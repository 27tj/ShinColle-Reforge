package com.lulan.shincolle.item;

import com.lulan.shincolle.reference.Enums.EnumEquipEffectSP;
import com.lulan.shincolle.reference.ID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

/**
 * Equipment Compass - compass equipment with 1 variant.
 */
public class EquipCompass extends BasicEquip {

    public EquipCompass() {
        super(1);
    }

    @Override
    public EnumEquipEffectSP getSpecialEffect(ItemStack stack) {
        return EnumEquipEffectSP.COMPASS;
    }

    @Override
    public int getEquipTypeIDFromMeta(int meta) {
        return ID.EquipType.COMPASS_LO;
    }

    @Override
    public int[] getResourceValue(int meta) {
        if (this.getEquipTypeIDFromMeta(meta) == ID.EquipType.COMPASS_LO) { // 90
            return new int[]{
                    itemRand.nextInt(5) + 5,
                    itemRand.nextInt(3) + 4,
                    itemRand.nextInt(2) + 2,
                    itemRand.nextInt(2) + 2
            };
        }
        return new int[]{0, 0, 0, 0};
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("gui.shincolle.compass").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(stack, level, tooltip, flag);
    }
}
