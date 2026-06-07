package com.lulan.shincolle.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

/**
 * Command: /shipcleardrop [range]
 * <p>
 * Clears dropped items (ItemEntity) within the specified range.
 * Requires OP level 2.
 */
public class ShipCmdClearDrop {

    private static final int DEFAULT_RANGE = 128;

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("shipcleardrop")
                .requires(s -> s.hasPermission(2))
                .executes(ctx -> execute(ctx.getSource(), DEFAULT_RANGE))
                .then(Commands.argument("range", IntegerArgumentType.integer(1))
                        .executes(ctx -> execute(ctx.getSource(), IntegerArgumentType.getInteger(ctx, "range")))));
    }

    private static int execute(CommandSourceStack source, int range) {
        ServerLevel level = source.getLevel();
        Vec3 pos = source.getPosition();

        AABB searchArea = new AABB(
                pos.x - range, pos.y - range, pos.z - range,
                pos.x + range, pos.y + range, pos.z + range);

        List<ItemEntity> items = level.getEntitiesOfClass(ItemEntity.class, searchArea);

        int count = items.size();
        for (ItemEntity item : items) {
            item.discard();
        }

        final int cleared = count;
        source.sendSuccess(() -> Component.literal(
                "[ShinColle] Cleared " + cleared + " dropped items in range " + range + "."), false);

        return 1;
    }
}
