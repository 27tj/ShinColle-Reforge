package com.lulan.shincolle.utility;

import com.lulan.shincolle.ai.path.ShipMoveHelper;
import com.lulan.shincolle.ai.path.ShipPathNavigate;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.entity.IShipAttackBase;
import com.lulan.shincolle.entity.IShipFloating;
import com.lulan.shincolle.entity.IShipNavigator;
import com.lulan.shincolle.reference.ID;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

/**
 * Helper for ship entity movement and navigation.
 *
 * Handles water depth calculation, floating behavior, and
 * custom movement in fluids.
 *
 * Ported from 1.10.2 EntityHelper.
 */
public class EntityHelper {

	/**
	 * Update ship navigator - called every tick on server side.
	 *
	 * Handles:
	 * - Water depth calculation for floating
	 * - Vertical position adjustment in water
	 * - Custom path navigation ticking (water/air pathfinding)
	 * - Custom move helper ticking (Y-axis movement)
	 */
	public static void updateShipNavigator(BasicEntityShip ship) {
		updateShipDepth(ship);
		updateShipFloating(ship);
		tickCustomNavigator(ship);
	}

	/**
	 * Update ship navigator for hostile ships.
	 */
	public static void updateShipNavigator(Mob ship) {
		if (ship instanceof IShipFloating floating) {
			updateShipDepth(floating);
			updateShipFloatingGeneric(ship, floating);
		}
		if (ship instanceof IShipNavigator) {
			tickCustomNavigator(ship);
		}
	}

	/**
	 * Tick the custom ship navigator and move helper.
	 * If the custom path is active, clears the vanilla navigator to prevent
	 * conflicts.
	 * Also clears custom path when sitting or leashed.
	 */
	private static void tickCustomNavigator(Mob entity) {
		if (!(entity instanceof IShipNavigator navEntity))
			return;

		ShipPathNavigate pathNavi = navEntity.getShipNavigate();
		ShipMoveHelper moveHelper = navEntity.getShipMoveHelper();

		if (pathNavi == null || moveHelper == null)
			return;

		if (!pathNavi.noPath()) {
			// clear vanilla navigator when custom path is active
			entity.getNavigation().stop();

			// clear if sitting or leashed
			if (entity instanceof BasicEntityShip ship) {
				if (ship.isOrderedToSit() || ship.isLeashed()) {
					pathNavi.clearPathEntity();
					return;
				}
			}

			// tick custom navigator and move helper
			pathNavi.onUpdateNavigation();
			moveHelper.onUpdateMoveHelper();
		}

		// [PORT] 1.10.2 -> 1.20.1: keep vanilla path disabled in liquid to avoid
		// mixed vanilla/custom navigation steering.
		if (!entity.getNavigation().isDone() && checkEntityIsInLiquid(entity)) {
			entity.getNavigation().stop();
		}
	}

	/**
	 * Calculate water depth at the ship's position.
	 * Sets the ShipDepth value used for floating calculations.
	 */
	public static void updateShipDepth(IShipFloating ship) {
		if (!(ship instanceof LivingEntity entity))
			return;

		Level level = entity.level();
		BlockPos pos = new BlockPos(
				net.minecraft.util.Mth.floor(entity.getX()),
				(int) entity.getBoundingBox().minY,
				net.minecraft.util.Mth.floor(entity.getZ()));
		// [PORT] 1.10.2 -> 1.20.1: restore legacy depth contract used by
		// ShipFloatingGoal
		// (single-column liquid depth + CanFloatUp flag from top block material).
		BlockState state = level.getBlockState(pos);
		double depth = 0D;

		if (BlockHelper.checkBlockIsLiquid(state)) {
			depth = 1D;
			ship.setStateFlag(ID.F.CanFloatUp, true);

			for (int y = pos.getY() + 1; y < level.getMaxBuildHeight(); y++) {
				BlockState upState = level.getBlockState(new BlockPos(pos.getX(), y, pos.getZ()));

				if (BlockHelper.checkBlockIsLiquid(upState)) {
					depth++;
				} else {
					ship.setStateFlag(ID.F.CanFloatUp, upState.isAir());
					break;
				}
			}

			depth -= (entity.getY() - Math.floor(entity.getY()));
		} else {
			ship.setStateFlag(ID.F.CanFloatUp, false);
		}

		ship.setShipDepth(depth);
	}

	/**
	 * Update ship floating behavior.
	 * Ships float on water surface unless sitting or in deep water.
	 */
	public static void updateShipFloating(BasicEntityShip ship) {
		if (ship.level().isClientSide())
			return;

		double depth = ship.getShipDepth();
		double floatingDepth = ship.getShipFloatingDepth();

		// not in water, no floating needed
		if (depth <= 0D) {
			ship.setShipFloatingDepth(0D);
			return;
		}

		// sitting ships sink slightly
		if (ship.isOrderedToSit()) {
			ship.setShipFloatingDepth(Math.min(depth, 0.5D));
			return;
		}

		// calculate target floating depth based on water depth
		// ships try to stay at surface level
		BlockPos pos = ship.blockPosition();
		Level level = ship.level();

		// find water surface
		BlockPos surfacePos = pos;
		while (surfacePos.getY() < level.getMaxBuildHeight()) {
			FluidState above = level.getFluidState(surfacePos.above());
			if (!above.is(FluidTags.WATER)) {
				break;
			}
			surfacePos = surfacePos.above();
		}

		// target Y is the water surface
		double targetY = surfacePos.getY() + 0.1D;
		double currentY = ship.getY();

		// do not set motion here directly, just update floating depth
		// the actual movement is handled by the ship's travel() method and gravity
		ship.setShipFloatingDepth(targetY - currentY);
	}

	/**
	 * Custom movement for ships in fluid.
	 * Called from BasicEntityShip.travel() override.
	 *
	 * Ships move differently in water:
	 * - No gravity in water (floating)
	 * - Horizontal movement uses move speed attribute
	 * - Vertical movement controlled by floating depth
	 */
	public static void moveEntityInFluid(BasicEntityShip ship, Vec3 travelVec) {
		if (!ship.isInWater())
			return;

		double depth = ship.getShipDepth();
		if (depth <= 0D)
			return;

		Vec3 motion = ship.getDeltaMovement();
		double floatingDepth = ship.getShipFloatingDepth();

		// vertical adjustment
		double vy = motion.y;
		if (floatingDepth > 0.1D) {
			// push up toward surface
			vy = Math.min(vy + 0.04D, 0.12D);
		} else if (floatingDepth < -0.1D) {
			// sink if below target depth
			vy = Math.max(vy - 0.02D, -0.08D);
		} else {
			// hover at surface
			vy *= 0.8D;
		}

		// apply drag in water
		double drag = 0.8D;
		ship.setDeltaMovement(motion.x * drag, vy, motion.z * drag);
	}

	/**
	 * Generic floating behavior for any LivingEntity with IShipFloating.
	 * Used by hostile ships (which don't extend BasicEntityShip).
	 */
	public static void updateShipFloatingGeneric(LivingEntity entity, IShipFloating floating) {
		if (entity.level().isClientSide())
			return;

		double depth = floating.getShipDepth();

		if (depth <= 0D) {
			floating.setShipFloatingDepth(0D);
			return;
		}

		BlockPos pos = entity.blockPosition();
		Level level = entity.level();

		// find water surface
		BlockPos surfacePos = pos;
		while (surfacePos.getY() < level.getMaxBuildHeight()) {
			FluidState above = level.getFluidState(surfacePos.above());
			if (!above.is(FluidTags.WATER))
				break;
			surfacePos = surfacePos.above();
		}

		double targetY = surfacePos.getY() + 0.1D;
		double currentY = entity.getY();
		floating.setShipFloatingDepth(targetY - currentY);
	}

	/**
	 * Check if entity is in water.
	 */
	public static boolean isInWater(LivingEntity entity) {
		return entity.isInWater() || entity.level().getFluidState(entity.blockPosition()).is(FluidTags.WATER);
	}

	/**
	 * Get distance squared between two entities.
	 */
	public static double getDistanceSq(LivingEntity a, LivingEntity b) {
		double dx = a.getX() - b.getX();
		double dy = a.getY() - b.getY();
		double dz = a.getZ() - b.getZ();
		return dx * dx + dy * dy + dz * dz;
	}

	/**
	 * Get distance squared between entity and position.
	 */
	public static double getDistanceSq(LivingEntity entity, BlockPos pos) {
		double dx = entity.getX() - pos.getX() - 0.5D;
		double dy = entity.getY() - pos.getY();
		double dz = entity.getZ() - pos.getZ() - 0.5D;
		return dx * dx + dy * dy + dz * dz;
	}

	/**
	 * Check entity moving type for AA/ASM damage modifier.
	 * 
	 * @return 0: default, 1: air mob, 2: water mob
	 */
	public static int checkEntityMovingType(Entity entity) {
		if (entity instanceof IShipAttackBase ship) {
			switch (ship.getDamageType()) {
				case ID.ShipDmgType.AIRPLANE:
					return 1;
				case ID.ShipDmgType.SUBMARINE:
					return 2;
				default:
					return 0;
			}
		} else if (entity instanceof WaterAnimal || entity instanceof Guardian) {
			return 2;
		} else if (entity instanceof Blaze || entity instanceof WitherBoss ||
				entity instanceof EnderDragon || entity instanceof Bat ||
				entity instanceof FlyingMob) {
			return 1;
		}

		return 0;
	}

	/**
	 * Check if entity is standing in liquid.
	 */
	public static boolean checkEntityIsInLiquid(Entity entity) {
		BlockPos pos = new BlockPos(
				net.minecraft.util.Mth.floor(entity.getX()),
				(int) entity.getBoundingBox().minY,
				net.minecraft.util.Mth.floor(entity.getZ()));
		return BlockHelper.checkBlockIsLiquid(entity.level().getBlockState(pos));
	}

	/**
	 * Apply emotes reaction to nearby friendly ships.
	 */
	public static void applyShipEmotesAOE(Level level, double x, double y, double z, double range, int emotesType) {
		if (level.isClientSide()) {
			return;
		}

		// [PORT] 1.10.2 -> 1.20.1: restore legacy AOE emote distribution for ships.
		AABB box = new AABB(x - range, y - range, z - range, x + range, y + range, z + range);
		for (BasicEntityShip ship : level.getEntitiesOfClass(BasicEntityShip.class, box)) {
			if (ship.isAlive()) {
				ship.applyEmotesReaction(emotesType);
			}
		}
	}

	/**
	 * Apply emotes reaction to nearby hostile ships.
	 */
	public static void applyShipEmotesAOEHostile(
			Level level, double x, double y, double z, double range, int emotesType) {
		if (level.isClientSide()) {
			return;
		}

		// [PORT] 1.10.2 -> 1.20.1: restore legacy hostile AOE emote distribution path.
		AABB box = new AABB(x - range, y - range, z - range, x + range, y + range, z + range);
		for (BasicEntityShipHostile ship : level.getEntitiesOfClass(BasicEntityShipHostile.class, box)) {
			if (ship.isAlive()) {
				ship.applyEmotesReaction(emotesType);
			}
		}
	}
}
