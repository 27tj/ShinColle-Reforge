package com.lulan.shincolle.client.render;

import com.lulan.shincolle.entity.IShipEmotion;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;

import java.util.function.Function;

/**
 * Configurable renderer for Mob entities that are not BasicEntityShip.
 * Used for hostile ships, mounts, airplanes, summons.
 */
public class PlaceholderMobRenderer<T extends Mob> extends MobRenderer<T, EntityModel<T>> {

    private final ResourceLocation texture;
    private final float baseShadowRadius;

    @SuppressWarnings("unchecked")
    public PlaceholderMobRenderer(EntityRendererProvider.Context context, EntityModel<?> model,
                                  ResourceLocation texture, float shadowRadius) {
        super(context, (EntityModel<T>) model, shadowRadius);
        this.texture = texture;
        this.baseShadowRadius = shadowRadius;
    }

    /**
     * Factory method for creating per-entity renderer providers.
     */
    public static <T extends Mob> EntityRendererProvider<T> factory(
            ModelLayerLocation layerLocation,
            Function<net.minecraft.client.model.geom.ModelPart, ? extends EntityModel<T>> modelFactory,
            ResourceLocation texture,
            float shadowRadius) {
        return context -> {
            EntityModel<T> model = modelFactory.apply(context.bakeLayer(layerLocation));
            return new PlaceholderMobRenderer<>(context, model, texture, shadowRadius);
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

    @Override
    protected void scale(T entity, PoseStack poseStack, float partialTick) {
        // [PORT] 1.10.2 -> 1.20.1: keep legacy shadow scaling semantics without
        // per-frame accumulation.
        float adjustedShadowRadius = this.baseShadowRadius;
        if (entity instanceof IShipEmotion shipEmotion) {
            adjustedShadowRadius += Math.max(0, shipEmotion.getScaleLevel()) * 0.4F;
        }
        this.shadowRadius = adjustedShadowRadius;
    }
}
