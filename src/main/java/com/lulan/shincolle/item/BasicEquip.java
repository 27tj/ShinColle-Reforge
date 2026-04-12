package com.lulan.shincolle.item;

import java.util.List;
import java.util.Random;

import com.lulan.shincolle.crafting.EquipCalc;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.reference.Enums.EnumEquipEffectSP;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.Values;
import com.lulan.shincolle.utility.ClientRuntimeHelper;
import com.lulan.shincolle.utility.EnchantHelper;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

/**
 * Base class for ship equipment items.
 * Equipment items have max stack size of 1 and use NBT for variant data.
 * In 1.10.2, variants were stored as item damage/meta values.
 * In 1.20.1, we store the variant in NBT tag "EquipMeta".
 */
public abstract class BasicEquip extends BasicItem implements IShipResourceItem {

	public static final String TAG_EQUIP_META = "EquipMeta";

	protected static final Random itemRand = new Random();

	private final int numVariants;

	public BasicEquip(int numVariants) {
		super(new Properties().stacksTo(1));
		this.numVariants = numVariants;
	}

	/** Get the number of equipment variants */
	public int getNumVariants() {
		return numVariants;
	}

	/** Get the equipment type ID for a given variant meta */
	public abstract int getEquipTypeIDFromMeta(int meta);

	/** Calculate the unique equipment ID (EquipTypeID + meta * 100) */
	public int getEquipID(int meta) {
		return getEquipTypeIDFromMeta(meta) + meta * 100;
	}

	/** Equip special effect */
	public EnumEquipEffectSP getSpecialEffect(ItemStack stack) {
		return EnumEquipEffectSP.NONE;
	}

	/**
	 * Get the texture icon index for a given meta value.
	 * Used by ItemProperties to select model overrides.
	 * Subclasses override to map meta ranges to icon indices.
	 */
	public int getIconFromDamage(int meta) {
		return 0;
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return false;
	}

	@Override
	public int getEnchantmentValue() {
		return 9;
	}

	/** Per-stack enchantability, subclasses override for type-specific values */
	public int getItemEnchantability(ItemStack stack) {
		return 9;
	}

	@Override
	public int[] getResourceValue(int meta) {
		return new int[] { 0, 0, 0, 0 };
	}

	// ==================== NBT Variant System ====================

	/** Get the equipment meta/variant from an ItemStack's NBT */
	public static int getEquipMeta(ItemStack stack) {
		CompoundTag tag = stack.getTag();
		if (tag != null && tag.contains(TAG_EQUIP_META)) {
			return tag.getInt(TAG_EQUIP_META);
		}
		return 0;
	}

	/** Set the equipment meta/variant on an ItemStack's NBT */
	public static void setEquipMeta(ItemStack stack, int meta) {
		stack.getOrCreateTag().putInt(TAG_EQUIP_META, meta);
	}

	/** Create an ItemStack with the specified variant meta */
	public ItemStack createStack(int meta) {
		ItemStack stack = new ItemStack(this);
		setEquipMeta(stack, meta);
		return stack;
	}

	/**
	 * Override description ID to provide variant-specific translation keys.
	 * meta 0 -> "item.shincolle.equip_cannon" (base key, no suffix)
	 * meta N -> "item.shincolle.equip_cannon_N"
	 */
	@Override
	public String getDescriptionId(ItemStack stack) {
		int meta = getEquipMeta(stack);
		if (meta > 0) {
			return super.getDescriptionId() + "_" + meta;
		}
		return super.getDescriptionId();
	}

	@Override
	public Component getName(ItemStack stack) {
		return Component.translatable(this.getDescriptionId(stack));
	}

	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
		// Toggle enchantment visibility with Ctrl key
		if (stack.hasTag()) {
			CompoundTag nbt = stack.getTag();
			if (nbt != null) {
				int hideFlag = ClientRuntimeHelper.isControlDown() ? 0 : 1;
				nbt.putInt("HideFlags", hideFlag);
			}
		}

		int meta = getEquipMeta(stack);
		int equipID = getEquipID(meta);

		float[] main = Values.EquipAttrsMain.get(equipID);
		int[] misc = Values.EquipAttrsMisc.get(equipID);

		if (main != null && misc != null) {
			// Apply enchant effect
			main = EquipCalc.calcEquipStatWithEnchant(misc[ID.EquipMisc.EQUIP_TYPE], main,
					EnchantHelper.calcEnchantEffect(stack));

			// Draw stat values
			if (main[ID.Attrs.HP] != 0F)
				tooltip.add(Component.literal(ChatFormatting.RED + String.format("%.1f",
						main[ID.Attrs.HP] * (float) ConfigHandler.scaleShip[ID.AttrsBase.HP]) + " " +
						Component.translatable("gui.shincolle.hp").getString()));
			if (main[ID.Attrs.ATK_L] != 0F)
				tooltip.add(Component.literal(ChatFormatting.RED + String.format("%.1f",
						main[ID.Attrs.ATK_L] * (float) ConfigHandler.scaleShip[ID.AttrsBase.ATK]) + " " +
						Component.translatable("gui.shincolle.firepower1").getString()));
			if (main[ID.Attrs.ATK_H] != 0F)
				tooltip.add(Component.literal(ChatFormatting.GREEN + String.format("%.1f",
						main[ID.Attrs.ATK_H] * (float) ConfigHandler.scaleShip[ID.AttrsBase.ATK]) + " " +
						Component.translatable("gui.shincolle.torpedo").getString()));
			if (main[ID.Attrs.ATK_AL] != 0F)
				tooltip.add(Component.literal(ChatFormatting.RED + String.format("%.1f",
						main[ID.Attrs.ATK_AL] * (float) ConfigHandler.scaleShip[ID.AttrsBase.ATK]) + " " +
						Component.translatable("gui.shincolle.airfirepower").getString()));
			if (main[ID.Attrs.ATK_AH] != 0F)
				tooltip.add(Component.literal(ChatFormatting.GREEN + String.format("%.1f",
						main[ID.Attrs.ATK_AH] * (float) ConfigHandler.scaleShip[ID.AttrsBase.ATK]) + " " +
						Component.translatable("gui.shincolle.airtorpedo").getString()));
			if (main[ID.Attrs.DEF] != 0F)
				tooltip.add(Component.literal(ChatFormatting.WHITE + String.format("%.1f",
						main[ID.Attrs.DEF] * 100F * (float) ConfigHandler.scaleShip[ID.AttrsBase.DEF]) + "% " +
						Component.translatable("gui.shincolle.armor").getString()));
			if (main[ID.Attrs.SPD] != 0F)
				tooltip.add(Component.literal(ChatFormatting.WHITE + String.format("%.2f",
						main[ID.Attrs.SPD] * (float) ConfigHandler.scaleShip[ID.AttrsBase.SPD]) + " " +
						Component.translatable("gui.shincolle.attackspeed").getString()));
			if (main[ID.Attrs.MOV] != 0F)
				tooltip.add(Component.literal(ChatFormatting.GRAY + String.format("%.2f",
						main[ID.Attrs.MOV] * (float) ConfigHandler.scaleShip[ID.AttrsBase.MOV]) + " " +
						Component.translatable("gui.shincolle.movespeed").getString()));
			if (main[ID.Attrs.HIT] != 0F)
				tooltip.add(Component.literal(ChatFormatting.LIGHT_PURPLE + String.format("%.1f",
						main[ID.Attrs.HIT] * (float) ConfigHandler.scaleShip[ID.AttrsBase.HIT]) + " " +
						Component.translatable("gui.shincolle.range").getString()));
			if (main[ID.Attrs.CRI] != 0F)
				tooltip.add(Component.literal(ChatFormatting.AQUA + String.format("%.0f",
						main[ID.Attrs.CRI] * 100F) + "% " +
						Component.translatable("gui.shincolle.critical").getString()));
			if (main[ID.Attrs.DHIT] != 0F)
				tooltip.add(Component.literal(ChatFormatting.YELLOW + String.format("%.0f",
						main[ID.Attrs.DHIT] * 100F) + "% " +
						Component.translatable("gui.shincolle.doublehit").getString()));
			if (main[ID.Attrs.THIT] != 0F)
				tooltip.add(Component.literal(ChatFormatting.GOLD + String.format("%.0f",
						main[ID.Attrs.THIT] * 100F) + "% " +
						Component.translatable("gui.shincolle.triplehit").getString()));
			if (main[ID.Attrs.MISS] != 0F)
				tooltip.add(Component.literal(ChatFormatting.RED + String.format("%.0f",
						main[ID.Attrs.MISS] * 100F) + "% " +
						Component.translatable("gui.shincolle.missreduce").getString()));
			if (main[ID.Attrs.DODGE] != 0F)
				tooltip.add(Component.literal(ChatFormatting.GOLD + String.format("%.0f",
						main[ID.Attrs.DODGE] * 100F) + "% " +
						Component.translatable("gui.shincolle.dodge").getString()));
			if (main[ID.Attrs.AA] != 0F)
				tooltip.add(Component.literal(ChatFormatting.YELLOW + String.format("%.1f",
						main[ID.Attrs.AA]) + " " +
						Component.translatable("gui.shincolle.antiair").getString()));
			if (main[ID.Attrs.ASM] != 0F)
				tooltip.add(Component.literal(ChatFormatting.AQUA + String.format("%.1f",
						main[ID.Attrs.ASM]) + " " +
						Component.translatable("gui.shincolle.antiss").getString()));
			if (main[ID.Attrs.XP] != 0F)
				tooltip.add(Component.literal(
						ChatFormatting.GREEN + Component.translatable("gui.shincolle.equip.xp").getString() + " " +
								String.format("%.0f", main[ID.Attrs.XP] * 100F) + "%"));
			if (main[ID.Attrs.GRUDGE] != 0F)
				tooltip.add(
						Component.literal(ChatFormatting.DARK_PURPLE
								+ Component.translatable("gui.shincolle.equip.grudge").getString() + " " +
								String.format("%.0f", main[ID.Attrs.GRUDGE] * 100F) + "%"));
			if (main[ID.Attrs.AMMO] != 0F)
				tooltip.add(Component.literal(ChatFormatting.DARK_AQUA
						+ Component.translatable("gui.shincolle.equip.ammo").getString() + " " +
						String.format("%.0f", main[ID.Attrs.AMMO] * 100F) + "%"));
			if (main[ID.Attrs.HPRES] != 0F)
				tooltip.add(Component.literal(ChatFormatting.DARK_GREEN
						+ Component.translatable("gui.shincolle.equip.hpres").getString() + " " +
						String.format("%.0f", main[ID.Attrs.HPRES] * 100F) + "%"));
			if (main[ID.Attrs.KB] != 0F)
				tooltip.add(Component.literal(
						ChatFormatting.DARK_RED + Component.translatable("gui.shincolle.equip.kb").getString() + " " +
								String.format("%.0f", main[ID.Attrs.KB] * 100F) + "%"));

			// Enchant type and equip type
			String drawstr = Component.translatable("gui.shincolle.equip.enchtype").getString() + " ";
			drawstr += misc[ID.EquipMisc.ENCH_TYPE] == 1
					? ChatFormatting.RED + Component.translatable("gui.shincolle.equip.enchtype1").getString()
					: misc[ID.EquipMisc.ENCH_TYPE] == 2
							? ChatFormatting.AQUA + Component.translatable("gui.shincolle.equip.enchtype0").getString()
							: misc[ID.EquipMisc.ENCH_TYPE] == 3
									? ChatFormatting.GRAY
											+ Component.translatable("gui.shincolle.equip.enchtype2").getString()
									: "";
			drawstr += misc[ID.EquipMisc.EQUIP_TYPE] == 1
					? "  " + ChatFormatting.DARK_RED + Component.translatable("gui.shincolle.notforcarrier").getString()
					: misc[ID.EquipMisc.EQUIP_TYPE] == 3
							? "  " + ChatFormatting.DARK_AQUA
									+ Component.translatable("gui.shincolle.carrieronly").getString()
							: "";
			tooltip.add(Component.literal(drawstr));

			// Construction info
			if (misc[ID.EquipMisc.DEVELOP_NUM] > 400) {
				tooltip.add(
						Component.literal(ChatFormatting.DARK_RED
								+ Component.translatable("block.shincolle.block_large_shipyard").getString()));
			} else {
				tooltip.add(
						Component.literal(ChatFormatting.DARK_RED
								+ Component.translatable("block.shincolle.block_small_shipyard").getString()));
			}

			// Material info
			String matname;
			switch (misc[ID.EquipMisc.DEVELOP_MAT]) {
				case 1:
					matname = Component.translatable("item.shincolle.abyss_metal").getString();
					break;
				case 2:
					matname = Component.translatable("item.shincolle.ammo").getString();
					break;
				case 3:
					matname = Component.translatable("item.shincolle.abyss_metal_1").getString();
					break;
				default:
					matname = Component.translatable("item.shincolle.grudge").getString();
					break;
			}

			drawstr = ChatFormatting.DARK_PURPLE + Component.translatable("gui.shincolle.equip.matstype").getString() +
					ChatFormatting.GRAY + " (" + matname + ") " +
					String.format("%.0f", (float) misc[ID.EquipMisc.DEVELOP_NUM]) + "  " +
					ChatFormatting.DARK_PURPLE + Component.translatable("gui.shincolle.equip.matsrarelevel").getString()
					+
					ChatFormatting.GRAY + " " + String.format("%.0f", (float) misc[ID.EquipMisc.RARE_MEAN]);
			tooltip.add(Component.literal(drawstr));
		}
	}
}
