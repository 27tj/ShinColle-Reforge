package com.lulan.shincolle.entity.other;

import com.lulan.shincolle.entity.BasicEntityAirplane;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.IShipAttackBase;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Takoyaki-style airplane entity.
 * Heavy ammo airplane variant spawned by certain carrier ships.
 * Ported from 1.10.2 EntityAirplaneTakoyaki.
 */
public class EntityAirplaneTakoyaki extends BasicEntityAirplane {

    public EntityAirplaneTakoyaki(EntityType<? extends EntityAirplaneTakoyaki> type, Level level) {
        super(type, level);
    }

    @Override
    public void initAttrs(IShipAttackBase host, Entity target, int scaleLevel, float... par2) {
        if (host instanceof BasicEntityShip ship) {
            float launchY = (float) ship.getY();
            if (par2 != null && par2.length > 0) launchY = par2[0];
            this.initAttrsFromHost(ship, target, scaleLevel, launchY);
            this.numAmmoLight = 0;
            this.numAmmoHeavy = 3;
        }
    }

    @Override
    public boolean useAmmoLight() {
        return false;
    }

    @Override
    public boolean useAmmoHeavy() {
        return true;
    }
}
