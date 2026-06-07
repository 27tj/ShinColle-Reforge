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

public class ModelBattleshipNagato extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "bb_nagato"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Neck;
    private final ModelPart BoobR;
    private final ModelPart BoobL;
    private final ModelPart ArmLeft01;
    private final ModelPart ArmRight01;
    private final ModelPart Butt;
    private final ModelPart Cloth;
    private final ModelPart Head;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart HeadEquip;
    private final ModelPart HeadEquip05;
    private final ModelPart Ahoke;
    private final ModelPart HairMidL01;
    private final ModelPart HairMidL02;
    private final ModelPart HeadEquip01;
    private final ModelPart HeadEquip03;
    private final ModelPart HeadEquip02;
    private final ModelPart HeadEquip04;
    private final ModelPart ArmLeft02;
    private final ModelPart ArmRight02;
    private final ModelPart LegRight;
    private final ModelPart LegLeft;
    private final ModelPart Skirt;
    private final ModelPart ShoesR;
    private final ModelPart ShoesL;
    private final ModelPart SkirtEquip;
    private final ModelPart EquipBase;
    private final ModelPart EquipL01;
    private final ModelPart EquipR01;
    private final ModelPart EquipBaseM01;
    private final ModelPart EquipBaseM02;
    private final ModelPart EquipBaseM03;
    private final ModelPart EquipL02;
    private final ModelPart EquipL03;
    private final ModelPart EquipR04;
    private final ModelPart EquipLCBase01;
    private final ModelPart EquipLC2Base01;
    private final ModelPart EquipLC2Base02;
    private final ModelPart EquipLC201;
    private final ModelPart EquipLC203;
    private final ModelPart EquipLC202;
    private final ModelPart EquipLC204;
    private final ModelPart EquipLCBase02;
    private final ModelPart EquipLC01;
    private final ModelPart EquipLC03;
    private final ModelPart EquipLCRadar;
    private final ModelPart EquipLC02;
    private final ModelPart EquipLC04;
    private final ModelPart EquipR02;
    private final ModelPart EquipR03;
    private final ModelPart EquipRCBase01;
    private final ModelPart EquipR04_1;
    private final ModelPart EquipRCBase02;
    private final ModelPart EquipRC01;
    private final ModelPart EquipRC03;
    private final ModelPart EquipRCRadar;
    private final ModelPart EquipRC02;
    private final ModelPart EquipRC04;
    private final ModelPart EquipRC2Base01;
    private final ModelPart EquipRC2Base02;
    private final ModelPart EquipRC201;
    private final ModelPart EquipRC203;
    private final ModelPart EquipRC202;
    private final ModelPart EquipRC204;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowNeck;
    private final ModelPart GlowHead;

    public ModelBattleshipNagato(ModelPart root) {
        super();
        this.BodyMain = root.getChild("BodyMain");
        this.Cloth = this.BodyMain.getChild("Cloth");
        this.Neck = this.BodyMain.getChild("Neck");
        this.BoobR = this.BodyMain.getChild("BoobR");
        this.BoobL = this.BodyMain.getChild("BoobL");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.Butt = this.BodyMain.getChild("Butt");
        this.Head = this.Neck.getChild("Head");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.LegRight = this.Butt.getChild("LegRight");
        this.Skirt = this.Butt.getChild("Skirt");
        this.LegLeft = this.Butt.getChild("LegLeft");
        this.Hair = this.Head.getChild("Hair");
        this.HairMain = this.Head.getChild("HairMain");
        this.HeadEquip05 = this.Head.getChild("HeadEquip05");
        this.HeadEquip = this.Head.getChild("HeadEquip");
        this.ShoesR = this.LegRight.getChild("ShoesR");
        this.SkirtEquip = this.Skirt.getChild("SkirtEquip");
        this.ShoesL = this.LegLeft.getChild("ShoesL");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.HairMidL01 = this.HairMain.getChild("HairMidL01");
        this.HeadEquip03 = this.HeadEquip.getChild("HeadEquip03");
        this.HeadEquip01 = this.HeadEquip.getChild("HeadEquip01");
        this.EquipBase = this.SkirtEquip.getChild("EquipBase");
        this.HairMidL02 = this.HairMidL01.getChild("HairMidL02");
        this.HeadEquip04 = this.HeadEquip03.getChild("HeadEquip04");
        this.HeadEquip02 = this.HeadEquip01.getChild("HeadEquip02");
        this.EquipBaseM01 = this.EquipBase.getChild("EquipBaseM01");
        this.EquipBaseM03 = this.EquipBase.getChild("EquipBaseM03");
        this.EquipBaseM02 = this.EquipBase.getChild("EquipBaseM02");
        this.EquipL01 = this.EquipBase.getChild("EquipL01");
        this.EquipR01 = this.EquipBase.getChild("EquipR01");
        this.EquipL02 = this.EquipL01.getChild("EquipL02");
        this.EquipR02 = this.EquipR01.getChild("EquipR02");
        this.EquipL03 = this.EquipL02.getChild("EquipL03");
        this.EquipR03 = this.EquipR02.getChild("EquipR03");
        this.EquipR04 = this.EquipL03.getChild("EquipR04");
        this.EquipLCBase01 = this.EquipL03.getChild("EquipLCBase01");
        this.EquipRCBase01 = this.EquipR03.getChild("EquipRCBase01");
        this.EquipR04_1 = this.EquipR03.getChild("EquipR04_1");
        this.EquipLC2Base01 = this.EquipR04.getChild("EquipLC2Base01");
        this.EquipLCBase02 = this.EquipLCBase01.getChild("EquipLCBase02");
        this.EquipRCBase02 = this.EquipRCBase01.getChild("EquipRCBase02");
        this.EquipRC2Base01 = this.EquipR04_1.getChild("EquipRC2Base01");
        this.EquipLC2Base02 = this.EquipLC2Base01.getChild("EquipLC2Base02");
        this.EquipLC01 = this.EquipLCBase02.getChild("EquipLC01");
        this.EquipLCRadar = this.EquipLCBase02.getChild("EquipLCRadar");
        this.EquipLC03 = this.EquipLCBase02.getChild("EquipLC03");
        this.EquipRC03 = this.EquipRCBase02.getChild("EquipRC03");
        this.EquipRC01 = this.EquipRCBase02.getChild("EquipRC01");
        this.EquipRCRadar = this.EquipRCBase02.getChild("EquipRCRadar");
        this.EquipRC2Base02 = this.EquipRC2Base01.getChild("EquipRC2Base02");
        this.EquipLC201 = this.EquipLC2Base02.getChild("EquipLC201");
        this.EquipLC203 = this.EquipLC2Base02.getChild("EquipLC203");
        this.EquipLC02 = this.EquipLC01.getChild("EquipLC02");
        this.EquipLC04 = this.EquipLC03.getChild("EquipLC04");
        this.EquipRC04 = this.EquipRC03.getChild("EquipRC04");
        this.EquipRC02 = this.EquipRC01.getChild("EquipRC02");
        this.EquipRC203 = this.EquipRC2Base02.getChild("EquipRC203");
        this.EquipRC201 = this.EquipRC2Base02.getChild("EquipRC201");
        this.EquipLC202 = this.EquipLC201.getChild("EquipLC202");
        this.EquipLC204 = this.EquipLC203.getChild("EquipLC204");
        this.EquipRC204 = this.EquipRC203.getChild("EquipRC204");
        this.EquipRC202 = this.EquipRC201.getChild("EquipRC202");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowNeck = this.GlowBodyMain.getChild("GlowNeck");
        this.GlowHead = this.GlowNeck.getChild("GlowHead");
        this.loadFaceParts(this.GlowHead);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 105)
                        .addBox(-6.5F, -10.0F, -4.0F, 13.0F, 15.0F, 7.0F),
                PartPose.offset(0.0F, -14.0F, 0.0F));

        bodyMain.addOrReplaceChild("Cloth",
                CubeListBuilder.create().texOffs(96, 16)
                        .addBox(-5.5F, 0.0F, 0.0F, 11.0F, 2.0F, 9.0F),
                PartPose.offset(0.0F, -11.5F, -5.0F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(46, 14)
                        .addBox(-7.0F, -0.5F, -4.5F, 14.0F, 12.0F, 8.0F),
                PartPose.offset(0.0F, -10.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(50, 75)
                        .addBox(-8.0F, -8.0F, -7.2F, 16.0F, 16.0F, 8.0F),
                PartPose.offset(0.0F, -7.5F, 0.0F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(33, 87)
                        .addBox(0.0F, -3.0F, -10.0F, 0.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(-1.0F, -10.0F, -5.0F, 0.0F, 0.5235987755982988F, 0.0F));

        PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(48, 56)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 9.0F, 10.0F),
                PartPose.offset(0.0F, -15.0F, -3.0F));

        PartDefinition hairMidL01 = hairMain.addOrReplaceChild("HairMidL01",
                CubeListBuilder.create().texOffs(48, 34)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 13.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 9.0F, 1.5F, 0.3490658503988659F, 0.0F, 0.0F));

        hairMidL01.addOrReplaceChild("HairMidL02",
                CubeListBuilder.create().texOffs(0, 32)
                        .addBox(-7.0F, 0.0F, 0.0F, 14.0F, 14.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 9.0F, 1.8F, -0.17453292519943295F, 0.0F, 0.0F));

        head.addOrReplaceChild("HeadEquip05",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-16.0F, 0.0F, 0.0F, 32.0F, 1.0F, 1.0F),
                PartPose.offset(0.0F, -11.5F, -1.0F));

        PartDefinition headEquip = head.addOrReplaceChild("HeadEquip",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-9.5F, 0.0F, 0.0F, 19.0F, 4.0F, 11.0F),
                PartPose.offsetAndRotation(0.0F, -8.0F, -1.0F, 0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition headEquip03 = headEquip.addOrReplaceChild("HeadEquip03",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-4.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F),
                PartPose.offsetAndRotation(-7.5F, 0.0F, 9.0F, 0.0F, 0.7853981633974483F,
                        0.17453292519943295F));

        headEquip03.addOrReplaceChild("HeadEquip04",
                CubeListBuilder.create().texOffs(92, 30)
                        .addBox(-10.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-4.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.08726646259971647F));

        PartDefinition headEquip01 = headEquip.addOrReplaceChild("HeadEquip01",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F),
                PartPose.offsetAndRotation(7.5F, 0.0F, 9.0F, 0.0F, -0.7853981633974483F,
                        -0.17453292519943295F));

        headEquip01.addOrReplaceChild("HeadEquip02",
                CubeListBuilder.create().mirror().texOffs(92, 30)
                        .addBox(0.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F),
                PartPose.offsetAndRotation(4.0F, 1.0F, 0.0F, 0.0F, 0.0F, -0.08726646259971647F));

        bodyMain.addOrReplaceChild("BoobR",
                CubeListBuilder.create().texOffs(0, 70)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 4.0F),
                PartPose.offsetAndRotation(-3.7F, -9.0F, -3.5F, -0.7853981633974483F,
                        -0.13962634015954636F, -0.08726646259971647F));

        bodyMain.addOrReplaceChild("BoobL",
                CubeListBuilder.create().mirror().texOffs(0, 70)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 4.0F),
                PartPose.offsetAndRotation(3.7F, -9.0F, -3.5F, -0.7853981633974483F,
                        0.13962634015954636F, 0.08726646259971647F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().mirror().texOffs(24, 53)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(8.5F, -10.0F, 0.0F, 0.0F, 0.0F, -0.15707963267948966F));

        armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().mirror().texOffs(0, 53)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                PartPose.offset(0.0F, 10.0F, 0.0F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().texOffs(24, 53)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(-8.5F, -10.0F, 0.0F, 0.0F, 0.0F, 0.15707963267948966F));

        armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().texOffs(0, 53)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                PartPose.offset(0.0F, 10.0F, 0.0F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(0, 17)
                        .addBox(-8.0F, 4.0F, -5.5F, 16.0F, 8.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition legRight = butt.addOrReplaceChild("LegRight",
                CubeListBuilder.create().texOffs(0, 80)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 19.0F, 6.0F),
                PartPose.offsetAndRotation(-4.5F, 9.5F, -3.0F, -0.2618F, 0.0F, -0.05235987755982988F));

        legRight.addOrReplaceChild("ShoesR",
                CubeListBuilder.create().texOffs(22, 70)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 9.0F, 7.0F),
                PartPose.offset(0.0F, 19.0F, -0.2F));

        PartDefinition skirt = butt.addOrReplaceChild("Skirt",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-8.5F, 0.0F, -4.5F, 17.0F, 6.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 7.0F, -2.0F, -0.136659280431156F, 0.0F, 0.0F));

        PartDefinition skirtEquip = skirt.addOrReplaceChild("SkirtEquip",
                CubeListBuilder.create().texOffs(71, 0)
                        .addBox(-9.0F, 0.0F, -5.0F, 18.0F, 3.0F, 10.0F),
                PartPose.offset(0.0F, -3.0F, 0.2F));

        PartDefinition equipBase = skirtEquip.addOrReplaceChild("EquipBase",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 4.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, 0.17453292519943295F, 0.0F, 0.0F));

        equipBase.addOrReplaceChild("EquipBaseM01",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 12.0F, -0.6981317007977318F, 0.0F, 0.0F));

        equipBase.addOrReplaceChild("EquipBaseM03",
                CubeListBuilder.create().texOffs(128, 92)
                        .addBox(-3.0F, -14.0F, 0.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, -0.4363323129985824F, 0.0F, 0.0F));

        equipBase.addOrReplaceChild("EquipBaseM02",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 7.0F),
                PartPose.offset(0.0F, -1.5F, 11.0F));

        PartDefinition equipL01 = equipBase.addOrReplaceChild("EquipL01",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 14.0F, 10.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, -3.0F, 8.0F, -0.20943951023931953F, 0.0F, 0.0F));

        PartDefinition equipL02 = equipL01.addOrReplaceChild("EquipL02",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 10.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(11.5F, 0.0F, 0.6F, 0.0F, 0.5235987755982988F, 0.0F));

        PartDefinition equipL03 = equipL02.addOrReplaceChild("EquipL03",
                CubeListBuilder.create().texOffs(128, 26)
                        .addBox(0.0F, 0.0F, -14.0F, 6.0F, 18.0F, 14.0F),
                PartPose.offsetAndRotation(5.3F, 0.0F, 1.3F, 0.0F, -0.6981317007977318F, 0.0F));

        PartDefinition equipR04 = equipL03.addOrReplaceChild("EquipR04",
                CubeListBuilder.create().texOffs(128, 60)
                        .addBox(0.0F, 0.0F, -10.0F, 6.0F, 7.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 11.0F, -13.0F, 0.0F, 0.17453292519943295F, 0.0F));

        PartDefinition equipLC2Base01 = equipR04.addOrReplaceChild("EquipLC2Base01",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-4.5F, 0.0F, -10.0F, 9.0F, 10.0F, 10.0F),
                PartPose.offset(3.0F, -1.0F, -10.0F));

        PartDefinition equipLC2Base02 = equipLC2Base01.addOrReplaceChild("EquipLC2Base02",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-5.0F, -5.0F, -10.0F, 10.0F, 5.0F, 14.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition equipLC201 = equipLC2Base02.addOrReplaceChild("EquipLC201",
                CubeListBuilder.create().texOffs(128, 117)
                        .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                PartPose.offsetAndRotation(-2.0F, -4.0F, -8.0F, -0.13962634015954636F, 0.0F, 0.0F));

        equipLC201.addOrReplaceChild("EquipLC202",
                CubeListBuilder.create().texOffs(132, 113)
                        .addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 13.0F),
                PartPose.offset(0.0F, 0.0F, -5.0F));

        PartDefinition equipLC203 = equipLC2Base02.addOrReplaceChild("EquipLC203",
                CubeListBuilder.create().texOffs(128, 117)
                        .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                PartPose.offsetAndRotation(2.0F, -4.0F, -8.0F, -0.08726646259971647F, 0.0F, 0.0F));

        equipLC203.addOrReplaceChild("EquipLC204",
                CubeListBuilder.create().texOffs(132, 113)
                        .addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 13.0F),
                PartPose.offset(0.0F, 0.0F, -5.0F));

        PartDefinition equipLCBase01 = equipL03.addOrReplaceChild("EquipLCBase01",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, -5.5F, -10.0F, 7.0F, 11.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 1.0F, -7.0F, 0.0F, 0.08726646259971647F, 0.0F));

        PartDefinition equipLCBase02 = equipLCBase01.addOrReplaceChild("EquipLCBase02",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, -5.0F, -4.0F, 5.0F, 10.0F, 14.0F),
                PartPose.offsetAndRotation(7.0F, 0.0F, -6.5F, -0.17453292519943295F,
                        0.05235987755982988F, 0.0F));

        PartDefinition equipLC01 = equipLCBase02.addOrReplaceChild("EquipLC01",
                CubeListBuilder.create().texOffs(128, 117)
                        .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                PartPose.offsetAndRotation(4.0F, -2.0F, -4.0F, 0.0F, -0.2617993877991494F, 0.0F));

        equipLC01.addOrReplaceChild("EquipLC02",
                CubeListBuilder.create().texOffs(132, 113)
                        .addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 13.0F),
                PartPose.offset(0.0F, 0.0F, -5.0F));

        equipLCBase02.addOrReplaceChild("EquipLCRadar",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, -7.5F, 0.0F, 1.0F, 15.0F, 5.0F),
                PartPose.offset(5.2F, 0.0F, 5.5F));

        PartDefinition equipLC03 = equipLCBase02.addOrReplaceChild("EquipLC03",
                CubeListBuilder.create().texOffs(128, 117)
                        .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                PartPose.offsetAndRotation(4.0F, 2.0F, -4.0F, 0.0F, -0.13962634015954636F, 0.0F));

        equipLC03.addOrReplaceChild("EquipLC04",
                CubeListBuilder.create().texOffs(132, 113)
                        .addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 13.0F),
                PartPose.offset(0.0F, 0.0F, -5.0F));

        PartDefinition equipR01 = equipBase.addOrReplaceChild("EquipR01",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-14.0F, 0.0F, 0.0F, 14.0F, 10.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, -3.0F, 8.0F, -0.20943951023931953F, 0.0F, 0.0F));

        PartDefinition equipR02 = equipR01.addOrReplaceChild("EquipR02",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-10.0F, 0.0F, 0.0F, 10.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(-11.5F, 0.0F, 0.6F, 0.0F, -0.5235987755982988F, 0.0F));

        PartDefinition equipR03 = equipR02.addOrReplaceChild("EquipR03",
                CubeListBuilder.create().texOffs(128, 26)
                        .addBox(-6.0F, 0.0F, -14.0F, 6.0F, 18.0F, 14.0F),
                PartPose.offsetAndRotation(-5.3F, 0.0F, 1.3F, 0.0F, 0.6981317007977318F, 0.0F));

        PartDefinition equipRCBase01 = equipR03.addOrReplaceChild("EquipRCBase01",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-7.0F, -5.5F, -10.0F, 7.0F, 11.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 1.0F, -7.0F, 0.0F, -0.08726646259971647F, 0.0F));

        PartDefinition equipRCBase02 = equipRCBase01.addOrReplaceChild("EquipRCBase02",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-5.0F, -5.0F, -4.0F, 5.0F, 10.0F, 14.0F),
                PartPose.offsetAndRotation(-7.0F, 0.0F, -6.5F, -0.17453292519943295F,
                        -0.05235987755982988F, 0.0F));

        PartDefinition equipRC03 = equipRCBase02.addOrReplaceChild("EquipRC03",
                CubeListBuilder.create().texOffs(128, 117)
                        .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                PartPose.offsetAndRotation(-4.0F, 2.0F, -4.0F, 0.0F, 0.20943951023931953F, 0.0F));

        equipRC03.addOrReplaceChild("EquipRC04",
                CubeListBuilder.create().texOffs(132, 113)
                        .addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 13.0F),
                PartPose.offset(0.0F, 0.0F, -5.0F));

        PartDefinition equipRC01 = equipRCBase02.addOrReplaceChild("EquipRC01",
                CubeListBuilder.create().texOffs(128, 117)
                        .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                PartPose.offsetAndRotation(-4.0F, -2.0F, -4.0F, 0.0F, 0.2617993877991494F, 0.0F));

        equipRC01.addOrReplaceChild("EquipRC02",
                CubeListBuilder.create().texOffs(132, 113)
                        .addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 13.0F),
                PartPose.offset(0.0F, 0.0F, -5.0F));

        equipRCBase02.addOrReplaceChild("EquipRCRadar",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-1.0F, -7.5F, 0.0F, 1.0F, 15.0F, 5.0F),
                PartPose.offset(-5.2F, 0.0F, 5.5F));

        PartDefinition equipR04_1 = equipR03.addOrReplaceChild("EquipR04_1",
                CubeListBuilder.create().texOffs(128, 60)
                        .addBox(-6.0F, 0.0F, -10.0F, 6.0F, 7.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 11.0F, -13.0F, 0.0F, -0.17453292519943295F, 0.0F));

        PartDefinition equipRC2Base01 = equipR04_1.addOrReplaceChild("EquipRC2Base01",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-4.5F, 0.0F, -10.0F, 9.0F, 10.0F, 10.0F),
                PartPose.offset(-3.0F, -1.0F, -10.0F));

        PartDefinition equipRC2Base02 = equipRC2Base01.addOrReplaceChild("EquipRC2Base02",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-5.0F, -5.0F, -10.0F, 10.0F, 5.0F, 14.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition equipRC203 = equipRC2Base02.addOrReplaceChild("EquipRC203",
                CubeListBuilder.create().texOffs(128, 117)
                        .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                PartPose.offsetAndRotation(2.0F, -4.0F, -8.0F, -0.17453292519943295F, 0.0F, 0.0F));

        equipRC203.addOrReplaceChild("EquipRC204",
                CubeListBuilder.create().texOffs(132, 113)
                        .addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 13.0F),
                PartPose.offset(0.0F, 0.0F, -5.0F));

        PartDefinition equipRC201 = equipRC2Base02.addOrReplaceChild("EquipRC201",
                CubeListBuilder.create().texOffs(128, 117)
                        .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                PartPose.offsetAndRotation(-2.0F, -4.0F, -8.0F, -0.08726646259971647F, 0.0F, 0.0F));

        equipRC201.addOrReplaceChild("EquipRC202",
                CubeListBuilder.create().texOffs(132, 113)
                        .addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 13.0F),
                PartPose.offset(0.0F, 0.0F, -5.0F));

        PartDefinition legLeft = butt.addOrReplaceChild("LegLeft",
                CubeListBuilder.create().mirror().texOffs(0, 80)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 19.0F, 6.0F),
                PartPose.offsetAndRotation(4.5F, 9.5F, -3.0F, -0.2618F, 0.0F, 0.05235987755982988F));

        legLeft.addOrReplaceChild("ShoesL",
                CubeListBuilder.create().mirror().texOffs(22, 70)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 9.0F, 7.0F),
                PartPose.offset(0.0F, 19.0F, -0.2F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -14.0F, 0.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -10.0F, 0.0F));

        PartDefinition glowHead = glowNeck.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -1.0F, 0.0F));
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
                this.scale = 2F;
                this.offsetY = -0.73F;
                break;
            case 2:
                this.scale = 1.5F;
                this.offsetY = -0.48F;
                break;
            case 1:
                this.scale = 1F;
                this.offsetY = 0.02F;
                break;
            default:
                this.scale = 0.5F;
                this.offsetY = 1.51F;
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
        this.HeadEquip.visible = !flag;
        this.HeadEquip05.visible = !flag;

        flag = !EmotionHelper.checkModelState(1, state);
        this.EquipBase.visible = !flag;
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
        this.EquipLC201.xRot = this.Head.xRot;
        this.EquipLC203.xRot = this.Head.xRot;
        this.EquipRC201.xRot = this.Head.xRot;
        this.EquipRC203.xRot = this.Head.xRot;
        this.EquipLCBase02.xRot = this.Head.xRot;
        this.EquipLC2Base02.yRot = this.Head.yRot;
        this.EquipRCBase02.xRot = this.Head.xRot;
        this.EquipRC2Base02.yRot = this.Head.yRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        this.offsetY += 0.73F + 0.28F * ent.getScaleLevel();
        this.setFaceHungry(ent);

        // 移動頭部使其看人
        this.Head.xRot = 0F;
        this.Head.yRot = 0F;
        // 胸部
        this.BoobL.xRot = -0.7854F;
        this.BoobR.xRot = -0.7854F;
        // Body
        this.Ahoke.yRot = 0.5236F;
        // arm
        this.ArmLeft01.yRot = 0F;
        this.ArmRight01.yRot = 0F;
        // Body
        this.BodyMain.xRot = 1.48F;
        // hair
        this.HairMidL01.xRot = 0.2F;
        this.HairMidL02.xRot = -0.3F;
        // arm
        this.ArmLeft01.xRot = -2.97F;
        this.ArmLeft01.zRot = 0.26F;
        this.ArmRight01.xRot = -2.8F;
        this.ArmRight01.zRot = -1.3F;
        this.ArmRight02.zRot = -0.9F;
        // leg
        this.LegLeft.xRot = -0.26F;
        this.LegRight.xRot = -0.26F;
        this.LegLeft.yRot = 0F;
        this.LegRight.yRot = 0F;
        this.LegLeft.zRot = -0.14F;
        this.LegRight.zRot = 0.14F;
        // equip
        this.EquipBase.visible = false;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float angleX = Mth.cos(f2 * 0.08F);
        float angleX1 = Mth.cos(f2 * 0.08F + 0.3F + f * 0.5F);
        float angleAdd1 = Mth.cos(f * 0.7F) * f1;
        float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
        float addk1;
        float addk2;
        boolean showCannon = EmotionHelper.checkModelState(1, ent.getStateEmotion(ID.S.State));

        // 水上漂浮
        if (ent.getShipDepth(0) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        // leg move parm
        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += angleX * 0.05F + 0.025F;
        addk1 = angleAdd1 - 0.2118F;
        addk2 = angleAdd2 - 0.1118F;

        // 移動頭部使其看人
        this.Head.xRot = f4 * 0.014F + 0.1F;
        this.Head.yRot = f3 * 0.01F;

        // 正常站立動作
        // 胸部
        this.BoobL.xRot = angleX * 0.06F - 0.7854F;
        this.BoobR.xRot = angleX * 0.06F - 0.7854F;
        // Body
        this.Ahoke.yRot = angleX * 0.25F + 0.5236F;
        this.BodyMain.xRot = -0.1F;
        // hair
        this.HairMidL01.xRot = angleX * 0.06F + 0.2F;
        this.HairMidL02.xRot = -angleX1 * 0.09F - 0.17F;
        this.HairMidL01.zRot = 0F;
        this.HairMidL02.zRot = 0F;
        // arm
        this.ArmLeft01.xRot = angleAdd2 * 0.6F + 0.15F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = angleX * 0.1F - 0.26F;
        this.ArmRight01.xRot = angleAdd1 * 0.6F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = -angleX * 0.1F + 0.26F;
        this.ArmRight02.xRot = 0F;
        this.ArmRight02.yRot = 0F;
        this.ArmRight02.zRot = 0F;
        // leg
        this.LegLeft.yRot = 0F;
        this.LegLeft.zRot = 0.05F;
        this.LegRight.yRot = 0F;
        this.LegRight.zRot = -0.05F;
        // cannon
        if (showCannon) {
            this.EquipBase.xRot = 0.17F;

            if (this.Head.xRot <= 0F) {
                this.EquipLC201.xRot = this.Head.xRot * 0.9F;
                this.EquipLC203.xRot = this.Head.xRot * 1.2F;
                this.EquipRC201.xRot = this.Head.xRot * 1.1F;
                this.EquipRC203.xRot = this.Head.xRot * 0.85F;
            }

            this.EquipLCBase02.xRot = this.Head.xRot;
            this.EquipLC2Base01.xRot = 0F;
            this.EquipLC2Base02.yRot = this.Head.yRot;
            this.EquipLC01.yRot = angleX * 0.1F - 0.26F;
            this.EquipLC03.yRot = -angleX * 0.08F - 0.15F;

            this.EquipRCBase02.xRot = this.Head.xRot;
            this.EquipRC2Base01.xRot = 0F;
            this.EquipRC2Base02.yRot = this.Head.yRot;
            this.EquipRC01.yRot = angleX * 0.08F + 0.2F;
            this.EquipRC03.yRot = -angleX * 0.1F + 0.1F;
        }

        if (ent.getIsSprinting() || f1 > 0.9F) { // 奔跑動作
            // Body
            this.Head.xRot -= 0.35F;
            this.BodyMain.xRot = 0.5236F;
            // hair
            this.HairMidL01.xRot += 0.3F;
            this.HairMidL02.xRot += 0.3F;
            // arm
            this.ArmLeft01.xRot = angleAdd2 * 1.4F - 0.1F;
            this.ArmRight01.xRot = angleAdd1 * 1.4F - 0.1F;
            this.ArmLeft01.zRot = angleX * 0.1F - 0.4F;
            this.ArmRight01.zRot = -angleX * 0.1F + 0.4F;
            // leg
            addk1 -= 0.55F;
            addk2 -= 0.55F;
            this.LegLeft.yRot = 0F;
            this.LegRight.yRot = 0F;
            this.LegLeft.zRot = 0F;
            this.LegRight.zRot = 0F;
            // cannon
            if (showCannon) {
                this.EquipLCBase02.xRot -= 0.45F;
                // this.EquipLC201.xRot -= 0.5F;
                // this.EquipLC203.xRot -= 0.55F;

                this.EquipRCBase02.xRot -= 0.5F;
                // this.EquipRC201.xRot -= 0.6F;
                // this.EquipRC203.xRot -= 0.5F;
            }
        }

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        if (ent.getIsSneaking()) { // 潛行, 蹲下動作
            // Body
            this.Head.xRot -= 0.35F;
            this.BodyMain.xRot = 0.5236F;
            // arm
            this.ArmLeft01.zRot = angleX * 0.1F - 0.4F;
            this.ArmRight01.zRot = -angleX * 0.1F + 0.4F;
            // leg
            addk1 -= 0.55F;
            addk2 -= 0.55F;
            this.LegLeft.yRot = 0F;
            this.LegRight.yRot = 0F;
            this.LegLeft.zRot = 0F;
            this.LegRight.zRot = 0F;
            // cannon
            if (showCannon) {
                this.EquipLCBase02.xRot -= 0.45F;
                // this.EquipLC201.xRot -= 0.5F;
                // this.EquipLC203.xRot -= 0.55F;

                this.EquipRCBase02.xRot -= 0.5F;
                // this.EquipRC201.xRot -= 0.6F;
                // this.EquipRC203.xRot -= 0.5F;
            }
        } // end if sneaking

        if (ent.getIsSitting() || ent.getIsRiding()) { // 騎乘動作
            if (showCannon) {
                // Body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.42F;
                this.BodyMain.xRot = -0.09F;
                // arm
                this.ArmLeft01.xRot = 0.52F;
                this.ArmLeft01.zRot = -1.04F;
                this.ArmRight01.xRot = 0.52F;
                this.ArmRight01.zRot = 1.04F;
                // leg
                addk1 = -1.4F;
                addk2 = -1.4F;
                this.LegLeft.yRot = -0.14F;
                this.LegRight.yRot = 0.14F;
                this.LegLeft.zRot = 0F;
                this.LegRight.zRot = 0F;
                // cannon
                this.EquipLCBase02.xRot = 1.57F;
                this.EquipLC2Base01.xRot = 0.8F;
                this.EquipLC01.yRot = 0F;
                this.EquipLC03.yRot = 0F;
                this.EquipLC201.xRot = 0F;
                this.EquipLC203.xRot = 0F;

                this.EquipRCBase02.xRot = 1.57F;
                this.EquipRC2Base01.xRot = 0.8F;
                this.EquipRC01.yRot = 0F;
                this.EquipRC03.yRot = 0F;
                this.EquipRC201.xRot = 0F;
                this.EquipRC203.xRot = 0F;
            } else if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                this.setFaceHungry(ent);
                // Body
                this.BodyMain.xRot = 1.48F;
                // hair
                this.HairMidL01.xRot = 0.2F;
                this.HairMidL02.xRot = -0.3F;
                // arm
                this.ArmLeft01.xRot = -2.97F;
                this.ArmLeft01.zRot = 0.26F;
                this.ArmRight01.xRot = -2.8F;
                this.ArmRight01.zRot = -1.3F;
                this.ArmRight02.zRot = -0.9F;
                // leg
                addk1 = -0.26F;
                addk2 = -0.26F;
                this.LegLeft.yRot = 0F;
                this.LegRight.yRot = 0F;
                this.LegLeft.zRot = -0.14F;
                this.LegRight.zRot = 0.14F;
            } else {
                // Body
                this.BodyMain.xRot = -0.09F;
                // arm
                this.ArmLeft01.xRot = -0.63F;
                this.ArmLeft01.zRot = 0.14F;
                this.ArmRight01.xRot = -0.63F;
                this.ArmRight01.zRot = -0.14F;
                // leg
                addk1 = -1.75F;
                addk2 = -1.75F;
                this.LegLeft.yRot = -0.14F;
                this.LegRight.yRot = 0.14F;
                this.LegLeft.zRot = 0F;
                this.LegRight.zRot = 0F;
            }
        } // end if sitting

        // 攻擊動作
        if (ent.getAttackTick() > 20) {
            switch (ent.getStateEmotion(ID.S.Phase)) {
                case 0: // heavy atk phase 0
                case 2: // heavy atk phase 2
                    // Body
                    // [PORT] Restored from 1.10.2 GlStateManager.translate
                    this.offsetY += scale * 0.35F + 0F;
                    this.Head.xRot -= 1.22F;
                    this.BodyMain.xRot = 1.75F;
                    // hair
                    this.HairMidL01.xRot += 0.3F;
                    this.HairMidL02.xRot += 0.6F;
                    // arm
                    this.ArmLeft01.xRot = -1.75F;
                    this.ArmLeft01.yRot = 0F;
                    this.ArmLeft01.zRot = 0F;
                    this.ArmRight01.xRot = -1.05F;
                    this.ArmRight01.yRot = 2.62F;
                    this.ArmRight01.zRot = 0.7F;
                    this.ArmRight02.zRot = -0.79F;
                    // leg
                    addk1 = -1.75F;
                    addk2 = -2.27F;
                    this.LegLeft.yRot = -0.44F;
                    this.LegRight.yRot = 0.44F;
                    this.LegLeft.zRot = 0F;
                    this.LegRight.zRot = 0F;
                    // equip
                    this.EquipBase.xRot = -1.22F;
                    this.EquipLCBase02.xRot -= 0.5F;
                    // this.EquipLC201.xRot -= 0.5F;
                    // this.EquipLC203.xRot -= 0.5F;
                    this.EquipRCBase02.xRot -= 0.5F;
                    // this.EquipRC201.xRot -= 0.5F;
                    // this.EquipRC203.xRot -= 0.5F;
                    break;
                default: // cannon or heavy atk phase 1,3
                    // setFace(3);
                    // Body
                    this.BodyMain.xRot = -0.17F;
                    // arm
                    this.ArmLeft01.xRot = -1.57F;
                    this.ArmLeft01.yRot = -0.26F;
                    this.ArmLeft01.zRot = 0F;
                    this.ArmRight01.xRot = 0F;
                    this.ArmRight01.zRot = 0.87F;
                    this.ArmRight02.zRot = -1.57F;
                    // leg
                    addk1 += 0.2618F;
                    addk2 += 0.2618F;
                    this.LegLeft.yRot = 0F;
                    this.LegRight.yRot = 0F;
                    this.LegLeft.zRot = -0.17F;
                    this.LegRight.zRot = 0.17F;
                    break;
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
            this.ArmRight02.xRot = 0F;
            this.ArmRight02.yRot = 0F;
            this.ArmRight02.zRot = 0F;
        }

        // 鬢毛調整
        float headX = this.Head.xRot * -0.5F;
        float headZ = this.Head.zRot * -0.5F;
        this.HairMidL01.xRot += headX;
        this.HairMidL01.zRot += headZ;
        this.HairMidL02.xRot += headX * 0.5F;
        this.HairMidL02.zRot += headZ * 0.5F;

        // leg motion
        this.LegLeft.xRot = addk1;
        this.LegRight.xRot = addk2;
    }
}
