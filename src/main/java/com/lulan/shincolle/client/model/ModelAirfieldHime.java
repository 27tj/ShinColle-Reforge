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

public class ModelAirfieldHime extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "airfield_hime"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Neck;
    private final ModelPart BoobR;
    private final ModelPart BoobL;
    private final ModelPart ArmLeft01;
    private final ModelPart ArmRight01;
    private final ModelPart Butt;
    private final ModelPart Head;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart HeadHL;
    private final ModelPart HeadHR;
    private final ModelPart Ahoke;
    private final ModelPart HairL01;
    private final ModelPart HairR01;
    private final ModelPart HairL02;
    private final ModelPart HairR02;
    private final ModelPart Hair01;
    private final ModelPart Hair02;
    private final ModelPart Hair03;
    private final ModelPart HeadHL2;
    private final ModelPart HeadHL3;
    private final ModelPart HeadHR2;
    private final ModelPart HeadHR3;
    private final ModelPart ArmLeft02;
    private final ModelPart EquipHand01;
    private final ModelPart ArmRight02;
    private final ModelPart EquipHand02;
    private final ModelPart LegRight01;
    private final ModelPart LegLeft01;
    private final ModelPart LegRight02;
    private final ModelPart ShoesR;
    private final ModelPart LegLeft02;
    private final ModelPart ShoesL;
    private final ModelPart EquipRdL01;
    private final ModelPart EquipRdR01;
    private final ModelPart EquipRdL02;
    private final ModelPart EquipRdL03;
    private final ModelPart EquipRdL04;
    private final ModelPart EquipRdL05;
    private final ModelPart EquipRdL06;
    private final ModelPart EquipRdR02;
    private final ModelPart EquipRdR03;
    private final ModelPart EquipRdR04;
    private final ModelPart EquipRdR05;
    private final ModelPart EquipRdR06;
    private final ModelPart GlowEquipBase;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowNeck;
    private final ModelPart GlowHead;

    public ModelAirfieldHime(ModelPart root) {
        super();
        this.scale = 0.47F;
        this.offsetY = 1.75F;
        this.BodyMain = root.getChild("BodyMain");
        this.BoobR = this.BodyMain.getChild("BoobR");
        this.BoobL = this.BodyMain.getChild("BoobL");
        this.Butt = this.BodyMain.getChild("Butt");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.Neck = this.BodyMain.getChild("Neck");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.LegLeft01 = this.Butt.getChild("LegLeft01");
        this.LegRight01 = this.Butt.getChild("LegRight01");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.EquipHand01 = this.ArmRight01.getChild("EquipHand01");
        this.Head = this.Neck.getChild("Head");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.EquipHand02 = this.ArmRight02.getChild("EquipHand02");
        this.HairMain = this.Head.getChild("HairMain");
        this.Hair = this.Head.getChild("Hair");
        this.ShoesL = this.LegLeft02.getChild("ShoesL");
        this.ShoesR = this.LegRight02.getChild("ShoesR");
        this.Hair01 = this.HairMain.getChild("Hair01");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.HairR01 = this.Hair.getChild("HairR01");
        this.HairL01 = this.Hair.getChild("HairL01");
        this.Hair02 = this.Hair01.getChild("Hair02");
        this.HairR02 = this.HairR01.getChild("HairR02");
        this.HairL02 = this.HairL01.getChild("HairL02");
        this.Hair03 = this.Hair02.getChild("Hair03");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowNeck = this.GlowBodyMain.getChild("GlowNeck");
        this.GlowEquipBase = this.GlowBodyMain.getChild("GlowEquipBase");
        this.GlowHead = this.GlowNeck.getChild("GlowHead");
        this.HeadHL = this.GlowHead.getChild("HeadHL");
        this.HeadHL2 = this.HeadHL.getChild("HeadHL2");
        this.HeadHL3 = this.HeadHL2.getChild("HeadHL3");
        this.HeadHR = this.GlowHead.getChild("HeadHR");
        this.HeadHR2 = this.HeadHR.getChild("HeadHR2");
        this.HeadHR3 = this.HeadHR2.getChild("HeadHR3");
        this.EquipRdL01 = this.GlowEquipBase.getChild("EquipRdL01");
        this.EquipRdL02 = this.EquipRdL01.getChild("EquipRdL02");
        this.EquipRdL03 = this.EquipRdL02.getChild("EquipRdL03");
        this.EquipRdL04 = this.EquipRdL03.getChild("EquipRdL04");
        this.EquipRdL05 = this.EquipRdL04.getChild("EquipRdL05");
        this.EquipRdL06 = this.EquipRdL05.getChild("EquipRdL06");
        this.EquipRdR01 = this.GlowEquipBase.getChild("EquipRdR01");
        this.EquipRdR02 = this.EquipRdR01.getChild("EquipRdR02");
        this.EquipRdR03 = this.EquipRdR02.getChild("EquipRdR03");
        this.EquipRdR04 = this.EquipRdR03.getChild("EquipRdR04");
        this.EquipRdR05 = this.EquipRdR04.getChild("EquipRdR05");
        this.EquipRdR06 = this.EquipRdR05.getChild("EquipRdR06");
        this.loadFaceParts(this.GlowHead);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 104)
                        .addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.17453292519943295F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("BoobR",
                CubeListBuilder.create().texOffs(33, 101)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(-3.7F, -8.6F, -3.5F, -0.6981317007977318F, -0.13962634015954636F,
                        -0.08726646259971647F));

        bodyMain.addOrReplaceChild("BoobL",
                CubeListBuilder.create().mirror().texOffs(33, 101)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(3.7F, -8.6F, -3.5F, -0.6981317007977318F, 0.13962634015954636F,
                        0.08726646259971647F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(39, 0)
                        .addBox(-7.5F, 4.0F, -5.7F, 15.0F, 8.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3141592653589793F, 0.0F, 0.0F));

        PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().mirror().texOffs(0, 84)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(4.7F, 9.5F, -2.6F, 0.0F, 0.0F, 0.14F));

        PartDefinition legLeft02 = legLeft01.addOrReplaceChild("LegLeft02",
                CubeListBuilder.create().mirror().texOffs(0, 84)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 7.0F, 6.0F),
                PartPose.offset(0.0F, 14.0F, -3.0F));

        legLeft02.addOrReplaceChild("ShoesL",
                CubeListBuilder.create().mirror().texOffs(87, 0)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 8.0F, 7.0F),
                PartPose.offset(0.0F, 7.0F, 3.0F));

        PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().texOffs(0, 84)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(-4.7F, 9.5F, -2.6F, -0.10471975511965977F, 0.0F, -0.14F));

        PartDefinition legRight02 = legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().texOffs(0, 84)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 7.0F, 6.0F),
                PartPose.offset(0.0F, 14.0F, -3.0F));

        legRight02.addOrReplaceChild("ShoesR",
                CubeListBuilder.create().texOffs(87, 0)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 8.0F, 7.0F),
                PartPose.offset(0.0F, 7.0F, 3.0F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().texOffs(2, 85)
                        .addBox(-3.0F, -1.0F, -2.5F, 5.0F, 13.0F, 5.0F),
                PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, 0.20943951023931953F, 0.0F, 0.20943951023931953F));

        PartDefinition armRight02 = armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().texOffs(24, 83)
                        .addBox(0.0F, 0.0F, -5.0F, 5.0F, 13.0F, 5.0F),
                PartPose.offset(-3.0F, 12.0F, 2.5F));

        armRight02.addOrReplaceChild("EquipHand02",
                CubeListBuilder.create().texOffs(0, 17)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offset(2.5F, -0.5F, -2.5F));

        armRight01.addOrReplaceChild("EquipHand01",
                CubeListBuilder.create().texOffs(0, 17)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 5.0F, 6.0F),
                PartPose.offset(-0.5F, 7.5F, 0.0F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(88, 26)
                        .addBox(-5.5F, -2.0F, -5.0F, 11.0F, 3.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, -10.3F, -0.5F, 0.20943951023931953F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offset(0.0F, -1.5F, 0.0F));

        PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(48, 55)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 12.0F, 10.0F),
                PartPose.offset(0.0F, -15.0F, -3.0F));

        PartDefinition hair01 = hairMain.addOrReplaceChild("Hair01",
                CubeListBuilder.create().texOffs(46, 29)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 17.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 9.0F, 1.0F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition hair02 = hair01.addOrReplaceChild("Hair02",
                CubeListBuilder.create().texOffs(0, 59)
                        .addBox(-8.0F, 0.0F, -5.0F, 16.0F, 16.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 13.5F, 5.5F, -0.08726646259971647F, 0.0F, 0.0F));

        hair02.addOrReplaceChild("Hair03",
                CubeListBuilder.create().texOffs(0, 37)
                        .addBox(-8.0F, 0.0F, -4.5F, 16.0F, 15.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 12.5F, -0.1F, -0.13962634015954636F, 0.0F, 0.0F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(45, 77)
                        .addBox(-8.0F, -8.0F, -7.2F, 16.0F, 16.0F, 8.0F),
                PartPose.offset(0.0F, -7.5F, 0.0F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(104, 29)
                        .addBox(0.0F, -4.0F, -11.5F, 0.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -10.5F, -5.0F, 0.0F, 0.5235987755982988F, 0.0F));

        PartDefinition hairR01 = hair.addOrReplaceChild("HairR01",
                CubeListBuilder.create().mirror().texOffs(25, 18)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(-6.5F, 3.0F, -3.0F, -0.2617993877991494F, 0.17453292519943295F,
                        0.13962634015954636F));

        hairR01.addOrReplaceChild("HairR02",
                CubeListBuilder.create().mirror().texOffs(25, 18)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(0.2F, 10.0F, 0.0F, 0.2617993877991494F, 0.0F, -0.05235987755982988F));

        PartDefinition hairL01 = hair.addOrReplaceChild("HairL01",
                CubeListBuilder.create().texOffs(25, 18)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(6.5F, 3.0F, -3.0F, -0.2617993877991494F, -0.17453292519943295F,
                        -0.13962634015954636F));

        hairL01.addOrReplaceChild("HairL02",
                CubeListBuilder.create().texOffs(25, 18)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.2617993877991494F, 0.0F, 0.08726646259971647F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().mirror().texOffs(2, 85)
                        .addBox(-2.0F, -1.0F, -2.5F, 5.0F, 13.0F, 5.0F),
                PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.20943951023931953F, 0.0F, -0.20943951023931953F));

        armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().mirror().texOffs(24, 83)
                        .addBox(-5.0F, 0.0F, -5.0F, 5.0F, 13.0F, 5.0F),
                PartPose.offset(3.0F, 12.0F, 2.5F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -15.0F, 0.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -10.3F, -0.5F));

        PartDefinition glowHead = glowNeck.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -1.5F, 0.0F));
        addDefaultFaceParts(glowHead);

        PartDefinition glowEquipBase = glowBodyMain.addOrReplaceChild("GlowEquipBase",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        // Horn glow parts - left horn chain
        PartDefinition glowHeadHL = glowHead.addOrReplaceChild("HeadHL",
                CubeListBuilder.create().mirror().texOffs(39, 28)
                        .addBox(0.0F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(6.4F, -10.6F, 0.8F, -0.7853981633974483F, -0.17453292519943295F,
                        -0.3141592653589793F));

        PartDefinition glowHeadHL2 = glowHeadHL.addOrReplaceChild("HeadHL2",
                CubeListBuilder.create().texOffs(47, 56)
                        .addBox(0.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F),
                PartPose.offset(3.0F, 0.0F, 0.0F));

        glowHeadHL2.addOrReplaceChild("HeadHL3",
                CubeListBuilder.create().texOffs(43, 30)
                        .addBox(0.0F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F),
                PartPose.offset(1.0F, 0.0F, 0.0F));

        // Horn glow parts - right horn chain
        PartDefinition glowHeadHR = glowHead.addOrReplaceChild("HeadHR",
                CubeListBuilder.create().mirror().texOffs(39, 28)
                        .addBox(-3.0F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(-6.4F, -10.6F, 0.8F, -0.7853981633974483F, 0.17453292519943295F,
                        0.3141592653589793F));

        PartDefinition glowHeadHR2 = glowHeadHR.addOrReplaceChild("HeadHR2",
                CubeListBuilder.create().texOffs(47, 56)
                        .addBox(-1.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F),
                PartPose.offset(-3.0F, 0.0F, 0.0F));

        glowHeadHR2.addOrReplaceChild("HeadHR3",
                CubeListBuilder.create().texOffs(43, 30)
                        .addBox(-1.0F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F),
                PartPose.offset(-1.0F, 0.0F, 0.0F));

        // Runway glow parts - left runway chain
        PartDefinition equipRdL01 = glowEquipBase.addOrReplaceChild("EquipRdL01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F),
                PartPose.offsetAndRotation(5.0F, 0.0F, 6.0F, 1.4F, -0.3490658503988659F, -0.3490658503988659F));

        PartDefinition equipRdL02 = equipRdL01.addOrReplaceChild("EquipRdL02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.3490658503988659F, 0.0F, 0.0F));

        PartDefinition equipRdL03 = equipRdL02.addOrReplaceChild("EquipRdL03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition equipRdL04 = equipRdL03.addOrReplaceChild("EquipRdL04",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition equipRdL05 = equipRdL04.addOrReplaceChild("EquipRdL05",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.2618F, 0.0F, 0.0F));

        equipRdL05.addOrReplaceChild("EquipRdL06",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.1745F, 0.0F, 0.0F));

        // Runway glow parts - right runway chain
        PartDefinition equipRdR01 = glowEquipBase.addOrReplaceChild("EquipRdR01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F),
                PartPose.offsetAndRotation(-5.0F, 0.0F, 6.0F, 1.4F, 0.3490658503988659F, 0.3490658503988659F));

        PartDefinition equipRdR02 = equipRdR01.addOrReplaceChild("EquipRdR02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.3490658503988659F, 0.0F, 0.0F));

        PartDefinition equipRdR03 = equipRdR02.addOrReplaceChild("EquipRdR03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition equipRdR04 = equipRdR03.addOrReplaceChild("EquipRdR04",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition equipRdR05 = equipRdR04.addOrReplaceChild("EquipRdR05",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.2618F, 0.0F, 0.0F));

        equipRdR05.addOrReplaceChild("EquipRdR06",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.1745F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
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

        boolean flag = !EmotionHelper.checkModelState(1, state);
        this.EquipHand01.visible = !flag;
        this.EquipHand02.visible = !flag;
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

        float addk1;
        float addk2;
        float headX;
        float headZ;
        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += 0.55F;
        this.setFaceHungry(ent);

        // 移動頭部使其看人
        this.Head.xRot = 0F; // 左右角度
        this.Head.yRot = 0F;
        this.Head.zRot = 0F;
        headX = this.Head.xRot * -0.5F;
        // 正常站立動作
        // 胸部
        this.BoobL.xRot = -0.7F;
        this.BoobR.xRot = -0.7F;
        // Body
        this.Ahoke.yRot = 0.5236F;
        this.BodyMain.zRot = 0F;
        // hair
        this.Hair01.xRot = 0.26F + headX;
        this.Hair02.xRot = -0.08F + headX;
        this.Hair03.xRot = -0.14F;
        // arm
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft02.xRot = 0F;
        this.ArmRight02.xRot = 0F;
        // leg
        this.LegLeft01.yRot = 0F;
        this.LegRight01.yRot = 0F;
        // equip
        if (this.EquipRdL01 != null)
            this.EquipRdL01.visible = false;
        if (this.EquipRdR01 != null)
            this.EquipRdR01.visible = false;

        // Body
        this.Head.xRot += 0.14F;
        this.BodyMain.xRot = 0.4F;
        this.Butt.xRot = -0.4F;
        // this.Butt.offsetZ = 0.19F;
        this.BoobL.xRot -= 0.2F;
        this.BoobR.xRot -= 0.2F;
        // arm
        this.ArmLeft01.xRot = -1.3F;
        this.ArmLeft01.zRot = -0.1F;
        this.ArmLeft02.zRot = 1.15F;
        this.ArmRight01.xRot = -1.3F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = 0.1F;
        this.ArmRight02.zRot = -1.4F;
        // leg
        addk1 = -2.1232F;
        addk2 = -2.0708F;
        this.LegLeft01.zRot = -0.2F;
        this.LegLeft02.xRot = 1.34F;
        this.LegRight01.zRot = 0.2F;
        this.LegRight02.xRot = 1.13F;
        // hair
        this.Hair01.xRot -= 0.2F;
        this.Hair02.xRot -= 0.2F;
        this.Hair03.xRot -= 0.1F;

        // 移動頭髮避免穿過身體
        headZ = this.Head.zRot * -0.5F;
        this.Hair01.zRot = headZ;
        this.Hair02.zRot = headZ;
        this.HairL01.zRot = headZ - 0.0F;
        this.HairL02.zRot = headZ + 0.087F;
        this.HairR01.zRot = headZ + 0.0F;
        this.HairR02.zRot = headZ - 0.052F;

        headX = this.Head.xRot * -0.5F;
        this.HairL01.xRot = headX - 0.5F;
        this.HairL02.xRot = headX - 0.1F;
        this.HairR01.xRot = headX - 0.5F;
        this.HairR02.xRot = headX - 0.1F;

        // leg motion
        this.LegLeft01.xRot = addk1;
        this.LegRight01.xRot = addk2;
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
        addk1 = angleAdd1;
        addk2 = angleAdd2 - 0.2F;

        // 移動頭部使其看人
        this.Head.xRot = f4 * 0.014F; // 上下角度
        this.Head.yRot = f3 * 0.01F; // 左右角度
        this.Head.zRot = 0F;
        headX = this.Head.xRot * -0.5F;
        // 正常站立動作
        // 胸部
        this.BoobL.xRot = angleX * 0.06F - 0.7F;
        this.BoobR.xRot = angleX * 0.06F - 0.7F;
        // Body
        this.Ahoke.yRot = angleX * 0.25F + 0.5236F;
        this.BodyMain.xRot = -0.1745F;
        this.BodyMain.zRot = 0F;
        this.Butt.xRot = 0.3142F;
        // this.Butt.offsetZ = 0F;
        // hair
        this.Hair01.xRot = angleX * 0.03F + 0.26F + headX;
        this.Hair01.zRot = 0F;
        this.Hair02.xRot = -angleX1 * 0.04F - 0.08F + headX;
        this.Hair02.zRot = 0F;
        this.Hair03.xRot = -angleX2 * 0.07F - 0.14F;
        this.Hair03.zRot = 0F;
        // arm
        this.ArmLeft01.xRot = angleAdd2 * 0.8F + 0.2F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = angleX * 0.08F - 0.2F;
        this.ArmLeft02.xRot = 0F;
        this.ArmLeft02.zRot = 0F;
        this.ArmRight01.xRot = angleAdd1 * 0.8F + 0.2F;
        this.ArmRight01.zRot = -angleX * 0.08F + 0.2F;
        this.ArmRight02.xRot = 0F;
        this.ArmRight02.zRot = 0F;
        // leg
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.14F;
        this.LegLeft02.xRot = 0F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.14F;
        this.LegRight02.xRot = 0F;
        // equip
        if (this.EquipRdL01 != null)
            this.EquipRdL01.visible = false;
        if (this.EquipRdR01 != null)
            this.EquipRdR01.visible = false;

        ent.getIsSprinting(); // 奔跑動作
        // 沒有特殊跑步動作


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
            this.offsetY += 0.07F;
            this.Head.xRot -= 0.6283F;
            this.BodyMain.xRot = 0.8727F;
            // arm
            this.ArmLeft01.xRot = -0.35F;
            this.ArmLeft01.zRot = 0.2618F;
            this.ArmRight01.xRot = -0.35F;
            this.ArmRight01.zRot = -0.2618F;
            // leg
            addk1 -= 1.1F;
            addk2 -= 1.1F;
            // hair
            this.Hair01.xRot += 0.37F;
            this.Hair02.xRot += 0.23F;
            this.Hair03.xRot -= 0.1F;
        } // end if sneaking

        if (ent.getIsSitting() && !ent.getIsRiding()) { // 騎乘動作
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.22F;
            this.offsetZ += 0.2F;
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                // Body
                this.Head.xRot += 0.14F;
                this.BodyMain.xRot = -0.4363F;
                this.BoobL.xRot -= 0.25F;
                this.BoobR.xRot -= 0.25F;
                // arm
                this.ArmLeft01.xRot = -0.3142F;
                this.ArmLeft01.zRot = 0.3490F;
                this.ArmLeft02.zRot = 1.15F;
                this.ArmRight01.xRot = -0.4363F;
                this.ArmRight01.zRot = -0.2793F;
                this.ArmRight02.zRot = -1.4F;
                // leg
                addk1 = -1.3090F;
                addk2 = -1.7F;
                this.LegLeft01.yRot = 0.3142F;
                this.LegLeft02.xRot = 1.0472F;
                this.LegRight01.yRot = -0.35F;
                this.LegRight01.zRot = -0.2618F;
                this.LegRight02.xRot = 0.9F;
                // hair
                this.Hair01.xRot += 0.12F;
                this.Hair02.xRot += 0.15F;
                this.Hair03.xRot += 0.25F;
            } else {
                // Body
                this.Head.xRot += 0.14F;
                this.BodyMain.xRot = -0.5236F;
                this.BoobL.xRot -= 0.2F;
                this.BoobR.xRot -= 0.2F;
                // arm
                this.ArmLeft01.xRot = -0.4363F;
                this.ArmLeft01.zRot = 0.3142F;
                this.ArmRight01.xRot = -0.4363F;
                this.ArmRight01.zRot = -0.3142F;
                // leg
                addk1 = -1.6232F;
                addk2 = -1.5708F;
                this.LegLeft01.zRot = -0.3142F;
                this.LegLeft02.xRot = 1.34F;
                this.LegRight01.zRot = 0.35F;
                this.LegRight02.xRot = 1.13F;
                // hair
                this.Hair01.xRot += 0.09F;
                this.Hair02.xRot += 0.43F;
                this.Hair03.xRot += 0.49F;
            }
        } // end sitting

        if (ent.getIsRiding()) {
            if (((net.minecraft.world.entity.Entity) ent).getVehicle() instanceof BasicEntityMount) {
                if (ent.getIsSitting()) {

                    if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                        // Body
                        this.Head.xRot -= 0.3F;
                        this.BodyMain.xRot = -0.4363F;
                        this.BoobL.xRot -= 0.25F;
                        this.BoobR.xRot -= 0.25F;
                        // arm
                        this.ArmLeft01.xRot = -0.3142F;
                        this.ArmLeft01.zRot = 0.3490F;
                        this.ArmLeft02.zRot = 1.15F;
                        this.ArmRight01.xRot = -0.4363F;
                        this.ArmRight01.zRot = -0.2793F;
                        this.ArmRight02.zRot = -1.4F;
                        // leg
                        addk1 = -1.3090F;
                        addk2 = -1.7F;
                        this.LegLeft01.yRot = 0.3142F;
                        this.LegLeft02.xRot = 1.0472F;
                        this.LegRight01.yRot = -0.35F;
                        this.LegRight01.zRot = -0.2618F;
                        this.LegRight02.xRot = 0.9F;
                        // hair
                        this.Hair01.xRot += 0.12F;
                        this.Hair02.xRot += 0.15F;
                        this.Hair03.xRot += 0.25F;
                    } else {
                        // Body
                        this.BodyMain.xRot = -0.5236F;
                        this.BoobL.xRot -= 0.2F;
                        this.BoobR.xRot -= 0.2F;
                        // arm
                        this.ArmLeft01.xRot = -0.4363F;
                        this.ArmLeft01.zRot = 0.3142F;
                        this.ArmRight01.xRot = -0.4363F;
                        this.ArmRight01.zRot = -0.3142F;
                        // leg
                        addk1 = -1.6232F;
                        addk2 = -1.5708F;
                        this.LegLeft01.zRot = -0.3142F;
                        this.LegLeft02.xRot = 1.34F;
                        this.LegRight01.zRot = 0.35F;
                        this.LegRight02.xRot = 1.13F;
                        // hair
                        this.Hair01.xRot += 0.09F;
                        this.Hair02.xRot += 0.43F;
                        this.Hair03.xRot += 0.49F;
                    }
                } // end if sitting
                else {
                    // body
                    this.Head.xRot -= 0.1F;
                    // arm
                    this.ArmLeft01.xRot = 0.5F;
                    this.ArmLeft01.zRot = -1.2F;
                    this.ArmRight01.xRot = 0.5F;
                    this.ArmRight01.zRot = 1.2F;
                    // leg
                    addk1 = -0.2618F;
                    addk2 = -0.35F;
                    this.LegRight02.xRot = 0.8727F;
                    // hair
                    this.Hair01.xRot += 0.45F;
                    this.Hair02.xRot += 0.43F;
                    this.Hair03.xRot += 0.49F;
                }
            } // end ship mount
            else { // normal mount ex: cart
                if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                    // Body
                    this.Head.xRot += 0.14F;
                    this.BodyMain.xRot = -0.4363F;
                    this.BoobL.xRot -= 0.25F;
                    this.BoobR.xRot -= 0.25F;
                    // arm
                    this.ArmLeft01.xRot = -0.3142F;
                    this.ArmLeft01.zRot = 0.3490F;
                    this.ArmLeft02.zRot = 1.15F;
                    this.ArmRight01.xRot = -0.4363F;
                    this.ArmRight01.zRot = -0.2793F;
                    this.ArmRight02.zRot = -1.4F;
                    // leg
                    addk1 = -1.3090F;
                    addk2 = -1.7F;
                    this.LegLeft01.yRot = 0.3142F;
                    this.LegLeft02.xRot = 1.0472F;
                    this.LegRight01.yRot = -0.35F;
                    this.LegRight01.zRot = -0.2618F;
                    this.LegRight02.xRot = 0.9F;
                    // hair
                    this.Hair01.xRot += 0.12F;
                    this.Hair02.xRot += 0.15F;
                    this.Hair03.xRot += 0.25F;
                } else {
                    // Body
                    this.Head.xRot += 0.14F;
                    this.BodyMain.xRot = -0.5236F;
                    this.BoobL.xRot -= 0.2F;
                    this.BoobR.xRot -= 0.2F;
                    // arm
                    this.ArmLeft01.xRot = -0.4363F;
                    this.ArmLeft01.zRot = 0.3142F;
                    this.ArmRight01.xRot = -0.4363F;
                    this.ArmRight01.zRot = -0.3142F;
                    // leg
                    addk1 = -1.6232F;
                    addk2 = -1.5708F;
                    this.LegLeft01.zRot = -0.3142F;
                    this.LegLeft02.xRot = 1.34F;
                    this.LegRight01.zRot = 0.35F;
                    this.LegRight02.xRot = 1.13F;
                    // hair
                    this.Hair01.xRot += 0.09F;
                    this.Hair02.xRot += 0.43F;
                    this.Hair03.xRot += 0.49F;
                }
            }
        } // end ridding

        // 攻擊動作
        if (ent.getAttackTick() > 0) {
            if (ent.getAttackTick() > 25) {
                // jojo攻擊動作
                if (EmotionHelper.checkModelState(2, ent.getStateEmotion(ID.S.State))) {
                    // Body
                    // [PORT] Restored from 1.10.2 GlStateManager.translate
                    this.offsetY += 0.15F;
                    this.Head.yRot *= 0.8F;
                    this.Head.xRot = 0.4538F;
                    this.BodyMain.xRot = -1.0472F;
                    this.BodyMain.zRot = -0.2094F;
                    // arm
                    this.ArmLeft01.xRot = -0.35F;
                    this.ArmLeft01.zRot = -0.35F;
                    this.ArmLeft02.xRot = -0.5F;
                    this.ArmRight01.xRot = 1.2F;
                    this.ArmRight01.zRot = 0.5236F;
                    this.ArmRight02.xRot = -0.35F;
                    // leg
                    addk1 = 0.5236F;
                    addk2 = 0.1745F;
                    this.LegLeft01.zRot = 0.2618F;
                    this.LegLeft02.xRot = 0.5236F;
                    this.LegRight01.zRot = 0.1745F;
                    this.LegRight02.xRot = 0.5236F;
                    // hair
                    this.Hair01.xRot += 0.09F;
                    this.Hair02.xRot += 0.43F;
                    this.Hair03.xRot += 0.49F;
                } else if (EmotionHelper.checkModelState(3, ent.getStateEmotion(ID.S.State))) {
                    // Body
                    this.Head.yRot *= 0.8F;
                    this.Head.xRot = 0.2094F;
                    this.Head.zRot = -0.2618F;
                    this.BodyMain.xRot = -0.35F;
                    this.BodyMain.zRot = 0.1745F;
                    // arm
                    this.ArmLeft01.xRot = -1.2217F;
                    this.ArmLeft01.yRot = 0.5236F;
                    this.ArmLeft01.zRot = -0.35F;
                    this.ArmLeft02.xRot = -1.3963F;
                    this.ArmRight01.xRot = 0.7854F;
                    this.ArmRight01.zRot = 0.5236F;
                    this.ArmRight02.xRot = -0.5236F;
                    // leg
                    addk1 = -0.2618F;
                    addk2 = 0.3142F;
                    this.LegLeft01.zRot = -0.4363F;
                    this.LegLeft02.xRot = 0.2618F;
                    this.LegRight01.zRot = 0.0873F;
                    // hair
                    this.Hair01.xRot += 0.09F;
                    this.Hair02.xRot += 0.43F;
                    this.Hair03.xRot += 0.49F;
                } else {
                    // arm
                    this.ArmLeft01.xRot = -1.3F;
                    this.ArmLeft01.yRot = -0.7F;
                    this.ArmLeft01.zRot = 0F;
                }
            }
            // 跑道顯示
            // Road visual parts are positioned statically in the constructor; no runtime
            // animation needed
        }

        // 鬢毛調整
        headX = this.Head.xRot * -0.5F;
        this.HairL01.xRot = angleX * 0.03F + headX - 0.26F;
        this.HairL02.xRot = -angleX1 * 0.04F + headX + 0.26F;
        this.HairR01.xRot = angleX * 0.03F + headX - 0.26F;
        this.HairR02.xRot = -angleX1 * 0.04F + headX + 0.26F;

        // swing arm
        float f6 = ent.getSwingTime(f2 % 1F);
        if (f6 != 0F) {
            float f7 = Mth.sin(f6 * f6 * (float) Math.PI);
            float f8 = Mth.sin(Mth.sqrt(f6) * (float) Math.PI);
            this.ArmRight01.xRot = -0.3F;
            this.ArmRight01.yRot = 0F;
            this.ArmRight01.zRot = -0.1F;
            this.ArmRight01.xRot += -f8 * 80.0F * ((float) Math.PI / 180F);
            this.ArmRight01.yRot += -f7 * 20.0F * ((float) Math.PI / 180F);
            this.ArmRight01.zRot += -f8 * 20.0F * ((float) Math.PI / 180F);
            this.ArmRight02.xRot = 0F;
            this.ArmRight02.zRot = 0F;
        }

        // leg motion
        this.LegLeft01.xRot = addk1;
        this.LegRight01.xRot = addk2;
    }
}
