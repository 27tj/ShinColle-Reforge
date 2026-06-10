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

public class ModelSubmHime extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "ss_hime"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Neck;
    private final ModelPart Butt;
    private final ModelPart ArmRight01;
    private final ModelPart ArmLeft01;
    private final ModelPart BoobR;
    private final ModelPart BoobL;
    private final ModelPart EquipBack;
    private final ModelPart Head;
    private final ModelPart Collar01;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart Ahoke01;
    private final ModelPart Ahoke01a;
    private final ModelPart HairU01;
    private final ModelPart HairR01;
    private final ModelPart HairL01;
    private final ModelPart HairR02;
    private final ModelPart HairL02;
    private final ModelPart Hair01;
    private final ModelPart Hair02;
    private final ModelPart Hair03;
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
    private final ModelPart Collar02;
    private final ModelPart Collar03;
    private final ModelPart Collar04;
    private final ModelPart Collar05;
    private final ModelPart Collar05a;
    private final ModelPart Collar05b;
    private final ModelPart LegLeft01;
    private final ModelPart Skirt01;
    private final ModelPart LegRight01;
    private final ModelPart LegLeft02;
    private final ModelPart Skirt02;
    private final ModelPart LegRight02;
    private final ModelPart ArmRight02;
    private final ModelPart ArmLeft02;
    private final ModelPart EquipTube00;
    private final ModelPart EquipTube00_1;
    private final ModelPart EquipTube01;
    private final ModelPart EquipTube01a;
    private final ModelPart EquipTube02;
    private final ModelPart EquipTube02a;
    private final ModelPart EquipTube03;
    private final ModelPart EquipTube03a;
    private final ModelPart EquipTube04;
    private final ModelPart EquipTube04a;
    private final ModelPart EquipTube05;
    private final ModelPart EquipTube05a;
    private final ModelPart EquipTBase;
    private final ModelPart EquipT01;
    private final ModelPart EquipT02;
    private final ModelPart EquipT03;
    private final ModelPart EquipT04;
    private final ModelPart EquipT05;
    private final ModelPart EquipT06;
    private final ModelPart EquipT07;
    private final ModelPart EquipT02a;
    private final ModelPart EquipT02b;
    private final ModelPart EquipT02c;
    private final ModelPart EquipT02d;
    private final ModelPart EquipTJaw01;
    private final ModelPart EquipTJaw02;
    private final ModelPart EquipTEyeA;
    private final ModelPart EquipTEyeB;
    private final ModelPart EquipTube01_1;
    private final ModelPart EquipTube01a_1;
    private final ModelPart EquipTube02_1;
    private final ModelPart EquipTube02a_1;
    private final ModelPart EquipTube03_1;
    private final ModelPart EquipTube03a_1;
    private final ModelPart EquipTube04_1;
    private final ModelPart EquipTube04a_1;
    private final ModelPart EquipTube05_1;
    private final ModelPart EquipTube05a_1;
    private final ModelPart EquipTBase_1;
    private final ModelPart EquipT01_1;
    private final ModelPart EquipT03_1;
    private final ModelPart EquipT05_1;
    private final ModelPart EquipT06_1;
    private final ModelPart EquipT07_1;
    private final ModelPart EquipT02_1;
    private final ModelPart EquipT04_1;
    private final ModelPart EquipT02a_1;
    private final ModelPart EquipT02b_1;
    private final ModelPart EquipT02c_1;
    private final ModelPart EquipT02d_1;
    private final ModelPart EquipTJaw01_1;
    private final ModelPart EquipTJaw02_1;
    private final ModelPart EquipTEyeA_1;
    private final ModelPart EquipTEyeB_1;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowNeck;
    private final ModelPart GlowHead;
    private final ModelPart GlowEquipBase;

    public ModelSubmHime(ModelPart root) {
        super();
        this.scale = 0.48F;
        this.offsetY = 1.62F;
        this.BodyMain = root.getChild("BodyMain");
        this.BoobR = this.BodyMain.getChild("BoobR");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.Butt = this.BodyMain.getChild("Butt");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.Neck = this.BodyMain.getChild("Neck");
        this.BoobL = this.BodyMain.getChild("BoobL");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.Skirt01 = this.Butt.getChild("Skirt01");
        this.LegRight01 = this.Butt.getChild("LegRight01");
        this.LegLeft01 = this.Butt.getChild("LegLeft01");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.Collar01 = this.Neck.getChild("Collar01");
        this.Head = this.Neck.getChild("Head");
        this.Skirt02 = this.Skirt01.getChild("Skirt02");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
        this.Collar02 = this.Collar01.getChild("Collar02");
        this.Ahoke01a = this.Head.getChild("Ahoke01a");
        this.HairMain = this.Head.getChild("HairMain");
        this.Hair = this.Head.getChild("Hair");
        this.Ahoke01 = this.Head.getChild("Ahoke01");
        this.Collar03 = this.Collar02.getChild("Collar03");
        this.Ahoke02a = this.Ahoke01a.getChild("Ahoke02a");
        this.Hair01 = this.HairMain.getChild("Hair01");
        this.HairR01 = this.Hair.getChild("HairR01");
        this.HairL01 = this.Hair.getChild("HairL01");
        this.HairU01 = this.Hair.getChild("HairU01");
        this.Ahoke02 = this.Ahoke01.getChild("Ahoke02");
        this.Collar04 = this.Collar03.getChild("Collar04");
        this.Ahoke03a = this.Ahoke02a.getChild("Ahoke03a");
        this.Hair02 = this.Hair01.getChild("Hair02");
        this.HairR02 = this.HairR01.getChild("HairR02");
        this.HairL02 = this.HairL01.getChild("HairL02");
        this.Ahoke03 = this.Ahoke02.getChild("Ahoke03");
        this.Collar05 = this.Collar04.getChild("Collar05");
        this.Ahoke04a = this.Ahoke03a.getChild("Ahoke04a");
        this.Hair03 = this.Hair02.getChild("Hair03");
        this.Ahoke04 = this.Ahoke03.getChild("Ahoke04");
        this.Collar05a = this.Collar05.getChild("Collar05a");
        this.Collar05b = this.Collar05.getChild("Collar05b");
        this.Ahoke05a = this.Ahoke04a.getChild("Ahoke05a");
        this.Ahoke05 = this.Ahoke04.getChild("Ahoke05");
        this.Ahoke06a = this.Ahoke05a.getChild("Ahoke06a");
        this.Ahoke06 = this.Ahoke05.getChild("Ahoke06");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowNeck = this.GlowBodyMain.getChild("GlowNeck");
        this.GlowEquipBase = this.GlowBodyMain.getChild("GlowEquipBase");
        this.GlowHead = this.GlowNeck.getChild("GlowHead");
        this.loadFaceParts(this.GlowHead);

        this.EquipBack = this.GlowBodyMain.getChild("EquipBack");

        // Right tube chain
        this.EquipTube00 = this.GlowEquipBase.getChild("EquipTube00");
        this.EquipTube01 = this.EquipTube00.getChild("EquipTube01");
        this.EquipTube01a = this.EquipTube01.getChild("EquipTube01a");
        this.EquipTube02 = this.EquipTube01.getChild("EquipTube02");
        this.EquipTube02a = this.EquipTube02.getChild("EquipTube02a");
        this.EquipTube03 = this.EquipTube02.getChild("EquipTube03");
        this.EquipTube03a = this.EquipTube03.getChild("EquipTube03a");
        this.EquipTube04 = this.EquipTube03.getChild("EquipTube04");
        this.EquipTube04a = this.EquipTube04.getChild("EquipTube04a");
        this.EquipTube05 = this.EquipTube04.getChild("EquipTube05");
        this.EquipTube05a = this.EquipTube05.getChild("EquipTube05a");
        this.EquipTBase = this.EquipTube05a.getChild("EquipTBase");
        this.EquipT01 = this.EquipTBase.getChild("EquipT01");
        this.EquipT02 = this.EquipTBase.getChild("EquipT02");
        this.EquipT02a = this.EquipT02.getChild("EquipT02a");
        this.EquipT02b = this.EquipT02.getChild("EquipT02b");
        this.EquipT02c = this.EquipT02.getChild("EquipT02c");
        this.EquipT02d = this.EquipT02.getChild("EquipT02d");
        this.EquipT03 = this.EquipTBase.getChild("EquipT03");
        this.EquipT04 = this.EquipTBase.getChild("EquipT04");
        this.EquipTJaw01 = this.EquipT04.getChild("EquipTJaw01");
        this.EquipTJaw02 = this.EquipT04.getChild("EquipTJaw02");
        this.EquipTEyeA = this.EquipT04.getChild("EquipTEyeA");
        this.EquipTEyeB = this.EquipT04.getChild("EquipTEyeB");
        this.EquipT05 = this.EquipTBase.getChild("EquipT05");
        this.EquipT06 = this.EquipTBase.getChild("EquipT06");
        this.EquipT07 = this.EquipTBase.getChild("EquipT07");

        // Left tube chain (mirror)
        this.EquipTube00_1 = this.GlowEquipBase.getChild("EquipTube00_1");
        this.EquipTube01_1 = this.EquipTube00_1.getChild("EquipTube01_1");
        this.EquipTube01a_1 = this.EquipTube01_1.getChild("EquipTube01a_1");
        this.EquipTube02_1 = this.EquipTube01_1.getChild("EquipTube02_1");
        this.EquipTube02a_1 = this.EquipTube02_1.getChild("EquipTube02a_1");
        this.EquipTube03_1 = this.EquipTube02_1.getChild("EquipTube03_1");
        this.EquipTube03a_1 = this.EquipTube03_1.getChild("EquipTube03a_1");
        this.EquipTube04_1 = this.EquipTube03_1.getChild("EquipTube04_1");
        this.EquipTube04a_1 = this.EquipTube04_1.getChild("EquipTube04a_1");
        this.EquipTube05_1 = this.EquipTube04_1.getChild("EquipTube05_1");
        this.EquipTube05a_1 = this.EquipTube05_1.getChild("EquipTube05a_1");
        this.EquipTBase_1 = this.EquipTube05a_1.getChild("EquipTBase_1");
        this.EquipT01_1 = this.EquipTBase_1.getChild("EquipT01_1");
        this.EquipT02_1 = this.EquipTBase_1.getChild("EquipT02_1");
        this.EquipT02a_1 = this.EquipT02_1.getChild("EquipT02a_1");
        this.EquipT02b_1 = this.EquipT02_1.getChild("EquipT02b_1");
        this.EquipT02c_1 = this.EquipT02_1.getChild("EquipT02c_1");
        this.EquipT02d_1 = this.EquipT02_1.getChild("EquipT02d_1");
        this.EquipT03_1 = this.EquipTBase_1.getChild("EquipT03_1");
        this.EquipT04_1 = this.EquipTBase_1.getChild("EquipT04_1");
        this.EquipTJaw01_1 = this.EquipT04_1.getChild("EquipTJaw01_1");
        this.EquipTJaw02_1 = this.EquipT04_1.getChild("EquipTJaw02_1");
        this.EquipTEyeA_1 = this.EquipT04_1.getChild("EquipTEyeA_1");
        this.EquipTEyeB_1 = this.EquipT04_1.getChild("EquipTEyeB_1");
        this.EquipT05_1 = this.EquipTBase_1.getChild("EquipT05_1");
        this.EquipT06_1 = this.EquipTBase_1.getChild("EquipT06_1");
        this.EquipT07_1 = this.EquipTBase_1.getChild("EquipT07_1");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 104)
                        .addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("BoobR",
                CubeListBuilder.create().texOffs(0, 36)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(-3.2F, -8.5F, -3.8F, -0.8726646259971648F, 0.08726646259971647F,
                        0.06981317007977318F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().mirror().texOffs(24, 71)
                        .addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, 0.0F, 0.0F, 0.2617993877991494F));

        armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().mirror().texOffs(24, 54)
                        .addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
                PartPose.offset(-3.0F, 11.0F, 2.5F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(0, 88)
                        .addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));

        PartDefinition skirt01 = butt.addOrReplaceChild("Skirt01",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-8.5F, 0.0F, -8.5F, 17.0F, 5.0F, 11.0F),
                PartPose.offsetAndRotation(0.0F, 3.0F, 1.5F, -0.08726646259971647F, 0.0F, 0.0F));

        skirt01.addOrReplaceChild("Skirt02",
                CubeListBuilder.create().texOffs(128, 17)
                        .addBox(-10.5F, 0.0F, -6.5F, 21.0F, 5.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, 3.5F, -2.7F, -0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().mirror().texOffs(0, 68)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.19198621771937624F, 0.0F, -0.08726646259971647F));

        legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().mirror().texOffs(0, 47)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                PartPose.offset(-3.0F, 14.0F, -3.0F));

        PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().texOffs(0, 68)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.296705972839036F, 0.0F, 0.08726646259971647F));

        legLeft01.addOrReplaceChild("LegLeft02",
                CubeListBuilder.create().texOffs(0, 47)
                        .addBox(-6.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                PartPose.offset(3.0F, 14.0F, -3.0F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().texOffs(24, 71)
                        .addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.20943951023931953F, 0.0F, -0.2617993877991494F));

        armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().texOffs(24, 54)
                        .addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
                PartPose.offset(3.0F, 11.0F, 2.5F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(24, 63)
                        .addBox(-2.5F, -3.0F, -2.9F, 5.0F, 3.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, -9.6F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition collar01 = neck.addOrReplaceChild("Collar01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-6.0F, -2.0F, -4.0F, 12.0F, 3.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, -1.1F, -1.2F, 0.03490658503988659F, 0.0F, 0.0F));

        PartDefinition collar02 = collar01.addOrReplaceChild("Collar02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, -0.6F, -3.2F, -0.6981317007977318F, 0.0F, 0.0F));

        PartDefinition collar03 = collar02.addOrReplaceChild("Collar03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 3.5F, 0.0F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition collar04 = collar03.addOrReplaceChild("Collar04",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-0.5F, 0.0F, -1.0F, 1.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.4553564018453205F, 0.0F, 0.0F));

        PartDefinition collar05 = collar04.addOrReplaceChild("Collar05",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.5F, 0.0F, -1.0F, 5.0F, 2.0F, 2.0F),
                PartPose.offset(0.0F, 4.0F, -0.2F));

        collar05.addOrReplaceChild("Collar05a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, -2.0F, -0.5F, 3.0F, 2.0F, 1.0F),
                PartPose.offsetAndRotation(2.5F, 2.0F, 0.0F, 0.0F, -0.08726646259971647F, -0.3490658503988659F));

        collar05.addOrReplaceChild("Collar05b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, -2.0F, -0.5F, 3.0F, 2.0F, 1.0F),
                PartPose.offsetAndRotation(-2.5F, 2.0F, 0.0F, 0.0F, 0.08726646259971647F, 0.3490658503988659F));

        PartDefinition head = neck.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offset(0.0F, -1.0F, -0.7F));

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
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 17.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 9.0F, 1.0F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition hair02 = hair01.addOrReplaceChild("Hair02",
                CubeListBuilder.create().texOffs(72, 29)
                        .addBox(-8.0F, 0.0F, -5.0F, 16.0F, 16.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 13.5F, 5.5F, -0.08726646259971647F, 0.0F, 0.0F));

        hair02.addOrReplaceChild("Hair03",
                CubeListBuilder.create().texOffs(26, 32)
                        .addBox(-8.0F, 0.0F, -4.5F, 16.0F, 15.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 12.5F, -0.1F, -0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(50, 77)
                        .addBox(-8.0F, -8.0F, -7.4F, 16.0F, 16.0F, 8.0F),
                PartPose.offset(0.0F, -7.5F, 0.1F));

        PartDefinition hairR01 = hair.addOrReplaceChild("HairR01",
                CubeListBuilder.create().mirror().texOffs(0, 18)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(-7.0F, 3.0F, -5.5F, -0.19198621771937624F, 0.17453292519943295F,
                        0.08726646259971647F));

        hairR01.addOrReplaceChild("HairR02",
                CubeListBuilder.create().mirror().texOffs(0, 18)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(0.2F, 10.0F, 0.0F, 0.17453292519943295F, 0.0F, -0.05235987755982988F));

        PartDefinition hairL01 = hair.addOrReplaceChild("HairL01",
                CubeListBuilder.create().texOffs(0, 18)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(7.0F, 3.0F, -5.5F, -0.19198621771937624F, -0.17453292519943295F,
                        -0.08726646259971647F));

        hairL01.addOrReplaceChild("HairL02",
                CubeListBuilder.create().texOffs(0, 18)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.08726646259971647F));

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

        bodyMain.addOrReplaceChild("BoobL",
                CubeListBuilder.create().mirror().texOffs(0, 36)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(3.2F, -8.5F, -3.7F, -0.8726646259971648F, -0.08726646259971647F,
                        -0.06981317007977318F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -15.0F, 0.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -9.6F, 0.5F));

        PartDefinition glowHead = glowNeck.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -1.0F, -0.7F));
        addDefaultFaceParts(glowHead);

        glowBodyMain.addOrReplaceChild("EquipBack",
                CubeListBuilder.create().texOffs(17, 31)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, -0.7F, 4.4F, -0.7853981633974483F, 0.0F, 0.0F));

        PartDefinition glowEquipBase = glowBodyMain.addOrReplaceChild("GlowEquipBase",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 8.0F, 3.0F));

        // Right tube chain: GlowEquipBase -> EquipTube00 -> ...
        PartDefinition equipTube00 = glowEquipBase.addOrReplaceChild("EquipTube00",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F),
                PartPose.offsetAndRotation(0.5F, 3.0F, 1.4F, 0.2617993877991494F, 0.61F, 0.0F));

        PartDefinition equipTube01 = equipTube00.addOrReplaceChild("EquipTube01",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 4.5F, 0.0F, 0.3490658503988659F, 0.0F, 0.0F));

        equipTube01.addOrReplaceChild("EquipTube01a",
                CubeListBuilder.create().texOffs(44, 67)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition equipTube02 = equipTube01.addOrReplaceChild("EquipTube02",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 7.0F, -1.0F, 0.5235987755982988F, 0.0F, 0.0F));

        equipTube02.addOrReplaceChild("EquipTube02a",
                CubeListBuilder.create().texOffs(44, 67)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition equipTube03 = equipTube02.addOrReplaceChild("EquipTube03",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.6108652381980153F, 0.0F, 0.0F));

        equipTube03.addOrReplaceChild("EquipTube03a",
                CubeListBuilder.create().texOffs(44, 67)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition equipTube04 = equipTube03.addOrReplaceChild("EquipTube04",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.6981317007977318F, 0.0F, 0.0F));

        equipTube04.addOrReplaceChild("EquipTube04a",
                CubeListBuilder.create().texOffs(44, 67)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition equipTube05 = equipTube04.addOrReplaceChild("EquipTube05",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.6108652381980153F, 0.0F, 0.0F));

        PartDefinition equipTube05a = equipTube05.addOrReplaceChild("EquipTube05a",
                CubeListBuilder.create().texOffs(44, 67)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition equipTBase = equipTube05a.addOrReplaceChild("EquipTBase",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 26.0F, 1.0F, 0.0F, 0.61F, 0.0F));

        equipTBase.addOrReplaceChild("EquipT01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F),
                PartPose.offset(0.0F, -19.0F, 0.0F));

        PartDefinition equipT02 = equipTBase.addOrReplaceChild("EquipT02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F),
                PartPose.offset(0.0F, -16.0F, 0.0F));

        equipT02.addOrReplaceChild("EquipT02a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, -0.5F, 3.0F, 7.0F, 1.0F),
                PartPose.offset(2.9F, 0.5F, 0.0F));

        equipT02.addOrReplaceChild("EquipT02b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, 0.0F, -0.5F, 3.0F, 7.0F, 1.0F),
                PartPose.offset(-2.9F, 0.5F, 0.0F));

        equipT02.addOrReplaceChild("EquipT02c",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, -0.5F, 3.0F, 7.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 0.5F, 5.9F, 0.0F, 1.5707963267948966F, 0.0F));

        equipT02.addOrReplaceChild("EquipT02d",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, -0.5F, 3.0F, 7.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 0.5F, -5.9F, 0.0F, -1.5707963267948966F, 0.0F));

        equipTBase.addOrReplaceChild("EquipT03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F),
                PartPose.offset(0.0F, -6.0F, 0.0F));

        PartDefinition equipT04 = equipTBase.addOrReplaceChild("EquipT04",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F),
                PartPose.offset(0.0F, 4.0F, 0.0F));

        equipT04.addOrReplaceChild("EquipTJaw01",
                CubeListBuilder.create().texOffs(59, 25)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 6.3F, 0.5F, 0.2617993877991494F, 0.0F, 0.0F));

        equipT04.addOrReplaceChild("EquipTJaw02",
                CubeListBuilder.create().mirror().texOffs(59, 25)
                        .addBox(-3.5F, 0.0F, -2.5F, 7.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 4.6F, 1.0F, 1.48352986419518F, 0.0F, 3.141592653589793F));

        equipT04.addOrReplaceChild("EquipTEyeA",
                CubeListBuilder.create().texOffs(0, 14)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F),
                PartPose.offsetAndRotation(3.2F, 10.9F, 3.0F, -2.0943951023931953F, 0.0F, 0.0F));

        equipT04.addOrReplaceChild("EquipTEyeB",
                CubeListBuilder.create().texOffs(0, 14)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-3.2F, 10.9F, 3.0F, -2.0943951023931953F, 0.0F, 0.0F));

        equipTBase.addOrReplaceChild("EquipT05",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F),
                PartPose.offset(0.0F, 14.0F, 0.0F));

        equipTBase.addOrReplaceChild("EquipT06",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 1.0F, 5.0F),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        equipTBase.addOrReplaceChild("EquipT07",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 1.0F, 4.0F),
                PartPose.offset(0.0F, 24.7F, 0.0F));

        // Left tube chain (mirror): GlowEquipBase -> EquipTube00_1 -> ...
        PartDefinition equipTube00_1 = glowEquipBase.addOrReplaceChild("EquipTube00_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F),
                PartPose.offsetAndRotation(-0.5F, 3.0F, 1.4F, 0.2617993877991494F, -0.61F, 0.0F));

        PartDefinition equipTube01_1 = equipTube00_1.addOrReplaceChild("EquipTube01_1",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 4.5F, 0.0F, 0.3490658503988659F, 0.0F, 0.0F));

        equipTube01_1.addOrReplaceChild("EquipTube01a_1",
                CubeListBuilder.create().texOffs(44, 67)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition equipTube02_1 = equipTube01_1.addOrReplaceChild("EquipTube02_1",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 7.0F, -1.0F, 0.5235987755982988F, 0.0F, 0.0F));

        equipTube02_1.addOrReplaceChild("EquipTube02a_1",
                CubeListBuilder.create().texOffs(44, 67)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition equipTube03_1 = equipTube02_1.addOrReplaceChild("EquipTube03_1",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.6108652381980153F, 0.0F, 0.0F));

        equipTube03_1.addOrReplaceChild("EquipTube03a_1",
                CubeListBuilder.create().texOffs(44, 67)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition equipTube04_1 = equipTube03_1.addOrReplaceChild("EquipTube04_1",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.6981317007977318F, 0.0F, 0.0F));

        equipTube04_1.addOrReplaceChild("EquipTube04a_1",
                CubeListBuilder.create().texOffs(44, 67)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition equipTube05_1 = equipTube04_1.addOrReplaceChild("EquipTube05_1",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.6108652381980153F, 0.0F, 0.0F));

        PartDefinition equipTube05a_1 = equipTube05_1.addOrReplaceChild("EquipTube05a_1",
                CubeListBuilder.create().texOffs(44, 67)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition equipTBase_1 = equipTube05a_1.addOrReplaceChild("EquipTBase_1",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 26.0F, 1.0F, 0.0F, -0.61F, 0.0F));

        equipTBase_1.addOrReplaceChild("EquipT01_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F),
                PartPose.offset(0.0F, -19.0F, 0.0F));

        PartDefinition equipT02_1 = equipTBase_1.addOrReplaceChild("EquipT02_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F),
                PartPose.offset(0.0F, -16.0F, 0.0F));

        equipT02_1.addOrReplaceChild("EquipT02a_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, -0.5F, 3.0F, 7.0F, 1.0F),
                PartPose.offset(2.9F, 0.5F, 0.0F));

        equipT02_1.addOrReplaceChild("EquipT02b_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, 0.0F, -0.5F, 3.0F, 7.0F, 1.0F),
                PartPose.offset(-2.9F, 0.5F, 0.0F));

        equipT02_1.addOrReplaceChild("EquipT02c_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, -0.5F, 3.0F, 7.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 0.5F, 5.9F, 0.0F, 1.5707963267948966F, 0.0F));

        equipT02_1.addOrReplaceChild("EquipT02d_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, -0.5F, 3.0F, 7.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 0.5F, -5.9F, 0.0F, -1.5707963267948966F, 0.0F));

        equipTBase_1.addOrReplaceChild("EquipT03_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F),
                PartPose.offset(0.0F, -6.0F, 0.0F));

        PartDefinition equipT04_1 = equipTBase_1.addOrReplaceChild("EquipT04_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F),
                PartPose.offset(0.0F, 4.0F, 0.0F));

        equipT04_1.addOrReplaceChild("EquipTJaw01_1",
                CubeListBuilder.create().texOffs(59, 25)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 6.3F, 0.5F, 0.2617993877991494F, 0.0F, 0.0F));

        equipT04_1.addOrReplaceChild("EquipTJaw02_1",
                CubeListBuilder.create().mirror().texOffs(59, 25)
                        .addBox(-3.5F, 0.0F, -2.5F, 7.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 4.6F, 1.0F, 1.48352986419518F, 0.0F, 3.141592653589793F));

        equipT04_1.addOrReplaceChild("EquipTEyeA_1",
                CubeListBuilder.create().texOffs(0, 14)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F),
                PartPose.offsetAndRotation(3.2F, 10.9F, 3.0F, -2.0943951023931953F, 0.0F, 0.0F));

        equipT04_1.addOrReplaceChild("EquipTEyeB_1",
                CubeListBuilder.create().texOffs(0, 14)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-3.2F, 10.9F, 3.0F, -2.0943951023931953F, 0.0F, 0.0F));

        equipTBase_1.addOrReplaceChild("EquipT05_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F),
                PartPose.offset(0.0F, 14.0F, 0.0F));

        equipTBase_1.addOrReplaceChild("EquipT06_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 1.0F, 5.0F),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        equipTBase_1.addOrReplaceChild("EquipT07_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 1.0F, 4.0F),
                PartPose.offset(0.0F, 24.7F, 0.0F));

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

        boolean flag = !EmotionHelper.checkModelState(1, state);
        this.Collar01.visible = !flag;
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

        this.offsetY += 0.62F;
        this.setFaceHungry(ent);

        // 頭部
        this.Head.xRot = -0.15F;
        this.Head.yRot = 0F;
        this.Head.zRot = 0F;
        // 胸部
        this.BoobL.xRot = -0.76F;
        this.BoobR.xRot = -0.76F;
        // Body
        this.BodyMain.xRot = 1.6F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        this.Butt.xRot = 1.2F;
        // this.Butt.offsetY = -0.2F;
        // this.Butt.offsetZ = -0.14F;
        this.Skirt01.xRot = -0.94F;
        // this.Skirt01.offsetY = 0.09F;
        // this.Skirt01.offsetZ = -0.03F;
        this.Skirt02.xRot = -0.3F;
        // hair
        this.Hair01.xRot = 0.35F;
        this.Hair01.zRot = 0F;
        this.Hair02.xRot = -0.2F;
        this.Hair02.zRot = 0F;
        this.Hair03.xRot = -0.35F;
        this.Hair03.zRot = 0F;
        this.HairL01.xRot = -0.14F;
        this.HairL02.xRot = 0.17F;
        this.HairR01.xRot = -0.14F;
        this.HairR02.xRot = 0.17F;
        // arm
        this.ArmLeft01.xRot = -2.9F;
        this.ArmLeft01.yRot = -0.6981F;
        this.ArmLeft01.zRot = 0.08F;
        this.ArmLeft02.xRot = 0F;
        this.ArmLeft02.yRot = 0F;
        this.ArmLeft02.zRot = 0F;
        this.ArmRight01.xRot = -2.9F;
        this.ArmRight01.yRot = 0.6981F;
        this.ArmRight01.zRot = -0.08F;
        this.ArmRight02.xRot = 0F;
        this.ArmRight02.yRot = 0F;
        this.ArmRight02.zRot = 0F;
        // leg
        this.LegLeft01.xRot = -1.9F;
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.05F;
        this.LegLeft02.xRot = 0.64F;
        // this.LegLeft02.offsetY = 0F;
        // this.LegLeft02.offsetZ = 0F;
        this.LegRight01.xRot = -1.9F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.05F;
        this.LegRight02.xRot = 0.64F;
        // this.LegRight02.offsetY = 0F;
        // this.LegRight02.offsetZ = 0F;
        // tails
        this.GlowEquipBase.visible = false;
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
        float addHL1 = 0F;
        float addHR1 = 0F;
        float addHL2 = 0F;
        float addHR2 = 0F;
        int state = ent.getStateEmotion(ID.S.State);
        boolean collar = EmotionHelper.checkModelState(1, state);
        boolean tails = EmotionHelper.checkModelState(2, state);

        // 水上漂浮
        // [RENDER?] 目視検証必須: 水面時の上下揺れが1.10.2相当の小振幅(0.025)で再現されること。
        // [REPRO?] 目視未確認: 実機で水面待機時の高さ差と揺れ周期を比較すること。
        if (ent.getShipDepth(0) > 0D || ent.getShipDepth(1) > 0D) {
            this.offsetY += angleX * 0.025F + 0.025F;
        }

        // leg move parm
        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += angleX * 0.025F + 0.025F;
        addk1 = angleAdd1 * 0.6F - 0.3F;
        addk2 = angleAdd2 * 0.6F - 0.2F;

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
        this.BodyMain.xRot = -0.1047F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        this.Butt.xRot = 0.35F;
        // this.Butt.offsetY = 0F;
        // this.Butt.offsetZ = 0F;
        this.BoobL.xRot = angleX * 0.06F - 0.76F;
        this.BoobL.yRot = -0.087F;
        this.BoobL.zRot = -0.07F;
        this.BoobR.xRot = angleX * 0.06F - 0.76F;
        this.BoobR.yRot = 0.087F;
        this.BoobR.zRot = 0.07F;


        // this.BoobL.offsetX = 0F;
        // this.BoobR.offsetX = 0F;

        // this.BoobL.offsetX = -0.05F;
        // this.BoobR.offsetX = 0.05F;


        this.Collar01.xRot = 0.035F;
        this.Collar03.xRot = angleX * 0.08F + 0.26F;
        this.Collar04.xRot = -angleX * 0.08F + 0.45F;
        // cloth
        this.Skirt01.xRot = -0.087F;
        // this.Skirt01.offsetY = 0F;
        // this.Skirt01.offsetZ = 0F;
        this.Skirt02.xRot = -0.087F;
        // this.Skirt02.offsetY = 0F;
        // this.Skirt02.offsetZ = 0F;
        // hair
        this.Hair01.xRot = angleX * 0.03F + 0.26F + headX;
        this.Hair01.zRot = 0F;
        this.Hair02.xRot = -angleX1 * 0.04F - 0.087F + headX;
        this.Hair02.zRot = 0F;
        this.Hair03.xRot = -angleX2 * 0.07F - 0.052F;
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
        this.LegLeft02.xRot = 0F;
        this.LegLeft02.yRot = 0F;
        this.LegLeft02.zRot = 0F;
        // this.LegLeft02.offsetX = 0F;
        // this.LegLeft02.offsetY = 0F;
        // this.LegLeft02.offsetZ = 0F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.087F;
        this.LegRight02.xRot = 0F;
        this.LegRight02.yRot = 0F;
        this.LegRight02.zRot = 0F;
        // this.LegRight02.offsetX = 0F;
        // this.LegRight02.offsetY = 0F;
        // this.LegRight02.offsetZ = 0F;
        // tails
        if (tails) {
            this.EquipTBase.visible = false;
            this.EquipTBase_1.visible = false;
            this.GlowEquipBase.xRot = 0.3F;
            this.EquipTube00.xRot = 0.2618F;
            this.EquipTube00.yRot = Mth.cos(-f2 * 0.1F + 0.7F) * 0.1F + 0.61F;
            this.EquipTube00.zRot = this.EquipTube00.yRot * 0.125F;
            this.EquipTube01.xRot = 0.35F;
            this.EquipTube01.yRot = Mth.cos(-f2 * 0.1F + 1.4F) * 0.125F;
            this.EquipTube01.zRot = this.EquipTube01.yRot * 0.125F;
            this.EquipTube02.xRot = 0.5235F;
            this.EquipTube02.yRot = Mth.cos(-f2 * 0.1F + 2.1F) * 0.15F;
            this.EquipTube02.zRot = this.EquipTube02.yRot * 0.125F;
            this.EquipTube03.xRot = 0.61F;
            this.EquipTube03.yRot = Mth.cos(-f2 * 0.1F + 2.8F) * 0.175F;
            this.EquipTube03.zRot = this.EquipTube03.yRot * 0.125F;
            this.EquipTube04.xRot = 0.6981F;
            this.EquipTube04.yRot = Mth.cos(-f2 * 0.1F + 3.5F) * 0.2F;
            this.EquipTube04.zRot = this.EquipTube04.yRot * 0.125F;
            this.EquipTube05.xRot = 0.61F;
            this.EquipTube05.yRot = Mth.cos(-f2 * 0.1F + 4.2F) * 0.175F;
            this.EquipTube05.zRot = this.EquipTube05.yRot * 0.125F;
            this.EquipTube00_1.xRot = this.EquipTube00.xRot;
            this.EquipTube00_1.yRot = -this.EquipTube00.yRot;
            this.EquipTube00_1.zRot = this.EquipTube00.zRot;
            this.EquipTube01_1.xRot = this.EquipTube01.xRot;
            this.EquipTube01_1.yRot = this.EquipTube01.yRot;
            this.EquipTube01_1.zRot = this.EquipTube01.zRot;
            this.EquipTube02_1.xRot = this.EquipTube02.xRot;
            this.EquipTube02_1.yRot = this.EquipTube02.yRot;
            this.EquipTube02_1.zRot = this.EquipTube02.zRot;
            this.EquipTube03_1.xRot = this.EquipTube03.xRot;
            this.EquipTube03_1.yRot = this.EquipTube03.yRot;
            this.EquipTube03_1.zRot = this.EquipTube03.zRot;
            this.EquipTube04_1.xRot = this.EquipTube04.xRot;
            this.EquipTube04_1.yRot = this.EquipTube04.yRot;
            this.EquipTube04_1.zRot = this.EquipTube04.zRot;
            this.EquipTube05_1.xRot = this.EquipTube05.xRot;
            this.EquipTube05_1.yRot = this.EquipTube05.yRot;
            this.EquipTube05_1.zRot = this.EquipTube05.zRot;
        }

        // 奔跑動作
        if (ent.getIsSprinting() || f1 > 0.9F) {
            if (ent.getIsRiding()) {
                // [PORT] 1.10.2 -> 1.20.1: riding sprint crouch offset.
                this.offsetY += 0.06F;

                if (f1 > 0.5F) {
                    this.Head.xRot += 0.4F;
                    this.Hair01.xRot += 0.1F;
                    this.Hair02.xRot -= 0.2F;
                    this.Hair03.xRot -= 0.2F;
                }
            } else {
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.06F;
                this.Head.xRot -= 1.1F;
                this.Hair01.xRot += 0.6F;
                this.Hair02.xRot += 0.5F;
                this.Hair03.xRot += 0.2F;
                this.Ahoke01.xRot += 0.38F;
                this.Ahoke01.yRot = 0.7F;
                this.Ahoke01.zRot = 0.4F;
                this.Ahoke01a.yRot = -2.5F;
                this.Ahoke01a.zRot = -0.2F;
            }

            // body
            this.BodyMain.xRot = 1.2566F;
            // 胸部
            this.BoobL.xRot = angleAdd2 * 0.1F - 0.83F;
            this.BoobL.zRot = -0.07F;
            this.BoobR.xRot = angleAdd2 * 0.1F - 0.83F;
            this.BoobR.zRot = 0.07F;
            this.Collar03.xRot += angleAdd2 * 0.1F;
            this.Collar04.xRot += angleAdd2 * 0.1F;
            // arm
            this.ArmLeft01.xRot = -2.7F;
            this.ArmLeft01.zRot = -0.22F;
            this.ArmRight01.xRot = -2.7F;
            this.ArmRight01.zRot = 0.22F;
            // leg
            this.LegLeft01.zRot = 0.05F;
            this.LegRight01.zRot = -0.05F;
            // tails
            if (tails) {
                this.EquipTBase.visible = false;
                this.EquipTBase_1.visible = false;
                this.GlowEquipBase.xRot = 0.3F;
                this.EquipTube00.xRot = Mth.cos(-f2 * 0.4F + 0.7F) * 0.1F + 0.4F;
                this.EquipTube00.yRot = Mth.cos(-f2 * 0.4F + 0.7F) * 0.1F + 0.9F;
                this.EquipTube00.zRot = this.EquipTube00.yRot * 0.125F;
                this.EquipTube01.xRot = Mth.cos(-f2 * 0.4F + 1.4F) * 0.125F;
                this.EquipTube01.yRot = Mth.cos(-f2 * 0.4F + 1.4F) * 0.125F;
                this.EquipTube01.zRot = this.EquipTube01.yRot * 0.125F;
                this.EquipTube02.xRot = Mth.cos(-f2 * 0.4F + 2.1F) * 0.15F;
                this.EquipTube02.yRot = Mth.cos(-f2 * 0.4F + 2.1F) * 0.15F;
                this.EquipTube02.zRot = this.EquipTube02.yRot * 0.125F;
                this.EquipTube03.xRot = Mth.cos(-f2 * 0.4F + 2.8F) * 0.175F;
                this.EquipTube03.yRot = Mth.cos(-f2 * 0.4F + 2.8F) * 0.175F;
                this.EquipTube03.zRot = this.EquipTube03.yRot * 0.125F;
                this.EquipTube04.xRot = Mth.cos(-f2 * 0.4F + 3.5F) * 0.2F;
                this.EquipTube04.yRot = Mth.cos(-f2 * 0.4F + 3.5F) * 0.2F;
                this.EquipTube04.zRot = this.EquipTube04.yRot * 0.125F;
                this.EquipTube05.xRot = Mth.cos(-f2 * 0.4F + 4.2F) * 0.175F;
                this.EquipTube05.yRot = Mth.cos(-f2 * 0.4F + 4.2F) * 0.175F;
                this.EquipTube05.zRot = this.EquipTube05.yRot * 0.125F;
                this.EquipTube00_1.xRot = this.EquipTube00.xRot;
                this.EquipTube00_1.yRot = -this.EquipTube00.yRot;
                this.EquipTube00_1.zRot = -this.EquipTube00.zRot;
                this.EquipTube01_1.xRot = this.EquipTube01.xRot;
                this.EquipTube01_1.yRot = this.EquipTube01.yRot;
                this.EquipTube01_1.zRot = this.EquipTube01.zRot;
                this.EquipTube02_1.xRot = this.EquipTube02.xRot;
                this.EquipTube02_1.yRot = this.EquipTube02.yRot;
                this.EquipTube02_1.zRot = this.EquipTube02.zRot;
                this.EquipTube03_1.xRot = this.EquipTube03.xRot;
                this.EquipTube03_1.yRot = this.EquipTube03.yRot;
                this.EquipTube03_1.zRot = this.EquipTube03.zRot;
                this.EquipTube04_1.xRot = this.EquipTube04.xRot;
                this.EquipTube04_1.yRot = this.EquipTube04.yRot;
                this.EquipTube04_1.zRot = this.EquipTube04.zRot;
                this.EquipTube05_1.xRot = this.EquipTube05.xRot;
                this.EquipTube05_1.yRot = this.EquipTube05.yRot;
                this.EquipTube05_1.zRot = this.EquipTube05.zRot;
            }
        }

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        // 潛行跟蹲下動作
        if (ent.getIsSneaking()) {
            // [PORT] 1.10.2 -> 1.20.1: GlStateManager.translate(0, 0.09, 0)
            this.offsetY += 0.09F;

            // Body
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.09F;
            this.Head.xRot -= 0.6283F;
            this.BodyMain.xRot = 0.8727F;
            this.Skirt01.xRot = -0.34F;
            // this.Skirt01.offsetY = -0.2F;
            // this.Skirt01.offsetZ = 0.03F;
            this.Skirt02.xRot = -0.27F;
            this.Collar01.xRot -= 0.35F;
            this.Collar03.xRot -= 0.3F;
            this.Collar04.xRot -= 0.35F;
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
            // tails
            this.GlowEquipBase.xRot = -0.2F;
        } // end if sneaking

        // 坐下動作
        if (ent.getIsSitting() && !ent.getIsRiding()) {
            if (ent.getTickExisted() % 512 > 256) {
                // [PORT] 1.10.2 -> 1.20.1: idle sit bobbing offset.
                this.offsetY += -angleX * 0.05F + 0.1F;

                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.52F;
                this.setFaceDamaged(ent);
                // body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += -angleX * 0.05F + 0.1F;
                this.Head.xRot *= 0.5F;
                this.Head.yRot *= 0.75F;
                this.Head.xRot += 0.5F;
                this.BodyMain.xRot = 1.6F;
                this.Skirt01.xRot = -0.33F;
                // this.Skirt01.offsetY = -0.23F;
                this.Skirt02.xRot = -0.12F;
                // this.Skirt02.offsetY = -0.16F;
                this.Ahoke01.xRot += 0.38F;
                this.Ahoke01.yRot = 0.8F;
                this.Ahoke01.zRot = 0.4F;
                this.Hair01.xRot -= 0.2F;
                this.Hair02.xRot -= 0.25F;
                this.Hair03.xRot -= 0.3F;
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
                    // [PORT] 1.10.2 -> 1.20.1: bored sit translate.
                    this.offsetY += 0.52F;

                    this.setFaceDamaged(ent);

                    // body
                    this.Head.xRot = 0.4F;
                    this.Skirt01.xRot = -0.64F;
                    // this.Skirt01.offsetY = -0.17F;
                    // this.Skirt01.offsetZ = 0F;
                    this.Skirt02.xRot = 0.29F;
                    // this.Skirt02.offsetY = -0.04F;
                    // this.Skirt02.offsetZ = 0.02F;
                    this.Hair01.xRot -= 0.2F;
                    this.Hair02.xRot -= 0.15F;
                    this.Hair03.xRot -= 0.1F;
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
                } else {
                    // [PORT] 1.10.2 -> 1.20.1: normal sit translate.
                    this.offsetY += 0.495F;

                    // body
                    // [PORT] Restored from 1.10.2 GlStateManager.translate
                    this.offsetY += 0.495F;
                    this.Head.xRot -= 0.7F;
                    this.BodyMain.xRot = 0.35F;
                    this.Hair01.xRot += 0.3F;
                    this.Hair02.xRot += 0.3F;
                    this.Hair03.xRot += 0.3F;
                    this.Skirt01.xRot = -0.32F;
                    // this.Skirt01.offsetY = -0.05F;
                    this.Skirt02.xRot = -0.21F;
                    this.Collar01.xRot += 0.1F;
                    this.Collar03.xRot += 0.1F;
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
            if (((net.minecraft.world.entity.Entity) ent).getVehicle() instanceof BasicEntityMount) {
                if (ent.getIsSitting()) {
                    // [PORT] 1.10.2 -> 1.20.1: ship mount sitting translate.
                    this.offsetY += 0.4F;

                    // body
                    this.Head.xRot -= 0.7F;
                    this.BodyMain.xRot = 0.35F;
                    this.Hair01.xRot += 0.3F;
                    this.Hair02.xRot += 0.3F;
                    this.Hair03.xRot += 0.3F;
                    this.Skirt01.xRot = -0.32F;
                    // this.Skirt01.offsetY = -0.05F;
                    this.Skirt02.xRot = -0.21F;
                    this.Collar01.xRot += 0.1F;
                    this.Collar03.xRot += 0.1F;
                    // arm
                    this.ArmLeft01.xRot = -0.8F;
                    this.ArmLeft01.yRot = 0.0F;
                    this.ArmLeft01.zRot = -0.2F;
                    this.ArmLeft02.xRot = 0F;
                    this.ArmLeft02.zRot = 0F;
                    // this.ArmLeft02.offsetX = 0F;
                    // this.ArmLeft02.offsetZ = 0F;
                    this.ArmRight01.xRot = -0.8F;
                    this.ArmRight01.yRot = 0.0F;
                    this.ArmRight01.zRot = 0.2F;
                    this.ArmRight02.xRot = 0F;
                    this.ArmRight02.zRot = 0F;
                    // this.ArmRight02.offsetX = 0F;
                    // this.ArmRight02.offsetZ = 0F;
                    // leg
                    addk1 = -1.4486232791552935F;
                    addk2 = -1.4486232791552935F;
                    this.LegLeft01.yRot = -0.5235987755982988F;
                    this.LegLeft01.zRot = -0.2F;
                    this.LegLeft02.xRot = 0.8F;
                    this.LegRight01.yRot = 0.5235987755982988F;
                    this.LegRight01.zRot = 0.2F;
                    this.LegRight02.xRot = 0.8F;
                } // end if sitting
                else {
                    // [PORT] 1.10.2 -> 1.20.1: ship mount moving translate.
                    this.offsetY += 0.22F;

                    // body
                    this.Head.xRot *= 0.5F;
                    this.Head.yRot *= 0.75F;
                    this.Head.xRot -= 1.0F;
                    this.BodyMain.xRot = 1.0F;
                    this.Skirt01.xRot = -0.33F;
                    // this.Skirt01.offsetY = -0.23F;
                    this.Skirt02.xRot = -0.12F;
                    // this.Skirt02.offsetY = -0.16F;
                    this.Collar01.xRot -= 0.5F;
                    this.Collar03.xRot -= 0.5F;
                    this.Collar04.xRot -= 0.5F;
                    // hair
                    this.Ahoke01.xRot += 0.38F;
                    this.Ahoke01.yRot = 0.8F;
                    this.Ahoke01.zRot = 0.4F;
                    this.Hair01.xRot += 0.5F;
                    this.Hair02.xRot += 0.65F;
                    this.Hair03.xRot += 0.5F;
                    addHL1 = -0.6F;
                    addHR1 = -0.6F;
                    addHL2 = -0.5F;
                    addHR2 = -0.5F;
                    // arm
                    this.ArmLeft01.xRot = -1.4F;
                    this.ArmLeft01.yRot = -0.0F;
                    this.ArmRight01.xRot = -1.4F;
                    this.ArmRight01.yRot = 0.0F;
                    // leg
                    addk1 = -1.7F;
                    addk2 = -1.7F;
                    this.LegLeft01.yRot = -0.2F;
                    this.LegRight01.yRot = 0.2F;
                }
            } // end ship mount
            // normal mount ex: cart
            else {
                if (ent.getIsSitting()) {
                    if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                        // [PORT] 1.10.2 -> 1.20.1: normal mount bored sit bobbing offset.
                        this.offsetY += -angleX * 0.05F + 0.1F;
                        this.setFaceDamaged(ent);
                        // body
                        this.Head.xRot *= 0.5F;
                        this.Head.yRot *= 0.75F;
                        this.Head.xRot += 0.5F;
                        this.BodyMain.xRot = 1.6F;
                        this.Skirt01.xRot = -0.33F;
                        // this.Skirt01.offsetY = -0.23F;
                        this.Skirt02.xRot = -0.12F;
                        // this.Skirt02.offsetY = -0.16F;
                        this.Ahoke01.xRot += 0.38F;
                        this.Ahoke01.yRot = 0.8F;
                        this.Ahoke01.zRot = 0.4F;
                        this.Hair01.xRot -= 0.2F;
                        this.Hair02.xRot -= 0.25F;
                        this.Hair03.xRot -= 0.3F;
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
                        // [PORT] 1.10.2 -> 1.20.1: normal mount sit translate.
                        this.offsetY += 0.52F;

                        this.setFaceDamaged(ent);

                        // body
                        this.Head.xRot = 0.4F;
                        this.Skirt01.xRot = -0.64F;
                        // this.Skirt01.offsetY = -0.17F;
                        // this.Skirt01.offsetZ = 0F;
                        this.Skirt02.xRot = 0.29F;
                        // this.Skirt02.offsetY = -0.04F;
                        // this.Skirt02.offsetZ = 0.02F;
                        this.Hair01.xRot -= 0.2F;
                        this.Hair02.xRot -= 0.15F;
                        this.Hair03.xRot -= 0.1F;
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
                    // [PORT] 1.10.2 -> 1.20.1: normal mount moving translate.
                    this.offsetY += 0.495F;

                    // body
                    this.Head.xRot -= 0.7F;
                    this.BodyMain.xRot = 0.35F;
                    this.Hair01.xRot += 0.3F;
                    this.Hair02.xRot += 0.3F;
                    this.Hair03.xRot += 0.3F;
                    this.Skirt01.xRot = -0.32F;
                    // this.Skirt01.offsetY = -0.05F;
                    this.Skirt02.xRot = -0.21F;
                    this.Collar01.xRot += 0.1F;
                    this.Collar03.xRot += 0.1F;
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
        if (ent.getAttackTick() > 0) {
            if (ent.getAttackTick() > 14) {
                if (ent.getIsRiding()) {
                    // [PORT] 1.10.2 -> 1.20.1: riding attack startup translate.
                    this.offsetY += 0.02F;

                    // body
                    this.Head.xRot *= 0.5F;
                    this.Head.yRot *= 0.75F;
                    this.Head.xRot -= 0.5F;
                    this.BodyMain.xRot = 1.1F;
                    this.Collar01.xRot -= 0.2F;
                    // hair
                    this.Ahoke01.xRot += 0.38F;
                    this.Ahoke01.yRot = 0.8F;
                    this.Ahoke01.zRot = 0.4F;
                    this.Hair01.xRot += 0.2F;
                    this.Hair02.xRot -= 0.1F;
                    this.Hair03.xRot -= 0.1F;
                    addHL1 = -0.6F;
                    addHR1 = -0.6F;
                    addHL2 = -0.5F;
                    addHR2 = -0.5F;
                    // leg
                    addk1 = -1.8F;
                    addk2 = -1.8F;
                    this.LegLeft01.yRot = -0.1F;
                    this.LegRight01.yRot = 0.1F;
                    // equip
                    this.GlowEquipBase.xRot = 0.5F;
                } else {
                    // [PORT] 1.10.2 -> 1.20.1: ground attack startup translate.
                    this.offsetY += 0.22F;

                    // body
                    this.Head.xRot *= 0.5F;
                    this.Head.yRot *= 0.75F;
                    this.Head.xRot -= 1.6F;
                    this.BodyMain.xRot = 1.6F;
                    this.Collar01.xRot -= 0.5F;
                    this.Collar03.xRot -= 0.5F;
                    this.Collar04.xRot -= 0.5F;
                    // hair
                    this.Ahoke01.xRot += 0.38F;
                    this.Ahoke01.yRot = 0.8F;
                    this.Ahoke01.zRot = 0.4F;
                    this.Hair01.xRot += 1.0F;
                    this.Hair02.xRot += 0.6F;
                    this.Hair03.xRot += 0.7F;
                    addHL1 = -0.6F;
                    addHR1 = -0.6F;
                    addHL2 = -0.5F;
                    addHR2 = -0.5F;
                    // leg
                    addk1 = -2.2F;
                    addk2 = -2.2F;
                    this.LegLeft01.yRot = -0.1F;
                    this.LegRight01.yRot = 0.1F;
                    // equip
                    this.GlowEquipBase.xRot = 0F;
                }

                // body
                this.Skirt01.xRot = -0.33F;
                // this.Skirt01.offsetY = -0.23F;
                this.Skirt02.xRot = -0.12F;
                // this.Skirt02.offsetY = -0.16F;
                // arm
                this.ArmLeft01.xRot = -1.6F;
                this.ArmLeft01.yRot = -0.2F;
                this.ArmRight01.xRot = -1.2F;
                this.ArmRight01.yRot = 1.2F;
            }
        }

        // 跑道顯示
        // Torpedo visual parts are positioned statically in the constructor; no runtime
        // animation needed

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
        this.HairL01.xRot = angleX * 0.02F + headX - 0.19F + addHL1;
        this.HairL02.xRot = -angleX1 * 0.04F + headX + 0.17F + addHL2;
        this.HairR01.xRot = angleX * 0.02F + headX - 0.19F + addHR1;
        this.HairR02.xRot = -angleX1 * 0.04F + headX + 0.17F + addHR2;
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
