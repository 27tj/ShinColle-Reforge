package com.lulan.shincolle.entity.other;

import com.lulan.shincolle.entity.BasicEntityAirplane;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.IShipAttackBase;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Light ammo airplane entity variant.
 * Spawned by carrier-type ships for light aircraft attacks.
 * Ported from 1.10.2 EntityAirplane.
 */
public class EntityAirplane extends BasicEntityAirplane {

    public EntityAirplane(EntityType<? extends EntityAirplane> type, Level level) {
        super(type, level);
    }

    @Override
    public void initAttrs(IShipAttackBase host, Entity target, int scaleLevel, float... par2) {
        if (host instanceof BasicEntityShip ship) {
            float launchY = (float) ship.getY();
            if (par2 != null && par2.length > 0) launchY = par2[0];
            this.initAttrsFromHost(ship, target, scaleLevel, launchY);
            this.numAmmoLight = 9;
            this.numAmmoHeavy = 0;
        }
    }

}
