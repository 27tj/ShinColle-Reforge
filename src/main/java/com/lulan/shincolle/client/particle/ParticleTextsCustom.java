package com.lulan.shincolle.client.particle;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * CUSTOM TEXT PARTICLE
 * Displays arbitrary text above a target position or entity.
 * <p>
 * Type 0: draw string at fixed position with specified #lines and width
 * Type 1: draw string following an entity with offset
 * <p>
 * Ported from 1.10.2 to 1.20.1.
 */
@OnlyIn(Dist.CLIENT)
public class ParticleTextsCustom extends Particle {

    private final int particleType;
    private final Font font;
    private final Entity host;
    private final float pScale;
    private int textWidth;
    private int textHeight;
    private double[] parms;
    private String text;

    public ParticleTextsCustom(Entity host, ClientLevel level, double posX, double posY, double posZ,
                               float scale, int type, String text, int... parms) {
        super(level, 0D, 0D, 0D);
        this.xd = 0D;
        this.yd = 0D;
        this.zd = 0D;
        this.pScale = scale;
        this.particleType = type;
        this.hasPhysics = false;
        this.host = host;

        this.font = Minecraft.getInstance().font;

        switch (type) {
            case 0: // draw string at fixed position with specific #lines and width
                this.lifetime = 30;
                this.textHeight = parms[0] - 1;
                this.textWidth = parms[1] / 2;
                this.text = text;
                this.setPos(posX, posY, posZ);
                break;
            case 1: // draw string following entity
                this.lifetime = 30;
                this.textHeight = parms[0] - 1;
                this.textWidth = parms[1] / 2;
                this.text = text;
                this.parms = new double[]{posX, posY, posZ};
                this.setPos(this.host.getX() + this.parms[0],
                        this.host.getY() + this.parms[1],
                        this.host.getZ() + this.parms[2]);
                break;
        }

        // init position
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
    }

    @Override
    public void render(VertexConsumer buffer, Camera camera, float partialTick) {
        Vec3 camPos = camera.getPosition();
        float px = (float) (Mth.lerp(partialTick, this.xo, this.x) - camPos.x());
        float py = (float) (Mth.lerp(partialTick, this.yo, this.y) - camPos.y());
        float pz = (float) (Mth.lerp(partialTick, this.zo, this.z) - camPos.z());

        // Use PoseStack for transform operations (translate, rotate, scale)
        PoseStack poseStack = new PoseStack();
        poseStack.pushPose();
        poseStack.translate(px, py, pz);

        // Billboard rotation: face the camera
        poseStack.mulPose(Axis.YP.rotationDegrees(-camera.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(camera.getXRot()));

        // Scale (original used -0.025 for X/Y to flip, 0.025 for Z)
        poseStack.scale(-0.025F, -0.025F, 0.025F);

        // Render background quad using POSITION_COLOR shader
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(false);
        RenderSystem.disableCull();

        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder builder = tesselator.getBuilder();
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);

        float left = -this.textWidth - 1;
        float right = this.textWidth + 1;
        float top = 8F;
        float bottom = -1F - this.textHeight * 9F;

        // Transform the quad corners through the PoseStack
        org.joml.Matrix4f matrix = poseStack.last().pose();

        builder.vertex(matrix, left, bottom, 0F).color(0F, 0F, 0F, 0.25F).endVertex();
        builder.vertex(matrix, left, top, 0F).color(0F, 0F, 0F, 0.25F).endVertex();
        builder.vertex(matrix, right, top, 0F).color(0F, 0F, 0F, 0.25F).endVertex();
        builder.vertex(matrix, right, bottom, 0F).color(0F, 0F, 0F, 0.25F).endVertex();

        tesselator.end();

        // Render text using Font
        RenderSystem.depthMask(true);

        MultiBufferSource.BufferSource bufferSource = MultiBufferSource
                .immediate(Tesselator.getInstance().getBuilder());

        // Split and draw text lines manually (replacing drawSplitString)
        int lineWidth = this.textWidth * 2;
        java.util.List<net.minecraft.util.FormattedCharSequence> lines = this.font
                .split(net.minecraft.network.chat.Component.literal(this.text), lineWidth);

        int yOffset = -this.textHeight * 9;
        for (net.minecraft.util.FormattedCharSequence line : lines) {
            this.font.drawInBatch(line, -this.textWidth, yOffset, 0xFFFFFFFF,
                    false, poseStack.last().pose(), bufferSource,
                    Font.DisplayMode.NORMAL, 0, 0xF000F0);
            yOffset += 9;
        }

        bufferSource.endBatch();

        poseStack.popPose();

        RenderSystem.enableCull();
        RenderSystem.disableBlend();
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.CUSTOM;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;

        if (this.age++ > this.lifetime) {
            this.remove();
            return;
        }

        if (this.particleType == 1) {
            if (this.host == null || !this.host.isAlive()) {
                this.remove();
                return;
            }

            this.setPos(this.host.getX() + this.parms[0],
                    this.host.getY() + this.parms[1],
                    this.host.getZ() + this.parms[2]);
        }
    }

}
