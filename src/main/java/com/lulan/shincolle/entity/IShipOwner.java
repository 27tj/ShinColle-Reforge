package com.lulan.shincolle.entity;

import net.minecraft.world.entity.Entity;

public interface IShipOwner {
    int getPlayerUID();

    void setPlayerUID(int uid);

    Entity getHostEntity();
}
