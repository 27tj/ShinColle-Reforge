package com.lulan.shincolle.item;

import com.lulan.shincolle.reference.ID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Map;

/**
 * Equipment Torpedo - torpedo equipment with 7 variants.
 * meta:
 * 0: 21inch Torpedo Mk.I
 * 1: 21inch Torpedo Mk.II
 * 2: 22inch Torpedo Mk.II
 * 3: Cuttlefish Torpedo
 * 4: High-Speed Torpedo
 * 5: High-speed Abyssal Torpedo Mod.2
 * 6: Abyssal Ambush Torpedo
 */
public class EquipTorpedo extends BasicEquip implements IShipEffectItem {

    public EquipTorpedo() {
        super(7);
    }

    @Override
    public int getEquipTypeIDFromMeta(int meta) {
        switch (meta) {
            case 0:
            case 1:
            case 2:
                return ID.EquipType.TORPEDO_LO;
            case 3:
            case 4:
            case 5:
            case 6:
                return ID.EquipType.TORPEDO_HI;
            default:
                return 0;
        }
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        switch (this.getEquipTypeIDFromMeta(getEquipMeta(stack))) {
            case ID.EquipType.TORPEDO_LO:
                return 16;
            case ID.EquipType.TORPEDO_HI:
                return 22;
            default:
                return 9;
        }
    }

    @Override
    public int[] getResourceValue(int meta) {
        switch (this.getEquipTypeIDFromMeta(meta)) {
            case ID.EquipType.TORPEDO_LO: // 160
                return new int[]{
                        itemRand.nextInt(4) + 8,
                        itemRand.nextInt(5) + 8,
                        itemRand.nextInt(6) + 12,
                        itemRand.nextInt(4) + 5
                };
            case ID.EquipType.TORPEDO_HI: // 1200
                return new int[]{
                        itemRand.nextInt(20) + 60,
                        itemRand.nextInt(25) + 70,
                        itemRand.nextInt(30) + 80,
                        itemRand.nextInt(15) + 45
                };
            default:
                return new int[]{0, 0, 0, 0};
        }
    }

    @Override
    public Map<Integer, int[]> getEffectOnAttack(int meta) {
        return null;
    }

    @Override
    public int getMissileType(int meta) {
        return -1;
    }

    @Override
    public int getMissileMoveType(int meta) {
        return -1;
    }

    @Override
    public int getMissileSpeedLevel(int meta) {
        switch (meta) {
            case 3:
            case 4:
                return 1;
            case 5:
                return 2;
            case 6:
                return 3;
            default:
                return 0;
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);

        int meta = getEquipMeta(stack);
        int speedLevel = getMissileSpeedLevel(meta);
        if (speedLevel != 0) {
            tooltip.add(Component.translatable("gui.shincolle.equip.torpedospeed", speedLevel)
                    .withStyle(ChatFormatting.YELLOW));
        }
    }
}
