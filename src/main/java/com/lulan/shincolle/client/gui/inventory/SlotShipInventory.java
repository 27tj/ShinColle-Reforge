package com.lulan.shincolle.client.gui.inventory;

import com.lulan.shincolle.item.BasicEquip;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/**
 * Custom slot for ship inventory GUI.
 * Equipment slots (0-5) only accept BasicEquip items and stack to 1.
 * Regular inventory slots accept any item.
 */
public class SlotShipInventory extends Slot {

    private final boolean isEquipSlot;

    public SlotShipInventory(Container container, int index, int x, int y, boolean isEquipSlot) {
        super(container, index, x, y);
        this.isEquipSlot = isEquipSlot;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        if (isEquipSlot) {
            return stack.getItem() instanceof BasicEquip;
        }
        return true;
    }

    @Override
    public int getMaxStackSize() {
        return isEquipSlot ? 1 : 64;
    }

    public boolean isEquipSlot() {
        return isEquipSlot;
    }
}
