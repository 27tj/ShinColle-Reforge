package com.lulan.shincolle.block;

import com.lulan.shincolle.item.IShipResourceItem;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

/**
 * Custom BlockItem for resource blocks that implements IShipResourceItem.
 * Allows ships to consume these blocks as fuel/resources.
 * <p>
 * Resource values per block type:
 * - Grudge Block: {9, 0, 0, 0}
 * - Abyssium Block: {0, 9, 0, 0}
 * - GrudgeHeavyDeco: {81, 0, 0, 0}
 * - Polymetal: {0, 0, 0, 9}
 * - Polymetal Gravel: {0, 0, 0, 4}
 */
public class ItemBlockResourceBlock extends BlockItem implements IShipResourceItem {

    private final int[] resourceValues;

    public ItemBlockResourceBlock(Block block, Properties properties, int[] resourceValues) {
        super(block, properties);
        this.resourceValues = resourceValues;
    }

    @Override
    public int[] getResourceValue(int meta) {
        return resourceValues;
    }
}
