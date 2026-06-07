package com.lulan.shincolle.ai;

import com.lulan.shincolle.entity.IShipNavigator;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.EnumSet;

/**
 * Open door goal.
 * Ported from EntityAIShipOpenDoor (setMutexBits: 0)
 */
public class ShipOpenDoorGoal extends Goal {

    private final Mob entity;
    private final boolean closeDoor;
    private BlockPos doorPos;
    private int waitTimer;

    public ShipOpenDoorGoal(IShipNavigator host, boolean closeDoor) {
        this.entity = (Mob) host;
        this.closeDoor = closeDoor;
        this.setFlags(EnumSet.noneOf(Goal.Flag.class));
    }

    @Override
    public boolean canUse() {
        if (this.entity.horizontalCollision) {
            // check nearby for doors
            BlockPos pos = this.entity.blockPosition();
            for (BlockPos checkPos : new BlockPos[]{
                    pos.north(), pos.south(), pos.east(), pos.west()}) {
                BlockState state = this.entity.level().getBlockState(checkPos);
                if (state.getBlock() instanceof DoorBlock || state.getBlock() instanceof FenceGateBlock) {
                    this.doorPos = checkPos;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean canContinueToUse() {
        return this.closeDoor && this.waitTimer > 0;
    }

    @Override
    public void start() {
        this.waitTimer = 20;
        if (this.doorPos != null) {
            // open door
            BlockState state = this.entity.level().getBlockState(this.doorPos);
            if (state.getBlock() instanceof DoorBlock door) {
                door.setOpen(this.entity, this.entity.level(), state, this.doorPos, true);
            } else if (state.getBlock() instanceof FenceGateBlock) {
                this.entity.level().setBlock(this.doorPos, state.setValue(FenceGateBlock.OPEN, true), 10);
            }
        }
    }

    @Override
    public void stop() {
        if (this.closeDoor && this.doorPos != null) {
            BlockState state = this.entity.level().getBlockState(this.doorPos);
            if (state.getBlock() instanceof DoorBlock door) {
                door.setOpen(this.entity, this.entity.level(), state, this.doorPos, false);
            } else if (state.getBlock() instanceof FenceGateBlock) {
                this.entity.level().setBlock(this.doorPos, state.setValue(FenceGateBlock.OPEN, false), 10);
            }
        }
        this.doorPos = null;
    }

    @Override
    public void tick() {
        --this.waitTimer;
    }
}
