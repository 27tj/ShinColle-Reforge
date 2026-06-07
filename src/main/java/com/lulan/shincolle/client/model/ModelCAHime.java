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

public class ModelCAHime extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "ca_hime"), "main");

    private final ModelPart BodyMain;
    private final ModelPart ArmLeft01;
    private final ModelPart ArmRight01;
    private final ModelPart LegLeft01;
    private final ModelPart LegRight01;
    private final ModelPart Neck;
    private final ModelPart Head;
    private final ModelPart TailBase;
    private final ModelPart Band01;
    private final ModelPart Band02;
    private final ModelPart ArmLeft02;
    private final ModelPart ArmRight02;
    private final ModelPart LegLeft02;
    private final ModelPart LegRight02;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart Ear01;
    private final ModelPart Ear02;
    private final ModelPart Horn01;
    private final ModelPart Horn02;
    private final ModelPart HatBase;
    private final ModelPart Ahoke;
    private final ModelPart Hair01;
    private final ModelPart Hair02a;
    private final ModelPart Hair02b;
    private final ModelPart Hair03a;
    private final ModelPart Hair03b;
    private final ModelPart Horn03;
    private final ModelPart HatL;
    private final ModelPart HatR;
    private final ModelPart HatEyeL;
    private final ModelPart HatEyeR;
    private final ModelPart Tail01;
    private final ModelPart Tail01_1;
    private final ModelPart Tail02;
    private final ModelPart Tail03;
    private final ModelPart Tail04;
    private final ModelPart Tail05;
    private final ModelPart Tail06;
    private final ModelPart Tail07;
    private final ModelPart Tail08;
    private final ModelPart Tail09;
    private final ModelPart TailHead01;
    private final ModelPart TailJaw01;
    private final ModelPart TailC01;
    private final ModelPart TailC02;
    private final ModelPart Tail02_1;
    private final ModelPart Tail03_1;
    private final ModelPart Tail04_1;
    private final ModelPart Tail05_1;
    private final ModelPart Tail06_1;
    private final ModelPart Tail07_1;
    private final ModelPart Tail08_1;
    private final ModelPart Tail09_1;
    private final ModelPart TailHead01_1;
    private final ModelPart TailJaw01_1;
    private final ModelPart TailC01_1;
    private final ModelPart TailC02_1;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowHead;

    public ModelCAHime(ModelPart root) {
        super();
        this.scale = 0.45F;
        this.offsetY = 2.22F;
        this.BodyMain = root.getChild("BodyMain");
        this.Neck = this.BodyMain.getChild("Neck");
        this.LegRight01 = this.BodyMain.getChild("LegRight01");
        this.LegLeft01 = this.BodyMain.getChild("LegLeft01");
        this.Band02 = this.BodyMain.getChild("Band02");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.TailBase = this.BodyMain.getChild("TailBase");
        this.Head = this.BodyMain.getChild("Head");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.Band01 = this.BodyMain.getChild("Band01");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.Tail01 = this.TailBase.getChild("Tail01");
        this.Tail01_1 = this.TailBase.getChild("Tail01_1");
        this.HairMain = this.Head.getChild("HairMain");
        this.Ear01 = this.Head.getChild("Ear01");
        this.Horn02 = this.Head.getChild("Horn02");
        this.Hair = this.Head.getChild("Hair");
        this.HatBase = this.Head.getChild("HatBase");
        this.Ear02 = this.Head.getChild("Ear02");
        this.Horn01 = this.Head.getChild("Horn01");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.Tail02 = this.Tail01.getChild("Tail02");
        this.Tail02_1 = this.Tail01_1.getChild("Tail02_1");
        this.Hair01 = this.HairMain.getChild("Hair01");
        this.Hair03a = this.HairMain.getChild("Hair03a");
        this.Hair02b = this.HairMain.getChild("Hair02b");
        this.Hair02a = this.HairMain.getChild("Hair02a");
        this.Hair03b = this.HairMain.getChild("Hair03b");
        this.Horn03 = this.Horn02.getChild("Horn03");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.HatL = this.HatBase.getChild("HatL");
        this.HatR = this.HatBase.getChild("HatR");
        this.Tail03 = this.Tail02.getChild("Tail03");
        this.Tail03_1 = this.Tail02_1.getChild("Tail03_1");
        this.HatEyeL = this.HatL.getChild("HatEyeL");
        this.HatEyeR = this.HatR.getChild("HatEyeR");
        this.Tail04 = this.Tail03.getChild("Tail04");
        this.Tail04_1 = this.Tail03_1.getChild("Tail04_1");
        this.Tail05 = this.Tail04.getChild("Tail05");
        this.Tail05_1 = this.Tail04_1.getChild("Tail05_1");
        this.Tail06 = this.Tail05.getChild("Tail06");
        this.Tail06_1 = this.Tail05_1.getChild("Tail06_1");
        this.Tail07 = this.Tail06.getChild("Tail07");
        this.Tail07_1 = this.Tail06_1.getChild("Tail07_1");
        this.Tail08 = this.Tail07.getChild("Tail08");
        this.Tail08_1 = this.Tail07_1.getChild("Tail08_1");
        this.Tail09 = this.Tail08.getChild("Tail09");
        this.Tail09_1 = this.Tail08_1.getChild("Tail09_1");
        this.TailHead01 = this.Tail09.getChild("TailHead01");
        this.TailJaw01 = this.Tail09.getChild("TailJaw01");
        this.TailHead01_1 = this.Tail09_1.getChild("TailHead01_1");
        this.TailJaw01_1 = this.Tail09_1.getChild("TailJaw01_1");
        this.TailC01 = this.TailHead01.getChild("TailC01");
        this.TailC02 = this.TailHead01.getChild("TailC02");
        this.TailC02_1 = this.TailHead01_1.getChild("TailC02_1");
        this.TailC01_1 = this.TailHead01_1.getChild("TailC01_1");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowHead = this.GlowBodyMain.getChild("GlowHead");
        this.loadFaceParts(this.GlowHead);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 93)
                        .addBox(-5.5F, -4.5F, -12.0F, 11.0F, 10.0F, 24.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(0, 78)
                        .addBox(-5.0F, -4.0F, -4.5F, 10.0F, 5.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, -2.0F, -9.4F, 0.41887902047863906F, 0.0F, 0.0F));

        PartDefinition legRight01 = bodyMain.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().mirror().texOffs(66, 92)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F),
                PartPose.offsetAndRotation(-4.0F, 3.0F, 8.3F, -0.13962634015954636F, 0.0F, -0.17453292519943295F));

        legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().mirror().texOffs(66, 105)
                        .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 7.0F, 5.0F),
                PartPose.offset(0.0F, 8.0F, -2.5F));

        PartDefinition legLeft01 = bodyMain.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().texOffs(46, 92)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F),
                PartPose.offsetAndRotation(4.0F, 3.0F, 8.3F, 0.13962634015954636F, 0.0F, 0.17453292519943295F));

        legLeft01.addOrReplaceChild("LegLeft02",
                CubeListBuilder.create().texOffs(46, 105)
                        .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 7.0F, 5.0F),
                PartPose.offset(0.0F, 8.0F, -2.5F));

        bodyMain.addOrReplaceChild("Band02",
                CubeListBuilder.create().texOffs(40, 39)
                        .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 6.0F, 0.0F),
                PartPose.offsetAndRotation(-4.5F, 1.7F, -12.0F, -0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().mirror().texOffs(0, 92)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F),
                PartPose.offsetAndRotation(-4.0F, 3.0F, -6.0F, 0.13962634015954636F, 0.0F, -0.20943951023931953F));

        armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().mirror().texOffs(0, 105)
                        .addBox(0.0F, 0.0F, -5.0F, 5.0F, 7.0F, 5.0F),
                PartPose.offset(-2.5F, 8.0F, 2.5F));

        PartDefinition tailBase = bodyMain.addOrReplaceChild("TailBase",
                CubeListBuilder.create().texOffs(57, 21)
                        .addBox(-4.0F, -2.0F, 0.0F, 8.0F, 5.0F, 7.0F),
                PartPose.offset(0.0F, 7.0F, -2.0F));

        PartDefinition tail01 = tailBase.addOrReplaceChild("Tail01",
                CubeListBuilder.create().texOffs(58, 16)
                        .addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(1.5F, 0.0F, 3.0F, 0.2617993877991494F, 1.5707963267948966F, 0.0F));

        PartDefinition tail02 = tail01.addOrReplaceChild("Tail02",
                CubeListBuilder.create().texOffs(58, 17)
                        .addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.6108652381980153F, -0.08726646259971647F, 0.0F));

        PartDefinition tail03 = tail02.addOrReplaceChild("Tail03",
                CubeListBuilder.create().texOffs(54, 16)
                        .addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.6108652381980153F, -0.08726646259971647F, 0.0F));

        PartDefinition tail04 = tail03.addOrReplaceChild("Tail04",
                CubeListBuilder.create().texOffs(54, 19)
                        .addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.5235987755982988F, 0.0F, 0.0F));

        PartDefinition tail05 = tail04.addOrReplaceChild("Tail05",
                CubeListBuilder.create().texOffs(53, 16)
                        .addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.5235987755982988F, 0.0F, 0.0F));

        PartDefinition tail06 = tail05.addOrReplaceChild("Tail06",
                CubeListBuilder.create().texOffs(83, 0)
                        .addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.3490658503988659F, 0.0F, 0.0F));

        PartDefinition tail07 = tail06.addOrReplaceChild("Tail07",
                CubeListBuilder.create().texOffs(86, 0)
                        .addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.17453292519943295F, 0.08726646259971647F, 0.0F));

        PartDefinition tail08 = tail07.addOrReplaceChild("Tail08",
                CubeListBuilder.create().texOffs(83, 0)
                        .addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.08726646259971647F, 0.2617993877991494F, 0.0F));

        PartDefinition tail09 = tail08.addOrReplaceChild("Tail09",
                CubeListBuilder.create().texOffs(96, 0)
                        .addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, -0.08726646259971647F, 0.4363323129985824F, 0.0F));

        PartDefinition tailHead01 = tail09.addOrReplaceChild("TailHead01",
                CubeListBuilder.create().texOffs(40, 0)
                        .addBox(-4.5F, 0.0F, 0.0F, 9.0F, 6.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, -1.8F, 3.5F, -0.17453292519943295F, 0.0F, 0.0F));

        tailHead01.addOrReplaceChild("TailC01",
                CubeListBuilder.create().texOffs(100, 8)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F),
                PartPose.offsetAndRotation(2.0F, 4.5F, 9.5F, -0.13962634015954636F, 0.03490658503988659F, 0.0F));

        tailHead01.addOrReplaceChild("TailC02",
                CubeListBuilder.create().texOffs(100, 8)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F),
                PartPose.offsetAndRotation(-2.0F, 4.5F, 9.5F, -0.13962634015954636F, -0.03490658503988659F, 0.0F));

        tail09.addOrReplaceChild("TailJaw01",
                CubeListBuilder.create().texOffs(90, 18)
                        .addBox(-4.5F, -4.0F, 0.0F, 9.0F, 4.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, -0.7F, 3.3F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition tail01_1 = tailBase.addOrReplaceChild("Tail01_1",
                CubeListBuilder.create().texOffs(54, 16)
                        .addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(-1.5F, 0.0F, 3.0F, 0.6981317007977318F, -1.5707963267948966F, 0.0F));

        PartDefinition tail02_1 = tail01_1.addOrReplaceChild("Tail02_1",
                CubeListBuilder.create().texOffs(56, 17)
                        .addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.3490658503988659F, 0.2617993877991494F, 0.0F));

        PartDefinition tail03_1 = tail02_1.addOrReplaceChild("Tail03_1",
                CubeListBuilder.create().texOffs(58, 16)
                        .addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.4363323129985824F, 0.3490658503988659F, 0.0F));

        PartDefinition tail04_1 = tail03_1.addOrReplaceChild("Tail04_1",
                CubeListBuilder.create().texOffs(53, 18)
                        .addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.3490658503988659F, 0.4363323129985824F, 0.0F));

        PartDefinition tail05_1 = tail04_1.addOrReplaceChild("Tail05_1",
                CubeListBuilder.create().texOffs(58, 19)
                        .addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.5235987755982988F, 0.3490658503988659F, 0.0F));

        PartDefinition tail06_1 = tail05_1.addOrReplaceChild("Tail06_1",
                CubeListBuilder.create().texOffs(85, 2)
                        .addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.08726646259971647F, 0.2617993877991494F, 0.0F));

        PartDefinition tail07_1 = tail06_1.addOrReplaceChild("Tail07_1",
                CubeListBuilder.create().texOffs(86, 0)
                        .addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, -0.3490658503988659F, 0.3490658503988659F, 0.0F));

        PartDefinition tail08_1 = tail07_1.addOrReplaceChild("Tail08_1",
                CubeListBuilder.create().texOffs(83, 0)
                        .addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, -0.5235987755982988F, 0.3490658503988659F, 0.0F));

        PartDefinition tail09_1 = tail08_1.addOrReplaceChild("Tail09_1",
                CubeListBuilder.create().texOffs(96, 0)
                        .addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, -0.08726646259971647F, 0.4363323129985824F, 0.0F));

        PartDefinition tailHead01_1 = tail09_1.addOrReplaceChild("TailHead01_1",
                CubeListBuilder.create().texOffs(40, 0)
                        .addBox(-4.5F, 0.0F, 0.0F, 9.0F, 6.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, -1.8F, 3.5F, -0.17453292519943295F, 0.0F, 0.0F));

        tailHead01_1.addOrReplaceChild("TailC02_1",
                CubeListBuilder.create().texOffs(100, 8)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F),
                PartPose.offsetAndRotation(-2.0F, 4.5F, 9.5F, -0.13962634015954636F, -0.03490658503988659F, 0.0F));

        tailHead01_1.addOrReplaceChild("TailC01_1",
                CubeListBuilder.create().texOffs(100, 8)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F),
                PartPose.offsetAndRotation(2.0F, 4.5F, 9.5F, -0.13962634015954636F, 0.03490658503988659F, 0.0F));

        tail09_1.addOrReplaceChild("TailJaw01_1",
                CubeListBuilder.create().texOffs(90, 18)
                        .addBox(-4.5F, -4.0F, 0.0F, 9.0F, 4.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, -0.7F, 2.7F, 0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition head = bodyMain.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 65)
                        .addBox(-7.0F, -11.0F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offset(0.0F, -6.0F, -13.0F));

        PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(0, 56)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 12.0F, 10.0F),
                PartPose.offset(0.0F, -11.5F, -3.0F));

        hairMain.addOrReplaceChild("Hair01",
                CubeListBuilder.create().texOffs(0, 40)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 7.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 9.0F, 1.6F, 0.3490658503988659F, 0.0F, 0.0F));

        hairMain.addOrReplaceChild("Hair03a",
                CubeListBuilder.create().texOffs(90, 32)
                        .addBox(-1.5F, 0.0F, -3.0F, 3.0F, 12.0F, 4.0F),
                PartPose.offsetAndRotation(6.4F, 9.8F, 5.5F, -0.20943951023931953F, -0.13962634015954636F,
                        0.06981317007977318F));

        hairMain.addOrReplaceChild("Hair02b",
                CubeListBuilder.create().texOffs(81, 116)
                        .addBox(-1.5F, 0.0F, -3.3F, 3.0F, 7.0F, 5.0F),
                PartPose.offsetAndRotation(-6.9F, 4.7F, 0.0F, 0.0F, 0.0F, 0.08726646259971647F));

        hairMain.addOrReplaceChild("Hair02a",
                CubeListBuilder.create().texOffs(81, 116)
                        .addBox(-1.5F, 0.0F, -3.3F, 3.0F, 7.0F, 5.0F),
                PartPose.offsetAndRotation(6.9F, 4.7F, 0.0F, 0.0F, 0.0F, -0.08726646259971647F));

        hairMain.addOrReplaceChild("Hair03b",
                CubeListBuilder.create().texOffs(90, 32)
                        .addBox(-1.5F, 0.0F, -3.0F, 3.0F, 12.0F, 4.0F),
                PartPose.offsetAndRotation(-6.4F, 9.8F, 5.5F, -0.20943951023931953F, 0.13962634015954636F,
                        -0.06981317007977318F));

        head.addOrReplaceChild("Ear01",
                CubeListBuilder.create().texOffs(0, 26)
                        .addBox(-2.0F, 0.0F, -7.0F, 4.0F, 7.0F, 7.0F),
                PartPose.offsetAndRotation(4.2F, -11.0F, 6.8F, -0.8377580409572781F, -0.12217304763960307F,
                        0.17453292519943295F));

        PartDefinition horn02 = head.addOrReplaceChild("Horn02",
                CubeListBuilder.create().texOffs(40, 39)
                        .addBox(-1.5F, -1.5F, -6.0F, 3.0F, 3.0F, 6.0F),
                PartPose.offsetAndRotation(3.3F, -7.5F, -6.0F, -0.8726646259971648F, -0.4363323129985824F,
                        0.2617993877991494F));

        horn02.addOrReplaceChild("Horn03",
                CubeListBuilder.create().texOffs(40, 39)
                        .addBox(-3.0F, -3.0F, -6.0F, 3.0F, 3.0F, 6.0F),
                PartPose.offsetAndRotation(1.5F, 1.5F, -6.0F, -0.6981317007977318F, 0.0F, 0.0F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(50, 40)
                        .addBox(-8.0F, -8.0F, -7.2F, 16.0F, 17.0F, 8.0F),
                PartPose.offset(0.0F, -4.0F, 0.0F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(104, 29)
                        .addBox(0.0F, 0.0F, -12.0F, 0.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(2.0F, -4.0F, -7.6F, -0.2617993877991494F, 1.48352986419518F,
                        -0.2617993877991494F));

        PartDefinition hatBase = head.addOrReplaceChild("HatBase",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offset(0.0F, -3.1F, 5.8F));

        PartDefinition hatL = hatBase.addOrReplaceChild("HatL",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, -14.0F, -1.0F, 10.0F, 16.0F, 10.0F),
                PartPose.offsetAndRotation(-1.3F, 2.1F, -2.9F, 0.5235987755982988F, 0.08726646259971647F,
                        0.06981317007977318F));

        hatL.addOrReplaceChild("HatEyeL",
                CubeListBuilder.create().texOffs(22, 28)
                        .addBox(0.0F, -3.0F, -3.0F, 1.0F, 6.0F, 6.0F),
                PartPose.offsetAndRotation(9.6F, -6.0F, 5.3F, 0.08726646259971647F, -0.05235987755982988F,
                        -0.05235987755982988F));

        PartDefinition hatR = hatBase.addOrReplaceChild("HatR",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-10.0F, -14.0F, -1.0F, 10.0F, 16.0F, 10.0F),
                PartPose.offsetAndRotation(1.3F, 2.1F, -2.9F, 0.5235987755982988F, -0.08726646259971647F,
                        -0.06981317007977318F));

        hatR.addOrReplaceChild("HatEyeR",
                CubeListBuilder.create().mirror().texOffs(22, 28)
                        .addBox(-1.0F, -3.0F, -3.0F, 1.0F, 6.0F, 6.0F),
                PartPose.offsetAndRotation(-9.6F, -6.0F, 5.3F, 0.08726646259971647F, 0.05235987755982988F,
                        0.05235987755982988F));

        head.addOrReplaceChild("Ear02",
                CubeListBuilder.create().mirror().texOffs(0, 26)
                        .addBox(-2.0F, 0.0F, -7.0F, 4.0F, 7.0F, 7.0F),
                PartPose.offsetAndRotation(-4.2F, -11.0F, 6.8F, -0.8377580409572781F, 0.12217304763960307F,
                        -0.17453292519943295F));

        head.addOrReplaceChild("Horn01",
                CubeListBuilder.create().texOffs(40, 39)
                        .addBox(-1.5F, -1.5F, -6.0F, 3.0F, 3.0F, 6.0F),
                PartPose.offsetAndRotation(-3.0F, -7.5F, -6.0F, -0.8726646259971648F, 0.4363323129985824F,
                        -0.5235987755982988F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().texOffs(0, 92)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F),
                PartPose.offsetAndRotation(4.0F, 3.0F, -6.0F, -0.13962634015954636F, 0.0F, 0.20943951023931953F));

        armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().texOffs(0, 105)
                        .addBox(-5.0F, 0.0F, -5.0F, 5.0F, 7.0F, 5.0F),
                PartPose.offset(2.5F, 8.0F, 2.5F));

        bodyMain.addOrReplaceChild("Band01",
                CubeListBuilder.create().texOffs(40, 39)
                        .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 6.0F, 0.0F),
                PartPose.offsetAndRotation(4.5F, 1.7F, -12.0F, -0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition glowHead = glowBodyMain.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -6.0F, -13.0F));
        addDefaultFaceParts(glowHead);

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

        int state = ent.getStateEmotion(ID.S.State);

        // tail state
        boolean ft1 = EmotionHelper.checkModelState(0, state);
        boolean ft2 = EmotionHelper.checkModelState(1, state);

        this.TailBase.visible = !(ft1 || ft2);

        // hat state
        boolean fh1 = EmotionHelper.checkModelState(2, state);
        boolean fh2 = EmotionHelper.checkModelState(3, state);
        boolean fh3 = EmotionHelper.checkModelState(4, state);
        boolean fh4 = fh1 & fh2;

        // hat state 2, 3, 4
        if (fh2 || fh3) {
            this.HatBase.visible = true;
            this.Hair01.visible = false;
            this.Horn01.visible = true;
            this.Horn02.visible = true;
            this.Ear01.visible = true;
            this.Ear02.visible = true;
        }
        // hat state 1
        else if (fh1) {
            this.HatBase.visible = true;
            this.Hair01.visible = false;
            this.Horn01.visible = false;
            this.Horn02.visible = false;
            this.Ear01.visible = false;
            this.Ear02.visible = false;
        }
        // no hat
        else {
            this.HatBase.visible = false;
            this.Hair01.visible = true;
            this.Horn01.visible = true;
            this.Horn02.visible = true;
            this.Ear01.visible = true;
            this.Ear02.visible = true;
        }
    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowBodyMain.xRot = this.BodyMain.xRot;
        this.GlowBodyMain.yRot = this.BodyMain.yRot;
        this.GlowBodyMain.zRot = this.BodyMain.zRot;
        this.GlowHead.xRot = this.Head.xRot;
        this.GlowHead.yRot = this.Head.yRot;
        this.GlowHead.zRot = this.Head.zRot;
        this.TailHead01_1.xRot = this.TailHead01.xRot;
        this.TailJaw01_1.xRot = this.TailJaw01.xRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += 0.2F;
        this.setFaceHungry(ent);

        // 頭部
        this.Head.xRot = 0.7853F;
        this.Head.yRot = 0F;
        // Body
        this.Ahoke.xRot = -0.2618F;
        this.BodyMain.xRot = 0F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = -1.4835F;
        // this.Head.offsetY = 0F;
        // this.GlowHead.offsetY = 0F;
        // arm
        this.ArmLeft01.xRot = -0.4F;
        this.ArmLeft01.zRot = 0.4537F;
        // this.ArmLeft01.offsetZ = 0F;
        this.ArmLeft02.zRot = 0F;
        this.ArmRight01.xRot = -0.8F;
        this.ArmRight01.zRot = -0.05F;
        // this.ArmRight01.offsetZ = 0F;
        this.ArmRight02.zRot = 0F;
        // leg
        this.LegLeft01.xRot = 0.5F;
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.4537F;
        this.LegLeft02.xRot = 0F;
        this.LegLeft02.zRot = 0F;
        this.LegRight01.xRot = 0.8F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.05F;
        this.LegRight02.xRot = 0F;
        this.LegRight02.zRot = 0F;

        // equip: hat position
        int state = ent.getStateEmotion(ID.S.State);
        boolean fh1 = EmotionHelper.checkModelState(2, state);
        boolean fh2 = EmotionHelper.checkModelState(3, state);
        boolean fh3 = EmotionHelper.checkModelState(4, state);
        boolean fh4 = fh1 & fh2;

        // hat state 4
        if (fh4) {
            this.HatBase.xRot = -1.8F;// -103
            // this.HatBase.offsetY = 0.6F;
            // this.HatBase.offsetZ = 0.07F;
        }
        // hat state 1
        else if (fh1) {
            this.HatBase.xRot = 1.37F;// 78
            // this.HatBase.offsetY = -0.45F;
            // this.HatBase.offsetZ = -0.2F;
        }
        // hat state 3
        else if (fh3) {
            this.HatBase.xRot = -0.85F;// -48
            // this.HatBase.offsetY = 0.33F;
            // this.HatBase.offsetZ = 0.07F;
        }
        // no hat or hat state 2
        else {
            this.HatBase.xRot = 0F;
            // this.HatBase.offsetY = 0F;
            // this.HatBase.offsetZ = 0F;
        }

        // tail head
        this.TailHead01.xRot = -0.17F;
        this.TailJaw01.xRot = 0.26F;
        this.TailHead01_1.xRot = 0F;
        this.TailJaw01_1.xRot = 0.2F;
        // tail body
        this.TailBase.visible = true;
        this.Tail01.xRot = -1.4F;
        this.Tail01.yRot = 1.57F;
        this.Tail02.xRot = -0.3F;
        this.Tail02.yRot = 0.2F;
        this.Tail03.xRot = -0.3F;
        this.Tail03.yRot = 0.3F;
        this.Tail04.xRot = 0.2F;
        this.Tail04.yRot = 0.4F;
        this.Tail05.xRot = 0.1F;
        this.Tail05.yRot = 0.5F;
        this.Tail06.xRot = -0.1F;
        this.Tail06.yRot = 0.4F;
        this.Tail07.xRot = -0.1F;
        this.Tail07.yRot = 0.3F;
        this.Tail08.xRot = 0.1F;
        this.Tail08.yRot = 0.2F;
        this.Tail09.xRot = 0F;
        this.Tail09.yRot = 0.1F;
        this.Tail01_1.xRot = -1.4F;
        this.Tail01_1.yRot = -1.7F;
        this.Tail02_1.xRot = -0.2F;
        this.Tail02_1.yRot = 0.2F;
        this.Tail03_1.xRot = -0.1F;
        this.Tail03_1.yRot = 0.3F;
        this.Tail04_1.xRot = 0F;
        this.Tail04_1.yRot = 0.4F;
        this.Tail05_1.xRot = 0F;
        this.Tail05_1.yRot = 0.5F;
        this.Tail06_1.xRot = -0.1F;
        this.Tail06_1.yRot = 0.4F;
        this.Tail07_1.xRot = -0.1F;
        this.Tail07_1.yRot = 0.3F;
        this.Tail08_1.xRot = 0.2F;
        this.Tail08_1.yRot = 0.2F;
        this.Tail09_1.xRot = -0.2F;
        this.Tail09_1.yRot = 0.3F;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float angleX = Mth.cos(f2 * 0.08F + f * 0.25F);
        float angleX1 = Mth.cos(f2 * 0.08F + 0.3F + f * 0.5F);
        float angleX2 = Mth.cos(f2 * 0.08F + 0.6F + f * 0.5F);
        float angleAdd1 = Mth.cos(f * 0.7F) * f1;
        float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
        float addk1;
        float addk2;
        int state = ent.getStateEmotion(ID.S.State);
        boolean ft1 = EmotionHelper.checkModelState(0, state);
        boolean ft2 = EmotionHelper.checkModelState(1, state);
        boolean ft3 = ft1 & ft2;
        boolean fh1 = EmotionHelper.checkModelState(2, state);
        boolean fh2 = EmotionHelper.checkModelState(3, state);
        boolean fh3 = EmotionHelper.checkModelState(4, state);
        boolean fh4 = fh1 & fh2;

        // 水上漂浮
        if (ent.getShipDepth(0) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        // leg move
        addk1 = angleAdd1 * 0.35F - 0.14F; // LegLeft01
        addk2 = angleAdd2 * 0.35F + 0.14F; // LegRight01
        this.ArmRight01.xRot = addk1;
        this.ArmLeft01.xRot = addk2;

        // head
        this.Head.xRot = f4 * 0.014F; // 上下角度
        this.Head.yRot = f3 * 0.01F; // 左右角度 角度轉成rad 即除以57.29578
        // body
        this.Ahoke.xRot = angleX * 0.05F - 0.2618F;
        this.BodyMain.xRot = 0F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        // this.Head.offsetY = 0F;
        // this.GlowHead.offsetY = 0F;
        // arm
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = 0.21F;
        // this.ArmLeft01.offsetZ = 0F;
        this.ArmLeft02.zRot = 0F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = -0.21F;
        // this.ArmRight01.offsetZ = 0F;
        this.ArmRight02.zRot = 0F;
        // leg
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.1745F;
        this.LegLeft02.xRot = 0F;
        this.LegLeft02.zRot = 0F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.1745F;
        this.LegRight02.xRot = 0F;
        this.LegRight02.zRot = 0F;

        // equip: hat position
        // hat state 4
        if (fh4) {
            this.HatBase.xRot = -1.8F;// -103
            // this.HatBase.offsetY = 0.4F;
            // this.HatBase.offsetZ = 0.07F;
        }
        // hat state 1
        else if (fh1) {
            this.HatBase.xRot = 1.37F;// 78
            // this.HatBase.offsetY = -0.45F;
            // this.HatBase.offsetZ = -0.2F;
        }
        // hat state 3
        else if (fh3) {
            this.HatBase.xRot = -0.85F;// -48
            // this.HatBase.offsetY = 0.33F;
            // this.HatBase.offsetZ = 0.07F;
        }
        // no hat or hat state 2
        else {
            this.HatBase.xRot = 0F;
            // this.HatBase.offsetY = 0F;
            // this.HatBase.offsetZ = 0F;
        }

        // equip: tail position
        float[] cosf2 = new float[9];
        for (int i = 0; i < 9; i++) {
            cosf2[i] = Mth.cos(f2 * 0.1F + f * 0.25F + 0.8F * i);
        }

        // tail head
        this.TailHead01.xRot = -angleX * 0.075F - 0.1F;
        this.TailJaw01.xRot = angleX * 0.1F + 0.18F;
        this.TailHead01_1.xRot = -angleX2 * 0.12F - 0.1F;
        this.TailJaw01_1.xRot = angleX2 * 0.15F + 0.26F;
        this.TailC01.xRot = angleX1 * 0.3F - 0.2F;
        this.TailC02.xRot = angleX2 * 0.3F - 0.2F;
        this.TailC01_1.xRot = angleX1 * 0.3F - 0.2F;
        this.TailC02_1.xRot = angleX2 * 0.3F - 0.2F;

        // tail body
        if (ft3) {
            // this.TailBase.offsetY = -0.15F;
            // this.TailBase.offsetZ = 0F;
            this.Tail01.xRot = 0.26F;
            this.Tail01.yRot = 1.7F + cosf2[0] * 0.015F;
            this.Tail02.xRot = 0.61F;
            this.Tail02.yRot = -0.09F + cosf2[1] * 0.02F;
            this.Tail03.xRot = 0.61F;
            this.Tail03.yRot = -0.09F + cosf2[2] * 0.025F;
            this.Tail04.xRot = 0.52F;
            this.Tail04.yRot = 0F + cosf2[3] * 0.03F;
            this.Tail05.xRot = 0.52F;
            this.Tail05.yRot = 0F + cosf2[4] * 0.04F;
            this.Tail06.xRot = 0.35F;
            this.Tail06.yRot = 0F + cosf2[5] * 0.05F;
            this.Tail07.xRot = 0.17F;
            this.Tail07.yRot = 0.1F + cosf2[6] * 0.06F;
            this.Tail08.xRot = 0.09F;
            this.Tail08.yRot = 0.1F + cosf2[7] * 0.08F;
            this.Tail09.xRot = -0.09F;
            this.Tail09.yRot = 0.5F + cosf2[8] * 0.15F;
            this.Tail01_1.xRot = 0.7F;
            this.Tail01_1.yRot = -1.57F + cosf2[0] * 0.02F;
            this.Tail02_1.xRot = 0.35F;
            this.Tail02_1.yRot = 0.26F + cosf2[1] * 0.03F;
            this.Tail03_1.xRot = 0.44F;
            this.Tail03_1.yRot = 0.35F + cosf2[2] * 0.04F;
            this.Tail04_1.xRot = 0.35F;
            this.Tail04_1.yRot = 0.44F + cosf2[3] * 0.05F;
            this.Tail05_1.xRot = 0.52F;
            this.Tail05_1.yRot = 0.35F + cosf2[4] * 0.06F;
            this.Tail06_1.xRot = 0.09F;
            this.Tail06_1.yRot = 0.26F + cosf2[5] * 0.07F;
            this.Tail07_1.xRot = -0.35F;
            this.Tail07_1.yRot = 0.35F + cosf2[6] * 0.08F;
            this.Tail08_1.xRot = -0.52F;
            this.Tail08_1.yRot = 0.35F + cosf2[7] * 0.09F;
            this.Tail09_1.xRot = -0.09F;
            this.Tail09_1.yRot = 0.44F + cosf2[8] * 0.12F;
        } else if (ft1) {
            // this.TailBase.offsetY = -0.15F;
            // this.TailBase.offsetZ = 0F;
            this.Tail01.xRot = -0.17F + cosf2[0] * 0.03F;
            this.Tail01.yRot = 1.3F + cosf2[0] * 0.03F;
            this.Tail02.xRot = 0.26F + cosf2[1] * 0.03F;
            this.Tail02.yRot = -0.52F + cosf2[1] * 0.03F;
            this.Tail03.xRot = 0.35F + cosf2[2] * 0.03F;
            this.Tail03.yRot = -0.52F + cosf2[2] * 0.03F;
            this.Tail04.xRot = 0.52F + cosf2[3] * 0.03F;
            this.Tail04.yRot = -0.44F + cosf2[3] * 0.03F;
            this.Tail05.xRot = 0.52F + cosf2[4] * 0.04F;
            this.Tail05.yRot = -0.17F + cosf2[4] * 0.04F;
            this.Tail06.xRot = 0.35F + cosf2[5] * 0.05F;
            this.Tail06.yRot = 0.35F + cosf2[5] * 0.05F;
            this.Tail07.xRot = 0.44F + cosf2[6] * 0.06F;
            this.Tail07.yRot = 0.17F + cosf2[6] * 0.06F;
            this.Tail08.xRot = 0.52F + cosf2[7] * 0.08F;
            this.Tail08.yRot = 0.17F + cosf2[7] * 0.08F;
            this.Tail09.xRot = 0.52F + cosf2[8] * 0.15F;
            this.Tail09.yRot = 0.17F + cosf2[8] * 0.15F;
            this.Tail01_1.xRot = -0.17F + cosf2[0] * 0.03F;
            this.Tail01_1.yRot = -1.3F + cosf2[0] * 0.03F;
            this.Tail02_1.xRot = 0.26F + cosf2[1] * 0.03F;
            this.Tail02_1.yRot = 0.52F + cosf2[1] * 0.03F;
            this.Tail03_1.xRot = 0.35F + cosf2[2] * 0.03F;
            this.Tail03_1.yRot = 0.52F + cosf2[2] * 0.03F;
            this.Tail04_1.xRot = 0.52F + cosf2[3] * 0.03F;
            this.Tail04_1.yRot = 0.44F + cosf2[3] * 0.03F;
            this.Tail05_1.xRot = 0.52F + cosf2[4] * 0.04F;
            this.Tail05_1.yRot = 0.17F + cosf2[4] * 0.04F;
            this.Tail06_1.xRot = 0.35F + cosf2[5] * 0.05F;
            this.Tail06_1.yRot = -0.35F + cosf2[5] * 0.05F;
            this.Tail07_1.xRot = 0.44F + cosf2[6] * 0.06F;
            this.Tail07_1.yRot = -0.17F + cosf2[6] * 0.06F;
            this.Tail08_1.xRot = 0.52F + cosf2[7] * 0.08F;
            this.Tail08_1.yRot = -0.17F + cosf2[7] * 0.08F;
            this.Tail09_1.xRot = 0.52F + cosf2[8] * 0.15F;
            this.Tail09_1.yRot = -0.17F + cosf2[8] * 0.15F;
        } else if (ft2) {
            // this.TailBase.offsetY = -0.54F;
            // this.TailBase.offsetZ = 0.86F;
            this.Tail01.xRot = -0.17F + cosf2[0] * 0.03F;
            this.Tail01.yRot = 1.3F + cosf2[0] * 0.03F;
            this.Tail02.xRot = 0.26F + cosf2[1] * 0.03F;
            this.Tail02.yRot = -0.52F + cosf2[1] * 0.03F;
            this.Tail03.xRot = 0.35F + cosf2[2] * 0.03F;
            this.Tail03.yRot = -0.52F + cosf2[2] * 0.03F;
            this.Tail04.xRot = 0.52F + cosf2[3] * 0.03F;
            this.Tail04.yRot = -0.44F + cosf2[3] * 0.03F;
            this.Tail05.xRot = 0.52F + cosf2[4] * 0.04F;
            this.Tail05.yRot = -0.17F + cosf2[4] * 0.04F;
            this.Tail06.xRot = 0.35F + cosf2[5] * 0.05F;
            this.Tail06.yRot = 0.35F + cosf2[5] * 0.05F;
            this.Tail07.xRot = 0.44F + cosf2[6] * 0.06F;
            this.Tail07.yRot = 0.17F + cosf2[6] * 0.06F;
            this.Tail08.xRot = 0.52F + cosf2[7] * 0.08F;
            this.Tail08.yRot = 0.17F + cosf2[7] * 0.08F;
            this.Tail09.xRot = 0.52F + cosf2[8] * 0.15F;
            this.Tail09.yRot = 0.17F + cosf2[8] * 0.15F;
            this.Tail01_1.xRot = -0.17F + cosf2[0] * 0.03F;
            this.Tail01_1.yRot = -1.3F + cosf2[0] * 0.03F;
            this.Tail02_1.xRot = 0.26F + cosf2[1] * 0.03F;
            this.Tail02_1.yRot = 0.52F + cosf2[1] * 0.03F;
            this.Tail03_1.xRot = 0.35F + cosf2[2] * 0.03F;
            this.Tail03_1.yRot = 0.52F + cosf2[2] * 0.03F;
            this.Tail04_1.xRot = 0.52F + cosf2[3] * 0.03F;
            this.Tail04_1.yRot = 0.44F + cosf2[3] * 0.03F;
            this.Tail05_1.xRot = 0.52F + cosf2[4] * 0.04F;
            this.Tail05_1.yRot = 0.17F + cosf2[4] * 0.04F;
            this.Tail06_1.xRot = 0.35F + cosf2[5] * 0.05F;
            this.Tail06_1.yRot = -0.35F + cosf2[5] * 0.05F;
            this.Tail07_1.xRot = 0.44F + cosf2[6] * 0.06F;
            this.Tail07_1.yRot = -0.17F + cosf2[6] * 0.06F;
            this.Tail08_1.xRot = 0.52F + cosf2[7] * 0.08F;
            this.Tail08_1.yRot = -0.17F + cosf2[7] * 0.08F;
            this.Tail09_1.xRot = 0.52F + cosf2[8] * 0.15F;
            this.Tail09_1.yRot = -0.17F + cosf2[8] * 0.15F;
        }

        // ear
        float modf2 = f2 % 128F;
        if (modf2 < 6F) {
            // total 10 ticks, loop twice in 20 ticks
            if (modf2 >= 3F)
                modf2 -= 3F;
            float anglef2 = Mth.sin(modf2 * 1.0472F) * 0.25F;
            this.Ear01.zRot = anglef2 + 0.1745F;
            this.Ear02.zRot = -anglef2 - 0.1745F;
        } else {
            this.Ear01.zRot = 0.1745F;
            this.Ear02.zRot = -0.1745F;
        }

        // 奔跑動作
        if (ent.getIsSprinting() || f1 > 0.8F) {
            // leg
            addk1 *= 2F;
            addk2 *= 2F;
            this.ArmRight01.xRot = addk1;
            this.ArmLeft01.xRot = addk2;
        }

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        // 潛行, 蹲下動作
        ent.getIsSneaking();
        // head
        // this.Head.offsetY = 0.2F;
        // this.GlowHead.offsetY = 0.2F;
        // end if sneaking

        // 坐下, 騎乘動作
        if (ent.getIsSitting() || ent.getIsRiding()) {
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                // hat state 4
                if (fh4) {
                    this.HatBase.xRot = -1.8F;// -103
                    // this.HatBase.offsetY = 0.3F;
                    // this.HatBase.offsetZ = 0.07F;
                }
                // hat state 1
                else if (fh1) {
                    this.HatBase.xRot = 1.37F;// 78
                    // this.HatBase.offsetY = -0.45F;
                    // this.HatBase.offsetZ = -0.2F;
                }
                // hat state 3
                else if (fh3) {
                    this.HatBase.xRot = -0.85F;// -48
                    // this.HatBase.offsetY = 0.1F;
                    // this.HatBase.offsetZ = 0.07F;
                }
                // no hat or hat state 2
                else {
                    this.HatBase.xRot = 0F;
                    // this.HatBase.offsetY = 0F;
                    // this.HatBase.offsetZ = 0F;
                }
                // body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.21F;
                this.Head.xRot -= 0.2F;
                this.Head.zRot -= 0.09F;
                this.BodyMain.zRot = 0.09F;
                // arm
                this.ArmLeft01.xRot = -1.31F;
                this.ArmLeft01.yRot = 0.17F;
                this.ArmLeft01.zRot = 0F;
                // this.ArmLeft01.offsetZ = 0F;
                this.ArmLeft02.zRot = 0F;
                this.ArmRight01.xRot = -1.22F;
                this.ArmRight01.yRot = 1.05F;
                this.ArmRight01.zRot = 0F;
                // this.ArmRight01.offsetZ = 0F;
                this.ArmRight02.zRot = 0F;
                // leg
                addk1 = 1.31F;
                addk2 = 1.22F;
                this.LegLeft01.yRot = -0.7F;
                this.LegLeft01.zRot = 0F;
                this.LegRight01.yRot = -0.87F;
                this.LegRight01.zRot = 0F;
            } else if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED) {
                // head
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.22F;
                this.Head.xRot = 1.5359F;
                // this.Head.offsetY = 0.25F;
                this.GlowHead.xRot = 1.5359F;
                // this.GlowHead.offsetY = 0.25F;
                // arm
                addk1 = 1.5359F;
                addk2 = 1.5359F;
                this.ArmLeft01.xRot = -1.5359F;
                this.ArmLeft01.zRot = 0F;
                // this.ArmLeft01.offsetZ = -0.18F;
                this.ArmRight01.xRot = -1.5359F;
                this.ArmRight01.zRot = 0F;
                // this.ArmRight01.offsetZ = -0.18F;

                // hat state 4
                if (fh4) {
                    this.HatBase.xRot = -1.8F;// -103
                    // this.HatBase.offsetY = 0.6F;
                    // this.HatBase.offsetZ = -0.3F;
                }
                // hat state 1
                else if (fh1) {
                    this.HatBase.xRot = 1.37F;// 78
                    // this.HatBase.offsetY = -0.45F;
                    // this.HatBase.offsetZ = -0.2F;
                }
                // hat state 3
                else if (fh3) {
                    this.HatBase.xRot = -0.85F;// -48
                    // this.HatBase.offsetY = 0.6F;
                    // this.HatBase.offsetZ = 0.07F;
                }
                // no hat or hat state 2
                else {
                    this.HatBase.xRot = 0F;
                    // this.HatBase.offsetY = 0F;
                    // this.HatBase.offsetZ = 0F;
                }
            } else {
                // hat state 4
                if (fh4) {
                    this.HatBase.xRot = -1.8F;// -103
                    // this.HatBase.offsetY = 0.2F;
                    // this.HatBase.offsetZ = 0.07F;
                }
                // hat state 1
                else if (fh1) {
                    this.HatBase.xRot = 1.37F;// 78
                    // this.HatBase.offsetY = -0.45F;
                    // this.HatBase.offsetZ = -0.2F;
                }
                // hat state 3
                else if (fh3) {
                    this.HatBase.xRot = -0.85F;// -48
                    // this.HatBase.offsetY = 0F;
                    // this.HatBase.offsetZ = 0.07F;
                }
                // no hat or hat state 2
                else {
                    this.HatBase.xRot = 0F;
                    // this.HatBase.offsetY = 0F;
                    // this.HatBase.offsetZ = 0F;
                }
                // head
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.22F;
                this.Head.xRot -= 0.5F;
                this.GlowHead.xRot -= 0.5F;
                // this.Head.offsetY = 0.25F;
                // this.GlowHead.offsetY = 0.25F;
                // arm
                addk1 = 1.5359F;
                addk2 = 1.5359F;
                this.ArmLeft01.xRot = -1.5359F;
                this.ArmLeft01.zRot = 0F;
                // this.ArmLeft01.offsetZ = -0.18F;
                this.ArmLeft02.zRot = 1.1868F;
                this.ArmRight01.xRot = -1.5359F;
                this.ArmRight01.zRot = 0F;
                // this.ArmRight01.offsetZ = -0.18F;
                this.ArmRight02.zRot = -1.1868F;
            }
        } // end if sitting

        // 攻擊動作
        if (ent.getAttackTick() > 30) {
            // tail head
            this.TailHead01.xRot = -0.6F;
            this.TailJaw01.xRot = 0.5F;
            this.TailHead01_1.xRot = -0.6F;
            this.TailJaw01_1.xRot = 0.5F;
            this.TailC01.xRot = -0.1F;
            this.TailC02.xRot = -0.1F;
            this.TailC01_1.xRot = -0.1F;
            this.TailC02_1.xRot = -0.1F;
            // tail body
            this.Tail01.xRot = 0.2F;
            this.Tail01.yRot = 1.2F;
            this.Tail02.xRot = 0.4F;
            this.Tail02.yRot = -0.5F;
            this.Tail03.xRot = 0.4F;
            this.Tail03.yRot = -0.32F;
            this.Tail04.xRot = 0.4F;
            this.Tail04.yRot = 0.4F;
            this.Tail05.xRot = 0.2F;
            this.Tail05.yRot = 0.4F;
            this.Tail06.xRot = 0.3F;
            this.Tail06.yRot = 0.4F;
            this.Tail07.xRot = 0.2F;
            this.Tail07.yRot = 0.4F;
            this.Tail08.xRot = 0.1F;
            this.Tail08.yRot = 0.3F;
            this.Tail09.xRot = 0.1F;
            this.Tail09.yRot = 0.3F;
            this.Tail01_1.xRot = -0.17F;
            this.Tail01_1.yRot = -1.5F;
            this.Tail02_1.xRot = 0.26F;
            this.Tail02_1.yRot = 0.52F;
            this.Tail03_1.xRot = 0.35F;
            this.Tail03_1.yRot = 0.52F;
            this.Tail04_1.xRot = 0.52F;
            this.Tail04_1.yRot = 0.3F;
            this.Tail05_1.xRot = 0.52F;
            this.Tail05_1.yRot = 0.17F;
            this.Tail06_1.xRot = 0.35F;
            this.Tail06_1.yRot = -0.35F;
            this.Tail07_1.xRot = 0.2F;
            this.Tail07_1.yRot = -0.17F;
            this.Tail08_1.xRot = 0.3F;
            this.Tail08_1.yRot = -0.17F;
            this.Tail09_1.xRot = 0.5F;
            this.Tail09_1.yRot = -0.17F;

            float ptick = ent.getAttackTick() + (1 - f2 + (int) f2);
            if (ent.getAttackTick() > 47) {
                this.TailHead01.xRot = (ptick - 50) * 0.3F - 0.1F;
                this.TailJaw01.xRot = (50 - ptick) * 0.3F + 0.1F;
            } else if (ent.getAttackTick() > 39) {
                this.TailHead01.xRot = -0.7F + (47 - ptick) * 0.06F;
                this.TailJaw01.xRot = 0.7F - (47 - ptick) * 0.06F;
            } else {
                this.TailHead01.xRot = -0.25F;
                this.TailJaw01.xRot = 0.25F;
            }

            this.TailHead01_1.xRot = this.TailHead01.xRot;
            this.TailJaw01_1.xRot = this.TailJaw01.xRot;
        }

        // swing arm
        float f6 = ent.getSwingTime(f2 - (int) f2);
        if (f6 != 0F) {
            float f7 = Mth.sin(f6 * f6 * (float) Math.PI);
            float f8 = Mth.sin(Mth.sqrt(f6) * (float) Math.PI);
            this.ArmRight01.xRot = -0.6F - f8 * 80.0F * ((float) Math.PI / 180F);
            this.ArmRight01.yRot = 0F - f7 * 20.0F * ((float) Math.PI / 180F) + 0.2F;
            this.ArmRight01.zRot = 0.2F - -f8 * 20.0F * ((float) Math.PI / 180F);
        }

        // leg motion
        this.LegLeft01.xRot = addk1;
        this.LegRight01.xRot = addk2;
    }
}
