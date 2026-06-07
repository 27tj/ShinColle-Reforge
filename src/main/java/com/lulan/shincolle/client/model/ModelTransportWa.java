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

public class ModelTransportWa extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "ap_wa"), "main");

    private final ModelPart BodyMain;
    private final ModelPart BoobR;
    private final ModelPart BoobL;
    private final ModelPart Butt;
    private final ModelPart Head;
    private final ModelPart ArmLeft01;
    private final ModelPart ArmRight01;
    private final ModelPart Cloth03;
    private final ModelPart EquipBase;
    private final ModelPart Cloth01b;
    private final ModelPart Cloth01a;
    private final ModelPart Cloth2b;
    private final ModelPart Cloth2a;
    private final ModelPart LegRight01;
    private final ModelPart LegLeft01;
    private final ModelPart LegRight02;
    private final ModelPart LegLeft02;
    private final ModelPart ClothLeg;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart EquipHeadBase;
    private final ModelPart Ahoke;
    private final ModelPart HairU01;
    private final ModelPart Hair01;
    private final ModelPart ClothHead;
    private final ModelPart EquipHead01;
    private final ModelPart EquipHead02;
    private final ModelPart EquipHead03;
    private final ModelPart EquipHead04;
    private final ModelPart EquipHead05;
    private final ModelPart EquipHead06;
    private final ModelPart ArmLeft02;
    private final ModelPart ArmRight02;
    private final ModelPart Cloth04;
    private final ModelPart Cloth00a;
    private final ModelPart Cloth00b;
    private final ModelPart Cloth00c;
    private final ModelPart Cloth00d;
    private final ModelPart EquipBack01a;
    private final ModelPart EquipBack01b;
    private final ModelPart EquipBack01c;
    private final ModelPart EquipBack01d;
    private final ModelPart EquipBack01e;
    private final ModelPart EquipBack01f;
    private final ModelPart EquipBack01g;
    private final ModelPart EquipBack01h;
    private final ModelPart EquipBack01i;
    private final ModelPart EquipBack01j;
    private final ModelPart EquipBack01k;
    private final ModelPart EquipBack01l;
    private final ModelPart EquipBack01m;
    private final ModelPart EquipBack01n;
    private final ModelPart EquipBack01o;
    private final ModelPart EquipBack01p;
    private final ModelPart EquipBack01q;
    private final ModelPart EquipBack01r;
    private final ModelPart EquipTubeR01;
    private final ModelPart EquipTubeL01;
    private final ModelPart EquipBack01s;
    private final ModelPart EquipBack01t;
    private final ModelPart EquipBack01u;
    private final ModelPart EquipBack01v;
    private final ModelPart EquipBack01w;
    private final ModelPart EquipBack01x;
    private final ModelPart EquipBack01y;
    private final ModelPart EquipBack01z;
    private final ModelPart EquipBack01za;
    private final ModelPart EquipBack01zb;
    private final ModelPart EquipBack01zc;
    private final ModelPart EquipBack01zd;
    private final ModelPart EquipTubeR02;
    private final ModelPart EquipTubeR03;
    private final ModelPart EquipTubeL02;
    private final ModelPart EquipTubeL03;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowBodyMain2;
    private final ModelPart GlowHead;
    private final ModelPart GlowEquipBase;
    private final ModelPart GlowEquipTubeL01;
    private final ModelPart GlowEquipTubeL02;
    private final ModelPart GlowEquipTubeR01;
    private final ModelPart GlowEquipTubeR02;

    public ModelTransportWa(ModelPart root) {
        super();
        this.scale = 0.4F;
        this.offsetY = 2.35F;
        this.BodyMain = root.getChild("BodyMain");
        this.Head = this.BodyMain.getChild("Head");
        this.Cloth01b = this.BodyMain.getChild("Cloth01b");
        this.Butt = this.BodyMain.getChild("Butt");
        this.Cloth01a = this.BodyMain.getChild("Cloth01a");
        this.EquipBase = this.BodyMain.getChild("EquipBase");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.Cloth03 = this.BodyMain.getChild("Cloth03");
        this.BoobL = this.BodyMain.getChild("BoobL");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.BoobR = this.BodyMain.getChild("BoobR");
        this.EquipHeadBase = this.Head.getChild("EquipHeadBase");
        this.HairMain = this.Head.getChild("HairMain");
        this.Hair = this.Head.getChild("Hair");
        this.LegLeft01 = this.Butt.getChild("LegLeft01");
        this.LegRight01 = this.Butt.getChild("LegRight01");
        this.EquipBack01t = this.EquipBase.getChild("EquipBack01t");
        this.EquipBack01m = this.EquipBase.getChild("EquipBack01m");
        this.EquipBack01v = this.EquipBase.getChild("EquipBack01v");
        this.EquipBack01j = this.EquipBase.getChild("EquipBack01j");
        this.EquipBack01q = this.EquipBase.getChild("EquipBack01q");
        this.EquipBack01x = this.EquipBase.getChild("EquipBack01x");
        this.EquipBack01zb = this.EquipBase.getChild("EquipBack01zb");
        this.EquipBack01n = this.EquipBase.getChild("EquipBack01n");
        this.EquipBack01a = this.EquipBase.getChild("EquipBack01a");
        this.EquipBack01p = this.EquipBase.getChild("EquipBack01p");
        this.EquipBack01i = this.EquipBase.getChild("EquipBack01i");
        this.EquipBack01d = this.EquipBase.getChild("EquipBack01d");
        this.EquipBack01w = this.EquipBase.getChild("EquipBack01w");
        this.EquipBack01o = this.EquipBase.getChild("EquipBack01o");
        this.EquipTubeR01 = this.EquipBase.getChild("EquipTubeR01");
        this.EquipBack01g = this.EquipBase.getChild("EquipBack01g");
        this.EquipTubeL01 = this.EquipBase.getChild("EquipTubeL01");
        this.EquipBack01zc = this.EquipBase.getChild("EquipBack01zc");
        this.EquipBack01b = this.EquipBase.getChild("EquipBack01b");
        this.EquipBack01e = this.EquipBase.getChild("EquipBack01e");
        this.EquipBack01h = this.EquipBase.getChild("EquipBack01h");
        this.EquipBack01s = this.EquipBase.getChild("EquipBack01s");
        this.EquipBack01r = this.EquipBase.getChild("EquipBack01r");
        this.EquipBack01f = this.EquipBase.getChild("EquipBack01f");
        this.EquipBack01k = this.EquipBase.getChild("EquipBack01k");
        this.EquipBack01l = this.EquipBase.getChild("EquipBack01l");
        this.EquipBack01za = this.EquipBase.getChild("EquipBack01za");
        this.EquipBack01z = this.EquipBase.getChild("EquipBack01z");
        this.EquipBack01zd = this.EquipBase.getChild("EquipBack01zd");
        this.EquipBack01u = this.EquipBase.getChild("EquipBack01u");
        this.EquipBack01y = this.EquipBase.getChild("EquipBack01y");
        this.EquipBack01c = this.EquipBase.getChild("EquipBack01c");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.Cloth00b = this.Cloth03.getChild("Cloth00b");
        this.Cloth04 = this.Cloth03.getChild("Cloth04");
        this.Cloth00d = this.Cloth03.getChild("Cloth00d");
        this.Cloth00a = this.Cloth03.getChild("Cloth00a");
        this.Cloth00c = this.Cloth03.getChild("Cloth00c");
        this.Cloth2a = this.BoobL.getChild("Cloth2a");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.Cloth2b = this.BoobR.getChild("Cloth2b");
        this.EquipHead03 = this.EquipHeadBase.getChild("EquipHead03");
        this.EquipHead04 = this.EquipHeadBase.getChild("EquipHead04");
        this.EquipHead05 = this.EquipHeadBase.getChild("EquipHead05");
        this.EquipHead06 = this.EquipHeadBase.getChild("EquipHead06");
        this.EquipHead02 = this.EquipHeadBase.getChild("EquipHead02");
        this.EquipHead01 = this.EquipHeadBase.getChild("EquipHead01");
        this.Hair01 = this.HairMain.getChild("Hair01");
        this.ClothHead = this.HairMain.getChild("ClothHead");
        this.HairU01 = this.Hair.getChild("HairU01");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
        this.ClothLeg = this.LegLeft01.getChild("ClothLeg");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.EquipTubeR02 = this.EquipTubeR01.getChild("EquipTubeR02");
        this.EquipTubeL02 = this.EquipTubeL01.getChild("EquipTubeL02");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowBodyMain2 = root.getChild("GlowBodyMain2");
        this.GlowHead = this.GlowBodyMain.getChild("GlowHead");
        this.GlowEquipBase = this.GlowBodyMain2.getChild("GlowEquipBase");
        this.GlowEquipTubeL01 = this.GlowEquipBase.getChild("GlowEquipTubeL01");
        this.GlowEquipTubeR01 = this.GlowEquipBase.getChild("GlowEquipTubeR01");
        this.GlowEquipTubeL02 = this.GlowEquipTubeL01.getChild("GlowEquipTubeL02");
        this.GlowEquipTubeR02 = this.GlowEquipTubeR01.getChild("GlowEquipTubeR02");
        this.EquipTubeL03 = this.GlowEquipTubeL02.getChild("EquipTubeL03");
        this.EquipTubeR03 = this.GlowEquipTubeR02.getChild("EquipTubeR03");
        this.loadFaceParts(this.GlowHead);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 105)
                        .addBox(-6.5F, -11.0F, -4.0F, 13.0F, 16.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, -11.0F, -3.0F, -0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition head = bodyMain.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, -11.8F, -1.0F, 0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition equipHeadBase = head.addOrReplaceChild("EquipHeadBase",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offset(0.0F, -13.8F, 0.0F));

        equipHeadBase.addOrReplaceChild("EquipHead03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-8.0F, 0.0F, -9.0F, 16.0F, 10.0F, 16.0F),
                PartPose.offsetAndRotation(0.0F, -4.3F, -7.0F, 0.2617993877991494F, 0.0F, 0.0F));

        equipHeadBase.addOrReplaceChild("EquipHead04",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 9.0F, 16.0F),
                PartPose.offsetAndRotation(0.0F, -5.2F, -2.8F, -0.5009094953223726F,
                        -0.7213445798492564F, 0.34487706019407954F));

        equipHeadBase.addOrReplaceChild("EquipHead05",
                CubeListBuilder.create().texOffs(0, 63)
                        .addBox(-7.0F, 0.0F, 0.0F, 14.0F, 5.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 7.3F, -12.0F, 0.3141592653589793F, 0.0F, 0.0F));

        equipHeadBase.addOrReplaceChild("EquipHead06",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        equipHeadBase.addOrReplaceChild("EquipHead02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-15.0F, 0.0F, 0.0F, 15.0F, 9.0F, 16.0F),
                PartPose.offsetAndRotation(-4.0F, -3.0F, -12.0F, 0.0F, 0.3490658503988659F,
                        -0.20943951023931953F));

        equipHeadBase.addOrReplaceChild("EquipHead01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 15.0F, 9.0F, 16.0F),
                PartPose.offsetAndRotation(4.0F, -3.0F, -12.0F, 0.0F, -0.3490658503988659F,
                        0.20943951023931953F));

        PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(47, 104)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F),
                PartPose.offset(0.0F, -14.8F, -3.0F));

        hairMain.addOrReplaceChild("Hair01",
                CubeListBuilder.create().texOffs(0, 32)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 9.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 7.2F, 1.1F, 0.08726646259971647F, 0.0F, 0.0F));

        hairMain.addOrReplaceChild("ClothHead",
                CubeListBuilder.create().texOffs(48, 0)
                        .addBox(-8.0F, 0.0F, 0.0F, 16.0F, 10.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, -1.1F, 1.5F, -0.06981317007977318F, 0.0F, 0.0F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(50, 81)
                        .addBox(-8.0F, -8.0F, -7.4F, 16.0F, 12.0F, 8.0F),
                PartPose.offset(0.0F, -7.5F, 0.4F));

        hair.addOrReplaceChild("HairU01",
                CubeListBuilder.create().texOffs(50, 45)
                        .addBox(-8.5F, 0.0F, 0.0F, 17.0F, 14.0F, 7.0F),
                PartPose.offset(0.0F, -6.0F, -6.5F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(104, 29)
                        .addBox(0.0F, -12.0F, -6.5F, 0.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, -4.5F, 1.2F, 0.6981317007977318F, 0.0F));

        bodyMain.addOrReplaceChild("Cloth01b",
                CubeListBuilder.create().mirror().texOffs(96, 19)
                        .addBox(-4.0F, 0.0F, -4.0F, 8.0F, 14.0F, 8.0F),
                PartPose.offsetAndRotation(-5.6F, -11.6F, -0.6F, 0.03490658503988659F, 0.0F,
                        -0.08726646259971647F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(52, 66)
                        .addBox(-7.5F, 0.0F, -5.7F, 15.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 3.0F, 1.3F, 0.3141592653589793F, 0.0F, 0.0F));

        PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().mirror().texOffs(0, 83)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F),
                PartPose.offsetAndRotation(4.4F, 5.5F, -2.6F, -0.24434609527920614F, 0.0F,
                        0.10471975511965977F));

        legLeft01.addOrReplaceChild("LegLeft02",
                CubeListBuilder.create().mirror().texOffs(0, 83)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 13.0F, 6.0F),
                PartPose.offset(-3.0F, 12.0F, -3.0F));

        legLeft01.addOrReplaceChild("ClothLeg",
                CubeListBuilder.create().texOffs(30, 78)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F),
                PartPose.offset(0.0F, 4.0F, 0.0F));

        PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().texOffs(0, 83)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F),
                PartPose.offsetAndRotation(-4.4F, 5.5F, -2.6F, -0.13962634015954636F, 0.0F,
                        -0.10471975511965977F));

        legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().texOffs(0, 83)
                        .addBox(-6.0F, 0.0F, 0.0F, 6.0F, 13.0F, 6.0F),
                PartPose.offset(3.0F, 12.0F, -3.0F));

        bodyMain.addOrReplaceChild("Cloth01a",
                CubeListBuilder.create().texOffs(96, 19)
                        .addBox(-4.0F, 0.0F, -4.0F, 8.0F, 14.0F, 8.0F),
                PartPose.offsetAndRotation(5.6F, -11.6F, -0.6F, 0.03490658503988659F, 0.0F,
                        0.08726646259971647F));

        PartDefinition equipBase = bodyMain.addOrReplaceChild("EquipBase",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, -4.5F, 7.5F, 0.05235987755982988F, 0.0F, 0.0F));

        equipBase.addOrReplaceChild("EquipBack01t",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, 6.0F),
                PartPose.offset(0.0F, -10.0F, 32.0F));

        equipBase.addOrReplaceChild("EquipBack01m",
                CubeListBuilder.create().texOffs(21, 6)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 10.0F),
                PartPose.offset(16.0F, -10.0F, 16.0F));

        equipBase.addOrReplaceChild("EquipBack01v",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, 6.0F),
                PartPose.offset(-10.0F, 0.0F, 32.0F));

        equipBase.addOrReplaceChild("EquipBack01j",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F),
                PartPose.offset(-16.0F, -16.0F, 16.0F));

        equipBase.addOrReplaceChild("EquipBack01q",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 10.0F),
                PartPose.offset(-22.0F, 0.0F, 16.0F));

        equipBase.addOrReplaceChild("EquipBack01x",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 10.0F, 6.0F, 10.0F),
                PartPose.offset(0.0F, -22.0F, 16.0F));

        equipBase.addOrReplaceChild("EquipBack01zb",
                CubeListBuilder.create().mirror().texOffs(0, 14)
                        .addBox(0.0F, 0.0F, 0.0F, 10.0F, 6.0F, 10.0F),
                PartPose.offset(-10.0F, 16.0F, 6.0F));

        equipBase.addOrReplaceChild("EquipBack01n",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 10.0F),
                PartPose.offset(16.0F, 0.0F, 16.0F));

        equipBase.addOrReplaceChild("EquipBack01a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F),
                PartPose.offset(0.0F, -16.0F, 0.0F));

        equipBase.addOrReplaceChild("EquipBack01p",
                CubeListBuilder.create().texOffs(7, 6)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 10.0F),
                PartPose.offset(-22.0F, -10.0F, 6.0F));

        equipBase.addOrReplaceChild("EquipBack01i",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F),
                PartPose.offset(-16.0F, 0.0F, 16.0F));

        equipBase.addOrReplaceChild("EquipBack01d",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F),
                PartPose.offset(-16.0F, 0.0F, 0.0F));

        equipBase.addOrReplaceChild("EquipBack01w",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 10.0F, 6.0F, 10.0F),
                PartPose.offset(0.0F, -22.0F, 6.0F));

        equipBase.addOrReplaceChild("EquipBack01o",
                CubeListBuilder.create().texOffs(26, 12)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 10.0F),
                PartPose.offset(-22.0F, 0.0F, 6.0F));

        PartDefinition equipTubeR01 = equipBase.addOrReplaceChild("EquipTubeR01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-4.0F, 0.0F, -4.0F, 8.0F, 16.0F, 8.0F),
                PartPose.offsetAndRotation(-18.0F, 3.0F, 28.0F, -0.3490658503988659F,
                        0.13962634015954636F, 0.13962634015954636F));

        equipTubeR01.addOrReplaceChild("EquipTubeR02",
                CubeListBuilder.create().texOffs(10, 0)
                        .addBox(-4.5F, 0.0F, -8.5F, 9.0F, 16.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 16.0F, 4.0F, -0.9560913642424937F, 0.0F, 0.0F));

        equipBase.addOrReplaceChild("EquipBack01g",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F),
                PartPose.offset(0.0F, 0.0F, 16.0F));

        PartDefinition equipTubeL01 = equipBase.addOrReplaceChild("EquipTubeL01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-4.0F, 0.0F, -4.0F, 8.0F, 16.0F, 8.0F),
                PartPose.offsetAndRotation(18.0F, 3.0F, 28.0F, -0.3490658503988659F,
                        -0.13962634015954636F, -0.13962634015954636F));

        equipTubeL01.addOrReplaceChild("EquipTubeL02",
                CubeListBuilder.create().texOffs(12, 0)
                        .addBox(-4.5F, 0.0F, -8.5F, 9.0F, 16.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 16.0F, 4.0F, -0.9560913642424937F, 0.0F, 0.0F));

        equipBase.addOrReplaceChild("EquipBack01zc",
                CubeListBuilder.create().mirror().texOffs(7, 13)
                        .addBox(0.0F, 0.0F, 0.0F, 10.0F, 6.0F, 10.0F),
                PartPose.offset(-10.0F, 16.0F, 16.0F));

        equipBase.addOrReplaceChild("EquipBack01b",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F),
                PartPose.offset(-16.0F, -16.0F, 0.0F));

        equipBase.addOrReplaceChild("EquipBack01e",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 10.0F, 16.0F, 4.0F),
                PartPose.offset(-10.0F, -6.0F, -4.0F));

        equipBase.addOrReplaceChild("EquipBack01h",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F),
                PartPose.offset(0.0F, -16.0F, 16.0F));

        equipBase.addOrReplaceChild("EquipBack01s",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, 6.0F),
                PartPose.offset(0.0F, 0.0F, 32.0F));

        equipBase.addOrReplaceChild("EquipBack01r",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 10.0F),
                PartPose.offset(-22.0F, -10.0F, 16.0F));

        equipBase.addOrReplaceChild("EquipBack01f",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 10.0F, 16.0F, 4.0F),
                PartPose.offset(0.0F, -6.0F, -4.0F));

        equipBase.addOrReplaceChild("EquipBack01k",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 10.0F),
                PartPose.offset(16.0F, 0.0F, 6.0F));

        equipBase.addOrReplaceChild("EquipBack01l",
                CubeListBuilder.create().mirror().texOffs(0, 11)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 10.0F),
                PartPose.offset(16.0F, -10.0F, 6.0F));

        equipBase.addOrReplaceChild("EquipBack01za",
                CubeListBuilder.create().texOffs(0, 16)
                        .addBox(0.0F, 0.0F, 0.0F, 10.0F, 6.0F, 10.0F),
                PartPose.offset(0.0F, 16.0F, 6.0F));

        equipBase.addOrReplaceChild("EquipBack01z",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 10.0F, 6.0F, 10.0F),
                PartPose.offset(-10.0F, -22.0F, 6.0F));

        equipBase.addOrReplaceChild("EquipBack01zd",
                CubeListBuilder.create().texOffs(0, 6)
                        .addBox(0.0F, 0.0F, 0.0F, 10.0F, 6.0F, 10.0F),
                PartPose.offset(0.0F, 16.0F, 16.0F));

        equipBase.addOrReplaceChild("EquipBack01u",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, 6.0F),
                PartPose.offset(-10.0F, -10.0F, 32.0F));

        equipBase.addOrReplaceChild("EquipBack01y",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 10.0F, 6.0F, 10.0F),
                PartPose.offset(-10.0F, -22.0F, 16.0F));

        equipBase.addOrReplaceChild("EquipBack01c",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().mirror().texOffs(2, 84)
                        .addBox(-2.0F, -1.0F, -2.5F, 5.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(7.8F, -9.7F, -0.7F, 0.0F, 0.0F, -0.20943951023931953F));

        armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().mirror().texOffs(2, 84)
                        .addBox(-5.0F, 0.0F, -5.0F, 5.0F, 11.0F, 5.0F),
                PartPose.offset(3.0F, 10.0F, 2.5F));

        PartDefinition cloth03 = bodyMain.addOrReplaceChild("Cloth03",
                CubeListBuilder.create().texOffs(58, 32)
                        .addBox(-7.0F, 0.0F, -4.7F, 14.0F, 4.0F, 9.0F),
                PartPose.offsetAndRotation(0.2F, 1.3F, -0.5F, 0.17453292519943295F, 0.0F,
                        0.08726646259971647F));

        cloth03.addOrReplaceChild("Cloth00b",
                CubeListBuilder.create().texOffs(19, 79)
                        .addBox(-7.0F, -2.0F, 0.0F, 7.0F, 4.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 0.5F, 3.3F, -0.20943951023931953F, 0.2617993877991494F,
                        0.17453292519943295F));

        cloth03.addOrReplaceChild("Cloth04",
                CubeListBuilder.create().texOffs(70, 21)
                        .addBox(-6.5F, 0.0F, 0.0F, 13.0F, 11.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 2.5F, -4.7F, -0.20943951023931953F, 0.0F,
                        -0.08726646259971647F));

        cloth03.addOrReplaceChild("Cloth00d",
                CubeListBuilder.create().texOffs(88, 101)
                        .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 12.0F, 0.0F),
                PartPose.offsetAndRotation(-0.8F, 1.0F, 4.5F, 0.3490658503988659F,
                        -0.13962634015954636F, 0.3141592653589793F));

        cloth03.addOrReplaceChild("Cloth00a",
                CubeListBuilder.create().mirror().texOffs(19, 79)
                        .addBox(0.0F, -2.0F, 0.0F, 7.0F, 4.0F, 2.0F),
                PartPose.offsetAndRotation(0.5F, 0.5F, 3.5F, -0.091106186954104F, -0.2617993877991494F,
                        -0.17453292519943295F));

        cloth03.addOrReplaceChild("Cloth00c",
                CubeListBuilder.create().mirror().texOffs(88, 101)
                        .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 12.0F, 0.0F),
                PartPose.offsetAndRotation(1.3F, 1.0F, 4.5F, 0.3141592653589793F, 0.13962634015954636F,
                        -0.3490658503988659F));

        PartDefinition boobL = bodyMain.addOrReplaceChild("BoobL",
                CubeListBuilder.create().mirror().texOffs(33, 101)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(4.1F, -8.5F, -3.7F, -0.6981317007977318F, 0.0785F, 0.0785F));

        boobL.addOrReplaceChild("Cloth2a",
                CubeListBuilder.create().texOffs(26, 89)
                        .addBox(0.0F, 0.0F, 0.0F, 5.0F, 6.0F, 6.0F),
                PartPose.offsetAndRotation(-1.2F, -0.5F, -0.7F, 0.0F, -0.0785F, -0.0785F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().texOffs(2, 84)
                        .addBox(-3.0F, -1.0F, -2.5F, 5.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(-7.8F, -9.7F, -0.7F, 0.20943951023931953F, 0.0F,
                        0.20943951023931953F));

        armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().texOffs(2, 84)
                        .addBox(0.0F, 0.0F, -5.0F, 5.0F, 11.0F, 5.0F),
                PartPose.offset(-3.0F, 10.0F, 2.5F));

        PartDefinition boobR = bodyMain.addOrReplaceChild("BoobR",
                CubeListBuilder.create().texOffs(33, 101)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(-4.1F, -8.5F, -3.7F, -0.6981317007977318F, -0.0785F,
                        -0.0785F));

        boobR.addOrReplaceChild("Cloth2b",
                CubeListBuilder.create().mirror().texOffs(26, 89)
                        .addBox(-5.0F, 0.0F, 0.0F, 5.0F, 6.0F, 6.0F),
                PartPose.offsetAndRotation(1.2F, -0.5F, -0.7F, 0.0F, 0.0785F, 0.0785F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -11.0F, -3.0F));

        PartDefinition glowHead = glowBodyMain.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -11.8F, -1.0F));
        addDefaultFaceParts(glowHead);

        PartDefinition glowBodyMain2 = partdefinition.addOrReplaceChild("GlowBodyMain2",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -11.0F, -3.0F));

        PartDefinition glowEquipBase = glowBodyMain2.addOrReplaceChild("GlowEquipBase",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -4.5F, 7.5F));

        PartDefinition glowEquipTubeL01 = glowEquipBase.addOrReplaceChild("GlowEquipTubeL01",
                CubeListBuilder.create(),
                PartPose.offset(18.0F, 3.0F, 28.0F));

        PartDefinition glowEquipTubeL02 = glowEquipTubeL01.addOrReplaceChild("GlowEquipTubeL02",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 16.0F, 4.0F));

        glowEquipTubeL02.addOrReplaceChild("EquipTubeL03",
                CubeListBuilder.create().texOffs(92, 0)
                        .addBox(-4.5F, 0.0F, -4.5F, 9.0F, 3.0F, 9.0F),
                PartPose.offset(0.0F, 16.1F, -4.0F));

        PartDefinition glowEquipTubeR01 = glowEquipBase.addOrReplaceChild("GlowEquipTubeR01",
                CubeListBuilder.create(),
                PartPose.offset(-18.0F, 3.0F, 28.0F));

        PartDefinition glowEquipTubeR02 = glowEquipTubeR01.addOrReplaceChild("GlowEquipTubeR02",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 16.0F, 4.0F));

        glowEquipTubeR02.addOrReplaceChild("EquipTubeR03",
                CubeListBuilder.create().texOffs(92, 0)
                        .addBox(-4.5F, 0.0F, -4.5F, 9.0F, 3.0F, 9.0F),
                PartPose.offset(0.0F, 16.1F, -4.0F));

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

        boolean flag = !EmotionHelper.checkModelState(0, state); // equip
        this.EquipBase.visible = !flag;
        this.GlowEquipBase.visible = !flag;

        flag = !EmotionHelper.checkModelState(1, state); // leg

        if (flag) {
            this.EquipBase.visible = true;
            this.GlowEquipBase.visible = true;
            this.LegLeft01.visible = false;
            this.LegRight01.visible = false;
        } else {
            this.LegLeft01.visible = true;
            this.LegRight01.visible = true;
        }

        flag = !EmotionHelper.checkModelState(2, state); // hat
        this.EquipHeadBase.visible = !flag;
        this.Ahoke.visible = flag; // Ahoke: visible when hat state OFF (original: isHidden = !flag)
    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowBodyMain.xRot = this.BodyMain.xRot;
        this.GlowBodyMain.yRot = this.BodyMain.yRot;
        this.GlowBodyMain.zRot = this.BodyMain.zRot;
        this.GlowBodyMain2.xRot = this.BodyMain.xRot;
        this.GlowBodyMain2.yRot = this.BodyMain.yRot;
        this.GlowBodyMain2.zRot = this.BodyMain.zRot;
        this.GlowHead.xRot = this.Head.xRot;
        this.GlowHead.yRot = this.Head.yRot;
        this.GlowHead.zRot = this.Head.zRot;
        this.GlowEquipBase.xRot = this.EquipBase.xRot;
        this.GlowEquipBase.yRot = this.EquipBase.yRot;
        this.GlowEquipBase.zRot = this.EquipBase.zRot;
        this.GlowEquipTubeL01.xRot = this.EquipTubeL01.xRot;
        this.GlowEquipTubeL01.yRot = this.EquipTubeL01.yRot;
        this.GlowEquipTubeL01.zRot = this.EquipTubeL01.zRot;
        this.GlowEquipTubeR01.xRot = this.EquipTubeR01.xRot;
        this.GlowEquipTubeR01.yRot = this.EquipTubeR01.yRot;
        this.GlowEquipTubeR01.zRot = this.EquipTubeR01.zRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += 0.12F;
        this.setFaceHungry(ent);

        // 頭部
        this.Head.xRot = 0.3F;
        this.Head.yRot = 0F;
        // 胸部
        this.BoobL.xRot = -0.75F;
        this.BoobR.xRot = -0.75F;
        // Body
        this.Ahoke.yRot = 0.7F;
        this.BodyMain.xRot = 2.8F;
        this.Cloth03.xRot = 0.17F;
        this.Cloth04.xRot = -0.8F;
        this.Butt.xRot = -1.1F;
        // this.Butt.offsetZ = 0.1F;
        // arm
        this.ArmLeft01.xRot = -0.35F;
        this.ArmLeft01.zRot = -2.6F;
        this.ArmRight01.xRot = -0.35F;
        this.ArmRight01.zRot = 2.6F;
        // leg
        this.LegLeft01.xRot = -0.24F;
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.1047F;
        this.LegRight01.xRot = -0.14F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.1047F;
        // equip
        this.EquipBase.visible = true;
        // this.EquipBase.offsetY = 0.45F;
        // this.EquipBase.offsetZ = -0.85F;
        this.EquipBase.xRot = -3.1F;
        this.EquipTubeL01.xRot = -0.3F;
        this.EquipTubeR01.xRot = -0.3F;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float angleX = Mth.cos(f2 * 0.08F + f * 0.25F);
        float angleAdd1 = Mth.cos(f * 0.7F) * f1;
        float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
        float addk1;
        float addk2;

        // 水上漂浮
        if (ent.getShipDepth(0) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        // leg move
        addk1 = angleAdd1 * 0.5F - 0.24F; // LegLeft01
        addk2 = angleAdd2 * 0.5F - 0.14F; // LegRight01

        // 頭部
        this.Head.xRot = f4 * 0.014F + 0.1047F;
        this.Head.yRot = f3 * 0.01F;
        // 胸部
        this.BoobL.xRot = angleX * 0.05F - 0.75F;
        this.BoobR.xRot = angleX * 0.05F - 0.75F;
        // Body
        this.Ahoke.yRot = angleX * 0.25F + 0.7F;
        this.BodyMain.xRot = -0.1047F;
        this.Butt.xRot = 0.3142F;
        // this.Butt.offsetY = 0F;
        // this.Butt.offsetZ = 0F;
        this.Cloth03.xRot = 0.1745F;
        this.Cloth04.xRot = angleX * 0.05F - 0.15F;
        // arm
        this.ArmLeft01.xRot = angleAdd2 * 0.25F + 0.21F;
        this.ArmLeft01.zRot = angleX * 0.03F - 0.21F;
        this.ArmRight01.xRot = angleAdd1 * 0.25F + 0.05F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = -angleX * 0.03F + 0.21F;
        // leg
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.1047F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.1047F;
        // equip
        this.EquipBase.xRot = 0.05236F;
        // this.EquipBase.offsetY = 0F;
        // this.EquipBase.offsetZ = 0F;
        this.EquipTubeL01.xRot = angleX * 0.08F - 0.35F;
        this.EquipTubeR01.xRot = -angleX * 0.08F - 0.35F;

        boolean hideLeg = !EmotionHelper.checkModelState(1, ent.getStateEmotion(ID.S.State));

        // fly mode
        if (hideLeg) {
            // body
            this.Cloth04.xRot += 0.23F;
            this.Butt.xRot = 0.7F;
            // this.Butt.offsetY = -0.1F;
            // this.Butt.offsetZ = -0.05F;
            // arm
            this.ArmLeft01.xRot += 0.2F;
            this.ArmLeft01.zRot -= 0.3F;
            this.ArmRight01.xRot += 0.2F;
            this.ArmRight01.zRot += 0.3F;
            // equip
            this.EquipBase.xRot = -0.4F;
            this.EquipTubeL01.xRot += 0.35F;
            this.EquipTubeR01.xRot += 0.35F;
        }

        if (ent.getIsSprinting() || f1 > 0.9F) { // 奔跑動作
            // head
            this.Head.xRot -= 0.2F;
            // body
            this.BodyMain.xRot = 0.35F;
            this.Cloth04.xRot -= 0.4F;
            // arm
            this.ArmLeft01.zRot -= 0.2F + f1 * 0.25F;
            this.ArmRight01.zRot += 0.2F + f1 * 0.25F;
            // leg
            addk1 -= 0.45F;
            addk2 -= 0.45F;
        }

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        if (ent.getIsSneaking()) {
            // 潛行, 蹲下動作
            // Body
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.05F;
            this.Head.xRot -= 1.0472F;
            this.BodyMain.xRot = 1.0472F;
            if (hideLeg) {
                this.Butt.xRot = 0.8F;
            } else {
                this.Butt.xRot = -0.8378F;
            }
            this.Cloth03.xRot -= 0.7F;
            this.Cloth04.xRot -= 0.45F;
            // arm
            this.ArmLeft01.xRot = -0.7F;
            this.ArmLeft01.zRot = 0.2618F;
            this.ArmRight01.xRot = -0.7F;
            this.ArmRight01.zRot = -0.2618F;
        } // end if sneaking

        if (ent.getIsSitting() || ent.getIsRiding()) { // 騎乘動作
            float ax = Mth.cos(f2 * 0.5F) * 0.5F;

            // fly mode
            if (hideLeg) {
                if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                    // [PORT] Restored from 1.10.2 GlStateManager.translate
                    this.offsetY += 0.54F;
                    setFace(3);

                    // body
                    this.Head.xRot = -0.9F;
                    this.Head.yRot = 0F;
                    this.Head.zRot = 0F;
                    this.Ahoke.yRot = 0.5236F;
                    this.BodyMain.xRot = 1.4835F;
                    // arm
                    this.ArmLeft01.xRot = ax + 0.25F;
                    this.ArmLeft01.zRot = -2.3F;
                    this.ArmRight01.xRot = -ax + 0.25F;
                    this.ArmRight01.zRot = 2.3F;
                    // leg
                    this.LegLeft01.yRot = 0F;
                    this.LegLeft01.zRot = 0.03F;
                    this.LegRight01.yRot = 0F;
                    this.LegRight01.zRot = -0.03F;
                } else {
                    // [PORT] Restored from 1.10.2 GlStateManager.translate
                    this.offsetY -= 0.17F;
                    setFace(1);

                    // body
                    this.Head.xRot = -0.7F;
                    this.Head.yRot = 0F;
                    this.Head.zRot = 0F;
                    this.Ahoke.yRot = 0.5236F;
                    this.BodyMain.xRot = -1.7453F;
                    this.Cloth04.xRot = 0.4F;
                    // arm
                    this.ArmLeft01.xRot = 0.85F;
                    this.ArmLeft01.zRot = -2.3F;
                    this.ArmRight01.xRot = 0.85F;
                    this.ArmRight01.zRot = 2.3F;
                    // leg
                    this.LegLeft01.yRot = 0F;
                    this.LegLeft01.zRot = 0.03F;
                    this.LegRight01.yRot = 0F;
                    this.LegRight01.zRot = -0.03F;
                    // equip
                    this.EquipTubeL01.xRot = 1.3F;
                    this.EquipTubeR01.xRot = 1.3F;
                }
            } else {
                if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                    setFace(3);

                    // body
                    this.Head.xRot = -0.7F;
                    this.Head.yRot = 0F;
                    this.Head.zRot = 0F;
                    this.Ahoke.yRot = 0.5236F;
                    this.BodyMain.xRot = 1.4835F;
                    // arm
                    this.ArmLeft01.xRot = ax + 0.25F;
                    this.ArmLeft01.zRot = -2.3F;
                    this.ArmRight01.xRot = -ax + 0.25F;
                    this.ArmRight01.zRot = 2.3F;
                    // leg
                    addk1 = -ax + 0.2F;
                    addk2 = ax + 0.2F;
                    this.LegLeft01.yRot = 0F;
                    this.LegLeft01.zRot = 0.03F;
                    this.LegRight01.yRot = 0F;
                    this.LegRight01.zRot = -0.03F;
                } else {
                    // body
                    // [PORT] Restored from 1.10.2 GlStateManager.translate
                    this.offsetY += 0.42F;
                    this.Head.xRot -= 0.7F;
                    this.BodyMain.xRot = 0.5236F;
                    // arm
                    this.ArmLeft01.xRot = -0.5236F;
                    this.ArmLeft01.zRot = 0.3146F;
                    this.ArmRight01.xRot = -0.5236F;
                    this.ArmRight01.zRot = -0.3146F;
                    // leg
                    addk1 = -2.2689F;
                    addk2 = -2.2689F;
                    this.LegLeft01.yRot = -0.3491F;
                    this.LegRight01.yRot = 0.3491F;
                    // equip
                    this.EquipBase.xRot = -0.4F;
                    this.EquipTubeL01.xRot = 0.9F;
                    this.EquipTubeR01.xRot = 0.9F;
                }
            }
        } // end if sitting

        // 攻擊動作
        if (ent.getAttackTick() > 40) {
            // Body
            this.Head.xRot -= 1.0472F;
            this.BodyMain.xRot = 1.7F;
            this.Butt.xRot = -0.8378F;
            this.Cloth03.xRot -= 0.7F;
            this.Cloth04.xRot -= 1.1F;
            // arm
            this.ArmLeft01.xRot = -0.9F;
            this.ArmLeft01.zRot = 0.2618F;
            this.ArmRight01.xRot = -1.9F;
            this.ArmRight01.zRot = -0.2618F;
            // equip
            this.EquipBase.xRot = -1.4F;
            // leg
            addk1 -= 0.7F;
            addk2 -= 0.7F;
        }

        // swing arm
        float f6 = ent.getSwingTime(f2 % 1F);
        if (f6 != 0F) {
            float f7 = Mth.sin(f6 * f6 * (float) Math.PI);
            float f8 = Mth.sin(Mth.sqrt(f6) * (float) Math.PI);
            this.ArmRight01.xRot += -f8 * 80.0F * ((float) Math.PI / 180F);
            this.ArmRight01.yRot += -f7 * 20.0F * ((float) Math.PI / 180F) + 0.2F;
            this.ArmRight01.zRot += -f8 * 20.0F * ((float) Math.PI / 180F);
        }

        // leg motion
        this.LegLeft01.xRot = addk1;
        this.LegRight01.xRot = addk2;
    }
}
