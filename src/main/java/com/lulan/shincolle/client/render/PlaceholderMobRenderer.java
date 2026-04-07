package com.lulan.shincolle.client.render;

import java.util.function.Function;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;

/**
 * Configurable renderer for Mob entities that are not BasicEntityShip.
 * Used for hostile ships, mounts, airplanes, summons.
 */
public class PlaceholderMobRenderer<T extends Mob> extends MobRenderer<T, EntityModel<T>> {

	private final ResourceLocation texture;

	@SuppressWarnings("unchecked")
	public PlaceholderMobRenderer(EntityRendererProvider.Context context, EntityModel<?> model,
			ResourceLocation texture, float shadowRadius) {
		super(context, (EntityModel<T>) model, shadowRadius);
		this.texture = texture;
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
}
