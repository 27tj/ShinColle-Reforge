package com.lulan.shincolle.entity;

import net.minecraft.world.entity.Entity;

public interface IShipAircraftAttack extends IShipAttackBase {
    int getNumAircraftLight();

    void setNumAircraftLight(int par1);

    int getNumAircraftHeavy();

    void setNumAircraftHeavy(int par1);

    boolean hasAirLight();

    boolean hasAirHeavy();

    boolean attackEntityWithAircraft(Entity target);

    boolean attackEntityWithHeavyAircraft(Entity target);
}
