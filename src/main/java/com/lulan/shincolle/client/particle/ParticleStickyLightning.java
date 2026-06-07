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

import java.util.Objects;

/**
 * NO TEXTURE LIGHTNING PARTICLE
 * <p>
 * WITHOUT rotate to player viewing angle
 * <p>
 * shape: all stem with random wide and random Y length
 * <p>
 * parms: world, host, scale, type
 */
@OnlyIn(Dist.CLIENT)
public class ParticleStickyLightning extends Particle {

    private final int particleType; // 0:red white lightning
    private final Entity host;
    private final int numStem; // lightning length number
    private final double[][] prevShape; // prev lightning shape
    private final float scaleX;
    private final float scaleZ;
    private final float scaleY;
    private final float stemWidth;
    private final float pScale;

    public ParticleStickyLightning(ClientLevel level, Entity entity, float scale, int life, int type) {
        super(level, entity.getX(), entity.getY(), entity.getZ());
        this.setBoundingBox(this.getBoundingBox().inflate(0));
        this.host = entity;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.pScale = scale;
        this.particleType = type;
        this.hasPhysics = false; // can clip = false

        float hostWidth = entity.getBbWidth();
        float hostHeight = entity.getBbHeight();

        switch (type) {
            case 1: // yamato cannon charge steady state
                this.rCol = 1F;
                this.gCol = 0.5F;
                this.bCol = 0.7F;
                this.alpha = 1F;
                this.lifetime = life;
                this.numStem = 4;
                this.scaleX = 0.5F + hostWidth * 0.5F;
                this.scaleY = 0.5F + hostWidth * 0.5F;
                this.scaleZ = 0.5F + hostWidth * 0.5F;
                this.stemWidth = 0.01F * hostWidth;

                // random position
                this.x = this.host.getX() + random.nextFloat() * this.pScale * 2F - this.pScale;
                this.y = this.host.getY() + hostHeight * 0.6D;
                this.z = this.host.getZ() + random.nextFloat() * this.pScale * 2F - this.pScale;
                break;
            case 2: // yamato cannon charging state IN, LivingEntity ONLY
                this.rCol = 1F;
                this.gCol = 0.5F;
                this.bCol = 0.7F;
                this.alpha = 1F;
                this.lifetime = life;
                this.numStem = 12;
                this.scaleX = 0.25F;
                this.scaleY = 0.25F;
                this.scaleZ = 0.25F;
                this.stemWidth = 0.005F;

                // particle position
                float[] partPos = CalcHelper.rotateXZByAxis(1F, 0F,
                        (((LivingEntity) host).yBodyRot % 360) * Values.N.DIV_PI_180, 1F);

                this.x = this.host.getX() + partPos[1];
                this.y = this.host.getY() + hostHeight * 0.8D;
                this.z = this.host.getZ() + partPos[0];
                break;
            case 3: // yamato cannon charging state OUT, LivingEntity ONLY
                this.rCol = 1F;
                this.gCol = 0.5F;
                this.bCol = 0.7F;
                this.alpha = 1F;
                this.lifetime = life;
                this.numStem = 4;
                this.scaleX = 1F;
                this.scaleY = 1F;
                this.scaleZ = 1F;
                this.stemWidth = 0.025F;
                break;
            case 4: // railgun
                this.rCol = 0F;
                this.gCol = 0.7F;
                this.bCol = 1F;
                this.alpha = 1F;
                this.lifetime = life;
                this.numStem = 12;
                this.scaleX = 0.75F;
                this.scaleY = 0.75F;
                this.scaleZ = 0.75F;
                this.stemWidth = 0.008F;

                // random position
                this.x = this.host.getX() + random.nextFloat() * 0.25F - 0.125F;
                this.y = this.host.getY() + hostHeight * 0.5D + random.nextFloat() * 0.25F - 0.125F;
                this.z = this.host.getZ() + random.nextFloat() * 0.25F - 0.125F;
                break;
            case 5: // black hole
                this.rCol = 0F;
                this.gCol = 0F;
                this.bCol = 0F;
                this.alpha = 0F;
                this.lifetime = life;
                this.numStem = 4;
                this.scaleX = this.pScale;
                this.scaleY = this.pScale;
                this.scaleZ = this.pScale;
                this.stemWidth = 0.1F;

                // random position
                this.x = this.host.getX() + random.nextFloat() * 0.25F - 0.125F;
                this.y = this.host.getY() + hostHeight * 0.5D + random.nextFloat() * 0.25F - 0.125F;
                this.z = this.host.getZ() + random.nextFloat() * 0.25F - 0.125F;
                break;
            default:
                this.rCol = 1F;
                this.gCol = 0.5F;
                this.bCol = 0.7F;
                this.alpha = 1F;
                this.lifetime = life;
                this.numStem = 8;
                this.scaleX = 1.75F;
                this.scaleY = 1.75F;
                this.scaleZ = 1.75F;
                this.stemWidth = 0.006F;

                // random position
                this.x = this.host.getX() + random.nextFloat() * 2F - 1F;
                this.y = this.host.getY() + hostHeight * 0.5D + random.nextFloat() * 2F - 1F;
                this.z = this.host.getZ() + random.nextFloat() * 2F - 1F;
                break;
        }// end switch

        this.prevShape = new double[numStem][6]; // prev lightning shape
    }

    @Override
    public void render(VertexConsumer buffer, Camera camera, float partialTick) {
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(true);
        RenderSystem.setShader(GameRenderer::getPositionColorShader);

        Vec3 camPos = camera.getPosition();
        float px = (float) (Mth.lerp(partialTick, this.xo, this.x) - camPos.x());
        float py = (float) (Mth.lerp(partialTick, this.yo, this.y) - camPos.y());
        float pz = (float) (Mth.lerp(partialTick, this.zo, this.z) - camPos.z());
        float offx;
        float offz;
        float offy;

        if (this.age % 2 == 0) {
            for (int i = 0; i < numStem; i++) {
                // stem random position
                offx = (random.nextFloat() - 0.5F) * this.scaleX;
                offz = (random.nextFloat() - 0.5F) * this.scaleZ;
                offy = (random.nextFloat() - 0.5F) * this.scaleY;

                // xyz position: 0:x1, 1:y1, 2:z1, 3:x2, 4:y2, 5:z2
                if (i == 0) { // first stem
                    prevShape[i][0] = px + offx;
                    prevShape[i][1] = py + offy;
                    prevShape[i][2] = pz + offz;
                    prevShape[i][3] = prevShape[i][0];
                    prevShape[i][4] = prevShape[i][1];
                    prevShape[i][5] = prevShape[i][2];
                } else if (i == numStem - 1) { // last stem
                    prevShape[i][0] = prevShape[i - 1][0] + offx;
                    prevShape[i][1] = prevShape[i - 1][1] + offy;
                    prevShape[i][2] = prevShape[i - 1][2] + offz;
                    prevShape[i][3] = prevShape[i][0];
                    prevShape[i][4] = prevShape[i][1];
                    prevShape[i][5] = prevShape[i][2];
                } else { // middle stem
                    prevShape[i][0] = prevShape[i - 1][0] + offx;
                    prevShape[i][1] = prevShape[i - 1][1] + offy;
                    prevShape[i][2] = prevShape[i - 1][2] + offz;
                    prevShape[i][3] = prevShape[i - 1][3] + offx + this.stemWidth;
                    prevShape[i][4] = prevShape[i - 1][4] + offy + this.stemWidth;
                    prevShape[i][5] = prevShape[i - 1][5] + offz + this.stemWidth;
                }
            }
        }

        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder builder = tesselator.getBuilder();

        // Front face - convert QUAD_STRIP to individual QUADS
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);

        for (int i = numStem - 1; i >= 1; i--) {
            builder.vertex(prevShape[i][0], prevShape[i][1], prevShape[i][2])
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
            builder.vertex(prevShape[i][3], prevShape[i][4], prevShape[i][5])
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
            builder.vertex(prevShape[i - 1][3], prevShape[i - 1][4], prevShape[i - 1][5])
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
            builder.vertex(prevShape[i - 1][0], prevShape[i - 1][1], prevShape[i - 1][2])
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        }

        tesselator.end();

        // Back face - convert QUAD_STRIP to individual QUADS (reversed winding)
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);

        for (int i = numStem - 1; i >= 1; i--) {
            builder.vertex(prevShape[i][3], prevShape[i][4], prevShape[i][5])
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
            builder.vertex(prevShape[i][0], prevShape[i][1], prevShape[i][2])
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
            builder.vertex(prevShape[i - 1][0], prevShape[i - 1][1], prevShape[i - 1][2])
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
            builder.vertex(prevShape[i - 1][3], prevShape[i - 1][4], prevShape[i - 1][5])
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        }

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
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.setPos(this.x, this.y, this.z);

        if (this.age++ > this.lifetime) {
            this.remove();
            return;
        }

        float hostHeight = (this.host != null) ? this.host.getBbHeight() : 1.0F;
        float hostWidth = (this.host != null) ? this.host.getBbWidth() : 1.0F;

        // change position
        if (this.particleType == 3) { // yamato cannon charging out
            // particle position
            assert host != null;
            float[] partPos2 = CalcHelper.rotateXZByAxis(hostWidth * 2F, 0F,
                    (((LivingEntity) Objects.requireNonNull(host)).yBodyRot % 360) * Values.N.DIV_PI_180, 1F);

            this.x = this.host.getX() + partPos2[1];
            this.y = this.host.getY() + hostHeight * 0.6D;
            this.z = this.host.getZ() + partPos2[0];
        }

        // change color
        switch (this.particleType) {
            case 4: // railgun
                if (this.lifetime - this.age < 6) {
                    this.alpha = (this.lifetime - this.age) * 0.15F + 0.2F;
                }

                this.gCol = 0.6F + random.nextFloat() * 0.6F;
                this.rCol = this.gCol - 0.3F;
                break;
            case 5: // black hole
                if (this.lifetime - this.age < 10) {
                    this.alpha = (this.lifetime - this.age) * 0.015F + 0.018F;
                } else {
                    this.alpha = 0.35F;
                }

                this.gCol = 0F + random.nextFloat() * 0.1F;
                this.rCol = this.gCol + random.nextFloat() * 0.15F;
                this.bCol = this.rCol + random.nextFloat() * 0.15F;
                break;
            case 1: // yamato cannon charge lightning
            case 2: // yamato cannon charging in
            case 3: // yamato cannon charging out
            default: // yamato cannon beam lightning
                if (this.lifetime - this.age < 6) {
                    this.alpha = (this.lifetime - this.age) * 0.15F + 0.2F;
                }

                this.gCol = 0.4F + random.nextFloat() * 0.75F;
                this.bCol = 0.1F + this.gCol;
                break;
        }// end switch

    }

}
