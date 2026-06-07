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

public class ModelDestroyerRo extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "destroyer_ro"), "main");

    private final ModelPart Back;
    private final ModelPart NeckBack;
    private final ModelPart Body;
    private final ModelPart TailBack;
    private final ModelPart LegLeftFront;
    private final ModelPart LegRightFront;
    private final ModelPart BodyTurbine;
    private final ModelPart Head;
    private final ModelPart NeckBody;
    private final ModelPart HeadD03;
    private final ModelPart HeadU01;
    private final ModelPart HeadD01;
    private final ModelPart FaceL00;
    private final ModelPart FaceL01;
    private final ModelPart FaceL02;
    private final ModelPart FaceR00;
    private final ModelPart FaceR01;
    private final ModelPart FaceR02;
    private final ModelPart k00;
    private final ModelPart HeadD04;
    private final ModelPart UpperTooth;
    private final ModelPart HeadU02;
    private final ModelPart LowerTooth;
    private final ModelPart k01;
    private final ModelPart k02;
    private final ModelPart k03;
    private final ModelPart tube01;
    private final ModelPart tube02;
    private final ModelPart tube03;
    private final ModelPart TailEnd;
    private final ModelPart TailBack01;
    private final ModelPart TailBack02;
    private final ModelPart LegLeftEnd;
    private final ModelPart LegRightEnd;
    private final ModelPart GlowBack;
    private final ModelPart GlowNeckBack;
    private final ModelPart GlowHead;

    public ModelDestroyerRo(ModelPart root) {
        super();
        this.Back = root.getChild("Back");
        this.TailBack = this.Back.getChild("TailBack");
        this.LegRightFront = this.Back.getChild("LegRightFront");
        this.Body = this.Back.getChild("Body");
        this.LegLeftFront = this.Back.getChild("LegLeftFront");
        this.NeckBack = this.Back.getChild("NeckBack");
        this.BodyTurbine = this.Back.getChild("BodyTurbine");
        this.TailBack02 = this.TailBack.getChild("TailBack02");
        this.TailBack01 = this.TailBack.getChild("TailBack01");
        this.TailEnd = this.TailBack.getChild("TailEnd");
        this.LegRightEnd = this.LegRightFront.getChild("LegRightEnd");
        this.LegLeftEnd = this.LegLeftFront.getChild("LegLeftEnd");
        this.Head = this.NeckBack.getChild("Head");
        this.HeadD03 = this.NeckBack.getChild("HeadD03");
        this.NeckBody = this.NeckBack.getChild("NeckBody");
        this.HeadD04 = this.Head.getChild("HeadD04");
        this.HeadU01 = this.Head.getChild("HeadU01");
        this.HeadD01 = this.Head.getChild("HeadD01");
        this.tube01 = this.NeckBody.getChild("tube01");
        this.HeadU02 = this.HeadU01.getChild("HeadU02");
        this.UpperTooth = this.HeadU01.getChild("UpperTooth");
        this.LowerTooth = this.HeadD01.getChild("LowerTooth");
        this.tube03 = this.tube01.getChild("tube03");
        this.tube02 = this.tube01.getChild("tube02");

        this.GlowBack = root.getChild("GlowBack");
        this.GlowNeckBack = this.GlowBack.getChild("GlowNeckBack");
        this.GlowHead = this.GlowNeckBack.getChild("GlowHead");
        this.loadFaceParts(this.GlowHead);
        this.FaceL00 = this.GlowHead.getChild("FaceL00");
        this.FaceL01 = this.GlowHead.getChild("FaceL01");
        this.FaceL02 = this.GlowHead.getChild("FaceL02");
        this.FaceR00 = this.GlowHead.getChild("FaceR00");
        this.FaceR01 = this.GlowHead.getChild("FaceR01");
        this.FaceR02 = this.GlowHead.getChild("FaceR02");

        this.k00 = this.GlowHead.getChild("k00");
        this.k01 = this.k00.getChild("k01");
        this.k02 = this.k00.getChild("k02");
        this.k03 = this.k00.getChild("k03");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition back = partdefinition.addOrReplaceChild("Back",
                CubeListBuilder.create().texOffs(2, 32)
                        .addBox(-12.0F, -12.0F, -14.0F, 24.0F, 22.0F, 28.0F),
                PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, -0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition tailBack = back.addOrReplaceChild("TailBack",
                CubeListBuilder.create().texOffs(12, 38)
                        .addBox(-10.0F, -8.0F, 0.0F, 20.0F, 14.0F, 22.0F),
                PartPose.offsetAndRotation(0.0F, -2.0F, 11.0F, -0.08726646259971647F, 0.0F, 0.0F));

        tailBack.addOrReplaceChild("TailBack02",
                CubeListBuilder.create().texOffs(30, 40)
                        .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 10.0F, 20.0F),
                PartPose.offsetAndRotation(-8.0F, 0.0F, 15.0F, -1.0471975511965976F, 0.0F,
                        -0.40142572795869574F));

        tailBack.addOrReplaceChild("TailBack01",
                CubeListBuilder.create().texOffs(30, 40)
                        .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 10.0F, 20.0F),
                PartPose.offsetAndRotation(8.0F, 0.0F, 15.0F, -1.0471975511965976F, 0.0F,
                        0.40142572795869574F));

        tailBack.addOrReplaceChild("TailEnd",
                CubeListBuilder.create().texOffs(14, 36)
                        .addBox(-8.0F, -6.5F, 0.0F, 16.0F, 10.0F, 24.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 19.0F, -0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition legRightFront = back.addOrReplaceChild("LegRightFront",
                CubeListBuilder.create().texOffs(20, 104)
                        .addBox(-4.0F, -4.0F, -4.0F, 8.0F, 16.0F, 8.0F),
                PartPose.offsetAndRotation(-7.8F, 12.0F, -3.0F, 0.7853981633974483F, 0.0F, 0.0F));

        legRightFront.addOrReplaceChild("LegRightEnd",
                CubeListBuilder.create().texOffs(24, 106)
                        .addBox(-3.0F, -3.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.5235987755982988F, 0.0F, 0.0F));

        back.addOrReplaceChild("Body",
                CubeListBuilder.create().texOffs(4, 96)
                        .addBox(-8.0F, 0.0F, 0.0F, 16.0F, 7.0F, 16.0F),
                PartPose.offsetAndRotation(0.0F, 8.0F, -10.0F, 0.5235987755982988F, 0.0F, 0.0F));

        PartDefinition legLeftFront = back.addOrReplaceChild("LegLeftFront",
                CubeListBuilder.create().texOffs(20, 104)
                        .addBox(-4.0F, -4.0F, -4.0F, 8.0F, 16.0F, 8.0F),
                PartPose.offsetAndRotation(7.8F, 12.0F, -3.0F, 0.7853981633974483F, 0.0F, 0.0F));

        legLeftFront.addOrReplaceChild("LegLeftEnd",
                CubeListBuilder.create().texOffs(24, 106)
                        .addBox(-3.0F, -3.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.5235987755982988F, 0.0F, 0.0F));

        PartDefinition neckBack = back.addOrReplaceChild("NeckBack",
                CubeListBuilder.create().texOffs(8, 40)
                        .addBox(-13.0F, -11.0F, -20.0F, 26.0F, 26.0F, 22.0F),
                PartPose.offsetAndRotation(0.0F, -3.0F, -12.0F, 0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition head = neckBack.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(6, 42)
                        .addBox(-15.0F, -12.0F, -16.0F, 30.0F, 27.0F, 18.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -17.5F, 0.2617993877991494F, 0.0F, 0.0F));

        head.addOrReplaceChild("HeadD04",
                CubeListBuilder.create().texOffs(2, 94)
                        .addBox(-8.0F, 0.0F, 0.0F, 16.0F, 12.0F, 18.0F),
                PartPose.offsetAndRotation(0.0F, 7.0F, -15.0F, -0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition headU01 = head.addOrReplaceChild("HeadU01",
                CubeListBuilder.create().texOffs(6, 40)
                        .addBox(-14.0F, -21.0F, -9.0F, 28.0F, 16.0F, 20.0F),
                PartPose.offsetAndRotation(0.0F, 7.0F, -19.0F, -0.08726646259971647F, 0.0F, 0.0F));

        headU01.addOrReplaceChild("HeadU02",
                CubeListBuilder.create().texOffs(6, 40)
                        .addBox(-14.0F, 0.0F, 0.0F, 28.0F, 15.0F, 20.0F),
                PartPose.offsetAndRotation(0.0F, -20.0F, -23.0F, 0.08726646259971647F, 0.0F, 0.0F));

        headU01.addOrReplaceChild("UpperTooth",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-12.0F, 0.0F, 0.0F, 24.0F, 10.0F, 20.0F),
                PartPose.offsetAndRotation(0.0F, -6.0F, -15.0F, 0.3490658503988659F, 0.0F, 0.0F));

        PartDefinition headD01 = head.addOrReplaceChild("HeadD01",
                CubeListBuilder.create().texOffs(0, 34)
                        .addBox(-13.0F, 1.5F, -25.0F, 26.0F, 10.0F, 28.0F),
                PartPose.offsetAndRotation(0.0F, 1.0F, -10.3F, 0.6981317007977318F, 0.0F, 0.0F));

        headD01.addOrReplaceChild("LowerTooth",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-12.0F, 0.0F, 0.0F, 24.0F, 10.0F, 20.0F),
                PartPose.offsetAndRotation(0.0F, 9.5F, -5.5F, -3.490658503988659F, 0.0F, 0.0F));

        neckBack.addOrReplaceChild("HeadD03",
                CubeListBuilder.create().texOffs(2, 94)
                        .addBox(-8.5F, 0.0F, 0.0F, 17.0F, 12.0F, 11.0F),
                PartPose.offsetAndRotation(0.0F, 10.3F, -23.0F, -0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition neckBody = neckBack.addOrReplaceChild("NeckBody",
                CubeListBuilder.create().texOffs(0, 94)
                        .addBox(-9.0F, 0.0F, -9.0F, 18.0F, 14.0F, 18.0F),
                PartPose.offsetAndRotation(0.0F, 7.0F, -9.0F, 0.3490658503988659F, 0.0F, 0.0F));

        PartDefinition tube01 = neckBody.addOrReplaceChild("tube01",
                CubeListBuilder.create().texOffs(31, 40)
                        .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 20.0F),
                PartPose.offsetAndRotation(0.0F, 12.0F, 3.0F, -0.8726646259971648F, 0.0F, 0.0F));

        tube01.addOrReplaceChild("tube03",
                CubeListBuilder.create().texOffs(24, 32)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 28.0F),
                PartPose.offsetAndRotation(-1.0F, 1.5F, 18.0F, 1.0471975511965976F,
                        -0.13962634015954636F, 0.0F));

        tube01.addOrReplaceChild("tube02",
                CubeListBuilder.create().texOffs(24, 32)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 28.0F),
                PartPose.offsetAndRotation(1.0F, 1.5F, 18.0F, 1.0471975511965976F, 0.13962634015954636F,
                        0.0F));

        back.addOrReplaceChild("BodyTurbine",
                CubeListBuilder.create().texOffs(86, 89)
                        .addBox(-4.5F, 0.0F, 0.0F, 9.0F, 9.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 7.0F, -2.0F, -0.5235987755982988F, 0.0F, 0.0F));

        PartDefinition glowBack = partdefinition.addOrReplaceChild("GlowBack",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -16.0F, 0.0F));

        PartDefinition glowNeckBack = glowBack.addOrReplaceChild("GlowNeckBack",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -3.0F, -12.0F));

        PartDefinition glowHead = glowNeckBack.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, -17.5F));
        // [PORT] 1.10.2 -> 1.20.1: DestroyerRo uses side-projected dual-eye atlas.
        // [RENDER?] 目視検証必須: 左右側面フェイス(通常/困り/泣き)が旧版と同じ位置・UVで表示されること。
        glowHead.addOrReplaceChild("FaceL00",
                CubeListBuilder.create().texOffs(96, 96)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 16.0F, 16.0F),
                PartPose.offset(15.1F, -8.0F, -16.0F));
        glowHead.addOrReplaceChild("FaceL01",
                CubeListBuilder.create().texOffs(96, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 16.0F, 16.0F),
                PartPose.offset(15.1F, -8.0F, -16.0F));
        glowHead.addOrReplaceChild("FaceL02",
                CubeListBuilder.create().texOffs(96, 16)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 16.0F, 16.0F),
                PartPose.offset(15.1F, -8.0F, -16.0F));
        glowHead.addOrReplaceChild("FaceR00",
                CubeListBuilder.create().texOffs(96, 96)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 16.0F, 16.0F),
                PartPose.offset(-15.1F, -8.0F, -16.0F));
        glowHead.addOrReplaceChild("FaceR01",
                CubeListBuilder.create().texOffs(96, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 16.0F, 16.0F),
                PartPose.offset(-15.1F, -8.0F, -16.0F));
        glowHead.addOrReplaceChild("FaceR02",
                CubeListBuilder.create().texOffs(96, 16)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 16.0F, 16.0F),
                PartPose.offset(-15.1F, -8.0F, -16.0F));

        PartDefinition k00 = glowHead.addOrReplaceChild("k00",
                CubeListBuilder.create().texOffs(54, 94)
                        .addBox(0.0F, 0.0F, 0.0F, 5.0F, 8.0F, 8.0F),
                PartPose.offsetAndRotation(12.0F, -10.0F, 0.0F, 0.0F, 0.17453292519943295F, 0.0F));

        k00.addOrReplaceChild("k01",
                CubeListBuilder.create().texOffs(72, 102)
                        .addBox(1.0F, -18.5F, 1.0F, 3.0F, 18.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5235987755982988F, 0.0F, 0.0F));

        k00.addOrReplaceChild("k02",
                CubeListBuilder.create().texOffs(72, 102)
                        .addBox(0.8F, -25.0F, -0.7F, 3.0F, 18.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.3962634015954636F, 0.0F, 0.0F));

        k00.addOrReplaceChild("k03",
                CubeListBuilder.create().texOffs(72, 102)
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
        this.offsetY = 2.1F;
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
        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);
        poseStack.translate(offsetX, offsetY, offsetZ);
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
                    this.setFace(2);
                }
                break;
            case ID.Emotion.BORED:
                if (ent.getFaceTick() <= 0) {
                    // [PORT] Restored from 1.10.2 GlStateManager.translate
                    this.offsetY += 0.45F;
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
        // [PORT] 1.10.2 -> 1.20.1: motionStopPos applied +0.45Y in NoFuel state.
        this.offsetY += 0.45F;

        this.setFace(1);

        this.HeadD01.xRot = 0.7F;
        this.NeckBack.xRot = 0F;
        this.NeckBack.yRot = 0.1F;
        this.Head.xRot = 0.1F;
        this.Head.yRot = 0.1F;

        this.Back.xRot = 0F;
        this.Back.yRot = 3.1415F;
        this.Back.zRot = 3.1415F;

        this.LegRightFront.xRot = 1.57F;
        this.LegRightFront.yRot = -0.52F;
        this.LegLeftFront.xRot = 1.57F;
        this.LegLeftFront.yRot = 0.52F;
        this.LegRightEnd.xRot = 1F;
        this.LegLeftEnd.xRot = 1F;

        this.TailBack.xRot = 0.1F;
        this.TailBack.yRot = -0.15F;
        this.TailEnd.xRot = 0.1F;
        this.TailEnd.yRot = -0.15F;
        this.tube01.xRot = -0.8F;
        this.tube01.yRot = -0.12F;

    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        float angleX = Mth.cos(f2 * 0.125F);

        // [PORT] 1.10.2 -> 1.20.1: restore legacy water bobbing translation.
        if (ent.getShipDepth(0) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        this.Back.xRot = -0.2618F;
        this.Back.yRot = 0F;
        this.Back.zRot = 0F;
        this.NeckBack.xRot = 0.0873F;
        this.Head.xRot = 0.3F;
        this.LegRightFront.yRot = 0F;
        this.LegLeftFront.yRot = 0F;

        if (f4 != 0F) {
            this.NeckBack.xRot = f4 * 0.005F;
            this.NeckBack.yRot = f3 * 0.005F;
            this.Head.xRot = f4 * 0.005F;
            this.Head.yRot = f3 * 0.005F;
            this.TailBack.xRot = 0.1F;
            this.TailBack.yRot = f3 * -0.005F;
            this.TailEnd.xRot = 0.1F;
            this.TailEnd.yRot = f3 * -0.005F;
            this.tube01.xRot = f4 * -0.005F - 0.8727F;
            this.tube01.yRot = f3 * -0.005F;
        } else {
            this.Head.xRot = angleX * 0.08F + 0.3F;
            this.HeadD01.xRot = angleX * 0.05F + 0.7F;
            this.NeckBack.xRot = 0.0873F;
            this.NeckBack.yRot = 0F;
            this.Head.yRot = 0F;
            this.TailBack.yRot = 0F;
            this.TailEnd.yRot = 0F;
            this.tube01.xRot = -0.8727F;
            this.tube01.yRot = 0F;
        }

        if (ent.getIsSitting()) {
            this.offsetY += 0.45F;
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                this.setFace(2);
                this.Back.xRot = 0F;
                this.Back.yRot = 3.1415F;
                this.Back.zRot = 3.1415F;
                this.Head.xRot = angleX * 0.08F + 0.35F;
                this.LegRightFront.xRot = angleX * 0.3F + 0.5F;
                this.LegLeftFront.xRot = -angleX * 0.3F + 0.5F;
                this.LegRightEnd.xRot = angleX * 0.3F + 0.5F;
                this.LegLeftEnd.xRot = -angleX * 0.3F + 0.5F;
                this.TailBack.xRot = -0.3F;
                this.TailBack.yRot = angleX * 0.3F;
                this.TailEnd.xRot = -0.3F;
                this.TailEnd.yRot = angleX * 0.5F;
                this.tube01.xRot = -0.8F;
            } else {
                this.Back.xRot = -0.7F;
                this.Head.xRot = angleX * 0.08F + 0.35F;
                this.LegRightFront.xRot = -0.6981F;
                this.LegLeftFront.xRot = -0.6981F;
                this.LegRightEnd.xRot = 0.1745F;
                this.LegLeftEnd.xRot = 0.1745F;
                this.TailBack.xRot = 0.5F;
                this.TailBack.yRot = angleX * 0.3F;
                this.TailEnd.xRot = 0.6F;
                this.TailEnd.yRot = angleX * 0.5F;
                this.tube01.xRot = -0.6F;
            }
        } else {
            if (ent.getIsSprinting() || f1 > 0.9F) {
                this.LegRightFront.xRot = Mth.cos(f * 0.6662F) * 0.4F * f1 + 1F;
                this.LegLeftFront.xRot = Mth.cos(f * 0.6662F + Mth.PI) * 0.4F * f1 + 1F;
                this.LegRightEnd.xRot = Mth.sin(f * 0.6662F) * f1 + 0.5F;
                this.LegLeftEnd.xRot = Mth.sin(f * 0.6662F + Mth.PI) * f1 + 0.5F;
            } else {
                this.LegRightFront.xRot = angleX * 0.3F + 0.8F;
                this.LegLeftFront.xRot = -angleX * 0.3F + 0.8F;
                this.LegRightEnd.xRot = angleX * 0.3F + 0.5F;
                this.LegLeftEnd.xRot = -angleX * 0.3F + 0.5F;
            }

            this.TailBack.xRot = angleX * 0.1F - 0.1F;
            this.TailEnd.xRot = angleX * 0.25F - 0.1F;
        }

    }

    @Override
    public void setFace(int emo) {
        this.FaceL00.visible = (emo == 0);
        this.FaceR00.visible = (emo == 0);
        this.FaceL01.visible = (emo == 1);
        this.FaceR01.visible = (emo == 1);
        this.FaceL02.visible = (emo == 2);
        this.FaceR02.visible = (emo == 2);
    }
}
