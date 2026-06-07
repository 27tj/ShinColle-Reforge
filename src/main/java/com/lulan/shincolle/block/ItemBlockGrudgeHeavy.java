package com.lulan.shincolle.block;

import com.lulan.shincolle.item.IShipResourceItem;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.List;

/**
 * Custom BlockItem for GrudgeHeavy that displays stored materials in tooltip.
 * When the multi-block is broken, it stores material stock in "mats" NBT array.
 */
public class ItemBlockGrudgeHeavy extends BlockItem implements IShipResourceItem {

    public ItemBlockGrudgeHeavy(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        if (stack.hasTag()) {
            CompoundTag nbt = stack.getTag();
            assert nbt != null;
            if (nbt.contains("mats")) {
                int[] mats = nbt.getIntArray("mats");
                if (mats.length >= 4) {
                    tooltip.add(Component.literal(
                            ChatFormatting.WHITE + "" + mats[0] + " " + Component.translatable("item.shincolle.grudge").getString()));
                    tooltip.add(Component.literal(
                            ChatFormatting.RED + "" + mats[1] + " " + Component.translatable("item.shincolle.abyss_metal").getString()));
                    tooltip.add(Component.literal(
                            ChatFormatting.GREEN + "" + mats[2] + " " + Component.translatable("item.shincolle.ammo").getString()));
                    tooltip.add(Component.literal(
                            ChatFormatting.AQUA + "" + mats[3] + " " + Component.translatable("item.shincolle.abyss_metal_1").getString()));
                }
            }
        }
    }

    @Override
    public int[] getResourceValue(int meta) {
        // GrudgeHeavy provides 81 grudge (9x9 grudge items)
        return new int[]{81, 0, 0, 0};
    }
}
