package com.lulan.shincolle.client.gui.inventory;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

/**
 * Ghost slot for Crane GUI filter configuration.
 * Items cannot be placed or picked up through normal slot interaction.
 * Items are set via custom click handling in ContainerCrane.
 */
public class SlotCrane extends SlotItemHandler {

    public SlotCrane(IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return false;
    }

    @Override
    public boolean mayPickup(Player player) {
        return false;
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }
}
