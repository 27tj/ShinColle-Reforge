package com.lulan.shincolle.entity.other;

import com.lulan.shincolle.entity.IShipAttackBase;
import com.lulan.shincolle.entity.IShipCustomTexture;
import com.lulan.shincolle.entity.IShipOwner;
import com.lulan.shincolle.entity.IShipProjectile;
import com.lulan.shincolle.utility.CombatHelper;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

/**
 * Static projectile/effect entity (mines, barriers, etc.).
 * Remains stationary at a position and damages entities that enter its effect radius.
 * Different effect types control behavior:
 *   0: mine - explodes on contact, single use
 *   1: barrier - persistent damage field, lasts for duration
 *   2: trap - slows and damages entities in range
 */
public class EntityProjectileStatic extends Entity implements IShipOwner, IShipCustomTexture, IShipProjectile {

	/** Synched effect radius for client-side rendering */
	private static final EntityDataAccessor<Float> EFFECT_RADIUS =
			SynchedEntityData.defineId(EntityProjectileStatic.class, EntityDataSerializers.FLOAT);
	/** Synched active flag for rendering */
	private static final EntityDataAccessor<Boolean> IS_ACTIVE =
			SynchedEntityData.defineId(EntityProjectileStatic.class, EntityDataSerializers.BOOLEAN);

	private int playerUID;
	private int textureID;
	private int projectileType;
	private int effectType;

	/** Host entity or ship that placed this effect */
	private LivingEntity hostEntity;
	private IShipAttackBase hostShip;

	/** Effect damage per hit */
	private float effectDamage;

	/** Effect radius in blocks */
	private float effectRadius = 3.0F;

	/** Effect lifetime in ticks */
	private int effectLifetime = 200;

	/** Damage interval in ticks */
	private int damageInterval = 20;

	/** Whether this effect has been triggered (for mine type) */
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
	}

	@Override
	public EntityDimensions getDimensions(Pose pose) {
		return EntityDimensions.fixed(0.5F, 0.5F);
	}

	@Override
	protected void defineSynchedData() {
		this.entityData.define(EFFECT_RADIUS, 3.0F);
		this.entityData.define(IS_ACTIVE, true);
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
	}

	@Override
	public void tick() {
		super.tick();

		// server-side effect logic
		if (!this.level().isClientSide()) {
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
			default:
				if (this.tickCount % this.damageInterval == 0) {
					applyAreaDamage();
				}
				break;
			}
		}
	}

	/**
	 * Mine behavior: check for entities in radius, explode on first contact.
	 */
	private void applyMineDamage() {
		AABB effectBox = this.getBoundingBox().inflate(this.effectRadius);
		List<Entity> entities = this.level().getEntities(this, effectBox);

		for (Entity ent : entities) {
			if (!ent.isPickable()) continue;
			if (ent == this.hostEntity) continue;

			// skip same-owner entities
			if (ent instanceof IShipOwner owner) {
				if (this.playerUID > 0 && owner.getPlayerUID() == this.playerUID) continue;
			}

			// check friendly fire
			if (this.hostEntity != null && CombatHelper.isFriendlyFire(this.hostEntity, ent)) continue;

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
			if (!ent.isPickable()) continue;
			if (ent == this.hostEntity) continue;

			// skip same-owner entities
			if (ent instanceof IShipOwner owner) {
				if (this.playerUID > 0 && owner.getPlayerUID() == this.playerUID) continue;
			}

			// check friendly fire
			if (this.hostEntity != null && CombatHelper.isFriendlyFire(this.hostEntity, ent)) continue;

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
			if (!ent.isPickable()) continue;
			if (ent == this.hostEntity) continue;

			// skip same-owner entities
			if (ent instanceof IShipOwner owner) {
				if (this.playerUID > 0 && owner.getPlayerUID() == this.playerUID) continue;
			}

			// check friendly fire
			if (this.hostEntity != null && CombatHelper.isFriendlyFire(this.hostEntity, ent)) continue;

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

	/** Get the effect radius for rendering */
	public float getEffectRadius() {
		return this.entityData.get(EFFECT_RADIUS);
	}

	/** Check if the effect is still active */
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
