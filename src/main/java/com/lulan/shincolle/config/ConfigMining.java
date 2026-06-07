package com.lulan.shincolle.config;

import com.lulan.shincolle.utility.LogHelper;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Mining loot table configuration loaded from a CSV file (mining.cfg).
 * <p>
 * Format per line (10 comma-separated fields):
 * dimension, biome, item_name, weight, min_stack, max_stack,
 * ship_level, y_level, tool_level, enchant_weight
 * <p>
 * dimension: "*" for all dimensions, or "overworld", "the_nether", "the_end"
 * biome: "*" for all biomes, or specific biome path like "ocean", "plains"
 * item_name: resource location like "minecraft:cobblestone",
 * "shincolle:abyss_metal"
 * weight: drop probability weight (normalized by total weight)
 * min_stack / max_stack: stack size range (>= 1)
 * ship_level: minimum ship level for this item
 * y_level: maximum Y-level of ship position for this item
 * tool_level: minimum pickaxe tier (0=wood/gold, 1=stone, 2=iron, 3=diamond,
 * 4=netherite)
 * enchant_weight: fortune bonus (actual extra = stack * (enchant_weight/100) *
 * fortune_level)
 * <p>
 * Lines starting with '#' are comments.
 */
public class ConfigMining {

    public static final String GENERAL_DIM = "*";
    public static final String GENERAL_BIOME = "*";
    /**
     * Loot map: dimension key -> (biome key -> entry list)
     */
    private static Map<String, Map<String, List<ItemEntry>>> MINING_MAP = new HashMap<>();
    private static File configFile;

    /**
     * Initialize and load the mining config from the given file.
     */
    public static void load(File file) {
        configFile = file;
        MINING_MAP = new HashMap<>();

        try {
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }

            if (!file.exists()) {
                if (file.createNewFile()) {
                    writeDefault(file);
                } else {
                    LogHelper.info("ERROR: Could not create mining config file: " + file);
                    return;
                }
            }

            List<String> lines = readLines(file);
            parse(lines);
            LogHelper.debug("DEBUG: loaded mining config: " + file + " entries parsed");
        } catch (Exception e) {
            LogHelper.info("ERROR: loading mining config: " + file + " " + e);
        }
    }

    /**
     * Get matching loot entries for the given dimension and biome.
     */
    public static List<ItemEntry> getEntries(String dimension, String biome) {
        List<ItemEntry> result = new ArrayList<>();

        // Add entries from general dimension + general biome
        addEntriesFrom(result, GENERAL_DIM, GENERAL_BIOME);
        // Add entries from general dimension + specific biome
        if (!GENERAL_BIOME.equals(biome)) {
            addEntriesFrom(result, GENERAL_DIM, biome);
        }
        // Add entries from specific dimension + general biome
        if (!GENERAL_DIM.equals(dimension)) {
            addEntriesFrom(result, dimension, GENERAL_BIOME);
            // Add entries from specific dimension + specific biome
            if (!GENERAL_BIOME.equals(biome)) {
                addEntriesFrom(result, dimension, biome);
            }
        }

        return result;
    }

    /**
     * Check if the mining map has been loaded with any entries.
     */
    public static boolean isLoaded() {
        return !MINING_MAP.isEmpty();
    }

    private static void addEntriesFrom(List<ItemEntry> result, String dim, String biome) {
        Map<String, List<ItemEntry>> biomeMap = MINING_MAP.get(dim);
        if (biomeMap != null) {
            List<ItemEntry> entries = biomeMap.get(biome);
            if (entries != null) {
                result.addAll(entries);
            }
        }
    }

    // ========== Internal ==========

    private static void parse(List<String> lines) {
        if (lines == null || lines.isEmpty())
            return;

        for (String str : lines) {
            // Skip comments and blank lines
            if (isComment(str))
                continue;

            str = str.replaceAll("\\s", "");
            String[] parts = str.split(",");

            if (parts.length == 10 && !parts[2].isEmpty()) {
                try {
                    String dim = parts[0];
                    String biome = parts[1];
                    String itemName = parts[2];
                    int weight = Integer.parseInt(parts[3]);
                    int min = Integer.parseInt(parts[4]);
                    int max = Integer.parseInt(parts[5]);
                    int lvShip = Integer.parseInt(parts[6]);
                    int lvHeight = Integer.parseInt(parts[7]);
                    int lvTool = Integer.parseInt(parts[8]);
                    int enchant = Integer.parseInt(parts[9]);

                    if (weight < 1)
                        weight = 1;
                    if (min < 1)
                        min = 1;
                    if (max < 1)
                        max = 1;

                    Map<String, List<ItemEntry>> biomeMap = MINING_MAP.computeIfAbsent(dim, k -> new HashMap<>());
                    List<ItemEntry> entryList = biomeMap.computeIfAbsent(biome, k -> new ArrayList<>());

                    entryList.add(new ItemEntry(itemName, weight, min, max,
                            lvShip, lvHeight, lvTool, enchant));
                } catch (NumberFormatException e) {
                    LogHelper.info("WARN: parse error in mining.cfg: " + str + " " + e);
                }
            }
        }
    }

    private static List<String> readLines(File file) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    private static boolean isComment(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return str.charAt(i) == '#';
            }
        }
        return true; // blank line = skip
    }

    private static void writeDefault(File file) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            for (String line : getDefaultContent()) {
                writer.write(line);
            }
        } catch (IOException e) {
            LogHelper.info("ERROR: writing default mining config: " + e);
        }
    }

    private static List<String> getDefaultContent() {
        String nl = System.lineSeparator();
        List<String> lines = new ArrayList<>();

        lines.add("# Mining Loot Table" + nl);
        lines.add("#" + nl);
        lines.add(
                "# format: dimension, biome, item_name, weight, min_stack, max_stack, ship_level, y_level, tool_level, enchant_weight"
                        + nl);
        lines.add("#" + nl);
        lines.add("# dimension: *=all, overworld, the_nether, the_end" + nl);
        lines.add("# biome: *=all biomes, or specific biome path (e.g. ocean, plains, frozen_ocean)" + nl);
        lines.add("# weight: drop rate, actual rate = weight of this item / total weight of all matched items" + nl);
        lines.add("# ship_level: ship minimal level for this item" + nl);
        lines.add("# y_level: highest y level of ship position for this item" + nl);
        lines.add("# tool_level: minimal pickaxe tier, 0=wood/gold, 1=stone, 2=iron, 3=diamond, 4=netherite" + nl);
        lines.add(
                "# enchant_weight: fortune bonus, actual stack size = stack * (1 + (enchant_weight/100) * fortune_level)"
                        + nl);
        lines.add("#" + nl);

        // general (all dimensions)
        lines.add("*,*,minecraft:cobblestone,100,1,4,1,256,0,0" + nl);

        // overworld general
        lines.add("overworld,*,minecraft:cobblestone,4000,1,4,1,256,0,0" + nl);
        lines.add("overworld,*,minecraft:granite,500,1,1,1,256,0,0" + nl);
        lines.add("overworld,*,minecraft:diorite,500,1,1,1,256,0,0" + nl);
        lines.add("overworld,*,minecraft:andesite,500,1,1,1,256,0,0" + nl);
        lines.add("overworld,*,minecraft:dirt,500,1,1,1,256,0,0" + nl);
        lines.add("overworld,*,minecraft:sand,500,1,1,1,256,0,0" + nl);
        lines.add("overworld,*,minecraft:gravel,200,1,1,1,256,0,0" + nl);
        lines.add("overworld,*,minecraft:obsidian,200,1,1,40,24,3,0" + nl);
        lines.add("overworld,*,minecraft:flint,250,1,1,1,256,0,0" + nl);
        lines.add("overworld,*,minecraft:gunpowder,400,1,1,40,64,0,0" + nl);
        lines.add("overworld,*,minecraft:bone,400,1,1,1,64,0,0" + nl);

        // overworld ores
        lines.add("overworld,*,minecraft:coal,500,1,3,1,100,1,150" + nl);
        lines.add("overworld,*,minecraft:redstone,500,1,3,20,15,2,150" + nl);
        lines.add("overworld,*,minecraft:raw_iron,350,1,2,1,64,2,100" + nl);
        lines.add("overworld,*,shincolle:abyss_metal,350,1,3,1,64,2,100" + nl);
        lines.add("overworld,*,minecraft:raw_copper,300,1,3,1,96,1,100" + nl);
        lines.add("overworld,*,minecraft:raw_gold,100,1,1,30,32,2,100" + nl);
        lines.add("overworld,*,minecraft:lapis_lazuli,200,1,3,30,30,2,150" + nl);
        lines.add("overworld,*,minecraft:diamond,50,1,1,60,16,3,100" + nl);
        lines.add("overworld,*,minecraft:emerald,80,1,1,40,32,3,100" + nl);
        lines.add("overworld,*,shincolle:marriage_ring,25,1,1,1,16,3,0" + nl);

        // overworld ocean biomes
        lines.add("overworld,ocean,minecraft:prismarine_shard,500,1,4,30,128,0,0" + nl);
        lines.add("overworld,ocean,minecraft:prismarine_crystals,200,1,3,60,128,2,100" + nl);
        lines.add("overworld,ocean,shincolle:abyss_metal,500,1,3,1,64,2,100" + nl);
        lines.add("overworld,ocean,minecraft:sponge,200,1,1,80,128,0,100" + nl);
        lines.add("overworld,deep_ocean,minecraft:prismarine_shard,500,1,4,30,128,0,0" + nl);
        lines.add("overworld,deep_ocean,minecraft:prismarine_crystals,200,1,3,60,128,2,100" + nl);
        lines.add("overworld,deep_ocean,shincolle:abyss_metal,500,1,3,1,64,2,100" + nl);
        lines.add("overworld,deep_ocean,minecraft:sponge,200,1,1,80,128,0,100" + nl);

        // overworld cold/snowy biomes
        lines.add("overworld,frozen_ocean,minecraft:packed_ice,1000,1,4,1,256,2,0" + nl);
        lines.add("overworld,frozen_river,minecraft:packed_ice,1000,1,4,1,256,2,0" + nl);
        lines.add("overworld,snowy_plains,minecraft:packed_ice,1000,1,4,1,256,2,0" + nl);
        lines.add("overworld,snowy_taiga,minecraft:packed_ice,1000,1,4,1,256,2,0" + nl);
        lines.add("overworld,ice_spikes,minecraft:packed_ice,1000,1,4,1,256,2,0" + nl);

        // overworld mushroom biome
        lines.add("overworld,mushroom_fields,minecraft:clay_ball,500,1,4,30,128,0,0" + nl);
        lines.add("overworld,mushroom_fields,minecraft:mycelium,500,1,1,50,128,0,0" + nl);

        // overworld swamp biome
        lines.add("overworld,swamp,minecraft:clay_ball,500,1,4,30,128,0,0" + nl);

        // nether
        lines.add("the_nether,*,minecraft:netherrack,4500,1,4,1,256,0,0" + nl);
        lines.add("the_nether,*,minecraft:nether_bricks,1000,1,1,1,256,0,0" + nl);
        lines.add("the_nether,*,minecraft:soul_sand,1000,1,1,1,256,0,0" + nl);
        lines.add("the_nether,*,minecraft:gravel,1000,1,1,1,256,0,0" + nl);
        lines.add("the_nether,*,minecraft:magma_block,500,1,1,40,256,3,0" + nl);
        lines.add("the_nether,*,minecraft:flint,500,1,1,1,256,0,0" + nl);
        lines.add("the_nether,*,shincolle:marriage_ring,50,1,1,1,256,3,0" + nl);

        // nether ores
        lines.add("the_nether,*,minecraft:quartz,1000,1,3,1,256,2,150" + nl);
        lines.add("the_nether,*,minecraft:glowstone_dust,500,1,2,1,256,0,100" + nl);
        lines.add("the_nether,*,minecraft:ghast_tear,50,1,1,90,256,3,100" + nl);
        lines.add("the_nether,*,minecraft:blaze_rod,80,1,1,60,256,3,100" + nl);
        lines.add("the_nether,*,minecraft:gold_nugget,300,1,4,1,256,1,100" + nl);

        // end
        lines.add("the_end,*,minecraft:end_stone,4000,1,4,1,256,0,0" + nl);
        lines.add("the_end,*,minecraft:ender_pearl,200,1,1,40,256,3,100" + nl);
        lines.add("the_end,*,minecraft:chorus_fruit,200,1,3,60,256,3,100" + nl);
        lines.add("the_end,*,shincolle:marriage_ring,25,1,1,1,256,3,0" + nl);

        return lines;
    }

    /**
     * Loot entry data
     */
    public record ItemEntry(String itemName, int weight, int min, int max, int lvShip, int lvHeight, int lvTool,
                            float enchant) {
        public ItemEntry(String itemName, int weight, int min, int max,
                         int lvShip, int lvHeight, int lvTool, int enchant) {
            this(itemName, weight, min, max, lvShip, lvHeight, lvTool, enchant * 0.01F);
        }
    }
}
