package com.lulan.shincolle.client.render;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

/**
 * Invisible/no-op renderer for non-living entities (missiles, projectiles, fishing hook).
 * These entities render nothing until Phase 7.
 */
public class NoopEntityRenderer<T extends Entity> extends EntityRenderer<T> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation("shincolle", "textures/entity/placeholder.png");

    public NoopEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return TEXTURE;
    }
}
