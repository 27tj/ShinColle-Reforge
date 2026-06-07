package com.lulan.shincolle.server;

import com.lulan.shincolle.reference.Reference;
import com.lulan.shincolle.team.TeamData;
import com.lulan.shincolle.utility.LogHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Server-side persistent world data for ShinColle.
 * <p>
 * Replaces the 1.10.2 WorldSavedData with 1.20.1 SavedData.
 * Stores team data, ship cache data, player target class lists,
 * and UID counters.
 * <p>
 * This class acts as the bridge between ServerDataManager's in-memory
 * maps and the on-disk .dat file.
 */
public class ShinWorldData extends SavedData {

    public static final String SAVE_ID = Reference.MOD_ID;

    // Tag names
    private static final String TAG_NEXT_PLAYER_ID = "nextPlayerID";
    private static final String TAG_NEXT_SHIP_ID = "nextShipID";
    private static final String TAG_PLAYER_DATA = "playerData";
    private static final String TAG_TEAM_DATA = "teamData";
    private static final String TAG_SHIP_DATA = "shipData";
    private static final String TAG_UNATK_TARGET = "UnatkTargetClass";
    private static final String TAG_CUSTOM_TARGET = "CustomTargetClass";

    private static final String TAG_PUID = "pUID";
    private static final String TAG_TUID = "tUID";
    private static final String TAG_TNAME = "tName";
    private static final String TAG_TLNAME = "tLName";
    private static final String TAG_TBAN = "tBan";
    private static final String TAG_TALLY = "tAlly";

    private static final String TAG_SHIP_UID = "sUID";
    private static final String TAG_SHIP_EID = "sEID";
    private static final String TAG_SHIP_DIM = "sDim";
    private static final String TAG_SHIP_CID = "sCID";
    private static final String TAG_SHIP_DEAD = "sDead";
    private static final String TAG_SHIP_POS = "sPOS";
    private static final String TAG_SHIP_NBT = "sNBT";

    // ========== In-memory data (mirrors ServerDataManager) ==========

    int nextPlayerID = -1;
    int nextShipID = -1;
    HashMap<Integer, TeamData> teamMap = new HashMap<>();
    HashMap<Integer, CacheDataShip> shipMap = new HashMap<>();
    HashMap<Integer, HashMap<Integer, String>> customTargetClass = new HashMap<>();
    HashMap<Integer, String> unattackableTargetClass = new HashMap<>();

    /**
     * Create empty data
     */
    public ShinWorldData() {
        super();
    }

    /**
     * Load from NBT
     */
    public static ShinWorldData load(CompoundTag nbt) {
        ShinWorldData data = new ShinWorldData();
        LogHelper.info("load world data from disk.");

        data.nextPlayerID = nbt.getInt(TAG_NEXT_PLAYER_ID);
        data.nextShipID = nbt.getInt(TAG_NEXT_SHIP_ID);

        // Load unattackable target list
        ListTag unatkTag = nbt.getList(TAG_UNATK_TARGET, Tag.TAG_STRING);
        LogHelper.info("load unattackable target list: count: " + unatkTag.size());
        for (int i = 0; i < unatkTag.size(); i++) {
            String str = unatkTag.getString(i);
            if (str.length() > 1) {
                data.unattackableTargetClass.put(str.hashCode(), str);
            }
        }

        // Load player custom target data
        ListTag playerList = nbt.getList(TAG_PLAYER_DATA, Tag.TAG_COMPOUND);
        LogHelper.info("load player data count: " + playerList.size());
        for (int i = 0; i < playerList.size(); i++) {
            CompoundTag tag = playerList.getCompound(i);
            int uid = tag.getInt(TAG_PUID);

            ListTag strListTag = tag.getList(TAG_CUSTOM_TARGET, Tag.TAG_STRING);
            HashMap<Integer, String> strList = new HashMap<>();
            for (int j = 0; j < strListTag.size(); j++) {
                String str = strListTag.getString(j);
                if (str.length() > 1) {
                    strList.put(str.hashCode(), str);
                }
            }

            LogHelper.debug("load player data: UID " + uid + " target list size: " + strList.size());
            data.customTargetClass.put(uid, strList);
        }

        // Load team data
        ListTag teamList = nbt.getList(TAG_TEAM_DATA, Tag.TAG_COMPOUND);
        LogHelper.info("load team data count: " + teamList.size());
        for (int i = 0; i < teamList.size(); i++) {
            CompoundTag tag = teamList.getCompound(i);
            int tUID = tag.getInt(TAG_TUID);
            String tName = tag.getString(TAG_TNAME);
            String tLName = tag.getString(TAG_TLNAME);
            int[] tBan = tag.getIntArray(TAG_TBAN);
            int[] tAlly = tag.getIntArray(TAG_TALLY);

            TeamData tData = new TeamData();
            tData.setTeamID(tUID);
            tData.setTeamName(tName);
            tData.setTeamLeaderName(tLName);
            tData.setTeamBannedList(intArrayToList(tBan));
            tData.setTeamAllyList(intArrayToList(tAlly));

            LogHelper.debug("load team data: UID " + tUID + " NAME " + tName);
            data.teamMap.put(tUID, tData);
        }

        // Load ship data
        ListTag shipList = nbt.getList(TAG_SHIP_DATA, Tag.TAG_COMPOUND);
        LogHelper.info("load ship data count: " + shipList.size());
        for (int i = 0; i < shipList.size(); i++) {
            CompoundTag tag = shipList.getCompound(i);
            int uid = tag.getInt(TAG_SHIP_UID);
            int eid = tag.getInt(TAG_SHIP_EID);
            String dimStr = tag.getString(TAG_SHIP_DIM);
            int cid = tag.getInt(TAG_SHIP_CID);
            boolean isDead = tag.getBoolean(TAG_SHIP_DEAD);
            int[] pos = tag.getIntArray(TAG_SHIP_POS);
            CompoundTag sTag = tag.getCompound(TAG_SHIP_NBT);

            ResourceKey<Level> dim = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(dimStr));
            CacheDataShip sData = new CacheDataShip(eid, dim, cid, isDead,
                    pos.length >= 3 ? pos[0] : 0, pos.length >= 3 ? pos[1] : 0,
                    pos.length >= 3 ? pos[2] : 0, sTag);

            LogHelper.debug("load ship data: UID " + uid);
            data.shipMap.put(uid, sData);
        }

        return data;
    }

    private static List<Integer> intArrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        if (arr != null) {
            for (int v : arr) {
                list.add(v);
            }
        }
        return list;
    }

    // ========== Utility ==========

    private static int[] listToIntArray(List<Integer> list) {
        if (list == null)
            return new int[0];
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    /**
     * Save to NBT
     */
    @Override
    public CompoundTag save(CompoundTag nbt) {
        LogHelper.debug("save world data to disk.");

        nbt.putInt(TAG_NEXT_PLAYER_ID, nextPlayerID);
        nbt.putInt(TAG_NEXT_SHIP_ID, nextShipID);

        // Save unattackable list
        ListTag unatkList = new ListTag();
        if (unattackableTargetClass != null) {
            unattackableTargetClass.forEach((key, str) -> unatkList.add(StringTag.valueOf(str)));
        }
        nbt.put(TAG_UNATK_TARGET, unatkList);

        // Save player custom target data
        ListTag playerDataList = new ListTag();
        if (customTargetClass != null) {
            customTargetClass.forEach((uid, targetMap) -> {
                CompoundTag tag = new CompoundTag();
                tag.putInt(TAG_PUID, uid);

                ListTag tagList = new ListTag();
                targetMap.forEach((key, str) -> tagList.add(StringTag.valueOf(str)));
                tag.put(TAG_CUSTOM_TARGET, tagList);

                playerDataList.add(tag);
            });
        }
        nbt.put(TAG_PLAYER_DATA, playerDataList);

        // Save team data
        ListTag teamDataList = new ListTag();
        if (teamMap != null) {
            teamMap.forEach((uid, tData) -> {
                LogHelper.debug("save team data: tid: " + uid);

                CompoundTag tag = new CompoundTag();
                tag.putInt(TAG_TUID, uid);
                tag.putString(TAG_TNAME, tData.getTeamName());
                tag.putString(TAG_TLNAME, tData.getTeamLeaderName());
                tag.putIntArray(TAG_TBAN, listToIntArray(tData.getTeamBannedList()));
                tag.putIntArray(TAG_TALLY, listToIntArray(tData.getTeamAllyList()));

                teamDataList.add(tag);
            });
        }
        nbt.put(TAG_TEAM_DATA, teamDataList);

        // Save ship data
        ListTag shipDataList = new ListTag();
        if (shipMap != null) {
            shipMap.forEach((uid, sData) -> {
                LogHelper.debug("save ship data: sid: " + uid + " cid: " + sData.classID);

                CompoundTag tag = new CompoundTag();
                tag.putInt(TAG_SHIP_UID, uid);
                tag.putInt(TAG_SHIP_EID, sData.entityID);
                tag.putString(TAG_SHIP_DIM, sData.dimension.location().toString());
                tag.putInt(TAG_SHIP_CID, sData.classID);
                tag.putBoolean(TAG_SHIP_DEAD, sData.isDead);
                tag.putIntArray(TAG_SHIP_POS, new int[]{sData.posX, sData.posY, sData.posZ});
                tag.put(TAG_SHIP_NBT, sData.entityNBT != null ? sData.entityNBT : new CompoundTag());

                shipDataList.add(tag);
            });
        }
        nbt.put(TAG_SHIP_DATA, shipDataList);

        return nbt;
    }
}
