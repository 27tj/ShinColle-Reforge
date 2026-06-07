package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.reference.Reference;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

/**
 * ModelAirplaneZero - PinkaLulan
 * Ported from Tabula 4.1.1 to 1.20.1 ModelPart system.
 */
public class ModelAirplaneZero extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "airplane_zero"), "main");

    private final ModelPart BodyMain;
    private final ModelPart GlowBodyMain;

    private boolean shouldRender = true;

    public ModelAirplaneZero(ModelPart root) {
        super();
        this.BodyMain = root.getChild("BodyMain");
        this.GlowBodyMain = root.getChild("GlowBodyMain");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        // BodyMain
        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 17)
                        .addBox(-2.0F, -3.0F, -6.0F, 4, 4, 11),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        // Propeller (child of BodyMain)
        bodyMain.addOrReplaceChild("Propeller",
                CubeListBuilder.create().texOffs(0, 6)
                        .addBox(-3.0F, -3.0F, 0.0F, 6, 6, 0),
                PartPose.offset(0.0F, -1.0F, -6.5F));

        // Wing02 (child of BodyMain)
        bodyMain.addOrReplaceChild("Wing02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-13.0F, 0.0F, 0.0F, 13, 1, 5),
                PartPose.offsetAndRotation(-2.0F, -0.4F, -3.2F, 0.0F, 0.0F, 0.0698F));

        // Prop02 (child of BodyMain)
        bodyMain.addOrReplaceChild("Prop02",
                CubeListBuilder.create().texOffs(0, 24)
                        .addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2),
                PartPose.offset(0.0F, -1.0F, -7.5F));

        // Tail01 (child of BodyMain)
        PartDefinition tail01 = bodyMain.addOrReplaceChild("Tail01",
                CubeListBuilder.create().texOffs(30, 25)
                        .addBox(-2.0F, 0.0F, 0.0F, 4, 3, 4),
                PartPose.offset(0.0F, -2.8F, 5.0F));

        // Tail02 (child of Tail01)
        PartDefinition tail02 = tail01.addOrReplaceChild("Tail02",
                CubeListBuilder.create().texOffs(46, 24)
                        .addBox(-1.5F, 0.0F, 0.0F, 3, 2, 6),
                PartPose.offset(0.0F, 0.1F, 4.0F));

        // Tail03 (child of Tail02)
        tail02.addOrReplaceChild("Tail03",
                CubeListBuilder.create().texOffs(0, 17)
                        .addBox(-0.5F, 0.0F, 0.0F, 1, 4, 3),
                PartPose.offsetAndRotation(0.0F, -2.2F, 4.5F, -1.0472F, 0.0F, 0.0F));

        // Tail04 (child of Tail02)
        tail02.addOrReplaceChild("Tail04",
                CubeListBuilder.create().texOffs(0, 13)
                        .addBox(-6.5F, 0.0F, 0.0F, 13, 1, 3),
                PartPose.offset(0.0F, 0.2F, 2.0F));

        // Wing01 (child of BodyMain, mirrored)
        bodyMain.addOrReplaceChild("Wing01",
                CubeListBuilder.create().texOffs(0, 0).mirror()
                        .addBox(0.0F, 0.0F, 0.0F, 13, 1, 5),
                PartPose.offsetAndRotation(2.0F, -0.4F, -3.2F, 0.0F, 0.0F, -0.0698F));

        // BodyU (child of BodyMain - also rendered as glow)
        bodyMain.addOrReplaceChild("BodyU",
                CubeListBuilder.create().texOffs(19, 17)
                        .addBox(-1.5F, 0.0F, 0.0F, 3, 2, 6),
                PartPose.offsetAndRotation(0.0F, -4.9F, -1.8F, -0.3142F, 0.0F, 0.0F));

        // Tank (child of BodyMain)
        bodyMain.addOrReplaceChild("Tank",
                CubeListBuilder.create().texOffs(14, 7)
                        .addBox(-1.0F, 0.0F, 0.0F, 2, 2, 4),
                PartPose.offset(0.0F, 0.5F, -3.0F));

        // GlowBodyMain (scaffold for glow)
        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        // Duplicate BodyU geometry in glow tree for glow rendering
        glowBodyMain.addOrReplaceChild("GlowBodyU",
                CubeListBuilder.create().texOffs(19, 17)
                        .addBox(-1.5F, 0.0F, 0.0F, 3, 2, 6),
                PartPose.offsetAndRotation(0.0F, -4.9F, -1.8F, -0.3142F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
        IShipEmotion ent = (IShipEmotion) entity;

        // Tick check - don't render in first 6 ticks
        this.shouldRender = entity.tickCount > 6;

        // FIX: head rotation bug while riding
        if (netHeadYaw <= -180F) {
            netHeadYaw += 360F;
        } else if (netHeadYaw >= 180F) {
            netHeadYaw -= 360F;
        }

        // Scale level
        switch (ent.getScaleLevel()) {
            case 3:
                this.scale = 1.6F;
                this.offsetY = 0.37F;
                break;
            case 2:
                this.scale = 1.2F;
                this.offsetY = 0.68F;
                break;
            case 1:
                this.scale = 0.8F;
                this.offsetY = 1.32F;
                break;
            default:
                this.scale = 0.4F;
                this.offsetY = 3.22F;
                break;
        }

        // Simple yaw/pitch rotation
        this.BodyMain.yRot = netHeadYaw / 57F;
        this.BodyMain.xRot = headPitch / 57F;
        this.GlowBodyMain.yRot = this.BodyMain.yRot;
        this.GlowBodyMain.xRot = this.BodyMain.xRot;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
                               float red, float green, float blue, float alpha) {
        if (!shouldRender)
            return;

        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);
        poseStack.translate(offsetX, offsetY, offsetZ);

        // Main body
        this.BodyMain.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);

        // Glow parts (full brightness)
        this.GlowBodyMain.render(poseStack, buffer, 0xF000F0, packedOverlay, red, green, blue, alpha);

        poseStack.popPose();
    }

    // No face system - override all as no-ops
    @Override
    public void setFace(int emo) {
    }

    @Override
    public void setMouth(int emo) {
    }

    @Override
    public void setFlush(boolean show) {
    }

    @Override
    public void setFaceNormal(IShipEmotion ent) {
    }

    @Override
    public void setFaceBlink0(IShipEmotion ent) {
    }

    @Override
    public void setFaceBlink1(IShipEmotion ent) {
    }

    @Override
    public void setFaceCry(IShipEmotion ent) {
    }

    @Override
    public void setFaceAttack(IShipEmotion ent) {
    }

    @Override
    public void setFaceDamaged(IShipEmotion ent) {
    }

    @Override
    public void setFaceScorn(IShipEmotion ent) {
    }

    @Override
    public void setFaceHungry(IShipEmotion ent) {
    }

    @Override
    public void setFaceAngry(IShipEmotion ent) {
    }

    @Override
    public void setFaceBored(IShipEmotion ent) {
    }

    @Override
    public void setFaceShy(IShipEmotion ent) {
    }

    @Override
    public void setFaceHappy(IShipEmotion ent) {
    }

    @Override
    public void showEquip(IShipEmotion ent) {
    }

    @Override
    public void syncRotationGlowPart() {
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
    }
}
