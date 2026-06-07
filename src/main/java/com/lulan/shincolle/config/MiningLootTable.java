package com.lulan.shincolle.config;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

/**
 * Mining loot table for ship mining AI.
 * <p>
 * When a ship entity performs mining, it rolls from this table
 * to determine what items are produced. The roll depends on:
 * - Dimension (overworld, nether, end)
 * - Ship level
 * - Y-level of the ship
 * - Tool level of equipped pickaxe
 * - Fortune enchantment level
 * <p>
 * Original system: ConfigMining.java with CSV file-based config
 * 1.20.1 approach: Code-based default table with weighted random selection
 */
public class MiningLootTable {

    private static final List<MiningEntry> OVERWORLD_GENERAL = new ArrayList<>();

    // ========== Loot tables by dimension ==========
    private static final List<MiningEntry> NETHER_GENERAL = new ArrayList<>();
    private static final List<MiningEntry> END_GENERAL = new ArrayList<>();

    static {
        // --- Overworld general ---
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:cobblestone", 4000, 1, 4, 1, 256, 0, 0F));
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:granite", 500, 1, 1, 1, 256, 0, 0F));
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:diorite", 500, 1, 1, 1, 256, 0, 0F));
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:andesite", 500, 1, 1, 1, 256, 0, 0F));
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:dirt", 500, 1, 1, 1, 256, 0, 0F));
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:sand", 500, 1, 1, 1, 256, 0, 0F));
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:gravel", 200, 1, 1, 1, 256, 0, 0F));
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:obsidian", 200, 1, 1, 40, 24, 3, 0F));
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:flint", 250, 1, 1, 1, 256, 0, 0F));
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:gunpowder", 400, 1, 1, 40, 64, 0, 0F));
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:bone", 400, 1, 1, 1, 64, 0, 0F));
        // Overworld ores
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:coal", 500, 1, 3, 1, 100, 1, 1.5F));
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:redstone", 500, 1, 3, 20, 15, 2, 1.5F));
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:raw_iron", 350, 1, 2, 1, 64, 2, 1.0F));
        OVERWORLD_GENERAL.add(new MiningEntry("shincolle:abyss_metal", 350, 1, 3, 1, 64, 2, 1.0F));
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:raw_gold", 100, 1, 1, 30, 32, 2, 1.0F));
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:lapis_lazuli", 200, 1, 3, 30, 30, 2, 1.5F));
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:diamond", 50, 1, 1, 60, 16, 3, 1.0F));
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:emerald", 80, 1, 1, 40, 32, 3, 1.0F));
        OVERWORLD_GENERAL.add(new MiningEntry("shincolle:marriage_ring", 25, 1, 1, 1, 16, 3, 0F));
        // Overworld water-themed
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:prismarine_shard", 300, 1, 4, 30, 128, 0, 0F));
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:prismarine_crystals", 100, 1, 3, 60, 128, 2, 1.0F));
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:clay_ball", 300, 1, 4, 30, 128, 0, 0F));
        OVERWORLD_GENERAL.add(new MiningEntry("minecraft:packed_ice", 200, 1, 4, 1, 256, 2, 0F));

        // --- Nether ---
        NETHER_GENERAL.add(new MiningEntry("minecraft:netherrack", 4500, 1, 4, 1, 256, 0, 0F));
        NETHER_GENERAL.add(new MiningEntry("minecraft:nether_bricks", 1000, 1, 1, 1, 256, 0, 0F));
        NETHER_GENERAL.add(new MiningEntry("minecraft:soul_sand", 1000, 1, 1, 1, 256, 0, 0F));
        NETHER_GENERAL.add(new MiningEntry("minecraft:gravel", 1000, 1, 1, 1, 256, 0, 0F));
        NETHER_GENERAL.add(new MiningEntry("minecraft:magma_block", 500, 1, 1, 40, 256, 3, 0F));
        NETHER_GENERAL.add(new MiningEntry("minecraft:flint", 500, 1, 1, 1, 256, 0, 0F));
        NETHER_GENERAL.add(new MiningEntry("shincolle:marriage_ring", 50, 1, 1, 1, 256, 3, 0F));
        // Nether ores
        NETHER_GENERAL.add(new MiningEntry("minecraft:quartz", 1000, 1, 3, 1, 256, 2, 1.5F));
        NETHER_GENERAL.add(new MiningEntry("minecraft:glowstone_dust", 500, 1, 2, 1, 256, 0, 1.0F));
        NETHER_GENERAL.add(new MiningEntry("minecraft:ghast_tear", 50, 1, 1, 90, 256, 3, 1.0F));
        NETHER_GENERAL.add(new MiningEntry("minecraft:blaze_rod", 80, 1, 1, 60, 256, 3, 1.0F));

        // --- End ---
        END_GENERAL.add(new MiningEntry("minecraft:end_stone", 4000, 1, 4, 1, 256, 0, 0F));
        END_GENERAL.add(new MiningEntry("minecraft:ender_pearl", 200, 1, 1, 40, 256, 3, 1.0F));
        END_GENERAL.add(new MiningEntry("minecraft:chorus_fruit", 200, 1, 3, 60, 256, 3, 1.0F));
        END_GENERAL.add(new MiningEntry("shincolle:marriage_ring", 25, 1, 1, 1, 256, 3, 0F));
    }

    /**
     * Get the mining loot table entries for the given dimension.
     *
     * @param dimensionId dimension resource location (e.g. "minecraft:overworld")
     * @return list of mining entries for that dimension
     */
    public static List<MiningEntry> getEntriesForDimension(ResourceLocation dimensionId) {
        String path = dimensionId.getPath();
        if ("the_nether".equals(path)) {
            return NETHER_GENERAL;
        } else if ("the_end".equals(path)) {
            return END_GENERAL;
        } else {
            return OVERWORLD_GENERAL;
        }
    }

    /**
     * Roll a mining result from the table.
     *
     * @param dimensionId  current dimension
     * @param shipLevel    ship entity level
     * @param yLevel       Y coordinate of the ship
     * @param toolLevel    pickaxe tool level (0=wood/gold, 1=stone, 2=iron,
     *                     3=diamond/netherite)
     * @param fortuneLevel fortune enchantment level on pickaxe
     * @param random       random source
     * @return resulting ItemStack, or ItemStack.EMPTY if no valid entry
     */
    public static ItemStack rollMiningDrop(ResourceLocation dimensionId, int shipLevel,
                                           int yLevel, int toolLevel, int fortuneLevel, RandomSource random) {
        List<MiningEntry> entries = getEntriesForDimension(dimensionId);

        // Filter available entries and calculate total weight
        List<MiningEntry> available = new ArrayList<>();
        int totalWeight = 0;

        for (MiningEntry entry : entries) {
            if (entry.isAvailable(shipLevel, yLevel, toolLevel)) {
                available.add(entry);
                totalWeight += entry.weight;
            }
        }

        if (available.isEmpty() || totalWeight <= 0) {
            return ItemStack.EMPTY;
        }

        // Weighted random roll
        int roll = random.nextInt(totalWeight);
        int cumulative = 0;

        for (MiningEntry entry : available) {
            cumulative += entry.weight;
            if (cumulative > roll) {
                return entry.createStack(random, fortuneLevel);
            }
        }

        return ItemStack.EMPTY;
    }

    /**
     * A single mining loot entry
     *
     * @param enchantScale fortune multiplier (0.0 = no bonus)
     */
    public record MiningEntry(String itemId, int weight, int minCount, int maxCount, int minShipLevel, int maxYLevel,
                              int minToolLevel, float enchantScale) {

        /**
         * Check if this entry is available given the current conditions
         */
        public boolean isAvailable(int shipLevel, int yLevel, int toolLevel) {
            return shipLevel >= minShipLevel && yLevel <= maxYLevel && toolLevel >= minToolLevel;
        }

        /**
         * Get the actual stack size accounting for fortune
         */
        public int rollCount(RandomSource random, int fortuneLevel) {
            int base = minCount + (maxCount > minCount ? random.nextInt(maxCount - minCount + 1) : 0);
            if (fortuneLevel > 0 && enchantScale > 0F) {
                base = (int) (base * (1F + enchantScale * fortuneLevel));
            }
            return Math.max(1, base);
        }

        /**
         * Create the ItemStack result
         */
        public ItemStack createStack(RandomSource random, int fortuneLevel) {
            ResourceLocation loc = new ResourceLocation(itemId);
            var item = ForgeRegistries.ITEMS.getValue(loc);
            if (item == null || item == Items.AIR)
                return ItemStack.EMPTY;
            int count = rollCount(random, fortuneLevel);
            return new ItemStack(item, count);
        }
    }
}
