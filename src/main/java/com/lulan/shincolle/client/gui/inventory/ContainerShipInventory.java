package com.lulan.shincolle.client.gui.inventory;

import com.lulan.shincolle.capability.CapaShipInventory;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.init.ModMenuTypes;
import com.lulan.shincolle.item.BasicEquip;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/**
 * Container/Menu for ship entity inventory.
 * 6 equipment slots (BasicEquip only) + 18 inventory slots per page (visible).
 * Supports 3 inventory pages via paging offset in the wrapper.
 */
public class ContainerShipInventory extends AbstractContainerMenu {

    /** Number of equipment slots */
    public static final int EQUIP_SLOTS = 6;
    /** Number of inventory slots per page */
    public static final int INV_SLOTS_PER_PAGE = 18;
    /** Number of inventory pages */
    public static final int INV_PAGES = 3;
    /** Total ship slots matches CapaShipInventory.SlotMax */
    public static final int TOTAL_SHIP_SLOTS = CapaShipInventory.SlotMax;
    /** Number of visible ship slots (equip + one page) */
    public static final int VISIBLE_SHIP_SLOTS = EQUIP_SLOTS + INV_SLOTS_PER_PAGE;

    private final BasicEntityShip ship;
    private final PagedShipContainerWrapper shipInv;

    /** Client-side constructor (from network) */
    public ContainerShipInventory(int containerId, Inventory playerInv, FriendlyByteBuf buf) {
        this(containerId, playerInv, getShipFromBuf(playerInv.player, buf));
    }

    /** Server-side constructor */
    public ContainerShipInventory(int containerId, Inventory playerInv, BasicEntityShip ship) {
        super(ModMenuTypes.SHIP_INVENTORY.get(), containerId);
        this.ship = ship;
        this.shipInv = (ship != null)
                ? new PagedShipContainerWrapper(ship.getCapaShipInventory())
                : new PagedShipContainerWrapper(new CapaShipInventory(TOTAL_SHIP_SLOTS, null));

        // Equipment slots (0-5): right column
        for (int i = 0; i < EQUIP_SLOTS; i++) {
            addSlot(new SlotShipInventory(shipInv, i, 144, 18 + i * 18, true));
        }

        // Inventory slots page 0 (6-23): 6 rows x 3 columns (matching original layout)
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 3; col++) {
                addSlot(new SlotShipInventory(shipInv, EQUIP_SLOTS + col + row * 3,
                        8 + col * 18, 18 + row * 18, false));
            }
        }

        // Player inventory (matching original: y=132, hotbar y=190)
        addPlayerInventory(playerInv, 8, 132);
    }

    private static BasicEntityShip getShipFromBuf(Player player, FriendlyByteBuf buf) {
        int entityId = buf.readInt();
        Entity e = player.level().getEntity(entityId);
        return e instanceof BasicEntityShip s ? s : null;
    }

    protected void addPlayerInventory(Inventory inv, int x, int y) {
        // Main inventory (3 rows of 9)
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                addSlot(new Slot(inv, 9 + row * 9 + col, x + col * 18, y + row * 18));
            }
        }
        // Hotbar (1 row of 9, 58px below main inventory top = y+58)
        for (int col = 0; col < 9; col++) {
            addSlot(new Slot(inv, col, x + col * 18, y + 58));
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return ship != null && ship.isAlive() && player.distanceToSqr(ship) < 64.0;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack result = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            result = slotStack.copy();

            if (index < EQUIP_SLOTS) {
                // From equip slots to player inventory
                if (!this.moveItemStackTo(slotStack, VISIBLE_SHIP_SLOTS, VISIBLE_SHIP_SLOTS + 36, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (index < VISIBLE_SHIP_SLOTS) {
                // From ship inventory slots
                if (slotStack.getItem() instanceof BasicEquip) {
                    // equip items: try equip slots first, then player
                    if (!this.moveItemStackTo(slotStack, 0, EQUIP_SLOTS, false)) {
                        if (!this.moveItemStackTo(slotStack, VISIBLE_SHIP_SLOTS, VISIBLE_SHIP_SLOTS + 36, true)) {
                            return ItemStack.EMPTY;
                        }
                    }
                } else {
                    // non-equip: player only
                    if (!this.moveItemStackTo(slotStack, VISIBLE_SHIP_SLOTS, VISIBLE_SHIP_SLOTS + 36, true)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else {
                // From player inventory to ship
                if (slotStack.getItem() instanceof BasicEquip) {
                    // equip items: try equip slots first, then ship inventory
                    if (!this.moveItemStackTo(slotStack, 0, EQUIP_SLOTS, false)) {
                        if (!this.moveItemStackTo(slotStack, EQUIP_SLOTS, VISIBLE_SHIP_SLOTS, false)) {
                            return ItemStack.EMPTY;
                        }
                    }
                } else {
                    // non-equip: ship inventory only
                    if (!this.moveItemStackTo(slotStack, EQUIP_SLOTS, VISIBLE_SHIP_SLOTS, false)) {
                        return ItemStack.EMPTY;
                    }
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

    /** Set the inventory page and force resync all slots */
    public void setInventoryPage(int page) {
        if (page < 0 || page >= INV_PAGES) return;
        this.shipInv.setPage(page);
        // force resync all inventory slots
        this.broadcastFullState();
    }

    public int getInventoryPage() {
        return this.shipInv.getPage();
    }

    public BasicEntityShip getShip() {
        return ship;
    }

    public Container getShipInv() {
        return shipInv;
    }

    // ========== Inner class: paged wrapper around CapaShipInventory ==========

    /**
     * Wraps a CapaShipInventory as a Container with inventory page support.
     * Equip slots (0-5) map directly. Inventory slots (6-23) are offset by page * 18.
     */
    static class PagedShipContainerWrapper implements Container {
        private final CapaShipInventory inv;
        private int page = 0;

        PagedShipContainerWrapper(CapaShipInventory inv) {
            this.inv = inv;
        }

        public int getPage() { return page; }
        public void setPage(int page) { this.page = page; }

        /** Map container slot index to actual CapaShipInventory slot index */
        private int mapSlot(int slot) {
            if (slot < CapaShipInventory.EquipSlots) {
                return slot; // equip slots: direct
            }
            // inventory slots: offset by page
            return slot + page * INV_SLOTS_PER_PAGE;
        }

        @Override
        public int getContainerSize() {
            return VISIBLE_SHIP_SLOTS;
        }

        @Override
        public boolean isEmpty() {
            for (int i = 0; i < getContainerSize(); i++) {
                if (!getItem(i).isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public ItemStack getItem(int slot) {
            return inv.getStackInSlot(mapSlot(slot));
        }

        @Override
        public ItemStack removeItem(int slot, int amount) {
            int mapped = mapSlot(slot);
            ItemStack stack = inv.getStackInSlot(mapped);
            if (stack.isEmpty()) {
                return ItemStack.EMPTY;
            }
            if (amount >= stack.getCount()) {
                ItemStack result = stack.copy();
                inv.setStackInSlot(mapped, ItemStack.EMPTY);
                return result;
            } else {
                ItemStack result = stack.split(amount);
                return result;
            }
        }

        @Override
        public ItemStack removeItemNoUpdate(int slot) {
            int mapped = mapSlot(slot);
            ItemStack stack = inv.getStackInSlot(mapped);
            if (stack.isEmpty()) {
                return ItemStack.EMPTY;
            }
            inv.setStackInSlot(mapped, ItemStack.EMPTY);
            return stack;
        }

        @Override
        public void setItem(int slot, ItemStack stack) {
            inv.setStackInSlot(mapSlot(slot), stack);
        }

        @Override
        public void setChanged() {
            // CapaShipInventory is saved via entity NBT
        }

        @Override
        public boolean stillValid(Player player) {
            return true;
        }

        @Override
        public void clearContent() {
            for (int i = 0; i < inv.getSlots(); i++) {
                inv.setStackInSlot(i, ItemStack.EMPTY);
            }
        }
    }
}
