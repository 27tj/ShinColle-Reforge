package com.lulan.shincolle.worldgen;

import com.lulan.shincolle.ShinColle;

/**
 * World generation placeholder for ShinColle.
 * <p>
 * In Minecraft 1.20.1 with Forge, world generation is fully data-driven via
 * JSON files.
 * The actual ore and feature generation is defined by the following data pack
 * files:
 *
 * <h3>Polymetallic Ore (all overworld biomes)</h3>
 * <ul>
 * <li>ConfiguredFeature:
 * {@code data/shincolle/worldgen/configured_feature/polymetal_ore.json}</li>
 * <li>PlacedFeature:
 * {@code data/shincolle/worldgen/placed_feature/polymetal_ore.json}</li>
 * <li>BiomeModifier:
 * {@code data/shincolle/forge/biome_modifier/add_polymetal_ore.json}</li>
 * </ul>
 *
 * <h3>Polymetallic Gravel (ocean biomes only)</h3>
 * <ul>
 * <li>ConfiguredFeature:
 * {@code data/shincolle/worldgen/configured_feature/polymetal_gravel.json}</li>
 * <li>PlacedFeature:
 * {@code data/shincolle/worldgen/placed_feature/polymetal_gravel.json}</li>
 * <li>BiomeModifier:
 * {@code data/shincolle/forge/biome_modifier/add_polymetal_gravel.json}</li>
 * </ul>
 * <p>
 * No programmatic registration is required; Forge automatically loads the JSON
 * biome modifiers.
 * This class exists as a code-level entry point for documentation and logging
 * purposes.
 */
public class ModWorldGen {

    /**
     * Initialization hook called during mod common setup.
     * Logs confirmation that the data-driven world generation files are expected to
     * be loaded.
     */
    public static void init() {
        ShinColle.LOGGER.info("ShinColle: World generation configured.");
        ShinColle.LOGGER.info(
                "ShinColle:   - Polymetallic Ore: overworld, Y 3-50, trapezoid distribution, vein size 7, 7 per chunk");
        ShinColle.LOGGER
                .info("ShinColle:   - Polymetallic Gravel: ocean floors, Y -64 to 55, disk radius 2-3, 4 per chunk");
    }
}
