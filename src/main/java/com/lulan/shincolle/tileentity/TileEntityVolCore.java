package com.lulan.shincolle.tileentity;

import com.lulan.shincolle.client.gui.inventory.ContainerVolCore;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.init.ModBlockEntities;
import com.lulan.shincolle.init.ModItems;
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
import net.minecraft.world.phys.AABB;

import java.util.List;

/**
 * Block entity for the Volcano Structure Core block.
 * Consumes fuel to provide AOE healing/buff effects to nearby ships.
 * <p>
 * Slot layout (9 slots): All fuel input slots
 */
public class TileEntityVolCore extends BasicTileInventory implements MenuProvider, ITileFurnace {

    public static final int SLOT_COUNT = 9;
    /**
     * AOE effect range (blocks)
     */
    private static final int EFFECT_RANGE = 16;
    // Config values loaded from ConfigHandler
    private static int POWER_MAX;
    private static int CONSUMED_SPEED;
    private static int FUEL_VALUE;

    static {
        reloadConfig();
    }

    /**
     * Whether the block is able to operate (has fuel)
     */
    private boolean canWork = false;
    /**
     * Whether the activation button is pressed
     */
    private boolean btnActive = false;
    /**
     * Remaining fuel power in storage
     */
    private int remainedPower = 0;
    /**
     * Sync timer
     */
    private int syncTime = 0;

    public TileEntityVolCore(BlockPos pos, BlockState state) {
        this(ModBlockEntities.VOL_CORE.get(), pos, state);
    }

    public TileEntityVolCore(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state, SLOT_COUNT);
    }

    public static void reloadConfig() {
        double[] cfg = ConfigHandler.tileVolCore;
        POWER_MAX = (int) cfg[0];
        CONSUMED_SPEED = (int) cfg[1];
        FUEL_VALUE = (int) cfg[2];
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, TileEntityVolCore tile) {
        tile.tickServer();
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.shincolle.vol_core");
    }

    // ==================== ITileFurnace ====================

    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInv, Player player) {
        return new ContainerVolCore(containerId, playerInv, this);
    }

    @Override
    public int getPowerConsumed() {
        return 0;
    }

    @Override
    public void setPowerConsumed(int v) {
    }

    @Override
    public int getPowerGoal() {
        return 0;
    }

    @Override
    public void setPowerGoal(int v) {
    }

    @Override
    public int getPowerRemained() {
        return remainedPower;
    }

    @Override
    public void setPowerRemained(int value) {
        this.remainedPower = value;
    }

    @Override
    public int getPowerMax() {
        return POWER_MAX;
    }

    @Override
    public void setPowerMax(int v) {
    }

    // ==================== State ====================

    @Override
    public float getFuelMagni() {
        return FUEL_VALUE;
    }

    public boolean isWorking() {
        return canWork && btnActive;
    }

    public boolean isBtnActive() {
        return btnActive;
    }

    public void setBtnActive(boolean active) {
        this.btnActive = active;
        setChanged();
    }

    // ==================== Fuel ====================

    /**
     * Get fuel bar scale for GUI rendering
     */
    public int getPowerRemainingScaled(int pixels) {
        if (POWER_MAX <= 0)
            return 0;
        return remainedPower * pixels / POWER_MAX;
    }

    // ==================== AOE Effects ====================

    /**
     * Consume fuel items from inventory, adding to power storage
     */
    private void decrItemFuel() {
        if (remainedPower >= POWER_MAX)
            return;

        for (int i = 0; i < SLOT_COUNT; i++) {
            ItemStack stack = inventory.getStackInSlot(i);
            if (!stack.isEmpty() && stack.is(ModItems.GRUDGE.get())) {
                if (remainedPower + FUEL_VALUE <= POWER_MAX) {
                    stack.shrink(1);
                    remainedPower += FUEL_VALUE;
                    if (stack.isEmpty()) {
                        inventory.setStackInSlot(i, ItemStack.EMPTY);
                    }
                    setChanged();
                }
                break;
            }
        }
    }

    // ==================== Tick Logic ====================

    /**
     * Apply healing effects to nearby ships
     */
    private void volcoreFunction() {
        if (level == null)
            return;

        AABB area = new AABB(worldPosition).inflate(EFFECT_RANGE);
        List<BasicEntityShip> ships = level.getEntitiesOfClass(BasicEntityShip.class, area);

        for (BasicEntityShip ship : ships) {
            float maxHP = ship.getMaxHealth();
            float curHP = ship.getHealth();
            if (curHP < maxHP) {
                ship.heal(maxHP * 0.01F);
            }
        }
    }

    private void tickServer() {
        boolean sendUpdate = false;
        syncTime++;

        if ((syncTime & 15) == 0) {
            boolean hadFuel = canWork;
            canWork = remainedPower >= CONSUMED_SPEED;

            if (hadFuel != canWork) {
                sendUpdate = true;
            }

            if (isWorking()) {
                remainedPower -= CONSUMED_SPEED;
            }

            if ((syncTime & 31) == 0) {
                decrItemFuel();

                if (isWorking()) {
                    volcoreFunction();
                }
            }
        }

        if (sendUpdate || syncTime > 12000) {
            syncTime = 0;
            setChanged();
        }
    }

    // ==================== NBT ====================

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putBoolean("CanWork", canWork);
        tag.putBoolean("BtnActive", btnActive);
        tag.putInt("RemainedPower", remainedPower);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        canWork = tag.getBoolean("CanWork");
        btnActive = tag.getBoolean("BtnActive");
        remainedPower = tag.getInt("RemainedPower");
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
