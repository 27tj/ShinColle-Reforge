package com.lulan.shincolle.item;

import net.minecraft.world.item.ItemStack;

/**
 * Kaitai Hammer - used to dismantle ship entities for resources.
 * Has durability (20 uses), and can be used in crafting recipes
 * without being consumed (loses 1 durability per craft).
 */
public class KaitaiHammer extends BasicItem {

    public KaitaiHammer() {
        super(new Properties().stacksTo(1).durability(20));
    }

    /**
     * This hammer can be used in crafting recipes as a tool.
     * It is not consumed but loses durability.
     */
    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    /**
     * Return a copy of this hammer with +1 damage when used in crafting.
     * If the hammer would break, return empty.
     */
    @Override
    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        ItemStack result = stack.copy();
        result.setDamageValue(stack.getDamageValue() + 1);

        if (result.getDamageValue() >= result.getMaxDamage()) {
            return ItemStack.EMPTY;
        }

        result.setCount(1);
        return result;
    }
}
