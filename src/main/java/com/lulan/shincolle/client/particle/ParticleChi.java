package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.reference.ID;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * CHI PARTICLE
 * Orbiting chi-ball effect. Entity must implement IShipEmotion.
 * Renders as an octahedron (4 diamond faces, 6 vertices) with a
 * semi-transparent outer shell.
 */
@OnlyIn(Dist.CLIENT)
public class ParticleChi extends Particle {

    private final Entity host;
    private final int particleType;
    private final float particleScale;
    private float radChi;

    public ParticleChi(ClientLevel level, Entity host, float scale, int type) {
        super(level, host.getX(), host.getY() + host.getBbHeight() * 0.55D, host.getZ());
        this.setBoundingBox(this.getBoundingBox().inflate(0));
        this.host = host;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleScale = scale;
        this.particleType = type;
        this.hasPhysics = false;

        if (type == 1) { // nagato
            this.rCol = 1F;
            this.gCol = 1F;
            this.bCol = 1F;
            this.alpha = 1F;
            this.lifetime = 40;
            this.radChi = scale * 12F;
        }
    }

    @Override
    public void render(VertexConsumer buffer, Camera camera, float partialTick) {
        if (this.age <= 1)
            return;

        Vec3 camPos = camera.getPosition();

        float f11 = (float) (Mth.lerp(partialTick, this.xo, this.x) - camPos.x());
        float f12 = (float) (Mth.lerp(partialTick, this.yo, this.y) - camPos.y());
        float f13 = (float) (Mth.lerp(partialTick, this.zo, this.z) - camPos.z());

        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(true);
        RenderSystem.disableCull();

        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder builder = tesselator.getBuilder();

        // Inner solid octahedron
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);

        // face1
        builder.vertex(f11, f12, f13 + particleScale).color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(f11, f12 + particleScale, f13).color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(f11 + particleScale, f12, f13).color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(f11, f12 - particleScale, f13).color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        // face2
        builder.vertex(f11 + particleScale, f12, f13).color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(f11, f12 + particleScale, f13).color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(f11, f12, f13 - particleScale).color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(f11, f12 - particleScale, f13).color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        // face3
        builder.vertex(f11, f12, f13 - particleScale).color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(f11, f12 + particleScale, f13).color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(f11 - particleScale, f12, f13).color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(f11, f12 - particleScale, f13).color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        // face4
        builder.vertex(f11 - particleScale, f12, f13).color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(f11, f12 + particleScale, f13).color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(f11, f12, f13 + particleScale).color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();
        builder.vertex(f11, f12 - particleScale, f13).color(this.rCol, this.gCol, this.bCol, this.alpha).endVertex();

        tesselator.end();

        // Semi-transparent outer shell (1.3x scale)
        float parAlpha2 = this.alpha * 0.5F;
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);

        // face1
        builder.vertex(f11, f12, f13 + particleScale * 1.3F).color(this.rCol, this.gCol, this.bCol, parAlpha2)
                .endVertex();
        builder.vertex(f11, f12 + particleScale * 1.3F, f13).color(this.rCol, this.gCol, this.bCol, parAlpha2)
                .endVertex();
        builder.vertex(f11 + particleScale * 1.3F, f12, f13).color(this.rCol, this.gCol, this.bCol, parAlpha2)
                .endVertex();
        builder.vertex(f11, f12 - particleScale * 1.3F, f13).color(this.rCol, this.gCol, this.bCol, parAlpha2)
                .endVertex();
        // face2
        builder.vertex(f11 + particleScale * 1.3F, f12, f13).color(this.rCol, this.gCol, this.bCol, parAlpha2)
                .endVertex();
        builder.vertex(f11, f12 + particleScale * 1.3F, f13).color(this.rCol, this.gCol, this.bCol, parAlpha2)
                .endVertex();
        builder.vertex(f11, f12, f13 - particleScale * 1.3F).color(this.rCol, this.gCol, this.bCol, parAlpha2)
                .endVertex();
        builder.vertex(f11, f12 - particleScale * 1.3F, f13).color(this.rCol, this.gCol, this.bCol, parAlpha2)
                .endVertex();
        // face3
        builder.vertex(f11, f12, f13 - particleScale * 1.3F).color(this.rCol, this.gCol, this.bCol, parAlpha2)
                .endVertex();
        builder.vertex(f11, f12 + particleScale * 1.3F, f13).color(this.rCol, this.gCol, this.bCol, parAlpha2)
                .endVertex();
        builder.vertex(f11 - particleScale * 1.3F, f12, f13).color(this.rCol, this.gCol, this.bCol, parAlpha2)
                .endVertex();
        builder.vertex(f11, f12 - particleScale * 1.3F, f13).color(this.rCol, this.gCol, this.bCol, parAlpha2)
                .endVertex();
        // face4
        builder.vertex(f11 - particleScale * 1.3F, f12, f13).color(this.rCol, this.gCol, this.bCol, parAlpha2)
                .endVertex();
        builder.vertex(f11, f12 + particleScale * 1.3F, f13).color(this.rCol, this.gCol, this.bCol, parAlpha2)
                .endVertex();
        builder.vertex(f11, f12, f13 + particleScale * 1.3F).color(this.rCol, this.gCol, this.bCol, parAlpha2)
                .endVertex();
        builder.vertex(f11, f12 - particleScale * 1.3F, f13).color(this.rCol, this.gCol, this.bCol, parAlpha2)
                .endVertex();

        tesselator.end();

        RenderSystem.enableCull();
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

        float[] newPos = CalcHelper.rotateXZByAxis(radChi, 0F, 6.283185F / this.lifetime * this.age, 1F);

        if (this.host != null) {
            this.setPos(this.host.getX() + newPos[0], this.y, this.host.getZ() + newPos[1]);
        }

        assert host != null;
        int phase = ((IShipEmotion) host).getStateEmotion(ID.S.Phase);

        if (this.age++ > this.lifetime) {
            this.remove();
        } else if (phase == 0 || phase == 2) {
            this.remove();
        }
    }

}
