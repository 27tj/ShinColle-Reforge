package com.lulan.shincolle.block;

import net.minecraft.world.level.material.MapColor;

public class BlockFrame extends BasicBlockFacing {

    public BlockFrame() {
        super(Properties.of().mapColor(MapColor.NONE).strength(1.0F).noOcclusion());
    }
}
