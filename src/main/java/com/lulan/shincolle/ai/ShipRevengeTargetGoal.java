package com.lulan.shincolle.ai;

import java.util.EnumSet;

import com.lulan.shincolle.entity.IShipAttackBase;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

/**
 * Revenge target goal - sets revenge target as attack target.
 * Ported from EntityAIShipRevengeTarget (setMutexBits: 1)
 */
public class ShipRevengeTargetGoal extends Goal {

	private final IShipAttackBase host;
	private int oldRevengeTime;

	public ShipRevengeTargetGoal(IShipAttackBase host) {
		this.host = host;
		this.oldRevengeTime = 0;
		// [PORT] 1.10.2 targetTasks mutex -> 1.20.1 TARGET control flag.
		this.setFlags(EnumSet.of(Goal.Flag.TARGET));
	}

	@Override
	public boolean canUse() {
		if (this.oldRevengeTime != this.host.getEntityRevengeTime()
				&& this.host.getEntityRevengeTarget() != null) {
			Entity revengeTarget = this.host.getEntityRevengeTarget();
			return revengeTarget.isAlive();
		}
		return false;
	}

	@Override
	public void start() {
		this.host.setEntityTarget(this.host.getEntityRevengeTarget());
		this.oldRevengeTime = this.host.getEntityRevengeTime();
	}

	@Override
	public boolean canContinueToUse() {
		Entity target = this.host.getEntityTarget();
		if (target == null || !target.isAlive()) {
			return false;
		}

		// Use follow range for tracking, not attack range
		float followMax = this.host.getStateMinor(com.lulan.shincolle.reference.ID.M.FollowMax);
		if (followMax < 16F)
			followMax = 16F;
		float rangeSq = (followMax + 2F) * (followMax + 2F);

		return ((LivingEntity) this.host).distanceToSqr(target) <= rangeSq;
	}

	@Override
	public void stop() {
	}
}
