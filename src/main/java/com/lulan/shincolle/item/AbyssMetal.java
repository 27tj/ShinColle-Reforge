package com.lulan.shincolle.item;

/**
 * Abyss Metal material item - abyssium and polymetal resource.
 * Meta 0 = Abyssium, Meta 1 = Polymetal
 */
public class AbyssMetal extends BasicItem implements IShipResourceItem, IShipFoodItem {

    public AbyssMetal() {
        super(new Properties());
    }

    @Override
    public float getFoodValue(int meta) {
        return 30.0F;
    }

    @Override
    public float getSaturationValue(int meta) {
        return 0.8F;
    }

    @Override
    public int getSpecialEffect(int meta) {
        if (meta == 1) {
            return 4;
        }
        return 2;
    }

    @Override
    public int[] getResourceValue(int meta) {
        if (meta == 1) {
            return new int[]{0, 0, 0, 1};
        }
        return new int[]{0, 1, 0, 0};
    }
}
