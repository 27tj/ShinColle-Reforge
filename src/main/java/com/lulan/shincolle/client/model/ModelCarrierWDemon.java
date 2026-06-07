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

public class ModelCarrierWDemon extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "cv_wd"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Neck;
    private final ModelPart BoobR;
    private final ModelPart BoobL;
    private final ModelPart Butt;
    private final ModelPart ArmLeft01;
    private final ModelPart ArmRight01;
    private final ModelPart Cloth01;
    private final ModelPart EquipBase;
    private final ModelPart Head;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart HeadS04;
    private final ModelPart HeadS05;
    private final ModelPart Ahoke;
    private final ModelPart HairL01;
    private final ModelPart HairR01;
    private final ModelPart HairL02;
    private final ModelPart HairR02;
    private final ModelPart Hair01;
    private final ModelPart Hair02;
    private final ModelPart Hair03;
    private final ModelPart HeadS01;
    private final ModelPart HeadS02;
    private final ModelPart HeadS03;
    private final ModelPart LegRight01;
    private final ModelPart LegLeft01;
    private final ModelPart Skirt01;
    private final ModelPart LegRight02;
    private final ModelPart ShoesR01;
    private final ModelPart ShoesR02;
    private final ModelPart ShoesR03;
    private final ModelPart ShoesR04;
    private final ModelPart LegLeft02;
    private final ModelPart ShoesL01;
    private final ModelPart ShoesL02;
    private final ModelPart ShoesL03;
    private final ModelPart ShoesL04;
    private final ModelPart Skirt02;
    private final ModelPart ArmLeft02;
    private final ModelPart ArmLeft03;
    private final ModelPart ArmLeft04;
    private final ModelPart ArmLeft05;
    private final ModelPart ArmRight02;
    private final ModelPart ArmRight03;
    private final ModelPart ArmRight04;
    private final ModelPart ArmRight05;
    private final ModelPart EquipL01;
    private final ModelPart EquipR01;
    private final ModelPart EquipL02;
    private final ModelPart EquipL03;
    private final ModelPart EquipL04;
    private final ModelPart EquipL05;
    private final ModelPart EquipR02;
    private final ModelPart EquipR03;
    private final ModelPart EquipR04;
    private final ModelPart EquipR05;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowBodyMain2;
    private final ModelPart GlowNeck;
    private final ModelPart GlowHead;

    public ModelCarrierWDemon(ModelPart root) {
        super();
        this.scale = 0.47F;
        this.offsetY = 1.7F;
        this.BodyMain = root.getChild("BodyMain");
        this.Cloth01 = this.BodyMain.getChild("Cloth01");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.Butt = this.BodyMain.getChild("Butt");
        this.BoobL = this.BodyMain.getChild("BoobL");
        this.BoobR = this.BodyMain.getChild("BoobR");
        this.Neck = this.BodyMain.getChild("Neck");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.LegLeft01 = this.Butt.getChild("LegLeft01");
        this.Skirt01 = this.Butt.getChild("Skirt01");
        this.LegRight01 = this.Butt.getChild("LegRight01");
        this.Head = this.Neck.getChild("Head");
        this.ArmRight03 = this.ArmRight02.getChild("ArmRight03");
        this.ArmLeft03 = this.ArmLeft02.getChild("ArmLeft03");
        this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
        this.Skirt02 = this.Skirt01.getChild("Skirt02");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.Hair = this.Head.getChild("Hair");
        this.HeadS05 = this.Head.getChild("HeadS05");
        this.HairMain = this.Head.getChild("HairMain");
        this.HeadS01 = this.Head.getChild("HeadS01");
        this.HeadS04 = this.Head.getChild("HeadS04");
        this.ArmRight04 = this.ArmRight03.getChild("ArmRight04");
        this.ArmLeft04 = this.ArmLeft03.getChild("ArmLeft04");
        this.ShoesL01 = this.LegLeft02.getChild("ShoesL01");
        this.ShoesR01 = this.LegRight02.getChild("ShoesR01");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.HairR01 = this.Hair.getChild("HairR01");
        this.HairL01 = this.Hair.getChild("HairL01");
        this.Hair01 = this.HairMain.getChild("Hair01");
        this.HeadS03 = this.HeadS01.getChild("HeadS03");
        this.HeadS02 = this.HeadS01.getChild("HeadS02");
        this.ArmRight05 = this.ArmRight04.getChild("ArmRight05");
        this.ArmLeft05 = this.ArmLeft04.getChild("ArmLeft05");
        this.ShoesL02 = this.ShoesL01.getChild("ShoesL02");
        this.ShoesR02 = this.ShoesR01.getChild("ShoesR02");
        this.HairR02 = this.HairR01.getChild("HairR02");
        this.HairL02 = this.HairL01.getChild("HairL02");
        this.Hair02 = this.Hair01.getChild("Hair02");
        this.ShoesL03 = this.ShoesL02.getChild("ShoesL03");
        this.ShoesR03 = this.ShoesR02.getChild("ShoesR03");
        this.Hair03 = this.Hair02.getChild("Hair03");
        this.ShoesL04 = this.ShoesL03.getChild("ShoesL04");
        this.ShoesR04 = this.ShoesR03.getChild("ShoesR04");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowBodyMain2 = root.getChild("GlowBodyMain2");
        this.GlowNeck = this.GlowBodyMain.getChild("GlowNeck");
        this.GlowHead = this.GlowNeck.getChild("GlowHead");
        this.loadFaceParts(this.GlowHead);

        this.EquipBase = this.GlowBodyMain2.getChild("EquipBase");
        this.EquipL01 = this.EquipBase.getChild("EquipL01");
        this.EquipR01 = this.EquipBase.getChild("EquipR01");
        this.EquipL02 = this.EquipL01.getChild("EquipL02");
        this.EquipL03 = this.EquipL02.getChild("EquipL03");
        this.EquipL04 = this.EquipL03.getChild("EquipL04");
        this.EquipL05 = this.EquipL04.getChild("EquipL05");
        this.EquipR02 = this.EquipR01.getChild("EquipR02");
        this.EquipR03 = this.EquipR02.getChild("EquipR03");
        this.EquipR04 = this.EquipR03.getChild("EquipR04");
        this.EquipR05 = this.EquipR04.getChild("EquipR05");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 104)
                        .addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("Cloth01",
                CubeListBuilder.create().texOffs(0, 9)
                        .addBox(-3.5F, 0.0F, 0.0F, 6.0F, 7.0F, 0.0F),
                PartPose.offset(0.5F, -4.7F, -6.3F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().texOffs(2, 85)
                        .addBox(-3.0F, -1.0F, -2.5F, 5.0F, 5.0F, 5.0F),
                PartPose.offset(-7.8F, -9.3F, -0.7F));

        PartDefinition armRight02 = armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().texOffs(25, 85)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F),
                PartPose.offset(-0.5F, 3.0F, 0.0F));

        PartDefinition armRight03 = armRight02.addOrReplaceChild("ArmRight03",
                CubeListBuilder.create().texOffs(100, 14)
                        .addBox(-1.5F, 0.0F, -6.5F, 7.0F, 8.0F, 7.0F),
                PartPose.offset(-2.0F, 10.0F, 3.0F));

        PartDefinition armRight04 = armRight03.addOrReplaceChild("ArmRight04",
                CubeListBuilder.create().texOffs(54, 49)
                        .addBox(-4.0F, 0.0F, -4.0F, 8.0F, 4.0F, 8.0F),
                PartPose.offsetAndRotation(2.0F, 8.0F, -3.0F, 0.0F, 0.08726646259971647F, 0.0F));

        armRight04.addOrReplaceChild("ArmRight05",
                CubeListBuilder.create().texOffs(72, 36)
                        .addBox(-2.5F, 0.0F, -3.0F, 5.0F, 5.0F, 6.0F),
                PartPose.offset(0.0F, 0.5F, 0.0F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().mirror().texOffs(2, 85)
                        .addBox(-2.0F, -1.0F, -2.5F, 5.0F, 5.0F, 5.0F),
                PartPose.offset(7.8F, -9.3F, -0.7F));

        PartDefinition armLeft02 = armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().mirror().texOffs(25, 85)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F),
                PartPose.offset(0.5F, 3.0F, 0.0F));

        PartDefinition armLeft03 = armLeft02.addOrReplaceChild("ArmLeft03",
                CubeListBuilder.create().mirror().texOffs(100, 14)
                        .addBox(-5.5F, 0.0F, -6.5F, 7.0F, 8.0F, 7.0F),
                PartPose.offset(2.0F, 10.0F, 3.0F));

        PartDefinition armLeft04 = armLeft03.addOrReplaceChild("ArmLeft04",
                CubeListBuilder.create().mirror().texOffs(54, 49)
                        .addBox(-4.0F, 0.0F, -4.0F, 8.0F, 4.0F, 8.0F),
                PartPose.offsetAndRotation(-2.0F, 8.0F, -3.0F, 0.0F, -0.08726646259971647F, 0.0F));

        armLeft04.addOrReplaceChild("ArmLeft05",
                CubeListBuilder.create().mirror().texOffs(72, 36)
                        .addBox(-2.5F, 0.0F, -3.0F, 5.0F, 5.0F, 6.0F),
                PartPose.offset(0.0F, 0.5F, 0.0F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(52, 61)
                        .addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F),
                PartPose.offset(0.0F, 4.0F, 1.3F));

        PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().mirror().texOffs(0, 84)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offset(4.8F, 5.5F, -2.6F));

        PartDefinition legLeft02 = legLeft01.addOrReplaceChild("LegLeft02",
                CubeListBuilder.create().mirror().texOffs(0, 95)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 3.0F, 6.0F),
                PartPose.offset(0.0F, 14.0F, -3.0F));

        PartDefinition shoesL01 = legLeft02.addOrReplaceChild("ShoesL01",
                CubeListBuilder.create().mirror().texOffs(99, 1)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 1.0F, 2.6F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition shoesL02 = shoesL01.addOrReplaceChild("ShoesL02",
                CubeListBuilder.create().mirror().texOffs(98, 0)
                        .addBox(-3.5F, 0.0F, -4.0F, 7.0F, 4.0F, 8.0F),
                PartPose.offset(0.0F, 3.0F, -0.7F));

        PartDefinition shoesL03 = shoesL02.addOrReplaceChild("ShoesL03",
                CubeListBuilder.create().mirror().texOffs(66, 0)
                        .addBox(-4.0F, 0.0F, -4.0F, 8.0F, 4.0F, 8.0F),
                PartPose.offset(0.0F, 4.0F, -0.9F));

        shoesL03.addOrReplaceChild("ShoesL04",
                CubeListBuilder.create().mirror().texOffs(32, 0)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 3.0F, -1.0F, -0.12F, 0.0F, 0.0F));

        PartDefinition skirt01 = butt.addOrReplaceChild("Skirt01",
                CubeListBuilder.create().texOffs(0, 22)
                        .addBox(-8.5F, 0.0F, -6.0F, 17.0F, 4.0F, 9.0F),
                PartPose.offset(0.0F, 2.9F, 0.0F));

        skirt01.addOrReplaceChild("Skirt02",
                CubeListBuilder.create().texOffs(42, 47)
                        .addBox(-9.0F, 0.0F, -6.0F, 18.0F, 4.0F, 10.0F),
                PartPose.offset(0.0F, 2.8F, -0.5F));

        PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().texOffs(0, 84)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offset(-4.8F, 5.5F, -2.6F));

        PartDefinition legRight02 = legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().texOffs(0, 95)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 3.0F, 6.0F),
                PartPose.offset(0.0F, 14.0F, -3.0F));

        PartDefinition shoesR01 = legRight02.addOrReplaceChild("ShoesR01",
                CubeListBuilder.create().texOffs(99, 1)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 1.0F, 2.6F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition shoesR02 = shoesR01.addOrReplaceChild("ShoesR02",
                CubeListBuilder.create().texOffs(98, 0)
                        .addBox(-3.5F, 0.0F, -4.0F, 7.0F, 4.0F, 8.0F),
                PartPose.offset(0.0F, 3.0F, -0.7F));

        PartDefinition shoesR03 = shoesR02.addOrReplaceChild("ShoesR03",
                CubeListBuilder.create().texOffs(66, 0)
                        .addBox(-4.0F, 0.0F, -4.0F, 8.0F, 4.0F, 8.0F),
                PartPose.offset(0.0F, 4.0F, -0.9F));

        shoesR03.addOrReplaceChild("ShoesR04",
                CubeListBuilder.create().texOffs(32, 0)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 3.0F, -1.0F, -0.12F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("BoobL",
                CubeListBuilder.create().mirror().texOffs(33, 101)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(3.7F, -8.1F, -3.7F, -0.6981317007977318F, 0.13962634015954636F,
                        0.08726646259971647F));

        bodyMain.addOrReplaceChild("BoobR",
                CubeListBuilder.create().texOffs(33, 101)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(-3.7F, -8.1F, -3.7F, -0.6981317007977318F, -0.13962634015954636F,
                        -0.08726646259971647F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(88, 29)
                        .addBox(-5.5F, -2.0F, -5.0F, 11.0F, 3.0F, 9.0F),
                PartPose.offset(0.0F, -10.3F, -0.2F));

        PartDefinition head = neck.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offset(0.0F, -1.5F, 0.0F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(50, 77)
                        .addBox(-8.0F, -8.0F, -7.2F, 16.0F, 16.0F, 8.0F),
                PartPose.offset(0.0F, -7.5F, 0.0F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(104, 29)
                        .addBox(0.0F, -4.0F, -11.5F, 0.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -9.0F, -5.5F, 0.0F, 0.6981317007977318F, 0.0F));

        PartDefinition hairR01 = hair.addOrReplaceChild("HairR01",
                CubeListBuilder.create().mirror().texOffs(86, 101)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 4.0F),
                PartPose.offsetAndRotation(-7.0F, 3.0F, -5.5F, -0.13962634015954636F, 0.17453292519943295F,
                        0.08726646259971647F));

        hairR01.addOrReplaceChild("HairR02",
                CubeListBuilder.create().mirror().texOffs(86, 101)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 4.0F),
                PartPose.offsetAndRotation(0.2F, 7.0F, 0.0F, 0.17453292519943295F, 0.0F, -0.05235987755982988F));

        PartDefinition hairL01 = hair.addOrReplaceChild("HairL01",
                CubeListBuilder.create().texOffs(86, 101)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 4.0F),
                PartPose.offsetAndRotation(7.0F, 3.0F, -5.5F, -0.13962634015954636F, -0.17453292519943295F,
                        -0.08726646259971647F));

        hairL01.addOrReplaceChild("HairL02",
                CubeListBuilder.create().texOffs(86, 101)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.08726646259971647F));

        head.addOrReplaceChild("HeadS05",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 3.0F),
                PartPose.offsetAndRotation(-8.1F, -7.5F, -6.7F, 0.7853981633974483F, 0.0F, 0.0F));

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

        PartDefinition headS01 = head.addOrReplaceChild("HeadS01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, -14.0F, -7.4F, 0.0F, 0.0F, 0.7853981633974483F));

        headS01.addOrReplaceChild("HeadS03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F),
                PartPose.offset(-2.5F, 2.9F, 0.0F));

        headS01.addOrReplaceChild("HeadS02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F),
                PartPose.offset(2.9F, -2.5F, 0.0F));

        head.addOrReplaceChild("HeadS04",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 3.0F),
                PartPose.offsetAndRotation(8.1F, -7.5F, -6.7F, 0.7853981633974483F, 0.0F, 0.0F));

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

        PartDefinition glowBodyMain2 = partdefinition.addOrReplaceChild("GlowBodyMain2",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -15.0F, 0.0F));

        PartDefinition equipBase = glowBodyMain2.addOrReplaceChild("EquipBase",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -23.0F, 0.0F));

        PartDefinition equipL01 = equipBase.addOrReplaceChild("EquipL01",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, -3.5F, 2.0F, 2.0F, 7.0F),
                PartPose.offset(30.0F, 0.0F, 0.0F));

        PartDefinition equipR01 = equipBase.addOrReplaceChild("EquipR01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.0F, 0.0F, -3.5F, 2.0F, 2.0F, 7.0F),
                PartPose.offset(-30.0F, 0.0F, 0.0F));

        PartDefinition equipL02 = equipL01.addOrReplaceChild("EquipL02",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-0.5F, 0.0F, -10.0F, 3.0F, 2.0F, 20.0F),
                PartPose.offset(0.0F, 2.0F, 0.0F));

        PartDefinition equipL03 = equipL02.addOrReplaceChild("EquipL03",
                CubeListBuilder.create().mirror().texOffs(43, 0)
                        .addBox(0.0F, 0.0F, -8.5F, 2.0F, 9.0F, 17.0F),
                PartPose.offset(0.0F, 2.0F, 0.0F));

        PartDefinition equipL04 = equipL03.addOrReplaceChild("EquipL04",
                CubeListBuilder.create().mirror().texOffs(67, 14)
                        .addBox(0.0F, 0.0F, -6.5F, 2.0F, 9.0F, 13.0F),
                PartPose.offset(0.0F, 9.0F, 0.0F));

        equipL04.addOrReplaceChild("EquipL05",
                CubeListBuilder.create().mirror().texOffs(46, 29)
                        .addBox(0.0F, 0.0F, -4.5F, 2.0F, 9.0F, 9.0F),
                PartPose.offset(0.0F, 9.0F, 0.0F));

        PartDefinition equipR02 = equipR01.addOrReplaceChild("EquipR02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.5F, 0.0F, -10.0F, 3.0F, 2.0F, 20.0F),
                PartPose.offset(0.0F, 2.0F, 0.0F));

        PartDefinition equipR03 = equipR02.addOrReplaceChild("EquipR03",
                CubeListBuilder.create().texOffs(43, 0)
                        .addBox(-2.0F, 0.0F, -8.5F, 2.0F, 9.0F, 17.0F),
                PartPose.offset(0.0F, 2.0F, 0.0F));

        PartDefinition equipR04 = equipR03.addOrReplaceChild("EquipR04",
                CubeListBuilder.create().texOffs(67, 14)
                        .addBox(-2.0F, 0.0F, -6.5F, 2.0F, 9.0F, 13.0F),
                PartPose.offset(0.0F, 9.0F, 0.0F));

        equipR04.addOrReplaceChild("EquipR05",
                CubeListBuilder.create().texOffs(46, 29)
                        .addBox(-2.0F, 0.0F, -4.5F, 2.0F, 9.0F, 9.0F),
                PartPose.offset(0.0F, 9.0F, 0.0F));

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
        this.GlowBodyMain2.render(poseStack, buffer, 0xF000F0, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();
    }

    @Override
    public void showEquip(IShipEmotion ent) {

        if (this.EquipBase != null)
            this.EquipBase.visible = EmotionHelper.checkModelState(1, ent.getStateEmotion(ID.S.State)); // original:
        // isHidden =
        // !checkModelState(...)
    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowBodyMain.xRot = this.BodyMain.xRot;
        this.GlowBodyMain.yRot = this.BodyMain.yRot;
        this.GlowBodyMain.zRot = this.BodyMain.zRot;
        this.GlowBodyMain2.xRot = this.BodyMain.xRot;
        this.GlowBodyMain2.yRot = this.BodyMain.yRot;
        this.GlowBodyMain2.zRot = this.BodyMain.zRot;
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
        this.offsetY += 0.48F;
        this.setFaceHungry(ent);

        // 頭部
        this.Head.xRot = 0F; // 上下角度
        this.Head.yRot = 0F; // 左右角度
        this.Head.zRot = 0F;
        // 正常站立動作
        // 胸部
        this.BoobL.xRot = -0.7F;
        this.BoobR.xRot = -0.7F;
        // Body
        this.Ahoke.yRot = 0.7F;
        this.BodyMain.xRot = -0.1047F;
        // hair
        this.Hair01.xRot = 0.21F;
        this.Hair01.zRot = 0F;
        this.Hair02.xRot = -0.09F;
        this.Hair02.zRot = 0F;
        this.Hair03.xRot = -0.14F;
        this.Hair03.zRot = 0F;
        // 鬢毛調整
        this.Hair01.zRot = 0F;
        this.Hair02.zRot = 0F;
        this.HairL01.zRot = 0.087F;
        this.HairL02.zRot = 0.087F;
        this.HairR01.zRot = 0.087F;
        this.HairR02.zRot = -0.052F;
        this.HairL01.xRot = -0.65F;
        this.HairL02.xRot = 0.17F;
        this.HairR01.xRot = -0.65F;
        this.HairR02.xRot = 0.17F;
        // arm
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft05.zRot = 0.2618F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight03.xRot = 0F;
        this.ArmRight03.zRot = 0F;
        // leg
        this.LegLeft01.xRot = -1.0472F;
        this.LegLeft01.yRot = 0F;
        this.ShoesL04.xRot = -0.1F;
        this.LegRight01.xRot = -1.0472F;
        this.LegRight01.yRot = 0F;
        // equip
        if (this.EquipBase != null)
            this.EquipBase.xRot = 0F;
        // this.EquipL01.offsetX = 0F;
        // this.EquipL01.offsetY = 0F;
        // this.EquipL01.offsetZ = 0F;
        if (this.EquipL01 != null)
            this.EquipL01.xRot = 0.2618F;
        if (this.EquipL01 != null)
            this.EquipL01.yRot = 0.1745F;
        if (this.EquipL01 != null)
            this.EquipL01.zRot = 0F;
        if (this.EquipL05 != null)
            this.EquipL05.zRot = 0F;
        // this.EquipR01.offsetX = 0F;
        // this.EquipR01.offsetY = 0F;
        // this.EquipR01.offsetZ = 0F;
        if (this.EquipR01 != null)
            this.EquipR01.xRot = 0.2618F;
        if (this.EquipR01 != null)
            this.EquipR01.yRot = -0.1745F;
        if (this.EquipR01 != null)
            this.EquipR01.zRot = 0f;

        // head
        this.Head.xRot = 0.55F;
        this.Head.yRot = 0F;
        this.Head.zRot = 0F;
        // hair 動到headX, 需重新調整hairX
        this.Hair01.xRot = -0.1F;
        this.Hair02.xRot = -0.2F;
        // body
        this.Neck.xRot = 0.3F;
        this.Butt.xRot = -0.14F;
        this.Skirt01.xRot = -0.1745F;
        this.Skirt02.xRot = -0.2618F;
        // arm
        this.ArmLeft01.xRot = 0.4F;
        this.ArmLeft01.zRot = -0.2618F;
        this.ArmLeft03.xRot = 0F;
        this.ArmLeft03.zRot = 0F;
        this.ArmRight01.xRot = 0.4F;
        this.ArmRight01.zRot = 0.2618F;
        // leg
        this.LegLeft01.zRot = -0.14F;
        this.LegLeft02.xRot = 1.2217F;
        this.LegLeft02.yRot = 1.2217F;
        this.LegLeft02.zRot = -1.0472F;
        // this.LegLeft02.offsetX = 0.175F;
        // this.LegLeft02.offsetY = -0.02F;
        // this.LegLeft02.offsetZ = 0.1635F;
        this.LegRight01.zRot = 0.14F;
        this.LegRight02.xRot = 1.2217F;
        this.LegRight02.yRot = -1.2217F;
        this.LegRight02.zRot = 1.0472F;
        // this.LegRight02.offsetX = -0.175F;
        // this.LegRight02.offsetY = -0.05F;
        // this.LegRight02.offsetZ = 0.1635F;
        // equip
        // this.EquipL01.offsetY = 0.6F;
        // this.EquipR01.offsetY = 0.6F;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

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
        addk1 = angleAdd1 * 0.6F - 0.35F;
        addk2 = angleAdd2 * 0.6F - 0.07F;

        // 移動頭部使其看人
        this.Head.xRot = f4 * 0.014F; // 上下角度
        this.Head.yRot = f3 * 0.01F; // 左右角度
        this.Head.zRot = 0F;
        headX = this.Head.xRot * -0.5F;
        // 正常站立動作
        // 胸部
        this.BoobL.xRot = angleX * 0.08F - 0.7F;
        this.BoobR.xRot = angleX * 0.08F - 0.7F;
        // Body
        this.Ahoke.yRot = angleX * 0.15F + 0.7F;
        this.Neck.xRot = 0.1F;
        this.BodyMain.xRot = -0.1047F;
        this.Butt.xRot = 0.3142F;
        this.Skirt01.xRot = -0.14F;
        this.Skirt02.xRot = -0.087F;
        // hair
        this.Hair01.xRot = angleX * 0.03F + 0.21F + headX;
        this.Hair01.zRot = 0F;
        this.Hair02.xRot = -angleX1 * 0.04F - 0.09F + headX;
        this.Hair02.zRot = 0F;
        this.Hair03.xRot = -angleX2 * 0.07F - 0.14F;
        this.Hair03.zRot = 0F;
        // arm
        this.ArmLeft01.xRot = 0.2618F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = -0.7F;
        this.ArmLeft03.xRot = -0.14F;
        this.ArmLeft03.zRot = 1.4835F;
        this.ArmLeft05.zRot = 0.2618F;
        this.ArmRight01.xRot = angleAdd1 * 0.375F + 0.2618F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = 0.2618F;
        this.ArmRight03.xRot = 0F;
        this.ArmRight03.zRot = 0F;
        // leg
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.14F;
        // this.LegLeft02.offsetX = 0;
        // this.LegLeft02.offsetY = 0;
        // this.LegLeft02.offsetZ = 0F;
        this.LegLeft02.xRot = 0F;
        this.LegLeft02.yRot = 0F;
        this.LegLeft02.zRot = 0F;
        this.ShoesL04.xRot = -0.1F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.14F;
        // this.LegRight02.offsetX = 0F;
        // this.LegRight02.offsetY = 0F;
        // this.LegRight02.offsetZ = 0F;
        this.LegRight02.xRot = 0F;
        this.LegRight02.yRot = 0F;
        this.LegRight02.zRot = 0F;
        // equip
        if (this.EquipBase != null)
            this.EquipBase.xRot = 0F;
        // this.EquipL01.offsetX = 0F;
        // this.EquipL01.offsetY = angleX * 0.125F;
        // this.EquipL01.offsetZ = 0F;
        if (this.EquipL01 != null)
            this.EquipL01.xRot = 0.2618F;
        if (this.EquipL01 != null)
            this.EquipL01.yRot = 0.1745F;
        if (this.EquipL01 != null)
            this.EquipL01.zRot = 0F;
        if (this.EquipL05 != null)
            this.EquipL05.zRot = 0F;
        // this.EquipR01.offsetX = 0F;
        // this.EquipR01.offsetY = -angleX * 0.125F;
        // this.EquipR01.offsetZ = 0F;
        if (this.EquipR01 != null)
            this.EquipR01.xRot = 0.2618F;
        if (this.EquipR01 != null)
            this.EquipR01.yRot = -0.1745F;
        if (this.EquipR01 != null)
            this.EquipR01.zRot = 0f;

        if (ent.getIsSprinting() || f1 > 0.9F) { // 奔跑動作
            // hair
            this.Hair01.xRot += 0.09F;
            this.Hair02.xRot += 0.43F;
            this.Hair03.xRot += 0.49F;
            // 胸部
            this.BoobL.xRot = angleAdd2 * 0.1F - 0.83F;
            this.BoobR.xRot = angleAdd1 * 0.1F - 0.83F;
            // arm
            this.ArmLeft01.xRot = angleAdd2 * 0.6F + 0.2618F;
            this.ArmLeft01.yRot = 0F;
            this.ArmLeft01.zRot = -0.3F;
            this.ArmLeft03.xRot = 0F;
            this.ArmLeft03.zRot = 0F;
            this.ArmLeft05.zRot = 0F;
            this.ArmRight01.xRot = angleAdd1 * 0.6F + 0.2618F;
            this.ArmRight01.yRot = 0F;
            this.ArmRight01.zRot = 0.3F;
        }

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        if (ent.getIsSneaking()) { // 潛行, 蹲下動作
            // Body
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.05F;
            this.Head.xRot -= 0.6283F;
            this.BodyMain.xRot = 0.8727F;
            this.Butt.xRot = -0.6283F;
            this.Skirt01.xRot = -0.1745F;
            this.Skirt02.xRot = -0.2618F;
            // arm
            this.ArmLeft01.xRot = 0.2618F;
            this.ArmLeft01.yRot = 0F;
            this.ArmLeft01.zRot = 0.2618F;
            this.ArmLeft03.xRot = 0F;
            this.ArmLeft03.zRot = 0F;
            this.ArmLeft05.zRot = 0F;
            this.ArmRight01.xRot = 0.2618F;
            this.ArmRight01.yRot = 0F;
            this.ArmRight01.zRot = -0.2618F;
            this.ArmRight05.zRot = 0F;
            // hair
            this.Hair01.xRot += 0.37F;
            this.Hair02.xRot += 0.23F;
            this.Hair03.xRot -= 0.1F;
        } // end if sneaking

        if (ent.getIsSitting() && !ent.getIsRiding()) { // 騎乘動作
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                setFace(1);
                // head
                int nodf2 = (int) f2 % 60;
                this.Head.xRot = 0.3F;
                if (nodf2 < 30) {
                    if (nodf2 < 6) {
                        this.Head.xRot = nodf2 * 0.02F + 0.3F;
                    } else if (nodf2 < 11) {
                        this.Head.xRot = (nodf2 - 5) * 0.03F + 0.4F;
                    } else if (nodf2 < 14) {
                        this.Head.xRot = (nodf2 - 10) * -0.09F + 0.55F;
                    }
                }
                this.Head.yRot = 0F;
                this.Head.zRot = 0F;
                // hair 動到headX, 需重新調整hairX
                headX = this.Head.xRot * -0.5F;
                this.Hair01.xRot = angleX * 0.012F + 0.21F + headX;
                this.Hair02.xRot = angleX * 0.015F - 0.09F + headX;
                // body
                this.Neck.xRot = 0.3F;
                this.Butt.xRot = -0.14F;
                this.Skirt01.xRot = -0.1745F;
                this.Skirt02.xRot = -0.2618F;
                // arm
                this.ArmLeft01.xRot = 0.4F;
                this.ArmLeft01.zRot = -0.2618F;
                this.ArmLeft03.xRot = 0F;
                this.ArmLeft03.zRot = 0F;
                this.ArmRight01.xRot = 0.4F;
                this.ArmRight01.zRot = 0.2618F;
                // leg
                addk1 = -1.0472F;
                addk2 = -1.0472F;
                this.LegLeft01.zRot = -0.14F;
                this.LegLeft02.xRot = 1.2217F;
                this.LegLeft02.yRot = 1.2217F;
                this.LegLeft02.zRot = -1.0472F;
                // this.LegLeft02.offsetX = 0.175F;
                // this.LegLeft02.offsetY = -0.02F;
                // this.LegLeft02.offsetZ = 0.1635F;
                this.LegRight01.zRot = 0.14F;
                this.LegRight02.xRot = 1.2217F;
                this.LegRight02.yRot = -1.2217F;
                this.LegRight02.zRot = 1.0472F;
                // this.LegRight02.offsetX = -0.175F;
                // this.LegRight02.offsetY = -0.05F;
                // this.LegRight02.offsetZ = 0.1635F;
                // equip
                // this.EquipL01.offsetY = 0.6F;
                // this.EquipR01.offsetY = 0.6F;
            } else {
                // body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.4F;
                this.Neck.xRot = 0.35F;
                this.BodyMain.xRot = -0.6283F;
                this.Butt.xRot = -0.6283F;
                this.Skirt01.xRot = -0.1745F;
                this.Skirt02.xRot = -0.2618F;
                // arm
                this.ArmRight01.xRot = angleX * 0.125F + 0.5236F;
                // leg
                addk1 = -0.8727F;
                addk2 = -0.35F;
                this.LegLeft01.zRot = 0.4363F;
                this.LegLeft02.xRot = 0.7854F;
                this.LegRight01.zRot = -0.35F;
                this.LegRight02.xRot = 0.8727F;
                this.ShoesL04.xRot = angleX * 0.25F - 0.1F;
                // equip
                // this.EquipL01.offsetX = -1.9F;
                // this.EquipL01.offsetY = 0.6F;
                // this.EquipL01.offsetZ = 0.4F;
                if (this.EquipL01 != null)
                    this.EquipL01.xRot = 0F;
                if (this.EquipL01 != null)
                    this.EquipL01.yRot = 1.57F;
                if (this.EquipL05 != null)
                    this.EquipL05.zRot = -1F;
                // this.EquipR01.offsetX = 1.9F;
                // this.EquipR01.offsetY = -1.0F;
                // this.EquipR01.offsetZ = -0.4F;
                if (this.EquipR01 != null)
                    this.EquipR01.xRot = -1.5708F;
                if (this.EquipR01 != null)
                    this.EquipR01.yRot = 0.6F;
                if (this.EquipR01 != null)
                    this.EquipR01.zRot = -1.5708F;
            }
        } // end sitting

        if (ent.getIsRiding()) {
            if (((net.minecraft.world.entity.Entity) ent).getVehicle() instanceof BasicEntityMount) {
                if (this.EquipBase != null)
                    this.EquipBase.visible = true;

                if (ent.getIsSitting()) {
                    if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                        setFace(1);
                        // head
                        int nodf2 = (int) f2 % 60;
                        this.Head.xRot = 0.3F;
                        if (nodf2 < 30) {
                            if (nodf2 < 6) {
                                this.Head.xRot = nodf2 * 0.02F + 0.3F;
                            } else if (nodf2 < 11) {
                                this.Head.xRot = (nodf2 - 5) * 0.03F + 0.4F;
                            } else if (nodf2 < 14) {
                                this.Head.xRot = (nodf2 - 10) * -0.09F + 0.55F;
                            }
                        }
                        this.Head.yRot = 0F;
                        this.Head.zRot = 0F;
                        // hair 動到headX, 需重新調整hairX
                        headX = this.Head.xRot * -0.5F;
                        this.Hair01.xRot = angleX * 0.012F + 0.21F + headX;
                        this.Hair02.xRot = angleX * 0.015F - 0.09F + headX;
                        // body
                        this.Neck.xRot = 0.3F;
                        this.Butt.xRot = -0.14F;
                        this.Skirt01.xRot = -0.1745F;
                        this.Skirt02.xRot = -0.2618F;
                        // arm
                        this.ArmLeft01.xRot = 0.4F;
                        this.ArmLeft01.zRot = -0.2618F;
                        this.ArmLeft03.xRot = 0F;
                        this.ArmLeft03.zRot = 0F;
                        this.ArmRight01.xRot = 0.4F;
                        this.ArmRight01.zRot = 0.2618F;
                        // leg
                        addk1 = -1.0472F;
                        addk2 = -1.0472F;
                        this.LegLeft01.zRot = -0.14F;
                        this.LegLeft02.xRot = 1.2217F;
                        this.LegLeft02.yRot = 1.2217F;
                        this.LegLeft02.zRot = -1.0472F;
                        // this.LegLeft02.offsetX = 0.175F;
                        // this.LegLeft02.offsetY = -0.02F;
                        // this.LegLeft02.offsetZ = 0.1635F;
                        this.LegRight01.zRot = 0.14F;
                        this.LegRight02.xRot = 1.2217F;
                        this.LegRight02.yRot = -1.2217F;
                        this.LegRight02.zRot = 1.0472F;
                        // this.LegRight02.offsetX = -0.175F;
                        // this.LegRight02.offsetY = -0.05F;
                        // this.LegRight02.offsetZ = 0.1635F;
                        // equip
                        if (this.EquipBase != null)
                            this.EquipBase.xRot = -0.4F;
                        // this.EquipL01.offsetX = -0.3F;
                        // this.EquipL01.offsetY = 0.6F;
                        // this.EquipL01.offsetZ = 0.6F;
                        if (this.EquipL01 != null)
                            this.EquipL01.yRot = 1.4F;
                        // this.EquipR01.offsetX = 0.3F;
                        // this.EquipR01.offsetY = 0.6F;
                        // this.EquipR01.offsetZ = 0.6F;
                        if (this.EquipR01 != null)
                            this.EquipR01.yRot = -1.4F;
                    } else {
                        // body
                        this.Neck.xRot = 0.35F;
                        this.BodyMain.xRot = -0.6283F;
                        this.Butt.xRot = -0.6283F;
                        this.Skirt01.xRot = -0.1745F;
                        this.Skirt02.xRot = -0.2618F;
                        // arm
                        this.ArmRight01.xRot = angleX * 0.125F + 0.5236F;
                        this.ArmRight01.zRot = 0.45F;
                        this.ArmRight03.xRot = -0.5F;
                        // leg
                        addk1 = -0.8727F;
                        addk2 = -0.35F;
                        this.LegLeft01.zRot = 0.4363F;
                        this.LegLeft02.xRot = 0.7854F;
                        this.LegRight01.zRot = -0.35F;
                        this.LegRight02.xRot = 0.8727F;
                        this.ShoesL04.xRot = angleX * 0.25F - 0.1F;
                        // equip
                        if (this.EquipBase != null)
                            this.EquipBase.xRot = 0.2F;
                        // this.EquipL01.offsetX = -0.25F;
                        // this.EquipL01.offsetY = 0.1F;
                        if (this.EquipL01 != null)
                            this.EquipL01.yRot = 1.4F;
                        // this.EquipR01.offsetX = 0.25F;
                        // this.EquipR01.offsetY = 0.1F;
                        if (this.EquipR01 != null)
                            this.EquipR01.yRot = -1.4F;
                    }
                } // end if sitting
                else {
                    // body
                    this.Neck.xRot = 0.35F;
                    this.BodyMain.xRot = -0.6283F;
                    this.Butt.xRot = -0.6283F;
                    this.Skirt01.xRot = -0.1745F;
                    this.Skirt02.xRot = -0.2618F;
                    // arm
                    this.ArmRight01.xRot = angleX * 0.125F + 0.5236F;
                    this.ArmRight01.zRot = 0.45F;
                    this.ArmRight03.xRot = -0.5F;
                    // leg
                    addk1 = -0.8727F;
                    addk2 = -0.35F;
                    this.LegLeft01.zRot = 0.4363F;
                    this.LegLeft02.xRot = 0.7854F;
                    this.LegRight01.zRot = -0.35F;
                    this.LegRight02.xRot = 0.8727F;
                    this.ShoesL04.xRot = angleX * 0.25F - 0.1F;
                    // equip
                    if (this.EquipBase != null)
                        this.EquipBase.xRot = -0.9F;
                    // this.EquipL01.offsetX = -0.25F;
                    // this.EquipL01.offsetY = 0.1F;
                    // this.EquipL01.offsetZ = 0.45F;
                    if (this.EquipL01 != null)
                        this.EquipL01.yRot = 1.4F;
                    // this.EquipR01.offsetX = 0.25F;
                    // this.EquipR01.offsetY = 0.1F;
                    // this.EquipR01.offsetZ = 0.45F;
                    if (this.EquipR01 != null)
                        this.EquipR01.yRot = -1.4F;
                }
            } // end ship mount
            else { // normal mount ex: cart
                if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                    setFace(1);
                    // head
                    int nodf2 = (int) f2 % 60;
                    this.Head.xRot = 0.2F;
                    if (nodf2 < 30) {
                        if (nodf2 < 6) {
                            this.Head.xRot = nodf2 * 0.02F + 0.2F;
                        } else if (nodf2 < 11) {
                            this.Head.xRot = (nodf2 - 5) * 0.03F + 0.3F;
                        } else if (nodf2 < 14) {
                            this.Head.xRot = (nodf2 - 10) * -0.09F + 0.45F;
                        }
                    }
                    this.Head.yRot = 0F;
                    this.Head.zRot = 0F;
                    // hair 動到headX, 需重新調整hairX
                    headX = this.Head.xRot * -0.5F;
                    this.Hair01.xRot = angleX * 0.012F + 0.21F + headX;
                    this.Hair02.xRot = angleX * 0.015F - 0.09F + headX;
                    // body
                    this.Neck.xRot = 0.3F;
                    this.Butt.xRot = -0.14F;
                    this.Skirt01.xRot = -0.1745F;
                    this.Skirt02.xRot = -0.2618F;
                    // arm
                    this.ArmLeft01.xRot = 0.4F;
                    this.ArmLeft01.zRot = -0.2618F;
                    this.ArmLeft03.xRot = 0F;
                    this.ArmLeft03.zRot = 0F;
                    this.ArmRight01.xRot = 0.4F;
                    this.ArmRight01.zRot = 0.2618F;
                    // leg
                    addk1 = -1.0472F;
                    addk2 = -1.0472F;
                    this.LegLeft01.zRot = -0.14F;
                    this.LegLeft02.xRot = 1.2217F;
                    this.LegLeft02.yRot = 1.2217F;
                    this.LegLeft02.zRot = -1.0472F;
                    // this.LegLeft02.offsetX = 0.175F;
                    // this.LegLeft02.offsetY = -0.02F;
                    // this.LegLeft02.offsetZ = 0.1635F;
                    this.LegRight01.zRot = 0.14F;
                    this.LegRight02.xRot = 1.2217F;
                    this.LegRight02.yRot = -1.2217F;
                    this.LegRight02.zRot = 1.0472F;
                    // this.LegRight02.offsetX = -0.175F;
                    // this.LegRight02.offsetY = -0.05F;
                    // this.LegRight02.offsetZ = 0.1635F;
                    // equip
                    // this.EquipL01.offsetY = 0.6F;
                    // this.EquipR01.offsetY = 0.6F;
                } else {
                    // body
                    this.Neck.xRot = 0.35F;
                    this.BodyMain.xRot = -0.6283F;
                    this.Butt.xRot = -0.6283F;
                    this.Skirt01.xRot = -0.1745F;
                    this.Skirt02.xRot = -0.2618F;
                    // arm
                    this.ArmRight01.xRot = angleX * 0.125F + 0.5236F;
                    // leg
                    addk1 = -0.8727F;
                    addk2 = -0.35F;
                    this.LegLeft01.zRot = 0.4363F;
                    this.LegLeft02.xRot = 0.7854F;
                    this.LegRight01.zRot = -0.35F;
                    this.LegRight02.xRot = 0.8727F;
                    this.ShoesL04.xRot = angleX * 0.25F - 0.1F;
                    // equip
                    // this.EquipL01.offsetX = -1.9F;
                    // this.EquipL01.offsetY = 0.6F;
                    // this.EquipL01.offsetZ = 0.4F;
                    if (this.EquipL01 != null)
                        this.EquipL01.xRot = 0F;
                    if (this.EquipL01 != null)
                        this.EquipL01.yRot = 1.57F;
                    if (this.EquipL05 != null)
                        this.EquipL05.zRot = -1F;
                    // this.EquipR01.offsetX = 1.9F;
                    // this.EquipR01.offsetY = -1.0F;
                    // this.EquipR01.offsetZ = -0.4F;
                    if (this.EquipR01 != null)
                        this.EquipR01.xRot = -1.5708F;
                    if (this.EquipR01 != null)
                        this.EquipR01.yRot = 0.6F;
                    if (this.EquipR01 != null)
                        this.EquipR01.zRot = -1.5708F;
                }
            }
        } // end ridding

        // 攻擊動作
        if (ent.getAttackTick() > 0) {
            if (ent.getIsRiding()) {
                // arm
                this.ArmRight01.xRot = -1.1F;
                this.ArmRight03.xRot = 0F;
                // equip
                if (this.EquipBase != null)
                    this.EquipBase.visible = true;
                if (this.EquipBase != null)
                    this.EquipBase.xRot = -1.2F + f4 * ((float) Math.PI / 180F);
                if (this.EquipL01 != null)
                    this.EquipL01.xRot = -0.1F;
                if (this.EquipR01 != null)
                    this.EquipR01.xRot = 0.1F;
            } else {
                // arm
                this.ArmRight01.xRot = -1.5F;
                // equip
                if (this.EquipBase != null)
                    this.EquipBase.visible = true;
                if (this.EquipBase != null)
                    this.EquipBase.xRot = -1.6F + f4 * ((float) Math.PI / 180F);
                // this.EquipL01.offsetY = 0F;
                // this.EquipR01.offsetY = 0F;
            }
        }

        // swing arm
        float f6 = ent.getSwingTime(f2 - (int) f2);
        if (f6 != 0F) {
            float f7 = Mth.sin(f6 * f6 * (float) Math.PI);
            float f8 = Mth.sin(Mth.sqrt(f6) * (float) Math.PI);
            this.ArmRight01.xRot = -0.4F;
            this.ArmRight01.yRot = 0F;
            this.ArmRight01.zRot = -0.2F;
            this.ArmRight01.xRot += -f8 * 80.0F * ((float) Math.PI / 180F);
            this.ArmRight01.yRot += -f7 * 20.0F * ((float) Math.PI / 180F) + 0.2F;
            this.ArmRight01.zRot += -f8 * 20.0F * ((float) Math.PI / 180F);
        }

        // 鬢毛調整
        headZ = this.Head.zRot * -0.5F;
        this.Hair01.zRot = headZ;
        this.Hair02.zRot = headZ;
        this.HairL01.zRot = headZ - 0.087F;
        this.HairL02.zRot = headZ + 0.087F;
        this.HairR01.zRot = headZ + 0.087F;
        this.HairR02.zRot = headZ - 0.052F;
        headX = this.Head.xRot * -0.5F;
        this.HairL01.xRot = angleX * 0.02F + headX - 0.14F;
        this.HairL02.xRot = angleX * 0.02F + headX + 0.17F;
        this.HairR01.xRot = angleX * 0.02F + headX - 0.14F;
        this.HairR02.xRot = angleX * 0.02F + headX + 0.17F;

        // leg motion
        this.LegLeft01.xRot = addk1;
        this.LegRight01.xRot = addk2;
    }
}
