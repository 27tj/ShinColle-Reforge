package com.lulan.shincolle.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;

public interface IShipGuardian extends IShipAttackBase {
    Entity getGuardedEntity();

    void setGuardedEntity(Entity entity);

    int getGuardedPos(int vec);

    void setGuardedPos(int x, int y, int z, int dim, int type);

    BlockPos getLastWaypoint();

    void setLastWaypoint(BlockPos pos);

    int getWpStayTime();

    void setWpStayTime(int time);

    int getWpStayTimeMax();
}
