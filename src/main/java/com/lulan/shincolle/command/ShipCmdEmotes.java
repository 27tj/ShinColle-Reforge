package com.lulan.shincolle.command;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.reference.ID;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.HashMap;
import java.util.Map;

/**
 * Command: /shipemotes [emote]
 * Aliases: /em, /emo, /emote, /emotes
 * <p>
 * Plays an emote on the ship entity the player is looking at.
 * Available to all players (permission level 0).
 */
public class ShipCmdEmotes {

    /**
     * Emote name to emote ID mapping (35 emotes, IDs 0-34)
     */
    private static final Map<String, Integer> EMOTE_MAP = new HashMap<>();

    static {
        // 0: swt, drop
        EMOTE_MAP.put("swt", 0);
        EMOTE_MAP.put("drop", 0);
        // 1: lv, love, heart
        EMOTE_MAP.put("lv", 1);
        EMOTE_MAP.put("love", 1);
        EMOTE_MAP.put("heart", 1);
        // 2: swt2, wah, panic
        EMOTE_MAP.put("swt2", 2);
        EMOTE_MAP.put("wah", 2);
        EMOTE_MAP.put("panic", 2);
        // 3: ?
        EMOTE_MAP.put("?", 3);
        // 4: !
        EMOTE_MAP.put("!", 4);
        // 5: ...
        EMOTE_MAP.put("...", 5);
        // 6: an, anger, angry
        EMOTE_MAP.put("an", 6);
        EMOTE_MAP.put("anger", 6);
        EMOTE_MAP.put("angry", 6);
        // 7: note, ho
        EMOTE_MAP.put("note", 7);
        EMOTE_MAP.put("ho", 7);
        // 8: sob, cry, sad
        EMOTE_MAP.put("sob", 8);
        EMOTE_MAP.put("cry", 8);
        EMOTE_MAP.put("sad", 8);
        // 9: spit, rice, hungry
        EMOTE_MAP.put("spit", 9);
        EMOTE_MAP.put("rice", 9);
        EMOTE_MAP.put("hungry", 9);
        // 10: spin, dizzy
        EMOTE_MAP.put("spin", 10);
        EMOTE_MAP.put("dizzy", 10);
        // 11: find, ??
        EMOTE_MAP.put("find", 11);
        EMOTE_MAP.put("??", 11);
        // 12: omg, shock
        EMOTE_MAP.put("omg", 12);
        EMOTE_MAP.put("shock", 12);
        // 13: ok, nod
        EMOTE_MAP.put("ok", 13);
        EMOTE_MAP.put("nod", 13);
        // 14: fsh, flash
        EMOTE_MAP.put("fsh", 14);
        EMOTE_MAP.put("flash", 14);
        // 15: kiss
        EMOTE_MAP.put("kiss", 15);
        // 16: lol, ha, heh
        EMOTE_MAP.put("lol", 16);
        EMOTE_MAP.put("ha", 16);
        EMOTE_MAP.put("heh", 16);
        // 17: gg, giggle
        EMOTE_MAP.put("gg", 17);
        EMOTE_MAP.put("giggle", 17);
        // 18: sigh
        EMOTE_MAP.put("sigh", 18);
        // 19: meh, lick
        EMOTE_MAP.put("meh", 19);
        EMOTE_MAP.put("lick", 19);
        // 20: orz, otl
        EMOTE_MAP.put("orz", 20);
        EMOTE_MAP.put("otl", 20);
        // 21: o, oh, yes
        EMOTE_MAP.put("o", 21);
        EMOTE_MAP.put("oh", 21);
        EMOTE_MAP.put("yes", 21);
        // 22: x, no
        EMOTE_MAP.put("x", 22);
        EMOTE_MAP.put("no", 22);
        // 23: surprised
        EMOTE_MAP.put("surprised", 23);
        // 24: rock, bawi
        EMOTE_MAP.put("rock", 24);
        EMOTE_MAP.put("bawi", 24);
        // 25: paper, bo
        EMOTE_MAP.put("paper", 25);
        EMOTE_MAP.put("bo", 25);
        // 26: scissors, gawi, ya, yeah
        EMOTE_MAP.put("scissors", 26);
        EMOTE_MAP.put("gawi", 26);
        EMOTE_MAP.put("ya", 26);
        EMOTE_MAP.put("yeah", 26);
        // 27: -w-
        EMOTE_MAP.put("-w-", 27);
        // 28: -o-
        EMOTE_MAP.put("-o-", 28);
        // 29: blink, wink
        EMOTE_MAP.put("blink", 29);
        EMOTE_MAP.put("wink", 29);
        // 30: pif
        EMOTE_MAP.put("pif", 30);
        // 31: shy, shine
        EMOTE_MAP.put("shy", 31);
        EMOTE_MAP.put("shine", 31);
        // 32: hmm
        EMOTE_MAP.put("hmm", 32);
        // 33: :p
        EMOTE_MAP.put(":p", 33);
        // 34: lll
        EMOTE_MAP.put("lll", 34);
    }

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        // Main command with optional emote argument
        dispatcher.register(Commands.literal("shipemotes")
                .executes(ctx -> executeList(ctx.getSource()))
                .then(Commands.argument("emote", StringArgumentType.string())
                        .executes(ctx -> executeEmote(ctx.getSource(), StringArgumentType.getString(ctx, "emote")))));

        // Aliases
        for (String alias : new String[]{"em", "emo", "emote", "emotes"}) {
            dispatcher.register(Commands.literal(alias)
                    .executes(ctx -> executeList(ctx.getSource()))
                    .then(Commands.argument("emote", StringArgumentType.string())
                            .executes(
                                    ctx -> executeEmote(ctx.getSource(), StringArgumentType.getString(ctx, "emote")))));
        }
    }

    private static int executeList(CommandSourceStack source) {
        StringBuilder sb = new StringBuilder("[ShinColle] Available emotes: ");
        // Build a list of unique emote names grouped by ID
        Map<Integer, StringBuilder> idToNames = new java.util.TreeMap<>();
        for (Map.Entry<String, Integer> entry : EMOTE_MAP.entrySet()) {
            idToNames.computeIfAbsent(entry.getValue(), k -> new StringBuilder())
                    .append(entry.getKey()).append("/");
        }
        for (Map.Entry<Integer, StringBuilder> entry : idToNames.entrySet()) {
            String names = entry.getValue().toString();
            if (names.endsWith("/"))
                names = names.substring(0, names.length() - 1);
            sb.append(entry.getKey()).append("=").append(names).append(", ");
        }

        source.sendSuccess(() -> Component.literal(sb.toString()), false);
        return 1;
    }

    private static int executeEmote(CommandSourceStack source, String emoteName) {
        // Try to parse as integer ID first
        Integer emoteId = null;
        try {
            int id = Integer.parseInt(emoteName);
            if (id >= 0 && id <= 34) {
                emoteId = id;
            }
        } catch (NumberFormatException ignored) {
            // Not an integer, try name lookup
        }

        // Try name lookup
        if (emoteId == null) {
            emoteId = EMOTE_MAP.get(emoteName.toLowerCase());
        }

        if (emoteId == null) {
            source.sendFailure(Component.literal("[ShinColle] Unknown emote: " + emoteName
                    + ". Use /shipemotes to see available emotes."));
            return 0;
        }

        // Get player for raycast
        ServerPlayer player;
        try {
            player = source.getPlayerOrException();
        } catch (CommandSyntaxException e) {
            source.sendFailure(Component.literal("[ShinColle] This command must be run by a player."));
            return 0;
        }

        // Server-side raycast to find target entity
        Vec3 eyePos = player.getEyePosition();
        Vec3 lookVec = player.getLookAngle();
        double range = 32.0;
        Vec3 endPos = eyePos.add(lookVec.scale(range));
        AABB searchArea = player.getBoundingBox().expandTowards(lookVec.scale(range)).inflate(1.0);
        EntityHitResult result = ProjectileUtil.getEntityHitResult(player, eyePos, endPos, searchArea,
                e -> !e.isSpectator(), range * range);
        Entity target = result != null ? result.getEntity() : null;

        // Check if target is a ship entity (friendly or hostile)
        if (target instanceof BasicEntityShip ship) {
            ship.setStateEmotion(ID.S.Emotion, emoteId, true);
        } else if (target instanceof BasicEntityShipHostile hostileShip) {
            hostileShip.setStateEmotion(ID.S.Emotion, emoteId, true);
        } else {
            source.sendFailure(Component.literal(
                    "[ShinColle] No ship entity found. Look at a ship entity and try again."));
            return 0;
        }

        final int resolvedId = emoteId;
        final String resolvedName = emoteName;
        source.sendSuccess(() -> Component.literal(
                "[ShinColle] Emote '" + resolvedName + "' (ID: " + resolvedId + ") applied to ship."), false);

        return 1;
    }
}
