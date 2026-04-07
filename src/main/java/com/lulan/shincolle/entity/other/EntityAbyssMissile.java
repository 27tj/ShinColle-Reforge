package com.lulan.shincolle.entity.other;

import java.util.HashMap;
import java.util.List;

import com.lulan.shincolle.entity.IShipAttackBase;
import com.lulan.shincolle.entity.IShipAttrs;
import com.lulan.shincolle.entity.IShipCustomTexture;
import com.lulan.shincolle.entity.IShipOwner;
import com.lulan.shincolle.entity.IShipProjectile;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.unitclass.Attrs;
import com.lulan.shincolle.utility.CombatHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

/**
 * Abyss missile projectile entity.
 * Supports multiple movement types: direct, parabolic, torpedo, etc.
 *
 * type:
 * 0: white smoke, 1: unused, 2: railgun, 3: cluster main, 4: cluster sub, 5:
 * black hole
 *
 * moveType:
 * 0: direct without gravity
 * 1: parabola
 * 2: sim-torpedo
 * 3: direct with gravity
 *
 * Ported from 1.10.2 EntityAbyssMissile.
 */
public class EntityAbyssMissile extends Entity implements IShipOwner, IShipAttrs, IShipCustomTexture, IShipProjectile {

	protected IShipAttackBase host;
	protected LivingEntity hostEntity;
	protected int playerUID;
	protected Attrs attrs;
	protected int type;
	public int moveType;
	public int life;
	public HashMap<Integer, int[]> effectMap;

	// velocity
	public double velX, velY, velZ;
	public double vel0;
	public double accY1, accY2;
	public double t0, t1;

	public EntityAbyssMissile(EntityType<? extends EntityAbyssMissile> type, Level level) {
		super(type, level);
		this.noCulling = true;
		this.attrs = new Attrs();
		this.life = 160;
	}

	@Override
	public EntityDimensions getDimensions(Pose pose) {
		return EntityDimensions.fixed(0.5F, 0.5F);
	}

	/**
	 * Initialize missile with host, attack data, target position and movement
	 * parameters.
	 *
	 * @param host        the attacking entity
	 * @param missileType missile visual/behavior type (0-5)
	 * @param moveType    movement type (0=direct, 1=parabola, 2=torpedo,
	 *                    3=direct+gravity)
	 * @param atk         attack damage
	 * @param kbValue     knockback value
	 * @param launchY     Y position to launch from
	 * @param tarX        target X position
	 * @param tarY        target Y position
	 * @param tarZ        target Z position
	 * @param lifetime    max ticks before expiring
	 * @param addHeight   additional height for parabola
	 * @param initVel     initial velocity
	 * @param initAccY1   acceleration Y phase 1
	 * @param initAccY2   acceleration Y phase 2
	 */
	public void initMissile(IShipAttackBase host, int missileType, int moveType,
			float atk, float kbValue, float launchY,
			float tarX, float tarY, float tarZ,
			int lifetime, float addHeight,
			float initVel, float initAccY1, float initAccY2) {
		this.host = host;
		if (host instanceof LivingEntity le) {
			this.hostEntity = le;
		}
		this.effectMap = host.getAttackEffectMap();
		this.setPlayerUID(host.getPlayerUID());
		this.type = missileType;
		this.moveType = moveType;
		this.life = lifetime;

		// set attrs
		this.attrs = new Attrs();
		this.attrs.copyRaw2Buffed();
		this.attrs.setAttrsBuffed(ID.Attrs.ATK_L, atk);
		this.attrs.setAttrsBuffed(ID.Attrs.ATK_H, atk);
		this.attrs.setAttrsBuffed(ID.Attrs.ATK_AL, atk);
		this.attrs.setAttrsBuffed(ID.Attrs.ATK_AH, atk);
		this.attrs.setAttrsBuffed(ID.Attrs.DODGE, 0.5F);
		this.attrs.setAttrsBuffed(ID.Attrs.KB, kbValue);

		// set position at host's XZ and given launch Y
		if (this.hostEntity != null) {
			this.setPos(this.hostEntity.getX(), launchY, this.hostEntity.getZ());
		}

		// init velocity
		this.vel0 = initVel;
		this.accY1 = initAccY1;
		this.accY2 = initAccY2;
		this.t0 = 0;
		this.t1 = 0;

		// calc direction vector to target
		double dx = tarX - this.getX();
		double dy = tarY - this.getY();
		double dz = tarZ - this.getZ();
		double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);

		// if target too close, force direct mode
		if (dist < 4D) {
			this.moveType = 0;
		}

		// normalize
		if (dist > 0.01D) {
			dx /= dist;
			dy /= dist;
			dz /= dist;
		}

		// set velocity based on move type
		switch (this.moveType) {
			case 0: // direct without gravity
				this.velX = dx * this.vel0;
				this.velY = dy * this.vel0;
				this.velZ = dz * this.vel0;
				this.accY1 = 0;
				this.accY2 = 0;
				break;
			case 1: // parabola
			{
				double dxRaw = tarX - this.getX();
				double dzRaw = tarZ - this.getZ();
				double dxz = Math.sqrt(dxRaw * dxRaw + dzRaw * dzRaw);

				if (addHeight <= 0 || dxz <= 4D) {
					// fallback to direct
					this.moveType = 0;
					this.velX = dx * this.vel0;
					this.velY = dy * this.vel0;
					this.velZ = dz * this.vel0;
					this.accY1 = 0;
					this.accY2 = 0;
				} else {
					double dxNorm = dxRaw / dxz;
					double dzNorm = dzRaw / dxz;
					double t = dxz / this.vel0;
					double aHeight = dist * addHeight;
					double dyAbs = Math.abs(this.getY() - tarY);

					this.velX = dxNorm * this.vel0;
					this.velZ = dzNorm * this.vel0;

					if (this.getY() - tarY < 1D) {
						// target higher
						double hy = Mth.sqrt((float) (aHeight / (aHeight + dyAbs)));
						this.t0 = Math.floor(t / (1 + hy));
						this.t1 = Math.floor(t * hy / (1 + hy));
						this.velY = 2D * (aHeight + dyAbs) / t0;
						this.accY1 = -this.velY / t0;
						this.accY2 = -2D * aHeight / (t1 * t1);
					} else {
						// target lower
						double hy = Mth.sqrt((float) (aHeight / (aHeight + dyAbs)));
						this.t0 = Math.floor(t * hy / (1 + hy));
						this.t1 = Math.floor(t / (1 + hy));
						this.accY1 = -2D * aHeight / (t0 * t0);
						this.velY = -this.accY1 * t0;
						this.accY2 = -2D * (aHeight + dyAbs) / (t1 * t1);
					}

					// if acceleration too high, fallback to direct
					if (Math.abs(this.accY1) > 0.15D || Math.abs(this.accY2) > 0.15D) {
						this.moveType = 0;
						this.velX = dx * this.vel0;
						this.velY = dy * this.vel0;
						this.velZ = dz * this.vel0;
						this.accY1 = 0;
						this.accY2 = 0;
					}
				}
			}
				break;
			case 2: // torpedo
				this.velX = dx * 0.6D;
				this.velY = 0.1D;
				this.velZ = dz * 0.6D;
				this.accY1 = -0.035D;
				break;
			case 3: // direct with gravity
				this.velX = dx * this.vel0;
				this.velY = dy * this.vel0;
				this.velZ = dz * this.vel0;
				this.accY1 = -0.035D;
				this.accY2 = -0.035D;
				break;
			default:
				this.velX = dx * this.vel0;
				this.velY = dy * this.vel0;
				this.velZ = dz * this.vel0;
				break;
		}
	}

	@Override
	protected void defineSynchedData() {
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		compound.putInt("MissileType", this.type);
		compound.putInt("MovementType", this.moveType);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		this.type = compound.getInt("MissileType");
		this.moveType = compound.getInt("MovementType");
	}

	@Override
	public void tick() {
		super.tick();

		// ===== BOTH SIDES: update position =====
		this.setDeltaMovement(this.velX, this.velY, this.velZ);
		Vec3 pos = this.position().add(this.velX, this.velY, this.velZ);
		this.setPos(pos.x, pos.y, pos.z);

		// update velocity
		handleMissileMovement();

		// ===== SERVER SIDE =====
		if (!this.level().isClientSide()) {
			// no host => discard silently
			if (this.host == null) {
				this.discard();
				return;
			}

			// lifetime check
			if (this.tickCount > this.life) {
				this.onImpact(null);
				return;
			}

			// collision checks after 5 ticks (let missile leave host)
			if (this.tickCount > 5) {
				// block collision: current position is solid
				BlockPos blockPos = BlockPos.containing(this.getX(), this.getY(), this.getZ());
				if (this.level().getBlockState(blockPos).isSuffocating(this.level(), blockPos)) {
					this.onImpact(null);
					return;
				}

				// ray trace for block collision in movement path
				Vec3 posStart = this.position();
				Vec3 posEnd = posStart.add(this.velX, this.velY, this.velZ);
				BlockHitResult raytrace = this.level().clip(new ClipContext(
						posStart, posEnd, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));

				if (raytrace.getType() == HitResult.Type.BLOCK) {
					this.onImpact(null);
					return;
				}

				// entity collision: check entities in expanded bounding box
				AABB hitBox = this.getBoundingBox().inflate(1D, 1.5D, 1D);
				List<Entity> hitList = this.level().getEntities(this, hitBox);

				for (Entity ent : hitList) {
					if (ent.isPickable() && isNotHost(ent) && !isSameOwner(ent)) {
						this.onImpact(ent);
						return;
					}
				}
			}
		}

		// ===== CLIENT SIDE: facing =====
		if (this.level().isClientSide()) {
			float f1 = Mth.sqrt((float) (this.velX * this.velX + this.velZ * this.velZ));
			this.setXRot((float) (Math.atan2(this.velY, f1)));
			this.setYRot((float) (Math.atan2(this.velX, this.velZ)));

			if (this.velX > 0) {
				this.setYRot(this.getYRot() - (float) Math.PI);
			} else {
				this.setYRot(this.getYRot() + (float) Math.PI);
			}
		}
	}

	/** Update velocity based on movement type */
	protected void handleMissileMovement() {
		switch (this.moveType) {
			case 1: // parabola
				if (this.tickCount <= this.t0) {
					this.velY += this.accY1;
				} else {
					this.velY += this.accY2;
				}
				break;
			case 2: // torpedo
				this.velX *= 0.85D;
				this.velY += this.accY1;
				this.velZ *= 0.85D;
				break;
			case 3: // direct with gravity
				this.velY += this.accY1;
				break;
		}
	}

	/** Called when missile hits something or expires */
	protected void onImpact(Entity hitEntity) {
		if (this.host == null) {
			this.discard();
			return;
		}

		if (!this.level().isClientSide()) {
			float missileAtk = this.attrs.getAttackDamage();

			// AoE damage in 3.5 block radius
			AABB aoeBox = this.getBoundingBox().inflate(3.5D, 3.5D, 3.5D);
			List<Entity> hitList = this.level().getEntities(this, aoeBox);

			for (Entity ent : hitList) {
				if (ent.isPickable() && isNotHost(ent)) {
					float dmg = missileAtk;

					// skip same owner
					if (isSameOwner(ent))
						continue;

					// apply combat rate (type modifier)
					if (this.hostEntity != null) {
						dmg = CombatHelper.applyCombatRateToDamageByType(dmg, this.hostEntity, ent);
					}

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

			// spawn explosion particles
			if (this.level() instanceof ServerLevel serverLevel) {
				double px = this.getX();
				double py = this.getY();
				double pz = this.getZ();
				// large explosion particle
				serverLevel.sendParticles(ParticleTypes.EXPLOSION,
						px, py, pz, 1, 0D, 0D, 0D, 0D);
				// smoke particles surrounding the impact
				serverLevel.sendParticles(ParticleTypes.LARGE_SMOKE,
						px, py, pz, 8, 0.5D, 0.5D, 0.5D, 0.02D);
				// flame particles for visual effect
				serverLevel.sendParticles(ParticleTypes.FLAME,
						px, py, pz, 6, 0.4D, 0.4D, 0.4D, 0.05D);
			}

			this.discard();
		}
	}

	/** Check if entity is not this missile's host */
	private boolean isNotHost(Entity ent) {
		if (ent == this)
			return false;
		if (this.hostEntity != null && ent == this.hostEntity)
			return false;
		return true;
	}

	/** Check if entity has same owner as this missile */
	private boolean isSameOwner(Entity ent) {
		if (ent instanceof IShipOwner owner) {
			return this.playerUID > 0 && owner.getPlayerUID() == this.playerUID;
		}
		return false;
	}

	@Override
	public boolean canBeCollidedWith() {
		return true;
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (this.level().isClientSide())
			return false;

		if (this.host == null) {
			this.discard();
			return false;
		}

		// ignore environmental damage
		if (source.equals(this.damageSources().inWall()) ||
				source.equals(this.damageSources().cactus()) ||
				source.equals(this.damageSources().fall()) ||
				source.equals(this.damageSources().lava()) ||
				source.equals(this.damageSources().onFire())) {
			return false;
		}

		// high damage causes immediate explosion
		if (this.isAlive() && amount > 8F) {
			this.onImpact(null);
			return true;
		}

		return false;
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

	// ========== IShipAttrs ==========

	@Override
	public Attrs getAttrs() {
		return this.attrs;
	}

	@Override
	public void setAttrs(Attrs data) {
		this.attrs = data;
	}

	// ========== IShipCustomTexture ==========

	@Override
	public int getTextureID() {
		return ID.ShipMisc.AbyssalMissile;
	}

	@Override
	public void setTextureID(int id) {
	}

	// ========== IShipProjectile ==========

	@Override
	public int getProjectileType() {
		return this.type;
	}

	@Override
	public void setProjectileType(int type) {
		this.type = type;
	}

	// ========== Missile-specific ==========

	public int getMissileType() {
		return this.type;
	}

	public void setMissileType(int missileType) {
		this.type = missileType;
	}

	public int getMovementType() {
		return this.moveType;
	}

	public void setMovementType(int movementType) {
		this.moveType = movementType;
	}
}
