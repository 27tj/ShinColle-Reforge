package com.lulan.shincolle.block;

import com.lulan.shincolle.tileentity.TileMultiPolymetal;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public class BlockPolymetal extends BasicBlockMulti {

    public BlockPolymetal() {
        super(Properties.of().mapColor(MapColor.METAL).strength(3.0F));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TileMultiPolymetal(pos, state);
    }
}
