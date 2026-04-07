package com.lulan.shincolle.block;

import net.minecraft.world.level.material.MapColor;

public class BlockVolBlock extends BasicBlock {

    public BlockVolBlock() {
        super(Properties.of().mapColor(MapColor.SAND).strength(2.0F).lightLevel(s -> 15));
    }
}
