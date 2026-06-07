package com.lulan.shincolle.block;

import net.minecraft.world.level.block.FallingBlock;

/**
 * Abstract base class for falling blocks in ShinColle.
 * Extends FallingBlock (1.20.1 replacement for BlockFalling).
 */
public abstract class BasicBlockFalling extends FallingBlock {

    public BasicBlockFalling() {
        this(Properties.of().strength(0.5F));
    }

    public BasicBlockFalling(Properties properties) {
        super(properties);
    }
}
