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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * GRADIENT WAVE RING PARTICLE
 * <p>
 * type 0: gradient radiate IN
 * type 1: gradient radiate OUT
 * type 2: gradient radiate OUT and posY updated with host
 */
@OnlyIn(Dist.CLIENT)
public class ParticleGradient extends Particle {

    private static final ResourceLocation TEXTURE = new ResourceLocation("shincolle",
            "textures/particles/particlegradient.png");
    private final int particleType;
    private final Entity host;
    private int gradCurrent;
    private int gradSpace;
    private float[][] gradPos; // grad position: 0: rad, 1: prev rad, 2~5:RGBA, 6:age
    private float gradRad, gradSpd, gradFad, gradHFad, gradSlope;
    private float pScale;

    public ParticleGradient(ClientLevel level, Entity entity, int type, float... parms) {
        super(level, 0F, 0F, 0F);
        this.setBoundingBox(this.getBoundingBox().inflate(0));
        this.host = entity;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleType = type;
        this.hasPhysics = false;
        this.gradCurrent = 0; // new grad index

        switch (type) {
            case 0:
            case 1:
                this.pScale = parms[0];
                this.gradRad = 0F;
                this.gradFad = parms[1];
                this.gradSpd = parms[2];
                this.gradHFad = 20F;
                this.gradSlope = 1.5F;
                this.gradSpace = (int) parms[3];
                if (this.gradSpace <= 1)
                    this.gradSpace = 1;
                this.rCol = parms[4];
                this.gCol = parms[5];
                this.bCol = parms[6];
                this.alpha = parms[7];
                this.lifetime = 80;
                this.gradPos = new float[20][7];
                this.setPos(entity.getX(), entity.getY(), entity.getZ());
                break;
            case 2:
                this.pScale = parms[0];
                this.gradRad = 0F;
                this.gradFad = parms[1];
                this.gradSpd = parms[2];
                this.gradSpace = (int) parms[3];
                if (this.gradSpace <= 1)
                    this.gradSpace = 1;
                this.rCol = parms[4];
                this.gCol = parms[5];
                this.bCol = parms[6];
                this.alpha = parms[7];
                this.gradHFad = parms[8];
                this.gradSlope = parms[9];
                this.lifetime = 80;
                this.gradPos = new float[20][7];
                this.setPos(entity.getX(), entity.getY(), entity.getZ());
                break;
        }

        // init pos
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
    }

    @Override
    public void render(VertexConsumer buffer, Camera camera, float partialTick) {
        RenderSystem.setShaderTexture(0, TEXTURE);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();

        Vec3 camPos = camera.getPosition();
        float px = (float) (Mth.lerp(partialTick, this.xo, this.x) - camPos.x());
        float py = (float) (Mth.lerp(partialTick, this.yo, this.y) - camPos.y());
        float pz = (float) (Mth.lerp(partialTick, this.zo, this.z) - camPos.z());

        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder builder = tesselator.getBuilder();

        for (float[] grad : this.gradPos) {
            // too far away or too transparent, skip
            if (grad[5] < 0.05F)
                continue;

            float rad = grad[1] + (grad[0] - grad[1]) * partialTick;
            float h = (this.gradHFad - grad[6]) / this.gradHFad;
            if (h < 0.1F)
                h = 0.1F;

            // Convert QUAD_STRIP to individual QUADS
            // Original strip has 10 vertices (5 pairs), forming 4 quads per face (front +
            // back)
            // Strip pairs: (bottom, top) for each of 5 corner positions around the ring

            // Pre-calculate the 5 strip vertex pairs (bottom, top) for the front face
            double[][] stripBottom = new double[5][3];
            double[][] stripTop = new double[5][3];
            float[][] stripUV_B = new float[5][2]; // UV for bottom vertices
            float[][] stripUV_T = new float[5][2]; // UV for top vertices

            // pair 0: +x, +z corner
            stripBottom[0][0] = px + rad;
            stripBottom[0][1] = py;
            stripBottom[0][2] = pz + rad;
            stripTop[0][0] = px + rad * this.gradSlope;
            stripTop[0][1] = py + this.pScale * h;
            stripTop[0][2] = pz + rad * this.gradSlope;
            stripUV_B[0][0] = 0F;
            stripUV_B[0][1] = 1F;
            stripUV_T[0][0] = 0F;
            stripUV_T[0][1] = 0F;

            // pair 1: -x, +z corner
            stripBottom[1][0] = px - rad;
            stripBottom[1][1] = py;
            stripBottom[1][2] = pz + rad;
            stripTop[1][0] = px - rad * this.gradSlope;
            stripTop[1][1] = py + this.pScale * h;
            stripTop[1][2] = pz + rad * this.gradSlope;
            stripUV_B[1][0] = 1F;
            stripUV_B[1][1] = 1F;
            stripUV_T[1][0] = 1F;
            stripUV_T[1][1] = 0F;

            // pair 2: -x, -z corner
            stripBottom[2][0] = px - rad;
            stripBottom[2][1] = py;
            stripBottom[2][2] = pz - rad;
            stripTop[2][0] = px - rad * this.gradSlope;
            stripTop[2][1] = py + this.pScale * h;
            stripTop[2][2] = pz - rad * this.gradSlope;
            stripUV_B[2][0] = 0F;
            stripUV_B[2][1] = 1F;
            stripUV_T[2][0] = 0F;
            stripUV_T[2][1] = 0F;

            // pair 3: +x, -z corner
            stripBottom[3][0] = px + rad;
            stripBottom[3][1] = py;
            stripBottom[3][2] = pz - rad;
            stripTop[3][0] = px + rad * this.gradSlope;
            stripTop[3][1] = py + this.pScale * h;
            stripTop[3][2] = pz - rad * this.gradSlope;
            stripUV_B[3][0] = 1F;
            stripUV_B[3][1] = 1F;
            stripUV_T[3][0] = 1F;
            stripUV_T[3][1] = 0F;

            // pair 4: same as pair 0 (closing the ring)
            stripBottom[4][0] = stripBottom[0][0];
            stripBottom[4][1] = stripBottom[0][1];
            stripBottom[4][2] = stripBottom[0][2];
            stripTop[4][0] = stripTop[0][0];
            stripTop[4][1] = stripTop[0][1];
            stripTop[4][2] = stripTop[0][2];
            stripUV_B[4][0] = 0F;
            stripUV_B[4][1] = 1F;
            stripUV_T[4][0] = 0F;
            stripUV_T[4][1] = 0F;

            builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);

            // Front face: 4 quads from strip pairs 0-1, 1-2, 2-3, 3-4
            for (int q = 0; q < 4; q++) {
                // QUAD_STRIP -> QUADS: (bottom_i, top_i, top_i+1, bottom_i+1)
                builder.vertex(stripBottom[q][0], stripBottom[q][1], stripBottom[q][2])
                        .uv(stripUV_B[q][0], stripUV_B[q][1]).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
                builder.vertex(stripTop[q][0], stripTop[q][1], stripTop[q][2]).uv(stripUV_T[q][0], stripUV_T[q][1])
                        .color(grad[2], grad[3], grad[4], grad[5]).endVertex();
                builder.vertex(stripTop[q + 1][0], stripTop[q + 1][1], stripTop[q + 1][2])
                        .uv(stripUV_T[q + 1][0], stripUV_T[q + 1][1]).color(grad[2], grad[3], grad[4], grad[5])
                        .endVertex();
                builder.vertex(stripBottom[q + 1][0], stripBottom[q + 1][1], stripBottom[q + 1][2])
                        .uv(stripUV_B[q + 1][0], stripUV_B[q + 1][1]).color(grad[2], grad[3], grad[4], grad[5])
                        .endVertex();
            }

            // Back face (reversed winding): pairs go in reverse order around the ring
            // Original back strip: (+x,+z), (+x,-z), (-x,-z), (-x,+z), (+x,+z)
            double[][] bStripBottom = new double[5][3];
            double[][] bStripTop = new double[5][3];
            float[][] bStripUV_B = new float[5][2];
            float[][] bStripUV_T = new float[5][2];

            // pair 0: +x, +z
            bStripBottom[0] = stripBottom[0];
            bStripTop[0] = stripTop[0];
            bStripUV_B[0][0] = 0F;
            bStripUV_B[0][1] = 1F;
            bStripUV_T[0][0] = 0F;
            bStripUV_T[0][1] = 0F;
            // pair 1: +x, -z
            bStripBottom[1] = stripBottom[3];
            bStripTop[1] = stripTop[3];
            bStripUV_B[1][0] = 1F;
            bStripUV_B[1][1] = 1F;
            bStripUV_T[1][0] = 1F;
            bStripUV_T[1][1] = 0F;
            // pair 2: -x, -z
            bStripBottom[2] = stripBottom[2];
            bStripTop[2] = stripTop[2];
            bStripUV_B[2][0] = 0F;
            bStripUV_B[2][1] = 1F;
            bStripUV_T[2][0] = 0F;
            bStripUV_T[2][1] = 0F;
            // pair 3: -x, +z
            bStripBottom[3] = stripBottom[1];
            bStripTop[3] = stripTop[1];
            bStripUV_B[3][0] = 1F;
            bStripUV_B[3][1] = 1F;
            bStripUV_T[3][0] = 1F;
            bStripUV_T[3][1] = 0F;
            // pair 4: +x, +z (closing)
            bStripBottom[4] = stripBottom[0];
            bStripTop[4] = stripTop[0];
            bStripUV_B[4][0] = 0F;
            bStripUV_B[4][1] = 1F;
            bStripUV_T[4][0] = 0F;
            bStripUV_T[4][1] = 0F;

            for (int q = 0; q < 4; q++) {
                builder.vertex(bStripBottom[q][0], bStripBottom[q][1], bStripBottom[q][2])
                        .uv(bStripUV_B[q][0], bStripUV_B[q][1]).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
                builder.vertex(bStripTop[q][0], bStripTop[q][1], bStripTop[q][2]).uv(bStripUV_T[q][0], bStripUV_T[q][1])
                        .color(grad[2], grad[3], grad[4], grad[5]).endVertex();
                builder.vertex(bStripTop[q + 1][0], bStripTop[q + 1][1], bStripTop[q + 1][2])
                        .uv(bStripUV_T[q + 1][0], bStripUV_T[q + 1][1]).color(grad[2], grad[3], grad[4], grad[5])
                        .endVertex();
                builder.vertex(bStripBottom[q + 1][0], bStripBottom[q + 1][1], bStripBottom[q + 1][2])
                        .uv(bStripUV_B[q + 1][0], bStripUV_B[q + 1][1]).color(grad[2], grad[3], grad[4], grad[5])
                        .endVertex();
            }

            tesselator.end();
        }

        RenderSystem.enableCull();
        RenderSystem.disableBlend();
        RenderSystem.depthMask(true);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.CUSTOM;
    }

    @Override
    public void tick() {
        // update age
        if (this.age++ > this.lifetime) {
            this.remove();
            return;
        }

        // update movement
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;

        // update grad
        switch (this.particleType) {
            case 0: // IN
                break;
            case 1: // OUT
            {
                if (this.host != null) {
                    this.setPos(this.host.getX(), this.host.getY(), this.host.getZ());
                }

                if (this.age <= 40 && this.age % this.gradSpace == 0) {
                    this.gradPos[this.gradCurrent] = new float[]{0F, 0F, this.rCol, this.gCol, this.bCol, this.alpha,
                            0F};
                    this.gradCurrent++;
                    if (this.gradCurrent >= this.gradPos.length)
                        this.gradCurrent = 0;
                }

                // update grad pos
                for (int i = 0; i < this.gradPos.length; i++) {
                    // move
                    this.gradPos[i][1] = this.gradPos[i][0]; // prev rad for interpolation
                    this.gradPos[i][0] += this.gradSpd;

                    // age++
                    this.gradPos[i][6] += 1;

                    // alpha--
                    if (this.age % 2 == 0)
                        this.gradPos[i][5] *= this.gradFad;
                }
            }
            break;
            case 2: // OUT and update posY
            {
                if (this.age == 1)
                    this.gradPos[0] = new float[]{0F, 0F, this.rCol, this.gCol, this.bCol, this.alpha, 0F};

                // move
                this.gradPos[0][1] = this.gradPos[0][0]; // prev rad for interpolation
                this.gradPos[0][0] += this.gradSpd;

                // age++
                this.gradPos[0][6] += 1;

                // alpha--
                if ((this.age & 1) == 0)
                    this.gradPos[0][5] *= this.gradFad;
            }
            break;
        }

    }

}
