package com.lulan.shincolle.entity.other;

import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.entity.IShipAttackBase;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Zero fighter airplane mob variant (hostile).
 * Spawned by hostile carrier ships via BasicEntityShipHostileCV.
 * Ported from 1.10.2 EntityAirplaneZeroMob.
 */
public class EntityAirplaneZeroMob extends EntityAirplaneZero {

    public EntityAirplaneZeroMob(EntityType<? extends EntityAirplaneZeroMob> type, Level level) {
        super(type, level);
    }

    @Override
    public void initAttrs(IShipAttackBase host, Entity target, int scaleLevel, float... par2) {
        if (host instanceof BasicEntityShipHostile hostile) {
            float launchY = (float) hostile.getY();
            if (par2 != null && par2.length > 0) launchY = par2[0];
            this.initAttrsFromHostile(hostile, target, scaleLevel, launchY);
            this.numAmmoLight = 9;
            this.numAmmoHeavy = 0;
        } else {
            // fallback to friendly ship init
            super.initAttrs(host, target, scaleLevel, par2);
        }
    }
}
