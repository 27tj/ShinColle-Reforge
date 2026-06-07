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

public class ModelMountHbH extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "mount_hbh"), "main");

    private final ModelPart BodyMain;
    private final ModelPart EquipBaseR;
    private final ModelPart Back01;
    private final ModelPart Back02;
    private final ModelPart EquipBaseL;
    private final ModelPart EquipR01;
    private final ModelPart Back01b;
    private final ModelPart Back02b;
    private final ModelPart Back02c;
    private final ModelPart Back02d;
    private final ModelPart Back02e;
    private final ModelPart Neck;
    private final ModelPart Head;
    private final ModelPart Jaw;
    private final ModelPart HeadTooth;
    private final ModelPart Road01;
    private final ModelPart Road02;
    private final ModelPart Road03;
    private final ModelPart Road04;
    private final ModelPart Road05;
    private final ModelPart JawTooth;
    private final ModelPart EquipL01;
    private final ModelPart EquipCannonPlate;
    private final ModelPart CanonBase;
    private final ModelPart EquipCannon01;
    private final ModelPart Neck_1;
    private final ModelPart Head_1;
    private final ModelPart Jaw_1;
    private final ModelPart Road01u;
    private final ModelPart Road01v;
    private final ModelPart HeadTooth_1;
    private final ModelPart JawTooth_1;
    private final ModelPart Road02u;
    private final ModelPart Road03u;
    private final ModelPart Road02v;
    private final ModelPart Road03v;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowEquipBaseL;
    private final ModelPart GlowEquipL01;
    private final ModelPart GlowEquipCannonPlate;
    private final ModelPart GlowBack02;
    private final ModelPart GlowBack02b;
    private final ModelPart GlowBack02c;
    private final ModelPart GlowBack02d;
    private final ModelPart GlowBack02e;
    private final ModelPart GlowNeck;
    private final ModelPart GlowHead;
    private final ModelPart GlowJaw;
    private final ModelPart GlowCanonBase;
    private final ModelPart GlowNeck_1;
    private final ModelPart GlowHead_1;
    private final ModelPart GlowJaw_1;

    public ModelMountHbH(ModelPart root) {
        super();
        this.BodyMain = root.getChild("BodyMain");
        this.Back01 = this.BodyMain.getChild("Back01");
        this.EquipBaseL = this.BodyMain.getChild("EquipBaseL");
        this.Back02 = this.BodyMain.getChild("Back02");
        this.EquipBaseR = this.BodyMain.getChild("EquipBaseR");
        this.Back01b = this.Back01.getChild("Back01b");
        this.EquipL01 = this.EquipBaseL.getChild("EquipL01");
        this.Back02b = this.Back02.getChild("Back02b");
        this.EquipR01 = this.EquipBaseR.getChild("EquipR01");
        this.CanonBase = this.EquipL01.getChild("CanonBase");
        this.EquipCannonPlate = this.EquipL01.getChild("EquipCannonPlate");
        this.Back02c = this.Back02b.getChild("Back02c");
        this.Neck_1 = this.CanonBase.getChild("Neck_1");
        this.Back02d = this.Back02c.getChild("Back02d");
        this.Jaw_1 = this.Neck_1.getChild("Jaw_1");
        this.Head_1 = this.Neck_1.getChild("Head_1");
        this.Back02e = this.Back02d.getChild("Back02e");
        this.Neck = this.Back02e.getChild("Neck");
        this.Head = this.Neck.getChild("Head");
        this.Jaw = this.Neck.getChild("Jaw");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowEquipBaseL = this.GlowBodyMain.getChild("GlowEquipBaseL");
        this.GlowBack02 = this.GlowBodyMain.getChild("GlowBack02");
        this.GlowEquipL01 = this.GlowEquipBaseL.getChild("GlowEquipL01");
        this.GlowBack02b = this.GlowBack02.getChild("GlowBack02b");
        this.GlowEquipCannonPlate = this.GlowEquipL01.getChild("GlowEquipCannonPlate");
        this.GlowCanonBase = this.GlowEquipL01.getChild("GlowCanonBase");
        this.GlowBack02c = this.GlowBack02b.getChild("GlowBack02c");
        this.GlowNeck_1 = this.GlowCanonBase.getChild("GlowNeck_1");
        this.GlowBack02d = this.GlowBack02c.getChild("GlowBack02d");
        this.GlowHead_1 = this.GlowNeck_1.getChild("GlowHead_1");
        this.GlowJaw_1 = this.GlowNeck_1.getChild("GlowJaw_1");
        this.GlowBack02e = this.GlowBack02d.getChild("GlowBack02e");
        this.GlowNeck = this.GlowBack02e.getChild("GlowNeck");
        this.GlowHead = this.GlowNeck.getChild("GlowHead");
        this.GlowJaw = this.GlowNeck.getChild("GlowJaw");

        this.EquipCannon01 = this.GlowEquipCannonPlate.getChild("EquipCannon01");
        this.HeadTooth = this.GlowHead.getChild("HeadTooth");
        this.JawTooth = this.GlowJaw.getChild("JawTooth");
        this.Road01 = this.GlowHead.getChild("Road01");
        this.Road02 = this.Road01.getChild("Road02");
        this.Road03 = this.Road02.getChild("Road03");
        this.Road04 = this.Road03.getChild("Road04");
        this.Road05 = this.Road04.getChild("Road05");
        this.HeadTooth_1 = this.GlowHead_1.getChild("HeadTooth_1");
        this.JawTooth_1 = this.GlowJaw_1.getChild("JawTooth_1");
        this.Road01u = this.GlowNeck_1.getChild("Road01u");
        this.Road02u = this.Road01u.getChild("Road02u");
        this.Road03u = this.Road02u.getChild("Road03u");
        this.Road01v = this.GlowNeck_1.getChild("Road01v");
        this.Road02v = this.Road01v.getChild("Road02v");
        this.Road03v = this.Road02v.getChild("Road03v");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-9.0F, -2.0F, 14.0F, 18.0F, 10.0F, 9.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition back01 = bodyMain.addOrReplaceChild("Back01",
                CubeListBuilder.create().texOffs(29, 22)
                        .addBox(0.0F, 0.0F, 0.0F, 13.0F, 10.0F, 13.0F),
                PartPose.offsetAndRotation(1.0F, -7.0F, 19.0F, 0.0F, 0.13962634015954636F, 0.0F));

        back01.addOrReplaceChild("Back01b",
                CubeListBuilder.create().texOffs(29, 22)
                        .addBox(0.0F, 0.0F, 0.0F, 13.0F, 10.0F, 13.0F),
                PartPose.offset(0.0F, -10.0F, 0.0F));

        PartDefinition equipBaseL = bodyMain.addOrReplaceChild("EquipBaseL",
                CubeListBuilder.create().texOffs(64, 30)
                        .addBox(-6.0F, -4.0F, -7.0F, 11.0F, 11.0F, 21.0F),
                PartPose.offsetAndRotation(14.5F, 2.0F, 5.0F, 0.0F, -0.05235987755982988F, 0.0F));

        PartDefinition equipL01 = equipBaseL.addOrReplaceChild("EquipL01",
                CubeListBuilder.create().texOffs(66, 31)
                        .addBox(-6.0F, 0.0F, -7.0F, 10.0F, 4.0F, 20.0F),
                PartPose.offset(0.5F, -8.0F, 1.0F));

        PartDefinition canonBase = equipL01.addOrReplaceChild("CanonBase",
                CubeListBuilder.create().texOffs(0, 21)
                        .addBox(0.0F, 0.0F, 0.0F, 7.0F, 9.0F, 7.0F),
                PartPose.offset(-3.5F, -9.0F, 3.0F));

        PartDefinition neck_1 = canonBase.addOrReplaceChild("Neck_1",
                CubeListBuilder.create().texOffs(0, 37)
                        .addBox(-4.0F, -6.0F, -0.5F, 8.0F, 8.0F, 9.0F),
                PartPose.offsetAndRotation(3.5F, -1.0F, 3.0F, -0.2617993877991494F,
                        -0.08726646259971647F, 0.0F));

        neck_1.addOrReplaceChild("Jaw_1",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-5.0F, -1.0F, -15.0F, 10.0F, 4.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, -5.0F, 3.0F, 0.8726646259971648F, 0.0F, 0.0F));

        neck_1.addOrReplaceChild("Head_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-5.0F, -4.0F, -17.0F, 10.0F, 4.0F, 17.0F),
                PartPose.offsetAndRotation(0.1F, -2.5F, 3.0F, -0.36425021489121656F, 0.0F, 0.0F));

        equipL01.addOrReplaceChild("EquipCannonPlate",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 4.0F, 3.0F, 1.0F),
                PartPose.offset(-3.0F, 1.8F, -7.5F));

        PartDefinition back02 = bodyMain.addOrReplaceChild("Back02",
                CubeListBuilder.create().texOffs(29, 22)
                        .addBox(-14.0F, 0.0F, 0.0F, 13.0F, 10.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, 19.0F, 0.0F, -0.13962634015954636F, 0.0F));

        PartDefinition back02b = back02.addOrReplaceChild("Back02b",
                CubeListBuilder.create().texOffs(29, 22)
                        .addBox(0.0F, 0.0F, 0.0F, 13.0F, 10.0F, 13.0F),
                PartPose.offset(-14.0F, -10.0F, 0.0F));

        PartDefinition back02c = back02b.addOrReplaceChild("Back02c",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-4.0F, -4.0F, -9.0F, 8.0F, 8.0F, 9.0F),
                PartPose.offsetAndRotation(3.5F, 2.0F, 8.0F, -0.44F, 1.22F, 0.0F));

        PartDefinition back02d = back02c.addOrReplaceChild("Back02d",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-4.0F, -4.0F, -9.0F, 8.0F, 8.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.5235987755982988F, -0.6981317007977318F,
                        -0.2617993877991494F));

        PartDefinition back02e = back02d.addOrReplaceChild("Back02e",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-4.0F, -4.0F, -9.0F, 8.0F, 8.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.3490658503988659F, -0.3490658503988659F,
                        0.0F));

        PartDefinition neck = back02e.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(0, 37)
                        .addBox(-4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -10.0F, -0.17453292519943295F,
                        0.08726646259971647F, -0.08726646259971647F));

        neck.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-5.0F, -4.0F, -17.0F, 10.0F, 4.0F, 17.0F),
                PartPose.offsetAndRotation(0.0F, -1.0F, -4.0F, 0.08726646259971647F, 0.0F, 0.0F));

        neck.addOrReplaceChild("Jaw",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-5.0F, -1.0F, -15.0F, 10.0F, 4.0F, 14.0F),
                PartPose.offsetAndRotation(0.0F, -0.8F, -3.0F, 0.6283185307179586F, 0.0F, 0.0F));

        PartDefinition equipBaseR = bodyMain.addOrReplaceChild("EquipBaseR",
                CubeListBuilder.create().texOffs(64, 30)
                        .addBox(-6.0F, -4.0F, -7.0F, 11.0F, 11.0F, 21.0F),
                PartPose.offsetAndRotation(-13.5F, 2.0F, 5.0F, 0.0F, 0.05235987755982988F, 0.0F));

        equipBaseR.addOrReplaceChild("EquipR01",
                CubeListBuilder.create().texOffs(66, 31)
                        .addBox(-5.0F, 0.0F, -7.0F, 10.0F, 4.0F, 20.0F),
                PartPose.offset(-0.5F, -8.0F, 1.0F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition glowEquipBaseL = glowBodyMain.addOrReplaceChild("GlowEquipBaseL",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(14.5F, 2.0F, 5.0F, 0.0F, -0.05235987755982988F, 0.0F));

        PartDefinition glowEquipL01 = glowEquipBaseL.addOrReplaceChild("GlowEquipL01",
                CubeListBuilder.create(),
                PartPose.offset(0.5F, -8.0F, 1.0F));

        PartDefinition glowEquipCannonPlate = glowEquipL01.addOrReplaceChild("GlowEquipCannonPlate",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 4.0F, 3.0F, 1.0F),
                PartPose.offset(-3.0F, 1.8F, -7.5F));

        glowEquipCannonPlate.addOrReplaceChild("EquipCannon01",
                CubeListBuilder.create().texOffs(47, 0)
                        .addBox(0.0F, 0.0F, -7.0F, 1.0F, 1.0F, 7.0F),
                PartPose.offsetAndRotation(1.5F, 1.0F, 0.5F, -0.31869712141416456F,
                        -0.08726646259971647F, 0.0F));

        PartDefinition glowCanonBase = glowEquipL01.addOrReplaceChild("GlowCanonBase",
                CubeListBuilder.create(),
                PartPose.offset(-3.5F, -9.0F, 3.0F));

        PartDefinition glowNeck_1 = glowCanonBase.addOrReplaceChild("GlowNeck_1",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(3.5F, -1.0F, 3.0F, -0.2617993877991494F,
                        -0.08726646259971647F, 0.0F));

        PartDefinition glowHead_1 = glowNeck_1.addOrReplaceChild("GlowHead_1",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.1F, -2.5F, 3.0F, -0.36425021489121656F, 0.0F, 0.0F));

        glowHead_1.addOrReplaceChild("HeadTooth_1",
                CubeListBuilder.create().texOffs(22, 46)
                        .addBox(-4.5F, 0.0F, -6.5F, 9.0F, 4.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -2.0F, -8.0F, 0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition glowJaw_1 = glowNeck_1.addOrReplaceChild("GlowJaw_1",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, -5.0F, 3.0F, 0.8726646259971648F, 0.0F, 0.0F));

        glowJaw_1.addOrReplaceChild("JawTooth_1",
                CubeListBuilder.create().texOffs(22, 46)
                        .addBox(-4.5F, 0.0F, -14.0F, 9.0F, 3.0F, 12.0F),
                PartPose.offsetAndRotation(0.1F, -0.6F, -0.3F, -0.20943951023931953F, 0.0F, 0.0F));

        PartDefinition road01u = glowNeck_1.addOrReplaceChild("Road01u",
                CubeListBuilder.create().texOffs(86, 16)
                        .addBox(-4.5F, 0.0F, -12.0F, 9.0F, 1.0F, 12.0F),
                PartPose.offset(0.0F, -4.7F, -3.0F));

        PartDefinition road02u = road01u.addOrReplaceChild("Road02u",
                CubeListBuilder.create().texOffs(86, 16)
                        .addBox(-4.5F, 0.0F, -12.0F, 9.0F, 1.0F, 12.0F),
                PartPose.offset(0.0F, 0.0F, -12.0F));

        road02u.addOrReplaceChild("Road03u",
                CubeListBuilder.create().texOffs(86, 16)
                        .addBox(-4.5F, 0.0F, -12.0F, 9.0F, 1.0F, 12.0F),
                PartPose.offset(0.0F, 0.0F, -12.0F));

        PartDefinition road01v = glowNeck_1.addOrReplaceChild("Road01v",
                CubeListBuilder.create().texOffs(86, 16)
                        .addBox(-4.5F, 0.0F, -12.0F, 9.0F, 1.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 3.2F, -2.4F, -0.0349F, 0.0F, -3.141592653589793F));

        PartDefinition road02v = road01v.addOrReplaceChild("Road02v",
                CubeListBuilder.create().texOffs(86, 16)
                        .addBox(-4.5F, 0.0F, -12.0F, 9.0F, 1.0F, 12.0F),
                PartPose.offset(0.0F, 0.0F, -12.0F));

        road02v.addOrReplaceChild("Road03v",
                CubeListBuilder.create().texOffs(86, 16)
                        .addBox(-4.5F, 0.0F, -12.0F, 9.0F, 1.0F, 12.0F),
                PartPose.offset(0.0F, 0.0F, -12.0F));

        PartDefinition glowBack02 = glowBodyMain.addOrReplaceChild("GlowBack02",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, -7.0F, 19.0F, 0.0F, -0.13962634015954636F, 0.0F));

        PartDefinition glowBack02b = glowBack02.addOrReplaceChild("GlowBack02b",
                CubeListBuilder.create(),
                PartPose.offset(-14.0F, -10.0F, 0.0F));

        PartDefinition glowBack02c = glowBack02b.addOrReplaceChild("GlowBack02c",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(3.5F, 2.0F, 8.0F, -0.44F, 1.22F, 0.0F));

        PartDefinition glowBack02d = glowBack02c.addOrReplaceChild("GlowBack02d",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.5235987755982988F,
                        -0.6981317007977318F, -0.2617993877991494F));

        PartDefinition glowBack02e = glowBack02d.addOrReplaceChild("GlowBack02e",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.3490658503988659F,
                        -0.3490658503988659F, 0.0F));

        PartDefinition glowNeck = glowBack02e.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, -10.0F, -0.17453292519943295F,
                        0.08726646259971647F, -0.08726646259971647F));

        PartDefinition glowHead = glowNeck.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, -1.0F, -4.0F, 0.08726646259971647F, 0.0F, 0.0F));

        glowHead.addOrReplaceChild("HeadTooth",
                CubeListBuilder.create().texOffs(22, 46)
                        .addBox(-4.5F, 0.0F, -6.5F, 9.0F, 4.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -2.0F, -8.0F, 0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition road01 = glowHead.addOrReplaceChild("Road01",
                CubeListBuilder.create().texOffs(55, 0)
                        .addBox(-5.5F, 0.0F, 0.0F, 11.0F, 1.0F, 14.0F),
                PartPose.offset(0.0F, -5.0F, -23.0F));

        PartDefinition road02 = road01.addOrReplaceChild("Road02",
                CubeListBuilder.create().texOffs(55, 0)
                        .addBox(-5.5F, 0.0F, 0.0F, 11.0F, 1.0F, 14.0F),
                PartPose.offset(0.0F, 0.0F, 14.0F));

        PartDefinition road03 = road02.addOrReplaceChild("Road03",
                CubeListBuilder.create().texOffs(55, 0)
                        .addBox(-5.5F, 0.0F, 0.0F, 11.0F, 1.0F, 14.0F),
                PartPose.offsetAndRotation(0.4F, 0.1F, 12.0F, 0.08726646259971647F,
                        -0.36425021489121656F, -0.017453292519943295F));

        PartDefinition road04 = road03.addOrReplaceChild("Road04",
                CubeListBuilder.create().texOffs(55, 0)
                        .addBox(-5.5F, 0.0F, 0.0F, 10.0F, 1.0F, 14.0F),
                PartPose.offsetAndRotation(-2.6F, 0.1F, 10.0F, 0.03839724354387525F,
                        0.8651597102135892F, 0.013962634015954637F));

        road04.addOrReplaceChild("Road05",
                CubeListBuilder.create().texOffs(55, 0)
                        .addBox(-5.5F, 0.0F, 0.0F, 11.0F, 1.0F, 14.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 14.0F, -0.6981317007977318F, 0.0F, 0.0F));

        PartDefinition glowJaw = glowNeck.addOrReplaceChild("GlowJaw",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, -0.8F, -3.0F, 0.6283185307179586F, 0.0F, 0.0F));

        glowJaw.addOrReplaceChild("JawTooth",
                CubeListBuilder.create().texOffs(22, 46)
                        .addBox(-4.5F, 0.0F, -14.0F, 9.0F, 3.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -1.6F, -0.3F, -0.17453292519943295F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
        IShipEmotion ent = (IShipEmotion) entity;
        float angleX = Mth.cos(ageInTicks * 0.08F);

        this.offsetY = 0F;
        if (ent.getShipDepth(0) > 0D) {
            // [PORT] 1.10.2 -> 1.20.1: restore mount water bobbing translation.
            // [RENDER?] Visual check required: water bobbing amplitude should match 1.10.2
            // mount behavior.
            // [REPRO?] Unverified visually: compare idle-on-water Y oscillation in client
            // runtime.
            this.offsetY += angleX * 0.025F + 0.025F;
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
    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowJaw.xRot = this.Jaw.xRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
    }
}
