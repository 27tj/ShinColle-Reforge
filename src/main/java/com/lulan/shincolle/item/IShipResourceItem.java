package com.lulan.shincolle.item;

/**
 * Interface for items that provide resources when fed or consumed.
 * Returns int[4] = {grudge, abyssium, ammo, polymetal}
 */
public interface IShipResourceItem {
    int[] getResourceValue(int meta);
}
