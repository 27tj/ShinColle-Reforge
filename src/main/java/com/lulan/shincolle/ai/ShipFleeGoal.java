package com.lulan.shincolle.ai;

import java.util.EnumSet;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

/**
 * Flee goal - activates when HP below threshold.
 * Ported from EntityAIShipFlee (setMutexBits: 7)
 */
public class ShipFleeGoal extends Goal {

	private final BasicEntityShip ship;
	private LivingEntity owner;
	private int pathfindCooldown;

	public ShipFleeGoal(BasicEntityShip ship) {
		this.ship = ship;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
	}

	@Override
	public boolean canUse() {
		if (this.ship.getStateFlag(ID.F.NoFuel))
			return false;

		LivingEntity owner = this.ship.getOwner();
		if (owner == null || !owner.isAlive())
			return false;

		float fleeHP = this.ship.getStateMinor(ID.M.FleeHP) * 0.01F;
		float hpRatio = this.ship.getHealth() / this.ship.getMaxHealth();

		return hpRatio <= fleeHP;
	}

	@Override
	public boolean canContinueToUse() {
		return canUse();
	}

	@Override
	public void start() {
		this.owner = this.ship.getOwner();
		this.pathfindCooldown = 0;
	}

	@Override
	public void stop() {
		this.owner = null;
		this.ship.getShipNavigate().clearPathEntity();
	}

	@Override
	public void tick() {
		if (--this.pathfindCooldown <= 0) {
			this.pathfindCooldown = 20;

			if (this.owner != null && this.owner.isAlive()) {
				this.ship.getShipNavigate().tryMoveToEntityLiving(this.owner, 1.2D);

				// teleport if too far and stuck
				if (this.ship.distanceToSqr(this.owner) > 1024D) {
					this.ship.teleportTo(this.owner.getX(), this.owner.getY(), this.owner.getZ());
				}
			}
		}
	}
}
