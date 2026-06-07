package com.lulan.shincolle.item;

import com.lulan.shincolle.reference.ID;

import net.minecraft.world.item.ItemStack;

/**
 * Equipment Airplane - aircraft equipment with 22 variants.
 * meta:
 * 0: Torpedo Bomber Mk.I
 * 1: Torpedo Bomber Mk.II
 * 2: Torpedo Bomber Mk.III
 * 3: Avenger Torpedo Bomber
 * 4: Fighter Mk.I
 * 5: Fighter Mk.II
 * 6: Fighter Mk.III
 * 7: Flying-Fish Fighter
 * 8: Hellcat Fighter
 * 9: Dive Bomber Mk.I
 * 10: Dive Bomber Mk.II
 * 11: Flying-Fish Dive Bomber
 * 12: Hell Diver
 * 13: Recon Plane
 * 14: Flying-Fish Recon Plane
 * 15: Avenger Torpedo Bomber Kai
 * 16: Hellcat Fighter Kai
 * 17: Hell Diver Kai
 * 18: Abyssal Cat Fighter (Bombing)
 * 19: Abyssal Liberation Land-based Dive Bomber
 * 20: Abyssal Liberation Land-based Dive Bomber Ace
 * 21: Abyssal Bearcat Fighter
 */
public class EquipAirplane extends BasicEquip {

    public EquipAirplane() {
        super(22);
    }

    @Override
    public int getEquipTypeIDFromMeta(int meta) {
        return switch (meta) {
            case 0, 1, 2 -> ID.EquipType.AIR_T_LO;
            case 3, 15 -> ID.EquipType.AIR_T_HI;
            case 4, 5, 6 -> ID.EquipType.AIR_F_LO;
            case 7, 8, 16, 18, 21 -> ID.EquipType.AIR_F_HI;
            case 9, 10 -> ID.EquipType.AIR_B_LO;
            case 11, 12, 17, 19, 20 -> ID.EquipType.AIR_B_HI;
            case 13 -> ID.EquipType.AIR_R_LO;
            case 14 -> ID.EquipType.AIR_R_HI;
            default -> 0;
        };
    }

    @Override
    public int getIconFromDamage(int meta) {
        return switch (this.getEquipTypeIDFromMeta(meta)) {
            case ID.EquipType.AIR_T_LO, ID.EquipType.AIR_T_HI -> 0; // torpedo bomber
            case ID.EquipType.AIR_F_LO, ID.EquipType.AIR_F_HI -> 1; // fighter
            case ID.EquipType.AIR_B_LO, ID.EquipType.AIR_B_HI -> 2; // bomber
            case ID.EquipType.AIR_R_LO, ID.EquipType.AIR_R_HI -> 3; // recon
            default -> 0;
        };
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        return switch (this.getEquipTypeIDFromMeta(getEquipMeta(stack))) {
            case ID.EquipType.AIR_T_LO, ID.EquipType.AIR_F_LO, ID.EquipType.AIR_B_LO, ID.EquipType.AIR_R_LO -> 18;
            case ID.EquipType.AIR_T_HI, ID.EquipType.AIR_F_HI, ID.EquipType.AIR_B_HI, ID.EquipType.AIR_R_HI -> 25;
            default -> 9;
        };
    }

    @Override
    public int[] getResourceValue(int meta) {
        return switch (this.getEquipTypeIDFromMeta(meta)) {
            case ID.EquipType.AIR_T_LO, ID.EquipType.AIR_F_LO, ID.EquipType.AIR_B_LO -> // 2400
                    new int[]{
                            itemRand.nextInt(20) + 80,
                            itemRand.nextInt(30) + 100,
                            itemRand.nextInt(40) + 120,
                            itemRand.nextInt(50) + 150
                    };
            case ID.EquipType.AIR_T_HI, ID.EquipType.AIR_F_HI, ID.EquipType.AIR_B_HI -> // 3800
                    new int[]{
                            itemRand.nextInt(50) + 130,
                            itemRand.nextInt(60) + 170,
                            itemRand.nextInt(70) + 210,
                            itemRand.nextInt(75) + 230
                    };
            case ID.EquipType.AIR_R_LO -> // 256
                    new int[]{
                            itemRand.nextInt(12) + 3,
                            itemRand.nextInt(14) + 5,
                            itemRand.nextInt(14) + 5,
                            itemRand.nextInt(16) + 11
                    };
            case ID.EquipType.AIR_R_HI -> // 1000
                    new int[]{
                            itemRand.nextInt(10) + 40,
                            itemRand.nextInt(15) + 50,
                            itemRand.nextInt(20) + 60,
                            itemRand.nextInt(25) + 80
                    };
            default -> new int[]{0, 0, 0, 0};
        };
    }
}
