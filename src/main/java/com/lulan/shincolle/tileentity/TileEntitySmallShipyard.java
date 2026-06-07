package com.lulan.shincolle.tileentity;

import com.lulan.shincolle.block.BlockSmallShipyard;
import com.lulan.shincolle.client.gui.inventory.ContainerSmallShipyard;
import com.lulan.shincolle.crafting.SmallRecipes;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.init.ModBlockEntities;
import com.lulan.shincolle.init.ModItems;
import com.lulan.shincolle.utility.LogHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;

/**
 * Block entity for the Small Shipyard block.
 * Handles ship/equipment building with fuel consumption and progress tracking.
 * <p>
 * Slot layout:
 * 0-3: Material inputs (Grudge, Abyssium, Ammo, Polymetal)
 * 4: Fuel input
 * 5: Build output
 */
public class TileEntitySmallShipyard extends BasicTileInventory implements MenuProvider, ITileFurnace {

    public static final int SLOT_COUNT = 6;
    public static final int SLOT_GRUDGE = 0;
    public static final int SLOT_ABYSSIUM = 1;
    public static final int SLOT_AMMO = 2;
    public static final int SLOT_POLYMETAL = 3;
    public static final int SLOT_FUEL = 4;
    public static final int SLOT_OUTPUT = 5;
    /**
     * Power added per Instant Construction Material
     */
    private static final int POWER_INSTANT = 57600;
    // Config values loaded from ConfigHandler
    private static int POWER_MAX;
    private static int BUILD_SPEED;
    private static float FUEL_MAGN;

    static {
        reloadConfig();
    }

    /**
     * Build type: 0=none, 1=ship, 2=equip, 3=ship_loop, 4=equip_loop
     */
    private int buildType = 0;
    /**
     * Power consumed in current build cycle
     */
    private int powerConsumed = 0;
    /**
     * Remaining fuel power in storage
     */
    private int powerRemained = 0;
    /**
     * Power goal for current build
     */
    private int powerGoal = 0;
    /**
     * Whether currently active (for blockstate sync)
     */
    private boolean isActive = false;
    /**
     * Sync timer for periodic updates
     */
    private int syncTime = 0;

    public TileEntitySmallShipyard(BlockPos pos, BlockState state) {
        this(ModBlockEntities.SMALL_SHIPYARD.get(), pos, state);
    }

    public TileEntitySmallShipyard(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state, SLOT_COUNT);
    }

    public static void reloadConfig() {
        double[] cfg = ConfigHandler.tileShipyardSmall;
        POWER_MAX = (int) cfg[0];
        BUILD_SPEED = (int) cfg[1];
        FUEL_MAGN = (float) cfg[2];
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, TileEntitySmallShipyard tile) {
        tile.tickServer();
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.shincolle.small_shipyard");
    }

    // ==================== ITileFurnace ====================

    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInv, Player player) {
        return new ContainerSmallShipyard(containerId, playerInv, this);
    }

    @Override
    public int getPowerConsumed() {
        return powerConsumed;
    }

    @Override
    public void setPowerConsumed(int value) {
        this.powerConsumed = value;
    }

    @Override
    public int getPowerGoal() {
        return powerGoal;
    }

    @Override
    public void setPowerGoal(int value) {
        this.powerGoal = value;
    }

    @Override
    public int getPowerRemained() {
        return powerRemained;
    }

    @Override
    public void setPowerRemained(int value) {
        this.powerRemained = value;
    }

    @Override
    public int getPowerMax() {
        return POWER_MAX;
    }

    @Override
    public void setPowerMax(int value) {
        // Max is config-defined, not settable
    }

    // ==================== Build Logic ====================

    @Override
    public float getFuelMagni() {
        return FUEL_MAGN;
    }

    public int getBuildType() {
        return buildType;
    }

    public void setBuildType(int type) {
        this.buildType = type;
        setChanged();
    }

    /**
     * Whether the shipyard has fuel and can build
     */
    public boolean isBuilding() {
        return hasRemainedPower() && canBuild();
    }

    /**
     * Whether there is enough fuel for at least one tick
     */
    public boolean hasRemainedPower() {
        return powerRemained >= BUILD_SPEED;
    }

    /**
     * Whether the build can proceed (has goal and output slot is empty)
     */
    public boolean canBuild() {
        if (buildType == 0)
            return false;

        // Check output slot is empty
        ItemStack output = inventory.getStackInSlot(SLOT_OUTPUT);
        if (!output.isEmpty())
            return false;

        // For non-loop builds, need materials and power goal
        if (buildType == 1 || buildType == 2) {
            return powerGoal > 0;
        }

        // For loop builds, continue even if powerGoal is temporarily 0 (will be
        // recalculated)
        return true;
    }

    /**
     * Calculate power goal from current material counts
     */
    private void calcPowerGoal() {
        int grudge = getSlotCount(SLOT_GRUDGE);
        int abyssium = getSlotCount(SLOT_ABYSSIUM);
        int ammo = getSlotCount(SLOT_AMMO);
        int polymetal = getSlotCount(SLOT_POLYMETAL);

        if (SmallRecipes.isValidInput(grudge, abyssium, ammo, polymetal)) {
            int totalMats = grudge + abyssium + ammo + polymetal;
            powerGoal = SmallRecipes.calculateFuelCost(totalMats);
        } else {
            powerGoal = 0;
        }
    }

    /**
     * Get item count in the specified material slot
     */
    private int getSlotCount(int slot) {
        ItemStack stack = inventory.getStackInSlot(slot);
        return stack.isEmpty() ? 0 : stack.getCount();
    }

    /**
     * Consume solid fuel from fuel slot, converting to power.
     * Accepts Grudge items (with fixed 2400 base burn value) and any vanilla
     * furnace fuel (coal, logs, lava buckets, blaze rods, etc.) via ForgeHooks.
     */
    private void decrItemFuel() {
        if (powerRemained >= POWER_MAX)
            return;

        ItemStack fuelStack = inventory.getStackInSlot(SLOT_FUEL);
        if (fuelStack.isEmpty())
            return;

        int fuelValue = 0;

        // Priority 1: Grudge items use a fixed base burn value
        if (fuelStack.is(ModItems.GRUDGE.get())) {
            fuelValue = (int) (2400 * FUEL_MAGN);
        } else {
            // Priority 2: Any vanilla/modded furnace fuel
            int burnTime = ForgeHooks.getBurnTime(fuelStack, null);
            if (burnTime > 0) {
                fuelValue = (int) (burnTime * FUEL_MAGN);
            }
        }

        if (fuelValue > 0 && powerRemained + fuelValue <= POWER_MAX) {
            // Handle container items (e.g., lava bucket -> empty bucket)
            ItemStack containerStack = fuelStack.getCraftingRemainingItem();
            if (!containerStack.isEmpty() && fuelStack.getCount() > 1) {
                // Cannot consume stacked items that leave a container
                return;
            }

            fuelStack.shrink(1);
            powerRemained += fuelValue;

            if (fuelStack.isEmpty()) {
                // Replace with container item if applicable (e.g., empty bucket)
                inventory.setStackInSlot(SLOT_FUEL, containerStack.isEmpty() ? ItemStack.EMPTY : containerStack.copy());
            }
            setChanged();
        }
    }

    /**
     * Handle build completion - generate output item
     */
    private void buildComplete() {
        int grudge = getSlotCount(SLOT_GRUDGE);
        int abyssium = getSlotCount(SLOT_ABYSSIUM);
        int ammo = getSlotCount(SLOT_AMMO);
        int polymetal = getSlotCount(SLOT_POLYMETAL);

        boolean buildShip = (buildType == 1 || buildType == 3);
        assert level != null;
        ItemStack result = SmallRecipes.calculateResult(grudge, abyssium, ammo, polymetal, buildShip, level.random);

        if (!result.isEmpty()) {
            // Place result in output slot
            inventory.setStackInSlot(SLOT_OUTPUT, result);

            // Consume materials
            inventory.setStackInSlot(SLOT_GRUDGE, ItemStack.EMPTY);
            inventory.setStackInSlot(SLOT_ABYSSIUM, ItemStack.EMPTY);
            inventory.setStackInSlot(SLOT_AMMO, ItemStack.EMPTY);
            inventory.setStackInSlot(SLOT_POLYMETAL, ItemStack.EMPTY);

            LogHelper.debug("SMALL SHIPYARD: build complete, result=" + result);
        }

        powerConsumed = 0;
        powerGoal = 0;

        // For non-loop builds, reset build type
        if (buildType == 1 || buildType == 2) {
            buildType = 0;
        }
        // Loop builds (3, 4) continue automatically
    }

    /**
     * Get remaining build time as formatted string
     */
    public String getBuildTimeString() {
        if (powerGoal <= 0 || BUILD_SPEED <= 0)
            return "0:00";
        int remainTicks = (powerGoal - powerConsumed) / BUILD_SPEED;
        int seconds = remainTicks / 20;
        return String.format("%d:%02d", seconds / 60, seconds % 60);
    }

    /**
     * Get fuel bar scale for GUI rendering
     */
    public int getPowerRemainingScaled(int pixels) {
        if (POWER_MAX <= 0)
            return 0;
        return powerRemained * pixels / POWER_MAX;
    }

    // ==================== Slot Validation ====================

    /**
     * Get build progress scale for GUI rendering
     */
    public int getBuildProgressScaled(int pixels) {
        if (powerGoal <= 0)
            return 0;
        return powerConsumed * pixels / powerGoal;
    }

    // ==================== Tick Logic ====================

    /**
     * Check if the given item is valid for the specified slot
     */
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        if (stack.isEmpty())
            return false;

        switch (slot) {
            case SLOT_GRUDGE:
                return stack.is(ModItems.GRUDGE.get());
            case SLOT_ABYSSIUM:
                return stack.is(ModItems.ABYSS_METAL.get());
            case SLOT_AMMO:
                return stack.is(ModItems.AMMO.get());
            case SLOT_POLYMETAL:
                return stack.is(ModItems.POLYMETAL_NODULE.get());
            case SLOT_FUEL:
                return stack.is(ModItems.GRUDGE.get()) || stack.is(ModItems.INSTANT_CON_MAT.get())
                        || ForgeHooks.getBurnTime(stack, null) > 0;
            case SLOT_OUTPUT:
                return false;
            default:
                return false;
        }
    }

    private void tickServer() {
        boolean sendUpdate = false;
        syncTime++;

        // Update power goal based on current materials
        if (buildType != 0) {
            calcPowerGoal();
        } else {
            powerGoal = 0;
        }

        // Consume fuel items
        decrItemFuel();

        // Process building
        if (isBuilding()) {
            // Check for Instant Construction Material in fuel slot
            ItemStack fuelStack = inventory.getStackInSlot(SLOT_FUEL);
            if (!fuelStack.isEmpty() && fuelStack.is(ModItems.INSTANT_CON_MAT.get())) {
                fuelStack.shrink(1);
                if (fuelStack.isEmpty()) {
                    inventory.setStackInSlot(SLOT_FUEL, ItemStack.EMPTY);
                }
                powerConsumed += POWER_INSTANT;
            }

            // Consume fuel and advance build
            if (powerRemained >= BUILD_SPEED) {
                powerRemained -= BUILD_SPEED;
                powerConsumed += BUILD_SPEED;
            }

            // Check for build completion
            if (powerGoal > 0 && powerConsumed >= powerGoal) {
                buildComplete();
                sendUpdate = true;
            }
        } else if (!canBuild()) {
            // Reset progress if build is no longer possible
            powerConsumed = 0;
        }

        // Detect state change for blockstate update
        boolean nowActive = isBuilding();
        if (isActive != nowActive) {
            isActive = nowActive;
            assert this.level != null;
            BlockSmallShipyard.updateBlockState(isActive, this.level, this.worldPosition);
            sendUpdate = true;
        }

        // Periodic or change-triggered sync
        if (sendUpdate || syncTime > 12000) {
            syncTime = 0;
            setChanged();
        }
    }

    // ==================== NBT ====================

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("BuildType", buildType);
        tag.putInt("PowerConsumed", powerConsumed);
        tag.putInt("PowerRemained", powerRemained);
        tag.putInt("PowerGoal", powerGoal);
        tag.putBoolean("Active", isActive);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        buildType = tag.getInt("BuildType");
        powerConsumed = tag.getInt("PowerConsumed");
        powerRemained = tag.getInt("PowerRemained");
        powerGoal = tag.getInt("PowerGoal");
        isActive = tag.getBoolean("Active");
    }

    // ==================== Client-Server Sync ====================

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        if (pkt.getTag() != null) {
            load(pkt.getTag());
        }
    }
}
