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

public class ModelDestroyerHa extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "destroyer_ha"), "main");

    private final ModelPart Back;
    private final ModelPart NeckBack;
    private final ModelPart Body;
    private final ModelPart TailBack;
    private final ModelPart Head;
    private final ModelPart NeckBody;
    private final ModelPart HeadD01;
    private final ModelPart k00;
    private final ModelPart Face00;
    private final ModelPart Face01;
    private final ModelPart Face02;
    private final ModelPart ToothU;
    private final ModelPart HeadD02;
    private final ModelPart ToothL;
    private final ModelPart HeadD03;
    private final ModelPart k01;
    private final ModelPart k02;
    private final ModelPart k03;
    private final ModelPart LegLeftFront;
    private final ModelPart LegRightFront;
    private final ModelPart LegLeftEnd;
    private final ModelPart LegRightEnd;
    private final ModelPart TailEnd1;
    private final ModelPart TailEnd2;
    private final ModelPart GlowBack;
    private final ModelPart GlowNeckBack;
    private final ModelPart GlowHead;

    public ModelDestroyerHa(ModelPart root) {
        super();
        this.Back = root.getChild("Back");
        this.TailBack = this.Back.getChild("TailBack");
        this.NeckBack = this.Back.getChild("NeckBack");
        this.Body = this.Back.getChild("Body");
        this.TailEnd1 = this.TailBack.getChild("TailEnd1");
        this.TailEnd2 = this.TailBack.getChild("TailEnd2");
        this.Head = this.NeckBack.getChild("Head");
        this.NeckBody = this.NeckBack.getChild("NeckBody");
        this.LegRightFront = this.Body.getChild("LegRightFront");
        this.LegLeftFront = this.Body.getChild("LegLeftFront");
        this.ToothU = this.Head.getChild("ToothU");
        this.HeadD01 = this.Head.getChild("HeadD01");
        this.LegRightEnd = this.LegRightFront.getChild("LegRightEnd");
        this.LegLeftEnd = this.LegLeftFront.getChild("LegLeftEnd");
        this.HeadD02 = this.HeadD01.getChild("HeadD02");
        this.ToothL = this.HeadD02.getChild("ToothL");
        this.HeadD03 = this.HeadD02.getChild("HeadD03");

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
                CubeListBuilder.create().texOffs(20, 73)
                        .addBox(-12.0F, -12.0F, -14.0F, 24.0F, 22.0F, 28.0F),
                PartPose.offset(0.0F, -22.0F, 0.0F));

        PartDefinition tailBack = back.addOrReplaceChild("TailBack",
                CubeListBuilder.create().texOffs(30, 79)
                        .addBox(-10.0F, -4.0F, 0.0F, 20.0F, 17.0F, 22.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, 9.0F, 0.08726646259971647F, 0.0F, 0.0F));

        tailBack.addOrReplaceChild("TailEnd1",
                CubeListBuilder.create().texOffs(36, 81)
                        .addBox(-8.0F, -3.0F, 0.0F, 16.0F, 12.0F, 20.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 19.0F, 0.17453292519943295F, 0.0F, 0.0F));

        tailBack.addOrReplaceChild("TailEnd2",
                CubeListBuilder.create().texOffs(42, 85)
                        .addBox(-7.0F, -5.0F, 0.0F, 14.0F, 10.0F, 16.0F),
                PartPose.offsetAndRotation(0.0F, 8.0F, 20.0F, -0.5235987755982988F, 0.0F, 0.0F));

        PartDefinition neckBack = back.addOrReplaceChild("NeckBack",
                CubeListBuilder.create().texOffs(24, 79)
                        .addBox(-13.0F, -10.0F, -20.0F, 26.0F, 26.0F, 22.0F),
                PartPose.offsetAndRotation(0.0F, -2.5F, -11.0F, -0.0873F, 0.0F, 0.0F));

        PartDefinition head = neckBack.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(16, 75)
                        .addBox(-13.5F, -14.0F, -28.0F, 27.0F, 27.0F, 26.0F),
                PartPose.offsetAndRotation(0.0F, 3.0F, -13.0F, -0.17453292519943295F, 0.0F, 0.0F));

        head.addOrReplaceChild("ToothU",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-11.0F, 0.0F, 0.0F, 22.0F, 7.0F, 22.0F),
                PartPose.offsetAndRotation(0.0F, 12.5F, -28.5F, 0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition headD01 = head.addOrReplaceChild("HeadD01",
                CubeListBuilder.create().texOffs(45, 94)
                        .addBox(-12.0F, 0.0F, -3.0F, 24.0F, 16.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 12.0F, -3.0F, -0.13962634015954636F, 0.0F, 0.0F));

        PartDefinition headD02 = headD01.addOrReplaceChild("HeadD02",
                CubeListBuilder.create().texOffs(27, 77)
                        .addBox(-10.5F, 0.0F, -21.0F, 21.0F, 8.0F, 24.0F),
                PartPose.offsetAndRotation(0.0F, 9.5F, -1.5F, 0.3490658503988659F, 0.0F, 0.0F));

        headD02.addOrReplaceChild("ToothL",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-11.0F, 0.0F, -22.0F, 22.0F, 7.0F, 22.0F),
                PartPose.offsetAndRotation(0.0F, 1.0F, 0.5F, -3.089232776029963F, -3.141592653589793F,
                        0.0F));

        headD02.addOrReplaceChild("HeadD03",
                CubeListBuilder.create().texOffs(44, 83)
                        .addBox(-5.0F, 0.0F, 0.0F, 10.0F, 10.0F, 18.0F),
                PartPose.offsetAndRotation(0.0F, 5.0F, -28.0F, 0.3490658503988659F, 0.0F, 0.0F));

        neckBack.addOrReplaceChild("NeckBody",
                CubeListBuilder.create().texOffs(46, 34)
                        .addBox(-9.0F, 0.0F, -9.0F, 18.0F, 11.0F, 22.0F),
                PartPose.offset(0.0F, 15.0F, -8.0F));

        PartDefinition body = back.addOrReplaceChild("Body",
                CubeListBuilder.create().texOffs(44, 32)
                        .addBox(-9.0F, 0.0F, 0.0F, 18.0F, 14.0F, 24.0F),
                PartPose.offsetAndRotation(0.0F, 11.0F, -18.0F, 0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition legRightFront = body.addOrReplaceChild("LegRightFront",
                CubeListBuilder.create().texOffs(66, 46)
                        .addBox(-5.0F, -4.0F, -5.0F, 10.0F, 16.0F, 10.0F),
                PartPose.offsetAndRotation(-12.0F, 7.0F, 14.0F, -0.5235987755982988F, 0.0F, 0.0F));

        legRightFront.addOrReplaceChild("LegRightEnd",
                CubeListBuilder.create().texOffs(70, 48)
                        .addBox(-4.0F, -3.0F, -4.0F, 8.0F, 16.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.6981317007977318F, 0.0F, 0.0F));

        PartDefinition legLeftFront = body.addOrReplaceChild("LegLeftFront",
                CubeListBuilder.create().texOffs(66, 46)
                        .addBox(-5.0F, -4.0F, -5.0F, 10.0F, 16.0F, 10.0F),
                PartPose.offsetAndRotation(12.0F, 7.0F, 14.0F, -0.5235987755982988F, 0.0F, 0.0F));

        legLeftFront.addOrReplaceChild("LegLeftEnd",
                CubeListBuilder.create().texOffs(70, 48)
                        .addBox(-4.0F, -3.0F, -4.0F, 8.0F, 16.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.6981317007977318F, 0.0F, 0.0F));

        PartDefinition glowBack = partdefinition.addOrReplaceChild("GlowBack",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -22.0F, 0.0F));

        PartDefinition glowNeckBack = glowBack.addOrReplaceChild("GlowNeckBack",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -2.5F, -11.0F));

        PartDefinition glowHead = glowNeckBack.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 3.0F, -13.0F));
        // [PORT] 1.10.2 -> 1.20.1: DestroyerHa uses model-specific 3-face atlas.
        glowHead.addOrReplaceChild("Face00",
                CubeListBuilder.create().texOffs(0, 81)
                        .addBox(-10.0F, 0.0F, 0.0F, 20.0F, 20.0F, 0.0F),
                PartPose.offset(0.0F, -12.0F, -28.1F));
        glowHead.addOrReplaceChild("Face01",
                CubeListBuilder.create().texOffs(0, 61)
                        .addBox(-10.0F, 0.0F, 0.0F, 20.0F, 20.0F, 0.0F),
                PartPose.offset(0.0F, -12.0F, -28.2F));
        glowHead.addOrReplaceChild("Face02",
                CubeListBuilder.create().texOffs(0, 41)
                        .addBox(-10.0F, 0.0F, 0.0F, 20.0F, 20.0F, 0.0F),
                PartPose.offset(0.0F, -12.0F, -28.3F));

        PartDefinition k00 = glowHead.addOrReplaceChild("k00",
                CubeListBuilder.create().texOffs(102, 84)
                        .addBox(0.0F, 0.0F, 0.0F, 5.0F, 8.0F, 8.0F),
                PartPose.offsetAndRotation(13.0F, -8.0F, -10.0F, 0.0F, 0.17453292519943295F, 0.0F));

        k00.addOrReplaceChild("k01",
                CubeListBuilder.create().texOffs(90, 0)
                        .addBox(1.0F, -18.5F, 1.0F, 3.0F, 18.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5235987755982988F, 0.0F, 0.0F));

        k00.addOrReplaceChild("k02",
                CubeListBuilder.create().texOffs(90, 0)
                        .addBox(0.8F, -25.0F, -0.7F, 3.0F, 18.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.3962634015954636F, 0.0F, 0.0F));

        k00.addOrReplaceChild("k03",
                CubeListBuilder.create().texOffs(90, 0)
                        .addBox(0.6F, -24.5F, -2.5F, 3.0F, 18.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.0943951023931953F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
        IShipEmotion ent = (IShipEmotion) entity;
        // [PORT] 1.10.2 -> 1.20.1: legacy model used fixed render transform.
        this.scale = 0.45F;
        this.offsetY = 1F;
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
                    this.offsetY += 0.5F;
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
        // [PORT] 1.10.2 -> 1.20.1: motionStopPos applied +0.5Y in NoFuel state.
        this.offsetY += 0.5F;

        // [PORT] 1.10.2 -> 1.20.1: legacy dead pose uses face index 2.
        this.setFace(2);

        this.Back.xRot = 0F;
        this.Back.zRot = -1.66F;
        this.NeckBack.xRot = 0.1745F;
        this.NeckBack.yRot = 0F;
        this.Head.xRot = 0.1745F;
        this.Head.yRot = 0F;
        this.HeadD01.xRot = 0.1745F;

        this.TailBack.xRot = 0.4F;
        this.TailBack.yRot = 0F;
        this.TailEnd1.xRot = 0.4F;
        this.TailEnd1.yRot = 0F;

        this.LegLeftFront.xRot = 0.35F;
        this.LegLeftFront.zRot = 0.52F;
        this.LegLeftEnd.xRot = 0F;
        this.LegLeftEnd.zRot = 0.52F;
        this.LegRightFront.xRot = -0.2F;
        this.LegRightFront.zRot = 0.087F;
        this.LegRightEnd.xRot = 0.52F;

    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        float angleX = Mth.cos(f2 * 0.125F);
        float angle1 = Mth.cos(f * 0.6662F) * 0.5F * f1;
        float angle2 = Mth.sin(f * 0.6662F) * 0.5F * f1;
        float angleSit = Mth.cos(f2);

        // [PORT] 1.10.2 -> 1.20.1: restore legacy water bobbing translation.
        if (ent.getShipDepth(0) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        this.Back.xRot = -0.1F;
        this.Back.zRot = 0F;
        this.NeckBack.xRot = -0.15F;
        this.NeckBack.yRot = 0F;
        this.Head.xRot = -0.2F;
        this.Head.yRot = 0F;
        this.LegLeftFront.zRot = 0F;
        this.LegLeftEnd.zRot = 0F;
        this.LegRightFront.zRot = 0F;

        if (f4 != 0F) {
            this.NeckBack.xRot = f4 * 0.005F;
            this.NeckBack.yRot = f3 * 0.005F;
            this.Head.xRot = f4 * 0.005F;
            this.Head.yRot = f3 * 0.005F;
            this.HeadD01.xRot = angleX * 0.05F - 0.05F;
            this.TailBack.xRot = 0.15F;
            this.TailBack.yRot = f3 * -0.005F;
            this.TailEnd1.xRot = 0.2F;
            this.TailEnd1.yRot = f3 * -0.005F;
        } else {
            this.HeadD01.xRot = angleX * 0.05F - 0.05F;
        }

        if (ent.getIsSitting()) {
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                this.setFace(1);
                this.offsetY += 0.4F;
                this.Back.xRot = -0.8F;
                this.NeckBack.xRot = -0.2618F;
                this.Head.xRot = -0.2618F;
                this.HeadD01.xRot = -angleSit * 0.05F + 0.2618F;
                this.LegRightFront.xRot = -0.7F;
                this.LegLeftFront.xRot = angleSit * 0.5F - 2.5F;
                this.LegRightEnd.xRot = 0.35F;
                this.LegLeftEnd.xRot = angleSit * 0.3F + 0.7F;
                this.TailBack.xRot = 0.35F;
                this.TailEnd1.xRot = 0.35F;
            } else {
                this.offsetY += 0.5F;
                this.Back.xRot = 0F;
                this.Back.zRot = -1.5708F;
                this.NeckBack.xRot = 0.1745F;
                this.Head.xRot = 0.1745F;
                this.HeadD01.xRot = 0.1745F;
                this.LegRightFront.xRot = 0F;
                this.LegLeftFront.xRot = 0.5F;
                this.LegRightEnd.xRot = 1.7F;
                this.LegLeftEnd.xRot = 1.5F;
                this.TailBack.xRot = -0.7F;
                this.TailEnd1.xRot = -0.5F;
            }
        } else {
            this.TailBack.xRot = angleX * 0.05F + 0.1745F;
            this.TailEnd1.xRot = angleX * 0.1F + 0.2618F;
            this.LegRightFront.xRot = angle1 - 0.5F;
            this.LegLeftFront.xRot = -angle1 - 0.5F;
            this.LegRightEnd.xRot = angle2 + 1F;
            this.LegLeftEnd.xRot = -angle2 + 1F;
        }

    }

    @Override
    public void setFace(int emo) {
        this.Face00.visible = (emo == 0);
        this.Face01.visible = (emo == 1);
        this.Face02.visible = (emo == 2);
    }
}
