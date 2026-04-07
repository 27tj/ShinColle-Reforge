package com.lulan.shincolle.item;

import com.lulan.shincolle.reference.ID;

import net.minecraft.world.item.ItemStack;

/**
 * Equipment Turbine - engine turbine equipment with 5 variants.
 * meta:
 * 0: Abyssal Boiler
 * 1: Improved Abyssal Turbine
 * 2: Enhanced Abyssal Boiler
 * 3: Abyssal Grudge Engine
 * 4: New Model Abyssal Grudge Engine
 */
public class EquipTurbine extends BasicEquip {

	public EquipTurbine() {
		super(5);
	}

	@Override
	public int getEquipTypeIDFromMeta(int meta) {
		switch (meta) {
			case 0:
			case 1:
				return ID.EquipType.TURBINE_LO;
			case 2:
			case 3:
			case 4:
				return ID.EquipType.TURBINE_HI;
			default:
				return 0;
		}
	}

	@Override
	public int getItemEnchantability(ItemStack stack) {
		switch (this.getEquipTypeIDFromMeta(getEquipMeta(stack))) {
			case ID.EquipType.TURBINE_LO:
				return 18;
			case ID.EquipType.TURBINE_HI:
				return 25;
			default:
				return 9;
		}
	}

	@Override
	public int[] getResourceValue(int meta) {
		switch (this.getEquipTypeIDFromMeta(meta)) {
			case ID.EquipType.TURBINE_LO: // 1400
				return new int[] {
						itemRand.nextInt(35) + 90,
						itemRand.nextInt(25) + 80,
						itemRand.nextInt(15) + 45,
						itemRand.nextInt(20) + 60
				};
			case ID.EquipType.TURBINE_HI: // 3200
				return new int[] {
						itemRand.nextInt(70) + 200,
						itemRand.nextInt(55) + 170,
						itemRand.nextInt(25) + 90,
						itemRand.nextInt(40) + 130
				};
			default:
				return new int[] { 0, 0, 0, 0 };
		}
	}
}
