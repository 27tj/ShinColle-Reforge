package com.lulan.shincolle.command;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

/**
 * Command: /shipstopai
 * Alias: /shipstop
 * <p>
 * Toggles the global AI stop flag for all ship entities.
 * When enabled, all ship entities will stop their AI processing.
 * Requires OP level 2.
 */
public class ShipCmdStopAI {

    // Local tracking flag. Also wired to BasicEntityShip.stopAI which entities
    // check in their tick() method to skip AI processing when true.
    private static boolean stopAI = false;

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        // Main command
        dispatcher.register(Commands.literal("shipstopai")
                .requires(s -> s.hasPermission(2))
                .executes(ctx -> execute(ctx.getSource())));

        // Alias
        dispatcher.register(Commands.literal("shipstop")
                .requires(s -> s.hasPermission(2))
                .executes(ctx -> execute(ctx.getSource())));
    }

    private static int execute(CommandSourceStack source) {
        stopAI = !stopAI;

        // Wire to BasicEntityShip.stopAI so entities check this flag in their tick()
        BasicEntityShip.stopAI = stopAI;

        source.sendSuccess(() -> Component.literal(
                "[ShinColle] Ship AI " + (stopAI ? "STOPPED" : "RESUMED") + ". (stopAI = " + stopAI + ")"), true);

        return 1;
    }

    /**
     * Returns the current stopAI state.
     */
    public static boolean isStopAI() {
        return stopAI;
    }
}
