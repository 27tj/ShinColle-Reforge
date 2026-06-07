package com.lulan.shincolle.item;

/**
 * Interface for items that can be fed to ship entities.
 */
public interface IShipFoodItem {
    float getFoodValue(int meta);

    float getSaturationValue(int meta);

    int getSpecialEffect(int meta);
}
