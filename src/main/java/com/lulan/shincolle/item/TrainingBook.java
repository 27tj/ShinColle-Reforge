package com.lulan.shincolle.item;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

/**
 * Training Book - used to train ship entities.
 */
public class TrainingBook extends BasicItem {

	public TrainingBook() {
		super(new Properties().stacksTo(1));
	}

	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
		tooltip.add(Component.translatable("gui.shincolle.trainingbook").withStyle(ChatFormatting.GOLD));
	}
}
