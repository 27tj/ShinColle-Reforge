package com.lulan.shincolle.command;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.reference.ID;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
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
 * Command: /shipattrs <level> [bonusHP] [bonusATK] [bonusDEF] [bonusSPD]
 * [bonusMOV] [bonusHIT]
 * <p>
 * Sets the attributes of the ship entity the player is looking at (mouse-over).
 * Requires OP level 2.
 * <p>
 * Args:
 * level - Ship level (1-150, required)
 * bonusHP - Bonus HP points (0-100, optional)
 * bonusATK - Bonus ATK points (0-100, optional)
 * bonusDEF - Bonus DEF points (0-100, optional)
 * bonusSPD - Bonus SPD points (0-100, optional)
 * bonusMOV - Bonus MOV points (0-100, optional)
 * bonusHIT - Bonus HIT points (0-100, optional)
 */
public class ShipCmdShipAttrs {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("shipattrs")
                .requires(s -> s.hasPermission(2))
                .then(Commands.argument("level", IntegerArgumentType.integer(1, 150))
                        // /shipattrs <level>
                        .executes(ctx -> execute(ctx.getSource(),
                                IntegerArgumentType.getInteger(ctx, "level"),
                                0, 0, 0, 0, 0, 0))
                        .then(Commands.argument("bonusHP", IntegerArgumentType.integer(0, 100))
                                // /shipattrs <level> <bonusHP>
                                .executes(ctx -> execute(ctx.getSource(),
                                        IntegerArgumentType.getInteger(ctx,
                                                "level"),
                                        IntegerArgumentType.getInteger(ctx,
                                                "bonusHP"),
                                        0, 0, 0, 0, 0))
                                .then(Commands.argument("bonusATK",
                                                IntegerArgumentType.integer(0, 100))
                                        // /shipattrs <level> <bonusHP>
                                        // <bonusATK>
                                        .executes(ctx -> execute(
                                                ctx.getSource(),
                                                IntegerArgumentType
                                                        .getInteger(ctx, "level"),
                                                IntegerArgumentType
                                                        .getInteger(ctx, "bonusHP"),
                                                IntegerArgumentType
                                                        .getInteger(ctx, "bonusATK"),
                                                0, 0, 0, 0))
                                        .then(Commands.argument("bonusDEF",
                                                        IntegerArgumentType
                                                                .integer(0, 100))
                                                // /shipattrs <level>
                                                // <bonusHP> <bonusATK>
                                                // <bonusDEF>
                                                .executes(ctx -> execute(
                                                        ctx.getSource(),
                                                        IntegerArgumentType
                                                                .getInteger(ctx, "level"),
                                                        IntegerArgumentType
                                                                .getInteger(ctx, "bonusHP"),
                                                        IntegerArgumentType
                                                                .getInteger(ctx, "bonusATK"),
                                                        IntegerArgumentType
                                                                .getInteger(ctx, "bonusDEF"),
                                                        0, 0,
                                                        0))
                                                .then(Commands.argument(
                                                                "bonusSPD",
                                                                IntegerArgumentType
                                                                        .integer(0, 100))
                                                        // /shipattrs
                                                        // <level>
                                                        // ...
                                                        // <bonusSPD>
                                                        .executes(ctx -> execute(
                                                                ctx.getSource(),
                                                                IntegerArgumentType
                                                                        .getInteger(ctx, "level"),
                                                                IntegerArgumentType
                                                                        .getInteger(ctx, "bonusHP"),
                                                                IntegerArgumentType
                                                                        .getInteger(ctx, "bonusATK"),
                                                                IntegerArgumentType
                                                                        .getInteger(ctx, "bonusDEF"),
                                                                IntegerArgumentType
                                                                        .getInteger(ctx, "bonusSPD"),
                                                                0,
                                                                0))
                                                        .then(Commands.argument(
                                                                        "bonusMOV",
                                                                        IntegerArgumentType
                                                                                .integer(0, 100))
                                                                // /shipattrs
                                                                // <level>
                                                                // ...
                                                                // <bonusMOV>
                                                                .executes(ctx -> execute(
                                                                        ctx.getSource(),
                                                                        IntegerArgumentType
                                                                                .getInteger(ctx, "level"),
                                                                        IntegerArgumentType
                                                                                .getInteger(ctx, "bonusHP"),
                                                                        IntegerArgumentType
                                                                                .getInteger(ctx, "bonusATK"),
                                                                        IntegerArgumentType
                                                                                .getInteger(ctx, "bonusDEF"),
                                                                        IntegerArgumentType
                                                                                .getInteger(ctx, "bonusSPD"),
                                                                        IntegerArgumentType
                                                                                .getInteger(ctx, "bonusMOV"),
                                                                        0))
                                                                .then(Commands.argument(
                                                                                "bonusHIT",
                                                                                IntegerArgumentType
                                                                                        .integer(0, 100))
                                                                        // /shipattrs
                                                                        // <level>
                                                                        // ...
                                                                        // <bonusHIT>
                                                                        .executes(ctx -> execute(
                                                                                ctx.getSource(),
                                                                                IntegerArgumentType
                                                                                        .getInteger(ctx, "level"),
                                                                                IntegerArgumentType
                                                                                        .getInteger(ctx, "bonusHP"),
                                                                                IntegerArgumentType
                                                                                        .getInteger(ctx, "bonusATK"),
                                                                                IntegerArgumentType
                                                                                        .getInteger(ctx, "bonusDEF"),
                                                                                IntegerArgumentType
                                                                                        .getInteger(ctx, "bonusSPD"),
                                                                                IntegerArgumentType
                                                                                        .getInteger(ctx, "bonusMOV"),
                                                                                IntegerArgumentType
                                                                                        .getInteger(ctx, "bonusHIT")))))))))));
    }

    private static int execute(CommandSourceStack source, int level,
                               int bonusHP, int bonusATK, int bonusDEF,
                               int bonusSPD, int bonusMOV, int bonusHIT) {
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

        // Set ship level
        ship.setStateMinor(ID.M.ShipLevel, level);

        // Set bonus attrs
        byte[] bonus = new byte[]{
                (byte) bonusHP, (byte) bonusATK, (byte) bonusDEF,
                (byte) bonusSPD, (byte) bonusMOV, (byte) bonusHIT
        };
        ship.getAttrs().setAttrsBonus(bonus);

        // Recalculate all attributes
        ship.calcShipAttributes(31, true);

        // Recalculate exp requirements
        ship.setExpNext();

        final int shipUID = ship.getShipUID();
        source.sendSuccess(() -> Component.literal(
                        "[ShinColle] Ship (UID: " + shipUID + ") attrs updated. Level: " + level
                                + ", Bonus: HP=" + bonusHP + " ATK=" + bonusATK
                                + " DEF=" + bonusDEF + " SPD=" + bonusSPD
                                + " MOV=" + bonusMOV + " HIT=" + bonusHIT),
                true);

        return 1;
    }
}
