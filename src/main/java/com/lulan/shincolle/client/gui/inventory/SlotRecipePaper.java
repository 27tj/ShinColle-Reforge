package com.lulan.shincolle.client.gui.inventory;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/**
 * Ghost slot for Recipe Paper crafting pattern GUI.
 * Items cannot be placed or picked up through normal slot interaction.
 * Items are set via custom click handling in ContainerRecipePaper.
 */
public class SlotRecipePaper extends Slot {

    public SlotRecipePaper(Container container, int index, int x, int y) {
        super(container, index, x, y);
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
