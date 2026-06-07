package com.lulan.shincolle.capability;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.utility.NBTHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;

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
        boolean hasMinor = nbt.contains("StateMinor", Tag.TAG_INT_ARRAY);
        boolean hasFlag = nbt.contains("StateFlag", Tag.TAG_BYTE_ARRAY);
        boolean hasEmotion = nbt.contains("StateEmotion", Tag.TAG_INT_ARRAY);

        // load state minor array
        if (hasMinor) {
            int[] minors = nbt.getIntArray("StateMinor");
            int[] current = ship.getStateMinorArray();
            int len = Math.min(minors.length, current.length);
            for (int i = 0; i < len; i++) {
                ship.setStateMinor(i, minors[i]);
            }
        }

        // load state flags
        if (hasFlag) {
            byte[] flagBytes = nbt.getByteArray("StateFlag");
            boolean[] current = ship.getStateFlagArray();
            int len = Math.min(flagBytes.length, current.length);
            for (int i = 0; i < len; i++) {
                ship.setStateFlag(i, flagBytes[i] != 0);
            }
        }

        // load state emotion
        if (hasEmotion) {
            int[] emotions = nbt.getIntArray("StateEmotion");
            int[] current = ship.getStateEmotionArray();
            int len = Math.min(emotions.length, current.length);
            for (int i = 0; i < len; i++) {
                ship.setStateEmotion(i, emotions[i], false);
            }
        }

        // [PORT] 1.10.2 -> 1.20.1: backward-compatible loading for legacy ShipExtProps schema.
        if ((!hasMinor || !hasFlag || !hasEmotion) && nbt.contains("ShipExtProps", Tag.TAG_COMPOUND)) {
            loadLegacyShipExtProps(nbt.getCompound("ShipExtProps"), ship, hasMinor, hasFlag, hasEmotion,
                    nbt.contains("CustomName", Tag.TAG_STRING));
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

    private static void loadLegacyShipExtProps(CompoundTag legacy, BasicEntityShip ship,
                                               boolean hasMinor, boolean hasFlag, boolean hasEmotion, boolean hasCustomName) {
        if (!hasMinor && legacy.contains("Minor", Tag.TAG_COMPOUND)) {
            CompoundTag minor = legacy.getCompound("Minor");
            setLegacyMinor(minor, ship, "Level", ID.M.ShipLevel);
            setLegacyMinor(minor, ship, "Kills", ID.M.Kills);
            setLegacyMinor(minor, ship, "Exp", ID.M.ExpCurrent);
            setLegacyMinor(minor, ship, "NumAmmoL", ID.M.NumAmmoLight);
            setLegacyMinor(minor, ship, "NumAmmoH", ID.M.NumAmmoHeavy);
            setLegacyMinor(minor, ship, "NumGrudge", ID.M.NumGrudge);
            setLegacyMinor(minor, ship, "NumAirL", ID.M.NumAirLight);
            setLegacyMinor(minor, ship, "NumAirH", ID.M.NumAirHeavy);
            setLegacyMinor(minor, ship, "FMin", ID.M.FollowMin);
            setLegacyMinor(minor, ship, "FMax", ID.M.FollowMax);
            setLegacyMinor(minor, ship, "FHP", ID.M.FleeHP);
            setLegacyMinor(minor, ship, "GuardX", ID.M.GuardX);
            setLegacyMinor(minor, ship, "GuardY", ID.M.GuardY);
            setLegacyMinor(minor, ship, "GuardZ", ID.M.GuardZ);
            setLegacyMinor(minor, ship, "GuardDim", ID.M.GuardDim);
            setLegacyMinor(minor, ship, "GuardID", ID.M.GuardID);
            setLegacyMinor(minor, ship, "GuardType", ID.M.GuardType);
            setLegacyMinor(minor, ship, "PlayerUID", ID.M.PlayerUID);
            setLegacyMinor(minor, ship, "ShipUID", ID.M.ShipUID);
            setLegacyMinor(minor, ship, "FType", ID.M.FormatType);
            setLegacyMinor(minor, ship, "FPos", ID.M.FormatPos);
            setLegacyMinor(minor, ship, "Morale", ID.M.Morale);
            setLegacyMinor(minor, ship, "Food", ID.M.Food);
            setLegacyMinor(minor, ship, "Crane", ID.M.CraneState);
            setLegacyMinor(minor, ship, "WpStay", ID.M.WpStay);
            setLegacyMinor(minor, ship, "AutoCR", ID.M.UseCombatRation);
            setLegacyMinor(minor, ship, "Task", ID.M.Task);
            setLegacyMinor(minor, ship, "Side", ID.M.TaskSide);

            if (!hasCustomName && minor.contains("tagName", Tag.TAG_STRING)) {
                String legacyName = minor.getString("tagName");
                if (!legacyName.trim().isEmpty()) {
                    ship.setCustomName(Component.literal(legacyName));
                }
            }
        }

        if (!hasEmotion && legacy.contains("Display", Tag.TAG_COMPOUND)) {
            CompoundTag display = legacy.getCompound("Display");
            setLegacyEmotion(display, ship, "State", ID.S.State);
            setLegacyEmotion(display, ship, "Emotion", ID.S.Emotion);
            setLegacyEmotion(display, ship, "Emotion2", ID.S.Emotion2);
            setLegacyEmotion(display, ship, "Phase", ID.S.Phase);
        }

        if (legacy.contains("Point", Tag.TAG_COMPOUND)) {
            CompoundTag point = legacy.getCompound("Point");
            setLegacyAttrBonus(point, ship, "HP", ID.AttrsBase.HP);
            setLegacyAttrBonus(point, ship, "ATK", ID.AttrsBase.ATK);
            setLegacyAttrBonus(point, ship, "DEF", ID.AttrsBase.DEF);
            setLegacyAttrBonus(point, ship, "SPD", ID.AttrsBase.SPD);
            setLegacyAttrBonus(point, ship, "MOV", ID.AttrsBase.MOV);
            setLegacyAttrBonus(point, ship, "HIT", ID.AttrsBase.HIT);
        }

        if (!hasFlag && legacy.contains("ShipFlags", Tag.TAG_COMPOUND)) {
            CompoundTag flags = legacy.getCompound("ShipFlags");
            setLegacyFlag(flags, ship, "CanFloat", ID.F.CanFloatUp);
            setLegacyFlag(flags, ship, "IsMarried", ID.F.IsMarried);
            setLegacyFlag(flags, ship, "NoFuel", ID.F.NoFuel);
            setLegacyFlag(flags, ship, "Melee", ID.F.UseMelee);
            setLegacyFlag(flags, ship, "AmmoL", ID.F.UseAmmoLight);
            setLegacyFlag(flags, ship, "AmmoH", ID.F.UseAmmoHeavy);
            setLegacyFlag(flags, ship, "AirL", ID.F.UseAirLight);
            setLegacyFlag(flags, ship, "AirH", ID.F.UseAirHeavy);
            setLegacyFlag(flags, ship, "WedEffect", ID.F.UseRingEffect);
            setLegacyFlag(flags, ship, "CanDrop", ID.F.CanDrop);
            setLegacyFlag(flags, ship, "CanFollow", ID.F.CanFollow);
            setLegacyFlag(flags, ship, "OnSight", ID.F.OnSightChase);
            setLegacyFlag(flags, ship, "PVPFirst", ID.F.PVPFirst);
            setLegacyFlag(flags, ship, "AA", ID.F.AntiAir);
            setLegacyFlag(flags, ship, "ASM", ID.F.AntiSS);
            setLegacyFlag(flags, ship, "PassiveAI", ID.F.PassiveAI);
            setLegacyFlag(flags, ship, "TimeKeeper", ID.F.TimeKeeper);
            setLegacyFlag(flags, ship, "PickItem", ID.F.PickItem);
            setLegacyFlag(flags, ship, "HeldItem", ID.F.ShowHeldItem);
            setLegacyFlag(flags, ship, "AutoPump", ID.F.AutoPump);
        }

        if (legacy.contains("Timer", Tag.TAG_COMPOUND)) {
            CompoundTag timer = legacy.getCompound("Timer");
            if (timer.contains("Crane", Tag.TAG_INT)) {
                ship.setStateTimer(ID.T.CraneTime, timer.getInt("Crane"));
            }
        }

        if ((ship.ownerName == null || ship.ownerName.isEmpty()) && legacy.contains("Owner", Tag.TAG_STRING)) {
            ship.ownerName = legacy.getString("Owner");
        }

        if (legacy.contains("uname", Tag.TAG_LIST)) {
            ArrayList<String> legacyNames = NBTHelper.loadStringTagArrayList(legacy, "uname");
            if (!legacyNames.isEmpty()) {
                ship.unitNames = legacyNames;
            }
        }
    }

    private static void setLegacyMinor(CompoundTag nbt, BasicEntityShip ship, String key, int stateId) {
        if (nbt.contains(key, Tag.TAG_INT)) {
            ship.setStateMinor(stateId, nbt.getInt(key));
        }
    }

    private static void setLegacyEmotion(CompoundTag nbt, BasicEntityShip ship, String key, int stateId) {
        if (nbt.contains(key, Tag.TAG_INT)) {
            ship.setStateEmotion(stateId, nbt.getInt(key), false);
        }
    }

    private static void setLegacyFlag(CompoundTag nbt, BasicEntityShip ship, String key, int stateId) {
        if (nbt.contains(key, Tag.TAG_BYTE)) {
            ship.setStateFlag(stateId, nbt.getBoolean(key));
        }
    }

    private static void setLegacyAttrBonus(CompoundTag nbt, BasicEntityShip ship, String key, int attrId) {
        if (nbt.contains(key, Tag.TAG_BYTE)) {
            ship.getAttrs().setAttrsBonus(attrId, nbt.getByte(key));
        }
    }
}
