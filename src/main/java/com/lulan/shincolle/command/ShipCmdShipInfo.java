package com.lulan.shincolle.command;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.reference.ID;
import com.mojang.brigadier.CommandDispatcher;
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

/**
 * Command: /shipinfo
 * <p>
 * Displays detailed information about the ship entity the player is looking at
 * (mouse-over).
 * Available to all players (permission level 0).
 */
public class ShipCmdShipInfo {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("shipinfo")
                .executes(ctx -> execute(ctx.getSource())));
    }

    private static int execute(CommandSourceStack source) {
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

        if (!(target instanceof BasicEntityShip ship)) {
            source.sendFailure(Component.literal(
                    "[ShinColle] No ship entity found. Look at a ship entity and try again."));
            return 0;
        }

        // Gather ship information
        float[] buffed = ship.getAttrs().getAttrsBuffed();
        int shipClass = ship.getShipClass();
        int level = ship.getLevel();
        float hp = ship.getHealth();
        float maxHp = ship.getMaxHealth();
        float atkL = buffed[ID.Attrs.ATK_L];
        float def = buffed[ID.Attrs.DEF];
        float spd = buffed[ID.Attrs.SPD];
        float mov = buffed[ID.Attrs.MOV];
        float hit = buffed[ID.Attrs.HIT];
        String ownerName = ship.ownerName;
        int shipUID = ship.getShipUID();
        int morale = ship.getMorale();
        int ammoLight = ship.getStateMinor(ID.M.NumAmmoLight);
        int ammoHeavy = ship.getStateMinor(ID.M.NumAmmoHeavy);
        int grudge = ship.getStateMinor(ID.M.NumGrudge);

        // Send info as chat messages
        source.sendSuccess(() -> Component.literal(
                "[ShinColle] === Ship Info ==="), false);
        source.sendSuccess(() -> Component.literal(
                "  Class: " + shipClass + " | Level: " + level), false);
        source.sendSuccess(() -> Component.literal(
                "  HP: " + String.format("%.1f", hp) + " / " + String.format("%.1f", maxHp)), false);
        source.sendSuccess(() -> Component.literal(
                "  ATK: " + String.format("%.1f", atkL)
                        + " | DEF: " + String.format("%.2f", def)
                        + " | SPD: " + String.format("%.2f", spd)), false);
        source.sendSuccess(() -> Component.literal(
                "  MOV: " + String.format("%.3f", mov)
                        + " | HIT: " + String.format("%.1f", hit)), false);
        source.sendSuccess(() -> Component.literal(
                "  Owner: " + ownerName + " | Ship UID: " + shipUID), false);
        source.sendSuccess(() -> Component.literal(
                "  Morale: " + morale
                        + " | Ammo(L): " + ammoLight
                        + " | Ammo(H): " + ammoHeavy
                        + " | Grudge: " + grudge), false);

        return 1;
    }
}
