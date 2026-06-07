package com.lulan.shincolle.client.particle;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * LINE PARTICLE
 * Renders a line with gradient texture between points.
 * Uses orthogonal planes for visibility from all directions.
 */
@OnlyIn(Dist.CLIENT)
public class ParticleLine extends Particle {

    private static final ResourceLocation TEXTURE = new ResourceLocation("shincolle",
            "textures/particles/particlegradientline.png");
    private final int particleType;
    private final float[] parms;

    /**
     * @param level client level
     * @param type  particle type
     * @param parms type 0: height, width forward, width backward, R, G, B, A, px,
     *              py, pz, mx, my, mz
     */
    public ParticleLine(ClientLevel level, int type, float[] parms) {
        super(level, 0D, 0D, 0D);
        this.setBoundingBox(this.getBoundingBox().inflate(0));
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.parms = parms;
        this.particleType = type;
        this.hasPhysics = false;

        if (type == 0) { // high speed blur
            this.lifetime = 50;
            this.rCol = parms[3];
            this.gCol = parms[4];
            this.bCol = parms[5];
            this.alpha = parms[6];
            this.setPos(parms[7], parms[8], parms[9]);
        }

        // init pos
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
    }

    @Override
    public void render(VertexConsumer buffer, Camera camera, float partialTick) {
        Vec3 camPos = camera.getPosition();

        // particle position relative to camera
        double px = this.x - camPos.x();
        double py = this.y - camPos.y();
        double pz = this.z - camPos.z();
        double[] xyzh = new double[]{parms[0] * parms[10], parms[0] * parms[11], parms[0] * parms[12]};
        double[] xyzf = new double[]{parms[1] * parms[10], parms[1] * parms[11], parms[1] * parms[12]};
        double[] xyzb = new double[]{-parms[2] * parms[10], -parms[2] * parms[11], -parms[2] * parms[12]};

        // Three orthogonal orientations: for vec (x, y, z), simple orthogonals are:
        // (-z, 0, x), (0, -z, y), (-y, x, 0)
        // Draw all three so the effect is visible from any direction
        Vec3[] plane1 = new Vec3[]{
                new Vec3(xyzf[0], xyzf[1] - xyzh[2], xyzf[2] + xyzh[1]),
                new Vec3(xyzf[0], xyzf[1] + xyzh[2], xyzf[2] - xyzh[1]),
                new Vec3(xyzb[0], xyzb[1] + xyzh[2], xyzb[2] - xyzh[1]),
                new Vec3(xyzb[0], xyzb[1] - xyzh[2], xyzb[2] + xyzh[1])
        };
        Vec3[] plane2 = new Vec3[]{
                new Vec3(xyzf[0] - xyzh[2], xyzf[1], xyzf[2] + xyzh[0]),
                new Vec3(xyzf[0] + xyzh[2], xyzf[1], xyzf[2] - xyzh[0]),
                new Vec3(xyzb[0] - xyzh[2], xyzb[1], xyzb[2] + xyzh[0]),
                new Vec3(xyzb[0] + xyzh[2], xyzb[1], xyzb[2] - xyzh[0])
        };
        Vec3[] plane3 = new Vec3[]{
                new Vec3(xyzf[0] - xyzh[1], xyzf[1] + xyzh[0], xyzf[2]),
                new Vec3(xyzf[0] + xyzh[1], xyzf[1] - xyzh[0], xyzf[2]),
                new Vec3(xyzb[0] - xyzh[1], xyzb[1] + xyzh[0], xyzb[2]),
                new Vec3(xyzb[0] + xyzh[1], xyzb[1] - xyzh[0], xyzb[2])
        };

        RenderSystem.setShaderTexture(0, TEXTURE);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(false);
        RenderSystem.disableCull();

        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder builder = tesselator.getBuilder();
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);

        // front plane1
        builder.vertex(px + plane1[0].x(), py + plane1[0].y(), pz + plane1[0].z()).uv(1F, 1F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(px + plane1[1].x(), py + plane1[1].y(), pz + plane1[1].z()).uv(1F, 0F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(px + plane1[2].x(), py + plane1[2].y(), pz + plane1[2].z()).uv(0F, 0F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(px + plane1[3].x(), py + plane1[3].y(), pz + plane1[3].z()).uv(0F, 1F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        // back plane1
        builder.vertex(px + plane1[3].x(), py + plane1[3].y(), pz + plane1[3].z()).uv(0F, 1F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(px + plane1[2].x(), py + plane1[2].y(), pz + plane1[2].z()).uv(0F, 0F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(px + plane1[1].x(), py + plane1[1].y(), pz + plane1[1].z()).uv(1F, 0F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(px + plane1[0].x(), py + plane1[0].y(), pz + plane1[0].z()).uv(1F, 1F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        // front plane2
        builder.vertex(px + plane2[0].x(), py + plane2[0].y(), pz + plane2[0].z()).uv(1F, 1F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(px + plane2[1].x(), py + plane2[1].y(), pz + plane2[1].z()).uv(1F, 0F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(px + plane2[2].x(), py + plane2[2].y(), pz + plane2[2].z()).uv(0F, 0F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(px + plane2[3].x(), py + plane2[3].y(), pz + plane2[3].z()).uv(0F, 1F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        // back plane2
        builder.vertex(px + plane2[3].x(), py + plane2[3].y(), pz + plane2[3].z()).uv(0F, 1F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(px + plane2[2].x(), py + plane2[2].y(), pz + plane2[2].z()).uv(0F, 0F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(px + plane2[1].x(), py + plane2[1].y(), pz + plane2[1].z()).uv(1F, 0F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(px + plane2[0].x(), py + plane2[0].y(), pz + plane2[0].z()).uv(1F, 1F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        // front plane3
        builder.vertex(px + plane3[0].x(), py + plane3[0].y(), pz + plane3[0].z()).uv(1F, 1F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(px + plane3[1].x(), py + plane3[1].y(), pz + plane3[1].z()).uv(1F, 0F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(px + plane3[2].x(), py + plane3[2].y(), pz + plane3[2].z()).uv(0F, 0F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(px + plane3[3].x(), py + plane3[3].y(), pz + plane3[3].z()).uv(0F, 1F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        // back plane3
        builder.vertex(px + plane3[3].x(), py + plane3[3].y(), pz + plane3[3].z()).uv(0F, 1F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(px + plane3[2].x(), py + plane3[2].y(), pz + plane3[2].z()).uv(0F, 0F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(px + plane3[1].x(), py + plane3[1].y(), pz + plane3[1].z()).uv(1F, 0F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(px + plane3[0].x(), py + plane3[0].y(), pz + plane3[0].z()).uv(1F, 1F)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();

        tesselator.end();

        RenderSystem.enableCull();
        RenderSystem.depthMask(true);
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
            return;
        }

        if (this.particleType == 0) {
            this.parms[0] *= 0.88F;
            this.parms[2] *= 0.85F;
            this.alpha *= 0.9F;
        }
    }

}
