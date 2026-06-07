package com.lulan.shincolle.item;

/**
 * Grudge material item - primary resource for ship entities.
 */
public class Grudge extends BasicItem implements IShipResourceItem, IShipFoodItem {

    public Grudge() {
        super(new Properties());
    }

    @Override
    public float getFoodValue(int meta) {
        return 10.0F;
    }

    @Override
    public float getSaturationValue(int meta) {
        return 0.5F;
    }

    @Override
    public int getSpecialEffect(int meta) {
        return 1;
    }

    @Override
    public int[] getResourceValue(int meta) {
        return new int[]{1, 0, 0, 0};
    }
}
