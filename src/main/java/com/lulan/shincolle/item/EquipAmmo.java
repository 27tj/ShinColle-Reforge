package com.lulan.shincolle.item;

import com.lulan.shincolle.reference.ID;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Equipment Ammo - ammunition equipment with 9 variants.
 */
public class EquipAmmo extends BasicEquip implements IShipEffectItem {

    public static final String PLIST = "PList";
    public static final String PID = "PID";
    public static final String PLEVEL = "PLV";
    public static final String PTIME = "PTick";
    public static final String PCHANCE = "PChance";

    public EquipAmmo() {
        super(9);
    }

    @Override
    public int getEquipTypeIDFromMeta(int meta) {
        switch (meta) {
            case 0:
            case 2:
                return ID.EquipType.AMMO_LO;
            case 1:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            default:
                return ID.EquipType.AMMO_HI;
        }
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        switch (this.getEquipTypeIDFromMeta(getEquipMeta(stack))) {
            case ID.EquipType.AMMO_LO:
                return 12;
            case ID.EquipType.AMMO_HI:
                return 25;
            default:
                return 12;
        }
    }

    @Override
    public int[] getResourceValue(int meta) {
        switch (this.getEquipTypeIDFromMeta(meta)) {
            case ID.EquipType.AMMO_LO: // 120
                return new int[]{
                        itemRand.nextInt(3) + 4,
                        itemRand.nextInt(4) + 7,
                        itemRand.nextInt(5) + 9,
                        itemRand.nextInt(2) + 4
                };
            case ID.EquipType.AMMO_HI: // 1000
                return new int[]{
                        itemRand.nextInt(25) + 35,
                        itemRand.nextInt(30) + 45,
                        itemRand.nextInt(40) + 70,
                        itemRand.nextInt(20) + 40
                };
            default:
                return new int[]{0, 0, 0, 0};
        }
    }

    @Override
    public Map<Integer, int[]> getEffectOnAttack(int meta) {
        HashMap<Integer, int[]> emap = new HashMap<>();

        switch (meta) {
            case 0: // type 91
                emap.put(19, new int[]{0, 120, 50});
                break;
            case 1: // type 1
                emap.put(19, new int[]{1, 120, 70});
                break;
            case 3: // type 3
                emap.put(9, new int[]{0, 120, 50});
                break;
            case 4: // DU
                emap.put(20, new int[]{0, 100, 25});
                break;
            case 6: // anti-grav
                emap.put(25, new int[]{0, 100, 50});
                break;
        }

        return emap;
    }

    @Override
    public int getMissileType(int meta) {
        switch (meta) {
            case 5: // black hole
                return 5;
            case 8: // cluster bomb
                return 3;
            default:
                return 0;
        }
    }

    @Override
    public int getMissileMoveType(int meta) {
        if (meta == 8) { // cluster bomb
            return 1;
        }
        return -1;
    }

    @Override
    public int getMissileSpeedLevel(int meta) {
        return 0;
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);

        int meta = getEquipMeta(stack);

        switch (meta) {
            case 5: // gravity
                tooltip.add(Component.literal(ChatFormatting.YELLOW + Component.translatable("gui.shincolle.equip.gravity").getString()));
                break;
            case 7: // enchant shell
                if (stack.hasTag()) {
                    CompoundTag nbt = stack.getTag();
                    assert nbt != null;
                    ListTag nbtlist = nbt.getList(PLIST, Tag.TAG_COMPOUND);

                    for (int i = 0; i < nbtlist.size(); i++) {
                        CompoundTag nbtX = nbtlist.getCompound(i);
                        int pid = nbtX.getInt(PID);
                        MobEffect effect = MobEffect.byId(pid);

                        if (effect != null) {
                            String s1 = Component.translatable(effect.getDescriptionId()).getString().trim();
                            int plv = nbtX.getInt(PLEVEL) + 1;
                            int ptime = nbtX.getInt(PTIME) / 20;
                            int pchance = nbtX.getInt(PCHANCE);
                            tooltip.add(Component.translatable("gui.shincolle.equip.enchantshell",
                                    pchance, s1, plv, ptime));
                        }
                    }
                }
                break;
            case 8: // cluster
                tooltip.add(Component.literal(ChatFormatting.YELLOW + Component.translatable("gui.shincolle.equip.cluster").getString()));
                break;
        }

        // Show other effects from getEffectOnAttack
        Map<Integer, int[]> emap = getEffectOnAttack(meta);
        if (emap != null && !emap.isEmpty()) {
            emap.forEach((pid, pdata) -> {
                MobEffect effect = MobEffect.byId(pid);
                if (effect != null) {
                    String s1 = Component.translatable(effect.getDescriptionId()).getString().trim();
                    tooltip.add(Component.translatable("gui.shincolle.equip.enchantshell",
                            pdata[2], s1, pdata[0] + 1, pdata[1] / 20));
                }
            });
        }
    }
}
