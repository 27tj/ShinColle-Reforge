package com.lulan.shincolle.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

/**
 * OP Tool - operator/debug tool with enchanted glow effect.
 */
public class OPTool extends BasicItem {

    public OPTool() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("gui.shincolle.optool1").withStyle(ChatFormatting.RED));
        tooltip.add(Component.translatable("gui.shincolle.optool2").withStyle(ChatFormatting.AQUA));
    }
}
