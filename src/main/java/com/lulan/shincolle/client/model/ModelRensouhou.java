package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.reference.Reference;
import com.lulan.shincolle.utility.EmotionHelper;
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
 * ModelRensouhou - PinkaLulan 2015/3/27
 * Ported from Tabula 4.1.1 to 1.20.1 ModelPart system.
 */
public class ModelRensouhou extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "rensouhou"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Head;
    private final ModelPart ArmLeft;
    private final ModelPart ArmRight;
    private final ModelPart LegLeft;
    private final ModelPart LegRight;
    private final ModelPart Propeller;
    private final ModelPart CannonL01;
    private final ModelPart CannonR01;
    private final ModelPart RFace0;
    private final ModelPart RFace1;
    private final ModelPart RFace2;

    public ModelRensouhou(ModelPart root) {
        super();
        this.BodyMain = root.getChild("BodyMain");
        this.ArmLeft = this.BodyMain.getChild("ArmLeft");
        this.ArmRight = this.BodyMain.getChild("ArmRight");
        ModelPart swimRing = this.BodyMain.getChild("SwimRing");
        this.Propeller = swimRing.getChild("Propeller");
        this.LegRight = swimRing.getChild("LegRight");
        this.LegLeft = swimRing.getChild("LegLeft");
        this.Head = this.BodyMain.getChild("Head");
        this.CannonL01 = this.Head.getChild("CannonL01");
        this.CannonR01 = this.Head.getChild("CannonR01");
        this.RFace0 = this.Head.getChild("Face0");
        this.RFace1 = this.Head.getChild("Face1");
        this.RFace2 = this.Head.getChild("Face2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        // BodyMain
        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-5.0F, -6.0F, -5.0F, 10, 11, 10),
                PartPose.offset(0.0F, 7.0F, 0.0F));

        // ArmLeft (child of BodyMain)
        bodyMain.addOrReplaceChild("ArmLeft",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.5F, 0.0F, -8.0F, 5, 2, 8),
                PartPose.offsetAndRotation(5.0F, -4.0F, -4.0F, 1.0472F, -0.5236F, 0.0F));

        // ArmRight (child of BodyMain)
        bodyMain.addOrReplaceChild("ArmRight",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.5F, 0.0F, -8.0F, 5, 2, 8),
                PartPose.offsetAndRotation(-5.0F, -4.0F, -4.0F, 1.0472F, 0.5236F, 0.0F));

        // SwimRing (child of BodyMain)
        PartDefinition swimRing = bodyMain.addOrReplaceChild("SwimRing",
                CubeListBuilder.create().texOffs(0, 29)
                        .addBox(-9.0F, 0.0F, -9.0F, 18, 7, 18),
                PartPose.offset(0.0F, 5.0F, 0.0F));

        // Propeller (child of SwimRing)
        swimRing.addOrReplaceChild("Propeller",
                CubeListBuilder.create().texOffs(0, 24)
                        .addBox(-2.5F, -2.5F, 0.0F, 5, 5, 2),
                PartPose.offset(0.0F, 4.0F, 9.0F));

        // LegRight (child of SwimRing)
        swimRing.addOrReplaceChild("LegRight",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.5F, 0.0F, -7.0F, 5, 2, 7),
                PartPose.offsetAndRotation(-4.0F, 6.0F, 0.0F, 0.5236F, 0.3491F, 0.0F));

        // LegLeft (child of SwimRing)
        swimRing.addOrReplaceChild("LegLeft",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.5F, 0.0F, -7.0F, 5, 2, 7),
                PartPose.offsetAndRotation(4.0F, 6.0F, 0.0F, 0.5236F, -0.3491F, 0.0F));

        // Head (child of BodyMain)
        PartDefinition head = bodyMain.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(56, 37)
                        .addBox(-9.0F, -8.0F, -9.0F, 18, 9, 18),
                PartPose.offset(0.0F, -7.0F, 0.0F));

        // EarL (child of Head)
        head.addOrReplaceChild("EarL",
                CubeListBuilder.create().texOffs(55, 20)
                        .addBox(-2.0F, 0.0F, 0.0F, 4, 3, 7),
                PartPose.offset(7.0F, -11.0F, -9.0F));

        // EarR (child of Head, mirrored)
        head.addOrReplaceChild("EarR",
                CubeListBuilder.create().texOffs(55, 20).mirror()
                        .addBox(-2.0F, 0.0F, 0.0F, 4, 3, 7),
                PartPose.offset(-7.0F, -11.0F, -9.0F));

        // HeadBack (child of Head)
        head.addOrReplaceChild("HeadBack",
                CubeListBuilder.create().texOffs(70, 22)
                        .addBox(-9.0F, 0.0F, 0.0F, 18, 4, 11),
                PartPose.offset(0.0F, -12.0F, -2.0F));

        // Radar (child of Head)
        head.addOrReplaceChild("Radar",
                CubeListBuilder.create().texOffs(0, 37)
                        .addBox(0.0F, 0.0F, 0.0F, 4, 4, 5),
                PartPose.offset(5.0F, -15.0F, -5.0F));

        // CannonL01 (child of Head)
        PartDefinition cannonL01 = head.addOrReplaceChild("CannonL01",
                CubeListBuilder.create().texOffs(54, 36)
                        .addBox(-2.0F, -2.0F, -6.0F, 4, 4, 6),
                PartPose.offsetAndRotation(2.5F, -9.0F, -2.0F, -0.5236F, -0.0349F, 0.0F));

        // CannonL02 (child of CannonL01)
        cannonL01.addOrReplaceChild("CannonL02",
                CubeListBuilder.create().texOffs(0, 1)
                        .addBox(-1.5F, -1.5F, -26.0F, 3, 3, 20),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        // CannonR01 (child of Head)
        PartDefinition cannonR01 = head.addOrReplaceChild("CannonR01",
                CubeListBuilder.create().texOffs(54, 36)
                        .addBox(-2.0F, -2.0F, -6.0F, 4, 4, 6),
                PartPose.offsetAndRotation(-2.5F, -9.0F, -2.0F, -0.5236F, 0.0349F, 0.0F));

        // CannonR02 (child of CannonR01)
        cannonR01.addOrReplaceChild("CannonR02",
                CubeListBuilder.create().texOffs(0, 1)
                        .addBox(-1.5F, -1.5F, -26.0F, 3, 3, 20),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        // Face0 (child of Head)
        head.addOrReplaceChild("Face0",
                CubeListBuilder.create().texOffs(54, 0)
                        .addBox(-8.5F, 0.0F, 0.0F, 17, 9, 0),
                PartPose.offset(0.0F, -8.0F, -9.1F));

        // Face1 (child of Head)
        head.addOrReplaceChild("Face1",
                CubeListBuilder.create().texOffs(54, 9)
                        .addBox(-8.5F, 0.0F, 0.0F, 17, 9, 0),
                PartPose.offset(0.0F, -8.0F, -9.1F));

        // Face2 (child of Head)
        head.addOrReplaceChild("Face2",
                CubeListBuilder.create().texOffs(88, 0)
                        .addBox(-8.5F, 0.0F, 0.0F, 17, 9, 0),
                PartPose.offset(0.0F, -8.0F, -9.1F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
        IShipEmotion ent = (IShipEmotion) entity;

        // FIX: head rotation bug while riding
        if (netHeadYaw <= -180F) {
            netHeadYaw += 360F;
        } else if (netHeadYaw >= 180F) {
            netHeadYaw -= 360F;
        }

        // Scale level
        switch (ent.getScaleLevel()) {
            case 3:
                this.scale = 1.08F;
                this.offsetY = -0.09F;
                break;
            case 2:
                this.scale = 0.81F;
                this.offsetY = 0.4F;
                break;
            case 1:
                this.scale = 0.54F;
                this.offsetY = 1.32F;
                break;
            default:
                this.scale = 0.27F;
                this.offsetY = 4.09F;
                break;
        }

        // Roll emotion (simple face system)
        EmotionHelper.rollEmotion(this, ent);

        // Animation
        float angleX = Mth.cos(ageInTicks * 0.08F);
        float angleRun = Mth.cos(limbSwing) * limbSwingAmount;

        // Leg move
        float addk1 = Mth.cos(limbSwing * 0.7F) * limbSwingAmount + 0.7F;
        float addk2 = Mth.cos(limbSwing * 0.7F + 3.1415927F) * limbSwingAmount + 0.7F;

        // Body
        this.Head.yRot = netHeadYaw / 57F;
        this.BodyMain.xRot = 0F;

        // Arm
        this.ArmLeft.xRot = angleX * 0.3F + 0.9F;
        this.ArmRight.xRot = angleX * 0.3F + 0.9F;

        // Cannon
        this.CannonL01.xRot = angleX * 0.05F - 0.5F;
        this.CannonR01.xRot = -angleX * 0.05F - 0.5F;

        // Propeller
        this.Propeller.zRot = (ageInTicks / 4F) % 360F;

        if (limbSwingAmount > 0.9F) {
            // Running
            setFace(2);
            this.BodyMain.xRot = 0.2618F;
            this.ArmLeft.xRot = angleRun * 0.3F + 0.9F;
            this.ArmRight.xRot = angleRun * 0.3F + 0.9F;
            this.CannonL01.xRot = angleRun * 0.05F - 0.5F;
            this.CannonR01.xRot = -angleRun * 0.05F - 0.5F;
            this.Propeller.zRot = (limbSwing / 2F) % 360F;
        }

        // Attack
        if (ent.getAttackTick() > 0) {
            setFace(2);
        }

        // Leg motion
        this.LegLeft.xRot = addk1;
        this.LegRight.xRot = addk2;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
                               float red, float green, float blue, float alpha) {
        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);
        poseStack.translate(offsetX, offsetY, offsetZ);

        // Main body (no separate glow tree for this model)
        this.BodyMain.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);

        poseStack.popPose();
    }

    // Custom 3-state face system (Face0/1/2)
    @Override
    public void setFace(int emo) {
        switch (emo) {
            case 0:
                this.RFace0.visible = true;
                this.RFace1.visible = false;
                this.RFace2.visible = false;
                break;
            case 1:
            case 4:
                this.RFace0.visible = false;
                this.RFace1.visible = true;
                this.RFace2.visible = false;
                break;
            case 2:
            case 3:
                this.RFace0.visible = false;
                this.RFace1.visible = false;
                this.RFace2.visible = true;
                break;
            default:
                break;
        }
    }

    // No mouth/flush system
    @Override
    public void setMouth(int emo) {
    }

    @Override
    public void setFlush(boolean show) {
    }

    @Override
    public void setFaceNormal(IShipEmotion ent) {
        setFace(0);
    }

    @Override
    public void setFaceBlink0(IShipEmotion ent) {
        setFace(0);
    }

    @Override
    public void setFaceBlink1(IShipEmotion ent) {
        setFace(1);
    }

    @Override
    public void setFaceCry(IShipEmotion ent) {
        setFace(1);
    }

    @Override
    public void setFaceAttack(IShipEmotion ent) {
        setFace(2);
    }

    @Override
    public void setFaceDamaged(IShipEmotion ent) {
        setFace(2);
    }

    @Override
    public void setFaceScorn(IShipEmotion ent) {
        setFace(2);
    }

    @Override
    public void setFaceHungry(IShipEmotion ent) {
        setFace(1);
    }

    @Override
    public void setFaceAngry(IShipEmotion ent) {
        setFace(2);
    }

    @Override
    public void setFaceBored(IShipEmotion ent) {
        setFace(0);
    }

    @Override
    public void setFaceShy(IShipEmotion ent) {
        setFace(0);
    }

    @Override
    public void setFaceHappy(IShipEmotion ent) {
        setFace(0);
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
