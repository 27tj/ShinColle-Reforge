package com.lulan.shincolle.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Custom sound rate configuration.
 * <p>
 * Maps ship class ID to an array of sound play rates (0.0 ~ 1.0).
 * Rate indices: 0:idle, 1:attack, 2:hurt, 3:dead, 4:marry, 5:knockback, 6:item,
 * 7:feed, 8:timekeep
 * <p>
 * For each value: 0.7 = 70% play custom sound, 30% play general sound.
 * If rate is 0 or no entry exists, only general sound is played.
 */
public class ConfigSound {

    /**
     * Custom sound rates: map(shipClassID -> float[9] rates)
     */
    public static final Map<Integer, float[]> SOUND_RATE = new HashMap<>();

    static {
        // Default custom sound rates (from original config)
        SOUND_RATE.put(54, new float[]{0.25F, 0F, 0.25F, 0F, 0.50F, 0F, 0.50F, 0F, 0F});
        SOUND_RATE.put(56, new float[]{0.50F, 0.50F, 0.50F, 1.0F, 0F, 0F, 0.50F, 0F, 0F});
        SOUND_RATE.put(60, new float[]{0.25F, 0.50F, 0F, 0F, 0F, 0F, 0F, 0F, 0F});
        SOUND_RATE.put(62, new float[]{0F, 0.35F, 0F, 0F, 0F, 0F, 0F, 0F, 0F});
    }

    /**
     * Get the custom sound play rate for a specific ship class and sound type.
     *
     * @param shipClass ship class ID
     * @param soundType sound type index (0-8)
     * @return play rate (0.0 ~ 1.0), 0 if no entry exists
     */
    public static float getSoundRate(int shipClass, int soundType) {
        float[] rates = SOUND_RATE.get(shipClass);
        if (rates != null && soundType >= 0 && soundType < rates.length) {
            return rates[soundType];
        }
        return 0F;
    }

    /**
     * Check if a custom sound should play based on its rate.
     *
     * @param shipClass ship class ID
     * @param soundType sound type index (0-8)
     * @return true if custom sound should be played this time
     */
    public static boolean shouldPlayCustomSound(int shipClass, int soundType) {
        float rate = getSoundRate(shipClass, soundType);
        if (rate <= 0F)
            return false;
        if (rate >= 1F)
            return true;
        return Math.random() < rate;
    }
}
