package com.lulan.shincolle.crafting;

import com.lulan.shincolle.init.ModItems;
import com.lulan.shincolle.utility.LogHelper;

import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;

/**
 * Machine crafting logic for the Small Shipyard block entity.
 * <p>
 * This is NOT a vanilla recipe system -- it is custom logic used by the
 * Small Shipyard tile entity to determine build results from material inputs.
 * <p>
 * Input slots: 4 material types
 * - grudge (min 16, max 64)
 * - abyssium (min 16, max 64)
 * - ammo (min 16, max 64)
 * - polymetal (min 16, max 64)
 * <p>
 * totalMats = grudge + abyssium + ammo + polymetal (range 64..256)
 * <p>
 * Fuel cost: 57600 + 2100 * (totalMats - 64)
 * Build time: scales from 1200 ticks (1 min) to 9600 ticks (8 min)
 * <p>
 * Output categories:
 * - If totalMats < 128, higher probability of ammo output
 * - Otherwise, roll from 12 small-build equipment types
 */
public class SmallRecipes {

    /**
     * Minimum per-slot material count
     */
    public static final int MIN_MATERIAL = 16;
    /**
     * Maximum per-slot material count
     */
    public static final int MAX_MATERIAL = 64;
    /**
     * Minimum total materials (4 slots * 16)
     */
    public static final int MIN_TOTAL = 64;
    /**
     * Maximum total materials (4 slots * 64)
     */
    public static final int MAX_TOTAL = 256;

    /**
     * Base fuel cost at minimum material level
     */
    private static final int BASE_FUEL = 57600;
    /**
     * Additional fuel per material unit above minimum
     */
    private static final int FUEL_PER_UNIT = 2100;

    /**
     * Minimum build time in ticks (1 minute)
     */
    private static final int MIN_BUILD_TIME = 1200;
    /**
     * Maximum build time in ticks (8 minutes)
     */
    private static final int MAX_BUILD_TIME = 9600;
    /**
     * Ticks per total material unit
     */
    private static final int TICKS_PER_MAT = 30;

    /**
     * Check whether the given material counts form a valid small build.
     *
     * @param grudge    grudge count
     * @param abyssium  abyssium count
     * @param ammo      ammo count
     * @param polymetal polymetal count
     * @return true if all counts are within [MIN_MATERIAL, MAX_MATERIAL]
     */
    public static boolean isValidInput(int grudge, int abyssium, int ammo, int polymetal) {
        return grudge >= MIN_MATERIAL && grudge <= MAX_MATERIAL
                && abyssium >= MIN_MATERIAL && abyssium <= MAX_MATERIAL
                && ammo >= MIN_MATERIAL && ammo <= MAX_MATERIAL
                && polymetal >= MIN_MATERIAL && polymetal <= MAX_MATERIAL;
    }

    /**
     * Calculate the build result for the Small Shipyard.
     *
     * @param grudge    grudge material count
     * @param abyssium  abyssium material count
     * @param ammo      ammo material count
     * @param polymetal polymetal material count
     * @param buildShip true for ship build, false for equipment build
     * @param random    random source for roll
     * @return resulting ItemStack, or ItemStack.EMPTY if inputs are invalid
     */
    public static ItemStack calculateResult(int grudge, int abyssium, int ammo, int polymetal, boolean buildShip, RandomSource random) {
        if (!isValidInput(grudge, abyssium, ammo, polymetal)) {
            return ItemStack.EMPTY;
        }

        int[] matAmount = {grudge, abyssium, ammo, polymetal};
        int totalMats = grudge + abyssium + ammo + polymetal;

        if (buildShip) {
            // Ship build: roll ship type and create spawn egg
            return ShipCalc.rollShip(matAmount, 0, random);
        }

        // Equipment build path
        // First roll: equipment vs ammo
        // If totalMats < 128, there is a chance to get ammo instead of equipment
        float equipRate = totalMats / 128F;
        if (equipRate > 1F) equipRate = 1F;  // min 50%, max 100%

        float randRate = random.nextFloat();
        LogHelper.debug("DEBUG: equip build roll: rate / random " +
                String.format("%.2f", equipRate) + " " + String.format("%.2f", randRate));

        if (randRate < equipRate) {
            // Equipment path: roll type then specific equipment
            int rollType = EquipCalc.rollEquipType(0, matAmount, random);
            return EquipCalc.rollEquipsOfTheType(rollType, totalMats, 0, random);
        } else {
            // Ammo path: 50% light container (11-21), 50% heavy container (2-3)
            if (random.nextInt(2) == 0) {
                return new ItemStack(ModItems.AMMO.get(), 11 + random.nextInt(11));
            } else {
                return new ItemStack(ModItems.AMMO.get(), 2 + random.nextInt(2));
            }
        }
    }

    /**
     * Calculate fuel cost for a small build.
     *
     * @param totalMats sum of all 4 material inputs
     * @return fuel cost in grudge fuel units
     */
    public static int calculateFuelCost(int totalMats) {
        return BASE_FUEL + FUEL_PER_UNIT * Math.max(0, totalMats - MIN_TOTAL);
    }

    /**
     * Calculate build time for a small build.
     *
     * @param totalMats sum of all 4 material inputs
     * @return build time in ticks (1200..9600)
     */
    public static int calculateBuildTime(int totalMats) {
        return Math.min(MAX_BUILD_TIME, Math.max(MIN_BUILD_TIME, totalMats * TICKS_PER_MAT));
    }
}
