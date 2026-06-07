package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * DEBUG PLANE PARTICLE
 * Draws colored planes to visualize entity hitbox body parts.
 * <p>
 * type:
 * 0: caress position indicator plane
 * 1: body cube position indicator (normal)
 * 2: body cube position indicator (hit sensitive)
 */
@OnlyIn(Dist.CLIENT)
public class ParticleDebugPlane extends Particle {

    private final int particleType;
    private final Entity host;
    private final float[] parms;
    private float hostWidth, yTop, yBottom, red2, green2, blue2, alpha2;

    public ParticleDebugPlane(Entity entity, int type, float... parms) {
        super((ClientLevel) entity.level(), 0F, 0F, 0F);
        this.setBoundingBox(this.getBoundingBox().inflate(0));
        this.host = entity;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleType = type;
        this.parms = parms;
        this.hasPhysics = false;

        switch (type) {

            case 0:

                this.hostWidth = this.host.getBbWidth() * 0.5F;
                this.lifetime = 2;
                this.red2 = 0F;
                this.green2 = 1F;
                this.blue2 = 0F;
                this.alpha2 = 0.6F;
                this.yTop = this.parms[0];
                this.yBottom = this.parms[0];
                this.setPos(entity.getX(), entity.getY(), entity.getZ());
                break;

            case 1:
            case 2: {

                this.hostWidth = this.host.getBbWidth() * 0.5F;

                // set top and bottom color
                if (this.host instanceof BasicEntityShip) {
                    // hit sensitive
                    if (this.particleType == 2) {
                        this.red2 = 1F;
                        this.green2 = 0.6F;
                        this.blue2 = 1F;
                        this.alpha2 = 0.6F;
                    } else {
                        this.red2 = 1F;
                        this.green2 = 1F;
                        this.blue2 = 1F;
                        this.alpha2 = 0.15F;
                    }

                    // set side color by body part
                    switch ((int) this.parms[2]) {
                        case 0: // top
                            this.rCol = 1F;
                            this.gCol = 1F;
                            this.bCol = 0F;
                            this.alpha = 0.15F;
                            break;
                        case 1: // head
                            this.rCol = 0F;
                            this.gCol = 1F;
                            this.bCol = 0F;
                            this.alpha = 0.15F;
                            break;
                        case 2: // neck
                            this.rCol = 1F;
                            this.gCol = 0F;
                            this.bCol = 1F;
                            this.alpha = 0.15F;
                            break;
                        case 3: // chest
                            this.rCol = 1F;
                            this.gCol = 1F;
                            this.bCol = 1F;
                            this.alpha = 0.15F;
                            break;
                        case 4: // belly
                            this.rCol = 0F;
                            this.gCol = 1F;
                            this.bCol = 1F;
                            this.alpha = 0.15F;
                            break;
                        case 5: // ubelly
                            this.rCol = 1F;
                            this.gCol = 0F;
                            this.bCol = 0F;
                            this.alpha = 0.15F;
                            break;
                        default: // leg
                            this.rCol = 0F;
                            this.gCol = 0F;
                            this.bCol = 1F;
                            this.alpha = 0.15F;
                            break;
                    }
                }


                this.lifetime = 2;
                this.yTop = this.parms[0];
                this.yBottom = this.parms[1];
                this.setPos(entity.getX(), entity.getY(), entity.getZ());
            }
            break;
        }

        // init pos
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
    }

    @Override
    public void render(VertexConsumer buffer, Camera camera, float partialTick) {
        if (this.age <= 1)
            return;

        Vec3 camPos = camera.getPosition();
        float x = (float) (Mth.lerp(partialTick, this.xo, this.x) - camPos.x());
        float y = (float) (Mth.lerp(partialTick, this.yo, this.y) - camPos.y());
        float z = (float) (Mth.lerp(partialTick, this.zo, this.z) - camPos.z());

        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(false);
        RenderSystem.disableCull();

        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder builder = tesselator.getBuilder();
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);

        // draw top plane, front and back
        builder.vertex((double) x + hostWidth, (double) y + yTop, (double) z - hostWidth)
                .color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
        builder.vertex((double) x + hostWidth, (double) y + yTop, (double) z + hostWidth)
                .color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
        builder.vertex((double) x - hostWidth, (double) y + yTop, (double) z + hostWidth)
                .color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
        builder.vertex((double) x - hostWidth, (double) y + yTop, (double) z - hostWidth)
                .color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
        builder.vertex((double) x - hostWidth, (double) y + yTop, (double) z - hostWidth)
                .color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
        builder.vertex((double) x - hostWidth, (double) y + yTop, (double) z + hostWidth)
                .color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
        builder.vertex((double) x + hostWidth, (double) y + yTop, (double) z + hostWidth)
                .color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
        builder.vertex((double) x + hostWidth, (double) y + yTop, (double) z - hostWidth)
                .color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();

        // draw side planes if top != bottom
        if (yTop != yBottom) {
            // draw bottom plane, front and back
            builder.vertex((double) x + hostWidth, (double) y + yBottom, (double) z - hostWidth)
                    .color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
            builder.vertex((double) x + hostWidth, (double) y + yBottom, (double) z + hostWidth)
                    .color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
            builder.vertex((double) x - hostWidth, (double) y + yBottom, (double) z + hostWidth)
                    .color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
            builder.vertex((double) x - hostWidth, (double) y + yBottom, (double) z - hostWidth)
                    .color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
            builder.vertex((double) x - hostWidth, (double) y + yBottom, (double) z - hostWidth)
                    .color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
            builder.vertex((double) x - hostWidth, (double) y + yBottom, (double) z + hostWidth)
                    .color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
            builder.vertex((double) x + hostWidth, (double) y + yBottom, (double) z + hostWidth)
                    .color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
            builder.vertex((double) x + hostWidth, (double) y + yBottom, (double) z - hostWidth)
                    .color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
            // draw side1
            builder.vertex((double) x + hostWidth, (double) y + yBottom, (double) z - hostWidth)
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
            builder.vertex((double) x + hostWidth, (double) y + yTop, (double) z - hostWidth)
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
            builder.vertex((double) x + hostWidth, (double) y + yTop, (double) z + hostWidth)
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
            builder.vertex((double) x + hostWidth, (double) y + yBottom, (double) z + hostWidth)
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
            // draw side2
            builder.vertex((double) x - hostWidth, (double) y + yBottom, (double) z - hostWidth)
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
            builder.vertex((double) x - hostWidth, (double) y + yTop, (double) z - hostWidth)
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
            builder.vertex((double) x + hostWidth, (double) y + yTop, (double) z - hostWidth)
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
            builder.vertex((double) x + hostWidth, (double) y + yBottom, (double) z - hostWidth)
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
            // draw side3
            builder.vertex((double) x - hostWidth, (double) y + yBottom, (double) z + hostWidth)
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
            builder.vertex((double) x - hostWidth, (double) y + yTop, (double) z + hostWidth)
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
            builder.vertex((double) x - hostWidth, (double) y + yTop, (double) z - hostWidth)
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
            builder.vertex((double) x - hostWidth, (double) y + yBottom, (double) z - hostWidth)
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
            // draw side4
            builder.vertex((double) x + hostWidth, (double) y + yBottom, (double) z + hostWidth)
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
            builder.vertex((double) x + hostWidth, (double) y + yTop, (double) z + hostWidth)
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
            builder.vertex((double) x - hostWidth, (double) y + yTop, (double) z + hostWidth)
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
            builder.vertex((double) x - hostWidth, (double) y + yBottom, (double) z + hostWidth)
                    .color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        }

        tesselator.end();

        RenderSystem.enableCull();
        RenderSystem.depthMask(true);
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
        if (this.age++ > this.lifetime || this.host == null) {
            this.remove();
            return;
        }

        // update movement
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;

        // update beam
        if (this.particleType == 0) { // type 0: caress indicator
            this.setPos(this.host.getX(), this.host.getY(), this.host.getZ());
        }
    }

}
