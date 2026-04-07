package com.lulan.shincolle.block;

import net.minecraft.world.level.material.MapColor;

public class BlockAbyssium extends BasicBlock {

    public BlockAbyssium() {
        super(Properties.of().mapColor(MapColor.METAL).strength(3.0F, 6.0F).requiresCorrectToolForDrops());
    }
}
