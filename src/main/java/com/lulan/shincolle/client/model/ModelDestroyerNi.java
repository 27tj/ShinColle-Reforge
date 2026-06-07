package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.reference.ID;
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

public class ModelDestroyerNi extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "destroyer_ni"), "main");

    private final ModelPart Back;
    private final ModelPart NeckBack;
    private final ModelPart Body;
    private final ModelPart TailBack;
    private final ModelPart Head;
    private final ModelPart NeckBody;
    private final ModelPart EquipBase;
    private final ModelPart ArmLeft;
    private final ModelPart ArmRight;
    private final ModelPart k00;
    private final ModelPart Face00;
    private final ModelPart Face01;
    private final ModelPart Face02;
    private final ModelPart ToothU;
    private final ModelPart k01;
    private final ModelPart k02;
    private final ModelPart k03;
    private final ModelPart Equip01;
    private final ModelPart Equip02;
    private final ModelPart Equip03;
    private final ModelPart ArmLeft01;
    private final ModelPart ArmRight01;
    private final ModelPart TailEnd1;
    private final ModelPart GlowBack;
    private final ModelPart GlowNeckBack;
    private final ModelPart GlowHead;

    public ModelDestroyerNi(ModelPart root) {
        super();
        this.Back = root.getChild("Back");
        this.Body = this.Back.getChild("Body");
        this.NeckBack = this.Back.getChild("NeckBack");
        this.TailBack = this.Back.getChild("TailBack");
        this.NeckBody = this.NeckBack.getChild("NeckBody");
        this.ArmRight = this.NeckBack.getChild("ArmRight");
        this.EquipBase = this.NeckBack.getChild("EquipBase");
        this.Head = this.NeckBack.getChild("Head");
        this.ArmLeft = this.NeckBack.getChild("ArmLeft");
        this.TailEnd1 = this.TailBack.getChild("TailEnd1");
        this.ArmRight01 = this.ArmRight.getChild("ArmRight01");
        this.Equip01 = this.EquipBase.getChild("Equip01");
        this.ToothU = this.Head.getChild("ToothU");
        this.ArmLeft01 = this.ArmLeft.getChild("ArmLeft01");
        this.Equip02 = this.Equip01.getChild("Equip02");
        this.Equip03 = this.Equip02.getChild("Equip03");

        this.GlowBack = root.getChild("GlowBack");
        this.GlowNeckBack = this.GlowBack.getChild("GlowNeckBack");
        this.GlowHead = this.GlowNeckBack.getChild("GlowHead");
        this.loadFaceParts(this.GlowHead);
        this.Face00 = this.GlowHead.getChild("Face00");
        this.Face01 = this.GlowHead.getChild("Face01");
        this.Face02 = this.GlowHead.getChild("Face02");
        this.k00 = this.GlowHead.getChild("k00");
        this.k01 = this.k00.getChild("k01");
        this.k02 = this.k00.getChild("k02");
        this.k03 = this.k00.getChild("k03");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition back = partdefinition.addOrReplaceChild("Back",
                CubeListBuilder.create().texOffs(14, 76)
                        .addBox(-12.0F, -12.0F, -14.0F, 24.0F, 21.0F, 26.0F),
                PartPose.offsetAndRotation(0.0F, -40.0F, 0.0F, 0.7853981633974483F, 0.0F, 0.0F));

        back.addOrReplaceChild("Body",
                CubeListBuilder.create().texOffs(0, 33)
                        .addBox(-10.0F, 0.0F, 0.0F, 20.0F, 12.0F, 24.0F),
                PartPose.offsetAndRotation(0.0F, 11.0F, -14.0F, 0.36425021489121656F, 0.0F, 0.0F));

        PartDefinition neckBack = back.addOrReplaceChild("NeckBack",
                CubeListBuilder.create().texOffs(10, 76)
                        .addBox(-14.0F, -10.0F, -20.0F, 28.0F, 25.0F, 26.0F),
                PartPose.offsetAndRotation(0.0F, -2.5F, -14.0F, 0.08726646259971647F, 0.0F, 0.0F));

        neckBack.addOrReplaceChild("NeckBody",
                CubeListBuilder.create().texOffs(1, 36)
                        .addBox(-11.0F, 0.0F, -9.0F, 22.0F, 10.0F, 21.0F),
                PartPose.offsetAndRotation(0.0F, 13.0F, -4.0F, -0.31869712141416456F, 0.0F, 0.0F));

        PartDefinition armRight = neckBack.addOrReplaceChild("ArmRight",
                CubeListBuilder.create().texOffs(0, 31)
                        .addBox(-4.0F, 0.0F, -4.0F, 8.0F, 30.0F, 8.0F),
                PartPose.offsetAndRotation(-13.0F, 15.0F, -9.0F, -0.5235987755982988F,
                        0.6981317007977318F, 1.0471975511965976F));

        armRight.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().texOffs(2, 32)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 30.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 28.0F, 0.0F, 0.0F, 0.0F, -1.3962634015954636F));

        PartDefinition equipBase = neckBack.addOrReplaceChild("EquipBase",
                CubeListBuilder.create().texOffs(11, 89)
                        .addBox(-20.0F, 0.0F, 0.0F, 40.0F, 13.0F, 13.0F),
                PartPose.offset(0.0F, 11.0F, -26.0F));

        PartDefinition equip01 = equipBase.addOrReplaceChild("Equip01",
                CubeListBuilder.create().texOffs(54, 64)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 24.0F, 5.0F),
                PartPose.offsetAndRotation(18.0F, 13.0F, 9.0F, 1.0471975511965976F, 0.7853981633974483F,
                        0.0F));

        PartDefinition equip02 = equip01.addOrReplaceChild("Equip02",
                CubeListBuilder.create().texOffs(54, 64)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 28.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 1.3089969389957472F));

        equip02.addOrReplaceChild("Equip03",
                CubeListBuilder.create().texOffs(54, 64)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 32.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 28.0F, 0.0F, 0.0F, 0.0F, -1.0471975511965976F));

        PartDefinition head = neckBack.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(0, 70)
                        .addBox(-16.0F, -14.0F, -28.0F, 32.0F, 22.0F, 32.0F),
                PartPose.offsetAndRotation(0.0F, 3.0F, -19.0F, 0.08726646259971647F, 0.0F, 0.0F));

        head.addOrReplaceChild("ToothU",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-11.0F, 0.0F, 0.0F, 22.0F, 9.0F, 22.0F),
                PartPose.offsetAndRotation(0.0F, 7.0F, -29.0F, 0.13962634015954636F, 0.0F, 0.0F));

        PartDefinition armLeft = neckBack.addOrReplaceChild("ArmLeft",
                CubeListBuilder.create().texOffs(0, 31)
                        .addBox(-4.0F, 0.0F, -4.0F, 8.0F, 30.0F, 8.0F),
                PartPose.offsetAndRotation(13.0F, 15.0F, -9.0F, -0.5235987755982988F,
                        -0.6981317007977318F, -1.0471975511965976F));

        armLeft.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().texOffs(2, 32)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 30.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 28.0F, 0.0F, 0.0F, 0.0F, 1.3962634015954636F));

        PartDefinition tailBack = back.addOrReplaceChild("TailBack",
                CubeListBuilder.create().texOffs(22, 80)
                        .addBox(-10.0F, -4.0F, 0.0F, 20.0F, 17.0F, 22.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, 9.0F, -0.17453292519943295F, 0.0F, 0.0F));

        tailBack.addOrReplaceChild("TailEnd1",
                CubeListBuilder.create().texOffs(28, 82)
                        .addBox(-8.0F, -3.0F, 0.0F, 16.0F, 13.0F, 20.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 19.0F, -0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition glowBack = partdefinition.addOrReplaceChild("GlowBack",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -40.0F, 0.0F));

        PartDefinition glowNeckBack = glowBack.addOrReplaceChild("GlowNeckBack",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -2.5F, -14.0F));

        PartDefinition glowHead = glowNeckBack.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 3.0F, -19.0F));
        // [PORT] 1.10.2 -> 1.20.1: DestroyerNi uses model-specific 3-face atlas.
        glowHead.addOrReplaceChild("Face00",
                CubeListBuilder.create().texOffs(68, 40)
                        .addBox(-10.0F, 0.0F, 0.0F, 20.0F, 0.0F, 20.0F),
                PartPose.offset(0.0F, -14.3F, -27.0F));
        glowHead.addOrReplaceChild("Face01",
                CubeListBuilder.create().texOffs(68, 20)
                        .addBox(-10.0F, 0.0F, 0.0F, 20.0F, 0.0F, 20.0F),
                PartPose.offset(0.0F, -14.2F, -27.0F));
        glowHead.addOrReplaceChild("Face02",
                CubeListBuilder.create().texOffs(68, 0)
                        .addBox(-10.0F, 0.0F, 0.0F, 20.0F, 0.0F, 20.0F),
                PartPose.offset(0.0F, -14.1F, -27.0F));

        PartDefinition k00 = glowHead.addOrReplaceChild("k00",
                CubeListBuilder.create().texOffs(100, 60)
                        .addBox(0.0F, 0.0F, 0.0F, 5.0F, 8.0F, 8.0F),
                PartPose.offsetAndRotation(14.0F, -12.0F, 0.0F, -0.3490658503988659F,
                        0.2617993877991494F, 0.0F));

        k00.addOrReplaceChild("k01",
                CubeListBuilder.create().texOffs(106, 76)
                        .addBox(1.0F, -18.5F, 1.0F, 3.0F, 18.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5235987755982988F, 0.0F, 0.0F));

        k00.addOrReplaceChild("k02",
                CubeListBuilder.create().texOffs(106, 76)
                        .addBox(0.8F, -25.0F, -0.7F, 3.0F, 18.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.3962634015954636F, 0.0F, 0.0F));

        k00.addOrReplaceChild("k03",
                CubeListBuilder.create().texOffs(106, 76)
                        .addBox(0.6F, -24.5F, -2.5F, 3.0F, 18.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.0943951023931953F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
        IShipEmotion ent = (IShipEmotion) entity;
        // [PORT] 1.10.2 -> 1.20.1: legacy model used fixed render transform.
        this.scale = 0.35F;
        this.offsetY = 1.1F;
        this.showEquip(ent);
        this.setFlush(ent.getStateMinor(ID.M.Morale) > ID.Morale.L_Happy);
        // [PORT] 1.10.2 -> 1.20.1: preserve legacy per-model emotion roll behavior.
        this.rollEmotionLegacy(ent);
        if (ent.getStateFlag(ID.F.NoFuel)) {
            this.applyDeadPose(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, ent);
        } else {
            this.applyNormalPose(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, ent);
        }
        this.syncRotationGlowPart();
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
                               float red, float green, float blue, float alpha) {
        // [PORT] 1.10.2 -> 1.20.1: model used fixed render transform without base
        // scaling.
        // Reversing the translation/scale order back to match 1.10.2 to prevent
        // hovering.
        poseStack.pushPose();
        poseStack.translate(offsetX, offsetY, offsetZ);
        poseStack.scale(scale, scale, scale);
        this.Back.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.GlowBack.render(poseStack, buffer, 0xF000F0, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();
    }

    @Override
    public void showEquip(IShipEmotion ent) {

        this.k00.visible = EmotionHelper.checkModelState(0, ent.getStateEmotion(ID.S.State));

    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowBack.xRot = this.Back.xRot;
        this.GlowBack.yRot = this.Back.yRot;
        this.GlowBack.zRot = this.Back.zRot;
        this.GlowNeckBack.xRot = this.NeckBack.xRot;
        this.GlowNeckBack.yRot = this.NeckBack.yRot;
        this.GlowNeckBack.zRot = this.NeckBack.zRot;
        this.GlowHead.xRot = this.Head.xRot;
        this.GlowHead.yRot = this.Head.yRot;
        this.GlowHead.zRot = this.Head.zRot;
    }

    private void rollEmotionLegacy(IShipEmotion ent) {
        switch (ent.getStateEmotion(ID.S.Emotion)) {
            case ID.Emotion.BLINK:
                EmotionHelper.applyEmotionBlink(this, ent);
                break;
            case ID.Emotion.T_T:
            case ID.Emotion.O_O:
            case ID.Emotion.HUNGRY:
                if (ent.getFaceTick() <= 0) {
                    // [PORT] Restored from 1.10.2 GlStateManager.translate
                    this.offsetY += 0.75F;
                    this.setFace(2);
                }
                break;
            case ID.Emotion.BORED:
                if (ent.getFaceTick() <= 0) {
                    this.setFace(1);
                }
                break;
            default:
                if (ent.getFaceTick() <= 0) {
                    this.setFace(0);
                } else {
                    EmotionHelper.applyEmotionBlink(this, ent);
                }

                if (ent.getTickExisted() % 120 == 0) {
                    int emotionRand = ent.getRand().nextInt(10);
                    if (emotionRand > 7) {
                        EmotionHelper.applyEmotionBlink(this, ent);
                    }
                }
                break;
        }
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        // [PORT] 1.10.2 -> 1.20.1: motionStopPos applied +0.75Y in NoFuel state.
        this.offsetY += 0.75F;

        // [PORT] 1.10.2 -> 1.20.1: legacy dead pose uses face index 2.
        this.setFace(2);

        this.NeckBack.xRot = 0.3F;
        this.NeckBack.yRot = 0F;
        this.Head.xRot = 0.3F;
        this.Head.yRot = 0F;
        this.Equip01.yRot = 0.5F;
        this.Equip02.zRot = 1F;
        this.Equip03.zRot = -0.8F;

        this.Back.xRot = -0.3236F;
        this.ArmLeft.xRot = -1.4F;
        this.ArmLeft.yRot = -0.7F;
        this.ArmLeft.zRot = -0.2618F;
        this.ArmRight.xRot = -1.4F;
        this.ArmRight.yRot = 0.9F;
        this.ArmRight.zRot = 0.2618F;
        this.ArmLeft01.xRot = 0F;
        this.ArmLeft01.zRot = 1.2F;
        this.ArmRight01.xRot = 0F;
        this.ArmRight01.zRot = -0.8F;
        this.TailBack.xRot = -0.1F;
        this.TailEnd1.xRot = 0.05F;
        this.Equip01.xRot = 2F;

    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        float angleX = Mth.cos(f2 * 0.125F);

        // [PORT] 1.10.2 -> 1.20.1: restore legacy water bobbing translation.
        if (ent.getShipDepth(0) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        this.Back.xRot = 0.7854F;
        this.ArmLeft.xRot = -0.5F;
        this.ArmLeft.yRot = -0.7F;
        this.ArmLeft.zRot = -1.2217F;
        this.ArmRight.xRot = -0.5F;
        this.ArmRight.yRot = 0.7F;
        this.ArmRight.zRot = 1.2217F;
        this.ArmLeft01.xRot = 0F;
        this.ArmLeft01.zRot = 1.4F;
        this.ArmRight01.xRot = 0F;
        this.ArmRight01.zRot = -1.4F;
        this.Equip01.xRot = 1F;

        if (f4 != 0F) {
            this.NeckBack.xRot = f4 * 0.005F;
            this.NeckBack.yRot = f3 * 0.005F;
            this.Head.xRot = f4 * 0.005F;
            this.Head.yRot = f3 * 0.005F;
        }

        if (ent.getIsSitting()) {
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                this.setFace(1);
                this.offsetY += angleX * 0.2F - 0.05F;
                this.ArmLeft.zRot = -angleX * 0.6F - 1.0472F;
                this.ArmLeft01.zRot = angleX * 0.5F + 1.2F;
                this.ArmRight.zRot = angleX * 0.6F + 1.0472F;
                this.ArmRight01.zRot = -angleX * 0.5F - 1.2F;
                this.TailBack.xRot = angleX * 0.1F + 0.2F;
                this.TailEnd1.xRot = angleX * 0.1F + 0.2F;
            } else {
                this.offsetY += 0.75F;
                this.Back.xRot = -0.5236F;
                this.ArmLeft.xRot = -0.6981F;
                this.ArmLeft.yRot = -0.2618F;
                this.ArmLeft.zRot = -0.2618F;
                this.ArmRight.xRot = -0.6981F;
                this.ArmRight.yRot = 0.2618F;
                this.ArmRight.zRot = 0.2618F;
                this.ArmLeft01.xRot = -1.9199F;
                this.ArmLeft01.zRot = -0.6981F;
                this.ArmRight01.xRot = -1.9199F;
                this.ArmRight01.zRot = 0.6981F;
                this.TailBack.xRot = angleX * 0.1F + 0.2F;
                this.TailEnd1.xRot = angleX * 0.1F + 0.2F;
                this.Equip01.xRot = 2F;
            }
        } else {
            float angle1 = Mth.cos(f * 0.6662F) * 1.1F * f1;
            this.ArmLeft.xRot = angle1 - 0.5F;
            this.ArmRight.xRot = -angle1 - 0.5F;
            this.TailBack.xRot = angleX * 0.2F;
            this.TailEnd1.xRot = angleX * 0.2F;
            this.Equip01.yRot = angleX * 0.2F + 0.5F;
            this.Equip02.zRot = angleX * 0.3F + 1F;
            this.Equip03.zRot = angleX * 0.4F - 0.8F;
        }

    }

    @Override
    public void setFace(int emo) {
        this.Face00.visible = (emo == 0);
        this.Face01.visible = (emo == 1);
        this.Face02.visible = (emo == 2);
    }
}
