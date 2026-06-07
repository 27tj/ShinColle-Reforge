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

public class ModelNorthernHime extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "northern_hime"), "main");

    private final ModelPart BodyMain;
    private final ModelPart ArmLeft01;
    private final ModelPart ArmRight01;
    private final ModelPart Butt;
    private final ModelPart EquipBase;
    private final ModelPart Cloth01;
    private final ModelPart Neck;
    private final ModelPart ArmLeft02;
    private final ModelPart ArmLeft03;
    private final ModelPart ArmLeft04;
    private final ModelPart ArmLeft05;
    private final ModelPart ArmLeft06;
    private final ModelPart EquipUmbre01a;
    private final ModelPart EquipUmbre01b;
    private final ModelPart EquipUmbre02;
    private final ModelPart EquipUmbre01c;
    private final ModelPart EquipUmbre02a;
    private final ModelPart EquipUmbre03a;
    private final ModelPart EquipUmbre02b;
    private final ModelPart EquipUmbre03b;
    private final ModelPart ArmRight02;
    private final ModelPart ArmRight03;
    private final ModelPart ArmRight04;
    private final ModelPart ArmRight05;
    private final ModelPart ArmRight06;
    private final ModelPart LegRight01;
    private final ModelPart ArmRightItem;
    private final ModelPart LegLeft01;
    private final ModelPart LegRight02;
    private final ModelPart ShoesR;
    private final ModelPart LegLeft02;
    private final ModelPart ShoesL2;
    private final ModelPart ShoesL;
    private final ModelPart EquipRT01;
    private final ModelPart EquipLT01;
    private final ModelPart EquipRT02;
    private final ModelPart HeadBase;
    private final ModelPart TailJaw1;
    private final ModelPart TailHead1;
    private final ModelPart TailHeadCL1;
    private final ModelPart TailHeadCR1;
    private final ModelPart EquipRoad01;
    private final ModelPart TailJawT01;
    private final ModelPart TailHead2;
    private final ModelPart TailHeadT01;
    private final ModelPart TailHeadC2;
    private final ModelPart TailHeadC3;
    private final ModelPart EquipRoad02;
    private final ModelPart EquipRoad03;
    private final ModelPart EquipLT02;
    private final ModelPart EquipLT03;
    private final ModelPart EquipLT04;
    private final ModelPart EquipLT05;
    private final ModelPart EquipLT06;
    private final ModelPart EquipLHead;
    private final ModelPart EquipLHead01;
    private final ModelPart EquipLHead02;
    private final ModelPart EquipLHead03;
    private final ModelPart Cloth02;
    private final ModelPart Cloth03;
    private final ModelPart SantaCloth01;
    private final ModelPart Head;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart HeadHL;
    private final ModelPart HeadHR;
    private final ModelPart SantaHat01;
    private final ModelPart Ahoke;
    private final ModelPart HairL01;
    private final ModelPart HairR01;
    private final ModelPart HairL02;
    private final ModelPart HairR02;
    private final ModelPart Hair01;
    private final ModelPart Hair02;
    private final ModelPart HeadHL2;
    private final ModelPart HeadHL3;
    private final ModelPart HeadHR2;
    private final ModelPart HeadHR3;
    private final ModelPart SantaHat02;
    private final ModelPart SantaHat03;
    private final ModelPart SantaHat04;
    private final ModelPart SantaHat05;
    private final ModelPart HairS01a;
    private final ModelPart HairS01b;
    private final ModelPart HairS02a;
    private final ModelPart HairS02b;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowNeck;
    private final ModelPart GlowHead;
    private final ModelPart GlowEquipBase;
    private final ModelPart GlowEquipRT01;
    private final ModelPart GlowEquipRT02;
    private final ModelPart GlowHeadBase;
    private final ModelPart GlowTailHead1;
    private final ModelPart GlowTailJaw1;
    private final ModelPart GlowTailHead2;
    private final ModelPart GlowEquipLT01;
    private final ModelPart GlowEquipLT02;
    private final ModelPart GlowEquipLT03;
    private final ModelPart GlowEquipLT04;
    private final ModelPart GlowEquipLT05;
    private final ModelPart GlowEquipLT06;

    public ModelNorthernHime(ModelPart root) {
        super();
        this.scale = 0.34F;
        this.offsetY = 3.08F;
        this.BodyMain = root.getChild("BodyMain");
        this.Cloth01 = this.BodyMain.getChild("Cloth01");
        this.Neck = this.BodyMain.getChild("Neck");
        this.Butt = this.BodyMain.getChild("Butt");
        this.EquipBase = this.BodyMain.getChild("EquipBase");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.Cloth02 = this.Cloth01.getChild("Cloth02");
        this.Head = this.Neck.getChild("Head");
        this.LegRight01 = this.Butt.getChild("LegRight01");
        this.LegLeft01 = this.Butt.getChild("LegLeft01");
        this.EquipLT01 = this.EquipBase.getChild("EquipLT01");
        this.EquipRT01 = this.EquipBase.getChild("EquipRT01");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.Cloth03 = this.Cloth02.getChild("Cloth03");
        this.HairMain = this.Head.getChild("HairMain");
        this.Hair = this.Head.getChild("Hair");
        this.SantaHat01 = this.Head.getChild("SantaHat01");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
        this.ShoesL2 = this.LegLeft01.getChild("ShoesL2");
        this.EquipLT02 = this.EquipLT01.getChild("EquipLT02");
        this.EquipRT02 = this.EquipRT01.getChild("EquipRT02");
        this.ArmRight03 = this.ArmRight02.getChild("ArmRight03");
        this.ArmLeft03 = this.ArmLeft02.getChild("ArmLeft03");
        this.SantaCloth01 = this.Cloth03.getChild("SantaCloth01");
        this.Hair01 = this.HairMain.getChild("Hair01");
        this.HairR01 = this.Hair.getChild("HairR01");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.HairL01 = this.Hair.getChild("HairL01");
        this.SantaHat02 = this.SantaHat01.getChild("SantaHat02");
        this.ShoesR = this.LegRight02.getChild("ShoesR");
        this.ShoesL = this.LegLeft02.getChild("ShoesL");
        this.EquipLT03 = this.EquipLT02.getChild("EquipLT03");
        this.HeadBase = this.EquipRT02.getChild("HeadBase");
        this.ArmRight04 = this.ArmRight03.getChild("ArmRight04");
        this.ArmLeft04 = this.ArmLeft03.getChild("ArmLeft04");
        this.Hair02 = this.Hair01.getChild("Hair02");
        this.HairS01a = this.Hair01.getChild("HairS01a");
        this.HairS02a = this.Hair01.getChild("HairS02a");
        this.HairR02 = this.HairR01.getChild("HairR02");
        this.HairL02 = this.HairL01.getChild("HairL02");
        this.SantaHat03 = this.SantaHat02.getChild("SantaHat03");
        this.EquipLT04 = this.EquipLT03.getChild("EquipLT04");
        this.TailHead1 = this.HeadBase.getChild("TailHead1");
        this.TailHeadCR1 = this.HeadBase.getChild("TailHeadCR1");
        this.TailJaw1 = this.HeadBase.getChild("TailJaw1");
        this.TailHeadCL1 = this.HeadBase.getChild("TailHeadCL1");
        this.ArmRight05 = this.ArmRight04.getChild("ArmRight05");
        this.ArmLeft05 = this.ArmLeft04.getChild("ArmLeft05");
        this.HairS01b = this.HairS01a.getChild("HairS01b");
        this.HairS02b = this.HairS02a.getChild("HairS02b");
        this.SantaHat04 = this.SantaHat03.getChild("SantaHat04");
        this.EquipLT05 = this.EquipLT04.getChild("EquipLT05");
        this.TailHead2 = this.TailHead1.getChild("TailHead2");
        this.ArmRightItem = this.ArmRight05.getChild("ArmRightItem");
        this.ArmRight06 = this.ArmRight05.getChild("ArmRight06");
        this.ArmLeft06 = this.ArmLeft05.getChild("ArmLeft06");
        this.EquipUmbre01a = this.ArmLeft05.getChild("EquipUmbre01a");
        this.SantaHat05 = this.SantaHat04.getChild("SantaHat05");
        this.EquipLT06 = this.EquipLT05.getChild("EquipLT06");
        this.EquipUmbre01b = this.EquipUmbre01a.getChild("EquipUmbre01b");
        this.EquipUmbre02 = this.EquipUmbre01a.getChild("EquipUmbre02");
        this.EquipUmbre01c = this.EquipUmbre01b.getChild("EquipUmbre01c");
        this.EquipUmbre03a = this.EquipUmbre01c.getChild("EquipUmbre03a");
        this.EquipUmbre02a = this.EquipUmbre01c.getChild("EquipUmbre02a");
        this.EquipUmbre03b = this.EquipUmbre03a.getChild("EquipUmbre03b");
        this.EquipUmbre02b = this.EquipUmbre02a.getChild("EquipUmbre02b");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowNeck = this.GlowBodyMain.getChild("GlowNeck");
        this.GlowEquipBase = this.GlowBodyMain.getChild("GlowEquipBase");
        this.GlowHead = this.GlowNeck.getChild("GlowHead");
        this.GlowEquipRT01 = this.GlowEquipBase.getChild("GlowEquipRT01");
        this.GlowEquipLT01 = this.GlowEquipBase.getChild("GlowEquipLT01");
        this.GlowEquipRT02 = this.GlowEquipRT01.getChild("GlowEquipRT02");
        this.GlowEquipLT02 = this.GlowEquipLT01.getChild("GlowEquipLT02");
        this.GlowHeadBase = this.GlowEquipRT02.getChild("GlowHeadBase");
        this.GlowEquipLT03 = this.GlowEquipLT02.getChild("GlowEquipLT03");
        this.GlowTailHead1 = this.GlowHeadBase.getChild("GlowTailHead1");
        this.GlowTailJaw1 = this.GlowHeadBase.getChild("GlowTailJaw1");
        this.GlowEquipLT04 = this.GlowEquipLT03.getChild("GlowEquipLT04");
        this.GlowTailHead2 = this.GlowTailHead1.getChild("GlowTailHead2");
        this.GlowEquipLT05 = this.GlowEquipLT04.getChild("GlowEquipLT05");
        this.GlowEquipLT06 = this.GlowEquipLT05.getChild("GlowEquipLT06");
        this.HeadHL = this.GlowHead.getChild("HeadHL");
        this.HeadHL2 = this.HeadHL.getChild("HeadHL2");
        this.HeadHL3 = this.HeadHL2.getChild("HeadHL3");
        this.HeadHR = this.GlowHead.getChild("HeadHR");
        this.HeadHR2 = this.HeadHR.getChild("HeadHR2");
        this.HeadHR3 = this.HeadHR2.getChild("HeadHR3");
        this.TailHeadT01 = this.GlowTailHead1.getChild("TailHeadT01");
        this.TailJawT01 = this.GlowTailJaw1.getChild("TailJawT01");
        this.TailHeadC2 = this.GlowTailHead2.getChild("TailHeadC2");
        this.TailHeadC3 = this.GlowTailHead2.getChild("TailHeadC3");
        this.EquipRoad01 = this.GlowHeadBase.getChild("EquipRoad01");
        this.EquipRoad02 = this.EquipRoad01.getChild("EquipRoad02");
        this.EquipRoad03 = this.EquipRoad02.getChild("EquipRoad03");
        this.EquipLHead = this.GlowEquipLT06.getChild("EquipLHead");
        this.EquipLHead01 = this.EquipLHead.getChild("EquipLHead01");
        this.EquipLHead02 = this.EquipLHead01.getChild("EquipLHead02");
        this.EquipLHead03 = this.EquipLHead02.getChild("EquipLHead03");
        this.loadFaceParts(this.GlowHead);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 114)
                        .addBox(-6.5F, -11.0F, -4.0F, 13.0F, 7.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition cloth01 = bodyMain.addOrReplaceChild("Cloth01",
                CubeListBuilder.create().texOffs(128, 75)
                        .addBox(-7.0F, 0.0F, 0.0F, 14.0F, 4.0F, 8.0F),
                PartPose.offset(0.0F, -5.0F, -4.4F));

        PartDefinition cloth02 = cloth01.addOrReplaceChild("Cloth02",
                CubeListBuilder.create().texOffs(128, 87)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 4.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 3.0F, -0.3F, 0.13962634015954636F, 0.0F, 0.0F));

        PartDefinition cloth03 = cloth02.addOrReplaceChild("Cloth03",
                CubeListBuilder.create().texOffs(128, 100)
                        .addBox(-8.0F, 0.0F, 0.0F, 16.0F, 4.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 3.0F, -0.2F, 0.13962634015954636F, 0.0F, 0.0F));

        cloth03.addOrReplaceChild("SantaCloth01",
                CubeListBuilder.create().texOffs(128, 114)
                        .addBox(-8.5F, 0.0F, 0.0F, 17.0F, 2.0F, 11.0F),
                PartPose.offset(0.0F, 3.0F, -0.3F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(129, 58)
                        .addBox(-7.0F, -2.0F, -6.0F, 14.0F, 3.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -11.3F, -0.5F, 0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offset(0.0F, -1.5F, 0.0F));

        PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(48, 55)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 12.0F, 10.0F),
                PartPose.offset(0.0F, -15.0F, -3.0F));

        PartDefinition hair01 = hairMain.addOrReplaceChild("Hair01",
                CubeListBuilder.create().texOffs(1, 70)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 12.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 9.0F, 2.0F, 0.3490658503988659F, 0.0F, 0.0F));

        hair01.addOrReplaceChild("Hair02",
                CubeListBuilder.create().texOffs(0, 70)
                        .addBox(-8.0F, 0.0F, -8.0F, 16.0F, 12.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 9.5F, 7.5F, 0.136659280431156F, 0.0F, 0.0F));

        PartDefinition hairS01a = hair01.addOrReplaceChild("HairS01a",
                CubeListBuilder.create().texOffs(38, 19)
                        .addBox(0.0F, 0.0F, -2.0F, 0.0F, 7.0F, 4.0F),
                PartPose.offsetAndRotation(7.5F, -1.0F, 3.5F, 0.087F, 0.0F, -0.2618F));

        hairS01a.addOrReplaceChild("HairS01b",
                CubeListBuilder.create().texOffs(46, 26)
                        .addBox(0.0F, 0.0F, -2.0F, 0.0F, 7.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition hairS02a = hair01.addOrReplaceChild("HairS02a",
                CubeListBuilder.create().texOffs(38, 19)
                        .addBox(0.0F, 0.0F, -2.0F, 0.0F, 7.0F, 4.0F),
                PartPose.offsetAndRotation(-7.5F, 3.0F, 2.5F, 0.087F, 0.0F, 0.35F));

        hairS02a.addOrReplaceChild("HairS02b",
                CubeListBuilder.create().texOffs(38, 25)
                        .addBox(0.0F, 0.0F, -2.0F, 0.0F, 7.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.0F, 0.0F, 0.35F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(50, 77)
                        .addBox(-8.0F, -8.0F, -7.2F, 16.0F, 16.0F, 8.0F),
                PartPose.offset(0.0F, -7.5F, 0.0F));

        PartDefinition hairR01 = hair.addOrReplaceChild("HairR01",
                CubeListBuilder.create().mirror().texOffs(86, 102)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 4.0F),
                PartPose.offsetAndRotation(-6.5F, 3.0F, -4.5F, -0.2617993877991494F,
                        0.17453292519943295F, 0.13962634015954636F));

        hairR01.addOrReplaceChild("HairR02",
                CubeListBuilder.create().mirror().texOffs(86, 102)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 4.0F),
                PartPose.offsetAndRotation(0.2F, 7.5F, 0.0F, 0.2617993877991494F, 0.0F,
                        -0.05235987755982988F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(104, 29)
                        .addBox(0.0F, -12.0F, -6.0F, 0.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -5.0F, -5.0F, 0.35F, 2.1F, 0.0F));

        PartDefinition hairL01 = hair.addOrReplaceChild("HairL01",
                CubeListBuilder.create().texOffs(86, 102)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 4.0F),
                PartPose.offsetAndRotation(6.5F, 3.0F, -4.5F, -0.2617993877991494F,
                        -0.17453292519943295F, -0.13962634015954636F));

        hairL01.addOrReplaceChild("HairL02",
                CubeListBuilder.create().texOffs(86, 102)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 4.0F),
                PartPose.offsetAndRotation(-0.2F, 7.5F, 0.0F, 0.2617993877991494F, 0.0F,
                        0.08726646259971647F));

        PartDefinition santaHat01 = head.addOrReplaceChild("SantaHat01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-6.5F, 0.0F, -6.5F, 13.0F, 3.0F, 13.0F),
                PartPose.offsetAndRotation(4.0F, -16.5F, 3.0F, -0.4363323129985824F,
                        0.8726646259971648F, -0.13962634015954636F));

        PartDefinition santaHat02 = santaHat01.addOrReplaceChild("SantaHat02",
                CubeListBuilder.create().texOffs(58, 24)
                        .addBox(-4.5F, -8.0F, -4.5F, 9.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 3.0F, -0.5F, -0.5235987755982988F,
                        0.17453292519943295F, 0.0F));

        PartDefinition santaHat03 = santaHat02.addOrReplaceChild("SantaHat03",
                CubeListBuilder.create().texOffs(65, 27)
                        .addBox(-2.5F, -6.0F, -2.5F, 6.0F, 6.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, -5.0F, -1.0F, -0.27314402793711257F, 0.0F,
                        -0.5009094953223726F));

        PartDefinition santaHat04 = santaHat03.addOrReplaceChild("SantaHat04",
                CubeListBuilder.create().texOffs(67, 28)
                        .addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F),
                PartPose.offsetAndRotation(0.5F, -4.5F, 0.0F, -1.1383037381507017F,
                        -0.27314402793711257F, 0.0F));

        santaHat04.addOrReplaceChild("SantaHat05",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F),
                PartPose.offsetAndRotation(2.0F, -5.8F, 2.0F, 0.6108652381980153F, 0.6981317007977318F,
                        -0.5235987755982988F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(92, 28)
                        .addBox(-5.5F, 0.0F, 0.0F, 11.0F, 6.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, -2.0F, -4.0F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().texOffs(0, 99)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F),
                PartPose.offsetAndRotation(-3.2F, 5.5F, 2.4F, -0.17453292519943295F, 0.0F,
                        0.05235987755982988F));

        PartDefinition legRight02 = legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().texOffs(0, 99)
                        .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 9.0F, 5.0F),
                PartPose.offset(0.0F, 8.0F, -2.5F));

        legRight02.addOrReplaceChild("ShoesR",
                CubeListBuilder.create().texOffs(80, 45)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F),
                PartPose.offset(0.0F, 4.0F, 2.5F));

        PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().mirror().texOffs(0, 99)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F),
                PartPose.offsetAndRotation(3.2F, 5.5F, 2.4F, -0.17453292519943295F, 0.0F,
                        -0.05235987755982988F));

        PartDefinition legLeft02 = legLeft01.addOrReplaceChild("LegLeft02",
                CubeListBuilder.create().mirror().texOffs(0, 99)
                        .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 9.0F, 5.0F),
                PartPose.offset(0.0F, 8.0F, -2.5F));

        legLeft02.addOrReplaceChild("ShoesL",
                CubeListBuilder.create().mirror().texOffs(80, 45)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F),
                PartPose.offset(0.0F, 4.0F, 2.5F));

        legLeft01.addOrReplaceChild("ShoesL2",
                CubeListBuilder.create().texOffs(80, 45)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F),
                PartPose.offset(0.0F, 4.0F, 0.0F));

        PartDefinition equipBase = bodyMain.addOrReplaceChild("EquipBase",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition equipLT01 = equipBase.addOrReplaceChild("EquipLT01",
                CubeListBuilder.create().texOffs(0, 45)
                        .addBox(0.0F, -2.5F, -2.5F, 6.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(2.0F, 4.0F, 2.5F, 0.0F, -1.0471975511965976F,
                        -0.2617993877991494F));

        PartDefinition equipLT02 = equipLT01.addOrReplaceChild("EquipLT02",
                CubeListBuilder.create().texOffs(0, 45)
                        .addBox(0.0F, -2.5F, -2.5F, 6.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 0.3490658503988659F,
                        -0.2617993877991494F));

        PartDefinition equipLT03 = equipLT02.addOrReplaceChild("EquipLT03",
                CubeListBuilder.create().texOffs(0, 45)
                        .addBox(0.0F, -2.5F, -2.5F, 6.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 0.3490658503988659F,
                        -0.2617993877991494F));

        PartDefinition equipLT04 = equipLT03.addOrReplaceChild("EquipLT04",
                CubeListBuilder.create().texOffs(0, 45)
                        .addBox(0.0F, -2.5F, -2.5F, 6.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 0.3490658503988659F,
                        -0.2617993877991494F));

        PartDefinition equipLT05 = equipLT04.addOrReplaceChild("EquipLT05",
                CubeListBuilder.create().texOffs(0, 45)
                        .addBox(0.0F, -2.5F, -2.5F, 6.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 0.3490658503988659F,
                        -0.2617993877991494F));

        equipLT05.addOrReplaceChild("EquipLT06",
                CubeListBuilder.create().texOffs(0, 45)
                        .addBox(0.0F, -2.5F, -2.5F, 6.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 0.3490658503988659F,
                        -0.2617993877991494F));

        PartDefinition equipRT01 = equipBase.addOrReplaceChild("EquipRT01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-16.0F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 4.0F, 0.0F, 0.7853981633974483F,
                        0.3490658503988659F));

        PartDefinition equipRT02 = equipRT01.addOrReplaceChild("EquipRT02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-16.0F, -2.0F, -4.0F, 16.0F, 4.0F, 4.0F),
                PartPose.offsetAndRotation(-16.0F, 0.0F, 2.0F, 0.0F, -1.0471975511965976F, 0.0F));

        PartDefinition headBase = equipRT02.addOrReplaceChild("HeadBase",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-6.0F, -8.0F, 2.0F, 12.0F, 15.0F, 8.0F),
                PartPose.offsetAndRotation(-14.0F, -3.0F, 0.0F, -0.4363323129985824F,
                        -2.792526803190927F, -0.13962634015954636F));

        PartDefinition tailHead1 = headBase.addOrReplaceChild("TailHead1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-7.0F, -0.2F, -5.6F, 14.0F, 8.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, -9.5F, 4.0F, 0.17453292519943295F, 0.0F, 0.0F));

        tailHead1.addOrReplaceChild("TailHead2",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-7.0F, 0.0F, 0.0F, 14.0F, 8.0F, 11.0F),
                PartPose.offset(0.0F, -1.0F, 4.5F));

        headBase.addOrReplaceChild("TailHeadCR1",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-1.0F, 0.0F, -3.0F, 2.0F, 11.0F, 6.0F),
                PartPose.offsetAndRotation(-6.0F, -5.0F, 12.0F, 0.0F, -0.05235987755982988F, 0.0F));

        headBase.addOrReplaceChild("TailJaw1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-6.5F, 0.0F, 0.0F, 13.0F, 5.0F, 14.0F),
                PartPose.offsetAndRotation(0.0F, 3.0F, 5.0F, -0.27314402793711257F, 0.0F, 0.0F));

        headBase.addOrReplaceChild("TailHeadCL1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, 0.0F, -3.0F, 2.0F, 11.0F, 6.0F),
                PartPose.offsetAndRotation(6.0F, -5.0F, 12.0F, 0.0F, 0.05235987755982988F, 0.0F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().texOffs(2, 100)
                        .addBox(-3.0F, -1.0F, -2.0F, 4.0F, 5.0F, 4.0F),
                PartPose.offsetAndRotation(-6.0F, -9.8F, -0.7F, 0.2617993877991494F, 0.0F,
                        0.5235987755982988F));

        PartDefinition armRight02 = armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().texOffs(2, 100)
                        .addBox(-2.0F, 0.0F, -4.0F, 4.0F, 4.0F, 4.0F),
                PartPose.offset(-1.0F, 4.0F, 2.0F));

        PartDefinition armRight03 = armRight02.addOrReplaceChild("ArmRight03",
                CubeListBuilder.create().texOffs(0, 90)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F),
                PartPose.offset(0.0F, 1.0F, -2.0F));

        PartDefinition armRight04 = armRight03.addOrReplaceChild("ArmRight04",
                CubeListBuilder.create().texOffs(72, 43)
                        .addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 8.0F),
                PartPose.offset(0.0F, 3.0F, 0.0F));

        PartDefinition armRight05 = armRight04.addOrReplaceChild("ArmRight05",
                CubeListBuilder.create().texOffs(20, 100)
                        .addBox(-3.0F, 0.0F, -3.5F, 6.0F, 7.0F, 7.0F),
                PartPose.offset(0.0F, 2.0F, 0.0F));

        armRight05.addOrReplaceChild("ArmRightItem",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        armRight05.addOrReplaceChild("ArmRight06",
                CubeListBuilder.create().texOffs(20, 100)
                        .addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(2.0F, 1.0F, -1.5F, -0.08726646259971647F,
                        -0.08726646259971647F, -0.17453292519943295F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().mirror().texOffs(2, 100)
                        .addBox(-1.0F, -1.0F, -2.0F, 4.0F, 5.0F, 4.0F),
                PartPose.offsetAndRotation(6.0F, -9.8F, -0.7F, -0.27314402793711257F, 0.0F,
                        -0.5235987755982988F));

        PartDefinition armLeft02 = armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().mirror().texOffs(2, 100)
                        .addBox(-2.0F, 0.0F, -4.0F, 4.0F, 4.0F, 4.0F),
                PartPose.offset(1.0F, 4.0F, 2.0F));

        PartDefinition armLeft03 = armLeft02.addOrReplaceChild("ArmLeft03",
                CubeListBuilder.create().texOffs(0, 90)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F),
                PartPose.offset(0.0F, 1.0F, -2.0F));

        PartDefinition armLeft04 = armLeft03.addOrReplaceChild("ArmLeft04",
                CubeListBuilder.create().texOffs(72, 43)
                        .addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 8.0F),
                PartPose.offset(0.0F, 3.0F, 0.0F));

        PartDefinition armLeft05 = armLeft04.addOrReplaceChild("ArmLeft05",
                CubeListBuilder.create().texOffs(20, 100)
                        .addBox(-3.0F, 0.0F, -3.5F, 6.0F, 7.0F, 7.0F),
                PartPose.offset(0.0F, 2.0F, 0.0F));

        armLeft05.addOrReplaceChild("ArmLeft06",
                CubeListBuilder.create().texOffs(20, 100)
                        .addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(-2.0F, 1.0F, -1.5F, -0.08726646259971647F,
                        0.08726646259971647F, 0.17453292519943295F));

        PartDefinition equipUmbre01a = armLeft05.addOrReplaceChild("EquipUmbre01a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 12.0F),
                PartPose.offset(-1.0F, 4.0F, -1.0F));

        PartDefinition equipUmbre01b = equipUmbre01a.addOrReplaceChild("EquipUmbre01b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, -12.0F, 2.0F, 2.0F, 12.0F),
                PartPose.offset(0.0F, 0.0F, -6.0F));

        PartDefinition equipUmbre01c = equipUmbre01b.addOrReplaceChild("EquipUmbre01c",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, -12.0F, 2.0F, 2.0F, 12.0F),
                PartPose.offset(0.0F, 0.0F, -12.0F));

        PartDefinition equipUmbre03a = equipUmbre01c.addOrReplaceChild("EquipUmbre03a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, -7.0F, 0.0F, 13.0F, 17.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -14.4F, 0.0F, -0.2617993877991494F,
                        0.36425021489121656F));

        equipUmbre03a.addOrReplaceChild("EquipUmbre03b",
                CubeListBuilder.create().texOffs(54, 0)
                        .addBox(-2.0F, -6.0F, 0.0F, 5.0F, 12.0F, 11.0F),
                PartPose.offsetAndRotation(1.5F, 2.0F, 2.9F, -0.091106186954104F, 0.6829473363053812F,
                        0.136659280431156F));

        PartDefinition equipUmbre02a = equipUmbre01c.addOrReplaceChild("EquipUmbre02a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-16.0F, -9.0F, -2.0F, 20.0F, 18.0F, 3.0F),
                PartPose.offsetAndRotation(-3.0F, 0.0F, -12.0F, 0.0F, 0.17453292519943295F,
                        0.5235987755982988F));

        equipUmbre02a.addOrReplaceChild("EquipUmbre02b",
                CubeListBuilder.create().texOffs(54, 0)
                        .addBox(-11.0F, -8.0F, 0.0F, 13.0F, 16.0F, 5.0F),
                PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, -0.05235987755982988F,
                        -0.08726646259971647F, 0.0F));

        equipUmbre01a.addOrReplaceChild("EquipUmbre02",
                CubeListBuilder.create().texOffs(38, 57)
                        .addBox(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 5.0F),
                PartPose.offset(0.0F, 0.0F, 6.0F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 2.0F, 0.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -11.3F, -0.5F));

        PartDefinition glowHead = glowNeck.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -1.5F, 0.0F));
        addDefaultFaceParts(glowHead);

        PartDefinition glowEquipBase = glowBodyMain.addOrReplaceChild("GlowEquipBase",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition glowEquipRT01 = glowEquipBase.addOrReplaceChild("GlowEquipRT01",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 4.0F, 4.0F));

        PartDefinition glowEquipRT02 = glowEquipRT01.addOrReplaceChild("GlowEquipRT02",
                CubeListBuilder.create(),
                PartPose.offset(-16.0F, 0.0F, 2.0F));

        PartDefinition glowHeadBase = glowEquipRT02.addOrReplaceChild("GlowHeadBase",
                CubeListBuilder.create(),
                PartPose.offset(-14.0F, -3.0F, 0.0F));

        PartDefinition glowTailHead1 = glowHeadBase.addOrReplaceChild("GlowTailHead1",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -9.5F, 4.0F));

        PartDefinition glowTailHead2 = glowTailHead1.addOrReplaceChild("GlowTailHead2",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -1.0F, 4.5F));

        PartDefinition glowTailJaw1 = glowHeadBase.addOrReplaceChild("GlowTailJaw1",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 3.0F, 5.0F));

        PartDefinition glowEquipLT01 = glowEquipBase.addOrReplaceChild("GlowEquipLT01",
                CubeListBuilder.create(),
                PartPose.offset(2.0F, 4.0F, 2.5F));

        PartDefinition glowEquipLT02 = glowEquipLT01.addOrReplaceChild("GlowEquipLT02",
                CubeListBuilder.create(),
                PartPose.offset(6.0F, 0.0F, 0.0F));

        PartDefinition glowEquipLT03 = glowEquipLT02.addOrReplaceChild("GlowEquipLT03",
                CubeListBuilder.create(),
                PartPose.offset(6.0F, 0.0F, 0.0F));

        PartDefinition glowEquipLT04 = glowEquipLT03.addOrReplaceChild("GlowEquipLT04",
                CubeListBuilder.create(),
                PartPose.offset(6.0F, 0.0F, 0.0F));

        PartDefinition glowEquipLT05 = glowEquipLT04.addOrReplaceChild("GlowEquipLT05",
                CubeListBuilder.create(),
                PartPose.offset(6.0F, 0.0F, 0.0F));

        PartDefinition glowEquipLT06 = glowEquipLT05.addOrReplaceChild("GlowEquipLT06",
                CubeListBuilder.create(),
                PartPose.offset(6.0F, 0.0F, 0.0F));

        // Horn glow parts - left horn chain
        PartDefinition glowHeadHL = glowHead.addOrReplaceChild("HeadHL",
                CubeListBuilder.create().mirror().texOffs(30, 90)
                        .addBox(0.0F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(5.9F, -10.9F, 1.0F, -0.7853981633974483F,
                        -0.17453292519943295F, -0.3141592653589793F));

        PartDefinition glowHeadHL2 = glowHeadHL.addOrReplaceChild("HeadHL2",
                CubeListBuilder.create().texOffs(30, 90)
                        .addBox(0.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F),
                PartPose.offset(3.0F, 0.0F, 0.0F));

        glowHeadHL2.addOrReplaceChild("HeadHL3",
                CubeListBuilder.create().texOffs(30, 90)
                        .addBox(0.0F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F),
                PartPose.offset(1.0F, 0.0F, 0.0F));

        // Horn glow parts - right horn chain
        PartDefinition glowHeadHR = glowHead.addOrReplaceChild("HeadHR",
                CubeListBuilder.create().mirror().texOffs(30, 90)
                        .addBox(-3.0F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(-5.9F, -10.8F, 1.0F, -0.7853981633974483F,
                        0.17453292519943295F, 0.3141592653589793F));

        PartDefinition glowHeadHR2 = glowHeadHR.addOrReplaceChild("HeadHR2",
                CubeListBuilder.create().texOffs(30, 90)
                        .addBox(-1.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F),
                PartPose.offset(-3.0F, 0.0F, 0.0F));

        glowHeadHR2.addOrReplaceChild("HeadHR3",
                CubeListBuilder.create().texOffs(30, 90)
                        .addBox(-1.0F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F),
                PartPose.offset(-1.0F, 0.0F, 0.0F));

        // Tail head top part
        glowTailHead1.addOrReplaceChild("TailHeadT01",
                CubeListBuilder.create().texOffs(0, 55)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 4.5F, 4.5F, -0.17453292519943295F, 0.0F, 0.0F));

        // Tail jaw top part
        glowTailJaw1.addOrReplaceChild("TailJawT01",
                CubeListBuilder.create().texOffs(0, 56)
                        .addBox(-5.5F, 0.0F, 0.0F, 11.0F, 5.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, -3.0F, 4.0F, 0.17453292519943295F, 0.0F, 0.0F));

        // Tail head cheek parts
        glowTailHead2.addOrReplaceChild("TailHeadC2",
                CubeListBuilder.create().texOffs(0, 13)
                        .addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 10.0F),
                PartPose.offsetAndRotation(3.2F, 3.2F, 10.5F, 0.08726646259971647F,
                        0.08726646259971647F, 0.017627825445142728F));

        glowTailHead2.addOrReplaceChild("TailHeadC3",
                CubeListBuilder.create().texOffs(0, 13)
                        .addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 10.0F),
                PartPose.offsetAndRotation(-3.2F, 3.2F, 10.5F, 0.08726646259971647F,
                        -0.08726646259971647F, 0.0F));

        // Equipment road parts
        PartDefinition equipRoad01 = glowHeadBase.addOrReplaceChild("EquipRoad01",
                CubeListBuilder.create().texOffs(46, 41)
                        .addBox(0.0F, 0.0F, 0.0F, 7.0F, 2.0F, 12.0F),
                PartPose.offsetAndRotation(6.0F, -11.5F, -3.0F, -0.20943951023931953F,
                        0.08726646259971647F, 0.0F));

        PartDefinition equipRoad02 = equipRoad01.addOrReplaceChild("EquipRoad02",
                CubeListBuilder.create().texOffs(46, 41)
                        .addBox(0.0F, 0.0F, 0.0F, 7.0F, 2.0F, 12.0F),
                PartPose.offset(0.0F, 0.0F, 12.0F));

        equipRoad02.addOrReplaceChild("EquipRoad03",
                CubeListBuilder.create().texOffs(46, 41)
                        .addBox(0.0F, 0.0F, 0.0F, 7.0F, 2.0F, 12.0F),
                PartPose.offset(0.0F, 0.0F, 12.0F));

        // Equipment left head parts
        PartDefinition equipLHead = glowEquipLT06.addOrReplaceChild("EquipLHead",
                CubeListBuilder.create().texOffs(0, 29)
                        .addBox(0.0F, -3.5F, -5.0F, 10.0F, 7.0F, 9.0F),
                PartPose.offsetAndRotation(5.0F, 0.0F, -1.0F, 0.0F, -0.6981317007977318F,
                        -0.17453292519943295F));

        PartDefinition equipLHead01 = equipLHead.addOrReplaceChild("EquipLHead01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-12.0F, -1.0F, 0.0F, 12.0F, 2.0F, 0.0F),
                PartPose.offsetAndRotation(4.0F, 0.0F, -4.0F, 0.0F, -0.5235987755982988F,
                        -0.3490658503988659F));

        PartDefinition equipLHead02 = equipLHead01.addOrReplaceChild("EquipLHead02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-12.0F, -1.0F, 0.0F, 12.0F, 2.0F, 0.0F),
                PartPose.offsetAndRotation(-11.5F, 0.0F, 0.0F, 0.0F, 0.5235987755982988F,
                        -0.2617993877991494F));

        equipLHead02.addOrReplaceChild("EquipLHead03",
                CubeListBuilder.create().texOffs(24, 48)
                        .addBox(-5.0F, -1.5F, -1.0F, 6.0F, 3.0F, 2.0F),
                PartPose.offsetAndRotation(-11.5F, 0.0F, 0.0F, 0.0F, 0.31869712141416456F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 128);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                          float headPitch) {
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

        int state = ent.getStateEmotion(ID.S.State);

        boolean flag = !EmotionHelper.checkModelState(0, state); // cannon
        this.GlowEquipBase.visible = !flag;
        this.EquipBase.visible = !flag;

        flag = !EmotionHelper.checkModelState(1, state); // hat
        this.SantaCloth01.visible = !flag;
        this.SantaHat01.visible = !flag;

        flag = !EmotionHelper.checkModelState(2, state); // umbrella
        this.EquipUmbre01a.visible = !flag;

        flag = !EmotionHelper.checkModelState(3, state); // leg equip
        this.ShoesL.visible = !flag;
        this.ShoesL2.visible = !flag;
        this.ShoesR.visible = !flag;
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
        this.GlowEquipBase.xRot = this.EquipBase.xRot;
        this.GlowTailJaw1.xRot = this.TailJaw1.xRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += 0.24F;
        this.setFaceHungry(ent);

        // 移動頭部使其看人
        this.Head.xRot = 0.5F; // 上下角度
        this.Head.yRot = 0F; // 左右角度 角度轉成rad 即除以57.29578
        // body
        this.BodyMain.xRot = -0.087F;
        // hair
        this.Hair01.xRot = 0.2F;
        this.Hair02.xRot = -0.3F;
        this.HairL01.xRot = -0.26F;
        this.HairL02.xRot = 0.26F;
        this.HairR01.xRot = -0.26F;
        this.HairR02.xRot = 0.26F;
        // arm
        this.ArmLeft01.xRot = 0.2618F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = -0.57F;
        this.ArmLeft02.xRot = 0F;
        // this.ArmLeft02.offsetY = 0F;
        // this.ArmLeft02.offsetZ = 0F;
        this.ArmLeft04.yRot = 0F;
        this.ArmRight01.xRot = 0.2618F;
        this.ArmRight01.zRot = 0.57F;
        this.ArmRight02.xRot = 0F;
        // leg
        this.LegLeft01.xRot = -1.66F;
        this.LegLeft01.yRot = -0.2618F;
        this.LegLeft01.zRot = -0.05F;
        this.LegLeft02.xRot = 0F;
        this.LegRight01.xRot = -1.66F;
        this.LegRight01.yRot = 0.2618F;
        this.LegRight01.zRot = 0.05F;
        this.LegRight02.xRot = 0F;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float angleX = Mth.cos(f2 * 0.08F);
        float angleAdd1 = Mth.cos(f * 0.7F) * f1;
        float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
        float addk1;
        float addk2;
        float headX;
        float headZ;
        int state = ent.getStateEmotion(ID.S.State);
        boolean showCannon = EmotionHelper.checkModelState(0, state);
        boolean showUmbrella = EmotionHelper.checkModelState(2, state);

        // 水上漂浮
        if (ent.getShipDepth(0) > 0D || ent.getShipDepth(1) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        // leg move parm
        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += angleX * 0.05F + 0.025F;
        addk1 = angleAdd1 - 0.1745F;
        addk2 = angleAdd2 - 0.1745F;

        // 移動頭部使其看人
        this.Head.xRot = f4 * 0.014F; // 上下角度
        this.Head.yRot = f3 * 0.01F; // 左右角度
        headX = this.Head.xRot * -0.5F;
        // 正常站立動作
        // body
        this.Ahoke.xRot = angleX * 0.25F + 0.35F;
        this.BodyMain.xRot = -0.087F;
        // hair
        this.Hair01.xRot = angleX * 0.02F + 0.35F + headX;
        this.Hair02.xRot = angleX * 0.04F + 0.14F + headX;
        this.HairL01.xRot = angleX * 0.02F + headX - 0.26F;
        this.HairL02.xRot = angleX * 0.02F + headX + 0.26F;
        this.HairR01.xRot = angleX * 0.02F + headX - 0.26F;
        this.HairR02.xRot = angleX * 0.02F + headX + 0.26F;
        // arm
        this.ArmLeft01.xRot = angleAdd2 + 0.2618F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = -angleX * 0.1F - 0.5235F;
        this.ArmLeft02.xRot = 0F;
        // this.ArmLeft02.offsetY = 0F;
        // this.ArmLeft02.offsetZ = 0F;
        this.ArmLeft04.yRot = 0F;
        this.ArmRight01.xRot = angleAdd1 + 0.2618F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = angleX * 0.1F + 0.5235F;
        this.ArmRight02.xRot = 0F;
        this.ArmRight04.yRot = 0F;
        // leg
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = -0.05F;
        this.LegLeft02.xRot = 0F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = 0.05F;
        this.LegRight02.xRot = 0F;
        // equip
        if (showCannon) {
            this.EquipBase.xRot = 0F;
            this.TailJaw1.xRot = angleX * 0.08F - 0.15F;
            if (this.TailHeadC2 != null)
                this.TailHeadC2.xRot = angleX * 0.12F;
            if (this.TailHeadC3 != null)
                this.TailHeadC3.xRot = -angleX * 0.08F + 0.1F;
            if (this.EquipLHead01 != null)
                this.EquipLHead01.yRot = angleX * 0.1F - 0.5F;
            if (this.EquipLHead01 != null)
                this.EquipLHead01.zRot = -angleX * 0.1F - 0.1F;
            if (this.EquipLHead02 != null)
                this.EquipLHead02.yRot = angleX * 0.3F + 0.1F;
            if (this.EquipLHead02 != null)
                this.EquipLHead02.zRot = -angleX * 0.3F;
        }
        // umbrella
        if (showUmbrella) {
            this.ArmLeft01.xRot = 0F;
            this.ArmLeft01.yRot = -0.26F;
            this.ArmLeft01.zRot = -0.52F;
            // this.ArmLeft02.offsetY = 0.25F;
            this.ArmLeft02.xRot = -1.57F;
            this.ArmLeft04.yRot = -0.52F;
            this.EquipUmbre03b.yRot = angleX * 0.3F + 0.7F;
        }

        if (ent.getIsSprinting() || f1 > 0.9F) { // 奔跑動作
            setFace(3);
            // arm
            this.ArmLeft01.zRot = -1F;
            this.ArmRight01.xRot = -2.9F;
            this.ArmRight01.zRot = -0.7F;

            if (showUmbrella) {
                this.ArmLeft04.yRot = -1F;
            }
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
            // body
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.02F;
            this.Head.xRot -= 0.8727F;
            this.BodyMain.xRot = 1.0472F;
            // hair
            this.Hair01.xRot += 0.2236F;
            // leg
            addk1 -= 1.2F;
            addk2 -= 1.2F;
            // equip
            this.EquipBase.xRot -= 0.8727F;

            if (showUmbrella) {
                this.ArmLeft01.yRot = -1.05F;
                this.ArmLeft02.xRot = -2.01F;
                this.ArmLeft04.yRot = -1.05F;
            }
        } // end if sneaking

        if (ent.getIsSitting() && !ent.getIsRiding()) { // 坐下動作

            // body
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.24F;
            this.Head.yRot *= 0.25F;

            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                // body
                this.Head.xRot -= 0.15F;
                this.BodyMain.xRot = -0.3142F;
                // arm
                this.ArmLeft01.xRot = -2F;
                this.ArmLeft01.yRot = -0.35F;
                this.ArmLeft01.zRot = 0.35F;
                this.ArmRight01.xRot = -2.9F;
                this.ArmRight01.yRot = 0.35F;
                this.ArmRight01.zRot = -0.35F;
                // leg
                addk1 = -1.4F;
                addk2 = -1.4F;
                this.LegLeft01.yRot = -0.2618F;
                this.LegRight01.yRot = 0.2618F;

                // this.ArmLeft02.offsetY = 0F;
                this.ArmLeft02.xRot = 0F;
                this.ArmLeft04.yRot = 0F;
            } else {
                // arm
                this.ArmLeft01.zRot -= 0.05F;
                this.ArmRight01.zRot += 0.05F;
                // leg
                addk1 = -1.66F;
                addk2 = -1.66F;
                this.LegLeft01.yRot = -0.2618F;
                this.LegRight01.yRot = 0.2618F;
                // this.ArmLeft02.offsetY = 0F;
            }
        } // end if sitting

        if (ent.getIsRiding()) { // 騎乘動作

            if (ent.getIsSitting()) {
                // arm
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.24F;
                this.offsetZ += 0.27F;
                this.ArmLeft01.xRot = -0.8F;
                this.ArmLeft01.zRot = -0.35F;
                this.ArmRight01.xRot = -0.8F;
                this.ArmRight01.zRot = 0.35F;
                // leg
                addk1 = -1.66F;
                addk2 = -1.66F;
                this.LegLeft01.yRot = -0.5F;
                this.LegRight01.yRot = 0.5F;

                if (showUmbrella) {
                    // this.ArmLeft02.offsetY = 0F;
                    this.ArmLeft02.xRot = -0.8F;
                    this.ArmLeft04.yRot = -0.4F;
                }
            } else {
                setFace(3);
                // head
                this.Head.xRot -= 0.25F;
                // arm
                this.ArmLeft01.xRot = -1.2F;
                this.ArmLeft01.yRot = -0.2F;
                this.ArmLeft01.zRot = -0.2F;
                this.ArmRight01.xRot = -2.53F;
                this.ArmRight01.zRot = -0.7F;
                // leg
                addk1 = -1.66F;
                addk2 = -1.66F;
                this.LegLeft01.yRot = -0.5F;
                this.LegRight01.yRot = 0.5F;

                if (showUmbrella) {
                    // this.ArmLeft02.offsetY = 0F;
                    this.ArmLeft02.xRot = -0.2F;
                    this.ArmLeft04.yRot = -0.4F;
                }
            }
        } // end if riding

        // 攻擊動作
        if (ent.getAttackTick() > 49) {
            this.ArmRight01.xRot = -3.5F;
            this.ArmRight01.yRot = 0F;
            this.ArmRight01.zRot = -0.35F;
            this.ArmRight04.yRot = -1.57F;
        } else if (ent.getAttackTick() > 46) {
            this.ArmRight01.xRot = (46F - ent.getAttackTick() + (f2 - (int) f2)) * 0.75F - 0.5F;
            this.ArmRight01.yRot = 0F;
            this.ArmRight01.zRot = -0.35F;
            this.ArmRight04.yRot = -1.57F;
        } else if (ent.getAttackTick() > 35) {
            this.ArmRight01.xRot = -0.5F;
            this.ArmRight01.yRot = 0F;
            this.ArmRight01.zRot = 0.5F;
            this.ArmRight04.yRot = -1.57F;
        }

        // leg motion
        this.LegLeft01.xRot = addk1;
        this.LegRight01.xRot = addk2;
    }
}
