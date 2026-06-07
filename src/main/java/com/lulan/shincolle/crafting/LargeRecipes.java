package com.lulan.shincolle.crafting;

import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;

/**
 * Machine crafting logic for the Large Shipyard block entity.
 * <p>
 * This is NOT a vanilla recipe system -- it is custom logic used by the
 * Large Shipyard tile entity to determine build results from material inputs.
 * <p>
 * Input slots: 4 material types
 * - grudge (min 100, max 1000)
 * - abyssium (min 100, max 1000)
 * - ammo (min 100, max 1000)
 * - polymetal (min 100, max 1000)
 * <p>
 * totalMats = grudge + abyssium + ammo + polymetal (range 400..4000)
 * <p>
 * Fuel cost: 460800 + 256 * (totalMats - 400)
 * Build time: scales from 9600 ticks (8 min) to 28800 ticks (24 min)
 * <p>
 * Output categories:
 * - Ships (via ShipCalc)
 * - Equipment (via EquipCalc)
 */
public class LargeRecipes {

    /**
     * Minimum per-slot material count
     */
    public static final int MIN_MATERIAL = 100;
    /**
     * Maximum per-slot material count
     */
    public static final int MAX_MATERIAL = 1000;
    /**
     * Minimum total materials (4 slots * 100)
     */
    public static final int MIN_TOTAL = 400;
    /**
     * Maximum total materials (4 slots * 1000)
     */
    public static final int MAX_TOTAL = 4000;

    /**
     * Base fuel cost at minimum material level
     */
    private static final int BASE_FUEL = 460800;
    /**
     * Additional fuel per material unit above minimum
     */
    private static final int FUEL_PER_UNIT = 256;

    /**
     * Minimum build time in ticks (8 minutes)
     */
    private static final int MIN_BUILD_TIME = 9600;
    /**
     * Maximum build time in ticks (24 minutes)
     */
    private static final int MAX_BUILD_TIME = 28800;
    /**
     * Ticks per total material unit
     */
    private static final int TICKS_PER_MAT = 8;

    /**
     * Check whether the given material counts form a valid large build.
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
     * Calculate the build result for the Large Shipyard.
     * Delegates to either ShipCalc or EquipCalc based on build mode.
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
            return ShipCalc.rollShip(matAmount, 1, random);
        } else {
            // Equipment build: roll equip type then specific equipment
            int rollType = EquipCalc.rollEquipType(1, matAmount, random);
            return EquipCalc.rollEquipsOfTheType(rollType, totalMats, 1, random);
        }
    }

    /**
     * Calculate fuel cost for a large build.
     *
     * @param totalMats sum of all 4 material inputs
     * @return fuel cost in grudge fuel units
     */
    public static int calculateFuelCost(int totalMats) {
        return BASE_FUEL + FUEL_PER_UNIT * Math.max(0, totalMats - MIN_TOTAL);
    }

    /**
     * Calculate build time for a large build.
     *
     * @param totalMats sum of all 4 material inputs
     * @return build time in ticks (9600..28800)
     */
    public static int calculateBuildTime(int totalMats) {
        return Math.min(MAX_BUILD_TIME, Math.max(MIN_BUILD_TIME, totalMats * TICKS_PER_MAT));
    }
}
