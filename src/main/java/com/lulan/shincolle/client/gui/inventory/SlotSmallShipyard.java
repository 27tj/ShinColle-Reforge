package com.lulan.shincolle.client.gui.inventory;

import com.lulan.shincolle.tileentity.TileEntitySmallShipyard;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

/**
 * Custom slot for Small Shipyard GUI.
 * Output slot (isOutputSlot=true) does not accept item placement.
 * Material and fuel slots validate items through tile entity.
 */
public class SlotSmallShipyard extends SlotItemHandler {

    private final boolean isOutputSlot;
    private final TileEntitySmallShipyard tile;

    public SlotSmallShipyard(IItemHandler itemHandler, int index, int x, int y, boolean isOutputSlot,
                             TileEntitySmallShipyard tile) {
        super(itemHandler, index, x, y);
        this.isOutputSlot = isOutputSlot;
        this.tile = tile;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        if (isOutputSlot) return false;
        if (tile != null) {
            return tile.isItemValidForSlot(getSlotIndex(), stack);
        }
        return true;
    }

    public boolean isOutputSlot() {
        return isOutputSlot;
    }
}
