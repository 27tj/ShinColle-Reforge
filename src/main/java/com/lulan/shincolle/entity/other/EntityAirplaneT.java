package com.lulan.shincolle.entity.other;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Takoyaki airplane variant (T).
 * Heavy ammo variant, inherits all behavior from EntityAirplaneTakoyaki.
 * Ported from 1.10.2 EntityAirplaneT.
 */
public class EntityAirplaneT extends EntityAirplaneTakoyaki {

    public EntityAirplaneT(EntityType<? extends EntityAirplaneT> type, Level level) {
        super(type, level);
    }
}
