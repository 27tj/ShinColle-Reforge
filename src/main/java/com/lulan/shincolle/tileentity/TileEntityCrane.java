package com.lulan.shincolle.tileentity;

import com.lulan.shincolle.client.gui.inventory.ContainerCrane;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

/**
 * Block entity for the Crane block.
 * Handles automated item loading/unloading between chest and ship entities.
 * <p>
 * Slot layout (18 slots):
 * 0-8: Loading filter slots
 * 9-17: Unloading filter slots
 * <p>
 * Crane modes determine wait behavior:
 * 0: No wait, 1: Until full, 2: Until empty, 3: Excess, 4: Remain
 * 5-24: Timed waits (16-60000 ticks)
 */
public class TileEntityCrane extends BasicTileInventory implements MenuProvider {

    public static final int SLOT_COUNT = 18;
    public static final String[] MODE_NAMES = {
            "No Wait", "Until Full", "Until Empty", "Excess", "Remain",
            "16 ticks", "32 ticks", "48 ticks", "64 ticks", "80 ticks",
            "5 sec", "10 sec", "15 sec", "20 sec", "25 sec",
            "1 min", "2 min", "3 min", "4 min", "5 min",
            "10 min", "20 min", "30 min", "40 min", "50 min"
    };
    /**
     * Tick counter
     */
    private int tick = 0;
    /**
     * Crane operating mode (wait condition)
     */
    private int craneMode = 0;
    /**
     * Whether currently active
     */
    private boolean isActive = false;
    /**
     * Whether paired with a chest
     */
    private boolean isPaired = false;
    /**
     * Enable loading (chest -> ship)
     */
    private boolean enabLoad = true;
    /**
     * Enable unloading (ship -> chest)
     */
    private boolean enabUnload = true;
    /**
     * Check item metadata when filtering
     */
    private boolean checkMetadata = false;
    /**
     * Check NBT data when filtering
     */
    private boolean checkNbt = false;
    /**
     * Check ore dictionary / item tags when filtering
     */
    private boolean checkDict = false;
    /**
     * Respond to redstone signal mode (0:none, 1:continuous, 2:pulse).
     */
    private int redSignalMode = 0;
    /**
     * Liquid transfer mode (0:none, 1:to ship, 2:to crane).
     */
    private int liquidMode = 0;
    /**
     * Energy transfer mode (0:none, 1:to ship, 2:to crane).
     */
    private int energyMode = 0;
    /**
     * Paired chest position
     */
    private BlockPos chestPos = BlockPos.ZERO;
    /**
     * Next waypoint position
     */
    private BlockPos nextPos = BlockPos.ZERO;
    /**
     * Last waypoint position
     */
    private BlockPos lastPos = BlockPos.ZERO;
    /**
     * Currently docked ship
     */
    private BasicEntityShip dockedShip = null;
    /**
     * Owner player UID
     */
    private int playerUID = 0;

    public TileEntityCrane(BlockPos pos, BlockState state) {
        this(ModBlockEntities.CRANE.get(), pos, state);
    }

    public TileEntityCrane(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state, SLOT_COUNT);
    }

    private static int normalizeTriStateMode(int mode) {
        // [PORT] 1.10.2 -> 1.20.1: Keep legacy crane tri-state semantics (0/1/2; >2
        // wraps to 0).
        if (mode < 0 || mode > 2) {
            return 0;
        }
        return mode;
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, TileEntityCrane tile) {
        tile.tickServer();
    }

    // ==================== Getters/Setters ====================

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.shincolle.crane");
    }

    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInv, Player player) {
        return new ContainerCrane(containerId, playerInv, this);
    }

    public int getCraneMode() {
        return craneMode;
    }

    public void setCraneMode(int mode) {
        this.craneMode = Math.max(0, Math.min(mode, MODE_NAMES.length - 1));
        setChanged();
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
        setChanged();
    }

    public boolean isPaired() {
        return isPaired;
    }

    public boolean isEnabLoad() {
        return enabLoad;
    }

    public void setEnabLoad(boolean v) {
        this.enabLoad = v;
        setChanged();
    }

    public boolean isEnabUnload() {
        return enabUnload;
    }

    public void setEnabUnload(boolean v) {
        this.enabUnload = v;
        setChanged();
    }

    public boolean isCheckMetadata() {
        return checkMetadata;
    }

    public void setCheckMetadata(boolean v) {
        this.checkMetadata = v;
        setChanged();
    }

    public boolean isCheckNbt() {
        return checkNbt;
    }

    public void setCheckNbt(boolean v) {
        this.checkNbt = v;
        setChanged();
    }

    public boolean isCheckDict() {
        return checkDict;
    }

    public void setCheckDict(boolean v) {
        this.checkDict = v;
        setChanged();
    }

    public boolean isRedSignal() {
        return redSignalMode > 0;
    }

    public void setRedSignal(boolean v) {
        setRedSignalMode(v ? 1 : 0);
    }

    public int getRedSignalMode() {
        return redSignalMode;
    }

    public void setRedSignalMode(int mode) {
        this.redSignalMode = normalizeTriStateMode(mode);
        setChanged();
    }

    public boolean isLiquidMode() {
        return liquidMode > 0;
    }

    public int getLiquidMode() {
        return liquidMode;
    }

    public void setLiquidMode(boolean v) {
        setLiquidMode(v ? 1 : 0);
    }

    public void setLiquidMode(int mode) {
        this.liquidMode = normalizeTriStateMode(mode);
        setChanged();
    }

    public boolean isEnergyMode() {
        return energyMode > 0;
    }

    public int getEnergyMode() {
        return energyMode;
    }

    public void setEnergyMode(boolean v) {
        setEnergyMode(v ? 1 : 0);
    }

    public void setEnergyMode(int mode) {
        this.energyMode = normalizeTriStateMode(mode);
        setChanged();
    }

    public BlockPos getChestPos() {
        return chestPos;
    }

    public void setChestPos(BlockPos pos) {
        this.chestPos = pos;
        this.isPaired = !pos.equals(BlockPos.ZERO);
        setChanged();
    }

    public BlockPos getNextPos() {
        return nextPos;
    }

    public void setNextPos(BlockPos pos) {
        this.nextPos = pos;
        setChanged();
    }

    public BlockPos getLastPos() {
        return lastPos;
    }

    public void setLastPos(BlockPos pos) {
        this.lastPos = pos;
        setChanged();
    }

    public int getPlayerUID() {
        return playerUID;
    }

    public void setPlayerUID(int uid) {
        this.playerUID = uid;
        setChanged();
    }

    public String getModeName() {
        if (craneMode >= 0 && craneMode < MODE_NAMES.length) {
            return MODE_NAMES[craneMode];
        }
        return "Unknown";
    }

    // ==================== Crane Logic ====================

    public BasicEntityShip getDockedShip() {
        return dockedShip;
    }

    /**
     * Check if paired chest still exists
     */
    private boolean checkPairedChest() {
        if (!isPaired || level == null)
            return false;
        BlockEntity be = level.getBlockEntity(chestPos);
        return be instanceof Container;
    }

    /**
     * Find ship at crane position
     */
    private void checkCraningShip() {
        if (level == null)
            return;

        AABB area = new AABB(worldPosition).inflate(3);
        List<BasicEntityShip> ships = level.getEntitiesOfClass(BasicEntityShip.class, area);

        dockedShip = null;
        for (BasicEntityShip ship : ships) {
            if (ship.isAlive()) {
                dockedShip = ship;
                break;
            }
        }
    }

    /**
     * Transfer items between chest and ship
     */
    private boolean applyItemTransfer(boolean loading) {
        if (dockedShip == null || level == null || !isPaired)
            return false;

        BlockEntity be = level.getBlockEntity(chestPos);
        if (!(be instanceof Container chest))
            return false;

        if (loading && enabLoad) {
            // Move from chest to ship
            return transferItems(chest, dockedShip);
        } else if (!loading && enabUnload) {
            // Move from ship to chest
            return transferItemsFromShip(dockedShip, chest);
        }
        return false;
    }

    /**
     * Transfer one item stack from chest container to ship
     */
    private boolean transferItems(Container source, BasicEntityShip target) {
        var shipInv = target.getCapaShipInventory();

        for (int i = 0; i < source.getContainerSize(); i++) {
            ItemStack stack = source.getItem(i);
            if (stack.isEmpty())
                continue;

            // Check loading filter
            if (!matchesFilter(stack, true))
                continue;

            // Try to add one item to ship inventory
            ItemStack toAdd = stack.copy();
            toAdd.setCount(1);
            if (shipInv.addItemStackToInventory(toAdd)) {
                source.removeItem(i, 1);
                source.setChanged();
                return true;
            }
        }
        return false;
    }

    /**
     * Transfer one item from ship to chest
     */
    private boolean transferItemsFromShip(BasicEntityShip source, Container target) {
        var shipInv = source.getCapaShipInventory();

        for (int i = 0; i < shipInv.getSlots(); i++) {
            ItemStack stack = shipInv.getStackInSlot(i);
            if (stack.isEmpty())
                continue;

            // Check unloading filter
            if (!matchesFilter(stack, false))
                continue;

            // Find a slot in the chest that can accept this item
            ItemStack toMove = stack.copy();
            toMove.setCount(1);

            // Try merging with existing stacks first
            for (int j = 0; j < target.getContainerSize(); j++) {
                ItemStack chestStack = target.getItem(j);
                if (!chestStack.isEmpty() && ItemStack.isSameItemSameTags(chestStack, toMove)
                        && chestStack.getCount() < chestStack.getMaxStackSize()) {
                    chestStack.grow(1);
                    target.setItem(j, chestStack);
                    stack.shrink(1);
                    if (stack.isEmpty()) {
                        shipInv.setStackInSlot(i, ItemStack.EMPTY);
                    }
                    target.setChanged();
                    return true;
                }
            }

            // Try empty slots
            for (int j = 0; j < target.getContainerSize(); j++) {
                if (target.getItem(j).isEmpty()) {
                    target.setItem(j, toMove);
                    stack.shrink(1);
                    if (stack.isEmpty()) {
                        shipInv.setStackInSlot(i, ItemStack.EMPTY);
                    }
                    target.setChanged();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if item matches the filter slots (loading: 0-8, unloading: 9-17)
     */
    private boolean matchesFilter(ItemStack stack, boolean loading) {
        int startSlot = loading ? 0 : 9;
        int endSlot = loading ? 9 : 18;

        boolean hasFilter = false;
        for (int i = startSlot; i < endSlot; i++) {
            ItemStack filterStack = inventory.getStackInSlot(i);
            if (!filterStack.isEmpty()) {
                hasFilter = true;
                if (ItemStack.isSameItem(stack, filterStack)) {
                    if (!checkMetadata || ItemStack.isSameItemSameTags(stack, filterStack)) {
                        return true;
                    }
                }
            }
        }

        // If no filter is set, allow all items
        return !hasFilter;
    }

    // ==================== Tick Logic ====================

    /**
     * Get wait time in ticks for timed modes
     */
    private int getWaitTime() {
        return switch (craneMode) {
            case 5 -> 16;
            case 6 -> 32;
            case 7 -> 48;
            case 8 -> 64;
            case 9 -> 80;
            case 10 -> 100;
            case 11 -> 200;
            case 12 -> 300;
            case 13 -> 400;
            case 14 -> 500;
            case 15 -> 1200;
            case 16 -> 2400;
            case 17 -> 3600;
            case 18 -> 4800;
            case 19 -> 6000;
            case 20 -> 12000;
            case 21 -> 24000;
            case 22 -> 36000;
            case 23 -> 48000;
            case 24 -> 60000;
            default -> 0;
        };
    }

    private void tickServer() {
        tick++;

        // Main work cycle: every 16 ticks
        if (isActive && isPaired && tick > 64 && (tick & 15) == 0) {
            // Validate chest
            if (!checkPairedChest()) {
                isPaired = false;
                setChanged();
                return;
            }

            // Find ship
            checkCraningShip();

            // Perform work
            if (dockedShip != null) {
                boolean didLoad = applyItemTransfer(true);
                boolean didUnload = applyItemTransfer(false);

                // Check crane ending condition
                if (craneMode >= 5) {
                    // Timed mode
                    int waitTime = getWaitTime();
                    if (tick > waitTime) {
                        // Release ship
                        dockedShip = null;
                        tick = 0;
                    }
                } else if (craneMode == 0) {
                    // No wait: stop when no work
                    if (!didLoad && !didUnload) {
                        dockedShip = null;
                    }
                }
            }
        }

        // Periodic sync
        if ((tick & 127) == 0) {
            setChanged();
        }
    }

    // ==================== NBT ====================

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("CraneMode", craneMode);
        tag.putBoolean("Active", isActive);
        tag.putBoolean("Paired", isPaired);
        tag.putBoolean("EnabLoad", enabLoad);
        tag.putBoolean("EnabUnload", enabUnload);
        tag.putBoolean("CheckMeta", checkMetadata);
        tag.putBoolean("CheckNbt", checkNbt);
        tag.putBoolean("CheckDict", checkDict);
        tag.putInt("RedSignal", redSignalMode);
        tag.putInt("LiquidMode", liquidMode);
        tag.putInt("EnergyMode", energyMode);
        tag.putInt("PlayerUID", playerUID);
        tag.putLong("ChestPos", chestPos.asLong());
        tag.putLong("NextPos", nextPos.asLong());
        tag.putLong("LastPos", lastPos.asLong());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        craneMode = tag.getInt("CraneMode");
        isActive = tag.getBoolean("Active");
        isPaired = tag.getBoolean("Paired");
        enabLoad = tag.getBoolean("EnabLoad");
        enabUnload = tag.getBoolean("EnabUnload");
        checkMetadata = tag.getBoolean("CheckMeta");
        checkNbt = tag.getBoolean("CheckNbt");
        checkDict = tag.getBoolean("CheckDict");
        if (tag.contains("RedSignal", Tag.TAG_INT)) {
            redSignalMode = normalizeTriStateMode(tag.getInt("RedSignal"));
        } else {
            redSignalMode = tag.getBoolean("RedSignal") ? 1 : 0;
        }
        if (tag.contains("LiquidMode", Tag.TAG_INT)) {
            liquidMode = normalizeTriStateMode(tag.getInt("LiquidMode"));
        } else {
            liquidMode = tag.getBoolean("LiquidMode") ? 1 : 0;
        }
        if (tag.contains("EnergyMode", Tag.TAG_INT)) {
            energyMode = normalizeTriStateMode(tag.getInt("EnergyMode"));
        } else {
            energyMode = tag.getBoolean("EnergyMode") ? 1 : 0;
        }
        playerUID = tag.getInt("PlayerUID");
        if (tag.contains("ChestPos"))
            chestPos = BlockPos.of(tag.getLong("ChestPos"));
        if (tag.contains("NextPos"))
            nextPos = BlockPos.of(tag.getLong("NextPos"));
        if (tag.contains("LastPos"))
            lastPos = BlockPos.of(tag.getLong("LastPos"));
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
