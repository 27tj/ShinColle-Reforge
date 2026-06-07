package com.lulan.shincolle.capability;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.ArrayList;
import java.util.List;

/**
 * Player capability for ShinColle ("Admiral" / "Teitoku" data).
 * <p>
 * Stores per-player persistent data:
 * - hasRing / isRingActive / isRingFlying (marriage ring state)
 * - marriageNum (total married ships)
 * - bossCooldown / teamCooldown (cooldown timers)
 * - teamList[9][6] - 9 teams of 6 ships each (ship entity IDs / -1)
 * - sidList[9][6] - ship UIDs per team slot
 * - formatID[9] - formation type per team
 * - unitNames[9] - team names
 * - playerUID - unique player ID
 * - selectTeam - currently selected team index
 * - colledShipNum / colledEquipNum - collection counters
 */
public class CapaTeitoku implements INBTSerializable<CompoundTag> {

    public static final int TEAM_NUM = 9;
    public static final int SLOT_NUM = 6;
    /**
     * teamList[team][slot] = ship entity ID (-1 = empty)
     */
    private final int[][] teamList;
    /**
     * sidList[team][slot] = ship UID (-1 = empty)
     */
    private final int[][] sidList;
    /**
     * formatID[team] = formation type
     */
    private final int[] formatID;
    /**
     * unitNames[team] = team name
     */
    private final String[] unitNames;
    // ========== Ring state ==========
    private boolean hasRing;
    private boolean isRingActive;

    // ========== Team data ==========
    private boolean isRingFlying;
    private int marriageNum;
    // ========== Cooldowns ==========
    private int bossCooldown;
    private int teamCooldown;
    // ========== Player identification ==========
    private int playerUID;
    private int selectTeam;

    // ========== Collection data ==========
    private int colledShipNum;
    private int colledEquipNum;

    // ========== Flags ==========
    private boolean isOpeningGUI;
    private boolean initSID;
    private boolean showPlayerSkill;

    // ========== Lists / Sync data ==========
    private List<Integer> targetClassList;
    private String teamName;
    private List<Integer> allyList;
    private List<Integer> banList;
    private List<Integer> knownTeamIds;
    private List<Integer> colledShipList;
    private List<Integer> colledEquipList;
    private List<Integer> shipList;
    private float[] entityItemList;

    public CapaTeitoku() {
        this.hasRing = false;
        this.isRingActive = false;
        this.isRingFlying = false;
        this.marriageNum = 0;
        this.bossCooldown = 0;
        this.teamCooldown = 0;
        this.playerUID = -1;
        this.selectTeam = 0;
        this.colledShipNum = 0;
        this.colledEquipNum = 0;
        this.isOpeningGUI = false;
        this.initSID = false;
        this.showPlayerSkill = false;

        this.targetClassList = new ArrayList<>();
        this.teamName = "";
        this.allyList = new ArrayList<>();
        this.banList = new ArrayList<>();
        this.knownTeamIds = new ArrayList<>();
        this.colledShipList = new ArrayList<>();
        this.colledEquipList = new ArrayList<>();
        this.shipList = new ArrayList<>();
        this.entityItemList = new float[0];

        this.teamList = new int[TEAM_NUM][SLOT_NUM];
        this.sidList = new int[TEAM_NUM][SLOT_NUM];
        this.formatID = new int[TEAM_NUM];
        this.unitNames = new String[TEAM_NUM];

        for (int i = 0; i < TEAM_NUM; i++) {
            for (int j = 0; j < SLOT_NUM; j++) {
                this.teamList[i][j] = -1;
                this.sidList[i][j] = -1;
            }
            this.formatID[i] = 0;
            this.unitNames[i] = "Team " + (i + 1);
        }
    }

    // ========== NBT Serialization ==========

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();

        nbt.putBoolean("HasRing", hasRing);
        nbt.putBoolean("RingActive", isRingActive);
        nbt.putBoolean("RingFlying", isRingFlying);
        nbt.putInt("MarriageNum", marriageNum);
        nbt.putInt("BossCD", bossCooldown);
        nbt.putInt("TeamCD", teamCooldown);
        nbt.putInt("PlayerUID", playerUID);
        nbt.putInt("SelectTeam", selectTeam);
        nbt.putInt("ColledShip", colledShipNum);
        nbt.putInt("ColledEquip", colledEquipNum);

        // Save team data
        ListTag teamTag = new ListTag();
        for (int i = 0; i < TEAM_NUM; i++) {
            CompoundTag team = new CompoundTag();
            team.putIntArray("EIDs", teamList[i]);
            team.putIntArray("SIDs", sidList[i]);
            team.putInt("Format", formatID[i]);
            team.putString("Name", unitNames[i] != null ? unitNames[i] : "");
            teamTag.add(team);
        }
        nbt.put("Teams", teamTag);

        // Save persistent list/string fields
        nbt.putString("TeamName", teamName != null ? teamName : "");
        nbt.putIntArray("TargetClassList", targetClassList.stream().mapToInt(Integer::intValue).toArray());
        nbt.putIntArray("AllyList", allyList.stream().mapToInt(Integer::intValue).toArray());
        nbt.putIntArray("BanList", banList.stream().mapToInt(Integer::intValue).toArray());
        nbt.putIntArray("KnownTeamIds", knownTeamIds.stream().mapToInt(Integer::intValue).toArray());
        nbt.putIntArray("ColledShipList", colledShipList.stream().mapToInt(Integer::intValue).toArray());
        nbt.putIntArray("ColledEquipList", colledEquipList.stream().mapToInt(Integer::intValue).toArray());
        nbt.putIntArray("ShipList", shipList.stream().mapToInt(Integer::intValue).toArray());

        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.hasRing = nbt.getBoolean("HasRing");
        this.isRingActive = nbt.getBoolean("RingActive");
        this.isRingFlying = nbt.getBoolean("RingFlying");
        this.marriageNum = nbt.getInt("MarriageNum");
        this.bossCooldown = nbt.getInt("BossCD");
        this.teamCooldown = nbt.getInt("TeamCD");
        this.playerUID = nbt.getInt("PlayerUID");
        this.selectTeam = nbt.getInt("SelectTeam");
        this.colledShipNum = nbt.getInt("ColledShip");
        this.colledEquipNum = nbt.getInt("ColledEquip");

        // Load team data
        if (nbt.contains("Teams")) {
            ListTag teamTag = nbt.getList("Teams", Tag.TAG_COMPOUND);
            for (int i = 0; i < Math.min(teamTag.size(), TEAM_NUM); i++) {
                CompoundTag team = teamTag.getCompound(i);
                int[] eids = team.getIntArray("EIDs");
                int[] sids = team.getIntArray("SIDs");

                System.arraycopy(eids, 0, teamList[i], 0, Math.min(eids.length, SLOT_NUM));
                System.arraycopy(sids, 0, sidList[i], 0, Math.min(sids.length, SLOT_NUM));

                formatID[i] = team.getInt("Format");
                unitNames[i] = team.getString("Name");
            }
        }

        // Load persistent list/string fields
        this.teamName = nbt.contains("TeamName") ? nbt.getString("TeamName") : "";

        this.targetClassList = new ArrayList<>();
        if (nbt.contains("TargetClassList")) {
            for (int v : nbt.getIntArray("TargetClassList")) {
                this.targetClassList.add(v);
            }
        }

        this.allyList = new ArrayList<>();
        if (nbt.contains("AllyList")) {
            for (int v : nbt.getIntArray("AllyList")) {
                this.allyList.add(v);
            }
        }

        this.banList = new ArrayList<>();
        if (nbt.contains("BanList")) {
            for (int v : nbt.getIntArray("BanList")) {
                this.banList.add(v);
            }
        }

        this.knownTeamIds = new ArrayList<>();
        if (nbt.contains("KnownTeamIds")) {
            for (int v : nbt.getIntArray("KnownTeamIds")) {
                this.knownTeamIds.add(v);
            }
        }

        this.colledShipList = new ArrayList<>();
        if (nbt.contains("ColledShipList")) {
            for (int v : nbt.getIntArray("ColledShipList")) {
                this.colledShipList.add(v);
            }
        }

        this.colledEquipList = new ArrayList<>();
        if (nbt.contains("ColledEquipList")) {
            for (int v : nbt.getIntArray("ColledEquipList")) {
                this.colledEquipList.add(v);
            }
        }

        this.shipList = new ArrayList<>();
        if (nbt.contains("ShipList")) {
            for (int v : nbt.getIntArray("ShipList")) {
                this.shipList.add(v);
            }
        }
    }

    // ========== Getters / Setters ==========

    public boolean hasRing() {
        return hasRing;
    }

    public void setHasRing(boolean val) {
        this.hasRing = val;
    }

    public boolean isRingActive() {
        return isRingActive;
    }

    public void setRingActive(boolean val) {
        this.isRingActive = val;
    }

    public boolean isRingFlying() {
        return isRingFlying;
    }

    public void setRingFlying(boolean val) {
        this.isRingFlying = val;
    }

    public int getMarriageNum() {
        return marriageNum;
    }

    public void setMarriageNum(int val) {
        this.marriageNum = val;
    }

    public void addMarriageNum(int val) {
        this.marriageNum += val;
    }

    public int getBossCooldown() {
        return bossCooldown;
    }

    public void setBossCooldown(int val) {
        this.bossCooldown = val;
    }

    public int getTeamCooldown() {
        return teamCooldown;
    }

    public void setTeamCooldown(int val) {
        this.teamCooldown = val;
    }

    public int getPlayerUID() {
        return playerUID;
    }

    public void setPlayerUID(int val) {
        this.playerUID = val;
    }

    public int getSelectTeam() {
        return selectTeam;
    }

    public void setSelectTeam(int val) {
        this.selectTeam = Math.max(0, Math.min(val, TEAM_NUM - 1));
    }

    public int getColledShipNum() {
        return colledShipNum;
    }

    public void setColledShipNum(int val) {
        this.colledShipNum = val;
    }

    public int getColledEquipNum() {
        return colledEquipNum;
    }

    public void setColledEquipNum(int val) {
        this.colledEquipNum = val;
    }

    public boolean isOpeningGUI() {
        return isOpeningGUI;
    }

    public void setOpeningGUI(boolean val) {
        this.isOpeningGUI = val;
    }

    // ========== Team accessors ==========

    // ========== New list/flag accessors ==========

    public List<Integer> getTargetClassList() {
        return targetClassList;
    }

    public void setTargetClassList(List<Integer> list) {
        this.targetClassList = list != null ? list : new ArrayList<>();
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String name) {
        this.teamName = name != null ? name : "";
    }

    public List<Integer> getAllyList() {
        return allyList;
    }

    public void setAllyList(List<Integer> list) {
        this.allyList = list != null ? list : new ArrayList<>();
    }

    public List<Integer> getBanList() {
        return banList;
    }

    public void setBanList(List<Integer> list) {
        this.banList = list != null ? list : new ArrayList<>();
    }

    public List<Integer> getKnownTeamIds() {
        return knownTeamIds;
    }

    public void setKnownTeamIds(List<Integer> list) {
        this.knownTeamIds = list != null ? list : new ArrayList<>();
    }

    public List<Integer> getColledShipList() {
        return colledShipList;
    }

    public void setColledShipList(List<Integer> list) {
        this.colledShipList = list != null ? list : new ArrayList<>();
    }

    public List<Integer> getColledEquipList() {
        return colledEquipList;
    }

    public void setColledEquipList(List<Integer> list) {
        this.colledEquipList = list != null ? list : new ArrayList<>();
    }

    public List<Integer> getShipList() {
        return shipList;
    }

    public void setShipList(List<Integer> list) {
        this.shipList = list != null ? list : new ArrayList<>();
    }

    public boolean isInitSID() {
        return initSID;
    }

    public void setInitSID(boolean val) {
        this.initSID = val;
    }

    public boolean isShowPlayerSkill() {
        return showPlayerSkill;
    }

    public void setShowPlayerSkill(boolean val) {
        this.showPlayerSkill = val;
    }

    public float[] getEntityItemList() {
        return entityItemList;
    }

    public void setEntityItemList(float[] items) {
        this.entityItemList = items != null ? items : new float[0];
    }

    // ========== Team member accessors ==========

    public int getTeamMember(int team, int slot) {
        if (team >= 0 && team < TEAM_NUM && slot >= 0 && slot < SLOT_NUM) {
            return teamList[team][slot];
        }
        return -1;
    }

    public void setTeamMember(int team, int slot, int entityId) {
        if (team >= 0 && team < TEAM_NUM && slot >= 0 && slot < SLOT_NUM) {
            teamList[team][slot] = entityId;
        }
    }

    public int getTeamSID(int team, int slot) {
        if (team >= 0 && team < TEAM_NUM && slot >= 0 && slot < SLOT_NUM) {
            return sidList[team][slot];
        }
        return -1;
    }

    public void setTeamSID(int team, int slot, int shipUID) {
        if (team >= 0 && team < TEAM_NUM && slot >= 0 && slot < SLOT_NUM) {
            sidList[team][slot] = shipUID;
        }
    }

    public int getFormatID(int team) {
        if (team >= 0 && team < TEAM_NUM) {
            return formatID[team];
        }
        return 0;
    }

    public void setFormatID(int team, int format) {
        if (team >= 0 && team < TEAM_NUM) {
            formatID[team] = format;
        }
    }

    public String getUnitName(int team) {
        if (team >= 0 && team < TEAM_NUM) {
            return unitNames[team];
        }
        return "";
    }

    public void setUnitName(int team, String name) {
        if (team >= 0 && team < TEAM_NUM) {
            unitNames[team] = name != null ? name : "";
        }
    }

    /**
     * Clear all entity IDs in team slots (e.g. on dimension change)
     */
    public void clearTeamEntityIDs() {
        for (int i = 0; i < TEAM_NUM; i++) {
            for (int j = 0; j < SLOT_NUM; j++) {
                teamList[i][j] = -1;
            }
        }
    }

    /**
     * Check if this player has a team (has team data in ServerDataManager)
     */
    public boolean hasTeam() {
        return this.playerUID > 0
                && com.lulan.shincolle.server.ServerDataManager.getTeamData(this.playerUID) != null;
    }

    /**
     * Copy all persistent data from another CapaTeitoku (for player respawn)
     */
    public void copyFrom(CapaTeitoku other) {
        this.hasRing = other.hasRing;
        this.isRingActive = other.isRingActive;
        this.isRingFlying = other.isRingFlying;
        this.marriageNum = other.marriageNum;
        this.bossCooldown = other.bossCooldown;
        this.teamCooldown = other.teamCooldown;
        this.playerUID = other.playerUID;
        this.selectTeam = other.selectTeam;
        this.colledShipNum = other.colledShipNum;
        this.colledEquipNum = other.colledEquipNum;
        this.initSID = other.initSID;
        this.showPlayerSkill = other.showPlayerSkill;

        this.targetClassList = new ArrayList<>(other.targetClassList);
        this.teamName = other.teamName;
        this.allyList = new ArrayList<>(other.allyList);
        this.banList = new ArrayList<>(other.banList);
        this.knownTeamIds = new ArrayList<>(other.knownTeamIds);
        this.colledShipList = new ArrayList<>(other.colledShipList);
        this.colledEquipList = new ArrayList<>(other.colledEquipList);
        this.shipList = new ArrayList<>(other.shipList);
        this.entityItemList = other.entityItemList != null ? other.entityItemList.clone() : new float[0];

        for (int i = 0; i < TEAM_NUM; i++) {
            System.arraycopy(other.teamList[i], 0, this.teamList[i], 0, SLOT_NUM);
            System.arraycopy(other.sidList[i], 0, this.sidList[i], 0, SLOT_NUM);
            this.formatID[i] = other.formatID[i];
            this.unitNames[i] = other.unitNames[i];
        }
    }
}
