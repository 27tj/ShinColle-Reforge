package com.lulan.shincolle.command;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.server.ServerDataManager;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.AABB;

import java.util.List;

/**
 * Command: /shipupdateowneruid [player]
 * <p>
 * Updates the owner UID for all ships owned by the specified player (or self if
 * no player given).
 * Permission level 0 for self, level 2 required when specifying another player.
 */
public class ShipCmdUpdateOwnerUID {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("shipupdateowneruid")
                // /shipupdateowneruid (self, no permission needed)
                .executes(ctx -> executeSelf(ctx.getSource()))
                // /shipupdateowneruid <player> (requires OP)
                .then(Commands.argument("player", EntityArgument.player())
                        .requires(s -> s.hasPermission(2))
                        .executes(ctx -> executeOther(ctx.getSource(), EntityArgument.getPlayer(ctx, "player")))));
    }

    private static int executeSelf(CommandSourceStack source) {
        ServerPlayer player;
        try {
            player = source.getPlayerOrException();
        } catch (CommandSyntaxException e) {
            source.sendFailure(Component.literal("[ShinColle] This command must be run by a player."));
            return 0;
        }

        int count = updateOwnerUID(source, player);

        final String playerName = player.getName().getString();
        source.sendSuccess(() -> Component.literal(
                "[ShinColle] Updated owner UID for " + count + " ships owned by " + playerName + "."), false);

        return 1;
    }

    private static int executeOther(CommandSourceStack source, ServerPlayer targetPlayer) {
        int count = updateOwnerUID(source, targetPlayer);

        final String playerName = targetPlayer.getName().getString();
        source.sendSuccess(() -> Component.literal(
                "[ShinColle] Updated owner UID for " + count + " ships owned by " + playerName + "."), false);

        return 1;
    }

    /**
     * Iterates all loaded levels, finds BasicEntityShip entities whose ownerName
     * matches the player's name, and updates their PlayerUID to the player's
     * current UID from capability data.
     *
     * @return the number of ships updated
     */
    private static int updateOwnerUID(CommandSourceStack source, ServerPlayer player) {
        CapaTeitoku capa = ServerDataManager.getTeitokuCapability(player);
        if (capa == null) {
            source.sendFailure(Component.literal("[ShinColle] Player capability data not found."));
            return 0;
        }

        int playerUID = capa.getPlayerUID();
        String playerName = player.getName().getString();
        int count = 0;

        for (ServerLevel level : source.getServer().getAllLevels()) {
            List<BasicEntityShip> ships = level.getEntitiesOfClass(
                    BasicEntityShip.class,
                    new AABB(level.getSharedSpawnPos()).inflate(30000000));

            for (BasicEntityShip ship : ships) {
                if (playerName.equals(ship.ownerName)) {
                    ship.setStateMinor(ID.M.PlayerUID, playerUID);
                    count++;
                }
            }
        }

        return count;
    }
}
