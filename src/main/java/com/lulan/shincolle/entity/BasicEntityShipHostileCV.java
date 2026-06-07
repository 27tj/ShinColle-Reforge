package com.lulan.shincolle.entity;

import com.lulan.shincolle.entity.other.EntityAirplaneTMob;
import com.lulan.shincolle.entity.other.EntityAirplaneZeroMob;
import com.lulan.shincolle.init.ModEntities;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Base class for hostile carrier-type ships with aircraft attacks.
 * Extends BasicEntityShipHostile and adds IShipAircraftAttack.
 * Spawns hostile airplane variants (ZeroMob, TMob).
 * <p>
 * Ported from 1.10.2 BasicEntityShipHostileCV.
 */
public abstract class BasicEntityShipHostileCV extends BasicEntityShipHostile implements IShipAircraftAttack {

    protected int numAircraftLight = 0;
    protected int numAircraftHeavy = 0;
    protected double launchHeight = 2.0D;

    protected BasicEntityShipHostileCV(EntityType<? extends BasicEntityShipHostileCV> type, Level level) {
        super(type, level);
    }

    // ========== Aircraft Count ==========

    @Override
    public int getNumAircraftLight() {
        return numAircraftLight;
    }

    @Override
    public void setNumAircraftLight(int par1) {
        this.numAircraftLight = par1;
    }

    @Override
    public int getNumAircraftHeavy() {
        return numAircraftHeavy;
    }

    @Override
    public void setNumAircraftHeavy(int par1) {
        this.numAircraftHeavy = par1;
    }

    @Override
    public boolean hasAirLight() {
        return numAircraftLight > 0;
    }

    @Override
    public boolean hasAirHeavy() {
        return numAircraftHeavy > 0;
    }

    public double getLaunchHeight() {
        return this.launchHeight;
    }

    // ========== Airplane Factory ==========

    /**
     * Create a hostile airplane entity for attacking.
     * Subclasses can override to change airplane types.
     */
    protected BasicEntityAirplane getAttackAirplane(boolean isLight) {
        if (isLight) {
            return new EntityAirplaneZeroMob(ModEntities.AIRPLANE_ZERO_MOB.get(), this.level());
        } else {
            return new EntityAirplaneTMob(ModEntities.AIRPLANE_T_MOB.get(), this.level());
        }
    }

    // ========== Light Aircraft Attack ==========

    @Override
    public boolean attackEntityWithAircraft(Entity target) {
        // check aircraft and ammo
        if (this.getNumAircraftLight() <= 0
                || !decrAmmoNum(0, 6 * this.getAmmoConsumption())) {
            return false;
        }

        // 50% chance to clear target
        if (this.random.nextInt(2) == 0) {
            this.setEntityTarget(null);
        }

        // consume aircraft slot
        this.setNumAircraftLight(this.getNumAircraftLight() - 1);

        // grudge and morale
        decrGrudgeNum(4);
        decrMorale(3);
        setCombatTick(this.tickCount);

        // launch position
        float summonHeight = (float) (this.getY() + launchHeight);

        if (!level().getBlockState(
                new net.minecraft.core.BlockPos(
                        (int) this.getX(),
                        (int) (this.getY() + launchHeight),
                        (int) this.getZ())).isAir()) {
            summonHeight = (float) this.getY() + 1F;
        }

        if (this.getVehicle() instanceof BasicEntityMount) {
            summonHeight -= 1.5F;
        }

        // spawn airplane
        BasicEntityAirplane plane = getAttackAirplane(true);
        plane.initAttrs(this, target, 0, summonHeight);
        this.level().addFreshEntity(plane);

        applySoundAtAttacker(3, target);
        applyEmotesReaction(3);

        return true;
    }

    // ========== Heavy Aircraft Attack ==========

    @Override
    public boolean attackEntityWithHeavyAircraft(Entity target) {
        if (this.getNumAircraftHeavy() <= 0
                || !decrAmmoNum(1, 2 * this.getAmmoConsumption())) {
            return false;
        }

        if (this.random.nextInt(2) == 0) {
            this.setEntityTarget(null);
        }

        this.setNumAircraftHeavy(this.getNumAircraftHeavy() - 1);

        decrGrudgeNum(6);
        decrMorale(4);
        setCombatTick(this.tickCount);

        float summonHeight = (float) (this.getY() + launchHeight);

        if (!level().getBlockState(
                new net.minecraft.core.BlockPos(
                        (int) this.getX(),
                        (int) (this.getY() + launchHeight),
                        (int) this.getZ())).isAir()) {
            summonHeight = (float) this.getY() + 0.5F;
        }

        if (this.getVehicle() instanceof BasicEntityMount) {
            summonHeight -= 1.5F;
        }

        BasicEntityAirplane plane = getAttackAirplane(false);
        plane.initAttrs(this, target, 0, summonHeight);
        this.level().addFreshEntity(plane);

        applySoundAtAttacker(4, target);
        applyEmotesReaction(3);

        return true;
    }
}
