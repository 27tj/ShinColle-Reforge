package com.lulan.shincolle.ai;

import java.util.EnumSet;

import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.IShipFloating;
import com.lulan.shincolle.entity.IShipGuardian;
import com.lulan.shincolle.reference.ID;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Blocks;

/**
 * Floating goal - makes ships rise toward water surface.
 * Ported from EntityAIShipFloating (setMutexBits: 8)
 *
 * 5-tier graduated upward velocity based on depth:
 *   depth > 4.0: +0.025
 *   depth > 2.0: +0.015
 *   depth > 1.3: +0.007
 *   depth > 0.47: +0.003
 *   depth > 0.15: +0.0015
 */
public class ShipFloatingGoal extends Goal {

	private final IShipFloating host;
	private final BasicEntityShip hostShip;
	private final BasicEntityMount hostMount;
	private final LivingEntity hostLiving;

	public ShipFloatingGoal(IShipFloating entity) {
		this.host = entity;
		this.hostLiving = (LivingEntity) entity;

		if (entity instanceof BasicEntityShip ship) {
			this.hostShip = ship;
			this.hostMount = null;
		} else if (entity instanceof BasicEntityMount mount) {
			this.hostShip = null;
			this.hostMount = mount;
		} else {
			this.hostShip = null;
			this.hostMount = null;
		}

		this.setFlags(EnumSet.noneOf(Goal.Flag.class));
	}

	@Override
	public boolean canUse() {
		// ship type
		if (hostShip != null) {
			if (hostShip.getStateFlag(ID.F.CanFloatUp) &&
					hostShip.getShipDepth() > hostShip.getShipFloatingDepth()) {
				// block floating when: riding, sitting, crane, navigating, or in guard position
				if (hostShip.isPassenger() || hostShip.isOrderedToSit() ||
						hostShip.getStateMinor(ID.M.CraneState) > 0 ||
						!hostShip.getShipNavigate().noPath() ||
						isInGuardPosition(hostShip)) {
					return false;
				}
				return true;
			}
			return false;
		}
		// mount type
		else if (hostMount != null && hostMount.getHostEntity() != null) {
			if (hostMount.getShipDepth() > hostMount.getShipFloatingDepth()) {
				Entity hostEntity = hostMount.getHostEntity();
				if (hostEntity instanceof BasicEntityShip ship) {
					// check host ship state
					if (ship.isOrderedToSit() || ship.getStateMinor(ID.M.CraneState) > 0 ||
							!ship.getShipNavigate().noPath() || isInGuardPosition(ship)) {
						return false;
					}
				}
				// check mount's own navigator and guard
				if (!hostMount.getShipNavigate().noPath() || isInGuardPosition(hostMount)) {
					return false;
				}
				return true;
			}
			return false;
		}

		// fallback
		return host.getShipDepth() > host.getShipFloatingDepth();
	}

	@Override
	public void tick() {
		double depth = this.host.getShipDepth();

		// 5-tier graduated float speeds matching original
		if (depth > 4D) {
			this.hostLiving.setDeltaMovement(
					this.hostLiving.getDeltaMovement().add(0D, 0.025D, 0D));
		} else if (depth > 2D) {
			this.hostLiving.setDeltaMovement(
					this.hostLiving.getDeltaMovement().add(0D, 0.015D, 0D));
		} else if (depth > 1.3D) {
			this.hostLiving.setDeltaMovement(
					this.hostLiving.getDeltaMovement().add(0D, 0.007D, 0D));
		} else if (depth > 0.47D) {
			this.hostLiving.setDeltaMovement(
					this.hostLiving.getDeltaMovement().add(0D, 0.003D, 0D));
		} else if (depth > 0.15D) {
			this.hostLiving.setDeltaMovement(
					this.hostLiving.getDeltaMovement().add(0D, 0.0015D, 0D));
		}
	}

	/**
	 * Check if ship is in guard position (should suppress floating).
	 * Returns true if the ship is close enough to its guard target.
	 */
	public static boolean isInGuardPosition(IShipGuardian host) {
		if (!(host instanceof Entity ent))
			return false;

		// if the block above is air, allow floating
		if (ent.level().getBlockState(ent.blockPosition().above()).isAir()) {
			return false;
		}

		// guard mode (CanFollow = false)
		if (!host.getStateFlag(ID.F.CanFollow)) {
			float fMin = host.getStateMinor(ID.M.FollowMin) + ent.getBbWidth() * 0.5F;
			float fMinSq = fMin * fMin;

			// guarding entity
			if (host.getGuardedEntity() != null) {
				double distSq = ent.distanceToSqr(host.getGuardedEntity());
				if (distSq < fMinSq)
					return true;
			}
			// guarding position
			else if (host.getStateMinor(ID.M.GuardY) > 0) {
				double dx = ent.getX() - host.getStateMinor(ID.M.GuardX);
				double dy = ent.getY() - host.getStateMinor(ID.M.GuardY);
				double dz = ent.getZ() - host.getStateMinor(ID.M.GuardZ);
				double distSq = dx * dx + dy * dy + dz * dz;
				if (distSq < fMinSq && ent.getY() >= host.getStateMinor(ID.M.GuardY))
					return true;
			}
		}
		// follow mode (CanFollow = true)
		else {
			float fMax = host.getStateMinor(ID.M.FollowMax) + ent.getBbWidth() * 0.5F;
			float fMaxSq = fMax * fMax;

			Entity hostEntity = host.getHostEntity();
			if (hostEntity != null) {
				double distSq = hostEntity.distanceToSqr(ent);
				if (distSq <= fMaxSq)
					return true;
			}
		}

		return false;
	}
}
