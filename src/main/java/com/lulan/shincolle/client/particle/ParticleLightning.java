package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.entity.IShipFloating;
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
 * NO TEXTURE LIGHTNING PARTICLE
 * <p>
 * shape: stem with increase wide & same Y length
 * <p>
 * parms: world, host, scale, type
 */
@OnlyIn(Dist.CLIENT)
public class ParticleLightning extends Particle {

    private final int particleType; // 0:red white lightning
    private final Entity host;
    private final int numStem; // lightning length
    private final double[][] prevShape; // prev lightning shape
    private final float scaleXZ;
    private final float scaleY;
    private final float pScale;

    public ParticleLightning(ClientLevel level, Entity entity, float scale, int type) {
        super(level, 0D, 0D, 0D);
        this.setBoundingBox(this.getBoundingBox().inflate(0));
        this.host = entity;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.pScale = scale;
        this.particleType = type;
        this.hasPhysics = false; // can clip = false

        this.rCol = 1F;
        this.gCol = 0.4F + this.random.nextFloat() * 0.3F;
        this.bCol = 0.4F + this.random.nextFloat() * 0.3F;
        this.alpha = 1F;
        this.lifetime = 20;
        this.numStem = 4;
        this.scaleXZ = 0.01F;
        this.scaleY = 0.12F;
        this.y = host.getY() + 1.5D;

        // calc particle position for MountHbH
        float randx = random.nextFloat() + 0.1F;
        float[] newPos = CalcHelper.rotateXZByAxis(0.8F + random.nextFloat() * 0.2F, randx,
                ((LivingEntity) host).yBodyRot * -0.01745F, 1F);

        this.x = this.host.getX() + newPos[0];
        this.y = this.host.getY() + 1.53D + randx * 0.25D;
        this.z = this.host.getZ() + newPos[1];

        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
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

        // Billboard angles from camera
        float yaw = camera.getYRot() * Mth.DEG_TO_RAD;
        float cosYaw = Mth.cos(yaw);
        float sinYaw = Mth.sin(yaw);
        float pitch = camera.getXRot() * Mth.DEG_TO_RAD;
        float cosPitch = Mth.cos(pitch);

        // create lightning shape
        float offx;
        float offz;
        float offy = 0F;

        for (int i = 0; i < numStem; i++) {
            offx = (random.nextFloat() - 0.5F) * 0.1F * (i + 1);
            offz = (random.nextFloat() - 0.5F) * 0.1F * (i + 1);
            random.nextFloat();

            if (i == 0) {
                prevShape[i][1] = py + cosPitch * scaleY;
            } else {
                prevShape[i][1] = py + cosPitch * scaleY - i * scaleY;
            }
            prevShape[i][4] = prevShape[i][1];

            prevShape[i][0] = px + offx + cosYaw * scaleXZ;
            prevShape[i][2] = pz + offz + sinYaw * scaleXZ;
            prevShape[i][3] = px + offx - cosYaw * scaleXZ;
            prevShape[i][5] = pz + offz - sinYaw * scaleXZ;
        }

        // Convert QUAD_STRIP to individual QUADS
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder builder = tesselator.getBuilder();
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);

        // Original strip went from numStem-1 down to 0, producing pairs: (v0L, v0R),
        // (v1L, v1R), ...
        // For QUADS: each consecutive pair of strip vertex pairs forms one quad
        for (int i = numStem - 1; i >= 1; i--) {
            // Strip vertices: i=(left,right), i-1=(left,right)
            // Quad: iL, iR, (i-1)R, (i-1)L
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

        if (this.age++ > this.lifetime) {
            this.remove();
            return;
        }

        // type 0: HarbourHime Mount
        if (this.particleType == 0 && host != null) {
            float randx = random.nextFloat() + 0.1F;
            float[] newPos = CalcHelper.rotateXZByAxis(0.8F + random.nextFloat() * 0.2F, randx,
                    ((LivingEntity) host).yBodyRot * -0.01745F, 1F);

            this.x = this.host.getX() + newPos[0];
            this.y = this.host.getY() + 1.76D + randx * 0.25D;
            this.z = this.host.getZ() + newPos[1];

            if (((IShipFloating) host).getShipDepth() > 0D) {
                this.y -= 0.08D;
            }

            if (((IShipEmotion) host).getIsSitting()) {
                this.y -= 0.23D;
            }
        }
    }

}
