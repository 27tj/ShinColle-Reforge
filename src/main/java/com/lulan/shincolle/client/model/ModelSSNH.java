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

public class ModelSSNH extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "ssnh"), "main");

    private final ModelPart BodyMain;
    private final ModelPart ArmLeft01;
    private final ModelPart ArmRight01;
    private final ModelPart Butt;
    private final ModelPart EquipBase;
    private final ModelPart Cloth01;
    private final ModelPart Neck;
    private final ModelPart Cloth00;
    private final ModelPart RingBase;
    private final ModelPart ArmLeft02;
    private final ModelPart EquipTBase;
    private final ModelPart EqyuipT01;
    private final ModelPart EqyuipT02;
    private final ModelPart EqyuipT04;
    private final ModelPart EqyuipT03;
    private final ModelPart EquipT03a;
    private final ModelPart EqyuipT05;
    private final ModelPart EquipT05a;
    private final ModelPart EquipT05b;
    private final ModelPart EquipT05c;
    private final ModelPart EquipT05d;
    private final ModelPart EquipTBase_2;
    private final ModelPart EqyuipT01_2;
    private final ModelPart EqyuipT02_2;
    private final ModelPart EqyuipT04_2;
    private final ModelPart EqyuipT03_2;
    private final ModelPart EquipT03a_2;
    private final ModelPart EqyuipT05_2;
    private final ModelPart EquipT05a_2;
    private final ModelPart EquipT05b_2;
    private final ModelPart EquipT05c_2;
    private final ModelPart EquipT05d_2;
    private final ModelPart ArmRight02;
    private final ModelPart EquipHandRing;
    private final ModelPart LegRight01;
    private final ModelPart LegLeft01;
    private final ModelPart LegRight02;
    private final ModelPart LegLeft02;
    private final ModelPart Cloth02;
    private final ModelPart Cloth03;
    private final ModelPart Cloth04;
    private final ModelPart Head;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart Ahoke01;
    private final ModelPart Ahoke01a;
    private final ModelPart HairU01;
    private final ModelPart Hair01;
    private final ModelPart Hair02;
    private final ModelPart Ahoke02;
    private final ModelPart Ahoke03;
    private final ModelPart Ahoke04;
    private final ModelPart Ahoke05;
    private final ModelPart Ahoke06;
    private final ModelPart Ahoke02a;
    private final ModelPart Ahoke03a;
    private final ModelPart Ahoke04a;
    private final ModelPart Ahoke05a;
    private final ModelPart Ahoke06a;
    private final ModelPart Ring01;
    private final ModelPart Ring02;
    private final ModelPart Ring03Base;
    private final ModelPart Ring03a;
    private final ModelPart Ring03b;
    private final ModelPart Ring03c;
    private final ModelPart Ring03d;
    private final ModelPart Ring03e;
    private final ModelPart Ring03f;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowNeck;
    private final ModelPart GlowHead;

    public ModelSSNH(ModelPart root) {
        super();
        this.scale = 0.32F;
        this.offsetY = 3.21F;
        this.BodyMain = root.getChild("BodyMain");
        this.Butt = this.BodyMain.getChild("Butt");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.Cloth00 = this.BodyMain.getChild("Cloth00");
        this.Neck = this.BodyMain.getChild("Neck");
        this.EquipBase = this.BodyMain.getChild("EquipBase");
        this.Cloth01 = this.BodyMain.getChild("Cloth01");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.RingBase = this.BodyMain.getChild("RingBase");
        this.LegLeft01 = this.Butt.getChild("LegLeft01");
        this.LegRight01 = this.Butt.getChild("LegRight01");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.Head = this.Neck.getChild("Head");
        this.Cloth02 = this.Cloth01.getChild("Cloth02");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.Ring01 = this.RingBase.getChild("Ring01");
        this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.EquipTBase = this.ArmLeft02.getChild("EquipTBase");
        this.Hair = this.Head.getChild("Hair");
        this.Ahoke01 = this.Head.getChild("Ahoke01");
        this.Ahoke01a = this.Head.getChild("Ahoke01a");
        this.HairMain = this.Head.getChild("HairMain");
        this.Cloth03 = this.Cloth02.getChild("Cloth03");
        this.EquipHandRing = this.ArmRight02.getChild("EquipHandRing");
        this.EquipTBase_2 = this.ArmRight02.getChild("EquipTBase_2");
        this.Ring02 = this.Ring01.getChild("Ring02");
        this.EqyuipT01 = this.EquipTBase.getChild("EqyuipT01");
        this.HairU01 = this.Hair.getChild("HairU01");
        this.Ahoke02 = this.Ahoke01.getChild("Ahoke02");
        this.Ahoke02a = this.Ahoke01a.getChild("Ahoke02a");
        this.Hair01 = this.HairMain.getChild("Hair01");
        this.Cloth04 = this.Cloth03.getChild("Cloth04");
        this.EqyuipT01_2 = this.EquipTBase_2.getChild("EqyuipT01_2");
        this.Ring03Base = this.Ring02.getChild("Ring03Base");
        this.EqyuipT02 = this.EqyuipT01.getChild("EqyuipT02");
        this.EqyuipT04 = this.EqyuipT01.getChild("EqyuipT04");
        this.Ahoke03 = this.Ahoke02.getChild("Ahoke03");
        this.Ahoke03a = this.Ahoke02a.getChild("Ahoke03a");
        this.Hair02 = this.Hair01.getChild("Hair02");
        this.EqyuipT02_2 = this.EqyuipT01_2.getChild("EqyuipT02_2");
        this.EqyuipT04_2 = this.EqyuipT01_2.getChild("EqyuipT04_2");
        this.Ring03b = this.Ring03Base.getChild("Ring03b");
        this.Ring03c = this.Ring03Base.getChild("Ring03c");
        this.Ring03a = this.Ring03Base.getChild("Ring03a");
        this.Ring03e = this.Ring03Base.getChild("Ring03e");
        this.Ring03d = this.Ring03Base.getChild("Ring03d");
        this.Ring03f = this.Ring03Base.getChild("Ring03f");
        this.EqyuipT03 = this.EqyuipT02.getChild("EqyuipT03");
        this.EqyuipT05 = this.EqyuipT04.getChild("EqyuipT05");
        this.Ahoke04 = this.Ahoke03.getChild("Ahoke04");
        this.Ahoke04a = this.Ahoke03a.getChild("Ahoke04a");
        this.EqyuipT03_2 = this.EqyuipT02_2.getChild("EqyuipT03_2");
        this.EqyuipT05_2 = this.EqyuipT04_2.getChild("EqyuipT05_2");
        this.EquipT03a = this.EqyuipT03.getChild("EquipT03a");
        this.EquipT05b = this.EqyuipT05.getChild("EquipT05b");
        this.EquipT05c = this.EqyuipT05.getChild("EquipT05c");
        this.EquipT05a = this.EqyuipT05.getChild("EquipT05a");
        this.EquipT05d = this.EqyuipT05.getChild("EquipT05d");
        this.Ahoke05 = this.Ahoke04.getChild("Ahoke05");
        this.Ahoke05a = this.Ahoke04a.getChild("Ahoke05a");
        this.EquipT03a_2 = this.EqyuipT03_2.getChild("EquipT03a_2");
        this.EquipT05a_2 = this.EqyuipT05_2.getChild("EquipT05a_2");
        this.EquipT05b_2 = this.EqyuipT05_2.getChild("EquipT05b_2");
        this.EquipT05c_2 = this.EqyuipT05_2.getChild("EquipT05c_2");
        this.EquipT05d_2 = this.EqyuipT05_2.getChild("EquipT05d_2");
        this.Ahoke06 = this.Ahoke05.getChild("Ahoke06");
        this.Ahoke06a = this.Ahoke05a.getChild("Ahoke06a");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowNeck = this.GlowBodyMain.getChild("GlowNeck");
        this.GlowHead = this.GlowNeck.getChild("GlowHead");
        this.loadFaceParts(this.GlowHead);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 113)
                        .addBox(-5.5F, -11.0F, -3.5F, 11.0F, 9.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(0, 78)
                        .addBox(-5.5F, 0.0F, 0.0F, 11.0F, 6.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, -2.0F, -4.0F, 0.20943951023931953F, 0.0F, 0.0F));

        PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().mirror().texOffs(0, 98)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 9.0F, 5.0F),
                PartPose.offsetAndRotation(3.2F, 5.5F, 2.4F, -0.10471975511965977F, 0.0F, -0.05235987755982988F));

        legLeft01.addOrReplaceChild("LegLeft02",
                CubeListBuilder.create().mirror().texOffs(0, 98)
                        .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 10.0F, 5.0F),
                PartPose.offset(0.0F, 9.0F, -2.5F));

        PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().texOffs(0, 98)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 9.0F, 5.0F),
                PartPose.offsetAndRotation(-3.2F, 5.5F, 2.4F, -0.10471975511965977F, 0.0F, 0.05235987755982988F));

        legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().texOffs(0, 98)
                        .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 10.0F, 5.0F),
                PartPose.offset(0.0F, 9.0F, -2.5F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().mirror().texOffs(2, 99)
                        .addBox(-1.0F, -1.0F, -2.0F, 4.0F, 8.0F, 4.0F),
                PartPose.offsetAndRotation(6.0F, -9.3F, -0.7F, 0.13962634015954636F, 0.0F, -0.2617993877991494F));

        PartDefinition armLeft02 = armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().mirror().texOffs(2, 99)
                        .addBox(-4.0F, 0.0F, -4.0F, 4.0F, 9.0F, 4.0F),
                PartPose.offset(3.0F, 7.0F, 2.0F));

        PartDefinition equipTBase = armLeft02.addOrReplaceChild("EquipTBase",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offsetAndRotation(-2.6F, 9.0F, -2.0F, 0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition eqyuipT01 = equipTBase.addOrReplaceChild("EqyuipT01",
                CubeListBuilder.create().texOffs(5, 0)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5707963267948966F, 0.0F, 0.0F));

        PartDefinition eqyuipT02 = eqyuipT01.addOrReplaceChild("EqyuipT02",
                CubeListBuilder.create().texOffs(4, 0)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F),
                PartPose.offset(0.0F, 6.9F, 0.0F));

        PartDefinition eqyuipT03 = eqyuipT02.addOrReplaceChild("EqyuipT03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F),
                PartPose.offset(0.0F, 6.9F, 0.0F));

        eqyuipT03.addOrReplaceChild("EquipT03a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 1.0F, 3.0F),
                PartPose.offset(0.0F, 6.9F, 0.0F));

        PartDefinition eqyuipT04 = eqyuipT01.addOrReplaceChild("EqyuipT04",
                CubeListBuilder.create().texOffs(3, 4)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F),
                PartPose.offset(0.0F, -6.9F, 0.0F));

        PartDefinition eqyuipT05 = eqyuipT04.addOrReplaceChild("EqyuipT05",
                CubeListBuilder.create().texOffs(2, 3)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, -6.9F, 0.0F, 0.0F, 0.0F, 0.02142916587671676F));

        eqyuipT05.addOrReplaceChild("EquipT05b",
                CubeListBuilder.create().texOffs(14, 4)
                        .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 6.0F, 2.0F),
                PartPose.offsetAndRotation(-1.9F, 1.0F, 0.0F, 0.0F, -1.5707963267948966F, 0.0F));

        eqyuipT05.addOrReplaceChild("EquipT05c",
                CubeListBuilder.create().texOffs(0, 4)
                        .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 6.0F, 2.0F),
                PartPose.offsetAndRotation(1.9F, 1.0F, 0.0F, 0.0F, 1.5707963267948966F, 0.0F));

        eqyuipT05.addOrReplaceChild("EquipT05a",
                CubeListBuilder.create().texOffs(8, 7)
                        .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 6.0F, 2.0F),
                PartPose.offset(0.0F, 1.0F, 1.9F));

        eqyuipT05.addOrReplaceChild("EquipT05d",
                CubeListBuilder.create().texOffs(0, 8)
                        .addBox(-0.5F, 0.0F, -2.0F, 1.0F, 6.0F, 2.0F),
                PartPose.offset(0.0F, 1.0F, -1.9F));

        bodyMain.addOrReplaceChild("Cloth00",
                CubeListBuilder.create().texOffs(56, 41)
                        .addBox(-6.0F, 0.0F, -2.9F, 12.0F, 8.0F, 7.0F),
                PartPose.offset(0.0F, -11.3F, -1.0F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(2, 99)
                        .addBox(-2.0F, -2.0F, -2.0F, 4.0F, 2.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, -10.3F, 0.2F, 0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offset(0.0F, -1.5F, -1.0F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(50, 77)
                        .addBox(-8.0F, -8.0F, -7.4F, 16.0F, 16.0F, 8.0F),
                PartPose.offset(0.0F, -7.6F, 0.1F));

        hair.addOrReplaceChild("HairU01",
                CubeListBuilder.create().texOffs(52, 56)
                        .addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F),
                PartPose.offset(0.0F, -6.0F, -7.0F));

        PartDefinition ahoke01 = head.addOrReplaceChild("Ahoke01",
                CubeListBuilder.create().texOffs(50, 77)
                        .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 0.0F),
                PartPose.offsetAndRotation(-1.0F, -15.0F, 0.0F, -2.007128639793479F, 0.5235987755982988F, 0.0F));

        PartDefinition ahoke02 = ahoke01.addOrReplaceChild("Ahoke02",
                CubeListBuilder.create().texOffs(50, 77)
                        .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 7.9F, 0.0F, 1.0471975511965976F, -0.05235987755982988F, 0.0F));

        PartDefinition ahoke03 = ahoke02.addOrReplaceChild("Ahoke03",
                CubeListBuilder.create().texOffs(50, 79)
                        .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 7.9F, 0.0F, 0.7853981633974483F, 0.05235987755982988F, 0.0F));

        PartDefinition ahoke04 = ahoke03.addOrReplaceChild("Ahoke04",
                CubeListBuilder.create().texOffs(50, 77)
                        .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, 0.4363323129985824F, 0.05235987755982988F, 0.0F));

        PartDefinition ahoke05 = ahoke04.addOrReplaceChild("Ahoke05",
                CubeListBuilder.create().texOffs(50, 79)
                        .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 7.9F, 0.0F, -0.17453292519943295F, 0.08726646259971647F, 0.0F));

        ahoke05.addOrReplaceChild("Ahoke06",
                CubeListBuilder.create().texOffs(42, 90)
                        .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, -0.4363323129985824F, 0.08726646259971647F, 0.0F));

        PartDefinition ahoke01a = head.addOrReplaceChild("Ahoke01a",
                CubeListBuilder.create().texOffs(50, 79)
                        .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, -15.0F, -1.5F, -2.2689280275926285F, -2.6179938779914944F, 0.0F));

        PartDefinition ahoke02a = ahoke01a.addOrReplaceChild("Ahoke02a",
                CubeListBuilder.create().texOffs(50, 79)
                        .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, 0.7853981633974483F, -0.05235987755982988F, 0.0F));

        PartDefinition ahoke03a = ahoke02a.addOrReplaceChild("Ahoke03a",
                CubeListBuilder.create().texOffs(50, 79)
                        .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, 1.0471975511965976F, 0.05235987755982988F, 0.0F));

        PartDefinition ahoke04a = ahoke03a.addOrReplaceChild("Ahoke04a",
                CubeListBuilder.create().texOffs(50, 77)
                        .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, 0.4886921905584123F, 0.05235987755982988F, 0.0F));

        PartDefinition ahoke05a = ahoke04a.addOrReplaceChild("Ahoke05a",
                CubeListBuilder.create().texOffs(50, 77)
                        .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 7.9F, 0.0F, -0.2617993877991494F, 0.08726646259971647F, 0.0F));

        ahoke05a.addOrReplaceChild("Ahoke06a",
                CubeListBuilder.create().mirror().texOffs(42, 89)
                        .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 7.9F, 0.0F, -0.5235987755982988F, 0.08726646259971647F, 0.0F));

        PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(46, 104)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F),
                PartPose.offset(0.0F, -14.8F, -3.0F));

        PartDefinition hair01 = hairMain.addOrReplaceChild("Hair01",
                CubeListBuilder.create().texOffs(80, 0)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 12.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 9.0F, 1.0F, 0.2617993877991494F, 0.0F, 0.0F));

        hair01.addOrReplaceChild("Hair02",
                CubeListBuilder.create().texOffs(80, 22)
                        .addBox(-8.0F, 0.0F, -5.0F, 16.0F, 11.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 9.5F, 5.8F, -0.08726646259971647F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("EquipBase",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition cloth01 = bodyMain.addOrReplaceChild("Cloth01",
                CubeListBuilder.create().texOffs(0, 66)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 4.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, -3.3F, -4.3F, 0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition cloth02 = cloth01.addOrReplaceChild("Cloth02",
                CubeListBuilder.create().texOffs(0, 53)
                        .addBox(-7.0F, 0.0F, 0.0F, 14.0F, 3.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 3.0F, -0.3F, 0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition cloth03 = cloth02.addOrReplaceChild("Cloth03",
                CubeListBuilder.create().texOffs(0, 40)
                        .addBox(-8.0F, 0.0F, 0.0F, 16.0F, 3.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 2.3F, -0.2F, 0.08726646259971647F, 0.0F, 0.0F));

        cloth03.addOrReplaceChild("Cloth04",
                CubeListBuilder.create().texOffs(0, 26)
                        .addBox(-9.0F, 0.0F, 0.0F, 18.0F, 3.0F, 11.0F),
                PartPose.offsetAndRotation(0.0F, 2.0F, -0.3F, -0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().texOffs(2, 99)
                        .addBox(-3.0F, -1.0F, -2.0F, 4.0F, 8.0F, 4.0F),
                PartPose.offsetAndRotation(-6.0F, -9.3F, -0.7F, 0.13962634015954636F, 0.0F, 0.6108652381980153F));

        PartDefinition armRight02 = armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().texOffs(2, 99)
                        .addBox(0.0F, 0.0F, -4.0F, 4.0F, 9.0F, 4.0F),
                PartPose.offset(-3.0F, 7.0F, 2.0F));

        armRight02.addOrReplaceChild("EquipHandRing",
                CubeListBuilder.create().texOffs(0, 91)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 2.0F, 5.0F),
                PartPose.offset(0.0F, 4.0F, -2.0F));

        PartDefinition equipTBase_2 = armRight02.addOrReplaceChild("EquipTBase_2",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offsetAndRotation(2.6F, 9.0F, -2.0F, 0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition eqyuipT01_2 = equipTBase_2.addOrReplaceChild("EqyuipT01_2",
                CubeListBuilder.create().texOffs(5, 0)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5707963267948966F, 0.0F, 0.0F));

        PartDefinition eqyuipT02_2 = eqyuipT01_2.addOrReplaceChild("EqyuipT02_2",
                CubeListBuilder.create().texOffs(4, 0)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F),
                PartPose.offset(0.0F, 6.9F, 0.0F));

        PartDefinition eqyuipT03_2 = eqyuipT02_2.addOrReplaceChild("EqyuipT03_2",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F),
                PartPose.offset(0.0F, 6.9F, 0.0F));

        eqyuipT03_2.addOrReplaceChild("EquipT03a_2",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 1.0F, 3.0F),
                PartPose.offset(0.0F, 6.9F, 0.0F));

        PartDefinition eqyuipT04_2 = eqyuipT01_2.addOrReplaceChild("EqyuipT04_2",
                CubeListBuilder.create().texOffs(3, 4)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F),
                PartPose.offset(0.0F, -6.9F, 0.0F));

        PartDefinition eqyuipT05_2 = eqyuipT04_2.addOrReplaceChild("EqyuipT05_2",
                CubeListBuilder.create().texOffs(2, 3)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, -6.9F, 0.0F, 0.0F, 0.0F, 0.02142916587671676F));

        eqyuipT05_2.addOrReplaceChild("EquipT05a_2",
                CubeListBuilder.create().texOffs(8, 7)
                        .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 6.0F, 2.0F),
                PartPose.offset(0.0F, 1.0F, 1.9F));

        eqyuipT05_2.addOrReplaceChild("EquipT05b_2",
                CubeListBuilder.create().texOffs(14, 4)
                        .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 6.0F, 2.0F),
                PartPose.offsetAndRotation(-1.9F, 1.0F, 0.0F, 0.0F, -1.5707963267948966F, 0.0F));

        eqyuipT05_2.addOrReplaceChild("EquipT05c_2",
                CubeListBuilder.create().texOffs(0, 4)
                        .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 6.0F, 2.0F),
                PartPose.offsetAndRotation(1.9F, 1.0F, 0.0F, 0.0F, 1.5707963267948966F, 0.0F));

        eqyuipT05_2.addOrReplaceChild("EquipT05d_2",
                CubeListBuilder.create().texOffs(0, 8)
                        .addBox(-0.5F, 0.0F, -2.0F, 1.0F, 6.0F, 2.0F),
                PartPose.offset(0.0F, 1.0F, -1.9F));

        PartDefinition ringBase = bodyMain.addOrReplaceChild("RingBase",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offset(0.0F, -16.0F, -0.4F));

        PartDefinition ring01 = ringBase.addOrReplaceChild("Ring01",
                CubeListBuilder.create().texOffs(62, 0)
                        .addBox(-4.0F, 0.0F, -0.5F, 8.0F, 10.0F, 1.0F),
                PartPose.offsetAndRotation(4.5F, 4.3F, 0.0F, -0.8203047484373349F, 1.5009831567151235F, 0.0F));

        PartDefinition ring02 = ring01.addOrReplaceChild("Ring02",
                CubeListBuilder.create().texOffs(62, 13)
                        .addBox(-4.0F, -9.0F, -0.5F, 8.0F, 9.0F, 1.0F),
                PartPose.offsetAndRotation(0.3F, 8.5F, 0.2F, 0.22759093446006054F, -0.03874630939427412F,
                        -2.792526803190927F));

        PartDefinition ring03Base = ring02.addOrReplaceChild("Ring03Base",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offsetAndRotation(-2.0F, -10.0F, 1.7F, -0.6108652381980153F, 0.17453292519943295F,
                        -0.10471975511965977F));

        ring03Base.addOrReplaceChild("Ring03b",
                CubeListBuilder.create().texOffs(36, 0)
                        .addBox(0.0F, -2.0F, -2.0F, 9.0F, 4.0F, 4.0F),
                PartPose.offsetAndRotation(-1.9F, 2.0F, 0.0F, 0.0F, 0.0F, -1.5707963267948966F));

        ring03Base.addOrReplaceChild("Ring03c",
                CubeListBuilder.create().texOffs(36, 0)
                        .addBox(0.0F, -2.0F, -2.0F, 9.0F, 4.0F, 4.0F),
                PartPose.offset(-4.0F, -8.9F, 0.0F));

        ring03Base.addOrReplaceChild("Ring03a",
                CubeListBuilder.create().texOffs(36, 0)
                        .addBox(0.0F, -2.0F, -2.0F, 9.0F, 4.0F, 4.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        ring03Base.addOrReplaceChild("Ring03e",
                CubeListBuilder.create().texOffs(36, 0)
                        .addBox(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-2.0F, -10.8F, 0.0F, 0.0F, 0.0F, 0.08726646259971647F));

        ring03Base.addOrReplaceChild("Ring03d",
                CubeListBuilder.create().texOffs(36, 0)
                        .addBox(0.0F, -2.0F, -2.0F, 9.0F, 4.0F, 4.0F),
                PartPose.offsetAndRotation(7.0F, -1.9F, 0.0F, 0.0F, 0.0F, -1.5707963267948966F));

        ring03Base.addOrReplaceChild("Ring03f",
                CubeListBuilder.create().texOffs(36, 0)
                        .addBox(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F),
                PartPose.offsetAndRotation(7.0F, -10.8F, 0.0F, 0.0F, 0.0F, -0.08726646259971647F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 2.0F, 0.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -10.3F, 0.2F));

        PartDefinition glowHead = glowNeck.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -1.5F, -1.0F));
        addDefaultFaceParts(glowHead);

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

        boolean flag = !EmotionHelper.checkModelState(0, state); // wrist
        this.EquipHandRing.visible = !flag;

        flag = !EmotionHelper.checkModelState(1, state); // ring
        this.RingBase.visible = !flag;

        flag = !EmotionHelper.checkModelState(2, state); // torpedo
        this.EquipTBase.visible = !flag;

        // hide torpedo 2
        this.EquipTBase_2.visible = false;
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

        this.offsetY += 0.27F;
        this.setFaceHungry(ent);

        // 頭部
        this.Head.xRot = -0.15F;
        this.Head.yRot = 0F;
        this.Head.zRot = 0F;
        // Body
        this.BodyMain.xRot = 1.6F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        this.Butt.xRot = 0.21F;
        // this.Butt.offsetY = 0F;
        // this.Butt.offsetZ = 0F;
        // cloth
        this.Cloth03.xRot = 0.087F;
        // this.Cloth03.offsetY = 0F;
        // this.Cloth03.offsetZ = 0F;
        this.Cloth04.xRot = -0.052F;
        // this.Cloth04.offsetY = 0F;
        // this.Cloth04.offsetZ = 0F;
        // hair
        this.Hair01.xRot = 0.35F;
        this.Hair01.zRot = 0F;
        this.Hair02.xRot = -0.2F;
        this.Hair02.zRot = 0F;
        // arm
        this.ArmLeft01.xRot = -3.0F;
        this.ArmLeft01.yRot = -0.6981F;
        this.ArmLeft01.zRot = 0.08F;
        this.ArmLeft02.xRot = 0F;
        this.ArmLeft02.yRot = 0F;
        this.ArmLeft02.zRot = 0F;
        this.ArmRight01.xRot = -3.0F;
        this.ArmRight01.yRot = 0.6981F;
        this.ArmRight01.zRot = -0.08F;
        this.ArmRight02.xRot = 0F;
        this.ArmRight02.yRot = 0F;
        this.ArmRight02.zRot = 0F;
        // leg
        this.LegLeft01.xRot = -0.3F;
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = -0.05F;
        this.LegLeft02.xRot = 0F;
        // this.LegLeft02.offsetY = 0F;
        // this.LegLeft02.offsetZ = 0F;
        this.LegRight01.xRot = -0.3F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = 0.05F;
        this.LegRight02.xRot = 0F;
        // this.LegRight02.offsetY = 0F;
        // this.LegRight02.offsetZ = 0F;
        // equip
        this.EquipTBase.xRot = 0.8F;
        this.EquipTBase.yRot = 0F;
        this.EquipTBase.zRot = 1.2F;
        // this.EquipTBase.offsetX = 0F;
        // this.EquipTBase.offsetY = 0F;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float angleX = Mth.cos(f2 * 0.08F);
        float angleX1 = Mth.cos(f2 * 0.08F + 0.4F + f * 0.5F);
        float angleX2 = Mth.cos(f2 * 0.08F + 0.8F + f * 0.5F);
        float angleX3 = Mth.cos(f2 * 0.08F + 1.2F + f * 0.5F);
        float angleX4 = Mth.cos(f2 * 0.08F + 1.6F + f * 0.5F);
        float angleX5 = Mth.cos(f2 * 0.08F + 2.0F + f * 0.5F);
        float angleX6 = Mth.cos(f2 * 0.08F + 2.4F + f * 0.5F);
        float angleAdd1 = Mth.cos(f * 0.7F) * f1 * 0.5F;
        float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.5F;
        float addk1;
        float addk2;
        float headX;
        float headZ;
        int state = ent.getStateEmotion(ID.S.State);
        boolean showTorpedo = EmotionHelper.checkModelState(2, state);

        // 水上漂浮
        // [RENDER?] 目視検証必須: 水面時の上下揺れが1.10.2相当の小振幅(0.025)で再現されること。
        // [REPRO?] 目視未確認: 実機で水面待機時の高さ差と揺れ周期を比較すること。
        if (ent.getShipDepth(0) > 0D || ent.getShipDepth(1) > 0D) {
            this.offsetY += angleX * 0.025F + 0.025F;
        }

        // leg move parm
        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += angleX * 0.025F + 0.025F;
        addk1 = angleAdd1 * 0.6F - 0.1F;
        addk2 = angleAdd2 * 0.6F - 0.1F;

        // 移動頭部使其看人
        this.Head.xRot = f4 * 0.014F; // 上下角度
        this.Head.yRot = f3 * 0.006F; // 左右角度
        this.Head.zRot = 0F;
        headX = this.Head.xRot * -0.5F;
        // 正常站立動作
        // Body
        this.Ahoke01.xRot = angleX1 * 0.07F - 2.01F;
        this.Ahoke01.yRot = 0.52F;
        this.Ahoke01.zRot = 0F;
        this.Ahoke02.xRot = -angleX2 * 0.09F + 1.04F;
        this.Ahoke03.xRot = angleX3 * 0.15F + 0.78F;
        this.Ahoke04.xRot = -angleX4 * 0.10F + 0.44F;
        this.Ahoke05.xRot = -angleX5 * 0.15F - 0.17F;
        this.Ahoke06.xRot = angleX6 * 0.18F - 0.31F;
        this.Ahoke01a.xRot = angleX1 * 0.07F - 2.27F;
        this.Ahoke01a.yRot = -2.62F;
        this.Ahoke01a.zRot = 0F;
        this.Ahoke02a.xRot = -angleX2 * 0.09F + 0.79F;
        this.Ahoke03a.xRot = angleX3 * 0.15F + 1.05F;
        this.Ahoke04a.xRot = -angleX4 * 0.10F + 0.41F;
        this.Ahoke05a.xRot = -angleX5 * 0.15F - 0.3F;
        this.Ahoke06a.xRot = angleX6 * 0.18F - 0.25F;
        this.BodyMain.xRot = -0.0873F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        this.Butt.xRot = 0.21F;
        // this.Butt.offsetY = 0F;
        // this.Butt.offsetZ = 0F;
        // cloth
        this.Cloth02.xRot = 0.087F;
        // this.Cloth02.offsetY = 0F;
        // this.Cloth02.offsetZ = 0F;
        this.Cloth03.xRot = 0.087F;
        // this.Cloth03.offsetY = 0F;
        // this.Cloth03.offsetZ = 0F;
        this.Cloth04.xRot = -0.052F;
        // this.Cloth04.offsetY = 0F;
        // this.Cloth04.offsetZ = 0F;
        // hair
        this.Hair01.xRot = angleX * 0.03F + 0.26F + headX;
        this.Hair01.zRot = 0F;
        this.Hair02.xRot = -angleX1 * 0.04F - 0.087F + headX;
        this.Hair02.zRot = 0F;
        // arm
        this.ArmLeft01.xRot = angleAdd2 * 0.8F - 0.05F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = angleX * 0.025F - 0.3F;
        this.ArmLeft02.xRot = 0F;
        this.ArmLeft02.yRot = 0F;
        this.ArmLeft02.zRot = 0F;
        // this.ArmLeft02.offsetX = 0F;
        // this.ArmLeft02.offsetZ = 0F;
        this.ArmRight01.xRot = angleAdd1 * 0.8F + 0.26F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = -angleX * 0.025F + 0.4F;
        this.ArmRight02.xRot = 0F;
        this.ArmRight02.yRot = 0F;
        this.ArmRight02.zRot = 0F;
        // this.ArmRight02.offsetX = 0F;
        // this.ArmRight02.offsetZ = 0F;
        // leg
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = -0.035F;
        this.LegLeft02.xRot = 0F;
        this.LegLeft02.yRot = 0F;
        this.LegLeft02.zRot = 0F;
        // this.LegLeft02.offsetX = 0F;
        // this.LegLeft02.offsetY = 0F;
        // this.LegLeft02.offsetZ = 0F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = 0.035F;
        this.LegRight02.xRot = 0F;
        this.LegRight02.yRot = 0F;
        this.LegRight02.zRot = 0F;
        // this.LegRight02.offsetX = 0F;
        // this.LegRight02.offsetY = 0F;
        // this.LegRight02.offsetZ = 0F;
        // equip
        this.EquipTBase.xRot = 0.15F;
        this.EquipTBase.yRot = 0F;
        this.EquipTBase.zRot = 0F;
        // this.EquipTBase.offsetX = -0.13F;
        // this.EquipTBase.offsetY = 0F;
        this.EquipTBase_2.xRot = 0.15F;
        this.EquipTBase_2.yRot = 0F;
        this.EquipTBase_2.zRot = 0F;
        // NOTE 1.20.1: offset not supported in new model API: this.EquipTBase_2.offsetX
        // = 0F;
        // NOTE 1.20.1: offset not supported in new model API: this.EquipTBase_2.offsetY
        // = 0F;

        // 奔跑動作
        if (ent.getIsSprinting() || f1 > 0.9F) {
            if (ent.getIsRiding()) {
                // [PORT] 1.10.2 -> 1.20.1: riding sprint has slight crouch offset.
                this.offsetY -= 0.06F;

                if (f1 > 0.5F) {
                    this.Head.xRot += 0.4F;
                    this.Hair01.xRot += 0.1F;
                    this.Hair02.xRot -= 0.2F;
                }
            } else {
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY -= 0.06F;
                this.Head.xRot -= 1.3F;
                this.Hair01.xRot += 0.6F;
                this.Hair02.xRot += 0.5F;
                this.Ahoke01.xRot += 0.38F;
                this.Ahoke01.yRot = 0.7F;
                this.Ahoke01.zRot = 0.4F;
                this.Ahoke01a.yRot = -2.5F;
                this.Ahoke01a.zRot = -0.2F;
            }

            // body
            this.BodyMain.xRot = 1.5F;
            // arm
            this.ArmLeft01.xRot = -2.9F;
            this.ArmLeft01.zRot = -0.22F;
            this.ArmRight01.xRot = -2.9F;
            this.ArmRight01.zRot = 0.22F;
            // leg
            this.LegLeft01.zRot = 0.05F;
            this.LegRight01.zRot = -0.05F;
            // equip
            if (showTorpedo) {
                this.EquipTBase.xRot = 1.42F;
                this.EquipTBase.yRot = 0F;
                this.EquipTBase.zRot = -0.22F;
                // this.EquipTBase.offsetX = 0.17F;
                // this.EquipTBase.offsetY = 0.64F;
                this.EquipTBase_2.visible = true;
                this.EquipTBase_2.xRot = 1.42F;
                this.EquipTBase_2.yRot = 0F;
                this.EquipTBase_2.zRot = 0.22F;
                // NOTE 1.20.1: offset not supported in new model API: this.EquipTBase_2.offsetX
                // = -0.17F;
                // NOTE 1.20.1: offset not supported in new model API: this.EquipTBase_2.offsetY
                // = 0.64F;
            }
        }

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        // 潛行跟蹲下動作
        if (ent.getIsSneaking()) {
            // [PORT] 1.10.2 -> 1.20.1: GlStateManager.translate(0, 0.01, 0)
            this.offsetY += 0.01F;

            // Body
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.01F;
            this.Head.xRot -= 0.6283F;
            this.BodyMain.xRot = 0.8727F;
            this.Cloth03.xRot = -0.34F;
            // this.Cloth03.offsetY = -0.2F;
            // this.Cloth03.offsetZ = 0.03F;
            this.Cloth04.xRot = -0.27F;
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
            // equip
            this.EquipTBase.xRot = 0.48F;
            this.EquipTBase.yRot = 1.55F;
            this.EquipTBase.zRot = 0F;
            // this.EquipTBase.offsetX = 0F;
            // this.EquipTBase.offsetY = 0F;
        } // end if sneaking

        // 坐下動作
        if (ent.getIsSitting() && !ent.getIsRiding()) {
            if (ent.getTickExisted() % 512 > 256) {
                // [PORT] 1.10.2 -> 1.20.1: bobbing sit translate
                this.offsetY += -angleX * 0.05F - 0.1F;

                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.26F;
                this.setFaceDamaged(ent);
                // body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += -angleX * 0.05F - 0.1F;
                this.Head.xRot *= 0.5F;
                this.Head.yRot *= 0.75F;
                this.Head.xRot += 0.5F;
                this.BodyMain.xRot = 1.6F;
                this.Cloth03.xRot = -0.33F;
                // this.Cloth03.offsetY = -0.23F;
                this.Cloth04.xRot = -0.12F;
                // this.Cloth04.offsetY = -0.16F;
                this.Ahoke01.xRot += 0.38F;
                this.Ahoke01.yRot = 0.8F;
                this.Ahoke01.zRot = 0.4F;
                this.Hair01.xRot -= 0.2F;
                this.Hair02.xRot -= 0.25F;
                // arm
                this.ArmLeft01.xRot = -1.5F;
                this.ArmLeft01.zRot = -2.3F;
                this.ArmRight01.xRot = -1.5F;
                this.ArmRight01.zRot = 2.3F;
                // leg
                addk1 = -1.8F;
                addk2 = -1.8F;
                this.LegLeft01.yRot = -0.1F - angleX * 0.02F;
                this.LegRight01.yRot = 0.1F + angleX * 0.02F;
            } else {
                if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                    // [PORT] 1.10.2 -> 1.20.1: bored sit translate
                    this.offsetY += 0.26F;

                    this.setFaceDamaged(ent);

                    // body
                    this.Head.xRot = 0.4F;
                    this.Cloth03.xRot = -0.64F;
                    // this.Cloth03.offsetY = -0.17F;
                    // this.Cloth03.offsetZ = 0F;
                    this.Cloth04.xRot = 0.29F;
                    // this.Cloth04.offsetY = -0.04F;
                    // this.Cloth04.offsetZ = 0.02F;
                    this.Hair01.xRot -= 0.2F;
                    this.Hair02.xRot -= 0.15F;
                    this.Ahoke01.xRot -= 0.1F;
                    // arm
                    this.ArmLeft01.xRot = 0.4F;
                    this.ArmLeft01.yRot = -2.96705972839036F;
                    this.ArmLeft01.zRot = -2.62F;
                    this.ArmLeft02.xRot = 0.0F;
                    this.ArmLeft02.yRot = 0.0F;
                    this.ArmLeft02.zRot = 1F;
                    // this.ArmLeft02.offsetX = 0F;
                    // this.ArmLeft02.offsetZ = 0F;
                    this.ArmRight01.xRot = 0.5235987755982988F;
                    this.ArmRight01.yRot = 2.96705972839036F;
                    this.ArmRight01.zRot = 2.62F;
                    this.ArmRight02.xRot = 0.0F;
                    this.ArmRight02.yRot = 0.0F;
                    this.ArmRight02.zRot = -1F;
                    // this.ArmRight02.offsetX = 0F;
                    // this.ArmRight02.offsetZ = 0F;
                    // leg
                    addk1 = -2.41309222380736F;
                    addk2 = -2.2689280275926285F;
                    this.LegLeft01.yRot = 0.0F;
                    this.LegLeft01.zRot = -0.27314402793711257F;
                    this.LegLeft02.xRot = 1.4570008595648662F;
                    this.LegLeft02.yRot = 0.0F;
                    this.LegLeft02.zRot = 0.0F;
                    this.LegRight01.yRot = 0.0F;
                    this.LegRight01.zRot = 0.22759093446006054F;
                    this.LegRight02.xRot = 1.0471975511965976F;
                    this.LegRight02.yRot = 0.0F;
                    this.LegRight02.zRot = 0.0F;
                    // equip
                    this.EquipTBase.visible = false;
                } else {
                    // [PORT] 1.10.2 -> 1.20.1: normal sit translate
                    this.offsetY += 0.24F;

                    // body
                    // [PORT] Restored from 1.10.2 GlStateManager.translate
                    this.offsetY += 0.24F;
                    this.Head.xRot -= 0.7F;
                    this.BodyMain.xRot = 0.35F;
                    this.Hair01.xRot += 0.3F;
                    this.Hair02.xRot += 0.3F;
                    this.Cloth03.xRot = -0.32F;
                    // this.Cloth03.offsetY = -0.05F;
                    this.Cloth04.xRot = -0.21F;
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
                }
            }
        } // end sitting

        // 騎乘專屬坐騎動作
        if (ent.getIsRiding()) {
            // player mount
            if (((net.minecraft.world.entity.Entity) ent)
                    .getVehicle() instanceof net.minecraft.world.entity.player.Player) {
                // body
                this.Head.yRot *= 0.25F;

                if (ent.getIsSitting()) {
                    if (((net.minecraft.world.entity.Entity) ent).getVehicle().isShiftKeyDown()) {
                        // [PORT] 1.10.2 -> 1.20.1: player mount sneaking sit translate.
                        this.offsetY += 0.33F;
                    } else {
                        // [PORT] 1.10.2 -> 1.20.1: player mount sit translate.
                        this.offsetY += 0.24F;
                    }

                    // cloth
                    // [PORT] Restored from 1.10.2 GlStateManager.translate
                    this.offsetY += 0.33F;
                    this.offsetZ += 0.27F;
                    this.Cloth02.xRot = -0.13F;
                    // this.Cloth02.offsetY = -0.11F;
                    this.Cloth03.xRot = -0.07F;
                    // this.Cloth03.offsetY = -0.11F;
                    this.Cloth04.xRot = -0.11F;
                    // this.Cloth04.offsetY = -0.08F;
                    // arm
                    this.ArmLeft01.xRot = -1.2F;
                    this.ArmLeft01.yRot = -0.3F;
                    this.ArmRight01.xRot = -1.2F;
                    this.ArmRight01.yRot = 0.3F;
                    // leg
                    addk1 = -1.66F;
                    addk2 = -1.66F;
                    this.LegLeft01.yRot = -0.6F;
                    this.LegRight01.yRot = 0.6F;
                } // end if sitting
                else {
                    if (((net.minecraft.world.entity.Entity) ent).getVehicle().isShiftKeyDown()) {
                        // [PORT] 1.10.2 -> 1.20.1: player mount sneaking stand translate.
                        this.offsetY += 0.16F;
                    } else {
                        // [PORT] 1.10.2 -> 1.20.1: player mount stand translate.
                        this.offsetY += 0.07F;
                    }

                    // body
                    this.Head.xRot *= 0.5F;
                    this.Head.yRot *= 0.75F;
                    this.Head.xRot -= 1.1F;
                    this.BodyMain.xRot = 1.5F;
                    // this.Cloth02.offsetY = -0.11F;
                    this.Cloth03.xRot = -0.07F;
                    // this.Cloth03.offsetY = -0.11F;
                    this.Cloth04.xRot = -0.11F;
                    // this.Cloth04.offsetY = -0.08F;
                    // hair
                    this.Ahoke01.xRot += 0.38F;
                    this.Ahoke01.yRot = 0.8F;
                    this.Ahoke01.zRot = 0.4F;
                    this.Hair01.xRot += 0.4F;
                    this.Hair02.xRot += 0.2F;
                    // arm
                    this.ArmLeft01.xRot = -1.39F;
                    this.ArmLeft01.yRot = -1.09F;
                    this.ArmLeft02.xRot = -1.18F;
                    this.ArmRight01.xRot = -1.39F;
                    this.ArmRight01.yRot = 1.09F;
                    this.ArmRight02.xRot = -1.18F;
                    // leg
                    addk1 = -1.7F;
                    addk2 = -1.7F;
                    this.LegLeft01.yRot = -0.2F;
                    this.LegRight01.yRot = 0.2F;
                    // equip
                    this.EquipTBase.xRot = 1.29F;
                }
            }
            // normal mount
            else {
                if (ent.getIsSitting()) {
                    if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                        // [PORT] 1.10.2 -> 1.20.1: mounted bored sit bobbing offset.
                        this.offsetY += -angleX * 0.05F - 0.16F;
                        this.setFaceDamaged(ent);
                        // body
                        this.Head.xRot *= 0.5F;
                        this.Head.yRot *= 0.75F;
                        this.Head.xRot += 0.5F;
                        this.BodyMain.xRot = 1.6F;
                        this.Cloth03.xRot = -0.33F;
                        // this.Cloth03.offsetY = -0.23F;
                        this.Cloth04.xRot = -0.12F;
                        // this.Cloth04.offsetY = -0.16F;
                        this.Ahoke01.xRot += 0.38F;
                        this.Ahoke01.yRot = 0.8F;
                        this.Ahoke01.zRot = 0.4F;
                        this.Hair01.xRot -= 0.2F;
                        this.Hair02.xRot -= 0.25F;
                        // arm
                        this.ArmLeft01.xRot = -1.5F;
                        this.ArmLeft01.zRot = -2.3F;
                        this.ArmRight01.xRot = -1.5F;
                        this.ArmRight01.zRot = 2.3F;
                        // leg
                        addk1 = -1.8F;
                        addk2 = -1.8F;
                        this.LegLeft01.yRot = -0.1F - angleX * 0.02F;
                        this.LegRight01.yRot = 0.1F + angleX * 0.02F;
                    } else {
                        // [PORT] 1.10.2 -> 1.20.1: mounted sit translate.
                        this.offsetY += 0.24F;

                        this.setFaceDamaged(ent);

                        // body
                        this.Head.xRot = 0.4F;
                        this.Cloth03.xRot = -0.64F;
                        // this.Cloth03.offsetY = -0.17F;
                        // this.Cloth03.offsetZ = 0F;
                        this.Cloth04.xRot = 0.29F;
                        // this.Cloth04.offsetY = -0.04F;
                        // this.Cloth04.offsetZ = 0.02F;
                        this.Hair01.xRot -= 0.2F;
                        this.Hair02.xRot -= 0.15F;
                        this.Ahoke01.xRot -= 0.1F;
                        // arm
                        this.ArmLeft01.xRot = 0.4F;
                        this.ArmLeft01.yRot = -2.96705972839036F;
                        this.ArmLeft01.zRot = -2.62F;
                        this.ArmLeft02.xRot = 0.0F;
                        this.ArmLeft02.yRot = 0.0F;
                        this.ArmLeft02.zRot = 1F;
                        // this.ArmLeft02.offsetX = 0F;
                        // this.ArmLeft02.offsetZ = 0F;
                        this.ArmRight01.xRot = 0.5235987755982988F;
                        this.ArmRight01.yRot = 2.96705972839036F;
                        this.ArmRight01.zRot = 2.62F;
                        this.ArmRight02.xRot = 0.0F;
                        this.ArmRight02.yRot = 0.0F;
                        this.ArmRight02.zRot = -1F;
                        // this.ArmRight02.offsetX = 0F;
                        // this.ArmRight02.offsetZ = 0F;
                        // leg
                        addk1 = -2.41309222380736F;
                        addk2 = -2.2689280275926285F;
                        this.LegLeft01.yRot = 0.0F;
                        this.LegLeft01.zRot = -0.27314402793711257F;
                        this.LegLeft02.xRot = 1.4570008595648662F;
                        this.LegLeft02.yRot = 0.0F;
                        this.LegLeft02.zRot = 0.0F;
                        this.LegRight01.yRot = 0.0F;
                        this.LegRight01.zRot = 0.22759093446006054F;
                        this.LegRight02.xRot = 1.0471975511965976F;
                        this.LegRight02.yRot = 0.0F;
                        this.LegRight02.zRot = 0.0F;
                    }
                } else {
                    // [PORT] 1.10.2 -> 1.20.1: mounted stand translate.
                    this.offsetY += 0.26F;

                    // body
                    this.Head.xRot -= 0.7F;
                    this.BodyMain.xRot = 0.35F;
                    this.Hair01.xRot += 0.3F;
                    this.Hair02.xRot += 0.3F;
                    this.Cloth03.xRot = -0.32F;
                    // this.Cloth03.offsetY = -0.05F;
                    this.Cloth04.xRot = -0.21F;
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
                }
            }
        } // end ridding

        // 攻擊動作
        int atktime = ent.getAttackTick();
        if (atktime > 41) {
            this.EquipTBase.visible = true;
            this.EquipTBase_2.visible = true;
            // this.EquipTBase.offsetX = 0F;
            // this.EquipTBase.offsetY = 0F;

            setFaceAttack(ent);
            // swing arm
            float ft = (50 - ent.getAttackTick()) + (f2 - (int) f2);
            ft *= 0.125F;
            float fa = Mth.cos(ft * ft * (float) Math.PI);
            float fb = Mth.cos(Mth.sqrt(ft) * (float) Math.PI);
            this.ArmLeft01.xRot += -fb * 120.0F * ((float) Math.PI / 180F) - 1.5F;
            this.ArmLeft01.yRot += fa * 20.0F * ((float) Math.PI / 180F);
            this.ArmLeft01.zRot += fb * 20.0F * ((float) Math.PI / 180F) + 0.26F;
        }
        if (atktime > 36 && atktime < 45) {
            this.EquipTBase.visible = true;
            this.EquipTBase_2.visible = true;
            // this.EquipTBase.offsetX = 0F;
            // this.EquipTBase.offsetY = 0F;

            setFaceAttack(ent);
            // swing arm
            float ft = (45 - ent.getAttackTick()) + (f2 - (int) f2);
            ft *= 0.125F;
            float fa = Mth.cos(ft * ft * (float) Math.PI);
            float fb = Mth.cos(Mth.sqrt(ft) * (float) Math.PI);
            this.ArmRight01.xRot += -fb * 120.0F * ((float) Math.PI / 180F) - 1.5F;
            this.ArmRight01.yRot += -fa * 20.0F * ((float) Math.PI / 180F);
            this.ArmRight01.zRot += -fb * 20.0F * ((float) Math.PI / 180F) - 0.26F;
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
        headZ = this.Head.zRot * -0.5F;
        this.Hair01.zRot = headZ;
        this.Hair02.zRot = headZ;

        // leg motion
        this.LegLeft01.xRot = addk1;
        this.LegRight01.xRot = addk2;
    }
}
