package com.lulan.shincolle.server;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

/**
 * Cache data for ship UID → entity mapping.
 * <p>
 * Saved to disk via ShinWorldData for ship backup/recovery.
 * Used for commands, dupe checking, and radar.
 */
public class CacheDataShip {

    public int entityID;
    public ResourceKey<Level> dimension;
    public int classID;
    public boolean isDead;
    public int posX;
    public int posY;
    public int posZ;
    public CompoundTag entityNBT;

    public CacheDataShip(int eid, ResourceKey<Level> dimension, int cid, boolean isDead,
                         double posX, double posY, double posZ, CompoundTag nbt) {
        this.entityID = eid;
        this.dimension = dimension;
        this.classID = cid;
        this.isDead = isDead;
        this.posX = (int) posX;
        this.posY = (int) posY;
        this.posZ = (int) posZ;
        this.entityNBT = nbt;
    }
}
