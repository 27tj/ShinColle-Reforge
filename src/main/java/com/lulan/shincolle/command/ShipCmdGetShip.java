package com.lulan.shincolle.command;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.server.CacheDataShip;
import com.lulan.shincolle.server.ServerDataManager;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.AABB;

import java.util.HashMap;
import java.util.List;

/**
 * Command: /ship <list|get|del> [page/uid]
 * <p>
 * Subcommands:
 * /ship list [page] - Lists ships owned by the player (level 0)
 * /ship get <uid> - Teleports a ship by its UID to the player (OP level 2)
 * /ship del <uid> - Deletes a ship cache entry by UID (OP level 2)
 */
public class ShipCmdGetShip {

    private static final int SHIPS_PER_PAGE = 8;

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("ship")
                // /ship list [page]
                .then(Commands.literal("list")
                        .executes(ctx -> executeList(ctx.getSource(), 1))
                        .then(Commands.argument("page", IntegerArgumentType.integer(1))
                                .executes(ctx -> executeList(ctx.getSource(),
                                        IntegerArgumentType.getInteger(ctx,
                                                "page")))))
                // /ship get <uid> (requires OP)
                .then(Commands.literal("get")
                        .requires(s -> s.hasPermission(2))
                        .then(Commands.argument("uid", IntegerArgumentType.integer(0))
                                .executes(ctx -> executeGet(ctx.getSource(),
                                        IntegerArgumentType.getInteger(ctx,
                                                "uid")))))
                // /ship del <uid> (requires OP)
                .then(Commands.literal("del")
                        .requires(s -> s.hasPermission(2))
                        .then(Commands.argument("uid", IntegerArgumentType.integer(0))
                                .executes(ctx -> executeDel(ctx.getSource(),
                                        IntegerArgumentType.getInteger(ctx,
                                                "uid"))))));
    }

    private static int executeList(CommandSourceStack source, int page) {
        ServerPlayer player;
        try {
            player = source.getPlayerOrException();
        } catch (CommandSyntaxException e) {
            source.sendFailure(Component.literal("[ShinColle] This command must be run by a player."));
            return 0;
        }

        CapaTeitoku capa = ServerDataManager.getTeitokuCapability(player);

        int uid = capa.getPlayerUID();

        ServerLevel level = source.getLevel();
        List<BasicEntityShip> ships = level.getEntitiesOfClass(
                BasicEntityShip.class,
                new AABB(player.blockPosition()).inflate(512),
                ship -> ship.getStateMinor(ID.M.PlayerUID) == uid);

        int totalShips = ships.size();
        int totalPages = Math.max(1, (totalShips + SHIPS_PER_PAGE - 1) / SHIPS_PER_PAGE);

        if (page > totalPages) {
            page = totalPages;
        }

        source.sendSuccess(() -> Component.literal(
                "[ShinColle] === Ship List ==="), false);

        int startIndex = (page - 1) * SHIPS_PER_PAGE;
        int endIndex = Math.min(startIndex + SHIPS_PER_PAGE, totalShips);

        for (int i = startIndex; i < endIndex; i++) {
            BasicEntityShip ship = ships.get(i);
            int shipClassID = ship.getShipClass();
            int shipLevel = ship.getLevel();
            int shipUID = ship.getShipUID();
            double distance = player.distanceTo(ship);
            final int displayIndex = i + 1;

            source.sendSuccess(() -> Component.literal(
                            String.format("  #%d  Class:%d  Lv:%d  UID:%d  Dist:%.1f",
                                    displayIndex, shipClassID, shipLevel, shipUID, distance)),
                    false);
        }

        final int finalPage = page;
        source.sendSuccess(() -> Component.literal(
                        String.format("[ShinColle] Page %d of %d (%d ships total)",
                                finalPage, totalPages, totalShips)),
                false);

        return 1;
    }

    private static int executeGet(CommandSourceStack source, int uid) {
        ServerPlayer player;
        try {
            player = source.getPlayerOrException();
        } catch (CommandSyntaxException e) {
            source.sendFailure(Component.literal("[ShinColle] This command must be run by a player."));
            return 0;
        }

        // Try cache lookup first
        BasicEntityShip ship = ServerDataManager.getShipByUID(uid);

        // Fallback: search all loaded levels
        if (ship == null) {
            for (ServerLevel level : source.getServer().getAllLevels()) {
                List<BasicEntityShip> found = level.getEntitiesOfClass(
                        BasicEntityShip.class,
                        new AABB(level.getSharedSpawnPos()).inflate(30000000),
                        s -> s.getShipUID() == uid);
                if (!found.isEmpty()) {
                    ship = found.get(0);
                    break;
                }
            }
        }

        if (ship != null) {
            ship.teleportTo(player.getX(), player.getY(), player.getZ());
            final int shipClass = ship.getShipClass();
            source.sendSuccess(() -> Component.literal(
                            "[ShinColle] Teleported ship UID " + uid + " (class " + shipClass + ") to your position."),
                    false);
            return 1;
        } else {
            source.sendFailure(Component.literal(
                    "[ShinColle] Ship with UID " + uid + " not found in any loaded level."));
            return 0;
        }
    }

    private static int executeDel(CommandSourceStack source, int uid) {
        HashMap<Integer, CacheDataShip> shipMap = ServerDataManager.getAllShipWorldData();

        if (shipMap != null && shipMap.containsKey(uid)) {
            shipMap.remove(uid);
            source.sendSuccess(() -> Component.literal(
                            "[ShinColle] Removed ship cache entry for UID " + uid
                                    + ". (Entity not killed)"),
                    false);
            return 1;
        } else {
            source.sendFailure(Component.literal(
                    "[ShinColle] No ship cache entry found for UID " + uid + "."));
            return 0;
        }
    }
}
