package com.lulan.shincolle.client.render;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Function;

/**
 * Configurable renderer for ship entities.
 * Each entity type provides its own model and texture via the factory method.
 */
public class ShipEntityRenderer<T extends BasicEntityShip> extends MobRenderer<T, EntityModel<T>> {

    private final ResourceLocation texture;
    private final float baseShadowRadius;

    @SuppressWarnings("unchecked")
    public ShipEntityRenderer(EntityRendererProvider.Context context, EntityModel<?> model,
                              ResourceLocation texture, float shadowRadius) {
        super(context, (EntityModel<T>) model, shadowRadius);
        this.texture = texture;
        this.baseShadowRadius = shadowRadius;
        this.addLayer(new LayerShipHeldItem<>(this));
    }

    /**
     * Factory method for creating per-entity renderer providers.
     */
    public static <T extends BasicEntityShip> EntityRendererProvider<T> factory(
            ModelLayerLocation layerLocation,
            Function<net.minecraft.client.model.geom.ModelPart, ? extends EntityModel<T>> modelFactory,
            ResourceLocation texture,
            float shadowRadius) {
        return context -> {
            EntityModel<T> model = modelFactory.apply(context.bakeLayer(layerLocation));
            return new ShipEntityRenderer<>(context, model, texture, shadowRadius);
        };
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return texture;
    }

    /**
     * Disable vanilla death rotation. Ship models handle their own
     * dead/NoFuel pose via applyDeadPose() in their setupAnim() method.
     * Matches original mod's getDeathMaxRotation() returning 0F.
     */
    @Override
    protected float getFlipDegrees(T entity) {
        return 0F;
    }

    /**
     * Apply scale adjustments based on scale level.
     * Only adjust shadow size - visual scaling is handled by the model's
     * scale/offsetY fields in renderToBuffer().
     */
    @Override
    protected void scale(T entity, PoseStack poseStack, float partialTick) {
        // [PORT] 1.10.2 -> 1.20.1: RenderBasic#setShadowSize() was recalculated every
        // frame.
        // Avoid cumulative growth by rebuilding shadow size from the renderer's base
        // radius.
        this.shadowRadius = this.baseShadowRadius + Math.max(0, entity.getScaleLevel()) * 0.4F;
    }
}
