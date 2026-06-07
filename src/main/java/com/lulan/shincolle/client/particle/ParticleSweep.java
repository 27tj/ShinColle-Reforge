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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * SWEEP PARTICLE
 * Sword sweep effect particle with animated sprite sheet.
 */
@OnlyIn(Dist.CLIENT)
public class ParticleSweep extends Particle {

    private static final ResourceLocation TEXTURE1 = new ResourceLocation("textures/entity/sweep.png");
    private final int particleType;
    private final Entity host;
    private float swpFad, swpSpd, swpScale1, swpScale2, swpScale3, swpAngle;

    /**
     * @param entity the host entity
     * @param type   particle type
     * @param parms  type 0: scale1(height), scale2(forward/back width),
     *               scale3(left/right width),
     *               fade, maxAge, R, G, B, A
     */
    public ParticleSweep(ClientLevel level, Entity entity, int type, float... parms) {
        super(level, 0F, 0F, 0F);
        this.setBoundingBox(this.getBoundingBox().inflate(0));
        this.host = entity;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleType = type;
        this.hasPhysics = false;

        if (type == 0) {
            this.swpScale1 = parms[0];
            this.swpScale2 = parms[1];
            this.swpScale3 = parms[2];
            this.swpFad = parms[3];
            this.lifetime = (int) parms[4];
            this.rCol = parms[5];
            this.gCol = parms[6];
            this.bCol = parms[7];
            this.alpha = parms[8];
            this.setPos(entity.getX(), entity.getY() + entity.getBbHeight() * 0.6F, entity.getZ());

            if (this.host instanceof LivingEntity) {
                this.swpAngle = ((LivingEntity) this.host).yBodyRot;
            } else {
                this.swpAngle = this.host.getYRot();
            }
        }

        // init pos
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
    }

    @Override
    public void render(VertexConsumer buffer, Camera camera, float partialTick) {
        int i = (int) ((this.age + partialTick) / this.lifetime * 8F);
        if (i >= 8)
            return;

        Vec3 camPos = camera.getPosition();

        float x = (float) (Mth.lerp(partialTick, this.xo, this.x) - camPos.x());
        float y = (float) (Mth.lerp(partialTick, this.yo, this.y) - camPos.y());
        float z = (float) (Mth.lerp(partialTick, this.zo, this.z) - camPos.z());
        float minU = (float) (i % 4) * 0.25F;
        float maxU = minU + 0.24975F;
        float minV = (float) (i / 4) * 0.5F;
        float maxV = minV + 0.4995F;
        // Use camera entity's width for offset calculation
        float entityWidth; // default player-like width

        entityWidth = camera.getEntity().getBbWidth();

        float[] pos1 = CalcHelper.rotateXZByAxis(entityWidth * 0.35F, 0F, this.swpAngle * Values.N.DIV_PI_180, 1F);

        RenderSystem.setShaderTexture(0, TEXTURE1);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(true);
        RenderSystem.disableCull();

        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder builder = tesselator.getBuilder();
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);

        // front face
        builder.vertex(x + pos1[1] - this.swpScale3 * pos1[0], y - this.swpScale1 * 0.5F,
                        z + pos1[0] + this.swpScale3 * pos1[1]).uv(maxU, maxV)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(x + pos1[1] * this.swpScale2 - this.swpScale3 * pos1[0], y - this.swpScale1 * 0.5F,
                        z + pos1[0] * this.swpScale2 + this.swpScale3 * pos1[1]).uv(maxU, minV)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(x + pos1[1] * this.swpScale2 * 1.25F + this.swpScale3 * pos1[0], y + this.swpScale1 * 0.8F,
                        z + pos1[0] * this.swpScale2 * 1.25F - this.swpScale3 * pos1[1]).uv(minU, minV)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(x + pos1[1] + this.swpScale3 * pos1[0], y + this.swpScale1 * 0.8F,
                        z + pos1[0] - this.swpScale3 * pos1[1]).uv(minU, maxV)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        // back face
        builder.vertex(x + pos1[1] + this.swpScale3 * pos1[0], y + this.swpScale1 * 0.8F,
                        z + pos1[0] - this.swpScale3 * pos1[1]).uv(minU, maxV)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(x + pos1[1] * this.swpScale2 * 1.25F + this.swpScale3 * pos1[0], y + this.swpScale1 * 0.8F,
                        z + pos1[0] * this.swpScale2 * 1.25F - this.swpScale3 * pos1[1]).uv(minU, minV)
                .color(this.rCol, this.gCol, this.bCol * 0.5F, this.alpha).endVertex();
        builder.vertex(x + pos1[1] * this.swpScale2 - this.swpScale3 * pos1[0], y - this.swpScale1 * 0.5F,
                        z + pos1[0] * this.swpScale2 + this.swpScale3 * pos1[1]).uv(maxU, minV)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(x + pos1[1] - this.swpScale3 * pos1[0], y - this.swpScale1 * 0.5F,
                        z + pos1[0] + this.swpScale3 * pos1[1]).uv(maxU, maxV)
                .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();

        pos1 = CalcHelper.rotateXZByAxis(entityWidth * 0.3F, 0F, this.swpAngle * Values.N.DIV_PI_180 - 0.001F, 1F);

        // front face (darker layer)
        builder.vertex(x + pos1[1] - this.swpScale3 * pos1[0], y - this.swpScale1 * 0.5F,
                        z + pos1[0] + this.swpScale3 * pos1[1]).uv(maxU, maxV)
                .color(this.rCol * 0.5F, this.gCol * 0.5F, this.bCol * 0.5F, this.alpha).endVertex();
        builder.vertex(x + pos1[1] * this.swpScale2 - this.swpScale3 * pos1[0], y - this.swpScale1 * 0.5F,
                        z + pos1[0] * this.swpScale2 + this.swpScale3 * pos1[1]).uv(maxU, minV)
                .color(this.rCol * 0.5F, this.gCol * 0.5F, this.bCol * 0.5F, this.alpha).endVertex();
        builder.vertex(x + pos1[1] * this.swpScale2 * 1.25F + this.swpScale3 * 1.25F * pos1[0],
                        y + this.swpScale1 * 0.8F, z + pos1[0] * this.swpScale2 * 1.25F - this.swpScale3 * 1.25F * pos1[1])
                .uv(minU, minV).color(this.rCol * 0.5F, this.gCol * 0.5F, this.bCol * 0.5F, this.alpha).endVertex();
        builder.vertex(x + pos1[1] + this.swpScale3 * 1.25F * pos1[0], y + this.swpScale1 * 0.8F,
                        z + pos1[0] - this.swpScale3 * 1.25F * pos1[1]).uv(minU, maxV)
                .color(this.rCol * 0.5F, this.gCol * 0.5F, this.bCol * 0.5F, this.alpha).endVertex();
        // back face (darker layer)
        builder.vertex(x + pos1[1] + this.swpScale3 * 1.25F * pos1[0], y + this.swpScale1 * 0.8F,
                        z + pos1[0] - this.swpScale3 * 1.25F * pos1[1]).uv(minU, maxV)
                .color(this.rCol * 0.5F, this.gCol * 0.5F, this.bCol * 0.5F, this.alpha).endVertex();
        builder.vertex(x + pos1[1] * this.swpScale2 * 1.25F + this.swpScale3 * 1.25F * pos1[0],
                        y + this.swpScale1 * 0.8F, z + pos1[0] * this.swpScale2 * 1.25F - this.swpScale3 * 1.25F * pos1[1])
                .uv(minU, minV).color(this.rCol, this.gCol * 0.5F, this.bCol * 0.5F, this.alpha).endVertex();
        builder.vertex(x + pos1[1] * this.swpScale2 - this.swpScale3 * pos1[0], y - this.swpScale1 * 0.5F,
                        z + pos1[0] * this.swpScale2 + this.swpScale3 * pos1[1]).uv(maxU, minV)
                .color(this.rCol * 0.5F, this.gCol * 0.5F, this.bCol * 0.5F, this.alpha).endVertex();
        builder.vertex(x + pos1[1] - this.swpScale3 * pos1[0], y - this.swpScale1 * 0.5F,
                        z + pos1[0] + this.swpScale3 * pos1[1]).uv(maxU, maxV)
                .color(this.rCol * 0.5F, this.gCol * 0.5F, this.bCol * 0.5F, this.alpha).endVertex();

        tesselator.end();

        RenderSystem.enableCull();
        RenderSystem.disableBlend();
    }

    @Override
    public int getLightColor(float partialTick) {
        return 61680;
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
        this.setPos(this.host.getX(), this.host.getY() + this.host.getBbHeight() * 0.6F, this.host.getZ());

        // update beam
        if (this.particleType == 0) { // out from host's back
            // angle
            if (this.host instanceof LivingEntity) {
                this.swpAngle = ((LivingEntity) this.host).yBodyRot;
            } else {
                this.swpAngle = this.host.getYRot();
            }

            // alpha fade
            this.alpha *= 0.6F;
        }
    }

}
