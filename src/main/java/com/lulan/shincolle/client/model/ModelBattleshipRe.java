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

public class ModelBattleshipRe extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "bb_re"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Cloth;
    private final ModelPart Neck;
    private final ModelPart BoobR;
    private final ModelPart BoobL;
    private final ModelPart ArmLeft01;
    private final ModelPart ArmRight01;
    private final ModelPart ArmLeft02;
    private final ModelPart ArmRight02;
    private final ModelPart BagMain;
    private final ModelPart TailBase;
    private final ModelPart Butt;
    private final ModelPart Cloth2;
    private final ModelPart Head;
    private final ModelPart Ear01;
    private final ModelPart Ear02;
    private final ModelPart Hair;
    private final ModelPart Hair01;
    private final ModelPart HairU01;
    private final ModelPart Cap;
    private final ModelPart Cap2;
    private final ModelPart Ahoke;
    private final ModelPart BoobM;
    private final ModelPart PalmLeft;
    private final ModelPart PalmRight;
    private final ModelPart BagMain2;
    private final ModelPart BagStrap1;
    private final ModelPart BagStrap2;
    private final ModelPart Tail1;
    private final ModelPart TailBack0;
    private final ModelPart Tail2;
    private final ModelPart TailBack1;
    private final ModelPart Tail3;
    private final ModelPart TailBack2;
    private final ModelPart Tail4;
    private final ModelPart TailBack3;
    private final ModelPart Tail5;
    private final ModelPart TailBack4;
    private final ModelPart Tail6;
    private final ModelPart TailBack5;
    private final ModelPart TailHeadBase;
    private final ModelPart TailBack6;
    private final ModelPart TailJaw1;
    private final ModelPart TailHead1;
    private final ModelPart TailHeadCL1;
    private final ModelPart TailHeadCR1;
    private final ModelPart TailJawT01;
    private final ModelPart TailJaw2;
    private final ModelPart TailJaw3;
    private final ModelPart TailHead2;
    private final ModelPart TailHeadT01;
    private final ModelPart TailHeadC1;
    private final ModelPart TailHead3;
    private final ModelPart TailHeadC2;
    private final ModelPart TailHeadC3;
    private final ModelPart TailHeadC4;
    private final ModelPart TailHeadCL2;
    private final ModelPart TailHeadCL3;
    private final ModelPart TailHeadCR2;
    private final ModelPart TailHeadCR3;
    private final ModelPart LegRight;
    private final ModelPart LegLeft;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowNeck;
    private final ModelPart GlowHead;
    private final ModelPart GlowTailBase;
    private final ModelPart GlowTail1;
    private final ModelPart GlowTail2;
    private final ModelPart GlowTail3;
    private final ModelPart GlowTail4;
    private final ModelPart GlowTail5;
    private final ModelPart GlowTail6;
    private final ModelPart GlowTailHeadBase;
    private final ModelPart GlowTailHead1;
    private final ModelPart GlowTailJaw1;

    public ModelBattleshipRe(ModelPart root) {
        super();
        this.scale = 0.4F;
        this.offsetY = 0F;
        this.BodyMain = root.getChild("BodyMain");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.BoobL = this.BodyMain.getChild("BoobL");
        this.BagMain = this.BodyMain.getChild("BagMain");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.BoobR = this.BodyMain.getChild("BoobR");
        this.Butt = this.BodyMain.getChild("Butt");
        this.Cloth = this.BodyMain.getChild("Cloth");
        this.Neck = this.BodyMain.getChild("Neck");
        this.TailBase = this.BodyMain.getChild("TailBase");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.BagStrap2 = this.BagMain.getChild("BagStrap2");
        this.BagStrap1 = this.BagMain.getChild("BagStrap1");
        this.BagMain2 = this.BagMain.getChild("BagMain2");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.BoobM = this.BoobR.getChild("BoobM");
        this.LegLeft = this.Butt.getChild("LegLeft");
        this.LegRight = this.Butt.getChild("LegRight");
        this.Cloth2 = this.Cloth.getChild("Cloth2");
        this.Head = this.Neck.getChild("Head");
        this.Cap2 = this.Neck.getChild("Cap2");
        this.Tail1 = this.TailBase.getChild("Tail1");
        this.PalmLeft = this.ArmLeft02.getChild("PalmLeft");
        this.PalmRight = this.ArmRight02.getChild("PalmRight");
        this.Cap = this.Head.getChild("Cap");
        this.Ear01 = this.Head.getChild("Ear01");
        this.Ear02 = this.Head.getChild("Ear02");
        this.Hair = this.Head.getChild("Hair");
        this.Hair01 = this.Head.getChild("Hair01");
        this.HairU01 = this.Head.getChild("HairU01");
        this.Tail2 = this.Tail1.getChild("Tail2");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.Tail3 = this.Tail2.getChild("Tail3");
        this.Tail4 = this.Tail3.getChild("Tail4");
        this.Tail5 = this.Tail4.getChild("Tail5");
        this.Tail6 = this.Tail5.getChild("Tail6");
        this.TailHeadBase = this.Tail6.getChild("TailHeadBase");
        this.TailHeadCL1 = this.TailHeadBase.getChild("TailHeadCL1");
        this.TailHeadCR1 = this.TailHeadBase.getChild("TailHeadCR1");
        this.TailHead1 = this.TailHeadBase.getChild("TailHead1");
        this.TailJaw1 = this.TailHeadBase.getChild("TailJaw1");
        this.TailHeadCL2 = this.TailHeadCL1.getChild("TailHeadCL2");
        this.TailHeadCL3 = this.TailHeadCL1.getChild("TailHeadCL3");
        this.TailHeadCR2 = this.TailHeadCR1.getChild("TailHeadCR2");
        this.TailHeadCR3 = this.TailHeadCR1.getChild("TailHeadCR3");
        this.TailHeadC1 = this.TailHead1.getChild("TailHeadC1");
        this.TailHead3 = this.TailHead1.getChild("TailHead3");
        this.TailHead2 = this.TailHead1.getChild("TailHead2");
        this.TailJaw2 = this.TailJaw1.getChild("TailJaw2");
        this.TailJaw3 = this.TailJaw1.getChild("TailJaw3");
        this.TailHeadC2 = this.TailHeadC1.getChild("TailHeadC2");
        this.TailHeadC3 = this.TailHeadC1.getChild("TailHeadC3");
        this.TailHeadC4 = this.TailHeadC1.getChild("TailHeadC4");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowNeck = this.GlowBodyMain.getChild("GlowNeck");
        this.GlowTailBase = this.GlowBodyMain.getChild("GlowTailBase");
        this.GlowHead = this.GlowNeck.getChild("GlowHead");
        this.GlowTail1 = this.GlowTailBase.getChild("GlowTail1");
        this.GlowTail2 = this.GlowTail1.getChild("GlowTail2");
        this.GlowTail3 = this.GlowTail2.getChild("GlowTail3");
        this.GlowTail4 = this.GlowTail3.getChild("GlowTail4");
        this.GlowTail5 = this.GlowTail4.getChild("GlowTail5");
        this.GlowTail6 = this.GlowTail5.getChild("GlowTail6");
        this.GlowTailHeadBase = this.GlowTail6.getChild("GlowTailHeadBase");
        this.GlowTailHead1 = this.GlowTailHeadBase.getChild("GlowTailHead1");
        this.GlowTailJaw1 = this.GlowTailHeadBase.getChild("GlowTailJaw1");
        this.TailBack0 = this.GlowTailBase.getChild("TailBack0");
        this.TailBack1 = this.GlowTail1.getChild("TailBack1");
        this.TailBack2 = this.GlowTail2.getChild("TailBack2");
        this.TailBack3 = this.GlowTail3.getChild("TailBack3");
        this.TailBack4 = this.GlowTail4.getChild("TailBack4");
        this.TailBack5 = this.GlowTail5.getChild("TailBack5");
        this.TailBack6 = this.GlowTail6.getChild("TailBack6");
        this.TailHeadT01 = this.GlowTailHead1.getChild("TailHeadT01");
        this.TailJawT01 = this.GlowTailJaw1.getChild("TailJawT01");
        this.loadFaceParts(this.GlowHead);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 34)
                        .addBox(-7.0F, -9.0F, -4.0F, 14.0F, 15.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().mirror().texOffs(0, 57)
                        .addBox(0.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F),
                PartPose.offsetAndRotation(4.5F, -8.5F, -0.5F, 0.2617993877991494F, 0.0F, -0.4363323129985824F));

        PartDefinition armLeft02 = armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().mirror().texOffs(0, 57)
                        .addBox(-6.0F, 0.0F, -6.0F, 6.0F, 7.0F, 6.0F),
                PartPose.offset(6.0F, 10.0F, 3.0F));

        armLeft02.addOrReplaceChild("PalmLeft",
                CubeListBuilder.create().mirror().texOffs(0, 89)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F),
                PartPose.offset(-3.0F, 7.0F, -3.0F));

        bodyMain.addOrReplaceChild("BoobL",
                CubeListBuilder.create().mirror().texOffs(0, 80)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 4.0F),
                PartPose.offsetAndRotation(3.5F, -9.5F, -3.0F, -0.7853981633974483F, -0.12217304763960307F,
                        -0.08726646259971647F));

        PartDefinition bagMain = bodyMain.addOrReplaceChild("BagMain",
                CubeListBuilder.create().texOffs(37, 23)
                        .addBox(-8.0F, 0.0F, 0.0F, 14.0F, 12.0F, 7.0F),
                PartPose.offsetAndRotation(3.0F, -13.0F, 6.5F, -0.2617993877991494F, 0.0F, 0.08726646259971647F));

        bagMain.addOrReplaceChild("BagStrap2",
                CubeListBuilder.create().texOffs(82, 24)
                        .addBox(-3.0F, 0.0F, -15.0F, 3.0F, 10.0F, 15.0F),
                PartPose.offsetAndRotation(-5.0F, 1.0F, 2.0F, 0.3490658503988659F, 0.3490658503988659F,
                        0.13962634015954636F));

        bagMain.addOrReplaceChild("BagStrap1",
                CubeListBuilder.create().texOffs(103, 16)
                        .addBox(0.0F, 0.0F, -11.0F, 3.0F, 10.0F, 11.0F),
                PartPose.offsetAndRotation(3.5F, 1.0F, 0.5F, 0.2617993877991494F, -0.13962634015954636F,
                        -0.17453292519943295F));

        bagMain.addOrReplaceChild("BagMain2",
                CubeListBuilder.create().texOffs(36, 23)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 9.0F, 8.0F),
                PartPose.offsetAndRotation(-0.5F, 11.0F, -0.5F, 0.6981317007977318F, 0.0F, -0.2617993877991494F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().texOffs(0, 57)
                        .addBox(-6.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F),
                PartPose.offsetAndRotation(-4.5F, -8.5F, -0.5F, 0.2617993877991494F, 0.0F, 0.4363323129985824F));

        PartDefinition armRight02 = armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().texOffs(0, 57)
                        .addBox(0.0F, 0.0F, -6.0F, 6.0F, 7.0F, 6.0F),
                PartPose.offset(-6.0F, 10.0F, 3.0F));

        armRight02.addOrReplaceChild("PalmRight",
                CubeListBuilder.create().texOffs(0, 89)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F),
                PartPose.offsetAndRotation(3.0F, 7.0F, -3.0F, 0.0F, 0.02530727415391778F, 0.0F));

        PartDefinition boobR = bodyMain.addOrReplaceChild("BoobR",
                CubeListBuilder.create().texOffs(0, 80)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 4.0F),
                PartPose.offsetAndRotation(-3.5F, -9.5F, -3.0F, -0.7853981633974483F, 0.12217304763960307F,
                        0.08726646259971647F));

        boobR.addOrReplaceChild("BoobM",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F),
                PartPose.offsetAndRotation(4.2F, 4.5F, 0.3F, 0.7853981633974483F, 0.0F, -0.08726646259971647F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(106, 0)
                        .addBox(-8.0F, 4.0F, -5.0F, 16.0F, 8.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.0F));

        butt.addOrReplaceChild("LegLeft",
                CubeListBuilder.create().mirror().texOffs(0, 98)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 22.0F, 7.0F),
                PartPose.offsetAndRotation(4.5F, 11.0F, -2.0F, -0.22689280275926282F, 0.0F, 0.05235987755982988F));

        butt.addOrReplaceChild("LegRight",
                CubeListBuilder.create().texOffs(0, 98)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 22.0F, 7.0F),
                PartPose.offsetAndRotation(-4.5F, 11.0F, -2.0F, -0.22689280275926282F, 0.0F, -0.05235987755982988F));

        PartDefinition cloth = bodyMain.addOrReplaceChild("Cloth",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-8.0F, 0.0F, -4.5F, 16.0F, 14.0F, 9.0F),
                PartPose.offset(0.0F, -8.5F, 0.0F));

        cloth.addOrReplaceChild("Cloth2",
                CubeListBuilder.create().texOffs(50, 0)
                        .addBox(-8.5F, 0.0F, -5.0F, 17.0F, 12.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(21, 85)
                        .addBox(-7.5F, -1.5F, -7.0F, 15.0F, 5.0F, 11.0F),
                PartPose.offsetAndRotation(0.0F, -11.5F, 0.5F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(39, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, -0.17453292519943295F, 0.0F, 0.0F));

        head.addOrReplaceChild("Cap",
                CubeListBuilder.create().texOffs(204, 40)
                        .addBox(-8.0F, -17.0F, -2.0F, 16.0F, 17.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 0.6F, 2.0F, 0.2F, 0.0F, 0.0F));

        head.addOrReplaceChild("Ear01",
                CubeListBuilder.create().mirror().texOffs(136, 17)
                        .addBox(-1.5F, 0.0F, -6.0F, 3.0F, 6.0F, 6.0F),
                PartPose.offsetAndRotation(-3.5F, -14.5F, 5.7F, -0.6981F, 0.2618F, -0.1396F));

        head.addOrReplaceChild("Ear02",
                CubeListBuilder.create().texOffs(136, 17)
                        .addBox(-1.5F, 0.0F, -6.0F, 3.0F, 6.0F, 6.0F),
                PartPose.offsetAndRotation(3.5F, -14.5F, 5.7F, -0.6981F, -0.2618F, 0.1396F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(24, 61)
                        .addBox(-7.5F, -8.0F, -8.0F, 15.0F, 16.0F, 8.0F),
                PartPose.offset(0.0F, -7.3F, 0.0F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(28, 90)
                        .addBox(0.0F, -6.0F, -11.0F, 0.0F, 11.0F, 11.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, -4.0F, -0.1742F, 0.5235987755982988F, 0.0F));

        head.addOrReplaceChild("Hair01",
                CubeListBuilder.create().texOffs(186, 0)
                        .addBox(-7.0F, 0.0F, -12.0F, 14.0F, 9.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, -9.5F, 9.5F, 0.1257F, 0.0F, 0.0F));

        head.addOrReplaceChild("HairU01",
                CubeListBuilder.create().texOffs(189, 19)
                        .addBox(-8.0F, -14.7F, 0.0F, 16.0F, 15.0F, 6.0F),
                PartPose.offset(0.0F, -0.2F, -7.2F));

        neck.addOrReplaceChild("Cap2",
                CubeListBuilder.create().texOffs(206, 42)
                        .addBox(-8.0F, -15.0F, 0.0F, 16.0F, 15.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, -2.0F, -3.0F, -1.4F, 0.0F, 0.0F));

        PartDefinition tailBase = bodyMain.addOrReplaceChild("TailBase",
                CubeListBuilder.create().texOffs(208, 103)
                        .addBox(-6.0F, -6.0F, 0.0F, 12.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 7.5F, 0.0F, -0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition tail1 = tailBase.addOrReplaceChild("Tail1",
                CubeListBuilder.create().texOffs(208, 103)
                        .addBox(-6.0F, -6.0F, 0.0F, 12.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition tail2 = tail1.addOrReplaceChild("Tail2",
                CubeListBuilder.create().texOffs(208, 103)
                        .addBox(-6.0F, -6.0F, 0.0F, 12.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, 0.5235987755982988F, 0.0F, 0.0F));

        PartDefinition tail3 = tail2.addOrReplaceChild("Tail3",
                CubeListBuilder.create().texOffs(208, 103)
                        .addBox(-6.0F, -6.0F, 0.0F, 12.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, 0.5235987755982988F, 0.0F, 0.0F));

        PartDefinition tail4 = tail3.addOrReplaceChild("Tail4",
                CubeListBuilder.create().texOffs(208, 103)
                        .addBox(-6.0F, -6.0F, 0.0F, 12.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition tail5 = tail4.addOrReplaceChild("Tail5",
                CubeListBuilder.create().texOffs(208, 103)
                        .addBox(-6.0F, -6.0F, 0.0F, 12.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, -0.5235987755982988F, 0.0F, 0.0F));

        PartDefinition tail6 = tail5.addOrReplaceChild("Tail6",
                CubeListBuilder.create().texOffs(208, 103)
                        .addBox(-5.5F, -6.5F, 0.0F, 11.0F, 13.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, -0.5235987755982988F, 0.0F, 0.0F));

        PartDefinition tailHeadBase = tail6.addOrReplaceChild("TailHeadBase",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition tailHeadCL1 = tailHeadBase.addOrReplaceChild("TailHeadCL1",
                CubeListBuilder.create().texOffs(207, 80)
                        .addBox(0.0F, 0.0F, 0.0F, 5.0F, 6.0F, 7.0F),
                PartPose.offsetAndRotation(6.0F, -6.0F, 5.0F, 0.08726646259971647F, 0.17453292519943295F, 0.0F));

        tailHeadCL1.addOrReplaceChild("TailHeadCL2",
                CubeListBuilder.create().texOffs(207, 77)
                        .addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 10.0F),
                PartPose.offsetAndRotation(2.0F, 0.5F, 7.0F, 0.08726646259971647F, 0.17453292519943295F, 0.0F));

        tailHeadCL1.addOrReplaceChild("TailHeadCL3",
                CubeListBuilder.create().texOffs(207, 77)
                        .addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 10.0F),
                PartPose.offsetAndRotation(2.0F, 3.5F, 7.0F, -0.05235987755982988F, 0.17453292519943295F, 0.0F));

        PartDefinition tailHeadCR1 = tailHeadBase.addOrReplaceChild("TailHeadCR1",
                CubeListBuilder.create().texOffs(207, 80)
                        .addBox(-5.0F, 0.0F, 0.0F, 5.0F, 6.0F, 7.0F),
                PartPose.offsetAndRotation(-6.0F, -6.0F, 5.0F, 0.08726646259971647F, -0.17453292519943295F, 0.0F));

        tailHeadCR1.addOrReplaceChild("TailHeadCR2",
                CubeListBuilder.create().texOffs(207, 77)
                        .addBox(-2.0F, 0.0F, 0.0F, 2.0F, 2.0F, 10.0F),
                PartPose.offsetAndRotation(-2.0F, 0.5F, 7.0F, 0.08726646259971647F, -0.17453292519943295F, 0.0F));

        tailHeadCR1.addOrReplaceChild("TailHeadCR3",
                CubeListBuilder.create().texOffs(207, 77)
                        .addBox(-2.0F, 0.0F, 0.0F, 2.0F, 2.0F, 10.0F),
                PartPose.offsetAndRotation(-2.0F, 3.5F, 7.0F, -0.05235987755982988F, -0.17453292519943295F, 0.0F));

        PartDefinition tailHead1 = tailHeadBase.addOrReplaceChild("TailHead1",
                CubeListBuilder.create().texOffs(191, 70)
                        .addBox(-5.5F, 0.0F, -0.5F, 11.0F, 8.0F, 17.0F),
                PartPose.offsetAndRotation(0.0F, -8.5F, 4.0F, 0.13962634015954636F, 0.0F, 0.0F));

        PartDefinition tailHeadC1 = tailHead1.addOrReplaceChild("TailHeadC1",
                CubeListBuilder.create().texOffs(201, 78)
                        .addBox(-4.5F, 0.0F, 0.0F, 9.0F, 5.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, -3.5F, 0.0F, 0.3490658503988659F, 0.0F, 0.0F));

        tailHeadC1.addOrReplaceChild("TailHeadC2",
                CubeListBuilder.create().texOffs(207, 77)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 1.0F, 8.5F, 0.13962634015954636F, 0.0F, 0.0F));

        tailHeadC1.addOrReplaceChild("TailHeadC3",
                CubeListBuilder.create().texOffs(207, 77)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 10.0F),
                PartPose.offsetAndRotation(-2.8F, 1.0F, 8.5F, 0.13962634015954636F, -0.05235987755982988F, 0.0F));

        tailHeadC1.addOrReplaceChild("TailHeadC4",
                CubeListBuilder.create().texOffs(207, 77)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 10.0F),
                PartPose.offsetAndRotation(2.8F, 1.0F, 8.5F, 0.13962634015954636F, 0.05235987755982988F, 0.0F));

        tailHead1.addOrReplaceChild("TailHead3",
                CubeListBuilder.create().texOffs(200, 80)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 4.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 14.5F, 0.5235987755982988F, 0.0F, 0.0F));

        tailHead1.addOrReplaceChild("TailHead2",
                CubeListBuilder.create().texOffs(182, 68)
                        .addBox(-9.0F, 0.0F, 0.0F, 18.0F, 8.0F, 19.0F),
                PartPose.offsetAndRotation(0.0F, -1.5F, 4.5F, 0.13962634015954636F, 0.0F, 0.0F));

        PartDefinition tailJaw1 = tailHeadBase.addOrReplaceChild("TailJaw1",
                CubeListBuilder.create().texOffs(194, 106)
                        .addBox(-6.5F, 0.0F, 0.0F, 13.0F, 5.0F, 16.0F),
                PartPose.offsetAndRotation(0.0F, 3.0F, 5.0F, -0.17453292519943295F, 0.0F, 0.0F));

        tailJaw1.addOrReplaceChild("TailJaw2",
                CubeListBuilder.create().texOffs(197, 77)
                        .addBox(-5.0F, 0.0F, 0.0F, 10.0F, 5.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 2.0F, 8.0F, -0.17453292519943295F, 0.0F, 0.0F));

        tailJaw1.addOrReplaceChild("TailJaw3",
                CubeListBuilder.create().texOffs(207, 80)
                        .addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 15.5F, -0.10035643198967394F, 0.0F, 0.0F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -8.0F, 0.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -11.5F, 0.5F));

        PartDefinition glowHead = glowNeck.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -0.5F, 0.0F));
        addDefaultFaceParts(glowHead);

        PartDefinition glowTailBase = glowBodyMain.addOrReplaceChild("GlowTailBase",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 7.5F, 0.0F));

        PartDefinition glowTail1 = glowTailBase.addOrReplaceChild("GlowTail1",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition glowTail2 = glowTail1.addOrReplaceChild("GlowTail2",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition glowTail3 = glowTail2.addOrReplaceChild("GlowTail3",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition glowTail4 = glowTail3.addOrReplaceChild("GlowTail4",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition glowTail5 = glowTail4.addOrReplaceChild("GlowTail5",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition glowTail6 = glowTail5.addOrReplaceChild("GlowTail6",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 9.0F));

        // Glow tail fin parts (TailBack0-6)
        glowTailBase.addOrReplaceChild("TailBack0",
                CubeListBuilder.create().texOffs(163, 70)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 2.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.0F));

        glowTail1.addOrReplaceChild("TailBack1",
                CubeListBuilder.create().texOffs(163, 70)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 2.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.0F));

        glowTail2.addOrReplaceChild("TailBack2",
                CubeListBuilder.create().texOffs(163, 70)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 2.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.0F));

        glowTail3.addOrReplaceChild("TailBack3",
                CubeListBuilder.create().texOffs(163, 70)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 2.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.0F));

        glowTail4.addOrReplaceChild("TailBack4",
                CubeListBuilder.create().texOffs(163, 70)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 2.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.0F));

        glowTail5.addOrReplaceChild("TailBack5",
                CubeListBuilder.create().texOffs(163, 70)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 2.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.0F));

        glowTail6.addOrReplaceChild("TailBack6",
                CubeListBuilder.create().texOffs(163, 70)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 2.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -7.5F, 0.0F, 0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition glowTailHeadBase = glowTail6.addOrReplaceChild("GlowTailHeadBase",
                CubeListBuilder.create().texOffs(157, 96)
                        .addBox(-5.0F, -7.0F, 0.0F, 10.0F, 14.0F, 12.0F),
                PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition glowTailHead1 = glowTailHeadBase.addOrReplaceChild("GlowTailHead1",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -8.5F, 4.0F));

        // Glow decoration on tail head
        glowTailHead1.addOrReplaceChild("TailHeadT01",
                CubeListBuilder.create().texOffs(141, 29)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 4.5F, 4.5F, -0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition glowTailJaw1 = glowTailHeadBase.addOrReplaceChild("GlowTailJaw1",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 3.0F, 5.0F));

        // Glow decoration on tail jaw
        glowTailJaw1.addOrReplaceChild("TailJawT01",
                CubeListBuilder.create().texOffs(143, 46)
                        .addBox(-5.5F, 0.0F, 0.0F, 11.0F, 5.0F, 11.0F),
                PartPose.offsetAndRotation(0.0F, -3.0F, 4.0F, 0.17453292519943295F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 128);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                          float headPitch) {
        IShipEmotion ent = (IShipEmotion) entity;
        this.offsetY = 0F;
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

        boolean flag = !EmotionHelper.checkModelState(0, state); // hat
        this.Hair01.visible = !flag;
        this.HairU01.visible = !flag;
        this.Ear01.visible = !flag;
        this.Ear02.visible = !flag;
        this.Cap.visible = flag; // Cap inverted: visible when hat state OFF (original: isHidden = !flag)
        this.Cap2.visible = !flag;

        flag = !EmotionHelper.checkModelState(1, state); // bag
        this.BagMain.visible = !flag;

        flag = !EmotionHelper.checkModelState(2, state); // ear
        this.Ear01.visible = !flag;
        this.Ear02.visible = !flag;
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
        this.GlowTailBase.xRot = this.TailBase.xRot;
        this.GlowTailBase.yRot = this.TailBase.yRot;
        this.GlowTailBase.zRot = this.TailBase.zRot;
        this.GlowTail1.xRot = this.Tail1.xRot;
        this.GlowTail1.yRot = this.Tail1.yRot;
        this.GlowTail1.zRot = this.Tail1.zRot;
        this.GlowTail2.xRot = this.Tail2.xRot;
        this.GlowTail2.yRot = this.Tail2.yRot;
        this.GlowTail2.zRot = this.Tail2.zRot;
        this.GlowTail3.xRot = this.Tail3.xRot;
        this.GlowTail3.yRot = this.Tail3.yRot;
        this.GlowTail3.zRot = this.Tail3.zRot;
        this.GlowTail4.xRot = this.Tail4.xRot;
        this.GlowTail4.yRot = this.Tail4.yRot;
        this.GlowTail4.zRot = this.Tail4.zRot;
        this.GlowTail5.xRot = this.Tail5.xRot;
        this.GlowTail5.yRot = this.Tail5.yRot;
        this.GlowTail5.zRot = this.Tail5.zRot;
        this.GlowTail6.xRot = this.Tail6.xRot;
        this.GlowTail6.yRot = this.Tail6.yRot;
        this.GlowTail6.zRot = this.Tail6.zRot;
        this.GlowTailHeadBase.xRot = this.TailHeadBase.xRot;
        this.GlowTailHeadBase.yRot = this.TailHeadBase.yRot;
        this.GlowTailHeadBase.zRot = this.TailHeadBase.zRot;
        this.GlowTailHead1.xRot = this.TailHead1.xRot;
        this.GlowTailHead1.yRot = this.TailHead1.yRot;
        this.GlowTailHead1.zRot = this.TailHead1.zRot;
        this.GlowTailJaw1.xRot = this.TailJaw1.xRot;
        this.GlowTailJaw1.yRot = this.TailJaw1.yRot;
        this.GlowTailJaw1.zRot = this.TailJaw1.zRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        // [PORT] 1.10.2 -> 1.20.1: restore legacy dead-pose grounding offset.
        this.offsetY += 1.13F;

        this.setFaceHungry(ent);

        // 頭部
        this.Head.xRot = 0F;
        this.Head.yRot = 0F;
        // 胸部
        this.BoobL.xRot = -0.73F;
        this.BoobR.xRot = -0.73F;
        // Body
        this.Ahoke.yRot = 0.5236F;
        this.Head.xRot -= 0.5236F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.xRot = 1.5708F;
        this.Cloth2.xRot = -0.0524F;
        // arm
        this.ArmLeft01.xRot = -2.9671F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = 0.0349F;
        this.ArmLeft02.zRot = 0F;
        this.ArmRight01.xRot = -2.9671F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = -0.0349F;
        this.ArmRight02.zRot = 0F;
        // bag
        this.BagStrap1.xRot = 0.2618F;
        this.BagStrap1.yRot = -0.1396F;
        this.BagStrap1.zRot = -0.1745F;
        this.BagStrap2.xRot = 0.3491F;
        this.BagStrap2.yRot = 0.3491F;
        // leg
        this.LegLeft.xRot = -0.3491F;
        this.LegRight.xRot = -0.3491F;
        this.LegLeft.yRot = 0F;
        this.LegRight.yRot = 0F;
        // tail
        this.TailBase.xRot = -0.4F;
        this.TailBase.yRot = -0.8F;// Mth.cos(-f2 * 0.1F) * 0.1F;
        this.TailBase.zRot = 0F;// Mth.cos(-f2 * 0.1F) * 0.05F;
        this.Tail1.xRot = -0.3F;
        this.Tail1.yRot = -0.35F;// Mth.cos(-f2 * 0.1F + 0.7F) * 0.2F;
        this.Tail1.zRot = 0F;// -Mth.cos(-f2 * 0.1F + 0.7F) * 0.05F;
        this.Tail2.xRot = -0.35F;
        this.Tail2.yRot = -0.3F;// Mth.cos(-f2 * 0.1F + 1.4F) * 0.3F;
        this.Tail2.zRot = 0F;// -Mth.cos(-f2 * 0.1F + 1.4F) * 0.05F;
        this.Tail3.xRot = -0.4F;
        this.Tail3.yRot = -0.2F;// Mth.cos(-f2 * 0.1F + 2.1F) * 0.4F;
        this.Tail3.zRot = 0F;// -Mth.cos(-f2 * 0.1F + 2.1F) * 0.05F;
        this.Tail4.xRot = -0.25F;
        this.Tail4.yRot = 0.2F;// Mth.cos(-f2 * 0.1F + 2.8F) * 0.5F;
        this.Tail4.zRot = 0F;// Mth.cos(-f2 * 0.1F + 2.8F) * 0.025F;
        this.Tail5.xRot = 0.25F;
        this.Tail5.yRot = 0.2F;// Mth.cos(-f2 * 0.1F + 3.5F) * 0.55F;
        this.Tail5.zRot = 0F;// Mth.cos(-f2 * 0.1F + 3.5F) * 0.05F;
        this.Tail6.xRot = 0.35F;
        this.Tail6.yRot = 0.2F;// Mth.cos(-f2 * 0.1F + 4.2F) * 0.6F;
        this.Tail6.zRot = 0F;// Mth.cos(-f2 * 0.1F + 4.2F) * 0.05F;
        this.TailHeadBase.xRot = 0.4F;
        this.TailHeadBase.yRot = 0F;// Mth.cos(-f2 * 0.1F + 4.9F) * 0.65F;
        this.TailHeadBase.zRot = 0F;// Mth.cos(-f2 * 0.1F + 4.9F) * 0.025F;
        this.TailHead1.xRot = 0.2618F;
        this.TailJaw1.xRot = -0.7F;
        this.Hair01.visible = false;
        this.Ear01.visible = false;
        this.Ear02.visible = false;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float angleX = Mth.cos(f2 * 0.08F);
        float addk1;
        float addk2;

        // [PORT] 1.10.2 -> 1.20.1: restore base standing height offset.
        this.offsetY += 2.18F; // Was 0.63F in 1.10.2 but this caused her to float above ground
        // 水上漂浮
        if (ent.getShipDepth(0) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        // leg move parm
        addk1 = Mth.cos(f * 0.7F) * f1;
        addk2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;

        // 頭部
        this.Head.xRot = f4 * 0.014F;
        this.Head.yRot = f3 * 0.01F;
        // 胸部
        this.BoobL.xRot = -angleX * 0.06F - 0.73F;
        this.BoobR.xRot = -angleX * 0.06F - 0.73F;
        // Body
        this.Ahoke.yRot = angleX * 0.25F + 0.5236F;
        this.Head.xRot -= 0.5236F;
        this.Cap2.xRot = -1.4F;
        this.BodyMain.xRot = 0.0873F;
        this.BodyMain.yRot = 0F;
        this.Cloth2.xRot = -0.0524F;
        // arm
        this.ArmLeft01.xRot = 0.2618F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = angleX * 0.1F - 0.5236F;
        this.ArmLeft02.zRot = 0F;
        this.ArmRight01.xRot = 0.2618F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = -angleX * 0.1F + 0.5236F;
        this.ArmRight02.zRot = 0F;
        // bag
        this.BagStrap1.xRot = 0.2618F;
        this.BagStrap1.yRot = -0.1396F;
        this.BagStrap1.zRot = -0.1745F;
        this.BagStrap2.xRot = 0.3491F;
        this.BagStrap2.yRot = 0.3491F;
        // leg
        addk1 -= 0.2618F;
        addk2 -= 0.2618F;
        this.LegLeft.yRot = 0F;
        this.LegRight.yRot = 0F;
        // tail
        this.TailBase.xRot = -0.5236F;
        this.TailBase.yRot = Mth.cos(-f2 * 0.1F) * 0.1F;
        this.TailBase.zRot = 0F;// Mth.cos(-f2 * 0.1F) * 0.1F;
        this.Tail1.xRot = 0.5236F;
        this.Tail1.yRot = Mth.cos(-f2 * 0.1F + 0.7F) * 0.1F;
        this.Tail1.zRot = 0F;// -Mth.cos(-f2 * 0.1F + 0.7F) * 0.1F;
        this.Tail2.xRot = 0.5236F;
        this.Tail2.yRot = Mth.cos(-f2 * 0.1F + 1.4F) * 0.15F;
        this.Tail2.zRot = 0F;// -Mth.cos(-f2 * 0.1F + 1.4F) * 0.1F;
        this.Tail3.xRot = 0.5236F;
        this.Tail3.yRot = Mth.cos(-f2 * 0.1F + 2.1F) * 0.2F;
        this.Tail3.zRot = 0F;// -Mth.cos(-f2 * 0.1F + 2.1F) * 0.1F;
        this.Tail4.xRot = 0.5236F;
        this.Tail4.yRot = Mth.cos(-f2 * 0.1F + 2.8F) * 0.25F;
        this.Tail4.zRot = 0F;// -Mth.cos(-f2 * 0.1F + 2.8F) * 0.1F;
        this.Tail5.xRot = -0.5236F;
        this.Tail5.yRot = Mth.cos(-f2 * 0.1F + 3.5F) * 0.3F;
        this.Tail5.zRot = 0F;// Mth.cos(-f2 * 0.1F + 3.5F) * 0.1F;
        this.Tail6.xRot = -0.5236F;
        this.Tail6.yRot = Mth.cos(-f2 * 0.1F + 4.2F) * 0.35F;
        this.Tail6.zRot = 0F;// Mth.cos(-f2 * 0.1F + 4.2F) * 0.1F;
        this.TailHeadBase.xRot = -0.5236F;
        this.TailHeadBase.yRot = Mth.cos(-f2 * 0.1F + 4.9F) * 0.4F;
        this.TailHeadBase.zRot = 0F;// Mth.cos(-f2 * 0.1F + 4.9F) * 0.1F;
        this.TailHead1.xRot = 0.1745F;
        this.TailJaw1.xRot = angleX * 0.1F - 0.15F;

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

        if (ent.getIsSprinting() || f1 > 0.9F) {
            // 奔跑動作
            this.setFaceHappy(ent);
            float t2 = ent.getTickExisted() & 1023;
            // change run type base on tickExisted
            if (t2 > 700) { // run type 1
                // 高度
                this.offsetY += 0.05F;
                // 手臂晃動
                this.ArmLeft01.xRot = Mth.cos(f * 0.8F) * 0.1F - 2.0944F;
                this.ArmLeft01.yRot = -0.5236F;
                this.ArmLeft01.zRot = 0F;
                this.ArmRight01.xRot = -Mth.cos(f * 0.8F) * 0.1F - 2.0944F;
                this.ArmRight01.yRot = 0.5236F;
                this.ArmRight01.zRot = 0F;
                // 頭部角度
                this.Head.xRot *= 0.75F;
                this.Head.xRot -= 0.5236F;
                this.Cap2.xRot = -1.74F;
                // 身體角度
                this.BodyMain.xRot = 0.5236F;
                this.BodyMain.yRot = 3.1416F;
                this.Cloth2.xRot = -0.7854F;
                // 腿擺動
                addk1 = addk1 * 0.1F - 1.2708F;
                addk2 = addk2 * 0.1F - 1.2708F;
                this.LegLeft.yRot = -0.2618F;
                this.LegRight.yRot = 0.2618F;
                // bag
                this.BagStrap1.xRot = 0.0872F;
                this.BagStrap1.yRot = 0F;
                this.BagStrap1.zRot = -0.1745F;
                this.BagStrap2.xRot = 0.0872F;
                this.BagStrap2.yRot = 0.3491F;
                // tail
                // X旋轉過, 要繼續轉Y時, 就要補上Z修正
                // X越大, Z修正要越大, 且跟X角度反號, 具體角度需自行觀察
                this.TailBase.xRot = -1.3F;
                this.TailBase.yRot = -Mth.cos(f * 0.25F - 5.0F) * 0.2F * f1;
                this.TailBase.zRot = Mth.cos(f * 0.25F - 5.0F) * 0.4F * f1;
                this.Tail1.xRot = 0.2618F;
                this.Tail1.yRot = -Mth.cos(f * 0.25F - 4.2F) * 0.3F * f1;
                this.Tail1.zRot = -Mth.cos(f * 0.25F - 4.2F) * 0.1F * f1;
                this.Tail2.xRot = 0.2618F;
                this.Tail2.yRot = -Mth.cos(f * 0.25F - 3.5F) * 0.4F * f1;
                this.Tail2.zRot = -Mth.cos(f * 0.25F - 3.5F) * 0.1F * f1;
                this.Tail3.xRot = 0.1745F;
                this.Tail3.yRot = -Mth.cos(f * 0.25F - 2.8F) * 0.5F * f1;
                this.Tail3.zRot = 0F;// Mth.cos(f * 0.3F - 2.8F) * 0.05F * f1;
                this.Tail4.xRot = 0.1745F;
                this.Tail4.yRot = -Mth.cos(f * 0.25F - 2.1F) * 0.5F * f1;
                this.Tail4.zRot = 0F;// Mth.cos(f * 0.3F - 2.1F) * 0.05F * f1;
                this.Tail5.xRot = 0.0873F;
                this.Tail5.yRot = -Mth.cos(f * 0.25F - 1.4F) * 0.4F * f1;
                this.Tail5.zRot = 0F;// Mth.cos(f * 0.3F - 1.4F) * 0.02F * f1;
                this.Tail6.xRot = 0.0873F;
                this.Tail6.yRot = -Mth.cos(f * 0.25F - 0.7F) * 0.3F * f1;
                this.Tail6.zRot = 0F;// Mth.cos(f * 0.3F - 0.7F) * 0.02F * f1;
                this.TailHeadBase.xRot = -0.0873F;
                this.TailHeadBase.yRot = -Mth.cos(f * 0.25F) * 0.2F * f1;
                this.TailHeadBase.zRot = 0F;// Mth.cos(f * 0.3F) * 0.02F * f1;
                this.TailHead1.xRot = 0.3F;
                this.TailJaw1.xRot = angleX * 0.2F - 0.3F;
            } else if (t2 > 400) { // run type 2
                // 高度
                this.offsetY += 0.05F;
                // 手臂晃動
                this.ArmLeft01.xRot = -1.0472F;
                this.ArmLeft01.yRot = 0.2618F;
                this.ArmLeft01.zRot = 0F;
                this.ArmRight01.xRot = -2.7925F;
                this.ArmRight01.yRot = 0F;
                this.ArmRight01.zRot = f3 / -57F;
                // 頭部角度
                this.Head.xRot *= 0.75F;
                this.Head.xRot -= 1.2217F;
                this.Cap2.xRot = -1.74F;
                // 身體角度
                this.BodyMain.xRot = 1.2217F;
                this.Cloth2.xRot = -0.3491F;
                // 腿擺動
                addk1 = -1.0472F;
                addk2 = -1.0472F;
                this.LegLeft.yRot = -0.3491F;
                this.LegRight.yRot = 0.3491F;
                // bag
                this.BagStrap1.xRot = 0.2618F;
                this.BagStrap1.yRot = 0F;
                this.BagStrap1.zRot = 0F;
                this.BagStrap2.xRot = 0.3491F;
                this.BagStrap2.yRot = 0.3491F;
                // tail
                this.TailBase.xRot = 1.0472F;
                this.TailBase.yRot = 0F;
                this.TailBase.zRot = 3.1415F;
                this.Tail1.xRot = 0.7854F;
                this.Tail1.yRot = 0F;
                this.Tail1.zRot = 0F;
                this.Tail2.xRot = 0.7854F;
                this.Tail2.yRot = 0F;
                this.Tail2.zRot = 0F;
                this.Tail3.xRot = 0.7854F;
                this.Tail3.yRot = 0F;
                this.Tail3.zRot = 0F;
                this.Tail4.xRot = 0.7854F;
                this.Tail4.yRot = 0F;
                this.Tail4.zRot = 0F;
                this.Tail5.xRot = 0.5236F;
                this.Tail5.yRot = 0F;
                this.Tail5.zRot = 0F;
                this.Tail6.xRot = -0.2618F;
                this.Tail6.yRot = 0F;
                this.Tail6.zRot = 0F;
                this.TailHeadBase.xRot = 0F;
                this.TailHeadBase.yRot = 0F;
                this.TailHeadBase.zRot = 0F;
                this.TailHead1.xRot = 0.1745F;
                this.TailJaw1.xRot = angleX * 0.15F - 0.3F;
            } else { // run type 3
                // 高度
                this.offsetY += 0.1F;
                // 手臂晃動
                this.ArmLeft01.xRot = Mth.cos(f * 0.8F) * 0.1F + 0.6981F;
                this.ArmLeft01.yRot = 0F;
                this.ArmLeft01.zRot = -0.6981F;
                this.ArmRight01.xRot = Mth.cos(f * 0.8F) * 0.1F + 0.6981F;
                this.ArmRight01.yRot = 0F;
                this.ArmRight01.zRot = 0.6981F;
                // 頭部角度
                this.Head.xRot *= 0.75F;
                this.Head.xRot -= 1.0472F;
                this.Cap2.xRot = -1.74F;
                // 身體角度
                this.BodyMain.xRot = 0.8727F;
                this.Cloth2.xRot = -0.5236F;
                // 腿擺動
                addk1 -= 0.5F;
                addk2 -= 0.5F;
                this.LegLeft.yRot = 0F;
                this.LegRight.yRot = 0F;
                // bag
                this.BagStrap1.xRot = 0.15F;
                this.BagStrap1.yRot = -1.0472F;
                this.BagStrap1.zRot = 0F;
                this.BagStrap2.xRot = 0.3491F;
                this.BagStrap2.yRot = 1.0472F;
                // tail
                this.TailBase.xRot = -0.7F;
                this.TailBase.yRot = -Mth.cos(-f * 0.3F) * 0.2F * f1;
                this.TailBase.zRot = Mth.cos(-f * 0.3F) * 0.3F * f1;
                this.Tail1.xRot = 0.2618F;
                this.Tail1.yRot = -Mth.cos(-f * 0.3F + 0.7F) * 0.2F * f1;
                this.Tail1.zRot = -Mth.cos(-f * 0.3F + 0.7F) * 0.1F * f1;
                this.Tail2.xRot = 0.2618F;
                this.Tail2.yRot = -Mth.cos(-f * 0.3F + 1.4F) * 0.3F * f1;
                this.Tail2.zRot = -Mth.cos(-f * 0.3F + 1.4F) * 0.1F * f1;
                this.Tail3.xRot = -0.2618F;
                this.Tail3.yRot = -Mth.cos(-f * 0.3F + 2.2F) * 0.3F * f1;
                this.Tail3.zRot = Mth.cos(-f * 0.3F + 2.2F) * 0.1F * f1;
                this.Tail4.xRot = -0.2618F;
                this.Tail4.yRot = -Mth.cos(-f * 0.3F + 2.8F) * 0.4F * f1;
                this.Tail4.zRot = Mth.cos(-f * 0.3F + 2.8F) * 0.1F * f1;
                this.Tail5.xRot = -0.2618F;
                this.Tail5.yRot = -Mth.cos(-f * 0.3F + 3.5F) * 0.4F * f1;
                this.Tail5.zRot = Mth.cos(-f * 0.3F + 3.5F) * 0.1F * f1;
                this.Tail6.xRot = -0.2618F;
                this.Tail6.yRot = -Mth.cos(-f * 0.3F + 4.2F) * 0.5F * f1;
                this.Tail6.zRot = Mth.cos(-f * 0.3F + 4.2F) * 0.1F * f1;
                this.TailHeadBase.xRot = 0.2618F;
                this.TailHeadBase.yRot = -Mth.cos(-f * 0.3F + 4.9F) * 0.6F * f1;
                this.TailHeadBase.zRot = -Mth.cos(-f * 0.3F + 4.9F) * 0.1F * f1;
                this.TailHead1.xRot = 0.1745F;
                this.TailJaw1.xRot = angleX * 0.15F - 0.3F;
            }
        }

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        if (ent.getIsSneaking()) { // 潛行, 蹲下動作
            // 高度
            this.offsetY += 0.1F;
            // 手臂晃動
            this.ArmLeft01.xRot = 0.5236F;
            this.ArmLeft01.yRot = 0F;
            this.ArmLeft01.zRot = -0.5236F;
            this.ArmRight01.xRot = 0.5236F;
            this.ArmRight01.yRot = 0F;
            this.ArmRight01.zRot = 0.5236F;
            // 頭部角度
            this.Head.xRot = -1.2217F;
            // 身體角度
            this.BodyMain.xRot = 1.0472F;
            this.Cloth2.xRot = -0.5236F;
            // 腿擺動
            addk1 = addk1 - 0.95F;
            addk2 = addk2 - 0.95F;
            this.LegLeft.yRot = 0F;
            this.LegRight.yRot = 0F;
            // bag
            this.BagStrap1.xRot = 0.15F;
            this.BagStrap1.yRot = -1.0472F;
            this.BagStrap1.zRot = 0F;
            this.BagStrap2.xRot = 0.3491F;
            this.BagStrap2.yRot = 1.0472F;
            // tail
            this.TailBase.xRot = 0.7F;
            this.TailBase.yRot = 0F;
            this.TailBase.zRot = 3.1416F;
            this.Tail1.xRot = -0.2618F;
            this.Tail1.yRot = 0F;
            this.Tail1.zRot = 0F;
            this.Tail2.xRot = -0.5236F;
            this.Tail2.yRot = 0F;
            this.Tail2.zRot = 0F;
            this.Tail3.xRot = -0.2618F;
            this.Tail3.yRot = 0F;
            this.Tail3.zRot = 0F;
            this.Tail4.xRot = -0.2618F;
            this.Tail4.yRot = 0F;
            this.Tail4.zRot = 0F;
            this.Tail5.xRot = -0.5236F;
            this.Tail5.yRot = 0F;
            this.Tail5.zRot = 0F;
            this.Tail6.xRot = -0.5236F;
            this.Tail6.yRot = 0F;
            this.Tail6.zRot = 0F;
            this.TailHeadBase.xRot = -0.2618F;
            this.TailHeadBase.yRot = 0F;
            this.TailHeadBase.zRot = 0F;
            this.TailHead1.xRot = 0.1745F;
            this.TailJaw1.xRot = -0.2F;
        } // end if sneaking

        // 騎乘動作
        if (ent.getIsSitting() || ent.getIsRiding()) {
            this.Cap2.visible = false;

            if ((ent.getTickExisted() & 1023) > 512) {
                if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                    this.offsetY += 0.13F;
                    // Body
                    this.Head.xRot += 0.3F;
                    this.BodyMain.xRot = -0.3F;
                    this.Cloth2.xRot = -0.3F;
                    // arm
                    this.ArmLeft01.xRot = 2.3F;
                    this.ArmLeft01.yRot = 0F;
                    this.ArmLeft01.zRot = 0.2F;
                    this.ArmLeft02.zRot = 1F;
                    this.ArmRight01.xRot = 2.3F;
                    this.ArmRight01.yRot = 0F;
                    this.ArmRight01.zRot = -0.2F;
                    this.ArmRight02.zRot = -1F;

                    // arm special
                    float parTick = f2 - (int) f2 + (ent.getTickExisted() & 255);

                    if (parTick < 30F) {
                        float az = Mth.sin(parTick * 0.033F * 1.5708F) * 1.6F;
                        float az1 = az * 1.6F;

                        this.setFaceHappy(ent);
                        // arm
                        this.ArmLeft01.zRot = 0.2F + az;
                        this.ArmLeft02.zRot = 1F - az1;
                        if (this.ArmLeft02.zRot < 0F)
                            this.ArmLeft02.zRot = 0F;
                        this.ArmRight01.zRot = -0.2F - az;
                        this.ArmRight02.zRot = -1F + az1;
                        if (this.ArmRight02.zRot > 0F)
                            this.ArmRight02.zRot = 0F;
                    } else if (parTick < 45F) {
                        this.setFaceHappy(ent);
                        // arm
                        this.ArmLeft01.zRot = 1.8F;
                        this.ArmLeft02.zRot = 0F;
                        this.ArmRight01.zRot = -1.8F;
                        this.ArmRight02.zRot = 0F;
                    } else if (parTick < 53F) {
                        float az = Mth.cos((parTick - 45F) * 0.125F * 1.5708F);
                        float az1 = az * 1.6F;

                        // arm
                        this.ArmLeft01.zRot = 0.2F + az1;
                        this.ArmLeft02.zRot = 1F - az;
                        this.ArmRight01.zRot = -0.2F - az1;
                        this.ArmRight02.zRot = -1F + az;
                    }

                    // bag
                    this.BagStrap1.xRot = 0.6F;
                    this.BagStrap1.yRot = 0F;
                    this.BagStrap1.zRot = 0F;
                    this.BagStrap2.xRot = 1.0472F;
                    this.BagStrap2.yRot = 1.3963F;
                    // leg
                    addk1 = angleX * 0.1F - 0.9F;
                    addk2 = -angleX * 0.1F - 0.9F;
                    this.LegLeft.yRot = -0.2F;
                    this.LegRight.yRot = 0.2F;
                    // tail
                    this.TailBase.xRot = -1.0F;
                    this.TailBase.yRot = 0.2618F;
                    this.TailBase.zRot = 0F;
                    this.Tail1.xRot = 0.6981F;
                    this.Tail1.yRot = 0.0872F;
                    this.Tail1.zRot = 0F;
                    this.Tail2.xRot = 0.5236F;
                    this.Tail2.yRot = 0.0872F;
                    this.Tail2.zRot = 0.1745F;
                    this.Tail3.xRot = 0F;
                    this.Tail3.yRot = 0.6981F;
                    this.Tail3.zRot = 0F;
                    this.Tail4.xRot = 0F;
                    this.Tail4.yRot = 0.6981F;
                    this.Tail4.zRot = 0F;
                    this.Tail5.xRot = 0F;
                    this.Tail5.yRot = 0.5236F;
                    this.Tail5.zRot = 0F;
                    this.Tail6.xRot = 0F;
                    this.Tail6.yRot = 0.5236F;
                    this.Tail6.zRot = 0F;
                    this.TailHeadBase.xRot = 0.2618F;
                    this.TailHeadBase.yRot = 0.5236F;
                    this.TailHeadBase.zRot = 0F;
                    this.TailHead1.xRot = 0.2618F;
                    this.TailJaw1.xRot = angleX * 0.1F - 0.2618F;
                } else {
                    this.offsetY += 0.51F;
                    // Body
                    this.Head.xRot *= 0.8F;
                    this.Head.xRot -= 1.8F;
                    this.Head.yRot *= 0.5F;
                    this.BodyMain.xRot = 1.5708F;
                    this.Cloth2.xRot = -0.0524F;
                    // arm
                    this.ArmLeft01.xRot = -2.9671F;
                    this.ArmLeft01.yRot = 0F;
                    this.ArmLeft01.zRot = 0.0349F;
                    this.ArmLeft02.zRot = 1.3962F;
                    this.ArmRight01.xRot = -2.9671F;
                    this.ArmRight01.yRot = 0F;
                    this.ArmRight01.zRot = -0.0349F;
                    this.ArmRight02.zRot = -1.3962F;
                    // bag
                    this.BagStrap1.xRot = 0.2618F;
                    this.BagStrap1.yRot = -0.1396F;
                    this.BagStrap1.zRot = -0.1745F;
                    this.BagStrap2.xRot = 0.3491F;
                    this.BagStrap2.yRot = 0.3491F;
                    // leg
                    addk1 = -0.3491F;
                    addk2 = -0.3491F;
                    this.LegLeft.yRot = 0F;
                    this.LegRight.yRot = 0F;
                    // tail
                    this.TailBase.xRot = -0.7F;
                    this.TailBase.yRot = Mth.cos(-f2 * 0.1F) * 0.1F;
                    this.TailBase.zRot = Mth.cos(-f2 * 0.1F) * 0.05F;
                    this.Tail1.xRot = 0.35F;
                    this.Tail1.yRot = Mth.cos(-f2 * 0.1F + 0.7F) * 0.2F;
                    this.Tail1.zRot = -Mth.cos(-f2 * 0.1F + 0.7F) * 0.05F;
                    this.Tail2.xRot = 0.35F;
                    this.Tail2.yRot = Mth.cos(-f2 * 0.1F + 1.4F) * 0.3F;
                    this.Tail2.zRot = -Mth.cos(-f2 * 0.1F + 1.4F) * 0.05F;
                    this.Tail3.xRot = 0.35F;
                    this.Tail3.yRot = Mth.cos(-f2 * 0.1F + 2.1F) * 0.4F;
                    this.Tail3.zRot = -Mth.cos(-f2 * 0.1F + 2.1F) * 0.05F;
                    this.Tail4.xRot = -0.2618F;
                    this.Tail4.yRot = Mth.cos(-f2 * 0.1F + 2.8F) * 0.5F;
                    this.Tail4.zRot = Mth.cos(-f2 * 0.1F + 2.8F) * 0.025F;
                    this.Tail5.xRot = -0.35F;
                    this.Tail5.yRot = Mth.cos(-f2 * 0.1F + 3.5F) * 0.55F;
                    this.Tail5.zRot = Mth.cos(-f2 * 0.1F + 3.5F) * 0.05F;
                    this.Tail6.xRot = -0.35F;
                    this.Tail6.yRot = Mth.cos(-f2 * 0.1F + 4.2F) * 0.6F;
                    this.Tail6.zRot = Mth.cos(-f2 * 0.1F + 4.2F) * 0.05F;
                    this.TailHeadBase.xRot = -0.15F;
                    this.TailHeadBase.yRot = Mth.cos(-f2 * 0.1F + 4.9F) * 0.65F;
                    this.TailHeadBase.zRot = Mth.cos(-f2 * 0.1F + 4.9F) * 0.025F;
                    this.TailHead1.xRot = 0.2618F;
                    this.TailJaw1.xRot = angleX * 0.1F - 0.15F;
                }
            } else {
                this.setFace(1);
                // 高度
                this.offsetY += 0.17F;
                // 手臂晃動
                this.ArmLeft01.xRot = -1.7F;
                this.ArmLeft01.yRot = -0.1F;
                this.ArmLeft01.zRot = 0F;
                this.ArmRight01.xRot = -1.8F;
                this.ArmRight01.yRot = 0.1F;
                this.ArmRight01.zRot = 0F;
                // 頭部角度
                this.Head.xRot = -1.5F;
                this.Head.yRot = 0F;
                this.Head.zRot = 0.7F;
                this.Cap2.xRot = -1.74F;
                // 身體角度
                this.BodyMain.xRot = 1.8F;
                this.Cloth2.xRot = -0.3491F;
                // 腿擺動
                addk1 = -1.8F;
                addk2 = -1.8F;
                this.LegLeft.yRot = -0.23F;
                this.LegRight.yRot = 0.23F;
                // bag
                this.BagStrap1.xRot = 0.2618F;
                this.BagStrap1.yRot = 0F;
                this.BagStrap1.zRot = 0F;
                this.BagStrap2.xRot = 0.3491F;
                this.BagStrap2.yRot = 0.3491F;
                // tail
                this.TailBase.xRot = 1.6F;
                this.TailBase.yRot = 0F;
                this.TailBase.zRot = 3.1415F;
                this.Tail1.xRot = 0.8F;
                this.Tail1.yRot = 0F;
                this.Tail1.zRot = 0F;
                this.Tail2.xRot = 0.8F;
                this.Tail2.yRot = 0F;
                this.Tail2.zRot = 0F;
                this.Tail3.xRot = 0.9F;
                this.Tail3.yRot = 0F;
                this.Tail3.zRot = 0F;
                this.Tail4.xRot = 0.9F;
                this.Tail4.yRot = 0F;
                this.Tail4.zRot = 0F;
                this.Tail5.xRot = 0.4F;
                this.Tail5.yRot = 0F;
                this.Tail5.zRot = 0F;
                this.Tail6.xRot = -0.4F;
                this.Tail6.yRot = 0F;
                this.Tail6.zRot = 0F;
                this.TailHeadBase.xRot = -0.3F;
                this.TailHeadBase.yRot = 0F;
                this.TailHeadBase.zRot = 0.8F;
                this.TailHead1.xRot = 0.1745F;
                this.TailJaw1.xRot = -0.5F;
            }
        } // end if sitting

        // 攻擊動作
        if (ent.getAttackTick() > 0) {
            // 高度
            this.offsetY += 0.13F;
            // 手臂晃動
            this.ArmLeft01.xRot = 0.5236F;
            this.ArmLeft01.yRot = 0F;
            this.ArmLeft01.zRot = -0.5236F;
            this.ArmRight01.xRot = -2.7925F;
            this.ArmRight01.yRot = 0F;
            this.ArmRight01.zRot = -0.2618F;
            // 頭部角度
            this.Head.xRot = -1.2217F;
            this.Head.yRot = 0F;
            // 身體角度
            this.BodyMain.xRot = 1.0472F;
            this.Cloth2.xRot = -0.5236F;
            // 腿擺動
            addk1 = addk1 - 1.48F;
            addk2 = addk2 - 0.26F;
            this.LegLeft.yRot = 0F;
            this.LegRight.yRot = 0F;
            // bag
            this.BagStrap1.xRot = 0.15F;
            this.BagStrap1.yRot = -1.0472F;
            this.BagStrap1.zRot = 0F;
            this.BagStrap2.xRot = 0.3491F;
            this.BagStrap2.yRot = 0.3491F;
            // tail
            this.TailBase.xRot = 0.6F;
            this.TailBase.yRot = 0F;
            this.TailBase.zRot = 3.1416F;
            this.Tail1.xRot = -0.2618F;
            this.Tail1.yRot = 0F;
            this.Tail1.zRot = 0F;
            this.Tail2.xRot = -0.5236F;
            this.Tail2.yRot = 0F;
            this.Tail2.zRot = 0F;
            this.Tail3.xRot = -0.2618F;
            this.Tail3.yRot = 0F;
            this.Tail3.zRot = 0F;
            this.Tail4.xRot = -0.2618F;
            this.Tail4.yRot = 0F;
            this.Tail4.zRot = 0F;
            this.Tail5.xRot = -0.5236F;
            this.Tail5.yRot = 0F;
            this.Tail5.zRot = 0F;
            this.Tail6.xRot = -0.5236F;
            this.Tail6.yRot = 0F;
            this.Tail6.zRot = 0F;
            this.TailHeadBase.xRot = -0.2618F;
            this.TailHeadBase.yRot = 0F;
            this.TailHeadBase.zRot = 0F;

            if (ent.getAttackTick() > 47) {
                this.TailHead1.xRot = (50 - ent.getAttackTick()) * 0.15F + 0.4F;
                this.TailJaw1.xRot = (ent.getAttackTick() - 50) * 0.15F - 0.4F;
            } else if (ent.getAttackTick() > 39) {
                this.TailHead1.xRot = 0.76F - (46 - ent.getAttackTick()) * 0.06F;
                this.TailJaw1.xRot = -0.76F + (46 - ent.getAttackTick()) * 0.06F;
            } else {
                this.TailHead1.xRot = 0.4F;
                this.TailJaw1.xRot = -0.4F;
            }
        }

        // swing arm
        float f6 = ent.getSwingTime(f2 - (int) f2);
        if (f6 != 0F) {
            float f7 = Mth.sin(f6 * f6 * (float) Math.PI);
            float f8 = Mth.sin(Mth.sqrt(f6) * (float) Math.PI);
            this.ArmRight01.xRot = -0.6F;
            this.ArmRight01.yRot = 0F;
            this.ArmRight01.zRot = 0.2F;
            this.ArmRight01.xRot += -f8 * 80.0F * ((float) Math.PI / 180F);
            this.ArmRight01.yRot += -f7 * 20.0F * ((float) Math.PI / 180F) + 0.2F;
            this.ArmRight01.zRot += -f8 * 20.0F * ((float) Math.PI / 180F);
        }

        // leg motion
        this.LegLeft.xRot = addk1;
        this.LegRight.xRot = addk2;
    }
}
