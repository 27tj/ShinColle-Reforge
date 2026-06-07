package com.lulan.shincolle.item;

/**
 * Interface for combat ration items with morale bonus.
 */
public interface IShipCombatRation extends IShipFoodItem {
    int getMoraleValue(int meta);
}
