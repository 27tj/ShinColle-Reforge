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

public class ModelIsolatedHime extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "isolated_hime"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Neck;
    private final ModelPart Butt;
    private final ModelPart ArmRight01;
    private final ModelPart ArmLeft01;
    private final ModelPart Cloth02a;
    private final ModelPart Head;
    private final ModelPart Cloth01a;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart Hair01;
    private final ModelPart HatBase;
    private final ModelPart HairU01;
    private final ModelPart Ahoke;
    private final ModelPart Hair02;
    private final ModelPart Hair03;
    private final ModelPart Hat01;
    private final ModelPart Hat03;
    private final ModelPart Hat05;
    private final ModelPart HeadH1;
    private final ModelPart HeadH2;
    private final ModelPart HeadH3;
    private final ModelPart HeadH4;
    private final ModelPart HeadH5;
    private final ModelPart HeadH6;
    private final ModelPart Hat02a;
    private final ModelPart Hat02b;
    private final ModelPart Hat02c;
    private final ModelPart Hat02d;
    private final ModelPart Hat02e;
    private final ModelPart Hat02f;
    private final ModelPart Hat02g;
    private final ModelPart Hat02h;
    private final ModelPart Hat02i;
    private final ModelPart Hat02j;
    private final ModelPart Hat04a;
    private final ModelPart Hat04b;
    private final ModelPart Hat04c;
    private final ModelPart Hat04d;
    private final ModelPart Hat04e;
    private final ModelPart Hat04f;
    private final ModelPart Hat04g;
    private final ModelPart Hat04h;
    private final ModelPart Hat06a;
    private final ModelPart Hat02b_1;
    private final ModelPart Hat02d_1;
    private final ModelPart Hat02e_1;
    private final ModelPart Hat02f_1;
    private final ModelPart Hat02g_1;
    private final ModelPart Hat02h_1;
    private final ModelPart Hat02i_1;
    private final ModelPart Cloth01b;
    private final ModelPart Cloth01c;
    private final ModelPart Cloth01b2;
    private final ModelPart Cloth01c2;
    private final ModelPart Skirt01;
    private final ModelPart LegRight01;
    private final ModelPart LegLeft01;
    private final ModelPart Skirt02;
    private final ModelPart Skirt03;
    private final ModelPart LegRight02a;
    private final ModelPart LegArmor02a;
    private final ModelPart LegRight02b;
    private final ModelPart LegArmor02b;
    private final ModelPart LegArmor02c;
    private final ModelPart LegLeft02a;
    private final ModelPart LegArmor01a;
    private final ModelPart LegLeft02b;
    private final ModelPart LegArmor01b;
    private final ModelPart LegArmor01c;
    private final ModelPart ArmRight02;
    private final ModelPart Cloth02c;
    private final ModelPart Cloth03a;
    private final ModelPart ArmLeft02;
    private final ModelPart Cloth02b;
    private final ModelPart Cloth03b;
    private final ModelPart EquipRdL01;
    private final ModelPart EquipRdL02;
    private final ModelPart EquipRdL03;
    private final ModelPart EquipRdL04;
    private final ModelPart EquipRdL05;
    private final ModelPart EquipRdL06;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowNeck;
    private final ModelPart GlowHead;
    private final ModelPart GlowHatBase;

    public ModelIsolatedHime(ModelPart root) {
        super();
        this.scale = 0.38F;
        this.offsetY = 2.59F;
        this.BodyMain = root.getChild("BodyMain");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.Neck = this.BodyMain.getChild("Neck");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.Butt = this.BodyMain.getChild("Butt");
        this.Cloth02a = this.BodyMain.getChild("Cloth02a");
        this.Cloth02b = this.ArmLeft01.getChild("Cloth02b");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.Head = this.Neck.getChild("Head");
        this.Cloth01a = this.Neck.getChild("Cloth01a");
        this.Cloth02c = this.ArmRight01.getChild("Cloth02c");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.LegLeft01 = this.Butt.getChild("LegLeft01");
        this.Skirt01 = this.Butt.getChild("Skirt01");
        this.LegRight01 = this.Butt.getChild("LegRight01");
        this.Cloth03b = this.ArmLeft02.getChild("Cloth03b");
        this.HairMain = this.Head.getChild("HairMain");
        this.Hair01 = this.Head.getChild("Hair01");
        this.Hair = this.Head.getChild("Hair");
        this.HatBase = this.Head.getChild("HatBase");
        this.Cloth01b2 = this.Cloth01a.getChild("Cloth01b2");
        this.Cloth01c = this.Cloth01a.getChild("Cloth01c");
        this.Cloth01b = this.Cloth01a.getChild("Cloth01b");
        this.Cloth01c2 = this.Cloth01a.getChild("Cloth01c2");
        this.Cloth03a = this.ArmRight02.getChild("Cloth03a");
        this.LegLeft02a = this.LegLeft01.getChild("LegLeft02a");
        this.LegArmor01a = this.LegLeft01.getChild("LegArmor01a");
        this.LegLeft02b = this.LegLeft01.getChild("LegLeft02b");
        this.Skirt02 = this.Skirt01.getChild("Skirt02");
        this.LegRight02b = this.LegRight01.getChild("LegRight02b");
        this.LegRight02a = this.LegRight01.getChild("LegRight02a");
        this.LegArmor02a = this.LegRight01.getChild("LegArmor02a");
        this.Hair02 = this.Hair01.getChild("Hair02");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.HairU01 = this.Hair.getChild("HairU01");
        this.Hat03 = this.HatBase.getChild("Hat03");
        this.Hat01 = this.HatBase.getChild("Hat01");
        this.Hat05 = this.HatBase.getChild("Hat05");
        this.LegArmor01b = this.LegArmor01a.getChild("LegArmor01b");
        this.Skirt03 = this.Skirt02.getChild("Skirt03");
        this.LegArmor02b = this.LegArmor02a.getChild("LegArmor02b");
        this.Hair03 = this.Hair02.getChild("Hair03");
        this.Hat04f = this.Hat03.getChild("Hat04f");
        this.Hat04g = this.Hat03.getChild("Hat04g");
        this.Hat04e = this.Hat03.getChild("Hat04e");
        this.Hat04d = this.Hat03.getChild("Hat04d");
        this.Hat04a = this.Hat03.getChild("Hat04a");
        this.Hat04h = this.Hat03.getChild("Hat04h");
        this.Hat04b = this.Hat03.getChild("Hat04b");
        this.Hat04c = this.Hat03.getChild("Hat04c");
        this.Hat02d = this.Hat01.getChild("Hat02d");
        this.Hat02a = this.Hat01.getChild("Hat02a");
        this.Hat02b = this.Hat01.getChild("Hat02b");
        this.Hat02g = this.Hat01.getChild("Hat02g");
        this.Hat02h = this.Hat01.getChild("Hat02h");
        this.Hat02e = this.Hat01.getChild("Hat02e");
        this.Hat02c = this.Hat01.getChild("Hat02c");
        this.Hat02i = this.Hat01.getChild("Hat02i");
        this.Hat02f = this.Hat01.getChild("Hat02f");
        this.Hat02j = this.Hat01.getChild("Hat02j");
        this.Hat02b_1 = this.Hat05.getChild("Hat02b_1");
        this.Hat02e_1 = this.Hat05.getChild("Hat02e_1");
        this.Hat06a = this.Hat05.getChild("Hat06a");
        this.Hat02g_1 = this.Hat05.getChild("Hat02g_1");
        this.Hat02i_1 = this.Hat05.getChild("Hat02i_1");
        this.Hat02h_1 = this.Hat05.getChild("Hat02h_1");
        this.Hat02f_1 = this.Hat05.getChild("Hat02f_1");
        this.Hat02d_1 = this.Hat05.getChild("Hat02d_1");
        this.LegArmor01c = this.LegArmor01b.getChild("LegArmor01c");
        this.LegArmor02c = this.LegArmor02b.getChild("LegArmor02c");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowNeck = this.GlowBodyMain.getChild("GlowNeck");
        this.GlowHead = this.GlowNeck.getChild("GlowHead");
        this.GlowHatBase = this.GlowHead.getChild("GlowHatBase");
        this.HeadH1 = this.GlowHatBase.getChild("HeadH1");
        this.HeadH2 = this.HeadH1.getChild("HeadH2");
        this.HeadH3 = this.HeadH2.getChild("HeadH3");
        this.HeadH4 = this.GlowHatBase.getChild("HeadH4");
        this.HeadH5 = this.HeadH4.getChild("HeadH5");
        this.HeadH6 = this.HeadH5.getChild("HeadH6");
        this.EquipRdL01 = this.GlowBodyMain.getChild("EquipRdL01");
        this.EquipRdL02 = this.EquipRdL01.getChild("EquipRdL02");
        this.EquipRdL03 = this.EquipRdL02.getChild("EquipRdL03");
        this.EquipRdL04 = this.EquipRdL03.getChild("EquipRdL04");
        this.EquipRdL05 = this.EquipRdL04.getChild("EquipRdL05");
        this.EquipRdL06 = this.EquipRdL05.getChild("EquipRdL06");
        this.loadFaceParts(this.GlowHead);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 105)
                        .addBox(-6.5F, -11.0F, -4.0F, 13.0F, 15.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().texOffs(24, 84)
                        .addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, -0.05235987755982988F, 0.0F, -0.2792526803190927F));

        armLeft01.addOrReplaceChild("Cloth02b",
                CubeListBuilder.create().texOffs(128, 85)
                        .addBox(-3.0F, 0.0F, -3.5F, 6.0F, 6.0F, 7.0F),
                PartPose.offsetAndRotation(0.9F, -1.5F, 0.0F, 0.0F, 0.0F, 0.05235987755982988F));

        PartDefinition armLeft02 = armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().texOffs(24, 63)
                        .addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
                PartPose.offset(3.0F, 11.0F, 2.5F));

        armLeft02.addOrReplaceChild("Cloth03b",
                CubeListBuilder.create().mirror().texOffs(128, 50)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 7.0F, 6.0F),
                PartPose.offset(-2.5F, 3.5F, -2.5F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(103, 35)
                        .addBox(-2.5F, -2.0F, -3.0F, 5.0F, 2.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offset(0.0F, -1.0F, -0.7F));

        head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(46, 104)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F),
                PartPose.offset(0.0F, -14.8F, -3.0F));

        PartDefinition hair01 = head.addOrReplaceChild("Hair01",
                CubeListBuilder.create().texOffs(50, 30)
                        .addBox(-7.5F, 0.0F, -4.0F, 15.0F, 17.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, -6.0F, 2.0F, 0.20943951023931953F, 0.0F, 0.0F));

        PartDefinition hair02 = hair01.addOrReplaceChild("Hair02",
                CubeListBuilder.create().texOffs(0, 38)
                        .addBox(-8.0F, 0.0F, -6.0F, 16.0F, 16.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 13.5F, 2.5F, 0.12217304763960307F, 0.0F, 0.0F));

        hair02.addOrReplaceChild("Hair03",
                CubeListBuilder.create().texOffs(0, 15)
                        .addBox(-7.5F, 0.0F, -5.5F, 15.0F, 15.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 12.5F, -0.1F, -0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(50, 77)
                        .addBox(-8.0F, -8.0F, -7.4F, 16.0F, 16.0F, 8.0F),
                PartPose.offset(0.0F, -7.5F, 0.1F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(106, 31)
                        .addBox(0.0F, -6.0F, -10.5F, 0.0F, 11.0F, 11.0F),
                PartPose.offsetAndRotation(-0.5F, -7.0F, -6.0F, 0.5235987755982988F, 0.6981317007977318F, 0.0F));

        hair.addOrReplaceChild("HairU01",
                CubeListBuilder.create().texOffs(52, 56)
                        .addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F),
                PartPose.offset(0.0F, -6.0F, -7.0F));

        PartDefinition hatBase = head.addOrReplaceChild("HatBase",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, -14.6F, -2.0F, -0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition hat03 = hatBase.addOrReplaceChild("Hat03",
                CubeListBuilder.create().texOffs(88, 23)
                        .addBox(-8.5F, 0.0F, -0.5F, 17.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(10.0F, 5.5F, 1.3F, 0.0F, -0.05235987755982988F, 1.5707963267948966F));

        hat03.addOrReplaceChild("Hat04f",
                CubeListBuilder.create().texOffs(30, 6)
                        .addBox(-2.0F, -3.0F, 0.0F, 4.0F, 2.0F, 7.0F),
                PartPose.offsetAndRotation(-4.3F, -1.0F, 2.5F, 0.0F, -0.03490658503988659F, 2.96705972839036F));

        hat03.addOrReplaceChild("Hat04g",
                CubeListBuilder.create().texOffs(30, 6)
                        .addBox(-2.0F, -3.0F, 0.0F, 4.0F, 2.0F, 7.0F),
                PartPose.offsetAndRotation(3.5F, -0.6F, 2.2F, -0.05235987755982988F, -0.03490658503988659F,
                        -3.07177948351002F));

        hat03.addOrReplaceChild("Hat04e",
                CubeListBuilder.create().texOffs(60, 2)
                        .addBox(-2.0F, -3.0F, 0.0F, 4.0F, 3.0F, 7.0F),
                PartPose.offsetAndRotation(-0.2F, 1.1F, 2.8F, 0.13962634015954636F, 0.0F, 0.03490658503988659F));

        hat03.addOrReplaceChild("Hat04d",
                CubeListBuilder.create().texOffs(42, 10)
                        .addBox(-2.0F, -3.0F, -10.0F, 4.0F, 2.0F, 10.0F),
                PartPose.offsetAndRotation(-4.9F, -1.5F, -0.2F, 0.017453292519943295F, 0.017453292519943295F,
                        2.792526803190927F));

        hat03.addOrReplaceChild("Hat04a",
                CubeListBuilder.create().texOffs(60, 15)
                        .addBox(-2.0F, -3.0F, -10.0F, 4.0F, 3.0F, 10.0F),
                PartPose.offsetAndRotation(-0.5F, 0.5F, -0.5F, -0.08726646259971647F, -0.03490658503988659F,
                        -0.06981317007977318F));

        hat03.addOrReplaceChild("Hat04h",
                CubeListBuilder.create().texOffs(60, 2)
                        .addBox(-2.0F, -3.0F, 0.0F, 4.0F, 3.0F, 7.0F),
                PartPose.offsetAndRotation(6.9F, 1.2F, 2.4F, 0.05235987755982988F, 0.06981317007977318F,
                        0.296705972839036F));

        hat03.addOrReplaceChild("Hat04b",
                CubeListBuilder.create().texOffs(42, 10)
                        .addBox(-2.0F, -3.0F, -10.0F, 4.0F, 2.0F, 10.0F),
                PartPose.offsetAndRotation(3.2F, -2.0F, -0.2F, -0.05235987755982988F, 0.08726646259971647F,
                        -3.07177948351002F));

        hat03.addOrReplaceChild("Hat04c",
                CubeListBuilder.create().texOffs(60, 15)
                        .addBox(-2.0F, -3.0F, -10.0F, 4.0F, 3.0F, 10.0F),
                PartPose.offsetAndRotation(6.4F, 1.0F, -0.1F, 0.06981317007977318F, -0.13962634015954636F,
                        0.2617993877991494F));

        PartDefinition hat01 = hatBase.addOrReplaceChild("Hat01",
                CubeListBuilder.create().texOffs(88, 23)
                        .addBox(-8.5F, 0.0F, -0.5F, 17.0F, 4.0F, 3.0F),
                PartPose.offset(0.0F, -3.6F, 1.0F));

        hat01.addOrReplaceChild("Hat02d",
                CubeListBuilder.create().texOffs(42, 10)
                        .addBox(-2.0F, -3.0F, -10.0F, 4.0F, 2.0F, 10.0F),
                PartPose.offsetAndRotation(-4.2F, -0.7F, -0.6F, -0.05235987755982988F, -0.017453292519943295F,
                        2.96705972839036F));

        hat01.addOrReplaceChild("Hat02a",
                CubeListBuilder.create().texOffs(60, 15)
                        .addBox(-2.0F, -3.0F, -10.0F, 4.0F, 3.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 1.5F, -0.7F, -0.06981317007977318F, 0.0F, 0.0F));

        hat01.addOrReplaceChild("Hat02b",
                CubeListBuilder.create().texOffs(42, 10)
                        .addBox(-2.0F, -3.0F, -10.0F, 4.0F, 2.0F, 10.0F),
                PartPose.offsetAndRotation(4.2F, -0.7F, -0.6F, -0.05235987755982988F, 0.017453292519943295F,
                        -2.96705972839036F));

        hat01.addOrReplaceChild("Hat02g",
                CubeListBuilder.create().texOffs(30, 6)
                        .addBox(-2.0F, -3.0F, 0.0F, 4.0F, 2.0F, 7.0F),
                PartPose.offsetAndRotation(-3.8F, -0.5F, 2.3F, 0.05235987755982988F, 0.05235987755982988F,
                        3.1066860685499065F));

        hat01.addOrReplaceChild("Hat02h",
                CubeListBuilder.create().texOffs(60, 2)
                        .addBox(-2.0F, -3.0F, 0.0F, 4.0F, 3.0F, 7.0F),
                PartPose.offsetAndRotation(-7.2F, 2.4F, 2.6F, 0.08726646259971647F, -0.05235987755982988F,
                        -0.5235987755982988F));

        hat01.addOrReplaceChild("Hat02e",
                CubeListBuilder.create().texOffs(60, 15)
                        .addBox(-2.0F, -3.0F, -10.0F, 4.0F, 3.0F, 10.0F),
                PartPose.offsetAndRotation(-7.6F, 2.0F, -0.6F, 0.05235987755982988F, 0.03490658503988659F,
                        -0.5759586531581287F));

        hat01.addOrReplaceChild("Hat02c",
                CubeListBuilder.create().texOffs(60, 15)
                        .addBox(-2.0F, -3.0F, -10.0F, 4.0F, 3.0F, 10.0F),
                PartPose.offsetAndRotation(7.6F, 2.0F, -0.6F, 0.05235987755982988F, -0.03490658503988659F,
                        0.5759586531581287F));

        hat01.addOrReplaceChild("Hat02i",
                CubeListBuilder.create().texOffs(30, 6)
                        .addBox(-2.0F, -3.0F, 0.0F, 4.0F, 2.0F, 7.0F),
                PartPose.offsetAndRotation(3.8F, -0.5F, 2.3F, 0.05235987755982988F, -0.05235987755982988F,
                        -3.1066860685499065F));

        hat01.addOrReplaceChild("Hat02f",
                CubeListBuilder.create().texOffs(60, 2)
                        .addBox(-2.0F, -3.0F, 0.0F, 4.0F, 3.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 1.7F, 2.6F, 0.08726646259971647F, 0.0F, 0.0F));

        hat01.addOrReplaceChild("Hat02j",
                CubeListBuilder.create().texOffs(60, 2)
                        .addBox(-2.0F, -3.0F, 0.0F, 4.0F, 3.0F, 7.0F),
                PartPose.offsetAndRotation(7.2F, 2.4F, 2.6F, 0.08726646259971647F, 0.05235987755982988F,
                        0.5235987755982988F));

        PartDefinition hat05 = hatBase.addOrReplaceChild("Hat05",
                CubeListBuilder.create().texOffs(88, 23)
                        .addBox(-8.5F, 0.0F, -0.5F, 17.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(-10.0F, 5.5F, 1.3F, 0.0F, 0.05235987755982988F, -1.5707963267948966F));

        hat05.addOrReplaceChild("Hat02b_1",
                CubeListBuilder.create().texOffs(42, 10)
                        .addBox(-2.0F, -3.0F, -10.0F, 4.0F, 2.0F, 10.0F),
                PartPose.offsetAndRotation(4.9F, -1.5F, -0.2F, 0.017453292519943295F, -0.017453292519943295F,
                        -2.792526803190927F));

        hat05.addOrReplaceChild("Hat02e_1",
                CubeListBuilder.create().texOffs(60, 15)
                        .addBox(-2.0F, -3.0F, -10.0F, 4.0F, 3.0F, 10.0F),
                PartPose.offsetAndRotation(-6.4F, 1.0F, -0.1F, -0.06981317007977318F, 0.13962634015954636F,
                        -0.2617993877991494F));

        hat05.addOrReplaceChild("Hat06a",
                CubeListBuilder.create().texOffs(60, 15)
                        .addBox(-2.0F, -3.0F, -10.0F, 4.0F, 3.0F, 10.0F),
                PartPose.offsetAndRotation(0.5F, 0.5F, -0.5F, -0.08726646259971647F, 0.03490658503988659F,
                        0.06981317007977318F));

        hat05.addOrReplaceChild("Hat02g_1",
                CubeListBuilder.create().texOffs(30, 6)
                        .addBox(-2.0F, -3.0F, 0.0F, 4.0F, 2.0F, 7.0F),
                PartPose.offsetAndRotation(-3.5F, -0.6F, 2.2F, -0.05235987755982988F, 0.03490658503988659F,
                        3.07177948351002F));

        hat05.addOrReplaceChild("Hat02i_1",
                CubeListBuilder.create().texOffs(30, 6)
                        .addBox(-2.0F, -3.0F, 0.0F, 4.0F, 2.0F, 7.0F),
                PartPose.offsetAndRotation(4.3F, -1.0F, 2.5F, 0.0F, 0.03490658503988659F, -2.96705972839036F));

        hat05.addOrReplaceChild("Hat02h_1",
                CubeListBuilder.create().texOffs(60, 2)
                        .addBox(-2.0F, -3.0F, 0.0F, 4.0F, 3.0F, 7.0F),
                PartPose.offsetAndRotation(-6.9F, 1.2F, 2.4F, 0.05235987755982988F, -0.06981317007977318F,
                        -0.296705972839036F));

        hat05.addOrReplaceChild("Hat02f_1",
                CubeListBuilder.create().texOffs(60, 2)
                        .addBox(-2.0F, -3.0F, 0.0F, 4.0F, 3.0F, 7.0F),
                PartPose.offsetAndRotation(0.2F, 1.1F, 2.8F, 0.13962634015954636F, 0.0F, 0.03490658503988659F));

        hat05.addOrReplaceChild("Hat02d_1",
                CubeListBuilder.create().texOffs(42, 10)
                        .addBox(-2.0F, -3.0F, -10.0F, 4.0F, 2.0F, 10.0F),
                PartPose.offsetAndRotation(-3.2F, -2.0F, -0.2F, -0.05235987755982988F, -0.08726646259971647F,
                        3.07177948351002F));

        PartDefinition cloth01a = neck.addOrReplaceChild("Cloth01a",
                CubeListBuilder.create().texOffs(51, 2)
                        .addBox(-1.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -7.9F, 0.7853981633974483F, 0.0F, 0.0F));

        cloth01a.addOrReplaceChild("Cloth01b2",
                CubeListBuilder.create().texOffs(51, 0)
                        .addBox(0.0F, -3.0F, -1.0F, 6.0F, 6.0F, 2.0F),
                PartPose.offsetAndRotation(0.5F, 0.3F, 0.3F, 0.08726646259971647F, 0.17453292519943295F,
                        -0.1488765851951163F));

        cloth01a.addOrReplaceChild("Cloth01c",
                CubeListBuilder.create().texOffs(0, 16)
                        .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F),
                PartPose.offsetAndRotation(-2.0F, 1.6F, -0.7F, -0.7853981633974483F, 0.13962634015954636F,
                        0.17453292519943295F));

        cloth01a.addOrReplaceChild("Cloth01b",
                CubeListBuilder.create().texOffs(51, 0)
                        .addBox(-6.0F, -3.0F, -1.0F, 6.0F, 6.0F, 2.0F),
                PartPose.offsetAndRotation(-0.5F, 0.3F, 0.3F, 0.08726646259971647F, -0.17453292519943295F,
                        0.13962634015954636F));

        cloth01a.addOrReplaceChild("Cloth01c2",
                CubeListBuilder.create().mirror().texOffs(0, 16)
                        .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F),
                PartPose.offsetAndRotation(2.0F, 1.6F, -0.7F, -0.7330382858376184F, -0.13962634015954636F,
                        -0.17453292519943295F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().mirror().texOffs(24, 84)
                        .addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, 0.2617993877991494F, 0.0F, 0.2792526803190927F));

        armRight01.addOrReplaceChild("Cloth02c",
                CubeListBuilder.create().mirror().texOffs(128, 85)
                        .addBox(-3.0F, 0.0F, -3.5F, 6.0F, 6.0F, 7.0F),
                PartPose.offsetAndRotation(-0.9F, -1.5F, 0.0F, 0.0F, 0.0F, -0.05235987755982988F));

        PartDefinition armRight02 = armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().mirror().texOffs(24, 63)
                        .addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
                PartPose.offset(-3.0F, 11.0F, 2.5F));

        armRight02.addOrReplaceChild("Cloth03a",
                CubeListBuilder.create().texOffs(128, 50)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 7.0F, 6.0F),
                PartPose.offset(2.5F, 3.5F, -2.5F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(82, 0)
                        .addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 2.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));

        PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().texOffs(0, 84)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.15707963267948966F, 0.0F, 0.08726646259971647F));

        legLeft01.addOrReplaceChild("LegLeft02a",
                CubeListBuilder.create().texOffs(0, 63)
                        .addBox(-6.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                PartPose.offset(3.0F, 14.0F, -3.0F));

        PartDefinition legArmor01a = legLeft01.addOrReplaceChild("LegArmor01a",
                CubeListBuilder.create().texOffs(0, 3)
                        .addBox(-3.5F, -4.0F, 0.0F, 7.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 13.0F, -5.0F, -0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition legArmor01b = legArmor01a.addOrReplaceChild("LegArmor01b",
                CubeListBuilder.create().texOffs(12, 0)
                        .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6108652381980153F, 0.0F, 0.0F));

        legArmor01b.addOrReplaceChild("LegArmor01c",
                CubeListBuilder.create().texOffs(0, 3)
                        .addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 2.0F, 0.2F, 0.6108652381980153F, 0.0F, 0.0F));

        legLeft01.addOrReplaceChild("LegLeft02b",
                CubeListBuilder.create().texOffs(128, 63)
                        .addBox(-6.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                PartPose.offset(3.0F, 14.0F, -3.0F));

        PartDefinition skirt01 = butt.addOrReplaceChild("Skirt01",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-9.0F, 0.0F, -6.2F, 18.0F, 4.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition skirt02 = skirt01.addOrReplaceChild("Skirt02",
                CubeListBuilder.create().texOffs(128, 15)
                        .addBox(-10.5F, 0.0F, -6.0F, 21.0F, 4.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 2.7F, -1.0F, -0.08726646259971647F, 0.0F, 0.0F));

        skirt02.addOrReplaceChild("Skirt03",
                CubeListBuilder.create().texOffs(128, 32)
                        .addBox(-11.5F, 0.0F, -6.5F, 23.0F, 4.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, -0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().mirror().texOffs(0, 84)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.296705972839036F, 0.0F, -0.08726646259971647F));

        legRight01.addOrReplaceChild("LegRight02b",
                CubeListBuilder.create().mirror().texOffs(128, 63)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                PartPose.offset(-3.0F, 14.0F, -3.0F));

        legRight01.addOrReplaceChild("LegRight02a",
                CubeListBuilder.create().mirror().texOffs(0, 63)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                PartPose.offset(-3.0F, 14.0F, -3.0F));

        PartDefinition legArmor02a = legRight01.addOrReplaceChild("LegArmor02a",
                CubeListBuilder.create().texOffs(10, 0)
                        .addBox(-3.5F, -4.0F, 0.0F, 7.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 13.0F, -5.0F, -0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition legArmor02b = legArmor02a.addOrReplaceChild("LegArmor02b",
                CubeListBuilder.create().texOffs(1, 0)
                        .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6108652381980153F, 0.0F, 0.0F));

        legArmor02b.addOrReplaceChild("LegArmor02c",
                CubeListBuilder.create().texOffs(0, 3)
                        .addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 2.0F, 0.2F, 0.6108652381980153F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("Cloth02a",
                CubeListBuilder.create().texOffs(128, 99)
                        .addBox(-7.0F, 0.0F, -4.0F, 14.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, -11.5F, -0.6F, 0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -15.0F, 0.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -10.3F, 0.5F));

        PartDefinition glowHead = glowNeck.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -1.0F, -0.7F));

        PartDefinition glowHatBase = glowHead.addOrReplaceChild("GlowHatBase",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -14.6F, -2.0F));
        addDefaultFaceParts(glowHead);

        // Head decoration glow chain - left side
        PartDefinition headH1 = glowHatBase.addOrReplaceChild("HeadH1",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-2.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F),
                PartPose.offsetAndRotation(-8.5F, -2.0F, 2.0F, 0.17453292519943295F, 0.0F, 0.4363323129985824F));

        PartDefinition headH2 = headH1.addOrReplaceChild("HeadH2",
                CubeListBuilder.create().texOffs(33, 102)
                        .addBox(-1.0F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F),
                PartPose.offsetAndRotation(-1.8F, 0.0F, 0.0F, 0.0F, 0.0F, 0.12217304763960307F));

        headH2.addOrReplaceChild("HeadH3",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.08726646259971647F, 0.17453292519943295F));

        // Head decoration glow chain - right side
        PartDefinition headH4 = glowHatBase.addOrReplaceChild("HeadH4",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(0.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F),
                PartPose.offsetAndRotation(8.5F, -2.0F, 2.0F, 0.17453292519943295F, 0.0F, -0.4363323129985824F));

        PartDefinition headH5 = headH4.addOrReplaceChild("HeadH5",
                CubeListBuilder.create().texOffs(33, 102)
                        .addBox(0.0F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F),
                PartPose.offsetAndRotation(1.8F, 0.0F, 0.0F, 0.0F, 0.0F, -0.12217304763960307F));

        headH5.addOrReplaceChild("HeadH6",
                CubeListBuilder.create().texOffs(0, 900)
                        .addBox(0.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.7F, 0.0F, 0.0F, 0.0F, 0.08726646259971647F, -0.17453292519943295F));

        // Equipment runway glow chain
        PartDefinition equipRdL01 = glowBodyMain.addOrReplaceChild("EquipRdL01",
                CubeListBuilder.create().texOffs(128, 115)
                        .addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F),
                PartPose.offsetAndRotation(4.0F, -6.0F, 5.0F, 1.5707963267948966F, -0.17453292519943295F,
                        -0.7853981633974483F));

        PartDefinition equipRdL02 = equipRdL01.addOrReplaceChild("EquipRdL02",
                CubeListBuilder.create().texOffs(128, 115)
                        .addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.4363323129985824F, 0.0F, 0.0F));

        PartDefinition equipRdL03 = equipRdL02.addOrReplaceChild("EquipRdL03",
                CubeListBuilder.create().texOffs(128, 115)
                        .addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.6981317007977318F, 0.0F, 0.0F));

        PartDefinition equipRdL04 = equipRdL03.addOrReplaceChild("EquipRdL04",
                CubeListBuilder.create().texOffs(128, 115)
                        .addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.3490658503988659F, 0.0F, 0.0F));

        PartDefinition equipRdL05 = equipRdL04.addOrReplaceChild("EquipRdL05",
                CubeListBuilder.create().texOffs(128, 115)
                        .addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.2617993877991494F, 0.0F, 0.0F));

        equipRdL05.addOrReplaceChild("EquipRdL06",
                CubeListBuilder.create().texOffs(128, 115)
                        .addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.17453292519943295F, 0.0F, 0.0F));

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

        boolean flag = !EmotionHelper.checkModelState(1, state); // hat
        this.HatBase.visible = !flag;
        this.GlowHatBase.visible = !flag;

        flag = !EmotionHelper.checkModelState(2, state); // horn
        if (this.HeadH1 != null)
            this.HeadH1.visible = !flag;
        if (this.HeadH4 != null)
            this.HeadH4.visible = !flag;

        flag = !EmotionHelper.checkModelState(3, state); // bowtie
        this.Cloth01a.visible = !flag;

        flag = !EmotionHelper.checkModelState(4, state); // shawl
        this.Cloth02a.visible = !flag;
        this.Cloth02b.visible = !flag;
        this.Cloth02c.visible = !flag;

        flag = !EmotionHelper.checkModelState(5, state); // shawl
        this.Cloth03a.visible = !flag;
        this.Cloth03b.visible = !flag;

        flag = !EmotionHelper.checkModelState(6, state); // leg
        this.LegLeft02b.visible = !flag;
        this.LegRight02b.visible = !flag;
        this.LegLeft02a.visible = flag; // Alternate legs: visible when state OFF (original: isHidden = !flag)
        this.LegRight02a.visible = flag; // Alternate legs: visible when state OFF (original: isHidden = !flag)

        flag = !EmotionHelper.checkModelState(7, state); // leg armor
        this.LegArmor01a.visible = !flag;
        this.LegArmor02a.visible = !flag;
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
        this.LegLeft02b.xRot = this.LegLeft02a.xRot;
        this.LegLeft02b.yRot = this.LegLeft02a.yRot;
        this.LegLeft02b.zRot = this.LegLeft02a.zRot;
        this.LegRight02b.xRot = this.LegRight02a.xRot;
        this.LegRight02b.yRot = this.LegRight02a.yRot;
        this.LegRight02b.zRot = this.LegRight02a.zRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += 0.43F;
        this.setFaceHungry(ent);

        // Body
        this.Head.xRot = 0.5F;
        this.Head.yRot = 0F;
        this.Head.zRot = 0F;
        this.Ahoke.yRot = 0.45F;
        this.BodyMain.xRot = 0.5F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        this.Butt.xRot = -0.85F;
        // this.Butt.offsetY = 0F;
        // this.Butt.offsetZ = 0F;
        // cloth
        this.Skirt01.xRot = -0.087F;
        this.Skirt02.xRot = -0.087F;
        this.Skirt03.xRot = -0.052F;
        // this.Cloth01a.offsetY = 0.092F;
        // this.Cloth01a.offsetZ = 0.1F;
        this.Cloth01c.xRot = -0.79F;
        this.Cloth01c2.xRot = -0.73F;
        // hair
        this.Hair01.xRot = -0.12F;
        this.Hair01.yRot = 0F;
        this.Hair01.zRot = 0F;
        this.Hair02.xRot = -0.33F;
        this.Hair02.yRot = 0F;
        this.Hair02.zRot = 0F;
        this.Hair03.xRot = -0.38F;
        this.Hair03.yRot = 0F;
        this.Hair03.zRot = 0F;
        // arm
        this.ArmLeft01.xRot = -1.1F;
        this.ArmLeft01.yRot = 0.39F;
        this.ArmLeft01.zRot = -0.05F;
        this.ArmLeft02.xRot = -1.46F;
        this.ArmLeft02.zRot = 0F;
        // this.ArmLeft02.offsetX = 0F;
        // this.ArmLeft02.offsetZ = 0F;
        this.ArmRight01.xRot = -1.1F;
        this.ArmRight01.yRot = -0.39F;
        this.ArmRight01.zRot = 0.05F;
        this.ArmRight02.xRot = -1.46F;
        this.ArmRight02.zRot = 0F;
        // this.ArmRight02.offsetX = 0F;
        // this.ArmRight02.offsetZ = 0F;
        // leg
        this.LegLeft01.xRot = -1.96F;
        this.LegLeft01.yRot = -0.6F;
        this.LegLeft01.zRot = 1.56F;
        // this.LegLeft01.offsetY = 0F;
        // this.LegLeft01.offsetZ = 0F;
        this.LegLeft02a.xRot = 2.1F;
        this.LegLeft02a.yRot = 0F;
        this.LegLeft02a.zRot = 0F;
        // this.LegLeft02a.offsetX = 0F;
        // this.LegLeft02a.offsetY = 0F;
        // this.LegLeft02a.offsetZ = 0.37F;
        this.LegRight01.xRot = -0.96F;
        this.LegRight01.yRot = 0.36F;
        this.LegRight01.zRot = 0.14F;
        // this.LegRight01.offsetY = 0F;
        // this.LegRight01.offsetZ = 0F;
        this.LegRight02a.xRot = 1.2217F;
        this.LegRight02a.yRot = -1.2217F;
        this.LegRight02a.zRot = 1.0472F;
        // this.LegRight02a.offsetX = 0F;
        // this.LegRight02a.offsetY = -0.06F;
        // this.LegRight02a.offsetZ = 0F;
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
        if (ent.getShipDepth(0) > 0D || ent.getShipDepth(1) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        // leg move parm
        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += angleX * 0.05F + 0.025F;
        addk1 = angleAdd1 - 0.157F;
        addk2 = angleAdd2 - 0.296F;

        // 移動頭部使其看人
        this.Head.xRot = f4 * 0.014F; // 上下角度
        this.Head.yRot = f3 * 0.01F; // 左右角度
        this.Head.zRot = 0F;
        headX = this.Head.xRot * -0.5F;
        // 正常站立動作
        // Body
        this.Ahoke.yRot = angleX * 0.25F + 0.5236F;
        this.BodyMain.xRot = -0.1047F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        this.Butt.xRot = 0.35F;
        // this.Butt.offsetY = 0F;
        // this.Butt.offsetZ = 0F;
        // cloth
        this.Skirt01.xRot = -0.087F;
        this.Skirt02.xRot = -0.087F;
        this.Skirt03.xRot = -0.052F;
        this.Cloth01a.xRot = angleX * 0.08F + 0.79F;
        // this.Cloth01a.offsetY = 0.092F;
        // this.Cloth01a.offsetZ = 0.1F;
        this.Cloth01c.xRot = -angleX * 0.12F - 0.9F;
        this.Cloth01c2.xRot = -angleX * 0.12F - 0.85F;
        // hair
        this.Hair01.xRot = angleX * 0.03F + 0.21F + headX;
        this.Hair01.zRot = 0F;
        this.Hair02.xRot = -angleX1 * 0.04F + 0.12F + headX;
        this.Hair02.zRot = 0F;
        this.Hair03.xRot = -angleX2 * 0.07F - 0.26F;
        this.Hair03.zRot = 0F;
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
        this.ArmRight01.zRot = -angleX * 0.025F + 0.3F;
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
        this.LegLeft02a.xRot = 0F;
        this.LegLeft02a.yRot = 0F;
        this.LegLeft02a.zRot = 0F;
        // this.LegLeft02a.offsetX = 0F;
        // this.LegLeft02a.offsetY = 0F;
        // this.LegLeft02a.offsetZ = 0F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.087F;
        // this.LegRight01.offsetY = 0F;
        // this.LegRight01.offsetZ = 0F;
        this.LegRight02a.xRot = 0F;
        this.LegRight02a.yRot = 0F;
        this.LegRight02a.zRot = 0F;
        // this.LegRight02a.offsetX = 0F;
        // this.LegRight02a.offsetY = 0F;
        // this.LegRight02a.offsetZ = 0F;
        // equip
        if (this.EquipRdL01 != null)
            this.EquipRdL01.visible = false;

        // 奔跑動作
        if (ent.getIsSprinting() || f1 > 0.9F) {
            // hair angleX * 0.03F + 0.21F + headX
            this.Hair01.xRot = angleAdd1 * 0.1F + f1 * 0.4F + headX;
            this.Hair02.xRot += 0F;
            this.Hair03.xRot += 0.1F;
            // arm
            this.ArmLeft01.zRot += f1 * -0.2F;
            this.ArmRight01.zRot += f1 * 0.2F;
        }

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        // 潛行跟蹲下動作
        if (ent.getIsSneaking()) {
            // Body
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.06F;
            this.Head.xRot -= 0.6283F;
            this.BodyMain.xRot = 0.8727F;
            this.Skirt01.xRot = -0.35F;
            this.Skirt02.xRot = -0.19F;
            this.Skirt03.xRot = -0.24F;
            // arm
            this.ArmLeft01.xRot = -0.35F;
            this.ArmLeft01.zRot = 0.2618F;
            this.ArmRight01.xRot = -0.35F;
            this.ArmRight01.zRot = -0.2618F;
            // leg
            addk1 -= 1.02F;
            addk2 -= 1.02F;
            // hair
            this.Hair01.xRot += 0.37F;
            this.Hair02.xRot += 0.23F;
            this.Hair03.xRot -= 0.1F;
        } // end if sneaking

        // 坐下動作
        if (ent.getIsSitting() && !ent.getIsRiding()) {
            if (ent.getTickExisted() % 512 > 256) {
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.48F;
                this.setFaceScorn(ent);

                // Body
                this.Head.xRot += 0.1F;
                this.BodyMain.xRot = -0.1F;
                this.Butt.xRot = -0.4F;
                // this.Butt.offsetZ = 0.19F;
                this.Ahoke.yRot = 0.5236F;
                this.Skirt01.xRot = -0.35F;
                this.Skirt02.xRot = -0.19F;
                this.Skirt03.xRot = -0.24F;
                // hair
                this.Hair01.xRot = 0.21F + headX;
                this.Hair02.xRot = -0.28F + headX;
                this.Hair03.xRot = -0.24F;
                // arm
                this.ArmLeft01.xRot = -1.18F;
                this.ArmLeft01.yRot = 0.27F;
                this.ArmLeft01.zRot = -0.1F;
                this.ArmLeft02.zRot = 0.92F;
                this.ArmRight01.xRot = -1.18F;
                this.ArmRight01.yRot = -0.27F;
                this.ArmRight01.zRot = 0.1F;
                this.ArmRight02.zRot = -1.32F;
                // leg
                addk1 = -2.57F;
                addk2 = -2.57F;
                // this.LegLeft01.offsetY = 0.25F;
                // this.LegLeft01.offsetZ = -0.2F;
                this.LegLeft01.yRot = 0.11F;
                this.LegLeft01.zRot = -0.12F;
                this.LegLeft02a.xRot = 2.75F;
                this.LegLeft02a.zRot = 0.02F;
                // this.LegLeft02a.offsetZ = 0.37F;
                // this.LegRight01.offsetY = 0.25F;
                // this.LegRight01.offsetZ = -0.2F;
                this.LegRight01.yRot = -0.11F;
                this.LegRight01.zRot = 0.12F;
                this.LegRight02a.xRot = 2.75F;
                this.LegRight02a.zRot = -0.02F;
                // this.LegRight02a.offsetZ = 0.37F;
            } else {
                if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                    // Body
                    // [PORT] Restored from 1.10.2 GlStateManager.translate
                    this.offsetY += 0.27F;
                    this.Head.xRot += 0.14F;
                    this.BodyMain.xRot = -0.4363F;
                    this.Skirt01.xRot = -0.35F;
                    this.Skirt02.xRot = -0.19F;
                    this.Skirt03.xRot = -0.24F;
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
                    this.LegLeft02a.xRot = 1.0472F;
                    this.LegRight01.yRot = -0.35F;
                    this.LegRight01.zRot = -0.2618F;
                    this.LegRight02a.xRot = 0.9F;
                    // hair
                    this.Hair01.xRot += 0.12F;
                    this.Hair02.xRot += 0.15F;
                    this.Hair03.xRot += 0.25F;
                } else {
                    // Body
                    this.Head.xRot += 0.14F;
                    this.BodyMain.xRot = -0.5236F;
                    this.Skirt01.xRot = -0.35F;
                    this.Skirt02.xRot = -0.19F;
                    this.Skirt03.xRot = -0.24F;
                    // arm
                    this.ArmLeft01.xRot = -0.4363F;
                    this.ArmLeft01.zRot = 0.3142F;
                    this.ArmRight01.xRot = -0.4363F;
                    this.ArmRight01.zRot = -0.3142F;
                    // leg
                    addk1 = -1.6232F;
                    addk2 = -1.5708F;
                    this.LegLeft01.zRot = -0.3142F;
                    this.LegLeft02a.xRot = 1.34F;
                    this.LegRight01.zRot = 0.35F;
                    this.LegRight02a.xRot = 1.13F;
                    // hair
                    this.Hair01.xRot += 0.09F;
                    this.Hair02.xRot += 0.43F;
                    this.Hair03.xRot += 0.49F;
                }
            }
        } // end sitting

        // 騎乘專屬坐騎動作
        if (ent.getIsRiding()) {
            if (((net.minecraft.world.entity.Entity) ent).getVehicle() instanceof BasicEntityMount) {
                if (ent.getIsSitting()) {

                    if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                        this.setFaceScorn(ent);

                        // Body
                        this.Head.xRot += 0.1F;
                        this.BodyMain.xRot = -0.1F;
                        this.Butt.xRot = -0.4F;
                        // this.Butt.offsetZ = 0.19F;
                        this.Ahoke.yRot = 0.5236F;
                        this.Skirt01.xRot = -0.35F;
                        this.Skirt02.xRot = -0.19F;
                        this.Skirt03.xRot = -0.24F;
                        // hair
                        this.Hair01.xRot = 0.21F + headX;
                        this.Hair02.xRot = -0.28F + headX;
                        this.Hair03.xRot = -0.24F;
                        // arm
                        this.ArmLeft01.xRot = -1.18F;
                        this.ArmLeft01.yRot = 0.27F;
                        this.ArmLeft01.zRot = -0.1F;
                        this.ArmLeft02.zRot = 0.92F;
                        this.ArmRight01.xRot = -1.18F;
                        this.ArmRight01.yRot = -0.27F;
                        this.ArmRight01.zRot = 0.1F;
                        this.ArmRight02.zRot = -1.32F;
                        // leg
                        addk1 = -2.57F;
                        addk2 = -2.57F;
                        // this.LegLeft01.offsetY = 0.25F;
                        // this.LegLeft01.offsetZ = -0.2F;
                        this.LegLeft01.yRot = 0.11F;
                        this.LegLeft01.zRot = -0.12F;
                        this.LegLeft02a.xRot = 2.75F;
                        this.LegLeft02a.zRot = 0.02F;
                        // this.LegLeft02a.offsetZ = 0.37F;
                        // this.LegRight01.offsetY = 0.25F;
                        // this.LegRight01.offsetZ = -0.2F;
                        this.LegRight01.yRot = -0.11F;
                        this.LegRight01.zRot = 0.12F;
                        this.LegRight02a.xRot = 2.75F;
                        this.LegRight02a.zRot = -0.02F;
                        // this.LegRight02a.offsetZ = 0.37F;
                    } else {
                        if (ent.getTickExisted() % 512 > 256) {
                            // Body
                            this.Head.xRot += 0.14F;
                            this.BodyMain.xRot = -0.4363F;
                            this.Skirt01.xRot = -0.35F;
                            this.Skirt02.xRot = -0.19F;
                            this.Skirt03.xRot = -0.24F;
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
                            this.LegLeft02a.xRot = 1.0472F;
                            this.LegRight01.yRot = -0.35F;
                            this.LegRight01.zRot = -0.2618F;
                            this.LegRight02a.xRot = 0.9F;
                            // hair
                            this.Hair01.xRot += 0.12F;
                            this.Hair02.xRot += 0.15F;
                            this.Hair03.xRot += 0.25F;
                        } else {
                            // Body
                            this.Head.xRot += 0.14F;
                            this.BodyMain.xRot = -0.5236F;
                            this.Skirt01.xRot = -0.35F;
                            this.Skirt02.xRot = -0.19F;
                            this.Skirt03.xRot = -0.24F;
                            // arm
                            this.ArmLeft01.xRot = -0.4363F;
                            this.ArmLeft01.zRot = 0.3142F;
                            this.ArmRight01.xRot = -0.4363F;
                            this.ArmRight01.zRot = -0.3142F;
                            // leg
                            addk1 = -1.6232F;
                            addk2 = -1.5708F;
                            this.LegLeft01.zRot = -0.3142F;
                            this.LegLeft02a.xRot = 1.34F;
                            this.LegRight01.zRot = 0.35F;
                            this.LegRight02a.xRot = 1.13F;
                            // hair
                            this.Hair01.xRot += 0.09F;
                            this.Hair02.xRot += 0.43F;
                            this.Hair03.xRot += 0.49F;
                        }
                    }
                } // end if sitting
                else {
                    // body
                    // [PORT] Restored from 1.10.2 GlStateManager.translate
                    this.offsetY += 0.03F;
                    this.Head.xRot -= 0.7F;
                    this.BodyMain.xRot = 0.35F;
                    // hair
                    this.Hair01.xRot += 0.5F;
                    this.Hair02.xRot += 0.15F;
                    this.Hair03.xRot += 0F;
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
                    this.LegLeft02a.xRot = 2.1816615649929116F;
                    this.LegLeft02a.yRot = 0.0F;
                    this.LegLeft02a.zRot = 0.0F;
                    // this.LegLeft02a.offsetX = 0F;
                    // this.LegLeft02a.offsetZ = 0.37F;
                    this.LegRight01.yRot = 0.5235987755982988F;
                    this.LegRight01.zRot = 1.3962634015954636F;
                    this.LegRight02a.xRot = 2.1816615649929116F;
                    this.LegRight02a.yRot = 0.0F;
                    this.LegRight02a.zRot = 0.0F;
                    // this.LegRight02a.offsetX = 0F;
                    // this.LegRight02a.offsetZ = 0.37F;
                }
            } // end ship mount
            // normal mount ex: cart
            else {
                if (ent.getTickExisted() % 512 > 256) {
                    this.setFaceScorn(ent);

                    // Body
                    this.Head.xRot += 0.1F;
                    this.BodyMain.xRot = -0.1F;
                    this.Butt.xRot = -0.4F;
                    // this.Butt.offsetZ = 0.19F;
                    this.Ahoke.yRot = 0.5236F;
                    this.Skirt01.xRot = -0.35F;
                    this.Skirt02.xRot = -0.19F;
                    this.Skirt03.xRot = -0.24F;
                    // hair
                    this.Hair01.xRot = 0.21F + headX;
                    this.Hair02.xRot = -0.28F + headX;
                    this.Hair03.xRot = -0.24F;
                    // arm
                    this.ArmLeft01.xRot = -1.18F;
                    this.ArmLeft01.yRot = 0.27F;
                    this.ArmLeft01.zRot = -0.1F;
                    this.ArmLeft02.zRot = 0.92F;
                    this.ArmRight01.xRot = -1.18F;
                    this.ArmRight01.yRot = -0.27F;
                    this.ArmRight01.zRot = 0.1F;
                    this.ArmRight02.zRot = -1.32F;
                    // leg
                    addk1 = -2.57F;
                    addk2 = -2.57F;
                    // this.LegLeft01.offsetY = 0.25F;
                    // this.LegLeft01.offsetZ = -0.2F;
                    this.LegLeft01.yRot = 0.11F;
                    this.LegLeft01.zRot = -0.12F;
                    this.LegLeft02a.xRot = 2.75F;
                    this.LegLeft02a.zRot = 0.02F;
                    // this.LegLeft02a.offsetZ = 0.37F;
                    // this.LegRight01.offsetY = 0.25F;
                    // this.LegRight01.offsetZ = -0.2F;
                    this.LegRight01.yRot = -0.11F;
                    this.LegRight01.zRot = 0.12F;
                    this.LegRight02a.xRot = 2.75F;
                    this.LegRight02a.zRot = -0.02F;
                    // this.LegRight02a.offsetZ = 0.37F;
                } else {
                    if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                        // Body
                        this.Head.xRot += 0.14F;
                        this.BodyMain.xRot = -0.4363F;
                        this.Skirt01.xRot = -0.35F;
                        this.Skirt02.xRot = -0.19F;
                        this.Skirt03.xRot = -0.24F;
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
                        this.LegLeft02a.xRot = 1.0472F;
                        this.LegRight01.yRot = -0.35F;
                        this.LegRight01.zRot = -0.2618F;
                        this.LegRight02a.xRot = 0.9F;
                        // hair
                        this.Hair01.xRot += 0.12F;
                        this.Hair02.xRot += 0.15F;
                        this.Hair03.xRot += 0.25F;
                    } else {
                        // Body
                        this.Head.xRot += 0.14F;
                        this.BodyMain.xRot = -0.5236F;
                        this.Skirt01.xRot = -0.35F;
                        this.Skirt02.xRot = -0.19F;
                        this.Skirt03.xRot = -0.24F;
                        // arm
                        this.ArmLeft01.xRot = -0.4363F;
                        this.ArmLeft01.zRot = 0.3142F;
                        this.ArmRight01.xRot = -0.4363F;
                        this.ArmRight01.zRot = -0.3142F;
                        // leg
                        addk1 = -1.6232F;
                        addk2 = -1.5708F;
                        this.LegLeft01.zRot = -0.3142F;
                        this.LegLeft02a.xRot = 1.34F;
                        this.LegRight01.zRot = 0.35F;
                        this.LegRight02a.xRot = 1.13F;
                        // hair
                        this.Hair01.xRot += 0.09F;
                        this.Hair02.xRot += 0.43F;
                        this.Hair03.xRot += 0.49F;
                    }
                }
            }
        } // end ridding

        // 攻擊動作
        if (ent.getAttackTick() > 0) {
            if (ent.getAttackTick() > 25) {
                // arm
                this.ArmLeft01.xRot = -1.3F + this.Head.xRot * 0.75F;
                this.ArmLeft01.yRot = -0.2F;
                this.ArmLeft01.zRot = 0F;
                this.ArmLeft02.xRot = 0F;
                this.ArmLeft02.yRot = 0F;
                this.ArmLeft02.zRot = 0F;
                // this.ArmLeft02.offsetX = 0F;
                // this.ArmLeft02.offsetZ = 0F;
            }

            // 跑道顯示
            // Road visual parts are positioned statically in the constructor; no runtime
            // animation needed
        }

        // 移動頭髮避免穿過身體
        headZ = this.Head.zRot * -0.5F;
        this.Hair01.zRot = headZ;
        this.Hair02.zRot = headZ;
        this.Hair03.zRot = headZ;

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
