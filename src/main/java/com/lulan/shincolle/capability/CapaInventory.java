package com.lulan.shincolle.capability;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.tileentity.BasicTileInventory;

import net.minecraft.core.Direction;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.ItemStackHandler;

/**
 * Inventory capability for tile / entity / itemstack.
 * <p>
 * If host implements WorldlyContainer, slot insertion/extraction
 * will be checked via canPlaceItemThroughFace/canTakeItemThroughFace.
 */
public class CapaInventory<T> extends ItemStackHandler {

    public static final String InvName = "CpInv";

    // host type: -1:error 0:ship entity 1:tile 2:other entity 3:item 4:null host
    protected int hostType;
    protected T host;
    protected WorldlyContainer hostInv;

    public CapaInventory(int size, T host) {
        super(size);
        this.host = host;

        if (host instanceof WorldlyContainer wc)
            this.hostInv = wc;

        if (this.host instanceof BasicEntityShip) {
            hostType = 0;
        } else if (this.host instanceof BasicTileInventory) {
            hostType = 1;
        } else if (this.host instanceof Entity) {
            hostType = 2;
        } else if (this.host instanceof ItemStack) {
            hostType = 3;
        } else {
            hostType = 4;
        }
    }

    public T getHost() {
        return this.host;
    }

    /**
     * Get multiple slots at once. IN: start slot id, length
     */
    public ItemStack[] getStacksInSlots(int slotStart, int length) {
        validateSlotIndex(slotStart);

        if (slotStart + length > getSlots() || length < 0) {
            throw new RuntimeException("Slot length not in valid range - [0, " + getSlots() + ")");
        }

        ItemStack[] items = new ItemStack[length];
        int slotEnd = slotStart + length;

        for (int i = slotStart; i < slotEnd; i++) {
            items[i - slotStart] = stacks.get(i);
        }

        return items;
    }

    @Override
    protected void onContentsChanged(int slot) {
        switch (hostType) {
            case 0: // ship entity
                break;
            case 1: // tile
                ((BlockEntity) this.host).setChanged();
                break;
            case 2: // other entity
                break;
            case 3: // item
                break;
            default:
                break;
        }
    }

    @Override
    protected void onLoad() {
    }

    @Override
    public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
        if (this.hostInv != null) {
            if (this.hostInv.canPlaceItemThroughFace(slot, stack, Direction.UP)) {
                return super.insertItem(slot, stack, simulate);
            } else {
                return stack; // disable insertion
            }
        }

        return super.insertItem(slot, stack, simulate);
    }

    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        if (this.hostInv != null) {
            if (this.hostInv.canTakeItemThroughFace(slot, this.getStackInSlot(slot), Direction.UP)) {
                return super.extractItem(slot, amount, simulate);
            } else {
                return ItemStack.EMPTY; // disable extraction
            }
        }

        return super.extractItem(slot, amount, simulate);
    }
}
