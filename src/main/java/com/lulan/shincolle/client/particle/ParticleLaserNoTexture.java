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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * LASER NO TEXTURE PARTICLE
 * Given host and target, generates a 3D cuboid laser beam effect (no texture).
 * <p>
 * type:
 * 0: red dual laser: par1 = X offset (left/right), par2 = firing height
 * 1: yamato wave cannon: main beam
 * 2: guard indicator line: entity type
 * 3: guard indicator line: block type
 * 4: supply indicator line
 * 5: position indicator line
 * 6: purple adjustable-width beam
 */
@OnlyIn(Dist.CLIENT)
public class ParticleLaserNoTexture extends Particle {

    private final int particleType;
    private final float particleScale;
    private final double par1;
    private final double par2;
    private final double par3;
    private final double[][] vt;
    private final double[][] vt2; // cube vertex arrays
    private final LivingEntity host;
    private final Entity target;
    private float shotYaw, shotPitch, scaleOut, scaleIn, alphaOut, alphaIn;
    private double tarX;
    private double tarY;
    private double tarZ;

    public ParticleLaserNoTexture(ClientLevel level, LivingEntity host, Entity target, double par1, double par2,
                                  double par3, float scale, int type) {
        super(level, host.getX(), host.getY(), host.getZ());
        this.setBoundingBox(this.getBoundingBox().inflate(0));
        this.host = host;
        this.target = target;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleScale = scale;
        this.particleType = type;
        this.tarX = target.getX();
        this.tarY = target.getY() + target.getBbHeight() * 0.75D;
        this.tarZ = target.getZ();
        this.par1 = par1;
        this.par2 = par2;
        this.par3 = par3;
        this.vt = new double[8][3];
        this.vt2 = new double[8][3];
        this.hasPhysics = false;

        float[] lookDeg;
        float[] posOffset;

        switch (type) {
            case 1: // yamato wave cannon
                this.lifetime = 30;
                this.rCol = 1F;
                this.gCol = 0.8F;
                this.bCol = 0.9F;
                break;
            case 2: // guard indicator line: entity type
                lookDeg = CalcHelper.getLookDegree(tarX - x, tarY - y, tarZ - z, false);
                this.shotYaw = lookDeg[0];
                this.shotPitch = lookDeg[1];
                this.lifetime = 8;
                this.rCol = 1F;
                this.gCol = 1F;
                this.bCol = 1F;
                this.scaleOut = this.particleScale * 0.5F;
                this.scaleIn = this.particleScale * 0.125F;
                this.alphaOut = 0.1F;
                this.alphaIn = 0.2F;
                break;
            case 4: // supply indicator line
                lookDeg = CalcHelper.getLookDegree(tarX - x, tarY - y, tarZ - z, false);
                this.shotYaw = lookDeg[0];
                this.shotPitch = lookDeg[1];
                this.tarX = target.getX();
                this.tarY = target.getY() + target.getBbHeight() * 0.5D;
                this.tarZ = target.getZ();
                this.lifetime = 12;
                this.rCol = 1F;
                this.gCol = 0.75F;
                this.bCol = 1F;
                this.scaleOut = this.particleScale * 0.5F;
                this.scaleIn = this.particleScale * 0.125F;
                this.alphaOut = 0.1F;
                this.alphaIn = 0.2F;
                break;
            case 5: // position indicator line
                lookDeg = CalcHelper.getLookDegree(tarX - x, tarY - y, tarZ - z, false);
                this.shotYaw = lookDeg[0];
                this.shotPitch = lookDeg[1];
                this.tarX = target.getX();
                this.tarY = target.getY() + 0.2D;
                this.tarZ = target.getZ();
                this.lifetime = 64;
                this.rCol = 1F;
                this.gCol = 0.6F;
                this.bCol = 1F;
                this.scaleOut = this.particleScale * 0.5F;
                this.scaleIn = this.particleScale * 0.125F;
                this.alphaOut = 0.6F;
                this.alphaIn = 0.8F;
                break;
            case 6: // purple adjustable width beam
                lookDeg = CalcHelper.getLookDegree(tarX - x, (tarY + target.getBbHeight() * 0.5D) - (y + this.par1),
                        tarZ - z, false);
                this.shotYaw = lookDeg[0];
                this.shotPitch = lookDeg[1];
                this.tarX = target.getX();
                this.tarY = target.getY() + target.getBbHeight() * 0.5D;
                this.tarZ = target.getZ();
                this.lifetime = 16;
                this.rCol = 0.5F;
                this.gCol = 0F;
                this.bCol = 1F;
                this.scaleOut = (float) this.par2;
                this.scaleIn = (float) this.par3;
                break;
            default: // red laser beam
                lookDeg = CalcHelper.getLookDegree(tarX - x, tarY - y, tarZ - z, false);
                posOffset = CalcHelper.rotateXYZByYawPitch((float) par1, 0F, 0.78F, lookDeg[0], lookDeg[1], 1F);
                this.shotYaw = lookDeg[0];
                this.shotPitch = lookDeg[1];
                this.setPos(this.x + posOffset[0], this.y + (par2 + posOffset[1]), this.z + posOffset[2]);
                this.lifetime = 8;
                this.rCol = 1F;
                this.gCol = 0F;
                this.bCol = 0F;
                this.scaleOut = this.particleScale * 0.5F;
                this.scaleIn = this.particleScale * 0.125F;
                this.alphaOut = 0.1F;
                this.alphaIn = 0.2F;
                break;
        }
    }

    public ParticleLaserNoTexture(ClientLevel level, LivingEntity host, double tarX, double tarY, double tarZ,
                                  float scale, int type) {
        super(level, host.getX(), host.getY(), host.getZ());
        this.setBoundingBox(this.getBoundingBox().inflate(0));
        this.host = host;
        this.target = host;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleScale = scale;
        this.particleType = type;
        this.tarX = tarX;
        this.tarY = tarY;
        this.tarZ = tarZ;
        this.par1 = 0D;
        this.par2 = 0D;
        this.par3 = 0D;
        this.vt = new double[8][3];
        this.vt2 = new double[8][3];
        this.hasPhysics = false;

        float[] lookDeg;

        if (type == 3) { // guard indicator line: block type
            lookDeg = CalcHelper.getLookDegree(tarX - x, tarY - y, tarZ - z, false);
            this.shotYaw = lookDeg[0];
            this.shotPitch = lookDeg[1];
            this.lifetime = 8;
            this.rCol = 1F;
            this.gCol = 1F;
            this.bCol = 1F;
            this.scaleOut = this.particleScale * 0.5F;
            this.scaleIn = this.particleScale * 0.125F;
            this.alphaOut = 0.1F;
            this.alphaIn = 0.2F;
        }
    }

    @Override
    public void render(VertexConsumer buffer, Camera camera, float partialTick) {
        if (this.age <= 1)
            return;

        Vec3 camPos = camera.getPosition();

        // outer layer vertex offsets
        float[] v1 = CalcHelper.rotateXYZByYawPitch(1F, -1F, -1F, shotYaw, shotPitch, this.scaleOut);
        float[] v2 = CalcHelper.rotateXYZByYawPitch(1F, 1F, -1F, shotYaw, shotPitch, this.scaleOut);
        float[] v3 = CalcHelper.rotateXYZByYawPitch(-1F, 1F, -1F, shotYaw, shotPitch, this.scaleOut);
        float[] v4 = CalcHelper.rotateXYZByYawPitch(-1F, -1F, -1F, shotYaw, shotPitch, this.scaleOut);
        // inner layer vertex offsets
        float[] v5 = CalcHelper.rotateXYZByYawPitch(1F, -1F, 0F, shotYaw, shotPitch, this.scaleIn);
        float[] v6 = CalcHelper.rotateXYZByYawPitch(1F, 1F, 0F, shotYaw, shotPitch, this.scaleIn);
        float[] v7 = CalcHelper.rotateXYZByYawPitch(-1F, 1F, 0F, shotYaw, shotPitch, this.scaleIn);
        float[] v8 = CalcHelper.rotateXYZByYawPitch(-1F, -1F, 0F, shotYaw, shotPitch, this.scaleIn);

        // particle positions relative to camera
        double hx = Mth.lerp(partialTick, this.xo, this.x) - camPos.x();
        double hy = Mth.lerp(partialTick, this.yo, this.y) - camPos.y();
        double hz = Mth.lerp(partialTick, this.zo, this.z) - camPos.z();
        double tx = this.tarX - camPos.x();
        double ty = this.tarY - camPos.y();
        double tz = this.tarZ - camPos.z();

        // calculate outer colored 8 vertices
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
        vt[4][0] = tx + v1[0];
        vt[4][1] = ty + v1[1];
        vt[4][2] = tz + v1[2];
        vt[5][0] = tx + v2[0];
        vt[5][1] = ty + v2[1];
        vt[5][2] = tz + v2[2];
        vt[6][0] = tx + v3[0];
        vt[6][1] = ty + v3[1];
        vt[6][2] = tz + v3[2];
        vt[7][0] = tx + v4[0];
        vt[7][1] = ty + v4[1];
        vt[7][2] = tz + v4[2];
        // calculate inner white 8 vertices
        vt2[0][0] = hx + v5[0];
        vt2[0][1] = hy + v5[1];
        vt2[0][2] = hz + v5[2];
        vt2[1][0] = hx + v6[0];
        vt2[1][1] = hy + v6[1];
        vt2[1][2] = hz + v6[2];
        vt2[2][0] = hx + v7[0];
        vt2[2][1] = hy + v7[1];
        vt2[2][2] = hz + v7[2];
        vt2[3][0] = hx + v8[0];
        vt2[3][1] = hy + v8[1];
        vt2[3][2] = hz + v8[2];
        vt2[4][0] = tx + v5[0];
        vt2[4][1] = ty + v5[1];
        vt2[4][2] = tz + v5[2];
        vt2[5][0] = tx + v6[0];
        vt2[5][1] = ty + v6[1];
        vt2[5][2] = tz + v6[2];
        vt2[6][0] = tx + v7[0];
        vt2[6][1] = ty + v7[1];
        vt2[6][2] = tz + v7[2];
        vt2[7][0] = tx + v8[0];
        vt2[7][1] = ty + v8[1];
        vt2[7][2] = tz + v8[2];

        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(true);
        RenderSystem.disableCull();

        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder builder = tesselator.getBuilder();
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);

        // inner white layer - 6 faces
        builder.vertex(vt2[3][0], vt2[3][1], vt2[3][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[2][0], vt2[2][1], vt2[2][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[1][0], vt2[1][1], vt2[1][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[0][0], vt2[0][1], vt2[0][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();

        builder.vertex(vt2[0][0], vt2[0][1], vt2[0][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[1][0], vt2[1][1], vt2[1][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[5][0], vt2[5][1], vt2[5][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[4][0], vt2[4][1], vt2[4][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();

        builder.vertex(vt2[4][0], vt2[4][1], vt2[4][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[5][0], vt2[5][1], vt2[5][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[6][0], vt2[6][1], vt2[6][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[7][0], vt2[7][1], vt2[7][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();

        builder.vertex(vt2[7][0], vt2[7][1], vt2[7][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[6][0], vt2[6][1], vt2[6][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[2][0], vt2[2][1], vt2[2][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[3][0], vt2[3][1], vt2[3][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();

        builder.vertex(vt2[1][0], vt2[1][1], vt2[1][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[2][0], vt2[2][1], vt2[2][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[6][0], vt2[6][1], vt2[6][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[5][0], vt2[5][1], vt2[5][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();

        builder.vertex(vt2[3][0], vt2[3][1], vt2[3][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[0][0], vt2[0][1], vt2[0][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[4][0], vt2[4][1], vt2[4][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();
        builder.vertex(vt2[7][0], vt2[7][1], vt2[7][2]).color(1F, 1F, 1F, this.alphaIn).endVertex();

        // outer colored layer - 6 faces
        builder.vertex(vt[3][0], vt[3][1], vt[3][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[2][0], vt[2][1], vt[2][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[1][0], vt[1][1], vt[1][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[0][0], vt[0][1], vt[0][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();

        builder.vertex(vt[0][0], vt[0][1], vt[0][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[1][0], vt[1][1], vt[1][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[5][0], vt[5][1], vt[5][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[4][0], vt[4][1], vt[4][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();

        builder.vertex(vt[4][0], vt[4][1], vt[4][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[5][0], vt[5][1], vt[5][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[6][0], vt[6][1], vt[6][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[7][0], vt[7][1], vt[7][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();

        builder.vertex(vt[7][0], vt[7][1], vt[7][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[6][0], vt[6][1], vt[6][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[2][0], vt[2][1], vt[2][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[3][0], vt[3][1], vt[3][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();

        builder.vertex(vt[1][0], vt[1][1], vt[1][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[2][0], vt[2][1], vt[2][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[6][0], vt[6][1], vt[6][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[5][0], vt[5][1], vt[5][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();

        builder.vertex(vt[3][0], vt[3][1], vt[3][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[0][0], vt[0][1], vt[0][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[4][0], vt[4][1], vt[4][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();
        builder.vertex(vt[7][0], vt[7][1], vt[7][2]).color(this.rCol, this.gCol, this.bCol, this.alphaOut).endVertex();

        tesselator.end();

        RenderSystem.enableCull();
        RenderSystem.disableBlend();
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.CUSTOM;
    }

    @SuppressWarnings("fallthrough")
    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;

        // null check
        if (host == null || target == null) {
            this.remove();
            return;
        }

        // update pos
        float[] lookDeg;
        float[] posOffset;

        switch (this.particleType) {
            case 1: // yamato cannon beam
                lookDeg = CalcHelper.getLookDegree(this.par1, this.par2, this.par3, false);
                posOffset = CalcHelper.rotateXYZByYawPitch(0F, 0F, host.getBbWidth() * 2F, lookDeg[0], lookDeg[1], 1F);

                this.setPos(host.getX() + posOffset[0], host.getY() + host.getBbHeight() * 0.6D,
                        host.getZ() + posOffset[2]);
                this.shotYaw = lookDeg[0];
                this.shotPitch = lookDeg[1];
                this.tarX = target.getX();
                this.tarY = target.getY() + target.getBbHeight() * 0.5F;
                this.tarZ = target.getZ();

                // change alpha
                if (this.age > 20) {
                    this.alphaIn = 1F + (20 - age) * 0.1F;
                    this.alphaOut = this.alphaIn * 0.25F;
                } else if (this.age < 4) {
                    this.alphaIn = 0.2F + age * 0.2F;
                    this.alphaOut = this.alphaIn * 0.25F;
                } else {
                    this.alphaIn = 1F;
                    this.alphaOut = 0.1F + this.random.nextFloat() * 0.25F;
                }

                // change scale
                if (this.age > 20) {
                    this.scaleOut = this.particleScale * (1F + (age - 20));
                    this.scaleIn = this.particleScale * 0.35F * (1F - (age - 20) * 0.1F);
                } else if (this.age < 8) {
                    this.scaleOut = this.particleScale * 0.3F * (age * 0.3F);
                    this.scaleIn = this.particleScale * 0.35F * (age * 0.125F);
                } else {
                    this.scaleOut = this.particleScale;
                    this.scaleIn = this.particleScale * 0.35F;
                }

                // random scale effect
                this.scaleOut += this.random.nextFloat() * 0.2F - 0.05F;
                this.scaleIn += this.random.nextFloat() * 0.08F - 0.04F;
                break;
            case 2: // guard indicator line: entity type
                this.tarX = target.getX();
                this.tarY = target.getY();
                this.tarZ = target.getZ();
                // fall through
            case 3: // guard indicator line: block type  // $FALL-THROUGH$
                this.setPos(host.getX(), host.getY(), host.getZ());

                lookDeg = CalcHelper.getLookDegree(tarX - x, tarY - y, tarZ - z, false);
                this.shotYaw = lookDeg[0];
                this.shotPitch = lookDeg[1];

                if (this.age > 4) {
                    this.alphaIn = 1.0F + (4 - age) * 0.2F;

                } else {
                    this.alphaIn = 0.2F + age * 0.2F;
                }
                this.alphaOut = this.alphaIn * 0.5F;

                break;
            case 4: // supply indicator line
                this.tarX = target.getX();
                this.tarY = target.getY() + target.getBbHeight() * 0.5D;
                this.tarZ = target.getZ();
                this.setPos(host.getX(), host.getY(), host.getZ());

                lookDeg = CalcHelper.getLookDegree(tarX - x, tarY - y, tarZ - z, false);
                this.shotYaw = lookDeg[0];
                this.shotPitch = lookDeg[1];

                if (this.age > 4) {
                    this.alphaIn = 1.0F + (4 - age) * 0.2F;

                } else {
                    this.alphaIn = 0.2F + age * 0.2F;
                }
                this.alphaOut = this.alphaIn * 0.5F;

                break;
            case 5: // position indicator line
                this.tarX = target.getX();
                this.tarY = target.getY() + 0.2D;
                this.tarZ = target.getZ();
                this.setPos(host.getX(), host.getY() + 0.65D, host.getZ());

                lookDeg = CalcHelper.getLookDegree(tarX - x, tarY - y, tarZ - z, false);
                this.shotYaw = lookDeg[0];
                this.shotPitch = lookDeg[1];

                if (this.age > 56) {
                    this.alphaIn *= 0.6F;
                    this.alphaOut = this.alphaIn * 0.5F;
                }
                break;
            case 6: // purple adjustable width beam
                lookDeg = CalcHelper.getLookDegree(tarX - x, (tarY + target.getBbHeight() * 0.5D) - (y + this.par1),
                        tarZ - z, false);
                this.shotYaw = lookDeg[0];
                this.shotPitch = lookDeg[1];
                this.setPos(host.getX(), host.getY() + this.par1, host.getZ());
                this.tarX = target.getX();
                this.tarY = target.getY() + target.getBbHeight() * 0.5D;
                this.tarZ = target.getZ();

                if (this.age < 8) {
                    this.scaleIn = (float) this.par3 * (1F + 0.6F * this.age);
                    this.alphaIn = 0.2F + age * 0.1F;
                    this.alphaOut = this.alphaIn * 0.25F;
                } else if (this.age > 10) {
                    this.scaleIn = this.scaleIn * 0.75F;
                    this.alphaIn = 1F + (10 - age) * 0.15F;
                    this.alphaOut = this.alphaIn * 0.25F;
                } else {
                    this.alphaIn = 1F;
                    this.alphaOut = 0.25F;
                }
                break;
            default: // red laser
                // force host look vector
                this.host.yBodyRot = shotYaw * Values.N.DIV_180_PI;

                lookDeg = CalcHelper.getLookDegree(tarX - x, tarY - y, tarZ - z, false);
                posOffset = CalcHelper.rotateXYZByYawPitch((float) par1, 0F, 0.78F, lookDeg[0], lookDeg[1], 1F);
                this.shotYaw = lookDeg[0];
                this.shotPitch = lookDeg[1];
                this.setPos(host.getX() + posOffset[0], host.getY() + par2 + posOffset[1], host.getZ() + posOffset[2]);
                this.tarX = target.getX();
                this.tarY = target.getY() + target.getBbHeight() * 0.75D;
                this.tarZ = target.getZ();

                if (this.age > 4) {
                    this.alphaIn = 1.0F + (4 - age) * 0.2F;

                } else {
                    this.alphaIn = 0.2F + age * 0.2F;
                }
                this.alphaOut = this.alphaIn * 0.5F;

                break;
        }

        if (this.age++ > this.lifetime) {
            this.remove();
        }
    }

}
