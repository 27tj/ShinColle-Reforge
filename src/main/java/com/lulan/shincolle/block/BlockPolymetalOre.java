package com.lulan.shincolle.block;

import net.minecraft.world.level.material.MapColor;

public class BlockPolymetalOre extends BasicBlock {

    public BlockPolymetalOre() {
        super(Properties.of().mapColor(MapColor.STONE).strength(3.0F, 3.0F).requiresCorrectToolForDrops());
    }
}
