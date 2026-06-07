package com.lulan.shincolle.server;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.capability.CapaTeitokuProvider;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.team.TeamData;
import com.lulan.shincolle.utility.LogHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.DimensionDataStorage;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Server-side data manager for ShinColle.
 * <p>
 * Replaces the 1.10.2 ServerProxy. This is NOT a proxy — it is a static
 * server-side data manager that handles:
 * - Player UID assignment and caching
 * - Ship UID assignment and caching
 * - Team data management (create, disband, ally, ban)
 * - Custom target class lists per player
 * - Unattackable entity class list
 * - Persistent world data save/load via ShinWorldData (SavedData)
 * <p>
 * All methods are server-side only (do NOT call from client).
 */
public class ServerDataManager {

    // ========== Data maps ==========

    /**
     * Server ticks counter
     */
    public static int serverTicks = 0;
    /**
     * Player custom target class: <player UID, <class name hash, class name>>
     */
    private static HashMap<Integer, HashMap<Integer, String>> customTargetClass = null;
    /**
     * Unattackable target class: <class name hash, class name>
     */
    private static HashMap<Integer, String> unattackableTargetClass = null;
    /**
     * Team data: <team ID (= player UID), TeamData>
     */
    private static HashMap<Integer, TeamData> mapTeamID = null;
    /**
     * Player UID cache (runtime only, not saved): <player UID, CacheDataPlayer>
     */
    private static HashMap<Integer, CacheDataPlayer> mapPlayerID = null;
    /**
     * Ship UID cache (saved): <ship UID, CacheDataShip>
     */
    private static HashMap<Integer, CacheDataShip> mapShipID = null;
    /**
     * Next auto-increment IDs (-1 = not initialized)
     */
    private static int nextPlayerID = -1;
    private static int nextShipID = -1;
    /**
     * Reference to the SavedData instance
     */
    private static ShinWorldData worldData = null;
    /**
     * Initialization flag
     */
    private static boolean initialized = false;

    // ========== Initialization ==========

    /**
     * Initialize server data manager. Called when overworld loads.
     *
     * @param overworld the overworld ServerLevel
     */
    public static void init(ServerLevel overworld) {
        LogHelper.info("init server data manager");

        // Init default maps
        customTargetClass = new HashMap<>();
        unattackableTargetClass = new HashMap<>();
        mapPlayerID = new HashMap<>();
        mapShipID = new HashMap<>();
        mapTeamID = new HashMap<>();
        nextPlayerID = -1;
        nextShipID = -1;
        serverTicks = 0;

        // Load from disk
        DimensionDataStorage storage = overworld.getDataStorage();
        worldData = storage.computeIfAbsent(ShinWorldData::load, ShinWorldData::new, ShinWorldData.SAVE_ID);

        nextPlayerID = worldData.nextPlayerID;
        nextShipID = worldData.nextShipID;
        mapTeamID = worldData.teamMap;
        mapShipID = worldData.shipMap;
        customTargetClass = worldData.customTargetClass;
        unattackableTargetClass = worldData.unattackableTargetClass;

        LogHelper.info("loaded world data: " + mapTeamID.size() + " teams, "
                + mapShipID.size() + " ships, nextPID=" + nextPlayerID + " nextSID=" + nextShipID);

        initialized = true;
    }

    /**
     * Reset on server stop
     */
    public static void reset() {
        save();
        customTargetClass = null;
        unattackableTargetClass = null;
        mapTeamID = null;
        mapPlayerID = null;
        mapShipID = null;
        nextPlayerID = -1;
        nextShipID = -1;
        worldData = null;
        initialized = false;
        serverTicks = 0;
    }

    /**
     * Save data to disk
     */
    public static void save() {
        if (worldData != null) {
            worldData.nextPlayerID = nextPlayerID;
            worldData.nextShipID = nextShipID;
            worldData.teamMap = mapTeamID != null ? mapTeamID : new HashMap<>();
            worldData.shipMap = mapShipID != null ? mapShipID : new HashMap<>();
            worldData.customTargetClass = customTargetClass != null ? customTargetClass : new HashMap<>();
            worldData.unattackableTargetClass = unattackableTargetClass != null ? unattackableTargetClass
                    : new HashMap<>();
            worldData.setDirty();
            LogHelper.debug("server data marked dirty for save");
        }
    }

    public static boolean isInitialized() {
        return initialized;
    }

    // ========== Server access ==========

    public static MinecraftServer getServer() {
        return ServerLifecycleHooks.getCurrentServer();
    }

    public static ServerLevel getOverworld() {
        MinecraftServer server = getServer();
        return server != null ? server.getLevel(Level.OVERWORLD) : null;
    }

    // ========== Next ID management ==========

    public static int getNextPlayerID() {
        return nextPlayerID;
    }

    public static void setNextPlayerID(int id) {
        LogHelper.debug("set next player id " + id);
        nextPlayerID = id;
        markDirty();
    }

    public static int getNextShipID() {
        return nextShipID;
    }

    public static void setNextShipID(int id) {
        LogHelper.debug("set next ship id " + id);
        nextShipID = id;
        markDirty();
    }

    private static void markDirty() {
        if (worldData != null) {
            worldData.nextPlayerID = nextPlayerID;
            worldData.nextShipID = nextShipID;
            worldData.setDirty();
        }
    }

    // ========== Team data ==========

    public static TeamData getTeamData(int tid) {
        if (tid > 0 && mapTeamID != null)
            return mapTeamID.get(tid);
        return null;
    }

    public static void setTeamData(TeamData data) {
        if (data != null && data.getTeamID() > 0 && mapTeamID != null) {
            mapTeamID.put(data.getTeamID(), data);
            markDirty();
        }
    }

    public static void removeTeamData(int tid) {
        if (tid > 0 && mapTeamID != null && mapTeamID.containsKey(tid)) {
            mapTeamID.remove(tid);
            markDirty();
        }
    }

    public static HashMap<Integer, TeamData> getAllTeamWorldData() {
        return mapTeamID;
    }

    /**
     * Create a new team for a player
     */
    public static void teamCreate(Player player, String tname) {
        CapaTeitoku capa = getTeitokuCapability(player);
        if (capa == null)
            return;

        int pUID = capa.getPlayerUID();
        if (pUID > 0 && tname != null && tname.length() > 1 && mapTeamID != null) {
            TeamData tdata = new TeamData();
            tdata.setTeamID(pUID);
            tdata.setTeamName(tname);
            tdata.setTeamLeaderName(player.getGameProfile().getName());
            LogHelper.debug("create team: " + pUID + " " + tname);

            // Remove duplicate team data for this leader
            cleanTeamData(tdata);

            setTeamData(tdata);
            capa.setTeamCooldown(ConfigHandler.teamCooldown());
            updatePlayerID(player);
        }
    }

    /**
     * Disband a player's team
     */
    public static void teamDisband(Player player) {
        if (player == null)
            return;
        CapaTeitoku capa = getTeitokuCapability(player);

        int pUID = capa.getPlayerUID();
        if (mapTeamID != null && mapTeamID.containsKey(pUID)) {
            LogHelper.debug("remove team: " + pUID);
            removeTeamData(pUID);
            capa.setTeamCooldown(ConfigHandler.teamCooldown());
            updatePlayerID(player);
        }
    }

    /**
     * Rename a team
     */
    public static void teamRename(int tid, String tname) {
        if (tid > 0 && tname != null && tname.length() > 1 && mapTeamID != null && mapTeamID.containsKey(tid)) {
            TeamData tdata = getTeamData(tid);
            if (tdata != null) {
                tdata.setTeamName(tname);
                markDirty();
            }
        }
    }

    /**
     * Add ally: team2 as team1's ally (unilateral)
     */
    public static void teamAddAlly(int tid1, int tid2) {
        if (tid1 > 0 && tid2 > 0 && tid1 != tid2 && mapTeamID != null
                && mapTeamID.containsKey(tid1) && mapTeamID.containsKey(tid2)) {
            LogHelper.debug("add ally: " + tid1 + " add " + tid2);
            TeamData tdata = getTeamData(tid1);
            if (tdata != null) {
                tdata.addTeamAlly(tid2);
                markDirty();
            }
        }
    }

    /**
     * Remove ally: bilateral removal
     */
    public static void teamRemoveAlly(int tid1, int tid2) {
        if (tid1 > 0 && tid2 > 0 && mapTeamID != null
                && mapTeamID.containsKey(tid1) && mapTeamID.containsKey(tid2)) {
            LogHelper.debug("remove ally: " + tid1 + " and " + tid2);
            TeamData tdata1 = getTeamData(tid1);
            if (tdata1 != null)
                tdata1.removeTeamAlly(tid2);
            TeamData tdata2 = getTeamData(tid2);
            if (tdata2 != null)
                tdata2.removeTeamAlly(tid1);
            markDirty();
        }
    }

    /**
     * Ban team: bilateral ban
     */
    public static void teamAddBan(int tid1, int tid2) {
        if (tid1 > 0 && tid2 > 0 && tid1 != tid2 && mapTeamID != null
                && mapTeamID.containsKey(tid1) && mapTeamID.containsKey(tid2)) {
            LogHelper.debug("ban team: " + tid1 + " ban " + tid2);
            TeamData tdata1 = getTeamData(tid1);
            if (tdata1 != null)
                tdata1.addTeamBanned(tid2);
            TeamData tdata2 = getTeamData(tid2);
            if (tdata2 != null)
                tdata2.addTeamBanned(tid1);
            markDirty();
        }
    }

    /**
     * Unban team: unilateral unban
     */
    public static void teamRemoveBan(int tid1, int tid2) {
        if (tid1 > 0 && tid2 > 0 && mapTeamID != null
                && mapTeamID.containsKey(tid1) && mapTeamID.containsKey(tid2)) {
            LogHelper.debug("unban team: " + tid1 + " unban " + tid2);
            TeamData tdata1 = getTeamData(tid1);
            if (tdata1 != null)
                tdata1.removeTeamBanned(tid2);
            markDirty();
        }
    }

    /**
     * Remove duplicate teams with the same leader name
     */
    private static void cleanTeamData(TeamData tdata) {
        if (tdata == null || mapTeamID == null)
            return;
        String owner1 = tdata.getTeamLeaderName();

        try {
            Iterator<Map.Entry<Integer, TeamData>> iter = mapTeamID.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<Integer, TeamData> entry = iter.next();
                TeamData existing = entry.getValue();
                if (owner1.equals(existing.getTeamLeaderName())) {
                    iter.remove();
                }
            }
        } catch (Exception e) {
            LogHelper.info("clean team data fail: " + e);
        }
    }

    // ========== Player data ==========

    public static CacheDataPlayer getPlayerWorldData(int uid) {
        if (uid > 0 && mapPlayerID != null)
            return mapPlayerID.get(uid);
        return null;
    }

    public static void setPlayerWorldData(int uid, CacheDataPlayer data) {
        if (uid > 0 && data != null && mapPlayerID != null) {
            mapPlayerID.put(uid, data);
        }
    }

    public static HashMap<Integer, CacheDataPlayer> getAllPlayerWorldData() {
        return mapPlayerID;
    }

    /**
     * Update or assign player UID on login
     */
    public static void updatePlayerID(Player player) {
        LogHelper.debug("update player: " + player.getGameProfile().getName()
                + " uuid=" + player.getUUID() + " eid=" + player.getId());

        CapaTeitoku capa = getTeitokuCapability(player);

        int pid = capa.getPlayerUID();

        if (pid > 0) {
            // Existing player — update cache
            LogHelper.info("update player: update uid: " + pid);
            setPlayerWorldData(pid, new CacheDataPlayer(
                    player.getId(), player.level().dimension(),
                    capa.hasTeam(), player.getX(), player.getY(), player.getZ(),
                    capa.serializeNBT()));

            // Safety: ensure nextPlayerID is ahead
            if (getNextPlayerID() <= 0 || getNextPlayerID() <= pid) {
                LogHelper.info("update player: next player UID too low, shifting +100000");
                setNextPlayerID(pid + 100000);
            }
        } else {
            // New player — assign UID
            pid = getNextPlayerID();
            if (pid <= 0)
                pid = 100; // init value

            LogHelper.info("update player: create uid: " + pid);
            capa.setPlayerUID(pid);
            setPlayerWorldData(pid, new CacheDataPlayer(
                    player.getId(), player.level().dimension(),
                    capa.hasTeam(), player.getX(), player.getY(), player.getZ(),
                    capa.serializeNBT()));
            setNextPlayerID(pid + 1);
        }
    }

    // ========== Ship data ==========

    public static CacheDataShip getShipWorldData(int uid) {
        if (uid > 0 && mapShipID != null)
            return mapShipID.get(uid);
        return null;
    }

    public static void setShipWorldData(int uid, CacheDataShip data) {
        if (uid > 0 && data != null && mapShipID != null) {
            mapShipID.put(uid, data);
            markDirty();
        }
    }

    public static HashMap<Integer, CacheDataShip> getAllShipWorldData() {
        return mapShipID;
    }

    /**
     * Update or assign ship UID
     */
    public static void updateShipID(BasicEntityShip ship) {
        LogHelper.debug("update ship: " + ship);

        int uid = ship.getShipUID();

        if (uid > 0) {
            // Existing ship — update cache
            LogHelper.debug("update ship: update sid " + uid + " eid: " + ship.getId()
                    + " dim: " + ship.level().dimension().location());

            ship = checkShipIsDupe(ship, uid);

            CacheDataShip sdata = new CacheDataShip(
                    ship.getId(), ship.level().dimension(),
                    ship.getShipClass(), ship.isRemoved(),
                    ship.getX(), ship.getY(), ship.getZ(),
                    createShipNBTBackup(ship));

            setShipWorldData(uid, sdata);

            // Safety: ensure nextShipID is ahead
            if (getNextShipID() <= 0 || getNextShipID() <= uid) {
                LogHelper.debug("update ship: next ship id too low, shifting +100000");
                setNextShipID(uid + 100000);
            }
        } else {
            // New ship — assign UID
            uid = getNextShipID();
            if (uid <= 0)
                uid = 100; // init value

            LogHelper.debug("update ship: create sid: " + uid + " eid: " + ship.getId()
                    + " dim: " + ship.level().dimension().location());
            ship.setShipUID(uid);

            CacheDataShip sdata = new CacheDataShip(
                    ship.getId(), ship.level().dimension(),
                    ship.getShipClass(), ship.isRemoved(),
                    ship.getX(), ship.getY(), ship.getZ(),
                    createShipNBTBackup(ship));

            setShipWorldData(uid, sdata);
            setNextShipID(uid + 1);
        }
    }

    /**
     * Check for duplicate ships with the same UID — delete the older one
     */
    public static BasicEntityShip checkShipIsDupe(BasicEntityShip ship, int uid) {
        if (mapShipID == null || !mapShipID.containsKey(uid))
            return ship;

        CacheDataShip olddata = mapShipID.get(uid);

        // Try to find the old entity in the same dimension
        MinecraftServer server = getServer();
        if (server == null)
            return ship;

        ServerLevel level = server.getLevel(olddata.dimension);
        if (level == null)
            return ship;

        Entity ent = level.getEntity(olddata.entityID);

        if (ent instanceof BasicEntityShip oldShip
                && oldShip.getId() != ship.getId()
                && oldShip.getShipUID() == uid) {
            LogHelper.info("ships with same uid found: uid: " + uid);
            LogHelper.info("  ent1: eid: " + oldShip.getId() + " ticks: " + oldShip.tickCount);
            LogHelper.info("  ent2: eid: " + ship.getId() + " ticks: " + ship.tickCount);

            if (oldShip.tickCount > 200 && ship.tickCount > 200
                    && oldShip.isAlive() && ship.isAlive()) {
                if (oldShip.tickCount > ship.tickCount) {
                    LogHelper.info("  older entity: " + oldShip.getId() + " is deleted.");
                    oldShip.discard();
                } else {
                    LogHelper.info("  older entity: " + ship.getId() + " is deleted.");
                    ship.discard();
                    ship = oldShip;
                }
            }
        }

        return ship;
    }

    /**
     * Update ship owner ID from owner's capability
     */
    public static void updateShipOwnerID(BasicEntityShip ship) {
        Entity owner = ship.getOwner();

        if (owner instanceof Player player) {
            CapaTeitoku capa = getTeitokuCapability(player);
            int pid = capa.getPlayerUID();
            LogHelper.debug("update ship: set owner id: " + pid + " on " + ship);
            ship.setPlayerUID(pid);
        } else {
            LogHelper.debug("update ship: get owner id fail, owner offline or no data: " + ship);
        }
    }

    // ========== Custom target class ==========

    public static HashMap<Integer, String> getPlayerTargetClass(int pid) {
        if (pid > 0 && customTargetClass != null)
            return customTargetClass.get(pid);
        return null;
    }

    /**
     * Toggle (add/remove) a target class for a player. Returns true if added.
     */
    public static boolean setPlayerTargetClass(int pid, String str) {
        if (str == null || str.length() <= 1 || pid <= 0)
            return true;

        HashMap<Integer, String> tarList = getPlayerTargetClass(pid);

        if (tarList != null) {
            String s = tarList.get(str.hashCode());
            if (s != null) {
                tarList.remove(str.hashCode());
                markDirty();
                return false; // removed
            }
            tarList.put(str.hashCode(), str);
            markDirty();
        } else {
            tarList = new HashMap<>();
            tarList.put(str.hashCode(), str);
            customTargetClass.put(pid, tarList);
            markDirty();
        }

        return true; // added
    }

    public static void setPlayerTargetClass(int pid, HashMap<Integer, String> map) {
        if (pid > 0 && customTargetClass != null) {
            customTargetClass.put(pid, map);
            markDirty();
        }
    }

    public static HashMap<Integer, HashMap<Integer, String>> getAllPlayerTargetClassList() {
        return customTargetClass;
    }

    // ========== Unattackable target class ==========

    public static HashMap<Integer, String> getUnattackableTargetClass() {
        return unattackableTargetClass;
    }

    /**
     * Toggle unattackable target. Returns true if added.
     */
    public static boolean addUnattackableTargetClass(String target) {
        if (target == null || unattackableTargetClass == null)
            return false;

        int key = target.hashCode();
        if (unattackableTargetClass.containsKey(key)) {
            unattackableTargetClass.remove(key);
            markDirty();
            return false; // removed
        } else {
            unattackableTargetClass.put(key, target);
            markDirty();
            return true; // added
        }
    }

    // ========== Player entity lookup ==========

    /**
     * Find a ServerPlayer by their ShinColle UID
     */
    public static ServerPlayer getPlayerByUID(int uid) {
        if (uid <= 0)
            return null;
        MinecraftServer server = getServer();
        if (server == null)
            return null;

        for (ServerPlayer player : server.getPlayerList().getPlayers()) {
            CapaTeitoku capa = getTeitokuCapability(player);
            if (capa != null && capa.getPlayerUID() == uid) {
                return player;
            }
        }
        return null;
    }

    /**
     * Find a BasicEntityShip by its ship UID
     */
    public static BasicEntityShip getShipByUID(int uid) {
        if (uid <= 0 || mapShipID == null)
            return null;

        CacheDataShip data = mapShipID.get(uid);
        if (data == null)
            return null;

        MinecraftServer server = getServer();
        if (server == null)
            return null;

        ServerLevel level = server.getLevel(data.dimension);
        if (level == null)
            return null;

        Entity ent = level.getEntity(data.entityID);
        if (ent instanceof BasicEntityShip ship && ship.getShipUID() == uid) {
            return ship;
        }

        return null;
    }

    // ========== Server tick ==========

    /**
     * Called every server tick
     */
    public static void onServerTick() {
        if (!initialized)
            return;

        serverTicks++;
        if (serverTicks > 23999)
            serverTicks = 0;

        // Auto-save every 6000 ticks (~5 minutes)
        if (serverTicks % 6000 == 0) {
            save();
        }
    }

    // ========== Utility ==========

    /**
     * Get CapaTeitoku from player, or null
     */
    public static CapaTeitoku getTeitokuCapability(Player player) {
        if (player == null)
            return null;
        return player.getCapability(CapaTeitokuProvider.CAPABILITY).orElse(null);
    }

    /**
     * Check if a player is an operator
     */
    public static boolean checkOP(Player player) {
        if (player instanceof ServerPlayer sp) {
            return sp.hasPermissions(2);
        }
        return false;
    }

    /**
     * Create a full NBT backup of the ship entity for recovery purposes.
     * Saves all entity data including attributes, inventory, and state.
     *
     * @param ship the ship entity to back up
     * @return CompoundTag containing the full entity NBT, or empty tag on failure
     */
    private static CompoundTag createShipNBTBackup(BasicEntityShip ship) {
        try {
            CompoundTag nbt = new CompoundTag();
            ship.saveWithoutId(nbt);
            return nbt;
        } catch (Exception e) {
            LogHelper.info("ship NBT backup failed for sid " + ship.getShipUID() + ": " + e);
            return new CompoundTag();
        }
    }
}
