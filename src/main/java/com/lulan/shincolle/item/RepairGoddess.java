package com.lulan.shincolle.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

/**
 * Repair Goddess - prevents sinking, has enchanted glow effect.
 */
public class RepairGoddess extends BasicItem {

    public RepairGoddess() {
        super(new Properties().stacksTo(16));
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("gui.shincolle.repairgoddess").withStyle(ChatFormatting.RED));
    }
}
