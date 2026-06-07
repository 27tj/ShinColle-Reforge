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
 * ModelAirplane - PinkaLulan 2015/2/18
 * Ported from Tabula 4.1.1 to 1.20.1 ModelPart system.
 */
public class ModelAirplane extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "airplane"), "main");

    private final ModelPart BodyMain;
    private final ModelPart GlowBodyMain;

    public ModelAirplane(ModelPart root) {
        super();
        this.scale = 0.5F;
        this.offsetY = 2.5F;
        this.BodyMain = root.getChild("BodyMain");
        this.GlowBodyMain = root.getChild("GlowBodyMain");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        // BodyMain
        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(3, 18)
                        .addBox(-3.0F, -3.0F, -1.0F, 6, 7, 7),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        // Head (child of BodyMain)
        bodyMain.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(8, 24)
                        .addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4),
                PartPose.offsetAndRotation(0.0F, 0.0F, -6.2F, 0.0F, 0.7854F, 0.0F));

        // AirfoilL (child of BodyMain)
        bodyMain.addOrReplaceChild("AirfoilL",
                CubeListBuilder.create().texOffs(0, 17)
                        .addBox(-2.5F, -2.0F, -6.0F, 5, 4, 11),
                PartPose.offsetAndRotation(3.5F, 0.0F, 0.0F, 0.0F, 0.5236F, 0.1222F));

        // AirfoilR (child of BodyMain)
        bodyMain.addOrReplaceChild("AirfoilR",
                CubeListBuilder.create().texOffs(0, 17)
                        .addBox(-2.5F, -2.0F, -6.0F, 5, 4, 11),
                PartPose.offsetAndRotation(-3.5F, 0.0F, 0.0F, 0.0F, -0.5236F, -0.1222F));

        // BombL (child of BodyMain)
        bodyMain.addOrReplaceChild("BombL",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 2, 2, 6),
                PartPose.offsetAndRotation(6.0F, 2.3F, -1.0F, 0.0F, 0.0F, 0.7854F));

        // BombR (child of BodyMain)
        bodyMain.addOrReplaceChild("BombR",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 2, 2, 6),
                PartPose.offsetAndRotation(-6.0F, 2.3F, -1.0F, 0.0F, 0.0F, 0.7854F));

        // BodyFront (child of BodyMain)
        bodyMain.addOrReplaceChild("BodyFront",
                CubeListBuilder.create().texOffs(12, 6)
                        .addBox(-2.5F, -2.6F, -2.5F, 5, 6, 5),
                PartPose.offsetAndRotation(0.0F, 0.0F, -3.2F, 0.0873F, 0.0F, 0.0F));

        // Tail (child of BodyMain)
        bodyMain.addOrReplaceChild("Tail",
                CubeListBuilder.create().texOffs(0, 19)
                        .addBox(-4.0F, -2.5F, -4.0F, 8, 5, 8),
                PartPose.offsetAndRotation(0.0F, 0.0F, 4.3F, 0.0F, 0.7854F, 0.0F));

        // Tongue (child of BodyMain)
        bodyMain.addOrReplaceChild("Tongue",
                CubeListBuilder.create().texOffs(0, 13)
                        .addBox(-1.5F, 0.0F, -3.0F, 3, 1, 3),
                PartPose.offsetAndRotation(0.0F, 2.3F, -3.5F, 1.6581F, 0.0F, 0.0F));

        // GunBase (child of BodyMain)
        PartDefinition gunBase = bodyMain.addOrReplaceChild("GunBase",
                CubeListBuilder.create().texOffs(10, 24)
                        .addBox(-1.5F, 0.0F, 0.0F, 3, 4, 3),
                PartPose.offset(0.0F, 4.0F, 2.5F));

        // Gun (child of GunBase)
        gunBase.addOrReplaceChild("Gun",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-0.5F, 0.0F, -8.0F, 1, 1, 8),
                PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.0524F, 0.0F, 0.0F));

        // GlowBodyMain (scaffold for glow parts)
        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        // EyeL (child of GlowBodyMain - glow)
        glowBodyMain.addOrReplaceChild("EyeL",
                CubeListBuilder.create().texOffs(16, 0)
                        .addBox(-2.0F, 0.0F, -2.0F, 4, 2, 4),
                PartPose.offsetAndRotation(3.7F, -3.2F, 2.0F, 0.0F, 0.7854F, 0.1745F));

        // EyeR (child of GlowBodyMain - glow)
        glowBodyMain.addOrReplaceChild("EyeR",
                CubeListBuilder.create().texOffs(16, 0)
                        .addBox(-2.0F, 0.0F, -2.0F, 4, 2, 4),
                PartPose.offsetAndRotation(-3.7F, -3.2F, 2.0F, 0.0F, -2.3562F, -0.1745F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
        // Simple yaw/pitch rotation
        this.BodyMain.yRot = netHeadYaw / 57F;
        this.BodyMain.xRot = headPitch / 57F;
        this.GlowBodyMain.yRot = this.BodyMain.yRot;
        this.GlowBodyMain.xRot = this.BodyMain.xRot;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
                               float red, float green, float blue, float alpha) {
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
