package com.lulan.shincolle.entity.other;

import com.lulan.shincolle.entity.IShipAttackBase;
import com.lulan.shincolle.entity.IShipCustomTexture;
import com.lulan.shincolle.entity.IShipOwner;
import com.lulan.shincolle.entity.IShipProjectile;
import com.lulan.shincolle.utility.CombatHelper;
import com.lulan.shincolle.utility.ParticleHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

/**
 * Beam projectile entity (laser, energy beam, etc.).
 * Implements beam physics: the beam extends from the host entity toward a
 * target
 * direction, damaging entities along its path. The beam persists for a set
 * duration.
 */
public class EntityProjectileBeam extends Entity implements IShipOwner, IShipCustomTexture, IShipProjectile {

    /**
     * Synched beam length for client-side rendering
     */
    private static final EntityDataAccessor<Float> BEAM_LENGTH = SynchedEntityData.defineId(EntityProjectileBeam.class,
            EntityDataSerializers.FLOAT);
    /**
     * Synched beam end tick for rendering fade-out
     */
    private static final EntityDataAccessor<Integer> BEAM_END_TICK = SynchedEntityData
            .defineId(EntityProjectileBeam.class, EntityDataSerializers.INT);
    /**
     * Damage interval in ticks
     */
    private final int damageInterval = 5;
    private int playerUID;
    private int textureID;
    private int projectileType;
    private int beamType;
    /**
     * Host entity that fired this beam
     */
    private LivingEntity hostEntity;
    private IShipAttackBase hostShip;
    /**
     * Beam direction (normalized)
     */
    private double dirX, dirY, dirZ;
    /**
     * Beam damage per tick
     */
    private float beamDamage;
    /**
     * Max beam length in blocks
     */
    private float maxLength = 32.0F;
    /**
     * Beam lifetime in ticks
     */
    private int beamLifetime = 20;

    public EntityProjectileBeam(EntityType<? extends EntityProjectileBeam> type, Level level) {
        super(type, level);
        this.noCulling = true;
    }

    /**
     * Initialize the beam with host, direction, damage, and lifetime.
     *
     * @param host     the entity firing the beam
     * @param dirX     beam direction X (normalized)
     * @param dirY     beam direction Y (normalized)
     * @param dirZ     beam direction Z (normalized)
     * @param damage   damage per hit
     * @param length   max beam length in blocks
     * @param lifetime beam duration in ticks
     */
    public void initBeam(IShipAttackBase host, double dirX, double dirY, double dirZ,
                         float damage, float length, int lifetime) {
        if (host instanceof LivingEntity le) {
            this.hostEntity = le;
            this.setPos(le.getX(), le.getEyeY(), le.getZ());
        }
        this.hostShip = host;
        this.setPlayerUID(host.getPlayerUID());

        double mag = Math.sqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);
        if (mag > 0.001D) {
            this.dirX = dirX / mag;
            this.dirY = dirY / mag;
            this.dirZ = dirZ / mag;
        } else {
            this.dirX = 0;
            this.dirY = 0;
            this.dirZ = 1;
        }

        this.beamDamage = damage;
        this.maxLength = length;
        this.beamLifetime = lifetime;
        this.entityData.set(BEAM_LENGTH, length);
        this.entityData.set(BEAM_END_TICK, this.tickCount + lifetime);
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return EntityDimensions.fixed(0.5F, 0.5F);
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(BEAM_LENGTH, 32.0F);
        this.entityData.define(BEAM_END_TICK, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        compound.putInt("BeamType", this.beamType);
        compound.putFloat("BeamLength", this.maxLength);
        compound.putInt("BeamLifetime", this.beamLifetime);
        compound.putFloat("BeamDamage", this.beamDamage);
        compound.putDouble("DirX", this.dirX);
        compound.putDouble("DirY", this.dirY);
        compound.putDouble("DirZ", this.dirZ);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        this.beamType = compound.getInt("BeamType");
        this.maxLength = compound.getFloat("BeamLength");
        this.beamLifetime = compound.getInt("BeamLifetime");
        this.beamDamage = compound.getFloat("BeamDamage");
        this.dirX = compound.getDouble("DirX");
        this.dirY = compound.getDouble("DirY");
        this.dirZ = compound.getDouble("DirZ");
    }

    @Override
    public void tick() {
        super.tick();

        // server-side beam logic
        if (!this.level().isClientSide()) {
            // discard if host is gone
            if (this.hostEntity == null || !this.hostEntity.isAlive()) {
                this.discard();
                return;
            }

            // update beam origin to follow host's eye position
            this.setPos(this.hostEntity.getX(), this.hostEntity.getEyeY(), this.hostEntity.getZ());

            // lifetime check
            if (this.tickCount > this.beamLifetime) {
                this.discard();
                return;
            }

            // apply damage along the beam path at regular intervals
            if (this.tickCount % this.damageInterval == 0) {
                applyBeamDamage();
            }
        }

        // client-side: update position to follow host
        if (this.level().isClientSide() && this.hostEntity != null) {
            this.setPos(this.hostEntity.getX(), this.hostEntity.getEyeY(), this.hostEntity.getZ());
        }

        if (this.level().isClientSide()) {
            // 2026/04/07・哦itHub Copilot縺ｫ繧医▲縺ｦ遒ｺ隱肴ｸ医∩
            int particleLife = Math.max(1, this.beamLifetime - this.tickCount);
            ParticleHelper.spawnStickyLightningParticle(this, 0F, particleLife, 4);
        }
    }

    /**
     * Apply damage to all entities along the beam path.
     */
    private void applyBeamDamage() {
        Vec3 start = this.position();
        Vec3 end = start.add(this.dirX * this.maxLength, this.dirY * this.maxLength, this.dirZ * this.maxLength);

        // create an AABB that encompasses the entire beam for broad-phase check
        AABB beamBox = new AABB(
                Math.min(start.x, end.x) - 1, Math.min(start.y, end.y) - 1, Math.min(start.z, end.z) - 1,
                Math.max(start.x, end.x) + 1, Math.max(start.y, end.y) + 1, Math.max(start.z, end.z) + 1);

        List<Entity> entities = this.level().getEntities(this, beamBox);

        for (Entity ent : entities) {
            if (!ent.isPickable())
                continue;
            if (ent == this.hostEntity)
                continue;

            // skip same-owner entities
            if (ent instanceof IShipOwner owner) {
                if (this.playerUID > 0 && owner.getPlayerUID() == this.playerUID)
                    continue;
            }

            // check if entity is close to the beam line
            if (isEntityOnBeamPath(ent, start, end)) {
                float dmg = this.beamDamage;

                // apply defense reduction
                dmg = CombatHelper.applyDamageReduceByDEF(dmg, ent);

                // check friendly fire
                if (this.hostEntity != null && CombatHelper.isFriendlyFire(this.hostEntity, ent))
                    continue;

                // deal damage
                if (ent instanceof LivingEntity livingTarget && this.hostEntity != null) {
                    livingTarget.hurt(this.damageSources().mobAttack(this.hostEntity), dmg);
                }
            }
        }
    }

    /**
     * Check if an entity's bounding box intersects with the beam line.
     * Uses point-to-line distance with a tolerance based on entity width.
     */
    private boolean isEntityOnBeamPath(Entity ent, Vec3 start, Vec3 end) {
        Vec3 entPos = ent.position().add(0, ent.getBbHeight() * 0.5, 0);
        Vec3 beamDir = end.subtract(start);
        Vec3 toEntity = entPos.subtract(start);

        double beamLenSq = beamDir.lengthSqr();
        if (beamLenSq < 0.001)
            return false;

        // project entity position onto beam line
        double t = toEntity.dot(beamDir) / beamLenSq;
        t = Math.max(0, Math.min(1, t));

        Vec3 closestPoint = start.add(beamDir.scale(t));
        double distSq = entPos.distanceToSqr(closestPoint);

        // tolerance: entity half-width + beam half-width (0.5 blocks)
        double tolerance = (ent.getBbWidth() * 0.5) + 0.5;
        return distSq <= tolerance * tolerance;
    }

    /**
     * Get the beam length for rendering
     */
    public float getBeamLength() {
        return this.entityData.get(BEAM_LENGTH);
    }

    /**
     * Get the beam end tick for rendering fade-out
     */
    public int getBeamEndTick() {
        return this.entityData.get(BEAM_END_TICK);
    }

    /**
     * Get the beam direction vector
     */
    public Vec3 getBeamDirection() {
        return new Vec3(this.dirX, this.dirY, this.dirZ);
    }

    // ========== IShipOwner ==========

    @Override
    public int getPlayerUID() {
        return this.playerUID;
    }

    @Override
    public void setPlayerUID(int uid) {
        this.playerUID = uid;
    }

    @Override
    public Entity getHostEntity() {
        return this.hostEntity;
    }

    // ========== IShipCustomTexture ==========

    @Override
    public int getTextureID() {
        return this.textureID;
    }

    @Override
    public void setTextureID(int id) {
        this.textureID = id;
    }

    // ========== IShipProjectile ==========

    @Override
    public int getProjectileType() {
        return this.projectileType;
    }

    @Override
    public void setProjectileType(int type) {
        this.projectileType = type;
    }

    // ========== Beam-specific getters/setters ==========

    public int getBeamType() {
        return this.beamType;
    }

    public void setBeamType(int beamType) {
        this.beamType = beamType;
    }
}
