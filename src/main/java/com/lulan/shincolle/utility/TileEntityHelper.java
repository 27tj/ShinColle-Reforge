package com.lulan.shincolle.utility;

import com.lulan.shincolle.tileentity.TileEntityWaypoint;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

/**
 * Utility methods for tile entity operations.
 * Ported from 1.10.2 TileEntityHelper.
 */
public class TileEntityHelper {

    /**
     * Pair two waypoints together (from→to link).
     * Sets nextWaypoint on source and lastWaypoint on target (if no cycle).
     *
     * @param player    commanding player
     * @param playerUID player UID for ownership check
     * @param level     server level
     * @param posFrom   source waypoint position
     * @param posTo     target waypoint position
     */
    public static void pairingWaypoints(ServerPlayer player, int playerUID,
                                        Level level, BlockPos posFrom, BlockPos posTo) {
        BlockEntity beFrom = level.getBlockEntity(posFrom);
        BlockEntity beTo = level.getBlockEntity(posTo);

        if (!(beFrom instanceof TileEntityWaypoint wpFrom) ||
                !(beTo instanceof TileEntityWaypoint wpTo)) {
            player.sendSystemMessage(Component.literal("[ShinColle] Waypoint pairing failed: invalid blocks"));
            return;
        }

        // Check ownership
        if (wpFrom.getPlayerUID() != playerUID || wpTo.getPlayerUID() != playerUID) {
            player.sendSystemMessage(Component.literal("[ShinColle] Waypoint pairing failed: not your waypoints"));
            return;
        }

        // Set next waypoint on source
        wpFrom.setNextWaypoint(posTo);

        // Set last waypoint on target (unless it would create a 2-node cycle)
        if (!wpTo.getNextWaypoint().equals(posFrom)) {
            wpTo.setLastWaypoint(posFrom);
        }

        player.sendSystemMessage(Component.literal(
                "[ShinColle] Waypoints paired: (" +
                        posFrom.getX() + "," + posFrom.getY() + "," + posFrom.getZ() + ") -> (" +
                        posTo.getX() + "," + posTo.getY() + "," + posTo.getZ() + ")"));
    }

    /**
     * Pair a waypoint with a chest/inventory container.
     *
     * @param player    commanding player
     * @param playerUID player UID for ownership check
     * @param level     server level
     * @param posWp     waypoint position
     * @param posChest  chest/inventory position
     */
    public static void pairingWaypointAndChest(ServerPlayer player, int playerUID,
                                               Level level, BlockPos posWp, BlockPos posChest) {
        BlockEntity beWp = level.getBlockEntity(posWp);
        BlockEntity beChest = level.getBlockEntity(posChest);

        if (!(beWp instanceof TileEntityWaypoint wp)) {
            player.sendSystemMessage(Component.literal("[ShinColle] Chest pairing failed: invalid waypoint"));
            return;
        }

        // Check ownership
        if (wp.getPlayerUID() != playerUID) {
            player.sendSystemMessage(Component.literal("[ShinColle] Chest pairing failed: not your waypoint"));
            return;
        }

        // Check target is a container
        if (!(beChest instanceof Container)) {
            player.sendSystemMessage(Component.literal("[ShinColle] Chest pairing failed: target is not a container"));
            return;
        }

        wp.setPairedChest(posChest);

        player.sendSystemMessage(Component.literal(
                "[ShinColle] Waypoint-chest paired: WP(" +
                        posWp.getX() + "," + posWp.getY() + "," + posWp.getZ() + ") -> Chest(" +
                        posChest.getX() + "," + posChest.getY() + "," + posChest.getZ() + ")"));
    }
}
