package com.lulan.shincolle.client.render;

import com.lulan.shincolle.entity.other.EntityShipFishingHook;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * Renderer for the ship fishing hook entity.
 * Draws a billboard hook sprite and a fishing line from the hook to the host
 * ship.
 * <p>
 * Ported from 1.10.2 RenderShipFishing to 1.20.1 EntityRenderer system.
 */
@OnlyIn(Dist.CLIENT)
public class RenderShipFishing extends EntityRenderer<EntityShipFishingHook> {

    /**
     * Vanilla particle atlas used for the hook sprite
     */
    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/particle/particles.png");

    public RenderShipFishing(EntityRendererProvider.Context context) {
        super(context);
    }

    private static void hookVertex(VertexConsumer consumer, PoseStack.Pose pose,
                                   float x, float y, float z, float u, float v, int light) {
        consumer.vertex(pose.pose(), x, y, z)
                .color(255, 255, 255, 255)
                .uv(u, v)
                .overlayCoords(OverlayTexture.NO_OVERLAY)
                .uv2(light)
                .normal(pose.normal(), 0F, 1F, 0F)
                .endVertex();
    }

    @Override
    public void render(EntityShipFishingHook entity, float entityYaw, float partialTick,
                       PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        LivingEntity host = entity.getHost();

        // Bobbing offset
        float bobOffset = Mth.cos((entity.tickCount + partialTick) * 0.15F) * 0.05F - 0.25F;

        // ========== Render hook billboard ==========
        poseStack.pushPose();
        poseStack.translate(0.0F, bobOffset + 0.25F, 0.0F);

        // Billboard: face camera
        poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
        poseStack.scale(0.5F, 0.5F, 0.5F);

        // Draw hook quad from particle atlas
        // UV coords for fishing hook sprite in particles.png
        float u0 = 0.0625F, u1 = 0.125F;
        float v0 = 0.125F, v1 = 0.1875F;

        VertexConsumer hookConsumer = buffer.getBuffer(RenderType.entityCutout(TEXTURE));
        PoseStack.Pose hookPose = poseStack.last();
        hookVertex(hookConsumer, hookPose, -0.5F, -0.5F, 0F, u0, v1, packedLight);
        hookVertex(hookConsumer, hookPose, 0.5F, -0.5F, 0F, u1, v1, packedLight);
        hookVertex(hookConsumer, hookPose, 0.5F, 0.5F, 0F, u1, v0, packedLight);
        hookVertex(hookConsumer, hookPose, -0.5F, 0.5F, 0F, u0, v0, packedLight);

        poseStack.popPose();

        // ========== Render fishing line to host ==========
        if (host != null) {
            poseStack.pushPose();

            // Calculate host hand position in world space
            float bodyYaw = Mth.lerp(partialTick, host.yBodyRotO, host.yBodyRot)
                    * Mth.DEG_TO_RAD;
            double sinYaw = Mth.sin(bodyYaw);
            double cosYaw = Mth.cos(bodyYaw);
            double handWidth = host.getBbWidth();

            double hostX = Mth.lerp(partialTick, host.xOld, host.getX())
                    - cosYaw * 0.25D - sinYaw * handWidth;
            double hostY = Mth.lerp(partialTick, host.yOld, host.getY())
                    + host.getEyeHeight() * 0.7D - 0.45D + host.getBbHeight() * 0.2D;
            double hostZ = Mth.lerp(partialTick, host.zOld, host.getZ())
                    - sinYaw * 0.25D + cosYaw * handWidth;

            // Hook position in world space
            double hookX = Mth.lerp(partialTick, entity.xOld, entity.getX());
            double hookY = Mth.lerp(partialTick, entity.yOld, entity.getY())
                    + 0.55D + bobOffset;
            double hookZ = Mth.lerp(partialTick, entity.zOld, entity.getZ());

            // Delta from hook to host (PoseStack is already at entity position)
            float dx = (float) (hostX - hookX);
            float dy = (float) (hostY - hookY);
            float dz = (float) (hostZ - hookZ);

            VertexConsumer lineConsumer = buffer.getBuffer(RenderType.lines());
            PoseStack.Pose linePose = poseStack.last();

            int segments = 16;
            for (int i = 0; i < segments; i++) {
                float t0 = (float) i / segments;
                float t1 = (float) (i + 1) / segments;

                // Catenary curve positions
                float x0 = dx * t0;
                float y0 = bobOffset + 0.25F
                        + dy * (t0 * t0 + t0) * 0.5F
                        + (segments - i) / 18F + 0.125F;
                float z0 = dz * t0;

                float x1 = dx * t1;
                float y1 = bobOffset + 0.25F
                        + dy * (t1 * t1 + t1) * 0.5F
                        + (segments - (i + 1)) / 18F + 0.125F;
                float z1 = dz * t1;

                lineConsumer.vertex(linePose.pose(), x0, y0, z0)
                        .color(200, 200, 200, 255)
                        .normal(linePose.normal(), 0F, 1F, 0F)
                        .endVertex();
                lineConsumer.vertex(linePose.pose(), x1, y1, z1)
                        .color(200, 200, 200, 255)
                        .normal(linePose.normal(), 0F, 1F, 0F)
                        .endVertex();
            }

            poseStack.popPose();
        }

        super.render(entity, entityYaw, partialTick, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityShipFishingHook entity) {
        return TEXTURE;
    }
}
