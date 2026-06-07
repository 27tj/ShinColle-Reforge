package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.BasicEntityMount;
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

public class ModelHarbourHime extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "harbour_hime"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Neck;
    private final ModelPart BoobR;
    private final ModelPart BoobL;
    private final ModelPart ArmLeft01;
    private final ModelPart Butt;
    private final ModelPart ArmRight01;
    private final ModelPart Head;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart HeadH;
    private final ModelPart Ahoke;
    private final ModelPart HairL01;
    private final ModelPart HairR01;
    private final ModelPart HairL02;
    private final ModelPart HairR02;
    private final ModelPart Hair01;
    private final ModelPart Hair02;
    private final ModelPart Hair03;
    private final ModelPart HeadH2;
    private final ModelPart HeadH3;
    private final ModelPart ArmLeft02;
    private final ModelPart ArmLeft03;
    private final ModelPart ArmLeft04;
    private final ModelPart ArmLeft05;
    private final ModelPart ArmLeft06;
    private final ModelPart ArmLeft07;
    private final ModelPart LegRight01;
    private final ModelPart LegLeft01;
    private final ModelPart Skirt;
    private final ModelPart LegRight02;
    private final ModelPart ShoesR;
    private final ModelPart LegLeft02;
    private final ModelPart ShoesL;
    private final ModelPart ArmRight02;
    private final ModelPart ArmRight03;
    private final ModelPart ArmRight04;
    private final ModelPart ArmRight05;
    private final ModelPart ArmRight06;
    private final ModelPart ArmRight07;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowNeck;
    private final ModelPart GlowHead;

    public ModelHarbourHime(ModelPart root) {
        super();
        this.scale = 0.53F;
        this.offsetY = 1.35F;
        this.BodyMain = root.getChild("BodyMain");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.BoobR = this.BodyMain.getChild("BoobR");
        this.Butt = this.BodyMain.getChild("Butt");
        this.BoobL = this.BodyMain.getChild("BoobL");
        this.Neck = this.BodyMain.getChild("Neck");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.LegRight01 = this.Butt.getChild("LegRight01");
        this.LegLeft01 = this.Butt.getChild("LegLeft01");
        this.Skirt = this.Butt.getChild("Skirt");
        this.Head = this.Neck.getChild("Head");
        this.ArmLeft03 = this.ArmLeft02.getChild("ArmLeft03");
        this.ArmRight03 = this.ArmRight02.getChild("ArmRight03");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
        this.Hair = this.Head.getChild("Hair");
        this.HairMain = this.Head.getChild("HairMain");
        this.ArmLeft04 = this.ArmLeft03.getChild("ArmLeft04");
        this.ArmRight04 = this.ArmRight03.getChild("ArmRight04");
        this.ShoesR = this.LegRight02.getChild("ShoesR");
        this.ShoesL = this.LegLeft02.getChild("ShoesL");
        this.HairL01 = this.Hair.getChild("HairL01");
        this.HairR01 = this.Hair.getChild("HairR01");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.Hair01 = this.HairMain.getChild("Hair01");
        this.ArmLeft05 = this.ArmLeft04.getChild("ArmLeft05");
        this.ArmRight05 = this.ArmRight04.getChild("ArmRight05");
        this.HairL02 = this.HairL01.getChild("HairL02");
        this.HairR02 = this.HairR01.getChild("HairR02");
        this.Hair02 = this.Hair01.getChild("Hair02");
        this.ArmLeft06 = this.ArmLeft05.getChild("ArmLeft06");
        this.ArmRight06 = this.ArmRight05.getChild("ArmRight06");
        this.Hair03 = this.Hair02.getChild("Hair03");
        this.ArmLeft07 = this.ArmLeft06.getChild("ArmLeft07");
        this.ArmRight07 = this.ArmRight06.getChild("ArmRight07");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowNeck = this.GlowBodyMain.getChild("GlowNeck");
        this.GlowHead = this.GlowNeck.getChild("GlowHead");
        this.HeadH = this.GlowHead.getChild("HeadH");
        this.HeadH2 = this.HeadH.getChild("HeadH2");
        this.HeadH3 = this.HeadH2.getChild("HeadH3");
        this.loadFaceParts(this.GlowHead);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 104)
                        .addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().mirror().texOffs(2, 85)
                        .addBox(-2.0F, -1.0F, -2.5F, 5.0F, 8.0F, 5.0F),
                PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, -0.2617993877991494F, 0.6981317007977318F, 0.0F));

        PartDefinition armLeft02 = armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().mirror().texOffs(72, 38)
                        .addBox(-3.0F, 0.0F, -3.5F, 6.0F, 10.0F, 7.0F),
                PartPose.offset(0.5F, 4.0F, 0.0F));

        PartDefinition armLeft03 = armLeft02.addOrReplaceChild("ArmLeft03",
                CubeListBuilder.create().texOffs(46, 46)
                        .addBox(-4.0F, 0.0F, -4.5F, 8.0F, 5.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.0F, 0.3490658503988659F, 0.0F));

        PartDefinition armLeft04 = armLeft03.addOrReplaceChild("ArmLeft04",
                CubeListBuilder.create().texOffs(50, 60)
                        .addBox(-5.0F, 0.0F, -5.5F, 10.0F, 6.0F, 11.0F),
                PartPose.offset(0.0F, 5.0F, 0.0F));

        PartDefinition armLeft05 = armLeft04.addOrReplaceChild("ArmLeft05",
                CubeListBuilder.create().texOffs(46, 0)
                        .addBox(-5.5F, -0.2F, -6.5F, 11.0F, 4.0F, 13.0F),
                PartPose.offset(0.0F, 6.0F, 0.0F));

        PartDefinition armLeft06 = armLeft05.addOrReplaceChild("ArmLeft06",
                CubeListBuilder.create().texOffs(68, 17)
                        .addBox(0.0F, 0.0F, -4.2F, 5.0F, 9.0F, 9.0F),
                PartPose.offsetAndRotation(-2.0F, 1.0F, 0.5F, 0.08726646259971647F, 0.13962634015954636F,
                        0.2617993877991494F));

        armLeft06.addOrReplaceChild("ArmLeft07",
                CubeListBuilder.create().texOffs(43, 18)
                        .addBox(0.0F, 0.0F, -3.0F, 4.0F, 6.0F, 4.0F),
                PartPose.offsetAndRotation(-1.0F, 0.0F, -2.0F, -0.2617993877991494F, 0.0F, 0.17453292519943295F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().mirror().texOffs(2, 85)
                        .addBox(-3.0F, -1.0F, -2.5F, 5.0F, 8.0F, 5.0F),
                PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, -0.2617993877991494F, -0.6981317007977318F, 0.0F));

        PartDefinition armRight02 = armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().mirror().texOffs(72, 38)
                        .addBox(-3.0F, 0.0F, -3.5F, 6.0F, 10.0F, 7.0F),
                PartPose.offset(-0.5F, 4.0F, 0.0F));

        PartDefinition armRight03 = armRight02.addOrReplaceChild("ArmRight03",
                CubeListBuilder.create().texOffs(46, 46)
                        .addBox(-4.0F, 0.0F, -4.5F, 8.0F, 5.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.0F, -0.3490658503988659F, 0.0F));

        PartDefinition armRight04 = armRight03.addOrReplaceChild("ArmRight04",
                CubeListBuilder.create().mirror().texOffs(50, 60)
                        .addBox(-5.0F, 0.0F, -5.5F, 10.0F, 6.0F, 11.0F),
                PartPose.offset(0.0F, 5.0F, 0.0F));

        PartDefinition armRight05 = armRight04.addOrReplaceChild("ArmRight05",
                CubeListBuilder.create().mirror().texOffs(46, 0)
                        .addBox(-5.5F, -0.2F, -6.5F, 11.0F, 4.0F, 13.0F),
                PartPose.offset(0.0F, 6.0F, 0.0F));

        PartDefinition armRight06 = armRight05.addOrReplaceChild("ArmRight06",
                CubeListBuilder.create().mirror().texOffs(68, 17)
                        .addBox(-4.0F, 0.0F, -4.2F, 5.0F, 9.0F, 9.0F),
                PartPose.offsetAndRotation(1.0F, 1.0F, 0.5F, 0.08726646259971647F, -0.13962634015954636F,
                        -0.2617993877991494F));

        armRight06.addOrReplaceChild("ArmRight07",
                CubeListBuilder.create().texOffs(43, 18)
                        .addBox(-3.0F, 0.0F, -3.0F, 4.0F, 6.0F, 4.0F),
                PartPose.offsetAndRotation(1.0F, 0.0F, -2.0F, -0.2617993877991494F, 0.0F, -0.17453292519943295F));

        bodyMain.addOrReplaceChild("BoobR",
                CubeListBuilder.create().texOffs(46, 33)
                        .addBox(-4.0F, 0.0F, 0.0F, 8.0F, 6.0F, 6.0F),
                PartPose.offsetAndRotation(-3.9F, -8.1F, -4.0F, -0.8726646259971648F, 0.08726646259971647F,
                        -0.08726646259971647F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-7.5F, 4.0F, -5.7F, 15.0F, 8.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3141592653589793F, 0.0F, 0.0F));

        PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().texOffs(0, 84)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(-5.2F, 9.5F, -2.6F, -0.20943951023931953F, 0.0F, -0.05235987755982988F));

        PartDefinition legRight02 = legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().texOffs(0, 84)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F),
                PartPose.offset(0.0F, 14.0F, -3.0F));

        legRight02.addOrReplaceChild("ShoesR",
                CubeListBuilder.create().texOffs(100, 0)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 14.0F, 7.0F),
                PartPose.offset(0.0F, 1.0F, 3.0F));

        PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().mirror().texOffs(0, 84)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(5.2F, 9.5F, -2.6F, -0.20943951023931953F, 0.0F, 0.05235987755982988F));

        PartDefinition legLeft02 = legLeft01.addOrReplaceChild("LegLeft02",
                CubeListBuilder.create().mirror().texOffs(0, 84)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F),
                PartPose.offset(0.0F, 14.0F, -3.0F));

        legLeft02.addOrReplaceChild("ShoesL",
                CubeListBuilder.create().mirror().texOffs(100, 0)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 14.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.03647738136668149F));

        butt.addOrReplaceChild("Skirt",
                CubeListBuilder.create().texOffs(0, 19)
                        .addBox(-8.5F, 0.0F, 0.0F, 17.0F, 6.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 6.9F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("BoobL",
                CubeListBuilder.create().mirror().texOffs(46, 33)
                        .addBox(-4.0F, 0.0F, 0.0F, 8.0F, 6.0F, 6.0F),
                PartPose.offsetAndRotation(3.9F, -8.1F, -4.0F, -0.8726646259971648F, -0.08726646259971647F,
                        0.08726646259971647F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(88, 26)
                        .addBox(-5.5F, -2.0F, -5.0F, 11.0F, 3.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, -10.3F, -0.2F, 0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offset(0.0F, -1.5F, 0.0F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(45, 77)
                        .addBox(-8.0F, -8.0F, -7.2F, 16.0F, 16.0F, 8.0F),
                PartPose.offset(0.0F, -7.5F, 0.0F));

        PartDefinition hairL01 = hair.addOrReplaceChild("HairL01",
                CubeListBuilder.create().texOffs(24, 84)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(7.0F, 3.0F, -5.5F, -0.14F, -0.1745F, -0.0873F));

        hairL01.addOrReplaceChild("HairL02",
                CubeListBuilder.create().texOffs(24, 84)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(-0.1F, 10.0F, 0.1F, 0.1745F, 0.0F, 0.08726646259971647F));

        PartDefinition hairR01 = hair.addOrReplaceChild("HairR01",
                CubeListBuilder.create().mirror().texOffs(24, 84)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(-7.0F, 3.0F, -5.5F, -0.14F, 0.1745F, 0.0873F));

        hairR01.addOrReplaceChild("HairR02",
                CubeListBuilder.create().mirror().texOffs(24, 84)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(0.1F, 10.0F, 0.1F, 0.1745F, 0.0F, -0.05235987755982988F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(104, 29)
                        .addBox(0.0F, -4.0F, -11.5F, 0.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -9.0F, -5.5F, -0.17453292519943295F, 0.6981317007977318F, 0.0F));

        PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(0, 57)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 12.0F, 10.0F),
                PartPose.offset(0.0F, -15.0F, -3.0F));

        PartDefinition hair01 = hairMain.addOrReplaceChild("Hair01",
                CubeListBuilder.create().texOffs(0, 57)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 17.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 9.0F, 1.0F, 0.20943951023931953F, 0.0F, 0.0F));

        PartDefinition hair02 = hair01.addOrReplaceChild("Hair02",
                CubeListBuilder.create().texOffs(0, 58)
                        .addBox(-8.0F, 0.0F, -5.0F, 16.0F, 16.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 13.5F, 5.5F, -0.08726646259971647F, 0.0F, 0.0F));

        hair02.addOrReplaceChild("Hair03",
                CubeListBuilder.create().texOffs(0, 35)
                        .addBox(-8.0F, 0.0F, -4.5F, 16.0F, 15.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 12.5F, -0.1F, -0.13962634015954636F, 0.0F, 0.0F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -15.0F, 0.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -10.3F, -0.2F));

        PartDefinition glowHead = glowNeck.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -1.5F, 0.0F));
        addDefaultFaceParts(glowHead);

        PartDefinition headH = glowHead.addOrReplaceChild("HeadH",
                CubeListBuilder.create().mirror().texOffs(33, 101)
                        .addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, -10.0F, -6.5F, -0.3141592653589793F, 0.0F, 0.0F));

        PartDefinition headH2 = headH.addOrReplaceChild("HeadH2",
                CubeListBuilder.create().texOffs(84, 64)
                        .addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, -0.2F, -3.7F, -0.13962634015954636F, 0.0F, 0.0F));

        headH2.addOrReplaceChild("HeadH3",
                CubeListBuilder.create().texOffs(45, 105)
                        .addBox(-1.0F, -1.2F, -3.0F, 2.0F, 2.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -3.8F, -0.13962634015954636F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
        IShipEmotion ent = (IShipEmotion) entity;
        this.showEquip(ent);
        this.setFlush(ent.getStateMinor(ID.M.Morale) > ID.Morale.L_Happy);
        EmotionHelper.rollEmotionAdv(this, ent);
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
        this.BodyMain.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.GlowBodyMain.render(poseStack, buffer, 0xF000F0, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();
    }

    @Override
    public void showEquip(IShipEmotion ent) {

    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowBodyMain.xRot = this.BodyMain.xRot;
        this.GlowBodyMain.yRot = this.BodyMain.yRot;
        this.GlowBodyMain.zRot = this.BodyMain.zRot;
        this.GlowNeck.xRot = this.Neck.xRot;
        this.GlowNeck.yRot = this.Neck.yRot;
        this.GlowNeck.zRot = this.Neck.zRot;
        this.GlowHead.xRot = this.Head.xRot;
        this.GlowHead.yRot = this.Head.yRot;
        this.GlowHead.zRot = this.Head.zRot;

    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += 0.74F;
        this.setFaceHungry(ent);

        // 頭部
        this.Head.xRot = -0.35F;
        this.Head.yRot = 0F;
        this.Head.zRot = 0F;
        // 胸部
        this.BoobL.xRot = -0.76F;
        this.BoobR.xRot = -0.76F;
        // Body
        this.Ahoke.yRot = 0.6F;
        this.BodyMain.xRot = 1.4835F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        this.Butt.xRot = 1.0472F;
        // this.Butt.offsetZ = -0.05F;
        // this.Skirt.offsetY = -0.1F;
        // hair
        this.Hair01.xRot = 0.35F;
        this.Hair01.zRot = 0F;
        this.Hair02.xRot = 0.2F;
        this.Hair02.zRot = 0F;
        this.Hair03.xRot = -0.3F;
        this.Hair03.zRot = 0F;
        this.HairL01.xRot = -0.14F;
        this.HairL02.xRot = 0.17F;
        this.HairR01.xRot = -0.14F;
        this.HairR02.xRot = 0.17F;
        // arm
        this.ArmLeft01.xRot = -2.967F;
        this.ArmLeft01.yRot = -0.6981F;
        this.ArmLeft01.zRot = 0.08F;
        this.ArmLeft03.xRot = 0F;
        this.ArmLeft03.yRot = 0.35F;
        this.ArmLeft03.zRot = 0F;
        this.ArmLeft06.xRot = 0.0873F;
        this.ArmLeft06.yRot = 0.14F;
        this.ArmLeft06.zRot = 0.26F;
        this.ArmLeft07.xRot = -0.2618F;
        this.ArmRight01.xRot = -2.967F;
        this.ArmRight01.yRot = 0.6981F;
        this.ArmRight01.zRot = -0.08F;
        this.ArmRight03.xRot = 0F;
        this.ArmRight03.yRot = -0.35F;
        this.ArmRight03.zRot = 0F;
        this.ArmRight06.zRot = -0.26F;
        this.ArmRight07.xRot = -0.2618F;
        // leg
        // this.LegLeft02.offsetZ = 0F;
        // this.LegRight02.offsetZ = 0F;
        this.LegLeft01.xRot = -1.7F;
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.05F;
        this.LegLeft02.xRot = 0.7F;
        this.LegRight01.xRot = -1.7F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.05F;
        this.LegRight02.xRot = 0.7F;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        // apply leg motion while riding
        if (((Entity) ent).getVehicle() instanceof BasicEntityMount mount) {
            f1 = mount.walkAnimation.speed(f2 - (int) f2);
            f = mount.walkAnimation.position(f2 - (int) f2);

            if (f1 > 1F)
                f1 = 1F;
        }

        float angleX = Mth.cos(f2 * 0.08F);
        float angleX1 = Mth.cos(f2 * 0.08F + 0.3F + f * 0.5F);
        float angleX2 = Mth.cos(f2 * 0.08F + 0.6F + f * 0.5F);
        float angleAdd1 = Mth.cos(f * 0.7F) * f1 * 0.7F;
        float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.7F;
        float addk1;
        float addk2;
        float headX;
        float headZ;

        // 水上漂浮
        if (ent.getShipDepth(0) > 0D || ent.getShipDepth(1) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        // leg move parm
        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += angleX * 0.05F + 0.025F;
        addk1 = angleAdd1 * 0.6F - 0.21F;
        addk2 = angleAdd2 * 0.6F - 0.21F;

        // 移動頭部使其看人
        this.Head.xRot = f4 * 0.014F; // 上下角度
        this.Head.yRot = f3 * 0.01F; // 左右角度 角度轉成rad 即除以57.29578
        this.Head.zRot = 0F;
        headX = this.Head.xRot * -0.5F;
        // 正常站立動作
        // 胸部
        this.BoobL.xRot = angleX * 0.08F - 0.76F;
        this.BoobR.xRot = angleX * 0.08F - 0.76F;
        // Body
        this.Ahoke.yRot = angleX * 0.15F + 0.6F;
        this.BodyMain.xRot = -0.1047F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        this.Butt.xRot = 0.3142F;
        // this.Butt.offsetZ = 0F;
        // this.Skirt.offsetY = 0F;
        // hair
        this.Hair01.xRot = angleX * 0.03F + 0.21F + headX;
        this.Hair01.zRot = 0F;
        this.Hair02.xRot = -angleX1 * 0.04F - 0.08F + headX;
        this.Hair02.zRot = 0F;
        this.Hair03.xRot = -angleX2 * 0.07F - 0.14F;
        this.Hair03.zRot = 0F;
        // arm
        this.ArmLeft01.xRot = -0.2618F;
        this.ArmLeft01.yRot = 0.7F;
        this.ArmLeft01.zRot = 0F;
        this.ArmLeft03.xRot = 0F;
        this.ArmLeft03.yRot = 0.35F;
        this.ArmLeft03.zRot = 0F;
        this.ArmLeft06.xRot = 0.0873F;
        this.ArmLeft06.yRot = 0.14F;
        this.ArmLeft06.zRot = angleX * 0.1F + 0.26F;
        this.ArmLeft07.xRot = -0.2618F;
        this.ArmRight01.xRot = -0.2618F;
        this.ArmRight01.yRot = -0.7F;
        this.ArmRight01.zRot = 0F;
        this.ArmRight03.xRot = 0F;
        this.ArmRight03.yRot = -0.35F;
        this.ArmRight03.zRot = 0F;
        this.ArmRight06.zRot = -angleX * 0.1F - 0.26F;
        this.ArmRight07.xRot = -0.2618F;
        // leg
        // this.LegLeft02.offsetZ = 0F;
        // this.LegRight02.offsetZ = 0F;
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.05F;
        this.LegLeft02.xRot = 0F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.05F;
        this.LegRight02.xRot = 0F;

        if (ent.getIsSprinting() || f1 > 0.9F) { // 奔跑動作
            // hair
            this.Hair01.xRot += 0.09F;
            this.Hair02.xRot += 0.43F;
            this.Hair03.xRot += 0.49F;
            // 胸部
            this.BoobL.xRot = angleAdd2 * 0.1F - 0.83F;
            this.BoobR.xRot = angleAdd1 * 0.1F - 0.83F;
            // arm
            this.ArmLeft01.xRot = angleAdd2 * 0.8F + 0.1745F;
            this.ArmLeft01.yRot = 0F;
            this.ArmLeft01.zRot = -0.35F;
            this.ArmLeft03.yRot = 0F;
            this.ArmRight01.xRot = angleAdd1 * 0.8F + 0.1745F;
            this.ArmRight01.yRot = 0F;
            this.ArmRight01.zRot = 0.35F;
            this.ArmRight03.yRot = 0F;
        }

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        // 移動頭髮避免穿過身體
        headZ = this.Head.zRot * -0.5F;
        this.Hair01.zRot = headZ;
        this.Hair02.zRot = headZ;
        this.HairL01.zRot = headZ - 0.14F;
        this.HairL02.zRot = headZ + 0.087F;
        this.HairR01.zRot = headZ + 0.14F;
        this.HairR02.zRot = headZ - 0.052F;

        if (ent.getIsSneaking()) { // 潛行, 蹲下動作
            // Body
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.1F;
            this.Head.xRot -= 0.6283F;
            this.BodyMain.xRot = 0.8727F;
            // arm
            this.ArmLeft01.xRot = -0.61F;
            this.ArmLeft01.yRot = 0.35F;
            this.ArmLeft01.zRot = -0.14F;
            this.ArmLeft03.yRot = 0.7F;
            this.ArmLeft06.zRot = -0.35F;
            this.ArmRight01.xRot = -0.61F;
            this.ArmRight01.yRot = -0.35F;
            this.ArmRight01.zRot = 0.14F;
            this.ArmRight03.yRot = -0.7F;
            this.ArmRight06.zRot = 0.35F;
            // leg
            addk1 -= 1.0F;
            addk2 -= 1.0F;
            // hair
            this.Hair01.xRot += 0.37F;
            this.Hair02.xRot += 0.23F;
            this.Hair03.xRot -= 0.1F;
        } // end if sneaking

        if (ent.getIsSitting() && !ent.getIsRiding()) { // 騎乘動作
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                setFace(2);
                // body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.57F;
                this.Head.xRot = this.Head.xRot * 0.5F + 0.55F;
                this.Head.yRot = this.Head.yRot * 0.5F - 0.2F;
                this.BodyMain.xRot = -0.61F;
                this.BodyMain.yRot = -0.2618F;
                this.BodyMain.zRot = -0.5236F;
                // arm
                this.ArmLeft01.xRot = 1.3F;
                this.ArmLeft01.yRot = 0.7F;
                this.ArmLeft01.zRot = -0.1745F;
                this.ArmLeft03.xRot = -2.53F;
                this.ArmLeft03.yRot = -0.7F;
                this.ArmLeft06.xRot = -0.5236F;
                this.ArmLeft06.yRot = -0.5236F;
                this.ArmLeft06.zRot = 0.7F;
                this.ArmRight01.xRot = 0.7F;
                this.ArmRight01.yRot = 0F;
                this.ArmRight01.zRot = 0.5236F;
                this.ArmRight03.xRot = -1.57F;
                this.ArmRight03.yRot = 0.14F;
                this.ArmRight03.zRot = 1.7453F;
                this.ArmRight06.zRot = -0.5236F;
                // leg
                addk1 = -1.05F;
                addk2 = -1.31F;
                this.LegLeft01.zRot = -0.5236F;
                this.LegLeft02.xRot = 1.05F;
                this.LegRight01.yRot = -0.4363F;
                this.LegRight02.xRot = 0.7F;
                // hair
                this.Hair01.xRot -= 0.12F;
                this.Hair01.zRot = -0.09F;
                this.Hair02.xRot -= 0.18F;
                this.Hair02.zRot = -0.26F;
                this.Hair03.xRot -= 0.21F;
                this.Hair03.zRot = -0.35F;
            } else {
                // head
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.4F;
                this.Head.xRot -= 0.25F;
                // arm
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.5F;
                this.ArmLeft01.xRot = -0.44F;
                this.ArmLeft01.yRot = 0.44F;
                this.ArmLeft01.zRot = 0F;
                this.ArmLeft03.yRot = 0.87F;
                this.ArmLeft06.zRot = 0.1F;
                this.ArmRight01.xRot = -0.44F;
                this.ArmRight01.yRot = -0.44F;
                this.ArmRight01.zRot = 0F;
                this.ArmRight03.yRot = -0.87F;
                this.ArmRight06.zRot = -0.1F;
                // leg
                addk1 = -1.2217F;
                addk2 = -1.2217F;
                // this.LegLeft02.offsetZ = 0.37F;
                // this.LegRight02.offsetZ = 0.37F;
                this.LegLeft01.yRot = 0.14F;
                this.LegRight01.yRot = -0.14F;
                this.LegLeft02.xRot = 2.53F;
                this.LegRight02.xRot = 2.53F;
            }
        } // end sitting

        if (ent.getIsRiding()) {
            if (((net.minecraft.world.entity.Entity) ent).getVehicle() instanceof BasicEntityMount) {
                if (ent.getIsSitting()) {
                    if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                        setFace(2);
                        // body
                        this.Head.xRot = this.Head.xRot * 0.5F + 0.55F;
                        this.Head.yRot = this.Head.yRot * 0.5F - 0.2F;
                        this.BodyMain.xRot = -0.61F;
                        this.BodyMain.yRot = -0.2618F;
                        this.BodyMain.zRot = -0.5236F;
                        // arm
                        this.ArmLeft01.xRot = 1.3F;
                        this.ArmLeft01.yRot = 0.7F;
                        this.ArmLeft01.zRot = -0.1745F;
                        this.ArmLeft03.xRot = -2.53F;
                        this.ArmLeft03.yRot = -0.7F;
                        this.ArmLeft06.xRot = -0.5236F;
                        this.ArmLeft06.yRot = -0.5236F;
                        this.ArmLeft06.zRot = 0.7F;
                        this.ArmRight01.xRot = 0.7F;
                        this.ArmRight01.yRot = 0F;
                        this.ArmRight01.zRot = 0.5236F;
                        this.ArmRight03.xRot = -1.57F;
                        this.ArmRight03.yRot = 0.14F;
                        this.ArmRight03.zRot = 1.7453F;
                        this.ArmRight06.zRot = -0.5236F;
                        // leg
                        addk1 = -1.05F;
                        addk2 = -1.31F;
                        this.LegLeft01.zRot = -0.5236F;
                        this.LegLeft02.xRot = 1.05F;
                        this.LegRight01.yRot = -0.4363F;
                        this.LegRight02.xRot = 0.7F;
                        // hair
                        this.Hair01.xRot -= 0.12F;
                        this.Hair01.zRot = -0.09F;
                        this.Hair02.xRot -= 0.18F;
                        this.Hair02.zRot = -0.26F;
                        this.Hair03.xRot -= 0.21F;
                        this.Hair03.zRot = -0.35F;
                    } else {
                        // body
                        // [PORT] Restored from 1.10.2 GlStateManager.translate
                        this.offsetY += 0.41F;
                        this.Head.xRot -= 0.35F;
                        // hair
                        this.Hair01.xRot += 0.35F;
                        // arm
                        this.ArmLeft01.xRot = 0.2F;
                        this.ArmLeft01.yRot = 0F;
                        this.ArmLeft01.zRot = -1.1F;
                        this.ArmLeft03.yRot = 0F;
                        this.ArmLeft03.zRot = -0.4F;
                        this.ArmRight01.xRot = 0.2F;
                        this.ArmRight01.yRot = 0F;
                        this.ArmRight01.zRot = 1.1F;
                        this.ArmRight03.zRot = 0.4F;
                        // leg
                        addk1 = -1.2217F;
                        addk2 = -1.2217F;
                        // this.LegLeft02.offsetZ = 0.37F;
                        // this.LegRight02.offsetZ = 0.37F;
                        this.LegLeft01.yRot = 0.14F;
                        this.LegRight01.yRot = -0.14F;
                        this.LegLeft02.xRot = 2.53F;
                        this.LegRight02.xRot = 2.53F;
                    }
                } // end if sitting
                else {
                    // hair
                    this.Hair01.xRot += 0.35F;
                    // arm
                    this.ArmLeft01.xRot = 0.5F;
                    this.ArmLeft01.yRot = 0F;
                    this.ArmLeft01.zRot = -0.7F;
                    this.ArmLeft03.xRot = -0.5F;
                    this.ArmLeft03.yRot = 0F;
                    this.ArmLeft03.zRot = -0.4F;
                    this.ArmLeft06.zRot = 0.4F;
                    this.ArmLeft07.xRot = -1.2F;
                    this.ArmRight01.xRot = 0.5F;
                    this.ArmRight01.yRot = 0F;
                    this.ArmRight01.zRot = 0.7F;
                    this.ArmRight03.xRot = -0.5F;
                    this.ArmRight03.yRot = 0F;
                    this.ArmRight03.zRot = 0.4F;
                    this.ArmRight06.zRot = -0.4F;
                    this.ArmRight07.xRot = -1.2F;
                }
            } // end ship mount
            else { // normal mount ex: cart
                if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                    setFace(2);
                    // body
                    this.Head.xRot = this.Head.xRot * 0.5F + 0.55F;
                    this.Head.yRot = this.Head.yRot * 0.5F - 0.2F;
                    this.BodyMain.xRot = -0.61F;
                    this.BodyMain.yRot = -0.2618F;
                    this.BodyMain.zRot = -0.5236F;
                    // arm
                    this.ArmLeft01.xRot = 1.3F;
                    this.ArmLeft01.yRot = 0.7F;
                    this.ArmLeft01.zRot = -0.1745F;
                    this.ArmLeft03.xRot = -2.53F;
                    this.ArmLeft03.yRot = -0.7F;
                    this.ArmLeft06.xRot = -0.5236F;
                    this.ArmLeft06.yRot = -0.5236F;
                    this.ArmLeft06.zRot = 0.7F;
                    this.ArmRight01.xRot = 0.7F;
                    this.ArmRight01.yRot = 0F;
                    this.ArmRight01.zRot = 0.5236F;
                    this.ArmRight03.xRot = -1.57F;
                    this.ArmRight03.yRot = 0.14F;
                    this.ArmRight03.zRot = 1.7453F;
                    this.ArmRight06.zRot = -0.5236F;
                    // leg
                    addk1 = -1.05F;
                    addk2 = -1.31F;
                    this.LegLeft01.zRot = -0.5236F;
                    this.LegLeft02.xRot = 1.05F;
                    this.LegRight01.yRot = -0.4363F;
                    this.LegRight02.xRot = 0.7F;
                    // hair
                    this.Hair01.xRot -= 0.12F;
                    this.Hair01.zRot = -0.09F;
                    this.Hair02.xRot -= 0.18F;
                    this.Hair02.zRot = -0.26F;
                    this.Hair03.xRot -= 0.21F;
                    this.Hair03.zRot = -0.35F;
                } else {
                    // arm
                    this.ArmLeft01.xRot = -0.44F;
                    this.ArmLeft01.yRot = 0.44F;
                    this.ArmLeft01.zRot = 0F;
                    this.ArmLeft03.yRot = 0.87F;
                    this.ArmLeft06.zRot = 0.1F;
                    this.ArmRight01.xRot = -0.44F;
                    this.ArmRight01.yRot = -0.44F;
                    this.ArmRight01.zRot = 0F;
                    this.ArmRight03.yRot = -0.87F;
                    this.ArmRight06.zRot = -0.1F;
                    // leg
                    addk1 = -1.2217F;
                    addk2 = -1.2217F;
                    // this.LegLeft02.offsetZ = 0.37F;
                    // this.LegRight02.offsetZ = 0.37F;
                    this.LegLeft01.yRot = 0.14F;
                    this.LegRight01.yRot = -0.14F;
                    this.LegLeft02.xRot = 2.53F;
                    this.LegRight02.xRot = 2.53F;
                }
            }
        } // end ridding

        // 攻擊動作
        if (ent.getAttackTick() > 0) {
            if (ent.getAttackTick() > 25)
                setFace(3);
            // arm
            this.ArmLeft01.xRot = -1.4F;
            this.ArmLeft01.yRot = -0.14F;
            this.ArmLeft01.zRot = 0F;
            this.ArmLeft06.zRot = -0.96F;
            this.ArmRight01.xRot = -1.4F;
            this.ArmRight01.yRot = 0.14F;
            this.ArmRight01.zRot = 0F;
            this.ArmRight06.zRot = 0.96F;
        }

        // swing arm
        float f6 = ent.getSwingTime(f2 - (int) f2);
        if (f6 != 0F) {
            float f7 = Mth.sin(f6 * f6 * (float) Math.PI);
            float f8 = Mth.sin(Mth.sqrt(f6) * (float) Math.PI);
            this.ArmRight01.xRot += -f8 * 80.0F * ((float) Math.PI / 180F);
            this.ArmRight01.yRot += -f7 * 20.0F * ((float) Math.PI / 180F) + 1.0F;
            this.ArmRight01.zRot += -f8 * 20.0F * ((float) Math.PI / 180F);
        }

        // caress
        if (ent.getStateEmotion(ID.S.Emotion3) == ID.Emotion3.CARESS) {
            // body
            this.Head.xRot += 0.2F;
        }

        // 鬢毛調整
        headX = this.Head.xRot * -0.5F;
        this.HairL01.xRot = angleX * 0.02F + headX - 0.14F;
        this.HairL02.xRot = -angleX1 * 0.04F + headX + 0.17F;
        this.HairR01.xRot = angleX * 0.02F + headX - 0.14F;
        this.HairR02.xRot = -angleX1 * 0.04F + headX + 0.17F;

        // leg motion
        this.LegLeft01.xRot = addk1;
        this.LegRight01.xRot = addk2;
    }
}
