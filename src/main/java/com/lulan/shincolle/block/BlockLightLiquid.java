package com.lulan.shincolle.block;

import com.lulan.shincolle.init.ModBlockEntities;
import com.lulan.shincolle.tileentity.TileEntityLightBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import javax.annotation.Nullable;

public class BlockLightLiquid extends BasicBlockContainer {

    public BlockLightLiquid() {
        super(Properties.of().mapColor(MapColor.NONE).noOcclusion().lightLevel(s -> 15));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TileEntityLightBlock(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state,
                                                                  BlockEntityType<T> type) {
        return level.isClientSide ? null
                : createTickerHelper(type, ModBlockEntities.LIGHT_BLOCK.get(), TileEntityLightBlock::serverTick);
    }
}
