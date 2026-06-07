package com.lulan.shincolle.item;

/**
 * Ammo material item - ammunition resource with type-dependent values.
 * Original meta types:
 * 0 = ammo (resource {0,0,1,0})
 * 1 = ammo container (resource {0,0,9,0})
 * 2 = heavy ammo (resource {0,0,4,0})
 * 3 = heavy ammo container (resource {0,0,36,0})
 */
public class Ammo extends BasicItem implements IShipResourceItem, IShipFoodItem {

    private final int type;

    public Ammo() {
        this(0);
    }

    public Ammo(int type) {
        super(new Properties());
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    @Override
    public float getFoodValue(int meta) {
        return 5.0F;
    }

    @Override
    public float getSaturationValue(int meta) {
        return 0.3F;
    }

    @Override
    public int getSpecialEffect(int meta) {
        return 3;
    }

    @Override
    public int[] getResourceValue(int meta) {
        return switch (this.type) {
            case 1 -> new int[]{0, 0, 9, 0};
            case 2 -> new int[]{0, 0, 4, 0};
            case 3 -> new int[]{0, 0, 36, 0};
            default -> new int[]{0, 0, 1, 0};
        };
    }
}
