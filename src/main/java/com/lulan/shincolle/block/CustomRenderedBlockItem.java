package com.lulan.shincolle.block;

import com.lulan.shincolle.client.render.block.ShipBlockItemRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

/**
 * BlockItem that uses a custom BEWLR for rendering in hand/inventory.
 * Used for blocks with ENTITYBLOCK_ANIMATED render shape (desk, small
 * shipyard).
 */
public class CustomRenderedBlockItem extends BlockItem {

    public CustomRenderedBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return ShipBlockItemRenderer.getInstance();
            }
        });
    }
}
