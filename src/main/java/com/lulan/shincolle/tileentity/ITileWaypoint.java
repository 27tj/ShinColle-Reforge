package com.lulan.shincolle.tileentity;

import com.lulan.shincolle.entity.IShipOwner;

import net.minecraft.core.BlockPos;

/**
 * Interface for waypoint tile entities.
 * Supports linked waypoint navigation and paired chest interaction.
 */
public interface ITileWaypoint extends IShipOwner, ITileGuardPoint {

	/** Last waypoint position */
	void setLastWaypoint(BlockPos pos);

	BlockPos getLastWaypoint();

	/** Next waypoint position */
	void setNextWaypoint(BlockPos pos);

	BlockPos getNextWaypoint();

	/** Waypoint stay time */
	void setWpStayTime(int time);

	int getWpStayTime();

	/** Paired chest position */
	void setPairedChest(BlockPos pos);

	BlockPos getPairedChest();
}
