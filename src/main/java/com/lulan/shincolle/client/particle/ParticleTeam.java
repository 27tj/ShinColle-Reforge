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
import org.jetbrains.annotations.NotNull;

/**
 * TEAM CIRCLE PARTICLE
 * type:
 * 0: green, normal mode
 * 1: cyan, single mode
 * 2: red, group mode
 * 3: yellow, formation mode
 * 4: green, moving target (show 20 ticks), alpha fade out
 * 5: red, attack target (show 20 ticks), alpha fade out
 * 6: white, guard target
 * 7: translucent green, friendly target
 * 8: waypoint
 * 9: waypoint rising
 */
@OnlyIn(Dist.CLIENT)
public class ParticleTeam extends Particle {

    private static final ResourceLocation TEXTURE = new ResourceLocation("shincolle",
            "textures/particles/particleteam.png");
    private final int particleType; // 0:green 1:cyan 2:red 3:yellow
    private final double height;
    private final float pScale;
    private float particleAlphaA, particleAlphaC; // arrow alpha, circle alpha
    private Entity host;

    // mark at entity
    public ParticleTeam(ClientLevel level, Entity host, float scale, int type) {
        super(level, 0D, 0D, 0D);
        this.setBoundingBox(this.getBoundingBox().inflate(0));
        this.xo = host.getX();
        this.yo = host.getY();
        this.zo = host.getZ();
        this.setPos(host.getX(), host.getY(), host.getZ());
        this.host = host;
        this.height = host.getBbHeight();
        this.xd = 0D;
        this.yd = 0D;
        this.zd = 0D;
        this.pScale = scale;
        this.particleAlphaA = 1F;
        this.particleAlphaC = 0.8F;
        this.particleType = type;
        this.hasPhysics = false; // can clip = false

        switch (type) {
            case 1: // cyan, single mode
                this.rCol = 0F;
                this.gCol = 1F;
                this.bCol = 1F;
                this.lifetime = 30;
                break;
            case 2: // red, group mode
                this.rCol = 1F;
                this.gCol = 0F;
                this.bCol = 1F;
                this.lifetime = 30;
                break;
            case 3: // yellow, formation mode
                this.rCol = 1F;
                this.gCol = 0.9F;
                this.bCol = 0F;
                this.lifetime = 30;
                break;
            case 4: // green, moving target
                this.rCol = 0F;
                this.gCol = 1F;
                this.bCol = 0F;
                this.lifetime = 30;
                break;
            case 5: // red, attack target
                this.rCol = 1F;
                this.gCol = 0F;
                this.bCol = 0F;
                this.lifetime = 30;
                break;
            case 6: // white, guard target
                this.rCol = 1F;
                this.gCol = 1F;
                this.bCol = 1F;
                this.lifetime = 30;
                break;
            case 7: // translucent green, friendly target
                this.rCol = 0F;
                this.gCol = 1F;
                this.bCol = 0F;
                this.lifetime = 30;
                this.particleAlphaA = 0F;
                this.particleAlphaC = 0.35F;
                this.xo = host.getX();
                this.yo = host.getY() - 0.04D;
                this.zo = host.getZ();
                this.setPos(host.getX(), host.getY() - 0.04D, host.getZ());
                break;
            default: // green, normal mode
                this.rCol = 0F;
                this.gCol = 1F;
                this.bCol = 0F;
                this.lifetime = 30;
                break;
        }// end switch
    }

    // mark at block
    public ParticleTeam(ClientLevel level, float scale, int type, double x, double y, double z) {
        super(level, 0D, 0D, 0D);
        this.setBoundingBox(this.getBoundingBox().inflate(0));
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
        this.xd = 0D;
        this.yd = 0D;
        this.zd = 0D;
        this.height = 1.5D;
        this.pScale = scale;
        this.particleAlphaA = 1F;
        this.particleAlphaC = 0.5F;
        this.particleType = type;
        this.hasPhysics = false; // can clip = false

        switch (type) {
            case 4: // green, moving target
                this.rCol = 0F;
                this.gCol = 1F;
                this.bCol = 0F;
                this.lifetime = 30;
                break;
            case 5: // red, attack target
                this.rCol = 1F;
                this.gCol = 0F;
                this.bCol = 0F;
                this.lifetime = 30;
                break;
            case 6: // white, guard target
                this.rCol = 1F;
                this.gCol = 1F;
                this.bCol = 1F;
                this.lifetime = 30;
                break;
            case 8: // waypoint
                this.rCol = 1F;
                this.gCol = 0F;
                this.bCol = 0F;
                this.lifetime = 31;
                this.particleAlphaA = 0.8F;
                this.particleAlphaC = 0.9F;
                break;
            case 9: // waypoint
                this.rCol = 1F;
                this.gCol = 0F;
                this.bCol = 0F;
                this.lifetime = 31;
                this.particleAlphaA = 0F;
                this.particleAlphaC = 0.9F;
                break;
            default: // green, normal mode
                this.rCol = 0F;
                this.gCol = 1F;
                this.bCol = 0F;
                this.lifetime = 30;
                break;
        }// end switch
    }

    @Override
    public void render(@NotNull VertexConsumer buffer, Camera camera, float partialTick) {
        RenderSystem.setShaderTexture(0, TEXTURE);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(true);
        RenderSystem.disableCull();

        float xmin = 0F;
        float xmax = 1F;
        float y1min = 0F; // arrow texture
        float y1max = 0.5F;
        float y2min = 0.5F; // circle texture
        float y2max = 1F;

        Vec3 camPos = camera.getPosition();
        double f11 = Mth.lerp(partialTick, this.xo, this.x) - camPos.x();
        double f12 = Mth.lerp(partialTick, this.yo, this.y) - camPos.y() + this.height + 1.3D;
        double f12b = Mth.lerp(partialTick, this.yo, this.y) - camPos.y() + 0.3D;
        double f13 = Mth.lerp(partialTick, this.zo, this.z) - camPos.z();

        // Billboard angles from camera
        float yaw = camera.getYRot() * Mth.DEG_TO_RAD;
        float cosYaw = Mth.cos(yaw);
        float sinYaw = Mth.sin(yaw);
        float pitch = camera.getXRot() * Mth.DEG_TO_RAD;
        float cosPitch = Mth.cos(pitch);

        // start
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder builder = tesselator.getBuilder();
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);

        // draw arrow (billboard facing player)
        builder.vertex(f11 - cosYaw * pScale, f12 - cosPitch * pScale * 2.0F, f13 - sinYaw * pScale).uv(xmax, y1max)
                .color(this.rCol, this.gCol, this.bCol, this.particleAlphaA).endVertex();
        builder.vertex(f11 - cosYaw * pScale, f12 + cosPitch * pScale * 2.0F, f13 - sinYaw * pScale).uv(xmax, y1min)
                .color(this.rCol, this.gCol, this.bCol, this.particleAlphaA).endVertex();
        builder.vertex(f11 + cosYaw * pScale, f12 + cosPitch * pScale * 2.0F, f13 + sinYaw * pScale).uv(xmin, y1min)
                .color(this.rCol, this.gCol, this.bCol, this.particleAlphaA).endVertex();
        builder.vertex(f11 + cosYaw * pScale, f12 - cosPitch * pScale * 2.0F, f13 + sinYaw * pScale).uv(xmin, y1max)
                .color(this.rCol, this.gCol, this.bCol, this.particleAlphaA).endVertex();

        float halfScale = pScale * 3F;

        // draw circle (facing up)
        builder.vertex(f11 + halfScale, f12b, f13 + halfScale).uv(xmax, y2max)
                .color(this.rCol, this.gCol, this.bCol, this.particleAlphaC).endVertex();
        builder.vertex(f11 + halfScale, f12b, f13 - halfScale).uv(xmax, y2min)
                .color(this.rCol, this.gCol, this.bCol, this.particleAlphaC).endVertex();
        builder.vertex(f11 - halfScale, f12b, f13 - halfScale).uv(xmin, y2min)
                .color(this.rCol, this.gCol, this.bCol, this.particleAlphaC).endVertex();
        builder.vertex(f11 - halfScale, f12b, f13 + halfScale).uv(xmin, y2max)
                .color(this.rCol, this.gCol, this.bCol, this.particleAlphaC).endVertex();

        // draw circle (facing down)
        builder.vertex(f11 + halfScale, f12b, f13 - halfScale).uv(xmax, y2max)
                .color(this.rCol, this.gCol, this.bCol, this.particleAlphaC).endVertex();
        builder.vertex(f11 + halfScale, f12b, f13 + halfScale).uv(xmax, y2min)
                .color(this.rCol, this.gCol, this.bCol, this.particleAlphaC).endVertex();
        builder.vertex(f11 - halfScale, f12b, f13 + halfScale).uv(xmin, y2min)
                .color(this.rCol, this.gCol, this.bCol, this.particleAlphaC).endVertex();
        builder.vertex(f11 - halfScale, f12b, f13 - halfScale).uv(xmin, y2max)
                .color(this.rCol, this.gCol, this.bCol, this.particleAlphaC).endVertex();

        // draw
        tesselator.end();

        RenderSystem.enableCull();
        RenderSystem.disableBlend();
        RenderSystem.depthMask(false);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.CUSTOM;
    }

    @Override
    public void tick() {
        // check host position
        if (host != null) {
            if (this.particleType == 7) {// set interpolation position
                this.xo = this.x;
                this.yo = this.y;
                this.zo = this.z;
                this.setPos(host.getX(), host.getY() - 0.04D, host.getZ());
            } else {// set interpolation position
                this.xo = this.x;
                this.yo = this.y;
                this.zo = this.z;
                this.setPos(host.getX(), host.getY(), host.getZ());
            }
        } else {
            if (particleType < 4) {
                this.remove();
            }
        }

        // special effect
        switch (this.particleType) {
            case 4:
            case 5:
            case 6:
                // fade out effect
                if (age > 10) {
                    this.particleAlphaA = 1F - ((age - 10F) / 20F);
                    this.particleAlphaC = this.particleAlphaA * 0.5F;
                }
                break;
            case 9: // waypoint
                this.xo = this.x;
                this.yo = this.y;
                this.zo = this.z;
                this.setPos(this.x, this.y + this.age * 0.002D, this.z);

                this.particleAlphaC = 0.9F - this.age * 0.027F;
                break;
        }// end switch

        if (this.age++ > this.lifetime) {
            this.remove();
        }
    }

}
