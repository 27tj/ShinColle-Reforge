package com.lulan.shincolle.crafting;

import com.lulan.shincolle.init.ModItems;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.utility.CalcHelper;
import com.lulan.shincolle.utility.LogHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Ship roll calculator for shipyard construction.
 * <p>
 * Roll system:
 * 1. rollShipType() - determines ship class via normal distribution
 * 2. getBuildResultShip() - creates spawn egg ItemStack with material NBT
 */
public class ShipCalc {

    /**
     * Roll tables: {shipClassId, materialMean, modifiedMaterialType}
     */
    private static final List<int[]> SHIP_SMALL = new ArrayList<>();
    private static final List<int[]> SHIP_LARGE = new ArrayList<>();

    static {
        // [PORT] 1.10.2 -> 1.20.1: keep legacy build tables (abyss-first construction)
        // Small build (from small shipyard spawn eggs)
        SHIP_SMALL.add(new int[]{ID.ShipClass.DDI, 80, 0});
        SHIP_SMALL.add(new int[]{ID.ShipClass.DDRO, 90, 0});
        SHIP_SMALL.add(new int[]{ID.ShipClass.DDHA, 100, 0});
        SHIP_SMALL.add(new int[]{ID.ShipClass.DDNI, 110, 0});
        SHIP_SMALL.add(new int[]{ID.ShipClass.APWA, 120, 1});
        SHIP_SMALL.add(new int[]{ID.ShipClass.SSKA, 140, 2});
        SHIP_SMALL.add(new int[]{ID.ShipClass.SSYO, 160, 2});
        SHIP_SMALL.add(new int[]{ID.ShipClass.SSSO, 180, 2});
        SHIP_SMALL.add(new int[]{ID.ShipClass.CARI, 200, 2});
        SHIP_SMALL.add(new int[]{ID.ShipClass.CANE, 256, 2});

        // Large build (from large shipyard spawn eggs)
        SHIP_LARGE.add(new int[]{ID.ShipClass.DDHime, 500, 0});
        SHIP_LARGE.add(new int[]{ID.ShipClass.CVWO, 650, 3});
        SHIP_LARGE.add(new int[]{ID.ShipClass.BBTA, 800, 2});
        SHIP_LARGE.add(new int[]{ID.ShipClass.BBRU, 800, 2});
        SHIP_LARGE.add(new int[]{ID.ShipClass.CAHime, 2000, 2});
        SHIP_LARGE.add(new int[]{ID.ShipClass.NorthernHime, 2600, 1});
        SHIP_LARGE.add(new int[]{ID.ShipClass.SSNH, 2600, 2});
        SHIP_LARGE.add(new int[]{ID.ShipClass.IsolatedHime, 2700, 1});
        SHIP_LARGE.add(new int[]{ID.ShipClass.HarbourHime, 2800, 1});
        SHIP_LARGE.add(new int[]{ID.ShipClass.AirfieldHime, 3000, 1});
        SHIP_LARGE.add(new int[]{ID.ShipClass.CVHime, 3000, 3});
        SHIP_LARGE.add(new int[]{ID.ShipClass.SSHime, 3500, 2});
        SHIP_LARGE.add(new int[]{ID.ShipClass.BBRE, 3800, 2});
        SHIP_LARGE.add(new int[]{ID.ShipClass.BBHime, 4600, 2});
        SHIP_LARGE.add(new int[]{ID.ShipClass.MidwayHime, 4800, 1});
        SHIP_LARGE.add(new int[]{ID.ShipClass.CVWD, 5000, 3});
    }

    /**
     * Roll ship type by material amounts.
     *
     * @param buildType 0=small, 1=large
     * @param matAmount material amounts {grudge, abyssium, ammo, polymetal}
     * @return ship class ID
     */
    public static int rollShipType(int buildType, int[] matAmount, RandomSource random) {
        List<int[]> shipList = buildType == 0 ? SHIP_SMALL : SHIP_LARGE;
        int totalMats = matAmount[0] + matAmount[1] + matAmount[2] + matAmount[3];

        Map<Integer, Float> probList = new HashMap<>();

        for (int[] entry : shipList) {
            int meanNew;
            if (entry[2] >= 0 && entry[2] <= 3) {
                meanNew = entry[1] - matAmount[entry[2]];
            } else {
                meanNew = entry[1];
            }

            int meanDist = Mth.abs(totalMats - meanNew);

            // Scale small build to large resolution
            if (buildType == 0) {
                meanDist = (int) (meanDist * 15.625F);
            }

            float prob = CalcHelper.getNormDist(meanDist);
            probList.put(entry[0], prob);
            LogHelper.debug("DEBUG: roll ship type: ID " + entry[0] +
                    " MEAN(ORG) " + entry[1] + " MEAN(NEW) " + meanNew +
                    " MD " + meanDist + " PR " + prob);
        }

        // Weighted roll
        float totalProb = 0F;
        for (float p : probList.values())
            totalProb += p;
        if (totalProb <= 0F)
            return ID.ShipClass.DDI;

        float roll = random.nextFloat() * totalProb;
        float sumProb = 0.0125F;

        for (Map.Entry<Integer, Float> entry : probList.entrySet()) {
            sumProb += entry.getValue();
            if (sumProb > roll) {
                LogHelper.debug("DEBUG: roll ship type: result=" + entry.getKey());
                return entry.getKey();
            }
        }

        return ID.ShipClass.DDI;
    }

    /**
     * Roll a complete ship result: determine type and create spawn egg.
     *
     * @param matAmount material amounts {grudge, abyssium, ammo, polymetal}
     * @param buildType 0=small, 1=large
     * @param random    random source
     * @return spawn egg with rolled ship class in NBT
     */
    public static ItemStack rollShip(int[] matAmount, int buildType, RandomSource random) {
        int shipClass = rollShipType(buildType, matAmount, random);

        ItemStack egg = new ItemStack(ModItems.SHIP_SPAWN_EGG.get());
        CompoundTag tag = new CompoundTag();
        tag.putInt("ShipClass", shipClass);
        tag.putByte("BuildType", (byte) buildType);
        tag.putInt("Grudge", matAmount[0]);
        tag.putInt("Abyssium", matAmount[1]);
        tag.putInt("Ammo", matAmount[2]);
        tag.putInt("Polymetal", matAmount[3]);
        egg.setTag(tag);
        return egg;
    }

    /**
     * Get kaitai (disassembly) items for a ship class.
     * Returns 4 ItemStacks of resources based on ship type.
     */
    public static ItemStack[] getKaitaiItems(int shipClass) {
        RandomSource rand = RandomSource.create();
        ItemStack[] amount = new ItemStack[4];

        // base amounts vary by ship class rarity
        int base;
        if (shipClass <= 0) {
            // special eggs
            base = shipClass == -2 ? 10 : 90;
        } else if (isLargeShip(shipClass)) {
            base = 40;
        } else {
            base = 20;
        }

        amount[0] = new ItemStack(ModItems.GRUDGE.get(), base + rand.nextInt(8));
        amount[1] = new ItemStack(ModItems.ABYSS_METAL.get(), base + rand.nextInt(8));
        amount[2] = new ItemStack(ModItems.AMMO.get(), base + rand.nextInt(8));
        amount[3] = new ItemStack(ModItems.POLYMETAL_NODULE.get(), base + rand.nextInt(8));

        return amount;
    }

    /**
     * Check if ship class is a large ship type
     */
    private static boolean isLargeShip(int shipClass) {
        return switch (shipClass) {
            // Abyssal small ships (destroyers, light cruisers, cruisers, light carrier,
            // transport, subs)
            // Friendly small ships (DD, SS)
            // Friendly light/heavy cruisers (in small construction table)
            // Abyssal destroyers (later additions)
            case ID.ShipClass.DDI, ID.ShipClass.DDRO, ID.ShipClass.DDHA, ID.ShipClass.DDNI, ID.ShipClass.CLHO,
                 ID.ShipClass.CLHE, ID.ShipClass.CLTO, ID.ShipClass.CLTSU, ID.ShipClass.CLTCHI, ID.ShipClass.CARI,
                 ID.ShipClass.CANE, ID.ShipClass.CVLNU, ID.ShipClass.APWA, ID.ShipClass.SSKA, ID.ShipClass.SSYO,
                 ID.ShipClass.SSSO, ID.ShipClass.DDShimakaze, ID.ShipClass.DDAkatsuki, ID.ShipClass.DDHibiki,
                 ID.ShipClass.DDIkazuchi, ID.ShipClass.DDInazuma, ID.ShipClass.SSU511, ID.ShipClass.SSRo500,
                 ID.ShipClass.Raiden, ID.ShipClass.CLTenryuu, ID.ShipClass.CLTatsuta, ID.ShipClass.CAAtago,
                 ID.ShipClass.CATakao, ID.ShipClass.DDNA, ID.ShipClass.DDAH -> false;
            // Everything else is large: BB, CV, CL, CA (friendly), all himes/bosses/demons
            default -> true;
        };
    }
}
