package com.lulan.shincolle.ai;

import java.util.EnumSet;

import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.IShipFloating;
import com.lulan.shincolle.entity.IShipGuardian;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.utility.DebugProfiler;

import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

/**
 * Floating goal - makes ships rise toward water surface.
 * Ported from EntityAIShipFloating (setMutexBits: 8)
 *
 * 5-tier graduated upward velocity based on depth:
 * depth > 4.0: +0.025
 * depth > 2.0: +0.015
 * depth > 1.3: +0.007
 * depth > 0.47: +0.003
 * depth > 0.15: +0.0015
 */
public class ShipFloatingGoal extends Goal {
	private static final double DEPTH_TIER_1 = 4D;
	private static final double DEPTH_TIER_2 = 2D;
	private static final double DEPTH_TIER_3 = 1.3D;
	private static final double DEPTH_TIER_4 = 0.47D;
	private static final double DEPTH_TIER_5 = 0.15D;

	private static final double FLOAT_SPEED_TIER_1 = 0.025D;
	private static final double FLOAT_SPEED_TIER_2 = 0.015D;
	private static final double FLOAT_SPEED_TIER_3 = 0.007D;
	private static final double FLOAT_SPEED_TIER_4 = 0.003D;
	private static final double FLOAT_SPEED_TIER_5 = 0.0015D;

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
<<<<<<< Updated upstream
		// ship type
		if (hostShip != null) {
			return canFloatShip(hostShip);
		}
		// mount type
		else if (hostMount != null && hostMount.getHostEntity() != null) {
			return canFloatMount(hostMount);
		}
=======
		ProfilerFiller profiler = DebugProfiler.push(this.hostLiving.level(), "shincolle.ai.floating.can_use");
		try {
			// ship type
			if (hostShip != null) {
				if (hostShip.getStateFlag(ID.F.CanFloatUp) &&
						hostShip.getShipDepth() > hostShip.getShipFloatingDepth()) {
					// block floating when: no fuel, riding, sitting, crane, navigating, or in guard
					// position
					if (hostShip.getStateFlag(ID.F.NoFuel) || hostShip.isPassenger() || hostShip.isOrderedToSit() ||
							hostShip.getStateMinor(ID.M.CraneState) > 0 ||
							!hostShip.getShipNavigate().noPath() ||
							isInGuardPosition(hostShip)) {
						DebugProfiler.count(profiler, "shincolle.ai.floating.blocked.ship_state_guard");
						return false;
					}
					DebugProfiler.count(profiler, "shincolle.ai.floating.can_use.ship_success");
					return true;
				}
				DebugProfiler.count(profiler, "shincolle.ai.floating.blocked.ship_depth_or_surface");
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
							DebugProfiler.count(profiler, "shincolle.ai.floating.blocked.mount_host_state_guard");
							return false;
						}
					}
					// check mount's own navigator and guard
					if (!hostMount.getShipNavigate().noPath() || isInGuardPosition(hostMount)) {
						DebugProfiler.count(profiler, "shincolle.ai.floating.blocked.mount_state_guard");
						return false;
					}
					DebugProfiler.count(profiler, "shincolle.ai.floating.can_use.mount_success");
					return true;
				}
				DebugProfiler.count(profiler, "shincolle.ai.floating.blocked.mount_depth");
				return false;
			}
>>>>>>> Stashed changes

			// fallback
			boolean canUse = host.getShipDepth() > host.getShipFloatingDepth();
			if (canUse) {
				DebugProfiler.count(profiler, "shincolle.ai.floating.can_use.fallback_success");
			}
			return canUse;
		} finally {
			DebugProfiler.pop(profiler);
		}
	}

	@Override
	public void tick() {
<<<<<<< Updated upstream
		double depth = this.host.getShipDepth();

		// 5-tier graduated float speeds matching original
		if (depth > DEPTH_TIER_1) {
			applyVerticalBoost(FLOAT_SPEED_TIER_1);
		} else if (depth > DEPTH_TIER_2) {
			applyVerticalBoost(FLOAT_SPEED_TIER_2);
		} else if (depth > DEPTH_TIER_3) {
			applyVerticalBoost(FLOAT_SPEED_TIER_3);
		} else if (depth > DEPTH_TIER_4) {
			applyVerticalBoost(FLOAT_SPEED_TIER_4);
		} else if (depth > DEPTH_TIER_5) {
			applyVerticalBoost(FLOAT_SPEED_TIER_5);
		}
	}

	private boolean canFloatShip(BasicEntityShip ship) {
		if (!ship.getStateFlag(ID.F.CanFloatUp) || ship.getShipDepth() <= ship.getShipFloatingDepth()) {
			return false;
=======
		ProfilerFiller profiler = DebugProfiler.push(this.hostLiving.level(), "shincolle.ai.floating.tick");
		try {
			double depth = this.host.getShipDepth();

			// 5-tier graduated float speeds matching original
			if (depth > 4D) {
				DebugProfiler.count(profiler, "shincolle.ai.floating.tick.band_4_0");
				this.hostLiving.setDeltaMovement(
						this.hostLiving.getDeltaMovement().add(0D, 0.025D, 0D));
			} else if (depth > 2D) {
				DebugProfiler.count(profiler, "shincolle.ai.floating.tick.band_2_0");
				this.hostLiving.setDeltaMovement(
						this.hostLiving.getDeltaMovement().add(0D, 0.015D, 0D));
			} else if (depth > 1.3D) {
				DebugProfiler.count(profiler, "shincolle.ai.floating.tick.band_1_3");
				this.hostLiving.setDeltaMovement(
						this.hostLiving.getDeltaMovement().add(0D, 0.007D, 0D));
			} else if (depth > 0.47D) {
				DebugProfiler.count(profiler, "shincolle.ai.floating.tick.band_0_47");
				this.hostLiving.setDeltaMovement(
						this.hostLiving.getDeltaMovement().add(0D, 0.003D, 0D));
			} else if (depth > 0.15D) {
				DebugProfiler.count(profiler, "shincolle.ai.floating.tick.band_0_15");
				this.hostLiving.setDeltaMovement(
						this.hostLiving.getDeltaMovement().add(0D, 0.0015D, 0D));
			}
		} finally {
			DebugProfiler.pop(profiler);
>>>>>>> Stashed changes
		}

		// block floating when: no fuel, riding, sitting, crane, navigating, or in guard
		// position
		return !(ship.getStateFlag(ID.F.NoFuel)
				|| ship.isPassenger()
				|| ship.isOrderedToSit()
				|| ship.getStateMinor(ID.M.CraneState) > 0
				|| !ship.getShipNavigate().noPath()
				|| isInGuardPosition(ship));
	}

	private boolean canFloatMount(BasicEntityMount mount) {
		if (mount.getShipDepth() <= mount.getShipFloatingDepth()) {
			return false;
		}

		Entity hostEntity = mount.getHostEntity();
		if (hostEntity instanceof BasicEntityShip ship) {
			if (ship.isOrderedToSit()
					|| ship.getStateMinor(ID.M.CraneState) > 0
					|| !ship.getShipNavigate().noPath()
					|| isInGuardPosition(ship)) {
				return false;
			}
		}

		// check mount's own navigator and guard
		return mount.getShipNavigate().noPath() && !isInGuardPosition(mount);
	}

	private void applyVerticalBoost(double amount) {
		this.hostLiving.setDeltaMovement(this.hostLiving.getDeltaMovement().add(0D, amount, 0D));
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
