package com.lulan.shincolle.block;

import com.lulan.shincolle.tileentity.TileEntityWaypoint;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public class BlockWaypoint extends BasicBlockContainer {

    public BlockWaypoint() {
        super(Properties.of().mapColor(MapColor.NONE).strength(1.0F).noOcclusion().noCollission());
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TileEntityWaypoint(pos, state);
    }
}
