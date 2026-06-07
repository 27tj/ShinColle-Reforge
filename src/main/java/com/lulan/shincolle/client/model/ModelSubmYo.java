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

public class ModelSubmYo extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "ss_yo"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Butt;
    private final ModelPart Head;
    private final ModelPart ArmLeft01;
    private final ModelPart ArmRight01;
    private final ModelPart BodyMain1;
    private final ModelPart BodyMain2;
    private final ModelPart BoobL;
    private final ModelPart BoobL2;
    private final ModelPart BoobR;
    private final ModelPart BoobR2;
    private final ModelPart Butt1;
    private final ModelPart Butt2;
    private final ModelPart EquipBase;
    private final ModelPart LegRight01;
    private final ModelPart LegLeft01;
    private final ModelPart LegRight02;
    private final ModelPart LegLeft02;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart Ahoke;
    private final ModelPart HairU01;
    private final ModelPart HairL01;
    private final ModelPart HairR01;
    private final ModelPart HairL02;
    private final ModelPart HairR02;
    private final ModelPart Hair01;
    private final ModelPart Hair02;
    private final ModelPart Hair03;
    private final ModelPart ArmLeft02;
    private final ModelPart ArmRight02;
    private final ModelPart EquipBody00;
    private final ModelPart EquipJaw00;
    private final ModelPart EquipHeadBack00;
    private final ModelPart EquipBody01;
    private final ModelPart EquipBody02;
    private final ModelPart EquipJaw00a;
    private final ModelPart EquipT01;
    private final ModelPart EquipJaw01;
    private final ModelPart EquipJaw02;
    private final ModelPart EquipJaw03;
    private final ModelPart EquipJaw04;
    private final ModelPart EquipJaw01a;
    private final ModelPart EquipJaw02a;
    private final ModelPart EquipJaw03a;
    private final ModelPart EquipJaw04a;
    private final ModelPart EquipT01a;
    private final ModelPart EquipT01b;
    private final ModelPart EquipT01c;
    private final ModelPart EquipHeadBack00a;
    private final ModelPart EquipHead00;
    private final ModelPart EquipT02;
    private final ModelPart EquipHead00a;
    private final ModelPart EquipHead00b;
    private final ModelPart EquipHead00c;
    private final ModelPart Eye01;
    private final ModelPart Eye02;
    private final ModelPart Eye03;
    private final ModelPart EquipHead01;
    private final ModelPart EquipHead02;
    private final ModelPart EquipHead03;
    private final ModelPart EquipHead04;
    private final ModelPart EquipHead01a;
    private final ModelPart EquipHead02a;
    private final ModelPart EquipHead03a;
    private final ModelPart EquipHead04a;
    private final ModelPart EquipE01a;
    private final ModelPart EquipE01b;
    private final ModelPart EquipE01c;
    private final ModelPart EquipE01d;
    private final ModelPart EquipT02a;
    private final ModelPart EquipT02b;
    private final ModelPart EquipT02c;
    private final ModelPart EquipS02a;
    private final ModelPart EquipS02b;
    private final ModelPart EquipS02c;
    private final ModelPart EquipS02d;
    private final ModelPart EquipS01a;
    private final ModelPart EquipS01b;
    private final ModelPart EquipS01c;
    private final ModelPart EquipS01d;
    private final ModelPart EquipT03;
    private final ModelPart EquipT04;
    private final ModelPart EquipT03a;
    private final ModelPart EquipT03b;
    private final ModelPart EquipT03c;
    private final ModelPart EquipT04a;
    private final ModelPart EquipT04b;
    private final ModelPart EquipT04c;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowHead;
    private final ModelPart GlowEquipBase;
    private final ModelPart GlowEquipBody00;
    private final ModelPart GlowEquipHeadBack00;
    private final ModelPart GlowEquipHeadBack00a;
    private final ModelPart GlowEquipHead00;
    private final ModelPart GlowEquipBody01;

    public ModelSubmYo(ModelPart root) {
        super();
        this.scale = 0.47F;
        this.offsetY = 1.78F;
        this.BodyMain = root.getChild("BodyMain");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.BodyMain2 = this.BodyMain.getChild("BodyMain2");
        this.BoobL2 = this.BodyMain.getChild("BoobL2");
        this.BoobR2 = this.BodyMain.getChild("BoobR2");
        this.Head = this.BodyMain.getChild("Head");
        this.Butt1 = this.BodyMain.getChild("Butt1");
        this.Butt = this.BodyMain.getChild("Butt");
        this.BodyMain1 = this.BodyMain.getChild("BodyMain1");
        this.BoobL = this.BodyMain.getChild("BoobL");
        this.EquipBase = this.BodyMain.getChild("EquipBase");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.Butt2 = this.BodyMain.getChild("Butt2");
        this.BoobR = this.BodyMain.getChild("BoobR");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.HairMain = this.Head.getChild("HairMain");
        this.Hair = this.Head.getChild("Hair");
        this.LegLeft01 = this.Butt.getChild("LegLeft01");
        this.LegRight01 = this.Butt.getChild("LegRight01");
        this.EquipBody00 = this.EquipBase.getChild("EquipBody00");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.Hair01 = this.HairMain.getChild("Hair01");
        this.HairL01 = this.Hair.getChild("HairL01");
        this.HairR01 = this.Hair.getChild("HairR01");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.HairU01 = this.Hair.getChild("HairU01");
        this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.EquipBody01 = this.EquipBody00.getChild("EquipBody01");
        this.EquipJaw00 = this.EquipBody00.getChild("EquipJaw00");
        this.EquipBody02 = this.EquipBody00.getChild("EquipBody02");
        this.EquipHeadBack00 = this.EquipBody00.getChild("EquipHeadBack00");
        this.Hair02 = this.Hair01.getChild("Hair02");
        this.HairL02 = this.HairL01.getChild("HairL02");
        this.HairR02 = this.HairR01.getChild("HairR02");
        this.EquipS02b = this.EquipBody01.getChild("EquipS02b");
        this.EquipS02a = this.EquipBody01.getChild("EquipS02a");
        this.EquipS02c = this.EquipBody01.getChild("EquipS02c");
        this.EquipS02d = this.EquipBody01.getChild("EquipS02d");
        this.EquipJaw00a = this.EquipJaw00.getChild("EquipJaw00a");
        this.EquipT01 = this.EquipJaw00.getChild("EquipT01");
        this.EquipT03 = this.EquipBody02.getChild("EquipT03");
        this.EquipT04 = this.EquipBody02.getChild("EquipT04");
        this.EquipHeadBack00a = this.EquipHeadBack00.getChild("EquipHeadBack00a");
        this.Hair03 = this.Hair02.getChild("Hair03");
        this.EquipJaw04 = this.EquipJaw00a.getChild("EquipJaw04");
        this.EquipJaw03 = this.EquipJaw00a.getChild("EquipJaw03");
        this.EquipJaw01 = this.EquipJaw00a.getChild("EquipJaw01");
        this.EquipJaw02 = this.EquipJaw00a.getChild("EquipJaw02");
        this.EquipT01a = this.EquipT01.getChild("EquipT01a");
        this.EquipT03a = this.EquipT03.getChild("EquipT03a");
        this.EquipT04a = this.EquipT04.getChild("EquipT04a");
        this.EquipT02 = this.EquipHeadBack00a.getChild("EquipT02");
        this.EquipHead00 = this.EquipHeadBack00a.getChild("EquipHead00");
        this.EquipJaw04a = this.EquipJaw04.getChild("EquipJaw04a");
        this.EquipJaw03a = this.EquipJaw03.getChild("EquipJaw03a");
        this.EquipJaw01a = this.EquipJaw01.getChild("EquipJaw01a");
        this.EquipJaw02a = this.EquipJaw02.getChild("EquipJaw02a");
        this.EquipT01b = this.EquipT01a.getChild("EquipT01b");
        this.EquipT03b = this.EquipT03a.getChild("EquipT03b");
        this.EquipT04b = this.EquipT04a.getChild("EquipT04b");
        this.EquipT02a = this.EquipT02.getChild("EquipT02a");
        this.EquipHead00b = this.EquipHead00.getChild("EquipHead00b");
        this.EquipHead00c = this.EquipHead00.getChild("EquipHead00c");
        this.EquipHead00a = this.EquipHead00.getChild("EquipHead00a");
        this.EquipT01c = this.EquipT01b.getChild("EquipT01c");
        this.EquipT03c = this.EquipT03b.getChild("EquipT03c");
        this.EquipT04c = this.EquipT04b.getChild("EquipT04c");
        this.EquipT02b = this.EquipT02a.getChild("EquipT02b");
        this.EquipHead01 = this.EquipHead00a.getChild("EquipHead01");
        this.EquipHead02 = this.EquipHead00a.getChild("EquipHead02");
        this.EquipHead04 = this.EquipHead00a.getChild("EquipHead04");
        this.EquipHead03 = this.EquipHead00a.getChild("EquipHead03");
        this.EquipT02c = this.EquipT02b.getChild("EquipT02c");
        this.EquipHead01a = this.EquipHead01.getChild("EquipHead01a");
        this.EquipHead02a = this.EquipHead02.getChild("EquipHead02a");
        this.EquipHead04a = this.EquipHead04.getChild("EquipHead04a");
        this.EquipHead03a = this.EquipHead03.getChild("EquipHead03a");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowHead = this.GlowBodyMain.getChild("GlowHead");
        this.GlowEquipBase = this.GlowBodyMain.getChild("GlowEquipBase");
        this.GlowEquipBody00 = this.GlowEquipBase.getChild("GlowEquipBody00");
        this.GlowEquipHeadBack00 = this.GlowEquipBody00.getChild("GlowEquipHeadBack00");
        this.GlowEquipBody01 = this.GlowEquipBody00.getChild("GlowEquipBody01");
        this.GlowEquipHeadBack00a = this.GlowEquipHeadBack00.getChild("GlowEquipHeadBack00a");
        this.GlowEquipHead00 = this.GlowEquipHeadBack00a.getChild("GlowEquipHead00");
        this.Eye01 = this.GlowEquipHead00.getChild("Eye01");
        this.Eye02 = this.GlowEquipHead00.getChild("Eye02");
        this.Eye03 = this.GlowEquipHead00.getChild("Eye03");
        this.EquipE01a = this.Eye03.getChild("EquipE01a");
        this.EquipE01b = this.Eye03.getChild("EquipE01b");
        this.EquipE01c = this.Eye03.getChild("EquipE01c");
        this.EquipE01d = this.Eye03.getChild("EquipE01d");
        this.EquipS01a = this.GlowEquipBody01.getChild("EquipS01a");
        this.EquipS01b = this.GlowEquipBody01.getChild("EquipS01b");
        this.EquipS01c = this.GlowEquipBody01.getChild("EquipS01c");
        this.EquipS01d = this.GlowEquipBody01.getChild("EquipS01d");
        this.loadFaceParts(this.GlowHead);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 106)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, -11.0F, -3.0F, 0.6981317007977318F, 0.0F, 0.0F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().texOffs(2, 88)
                        .addBox(-3.0F, -1.0F, -2.5F, 5.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(-7.8F, -9.7F, -0.7F, -1.2217304763960306F, 0.0F,
                        0.8726646259971648F));

        armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().texOffs(2, 88)
                        .addBox(0.0F, 0.0F, -5.0F, 5.0F, 11.0F, 5.0F),
                PartPose.offset(-3.0F, 10.0F, 2.5F));

        bodyMain.addOrReplaceChild("BodyMain2",
                CubeListBuilder.create().texOffs(88, 0)
                        .addBox(-6.5F, -11.0F, -4.0F, 13.0F, 15.0F, 7.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("BoobL2",
                CubeListBuilder.create().mirror().texOffs(65, 34)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(2.44F, -8.6F, -3.9F, -0.6981317007977318F,
                        -0.08726646259971647F, -0.06981317007977318F));

        bodyMain.addOrReplaceChild("BoobR2",
                CubeListBuilder.create().texOffs(106, 37)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(-2.44F, -8.6F, -3.9F, -0.6981317007977318F,
                        0.08726646259971647F, 0.06981317007977318F));

        PartDefinition head = bodyMain.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, -11.8F, -0.5F, -0.5235987755982988F, 0.0F, 0.0F));

        PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(46, 104)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F),
                PartPose.offset(0.0F, -14.8F, -3.0F));

        PartDefinition hair01 = hairMain.addOrReplaceChild("Hair01",
                CubeListBuilder.create().texOffs(0, 62)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 16.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 8.0F, 1.1F, 0.5759586531581287F, 0.0F, 0.0F));

        PartDefinition hair02 = hair01.addOrReplaceChild("Hair02",
                CubeListBuilder.create().texOffs(0, 63)
                        .addBox(-8.0F, 0.0F, -5.0F, 16.0F, 16.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 13.5F, 5.5F, 0.3490658503988659F, 0.0F, 0.0F));

        hair02.addOrReplaceChild("Hair03",
                CubeListBuilder.create().texOffs(0, 40)
                        .addBox(-8.0F, 0.0F, -4.5F, 16.0F, 15.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 12.5F, 0.0F, 1.7453292519943295F, 0.0F, 0.0F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(50, 81)
                        .addBox(-8.0F, -8.0F, -7.4F, 16.0F, 12.0F, 8.0F),
                PartPose.offset(0.0F, -7.5F, 0.4F));

        PartDefinition hairL01 = hair.addOrReplaceChild("HairL01",
                CubeListBuilder.create().texOffs(24, 91)
                        .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 9.0F, 2.0F),
                PartPose.offsetAndRotation(-4.9F, 8.0F, -7.2F, 0.08726646259971647F,
                        0.13962634015954636F, -0.05235987755982988F));

        hairL01.addOrReplaceChild("HairL02",
                CubeListBuilder.create().texOffs(24, 91)
                        .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 12.0F, 2.0F),
                PartPose.offsetAndRotation(-0.3F, 7.5F, 0.1F, 0.3141592653589793F, 0.17453292519943295F,
                        0.17453292519943295F));

        PartDefinition hairR01 = hair.addOrReplaceChild("HairR01",
                CubeListBuilder.create().mirror().texOffs(24, 88)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(5.7F, 7.9F, -7.5F, -0.13962634015954636F,
                        0.4363323129985824F, 0.13962634015954636F));

        hairR01.addOrReplaceChild("HairR02",
                CubeListBuilder.create().mirror().texOffs(24, 88)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(0.3F, 10.0F, 0.0F, 0.17453292519943295F,
                        0.08726646259971647F, -0.13962634015954636F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(0, 18)
                        .addBox(0.0F, -5.0F, -10.5F, 0.0F, 11.0F, 11.0F),
                PartPose.offsetAndRotation(-1.0F, -7.0F, -5.5F, 0.2617993877991494F,
                        0.6981317007977318F, 0.0F));

        hair.addOrReplaceChild("HairU01",
                CubeListBuilder.create().mirror().texOffs(50, 44)
                        .addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 7.0F),
                PartPose.offset(0.0F, -6.0F, -7.7F));

        bodyMain.addOrReplaceChild("Butt1",
                CubeListBuilder.create().texOffs(52, 66)
                        .addBox(-7.5F, 0.0F, -7.0F, 15.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 2.5F, 2.8F, 0.20943951023931953F, 0.0F, 0.0F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 2.5F, 2.8F, 0.20943951023931953F, 0.0F, 0.0F));

        PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().mirror().texOffs(0, 87)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F),
                PartPose.offsetAndRotation(4.4F, 6.5F, -4.0F, 1.5707963267948966F, 0.0F,
                        0.10471975511965977F));

        legLeft01.addOrReplaceChild("LegLeft02",
                CubeListBuilder.create().mirror().texOffs(0, 87)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 13.0F, 6.0F),
                PartPose.offset(-3.0F, 12.0F, -3.0F));

        PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().texOffs(0, 87)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F),
                PartPose.offsetAndRotation(-4.4F, 6.5F, -4.0F, 1.5707963267948966F, 0.0F,
                        -0.10471975511965977F));

        legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().texOffs(0, 87)
                        .addBox(-6.0F, 0.0F, 0.0F, 6.0F, 13.0F, 6.0F),
                PartPose.offset(3.0F, 12.0F, -3.0F));

        bodyMain.addOrReplaceChild("BodyMain1",
                CubeListBuilder.create().texOffs(0, 106)
                        .addBox(-6.5F, -11.0F, -4.0F, 13.0F, 15.0F, 7.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("BoobL",
                CubeListBuilder.create().mirror().texOffs(34, 102)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(3.2F, -8.6F, -3.9F, -0.6981317007977318F,
                        -0.08726646259971647F, -0.06981317007977318F));

        PartDefinition equipBase = bodyMain.addOrReplaceChild("EquipBase",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition equipBody00 = equipBase.addOrReplaceChild("EquipBody00",
                CubeListBuilder.create().texOffs(1, 0)
                        .addBox(-10.0F, -10.0F, 1.0F, 20.0F, 12.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, 5.0F, 7.5F, -0.5235987755982988F, 0.0F, 0.0F));

        PartDefinition equipBody01 = equipBody00.addOrReplaceChild("EquipBody01",
                CubeListBuilder.create().texOffs(5, 0)
                        .addBox(-8.5F, 0.0F, 0.0F, 17.0F, 12.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, -2.4F, 3.0F, 0.45378560551852565F, 0.0F, 0.0F));

        equipBody01.addOrReplaceChild("EquipS02b",
                CubeListBuilder.create().texOffs(22, 32)
                        .addBox(-4.5F, -2.5F, -1.0F, 9.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, 9.0F, 12.0F, -0.7853981633974483F,
                        -1.7453292519943295F, 0.0F));

        equipBody01.addOrReplaceChild("EquipS02a",
                CubeListBuilder.create().texOffs(22, 32)
                        .addBox(-4.5F, -2.5F, -1.0F, 9.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(9.0F, 9.0F, 4.0F, -0.7853981633974483F, -1.3962634015954636F,
                        0.0F));

        equipBody01.addOrReplaceChild("EquipS02c",
                CubeListBuilder.create().texOffs(22, 32)
                        .addBox(-4.5F, -2.5F, -1.0F, 9.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, 9.0F, 12.0F, -0.7853981633974483F,
                        1.7453292519943295F, 0.0F));

        equipBody01.addOrReplaceChild("EquipS02d",
                CubeListBuilder.create().texOffs(22, 32)
                        .addBox(-4.5F, -2.5F, -1.0F, 9.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(-9.0F, 9.0F, 4.0F, -0.7853981633974483F, 1.3962634015954636F,
                        0.0F));

        PartDefinition equipJaw00 = equipBody00.addOrReplaceChild("EquipJaw00",
                CubeListBuilder.create().texOffs(1, 0)
                        .addBox(-10.0F, 0.0F, -11.0F, 20.0F, 12.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, -3.0F, 5.0F, 0.13962634015954636F, 0.0F, 0.0F));

        PartDefinition equipJaw00a = equipJaw00.addOrReplaceChild("EquipJaw00a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-10.0F, -2.0F, -6.0F, 20.0F, 4.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 11.0F, -10.0F, 0.3490658503988659F, 0.0F, 0.0F));

        PartDefinition equipJaw04 = equipJaw00a.addOrReplaceChild("EquipJaw04",
                CubeListBuilder.create().texOffs(18, 5)
                        .addBox(-6.0F, -15.0F, -4.0F, 12.0F, 15.0F, 4.0F),
                PartPose.offsetAndRotation(-6.8F, 1.2F, -2.7F, 0.13962634015954636F,
                        1.5707963267948966F, 0.0F));

        equipJaw04.addOrReplaceChild("EquipJaw04a",
                CubeListBuilder.create().texOffs(22, 25)
                        .addBox(-6.0F, -5.0F, 0.0F, 12.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, -14.5F, -3.0F, -0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition equipJaw03 = equipJaw00a.addOrReplaceChild("EquipJaw03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-6.0F, -15.0F, -4.0F, 12.0F, 15.0F, 4.0F),
                PartPose.offsetAndRotation(6.8F, 1.2F, -2.7F, 0.13962634015954636F,
                        -1.5707963267948966F, 0.0F));

        equipJaw03.addOrReplaceChild("EquipJaw03a",
                CubeListBuilder.create().texOffs(22, 25)
                        .addBox(-6.0F, -5.0F, 0.0F, 12.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, -14.5F, -3.0F, -0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition equipJaw01 = equipJaw00a.addOrReplaceChild("EquipJaw01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-6.0F, -16.0F, -4.0F, 12.0F, 15.0F, 4.0F),
                PartPose.offsetAndRotation(-5.1F, 2.0F, -4.0F, 0.17453292519943295F,
                        0.13962634015954636F, 0.0F));

        equipJaw01.addOrReplaceChild("EquipJaw01a",
                CubeListBuilder.create().texOffs(22, 25)
                        .addBox(-6.0F, -5.0F, 0.0F, 12.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, -15.5F, -3.0F, -0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition equipJaw02 = equipJaw00a.addOrReplaceChild("EquipJaw02",
                CubeListBuilder.create().texOffs(35, 0)
                        .addBox(-6.0F, -16.0F, -4.0F, 12.0F, 15.0F, 4.0F),
                PartPose.offsetAndRotation(5.1F, 2.0F, -4.0F, 0.17453292519943295F,
                        -0.13962634015954636F, 0.0F));

        equipJaw02.addOrReplaceChild("EquipJaw02a",
                CubeListBuilder.create().texOffs(22, 25)
                        .addBox(-6.0F, -5.0F, 0.0F, 12.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, -15.5F, -3.0F, -0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition equipT01 = equipJaw00.addOrReplaceChild("EquipT01",
                CubeListBuilder.create().texOffs(38, 0)
                        .addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 15.0F, -8.0F, 0.6283185307179586F, 0.0F, 0.0F));

        PartDefinition equipT01a = equipT01.addOrReplaceChild("EquipT01a",
                CubeListBuilder.create().texOffs(68, 14)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.31869712141416456F, 0.0F, 0.0F));

        PartDefinition equipT01b = equipT01a.addOrReplaceChild("EquipT01b",
                CubeListBuilder.create().texOffs(68, 14)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 8.5F, 0.0F, 0.5235987755982988F, 0.0F, 0.0F));

        equipT01b.addOrReplaceChild("EquipT01c",
                CubeListBuilder.create().texOffs(70, 15)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, 8.5F, 0.0F, -0.3490658503988659F, 0.0F, 0.0F));

        PartDefinition equipBody02 = equipBody00.addOrReplaceChild("EquipBody02",
                CubeListBuilder.create().texOffs(7, 0)
                        .addBox(-8.0F, 0.0F, 0.0F, 16.0F, 12.0F, 13.0F),
                PartPose.offset(0.0F, -12.0F, 11.0F));

        PartDefinition equipT03 = equipBody02.addOrReplaceChild("EquipT03",
                CubeListBuilder.create().texOffs(24, 7)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 7.0F, 7.0F),
                PartPose.offsetAndRotation(7.0F, 9.5F, 8.5F, 1.3962634015954636F, 0.17453292519943295F,
                        0.0F));

        PartDefinition equipT03a = equipT03.addOrReplaceChild("EquipT03a",
                CubeListBuilder.create().texOffs(68, 14)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition equipT03b = equipT03a.addOrReplaceChild("EquipT03b",
                CubeListBuilder.create().texOffs(68, 14)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 8.5F, 0.0F, 0.3490658503988659F, 0.0F, 0.0F));

        equipT03b.addOrReplaceChild("EquipT03c",
                CubeListBuilder.create().texOffs(70, 15)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, 8.5F, 0.0F, -0.3490658503988659F, 0.0F, 0.0F));

        PartDefinition equipT04 = equipBody02.addOrReplaceChild("EquipT04",
                CubeListBuilder.create().texOffs(0, 7)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 7.0F, 7.0F),
                PartPose.offsetAndRotation(-7.0F, 9.5F, 8.5F, 1.3962634015954636F,
                        -0.17453292519943295F, 0.0F));

        PartDefinition equipT04a = equipT04.addOrReplaceChild("EquipT04a",
                CubeListBuilder.create().texOffs(68, 14)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition equipT04b = equipT04a.addOrReplaceChild("EquipT04b",
                CubeListBuilder.create().texOffs(68, 14)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 8.5F, 0.0F, -0.5235987755982988F, 0.0F, 0.0F));

        equipT04b.addOrReplaceChild("EquipT04c",
                CubeListBuilder.create().texOffs(70, 15)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, 8.5F, 0.0F, 0.3490658503988659F, 0.0F, 0.0F));

        PartDefinition equipHeadBack00 = equipBody00.addOrReplaceChild("EquipHeadBack00",
                CubeListBuilder.create().texOffs(1, 0)
                        .addBox(-9.0F, -10.0F, -10.0F, 18.0F, 12.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, -8.0F, 9.0F, -1.3962634015954636F, 0.0F, 0.0F));

        PartDefinition equipHeadBack00a = equipHeadBack00.addOrReplaceChild("EquipHeadBack00a",
                CubeListBuilder.create().texOffs(6, 0)
                        .addBox(-8.0F, -11.0F, -11.0F, 16.0F, 11.0F, 13.0F),
                PartPose.offset(0.0F, -4.0F, -3.0F));

        PartDefinition equipT02 = equipHeadBack00a.addOrReplaceChild("EquipT02",
                CubeListBuilder.create().texOffs(20, 3)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 7.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, -9.0F, -10.0F, 2.6179938779914944F, 0.0F, 0.0F));

        PartDefinition equipT02a = equipT02.addOrReplaceChild("EquipT02a",
                CubeListBuilder.create().texOffs(68, 14)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition equipT02b = equipT02a.addOrReplaceChild("EquipT02b",
                CubeListBuilder.create().texOffs(68, 14)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 8.5F, 0.0F, -0.5235987755982988F, 0.0F, 0.0F));

        equipT02b.addOrReplaceChild("EquipT02c",
                CubeListBuilder.create().texOffs(70, 15)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, 8.5F, 0.0F, 0.41887902047863906F, 0.0F, 0.0F));

        PartDefinition equipHead00 = equipHeadBack00a.addOrReplaceChild("EquipHead00",
                CubeListBuilder.create().texOffs(1, 0)
                        .addBox(-10.0F, -12.0F, -11.0F, 20.0F, 12.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, -1.0F, -10.0F, 0.20943951023931953F, 0.0F, 0.0F));

        equipHead00.addOrReplaceChild("EquipHead00b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -3.5F, 3.0F, 10.0F, 7.0F),
                PartPose.offsetAndRotation(-10.0F, -2.0F, -2.0F, 0.20943951023931953F,
                        -0.06981317007977318F, 0.13962634015954636F));

        equipHead00.addOrReplaceChild("EquipHead00c",
                CubeListBuilder.create().texOffs(17, 5)
                        .addBox(-1.5F, 0.0F, -3.5F, 3.0F, 10.0F, 7.0F),
                PartPose.offsetAndRotation(10.0F, -2.0F, -2.0F, 0.20943951023931953F,
                        0.06981317007977318F, -0.13962634015954636F));

        PartDefinition equipHead00a = equipHead00.addOrReplaceChild("EquipHead00a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-10.0F, -4.0F, -5.5F, 20.0F, 4.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, -8.0F, -12.0F, 0.20943951023931953F, 0.0F, 0.0F));

        PartDefinition equipHead01 = equipHead00a.addOrReplaceChild("EquipHead01",
                CubeListBuilder.create().texOffs(8, 6)
                        .addBox(-6.0F, 0.0F, -4.0F, 12.0F, 15.0F, 4.0F),
                PartPose.offsetAndRotation(-5.1F, -4.0F, -4.0F, -0.17453292519943295F,
                        0.13962634015954636F, 0.0F));

        equipHead01.addOrReplaceChild("EquipHead01a",
                CubeListBuilder.create().texOffs(22, 25)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 14.5F, -3.0F, 0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition equipHead02 = equipHead00a.addOrReplaceChild("EquipHead02",
                CubeListBuilder.create().texOffs(32, 0)
                        .addBox(-6.0F, 0.0F, -4.0F, 12.0F, 15.0F, 4.0F),
                PartPose.offsetAndRotation(5.1F, -4.0F, -4.0F, -0.17453292519943295F,
                        -0.13962634015954636F, 0.0F));

        equipHead02.addOrReplaceChild("EquipHead02a",
                CubeListBuilder.create().texOffs(22, 25)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 14.5F, -3.0F, 0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition equipHead04 = equipHead00a.addOrReplaceChild("EquipHead04",
                CubeListBuilder.create().texOffs(34, 5)
                        .addBox(-6.0F, 0.0F, -4.0F, 12.0F, 15.0F, 4.0F),
                PartPose.offsetAndRotation(-6.8F, -4.2F, -2.6F, -0.13962634015954636F,
                        1.5707963267948966F, 0.0F));

        equipHead04.addOrReplaceChild("EquipHead04a",
                CubeListBuilder.create().texOffs(22, 25)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 14.5F, -3.0F, 0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition equipHead03 = equipHead00a.addOrReplaceChild("EquipHead03",
                CubeListBuilder.create().texOffs(0, 4)
                        .addBox(-6.0F, 0.0F, -4.0F, 12.0F, 15.0F, 4.0F),
                PartPose.offsetAndRotation(6.8F, -4.2F, -2.6F, -0.13962634015954636F,
                        -1.5707963267948966F, 0.0F));

        equipHead03.addOrReplaceChild("EquipHead03a",
                CubeListBuilder.create().texOffs(22, 25)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 14.5F, -3.0F, 0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().mirror().texOffs(2, 88)
                        .addBox(-2.0F, -1.0F, -2.5F, 5.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(7.8F, -9.7F, -0.7F, -1.2217304763960306F, 0.0F,
                        -0.8726646259971648F));

        armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().mirror().texOffs(2, 88)
                        .addBox(-5.0F, 0.0F, -5.0F, 5.0F, 11.0F, 5.0F),
                PartPose.offset(3.0F, 10.0F, 2.5F));

        bodyMain.addOrReplaceChild("Butt2",
                CubeListBuilder.create().texOffs(82, 22)
                        .addBox(-7.5F, 0.0F, -7.0F, 15.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 2.5F, 2.8F, 0.20943951023931953F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("BoobR",
                CubeListBuilder.create().texOffs(34, 102)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(-3.2F, -8.6F, -3.9F, -0.6981317007977318F,
                        0.08726646259971647F, 0.06981317007977318F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -11.0F, -3.0F));

        PartDefinition glowHead = glowBodyMain.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -11.8F, -0.5F));
        addDefaultFaceParts(glowHead);

        PartDefinition glowEquipBase = glowBodyMain.addOrReplaceChild("GlowEquipBase",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition glowEquipBody00 = glowEquipBase.addOrReplaceChild("GlowEquipBody00",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 5.0F, 7.5F));

        PartDefinition glowEquipHeadBack00 = glowEquipBody00.addOrReplaceChild("GlowEquipHeadBack00",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -8.0F, 9.0F));

        PartDefinition glowEquipHeadBack00a = glowEquipHeadBack00.addOrReplaceChild("GlowEquipHeadBack00a",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -4.0F, -3.0F));

        PartDefinition glowEquipHead00 = glowEquipHeadBack00a.addOrReplaceChild("GlowEquipHead00",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -1.0F, -10.0F));

        glowEquipHead00.addOrReplaceChild("Eye01",
                CubeListBuilder.create().texOffs(70, 0)
                        .addBox(-1.0F, 0.0F, -3.0F, 2.0F, 7.0F, 7.0F),
                PartPose.offsetAndRotation(11.0F, -8.5F, -6.0F, 0.0F, -0.10471975511965977F,
                        -0.17453292519943295F));

        glowEquipHead00.addOrReplaceChild("Eye02",
                CubeListBuilder.create().texOffs(70, 0)
                        .addBox(-1.0F, 0.0F, -3.0F, 2.0F, 7.0F, 7.0F),
                PartPose.offsetAndRotation(-11.0F, -8.5F, -6.0F, 0.0F, 0.10471975511965977F,
                        0.17453292519943295F));

        PartDefinition eye03 = glowEquipHead00.addOrReplaceChild("Eye03",
                CubeListBuilder.create().texOffs(70, 0)
                        .addBox(-1.0F, -3.5F, -3.5F, 2.0F, 7.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, 0.8726646259971648F,
                        1.5707963267948966F));

        eye03.addOrReplaceChild("EquipE01a",
                CubeListBuilder.create().texOffs(22, 32)
                        .addBox(-4.5F, -2.5F, -1.0F, 9.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(-0.3F, 5.0F, 0.0F, 2.2689280275926285F,
                        1.5707963267948966F, 0.0F));

        eye03.addOrReplaceChild("EquipE01b",
                CubeListBuilder.create().texOffs(22, 32)
                        .addBox(-4.5F, -2.5F, -1.0F, 9.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(-0.3F, -5.0F, 0.0F, -2.2689280275926285F,
                        1.5707963267948966F, 0.0F));

        eye03.addOrReplaceChild("EquipE01c",
                CubeListBuilder.create().texOffs(22, 32)
                        .addBox(-4.5F, -2.5F, -1.0F, 9.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.0471975511965976F, 0.0F,
                        1.5707963267948966F));

        eye03.addOrReplaceChild("EquipE01d",
                CubeListBuilder.create().texOffs(22, 32)
                        .addBox(-4.5F, -2.5F, -1.0F, 9.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(-0.5F, 0.0F, 5.0F, 0.5235987755982988F, 0.0F,
                        1.5707963267948966F));

        PartDefinition glowEquipBody01 = glowEquipBody00.addOrReplaceChild("GlowEquipBody01",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -2.4F, 3.0F));

        glowEquipBody01.addOrReplaceChild("EquipS01a",
                CubeListBuilder.create().texOffs(41, 35)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F),
                PartPose.offsetAndRotation(6.5F, 11.0F, 3.0F, -0.2617993877991494F, 0.0F,
                        -0.2617993877991494F));

        glowEquipBody01.addOrReplaceChild("EquipS01b",
                CubeListBuilder.create().texOffs(41, 35)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F),
                PartPose.offsetAndRotation(-6.5F, 11.0F, 3.0F, -0.2617993877991494F, 0.0F,
                        0.2617993877991494F));

        glowEquipBody01.addOrReplaceChild("EquipS01c",
                CubeListBuilder.create().texOffs(41, 35)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F),
                PartPose.offsetAndRotation(6.5F, 11.0F, 11.0F, 0.2617993877991494F, 0.0F,
                        -0.2617993877991494F));

        glowEquipBody01.addOrReplaceChild("EquipS01d",
                CubeListBuilder.create().texOffs(41, 35)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F),
                PartPose.offsetAndRotation(-6.5F, 11.0F, 11.0F, 0.2617993877991494F, 0.0F,
                        0.2617993877991494F));

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
        this.Hair03.visible = flag; // Hair03: visible when equip state OFF (original: isHidden = !flag)
        this.LegLeft01.visible = flag; // Legs: visible when equip state OFF (original: isHidden = !flag)
        this.LegRight01.visible = flag;

        flag = !EmotionHelper.checkModelState(1, state); // cloth
        this.BodyMain1.visible = flag; // Outfit 1: visible when cloth state OFF (original: isHidden = !flag)
        this.Butt1.visible = flag;
        this.BoobL.visible = flag;
        this.BoobR.visible = flag;
        this.BodyMain2.visible = !flag;
        this.Butt2.visible = !flag;
        this.BoobL2.visible = !flag;
        this.BoobR2.visible = !flag;
    }

    @Override
    public void syncRotationGlowPart() {
        this.BoobL2.xRot = this.BoobL.xRot;
        this.BoobR2.xRot = this.BoobR.xRot;
        this.Butt1.xRot = this.Butt.xRot;
        this.Butt2.xRot = this.Butt.xRot;
        this.GlowBodyMain.xRot = this.BodyMain.xRot;
        this.GlowBodyMain.yRot = this.BodyMain.yRot;
        this.GlowBodyMain.zRot = this.BodyMain.zRot;
        this.GlowHead.xRot = this.Head.xRot;
        this.GlowHead.yRot = this.Head.yRot;
        this.GlowHead.zRot = this.Head.zRot;
        this.GlowEquipHeadBack00.xRot = this.EquipHeadBack00.xRot;
        this.GlowEquipHeadBack00.yRot = this.EquipHeadBack00.yRot;
        this.GlowEquipHeadBack00.zRot = this.EquipHeadBack00.zRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float angleX = Mth.cos(f2 * 0.08F);
        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += 0.39F;
        this.offsetZ -= 0.1F;
        this.setFaceHungry(ent);

        this.EquipBase.visible = true;
        this.GlowEquipBase.visible = true;
        this.Head.visible = false;
        this.GlowHead.visible = false;
        this.LegLeft01.visible = false;
        this.LegRight01.visible = false;

        // boob
        this.BoobL.xRot = -0.76F;
        this.BoobR.xRot = -0.76F;
        // body
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        this.Butt.xRot = 0.21F;
        // this.Butt.offsetZ = 0F;
        // hair
        this.Hair01.xRot = 0.209F;
        this.Hair01.zRot = 0F;
        this.Hair02.xRot = -0.087F;
        this.Hair02.zRot = 0F;
        this.Hair03.xRot = -0.139F;
        this.Hair03.zRot = 0F;
        this.HairL01.xRot = -0.1F;
        this.HairL02.xRot = 0.3142F;
        this.HairR01.xRot = -0.1F;
        this.HairR02.xRot = 0.1745F;
        this.HairL01.zRot = -0.0524F;
        this.HairL02.zRot = 0.1745F;
        this.HairR01.zRot = 0.1396F;
        this.HairR02.zRot = -0.1396F;

        // body
        this.BodyMain.xRot = 0.2F;
        // arm
        this.ArmLeft01.xRot = -0.25F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = 0.2618F;
        this.ArmRight01.xRot = -0.25F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = -0.2618F;
        // equip
        this.EquipHeadBack00.xRot = -0.15F;
        this.EquipT01a.xRot = 0.5F;
        this.EquipT01b.xRot = 0.5F;
        this.EquipT01c.xRot = 0.5F;
        this.EquipT02a.xRot = -0.7F;
        this.EquipT02b.xRot = -0.5F;
        this.EquipT02c.xRot = -0.5F;
        this.EquipT03a.xRot = 0F;
        this.EquipT03b.xRot = 0F;
        this.EquipT03c.xRot = 0F;
        this.EquipT04a.xRot = 0F;
        this.EquipT04b.xRot = 0F;
        this.EquipT04c.xRot = 0F;
        this.EquipT03a.zRot = 0.5F;
        this.EquipT03b.zRot = 0.6F;
        this.EquipT03c.zRot = 0.7F;
        this.EquipT04a.zRot = 0.3F;
        this.EquipT04b.zRot = 0.3F;
        this.EquipT04c.zRot = 0.3F;
        this.EquipS01a.xRot = 0.2F;
        this.EquipS01b.xRot = 0.3F;
        this.EquipS01c.xRot = 0.2F;
        this.EquipS01d.xRot = 0.5F;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float angleX = Mth.cos(f2 * 0.08F);
        float angleX1 = Mth.cos(f2 * 0.1F + 0.3F + f * 0.5F);
        float angleX2 = Mth.cos(f2 * 0.1F + 0.6F + f * 0.5F);
        float angleX3 = Mth.cos(f2 * 0.1F + 0.9F + f * 0.5F);
        float angleX4 = Mth.cos(f2 * 0.3F + 2F + f * 0.5F);
        float angleX5 = Mth.cos(f2 * 0.3F + 4F + f * 0.5F);
        float angleX6 = Mth.cos(f2 * 0.3F + 6F + f * 0.5F);
        float angleX7 = Mth.sin(f2);
        float angleAdd1 = Mth.cos(f * 0.7F) * f1 * 0.7F;
        float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.7F;
        float addk1 = 0F;
        float addk2 = 0F;
        float headX;
        float headZ;

        // 水上漂浮
        if (ent.getShipDepth(0) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        // head
        this.Head.visible = true;
        this.GlowHead.visible = true;
        this.Head.xRot = f4 * 0.014F;
        this.Head.yRot = f3 * 0.01F;
        this.Head.zRot = 0F;

        // boob
        this.BoobL.xRot = angleX * 0.08F - 0.76F;
        this.BoobR.xRot = angleX * 0.08F - 0.76F;
        // body
        this.Ahoke.yRot = angleX * 0.15F + 0.6F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        this.Butt.xRot = 0.21F;
        // this.Butt.offsetZ = 0F;
        // hair
        this.Hair01.xRot = 0.209F;
        this.Hair01.zRot = 0F;
        this.Hair02.xRot = -0.087F;
        this.Hair02.zRot = 0F;
        this.Hair03.xRot = -0.139F;
        this.Hair03.zRot = 0F;
        this.HairL01.xRot = -0.1F;
        this.HairL02.xRot = 0.3142F;
        this.HairR01.xRot = -0.1F;
        this.HairR02.xRot = 0.1745F;
        this.HairL01.zRot = -0.0524F;
        this.HairL02.zRot = 0.1745F;
        this.HairR01.zRot = 0.1396F;
        this.HairR02.zRot = -0.1396F;

        boolean showEquip = EmotionHelper.checkModelState(0, ent.getStateEmotion(ID.S.State));

        if (showEquip) {
            // head
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += angleX * 0.035F + 0.1F;
            this.offsetZ -= 0.1F;
            this.Head.xRot -= 0.7F;
            // body
            this.BodyMain.xRot = 0.7F;
            // arm
            this.ArmLeft01.xRot = -angleX * 0.1F - 1.0472F;
            this.ArmLeft01.yRot = 0F;
            this.ArmLeft01.zRot = -angleX * 0.1F - 0.7F;
            this.ArmRight01.xRot = -angleX * 0.1F - 1.0472F;
            this.ArmRight01.yRot = 0F;
            this.ArmRight01.zRot = angleX * 0.1F + 0.7F;
            // equip
            this.EquipHeadBack00.xRot = angleX * 0.05F - 1.7F;
            this.EquipT01a.xRot = angleX6 * 0.22F + 0.5F;
            this.EquipT01b.xRot = angleX5 * 0.44F;
            this.EquipT01c.xRot = angleX4 * 0.66F;
            this.EquipT02a.xRot = -angleX6 * 0.22F;
            this.EquipT02b.xRot = -angleX5 * 0.44F;
            this.EquipT02c.xRot = -angleX4 * 0.66F;
            this.EquipT03a.xRot = 0F;
            this.EquipT03b.xRot = 0F;
            this.EquipT03c.xRot = 0F;
            this.EquipT04a.xRot = 0F;
            this.EquipT04b.xRot = 0F;
            this.EquipT04c.xRot = 0F;
            this.EquipT03a.zRot = angleX6 * 0.25F;
            this.EquipT03b.zRot = angleX5 * 0.5F;
            this.EquipT03c.zRot = angleX4 * 0.75F;
            this.EquipT04a.zRot = -angleX6 * 0.25F;
            this.EquipT04b.zRot = -angleX5 * 0.5F;
            this.EquipT04c.zRot = -angleX4 * 0.75F;
            this.EquipS01a.xRot = angleX7 * 0.05F * ent.getRand().nextFloat() - 0.2618F;
            this.EquipS01b.xRot = angleX7 * 0.05F * ent.getRand().nextFloat() - 0.2618F;
            this.EquipS01c.xRot = -angleX7 * 0.05F * ent.getRand().nextFloat() + 0.2618F;
            this.EquipS01d.xRot = -angleX7 * 0.05F * ent.getRand().nextFloat() + 0.2618F;
        } else {
            // head
            this.Head.xRot += 0.1F;
            // body
            this.BodyMain.xRot = -0.1047F;
            // arm
            this.ArmLeft01.xRot = 0.2094F;
            this.ArmLeft01.yRot = 0F;
            this.ArmLeft01.zRot = -angleX * 0.05F - 0.3142F;
            this.ArmRight01.xRot = 0F;
            this.ArmRight01.yRot = 0F;
            this.ArmRight01.zRot = angleX * 0.05F + 0.2094F;
            // leg
            addk1 = angleAdd1 * 0.6F - 0.157F;
            addk2 = angleAdd2 * 0.6F - 0.035F;
            this.LegLeft01.yRot = 0F;
            this.LegLeft01.zRot = 0.1F;
            this.LegRight01.yRot = 0F;
            this.LegRight01.zRot = -0.1F;
        }

        // sprinting
        if (ent.getIsSprinting() || f1 > 0.92F) { // 奔跑動作

            if (showEquip) {
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.1F;
                this.Head.xRot += 0.6F;
            }

            // body
            this.Head.xRot -= 1.1F;
            this.BodyMain.xRot = 1.1F;
            // 胸部
            this.BoobL.xRot = angleAdd1 * 0.08F - 0.7F;
            this.BoobL.zRot = -0.07F;
            this.BoobR.xRot = angleAdd1 * 0.08F - 0.7F;
            this.BoobR.zRot = 0.07F;
            // arm
            this.ArmLeft01.xRot = -2.5133F;
            this.ArmLeft01.zRot = -0.22F;
            this.ArmRight01.xRot = -2.5133F;
            this.ArmRight01.zRot = 0.22F;
            // leg
            this.LegLeft01.zRot = 0.05F;
            this.LegRight01.zRot = -0.05F;
        } // end is sprinting

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        if (ent.getIsSneaking()) { // 潛行, 蹲下動作
            // Body
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.05F;
            this.Head.xRot -= 1.0472F;
            this.BodyMain.xRot = 1.0472F;
            this.Butt.xRot = -0.8378F;
            // hair
            this.Hair01.xRot -= 0.1F;
            this.Hair02.xRot -= 0.2F;
            this.Hair03.xRot -= 0.5F;
            // arm
            this.ArmLeft01.xRot = -0.7F;
            this.ArmLeft01.zRot = 0.2618F;
            this.ArmRight01.xRot = -0.7F;
            this.ArmRight01.zRot = -0.2618F;
            // leg
            addk1 -= 0.1F;
            addk2 -= 0.1F;

            if (showEquip) {
                this.Head.xRot += 0.8F;
                this.ArmLeft01.xRot = -0.25F;
                this.ArmRight01.xRot = -0.25F;
                this.EquipHeadBack00.xRot += 0.4F;
            }
        } // end if sneaking

        // sitting riding
        if (ent.getIsSitting() && !ent.getIsRiding()) {
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                this.setFaceDamaged(ent);
                // body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += -angleX * 0.05F;
                this.Head.xRot *= 0.5F;
                this.Head.yRot *= 0.75F;
                this.Head.xRot += 0.5F;
                this.BodyMain.xRot = 1.6F;
                // arm
                this.ArmLeft01.xRot = -1.6F;
                this.ArmLeft01.zRot = -2.3F;
                this.ArmRight01.xRot = -1.6F;
                this.ArmRight01.zRot = 2.3F;
                // leg
                addk1 = -1.6F;
                addk2 = -1.6F;
                this.LegLeft01.yRot = -0.1F - angleX * 0.05F;
                this.LegRight01.yRot = 0.1F + angleX * 0.05F;

                if (showEquip) {
                    float ax = Mth.cos(f2 * 0.5F) * 0.5F;

                    this.ArmLeft01.xRot = ax + 0.1F;
                    this.ArmRight01.xRot = -ax + 0.1F;
                    // equip
                    this.EquipHeadBack00.xRot = ax * 0.1F - 0.7F;
                }
            } else {
                // body
                this.Head.xRot -= 0.7F;
                this.BodyMain.xRot = 0.5236F;
                // arm
                this.ArmLeft01.xRot = -0.4F;
                this.ArmLeft01.zRot = 0.3146F;
                this.ArmRight01.xRot = -0.4F;
                this.ArmRight01.zRot = -0.3146F;
                // leg
                addk1 = -2.18F;
                addk2 = -2.18F;
                this.LegLeft01.yRot = -0.3491F;
                this.LegRight01.yRot = 0.3491F;

                if (showEquip) {
                    // body
                    this.Head.xRot += 0.7F;
                    this.BodyMain.xRot = 0.3F;
                    // arm
                    this.ArmLeft01.xRot = -0.27F;
                    this.ArmLeft01.zRot = 0.3146F;
                    this.ArmRight01.xRot = -0.27F;
                    this.ArmRight01.zRot = -0.3146F;
                    // equip
                    this.EquipHeadBack00.xRot += 0.45F;
                } else {
                }
            }
        } // end sitting

        // attack
        if (ent.getAttackTick() > 41) {
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.45F;
            setFaceAttack(ent);
            // swing arm
            float ft = (50 - ent.getAttackTick()) + (f2 - (int) f2);
            ft *= 0.125F;
            float fa = Mth.sin(ft * ft * (float) Math.PI);
            float fb = Mth.sin(Mth.sqrt(ft) * (float) Math.PI);
            this.ArmLeft01.xRot += -fb * 80.0F * ((float) Math.PI / 180F) - 0.3F;
            this.ArmLeft01.yRot += fa * 20.0F * ((float) Math.PI / 180F) - 0.4F;
            this.ArmLeft01.zRot += fb * 20.0F * ((float) Math.PI / 180F);
            this.ArmRight01.xRot += -fb * 80.0F * ((float) Math.PI / 180F) - 0.3F;
            this.ArmRight01.yRot += -fa * 20.0F * ((float) Math.PI / 180F) + 0.4F;
            this.ArmRight01.zRot += -fb * 20.0F * ((float) Math.PI / 180F);
        } // end attack

        // 鬢毛調整
        headX = this.Head.xRot * -0.5F;
        headZ = this.Head.zRot * -0.5F;
        this.Hair01.xRot += angleX1 * 0.08F + headX;
        this.Hair02.xRot += -angleX2 * 0.08F + headX * 0.5F + 0.1F;
        this.Hair03.xRot += -angleX3 * 0.08F + headX * 0.5F + 0.1F;
        this.Hair01.zRot += headZ;
        this.Hair02.zRot += headZ * 0.5F;
        this.Hair03.zRot += headZ * 0.5F;
        this.HairL01.xRot += angleX * 0.04F + headX;
        this.HairL02.xRot += angleX * 0.05F + headX * 0.8F;
        this.HairR01.xRot += angleX * 0.04F + headX;
        this.HairR02.xRot += angleX * 0.05F + headX * 0.8F;
        this.HairL01.zRot += headZ;
        this.HairL02.zRot += headZ;
        this.HairR01.zRot += headZ * 2.5F;
        this.HairR02.zRot += headZ * 0.8F;

        // swing arm
        float f6 = ent.getSwingTime(f2 - (int) f2);
        if (f6 != 0F) {
            float f7 = Mth.sin(f6 * f6 * (float) Math.PI);
            float f8 = Mth.sin(Mth.sqrt(f6) * (float) Math.PI);
            this.ArmRight01.xRot += -f8 * 80.0F * ((float) Math.PI / 180F) - 0.3F;
            this.ArmRight01.yRot += -f7 * 20.0F * ((float) Math.PI / 180F) + 0.4F;
            this.ArmRight01.zRot += -f8 * 20.0F * ((float) Math.PI / 180F);
        }

        // leg motion
        this.LegLeft01.xRot = addk1;
        this.LegRight01.xRot = addk2;
    }
}
