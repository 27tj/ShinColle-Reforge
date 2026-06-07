package com.lulan.shincolle.entity.other;

import com.lulan.shincolle.entity.IShipAttackBase;
import com.lulan.shincolle.entity.IShipCustomTexture;
import com.lulan.shincolle.entity.IShipOwner;
import com.lulan.shincolle.entity.IShipProjectile;
import com.lulan.shincolle.utility.CombatHelper;
import com.lulan.shincolle.utility.ParticleHelper;
import com.lulan.shincolle.utility.TargetHelper;
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
 * Static projectile/effect entity (mines, barriers, etc.).
 * Remains stationary at a position and damages entities that enter its effect
 * radius.
 * Different effect types control behavior:
 * 0: mine - explodes on contact, single use
 * 1: barrier - persistent damage field, lasts for duration
 * 2: trap - slows and damages entities in range
 */
public class EntityProjectileStatic extends Entity implements IShipOwner, IShipCustomTexture, IShipProjectile {

    /**
     * Synched effect radius for client-side rendering
     */
    private static final EntityDataAccessor<Float> EFFECT_RADIUS = SynchedEntityData
            .defineId(EntityProjectileStatic.class, EntityDataSerializers.FLOAT);
    /**
     * Synched active flag for rendering
     */
    private static final EntityDataAccessor<Boolean> IS_ACTIVE = SynchedEntityData
            .defineId(EntityProjectileStatic.class, EntityDataSerializers.BOOLEAN);
    /**
     * Synched lifetime for client particle timing
     */
    private static final EntityDataAccessor<Integer> EFFECT_LIFETIME = SynchedEntityData
            .defineId(EntityProjectileStatic.class, EntityDataSerializers.INT);
    /**
     * Damage interval in ticks
     */
    private final int damageInterval = 20;
    private int playerUID;
    private int textureID;
    private int projectileType;
    private int effectType;
    /**
     * Host entity or ship that placed this effect
     */
    private LivingEntity hostEntity;
    private IShipAttackBase hostShip;
    /**
     * Effect damage per hit
     */
    private float effectDamage;
    /**
     * Effect radius in blocks
     */
    private float effectRadius = 3.0F;
    /**
     * Effect lifetime in ticks
     */
    private int effectLifetime = 200;
    /**
     * Whether this effect has been triggered (for mine type)
     */
    private boolean triggered = false;

    public EntityProjectileStatic(EntityType<? extends EntityProjectileStatic> type, Level level) {
        super(type, level);
        this.noCulling = true;
    }

    /**
     * Initialize the static effect.
     *
     * @param host       the entity that placed this effect
     * @param effectType effect behavior type (0=mine, 1=barrier, 2=trap)
     * @param damage     damage per hit
     * @param radius     effect radius in blocks
     * @param lifetime   effect duration in ticks
     */
    public void initEffect(IShipAttackBase host, int effectType, float damage, float radius, int lifetime) {
        if (host instanceof LivingEntity le) {
            this.hostEntity = le;
        }
        this.hostShip = host;
        this.setPlayerUID(host.getPlayerUID());
        this.effectType = effectType;
        this.effectDamage = damage;
        this.effectRadius = radius;
        this.effectLifetime = lifetime;
        this.entityData.set(EFFECT_RADIUS, radius);
        this.entityData.set(IS_ACTIVE, true);
        this.entityData.set(EFFECT_LIFETIME, lifetime);
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return EntityDimensions.fixed(0.5F, 0.5F);
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(EFFECT_RADIUS, 3.0F);
        this.entityData.define(IS_ACTIVE, true);
        this.entityData.define(EFFECT_LIFETIME, 200);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        compound.putInt("EffectType", this.effectType);
        compound.putFloat("EffectDamage", this.effectDamage);
        compound.putFloat("EffectRadius", this.effectRadius);
        compound.putInt("EffectLifetime", this.effectLifetime);
        compound.putBoolean("Triggered", this.triggered);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        this.effectType = compound.getInt("EffectType");
        this.effectDamage = compound.getFloat("EffectDamage");
        this.effectRadius = compound.getFloat("EffectRadius");
        this.effectLifetime = compound.getInt("EffectLifetime");
        this.triggered = compound.getBoolean("Triggered");
        this.entityData.set(EFFECT_RADIUS, this.effectRadius);
        this.entityData.set(EFFECT_LIFETIME, this.effectLifetime);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            if (this.tickCount == 1) {
                this.effectLifetime = this.entityData.get(EFFECT_LIFETIME);
                // 2026/04/07・哦itHub Copilot縺ｫ繧医▲縺ｦ遒ｺ隱肴ｸ医∩
                ParticleHelper.spawnSphereLightParticle(this, 5, (float) this.effectLifetime, this.effectRadius * 2F);
            }
            return;
        }

        // server-side effect logic
        // lifetime check
        if (this.tickCount > this.effectLifetime) {
            this.discard();
            return;
        }

        // apply effect based on type
        switch (this.effectType) {
            case 0: // mine - explodes on first contact
                if (!this.triggered && this.tickCount > 10) {
                    applyMineDamage();
                }
                break;
            case 1: // barrier - persistent damage field
                if (this.tickCount % this.damageInterval == 0) {
                    applyAreaDamage();
                }
                break;
            case 2: // trap - slow + damage
                if (this.tickCount % this.damageInterval == 0) {
                    applyTrapEffect();
                }
                break;
            case 5: // legacy black hole pull field
                if ((this.tickCount & 3) == 0) {
                    applyBlackHolePull();
                }
                break;
            default:
                if (this.tickCount % this.damageInterval == 0) {
                    applyAreaDamage();
                }
                break;
        }
    }

    /**
     * Legacy black-hole behavior (1.10.2 parity): periodically pull entities toward
     * center. effectDamage is interpreted as pull force for this mode.
     */
    private void applyBlackHolePull() {
        // 2026/04/07・哦itHub Copilot縺ｫ繧医▲縺ｦ遒ｺ隱肴ｸ医∩
        AABB effectBox = this.getBoundingBox().inflate(this.effectRadius);
        List<Entity> entities = this.level().getEntities(this, effectBox);

        for (Entity ent : entities) {
            if (!ent.isPickable() || !ent.isPushable())
                continue;
            if (ent == this.hostEntity || ent == this)
                continue;
            if (TargetHelper.isEntityInvulnerable(ent))
                continue;

            if (ent instanceof IShipOwner owner) {
                if (this.playerUID > 0 && owner.getPlayerUID() == this.playerUID)
                    continue;
            }

            Vec3 delta = ent.position().subtract(this.position());
            double dist = delta.length();
            if (dist <= 1D || dist > this.effectRadius)
                continue;

            Vec3 pull = delta.normalize().scale(-this.effectDamage);
            ent.setDeltaMovement(ent.getDeltaMovement().add(pull));
            ent.hurtMarked = true;
        }
    }

    /**
     * Mine behavior: check for entities in radius, explode on first contact.
     */
    private void applyMineDamage() {
        AABB effectBox = this.getBoundingBox().inflate(this.effectRadius);
        List<Entity> entities = this.level().getEntities(this, effectBox);

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

            // check friendly fire
            if (this.hostEntity != null && CombatHelper.isFriendlyFire(this.hostEntity, ent))
                continue;

            double distSq = this.distanceToSqr(ent);
            if (distSq <= this.effectRadius * this.effectRadius) {
                // trigger mine explosion
                this.triggered = true;

                // damage all entities in explosion radius
                applyAreaDamage();

                // discard after detonation
                this.entityData.set(IS_ACTIVE, false);
                this.discard();
                return;
            }
        }
    }

    /**
     * Apply area damage to all valid entities within effect radius.
     */
    private void applyAreaDamage() {
        AABB effectBox = this.getBoundingBox().inflate(this.effectRadius);
        List<Entity> entities = this.level().getEntities(this, effectBox);

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

            // check friendly fire
            if (this.hostEntity != null && CombatHelper.isFriendlyFire(this.hostEntity, ent))
                continue;

            double distSq = this.distanceToSqr(ent);
            if (distSq <= this.effectRadius * this.effectRadius) {
                float dmg = this.effectDamage;

                // damage falloff based on distance
                double dist = Math.sqrt(distSq);
                dmg *= (float) (1.0 - dist / this.effectRadius) * 0.5F + 0.5F;

                // apply defense reduction
                dmg = CombatHelper.applyDamageReduceByDEF(dmg, ent);

                // deal damage
                if (ent instanceof LivingEntity livingTarget && this.hostEntity != null) {
                    livingTarget.hurt(this.damageSources().mobAttack(this.hostEntity), dmg);
                }
            }
        }
    }

    /**
     * Trap behavior: slow and damage entities in range.
     */
    private void applyTrapEffect() {
        AABB effectBox = this.getBoundingBox().inflate(this.effectRadius);
        List<Entity> entities = this.level().getEntities(this, effectBox);

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

            // check friendly fire
            if (this.hostEntity != null && CombatHelper.isFriendlyFire(this.hostEntity, ent))
                continue;

            double distSq = this.distanceToSqr(ent);
            if (distSq <= this.effectRadius * this.effectRadius) {
                float dmg = this.effectDamage * 0.5F;

                // apply defense reduction
                dmg = CombatHelper.applyDamageReduceByDEF(dmg, ent);

                // deal damage
                if (ent instanceof LivingEntity livingTarget && this.hostEntity != null) {
                    livingTarget.hurt(this.damageSources().mobAttack(this.hostEntity), dmg);

                    // apply slow effect
                    livingTarget.addEffect(new net.minecraft.world.effect.MobEffectInstance(
                            net.minecraft.world.effect.MobEffects.MOVEMENT_SLOWDOWN,
                            40, 1, false, false));
                }
            }
        }
    }

    /**
     * Get the effect radius for rendering
     */
    public float getEffectRadius() {
        return this.entityData.get(EFFECT_RADIUS);
    }

    /**
     * Check if the effect is still active
     */
    public boolean isActive() {
        return this.entityData.get(IS_ACTIVE);
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

    // ========== Effect-specific getters/setters ==========

    public int getEffectType() {
        return this.effectType;
    }

    public void setEffectType(int effectType) {
        this.effectType = effectType;
    }
}
