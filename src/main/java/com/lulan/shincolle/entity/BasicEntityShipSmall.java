package com.lulan.shincolle.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Small ship base class.
 * Thin marker class that extends BasicEntityShip.
 */
public abstract class BasicEntityShipSmall extends BasicEntityShip {

    protected BasicEntityShipSmall(EntityType<? extends BasicEntityShipSmall> type, Level level) {
        super(type, level);
    }
}
