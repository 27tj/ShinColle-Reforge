package com.lulan.shincolle.entity;

import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Large mount base class - supports aircraft attacks.
 * Aircraft counts and attacks are delegated to the host ship.
 */
public abstract class BasicEntityMountLarge extends BasicEntityMount implements IShipAircraftAttack {

    protected BasicEntityMountLarge(EntityType<? extends BasicEntityMountLarge> type, Level level) {
        super(type, level);
    }

    @Override
    public int getNumAircraftLight() {
        if (host != null)
            return host.getStateMinor(ID.M.NumAirLight);
        return 0;
    }

    @Override
    public void setNumAircraftLight(int par1) {
        if (this.host instanceof IShipAircraftAttack) {
            ((IShipAircraftAttack) this.host).setNumAircraftLight(par1);
        }
    }

    @Override
    public int getNumAircraftHeavy() {
        if (host != null)
            return host.getStateMinor(ID.M.NumAirHeavy);
        return 0;
    }

    @Override
    public void setNumAircraftHeavy(int par1) {
        if (this.host instanceof IShipAircraftAttack) {
            ((IShipAircraftAttack) this.host).setNumAircraftHeavy(par1);
        }
    }

    @Override
    public boolean hasAirLight() {
        if (host != null)
            return host.getStateMinor(ID.M.NumAirLight) > 0;
        return false;
    }

    @Override
    public boolean hasAirHeavy() {
        if (host != null)
            return host.getStateMinor(ID.M.NumAirHeavy) > 0;
        return false;
    }

    @Override
    public boolean attackEntityWithAircraft(Entity target) {
        if (host instanceof IShipAircraftAttack) {
            return ((IShipAircraftAttack) host).attackEntityWithAircraft(target);
        }
        return false;
    }

    @Override
    public boolean attackEntityWithHeavyAircraft(Entity target) {
        if (host instanceof IShipAircraftAttack) {
            return ((IShipAircraftAttack) host).attackEntityWithHeavyAircraft(target);
        }
        return false;
    }
}
