package com.lulan.shincolle.block;

import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class BlockPolymetalGravel extends FallingBlock {

    public BlockPolymetalGravel() {
        super(Properties.of().mapColor(MapColor.STONE).strength(2.0F).sound(SoundType.GRAVEL));
    }
}
