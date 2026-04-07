package com.lulan.shincolle.capability;

import com.lulan.shincolle.entity.BasicEntityShip;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;

/**
 * Ship persistent data save/load helper.
 * Handles save/load of ship persistent state arrays to/from NBT.
 */
public class CapaShipSavedValues {

	/**
	 * Save ship data to NBT
	 */
	public static void saveNBTData(CompoundTag nbt, BasicEntityShip ship) {
		// save state minor array
		nbt.putIntArray("StateMinor", ship.getStateMinorArray());

		// save state flags as byte array
		boolean[] flags = ship.getStateFlagArray();
		byte[] flagBytes = new byte[flags.length];
		for (int i = 0; i < flags.length; i++) {
			flagBytes[i] = flags[i] ? (byte) 1 : (byte) 0;
		}
		nbt.putByteArray("StateFlag", flagBytes);

		// save state emotion
		nbt.putIntArray("StateEmotion", ship.getStateEmotionArray());

		// save attrs bonus
		nbt.putByteArray("AttrsBonus", ship.getAttrs().getAttrsBonus());

		// save owner name
		nbt.putString("OwnerName", ship.ownerName != null ? ship.ownerName : "");

		// save texture ID
		nbt.putInt("TextureID", ship.getTextureID());

		// Save custom name
		if (ship.hasCustomName()) {
			nbt.putString("CustomName", Component.Serializer.toJson(ship.getCustomName()));
		}
	}

	/**
	 * Load ship data from NBT
	 */
	public static void loadNBTData(CompoundTag nbt, BasicEntityShip ship) {
		// load state minor array
		if (nbt.contains("StateMinor")) {
			int[] minors = nbt.getIntArray("StateMinor");
			int[] current = ship.getStateMinorArray();
			int len = Math.min(minors.length, current.length);
			for (int i = 0; i < len; i++) {
				ship.setStateMinor(i, minors[i]);
			}
		}

		// load state flags
		if (nbt.contains("StateFlag")) {
			byte[] flagBytes = nbt.getByteArray("StateFlag");
			boolean[] current = ship.getStateFlagArray();
			int len = Math.min(flagBytes.length, current.length);
			for (int i = 0; i < len; i++) {
				ship.setStateFlag(i, flagBytes[i] != 0);
			}
		}

		// load state emotion
		if (nbt.contains("StateEmotion")) {
			int[] emotions = nbt.getIntArray("StateEmotion");
			int[] current = ship.getStateEmotionArray();
			int len = Math.min(emotions.length, current.length);
			for (int i = 0; i < len; i++) {
				ship.setStateEmotion(i, emotions[i], false);
			}
		}

		// load attrs bonus
		if (nbt.contains("AttrsBonus")) {
			byte[] bonus = nbt.getByteArray("AttrsBonus");
			ship.getAttrs().setAttrsBonus(bonus);
		}

		// load owner name
		if (nbt.contains("OwnerName")) {
			ship.ownerName = nbt.getString("OwnerName");
		}

		// Load custom name
		if (nbt.contains("CustomName")) {
			try {
				ship.setCustomName(Component.Serializer.fromJson(nbt.getString("CustomName")));
			} catch (Exception e) {
				// Fallback if invalid JSON
			}
		}

		// load texture ID
		if (nbt.contains("TextureID")) {
			ship.setTextureID(nbt.getInt("TextureID"));
		}

		// recalc attributes after loading
		ship.calcShipAttributes(31, false);

		// set exp next value
		ship.setExpNext();
	}
}
