package com.lulan.shincolle.utility;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.IShipOwner;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.server.ServerDataManager;
import com.lulan.shincolle.team.TeamData;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.player.Player;

/**
 * Helper for owner / team / ally / friendly / hostile checking.
 * <p>
 * Ported from 1.10.2 TeamHelper. All methods are SERVER SIDE ONLY
 * unless otherwise noted.
 */
public class TeamHelper {

    /**
     * Get team data by player UID. SERVER SIDE ONLY.
     */
    public static TeamData getTeamDataByUID(int uid) {
        if (uid > 0) {
            return ServerDataManager.getTeamData(uid);
        }
        return null;
    }

    /**
     * Check if host's owner is a player (for mod interaction)
     */
    public static boolean checkOwnerIsPlayer(Entity ent) {
        if (ent == null)
            return false;

        if (ent instanceof IShipOwner owner) {
            return owner.getPlayerUID() > 0;
        }
        if (ent instanceof OwnableEntity ownable) {
            return ownable.getOwner() instanceof Player;
        }

        return false;
    }

    /**
     * Check friendly fire (returns false = no damage should be applied).
     *
     * @param attacker the attacking entity (must be IShipOwner)
     * @param target   the target entity
     * @return true if damage should be applied, false if it should be blocked
     */
    public static boolean doFriendlyFire(IShipOwner attacker, Entity target) {
        if (attacker == null || target == null)
            return true;

        int ida = attacker.getPlayerUID();
        int idb = getPlayerUID(target);

        if (ConfigHandler.friendlyFire()) {
            // Friendly fire enabled
            if (ida > 0 || ida < -1) {
                // Same owner → no damage
                return ida != idb;
            }
        } else {
            // Friendly fire disabled
            // Hostile vs hostile = no damage
            if (ida < -1 && idb < -1 && ida == idb) {
                return false;
            }

            // Normal ship cannot hurt player
            if (ida >= -1 && target instanceof Player) {
                return false;
            }

            // No damage to ally
            return !checkIsAlly(ida, idb);
        }

        // Default: can damage
        return true;
    }

    /**
     * Check if target entity is host's ally. SERVER SIDE ONLY.
     */
    public static boolean checkIsAlly(Entity host, Entity target) {
        if (host != null && target != null) {
            int hostID = getPlayerUID(host);
            int tarID = getPlayerUID(target);
            return checkIsAlly(hostID, tarID);
        }
        return false;
    }

    /**
     * Check if two player UIDs are allied. SERVER SIDE ONLY.
     */
    public static boolean checkIsAlly(int hostPID, int tarPID) {
        // Mob vs mob
        if (hostPID < -1 && tarPID < -1) {
            return true;
        }

        // Player vs mob
        if ((hostPID < -1 && tarPID > 0) || (hostPID > 0 && tarPID < -1)) {
            return false;
        }

        // Player vs player
        if (hostPID > 0 && tarPID > 0) {
            // Same owner
            if (hostPID == tarPID)
                return true;

            // Check team alliance
            TeamData hostTeam = getTeamDataByUID(hostPID);
            TeamData tarTeam = getTeamDataByUID(tarPID);

            if (hostTeam != null && tarTeam != null) {
                return hostTeam.getTeamAllyList().contains(tarTeam.getTeamID());
            }
        }

        return false;
    }

    /**
     * Check if target entity is in host's banned list. SERVER SIDE ONLY.
     */
    public static boolean checkIsBanned(Entity host, Entity target) {
        if (host != null && target != null) {
            int hostID = getPlayerUID(host);
            int tarID = getPlayerUID(target);
            return checkIsBanned(hostID, tarID);
        }
        return false;
    }

    /**
     * Check if two player UIDs are banned (hostile). SERVER SIDE ONLY.
     */
    public static boolean checkIsBanned(int hostPID, int tarPID) {
        // Mob vs mob
        if (hostPID < -1 && tarPID < -1) {
            return false;
        }

        // Player vs mob
        if ((hostPID < -1 && tarPID > 0) || (hostPID > 0 && tarPID < -1)) {
            return true;
        }

        // Player vs player
        if (hostPID > 0 && tarPID > 0) {
            TeamData hostTeam = getTeamDataByUID(hostPID);
            TeamData tarTeam = getTeamDataByUID(tarPID);

            if (hostTeam != null && tarTeam != null) {
                return hostTeam.getTeamBannedList().contains(tarTeam.getTeamID());
            }
        }

        return false;
    }

    /**
     * Check if two entities have the same owner UID
     */
    public static boolean checkSameOwner(Entity enta, Entity entb) {
        int ida = getPlayerUID(enta);
        int idb = getPlayerUID(entb);

        // Both must be valid (>0 or <-1, not 0 or -1)
        if ((ida > 0 || ida < -1) && (idb > 0 || idb < -1)) {
            return ida == idb;
        }

        return false;
    }

    /**
     * Update team ship pointers.
     * Resolves ship UIDs to entity IDs for the current team.
     */
    public static void updateTeamList(Player player, CapaTeitoku capa) {
        int team = capa.getSelectTeam();

        for (int i = 0; i < CapaTeitoku.SLOT_NUM; i++) {
            int shipUID = capa.getTeamMember(team, i);
            BasicEntityShip ship = ServerDataManager.getShipByUID(shipUID);

            if (ship != null) {
                if (checkSameOwner(ship, player)) {
                    // TeamMember stores persistent ship UID; TeamSID stores runtime entity ID.
                    capa.setTeamMember(team, i, ship.getStateMinor(ID.M.ShipUID));
                    capa.setTeamSID(team, i, ship.getId());
                } else {
                    // Owner changed, clear runtime entity pointer but keep persistent UID.
                    capa.setTeamSID(team, i, -1);
                }
            } else {
                // Ship not found; clear runtime entity pointer but keep UID for later relink.
                capa.setTeamSID(team, i, -1);

                // Truly empty slot: clear both fields.
                if (shipUID <= 0) {
                    capa.setTeamMember(team, i, -1);
                    capa.setTeamSID(team, i, -1);
                }
            }
        }
    }

    /**
     * Get the player UID associated with an entity
     */
    public static int getPlayerUID(Entity entity) {
        if (entity instanceof IShipOwner owner) {
            return owner.getPlayerUID();
        }
        if (entity instanceof Player player) {
            CapaTeitoku capa = ServerDataManager.getTeitokuCapability(player);
            return capa.getPlayerUID();
        }
        // Check vanilla tameable
        if (entity instanceof OwnableEntity ownable) {
            Entity owner = ownable.getOwner();
            if (owner instanceof Player player) {
                CapaTeitoku capa = ServerDataManager.getTeitokuCapability(player);
                return capa.getPlayerUID();
            }
        }
        return 0;
    }
}
