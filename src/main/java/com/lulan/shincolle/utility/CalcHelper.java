package com.lulan.shincolle.utility;

import com.lulan.shincolle.reference.Values;
import net.minecraft.util.Mth;

import java.util.List;
import java.util.Set;

/**
 * Math and calculation helper utilities.
 */
public class CalcHelper {
    private static final int NORM_TABLE_SIZE = 2000;
    /**
     * Pre-computed normal distribution table (half curve).
     * Index = distance from mean (0 = at mean, 1999 = far from mean).
     * Computed as: normalDist(0.5 - i*0.00025, mean=0.5, sd=0.2) * 0.50132566
     * Minimum clamped to NORM_MIN.
     */
    public static final float[] NORM_TABLE = new float[NORM_TABLE_SIZE];
    private static final float NORM_MEAN = 0.5F;
    private static final float NORM_SD = 0.2F;
    private static final float NORM_STEP = 0.00025F;
    private static final float NORM_SCALE = 0.50132566F;
    private static final float NORM_MIN = 0.2F;

    static {
        for (int i = 0; i < NORM_TABLE_SIZE; i++) {
            NORM_TABLE[i] = calcNormalDist(NORM_MEAN - i * NORM_STEP, NORM_MEAN, NORM_SD) * NORM_SCALE;
            if (NORM_TABLE[i] < NORM_MIN)
                NORM_TABLE[i] = NORM_MIN;
        }
    }

    /**
     * Calculate normal distribution probability density.
     * f(x) = 1 / (s * sqrt(2*PI)) * exp(-(x-m)^2 / (2*s^2))
     */
    public static float calcNormalDist(float x, float mean, float sd) {
        float s1 = 2.5066283F; // sqrt(2*pi)
        float s2 = 1F / (sd * s1);
        float s3 = x - mean;
        float s4 = -(s3 * s3);
        float s5 = 2 * sd * sd;
        float s6 = (float) Math.exp(s4 / s5);
        return s2 * s6;
    }

    /**
     * Look up normal distribution probability by distance from mean.
     *
     * @param x distance from mean (0-1999), clamped to NORM_MIN outside range
     */
    public static float getNormDist(int x) {
        if (x >= 0 && x < NORM_TABLE_SIZE) {
            return NORM_TABLE[x];
        }
        return NORM_MIN;
    }

    /**
     * Rotate point (z, x) around origin by angle rad.
     * Returns float[2] = {newZ, newX}.
     */
    public static float[] rotateXZByAxis(float z, float x, float rad, float scale) {
        float cosD = Mth.cos(rad);
        float sinD = Mth.sin(rad);
        float[] newPos = new float[2];
        newPos[0] = (z * cosD - x * sinD) * scale;
        newPos[1] = (z * sinD + x * cosD) * scale;
        return newPos;
    }

    /**
     * Calculate look yaw and pitch from XYZ motion vector.
     * Returns float[2] = {yaw, pitch} in radians (or degrees if getDegree=true).
     */
    public static float[] getLookDegree(double motX, double motY, double motZ, boolean getDegree) {
        // normalize
        double d1 = Math.sqrt(motX * motX + motY * motY + motZ * motZ);

        if (d1 > 1.0E-4D) {
            motX /= d1;
            motY /= d1;
            motZ /= d1;
        }

        // calculate angles (RAD, not DEG)
        double f1 = Math.sqrt(motX * motX + motZ * motZ);
        float[] degree = new float[2];

        degree[1] = -(float) (Math.atan2(motY, f1));
        degree[0] = -(float) (Math.atan2(motX, motZ));

        if (getDegree) {
            // convert to degree value
            degree[0] *= Values.N.DIV_180_PI;
            degree[1] *= Values.N.DIV_180_PI;
        }

        return degree;
    }

    /**
     * Rotate point (x, y, z) by yaw and pitch angles.
     * First rotates by pitch, then by yaw, then scales.
     * Returns float[3] = {newX, newY, newZ}.
     */
    public static float[] rotateXYZByYawPitch(float x, float y, float z, float yaw, float pitch, float scale) {
        float cosYaw = Mth.cos(yaw);
        float sinYaw = Mth.sin(yaw);
        float cosPitch = Mth.cos(-pitch);
        float sinPitch = Mth.sin(-pitch);
        float[] newPos = new float[]{x, y, z};

        // rotate pitch
        newPos[1] = y * cosPitch + z * sinPitch;
        newPos[2] = z * cosPitch - y * sinPitch;

        // rotate yaw
        float x2 = newPos[0];
        float z2 = newPos[2];
        newPos[0] = x2 * cosYaw - z2 * sinYaw;
        newPos[2] = z2 * cosYaw + x2 * sinYaw;

        // apply scale
        newPos[0] *= scale;
        newPos[1] *= scale;
        newPos[2] *= scale;

        return newPos;
    }

    /**
     * Convert integer list to int array.
     */
    public static int[] intListToArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * Check int value is NOT in the given array.
     * Returns true if the value is not found.
     */
    public static boolean checkIntNotInArray(int value, int[] array) {
        if (array == null)
            return true;
        for (int a : array) {
            if (a == value)
                return false;
        }
        return true;
    }

    /**
     * Convert integer set to int array.
     */
    public static int[] intSetToArray(Set<Integer> set) {
        int[] result = new int[set.size()];
        int i = 0;
        for (int v : set) {
            result[i++] = v;
        }
        return result;
    }

    /**
     * Get distance vector from entity A to entity B.
     * Returns Dist4d with normalized direction and distance.
     */
    public static com.lulan.shincolle.reference.unitclass.Dist4d getDistanceFromA2B(
            net.minecraft.world.entity.Entity a, net.minecraft.world.entity.Entity b) {
        double dx = b.getX() - a.getX();
        double dy = b.getY() - a.getY();
        double dz = b.getZ() - a.getZ();
        double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);

        return new com.lulan.shincolle.reference.unitclass.Dist4d(dx, dy, dz, dist);
    }
}
