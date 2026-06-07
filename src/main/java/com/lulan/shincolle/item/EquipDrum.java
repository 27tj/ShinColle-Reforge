package com.lulan.shincolle.item;

import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.reference.Enums.EnumEquipEffectSP;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.utility.EnchantHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

/**
 * Equipment Drum - drum canister equipment with 3 variants.
 * meta:
 * 0: item drum
 * 1: fluid drum
 * 2: EU drum (battery)
 */
public class EquipDrum extends BasicEquip {

    public EquipDrum() {
        super(3);
    }

    @Override
    public int getEquipTypeIDFromMeta(int meta) {
        return ID.EquipType.DRUM_LO;
    }

    @Override
    public int getIconFromDamage(int meta) {
        return Math.min(meta, 2); // 0=item, 1=liquid, 2=EU
    }

    @Override
    public EnumEquipEffectSP getSpecialEffect(ItemStack stack) {
        int meta = getEquipMeta(stack);

        switch (meta) {
            case 1:
                return EnumEquipEffectSP.DRUM_LIQUID;
            case 2:
                return EnumEquipEffectSP.DRUM_EU;
            default:
                return EnumEquipEffectSP.DRUM;
        }
    }

    @Override
    public int[] getResourceValue(int meta) {
        if (this.getEquipTypeIDFromMeta(meta) == ID.EquipType.DRUM_LO) { // 120
            return new int[]{
                    itemRand.nextInt(4) + 5,
                    itemRand.nextInt(5) + 9,
                    itemRand.nextInt(4) + 4,
                    itemRand.nextInt(3) + 3
            };
        }
        return new int[]{0, 0, 0, 0};
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        int meta = getEquipMeta(stack);

        switch (meta) {
            case 1: {
                tooltip.add(Component.literal(ChatFormatting.GRAY + Component.translatable("gui.shincolle.drum1").getString()));
                int num = EnchantHelper.calcEnchantNumber(stack) * ConfigHandler.drumLiquid[1]
                        + ConfigHandler.drumLiquid[0];
                if (num > 0)
                    tooltip.add(Component.literal(
                            ChatFormatting.AQUA + Component.translatable("gui.shincolle.equip.rateliq").getString() + " " + num + " mB/t"));
                break;
            }
            case 2: {
                // EU transport is NYI (IC2 not available on 1.20.1)
                tooltip.add(Component.literal(ChatFormatting.GRAY + Component.translatable("gui.shincolle.drum2b").getString()));
                break;
            }
            default:
                tooltip.add(Component.literal(ChatFormatting.GRAY + Component.translatable("gui.shincolle.drum").getString()));
                break;
        }

        super.appendHoverText(stack, level, tooltip, flag);
    }
}
