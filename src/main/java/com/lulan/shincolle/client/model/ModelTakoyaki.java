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
 * ModelTakoyaki - PinkaLulan 2015/2/18
 * Ported from Tabula 4.1.1 to 1.20.1 ModelPart system.
 */
public class ModelTakoyaki extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "airplane_takoyaki"), "main");

    private final ModelPart BodyMain;
    private final ModelPart JawMain;
    private final ModelPart GlowBodyMain;

    public ModelTakoyaki(ModelPart root) {
        super();
        this.scale = 0.45F;
        this.offsetY = 2.7F;
        this.BodyMain = root.getChild("BodyMain");
        this.JawMain = this.BodyMain.getChild("JawMain");
        this.GlowBodyMain = root.getChild("GlowBodyMain");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        // BodyMain
        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(76, 42)
                        .addBox(-6.5F, -6.4F, -6.5F, 13, 9, 13),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

        // Body1 (child of BodyMain)
        bodyMain.addOrReplaceChild("Body1",
                CubeListBuilder.create().texOffs(76, 19)
                        .addBox(-5.0F, -4.3F, -8.0F, 10, 7, 16),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        // JawMain (child of BodyMain)
        PartDefinition jawMain = bodyMain.addOrReplaceChild("JawMain",
                CubeListBuilder.create().texOffs(0, 38)
                        .addBox(-6.5F, -1.1F, -8.0F, 13, 6, 13),
                PartPose.offsetAndRotation(0.0F, 3.5F, 3.0F, 1.3F, 0.0F, 0.0F));

        // Jaw1 (child of JawMain)
        jawMain.addOrReplaceChild("Jaw1",
                CubeListBuilder.create().texOffs(0, 17)
                        .addBox(-5.0F, 0.0F, 0.0F, 10, 5, 16),
                PartPose.offset(0.0F, -1.2F, -9.5F));

        // Jaw2 (child of JawMain)
        jawMain.addOrReplaceChild("Jaw2",
                CubeListBuilder.create().texOffs(0, 2)
                        .addBox(-8.0F, 0.0F, 0.0F, 16, 5, 10),
                PartPose.offset(0.0F, -1.0F, -6.5F));

        // Jaw3 (child of JawMain)
        jawMain.addOrReplaceChild("Jaw3",
                CubeListBuilder.create().texOffs(42, 0)
                        .addBox(-5.0F, 5.0F, -5.5F, 10, 2, 9),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        // Tongue (child of JawMain)
        jawMain.addOrReplaceChild("Tongue",
                CubeListBuilder.create().texOffs(50, 39)
                        .addBox(-4.5F, 0.0F, -7.0F, 9, 3, 7),
                PartPose.offsetAndRotation(0.0F, -2.0F, 0.5F, -0.0873F, 0.0F, 0.0F));

        // Body3 (child of BodyMain)
        bodyMain.addOrReplaceChild("Body3",
                CubeListBuilder.create().texOffs(76, 1)
                        .addBox(-8.0F, -5.0F, -5.0F, 16, 8, 10),
                PartPose.offset(0.0F, -0.5F, 0.0F));

        // Body2 (child of BodyMain)
        bodyMain.addOrReplaceChild("Body2",
                CubeListBuilder.create().texOffs(54, 19)
                        .addBox(-5.0F, -8.5F, -4.5F, 10, 2, 9),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0136F));

        // EarL (child of BodyMain, mirrored)
        bodyMain.addOrReplaceChild("EarL",
                CubeListBuilder.create().texOffs(114, 20).mirror()
                        .addBox(-2.0F, -8.0F, -1.5F, 4, 8, 3),
                PartPose.offsetAndRotation(5.5F, -4.5F, 3.0F, -0.5236F, -0.5236F, 0.7854F));

        // EarR (child of BodyMain)
        bodyMain.addOrReplaceChild("EarR",
                CubeListBuilder.create().texOffs(114, 20)
                        .addBox(-2.0F, -8.0F, -1.5F, 4, 8, 3),
                PartPose.offsetAndRotation(-5.5F, -4.5F, 3.0F, -0.5236F, 0.5236F, -0.7854F));

        // GlowBodyMain (scaffold for glow)
        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        // EyeL (child of GlowBodyMain - glow)
        glowBodyMain.addOrReplaceChild("EyeL",
                CubeListBuilder.create().texOffs(65, 50)
                        .addBox(0.0F, -3.0F, -3.0F, 0, 5, 5),
                PartPose.offsetAndRotation(8.1F, -3.3F, 0.5F, -0.1745F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
        // Yaw/pitch rotation
        this.BodyMain.yRot = netHeadYaw / 57F;
        this.BodyMain.xRot = headPitch / 57F;
        this.GlowBodyMain.yRot = netHeadYaw / 57F;
        this.GlowBodyMain.xRot = headPitch / 57F;

        // Jaw animation
        this.JawMain.zRot = 0F;
        this.JawMain.xRot = Mth.cos(entity.tickCount * 0.125F) * 0.2F + 1.1F;
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
