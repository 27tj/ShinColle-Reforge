package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.entity.IShipFloating;
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

public class ModelCarrierAkagi extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "cv_akagi"), "main");

    private final ModelPart BodyMain;
    private final ModelPart BoobR;
    private final ModelPart BoobL;
    private final ModelPart Butt;
    private final ModelPart Head;
    private final ModelPart Cloth01;
    private final ModelPart Cloth02;
    private final ModelPart Cloth05;
    private final ModelPart Cloth06;
    private final ModelPart EquipB01;
    private final ModelPart EquipC01;
    private final ModelPart EquipABase;
    private final ModelPart ArmLeft01;
    private final ModelPart ArmRight01;
    private final ModelPart ClothBody01;
    private final ModelPart ClothBody02;
    private final ModelPart LegRight01;
    private final ModelPart LegLeft01;
    private final ModelPart Skirt01;
    private final ModelPart Tail01;
    private final ModelPart LegRight02;
    private final ModelPart EquipSR01;
    private final ModelPart LegLeft02;
    private final ModelPart EquipSL01;
    private final ModelPart Skirt02;
    private final ModelPart Cloth07;
    private final ModelPart Cloth08;
    private final ModelPart Cloth09;
    private final ModelPart EquipS01;
    private final ModelPart Tail02;
    private final ModelPart Tail03;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart Ear01;
    private final ModelPart Ear02;
    private final ModelPart Ahoke;
    private final ModelPart HairU01;
    private final ModelPart HairR01;
    private final ModelPart HairL01;
    private final ModelPart HairR02;
    private final ModelPart HairL02;
    private final ModelPart Hair01;
    private final ModelPart Hair02;
    private final ModelPart Cloth03;
    private final ModelPart Cloth04;
    private final ModelPart EquipC02;
    private final ModelPart EquipABelt01;
    private final ModelPart EquipABody01;
    private final ModelPart EquipABody04;
    private final ModelPart EquipABody02;
    private final ModelPart EquipABody03;
    private final ModelPart EquipABody05;
    private final ModelPart EquipAArr01a;
    private final ModelPart EquipAArr02a;
    private final ModelPart EquipAArr03a;
    private final ModelPart EquipABody05b;
    private final ModelPart EquipABody05c;
    private final ModelPart EquipABelt02;
    private final ModelPart EquipAArr01b;
    private final ModelPart EquipAArr02b;
    private final ModelPart EquipAArr03b;
    private final ModelPart ArmLeft02;
    private final ModelPart ClothHL01;
    private final ModelPart EquipE01;
    private final ModelPart EquipE02;
    private final ModelPart EquipE04;
    private final ModelPart EquipE03;
    private final ModelPart EquipE05;
    private final ModelPart EquipE06;
    private final ModelPart ClothHL02;
    private final ModelPart ClothHL03;
    private final ModelPart ArmRight02;
    private final ModelPart ClothHL01_1;
    private final ModelPart EquipD01;
    private final ModelPart EquipGlove;
    private final ModelPart ClothHL02_1;
    private final ModelPart ClothHL03_1;
    private final ModelPart EquipD02;
    private final ModelPart EquipD03;
    private final ModelPart EquipD04;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowHead;

    public ModelCarrierAkagi(ModelPart root) {
        super();
        this.BodyMain = root.getChild("BodyMain");
        this.ClothBody02 = this.BodyMain.getChild("ClothBody02");
        this.Head = this.BodyMain.getChild("Head");
        this.BoobL = this.BodyMain.getChild("BoobL");
        this.Butt = this.BodyMain.getChild("Butt");
        this.EquipABase = this.BodyMain.getChild("EquipABase");
        this.Cloth02 = this.BodyMain.getChild("Cloth02");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.Cloth01 = this.BodyMain.getChild("Cloth01");
        this.EquipB01 = this.BodyMain.getChild("EquipB01");
        this.ClothBody01 = this.BodyMain.getChild("ClothBody01");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.Cloth06 = this.BodyMain.getChild("Cloth06");
        this.EquipC01 = this.BodyMain.getChild("EquipC01");
        this.BoobR = this.BodyMain.getChild("BoobR");
        this.Cloth05 = this.BodyMain.getChild("Cloth05");
        this.Ear02 = this.Head.getChild("Ear02");
        this.Hair = this.Head.getChild("Hair");
        this.Ear01 = this.Head.getChild("Ear01");
        this.HairMain = this.Head.getChild("HairMain");
        this.LegLeft01 = this.Butt.getChild("LegLeft01");
        this.LegRight01 = this.Butt.getChild("LegRight01");
        this.Skirt01 = this.Butt.getChild("Skirt01");
        this.Tail01 = this.Butt.getChild("Tail01");
        this.EquipABelt01 = this.EquipABase.getChild("EquipABelt01");
        this.Cloth03 = this.Cloth02.getChild("Cloth03");
        this.Cloth04 = this.Cloth02.getChild("Cloth04");
        this.EquipD01 = this.ArmRight01.getChild("EquipD01");
        this.ClothHL01_1 = this.ArmRight01.getChild("ClothHL01_1");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.ClothHL01 = this.ArmLeft01.getChild("ClothHL01");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.EquipC02 = this.EquipC01.getChild("EquipC02");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.HairR01 = this.Hair.getChild("HairR01");
        this.HairL01 = this.Hair.getChild("HairL01");
        this.HairU01 = this.Hair.getChild("HairU01");
        this.Hair01 = this.HairMain.getChild("Hair01");
        this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.Cloth08 = this.Skirt01.getChild("Cloth08");
        this.Cloth09 = this.Skirt01.getChild("Cloth09");
        this.EquipS01 = this.Skirt01.getChild("EquipS01");
        this.Skirt02 = this.Skirt01.getChild("Skirt02");
        this.Cloth07 = this.Skirt01.getChild("Cloth07");
        this.Tail02 = this.Tail01.getChild("Tail02");
        this.EquipABody01 = this.EquipABelt01.getChild("EquipABody01");
        this.EquipD02 = this.EquipD01.getChild("EquipD02");
        this.ClothHL02_1 = this.ClothHL01_1.getChild("ClothHL02_1");
        this.EquipGlove = this.ArmRight02.getChild("EquipGlove");
        this.ClothHL02 = this.ClothHL01.getChild("ClothHL02");
        this.EquipE01 = this.ArmLeft02.getChild("EquipE01");
        this.HairR02 = this.HairR01.getChild("HairR02");
        this.HairL02 = this.HairL01.getChild("HairL02");
        this.Hair02 = this.Hair01.getChild("Hair02");
        this.EquipSL01 = this.LegLeft02.getChild("EquipSL01");
        this.EquipSR01 = this.LegRight02.getChild("EquipSR01");
        this.Tail03 = this.Tail02.getChild("Tail03");
        this.EquipABody02 = this.EquipABody01.getChild("EquipABody02");
        this.EquipABody03 = this.EquipABody01.getChild("EquipABody03");
        this.EquipABody04 = this.EquipABody01.getChild("EquipABody04");
        this.EquipD03 = this.EquipD02.getChild("EquipD03");
        this.ClothHL03_1 = this.ClothHL02_1.getChild("ClothHL03_1");
        this.ClothHL03 = this.ClothHL02.getChild("ClothHL03");
        this.EquipE02 = this.EquipE01.getChild("EquipE02");
        this.EquipE04 = this.EquipE01.getChild("EquipE04");
        this.EquipAArr01a = this.EquipABody04.getChild("EquipAArr01a");
        this.EquipAArr02a = this.EquipABody04.getChild("EquipAArr02a");
        this.EquipABody05 = this.EquipABody04.getChild("EquipABody05");
        this.EquipAArr03a = this.EquipABody04.getChild("EquipAArr03a");
        this.EquipD04 = this.EquipD03.getChild("EquipD04");
        this.EquipE03 = this.EquipE02.getChild("EquipE03");
        this.EquipE05 = this.EquipE04.getChild("EquipE05");
        this.EquipAArr01b = this.EquipAArr01a.getChild("EquipAArr01b");
        this.EquipAArr02b = this.EquipAArr02a.getChild("EquipAArr02b");
        this.EquipABody05b = this.EquipABody05.getChild("EquipABody05b");
        this.EquipAArr03b = this.EquipAArr03a.getChild("EquipAArr03b");
        this.EquipE06 = this.EquipE05.getChild("EquipE06");
        this.EquipABody05c = this.EquipABody05b.getChild("EquipABody05c");
        this.EquipABelt02 = this.EquipABody05c.getChild("EquipABelt02");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowHead = this.GlowBodyMain.getChild("GlowHead");
        this.loadFaceParts(this.GlowHead);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 104)
                        .addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("ClothBody02",
                CubeListBuilder.create().texOffs(0, 113)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 5.0F),
                PartPose.offsetAndRotation(-6.0F, -3.8F, -2.3F, 0.2617993877991494F, 0.0F,
                        0.2617993877991494F));

        PartDefinition head = bodyMain.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, -11.8F, -1.0F, 0.10471975511965977F, 0.0F, 0.0F));

        head.addOrReplaceChild("Ear02",
                CubeListBuilder.create().texOffs(20, 0)
                        .addBox(-1.5F, 0.0F, -6.0F, 3.0F, 6.0F, 6.0F),
                PartPose.offsetAndRotation(3.8F, -14.5F, 5.7F, -0.7853981633974483F,
                        -0.2617993877991494F, 0.13962634015954636F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(50, 81)
                        .addBox(-8.0F, -8.0F, -7.4F, 16.0F, 12.0F, 8.0F),
                PartPose.offset(0.0F, -7.5F, 0.2F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(104, 29)
                        .addBox(0.0F, -4.0F, -11.5F, 0.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(-1.0F, -9.0F, -5.5F, 0.08726646259971647F,
                        0.6981317007977318F, 0.0F));

        PartDefinition hairR01 = hair.addOrReplaceChild("HairR01",
                CubeListBuilder.create().mirror().texOffs(86, 101)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 4.0F),
                PartPose.offsetAndRotation(-7.0F, 3.0F, -5.5F, -0.13962634015954636F,
                        0.17453292519943295F, 0.08726646259971647F));

        hairR01.addOrReplaceChild("HairR02",
                CubeListBuilder.create().mirror().texOffs(86, 101)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 4.0F),
                PartPose.offsetAndRotation(0.2F, 7.0F, 0.0F, 0.17453292519943295F, 0.0F,
                        -0.05235987755982988F));

        PartDefinition hairL01 = hair.addOrReplaceChild("HairL01",
                CubeListBuilder.create().texOffs(86, 101)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 4.0F),
                PartPose.offsetAndRotation(7.0F, 3.0F, -5.5F, -0.13962634015954636F,
                        -0.17453292519943295F, -0.08726646259971647F));

        hairL01.addOrReplaceChild("HairL02",
                CubeListBuilder.create().texOffs(86, 101)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.17453292519943295F, 0.0F,
                        0.08726646259971647F));

        hair.addOrReplaceChild("HairU01",
                CubeListBuilder.create().texOffs(82, 0)
                        .addBox(-8.5F, 0.0F, 0.0F, 17.0F, 14.0F, 6.0F),
                PartPose.offset(0.0F, -6.0F, -6.5F));

        head.addOrReplaceChild("Ear01",
                CubeListBuilder.create().mirror().texOffs(20, 0)
                        .addBox(-1.5F, 0.0F, -6.0F, 3.0F, 6.0F, 6.0F),
                PartPose.offsetAndRotation(-3.8F, -14.5F, 5.7F, -0.7853981633974483F,
                        0.2617993877991494F, -0.13962634015954636F));

        PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(48, 34)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F),
                PartPose.offset(0.0F, -14.8F, -3.0F));

        PartDefinition hair01 = hairMain.addOrReplaceChild("Hair01",
                CubeListBuilder.create().texOffs(189, 0)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 14.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 9.5F, 1.0F, 0.20943951023931953F, 0.0F, 0.0F));

        hair01.addOrReplaceChild("Hair02",
                CubeListBuilder.create().texOffs(192, 25)
                        .addBox(-7.0F, 0.0F, -4.5F, 14.0F, 13.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 11.0F, 6.2F, -0.10471975511965977F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("BoobL",
                CubeListBuilder.create().mirror().texOffs(33, 101)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(2.8F, -8.5F, -3.5F, -0.6981317007977318F,
                        -0.10471975511965977F, -0.08726646259971647F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(52, 65)
                        .addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3141592653589793F, 0.0F, 0.0F));

        PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().mirror().texOffs(0, 63)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.2792526803190927F, 0.0F,
                        0.13962634015954636F));

        PartDefinition legLeft02 = legLeft01.addOrReplaceChild("LegLeft02",
                CubeListBuilder.create().mirror().texOffs(0, 83)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                PartPose.offset(0.0F, 14.0F, -3.0F));

        legLeft02.addOrReplaceChild("EquipSL01",
                CubeListBuilder.create().mirror().texOffs(24, 90)
                        .addBox(-3.0F, 0.0F, -3.5F, 6.0F, 4.0F, 7.0F),
                PartPose.offset(0.0F, 15.0F, 3.0F));

        PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().texOffs(0, 63)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.13962634015954636F, 0.0F,
                        -0.13962634015954636F));

        PartDefinition legRight02 = legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().texOffs(0, 83)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                PartPose.offset(0.0F, 14.0F, -3.0F));

        legRight02.addOrReplaceChild("EquipSR01",
                CubeListBuilder.create().texOffs(24, 90)
                        .addBox(-3.0F, 0.0F, -3.5F, 6.0F, 4.0F, 7.0F),
                PartPose.offset(0.0F, 15.0F, 3.0F));

        PartDefinition skirt01 = butt.addOrReplaceChild("Skirt01",
                CubeListBuilder.create().texOffs(0, 28)
                        .addBox(-8.5F, 0.0F, -6.3F, 17.0F, 6.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 2.3F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));

        skirt01.addOrReplaceChild("Cloth08",
                CubeListBuilder.create().texOffs(24, 80)
                        .addBox(-3.0F, 0.0F, 0.0F, 3.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(-0.5F, 0.5F, -7.0F, -0.15707963267948966F,
                        -0.10471975511965977F, 0.17453292519943295F));

        skirt01.addOrReplaceChild("Cloth09",
                CubeListBuilder.create().texOffs(34, 80)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 10.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 0.2F, -6.8F, -0.13962634015954636F, 0.0F, 0.0F));

        skirt01.addOrReplaceChild("EquipS01",
                CubeListBuilder.create().texOffs(58, 55)
                        .addBox(-5.5F, 0.0F, 0.0F, 11.0F, 9.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 0.3F, -7.3F, -0.2792526803190927F, 0.0F, 0.0F));

        skirt01.addOrReplaceChild("Skirt02",
                CubeListBuilder.create().texOffs(0, 44)
                        .addBox(-9.0F, 0.0F, -6.0F, 18.0F, 8.0F, 11.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, -0.6F, -0.08726646259971647F, 0.0F, 0.0F));

        skirt01.addOrReplaceChild("Cloth07",
                CubeListBuilder.create().texOffs(24, 80)
                        .addBox(0.0F, 0.0F, 0.0F, 3.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(0.5F, 0.5F, -7.0F, -0.17453292519943295F,
                        -0.13962634015954636F, -0.20943951023931953F));

        PartDefinition tail01 = butt.addOrReplaceChild("Tail01",
                CubeListBuilder.create().texOffs(63, 36)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 6.5F, 1.0F, -0.8726646259971648F, 0.0F, 0.0F));

        PartDefinition tail02 = tail01.addOrReplaceChild("Tail02",
                CubeListBuilder.create().texOffs(63, 36)
                        .addBox(-1.0F, -1.0F, -0.3F, 2.0F, 2.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 7.5F, 0.6981317007977318F, 0.0F, 0.0F));

        tail02.addOrReplaceChild("Tail03",
                CubeListBuilder.create().texOffs(63, 36)
                        .addBox(-1.0F, -1.0F, -0.4F, 2.0F, 2.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 7.5F, 0.5235987755982988F, 0.0F, 0.0F));

        PartDefinition equipABase = bodyMain.addOrReplaceChild("EquipABase",
                CubeListBuilder.create().texOffs(44, 35)
                        .addBox(-0.5F, -1.0F, -0.3F, 3.0F, 2.0F, 1.0F),
                PartPose.offsetAndRotation(-1.0F, -8.0F, 3.6F, 0.0F, 0.13962634015954636F, 0.0F));

        PartDefinition equipABelt01 = equipABase.addOrReplaceChild("EquipABelt01",
                CubeListBuilder.create().texOffs(0, 27)
                        .addBox(-12.0F, 0.0F, -0.5F, 12.0F, 0.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3490658503988659F, 0.13962634015954636F,
                        -0.5235987755982988F));

        PartDefinition equipABody01 = equipABelt01.addOrReplaceChild("EquipABody01",
                CubeListBuilder.create().texOffs(86, 55)
                        .addBox(-5.0F, -5.5F, -1.0F, 4.0F, 8.0F, 2.0F),
                PartPose.offsetAndRotation(-12.5F, -2.5F, 0.0F, 0.0F, 0.0F, -0.7853981633974483F));

        equipABody01.addOrReplaceChild("EquipABody02",
                CubeListBuilder.create().texOffs(128, 37)
                        .addBox(-0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F),
                PartPose.offset(-3.5F, -11.4F, 0.0F));

        equipABody01.addOrReplaceChild("EquipABody03",
                CubeListBuilder.create().texOffs(128, 34)
                        .addBox(-3.5F, -0.5F, -0.5F, 7.0F, 1.0F, 1.0F),
                PartPose.offset(-3.5F, -6.5F, 0.0F));

        PartDefinition equipABody04 = equipABody01.addOrReplaceChild("EquipABody04",
                CubeListBuilder.create().texOffs(128, 28)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F),
                PartPose.offset(-8.0F, 0.0F, 0.0F));

        PartDefinition equipAArr01a = equipABody04.addOrReplaceChild("EquipAArr01a",
                CubeListBuilder.create().texOffs(4, 47)
                        .addBox(0.0F, -4.0F, 0.0F, 1.0F, 7.0F, 1.0F),
                PartPose.offsetAndRotation(-0.5F, 0.7F, 0.0F, 0.0F, 0.0F, 0.05235987755982988F));

        equipAArr01a.addOrReplaceChild("EquipAArr01b",
                CubeListBuilder.create().texOffs(0, 48)
                        .addBox(-0.5F, -2.7F, 0.5F, 2.0F, 4.0F, 0.0F),
                PartPose.offset(0.0F, -2.0F, 0.0F));

        PartDefinition equipAArr02a = equipABody04.addOrReplaceChild("EquipAArr02a",
                CubeListBuilder.create().texOffs(4, 47)
                        .addBox(0.0F, -4.0F, 0.0F, 1.0F, 7.0F, 1.0F),
                PartPose.offsetAndRotation(-1.5F, 0.3F, -1.1F, 0.05235987755982988F,
                        -0.31869712141416456F, -0.05235987755982988F));

        equipAArr02a.addOrReplaceChild("EquipAArr02b",
                CubeListBuilder.create().texOffs(0, 48)
                        .addBox(-0.5F, -2.7F, 0.5F, 2.0F, 4.0F, 0.0F),
                PartPose.offset(0.0F, -2.0F, 0.0F));

        PartDefinition equipABody05 = equipABody04.addOrReplaceChild("EquipABody05",
                CubeListBuilder.create().texOffs(128, 13)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F),
                PartPose.offset(0.0F, 3.0F, 0.0F));

        PartDefinition equipABody05b = equipABody05.addOrReplaceChild("EquipABody05b",
                CubeListBuilder.create().texOffs(128, 13)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F),
                PartPose.offset(0.0F, 10.0F, 0.0F));

        PartDefinition equipABody05c = equipABody05b.addOrReplaceChild("EquipABody05c",
                CubeListBuilder.create().texOffs(128, 13)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F),
                PartPose.offset(0.0F, 10.0F, 0.0F));

        equipABody05c.addOrReplaceChild("EquipABelt02",
                CubeListBuilder.create().texOffs(0, 27)
                        .addBox(0.0F, 0.0F, -0.5F, 17.0F, 0.0F, 1.0F),
                PartPose.offsetAndRotation(3.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.7740535232594852F));

        PartDefinition equipAArr03a = equipABody04.addOrReplaceChild("EquipAArr03a",
                CubeListBuilder.create().texOffs(4, 47)
                        .addBox(0.0F, -4.0F, 0.0F, 1.0F, 7.0F, 1.0F),
                PartPose.offsetAndRotation(-1.6F, 0.0F, 0.4F, -0.03490658503988659F,
                        -0.2617993877991494F, 0.0F));

        equipAArr03a.addOrReplaceChild("EquipAArr03b",
                CubeListBuilder.create().texOffs(0, 48)
                        .addBox(-0.5F, -2.7F, 0.5F, 2.0F, 4.0F, 0.0F),
                PartPose.offset(0.0F, -2.0F, 0.0F));

        PartDefinition cloth02 = bodyMain.addOrReplaceChild("Cloth02",
                CubeListBuilder.create().mirror().texOffs(44, 19)
                        .addBox(0.0F, -3.5F, -4.6F, 1.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(5.8F, -7.9F, 0.0F, 0.08726646259971647F,
                        -0.13962634015954636F, -0.13962634015954636F));

        cloth02.addOrReplaceChild("Cloth03",
                CubeListBuilder.create().texOffs(0, 64)
                        .addBox(0.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 0.5F, -4.6F, 0.13962634015954636F,
                        -0.3141592653589793F, 0.13962634015954636F));

        cloth02.addOrReplaceChild("Cloth04",
                CubeListBuilder.create().texOffs(0, 64)
                        .addBox(0.0F, 0.0F, -1.0F, 1.0F, 4.0F, 1.0F),
                PartPose.offsetAndRotation(-0.1F, 0.6F, -4.5F, -0.13962634015954636F,
                        -0.3490658503988659F, -0.20943951023931953F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().texOffs(0, 8)
                        .addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(-7.8F, -8.7F, -0.7F, 0.0F, 0.0F, 0.3141592653589793F));

        PartDefinition equipD01 = armRight01.addOrReplaceChild("EquipD01",
                CubeListBuilder.create().texOffs(150, 13)
                        .addBox(-3.0F, 0.0F, -3.5F, 8.0F, 1.0F, 7.0F),
                PartPose.offsetAndRotation(0.3F, 2.0F, 0.0F, 0.0F, 3.141592653589793F, 0.0F));

        PartDefinition equipD02 = equipD01.addOrReplaceChild("EquipD02",
                CubeListBuilder.create().texOffs(58, 55)
                        .addBox(-5.5F, 0.0F, 0.0F, 11.0F, 9.0F, 1.0F),
                PartPose.offsetAndRotation(5.6F, 3.0F, 0.0F, -0.03490658503988659F, 1.4660765716752369F,
                        3.141592653589793F));

        PartDefinition equipD03 = equipD02.addOrReplaceChild("EquipD03",
                CubeListBuilder.create().texOffs(153, 21)
                        .addBox(-5.5F, -26.0F, 0.0F, 11.0F, 26.0F, 1.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        equipD03.addOrReplaceChild("EquipD04",
                CubeListBuilder.create().texOffs(128, 90)
                        .addBox(-4.5F, 0.0F, 0.0F, 9.0F, 11.0F, 1.0F),
                PartPose.offset(0.0F, -37.0F, 0.0F));

        PartDefinition clothHL01_1 = armRight01.addOrReplaceChild("ClothHL01_1",
                CubeListBuilder.create().texOffs(43, 1)
                        .addBox(-3.5F, 0.0F, -3.0F, 6.0F, 5.0F, 6.0F),
                PartPose.offset(0.0F, -1.5F, 0.0F));

        PartDefinition clothHL02_1 = clothHL01_1.addOrReplaceChild("ClothHL02_1",
                CubeListBuilder.create().texOffs(42, 1)
                        .addBox(-4.0F, 0.0F, -3.0F, 7.0F, 5.0F, 6.0F),
                PartPose.offset(0.0F, 4.5F, 0.0F));

        clothHL02_1.addOrReplaceChild("ClothHL03_1",
                CubeListBuilder.create().texOffs(40, 0)
                        .addBox(-3.5F, 0.0F, -3.5F, 8.0F, 5.0F, 7.0F),
                PartPose.offset(-1.0F, 4.0F, 0.0F));

        PartDefinition armRight02 = armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().texOffs(0, 8)
                        .addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
                PartPose.offset(-3.0F, 11.0F, 2.5F));

        armRight02.addOrReplaceChild("EquipGlove",
                CubeListBuilder.create().texOffs(128, 103)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F),
                PartPose.offset(2.5F, 6.3F, -2.5F));

        bodyMain.addOrReplaceChild("Cloth01",
                CubeListBuilder.create().texOffs(98, 31)
                        .addBox(-4.0F, 0.0F, -4.0F, 8.0F, 3.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, -12.1F, -0.6F, 0.17453292519943295F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("EquipB01",
                CubeListBuilder.create().texOffs(62, 22)
                        .addBox(-7.0F, -6.0F, -6.0F, 14.0F, 6.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, -4.2F, 0.7F, 0.6981317007977318F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("ClothBody01",
                CubeListBuilder.create().texOffs(0, 113)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 5.0F),
                PartPose.offsetAndRotation(6.0F, -3.8F, -2.3F, 0.2617993877991494F, 0.0F,
                        -0.2617993877991494F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().mirror().texOffs(0, 8)
                        .addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(7.8F, -8.7F, -0.7F, 0.20943951023931953F, 0.0F,
                        -0.20943951023931953F));

        PartDefinition clothHL01 = armLeft01.addOrReplaceChild("ClothHL01",
                CubeListBuilder.create().texOffs(43, 1)
                        .addBox(-2.5F, 0.0F, -3.0F, 6.0F, 5.0F, 6.0F),
                PartPose.offset(0.0F, -1.5F, 0.0F));

        PartDefinition clothHL02 = clothHL01.addOrReplaceChild("ClothHL02",
                CubeListBuilder.create().texOffs(42, 1)
                        .addBox(-3.0F, 0.0F, -3.0F, 7.0F, 5.0F, 6.0F),
                PartPose.offset(0.0F, 4.5F, 0.0F));

        clothHL02.addOrReplaceChild("ClothHL03",
                CubeListBuilder.create().texOffs(40, 0)
                        .addBox(-2.5F, 0.0F, -3.5F, 8.0F, 5.0F, 7.0F),
                PartPose.offset(-1.0F, 4.0F, 0.0F));

        PartDefinition armLeft02 = armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().mirror().texOffs(0, 8)
                        .addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
                PartPose.offset(3.0F, 11.0F, 2.5F));

        PartDefinition equipE01 = armLeft02.addOrReplaceChild("EquipE01",
                CubeListBuilder.create().texOffs(128, 37)
                        .addBox(-0.5F, -0.5F, -20.0F, 1.0F, 1.0F, 20.0F),
                PartPose.offsetAndRotation(-2.8F, 10.5F, -3.0F, 0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition equipE02 = equipE01.addOrReplaceChild("EquipE02",
                CubeListBuilder.create().texOffs(128, 74)
                        .addBox(-0.5F, -0.5F, -15.0F, 1.0F, 1.0F, 15.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -19.7F, -0.4886921905584123F, 0.0F, 0.0F));

        equipE02.addOrReplaceChild("EquipE03",
                CubeListBuilder.create().texOffs(134, 80)
                        .addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -14.7F, 0.3141592653589793F, 0.0F, 0.0F));

        PartDefinition equipE04 = equipE01.addOrReplaceChild("EquipE04",
                CubeListBuilder.create().texOffs(133, 58)
                        .addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 15.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -0.2F, -0.13962634015954636F, 0.0F, 0.0F));

        PartDefinition equipE05 = equipE04.addOrReplaceChild("EquipE05",
                CubeListBuilder.create().texOffs(131, 77)
                        .addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 14.7F, 0.45378560551852565F, 0.0F, 0.0F));

        equipE05.addOrReplaceChild("EquipE06",
                CubeListBuilder.create().texOffs(135, 81)
                        .addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 11.7F, -0.2792526803190927F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("Cloth06",
                CubeListBuilder.create().texOffs(104, 21)
                        .addBox(0.0F, 0.0F, 0.0F, 12.0F, 7.0F, 0.0F),
                PartPose.offsetAndRotation(-6.0F, -11.6F, 3.2F, 0.06981317007977318F, 0.0F, 0.0F));

        PartDefinition equipC01 = bodyMain.addOrReplaceChild("EquipC01",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-9.0F, 0.0F, -4.0F, 18.0F, 1.0F, 12.0F),
                PartPose.offsetAndRotation(-1.2F, 6.4F, -0.8F, 0.0F, 0.08726646259971647F,
                        -0.18203784098300857F));

        equipC01.addOrReplaceChild("EquipC02",
                CubeListBuilder.create().texOffs(64, 7)
                        .addBox(-2.5F, 0.0F, -3.0F, 3.0F, 9.0F, 6.0F),
                PartPose.offsetAndRotation(-8.0F, -0.5F, 1.5F, 0.17453292519943295F, 0.0F,
                        0.3490658503988659F));

        bodyMain.addOrReplaceChild("BoobR",
                CubeListBuilder.create().texOffs(33, 101)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(-2.8F, -8.5F, -3.5F, -0.6981317007977318F,
                        0.10471975511965977F, 0.08726646259971647F));

        bodyMain.addOrReplaceChild("Cloth05",
                CubeListBuilder.create().texOffs(44, 19)
                        .addBox(-1.0F, -3.5F, -4.6F, 1.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(-5.8F, -7.9F, 0.0F, 0.08726646259971647F,
                        0.13962634015954636F, 0.13962634015954636F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -15.0F, 0.0F));

        PartDefinition glowHead = glowBodyMain.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -11.8F, -1.0F));
        addDefaultFaceParts(glowHead);

        return LayerDefinition.create(meshdefinition, 256, 128);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                          float headPitch) {
        IShipEmotion ent = (IShipEmotion) entity;
        // set scale per scaleLevel
        switch (ent.getScaleLevel()) {
            case 3:
                this.scale = 1.84F;
                this.offsetY = -0.63F;
                break;
            case 2:
                this.scale = 1.38F;
                this.offsetY = -0.37F;
                break;
            case 1:
                this.scale = 0.92F;
                this.offsetY = 0.16F;
                break;
            default:
                this.scale = 0.46F;
                this.offsetY = 1.81F;
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

        boolean flag = !EmotionHelper.checkModelState(0, state);
        this.EquipE01.visible = !flag; // bow
        this.EquipGlove.visible = !flag; // glove

        flag = !EmotionHelper.checkModelState(1, state);
        this.EquipABase.visible = !flag; // quiver

        flag = !EmotionHelper.checkModelState(2, state);
        this.EquipD01.visible = !flag; // deck

        flag = !EmotionHelper.checkModelState(3, state);
        this.EquipC01.visible = !flag; // water bag

        flag = !EmotionHelper.checkModelState(4, state);
        this.EquipB01.visible = !flag; // armor

        flag = !EmotionHelper.checkModelState(5, state);
        this.EquipS01.visible = !flag; // skirt

        flag = !EmotionHelper.checkModelState(6, state);
        this.Ear01.visible = !flag; // ear+tail
        this.Ear02.visible = !flag;
        this.Tail01.visible = !flag;

        flag = !EmotionHelper.checkModelState(7, state);
        this.EquipSL01.visible = !flag; // shoes
        this.EquipSR01.visible = !flag;
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
        // [PORT] 1.10.2 -> 1.20.1: preserve legacy dead-pose grounding offset.
        this.offsetY += 0.53F + 0.25F * ent.getScaleLevel();

        this.setFaceHungry(ent);

        if (((IShipFloating) ent).getShipDepth() > 0) {
            this.EquipSL01.visible = true;
            this.EquipSR01.visible = true;
        } else {
            this.EquipSL01.visible = false;
            this.EquipSR01.visible = false;
        }

        // Body
        this.Skirt01.xRot = -0.2F;
        this.Skirt02.xRot = -0.3F;
        // arm
        // this.ArmRight02.offsetX = 0F;

        int state = ent.getStateEmotion(ID.S.State);

        if (EmotionHelper.checkModelState(3, state)) {
            this.ArmRight01.zRot += 0.15F;
        }

        if (EmotionHelper.checkModelState(6, state)) {
            this.ArmLeft01.zRot -= 0.15F;

            // tail
            this.Tail01.xRot = -1.85F;
            this.Tail02.xRot = -0.6F;
            this.Tail03.xRot = -0.6F;
        }

        // leg
        this.LegLeft02.yRot = 0F;
        // this.LegLeft02.offsetX = 0F;
        // this.LegLeft02.offsetY = 0F;
        this.LegRight02.yRot = 0F;
        // this.LegRight02.offsetX = 0F;
        // this.LegRight02.offsetY = 0F;

        // equip
        this.EquipE01.xRot = 0.05F;
        this.EquipE01.yRot = -0.2F;
        this.EquipE01.zRot = 0F;
        // this.EquipE01.offsetX = 0F;
        this.EquipE02.xRot = -0.4887F;
        this.EquipE05.xRot = 0.4538F;
        this.EquipD02.xRot = 0.25F;
        this.EquipD02.yRot = 1.6755F;
        this.EquipD02.zRot = 3.1416F;
        // this.EquipD02.offsetY = 0F;
        this.EquipS01.xRot = -0.95F;

        // 頭部
        this.Head.xRot = -0.2618F;
        this.Head.yRot = 0F;
        this.Head.zRot = 0F;
        // 胸部
        this.BoobL.xRot = -1.0F;
        this.BoobR.xRot = -1.0F;
        // Body
        this.Ahoke.yRot = -1.0F;
        this.BodyMain.xRot = 1.2217F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 1.2217F;
        this.Butt.xRot = -0.05F;
        // hair
        this.Hair01.xRot = 0.2F;
        this.Hair01.zRot = -0.36F;
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
        // arm
        this.ArmLeft01.xRot = -0.35F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = -3F;
        this.ArmLeft02.xRot = 0F;
        this.ArmRight01.xRot = -0.35F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = -0.35F;
        this.ArmRight02.xRot = 0F;
        this.ArmRight02.zRot = -0.8727F;
        // leg
        this.LegLeft01.xRot = -0.14F;
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.09F;
        this.LegLeft02.xRot = 0F;
        this.LegLeft02.zRot = 0F;
        // this.LegLeft02.offsetZ = 0F;
        this.LegRight01.xRot = -1.2217F;
        this.LegRight01.yRot = -0.5236F;
        this.LegRight01.zRot = 0F;
        this.LegRight02.xRot = 1.0472F;
        this.LegRight02.zRot = 0F;
        // this.LegRight02.offsetZ = 0F;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float angleX = Mth.cos(f2 * 0.08F + f * 0.25F);
        float angleX1 = Mth.cos(f2 * 0.1F + 0.3F + f * 0.5F);
        float angleX2 = Mth.cos(f2 * 0.1F + 0.6F + f * 0.5F);
        float angleX3 = Mth.cos(f2 * 0.1F + 0.9F + f * 0.5F);
        float angleAdd1 = Mth.cos(f * 0.7F) * f1;
        float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
        float addk1;
        float addk2;
        float headX;
        float headZ;

        // 水上漂浮
        if (ent.getShipDepth(0) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        // leg move
        addk1 = angleAdd1 * 0.5F - 0.2793F; // LegLeft01
        addk2 = angleAdd2 * 0.5F - 0.1396F; // LegRight01

        if (((IShipFloating) ent).getShipDepth() > 0) {
            this.EquipSL01.visible = true;
            this.EquipSR01.visible = true;
        }

        // head
        this.Head.xRot = f4 * 0.014F + 0.1047F;
        this.Head.yRot = f3 * 0.01F;
        // boob
        this.BoobL.xRot = angleX * 0.06F - 0.8F;
        this.BoobR.xRot = angleX * 0.06F - 0.8F;
        // body
        this.Ahoke.yRot = angleX * 0.25F + 0.45F;
        this.BodyMain.xRot = -0.1047F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        this.Butt.xRot = 0.3142F;
        this.Skirt01.xRot = -0.14F;
        this.Skirt02.xRot = -0.0873F;
        // cloth
        // NOTE 1.20.1: offset not supported in new model API: this.ClothHL02_1.offsetY
        // = 0F;
        // NOTE 1.20.1: offset not supported in new model API: this.ClothHL03_1.offsetY
        // = 0F;
        // hair
        this.Hair01.xRot = angleX * 0.04F + 0.23F;
        this.Hair01.zRot = 0F;
        this.Hair02.xRot = -angleX1 * 0.07F - 0.1F;
        this.Hair02.zRot = 0F;
        this.HairL01.xRot = -0.16F;
        this.HairL02.xRot = 0.1745F;
        this.HairR01.xRot = -0.14F;
        this.HairR02.xRot = 0.174F;
        this.HairL01.zRot = -0.0873F;
        this.HairL02.zRot = 0.087F;
        this.HairR01.zRot = 0.0873F;
        this.HairR02.zRot = -0.053F;
        // arm
        this.ArmLeft01.xRot = angleAdd2 * 0.25F + 0.21F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = angleX * 0.03F - 0.21F;
        this.ArmLeft02.xRot = 0F;
        this.ArmRight01.xRot = angleAdd1 * 0.25F + 0.05F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = -angleX * 0.03F + 0.21F;
        this.ArmRight02.zRot = 0F;
        // this.ArmRight02.offsetX = 0F;

        int state = ent.getStateEmotion(ID.S.State);
        boolean fbag = EmotionHelper.checkModelState(3, state);
        boolean ftail = EmotionHelper.checkModelState(6, state);

        if (fbag) {
            this.ArmRight01.zRot += 0.15F;
        }

        if (ftail) {
            // tail
            this.Tail01.xRot = angleX1 * 0.5F - 0.7F;
            this.Tail02.xRot = -angleX2 * 0.5F;
            this.Tail03.xRot = -angleX3 * 0.5F;
        }

        // leg
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.1396F;
        this.LegLeft02.xRot = 0F;
        this.LegLeft02.yRot = 0F;
        this.LegLeft02.zRot = 0F;
        // this.LegLeft02.offsetX = 0F;
        // this.LegLeft02.offsetY = 0F;
        // this.LegLeft02.offsetZ = 0F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.1396F;
        this.LegRight02.xRot = 0F;
        this.LegRight02.yRot = 0F;
        this.LegRight02.zRot = 0F;
        // this.LegRight02.offsetX = 0F;
        // this.LegRight02.offsetY = 0F;
        // this.LegRight02.offsetZ = 0F;

        // equip
        this.EquipE01.xRot = 0.05F;
        this.EquipE01.yRot = 0F;
        this.EquipE01.zRot = 0F;
        // this.EquipE01.offsetX = 0F;
        this.EquipE02.xRot = -0.4887F;
        this.EquipE05.xRot = 0.4538F;
        this.EquipD01.xRot = 0F;
        this.EquipD02.xRot = -0.05F;
        this.EquipD02.yRot = 1.6755F;
        this.EquipD02.zRot = 3.1416F;
        // this.EquipD02.offsetY = 0F;
        this.EquipS01.xRot = -0.28F;

        // ear
        float modf2 = f2 % 128F;
        if (modf2 < 6F) {
            // total 3 ticks, loop twice in 6 ticks
            if (modf2 >= 3F)
                modf2 -= 3F;
            float anglef2 = Mth.sin(modf2 * 1.0472F) * 0.25F;
            this.Ear01.zRot = -anglef2 - 0.14F;
            this.Ear02.zRot = anglef2 + 0.14F;
        } else {
            this.Ear01.zRot = -0.14F;
            this.Ear02.zRot = 0.14F;
        }

        if (ent.getIsSprinting() || f1 > 0.1F) { // 奔跑動作
            // hair
            this.Hair01.xRot = angleAdd1 * 0.1F + f1 * 0.4F;
            this.Hair02.xRot += 0.5F;
            // arm
            this.ArmLeft01.zRot += f1 * -0.2F;
            this.ArmRight01.zRot += f1 * 0.2F;
        }

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        if (ent.getIsSneaking()) { // 潛行, 蹲下動作
            // [PORT] 1.10.2 -> 1.20.1: GlStateManager.translate(0, 0.1, 0)
            this.offsetY += 0.1F;

            // Body
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.1F;
            this.Head.xRot -= 1.0472F;
            this.BodyMain.xRot = 1.0472F;
            this.Butt.xRot = -0.8378F;
            // arm
            this.ArmLeft01.xRot = -0.7F;
            this.ArmLeft01.zRot = 0.2618F;
            this.ArmRight01.xRot = -0.7F;
            this.ArmRight01.zRot = -0.2618F;
            // equip
            this.EquipD02.xRot = 0.15F;
            this.EquipE01.yRot = 1.3F;
            // tail
            this.Tail01.xRot += 1.3F;
        } // end if sneaking

        if (ent.getIsSitting() || ent.getIsRiding()) { // 騎乘動作
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                setFace(1);
                // [PORT] 1.10.2 -> 1.20.1: GlStateManager.translate(0, 0.43, 0)
                this.offsetY += 0.43F;

                // head
                int nodf2 = (int) f2 % 60;
                this.Head.xRot = 0.4F;
                if (nodf2 < 30) {
                    if (nodf2 < 6) {
                        this.Head.xRot = nodf2 * 0.02F + 0.4F;
                    } else if (nodf2 < 11) {
                        this.Head.xRot = (nodf2 - 5) * 0.03F + 0.5F;
                    } else if (nodf2 < 14) {
                        this.Head.xRot = (nodf2 - 10) * -0.09F + 0.65F;
                    }
                }
                this.Head.yRot = 0F;
                this.Head.zRot = 0F;
                // body
                this.Butt.xRot = -0.2F;
                this.Skirt01.xRot = -0.26F;
                this.Skirt02.xRot = -0.45F;
                // arm
                this.ArmLeft01.xRot = 0.4F;
                this.ArmLeft01.zRot = -0.2618F;
                this.ArmRight01.xRot = 0.4F;
                this.ArmRight01.zRot = 0.2618F;
                // leg
                addk1 = -0.9F;
                addk2 = -0.9F;
                this.LegLeft01.zRot = -0.14F;
                this.LegLeft02.xRot = 1.2217F;
                this.LegLeft02.yRot = 1.2217F;
                this.LegLeft02.zRot = -1.0472F;
                // this.LegLeft02.offsetX = 0.17F;
                // this.LegLeft02.offsetY = -0.03F;
                // this.LegLeft02.offsetZ = 0.2F;
                this.LegRight01.zRot = 0.14F;
                this.LegRight02.xRot = 1.2217F;
                this.LegRight02.yRot = -1.2217F;
                this.LegRight02.zRot = 1.0472F;
                // this.LegRight02.offsetX = -0.17F;
                // this.LegRight02.offsetY = -0.03F;
                // this.LegRight02.offsetZ = 0.2F;
                // tail
                this.Tail01.xRot += 1.7F;
                this.Tail02.xRot += 0.15F;
                this.Tail03.xRot += 0.15F;
                this.Tail01.xRot *= 0.2F;
                this.Tail02.xRot *= 0.2F;
                this.Tail03.xRot *= 0.2F;
                // equip
                this.EquipE01.yRot = 1.7F;
                this.EquipE01.zRot = 0.15F;
                this.EquipD02.xRot = 0.2F;
                // this.EquipD02.offsetY = -0.5F;
            } else {
                // [PORT] 1.10.2 -> 1.20.1: GlStateManager.translate(0, 0.36, 0)
                this.offsetY += 0.36F;

                // Body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.36F;
                this.Head.xRot += 0.1047F;
                this.BodyMain.xRot = -0.1396F;
                this.Butt.xRot = 0.1396F;
                // arm
                this.ArmLeft01.xRot = -0.4F;
                this.ArmLeft01.zRot = 0.2618F;
                this.ArmRight01.xRot = -0.4F;
                this.ArmRight01.zRot = -0.2618F;
                // leg
                addk1 = -1.0472F;
                addk2 = -1.0472F;
                this.LegLeft01.yRot = 0.0524F;
                this.LegLeft01.zRot = 0F;
                // this.LegLeft02.offsetZ = 0.38F;
                this.LegLeft02.xRot = 2.5831F;
                this.LegLeft02.zRot = 0.0175F;
                this.LegRight01.yRot = -0.0524F;
                this.LegRight01.zRot = 0F;
                // this.LegRight02.offsetZ = 0.38F;
                this.LegRight02.xRot = 2.5831F;
                this.LegRight02.zRot = -0.0175F;
                // tail
                this.Tail01.xRot += 1F;
                this.Tail02.xRot += 0.15F;
                this.Tail03.xRot += 0.15F;
                // equip
                this.EquipE01.yRot = 1.7F;
                this.EquipE01.zRot = -0.2F;
                this.EquipD02.xRot = 0.2F;
                // this.EquipD02.offsetY = -0.5F;
            }
        } // end if sitting

        // 攻擊動作
        if (ent.getAttackTick() > 20) {
            // set start time
            if (ent.getAttackTick() >= 49)
                ent.setAttackTick2(0);
            int tick = ent.getAttackTick2();
            float parTick = f2 - (int) f2 + tick;

            // head
            this.Head.xRot = 0F;
            this.Head.yRot = -1.31F;
            // body
            this.BodyMain.xRot = -0.05F;
            this.BodyMain.yRot = 1.4F;
            // cloth
            // NOTE 1.20.1: offset not supported in new model API: this.ClothHL02_1.offsetY
            // = -0.17F;
            // NOTE 1.20.1: offset not supported in new model API: this.ClothHL03_1.offsetY
            // = -0.2F;
            // arm
            this.ArmLeft01.xRot = -1.5708F;
            this.ArmLeft01.yRot = -1.35F;
            this.ArmLeft01.zRot = 0F;
            this.ArmRight01.xRot = 0F;
            this.ArmRight01.yRot = 2.1817F;
            this.ArmRight01.zRot = 1.5708F;
            this.ArmRight02.zRot = -2.44F + 0.15F * parTick; // -2.44~-1.57
            if (this.ArmRight02.zRot > -1.57F)
                this.ArmRight02.zRot = -1.57F;
            // this.ArmRight02.offsetX = 0.31F;
            // leg
            addk1 = -0.35F;
            addk2 = -0.23F;
            this.LegLeft01.zRot = -0.14F;
            this.LegRight01.zRot = 0.14F;
            // equip
            this.EquipE01.visible = true;
            this.EquipD01.xRot = 1.3F;
            this.EquipD02.xRot = -1.15F;
            this.EquipD02.yRot = -2.0F;
            this.EquipD02.zRot = 1.7453F;
            this.EquipE01.xRot = 0.2618F;
            this.EquipE01.zRot = -0.23F;
            // this.EquipE01.offsetX = -0.15F;
            this.EquipE02.xRot = -0.7F + 0.1F * parTick; // -0.7~-0.49
            if (this.EquipE02.xRot > -0.49F)
                this.EquipE02.xRot = -0.49F;
            this.EquipE05.xRot = 0.7F - 0.1F * parTick; // 0.7~0.45
            if (this.EquipE05.xRot < 0.45F)
                this.EquipE05.xRot = 0.45F;
            if (tick > 5 && tick < 12) {
                this.EquipE01.xRot -= 0.36F * Mth.sin(parTick * 0.2244F);
                this.EquipE01.zRot -= 5F * Mth.sin(parTick * 0.2244F);
            }
            if (tick >= 12) {
                this.EquipE01.xRot = -0.1F;
                this.EquipE01.zRot = -3.3F;
            }

            // save tick
            ent.setAttackTick2(++tick);
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
        headX = this.Head.xRot * -0.5F;
        headZ = this.Head.zRot * -0.5F;
        this.Hair01.xRot += headX;
        this.Hair02.xRot += headX * 0.1F;
        this.Hair01.zRot += headZ;
        this.Hair02.zRot += headZ * 0.7F;
        this.HairL01.zRot += headZ;
        this.HairL02.zRot += headZ * 0.8F;
        this.HairR01.zRot += headZ;
        this.HairR02.zRot += headZ * 0.8F;
        this.HairL01.xRot += angleX * 0.04F + headX;
        this.HairL02.xRot += angleX1 * 0.07F + headX * 0.8F;
        this.HairR01.xRot += angleX * 0.04F + headX;
        this.HairR02.xRot += angleX1 * 0.07F + headX * 0.8F;

        // leg motion
        this.LegLeft01.xRot = addk1;
        this.LegRight01.xRot = addk2;
    }
}
