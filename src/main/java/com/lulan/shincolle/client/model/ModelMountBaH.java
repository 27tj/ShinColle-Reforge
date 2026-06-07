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

public class ModelMountBaH extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "mount_bah"), "main");

    private final ModelPart BodyMain;
    private final ModelPart ArmLeft01;
    private final ModelPart ArmRight01;
    private final ModelPart Butt;
    private final ModelPart Neck;
    private final ModelPart ChestCannon01a;
    private final ModelPart ChestCannon02a;
    private final ModelPart ChestCannon03a;
    private final ModelPart ChestCannon04a;
    private final ModelPart ChestCannon05a;
    private final ModelPart ChestCannon06;
    private final ModelPart EquipBaseL;
    private final ModelPart EquipBaseR;
    private final ModelPart ArmLeft02;
    private final ModelPart ArmRight02;
    private final ModelPart LegRight01;
    private final ModelPart LegLeft01;
    private final ModelPart LegRight02;
    private final ModelPart LefLeft02;
    private final ModelPart Head;
    private final ModelPart HeadTooth;
    private final ModelPart Jaw;
    private final ModelPart HeadBack01;
    private final ModelPart HeadBack02;
    private final ModelPart HeadBack03;
    private final ModelPart JawTooth;
    private final ModelPart Tongue;
    private final ModelPart ChestCannon01b;
    private final ModelPart ChestCannon02b;
    private final ModelPart ChestCannon03b;
    private final ModelPart ChestCannon04b;
    private final ModelPart ChestCannon05b;
    private final ModelPart EquipL01;
    private final ModelPart EquipL03;
    private final ModelPart EquipL02;
    private final ModelPart EquipCannon01;
    private final ModelPart EquipCannon02;
    private final ModelPart EquipCannon03;
    private final ModelPart ChestCannonL01a;
    private final ModelPart ChestCannonL01b;
    private final ModelPart EquipR01;
    private final ModelPart EquipR03;
    private final ModelPart EquipR02;
    private final ModelPart EquipCannon01_1;
    private final ModelPart EquipCannon02_1;
    private final ModelPart EquipCannon03_1;
    private final ModelPart ChestCannonR01a;
    private final ModelPart ChestCannonR01b;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowNeck;
    private final ModelPart GlowEquipBaseL;
    private final ModelPart GlowEquipBaseR;
    private final ModelPart GlowEquipL01;
    private final ModelPart GlowEquipL02;
    private final ModelPart GlowEquipR01;
    private final ModelPart GlowEquipR02;
    private final ModelPart GlowChestCannonL01a;
    private final ModelPart GlowChestCannonR01a;
    private final ModelPart GlowChestCannon01a;
    private final ModelPart GlowChestCannon02a;
    private final ModelPart GlowChestCannon03a;
    private final ModelPart GlowChestCannon04a;
    private final ModelPart GlowChestCannon05a;
    private final ModelPart GlowEquipL03;
    private final ModelPart GlowEquipR03;

    public ModelMountBaH(ModelPart root) {
        super();
        this.BodyMain = root.getChild("BodyMain");
        this.ChestCannon06 = this.BodyMain.getChild("ChestCannon06");
        this.ChestCannon01a = this.BodyMain.getChild("ChestCannon01a");
        this.Butt = this.BodyMain.getChild("Butt");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.ChestCannon04a = this.BodyMain.getChild("ChestCannon04a");
        this.EquipBaseL = this.BodyMain.getChild("EquipBaseL");
        this.EquipBaseR = this.BodyMain.getChild("EquipBaseR");
        this.ChestCannon03a = this.BodyMain.getChild("ChestCannon03a");
        this.ChestCannon02a = this.BodyMain.getChild("ChestCannon02a");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.ChestCannon05a = this.BodyMain.getChild("ChestCannon05a");
        this.Neck = this.BodyMain.getChild("Neck");
        this.LegRight01 = this.Butt.getChild("LegRight01");
        this.LegLeft01 = this.Butt.getChild("LegLeft01");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.EquipL01 = this.EquipBaseL.getChild("EquipL01");
        this.EquipL03 = this.EquipBaseL.getChild("EquipL03");
        this.EquipR01 = this.EquipBaseR.getChild("EquipR01");
        this.EquipR03 = this.EquipBaseR.getChild("EquipR03");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.Head = this.Neck.getChild("Head");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.LefLeft02 = this.LegLeft01.getChild("LefLeft02");
        this.EquipL02 = this.EquipL01.getChild("EquipL02");
        this.ChestCannonL01a = this.EquipL03.getChild("ChestCannonL01a");
        this.EquipR02 = this.EquipR01.getChild("EquipR02");
        this.ChestCannonR01a = this.EquipR03.getChild("ChestCannonR01a");
        this.HeadTooth = this.Head.getChild("HeadTooth");
        this.HeadBack01 = this.Head.getChild("HeadBack01");
        this.HeadBack02 = this.Head.getChild("HeadBack02");
        this.HeadBack03 = this.Head.getChild("HeadBack03");
        this.Jaw = this.Head.getChild("Jaw");
        this.Tongue = this.Jaw.getChild("Tongue");
        this.JawTooth = this.Jaw.getChild("JawTooth");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowNeck = this.GlowBodyMain.getChild("GlowNeck");
        this.GlowEquipBaseL = this.GlowBodyMain.getChild("GlowEquipBaseL");
        this.GlowEquipBaseR = this.GlowBodyMain.getChild("GlowEquipBaseR");
        this.GlowChestCannon01a = this.GlowBodyMain.getChild("GlowChestCannon01a");
        this.GlowChestCannon02a = this.GlowBodyMain.getChild("GlowChestCannon02a");
        this.GlowChestCannon03a = this.GlowBodyMain.getChild("GlowChestCannon03a");
        this.GlowChestCannon04a = this.GlowBodyMain.getChild("GlowChestCannon04a");
        this.GlowChestCannon05a = this.GlowBodyMain.getChild("GlowChestCannon05a");
        this.GlowEquipL01 = this.GlowEquipBaseL.getChild("GlowEquipL01");
        this.GlowEquipL03 = this.GlowEquipBaseL.getChild("GlowEquipL03");
        this.GlowEquipR01 = this.GlowEquipBaseR.getChild("GlowEquipR01");
        this.GlowEquipR03 = this.GlowEquipBaseR.getChild("GlowEquipR03");
        this.GlowEquipL02 = this.GlowEquipL01.getChild("GlowEquipL02");
        this.GlowChestCannonL01a = this.GlowEquipL03.getChild("GlowChestCannonL01a");
        this.GlowEquipR02 = this.GlowEquipR01.getChild("GlowEquipR02");
        this.GlowChestCannonR01a = this.GlowEquipR03.getChild("GlowChestCannonR01a");

        this.EquipCannon01 = this.GlowEquipL02.getChild("EquipCannon01");
        this.EquipCannon02 = this.GlowEquipL02.getChild("EquipCannon02");
        this.EquipCannon03 = this.GlowEquipL02.getChild("EquipCannon03");
        this.EquipCannon01_1 = this.GlowEquipR02.getChild("EquipCannon01_1");
        this.EquipCannon02_1 = this.GlowEquipR02.getChild("EquipCannon02_1");
        this.EquipCannon03_1 = this.GlowEquipR02.getChild("EquipCannon03_1");
        this.ChestCannonL01b = this.GlowChestCannonL01a.getChild("ChestCannonL01b");
        this.ChestCannonR01b = this.GlowChestCannonR01a.getChild("ChestCannonR01b");
        this.ChestCannon01b = this.GlowChestCannon01a.getChild("ChestCannon01b");
        this.ChestCannon02b = this.GlowChestCannon02a.getChild("ChestCannon02b");
        this.ChestCannon03b = this.GlowChestCannon03a.getChild("ChestCannon03b");
        this.ChestCannon04b = this.GlowChestCannon04a.getChild("ChestCannon04b");
        this.ChestCannon05b = this.GlowChestCannon05a.getChild("ChestCannon05b");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 51)
                        .addBox(-15.0F, -11.0F, -5.0F, 30.0F, 20.0F, 18.0F),
                PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 1.0471975511965976F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("ChestCannon06",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 9.0F, 10.0F, 3.0F),
                PartPose.offsetAndRotation(-4.0F, -1.0F, -7.0F, 0.091106186954104F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("ChestCannon01a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 7.0F, 8.0F, 3.0F),
                PartPose.offsetAndRotation(6.0F, -8.0F, -7.0F, -0.136659280431156F, -0.091106186954104F,
                        0.0F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(0, 96)
                        .addBox(-11.0F, 0.0F, -2.5F, 22.0F, 18.0F, 14.0F),
                PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.5009094953223726F, 0.0F, 0.0F));

        PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().texOffs(0, 101)
                        .addBox(-4.5F, 0.0F, -4.5F, 9.0F, 18.0F, 9.0F),
                PartPose.offsetAndRotation(-5.0F, 16.0F, 7.0F, -1.6755160819145563F,
                        0.20943951023931953F, 0.0F));

        legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().texOffs(0, 102)
                        .addBox(-4.0F, 0.0F, -2.0F, 8.0F, 18.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 18.0F, -2.0F, 1.7453292519943295F, 0.0F, 0.0F));

        PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().mirror().texOffs(0, 101)
                        .addBox(-4.5F, 0.0F, -4.5F, 9.0F, 18.0F, 9.0F),
                PartPose.offsetAndRotation(5.0F, 16.0F, 7.0F, -1.6755160819145563F,
                        -0.20943951023931953F, 0.0F));

        legLeft01.addOrReplaceChild("LefLeft02",
                CubeListBuilder.create().mirror().texOffs(0, 102)
                        .addBox(-4.0F, 0.0F, -2.0F, 8.0F, 18.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 18.0F, -2.0F, 1.7453292519943295F, 0.0F, 0.0F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().mirror().texOffs(0, 92)
                        .addBox(-1.0F, -7.0F, -7.0F, 14.0F, 22.0F, 14.0F),
                PartPose.offsetAndRotation(15.0F, 1.0F, 2.0F, -0.8726646259971648F,
                        -0.20943951023931953F, 0.0F));

        armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().mirror().texOffs(0, 89)
                        .addBox(-6.5F, 0.0F, -13.0F, 13.0F, 26.0F, 13.0F),
                PartPose.offsetAndRotation(6.0F, 15.0F, 7.0F, -0.6981317007977318F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("ChestCannon04a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 9.0F, 7.0F, 3.0F),
                PartPose.offsetAndRotation(-10.0F, -1.0F, -7.0F, 0.18203784098300857F,
                        0.091106186954104F, 0.0F));

        PartDefinition equipBaseL = bodyMain.addOrReplaceChild("EquipBaseL",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-9.0F, -6.0F, -8.5F, 18.0F, 5.0F, 18.0F),
                PartPose.offsetAndRotation(20.0F, -3.0F, 2.0F, -0.7740535232594852F, 0.0F,
                        0.17453292519943295F));

        PartDefinition equipL01 = equipBaseL.addOrReplaceChild("EquipL01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-7.0F, 0.0F, -7.0F, 14.0F, 4.0F, 14.0F),
                PartPose.offset(0.0F, -10.0F, 1.0F));

        equipL01.addOrReplaceChild("EquipL02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-9.0F, -9.0F, -9.0F, 18.0F, 9.0F, 20.0F),
                PartPose.offsetAndRotation(0.0F, 1.8F, 0.0F, -0.2617993877991494F,
                        -0.13962634015954636F, 0.0F));

        PartDefinition equipL03 = equipBaseL.addOrReplaceChild("EquipL03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 5.0F, 13.0F, 10.0F),
                PartPose.offsetAndRotation(6.0F, -6.0F, -2.0F, 0.0F, 0.0F, -0.3141592653589793F));

        equipL03.addOrReplaceChild("ChestCannonL01a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 7.0F, 8.0F, 3.0F),
                PartPose.offsetAndRotation(5.5F, 2.0F, 1.0F, -0.136659280431156F, -1.4114477660878142F,
                        0.0F));

        PartDefinition equipBaseR = bodyMain.addOrReplaceChild("EquipBaseR",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-9.0F, -6.0F, -8.5F, 18.0F, 5.0F, 18.0F),
                PartPose.offsetAndRotation(-20.0F, -3.0F, 2.0F, -0.7740535232594852F, 0.0F,
                        -0.17453292519943295F));

        PartDefinition equipR01 = equipBaseR.addOrReplaceChild("EquipR01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-7.0F, 0.0F, -7.0F, 14.0F, 4.0F, 14.0F),
                PartPose.offset(0.0F, -10.0F, 1.0F));

        equipR01.addOrReplaceChild("EquipR02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-9.0F, -9.0F, -9.0F, 18.0F, 9.0F, 20.0F),
                PartPose.offsetAndRotation(0.0F, 1.8F, 0.0F, -0.3141592653589793F, 0.13962634015954636F,
                        0.0F));

        PartDefinition equipR03 = equipBaseR.addOrReplaceChild("EquipR03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 5.0F, 13.0F, 10.0F),
                PartPose.offsetAndRotation(-7.0F, -6.0F, 7.0F, 0.0F, -3.141592653589793F,
                        0.3141592653589793F));

        equipR03.addOrReplaceChild("ChestCannonR01a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 7.0F, 8.0F, 3.0F),
                PartPose.offsetAndRotation(5.5F, 2.0F, 1.0F, -0.136659280431156F, -1.4114477660878142F,
                        0.0F));

        bodyMain.addOrReplaceChild("ChestCannon03a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 12.0F, 9.0F, 4.0F),
                PartPose.offsetAndRotation(-5.0F, -6.4F, -7.0F, -0.18203784098300857F,
                        -0.02024581932313422F, 0.0F));

        bodyMain.addOrReplaceChild("ChestCannon02a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 7.0F, 8.0F, 3.0F),
                PartPose.offsetAndRotation(4.6F, -2.4F, -7.0F, 0.091106186954104F, -0.091106186954104F,
                        0.0F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().texOffs(0, 92)
                        .addBox(-13.0F, -7.0F, -7.0F, 14.0F, 22.0F, 14.0F),
                PartPose.offsetAndRotation(-15.0F, 0.0F, 2.0F, -0.8726646259971648F,
                        0.20943951023931953F, 0.0F));

        armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().texOffs(0, 89)
                        .addBox(-6.5F, 0.0F, -13.0F, 13.0F, 26.0F, 13.0F),
                PartPose.offsetAndRotation(-6.0F, 15.0F, 7.0F, -0.6981317007977318F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("ChestCannon05a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 9.0F, 7.0F, 3.0F),
                PartPose.offsetAndRotation(-13.0F, -8.0F, -6.0F, -0.091106186954104F,
                        0.136659280431156F, 0.022126174344515567F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-9.0F, -18.0F, -6.0F, 18.0F, 18.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, -8.0F, 6.0F, -0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(0, 20)
                        .addBox(-9.5F, -9.0F, -16.0F, 19.0F, 12.0F, 19.0F),
                PartPose.offsetAndRotation(0.0F, -12.0F, -2.6F, -0.8726646259971648F, 0.0F, 0.0F));

        head.addOrReplaceChild("HeadTooth",
                CubeListBuilder.create().texOffs(68, 91)
                        .addBox(-7.5F, 0.0F, -7.5F, 15.0F, 4.0F, 15.0F),
                PartPose.offsetAndRotation(0.0F, 1.0F, -7.0F, 0.17453292519943295F, 0.0F, 0.0F));

        head.addOrReplaceChild("HeadBack01",
                CubeListBuilder.create().texOffs(45, 6)
                        .addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 12.0F),
                PartPose.offsetAndRotation(6.0F, -2.0F, 4.0F, 0.6829473363053812F, 0.4363323129985824F,
                        0.0F));

        head.addOrReplaceChild("HeadBack02",
                CubeListBuilder.create().texOffs(45, 6)
                        .addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -3.0F, 5.0F, 0.7740535232594852F, 0.08726646259971647F,
                        0.0F));

        head.addOrReplaceChild("HeadBack03",
                CubeListBuilder.create().texOffs(45, 6)
                        .addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 12.0F),
                PartPose.offsetAndRotation(-6.0F, -3.0F, 5.0F, 0.5918411493512771F,
                        -0.5009094953223726F, 0.0F));

        PartDefinition jaw = head.addOrReplaceChild("Jaw",
                CubeListBuilder.create().texOffs(77, 25)
                        .addBox(-8.5F, 0.0F, -14.5F, 17.0F, 9.0F, 17.0F),
                PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.8726646259971648F, 0.0F, 0.0F));

        jaw.addOrReplaceChild("Tongue",
                CubeListBuilder.create().texOffs(82, 54)
                        .addBox(-5.0F, 0.0F, -13.0F, 10.0F, 2.0F, 13.0F),
                PartPose.offset(0.0F, -3.1F, 1.0F));

        jaw.addOrReplaceChild("JawTooth",
                CubeListBuilder.create().texOffs(68, 91)
                        .addBox(-7.5F, 0.0F, -13.0F, 15.0F, 3.0F, 15.0F),
                PartPose.offsetAndRotation(0.0F, -1.5F, -0.5F, -0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 1.0471975511965976F, 0.0F, 0.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, -8.0F, 6.0F, -0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition glowEquipBaseL = glowBodyMain.addOrReplaceChild("GlowEquipBaseL",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(20.0F, -3.0F, 2.0F, -0.7740535232594852F, 0.0F,
                        0.17453292519943295F));

        PartDefinition glowEquipL01 = glowEquipBaseL.addOrReplaceChild("GlowEquipL01",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -10.0F, 1.0F));

        PartDefinition glowEquipL02 = glowEquipL01.addOrReplaceChild("GlowEquipL02",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 1.8F, 0.0F, -0.2617993877991494F,
                        -0.13962634015954636F, 0.0F));

        glowEquipL02.addOrReplaceChild("EquipCannon01",
                CubeListBuilder.create().texOffs(90, 0)
                        .addBox(0.0F, 0.0F, -16.0F, 3.0F, 3.0F, 16.0F),
                PartPose.offsetAndRotation(4.0F, -7.5F, -8.0F, -0.136659280431156F,
                        -0.08726646259971647F, 0.0F));

        glowEquipL02.addOrReplaceChild("EquipCannon02",
                CubeListBuilder.create().texOffs(90, 0)
                        .addBox(0.0F, 0.0F, -16.0F, 3.0F, 3.0F, 16.0F),
                PartPose.offsetAndRotation(-1.5F, -7.5F, -8.0F, -0.4553564018453205F, 0.0F, 0.0F));

        glowEquipL02.addOrReplaceChild("EquipCannon03",
                CubeListBuilder.create().texOffs(90, 0)
                        .addBox(0.0F, 0.0F, -16.0F, 3.0F, 3.0F, 16.0F),
                PartPose.offsetAndRotation(-7.0F, -7.5F, -8.0F, -0.27314402793711257F,
                        0.08726646259971647F, 0.0F));

        PartDefinition glowEquipL03 = glowEquipBaseL.addOrReplaceChild("GlowEquipL03",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(6.0F, -6.0F, -2.0F, 0.0F, 0.0F, -0.3141592653589793F));

        PartDefinition glowChestCannonL01a = glowEquipL03.addOrReplaceChild("GlowChestCannonL01a",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(5.5F, 2.0F, 1.0F, -0.136659280431156F,
                        -1.4114477660878142F, 0.0F));

        glowChestCannonL01a.addOrReplaceChild("ChestCannonL01b",
                CubeListBuilder.create().texOffs(84, 0)
                        .addBox(0.0F, 0.0F, -9.0F, 2.0F, 2.0F, 9.0F),
                PartPose.offsetAndRotation(2.5F, 2.5F, 1.0F, 0.136659280431156F,
                        0.091106186954104F, 0.0F));

        PartDefinition glowEquipBaseR = glowBodyMain.addOrReplaceChild("GlowEquipBaseR",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(-20.0F, -3.0F, 2.0F, -0.7740535232594852F, 0.0F,
                        -0.17453292519943295F));

        PartDefinition glowEquipR01 = glowEquipBaseR.addOrReplaceChild("GlowEquipR01",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -10.0F, 1.0F));

        PartDefinition glowEquipR02 = glowEquipR01.addOrReplaceChild("GlowEquipR02",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 1.8F, 0.0F, -0.3141592653589793F,
                        0.13962634015954636F, 0.0F));

        glowEquipR02.addOrReplaceChild("EquipCannon01_1",
                CubeListBuilder.create().texOffs(90, 0)
                        .addBox(0.0F, 0.0F, -16.0F, 3.0F, 3.0F, 16.0F),
                PartPose.offsetAndRotation(4.0F, -7.5F, -8.0F, 0.0F, -0.08726646259971647F, 0.0F));

        glowEquipR02.addOrReplaceChild("EquipCannon02_1",
                CubeListBuilder.create().texOffs(90, 0)
                        .addBox(0.0F, 0.0F, -16.0F, 3.0F, 3.0F, 16.0F),
                PartPose.offsetAndRotation(-1.5F, -7.5F, -8.0F, -0.18203784098300857F, 0.0F, 0.0F));

        glowEquipR02.addOrReplaceChild("EquipCannon03_1",
                CubeListBuilder.create().texOffs(90, 0)
                        .addBox(0.0F, 0.0F, -16.0F, 3.0F, 3.0F, 16.0F),
                PartPose.offsetAndRotation(-7.0F, -7.5F, -8.0F, -0.27314402793711257F,
                        0.08726646259971647F, 0.0F));

        PartDefinition glowEquipR03 = glowEquipBaseR.addOrReplaceChild("GlowEquipR03",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(-7.0F, -6.0F, 7.0F, 0.0F, -3.141592653589793F,
                        0.3141592653589793F));

        PartDefinition glowChestCannonR01a = glowEquipR03.addOrReplaceChild("GlowChestCannonR01a",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(5.5F, 2.0F, 1.0F, -0.136659280431156F,
                        -1.4114477660878142F, 0.0F));

        glowChestCannonR01a.addOrReplaceChild("ChestCannonR01b",
                CubeListBuilder.create().texOffs(84, 0)
                        .addBox(0.0F, 0.0F, -9.0F, 2.0F, 2.0F, 9.0F),
                PartPose.offsetAndRotation(2.5F, 2.5F, 1.0F, 0.18203784098300857F,
                        -0.18203784098300857F, 0.0F));

        PartDefinition glowChestCannon01a = glowBodyMain.addOrReplaceChild("GlowChestCannon01a",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(6.0F, -8.0F, -7.0F, -0.136659280431156F,
                        -0.091106186954104F, 0.0F));

        glowChestCannon01a.addOrReplaceChild("ChestCannon01b",
                CubeListBuilder.create().texOffs(84, 0)
                        .addBox(0.0F, 0.0F, -9.0F, 2.0F, 2.0F, 9.0F),
                PartPose.offsetAndRotation(2.5F, 3.5F, 1.0F, -0.4553564018453205F,
                        -0.5462880558742251F, 0.0F));

        PartDefinition glowChestCannon02a = glowBodyMain.addOrReplaceChild("GlowChestCannon02a",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(4.6F, -2.4F, -7.0F, 0.091106186954104F,
                        -0.091106186954104F, 0.0F));

        glowChestCannon02a.addOrReplaceChild("ChestCannon02b",
                CubeListBuilder.create().texOffs(84, 0)
                        .addBox(0.0F, 0.0F, -9.0F, 2.0F, 2.0F, 9.0F),
                PartPose.offsetAndRotation(2.5F, 2.5F, 1.0F, 0.045553093477052F,
                        -0.27314402793711257F, 0.0F));

        PartDefinition glowChestCannon03a = glowBodyMain.addOrReplaceChild("GlowChestCannon03a",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(-5.0F, -6.4F, -7.0F, -0.18203784098300857F,
                        -0.02024581932313422F, 0.0F));

        glowChestCannon03a.addOrReplaceChild("ChestCannon03b",
                CubeListBuilder.create().texOffs(84, 0)
                        .addBox(0.0F, 0.0F, -9.0F, 2.0F, 2.0F, 9.0F),
                PartPose.offsetAndRotation(4.5F, 2.5F, 1.5F, -0.6373942428283291F, 0.0F, 0.0F));

        PartDefinition glowChestCannon04a = glowBodyMain.addOrReplaceChild("GlowChestCannon04a",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(-10.0F, -1.0F, -7.0F, 0.18203784098300857F,
                        0.091106186954104F, 0.0F));

        glowChestCannon04a.addOrReplaceChild("ChestCannon04b",
                CubeListBuilder.create().texOffs(84, 0)
                        .addBox(0.0F, 0.0F, -9.0F, 2.0F, 2.0F, 9.0F),
                PartPose.offsetAndRotation(2.5F, 2.5F, 1.0F, -0.27314402793711257F,
                        0.22759093446006054F, 0.0F));

        PartDefinition glowChestCannon05a = glowBodyMain.addOrReplaceChild("GlowChestCannon05a",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(-13.0F, -8.0F, -6.0F, -0.091106186954104F,
                        0.136659280431156F, 0.022126174344515567F));

        glowChestCannon05a.addOrReplaceChild("ChestCannon05b",
                CubeListBuilder.create().texOffs(84, 0)
                        .addBox(0.0F, 0.0F, -9.0F, 2.0F, 2.0F, 9.0F),
                PartPose.offsetAndRotation(2.5F, 2.5F, 1.0F, -0.7285004297824331F,
                        0.3389429407372988F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
        IShipEmotion ent = (IShipEmotion) entity;
        float angleX = Mth.cos(ageInTicks * 0.08F);

        this.offsetY = 0F;
        if (ent.getShipDepth(0) > 0D) {
            // [PORT] 1.10.2 -> 1.20.1: restore mount water bobbing translation.
            // [RENDER?] Visual check required: water bobbing amplitude should match 1.10.2
            // mount behavior.
            // [REPRO?] Unverified visually: compare idle-on-water Y oscillation in client
            // runtime.
            this.offsetY += angleX * 0.025F + 0.025F;
        }

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
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
    }
}
