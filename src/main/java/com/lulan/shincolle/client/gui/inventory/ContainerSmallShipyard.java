package com.lulan.shincolle.client.gui.inventory;

import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.init.ModMenuTypes;
import com.lulan.shincolle.tileentity.TileEntitySmallShipyard;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

/**
 * Container/Menu for Small Shipyard block.
 * 4 material slots + 1 fuel slot + 1 output slot = 6 shipyard slots + player
 * inventory.
 * <p>
 * ContainerData layout (synced server->client as scaled values):
 * 0: fuelPercent (0-1000, representing 0%-100.0% fuel)
 * 1: buildPercent (0-1000, representing 0%-100.0% progress)
 * 2: buildType (0=none, 1=ship, 2=equip, 3=ship_loop, 4=equip_loop)
 * 3: buildTimeSeconds (remaining seconds)
 */
public class ContainerSmallShipyard extends AbstractContainerMenu {

    public static final int MATERIAL_SLOTS = 4;
    public static final int FUEL_SLOT = 4;
    public static final int OUTPUT_SLOT = 5;
    public static final int SHIPYARD_SLOT_COUNT = 6;

    public static final int DATA_FUEL_PERCENT = 0;
    public static final int DATA_BUILD_PERCENT = 1;
    public static final int DATA_BUILD_TYPE = 2;
    public static final int DATA_BUILD_TIME = 3;
    public static final int DATA_COUNT = 4;

    private final TileEntitySmallShipyard tile;
    private final ContainerData data;

    /**
     * Client-side constructor (from network) - uses SimpleContainerData for
     * receiving synced values
     */
    public ContainerSmallShipyard(int containerId, Inventory playerInv, FriendlyByteBuf buf) {
        this(containerId, playerInv, getTileFromBuf(playerInv.player, buf), new SimpleContainerData(DATA_COUNT));
    }

    /**
     * Server-side constructor - creates ContainerData that reads from tile entity
     */
    public ContainerSmallShipyard(int containerId, Inventory playerInv, TileEntitySmallShipyard tile) {
        this(containerId, playerInv, tile, createTileData(tile));
    }

    private ContainerSmallShipyard(int containerId, Inventory playerInv, TileEntitySmallShipyard tile,
                                   ContainerData data) {
        super(ModMenuTypes.SMALL_SHIPYARD.get(), containerId);
        this.tile = tile;
        this.data = data;

        IItemHandler handler = tile != null ? tile.getInventory() : new ItemStackHandler(SHIPYARD_SLOT_COUNT);

        // Material slots (0-3): horizontal row matching GUI texture
        addSlot(new SlotSmallShipyard(handler, 0, 33, 29, false, tile));  // Grudge
        addSlot(new SlotSmallShipyard(handler, 1, 53, 29, false, tile));  // Abyssium
        addSlot(new SlotSmallShipyard(handler, 2, 73, 29, false, tile));  // Ammo
        addSlot(new SlotSmallShipyard(handler, 3, 93, 29, false, tile));  // Polymetal

        // Fuel slot (4)
        addSlot(new SlotSmallShipyard(handler, FUEL_SLOT, 8, 53, false, tile));

        // Output slot (5): no item placement
        addSlot(new SlotSmallShipyard(handler, OUTPUT_SLOT, 134, 44, true, tile));

        // Player inventory
        addPlayerInventory(playerInv, 8, 87);

        addDataSlots(data);
    }

    private static ContainerData createTileData(TileEntitySmallShipyard tile) {
        if (tile == null)
            return new SimpleContainerData(DATA_COUNT);
        return new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case DATA_FUEL_PERCENT -> tile.getPowerMax() > 0
                            ? (int) ((long) tile.getPowerRemained() * 1000 / tile.getPowerMax())
                            : 0;
                    case DATA_BUILD_PERCENT -> tile.getPowerGoal() > 0
                            ? (int) ((long) tile.getPowerConsumed() * 1000 / tile.getPowerGoal())
                            : 0;
                    case DATA_BUILD_TYPE -> tile.getBuildType();
                    case DATA_BUILD_TIME -> {
                        int goal = tile.getPowerGoal();
                        int consumed = tile.getPowerConsumed();
                        if (goal <= 0)
                            yield 0;
                        int buildSpeed = (int) ConfigHandler.tileShipyardSmall[1];
                        if (buildSpeed <= 0)
                            yield 0;
                        yield Math.max(0, (goal - consumed) / buildSpeed / 20);
                    }
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
            }

            @Override
            public int getCount() {
                return DATA_COUNT;
            }
        };
    }

    private static TileEntitySmallShipyard getTileFromBuf(Player player, FriendlyByteBuf buf) {
        BlockPos pos = buf.readBlockPos();
        BlockEntity be = player.level().getBlockEntity(pos);
        return be instanceof TileEntitySmallShipyard t ? t : null;
    }

    protected void addPlayerInventory(Inventory inv, int x, int y) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                addSlot(new Slot(inv, 9 + row * 9 + col, x + col * 18, y + row * 18));
            }
        }
        for (int col = 0; col < 9; col++) {
            addSlot(new Slot(inv, col, x + col * 18, y + 58));
        }
    }

    @Override
    public boolean stillValid(Player player) {
        if (tile == null)
            return false;
        BlockPos pos = tile.getBlockPos();
        return player.distanceToSqr(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5) <= 64.0;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack result = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            result = slotStack.copy();

            if (index < SHIPYARD_SLOT_COUNT) {
                if (!this.moveItemStackTo(slotStack, SHIPYARD_SLOT_COUNT, SHIPYARD_SLOT_COUNT + 36, true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (!this.moveItemStackTo(slotStack, 0, OUTPUT_SLOT, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (slotStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return result;
    }

    public TileEntitySmallShipyard getTile() {
        return tile;
    }

    public int getFuelPercent() {
        return data.get(DATA_FUEL_PERCENT);
    }

    public int getBuildPercent() {
        return data.get(DATA_BUILD_PERCENT);
    }

    public int getBuildType() {
        return data.get(DATA_BUILD_TYPE);
    }

    public int getBuildTimeSeconds() {
        return data.get(DATA_BUILD_TIME);
    }
}
