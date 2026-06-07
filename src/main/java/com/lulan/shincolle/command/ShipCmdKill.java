package com.lulan.shincolle.command;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

/**
 * Command: /shipkill <classId> [range]
 * <p>
 * Finds and kills all BasicEntityShip or BasicEntityShipHostile entities
 * of the given ship class within the specified range.
 * Requires OP level 2.
 */
public class ShipCmdKill {

    private static final int DEFAULT_RANGE = 64;

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("shipkill")
                .requires(s -> s.hasPermission(2))
                .then(Commands.argument("classId", IntegerArgumentType.integer(0))
                        .executes(ctx -> execute(ctx.getSource(),
                                IntegerArgumentType.getInteger(ctx, "classId"),
                                DEFAULT_RANGE))
                        .then(Commands.argument("range", IntegerArgumentType.integer(1))
                                .executes(ctx -> execute(ctx.getSource(),
                                        IntegerArgumentType.getInteger(ctx,
                                                "classId"),
                                        IntegerArgumentType.getInteger(ctx,
                                                "range"))))));
    }

    private static int execute(CommandSourceStack source, int classId, int range) {
        ServerLevel level = source.getLevel();
        Vec3 pos = source.getPosition();

        AABB searchArea = new AABB(
                pos.x - range, pos.y - range, pos.z - range,
                pos.x + range, pos.y + range, pos.z + range);

        int killCount = 0;

        // Find and kill friendly ships of matching class
        List<BasicEntityShip> friendlyShips = level.getEntitiesOfClass(
                BasicEntityShip.class, searchArea,
                entity -> entity.getShipClass() == classId);
        for (BasicEntityShip ship : friendlyShips) {
            ship.discard();
            killCount++;
        }

        // Find and kill hostile ships of matching class
        List<BasicEntityShipHostile> hostileShips = level.getEntitiesOfClass(
                BasicEntityShipHostile.class, searchArea,
                entity -> entity.getShipClass() == classId);
        for (BasicEntityShipHostile ship : hostileShips) {
            ship.discard();
            killCount++;
        }

        final int finalCount = killCount;
        source.sendSuccess(() -> Component.literal(
                        "[ShinColle] Killed " + finalCount + " ship(s) of class " + classId
                                + " within range " + range + "."),
                true);

        return killCount;
    }
}
