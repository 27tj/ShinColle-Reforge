package com.lulan.shincolle.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;

public class BasicBlock extends Block {

    public BasicBlock(Properties properties) {
        super(properties);
    }

    public BasicBlock() {
        super(Properties.of().mapColor(MapColor.STONE).strength(3.0F));
    }
}
