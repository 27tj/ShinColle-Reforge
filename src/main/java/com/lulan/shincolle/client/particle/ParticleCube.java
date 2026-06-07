package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.reference.Values;
import com.lulan.shincolle.utility.CalcHelper;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/**
 * CUBE PARTICLE
 * Generates two-layer cubes: outer shell semi-transparent, inner white.
 * <p>
 * type:
 * 0: Yamato cannon charging effect: vibrating double-layer cube
 * 1: Yamato beam head
 */
@OnlyIn(Dist.CLIENT)
public class ParticleCube extends Particle {

    private final int particleType;
    private final double par1;
    private final double par2;
    private final double par3;
    private final double[][] vt;
    private final double[][] vt2; // cube vertex
    private final LivingEntity host;
    private float shotYaw, shotPitch, scaleOut, scaleIn, alphaOut, alphaIn;
    private float particleScale;

    public ParticleCube(ClientLevel level, LivingEntity host, double par1, double par2, double par3, float scale,
                        int type) {
        super(level, host.getX(), host.getY(), host.getZ());
        this.setBoundingBox(this.getBoundingBox().inflate(0));
        this.host = host;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleScale = scale;
        this.particleType = type;
        this.par1 = par1;
        this.par2 = par2;
        this.par3 = par3;
        this.vt = new double[8][3];
        this.vt2 = new double[8][3];
        this.hasPhysics = false;

        // yamato cannon charging
        if (type == 1) { // yamato beam head
            this.lifetime = 30;
        } else {
            this.particleScale = (float) par1; // par1 as new scale
            this.lifetime = 40;
        }
        this.rCol = 1F;
        this.gCol = 0.8F;
        this.bCol = 0.9F;
    }

    @Override
    public void render(VertexConsumer buffer, Camera camera, float partialTick) {
        if (this.age <= 1)
            return;

        Vec3 camPos = camera.getPosition();

        // calc rotate vector
        // out
        float[] v1 = CalcHelper.rotateXYZByYawPitch(-1F, -1F, -1F, shotYaw, shotPitch, this.scaleOut);
        float[] v2 = CalcHelper.rotateXYZByYawPitch(-1F, 1F, -1F, shotYaw, shotPitch, this.scaleOut);
        float[] v3 = CalcHelper.rotateXYZByYawPitch(1F, 1F, -1F, shotYaw, shotPitch, this.scaleOut);
        float[] v4 = CalcHelper.rotateXYZByYawPitch(1F, -1F, -1F, shotYaw, shotPitch, this.scaleOut);
        float[] v5 = CalcHelper.rotateXYZByYawPitch(-1F, -1F, 1F, shotYaw, shotPitch, this.scaleOut);
        float[] v6 = CalcHelper.rotateXYZByYawPitch(-1F, 1F, 1F, shotYaw, shotPitch, this.scaleOut);
        float[] v7 = CalcHelper.rotateXYZByYawPitch(1F, 1F, 1F, shotYaw, shotPitch, this.scaleOut);
        float[] v8 = CalcHelper.rotateXYZByYawPitch(1F, -1F, 1F, shotYaw, shotPitch, this.scaleOut);
        // in
        float[] t1 = CalcHelper.rotateXYZByYawPitch(-1F, -1F, -1F, shotYaw, shotPitch, this.scaleIn);
        float[] t2 = CalcHelper.rotateXYZByYawPitch(-1F, 1F, -1F, shotYaw, shotPitch, this.scaleIn);
        float[] t3 = CalcHelper.rotateXYZByYawPitch(1F, 1F, -1F, shotYaw, shotPitch, this.scaleIn);
        float[] t4 = CalcHelper.rotateXYZByYawPitch(1F, -1F, -1F, shotYaw, shotPitch, this.scaleIn);
        float[] t5 = CalcHelper.rotateXYZByYawPitch(-1F, -1F, 1F, shotYaw, shotPitch, this.scaleIn);
        float[] t6 = CalcHelper.rotateXYZByYawPitch(-1F, 1F, 1F, shotYaw, shotPitch, this.scaleIn);
        float[] t7 = CalcHelper.rotateXYZByYawPitch(1F, 1F, 1F, shotYaw, shotPitch, this.scaleIn);
        float[] t8 = CalcHelper.rotateXYZByYawPitch(1F, -1F, 1F, shotYaw, shotPitch, this.scaleIn);

        // particle position relative to camera
        double hx = Mth.lerp(partialTick, this.xo, this.x) - camPos.x();
        double hy = Mth.lerp(partialTick, this.yo, this.y) - camPos.y();
        double hz = Mth.lerp(partialTick, this.zo, this.z) - camPos.z();

        // out
        vt[0][0] = hx + v1[0];
        vt[0][1] = hy + v1[1];
        vt[0][2] = hz + v1[2];
        vt[1][0] = hx + v2[0];
        vt[1][1] = hy + v2[1];
        vt[1][2] = hz + v2[2];
        vt[2][0] = hx + v3[0];
        vt[2][1] = hy + v3[1];
        vt[2][2] = hz + v3[2];
        vt[3][0] = hx + v4[0];
        vt[3][1] = hy + v4[1];
        vt[3][2] = hz + v4[2];
        vt[4][0] = hx + v5[0];
        vt[4][1] = hy + v5[1];
        vt[4][2] = hz + v5[2];
        vt[5][0] = hx + v6[0];
        vt[5][1] = hy + v6[1];
        vt[5][2] = hz + v6[2];
        vt[6][0] = hx + v7[0];
        vt[6][1] = hy + v7[1];
        vt[6][2] = hz + v7[2];
        vt[7][0] = hx + v8[0];
        vt[7][1] = hy + v8[1];
        vt[7][2] = hz + v8[2];
        // in
        vt2[0][0] = hx + t1[0];
        vt2[0][1] = hy + t1[1];
        vt2[0][2] = hz + t1[2];
        vt2[1][0] = hx + t2[0];
        vt2[1][1] = hy + t2[1];
        vt2[1][2] = hz + t2[2];
        vt2[2][0] = hx + t3[0];
        vt2[2][1] = hy + t3[1];
        vt2[2][2] = hz + t3[2];
        vt2[3][0] = hx + t4[0];
        vt2[3][1] = hy + t4[1];
        vt2[3][2] = hz + t4[2];
        vt2[4][0] = hx + t5[0];
        vt2[4][1] = hy + t5[1];
        vt2[4][2] = hz + t5[2];
        vt2[5][0] = hx + t6[0];
        vt2[5][1] = hy + t6[1];
        vt2[5][2] = hz + t6[2];
        vt2[6][0] = hx + t7[0];
        vt2[6][1] = hy + t7[1];
        vt2[6][2] = hz + t7[2];
        vt2[7][0] = hx + t8[0];
        vt2[7][1] = hy + t8[1];
        vt2[7][2] = hz + t8[2];

        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(true);
        RenderSystem.disableCull();

        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder builder = tesselator.getBuilder();
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);

        // in (white inner cube) - 6 faces
        builder.vertex(vt2[7][0], vt2[7][1], vt2[7][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[6][0], vt2[6][1], vt2[6][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[5][0], vt2[5][1], vt2[5][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[4][0], vt2[4][1], vt2[4][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();

        builder.vertex(vt2[3][0], vt2[3][1], vt2[3][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[2][0], vt2[2][1], vt2[2][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[6][0], vt2[6][1], vt2[6][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[7][0], vt2[7][1], vt2[7][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();

        builder.vertex(vt2[0][0], vt2[0][1], vt2[0][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[1][0], vt2[1][1], vt2[1][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[2][0], vt2[2][1], vt2[2][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[3][0], vt2[3][1], vt2[3][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();

        builder.vertex(vt2[4][0], vt2[4][1], vt2[4][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[5][0], vt2[5][1], vt2[5][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[1][0], vt2[1][1], vt2[1][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[0][0], vt2[0][1], vt2[0][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();

        builder.vertex(vt2[2][0], vt2[2][1], vt2[2][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[1][0], vt2[1][1], vt2[1][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[5][0], vt2[5][1], vt2[5][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[6][0], vt2[6][1], vt2[6][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();

        builder.vertex(vt2[3][0], vt2[3][1], vt2[3][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[7][0], vt2[7][1], vt2[7][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[4][0], vt2[4][1], vt2[4][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[0][0], vt2[0][1], vt2[0][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();

        // out (colored outer cube) - 6 faces
        builder.vertex(vt[7][0], vt[7][1], vt[7][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[6][0], vt[6][1], vt[6][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[5][0], vt[5][1], vt[5][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[4][0], vt[4][1], vt[4][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();

        builder.vertex(vt[3][0], vt[3][1], vt[3][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[2][0], vt[2][1], vt[2][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[6][0], vt[6][1], vt[6][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[7][0], vt[7][1], vt[7][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();

        builder.vertex(vt[0][0], vt[0][1], vt[0][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[1][0], vt[1][1], vt[1][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[2][0], vt[2][1], vt[2][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[3][0], vt[3][1], vt[3][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();

        builder.vertex(vt[4][0], vt[4][1], vt[4][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[5][0], vt[5][1], vt[5][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[1][0], vt[1][1], vt[1][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[0][0], vt[0][1], vt[0][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();

        builder.vertex(vt[2][0], vt[2][1], vt[2][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[1][0], vt[1][1], vt[1][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[5][0], vt[5][1], vt[5][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[6][0], vt[6][1], vt[6][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();

        builder.vertex(vt[3][0], vt[3][1], vt[3][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[7][0], vt[7][1], vt[7][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[4][0], vt[4][1], vt[4][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[0][0], vt[0][1], vt[0][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();

        // draw
        tesselator.end();

        RenderSystem.enableCull();
        RenderSystem.disableBlend();
    }

    @Override
    public @NotNull ParticleRenderType getRenderType() {
        return ParticleRenderType.CUSTOM;
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;

        // null check
        if (host == null) {
            this.remove();
        }
        // update pos
        else {
            float[] lookDeg;
            float[] posOffset;

            // yamato cannon charging
            if (this.particleType == 1) { // yamato beam head
                // particle position
                lookDeg = CalcHelper.getLookDegree(this.par1, this.par2, this.par3, false);
                posOffset = CalcHelper.rotateXYZByYawPitch(0F, 0F, host.getBbWidth() * 2F, lookDeg[0], lookDeg[1],
                        1F);

                this.x = this.host.getX() + posOffset[0];
                this.y = this.host.getY() + host.getBbHeight() * 0.6D;
                this.z = this.host.getZ() + posOffset[2];
                this.shotYaw = lookDeg[0];
                this.shotPitch = lookDeg[1];

                // change alpha
                if (this.age > 20) {
                    this.alphaIn = 1F + (20 - age) * 0.1F;
                } else if (this.age < 4) {
                    this.alphaIn = 0.2F + age * 0.2F;
                } else {
                    this.alphaIn = 0.95F;
                }
                this.alphaOut = 0F;

                // change scale
                if (this.age > 20) {
                    this.scaleOut = this.particleScale * (1F + (age - 20));
                    this.scaleIn = this.particleScale * 0.4F * (1F - (age - 20) * 0.1F);
                } else if (this.age < 8) {
                    this.scaleOut = this.particleScale * 0.3F * (age * 0.3F);
                    this.scaleIn = this.particleScale * 0.4F * (age * 0.125F);
                } else {
                    this.scaleOut = this.particleScale;
                    this.scaleIn = this.particleScale * 0.4F;
                }

                // random scale effect
            } else {// particle position
                posOffset = CalcHelper.rotateXZByAxis(host.getBbWidth() * 2F, 0F,
                        (host.yBodyRot % 360) * Values.N.DIV_PI_180, 1F);

                this.x = this.host.getX() + posOffset[1];
                this.y = this.host.getY() + host.getBbHeight() * 0.6D;
                this.z = this.host.getZ() + posOffset[0];
                this.shotYaw = (host.yBodyRot % 360) * Values.N.DIV_PI_180;
                this.shotPitch = (host.getXRot() % 360) * Values.N.DIV_PI_180;

                // change alpha
                if (this.age < 32) {
                    this.alphaIn = this.random.nextFloat() * 0.5F + 0.75F;
                } else {
                    this.alphaIn = (this.lifetime - this.age) * 0.1F + 0.2F;
                }
                this.alphaOut = this.alphaIn * 0.25F;

                // change scale
                this.scaleOut = this.particleScale * this.age * ((Mth.cos(this.age) + 1F) * 0.005F + 0.015F);
                this.scaleIn = this.scaleOut * 0.75F;

                // random scale effect
            }// end switch
            this.scaleOut += this.random.nextFloat() * 0.04F - 0.01F;
            this.scaleIn += this.random.nextFloat() * 0.04F - 0.005F;
        }

        if (this.age++ > this.lifetime) {
            this.remove();
        }
    }

}
