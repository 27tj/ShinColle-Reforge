package com.lulan.shincolle.tileentity;

import com.lulan.shincolle.init.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Block entity for invisible light source blocks.
 * Used for both air and liquid light variants.
 * Stores a tick counter for automatic removal after a set duration.
 */
public class TileEntityLightBlock extends BasicTileEntity {

    private int ticksRemaining = 200;

    public TileEntityLightBlock(BlockPos pos, BlockState state) {
        this(ModBlockEntities.LIGHT_BLOCK.get(), pos, state);
    }

    public TileEntityLightBlock(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, TileEntityLightBlock tile) {
        tile.ticksRemaining--;
        if (tile.ticksRemaining <= 0) {
            level.removeBlock(pos, false);
        }
    }

    public int getTicksRemaining() {
        return ticksRemaining;
    }

    // ==================== Tick Logic ====================

    public void setTicksRemaining(int ticks) {
        this.ticksRemaining = ticks;
        setChanged();
    }

    // ==================== NBT ====================

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("TicksRemaining", ticksRemaining);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains("TicksRemaining")) {
            ticksRemaining = tag.getInt("TicksRemaining");
        }
    }
}
