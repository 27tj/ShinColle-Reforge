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
 * LASER PARTICLE
 * Given host position and target position, generates a laser beam effect.
 * Used by RE-CLASS and some Hime-class entities.
 * <p>
 * type: 0: lasts 11 ticks
 * 1: NGT speed blur
 */
@OnlyIn(Dist.CLIENT)
public class ParticleLaser extends Particle {

    private static final ResourceLocation TEXTURE = new ResourceLocation("shincolle",
            "textures/particles/particlelaser.png");
    private final int particleType;
    private final double tarX;
    private final double tarY;
    private final double tarZ;
    private final float particleScale;

    public ParticleLaser(ClientLevel level, double posX, double posY, double posZ, double tarX, double tarY,
                         double tarZ, float scale, int type) {
        super(level, posX, posY, posZ);
        this.setBoundingBox(this.getBoundingBox().inflate(0));
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleScale = scale;
        this.particleType = type;
        this.tarX = tarX;
        this.tarY = tarY;
        this.tarZ = tarZ;
        this.hasPhysics = false;

        switch (type) {
            case 0: // re-class laser
                this.lifetime = 11;
                this.rCol = 1F;
                this.gCol = 1F;
                this.bCol = 1F;
                this.alpha = 1F;
                break;
            case 1: // NGT speed blur
                this.lifetime = 11;
                this.age = 4;
                this.rCol = 1F;
                this.gCol = 0F;
                this.bCol = 0F;
                this.alpha = 1F;
                break;
        }
    }

    @Override
    public void render(VertexConsumer buffer, Camera camera, float partialTick) {
        Vec3 camPos = camera.getPosition();

        // particle positions relative to camera
        double f11 = Mth.lerp(partialTick, this.xo, this.x) - camPos.x();
        double f12 = Mth.lerp(partialTick, this.yo, this.y) - camPos.y();
        double f13 = Mth.lerp(partialTick, this.zo, this.z) - camPos.z();
        double f21 = this.tarX - camPos.x();
        double f22 = this.tarY - camPos.y();
        double f23 = this.tarZ - camPos.z();

        float minU = 0.0f;
        float maxU = (this.random.nextInt(32) + 32) / 64.0f;
        float minV = this.age % 12 / 12F;
        float maxV = minV + 0.08333333F;

        RenderSystem.setShaderTexture(0, TEXTURE);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(true);
        RenderSystem.disableCull();

        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder builder = tesselator.getBuilder();
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);

        // Note: only one side of a quad face is visible, so draw both front and back (8
        // vertices total)
        // For front face, vertices must be in order: bottom-right -> top-right ->
        // top-left -> bottom-left
        // add front plane
        builder.vertex(f21, f22, f23).uv(maxU, maxV).color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(f21, f22 + particleScale * 0.3D, f23).uv(maxU, minV)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(f11, f12 + particleScale * 0.3D, f13).uv(minU, minV)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(f11, f12, f13).uv(minU, maxV).color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        // add back plane
        builder.vertex(f11, f12, f13).uv(minU, maxV).color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(f11, f12 + particleScale * 0.3D, f13).uv(minU, minV)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(f21, f22 + particleScale * 0.3D, f23).uv(maxU, minV)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(f21, f22, f23).uv(maxU, maxV).color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();

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
        if (this.age++ > this.lifetime) {
            this.remove();
        }
    }

}
