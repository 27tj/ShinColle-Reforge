package com.lulan.shincolle.client.gui.inventory;

import com.lulan.shincolle.init.ModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

/**
 * Custom slot for Volcano Core GUI.
 * Validates items for fuel input.
 */
public class SlotVolCore extends SlotItemHandler {

    public SlotVolCore(IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
    }

    /**
     * Check if the item is a valid fuel for the Volcano Core.
     * Accepted fuels: Grudge, Grudge Block, Grudge Heavy, Coal, Charcoal, Lava
     * Bucket.
     */
    public static boolean isValidFuel(ItemStack stack) {
        if (stack.isEmpty())
            return false;

        // Mod-specific fuel items
        if (stack.is(ModItems.GRUDGE.get()))
            return true;
        if (stack.is(ModItems.GRUDGE_BLOCK_ITEM.get()))
            return true;
        if (stack.is(ModItems.GRUDGE_HEAVY_BLOCK_ITEM.get()))
            return true;

        // Vanilla fuel items
        if (stack.is(Items.COAL))
            return true;
        if (stack.is(Items.CHARCOAL))
            return true;
        return stack.is(Items.LAVA_BUCKET);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return isValidFuel(stack);
    }
}
