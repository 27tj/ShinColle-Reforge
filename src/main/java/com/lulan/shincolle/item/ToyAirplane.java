package com.lulan.shincolle.item;

/**
 * Toy Airplane - food item with high food value for ship entities.
 */
public class ToyAirplane extends BasicItem implements IShipFoodItem {

    public ToyAirplane() {
        super(new Properties());
    }

    @Override
    public float getFoodValue(int meta) {
        return 150.0F;
    }

    @Override
    public float getSaturationValue(int meta) {
        return 1.5F;
    }

    @Override
    public int getSpecialEffect(int meta) {
        return 5;
    }
}
