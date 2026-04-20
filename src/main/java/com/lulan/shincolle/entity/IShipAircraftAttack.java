package com.lulan.shincolle.entity;

import net.minecraft.world.entity.Entity;

public interface IShipAircraftAttack extends IShipAttackBase {
    int getNumAircraftLight();

    int getNumAircraftHeavy();

    boolean hasAirLight();

    boolean hasAirHeavy();

    void setNumAircraftLight(int par1);

    void setNumAircraftHeavy(int par1);

    boolean attackEntityWithAircraft(Entity target);

    boolean attackEntityWithHeavyAircraft(Entity target);
}
