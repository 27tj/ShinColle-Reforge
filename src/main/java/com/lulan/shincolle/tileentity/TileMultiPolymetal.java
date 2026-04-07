package com.lulan.shincolle.tileentity;

import com.lulan.shincolle.init.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Block entity for Polymetal multiblock structure components.
 * Stores a reference to the core block position via BasicTileMulti.
 */
public class TileMultiPolymetal extends BasicTileMulti {

    public TileMultiPolymetal(BlockPos pos, BlockState state) {
        this(ModBlockEntities.POLYMETAL_MULTI.get(), pos, state);
    }

    public TileMultiPolymetal(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
}
