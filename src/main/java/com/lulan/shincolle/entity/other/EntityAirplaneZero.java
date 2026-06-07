package com.lulan.shincolle.entity.other;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Zero fighter airplane entity.
 * Light+fast variant, inherits all behavior from EntityAirplane.
 * Ported from 1.10.2 EntityAirplaneZero.
 */
public class EntityAirplaneZero extends EntityAirplane {

    public EntityAirplaneZero(EntityType<? extends EntityAirplaneZero> type, Level level) {
        super(type, level);
    }
}
