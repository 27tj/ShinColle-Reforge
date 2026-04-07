package com.lulan.shincolle.ai;

import java.util.EnumSet;

import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.IShipCannonAttack;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;

/**
 * Range attack goal (cannon fire).
 * Ported from EntityAIShipRangeAttack (setMutexBits: 1)
 */
public class ShipRangeAttackGoal extends Goal {

	private final IShipCannonAttack host;
	private final Mob entity;
	private Entity target;
	private int delayLight;
	private int maxDelayLight;
	private int delayHeavy;
	private int maxDelayHeavy;
	private int onSightTime;
	private float range;
	private float rangeSq;
	private int aimTime;

	public ShipRangeAttackGoal(IShipCannonAttack host) {
		this.host = host;
		this.entity = (Mob) host;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE));

		this.delayLight = 20;
		this.delayHeavy = 40;
		this.maxDelayLight = 20;
		this.maxDelayHeavy = 40;
	}

	@Override
	public boolean canUse() {
		if (this.host.getIsSitting() || this.host.getStateMinor(ID.M.CraneState) > 0) {
			return false;
		}

		if (this.host.getIsRiding()) {
			if (this.entity.getVehicle() instanceof BasicEntityMount) {
				return false;
			}
		}

		Entity target = this.host.getEntityTarget();

		if (target != null && target.isAlive() &&
				((this.host.getAttackType(ID.F.AtkType_Light) && this.host.getStateFlag(ID.F.UseAmmoLight)
						&& this.host.hasAmmoLight()) ||
						(this.host.getAttackType(ID.F.AtkType_Heavy) && this.host.getStateFlag(ID.F.UseAmmoHeavy)
								&& this.host.hasAmmoHeavy()))) {
			this.target = target;
			return true;
		}

		return false;
	}

	@Override
	public void start() {
		this.updateAttackParms();

		if (this.delayLight <= this.aimTime) {
			this.delayLight = this.aimTime;
		}
		if (this.delayHeavy <= this.aimTime * 2) {
			this.delayHeavy = this.aimTime * 2;
		}
	}

	@Override
	public boolean canContinueToUse() {
		if (this.target != null && this.target.isAlive() && !this.host.getShipNavigate().noPath()) {
			return true;
		}
		return this.canUse();
	}

	@Override
	public void stop() {
		this.target = null;
		this.onSightTime = 0;
	}

	@Override
	public void tick() {
		if (this.target == null)
			return;

		// update attributes periodically
		if (this.entity.tickCount % 64 == 0) {
			this.updateAttackParms();
		}

		this.delayLight--;
		this.delayHeavy--;

		double distSq = this.entity.distanceToSqr(this.target);
		boolean onSight = this.entity.getSensing().hasLineOfSight(this.target);

		if (onSight) {
			++this.onSightTime;
		} else {
			this.onSightTime = 0;

			if (this.host.getStateFlag(ID.F.OnSightChase)) {
				this.host.setEntityTarget(null);
				this.stop();
				return;
			}
		}

		// stop moving if in range and has sight
		if (distSq < this.rangeSq && onSight && !this.host.getStateFlag(ID.F.UseMelee)) {
			this.host.getShipNavigate().clearPathEntity();
		} else {
			// chase target
			if (this.entity.tickCount % 32 == 0) {
				this.host.getShipNavigate().tryMoveToEntityLiving(this.target, 1.0D);
			}
		}

		this.entity.getLookControl().setLookAt(this.target, 30.0F, 30.0F);

		// fire if delay done, on sight, in range, and aimed long enough
		if (onSight && distSq <= this.rangeSq && this.onSightTime >= this.aimTime) {
			// light attack
			if (this.delayLight <= 0 && this.host.useAmmoLight() && this.host.hasAmmoLight()) {
				this.host.attackEntityWithAmmo(this.target);
				this.delayLight = this.maxDelayLight;
			}
			// heavy attack
			if (this.delayHeavy <= 0 && this.host.useAmmoHeavy() && this.host.hasAmmoHeavy()) {
				this.host.attackEntityWithHeavyAmmo(this.target);
				this.delayHeavy = this.maxDelayHeavy;
			}
		}

		// reset if stuck too long without hitting
		if (this.delayHeavy < -40 && this.delayLight < -40) {
			this.delayLight = 20;
			this.delayHeavy = 20;
			this.host.setEntityTarget(null);
			this.stop();
		}
	}

	private void updateAttackParms() {
		float atkSpd = this.host.getAttrs().getAttackSpeed();
		// attack delay = baseAttackSpeed / attackSpeed + fixedAttackDelay
		this.maxDelayLight = Math.max(5,
				(int) (ConfigHandler.baseAttackSpeed[1] / Math.max(atkSpd, 0.01F))
						+ ConfigHandler.fixedAttackDelay[1]);
		this.maxDelayHeavy = Math.max(10,
				(int) (ConfigHandler.baseAttackSpeed[2] / Math.max(atkSpd, 0.01F))
						+ ConfigHandler.fixedAttackDelay[2]);
		this.aimTime = (int) (20.0F * (150 - this.host.getLevel()) / 150.0F) + 10;
		this.range = this.host.getAttrs().getAttackRange();
		this.rangeSq = this.range * this.range;
	}
}
