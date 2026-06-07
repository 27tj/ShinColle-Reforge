package com.lulan.shincolle.entity.other;

import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;

/**
 * Rensouhou S variant (larger turret).
 * Larger model, inherits all behavior from EntityRensouhou.
 * Ported from 1.10.2 EntityRensouhouS.
 */
public class EntityRensouhouS extends EntityRensouhou {

    public EntityRensouhouS(EntityType<? extends EntityRensouhouS> type, Level level) {
        super(type, level);
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return EntityDimensions.fixed(0.5F, 1.4F);
    }
}
