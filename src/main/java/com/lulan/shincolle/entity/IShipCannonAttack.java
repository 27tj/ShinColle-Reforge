package com.lulan.shincolle.entity;

import net.minecraft.world.entity.Entity;

public interface IShipCannonAttack extends IShipAttackBase {
    boolean attackEntityWithAmmo(Entity target);

    boolean attackEntityWithHeavyAmmo(Entity target);

    boolean useAmmoLight();

    boolean useAmmoHeavy();
}
