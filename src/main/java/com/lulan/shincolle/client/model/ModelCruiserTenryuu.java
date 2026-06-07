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

public class ModelCruiserTenryuu extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "cl_tenryuu"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Neck;
    private final ModelPart BoobR;
    private final ModelPart BoobL;
    private final ModelPart Butt;
    private final ModelPart ArmRight01;
    private final ModelPart ArmLeft01;
    private final ModelPart Cloth01;
    private final ModelPart EquipSR01;
    private final ModelPart Equip00;
    private final ModelPart Head;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart EarL01;
    private final ModelPart EarR01;
    private final ModelPart EyeMask;
    private final ModelPart HairU01;
    private final ModelPart Ahoke;
    private final ModelPart Hair01;
    private final ModelPart EarL02;
    private final ModelPart EarL03;
    private final ModelPart EarL04;
    private final ModelPart EarR02;
    private final ModelPart EarR03;
    private final ModelPart EarR04;
    private final ModelPart LegLeft01;
    private final ModelPart Skirt01;
    private final ModelPart LegRight01;
    private final ModelPart LegLeft02;
    private final ModelPart ShoeL01;
    private final ModelPart ShoeL00;
    private final ModelPart ShoeL02;
    private final ModelPart Skirt02;
    private final ModelPart LegRight02;
    private final ModelPart ShoeR01;
    private final ModelPart ShoeR00;
    private final ModelPart ShoeR02;
    private final ModelPart ArmRight02;
    private final ModelPart ArmRight02a;
    private final ModelPart ArmLeft02;
    private final ModelPart ArmLeft02a;
    private final ModelPart EquipSL00;
    private final ModelPart EquipSL00a;
    private final ModelPart EquipSL00b;
    private final ModelPart EquipSL01;
    private final ModelPart EquipSL02;
    private final ModelPart EquipSL02a;
    private final ModelPart EquipSL03;
    private final ModelPart EquipSL03a;
    private final ModelPart EquipSR02;
    private final ModelPart EquipSR03;
    private final ModelPart Equip01a;
    private final ModelPart Equip01b;
    private final ModelPart Equip01c;
    private final ModelPart Equip02a;
    private final ModelPart Equip01d;
    private final ModelPart Equip03L;
    private final ModelPart Equip03R;
    private final ModelPart EquipCL01;
    private final ModelPart EquipCL02;
    private final ModelPart EquipCL03;
    private final ModelPart EquipCL04;
    private final ModelPart EquipCL05;
    private final ModelPart EquipCR01;
    private final ModelPart EquipCR02;
    private final ModelPart EquipCR03;
    private final ModelPart EquipCR04;
    private final ModelPart EquipCR05;
    private final ModelPart Equip02b;
    private final ModelPart Equip02c;
    private final ModelPart Equip02d;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowNeck;
    private final ModelPart GlowHead;
    private final ModelPart GlowEquip00;
    private final ModelPart GlowEquip01a;
    private final ModelPart GlowEquip02a;

    public ModelCruiserTenryuu(ModelPart root) {
        super();
        this.BodyMain = root.getChild("BodyMain");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.Cloth01 = this.BodyMain.getChild("Cloth01");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.Neck = this.BodyMain.getChild("Neck");
        this.BoobL = this.BodyMain.getChild("BoobL");
        this.Butt = this.BodyMain.getChild("Butt");
        this.EquipSR01 = this.BodyMain.getChild("EquipSR01");
        this.Equip00 = this.BodyMain.getChild("Equip00");
        this.BoobR = this.BodyMain.getChild("BoobR");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.Head = this.Neck.getChild("Head");
        this.LegRight01 = this.Butt.getChild("LegRight01");
        this.Skirt01 = this.Butt.getChild("Skirt01");
        this.LegLeft01 = this.Butt.getChild("LegLeft01");
        this.EquipSR02 = this.EquipSR01.getChild("EquipSR02");
        this.Equip01a = this.Equip00.getChild("Equip01a");
        this.ArmRight02a = this.ArmRight02.getChild("ArmRight02a");
        this.EquipSL00 = this.ArmLeft02.getChild("EquipSL00");
        this.ArmLeft02a = this.ArmLeft02.getChild("ArmLeft02a");
        this.Hair = this.Head.getChild("Hair");
        this.EyeMask = this.Head.getChild("EyeMask");
        this.HairMain = this.Head.getChild("HairMain");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.Skirt02 = this.Skirt01.getChild("Skirt02");
        this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
        this.EquipSR03 = this.EquipSR02.getChild("EquipSR03");
        this.Equip01b = this.Equip01a.getChild("Equip01b");
        this.Equip01c = this.Equip01a.getChild("Equip01c");
        this.Equip02a = this.Equip01a.getChild("Equip02a");
        this.EquipSL00b = this.EquipSL00.getChild("EquipSL00b");
        this.EquipSL01 = this.EquipSL00.getChild("EquipSL01");
        this.EquipSL00a = this.EquipSL00.getChild("EquipSL00a");
        this.HairU01 = this.Hair.getChild("HairU01");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.Hair01 = this.HairMain.getChild("Hair01");
        this.ShoeR01 = this.LegRight02.getChild("ShoeR01");
        this.ShoeR00 = this.LegRight02.getChild("ShoeR00");
        this.ShoeL01 = this.LegLeft02.getChild("ShoeL01");
        this.ShoeL00 = this.LegLeft02.getChild("ShoeL00");
        this.Equip01d = this.Equip01c.getChild("Equip01d");
        this.EquipSL02 = this.EquipSL01.getChild("EquipSL02");
        this.ShoeR02 = this.ShoeR01.getChild("ShoeR02");
        this.ShoeL02 = this.ShoeL01.getChild("ShoeL02");
        this.Equip03R = this.Equip01d.getChild("Equip03R");
        this.Equip03L = this.Equip01d.getChild("Equip03L");
        this.EquipSL03 = this.EquipSL02.getChild("EquipSL03");
        this.EquipSL02a = this.EquipSL02.getChild("EquipSL02a");
        this.EquipCR01 = this.Equip03R.getChild("EquipCR01");
        this.EquipCL01 = this.Equip03L.getChild("EquipCL01");
        this.EquipSL03a = this.EquipSL03.getChild("EquipSL03a");
        this.EquipCR02 = this.EquipCR01.getChild("EquipCR02");
        this.EquipCL02 = this.EquipCL01.getChild("EquipCL02");
        this.EquipCR03 = this.EquipCR02.getChild("EquipCR03");
        this.EquipCL03 = this.EquipCL02.getChild("EquipCL03");
        this.EquipCR04 = this.EquipCR03.getChild("EquipCR04");
        this.EquipCL04 = this.EquipCL03.getChild("EquipCL04");
        this.EquipCR05 = this.EquipCR04.getChild("EquipCR05");
        this.EquipCL05 = this.EquipCL04.getChild("EquipCL05");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowNeck = this.GlowBodyMain.getChild("GlowNeck");
        this.GlowEquip00 = this.GlowBodyMain.getChild("GlowEquip00");
        this.GlowHead = this.GlowNeck.getChild("GlowHead");
        this.GlowEquip01a = this.GlowEquip00.getChild("GlowEquip01a");
        this.GlowEquip02a = this.GlowEquip01a.getChild("GlowEquip02a");
        this.EarL01 = this.GlowHead.getChild("EarL01");
        this.EarL02 = this.EarL01.getChild("EarL02");
        this.EarL03 = this.EarL02.getChild("EarL03");
        this.EarL04 = this.EarL03.getChild("EarL04");
        this.EarR01 = this.GlowHead.getChild("EarR01");
        this.EarR02 = this.EarR01.getChild("EarR02");
        this.EarR03 = this.EarR02.getChild("EarR03");
        this.EarR04 = this.EarR03.getChild("EarR04");
        this.Equip02b = this.GlowEquip02a.getChild("Equip02b");
        this.Equip02c = this.Equip02b.getChild("Equip02c");
        this.Equip02d = this.Equip02c.getChild("Equip02d");
        this.loadFaceParts(this.GlowHead);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 104)
                        .addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().mirror().texOffs(24, 84)
                        .addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, 0.0F, 0.0F, 0.3490658503988659F));

        PartDefinition armRight02 = armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().mirror().texOffs(24, 63)
                        .addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
                PartPose.offset(-3.0F, 11.0F, 2.5F));

        armRight02.addOrReplaceChild("ArmRight02a",
                CubeListBuilder.create().mirror().texOffs(104, 33)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F),
                PartPose.offsetAndRotation(2.5F, 1.3F, -2.4F, 0.06981317007977318F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("Cloth01",
                CubeListBuilder.create().texOffs(16, 22)
                        .addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 6.0F),
                PartPose.offset(0.0F, -11.7F, -0.2F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().texOffs(24, 84)
                        .addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.10471975511965977F, 0.0F, -0.3490658503988659F));

        PartDefinition armLeft02 = armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().texOffs(24, 63)
                        .addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
                PartPose.offset(3.0F, 11.0F, 2.5F));

        PartDefinition equipSL00 = armLeft02.addOrReplaceChild("EquipSL00",
                CubeListBuilder.create().texOffs(98, 27)
                        .addBox(0.0F, -4.0F, -0.5F, 2.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(-2.0F, 9.3F, -3.0F, -1.5707963267948966F, -0.13962634015954636F,
                        1.5707963267948966F));

        equipSL00.addOrReplaceChild("EquipSL00b",
                CubeListBuilder.create().texOffs(66, 40)
                        .addBox(0.0F, -2.0F, -0.5F, 3.0F, 2.0F, 1.0F),
                PartPose.offsetAndRotation(-0.1F, -3.8F, 0.0F, 0.0F, 0.0F, 0.13962634015954636F));

        PartDefinition equipSL01 = equipSL00.addOrReplaceChild("EquipSL01",
                CubeListBuilder.create().texOffs(90, 0)
                        .addBox(-2.5F, 0.0F, -0.5F, 3.0F, 12.0F, 1.0F),
                PartPose.offsetAndRotation(2.1F, 4.7F, 0.0F, 0.0F, 0.0F, 0.06981317007977318F));

        PartDefinition equipSL02 = equipSL01.addOrReplaceChild("EquipSL02",
                CubeListBuilder.create().texOffs(90, 0)
                        .addBox(-2.5F, 0.0F, -0.5F, 3.0F, 11.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 11.9F, 0.0F, 0.0F, 0.0F, 0.10471975511965977F));

        PartDefinition equipSL03 = equipSL02.addOrReplaceChild("EquipSL03",
                CubeListBuilder.create().texOffs(90, 0)
                        .addBox(-2.5F, 0.0F, -0.5F, 3.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 10.9F, 0.0F, 0.0F, 0.0F, 0.13962634015954636F));

        equipSL03.addOrReplaceChild("EquipSL03a",
                CubeListBuilder.create().texOffs(46, 62)
                        .addBox(-2.5F, 0.0F, -0.5F, 2.0F, 11.0F, 1.0F),
                PartPose.offsetAndRotation(-1.7F, -3.0F, -0.2F, 0.017453292519943295F, 0.0F, -0.15707963267948966F));

        equipSL02.addOrReplaceChild("EquipSL02a",
                CubeListBuilder.create().mirror().texOffs(46, 62)
                        .addBox(0.0F, 0.0F, -0.5F, 2.0F, 11.0F, 1.0F),
                PartPose.offsetAndRotation(-4.3F, -3.0F, 0.0F, -0.017453292519943295F, 0.0F, -0.05235987755982988F));

        equipSL00.addOrReplaceChild("EquipSL00a",
                CubeListBuilder.create().texOffs(67, 35)
                        .addBox(0.0F, 0.0F, -1.0F, 4.0F, 1.0F, 2.0F),
                PartPose.offset(-0.7F, 3.9F, 0.0F));

        armLeft02.addOrReplaceChild("ArmLeft02a",
                CubeListBuilder.create().texOffs(104, 33)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F),
                PartPose.offsetAndRotation(-2.5F, 1.3F, -2.4F, 0.06981317007977318F, 0.0F, 0.0F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(29, 12)
                        .addBox(-2.5F, -2.0F, -3.6F, 5.0F, 2.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offset(0.0F, -1.0F, -0.7F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(50, 77)
                        .addBox(-8.0F, -8.0F, -7.4F, 16.0F, 16.0F, 8.0F),
                PartPose.offset(0.0F, -7.5F, 0.1F));

        hair.addOrReplaceChild("HairU01",
                CubeListBuilder.create().texOffs(52, 56)
                        .addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F),
                PartPose.offset(0.0F, -6.0F, -7.0F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(106, 31)
                        .addBox(0.0F, -6.0F, -10.5F, 0.0F, 11.0F, 11.0F),
                PartPose.offsetAndRotation(-0.5F, -7.0F, -6.0F, 0.20943951023931953F, 0.6981317007977318F, 0.0F));

        head.addOrReplaceChild("EyeMask",
                CubeListBuilder.create().texOffs(114, 17)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 5.0F, 1.0F),
                PartPose.offsetAndRotation(2.7F, -8.4F, -6.7F, 0.0F, 0.0F, 0.4363323129985824F));

        PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(46, 104)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F),
                PartPose.offset(0.0F, -14.8F, -3.0F));

        hairMain.addOrReplaceChild("Hair01",
                CubeListBuilder.create().texOffs(46, 21)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 5.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 11.5F, 3.3F, 0.2617993877991494F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("BoobL",
                CubeListBuilder.create().mirror().texOffs(33, 101)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(3.5F, -8.1F, -3.7F, -0.6981317007977318F, 0.08726646259971647F,
                        0.08726646259971647F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(0, 47)
                        .addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));

        PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().mirror().texOffs(0, 84)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.20943951023931953F, 0.0F, -0.08726646259971647F));

        PartDefinition legRight02 = legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().mirror().texOffs(0, 63)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                PartPose.offset(-3.0F, 14.0F, -3.0F));

        PartDefinition shoeR01 = legRight02.addOrReplaceChild("ShoeR01",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F),
                PartPose.offset(3.0F, 10.5F, 3.0F));

        shoeR01.addOrReplaceChild("ShoeR02",
                CubeListBuilder.create().mirror().texOffs(74, 6)
                        .addBox(-0.5F, 0.0F, -10.0F, 1.0F, 3.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, -0.3F, -2.5F, -0.17453292519943295F, 0.0F, 0.0F));

        legRight02.addOrReplaceChild("ShoeR00",
                CubeListBuilder.create().mirror().texOffs(6, 5)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F),
                PartPose.offsetAndRotation(3.0F, 4.2F, 3.0F, 0.0F, -3.141592653589793F, 0.0F));

        PartDefinition skirt01 = butt.addOrReplaceChild("Skirt01",
                CubeListBuilder.create().texOffs(46, 43)
                        .addBox(-8.5F, 0.0F, -6.0F, 17.0F, 4.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 2.9F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));

        skirt01.addOrReplaceChild("Skirt02",
                CubeListBuilder.create().texOffs(0, 33)
                        .addBox(-9.0F, 0.0F, -6.0F, 18.0F, 4.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 2.8F, -0.5F, -0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().texOffs(0, 84)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.2792526803190927F, 0.0F, 0.08726646259971647F));

        PartDefinition legLeft02 = legLeft01.addOrReplaceChild("LegLeft02",
                CubeListBuilder.create().texOffs(0, 63)
                        .addBox(-6.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                PartPose.offset(3.0F, 14.0F, -3.0F));

        PartDefinition shoeL01 = legLeft02.addOrReplaceChild("ShoeL01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F),
                PartPose.offsetAndRotation(-3.0F, 10.5F, 3.0F, 0.08726646259971647F, 0.0F, 0.0F));

        shoeL01.addOrReplaceChild("ShoeL02",
                CubeListBuilder.create().texOffs(74, 6)
                        .addBox(-0.5F, 0.0F, -10.0F, 1.0F, 3.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, -0.3F, -2.5F, -0.17453292519943295F, 0.0F, 0.0F));

        legLeft02.addOrReplaceChild("ShoeL00",
                CubeListBuilder.create().texOffs(6, 5)
                        .addBox(-3.6F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F),
                PartPose.offsetAndRotation(-3.0F, 4.2F, 3.0F, 0.0F, -3.141592653589793F, 0.0F));

        PartDefinition equipSR01 = bodyMain.addOrReplaceChild("EquipSR01",
                CubeListBuilder.create().texOffs(118, 0)
                        .addBox(-1.0F, -2.0F, -1.5F, 2.0F, 12.0F, 3.0F),
                PartPose.offsetAndRotation(-9.0F, 5.5F, -5.0F, 1.3089969389957472F, -0.13962634015954636F,
                        -0.13962634015954636F));

        PartDefinition equipSR02 = equipSR01.addOrReplaceChild("EquipSR02",
                CubeListBuilder.create().texOffs(108, 0)
                        .addBox(-1.0F, 0.0F, -3.0F, 2.0F, 12.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 10.0F, 1.5F, -0.05235987755982988F, 0.0F, 0.0F));

        equipSR02.addOrReplaceChild("EquipSR03",
                CubeListBuilder.create().texOffs(98, 0)
                        .addBox(-1.0F, 0.0F, -3.0F, 2.0F, 12.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition equip00 = bodyMain.addOrReplaceChild("Equip00",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 5.0F, 0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition equip01a = equip00.addOrReplaceChild("Equip01a",
                CubeListBuilder.create().texOffs(28, 0)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 5.0F),
                PartPose.offset(0.0F, -12.0F, 0.0F));

        equip01a.addOrReplaceChild("Equip01b",
                CubeListBuilder.create().texOffs(52, 0)
                        .addBox(-5.5F, 0.0F, 0.0F, 11.0F, 11.0F, 5.0F),
                PartPose.offset(0.0F, 7.0F, 0.0F));

        PartDefinition equip01c = equip01a.addOrReplaceChild("Equip01c",
                CubeListBuilder.create().texOffs(28, 0)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 5.0F),
                PartPose.offset(0.0F, 0.0F, 5.0F));

        PartDefinition equip01d = equip01c.addOrReplaceChild("Equip01d",
                CubeListBuilder.create().texOffs(52, 0)
                        .addBox(-5.5F, 0.0F, 0.0F, 11.0F, 11.0F, 5.0F),
                PartPose.offset(0.0F, 7.0F, 0.0F));

        PartDefinition equip03R = equip01d.addOrReplaceChild("Equip03R",
                CubeListBuilder.create().mirror().texOffs(86, 104)
                        .addBox(-4.0F, 0.0F, 0.0F, 4.0F, 8.0F, 2.0F),
                PartPose.offset(-5.0F, 1.5F, 4.5F));

        PartDefinition equipCR01 = equip03R.addOrReplaceChild("EquipCR01",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F),
                PartPose.offset(-3.5F, 3.5F, 2.0F));

        PartDefinition equipCR02 = equipCR01.addOrReplaceChild("EquipCR02",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-5.0F, -3.0F, -2.0F, 5.0F, 7.0F, 7.0F),
                PartPose.offset(-1.9F, 0.0F, 0.0F));

        PartDefinition equipCR03 = equipCR02.addOrReplaceChild("EquipCR03",
                CubeListBuilder.create().mirror().texOffs(0, 18)
                        .addBox(-5.0F, 0.0F, 0.0F, 5.0F, 4.0F, 6.0F),
                PartPose.offset(0.0F, -7.0F, -1.5F));

        PartDefinition equipCR04 = equipCR03.addOrReplaceChild("EquipCR04",
                CubeListBuilder.create().mirror().texOffs(46, 36)
                        .addBox(-1.5F, -5.8F, -1.5F, 3.0F, 4.0F, 3.0F),
                PartPose.offset(-2.5F, 3.0F, 3.0F));

        equipCR04.addOrReplaceChild("EquipCR05",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-1.0F, -13.6F, -1.0F, 2.0F, 8.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition equip03L = equip01d.addOrReplaceChild("Equip03L",
                CubeListBuilder.create().texOffs(86, 104)
                        .addBox(0.0F, 0.0F, 0.0F, 4.0F, 8.0F, 2.0F),
                PartPose.offset(5.0F, 1.5F, 4.5F));

        PartDefinition equipCL01 = equip03L.addOrReplaceChild("EquipCL01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F),
                PartPose.offset(3.5F, 3.5F, 2.0F));

        PartDefinition equipCL02 = equipCL01.addOrReplaceChild("EquipCL02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, -3.0F, -2.0F, 5.0F, 7.0F, 7.0F),
                PartPose.offset(1.9F, 0.0F, 0.0F));

        PartDefinition equipCL03 = equipCL02.addOrReplaceChild("EquipCL03",
                CubeListBuilder.create().texOffs(0, 18)
                        .addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 6.0F),
                PartPose.offset(0.0F, -7.0F, -1.5F));

        PartDefinition equipCL04 = equipCL03.addOrReplaceChild("EquipCL04",
                CubeListBuilder.create().texOffs(46, 36)
                        .addBox(-1.5F, -5.8F, -1.5F, 3.0F, 4.0F, 3.0F),
                PartPose.offset(2.5F, 3.0F, 3.0F));

        equipCL04.addOrReplaceChild("EquipCL05",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -13.6F, -1.0F, 2.0F, 8.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        equip01a.addOrReplaceChild("Equip02a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-4.5F, 0.0F, 0.0F, 9.0F, 7.0F, 4.0F),
                PartPose.offset(0.0F, -0.4F, 10.0F));

        bodyMain.addOrReplaceChild("BoobR",
                CubeListBuilder.create().texOffs(33, 101)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(-3.5F, -8.1F, -3.7F, -0.6981317007977318F, -0.08726646259971647F,
                        -0.08726646259971647F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -15.0F, 0.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -10.3F, 0.5F));

        PartDefinition glowHead = glowNeck.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -1.0F, -0.7F));

        PartDefinition earL01 = glowHead.addOrReplaceChild("EarL01",
                CubeListBuilder.create().texOffs(43, 75)
                        .addBox(-1.0F, -2.5F, -2.5F, 2.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(9.0F, -11.0F, 4.0F, 0.08726646259971647F, -0.17453292519943295F,
                        -0.08726646259971647F));

        PartDefinition earL02 = earL01.addOrReplaceChild("EarL02",
                CubeListBuilder.create().texOffs(88, 41)
                        .addBox(0.0F, -4.0F, -3.5F, 2.0F, 4.0F, 7.0F),
                PartPose.offset(-1.0F, -2.5F, -1.0F));

        PartDefinition earL03 = earL02.addOrReplaceChild("EarL03",
                CubeListBuilder.create().texOffs(88, 31)
                        .addBox(0.0F, -5.0F, 0.0F, 2.0F, 4.0F, 6.0F),
                PartPose.offset(0.0F, -3.0F, -3.2F));

        earL03.addOrReplaceChild("EarL04",
                CubeListBuilder.create().texOffs(74, 34)
                        .addBox(0.0F, -4.0F, 0.0F, 2.0F, 4.0F, 5.0F),
                PartPose.offset(0.0F, -5.0F, 0.3F));

        PartDefinition earR01 = glowHead.addOrReplaceChild("EarR01",
                CubeListBuilder.create().mirror().texOffs(43, 75)
                        .addBox(-1.0F, -2.5F, -2.5F, 2.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(-9.0F, -11.0F, 4.0F, 0.08726646259971647F, 0.17453292519943295F,
                        0.08726646259971647F));

        PartDefinition earR02 = earR01.addOrReplaceChild("EarR02",
                CubeListBuilder.create().mirror().texOffs(88, 41)
                        .addBox(0.0F, -4.0F, -3.5F, 2.0F, 4.0F, 7.0F),
                PartPose.offset(-1.0F, -2.5F, -1.0F));

        PartDefinition earR03 = earR02.addOrReplaceChild("EarR03",
                CubeListBuilder.create().mirror().texOffs(88, 31)
                        .addBox(0.0F, -5.0F, 0.0F, 2.0F, 4.0F, 6.0F),
                PartPose.offset(0.0F, -3.0F, -3.2F));

        earR03.addOrReplaceChild("EarR04",
                CubeListBuilder.create().mirror().texOffs(74, 34)
                        .addBox(0.0F, -4.0F, 0.0F, 2.0F, 4.0F, 5.0F),
                PartPose.offset(0.0F, -5.0F, 0.3F));

        addDefaultFaceParts(glowHead);

        PartDefinition glowEquip00 = glowBodyMain.addOrReplaceChild("GlowEquip00",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 4.0F, 5.0F));

        PartDefinition glowEquip01a = glowEquip00.addOrReplaceChild("GlowEquip01a",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -12.0F, 0.0F));

        PartDefinition glowEquip02a = glowEquip01a.addOrReplaceChild("GlowEquip02a",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -0.4F, 10.0F));

        PartDefinition equip02b = glowEquip02a.addOrReplaceChild("Equip02b",
                CubeListBuilder.create().texOffs(104, 23)
                        .addBox(-4.0F, 0.0F, 0.0F, 8.0F, 6.0F, 4.0F),
                PartPose.offset(0.0F, 0.0F, 4.0F));

        PartDefinition equip02c = equip02b.addOrReplaceChild("Equip02c",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 1.0F),
                PartPose.offset(0.0F, 3.0F, 4.0F));

        equip02c.addOrReplaceChild("Equip02d",
                CubeListBuilder.create().texOffs(0, 28)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F),
                PartPose.offset(0.0F, -1.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                          float headPitch) {
        IShipEmotion ent = (IShipEmotion) entity;
        // set scale per scaleLevel
        switch (ent.getScaleLevel()) {
            case 3:
                this.scale = 1.64F;
                this.offsetY = -0.58F;
                break;
            case 2:
                this.scale = 1.23F;
                this.offsetY = -0.27F;
                break;
            case 1:
                this.scale = 0.82F;
                this.offsetY = 0.35F;
                break;
            default:
                this.scale = 0.41F;
                this.offsetY = 2.17F;
                break;
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

        int state = ent.getStateEmotion(ID.S.State);

        boolean flag = !EmotionHelper.checkModelState(0, state); // cannon
        this.Equip00.visible = !flag;
        this.GlowEquip00.visible = !flag;

        flag = !EmotionHelper.checkModelState(1, state); // head
        this.EarL01.visible = !flag;
        this.EarR01.visible = !flag;

        flag = !EmotionHelper.checkModelState(2, state); // sword
        this.EquipSL00.visible = !flag;
        this.EquipSR01.visible = !flag;

        flag = !EmotionHelper.checkModelState(3, state); // eye mask
        this.EyeMask.visible = !flag;

        flag = !EmotionHelper.checkModelState(4, state); // shoes
        this.ShoeL02.visible = !flag;
        this.ShoeR02.visible = !flag;
    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowBodyMain.xRot = this.BodyMain.xRot;
        this.GlowBodyMain.yRot = this.BodyMain.yRot;
        this.GlowBodyMain.zRot = this.BodyMain.zRot;
        this.GlowHead.xRot = this.Head.xRot;
        this.GlowHead.yRot = this.Head.yRot;
        this.GlowHead.zRot = this.Head.zRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        this.offsetY += 0.53F + 0.26F * ent.getScaleLevel();
        this.setFaceHungry(ent);

        // body
        this.Ahoke.xRot = 0.20943951023931953F;
        this.Ahoke.yRot = 0.6981317007977318F;
        this.Ahoke.zRot = 0.0F;
        this.Head.xRot = 0.15F;
        this.Head.yRot = 0.0F;
        this.Head.zRot = 0.0F;
        this.BodyMain.xRot = 1.7453292519943295F;
        this.BodyMain.yRot = 0.0F;
        this.BodyMain.zRot = -0.5235987755982988F;
        this.Butt.xRot = -0.7853981633974483F;
        this.Butt.yRot = 0.0F;
        this.Butt.zRot = 0.0F;
        // this.Butt.offsetY = 0F;
        this.Skirt01.xRot = 0F;
        // this.Skirt01.offsetY = 0F;
        this.Skirt02.xRot = -0.08726646259971647F;
        this.Skirt02.yRot = 0.0F;
        this.Skirt02.zRot = 0.0F;
        // arm
        this.ArmLeft01.xRot = -1.3962634015954636F;
        this.ArmLeft01.yRot = -0.3490658503988659F;
        this.ArmLeft01.zRot = -0.17453292519943295F;
        this.ArmLeft02.xRot = -1.48352986419518F;
        this.ArmLeft02.yRot = 0.0F;
        this.ArmLeft02.zRot = 0.0F;
        // this.ArmLeft02.offsetX = 0F;
        // this.ArmLeft02.offsetZ = -0.2F;
        this.ArmRight01.xRot = -1.3089969389957472F;
        this.ArmRight01.yRot = -0.8726646259971648F;
        this.ArmRight01.zRot = 0.0F;
        this.ArmRight02.xRot = 0.0F;
        this.ArmRight02.yRot = 0.0F;
        this.ArmRight02.zRot = -0.17453292519943295F;
        // this.ArmRight02.offsetX = 0F;
        // leg
        this.LegLeft01.xRot = -0.6981317007977318F;
        this.LegLeft01.yRot = -0.6981317007977318F;
        this.LegLeft01.zRot = -0.2617993877991494F;
        this.LegLeft02.xRot = 1.5707963267948966F;
        this.LegLeft02.yRot = 0.0F;
        this.LegLeft02.zRot = 0.0F;
        // this.LegLeft02.offsetX = 0F;
        // this.LegLeft02.offsetY = 0F;
        // this.LegLeft02.offsetZ = 0F;
        this.LegRight01.xRot = 0.0F;
        this.LegRight01.yRot = -0.7853981633974483F;
        this.LegRight01.zRot = -0.5759586531581287F;
        this.LegRight02.xRot = 1.3089969389957472F;
        this.LegRight02.yRot = 0.0F;
        this.LegRight02.zRot = 0.0F;
        // this.LegRight02.offsetX = 0F;
        // this.LegRight02.offsetY = 0F;
        // this.LegRight02.offsetZ = 0F;
        // equip
        this.EquipSL00.visible = false;
        this.Equip00.xRot = 0.08726646259971647F;
        this.Equip00.yRot = 0.0F;
        this.Equip00.zRot = 0.0F;
        this.EquipSR01.xRot = -0.1F;
        this.EquipSR01.yRot = -0.13962634015954636F;
        this.EquipSR01.zRot = -0.13962634015954636F;
        this.EarL01.xRot = 0.6F;
        this.EarL01.yRot = -0.17453292519943295F;
        this.EarL01.zRot = -0.08726646259971647F;
        this.EarR01.xRot = 0.6F;
        this.EarR01.yRot = 0.17453292519943295F;
        this.EarR01.zRot = 0.08726646259971647F;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float angleX = Mth.cos(f2 * 0.08F + f * 0.25F);
        float angleX1 = Mth.cos(f2 * 0.1F + 0.3F + f * 0.5F);
        float angleAdd1 = Mth.cos(f * 0.7F) * f1;
        float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
        float addk1;
        float addk2;
        float headX = 0F;
        float headZ = 0F;
        float t2 = ent.getTickExisted() & 511;

        // 水上漂浮
        if (ent.getShipDepth(0) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        // leg move
        addk1 = angleAdd1 * 0.5F - 0.28F; // LegLeft01
        addk2 = angleAdd2 * 0.5F - 0.21F; // LegRight01

        // head
        this.Head.xRot = f4 * 0.014F;
        this.Head.yRot = f3 * 0.01F;
        // boob
        this.BoobL.xRot = angleX * 0.06F - 0.8F;
        this.BoobR.xRot = angleX * 0.06F - 0.8F;
        // body
        this.Ahoke.yRot = angleX * 0.25F + 0.7F;
        this.BodyMain.xRot = -0.1047F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        this.Butt.xRot = 0.35F;
        this.Skirt01.xRot = -0.14F;
        this.Skirt02.xRot = -0.09F;
        // this.Skirt02.offsetY = 0F;
        // arm
        this.ArmLeft01.xRot = angleAdd2 * 0.25F + 0.2F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = angleX * 0.03F - 0.25F;
        this.ArmLeft02.xRot = 0F;
        this.ArmLeft02.zRot = 0F;
        // this.ArmLeft02.offsetX = 0F;
        // this.ArmLeft02.offsetZ = 0F;
        this.ArmRight01.xRot = 0F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = -angleX * 0.03F + 0.25F;
        this.ArmRight02.xRot = 0F;
        this.ArmRight02.zRot = 0F;
        // this.ArmRight02.offsetX = 0F;
        // leg
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.0873F;
        this.LegLeft02.xRot = 0F;
        this.LegLeft02.yRot = 0F;
        this.LegLeft02.zRot = 0F;
        // this.LegLeft02.offsetX = 0F;
        // this.LegLeft02.offsetZ = 0F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.0873F;
        this.LegRight02.xRot = 0F;
        this.LegRight02.yRot = 0F;
        this.LegRight02.zRot = 0F;
        // this.LegRight02.offsetX = 0F;
        // this.LegRight02.offsetY = 0F;
        // this.LegRight02.offsetZ = 0F;
        // equip
        this.EquipSL00.xRot = -1.57F;
        this.EquipSL00.yRot = -0.14F;
        this.EquipSL00.zRot = 1.57F;
        this.EquipSR01.xRot = 1.3F;
        this.EquipCL02.xRot = f4 * 0.008F + 0.7F;
        this.EquipCR02.xRot = f4 * 0.008F + 0.7F;
        this.EquipCL04.xRot = f4 * 0.008F;
        this.EquipCR04.xRot = f4 * 0.008F;
        this.EarL01.xRot = angleX * 0.1F + 0.0873F;
        this.EarR01.xRot = angleX * 0.1F + 0.0873F;

        float modf2 = f2 % 128F;
        if (modf2 < 6F) {
            // total 3 ticks, loop twice in 6 ticks
            if (modf2 >= 3F)
                modf2 -= 3F;
            float anglef2 = Mth.sin(modf2 * 1.0472F) * 0.08F;
            this.EarL01.zRot = -anglef2 - 0.0873F;
            this.EarR01.zRot = anglef2 + 0.0873F;
        } else {
            this.EarL01.zRot = -0.0873F;
            this.EarR01.zRot = 0.0873F;
        }

        // special stand pos
        if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
            if (t2 > 180) {
                // arm
                this.ArmLeft01.xRot = 0.44F;
                this.ArmLeft01.yRot = -0.14F;
                this.ArmLeft01.zRot = -0.52F;
                this.ArmRight01.xRot = -0.17F;
                this.ArmRight01.yRot = 0F;
                this.ArmRight01.zRot = 0.7F;
                this.ArmRight02.zRot = -1.22F;
                // leg
                addk1 = angleAdd1 * 0.5F - 0.35F; // LegLeft01
                addk2 = angleAdd2 * 0.5F - 0.09F; // LegRight01

                if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED) {
                    // arm
                    this.ArmLeft01.xRot = -1.4F;
                    this.ArmLeft01.yRot = -1.4F;
                    this.ArmLeft01.zRot = 0.87F;
                    this.ArmLeft02.xRot = -2.1F;
                    // this.ArmLeft02.offsetZ = -0.32F;
                    // equip
                    this.EquipSL00.xRot = -1.83F;
                    this.EquipSL00.yRot = 0.35F;
                    this.EquipSL00.zRot = 1.57F;
                }
            } else {
                this.setFace(8);
                // body
                this.BodyMain.xRot = -0.44F;
                this.Head.xRot = 0.52F;
                this.Head.yRot = 0F;
                this.Head.zRot = 0F;
                // arm
                this.ArmLeft01.xRot = -1.05F;
                this.ArmLeft01.yRot = -1.05F;
                this.ArmLeft01.zRot = 1.4F;
                this.ArmLeft02.zRot = 2.1F;
                // this.ArmLeft02.offsetX = -0.32F;
                // this.ArmLeft02.offsetZ = 0F;
                this.ArmRight01.xRot = -1.57F;
                this.ArmRight01.yRot = -1.31F;
                this.ArmRight01.zRot = 1.22F;
                this.ArmRight02.xRot = -0.96F;
                // leg
                addk1 = angleAdd1 * 0.5F + 0.4F; // LegLeft01
                addk2 = angleAdd2 * 0.5F + 0.09F; // LegRight01
                this.LegLeft01.yRot = 0F;
                this.LegLeft01.zRot = f1 > 0.1F ? 0.05F : 0.26F;
                this.LegRight01.yRot = 0F;
                this.LegRight01.zRot = f1 > 0.1F ? -0.05F : -0.26F;
                // skirt
                this.Skirt01.xRot = 0F;
                this.Skirt02.xRot = 0.09F;
                // equip
                this.EquipSL00.visible = false;
            }
        }

        if (ent.getIsSprinting() || f1 > 0.9F) {
            // 奔跑動作
            // body
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += this.scale * 0.1F;
            this.Head.xRot -= 0.6F;
            this.BodyMain.xRot = 0.9F;
            this.Butt.xRot -= 0.7F;
            this.Skirt01.xRot = -0.15F;
            this.Skirt02.xRot = -0.32F;
            // arm
            this.ArmLeft01.xRot = 0.7F;
            this.ArmLeft01.yRot = -1.1F;
            this.ArmLeft01.zRot = -1F;
            this.ArmRight01.xRot = 0.7F;
            this.ArmRight01.yRot = 1.1F;
            this.ArmRight01.zRot = 1F;
            if (this.EquipSR01.visible) {
                this.ArmRight02.zRot = 0F;
            } else if (t2 > 300) {
                this.ArmRight02.zRot = -1.1F;
            }
            // leg
            addk1 = angleAdd1 - 0.28F; // LegLeft01
            addk2 = angleAdd2 - 0.21F; // LegRight01
            // equip
            this.EquipSR01.xRot = 0.7F;
        }

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        if (ent.getIsSneaking()) {
            // 潛行, 蹲下動作
            // Body
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += this.scale * 0.06F;
            this.Head.xRot -= 1.0472F;
            this.BodyMain.xRot = 1.0472F;
            this.Butt.xRot = -0.4F;
            this.Skirt01.xRot = -0.12F;
            this.Skirt02.xRot = -0.16F;
            // this.Skirt02.offsetY = -0.1F;
            // arm
            if (this.EquipSL00.visible) {
                this.ArmLeft01.xRot = -0.6F;
                this.ArmLeft01.zRot = 0.2618F;
                this.ArmRight01.xRot = -0.6F;
                this.ArmRight01.zRot = -0.2618F;
            } else {
                this.ArmLeft01.xRot = angleAdd2 * 0.25F - 0.1F;
                this.ArmLeft01.yRot = -0.7F;
                this.ArmLeft01.zRot = -0.3F;
                this.ArmRight01.xRot = angleAdd1 * 0.25F - 0.1F;
                this.ArmRight01.yRot = 0.7F;
                this.ArmRight01.zRot = 0.3F;
            }
            // leg
            addk1 -= 0.4F;
            addk2 -= 0.4F;
            // equip
            this.EquipSR01.xRot = 0F;
        } // end if sneaking

        // 坐下動作
        if (ent.getIsSitting() || ent.getIsRiding()) {
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                // body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.41F;
                this.BodyMain.xRot = 0.7F;
                this.Butt.xRot = -0.79F;
                this.Head.xRot -= 1.2F;
                // arm
                if (!this.EquipSL00.visible && ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED) {
                    // arm
                    this.ArmLeft01.xRot = -2.44F;
                    this.ArmLeft01.yRot = 1.05F;
                    this.ArmLeft01.zRot = 2.44F;
                    this.ArmLeft02.xRot = 0F;
                    this.ArmLeft02.zRot = 1.92F;
                    // this.ArmLeft02.offsetX = -0.32F;
                    // this.ArmLeft02.offsetZ = 0F;
                    this.ArmRight01.xRot = -1.13F;
                    this.ArmRight01.yRot = 0.44F;
                    this.ArmRight01.zRot = 0.52F;
                    this.ArmRight02.xRot = 0F;
                    this.ArmRight02.zRot = -0.52F;
                    // equip
                    this.EquipSL00.xRot = -0.3F;
                    this.EquipSL00.yRot = -0.22F;
                    this.EquipSL00.zRot = 1.77F;
                    this.EquipSR01.xRot = 0.81F;
                } else {
                    this.ArmLeft01.xRot = -1.13F;
                    this.ArmLeft01.yRot = -0.44F;
                    this.ArmLeft01.zRot = -0.52F;
                    this.ArmLeft02.xRot = 0F;
                    this.ArmLeft02.zRot = 0.52F;
                    // this.ArmLeft02.offsetX = 0F;
                    // this.ArmLeft02.offsetZ = 0F;
                    this.ArmRight01.xRot = -1.13F;
                    this.ArmRight01.yRot = 0.44F;
                    this.ArmRight01.zRot = 0.52F;
                    this.ArmRight02.xRot = 0F;
                    this.ArmRight02.zRot = -0.52F;
                    // equip
                    this.EquipSL00.xRot = -0.2F;
                    this.EquipSL00.yRot = -0.1F;
                    this.EquipSL00.zRot = 1.4F;
                    this.EquipSR01.xRot = 0.81F;
                }

                // leg
                addk1 = -2.1F;
                addk2 = -2.1F;
                this.LegLeft01.yRot = -0.58F;
                this.LegLeft01.zRot = 0.05F;
                this.LegLeft02.xRot = 2.44F;
                // this.LegLeft02.offsetZ = 0.38F;
                this.LegRight01.yRot = 0.58F;
                this.LegRight01.zRot = -0.05F;
                this.LegRight02.xRot = 2.44F;
                // this.LegRight02.offsetZ = 0.38F;
                // skirt
                this.Skirt01.xRot = -0.17F;
                this.Skirt02.xRot = -0.26F;
            } else {
                // body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.46F;
                this.BodyMain.xRot = 0.08726646259971647F;
                this.Butt.xRot = -0.17453292519943295F;
                this.Head.xRot -= 0.2F;
                // arm
                this.ArmLeft01.xRot = 0.2617993877991494F;
                this.ArmLeft01.yRot = 0.0F;
                this.ArmLeft01.zRot = -0.2617993877991494F;
                this.ArmLeft02.xRot = 0F;
                this.ArmLeft02.yRot = 0F;
                this.ArmLeft02.zRot = 0F;
                // this.ArmLeft02.offsetX = 0F;
                // this.ArmLeft02.offsetZ = 0F;
                this.ArmRight01.xRot = -1.1344640137963142F;
                this.ArmRight01.yRot = 0.0F;
                this.ArmRight01.zRot = 0.0F;
                this.ArmRight02.xRot = 0.0F;
                this.ArmRight02.zRot = -1.2217304763960306F;
                // leg
                addk1 = -1.45F;
                addk2 = -2.1F;
                this.LegLeft01.xRot = -1.4486232791552935F;
                this.LegLeft01.yRot = 0.08726646259971647F;
                this.LegLeft01.zRot = 0.0F;
                this.LegLeft02.xRot = 0F;
                this.LegLeft02.zRot = 0F;
                this.LegRight01.xRot = -2.0943951023931953F;
                this.LegRight01.yRot = 0.091106186954104F;
                this.LegRight01.zRot = 0.17453292519943295F;
                this.LegRight02.xRot = 1.3962634015954636F;
                this.LegRight02.zRot = 0.0F;
                // skirt
                this.Skirt01.xRot = -0.17F;
                this.Skirt02.xRot = -0.26F;
                // equip
                this.EquipSL00.xRot = -1.6755160819145563F;
                this.EquipSL00.yRot = 0.17453292519943295F;
                this.EquipSL00.zRot = 0.8726646259971648F;
                this.EquipSR01.xRot = 1.3089969389957472F;
                this.EquipSR01.yRot = -0.13962634015954636F;
                this.EquipSR01.zRot = -0.13962634015954636F;
            }
        } // end if sitting

        // 攻擊動作: 設為30~50會有揮刀動作, 設為100則沒有揮刀動作
        if (ent.getAttackTick() > 30) {
            // reset attack tick
            if (ent.getAttackTick() == 60)
                ent.setAttackTick(0);
            // body
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.22F + ent.getScaleLevel() * 0.12F;
            this.Head.xRot = -0.4363323129985824F;
            this.Head.yRot = 0.0F;
            this.Head.zRot = 0.0F;
            this.BodyMain.xRot = 1.0471975511965976F;
            this.BodyMain.yRot = 0.2617993877991494F;
            this.BodyMain.zRot = 0.0F;
            this.Butt.xRot = -0.5235987755982988F;
            this.Butt.yRot = 0.0F;
            this.Butt.zRot = 0.0F;
            // arm
            this.ArmLeft01.xRot = -0.7853981633974483F;
            this.ArmLeft01.yRot = 0.2617993877991494F;
            this.ArmLeft01.zRot = 0.5235987755982988F;
            this.ArmLeft02.xRot = 0.0F;
            this.ArmLeft02.yRot = 0.0F;
            this.ArmLeft02.zRot = 0.7853981633974483F;
            // this.ArmLeft02.offsetX = 0F;
            // this.ArmLeft02.offsetZ = 0F;
            this.ArmRight01.xRot = 0.5235987755982988F;
            this.ArmRight01.yRot = -0.3490658503988659F;
            this.ArmRight01.zRot = 0.17453292519943295F;
            this.ArmRight02.xRot = -1.3089969389957472F;
            this.ArmRight02.yRot = 0.0F;
            this.ArmRight02.zRot = 0.0F;
            // this.ArmRight02.offsetX = 0F;
            // this.ArmRight02.offsetZ = 0F;
            // leg
            addk1 = 0.31F;
            addk2 = -1.57F;
            this.LegLeft01.yRot = -0.17453292519943295F;
            this.LegLeft01.zRot = 0.08726646259971647F;
            this.LegLeft02.xRot = 0.13F;
            this.LegLeft02.yRot = 0.0F;
            this.LegLeft02.zRot = 0.0F;
            // this.LegLeft02.offsetX = 0F;
            // this.LegLeft02.offsetZ = 0F;
            this.LegRight01.yRot = 0.0F;
            this.LegRight01.zRot = 0.13962634015954636F;
            this.LegRight02.xRot = 1.2292353921796064F;
            this.LegRight02.yRot = 0.0F;
            this.LegRight02.zRot = 0.0F;
            // this.LegRight02.offsetX = 0F;
            // this.LegRight02.offsetZ = 0F;
            // equip
            this.EquipSL00.visible = true;
            this.EquipSR01.xRot = 0.8651597102135892F;
            this.EquipSR01.yRot = -0.13962634015954636F;
            this.EquipSR01.zRot = -0.13962634015954636F;
            this.EquipSL00.xRot = 1.593485607070823F;
            this.EquipSL00.yRot = 0.18203784098300857F;
            this.EquipSL00.zRot = 1.5707963267948966F;

            // swing sword
            if (ent.getAttackTick() < 51) {
                if (ent.getAttackTick() > 45) {
                    int tick = 4 - (ent.getAttackTick() - 46);
                    float parTick = f2 - (int) f2 + tick;
                    // arm
                    this.ArmLeft01.xRot = -0.785F - 0.644F * parTick;
                    this.ArmLeft02.zRot = 0.785F - 0.157F * parTick;
                    // equip
                    this.EquipSL00.yRot = 0.182F + 0.278F * parTick;
                } else {
                    // arm
                    this.ArmLeft01.xRot = -4.1F;
                    this.ArmLeft02.zRot = 0F;
                    // equip
                    this.EquipSL00.yRot = 1.57F;
                }
            }

            // final attack
            if (ent.getStateEmotion(ID.S.Phase) == 3) {
                // body
                this.BodyMain.xRot = 2.1F;
                // arm
                this.ArmLeft01.xRot = -1.92F;
                this.ArmLeft01.yRot = 0.4F;
                this.ArmLeft01.zRot = 0.26F;
                this.ArmLeft02.zRot = 0F;
                this.ArmRight01.xRot = -1.92F;
                this.ArmRight01.yRot = -0.4F;
                this.ArmRight01.zRot = 0.26F;
                this.ArmRight02.xRot = 0F;
                // equip
                this.EquipSL00.xRot = -1.4F;
                this.EquipSL00.yRot = -0.14F;
                this.EquipSL00.zRot = 1.57F;
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

        // leg motion
        this.LegLeft01.xRot = addk1;
        this.LegRight01.xRot = addk2;
    }
}
