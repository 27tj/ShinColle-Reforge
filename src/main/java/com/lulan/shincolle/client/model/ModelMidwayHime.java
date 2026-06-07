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

public class ModelMidwayHime extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "midway_hime"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Neck;
    private final ModelPart Butt;
    private final ModelPart ArmRight01;
    private final ModelPart ArmLeft01;
    private final ModelPart BoobR;
    private final ModelPart BoobL;
    private final ModelPart EquipSR01;
    private final ModelPart EquipSR01b;
    private final ModelPart EquipSR01c;
    private final ModelPart Head;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart HeadHL;
    private final ModelPart HeadHR;
    private final ModelPart HairU01;
    private final ModelPart Ahoke;
    private final ModelPart HairR01;
    private final ModelPart HairL01;
    private final ModelPart HairR02;
    private final ModelPart HairL02;
    private final ModelPart Hair01;
    private final ModelPart Hair02;
    private final ModelPart Hair03;
    private final ModelPart HeadHL2;
    private final ModelPart HeadHL3;
    private final ModelPart HeadHR2;
    private final ModelPart HeadHR3;
    private final ModelPart LegLeft01;
    private final ModelPart Skirt01;
    private final ModelPart LegRight01;
    private final ModelPart LegLeft02;
    private final ModelPart Skirt02;
    private final ModelPart Skirt03;
    private final ModelPart LegRight02;
    private final ModelPart ArmRight02;
    private final ModelPart ArmRight02a;
    private final ModelPart ArmRight02b;
    private final ModelPart ArmLeft02;
    private final ModelPart ArmLeft02a;
    private final ModelPart ArmLeft02b;
    private final ModelPart Collar02;
    private final ModelPart Collar03a1;
    private final ModelPart Collar03a2;
    private final ModelPart Collar03a3;
    private final ModelPart Collar03a3_1;
    private final ModelPart Collar03a4;
    private final ModelPart Collar03a5;
    private final ModelPart Collar03a6;
    private final ModelPart Collar03a7;
    private final ModelPart Collar03a8;
    private final ModelPart Collar03a9;
    private final ModelPart Collar03a10;
    private final ModelPart Collar03a11;
    private final ModelPart Collar03a12;
    private final ModelPart Collar03a13;
    private final ModelPart Collar03a14;
    private final ModelPart Collar03a15;
    private final ModelPart Collar03b1;
    private final ModelPart Collar03b2;
    private final ModelPart Collar03b3;
    private final ModelPart Collar03b3_1;
    private final ModelPart Collar03b4;
    private final ModelPart Collar03b5;
    private final ModelPart Collar03b6;
    private final ModelPart Collar03b7;
    private final ModelPart Collar03b8;
    private final ModelPart Collar03b9;
    private final ModelPart Collar03b10;
    private final ModelPart Collar03b11;
    private final ModelPart Collar03b12;
    private final ModelPart Collar03b13;
    private final ModelPart Collar03b14;
    private final ModelPart Collar03b15;
    private final ModelPart EquipSR02;
    private final ModelPart EquipSR03;
    private final ModelPart EquipSR04;
    private final ModelPart EquipSR05;
    private final ModelPart EquipSR02b;
    private final ModelPart EquipSR03b;
    private final ModelPart EquipSR04b;
    private final ModelPart EquipSR02c;
    private final ModelPart EquipSR03c;
    private final ModelPart EquipSR04c;
    private final ModelPart EquipSR05c;
    private final ModelPart Collar01;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowBodyMain2;
    private final ModelPart GlowBodyMain2a;
    private final ModelPart GlowNeck;
    private final ModelPart GlowHead;

    public ModelMidwayHime(ModelPart root) {
        super();
        this.scale = 0.48F;
        this.offsetY = 1.62F;
        this.BodyMain = root.getChild("BodyMain");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.BoobL = this.BodyMain.getChild("BoobL");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.BoobR = this.BodyMain.getChild("BoobR");
        this.Neck = this.BodyMain.getChild("Neck");
        this.Butt = this.BodyMain.getChild("Butt");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.Head = this.Neck.getChild("Head");
        this.LegRight01 = this.Butt.getChild("LegRight01");
        this.Skirt01 = this.Butt.getChild("Skirt01");
        this.LegLeft01 = this.Butt.getChild("LegLeft01");
        this.ArmRight02a = this.ArmRight02.getChild("ArmRight02a");
        this.ArmLeft02a = this.ArmLeft02.getChild("ArmLeft02a");
        this.Hair = this.Head.getChild("Hair");
        this.HairMain = this.Head.getChild("HairMain");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.Skirt02 = this.Skirt01.getChild("Skirt02");
        this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
        this.ArmRight02b = this.ArmRight02a.getChild("ArmRight02b");
        this.ArmLeft02b = this.ArmLeft02a.getChild("ArmLeft02b");
        this.HairL01 = this.Hair.getChild("HairL01");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.HairU01 = this.Hair.getChild("HairU01");
        this.HairR01 = this.Hair.getChild("HairR01");
        this.Hair01 = this.HairMain.getChild("Hair01");
        this.Skirt03 = this.Skirt02.getChild("Skirt03");
        this.HairL02 = this.HairL01.getChild("HairL02");
        this.HairR02 = this.HairR01.getChild("HairR02");
        this.Hair02 = this.Hair01.getChild("Hair02");
        this.Hair03 = this.Hair02.getChild("Hair03");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowBodyMain2 = root.getChild("GlowBodyMain2");
        this.GlowNeck = this.GlowBodyMain.getChild("GlowNeck");
        this.GlowBodyMain2a = this.GlowBodyMain2.getChild("GlowBodyMain2a");
        this.EquipSR01 = this.GlowBodyMain2a.getChild("EquipSR01");
        this.EquipSR01b = this.GlowBodyMain2a.getChild("EquipSR01b");
        this.EquipSR01c = this.GlowBodyMain2a.getChild("EquipSR01c");
        this.GlowHead = this.GlowNeck.getChild("GlowHead");
        this.loadFaceParts(this.GlowHead);

        // Horn parts
        this.HeadHL = this.GlowHead.getChild("HeadHL");
        this.HeadHL2 = this.HeadHL.getChild("HeadHL2");
        this.HeadHL3 = this.HeadHL2.getChild("HeadHL3");
        this.HeadHR = this.GlowHead.getChild("HeadHR");
        this.HeadHR2 = this.HeadHR.getChild("HeadHR2");
        this.HeadHR3 = this.HeadHR2.getChild("HeadHR3");

        // Collar parts
        this.Collar01 = this.GlowNeck.getChild("Collar01");
        this.Collar02 = this.Collar01.getChild("Collar02");
        this.Collar03a1 = this.Collar02.getChild("Collar03a1");
        this.Collar03a2 = this.Collar02.getChild("Collar03a2");
        this.Collar03a3 = this.Collar02.getChild("Collar03a3");
        this.Collar03a3_1 = this.Collar02.getChild("Collar03a3_1");
        this.Collar03a4 = this.Collar02.getChild("Collar03a4");
        this.Collar03a5 = this.Collar02.getChild("Collar03a5");
        this.Collar03a6 = this.Collar02.getChild("Collar03a6");
        this.Collar03a7 = this.Collar02.getChild("Collar03a7");
        this.Collar03a8 = this.Collar02.getChild("Collar03a8");
        this.Collar03a9 = this.Collar02.getChild("Collar03a9");
        this.Collar03a10 = this.Collar02.getChild("Collar03a10");
        this.Collar03a11 = this.Collar02.getChild("Collar03a11");
        this.Collar03a12 = this.Collar02.getChild("Collar03a12");
        this.Collar03a13 = this.Collar02.getChild("Collar03a13");
        this.Collar03a14 = this.Collar02.getChild("Collar03a14");
        this.Collar03a15 = this.Collar02.getChild("Collar03a15");
        this.Collar03b1 = this.Collar03a1.getChild("Collar03b1");
        this.Collar03b2 = this.Collar03a2.getChild("Collar03b2");
        this.Collar03b3 = this.Collar03a3.getChild("Collar03b3");
        this.Collar03b3_1 = this.Collar03a3_1.getChild("Collar03b3_1");
        this.Collar03b4 = this.Collar03a4.getChild("Collar03b4");
        this.Collar03b5 = this.Collar03a5.getChild("Collar03b5");
        this.Collar03b6 = this.Collar03a6.getChild("Collar03b6");
        this.Collar03b7 = this.Collar03a7.getChild("Collar03b7");
        this.Collar03b8 = this.Collar03a8.getChild("Collar03b8");
        this.Collar03b9 = this.Collar03a9.getChild("Collar03b9");
        this.Collar03b10 = this.Collar03a10.getChild("Collar03b10");
        this.Collar03b11 = this.Collar03a11.getChild("Collar03b11");
        this.Collar03b12 = this.Collar03a12.getChild("Collar03b12");
        this.Collar03b13 = this.Collar03a13.getChild("Collar03b13");
        this.Collar03b14 = this.Collar03a14.getChild("Collar03b14");
        this.Collar03b15 = this.Collar03a15.getChild("Collar03b15");

        // Equipment chain parts
        this.EquipSR02 = this.EquipSR01.getChild("EquipSR02");
        this.EquipSR03 = this.EquipSR02.getChild("EquipSR03");
        this.EquipSR04 = this.EquipSR03.getChild("EquipSR04");
        this.EquipSR05 = this.EquipSR04.getChild("EquipSR05");
        this.EquipSR02b = this.EquipSR01b.getChild("EquipSR02b");
        this.EquipSR03b = this.EquipSR02b.getChild("EquipSR03b");
        this.EquipSR04b = this.EquipSR03b.getChild("EquipSR04b");
        this.EquipSR02c = this.EquipSR01c.getChild("EquipSR02c");
        this.EquipSR03c = this.EquipSR02c.getChild("EquipSR03c");
        this.EquipSR04c = this.EquipSR03c.getChild("EquipSR04c");
        this.EquipSR05c = this.EquipSR04c.getChild("EquipSR05c");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 104)
                        .addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().mirror().texOffs(24, 71)
                        .addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, -0.08726646259971647F, 0.0F, 0.2617993877991494F));

        PartDefinition armRight02 = armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().mirror().texOffs(24, 54)
                        .addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
                PartPose.offset(-3.0F, 11.0F, 2.5F));

        PartDefinition armRight02a = armRight02.addOrReplaceChild("ArmRight02a",
                CubeListBuilder.create().mirror().texOffs(75, 47)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F),
                PartPose.offsetAndRotation(2.5F, 3.0F, -2.5F, 0.05235987755982988F, 0.0F, 0.0F));

        armRight02a.addOrReplaceChild("ArmRight02b",
                CubeListBuilder.create().mirror().texOffs(78, 37)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F),
                PartPose.offset(0.0F, 1.9F, 0.2F));

        bodyMain.addOrReplaceChild("BoobL",
                CubeListBuilder.create().mirror().texOffs(0, 35)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 6.0F, 6.0F),
                PartPose.offsetAndRotation(3.4F, -8.5F, -3.7F, -0.8726646259971648F, -0.08726646259971647F,
                        -0.06981317007977318F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().texOffs(24, 71)
                        .addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.3490658503988659F, 0.0F, -0.2617993877991494F));

        PartDefinition armLeft02 = armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().texOffs(24, 54)
                        .addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
                PartPose.offset(3.0F, 11.0F, 2.5F));

        PartDefinition armLeft02a = armLeft02.addOrReplaceChild("ArmLeft02a",
                CubeListBuilder.create().texOffs(75, 47)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F),
                PartPose.offsetAndRotation(-2.5F, 3.0F, -2.5F, 0.05235987755982988F, 0.0F, 0.0F));

        armLeft02a.addOrReplaceChild("ArmLeft02b",
                CubeListBuilder.create().texOffs(78, 37)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F),
                PartPose.offset(0.0F, 1.9F, 0.2F));

        bodyMain.addOrReplaceChild("BoobR",
                CubeListBuilder.create().texOffs(0, 35)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 6.0F, 6.0F),
                PartPose.offsetAndRotation(-3.5F, -8.5F, -3.8F, -0.8726646259971648F, 0.08726646259971647F,
                        0.06981317007977318F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(24, 80)
                        .addBox(-2.5F, -3.0F, -2.9F, 5.0F, 3.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offset(0.0F, -0.8F, -0.7F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(50, 77)
                        .addBox(-8.0F, -8.0F, -7.4F, 16.0F, 16.0F, 8.0F),
                PartPose.offset(0.0F, -7.5F, 0.1F));

        PartDefinition hairL01 = hair.addOrReplaceChild("HairL01",
                CubeListBuilder.create().texOffs(0, 10)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(7.0F, 3.0F, -5.5F, -0.19198621771937624F, -0.17453292519943295F,
                        -0.08726646259971647F));

        hairL01.addOrReplaceChild("HairL02",
                CubeListBuilder.create().texOffs(0, 10)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.08726646259971647F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(106, 31)
                        .addBox(0.0F, -6.0F, -10.5F, 0.0F, 11.0F, 11.0F),
                PartPose.offsetAndRotation(-0.5F, -7.0F, -6.0F, 0.20943951023931953F, 0.6981317007977318F, 0.0F));

        hair.addOrReplaceChild("HairU01",
                CubeListBuilder.create().texOffs(52, 56)
                        .addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F),
                PartPose.offset(0.0F, -6.0F, -7.0F));

        PartDefinition hairR01 = hair.addOrReplaceChild("HairR01",
                CubeListBuilder.create().mirror().texOffs(0, 10)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(-7.0F, 3.0F, -5.5F, -0.19198621771937624F, 0.17453292519943295F,
                        0.08726646259971647F));

        hairR01.addOrReplaceChild("HairR02",
                CubeListBuilder.create().mirror().texOffs(0, 10)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(0.2F, 10.0F, 0.0F, 0.17453292519943295F, 0.0F, -0.05235987755982988F));

        PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(46, 104)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F),
                PartPose.offset(0.0F, -14.8F, -3.0F));

        PartDefinition hair01 = hairMain.addOrReplaceChild("Hair01",
                CubeListBuilder.create().texOffs(14, 0)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 17.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 9.0F, 1.0F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition hair02 = hair01.addOrReplaceChild("Hair02",
                CubeListBuilder.create().texOffs(62, 0)
                        .addBox(-8.0F, 0.0F, -5.0F, 16.0F, 16.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 13.5F, 5.5F, -0.08726646259971647F, 0.0F, 0.0F));

        hair02.addOrReplaceChild("Hair03",
                CubeListBuilder.create().texOffs(26, 28)
                        .addBox(-8.0F, 0.0F, -4.5F, 16.0F, 15.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 12.5F, -0.1F, -0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(0, 88)
                        .addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));

        PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().mirror().texOffs(0, 68)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.08726646259971647F, 0.0F, -0.08726646259971647F));

        legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().mirror().texOffs(0, 47)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                PartPose.offset(-3.0F, 14.0F, -3.0F));

        PartDefinition skirt01 = butt.addOrReplaceChild("Skirt01",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-8.5F, 0.0F, -8.5F, 17.0F, 6.0F, 11.0F),
                PartPose.offsetAndRotation(0.0F, 3.0F, 1.5F, -0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition skirt02 = skirt01.addOrReplaceChild("Skirt02",
                CubeListBuilder.create().texOffs(128, 17)
                        .addBox(-10.5F, 0.0F, -6.5F, 21.0F, 6.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, 4.5F, -2.7F, -0.08726646259971647F, 0.0F, 0.0F));

        skirt02.addOrReplaceChild("Skirt03",
                CubeListBuilder.create().texOffs(128, 37)
                        .addBox(-13.0F, 0.0F, -7.5F, 26.0F, 6.0F, 15.0F),
                PartPose.offsetAndRotation(0.0F, 4.5F, 0.3F, -0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().texOffs(0, 68)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.2792526803190927F, 0.0F, 0.08726646259971647F));

        legLeft01.addOrReplaceChild("LegLeft02",
                CubeListBuilder.create().texOffs(0, 47)
                        .addBox(-6.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                PartPose.offset(3.0F, 14.0F, -3.0F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -15.0F, 0.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -10.3F, 0.5F));

        PartDefinition glowHead = glowNeck.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -0.8F, -0.7F));
        addDefaultFaceParts(glowHead);

        // Horn glow parts - left horn chain
        PartDefinition glowHeadHL = glowHead.addOrReplaceChild("HeadHL",
                CubeListBuilder.create().mirror().texOffs(40, 104)
                        .addBox(0.0F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(6.4F, -10.6F, 0.8F, -0.7853981633974483F, -0.17453292519943295F,
                        -0.3839724354387525F));

        PartDefinition glowHeadHL2 = glowHeadHL.addOrReplaceChild("HeadHL2",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F),
                PartPose.offset(3.0F, 0.0F, 0.0F));

        glowHeadHL2.addOrReplaceChild("HeadHL3",
                CubeListBuilder.create().texOffs(44, 70)
                        .addBox(0.0F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F),
                PartPose.offset(1.0F, 0.0F, 0.0F));

        // Horn glow parts - right horn chain
        PartDefinition glowHeadHR = glowHead.addOrReplaceChild("HeadHR",
                CubeListBuilder.create().texOffs(40, 104)
                        .addBox(-3.0F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(-6.4F, -10.6F, 0.8F, -0.7853981633974483F, 0.17453292519943295F,
                        0.3839724354387525F));

        PartDefinition glowHeadHR2 = glowHeadHR.addOrReplaceChild("HeadHR2",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F),
                PartPose.offset(-3.0F, 0.0F, 0.0F));

        glowHeadHR2.addOrReplaceChild("HeadHR3",
                CubeListBuilder.create().texOffs(44, 70)
                        .addBox(-1.0F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F),
                PartPose.offset(-1.0F, 0.0F, 0.0F));

        // Collar glow parts on GlowNeck
        PartDefinition collar01 = glowNeck.addOrReplaceChild("Collar01",
                CubeListBuilder.create().texOffs(66, 25)
                        .addBox(-6.0F, -2.0F, -4.0F, 12.0F, 2.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 1.9F, -1.2F, 0.035F, 0.0F, 0.0F));

        PartDefinition collar02 = collar01.addOrReplaceChild("Collar02",
                CubeListBuilder.create().texOffs(128, 60)
                        .addBox(-7.0F, -1.5F, -5.7F, 14.0F, 3.0F, 11.0F),
                PartPose.offset(0.0F, -2.5F, -1.0F));

        // Collar03a parts on Collar02
        PartDefinition collar03a1 = collar02.addOrReplaceChild("Collar03a1",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(1.3F, 0.6F, -3.5F, -1.8325957145940461F, -0.12217304763960307F,
                        0.03490658503988659F));

        PartDefinition collar03a2 = collar02.addOrReplaceChild("Collar03a2",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(-1.3F, 0.6F, -3.5F, -1.8325957145940461F, 0.12217304763960307F,
                        -0.03490658503988659F));

        PartDefinition collar03a3 = collar02.addOrReplaceChild("Collar03a3",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F),
                PartPose.offsetAndRotation(4.3F, 0.5F, -3.5F, -2.007128639793479F, -0.20943951023931953F,
                        0.06981317007977318F));

        PartDefinition collar03a3_1 = collar02.addOrReplaceChild("Collar03a3_1",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F),
                PartPose.offsetAndRotation(-4.3F, 0.5F, -3.5F, -2.007128639793479F, 0.20943951023931953F,
                        -0.06981317007977318F));

        PartDefinition collar03a4 = collar02.addOrReplaceChild("Collar03a4",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(5.0F, 0.2F, -2.1F, -1.6580627893946132F, -0.8028514559173915F,
                        -0.08726646259971647F));

        PartDefinition collar03a5 = collar02.addOrReplaceChild("Collar03a5",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(4.6F, 0.1F, -1.3F, -1.7453292519943295F, -1.4311699866353502F, 0.0F));

        PartDefinition collar03a6 = collar02.addOrReplaceChild("Collar03a6",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F),
                PartPose.offsetAndRotation(4.6F, 0.1F, 1.7F, -1.7453292519943295F, -1.605702911834783F, 0.0F));

        PartDefinition collar03a7 = collar02.addOrReplaceChild("Collar03a7",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(5.4F, 0.1F, 2.7F, -1.7453292519943295F, -2.2689280275926285F, 0.0F));

        PartDefinition collar03a8 = collar02.addOrReplaceChild("Collar03a8",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F),
                PartPose.offsetAndRotation(3.5F, 0.2F, 3.4F, -1.7453292519943295F, -2.6179938779914944F,
                        0.05235987755982988F));

        PartDefinition collar03a9 = collar02.addOrReplaceChild("Collar03a9",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F),
                PartPose.offsetAndRotation(1.4F, 0.4F, 2.6F, -1.7453292519943295F, -3.036872898470133F,
                        0.05235987755982988F));

        PartDefinition collar03a10 = collar02.addOrReplaceChild("Collar03a10",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F),
                PartPose.offsetAndRotation(-1.4F, 0.4F, 2.6F, -1.7453292519943295F, 3.036872898470133F,
                        -0.05235987755982988F));

        PartDefinition collar03a11 = collar02.addOrReplaceChild("Collar03a11",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F),
                PartPose.offsetAndRotation(-3.5F, 0.2F, 3.4F, -1.7453292519943295F, 2.6179938779914944F,
                        -0.05235987755982988F));

        PartDefinition collar03a12 = collar02.addOrReplaceChild("Collar03a12",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(-5.4F, 0.1F, 2.7F, -1.7453292519943295F, 2.2689280275926285F, 0.0F));

        PartDefinition collar03a13 = collar02.addOrReplaceChild("Collar03a13",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F),
                PartPose.offsetAndRotation(-4.6F, 0.1F, 1.7F, -1.7453292519943295F, 1.605702911834783F, 0.0F));

        PartDefinition collar03a14 = collar02.addOrReplaceChild("Collar03a14",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(-4.6F, 0.1F, -1.3F, -1.7453292519943295F, 1.4311699866353502F, 0.0F));

        PartDefinition collar03a15 = collar02.addOrReplaceChild("Collar03a15",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(-5.0F, 0.2F, -2.1F, -1.6580627893946132F, 0.8028514559173915F,
                        0.08726646259971647F));

        // Collar03b parts on their respective Collar03a parents
        collar03a1.addOrReplaceChild("Collar03b1",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 1.5F, -0.8726646259971648F, 0.0F, 0.0F));

        collar03a2.addOrReplaceChild("Collar03b2",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 1.5F, -0.8726646259971648F, 0.0F, 0.0F));

        collar03a3.addOrReplaceChild("Collar03b3",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.9599310885968813F, 0.0F, 0.0F));

        collar03a3_1.addOrReplaceChild("Collar03b3_1",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.9599310885968813F, 0.0F, 0.0F));

        collar03a4.addOrReplaceChild("Collar03b4",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 1.5F, -0.8377580409572781F, 0.0F, 0.0F));

        collar03a5.addOrReplaceChild("Collar03b5",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 1.5F, -0.8377580409572781F, 0.0F, 0.0F));

        collar03a6.addOrReplaceChild("Collar03b6",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.9948376736367678F, 0.0F, 0.0F));

        collar03a7.addOrReplaceChild("Collar03b7",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 1.5F, -0.8377580409572781F, 0.0F, 0.0F));

        collar03a8.addOrReplaceChild("Collar03b8",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.767944870877505F, 0.0F, 0.0F));

        collar03a9.addOrReplaceChild("Collar03b9",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.6981317007977318F, 0.0F, 0.0F));

        collar03a10.addOrReplaceChild("Collar03b10",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.6981317007977318F, 0.0F, 0.0F));

        collar03a11.addOrReplaceChild("Collar03b11",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.767944870877505F, 0.0F, 0.0F));

        collar03a12.addOrReplaceChild("Collar03b12",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 1.5F, -0.8377580409572781F, 0.0F, 0.0F));

        collar03a13.addOrReplaceChild("Collar03b13",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.9948376736367678F, 0.0F, 0.0F));

        collar03a14.addOrReplaceChild("Collar03b14",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 1.5F, -0.8377580409572781F, 0.0F, 0.0F));

        collar03a15.addOrReplaceChild("Collar03b15",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 1.5F, -0.8377580409572781F, 0.0F, 0.0F));

        PartDefinition glowBodyMain2 = partdefinition.addOrReplaceChild("GlowBodyMain2",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -15.0F, 0.0F));

        PartDefinition glowBodyMain2a = glowBodyMain2.addOrReplaceChild("GlowBodyMain2a",
                CubeListBuilder.create(),
                PartPose.offset(10.0F, -14.0F, -39.0F));

        PartDefinition equipSR01 = glowBodyMain2a.addOrReplaceChild("EquipSR01",
                CubeListBuilder.create().texOffs(108, 25)
                        .addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F),
                PartPose.offsetAndRotation(40.0F, -11.0F, 13.0F, 0.0F, 0.5236F, 1.5708F));

        PartDefinition equipSR02 = equipSR01.addOrReplaceChild("EquipSR02",
                CubeListBuilder.create().texOffs(108, 25)
                        .addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F),
                PartPose.offset(0.0F, 16.0F, 0.0F));

        PartDefinition equipSR03 = equipSR02.addOrReplaceChild("EquipSR03",
                CubeListBuilder.create().texOffs(108, 25)
                        .addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F),
                PartPose.offset(0.0F, 16.0F, 0.0F));

        PartDefinition equipSR04 = equipSR03.addOrReplaceChild("EquipSR04",
                CubeListBuilder.create().texOffs(108, 25)
                        .addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F),
                PartPose.offset(0.0F, 16.0F, 0.0F));

        equipSR04.addOrReplaceChild("EquipSR05",
                CubeListBuilder.create().texOffs(108, 25)
                        .addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F),
                PartPose.offset(0.0F, 16.0F, 0.0F));

        PartDefinition equipSR01b = glowBodyMain2a.addOrReplaceChild("EquipSR01b",
                CubeListBuilder.create().texOffs(108, 25)
                        .addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F),
                PartPose.offsetAndRotation(-33.0F, -9.0F, 13.7F, -0.5918F, -0.3665F, -0.5918F));

        PartDefinition equipSR02b = equipSR01b.addOrReplaceChild("EquipSR02b",
                CubeListBuilder.create().texOffs(108, 25)
                        .addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F),
                PartPose.offset(0.0F, 16.0F, 0.0F));

        PartDefinition equipSR03b = equipSR02b.addOrReplaceChild("EquipSR03b",
                CubeListBuilder.create().texOffs(108, 25)
                        .addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F),
                PartPose.offset(0.0F, 16.0F, 0.0F));

        equipSR03b.addOrReplaceChild("EquipSR04b",
                CubeListBuilder.create().texOffs(108, 25)
                        .addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F),
                PartPose.offset(0.0F, 16.0F, 0.0F));

        PartDefinition equipSR01c = glowBodyMain2a.addOrReplaceChild("EquipSR01c",
                CubeListBuilder.create().texOffs(108, 25)
                        .addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F),
                PartPose.offsetAndRotation(-12.0F, 30.0F, -19.0F, 0.5585F, -0.3491F, -2.5307F));

        PartDefinition equipSR02c = equipSR01c.addOrReplaceChild("EquipSR02c",
                CubeListBuilder.create().texOffs(108, 25)
                        .addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F),
                PartPose.offset(0.0F, 16.0F, 0.0F));

        PartDefinition equipSR03c = equipSR02c.addOrReplaceChild("EquipSR03c",
                CubeListBuilder.create().texOffs(108, 25)
                        .addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F),
                PartPose.offset(0.0F, 16.0F, 0.0F));

        PartDefinition equipSR04c = equipSR03c.addOrReplaceChild("EquipSR04c",
                CubeListBuilder.create().texOffs(108, 25)
                        .addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F),
                PartPose.offset(0.0F, 16.0F, 0.0F));

        equipSR04c.addOrReplaceChild("EquipSR05c",
                CubeListBuilder.create().texOffs(108, 25)
                        .addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F),
                PartPose.offset(0.0F, 16.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 128);
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

        int state = ent.getStateEmotion(ID.S.State);

        this.EquipSR01.visible = false;
        this.EquipSR01b.visible = false;
        this.EquipSR01c.visible = false;

        boolean flag = !EmotionHelper.checkModelState(1, state);
        if (this.Collar01 != null)
            this.Collar01.visible = !flag;

        // this.renderTako = false;
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

        this.GlowBodyMain2a.xRot = this.ArmLeft01.xRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += 0.59F;
        this.setFaceHungry(ent);

        // 頭部
        this.Head.xRot = -0.2618F;
        this.Head.yRot = 0F;
        this.Head.zRot = 0F;
        // Body
        this.Ahoke.yRot = -1.0F;
        this.BodyMain.xRot = 1.2217F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 1.2217F;
        this.Butt.xRot = -0.05F;
        this.Skirt01.xRot = -0.34F;
        // this.Skirt01.offsetY = 0F;
        // this.Skirt01.offsetZ = 0F;
        this.Skirt02.xRot = -0.27F;
        // this.Skirt02.offsetY = 0F;
        this.Skirt03.xRot = -0.22F;
        // this.Skirt03.offsetY = 0F;
        if (this.Collar01 != null)
            this.Collar01.xRot = 0.035F;
        // hair
        this.Hair01.xRot = 0.2F;
        this.Hair01.zRot = -0.2F;
        this.Hair02.xRot = 0.2F;
        this.Hair02.zRot = -0.15F;
        this.HairL01.zRot = 0.0873F;
        this.HairL02.zRot = -0.3142F;
        this.HairR01.zRot = -0.0873F;
        this.HairR02.zRot = -1.2217F;
        this.HairL01.xRot = -0.28F;
        this.HairL02.xRot = 0.15F;
        this.HairR01.xRot = -0.35F;
        this.HairR02.xRot = 0.18F;
        // 胸部
        this.BoobL.xRot = -1.0F;
        this.BoobL.zRot = -0.12F;
        this.BoobR.xRot = -0.7F;
        this.BoobR.zRot = -0.12F;
        // arm
        this.ArmLeft01.xRot = -0.35F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = -3F;
        this.ArmLeft02.xRot = 0F;
        this.ArmLeft02.zRot = 0F;
        // this.ArmLeft02.offsetX = 0F;
        // this.ArmLeft02.offsetY = 0F;
        // this.ArmLeft02.offsetZ = 0F;
        this.ArmRight01.xRot = -0.5F;
        this.ArmRight01.yRot = 0.3F;
        this.ArmRight01.zRot = -0.5F;
        this.ArmRight02.xRot = 0F;
        this.ArmRight02.zRot = -0.8727F;
        // this.ArmRight02.offsetX = 0F;
        // this.ArmRight02.offsetY = 0F;
        // this.ArmRight02.offsetZ = 0F;
        // leg
        this.LegLeft01.xRot = -0.14F;
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.09F;
        this.LegLeft02.xRot = 0F;
        this.LegLeft02.yRot = 0F;
        this.LegLeft02.zRot = 0F;
        // this.LegLeft02.offsetX = 0F;
        // this.LegLeft02.offsetY = 0F;
        // this.LegLeft02.offsetZ = 0F;
        this.LegRight01.xRot = -1.2217F;
        this.LegRight01.yRot = -0.5236F;
        this.LegRight01.zRot = 0F;
        this.LegRight02.xRot = 1.0472F;
        this.LegRight02.yRot = 0F;
        this.LegRight02.zRot = 0F;
        // this.LegRight02.offsetX = 0F;
        // this.LegRight02.offsetY = 0F;
        // this.LegRight02.offsetZ = 0F;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float angleX = Mth.cos(f2 * 0.08F);
        float angleX1 = Mth.cos(f2 * 0.08F + 0.3F + f * 0.5F);
        float angleX2 = Mth.cos(f2 * 0.08F + 0.6F + f * 0.5F);
        float angleAdd1 = Mth.cos(f * 0.7F) * f1 * 0.5F;
        float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.5F;
        float addk1;
        float addk2;
        float headX;
        float headZ;

        // 水上漂浮
        // [RENDER?] 目視検証必須: 水面時の上下揺れが1.10.2相当の小振幅(0.025)で再現されること。
        // [REPRO?] 目視未確認: 実機で水面待機時の高さ差と揺れ周期を比較すること。
        if (ent.getShipDepth(0) > 0D || ent.getShipDepth(1) > 0D) {
            this.offsetY += angleX * 0.025F + 0.025F;
        }

        // leg move parm
        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += angleX * 0.025F + 0.025F;
        addk1 = angleAdd1 * 0.6F - 0.27F;
        addk2 = angleAdd2 * 0.6F - 0.19F;

        // 移動頭部使其看人
        this.Head.xRot = f4 * 0.014F; // 上下角度
        this.Head.yRot = f3 * 0.006F; // 左右角度
        this.Head.zRot = 0F;
        headX = this.Head.xRot * -0.5F;
        // 正常站立動作
        // Body
        this.Ahoke.yRot = angleX * 0.15F + 0.6F;
        this.BodyMain.xRot = -0.1047F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        this.Butt.xRot = 0.35F;
        // this.Butt.offsetY = 0F;
        // this.Butt.offsetZ = 0F;
        this.BoobL.xRot = angleX * 0.08F - 0.76F;
        this.BoobL.zRot = 0.08F;
        this.BoobR.xRot = angleX * 0.08F - 0.76F;
        this.BoobR.zRot = -0.08F;
        if (this.Collar01 != null)
            this.Collar01.xRot = 0.035F;
        if (this.Collar01 != null)
            this.Collar01.xRot += this.Head.xRot * 0.8F;
        // cloth
        this.Skirt01.xRot = -0.087F;
        // this.Skirt01.offsetY = 0F;
        // this.Skirt01.offsetZ = 0F;
        this.Skirt02.xRot = angleX1 * 0.015F - 0.087F;
        // this.Skirt02.offsetY = 0F;
        this.Skirt03.xRot = -angleX2 * 0.04F - 0.052F;
        // this.Skirt03.offsetY = 0F;
        // hair
        this.Hair01.xRot = angleX * 0.03F + 0.26F + headX;
        this.Hair01.zRot = 0F;
        this.Hair02.xRot = -angleX1 * 0.04F - 0.087F + headX;
        this.Hair02.zRot = 0F;
        this.Hair03.xRot = -angleX2 * 0.07F - 0.052F;
        this.Hair03.zRot = 0F;
        // arm
        this.ArmLeft01.xRot = -0.26F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = 0.28F;
        this.ArmLeft02.xRot = 0F;
        this.ArmLeft02.yRot = 0F;
        this.ArmLeft02.zRot = 0F;
        // this.ArmLeft02.offsetX = 0F;
        // this.ArmLeft02.offsetZ = 0F;
        this.ArmRight01.xRot = -0.26F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = -0.28F;
        this.ArmRight02.xRot = 0F;
        this.ArmRight02.yRot = 0F;
        this.ArmRight02.zRot = 0F;
        // this.ArmRight02.offsetX = 0F;
        // this.ArmRight02.offsetZ = 0F;
        // leg
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.087F;
        // this.LegLeft01.offsetY = 0F;
        // this.LegLeft01.offsetZ = 0F;
        this.LegLeft02.xRot = 0F;
        this.LegLeft02.yRot = 0F;
        this.LegLeft02.zRot = 0F;
        // this.LegLeft02.offsetX = 0F;
        // this.LegLeft02.offsetY = 0F;
        // this.LegLeft02.offsetZ = 0F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.087F;
        // this.LegRight01.offsetY = 0F;
        // this.LegRight01.offsetZ = 0F;
        this.LegRight02.xRot = 0F;
        this.LegRight02.yRot = 0F;
        this.LegRight02.zRot = 0F;
        // this.LegRight02.offsetX = 0F;
        // this.LegRight02.offsetY = 0F;
        // this.LegRight02.offsetZ = 0F;

        // 奔跑動作
        if (ent.getIsSprinting() || f1 > 0.9F) {
            // hair angleX * 0.03F + 0.21F + headX
            this.Hair01.xRot = angleAdd1 * 0.1F + f1 * 0.4F + headX;
            this.Hair02.xRot += 0F;
            this.Hair03.xRot += 0.1F;
            // 胸部
            this.BoobL.xRot = angleAdd2 * 0.1F - 0.83F;
            this.BoobL.zRot = -0.07F;
            this.BoobR.xRot = angleAdd1 * 0.1F - 0.83F;
            this.BoobR.zRot = 0.07F;
            // arm
            this.ArmLeft01.xRot = angleAdd2 * 0.8F + 0.1745F;
            this.ArmLeft01.yRot = 0F;
            this.ArmLeft01.zRot = -0.35F;
            this.ArmRight01.xRot = angleAdd1 * 0.8F + 0.1745F;
            this.ArmRight01.yRot = 0F;
            this.ArmRight01.zRot = 0.35F;
        }

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        // 潛行跟蹲下動作
        if (ent.getIsSneaking()) {
            // Body
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.09F;
            this.Head.xRot -= 0.6283F;
            this.BodyMain.xRot = 0.8727F;
            this.Skirt01.xRot = -0.34F;
            // this.Skirt01.offsetY = -0.2F;
            // this.Skirt01.offsetZ = 0.03F;
            this.Skirt02.xRot = -0.27F;
            this.Skirt03.xRot = -0.22F;
            if (this.Collar01 != null)
                this.Collar01.xRot -= 0.35F;
            // 胸部
            this.BoobL.xRot -= 0.2F;
            this.BoobL.zRot = -0.04F;
            this.BoobR.xRot -= 0.2F;
            this.BoobR.zRot = 0.04F;
            // arm
            this.ArmLeft01.xRot = -0.35F;
            this.ArmLeft01.zRot = 0.2618F;
            this.ArmRight01.xRot = -0.35F;
            this.ArmRight01.zRot = -0.2618F;
            // leg
            addk1 -= 0.94F;
            addk2 -= 0.94F;
            this.LegLeft01.zRot = 0.2F;
            this.LegRight01.zRot = -0.2F;
            // hair
            this.Hair01.xRot = this.Hair01.xRot * 0.5F + 0.4F;
            this.Hair02.xRot = this.Hair02.xRot * 0.75F + 0.25F;
            this.Hair03.xRot -= 0.1F;
        } // end if sneaking

        // 坐下動作
        if (ent.getIsSitting() && !ent.getIsRiding()) {
            if (ent.getTickExisted() % 512 > 256) {
                // body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.51F;
                this.Head.xRot -= 0.7F;
                this.BodyMain.xRot = 0.35F;
                this.Skirt01.xRot = -0.23F;
                // this.Skirt01.offsetY = -0.23F;
                this.Skirt02.xRot = -0.2F;
                // this.Skirt02.offsetY = -0.17F;
                this.Skirt03.xRot = -0.2F;
                // this.Skirt03.offsetY = -0.15F;
                if (this.Collar01 != null)
                    this.Collar01.xRot -= 0.35F;
                // arm
                this.ArmLeft01.xRot = -0.5235987755982988F;
                this.ArmLeft01.yRot = 0.0F;
                this.ArmLeft01.zRot = 0.3490658503988659F;
                this.ArmLeft02.xRot = 0F;
                this.ArmLeft02.zRot = 0F;
                // this.ArmLeft02.offsetX = 0F;
                // this.ArmLeft02.offsetZ = 0F;
                this.ArmRight01.xRot = -0.5235987755982988F;
                this.ArmRight01.yRot = 0.0F;
                this.ArmRight01.zRot = -0.3490658503988659F;
                this.ArmRight02.xRot = 0F;
                this.ArmRight02.zRot = 0F;
                // this.ArmRight02.offsetX = 0F;
                // this.ArmRight02.offsetZ = 0F;
                // leg
                addk1 = -1.4486232791552935F;
                addk2 = -1.4486232791552935F;
                this.LegLeft01.yRot = -0.5235987755982988F;
                this.LegLeft01.zRot = -1.3962634015954636F;
                this.LegLeft02.xRot = 2.1816615649929116F;
                this.LegLeft02.yRot = 0.0F;
                this.LegLeft02.zRot = 0.0F;
                // this.LegLeft02.offsetX = 0F;
                // this.LegLeft02.offsetZ = 0.37F;
                this.LegRight01.yRot = 0.5235987755982988F;
                this.LegRight01.zRot = 1.3962634015954636F;
                this.LegRight02.xRot = 2.1816615649929116F;
                this.LegRight02.yRot = 0.0F;
                this.LegRight02.zRot = 0.0F;
                // this.LegRight02.offsetX = 0F;
                // this.LegRight02.offsetZ = 0.37F;
                // hair
                this.Hair01.xRot += 0.2F;
                this.Hair02.xRot += 0.5F;
                this.Hair03.xRot += 0.4F;
            } else {
                if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                    // Body
                    // [PORT] Restored from 1.10.2 GlStateManager.translate
                    this.offsetY += 0.43F;
                    this.Head.xRot -= 0.1F;
                    this.BodyMain.xRot = 0F;
                    this.Butt.xRot = -0.2F;
                    // this.Butt.offsetY = 0F;
                    this.BoobL.xRot -= 0.1F;
                    this.BoobL.zRot = 0.16F;
                    this.BoobR.xRot -= 0.1F;
                    this.BoobR.zRot = -0.16F;
                    // skirt
                    this.Skirt01.xRot = -0.05F;
                    // this.Skirt01.offsetY = -0.1F;
                    this.Skirt02.xRot = -0.15F;
                    // this.Skirt02.offsetY = -0.1F;
                    this.Skirt03.xRot = -0.1F;
                    // this.Skirt03.offsetY = -0.1F;
                    // arm
                    this.ArmLeft01.xRot = -0.6F;
                    this.ArmLeft01.zRot = 0.1F;
                    this.ArmLeft02.zRot = 0.39F;
                    this.ArmRight01.xRot = -0.6F;
                    this.ArmRight01.zRot = -0.1F;
                    this.ArmRight02.zRot = -0.39F;
                    // leg
                    addk1 = -0.9F;
                    addk2 = -0.9F;
                    this.LegLeft01.yRot = 0.19F;
                    this.LegLeft01.zRot = 0F;
                    this.LegLeft02.xRot = 2.67F;
                    this.LegLeft02.zRot = 0.0175F;
                    // this.LegLeft02.offsetZ = 0.375F;
                    this.LegRight01.yRot = -0.19F;
                    this.LegRight01.zRot = 0F;
                    this.LegRight02.xRot = 2.67F;
                    this.LegRight02.zRot = -0.0175F;
                    // this.LegRight02.offsetZ = 0.375F;
                    // tako
                    // this.renderTako = true;
                    // tako1 = this.miscModelList.get(0);
                    // tako1.entity.ticksExisted = ent.getTickExisted();
                    // tako1.entity.posY = 0.34F;
                } else {
                    // Body
                    this.Head.xRot -= 0.1F;
                    this.BodyMain.xRot = 0F;
                    this.Butt.xRot = -0.2F;
                    // this.Butt.offsetY = 0F;
                    this.BoobL.xRot -= 0.1F;
                    this.BoobL.zRot = 0.16F;
                    this.BoobR.xRot -= 0.1F;
                    this.BoobR.zRot = -0.16F;
                    // skirt
                    this.Skirt01.xRot = -0.05F;
                    // this.Skirt01.offsetY = -0.1F;
                    this.Skirt02.xRot = -0.15F;
                    // this.Skirt02.offsetY = -0.1F;
                    this.Skirt03.xRot = -0.1F;
                    // this.Skirt03.offsetY = -0.1F;
                    // arm
                    this.ArmLeft01.xRot = -0.46F;
                    this.ArmLeft01.zRot = 0.35F;
                    this.ArmRight01.xRot = -0.46F;
                    this.ArmRight01.zRot = -0.35F;
                    // leg
                    addk1 = -0.9F;
                    addk2 = -0.9F;
                    this.LegLeft01.yRot = 0.19F;
                    this.LegLeft01.zRot = 0F;
                    this.LegLeft02.xRot = 2.67F;
                    this.LegLeft02.zRot = 0.0175F;
                    // this.LegLeft02.offsetZ = 0.375F;
                    this.LegRight01.yRot = -0.19F;
                    this.LegRight01.zRot = 0F;
                    this.LegRight02.xRot = 2.67F;
                    this.LegRight02.zRot = -0.0175F;
                    // this.LegRight02.offsetZ = 0.375F;
                }
            }
        } // end sitting

        // 騎乘專屬坐騎動作
        if (ent.getIsRiding()) {
            if (((net.minecraft.world.entity.Entity) ent).getVehicle() instanceof BasicEntityMount) {
                if (ent.getIsSitting()) {
                    if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {

                        // Body
                        this.Head.xRot -= 0.1F;
                        this.BodyMain.xRot = 0F;
                        this.Butt.xRot = -0.2F;
                        // this.Butt.offsetY = 0F;
                        this.BoobL.xRot -= 0.1F;
                        this.BoobL.zRot = 0.16F;
                        this.BoobR.xRot -= 0.1F;
                        this.BoobR.zRot = -0.16F;
                        // skirt
                        this.Skirt01.xRot = -0.05F;
                        // this.Skirt01.offsetY = -0.1F;
                        this.Skirt02.xRot = -0.15F;
                        // this.Skirt02.offsetY = -0.1F;
                        this.Skirt03.xRot = -0.1F;
                        // this.Skirt03.offsetY = -0.1F;
                        // arm
                        this.ArmLeft01.xRot = -0.6F;
                        this.ArmLeft01.zRot = 0.1F;
                        this.ArmLeft02.zRot = 0.39F;
                        this.ArmRight01.xRot = -0.6F;
                        this.ArmRight01.zRot = -0.1F;
                        this.ArmRight02.zRot = -0.39F;
                        // leg
                        addk1 = -0.9F;
                        addk2 = -0.9F;
                        this.LegLeft01.yRot = 0.19F;
                        this.LegLeft01.zRot = 0F;
                        this.LegLeft02.xRot = 2.67F;
                        this.LegLeft02.zRot = 0.0175F;
                        // this.LegLeft02.offsetZ = 0.375F;
                        this.LegRight01.yRot = -0.19F;
                        this.LegRight01.zRot = 0F;
                        this.LegRight02.xRot = 2.67F;
                        this.LegRight02.zRot = -0.0175F;
                        // this.LegRight02.offsetZ = 0.375F;
                        // tako
                        // this.renderTako = true;
                        // tako1 = this.miscModelList.get(0);
                        // tako1.entity.ticksExisted = ent.getTickExisted();
                        // tako1.entity.posY = -1.12F;
                    } else {

                        // Body
                        this.Head.xRot -= 0.1F;
                        this.BodyMain.xRot = 0F;
                        this.Butt.xRot = -0.2F;
                        // this.Butt.offsetY = 0F;
                        this.BoobL.xRot -= 0.1F;
                        this.BoobL.zRot = 0.16F;
                        this.BoobR.xRot -= 0.1F;
                        this.BoobR.zRot = -0.16F;
                        // skirt
                        this.Skirt01.xRot = -0.05F;
                        // this.Skirt01.offsetY = -0.1F;
                        this.Skirt02.xRot = -0.15F;
                        // this.Skirt02.offsetY = -0.1F;
                        this.Skirt03.xRot = -0.1F;
                        // this.Skirt03.offsetY = -0.1F;
                        // arm
                        this.ArmLeft01.xRot = -0.46F;
                        this.ArmLeft01.zRot = 0.35F;
                        this.ArmRight01.xRot = -0.46F;
                        this.ArmRight01.zRot = -0.35F;
                        // leg
                        addk1 = -0.9F;
                        addk2 = -0.9F;
                        this.LegLeft01.yRot = 0.19F;
                        this.LegLeft01.zRot = 0F;
                        this.LegLeft02.xRot = 2.67F;
                        this.LegLeft02.zRot = 0.0175F;
                        // this.LegLeft02.offsetZ = 0.375F;
                        this.LegRight01.yRot = -0.19F;
                        this.LegRight01.zRot = 0F;
                        this.LegRight02.xRot = 2.67F;
                        this.LegRight02.zRot = -0.0175F;
                        // this.LegRight02.offsetZ = 0.375F;
                    }
                } // end if sitting
                else {

                    // body
                    this.Head.xRot -= 0.7F;
                    this.BodyMain.xRot = 0.35F;
                    this.Skirt01.xRot = -0.23F;
                    // this.Skirt01.offsetY = -0.23F;
                    this.Skirt02.xRot = -0.2F;
                    // this.Skirt02.offsetY = -0.17F;
                    this.Skirt03.xRot = -0.2F;
                    // this.Skirt03.offsetY = -0.15F;
                    if (this.Collar01 != null)
                        this.Collar01.xRot -= 0.35F;
                    // arm
                    this.ArmLeft01.xRot = -0.5235987755982988F;
                    this.ArmLeft01.yRot = 0.0F;
                    this.ArmLeft01.zRot = 0.3490658503988659F;
                    this.ArmLeft02.xRot = 0F;
                    this.ArmLeft02.zRot = 0F;
                    // this.ArmLeft02.offsetX = 0F;
                    // this.ArmLeft02.offsetZ = 0F;
                    this.ArmRight01.xRot = -0.5235987755982988F;
                    this.ArmRight01.yRot = 0.0F;
                    this.ArmRight01.zRot = -0.3490658503988659F;
                    this.ArmRight02.xRot = 0F;
                    this.ArmRight02.zRot = 0F;
                    // this.ArmRight02.offsetX = 0F;
                    // this.ArmRight02.offsetZ = 0F;
                    // leg
                    addk1 = -1.4486232791552935F;
                    addk2 = -1.4486232791552935F;
                    this.LegLeft01.yRot = -0.5235987755982988F;
                    this.LegLeft01.zRot = -1.3962634015954636F;
                    this.LegLeft02.xRot = 2.1816615649929116F;
                    this.LegLeft02.yRot = 0.0F;
                    this.LegLeft02.zRot = 0.0F;
                    // this.LegLeft02.offsetX = 0F;
                    // this.LegLeft02.offsetZ = 0.37F;
                    this.LegRight01.yRot = 0.5235987755982988F;
                    this.LegRight01.zRot = 1.3962634015954636F;
                    this.LegRight02.xRot = 2.1816615649929116F;
                    this.LegRight02.yRot = 0.0F;
                    this.LegRight02.zRot = 0.0F;
                    // this.LegRight02.offsetX = 0F;
                    // this.LegRight02.offsetZ = 0.37F;
                    // hair
                    if (ent.getIsSprinting() || f1 > 0.9F) {
                        this.Hair01.xRot += 0.5F;
                        this.Hair02.xRot += 0.4F;
                        this.Hair03.xRot += 0.2F;
                    } else {
                        this.Hair01.xRot += 0.2F;
                        this.Hair02.xRot += 0.4F;
                        this.Hair03.xRot += 0.2F;
                    }
                }
            } // end ship mount
            // normal mount ex: cart
            else {
                if (ent.getIsSitting()) {
                    if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {

                        // Body
                        this.Head.xRot -= 0.1F;
                        this.BodyMain.xRot = 0F;
                        this.Butt.xRot = -0.2F;
                        // this.Butt.offsetY = 0F;
                        this.BoobL.xRot -= 0.1F;
                        this.BoobL.zRot = 0.16F;
                        this.BoobR.xRot -= 0.1F;
                        this.BoobR.zRot = -0.16F;
                        // skirt
                        this.Skirt01.xRot = -0.05F;
                        // this.Skirt01.offsetY = -0.1F;
                        this.Skirt02.xRot = -0.15F;
                        // this.Skirt02.offsetY = -0.1F;
                        this.Skirt03.xRot = -0.1F;
                        // this.Skirt03.offsetY = -0.1F;
                        // arm
                        this.ArmLeft01.xRot = -0.6F;
                        this.ArmLeft01.zRot = 0.1F;
                        this.ArmLeft02.zRot = 0.39F;
                        this.ArmRight01.xRot = -0.6F;
                        this.ArmRight01.zRot = -0.1F;
                        this.ArmRight02.zRot = -0.39F;
                        // leg
                        addk1 = -0.9F;
                        addk2 = -0.9F;
                        this.LegLeft01.yRot = 0.19F;
                        this.LegLeft01.zRot = 0F;
                        this.LegLeft02.xRot = 2.67F;
                        this.LegLeft02.zRot = 0.0175F;
                        // this.LegLeft02.offsetZ = 0.375F;
                        this.LegRight01.yRot = -0.19F;
                        this.LegRight01.zRot = 0F;
                        this.LegRight02.xRot = 2.67F;
                        this.LegRight02.zRot = -0.0175F;
                        // this.LegRight02.offsetZ = 0.375F;
                        // tako
                        // this.renderTako = true;
                        // tako1 = this.miscModelList.get(0);
                        // tako1.entity.ticksExisted = ent.getTickExisted();
                        // tako1.entity.posY = 0.34F;
                    } else {

                        // Body
                        this.Head.xRot -= 0.1F;
                        this.BodyMain.xRot = 0F;
                        this.Butt.xRot = -0.2F;
                        // this.Butt.offsetY = 0F;
                        this.BoobL.xRot -= 0.1F;
                        this.BoobL.zRot = 0.16F;
                        this.BoobR.xRot -= 0.1F;
                        this.BoobR.zRot = -0.16F;
                        // skirt
                        this.Skirt01.xRot = -0.05F;
                        // this.Skirt01.offsetY = -0.1F;
                        this.Skirt02.xRot = -0.15F;
                        // this.Skirt02.offsetY = -0.1F;
                        this.Skirt03.xRot = -0.1F;
                        // this.Skirt03.offsetY = -0.1F;
                        // arm
                        this.ArmLeft01.xRot = -0.46F;
                        this.ArmLeft01.zRot = 0.35F;
                        this.ArmRight01.xRot = -0.46F;
                        this.ArmRight01.zRot = -0.35F;
                        // leg
                        addk1 = -0.9F;
                        addk2 = -0.9F;
                        this.LegLeft01.yRot = 0.19F;
                        this.LegLeft01.zRot = 0F;
                        this.LegLeft02.xRot = 2.67F;
                        this.LegLeft02.zRot = 0.0175F;
                        // this.LegLeft02.offsetZ = 0.375F;
                        this.LegRight01.yRot = -0.19F;
                        this.LegRight01.zRot = 0F;
                        this.LegRight02.xRot = 2.67F;
                        this.LegRight02.zRot = -0.0175F;
                        // this.LegRight02.offsetZ = 0.375F;
                    }
                } else {

                    // body
                    this.Head.xRot -= 0.7F;
                    this.BodyMain.xRot = 0.35F;
                    this.Skirt01.xRot = -0.23F;
                    // this.Skirt01.offsetY = -0.23F;
                    this.Skirt02.xRot = -0.2F;
                    // this.Skirt02.offsetY = -0.17F;
                    this.Skirt03.xRot = -0.2F;
                    // this.Skirt03.offsetY = -0.15F;
                    if (this.Collar01 != null)
                        this.Collar01.xRot -= 0.35F;
                    // arm
                    this.ArmLeft01.xRot = -0.5235987755982988F;
                    this.ArmLeft01.yRot = 0.0F;
                    this.ArmLeft01.zRot = 0.3490658503988659F;
                    this.ArmLeft02.xRot = 0F;
                    this.ArmLeft02.zRot = 0F;
                    // this.ArmLeft02.offsetX = 0F;
                    // this.ArmLeft02.offsetZ = 0F;
                    this.ArmRight01.xRot = -0.5235987755982988F;
                    this.ArmRight01.yRot = 0.0F;
                    this.ArmRight01.zRot = -0.3490658503988659F;
                    this.ArmRight02.xRot = 0F;
                    this.ArmRight02.zRot = 0F;
                    // this.ArmRight02.offsetX = 0F;
                    // this.ArmRight02.offsetZ = 0F;
                    // leg
                    addk1 = -1.4486232791552935F;
                    addk2 = -1.4486232791552935F;
                    this.LegLeft01.yRot = -0.5235987755982988F;
                    this.LegLeft01.zRot = -1.3962634015954636F;
                    this.LegLeft02.xRot = 2.1816615649929116F;
                    this.LegLeft02.yRot = 0.0F;
                    this.LegLeft02.zRot = 0.0F;
                    // this.LegLeft02.offsetX = 0F;
                    // this.LegLeft02.offsetZ = 0.37F;
                    this.LegRight01.yRot = 0.5235987755982988F;
                    this.LegRight01.zRot = 1.3962634015954636F;
                    this.LegRight02.xRot = 2.1816615649929116F;
                    this.LegRight02.yRot = 0.0F;
                    this.LegRight02.zRot = 0.0F;
                    // this.LegRight02.offsetX = 0F;
                    // this.LegRight02.offsetZ = 0.37F;
                    // hair
                    this.Hair01.xRot += 0.2F;
                    this.Hair02.xRot += 0.5F;
                    this.Hair03.xRot += 0.4F;
                }
            }
        } // end ridding

        // 攻擊動作
        if (ent.getAttackTick() > 0) {
            if (ent.getAttackTick() > 20) {
                // arm
                this.ArmLeft01.xRot = -1.7F + this.Head.xRot * 0.75F;
                this.ArmLeft01.yRot = -0.2F;
                this.ArmLeft01.zRot = 0F;
                this.ArmLeft02.xRot = 0F;
                this.ArmLeft02.yRot = 0F;
                this.ArmLeft02.zRot = 0F;
                // this.ArmLeft02.offsetX = 0F;
                // this.ArmLeft02.offsetZ = 0F;
            }

            this.GlowBodyMain2a.xRot = this.ArmLeft01.xRot * -0.3F;

            // 跑道顯示
            // Road visual parts are positioned statically in the constructor; no runtime
            // animation needed
        }

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

        // 移動頭髮避免穿過身體
        headX = this.Head.xRot * -0.5F;
        this.HairL01.xRot = angleX * 0.02F + headX - 0.19F;
        this.HairL02.xRot = -angleX1 * 0.04F + headX + 0.17F;
        this.HairR01.xRot = angleX * 0.02F + headX - 0.19F;
        this.HairR02.xRot = -angleX1 * 0.04F + headX + 0.17F;
        headZ = this.Head.zRot * -0.5F;
        this.Hair01.zRot = headZ;
        this.Hair02.zRot = headZ;
        this.Hair03.zRot = headZ;
        this.HairL01.zRot = headZ - 0.087F;
        this.HairL02.zRot = headZ + 0.087F;
        this.HairR01.zRot = headZ + 0.087F;
        this.HairR02.zRot = headZ - 0.052F;

        // leg motion
        this.LegLeft01.xRot = addk1;
        this.LegRight01.xRot = addk2;
    }
}
