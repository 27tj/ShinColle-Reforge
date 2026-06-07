package com.lulan.shincolle.client.particle;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * CRANING PARTICLE
 *
 */
@OnlyIn(Dist.CLIENT)
public class ParticleCraning extends Particle {

    private final int particleType;
    private final float par1;
    private final float lenMax;
    private final float pScale;
    private final double[][] vt1;
    private final double[][] vt2; // cube vertex
    private float len;

    public ParticleCraning(ClientLevel level, double x, double y, double z, double lengthMax, double par1, double scale,
                           int type) {
        super(level, x, y, z);
        this.setBoundingBox(this.getBoundingBox().inflate(0));
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.lenMax = (float) lengthMax;
        this.par1 = (float) par1;
        this.pScale = (float) scale;
        this.particleType = type;
        this.vt1 = new double[8][3];
        this.vt2 = new double[8][3];
        this.hasPhysics = false; // can clip = false

        // craning
        this.lifetime = 127;
        this.rCol = 0.6F;
        this.gCol = 0F;
        this.bCol = 0F;
        this.len = 0F;
    }

    @Override
    public void render(VertexConsumer buffer, Camera camera, float partialTick) {
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(true);
        RenderSystem.setShader(GameRenderer::getPositionColorShader);

        float sizeHead = this.pScale;
        float sizeChain = this.pScale * 0.25F;

        // out
        float[] v1 = new float[]{sizeHead * 0.75F, -sizeHead, -sizeHead};
        float[] v2 = new float[]{sizeHead * 0.75F, sizeHead, -sizeHead};
        float[] v3 = new float[]{-sizeHead * 0.75F, sizeHead, -sizeHead};
        float[] v4 = new float[]{-sizeHead * 0.75F, -sizeHead, -sizeHead};
        // in
        float[] v5 = new float[]{sizeChain, -sizeChain * 1.5F, -sizeChain};
        float[] v6 = new float[]{sizeChain, sizeChain * 1.5F, -sizeChain};
        float[] v7 = new float[]{-sizeChain, sizeChain * 1.5F, -sizeChain};
        float[] v8 = new float[]{-sizeChain, -sizeChain * 1.5F, -sizeChain};

        Vec3 camPos = camera.getPosition();
        double hx = Mth.lerp(partialTick, this.xo, this.x) - camPos.x();
        double hy = Mth.lerp(partialTick, this.yo, this.y) - camPos.y() - len + this.pScale * 5D;
        double hz = Mth.lerp(partialTick, this.zo, this.z) - camPos.z() + this.pScale * 0.5D;
        double z1 = this.pScale * 0.8D;
        double z2 = this.pScale * 0.25D;
        double y1 = this.pScale * 1D;

        // crane head
        vt1[0][0] = hx + v1[0];
        vt1[0][1] = hy + v1[1];
        vt1[0][2] = hz + v1[2];
        vt1[1][0] = hx + v2[0];
        vt1[1][1] = hy + v2[1];
        vt1[1][2] = hz + v2[2];
        vt1[2][0] = hx + v3[0];
        vt1[2][1] = hy + v3[1];
        vt1[2][2] = hz + v3[2];
        vt1[3][0] = hx + v4[0];
        vt1[3][1] = hy + v4[1];
        vt1[3][2] = hz + v4[2];
        vt1[4][0] = hx + v1[0];
        vt1[4][1] = hy + v1[1];
        vt1[4][2] = hz + v1[2] + z1;
        vt1[5][0] = hx + v2[0];
        vt1[5][1] = hy + v2[1];
        vt1[5][2] = hz + v2[2] + z1;
        vt1[6][0] = hx + v3[0];
        vt1[6][1] = hy + v3[1];
        vt1[6][2] = hz + v3[2] + z1;
        vt1[7][0] = hx + v4[0];
        vt1[7][1] = hy + v4[1];
        vt1[7][2] = hz + v4[2] + z1;

        hz -= this.pScale * 0.47D;

        // crane chain
        vt2[0][0] = hx + v5[0];
        vt2[0][1] = hy + v5[1] + y1;
        vt2[0][2] = hz + v5[2];
        vt2[1][0] = hx + v6[0];
        vt2[1][1] = hy + v6[1] + y1;
        vt2[1][2] = hz + v6[2];
        vt2[2][0] = hx + v7[0];
        vt2[2][1] = hy + v7[1] + y1;
        vt2[2][2] = hz + v7[2];
        vt2[3][0] = hx + v8[0];
        vt2[3][1] = hy + v8[1] + y1;
        vt2[3][2] = hz + v8[2];
        vt2[4][0] = hx + v5[0];
        vt2[4][1] = hy + v5[1] + y1;
        vt2[4][2] = hz + v5[2] + z2;
        vt2[5][0] = hx + v6[0];
        vt2[5][1] = hy + v6[1] + y1;
        vt2[5][2] = hz + v6[2] + z2;
        vt2[6][0] = hx + v7[0];
        vt2[6][1] = hy + v7[1] + y1;
        vt2[6][2] = hz + v7[2] + z2;
        vt2[7][0] = hx + v8[0];
        vt2[7][1] = hy + v8[1] + y1;
        vt2[7][2] = hz + v8[2] + z2;

        // start tess
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder builder = tesselator.getBuilder();
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);

        // crane chain
        for (float clen = 0F; clen < len; clen += this.pScale) {
            float ny = (float) hy + clen;

            // crane chain
            vt2[0][0] = hx + v5[0];
            vt2[0][1] = ny + v5[1] + y1;
            vt2[0][2] = hz + v5[2];
            vt2[1][0] = hx + v6[0];
            vt2[1][1] = ny + v6[1] + y1;
            vt2[1][2] = hz + v6[2];
            vt2[2][0] = hx + v7[0];
            vt2[2][1] = ny + v7[1] + y1;
            vt2[2][2] = hz + v7[2];
            vt2[3][0] = hx + v8[0];
            vt2[3][1] = ny + v8[1] + y1;
            vt2[3][2] = hz + v8[2];
            vt2[4][0] = hx + v5[0];
            vt2[4][1] = ny + v5[1] + y1;
            vt2[4][2] = hz + v5[2] + z2;
            vt2[5][0] = hx + v6[0];
            vt2[5][1] = ny + v6[1] + y1;
            vt2[5][2] = hz + v6[2] + z2;
            vt2[6][0] = hx + v7[0];
            vt2[6][1] = ny + v7[1] + y1;
            vt2[6][2] = hz + v7[2] + z2;
            vt2[7][0] = hx + v8[0];
            vt2[7][1] = ny + v8[1] + y1;
            vt2[7][2] = hz + v8[2] + z2;

            // face: front
            builder.vertex(vt2[3][0], vt2[3][1], vt2[3][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
            builder.vertex(vt2[2][0], vt2[2][1], vt2[2][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
            builder.vertex(vt2[1][0], vt2[1][1], vt2[1][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
            builder.vertex(vt2[0][0], vt2[0][1], vt2[0][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();

            // face: right
            builder.vertex(vt2[0][0], vt2[0][1], vt2[0][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
            builder.vertex(vt2[1][0], vt2[1][1], vt2[1][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
            builder.vertex(vt2[5][0], vt2[5][1], vt2[5][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
            builder.vertex(vt2[4][0], vt2[4][1], vt2[4][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();

            // face: back
            builder.vertex(vt2[4][0], vt2[4][1], vt2[4][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
            builder.vertex(vt2[5][0], vt2[5][1], vt2[5][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
            builder.vertex(vt2[6][0], vt2[6][1], vt2[6][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
            builder.vertex(vt2[7][0], vt2[7][1], vt2[7][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();

            // face: left
            builder.vertex(vt2[7][0], vt2[7][1], vt2[7][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
            builder.vertex(vt2[6][0], vt2[6][1], vt2[6][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
            builder.vertex(vt2[2][0], vt2[2][1], vt2[2][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
            builder.vertex(vt2[3][0], vt2[3][1], vt2[3][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();

            // face: top
            builder.vertex(vt2[1][0], vt2[1][1], vt2[1][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
            builder.vertex(vt2[2][0], vt2[2][1], vt2[2][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
            builder.vertex(vt2[6][0], vt2[6][1], vt2[6][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
            builder.vertex(vt2[5][0], vt2[5][1], vt2[5][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();

            // face: bottom
            builder.vertex(vt2[3][0], vt2[3][1], vt2[3][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
            builder.vertex(vt2[0][0], vt2[0][1], vt2[0][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
            builder.vertex(vt2[4][0], vt2[4][1], vt2[4][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
            builder.vertex(vt2[7][0], vt2[7][1], vt2[7][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
        }

        // crane head - face: front
        builder.vertex(vt1[3][0], vt1[3][1], vt1[3][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
        builder.vertex(vt1[2][0], vt1[2][1], vt1[2][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
        builder.vertex(vt1[1][0], vt1[1][1], vt1[1][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
        builder.vertex(vt1[0][0], vt1[0][1], vt1[0][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();

        // face: right
        builder.vertex(vt1[0][0], vt1[0][1], vt1[0][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
        builder.vertex(vt1[1][0], vt1[1][1], vt1[1][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
        builder.vertex(vt1[5][0], vt1[5][1], vt1[5][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
        builder.vertex(vt1[4][0], vt1[4][1], vt1[4][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();

        // face: back
        builder.vertex(vt1[4][0], vt1[4][1], vt1[4][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
        builder.vertex(vt1[5][0], vt1[5][1], vt1[5][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
        builder.vertex(vt1[6][0], vt1[6][1], vt1[6][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
        builder.vertex(vt1[7][0], vt1[7][1], vt1[7][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();

        // face: left
        builder.vertex(vt1[7][0], vt1[7][1], vt1[7][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
        builder.vertex(vt1[6][0], vt1[6][1], vt1[6][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
        builder.vertex(vt1[2][0], vt1[2][1], vt1[2][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
        builder.vertex(vt1[3][0], vt1[3][1], vt1[3][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();

        // face: top
        builder.vertex(vt1[1][0], vt1[1][1], vt1[1][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
        builder.vertex(vt1[2][0], vt1[2][1], vt1[2][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
        builder.vertex(vt1[6][0], vt1[6][1], vt1[6][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
        builder.vertex(vt1[5][0], vt1[5][1], vt1[5][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();

        // face: bottom
        builder.vertex(vt1[3][0], vt1[3][1], vt1[3][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
        builder.vertex(vt1[0][0], vt1[0][1], vt1[0][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
        builder.vertex(vt1[4][0], vt1[4][1], vt1[4][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();
        builder.vertex(vt1[7][0], vt1[7][1], vt1[7][2]).color(this.rCol, this.gCol, this.bCol, 1F).endVertex();

        // draw
        tesselator.end();

        RenderSystem.depthMask(false);
        RenderSystem.disableBlend();
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.CUSTOM;
    }

    @Override
    public void tick() {
        // update pos
        float half = lifetime * 0.45F;
        float half2 = lifetime - half;

        if (age <= half) {
            len = age / half * lenMax;
        } else if (age > half && age <= half2) {
            len = lenMax;
        } else if (age > half2) {
            len = (lifetime - age) / half * lenMax;
        }

        if (this.age++ > this.lifetime) {
            this.remove();
        }
    }

}
