package com.lulan.shincolle.item;

import java.util.Map;

/**
 * Interface for items that apply effects on attack.
 */
public interface IShipEffectItem {
    Map<Integer, int[]> getEffectOnAttack(int meta);

    int getMissileType(int meta);

    int getMissileMoveType(int meta);

    int getMissileSpeedLevel(int meta);
}
