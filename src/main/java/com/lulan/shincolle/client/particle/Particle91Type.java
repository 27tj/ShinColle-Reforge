package com.lulan.shincolle.client.particle;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * 91TYPE PARTICLE
 * Attack text effect with 6 characters that fade in/out individually.
 * <p>
 * Animation phases per character:
 * age 0~15: color fade in (scale shrinks from 3x to 1x, alpha rises 0 to 1)
 * age 16~75: stable (scale 1x, alpha 1)
 * age 76~91: alpha fade out (scale grows from 1x to 3x, alpha drops 1 to 0)
 * <p>
 * Each character is offset by 8 ticks from the previous.
 * <p>
 * Ported from 1.10.2 to 1.20.1.
 */
@OnlyIn(Dist.CLIENT)
public class Particle91Type extends Particle {

    private static final ResourceLocation TEXTURE = new ResourceLocation("shincolle",
            "textures/particles/particle91type.png");
    private final int fadeTime = 16;
    private final int middTime = 60;
    private final int totalTime = 2 * fadeTime + middTime;
    private final float fadeCoef = 1F / fadeTime;
    private final float pScale;
    private int partAge;
    private float minu, maxu, cx, cy, cz, charScale, charAlpha;

    public Particle91Type(ClientLevel level, double posX, double posY, double posZ, float scale) {
        super(level, 0D, 0D, 0D);
        this.setPos(posX, posY + this.random.nextDouble() * 4D, posZ);
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.pScale = scale;
        this.lifetime = 136;
        this.hasPhysics = false;
    }

    @Override
    public void render(VertexConsumer buffer, Camera camera, float partialTick) {
        Vec3 camPos = camera.getPosition();
        float px = (float) (Mth.lerp(partialTick, this.xo, this.x) - camPos.x());
        float py = (float) (Mth.lerp(partialTick, this.yo, this.y) - camPos.y());
        float pz = (float) (Mth.lerp(partialTick, this.zo, this.z) - camPos.z());

        // Billboard rotation from camera
        float yaw = camera.getYRot() * Mth.DEG_TO_RAD;
        float cosYaw = Mth.cos(yaw);
        float sinYaw = Mth.sin(yaw);
        float pitch = camera.getXRot() * Mth.DEG_TO_RAD;
        float cosPitch = Mth.cos(pitch);

        // Set up rendering
        RenderSystem.setShaderTexture(0, TEXTURE);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(true);
        RenderSystem.disableCull();

        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder builder = tesselator.getBuilder();
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);

        // Draw 6 characters, each offset by 8 ticks
        for (int i = 0; i < 6; ++i) {
            partAge = this.age - i * 8;

            if (partAge > -1 && partAge < totalTime) {
                minu = 1F / 6F * i;
                maxu = 1F / 6F * (i + 1);

                // Each character is offset horizontally along the camera's X axis
                cx = px - (i - 2.5F) * this.pScale * 2F * cosYaw;
                cy = py;
                cz = pz - (i - 2.5F) * this.pScale * 2F * sinYaw;

                if (partAge < fadeTime) {
                    // Fade in: scale shrinks from 3x to 1x, alpha rises from 0 to 1
                    charScale = this.pScale * (3F - 2F * fadeCoef * partAge);
                    charAlpha = fadeCoef * partAge;
                } else if (partAge >= (fadeTime + middTime)) {
                    // Fade out: scale grows from 1x to 3x, alpha drops from 1 to 0
                    int fadeAge = partAge - (fadeTime + middTime);
                    charScale = this.pScale * (1F + 2F * fadeCoef * fadeAge);
                    charAlpha = 1F - fadeCoef * fadeAge;
                } else {
                    // Stable
                    charScale = this.pScale;
                    charAlpha = 1F;
                }

                addQuad(builder, charScale, cx, cy, cz, cosYaw, cosPitch, sinYaw, minu, maxu, 0F, 1F);
            }
        }

        tesselator.end();

        RenderSystem.enableCull();
        RenderSystem.disableBlend();
    }

    /**
     * Add a quad with the given size and UV coordinates.
     */
    private void addQuad(BufferBuilder builder, float scale, float x, float y, float z,
                         float offx, float offy, float offz,
                         float minu, float maxu, float minv, float maxv) {
        float offsetX = offx * scale;
        float offsetY = offy * scale;
        float offsetZ = offz * scale;

        builder.vertex(x - offsetX, y - offsetY, z - offsetZ).uv(maxu, maxv).color(1F, 1F, 1F, charAlpha).endVertex();
        builder.vertex(x - offsetX, y + offsetY, z - offsetZ).uv(maxu, minv).color(1F, 1F, 1F, charAlpha).endVertex();
        builder.vertex(x + offsetX, y + offsetY, z + offsetZ).uv(minu, minv).color(1F, 1F, 1F, charAlpha).endVertex();
        builder.vertex(x + offsetX, y - offsetY, z + offsetZ).uv(minu, maxv).color(1F, 1F, 1F, charAlpha).endVertex();
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.CUSTOM;
    }

    @Override
    public void tick() {
        if (this.age++ > this.lifetime) {
            this.remove();
        }
    }

}
