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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

/**
 * ModelFloatingFort - PinkaLulan
 * Ported from Tabula 4.1.1 to 1.20.1 ModelPart system.
 */
public class ModelFloatingFort extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "floating_fort"), "main");

    private final ModelPart BodyMain;
    private final ModelPart JawMain;

    public ModelFloatingFort(ModelPart root) {
        super();
        this.scale = 0.3F;
        this.offsetY = 4.2F;
        this.BodyMain = root.getChild("BodyMain");
        this.JawMain = this.BodyMain.getChild("JawMain");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        // BodyMain
        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(76, 43)
                        .addBox(-6.5F, -6.4F, -6.5F, 13, 8, 13),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2276F, 0.0F, 0.0F));

        // Body1 (child of BodyMain)
        bodyMain.addOrReplaceChild("Body1",
                CubeListBuilder.create().texOffs(76, 20)
                        .addBox(-5.0F, -4.3F, -8.0F, 10, 6, 16),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        // Body3 (child of BodyMain)
        bodyMain.addOrReplaceChild("Body3",
                CubeListBuilder.create().texOffs(76, 2)
                        .addBox(-8.0F, -5.0F, -5.0F, 16, 7, 10),
                PartPose.offset(0.0F, -0.5F, 0.0F));

        // JawMain (child of BodyMain)
        PartDefinition jawMain = bodyMain.addOrReplaceChild("JawMain",
                CubeListBuilder.create().texOffs(1, 39)
                        .addBox(-6.0F, -1.1F, -11.5F, 12, 5, 12),
                PartPose.offsetAndRotation(0.0F, 2.8F, 6.0F, 0.5236F, 0.0F, 0.0F));

        // Jaw2 (child of JawMain)
        jawMain.addOrReplaceChild("Jaw2",
                CubeListBuilder.create().texOffs(1, 3)
                        .addBox(-7.5F, 0.0F, 0.0F, 15, 4, 9),
                PartPose.offset(0.0F, -1.0F, -10.0F));

        // Jaw3 (child of JawMain)
        jawMain.addOrReplaceChild("Jaw3",
                CubeListBuilder.create().texOffs(42, 0)
                        .addBox(-5.0F, 4.0F, 0.0F, 10, 1, 9),
                PartPose.offset(0.0F, -0.1F, -9.5F));

        // Jaw1 (child of JawMain)
        jawMain.addOrReplaceChild("Jaw1",
                CubeListBuilder.create().texOffs(1, 18)
                        .addBox(-4.5F, 0.0F, 0.0F, 9, 4, 15),
                PartPose.offset(0.0F, -1.2F, -13.0F));

        // Body2 (child of BodyMain)
        bodyMain.addOrReplaceChild("Body2",
                CubeListBuilder.create().texOffs(54, 19)
                        .addBox(-5.0F, -8.5F, -4.5F, 10, 2, 9),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0136F));

        // EarR (child of BodyMain)
        bodyMain.addOrReplaceChild("EarR",
                CubeListBuilder.create().texOffs(114, 20)
                        .addBox(-2.0F, -6.0F, -2.0F, 4, 6, 4),
                PartPose.offsetAndRotation(-5.0F, -5.5F, 0.7F, -0.1745F, -0.7854F, -0.0873F));

        // EarL (child of BodyMain, mirrored)
        bodyMain.addOrReplaceChild("EarL",
                CubeListBuilder.create().texOffs(114, 20).mirror()
                        .addBox(-2.0F, -6.0F, -2.0F, 4, 6, 4),
                PartPose.offsetAndRotation(5.0F, -5.5F, 0.7F, -0.1745F, 0.7854F, 0.0873F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
        // Yaw/pitch rotation (using radians conversion like original)
        this.BodyMain.yRot = netHeadYaw * 0.0174533F;
        this.BodyMain.xRot = headPitch * 0.0174533F;

        // Jaw animation
        this.JawMain.zRot = 0F;
        this.JawMain.xRot = Mth.cos(ageInTicks) * 0.25F + 0.375F;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
                               float red, float green, float blue, float alpha) {
        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);
        poseStack.translate(offsetX, offsetY, offsetZ);

        // Main body (no glow for this model)
        this.BodyMain.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);

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
