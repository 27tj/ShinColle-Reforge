package com.lulan.shincolle.crafting;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.TransientCraftingContainer;

/**
 * Fake crafting container for task system.
 * Uses TransientCraftingContainer (CraftingContainer is an interface in
 * 1.20.1).
 */
public class InventoryCraftingFake extends TransientCraftingContainer {

    public InventoryCraftingFake(int width, int height) {
        super(new AbstractContainerMenu(null, -1) {
            @Override
            public net.minecraft.world.item.ItemStack quickMoveStack(net.minecraft.world.entity.player.Player player,
                                                                     int index) {
                return net.minecraft.world.item.ItemStack.EMPTY;
            }

            @Override
            public boolean stillValid(net.minecraft.world.entity.player.Player player) {
                return false;
            }
        }, width, height);
    }
}
