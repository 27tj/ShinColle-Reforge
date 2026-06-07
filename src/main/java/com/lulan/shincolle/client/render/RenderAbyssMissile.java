package com.lulan.shincolle.client.render;

import com.lulan.shincolle.client.model.ModelAbyssMissile;
import com.lulan.shincolle.entity.other.EntityAbyssMissile;
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
 * Renderer for abyss missiles.
 * Ported from 1.10.2 RenderMiscEntity abyss missile path.
 */
public class RenderAbyssMissile extends EntityRenderer<EntityAbyssMissile> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID,
            "textures/entity/entityabyssmissile.png");

    private final ModelAbyssMissile model;

    public RenderAbyssMissile(EntityRendererProvider.Context context) {
        super(context);
        this.model = new ModelAbyssMissile(context.bakeLayer(ModelAbyssMissile.LAYER_LOCATION));
        this.shadowRadius = 0F;
    }

    @Override
    public ResourceLocation getTextureLocation(EntityAbyssMissile entity) {
        return TEXTURE;
    }

    @Override
    public void render(EntityAbyssMissile entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight) {
        if (entity.tickCount < 2) {
            return;
        }

        poseStack.pushPose();
        poseStack.translate(0D, 0.3D, 0D);
        poseStack.translate(0D, -0.65D, 0.1D);

        float yaw = Mth.lerp(partialTick, entity.yRotO, entity.getYRot());
        float pitch = Mth.lerp(partialTick, entity.xRotO, entity.getXRot());
        this.model.setupAnim(entity, partialTick, 0F, 0F, yaw, pitch);

        VertexConsumer vertexConsumer = buffer.getBuffer(this.model.renderType(TEXTURE));
        this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY,
                1F, 1F, 1F, 1F);
        poseStack.popPose();

        super.render(entity, entityYaw, partialTick, poseStack, buffer, packedLight);
    }
}