package com.lulan.shincolle.handler;

import com.lulan.shincolle.reference.Reference;
import com.lulan.shincolle.utility.LogHelper;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Injects ShinColle items into vanilla loot tables (chests, structures).
 *
 * Uses LootTableLoadEvent to add custom loot pools referencing
 * data/shincolle/loot_tables/inject/*.json loot tables.
 *
 * Original system: ConfigLoot.java with file-based CSV config
 * 1.20.1 approach: Data-driven JSON loot tables injected via event
 */
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class LootInjector {

    private static final String[] INJECT_TARGETS = {
            "minecraft:chests/spawn_bonus_chest",
            "minecraft:chests/igloo_chest",
            "minecraft:chests/simple_dungeon",
            "minecraft:chests/village/village_weaponsmith",
            "minecraft:chests/abandoned_mineshaft",
            "minecraft:chests/desert_pyramid",
            "minecraft:chests/jungle_temple",
            "minecraft:chests/nether_bridge",
            "minecraft:chests/stronghold_corridor",
            "minecraft:chests/end_city_treasure",
    };

    private static final String[] INJECT_NAMES = {
            "spawn_bonus",
            "igloo",
            "dungeon",
            "village_blacksmith",
            "mineshaft",
            "pyramid",
            "jungle_temple",
            "nether_bridge",
            "stronghold",
            "end_city",
    };

    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        ResourceLocation name = event.getName();

        for (int i = 0; i < INJECT_TARGETS.length; i++) {
            if (name.toString().equals(INJECT_TARGETS[i])) {
                ResourceLocation injectTable = new ResourceLocation(
                        Reference.MOD_ID, "inject/" + INJECT_NAMES[i]);

                LootPool pool = LootPool.lootPool()
                        .name(Reference.MOD_ID + "_inject_" + INJECT_NAMES[i])
                        .add(LootTableReference.lootTableReference(injectTable))
                        .build();

                event.getTable().addPool(pool);
                LogHelper.debug("DEBUG: injected loot pool into " + name);
                break;
            }
        }
    }
}
