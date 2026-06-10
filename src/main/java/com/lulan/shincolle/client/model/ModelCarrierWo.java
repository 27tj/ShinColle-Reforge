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

public class ModelCarrierWo extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "cv_wo"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Butt;
    private final ModelPart ArmLeft01;
    private final ModelPart ArmRight01;
    private final ModelPart ArmLeft02;
    private final ModelPart ArmRight02;
    private final ModelPart Neck;
    private final ModelPart Neck02;
    private final ModelPart BoobR;
    private final ModelPart BoobL;
    private final ModelPart CloakNeck;
    private final ModelPart LegRight01;
    private final ModelPart LegLeft01;
    private final ModelPart LegRight02;
    private final ModelPart LegLeft02;
    private final ModelPart ShoesRight;
    private final ModelPart ShoesLeft;
    private final ModelPart Staff;
    private final ModelPart StaffHead;
    private final ModelPart Head;
    private final ModelPart Hair;
    private final ModelPart Ahoke;
    private final ModelPart HairL01;
    private final ModelPart Hair00a;
    private final ModelPart Hair00b;
    private final ModelPart HairR01;
    private final ModelPart HairL02;
    private final ModelPart HairR02;
    private final ModelPart EquipBase;
    private final ModelPart Equip01;
    private final ModelPart Equip02;
    private final ModelPart Equip03;
    private final ModelPart Equip04;
    private final ModelPart EquipEye01;
    private final ModelPart EquipEye02;
    private final ModelPart EquipT01L;
    private final ModelPart EquipT01R;
    private final ModelPart Equip05;
    private final ModelPart Equip06;
    private final ModelPart EquipLC01;
    private final ModelPart EquipRC01;
    private final ModelPart EquipTB01L;
    private final ModelPart EquipTB01R;
    private final ModelPart EquipTooth01;
    private final ModelPart EquipTooth02;
    private final ModelPart EquipTooth03;
    private final ModelPart EquipT02L;
    private final ModelPart EquipT03L;
    private final ModelPart EquipT02R;
    private final ModelPart EquipT03R;
    private final ModelPart EquipLC02;
    private final ModelPart EquipLC03;
    private final ModelPart EquipRC02;
    private final ModelPart EquipRC03;
    private final ModelPart EquipTB02L;
    private final ModelPart EquipTB03L;
    private final ModelPart EquipTB02R;
    private final ModelPart EquipTB03R;
    private final ModelPart Cloak01;
    private final ModelPart Cloak02;
    private final ModelPart Cloak03;
    private final ModelPart Neck03;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowHead;
    private final ModelPart GlowEquipBase;

    public ModelCarrierWo(ModelPart root) {
        super();
        this.scale = 0.44F;
        this.offsetY = 1.9F;
        this.BodyMain = root.getChild("BodyMain");
        this.Head = this.BodyMain.getChild("Head");
        this.Neck03 = this.BodyMain.getChild("Neck03");
        this.BoobL = this.BodyMain.getChild("BoobL");
        this.CloakNeck = this.BodyMain.getChild("CloakNeck");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.Neck = this.BodyMain.getChild("Neck");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.BoobR = this.BodyMain.getChild("BoobR");
        this.Butt = this.BodyMain.getChild("Butt");
        this.Hair = this.Head.getChild("Hair");
        this.EquipBase = this.Head.getChild("EquipBase");
        this.Cloak01 = this.CloakNeck.getChild("Cloak01");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.Neck02 = this.Neck.getChild("Neck02");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.LegLeft01 = this.Butt.getChild("LegLeft01");
        this.LegRight01 = this.Butt.getChild("LegRight01");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.HairR01 = this.Hair.getChild("HairR01");
        this.HairL01 = this.Hair.getChild("HairL01");
        this.Hair00a = this.Hair.getChild("Hair00a");
        this.Hair00b = this.Hair.getChild("Hair00b");
        this.Equip05 = this.EquipBase.getChild("Equip05");
        this.Equip03 = this.EquipBase.getChild("Equip03");
        this.EquipTooth03 = this.EquipBase.getChild("EquipTooth03");
        this.Equip04 = this.EquipBase.getChild("Equip04");
        this.EquipLC01 = this.EquipBase.getChild("EquipLC01");
        this.EquipTB01L = this.EquipBase.getChild("EquipTB01L");
        this.Equip06 = this.EquipBase.getChild("Equip06");
        this.Equip02 = this.EquipBase.getChild("Equip02");
        this.EquipT01R = this.EquipBase.getChild("EquipT01R");
        this.EquipTB01R = this.EquipBase.getChild("EquipTB01R");
        this.EquipRC01 = this.EquipBase.getChild("EquipRC01");
        this.EquipTooth02 = this.EquipBase.getChild("EquipTooth02");
        this.EquipT01L = this.EquipBase.getChild("EquipT01L");
        this.Equip01 = this.EquipBase.getChild("Equip01");
        this.EquipTooth01 = this.EquipBase.getChild("EquipTooth01");
        this.Cloak02 = this.Cloak01.getChild("Cloak02");
        this.Staff = this.ArmRight02.getChild("Staff");
        this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.HairR02 = this.HairR01.getChild("HairR02");
        this.HairL02 = this.HairL01.getChild("HairL02");
        this.EquipLC02 = this.EquipLC01.getChild("EquipLC02");
        this.EquipLC03 = this.EquipLC01.getChild("EquipLC03");
        this.EquipTB02L = this.EquipTB01L.getChild("EquipTB02L");
        this.EquipT02R = this.EquipT01R.getChild("EquipT02R");
        this.EquipTB02R = this.EquipTB01R.getChild("EquipTB02R");
        this.EquipRC02 = this.EquipRC01.getChild("EquipRC02");
        this.EquipRC03 = this.EquipRC01.getChild("EquipRC03");
        this.EquipT02L = this.EquipT01L.getChild("EquipT02L");
        this.Cloak03 = this.Cloak02.getChild("Cloak03");
        this.StaffHead = this.Staff.getChild("StaffHead");
        this.ShoesLeft = this.LegLeft02.getChild("ShoesLeft");
        this.ShoesRight = this.LegRight02.getChild("ShoesRight");
        this.EquipTB03L = this.EquipTB02L.getChild("EquipTB03L");
        this.EquipT03R = this.EquipT02R.getChild("EquipT03R");
        this.EquipTB03R = this.EquipTB02R.getChild("EquipTB03R");
        this.EquipT03L = this.EquipT02L.getChild("EquipT03L");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowHead = this.GlowBodyMain.getChild("GlowHead");
        this.GlowEquipBase = this.GlowHead.getChild("GlowEquipBase");
        this.EquipEye01 = this.GlowEquipBase.getChild("EquipEye01");
        this.EquipEye02 = this.GlowEquipBase.getChild("EquipEye02");
        this.loadFaceParts(this.GlowHead);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-6.5F, -12.0F, -4.0F, 13.0F, 17.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, -0.3490658503988659F, 0.0F, 0.0F));

        PartDefinition head = bodyMain.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(43, 101)
                        .addBox(-7.0F, -14.0F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offset(0.0F, -13.0F, -0.5F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(128, 61)
                        .addBox(-8.0F, -8.0F, -7.2F, 16.0F, 14.0F, 7.0F),
                PartPose.offset(0.0F, -7.0F, 0.0F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(31, 89)
                        .addBox(0.0F, -13.5F, -12.0F, 0.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -4.5F, 0.0F, 0.7F, 0.0F));

        PartDefinition hairR01 = hair.addOrReplaceChild("HairR01",
                CubeListBuilder.create().mirror().texOffs(175, 61)
                        .addBox(-1.0F, 0.0F, -2.0F, 2.0F, 9.0F, 4.0F),
                PartPose.offsetAndRotation(-6.0F, 0.0F, -2.0F, -0.5235987755982988F, 0.17453292519943295F,
                        0.3141592653589793F));

        hairR01.addOrReplaceChild("HairR02",
                CubeListBuilder.create().texOffs(176, 74)
                        .addBox(-1.0F, 0.0F, -2.2F, 2.0F, 9.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.3490658503988659F, 0.0F, -0.2617993877991494F));

        PartDefinition hairL01 = hair.addOrReplaceChild("HairL01",
                CubeListBuilder.create().texOffs(175, 61)
                        .addBox(-1.0F, 0.0F, -2.0F, 2.0F, 9.0F, 4.0F),
                PartPose.offsetAndRotation(6.0F, 0.0F, -2.0F, -0.5235987755982988F, -0.17453292519943295F,
                        -0.3141592653589793F));

        hairL01.addOrReplaceChild("HairL02",
                CubeListBuilder.create().mirror().texOffs(176, 74)
                        .addBox(-1.0F, 0.0F, -2.2F, 2.0F, 9.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.3490658503988659F, 0.0F, 0.2617993877991494F));

        hair.addOrReplaceChild("Hair00a",
                CubeListBuilder.create().texOffs(128, 82)
                        .addBox(-7.5F, -7.5F, -1.0F, 15.0F, 8.0F, 9.0F),
                PartPose.offset(0.0F, 0.0F, -0.5F));

        hair.addOrReplaceChild("Hair00b",
                CubeListBuilder.create().texOffs(43, 21)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 10.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 0.3F, -2.5F, 0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition equipBase = head.addOrReplaceChild("EquipBase",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, -10.0F, -3.0F, 0.08726646259971647F, 0.0F, 0.0F));

        equipBase.addOrReplaceChild("Equip05",
                CubeListBuilder.create().texOffs(104, 4)
                        .addBox(-24.0F, -18.0F, -15.0F, 48.0F, 18.0F, 28.0F),
                PartPose.offsetAndRotation(0.0F, -5.0F, 2.5F, 0.03490658503988659F, 0.0F, 0.0F));

        equipBase.addOrReplaceChild("Equip03",
                CubeListBuilder.create().texOffs(112, 0)
                        .addBox(-16.0F, -18.0F, -20.0F, 32.0F, 18.0F, 40.0F),
                PartPose.offsetAndRotation(0.0F, -5.5F, 4.0F, 0.06981317007977318F, 0.0F, 0.0F));

        equipBase.addOrReplaceChild("EquipTooth03",
                CubeListBuilder.create().mirror().texOffs(128, 99)
                        .addBox(-14.0F, 0.0F, 0.0F, 14.0F, 8.0F, 4.0F),
                PartPose.offsetAndRotation(-12.4F, -17.0F, -20.3F, 0.06981317007977318F, 0.5235987755982988F,
                        -0.05235987755982988F));

        equipBase.addOrReplaceChild("Equip04",
                CubeListBuilder.create().texOffs(112, 0)
                        .addBox(-12.0F, -15.0F, -24.0F, 24.0F, 15.0F, 46.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, 5.5F, 0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition equipLC01 = equipBase.addOrReplaceChild("EquipLC01",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-3.5F, -5.5F, -7.5F, 7.0F, 11.0F, 15.0F),
                PartPose.offsetAndRotation(30.0F, -7.0F, 4.0F, -0.17453292519943295F, -0.2617993877991494F,
                        0.17453292519943295F));

        equipLC01.addOrReplaceChild("EquipLC02",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F),
                PartPose.offsetAndRotation(-1.0F, -2.0F, -7.0F, -0.10471975511965977F, 0.0F, 0.0F));

        equipLC01.addOrReplaceChild("EquipLC03",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-1.5F, -1.5F, -16.0F, 3.0F, 3.0F, 16.0F),
                PartPose.offsetAndRotation(0.0F, 2.0F, -7.0F, 0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition equipTB01L = equipBase.addOrReplaceChild("EquipTB01L",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-3.0F, -2.0F, -3.0F, 6.0F, 10.0F, 6.0F),
                PartPose.offsetAndRotation(15.0F, -6.0F, 10.0F, 0.17453292519943295F, 0.0F, -0.3490658503988659F));

        PartDefinition equipTB02L = equipTB01L.addOrReplaceChild("EquipTB02L",
                CubeListBuilder.create().texOffs(21, 56)
                        .addBox(-2.5F, -2.0F, -2.5F, 5.0F, 16.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.4363323129985824F, 0.0F, -0.3490658503988659F));

        equipTB02L.addOrReplaceChild("EquipTB03L",
                CubeListBuilder.create().texOffs(21, 56)
                        .addBox(-2.0F, -2.0F, -2.0F, 4.0F, 15.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.6981317007977318F, 0.0F, 0.7853981633974483F));

        equipBase.addOrReplaceChild("Equip06",
                CubeListBuilder.create().texOffs(96, 0)
                        .addBox(-29.0F, -13.0F, -13.0F, 58.0F, 13.0F, 22.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, 4.5F, 0.06981317007977318F, 0.0F, 0.0F));

        equipBase.addOrReplaceChild("Equip02",
                CubeListBuilder.create().texOffs(120, 0)
                        .addBox(-18.0F, -22.0F, -15.0F, 36.0F, 22.0F, 32.0F),
                PartPose.offsetAndRotation(0.0F, -3.0F, 2.0F, 0.03490658503988659F, 0.0F, 0.0F));

        PartDefinition equipT01R = equipBase.addOrReplaceChild("EquipT01R",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-4.0F, 0.0F, -4.0F, 8.0F, 10.0F, 8.0F),
                PartPose.offsetAndRotation(-17.0F, -7.0F, -8.0F, -0.2617993877991494F, 0.0F, 0.2617993877991494F));

        PartDefinition equipT02R = equipT01R.addOrReplaceChild("EquipT02R",
                CubeListBuilder.create().texOffs(21, 56)
                        .addBox(-3.0F, -2.0F, -3.0F, 6.0F, 22.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, -0.17453292519943295F, 0.0F, 0.2617993877991494F));

        equipT02R.addOrReplaceChild("EquipT03R",
                CubeListBuilder.create().texOffs(21, 56)
                        .addBox(-2.5F, -2.0F, -2.5F, 5.0F, 20.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 20.0F, 0.0F, 1.0471975511965976F, 0.0F, -0.7853981633974483F));

        PartDefinition equipTB01R = equipBase.addOrReplaceChild("EquipTB01R",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-3.0F, -2.0F, -3.0F, 6.0F, 10.0F, 6.0F),
                PartPose.offsetAndRotation(-15.0F, -6.0F, 10.0F, 0.17453292519943295F, 0.0F, 0.3490658503988659F));

        PartDefinition equipTB02R = equipTB01R.addOrReplaceChild("EquipTB02R",
                CubeListBuilder.create().texOffs(21, 56)
                        .addBox(-2.5F, -2.0F, -2.5F, 5.0F, 16.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.4363323129985824F, 0.0F, 0.3490658503988659F));

        equipTB02R.addOrReplaceChild("EquipTB03R",
                CubeListBuilder.create().texOffs(21, 56)
                        .addBox(-2.0F, -2.0F, -2.0F, 4.0F, 15.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.6981317007977318F, 0.0F, -0.7853981633974483F));

        PartDefinition equipRC01 = equipBase.addOrReplaceChild("EquipRC01",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-3.5F, -5.5F, -7.5F, 7.0F, 11.0F, 15.0F),
                PartPose.offsetAndRotation(-30.0F, -7.0F, 4.0F, -0.17453292519943295F, 0.2617993877991494F,
                        -0.17453292519943295F));

        equipRC01.addOrReplaceChild("EquipRC02",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F),
                PartPose.offsetAndRotation(1.0F, -2.0F, -7.0F, -0.10471975511965977F, 0.0F, 0.0F));

        equipRC01.addOrReplaceChild("EquipRC03",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-1.5F, -1.5F, -16.0F, 3.0F, 3.0F, 16.0F),
                PartPose.offsetAndRotation(0.0F, 2.0F, -7.0F, 0.10471975511965977F, 0.0F, 0.0F));

        equipBase.addOrReplaceChild("EquipTooth02",
                CubeListBuilder.create().texOffs(128, 99)
                        .addBox(0.0F, 0.0F, 0.0F, 14.0F, 8.0F, 4.0F),
                PartPose.offsetAndRotation(12.4F, -17.0F, -20.3F, 0.10471975511965977F, -0.5235987755982988F,
                        0.05235987755982988F));

        PartDefinition equipT01L = equipBase.addOrReplaceChild("EquipT01L",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-4.0F, 0.0F, -4.0F, 8.0F, 10.0F, 8.0F),
                PartPose.offsetAndRotation(17.0F, -7.0F, -8.0F, -0.2617993877991494F, 0.0F, -0.2617993877991494F));

        PartDefinition equipT02L = equipT01L.addOrReplaceChild("EquipT02L",
                CubeListBuilder.create().texOffs(21, 56)
                        .addBox(-3.0F, -2.0F, -3.0F, 6.0F, 22.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, -0.17453292519943295F, 0.0F, -0.2617993877991494F));

        equipT02L.addOrReplaceChild("EquipT03L",
                CubeListBuilder.create().texOffs(21, 56)
                        .addBox(-2.5F, -2.0F, -2.5F, 5.0F, 20.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 20.0F, 0.0F, 1.0471975511965976F, 0.0F, 0.7853981633974483F));

        equipBase.addOrReplaceChild("Equip01",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-9.0F, -28.5F, -7.0F, 18.0F, 27.0F, 22.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

        equipBase.addOrReplaceChild("EquipTooth01",
                CubeListBuilder.create().texOffs(128, 112)
                        .addBox(-12.0F, 0.0F, 0.0F, 24.0F, 15.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, -19.3F, -20.6F, 0.10471975511965977F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("Neck03",
                CubeListBuilder.create().texOffs(8, 0)
                        .addBox(-2.5F, -2.0F, -2.5F, 5.0F, 2.0F, 5.0F),
                PartPose.offset(0.0F, -11.9F, 0.0F));

        bodyMain.addOrReplaceChild("BoobL",
                CubeListBuilder.create().mirror().texOffs(3, 27)
                        .addBox(-3.5F, 0.0F, -1.0F, 7.0F, 5.0F, 4.0F),
                PartPose.offsetAndRotation(3.5F, -9.0F, -3.2F, -0.7853981633974483F, 0.08726646259971647F, 0.14F));

        PartDefinition cloakNeck = bodyMain.addOrReplaceChild("CloakNeck",
                CubeListBuilder.create().texOffs(192, 61)
                        .addBox(-10.0F, 0.0F, -6.0F, 20.0F, 7.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -12.0F, -1.5F, 0.31416F, 0.0F, 0.0F));

        PartDefinition cloak01 = cloakNeck.addOrReplaceChild("Cloak01",
                CubeListBuilder.create().texOffs(216, 85)
                        .addBox(-10.0F, 0.0F, 0.0F, 20.0F, 12.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 6.5F, 6.0F, 0.5F, 0.0F, 0.0F));

        PartDefinition cloak02 = cloak01.addOrReplaceChild("Cloak02",
                CubeListBuilder.create().texOffs(208, 97)
                        .addBox(-12.0F, 0.0F, 0.0F, 24.0F, 16.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.4553564018453205F, 0.0F, 0.0F));

        cloak02.addOrReplaceChild("Cloak03",
                CubeListBuilder.create().texOffs(196, 113)
                        .addBox(-15.0F, 0.0F, 0.0F, 30.0F, 15.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 16.0F, 0.0F, 0.3490658503988659F, 0.0F, 0.0F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().texOffs(0, 54)
                        .addBox(-5.0F, -1.0F, -2.0F, 5.0F, 12.0F, 5.0F),
                PartPose.offset(-4.7F, -9.0F, 0.0F));

        PartDefinition armRight02 = armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().texOffs(0, 71)
                        .addBox(0.0F, 0.0F, -4.0F, 5.0F, 12.0F, 5.0F),
                PartPose.offset(-5.0F, 11.0F, 2.0F));

        PartDefinition staff = armRight02.addOrReplaceChild("Staff",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, -15.0F, 0.0F, 3.0F, 28.0F, 4.0F),
                PartPose.offsetAndRotation(8.0F, 35.0F, 21.0F, 1.1838568316277536F, -0.18203784098300857F,
                        -1.2292353921796064F));

        staff.addOrReplaceChild("StaffHead",
                CubeListBuilder.create().texOffs(38, 80)
                        .addBox(0.0F, -13.0F, 0.0F, 4.0F, 13.0F, 8.0F),
                PartPose.offset(-0.5F, -15.0F, -1.0F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(46, 41)
                        .addBox(-7.5F, -1.5F, -7.0F, 15.0F, 4.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, -13.0F, -2.0F, 0.41888F, 0.0F, 0.0F));

        neck.addOrReplaceChild("Neck02",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 2.0F, -5.0F, -0.52F, 0.0F, 0.0F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().mirror().texOffs(0, 54)
                        .addBox(0.0F, -1.0F, -2.0F, 5.0F, 12.0F, 5.0F),
                PartPose.offset(4.7F, -9.0F, 0.0F));

        armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().mirror().texOffs(0, 71)
                        .addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
                PartPose.offset(5.0F, 11.0F, 3.0F));

        bodyMain.addOrReplaceChild("BoobR",
                CubeListBuilder.create().texOffs(3, 27)
                        .addBox(-3.5F, 0.0F, -1.0F, 7.0F, 5.0F, 4.0F),
                PartPose.offsetAndRotation(-3.5F, -9.0F, -3.2F, -0.7853981633974483F, -0.08726646259971647F, -0.14F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(0, 38)
                        .addBox(-7.5F, -2.0F, -4.1F, 15.0F, 8.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 4.7F, 0.5F, 0.5235987755982988F, 0.0F, 0.0F));

        PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().mirror().texOffs(0, 88)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F),
                PartPose.offset(4.2F, 5.0F, -1.0F));

        PartDefinition legLeft02 = legLeft01.addOrReplaceChild("LegLeft02",
                CubeListBuilder.create().mirror().texOffs(1, 110)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 7.0F, 6.0F),
                PartPose.offset(0.0F, 12.0F, -3.0F));

        legLeft02.addOrReplaceChild("ShoesLeft",
                CubeListBuilder.create().texOffs(0, 109)
                        .addBox(-3.5F, 4.5F, -0.5F, 7.0F, 9.0F, 7.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().texOffs(0, 88)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F),
                PartPose.offset(-4.2F, 5.0F, -1.0F));

        PartDefinition legRight02 = legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().texOffs(1, 110)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 7.0F, 6.0F),
                PartPose.offset(0.0F, 12.0F, -3.0F));

        legRight02.addOrReplaceChild("ShoesRight",
                CubeListBuilder.create().texOffs(0, 109)
                        .addBox(-3.5F, 4.5F, -0.5F, 7.0F, 9.0F, 7.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -11.0F, 0.0F));

        PartDefinition glowHead = glowBodyMain.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -13.0F, -0.5F));
        addDefaultFaceParts(glowHead);

        PartDefinition glowEquipBase = glowHead.addOrReplaceChild("GlowEquipBase",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -10.0F, -3.0F));

        glowEquipBase.addOrReplaceChild("EquipEye01",
                CubeListBuilder.create().texOffs(44, 0)
                        .addBox(-7.5F, -6.0F, 0.0F, 15.0F, 6.0F, 14.0F),
                PartPose.offsetAndRotation(-14.5F, -21.0F, -8.0F, 0.13962634015954636F, 0.13962634015954636F,
                        -0.2617993877991494F));

        glowEquipBase.addOrReplaceChild("EquipEye02",
                CubeListBuilder.create().texOffs(44, 0)
                        .addBox(-7.5F, -6.0F, 0.0F, 15.0F, 6.0F, 14.0F),
                PartPose.offsetAndRotation(14.5F, -21.0F, -8.0F, 0.13962634015954636F, -0.13962634015954636F,
                        0.2617993877991494F));

        return LayerDefinition.create(meshdefinition, 256, 128);
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

        boolean flag = !EmotionHelper.checkModelState(0, state); // head
        this.EquipBase.visible = !flag;
        this.GlowEquipBase.visible = !flag;

        flag = !EmotionHelper.checkModelState(1, state); // weapon
        this.Staff.visible = !flag;

        flag = !EmotionHelper.checkModelState(2, state); // neck
        this.Neck.visible = !flag;

        flag = !EmotionHelper.checkModelState(3, state); // cloak
        this.CloakNeck.visible = !flag;
    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowBodyMain.xRot = this.BodyMain.xRot;
        this.GlowBodyMain.yRot = this.BodyMain.yRot;
        this.GlowBodyMain.zRot = this.BodyMain.zRot;
        this.GlowEquipBase.xRot = this.EquipBase.xRot;
        this.GlowEquipBase.yRot = this.EquipBase.yRot;
        this.GlowEquipBase.zRot = this.EquipBase.zRot;
        this.GlowHead.xRot = this.Head.xRot;
        this.GlowHead.yRot = this.Head.yRot;
        this.GlowHead.zRot = this.Head.zRot;
        this.EquipLC01.xRot = this.Head.xRot;
        this.EquipLC01.xRot = this.Head.xRot;
        this.EquipRC01.xRot = this.Head.xRot;
        this.EquipRC01.xRot = this.Head.xRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += 0.41F;
        this.setFaceHungry(ent);

        // 頭部
        this.Head.yRot = 0F; // 左右角度 角度轉成rad 即除以57.29578
        this.Head.xRot = 0F; // 上下角度
        // 胸部
        this.BoobL.xRot = -0.63F;
        this.BoobR.xRot = -0.63F;
        // 呆毛
        this.Ahoke.yRot = 0.5236F;
        // 手臂晃動
        this.ArmRight02.yRot = 0F;
        // 身體角度
        this.BodyMain.xRot = 0.2094F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        this.Butt.xRot = -0.4189F;
        // this.Butt.offsetZ = -0.12F;
        // 手臂
        this.ArmLeft01.xRot = -1.0472F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = 0.4189F;
        this.ArmLeft02.xRot = -0.1396F;
        this.ArmLeft02.yRot = 0F;
        this.ArmLeft02.zRot = 1.2915F;
        this.ArmRight01.xRot = -0.8727F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = -0.0873F;
        this.ArmRight02.zRot = -1.1345F;
        // 腿擺動
        this.LegLeft01.xRot = -2.2689F;
        this.LegLeft01.yRot = -0.2094F;
        this.LegLeft01.zRot = -0.2094F;
        this.LegLeft02.xRot = 1.7454F;
        // this.LegLeft02.offsetZ = 0.3F;
        this.LegRight01.xRot = -2.2689F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = 0.0873F;
        this.LegRight02.xRot = 1.5708F;
        // this.LegRight02.offsetZ = 0.3F;
        // 披風擺動
        this.Cloak01.xRot = 0.2618F;
        this.Cloak02.xRot = -1.3963F;
        this.Cloak03.xRot = -0.9425F;
        // 杖位置
        this.Staff.xRot = 1.309F;
        this.Staff.yRot = -0.5934F;
        this.Staff.zRot = -0.2094F;
        // this.Staff.offsetX = -0.3F;
        // this.Staff.offsetY = -1.5F;
        // this.Staff.offsetZ = -1.7F;
        // 觸手晃動 (equip only)
        if (EmotionHelper.checkModelState(0, ent.getStateEmotion(ID.S.State))) {
            this.EquipLC01.xRot = this.Head.xRot;
            this.EquipRC01.xRot = this.Head.xRot;

            this.EquipT01L.xRot = -0.2618F;
            this.EquipT01L.zRot = -0.2618F;
            this.EquipT02L.xRot = -0.3491F;
            this.EquipT02L.zRot = 0.2618F;
            this.EquipT03L.xRot = 1.0472F;
            this.EquipT03L.zRot = 1.0472F;

            this.EquipT01R.xRot = -0.2618F;
            this.EquipT01R.zRot = 0.2618F;
            this.EquipT02R.xRot = -0.3491F;
            this.EquipT02R.zRot = -0.2618F;
            this.EquipT03R.xRot = 1.0472F;
            this.EquipT03R.zRot = -1.0472F;

            this.EquipTB01L.xRot = 0.1745F;
            this.EquipTB01L.zRot = -0.3491F;
            this.EquipTB02L.xRot = -0.6981F;
            this.EquipTB02L.zRot = 0.3491F;
            this.EquipTB03L.xRot = 0.1745F;
            this.EquipTB03L.zRot = 0.2618F;

            this.EquipTB01R.xRot = 0.1745F;
            this.EquipTB01R.zRot = 0.3491F;
            this.EquipTB02R.xRot = -0.6981F;
            this.EquipTB02R.zRot = -0.3491F;
            this.EquipTB03R.xRot = 0.1745F;
            this.EquipTB03R.zRot = -0.2618F;
        }
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float angleZ = Mth.cos(f2 * 0.08F);
        float addk1;
        float addk2;

        // 水上漂浮
        if (ent.getShipDepth(0) > 0D) {
            // [PORT] 1.10.2 -> 1.20.1: restore legacy water bobbing translation.
            this.offsetY += angleZ * 0.05F + 0.025F;
        }

        // leg move parm
        addk1 = Mth.cos(f * 0.4F) * 0.5F * f1;
        addk2 = Mth.cos(f * 0.4F + 3.1415927F) * 0.5F * f1;

        // 移動頭部使其看人
        this.Head.xRot = f4 * 0.012F; // 上下角度
        this.Head.yRot = f3 * 0.01F; // 左右角度
        // 正常站立動作
        // 胸部
        this.BoobL.xRot = -angleZ * 0.06F - 0.63F;
        this.BoobR.xRot = -angleZ * 0.06F - 0.63F;
        // 呆毛
        this.Ahoke.yRot = angleZ * 0.25F + 0.5236F;
        // 手臂晃動
        this.ArmLeft01.xRot = -0.3F;
        this.ArmRight01.xRot = -0.3F;
        this.ArmLeft01.yRot = 0F;
        this.ArmRight01.yRot = 0F;
        this.ArmLeft01.zRot = 0.24F;
        this.ArmRight01.zRot = -0.24F;
        this.ArmLeft02.xRot = 0F;
        this.ArmLeft02.yRot = 0F;
        this.ArmLeft02.zRot = 0F;
        this.ArmRight02.yRot = 0F;
        this.ArmLeft02.zRot = 0F;
        this.ArmRight02.zRot = 0F;
        // 身體角度
        this.BodyMain.xRot = -0.1745F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        this.Butt.xRot = 0.5236F;
        // this.Butt.offsetY = 0F;
        // this.Butt.offsetZ = 0F;
        // hair
        this.HairL01.xRot = -0.3F;
        this.HairL02.xRot = 0.35F;
        this.HairR01.xRot = -0.3F;
        this.HairR02.xRot = 0.35F;
        this.HairL01.zRot = -0.314F;
        this.HairL02.zRot = 0.2618F;
        this.HairR01.zRot = 0.314F;
        this.HairR02.zRot = -0.2618F;
        // 腿擺動
        addk1 -= 0.349F;
        addk2 -= 0.349F;
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.052F;
        this.LegLeft02.xRot = 0F;
        // this.LegLeft02.offsetZ = 0F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.052F;
        this.LegRight02.xRot = 0F;
        // this.LegRight02.offsetZ = 0F;
        // 披風擺動
        this.Cloak01.xRot = angleZ * 0.05F + 0.2618F;
        this.Cloak02.xRot = angleZ * 0.1F + 0.1745F;
        this.Cloak03.xRot = angleZ * 0.15F + 0.2618F;
        // 杖位置
        this.Staff.xRot = 0F;
        this.Staff.yRot = 0F;
        this.Staff.zRot = 1.8326F;
        // this.Staff.offsetX = -0.7F;
        // this.Staff.offsetY = -1.7F;
        // this.Staff.offsetZ = -1.4F;
        // 觸手晃動 (equip only)
        boolean fhead = EmotionHelper.checkModelState(0, ent.getStateEmotion(ID.S.State));
        if (fhead) {
            this.EquipLC01.xRot = this.Head.xRot;
            this.EquipRC01.xRot = this.Head.xRot;

            this.EquipT01L.xRot = angleZ * 0.05F - 0.2618F;
            this.EquipT01L.zRot = angleZ * 0.05F - 0.2618F;
            this.EquipT02L.xRot = angleZ * 0.1F;
            this.EquipT02L.zRot = angleZ * 0.1F;
            this.EquipT03L.xRot = angleZ * 0.25F;
            this.EquipT03L.zRot = angleZ * 0.25F;

            this.EquipT01R.xRot = angleZ * 0.05F - 0.2618F;
            this.EquipT01R.zRot = -angleZ * 0.05F + 0.2618F;
            this.EquipT02R.xRot = angleZ * 0.1F;
            this.EquipT02R.zRot = -angleZ * 0.1F;
            this.EquipT03R.xRot = angleZ * 0.25F;
            this.EquipT03R.zRot = -angleZ * 0.25F;

            this.EquipTB01L.xRot = -angleZ * 0.05F + 0.2618F;
            this.EquipTB01L.zRot = angleZ * 0.05F - 0.2618F;
            this.EquipTB02L.xRot = -angleZ * 0.1F;
            this.EquipTB02L.zRot = angleZ * 0.1F;
            this.EquipTB03L.xRot = -angleZ * 0.25F;
            this.EquipTB03L.zRot = angleZ * 0.25F;

            this.EquipTB01R.xRot = -angleZ * 0.05F + 0.2618F;
            this.EquipTB01R.zRot = -angleZ * 0.05F + 0.2618F;
            this.EquipTB02R.xRot = -angleZ * 0.1F;
            this.EquipTB02R.zRot = -angleZ * 0.1F;
            this.EquipTB03R.xRot = -angleZ * 0.25F;
            this.EquipTB03R.zRot = -angleZ * 0.25F;
        }

        if (ent.getIsSprinting() || f1 > 0.9F) { // 奔跑動作
            float angleZFast = Mth.cos(f2 * 0.3F);
            // 手臂晃動
            this.ArmLeft01.xRot = -0.6981F;
            this.ArmRight01.xRot = -0.6981F;
            this.ArmLeft01.yRot = 0.4F;
            this.ArmRight01.yRot = -0.4F;
            this.ArmLeft01.zRot = 0F;
            this.ArmRight01.zRot = 0F;
            // 身體角度
            this.BodyMain.xRot = -0.349F;
            // 腿擺動
            addk1 = 0F;
            addk2 = 0F;
            this.LegLeft01.yRot = 0F;
            this.LegRight01.yRot = 0F;
            this.LegLeft01.zRot = 0.05236F;
            this.LegRight01.zRot = -0.05236F;
            // 披風擺動
            this.Cloak01.xRot = angleZFast * 0.1F + 1.2F;
            this.Cloak02.xRot = angleZFast * 0.25F;
            this.Cloak03.xRot = angleZFast * 0.15F;
            // 杖位置
            this.Staff.xRot = 1.3F;
            this.Staff.yRot = -0.1820F;
            this.Staff.zRot = -1.2292F;
            // this.Staff.offsetX = 0.2F;
            // this.Staff.offsetY = -1F;
            // this.Staff.offsetZ = -0.1F;
            // 觸手晃動 (equip only)
            if (fhead) {
                this.EquipT01L.xRot = angleZFast * 0.05F + 0.2618F;
                this.EquipT01L.zRot = -0.2618F;
                this.EquipT02L.xRot = angleZFast * 0.15F + 0.2618F;
                this.EquipT02L.zRot = -0.2618F;
                this.EquipT03L.xRot = angleZFast * 0.45F + 0.5236F;
                this.EquipT03L.zRot = -0.2618F;

                this.EquipT01R.xRot = angleZFast * 0.05F + 0.2618F;
                this.EquipT01R.zRot = 0.2618F;
                this.EquipT02R.xRot = angleZFast * 0.15F + 0.2618F;
                this.EquipT02R.zRot = 0.2618F;
                this.EquipT03R.xRot = angleZFast * 0.45F + 0.5236F;
                this.EquipT03R.zRot = 0.2618F;

                this.EquipTB01L.xRot = angleZFast * 0.05F + 0.349F;
                this.EquipTB01L.zRot = -0.349F;
                this.EquipTB02L.xRot = angleZFast * 0.15F + 0.5236F;
                this.EquipTB02L.zRot = 0.1745F;
                this.EquipTB03L.xRot = angleZFast * 0.45F + 0.5236F;
                this.EquipTB03L.zRot = 0.1745F;

                this.EquipTB01R.xRot = angleZFast * 0.05F + 0.349F;
                this.EquipTB01R.zRot = 0.349F;
                this.EquipTB02R.xRot = angleZFast * 0.15F + 0.5236F;
                this.EquipTB02R.zRot = -0.1745F;
                this.EquipTB03R.xRot = angleZFast * 0.45F + 0.5236F;
                this.EquipTB03R.zRot = -0.1745F;
            }
        }

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        if (ent.getIsSneaking()) {
            // 潛行, 蹲下動作
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.05F;
            this.ArmLeft01.xRot = 0.7F;
            this.ArmRight01.xRot = 0.7F;
            this.BodyMain.xRot = 0.5F;
            this.Head.xRot -= 0.5F;
            this.Cloak01.xRot = angleZ * 0.02F + 0.34F;
            addk1 -= 0.66F;
            addk2 -= 0.66F;
        } else {
            this.Head.xRot += 0.2F;
        }

        if (ent.getIsSitting() || ent.getIsRiding()) { // 騎乘動作
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                // 身體角度
                this.BodyMain.xRot = 0.2094F;
                this.BodyMain.yRot = 0F;
                this.BodyMain.zRot = 0F;
                this.Butt.xRot = -0.4189F;
                // this.Butt.offsetZ = -0.12F;
                // 頭
                this.Head.yRot *= 0.5F;
                // 手臂
                this.ArmLeft01.xRot = -1.0472F;
                this.ArmLeft01.yRot = 0F;
                this.ArmLeft01.zRot = 0.4189F;
                this.ArmLeft02.xRot = -0.1396F;
                this.ArmLeft02.yRot = 0F;
                this.ArmLeft02.zRot = 1.2915F;
                this.ArmRight01.xRot = -0.8727F;
                this.ArmRight01.yRot = 0F;
                this.ArmRight01.zRot = -0.0873F;
                this.ArmRight02.zRot = -1.1345F;
                // 腿擺動
                addk1 = -2.2689F;
                addk2 = -2.2689F;
                this.LegLeft01.yRot = -0.2094F;
                this.LegLeft01.zRot = -0.2094F;
                this.LegLeft02.xRot = 1.7454F;
                // this.LegLeft02.offsetZ = 0.3F;
                this.LegRight01.yRot = 0F;
                this.LegRight01.zRot = 0.0873F;
                this.LegRight02.xRot = 1.5708F;
                // this.LegRight02.offsetZ = 0.3F;
                // 披風擺動
                this.Cloak01.xRot = 0.2618F;
                this.Cloak02.xRot = -1.3963F;
                this.Cloak03.xRot = -0.9425F;
                // 杖位置
                this.Staff.xRot = 1.309F;
                this.Staff.yRot = -0.5934F;
                this.Staff.zRot = -0.2094F;
                // this.Staff.offsetX = -0.3F;
                // this.Staff.offsetY = -1.5F;
                // this.Staff.offsetZ = -1.7F;
                // 觸手晃動 (equip only)
                if (fhead) {
                    this.EquipT01L.xRot = angleZ * 0.01F - 0.2618F;
                    this.EquipT01L.zRot = -0.2618F;
                    this.EquipT02L.xRot = angleZ * 0.03F - 0.3491F;
                    this.EquipT02L.zRot = 0.2618F;
                    this.EquipT03L.xRot = -angleZ * 0.1F + 1.0472F;
                    this.EquipT03L.zRot = 1.0472F;

                    this.EquipT01R.xRot = -angleZ * 0.01F - 0.2618F;
                    this.EquipT01R.zRot = 0.2618F;
                    this.EquipT02R.xRot = -angleZ * 0.03F - 0.3491F;
                    this.EquipT02R.zRot = -0.2618F;
                    this.EquipT03R.xRot = angleZ * 0.1F + 1.0472F;
                    this.EquipT03R.zRot = -1.0472F;

                    this.EquipTB01L.xRot = angleZ * 0.01F + 0.1745F;
                    this.EquipTB01L.zRot = -0.3491F;
                    this.EquipTB02L.xRot = angleZ * 0.03F - 0.6981F;
                    this.EquipTB02L.zRot = 0.3491F;
                    this.EquipTB03L.xRot = angleZ * 0.05F + 0.1745F;
                    this.EquipTB03L.zRot = 0.2618F;

                    this.EquipTB01R.xRot = -angleZ * 0.01F + 0.1745F;
                    this.EquipTB01R.zRot = 0.3491F;
                    this.EquipTB02R.xRot = -angleZ * 0.03F - 0.6981F;
                    this.EquipTB02R.zRot = -0.3491F;
                    this.EquipTB03R.xRot = -angleZ * 0.05F + 0.1745F;
                    this.EquipTB03R.zRot = -0.2618F;
                }
            } else {
                // 手臂晃動
                this.ArmLeft01.xRot = 0.4F;
                this.ArmLeft01.yRot = 0F;
                this.ArmLeft01.zRot = -0.32F;
                this.ArmRight01.xRot = 0.34F;
                this.ArmRight01.yRot = 0F;
                this.ArmRight01.zRot = 0.5236F;
                // 身體角度
                this.BodyMain.xRot = -0.349F;
                this.BodyMain.yRot = -1.57F;
                this.BodyMain.zRot = -0.0873F;
                // 脖子角度
                this.Head.xRot -= 0.25F;
                this.Head.yRot += 0.4F;
                this.Head.zRot += 0F;
                // 腿擺動
                addk1 = angleZ * 0.3F - 1.0472F;
                addk2 = -angleZ * 0.3F - 1.0472F;
                this.LegLeft01.yRot = 0F;
                this.LegRight01.yRot = 0F;
                this.LegLeft01.zRot = 0.05236F;
                this.LegRight01.zRot = -0.05236F;
                // 披風擺動
                this.Cloak01.xRot = angleZ * 0.1F + 0.4F;
                this.Cloak02.xRot = angleZ * 0.15F;
                this.Cloak03.xRot = angleZ * 0.15F;
                // 杖位置
                this.Staff.xRot = 0.2F;
                this.Staff.yRot = 0F;
                this.Staff.zRot = -2.0F;
                // this.Staff.offsetX = 1.1F;
                // this.Staff.offsetY = -1.95F;
                // this.Staff.offsetZ = -1.4F;
                // 觸手晃動 (equip only)
                if (fhead) {
                    this.EquipT01L.xRot = -angleZ * 0.05F + 0.2618F;
                    this.EquipT01L.zRot = -0.2618F;
                    this.EquipT02L.xRot = -angleZ * 0.15F + 0.2618F;
                    this.EquipT02L.zRot = -0.1618F;
                    this.EquipT03L.xRot = -angleZ * 0.45F + 0F;
                    this.EquipT03L.zRot = -0.2618F;

                    this.EquipT01R.xRot = angleZ * 0.05F + 0.2618F;
                    this.EquipT01R.zRot = 0.2618F;
                    this.EquipT02R.xRot = angleZ * 0.15F + 0.2618F;
                    this.EquipT02R.zRot = 0.1618F;
                    this.EquipT03R.xRot = angleZ * 0.45F + 0F;
                    this.EquipT03R.zRot = 0.2618F;

                    this.EquipTB01L.xRot = angleZ * 0.05F + 0.349F;
                    this.EquipTB01L.zRot = -0.349F;
                    this.EquipTB02L.xRot = angleZ * 0.15F + 0.2236F;
                    this.EquipTB02L.zRot = 0.1745F;
                    this.EquipTB03L.xRot = angleZ * 0.45F + 0.1236F;
                    this.EquipTB03L.zRot = 0.1745F;

                    this.EquipTB01R.xRot = -angleZ * 0.05F + 0.349F;
                    this.EquipTB01R.zRot = 0.349F;
                    this.EquipTB02R.xRot = -angleZ * 0.15F + 0.2236F;
                    this.EquipTB02R.zRot = -0.1745F;
                    this.EquipTB03R.xRot = -angleZ * 0.45F + 0.1236F;
                    this.EquipTB03R.zRot = -0.1745F;
                }
            }
        }

        // 鬢毛調整
        float headX = this.Head.xRot * -0.5F;
        float headZ = this.Head.zRot * -0.5F;
        this.HairL01.zRot += headZ;
        this.HairL02.zRot += headZ;
        this.HairR01.zRot += headZ;
        this.HairR02.zRot += headZ;
        this.HairL01.xRot += headX;
        this.HairL02.xRot += headX;
        this.HairR01.xRot += headX;
        this.HairR02.xRot += headX;

        // leg motion
        this.LegLeft01.xRot = addk1;
        this.LegRight01.xRot = addk2;

        // 攻擊時順便將左手指向對方
        if (ent.getAttackTick() > 0) {
            this.ArmLeft01.xRot = f4 / 57.29578F - 1.5F;
            this.ArmRight01.zRot = 0.7F;
            this.ArmRight01.xRot = 0.4F;
            // 杖位置
            this.Staff.xRot = 1.5F;
            this.Staff.yRot = 0F;
            this.Staff.zRot = -1.2F;
            // this.Staff.offsetX = -0.2F;
            // this.Staff.offsetY = -1.2F;
            // this.Staff.offsetZ = -1.0F;
        }

        // swing arm
        float f6 = ent.getSwingTime(f2 - (int) f2);
        if (f6 != 0F) {
            float f7 = Mth.sin(f6 * f6 * (float) Math.PI);
            float f8 = Mth.sin(Mth.sqrt(f6) * (float) Math.PI);
            this.ArmRight01.xRot = -0.2F;
            this.ArmRight01.yRot = 0F;
            this.ArmRight01.zRot = -0.1F;
            this.ArmRight01.xRot += -f8 * 80.0F * ((float) Math.PI / 180F);
            this.ArmRight01.yRot += -f7 * 20.0F * ((float) Math.PI / 180F) + 0.2F;
            this.ArmRight01.zRot += -f8 * 20.0F * ((float) Math.PI / 180F);
            this.ArmRight02.xRot = 0F;
            this.ArmRight02.yRot = 0F;
            this.ArmRight02.zRot = 0F;
        }
    }
}
