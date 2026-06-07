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
 * MISS / CRITICAL / DOUBLE HIT / TRIPLE HIT / DODGE text particle.
 * Type 0: miss, 1: critical, 2: double hit, 3: triple hit, 4: dodge
 * <p>
 * Ported from 1.10.2. Uses custom texture billboard rendering (CUSTOM render
 * type).
 */
@OnlyIn(Dist.CLIENT)
public class ParticleTexts extends Particle {

    private static final ResourceLocation TEXTURE = new ResourceLocation("shincolle",
            "textures/particles/particletexts.png");
    private final int particleType; // 0:miss 1:critical 2:double hit 3:triple hit 4:dodge
    private final float pScale;

    public ParticleTexts(ClientLevel level, double posX, double posY, double posZ, float scale, int type) {
        super(level, posX, posY, posZ);
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0.1D;
        this.pScale = scale;
        this.lifetime = 25;
        this.particleType = type;
        this.hasPhysics = false;
    }

    @Override
    public void render(VertexConsumer buffer, Camera camera, float partialTick) {
        Vec3 camPos = camera.getPosition();
        float px = (float) (Mth.lerp(partialTick, this.xo, this.x) - camPos.x());
        float py = (float) (Mth.lerp(partialTick, this.yo, this.y) - camPos.y());
        float pz = (float) (Mth.lerp(partialTick, this.zo, this.z) - camPos.z());

        // UV coordinates - texture is divided into 5 rows (one per type)
        float u0 = 0F;
        float u1 = 1F;
        float v0 = particleType / 5F;
        float v1 = (particleType + 1F) / 5F;

        float halfWidth = 0.8F;

        // Billboard: only rotate around Y axis (face player horizontally), slight
        // vertical offset
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

        // X and Z offsets use only cosYaw/sinYaw (no pitch component), Y offset uses
        // cosPitch
        builder.vertex(px - cosYaw * halfWidth, py - cosPitch * 0.2F, pz - sinYaw * halfWidth)
                .uv(u1, v1).color(1F, 1F, 1F, 1F).endVertex();
        builder.vertex(px - cosYaw * halfWidth, py + cosPitch * 0.2F, pz - sinYaw * halfWidth)
                .uv(u1, v0).color(1F, 1F, 1F, 1F).endVertex();
        builder.vertex(px + cosYaw * halfWidth, py + cosPitch * 0.2F, pz + sinYaw * halfWidth)
                .uv(u0, v0).color(1F, 1F, 1F, 1F).endVertex();
        builder.vertex(px + cosYaw * halfWidth, py - cosPitch * 0.2F, pz + sinYaw * halfWidth)
                .uv(u0, v1).color(1F, 1F, 1F, 1F).endVertex();

        tesselator.end();

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

        this.move(this.xd, this.yd, this.zd);
        this.yd *= 0.9D;
    }

}
