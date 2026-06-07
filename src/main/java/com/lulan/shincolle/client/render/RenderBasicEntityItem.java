package com.lulan.shincolle.client.render;

import com.lulan.shincolle.client.model.ModelBasicEntityItem;
import com.lulan.shincolle.entity.other.BasicEntityItem;
import com.lulan.shincolle.reference.Reference;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

/**
 * Renderer for BasicEntityItem.
 * Ported from 1.10.2 RenderBasicEntityItem with pulsing alpha/scale.
 */
public class RenderBasicEntityItem extends EntityRenderer<BasicEntityItem> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID,
            "textures/entity/modelbasicentityitem.png");

    private final ModelBasicEntityItem model;

    public RenderBasicEntityItem(EntityRendererProvider.Context context) {
        super(context);
        this.model = new ModelBasicEntityItem(context.bakeLayer(ModelBasicEntityItem.LAYER_LOCATION));
        this.shadowRadius = 0F;
    }

    @Override
    public ResourceLocation getTextureLocation(BasicEntityItem entity) {
        return TEXTURE;
    }

    @Override
    public void render(BasicEntityItem entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight) {
        float age = entity.tickCount + partialTick;
        float pulse = Mth.cos(age * 0.12F) * 0.5F;
        float alpha = pulse < 0F ? 0.9F + pulse : 0.9F - pulse;
        float scale = pulse < 0F ? 0.25F - pulse * 0.5F : 0.25F + pulse * 1.25F;

        poseStack.pushPose();
        poseStack.translate(0D, 0.1D, 0D);
        poseStack.scale(scale, scale, scale);

        this.model.setupAnim(entity, age, 0F, 0F, 0F, 0F);
        VertexConsumer vertexConsumer = buffer.getBuffer(this.model.renderType(TEXTURE));
        this.model.renderToBuffer(poseStack, vertexConsumer, 0xF000F0, OverlayTexture.NO_OVERLAY,
                1F, 1F, 1F, alpha);
        poseStack.popPose();

        super.render(entity, entityYaw, partialTick, poseStack, buffer, packedLight);
    }
}