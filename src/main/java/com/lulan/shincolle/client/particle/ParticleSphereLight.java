package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.reference.Values;
import com.lulan.shincolle.utility.CalcHelper;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
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
 * SPHERE LIGHT PARTICLE
 * Radiating light beam effects around a point using a gradient texture.
 * <p>
 * type:
 * 0: light beam radiate IN
 * 1: light beam radiate OUT
 * 2: light beam radiate UP
 * 3: light beam radiate DOWN
 * 4: light beam STEADY
 * 5: light beam radiate IN custom
 */
@OnlyIn(Dist.CLIENT)
public class ParticleSphereLight extends Particle {

    private static final ResourceLocation TEXTURE1 = new ResourceLocation("shincolle",
            "textures/particles/particlegradientline.png");
    private static int NumBeam = 30;
    private final int particleType;
    private final Entity host;
    private float particleScale;
    private int beamCurrent;
    private float[][] beamPos; // beam position: 0~1: xy, 2~5:RGBA
    private float beamRad, beamSpd, beamThick, beamHeight;

    public ParticleSphereLight(Entity entity, int type, float... parms) {
        super((ClientLevel) entity.level(), 0F, 0F, 0F);
        this.setBoundingBox(this.getBoundingBox().inflate(0));
        this.host = entity;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleType = type;
        this.hasPhysics = false;
        this.beamCurrent = 0; // new beam index

        // particleSetting: 0:all, 1:decr, 2:min -> 3:all, 2:decr, 1:min
        int particleSetting = Minecraft.getInstance().options.particles().get().getId();
        NumBeam = (3 - particleSetting) * 25;

        switch (type) {

            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                this.particleScale = parms[0];
                this.beamRad = parms[1];
                this.beamSpd = parms[2];
                this.beamThick = parms[3];
                this.rCol = parms[4];
                this.gCol = parms[5];
                this.bCol = parms[6];
                this.alpha = parms[7];
                this.beamHeight = parms[8];
                this.lifetime = 40;
                this.beamPos = new float[NumBeam][6];
                this.setPos(entity.getX(), entity.getY() + this.beamHeight, entity.getZ());
                break;
            case 5:
                this.lifetime = (int) parms[0];
                this.particleScale = parms[1];
                this.beamRad = 0.5F;
                this.beamSpd = 0.8F;
                this.beamThick = 2F;
                this.rCol = 0F;
                this.gCol = 0F;
                this.bCol = 0F;
                this.alpha = 0.8F;
                this.beamHeight = entity.getBbHeight() * 0.5F;
                this.beamPos = new float[NumBeam][6];
                this.setPos(entity.getX(), entity.getY() + this.beamHeight, entity.getZ());
                break;
        }

        // init pos
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
    }

    @Override
    public void render(VertexConsumer buffer, Camera camera, float partialTick) {
        Vec3 camPos = camera.getPosition();
        float cx = (float) (Mth.lerp(partialTick, this.xo, this.x) - camPos.x());
        float cy = (float) (Mth.lerp(partialTick, this.yo, this.y) - camPos.y());
        float cz = (float) (Mth.lerp(partialTick, this.zo, this.z) - camPos.z());

        RenderSystem.setShaderTexture(0, TEXTURE1);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(true);
        RenderSystem.disableCull();

        // Use model view stack to apply billboard transform
        PoseStack modelView = RenderSystem.getModelViewStack();
        modelView.pushPose();
        modelView.translate(cx, cy, cz);
        modelView.mulPose(Axis.YP.rotationDegrees(-camera.getYRot()));
        modelView.mulPose(Axis.XP.rotationDegrees(camera.getXRot()));
        modelView.scale(-0.25F, -0.25F, 0.25F);
        RenderSystem.applyModelViewMatrix();

        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder builder = tesselator.getBuilder();
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);

        for (float[] beam : this.beamPos) {
            if (beam[0] == 0F && beam[1] == 0F)
                continue;
            float depth = this.random.nextFloat() * 0.1F;

            builder.vertex(this.particleScale * beam[0] - beam[1] * this.beamThick,
                            this.particleScale * beam[1] + beam[0] * this.beamThick, depth).uv(1F, 1F)
                    .color(beam[2], beam[3], beam[4], beam[5]).endVertex();
            builder.vertex(this.particleScale * beam[0], this.particleScale * beam[1], depth).uv(1F, 0F)
                    .color(beam[2], beam[3], beam[4], beam[5]).endVertex();
            builder.vertex(beam[0], beam[1], depth).uv(0F, 0F).color(beam[2], beam[3], beam[4], beam[5]).endVertex();
            builder.vertex(beam[0] - beam[1] * this.beamThick, beam[1] + beam[0] * this.beamThick, depth).uv(0F, 1F)
                    .color(beam[2], beam[3], beam[4], beam[5]).endVertex();
        }

        tesselator.end();

        modelView.popPose();
        RenderSystem.applyModelViewMatrix();

        RenderSystem.enableCull();
        RenderSystem.depthMask(false);
        RenderSystem.disableBlend();
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.CUSTOM;
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void tick() {
        // update age
        if (this.age++ > this.lifetime) {
            this.remove();
        }

        // update movement
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;

        if (this.host != null) {
            this.setPos(this.host.getX(), this.host.getY() + this.beamHeight, this.host.getZ());
        }

        int particleSetting = Minecraft.getInstance().options.particles().get().getId();

        // update beam
        float[] newpos;

        switch (this.particleType) {
            case 0: // IN
            {
                if (this.age <= 30) {
                    for (int i = 0; i < (3 - particleSetting) * 3; i++) {
                        // create new beam
                        newpos = CalcHelper.rotateXZByAxis(
                                this.beamRad * (this.random.nextFloat() + 1F),
                                this.beamRad * (this.random.nextFloat() + 1F),
                                this.random.nextFloat() * 360F * Values.N.DIV_PI_180, 1F);
                        this.beamPos[this.beamCurrent] = new float[]{newpos[0], newpos[1], this.rCol, this.gCol,
                                this.bCol, this.alpha};
                        this.beamCurrent++;
                        if (this.beamCurrent >= this.beamPos.length)
                            this.beamCurrent = 0;
                    }
                }

                // update beam pos: halve dist to (0,0,0)
                for (int i = 0; i < this.beamPos.length; i++) {
                    // move
                    this.beamPos[i][0] *= this.beamSpd;
                    this.beamPos[i][1] *= this.beamSpd;

                    // min limit
                    if (this.beamPos[i][0] > 0F && this.beamPos[i][0] < 0.001F)
                        this.beamPos[i][0] = 0.001F;
                    if (this.beamPos[i][0] < 0F && this.beamPos[i][0] > -0.001F)
                        this.beamPos[i][0] = -0.001F;
                    if (this.beamPos[i][1] > 0F && this.beamPos[i][1] < 0.001F)
                        this.beamPos[i][1] = 0.001F;
                    if (this.beamPos[i][1] < 0F && this.beamPos[i][1] > -0.001F)
                        this.beamPos[i][1] = -0.001F;
                }
            }
            break;
            case 1: // OUT
            {
                if (this.age <= 40) {
                    for (int i = 0; i < 2; i++) {
                        // create new beam
                        newpos = CalcHelper.rotateXZByAxis(
                                this.beamRad * (this.random.nextFloat() + 1F),
                                this.beamRad * (this.random.nextFloat() + 1F),
                                this.random.nextFloat() * 540F * Values.N.DIV_PI_180, 1F);
                        this.beamPos[this.beamCurrent] = new float[]{newpos[0], newpos[1], this.rCol, this.gCol,
                                this.bCol, this.alpha};
                        this.beamCurrent++;
                        if (this.beamCurrent >= this.beamPos.length)
                            this.beamCurrent = 0;
                    }
                }

                // update beam pos: halve dist to (0,0,0)
                for (int i = 0; i < this.beamPos.length; i++) {
                    // move
                    this.beamPos[i][0] *= 1F + this.beamSpd;
                    this.beamPos[i][1] *= 1F + this.beamSpd;

                    if (this.age > 30)
                        this.beamPos[i][5] *= 0.8F;
                }
            }
            break;
            case 2: // UP or DOWN
            case 3: // STEADY
                break;
            case 5: // IN custom data
            {
                if (this.age <= this.lifetime * 0.95F) {
                    if (this.age > this.lifetime * 0.5F) {
                        this.alpha *= 0.8F;
                    }

                    for (int i = 0; i < (3 - particleSetting) * 3; i++) {
                        // create new beam
                        newpos = CalcHelper.rotateXZByAxis(
                                this.beamRad * (this.random.nextFloat() + 1F),
                                this.beamRad * (this.random.nextFloat() + 1F),
                                this.random.nextFloat() * 360F * Values.N.DIV_PI_180, 1F);
                        this.beamPos[this.beamCurrent] = new float[]{newpos[0], newpos[1],
                                this.rCol + this.random.nextFloat() * 0.1F, this.gCol,
                                this.bCol + this.random.nextFloat() * 0.2F, this.alpha};
                        this.beamCurrent++;
                        if (this.beamCurrent >= this.beamPos.length)
                            this.beamCurrent = 0;
                    }
                }

                // update beam pos: halve dist to (0,0,0)
                for (int i = 0; i < this.beamPos.length; i++) {
                    // move
                    this.beamPos[i][0] *= this.beamSpd;
                    this.beamPos[i][1] *= this.beamSpd;

                    // min limit
                    if (this.beamPos[i][0] > 0F && this.beamPos[i][0] < 0.001F)
                        this.beamPos[i][0] = 0.001F;
                    if (this.beamPos[i][0] < 0F && this.beamPos[i][0] > -0.001F)
                        this.beamPos[i][0] = -0.001F;
                    if (this.beamPos[i][1] > 0F && this.beamPos[i][1] < 0.001F)
                        this.beamPos[i][1] = 0.001F;
                    if (this.beamPos[i][1] < 0F && this.beamPos[i][1] > -0.001F)
                        this.beamPos[i][1] = -0.001F;
                }
            }
            break;
        }

    }

}
