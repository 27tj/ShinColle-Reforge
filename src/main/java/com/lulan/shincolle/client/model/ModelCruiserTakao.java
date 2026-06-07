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

public class ModelCruiserTakao extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "ca_takao"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Neck;
    private final ModelPart Butt;
    private final ModelPart ArmRight01;
    private final ModelPart ArmLeft01;
    private final ModelPart BoobR;
    private final ModelPart BoobL;
    private final ModelPart Cloth01;
    private final ModelPart EquipBase;
    private final ModelPart EquipBag00;
    private final ModelPart Head;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart Hat01;
    private final ModelPart HairU01;
    private final ModelPart Ahoke;
    private final ModelPart Hair01;
    private final ModelPart Hat02;
    private final ModelPart Hat03;
    private final ModelPart LegLeft01;
    private final ModelPart Skirt01;
    private final ModelPart LegRight01;
    private final ModelPart LegLeft02;
    private final ModelPart ShoeL03;
    private final ModelPart ShoeL01;
    private final ModelPart ShoeL02;
    private final ModelPart ShoeL04;
    private final ModelPart Belt01;
    private final ModelPart LegRight02;
    private final ModelPart ShoeL03_1;
    private final ModelPart ShoeR01;
    private final ModelPart ShoeR02;
    private final ModelPart ShoeL04_1;
    private final ModelPart ArmRight02;
    private final ModelPart ArmRight02a;
    private final ModelPart ArmRight02b;
    private final ModelPart ArmLeft02;
    private final ModelPart ArmLeft02a;
    private final ModelPart ArmLeft02b;
    private final ModelPart Equip00;
    private final ModelPart EquipCannonBase;
    private final ModelPart EquipLIn01;
    private final ModelPart EquipRIn01;
    private final ModelPart EquipOut01;
    private final ModelPart EquipOut01_1;
    private final ModelPart EquipC01a;
    private final ModelPart EquipLIn02;
    private final ModelPart EquipLIn03;
    private final ModelPart EquipLIn07;
    private final ModelPart EquipLIn08;
    private final ModelPart EquipLIn09;
    private final ModelPart EquipLIn04;
    private final ModelPart EquipLIn06a;
    private final ModelPart EquipLIn05;
    private final ModelPart EquipLIn06b;
    private final ModelPart EquipRIn02;
    private final ModelPart EquipRIn03;
    private final ModelPart EquipRIn07;
    private final ModelPart EquipRIn08;
    private final ModelPart EquipRIn09;
    private final ModelPart EquipRIn04;
    private final ModelPart EquipRIn06a;
    private final ModelPart EquipRIn05;
    private final ModelPart EquipRIn06b;
    private final ModelPart EquipOut02;
    private final ModelPart EquipOut03;
    private final ModelPart EquipOut04;
    private final ModelPart EquipOut05;
    private final ModelPart EquipOut02_1;
    private final ModelPart EquipOut03_1;
    private final ModelPart EquipOut04_1;
    private final ModelPart EquipOut05_1;
    private final ModelPart EquipC01b;
    private final ModelPart EquipC01c;
    private final ModelPart EquipC01e;
    private final ModelPart EquipC01d;
    private final ModelPart EquipC01f;
    private final ModelPart EquipC01a_1;
    private final ModelPart EquipC01a_2;
    private final ModelPart EquipC01b_1;
    private final ModelPart EquipC01c_1;
    private final ModelPart EquipC01e_1;
    private final ModelPart EquipC01d_1;
    private final ModelPart EquipC01f_1;
    private final ModelPart EquipC01b_2;
    private final ModelPart EquipC01c_2;
    private final ModelPart EquipC01e_2;
    private final ModelPart EquipC01d_2;
    private final ModelPart EquipC01f_2;
    private final ModelPart EquipBag01;
    private final ModelPart EquipBag02;
    private final ModelPart EquipBag03;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowNeck;
    private final ModelPart GlowHead;

    public ModelCruiserTakao(ModelPart root) {
        super();
        this.BodyMain = root.getChild("BodyMain");
        this.EquipBase = this.BodyMain.getChild("EquipBase");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.Neck = this.BodyMain.getChild("Neck");
        this.EquipBag00 = this.BodyMain.getChild("EquipBag00");
        this.BoobL = this.BodyMain.getChild("BoobL");
        this.BoobR = this.BodyMain.getChild("BoobR");
        this.Butt = this.BodyMain.getChild("Butt");
        this.Cloth01 = this.BodyMain.getChild("Cloth01");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.Equip00 = this.EquipBase.getChild("Equip00");
        this.EquipCannonBase = this.EquipBase.getChild("EquipCannonBase");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.Head = this.Neck.getChild("Head");
        this.EquipBag01 = this.EquipBag00.getChild("EquipBag01");
        this.LegRight01 = this.Butt.getChild("LegRight01");
        this.LegLeft01 = this.Butt.getChild("LegLeft01");
        this.Skirt01 = this.Butt.getChild("Skirt01");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.EquipOut01_1 = this.Equip00.getChild("EquipOut01_1");
        this.EquipC01a = this.Equip00.getChild("EquipC01a");
        this.EquipOut01 = this.Equip00.getChild("EquipOut01");
        this.EquipLIn01 = this.Equip00.getChild("EquipLIn01");
        this.EquipRIn01 = this.Equip00.getChild("EquipRIn01");
        this.EquipC01a_1 = this.EquipCannonBase.getChild("EquipC01a_1");
        this.EquipC01a_2 = this.EquipCannonBase.getChild("EquipC01a_2");
        this.ArmRight02a = this.ArmRight02.getChild("ArmRight02a");
        this.HairMain = this.Head.getChild("HairMain");
        this.Hair = this.Head.getChild("Hair");
        this.Hat01 = this.Head.getChild("Hat01");
        this.EquipBag03 = this.EquipBag01.getChild("EquipBag03");
        this.EquipBag02 = this.EquipBag01.getChild("EquipBag02");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.ShoeL03_1 = this.LegRight01.getChild("ShoeL03_1");
        this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
        this.ShoeL03 = this.LegLeft01.getChild("ShoeL03");
        this.Belt01 = this.Skirt01.getChild("Belt01");
        this.ArmLeft02a = this.ArmLeft02.getChild("ArmLeft02a");
        this.EquipOut02_1 = this.EquipOut01_1.getChild("EquipOut02_1");
        this.EquipC01b = this.EquipC01a.getChild("EquipC01b");
        this.EquipOut02 = this.EquipOut01.getChild("EquipOut02");
        this.EquipLIn02 = this.EquipLIn01.getChild("EquipLIn02");
        this.EquipRIn02 = this.EquipRIn01.getChild("EquipRIn02");
        this.EquipC01b_1 = this.EquipC01a_1.getChild("EquipC01b_1");
        this.EquipC01b_2 = this.EquipC01a_2.getChild("EquipC01b_2");
        this.ArmRight02b = this.ArmRight02a.getChild("ArmRight02b");
        this.Hair01 = this.HairMain.getChild("Hair01");
        this.HairU01 = this.Hair.getChild("HairU01");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.Hat02 = this.Hat01.getChild("Hat02");
        this.ShoeR01 = this.LegRight02.getChild("ShoeR01");
        this.ShoeL04_1 = this.ShoeL03_1.getChild("ShoeL04_1");
        this.ShoeL01 = this.LegLeft02.getChild("ShoeL01");
        this.ShoeL04 = this.ShoeL03.getChild("ShoeL04");
        this.ArmLeft02b = this.ArmLeft02a.getChild("ArmLeft02b");
        this.EquipOut03_1 = this.EquipOut02_1.getChild("EquipOut03_1");
        this.EquipC01c = this.EquipC01b.getChild("EquipC01c");
        this.EquipC01e = this.EquipC01b.getChild("EquipC01e");
        this.EquipOut03 = this.EquipOut02.getChild("EquipOut03");
        this.EquipLIn09 = this.EquipLIn02.getChild("EquipLIn09");
        this.EquipLIn07 = this.EquipLIn02.getChild("EquipLIn07");
        this.EquipLIn08 = this.EquipLIn02.getChild("EquipLIn08");
        this.EquipLIn03 = this.EquipLIn02.getChild("EquipLIn03");
        this.EquipRIn09 = this.EquipRIn02.getChild("EquipRIn09");
        this.EquipRIn03 = this.EquipRIn02.getChild("EquipRIn03");
        this.EquipRIn08 = this.EquipRIn02.getChild("EquipRIn08");
        this.EquipRIn07 = this.EquipRIn02.getChild("EquipRIn07");
        this.EquipC01c_1 = this.EquipC01b_1.getChild("EquipC01c_1");
        this.EquipC01e_1 = this.EquipC01b_1.getChild("EquipC01e_1");
        this.EquipC01e_2 = this.EquipC01b_2.getChild("EquipC01e_2");
        this.EquipC01c_2 = this.EquipC01b_2.getChild("EquipC01c_2");
        this.Hat03 = this.Hat02.getChild("Hat03");
        this.ShoeR02 = this.ShoeR01.getChild("ShoeR02");
        this.ShoeL02 = this.ShoeL01.getChild("ShoeL02");
        this.EquipOut04_1 = this.EquipOut03_1.getChild("EquipOut04_1");
        this.EquipC01d = this.EquipC01c.getChild("EquipC01d");
        this.EquipC01f = this.EquipC01e.getChild("EquipC01f");
        this.EquipOut04 = this.EquipOut03.getChild("EquipOut04");
        this.EquipLIn04 = this.EquipLIn03.getChild("EquipLIn04");
        this.EquipLIn06a = this.EquipLIn03.getChild("EquipLIn06a");
        this.EquipRIn04 = this.EquipRIn03.getChild("EquipRIn04");
        this.EquipRIn06a = this.EquipRIn03.getChild("EquipRIn06a");
        this.EquipC01d_1 = this.EquipC01c_1.getChild("EquipC01d_1");
        this.EquipC01f_1 = this.EquipC01e_1.getChild("EquipC01f_1");
        this.EquipC01f_2 = this.EquipC01e_2.getChild("EquipC01f_2");
        this.EquipC01d_2 = this.EquipC01c_2.getChild("EquipC01d_2");
        this.EquipOut05_1 = this.EquipOut04_1.getChild("EquipOut05_1");
        this.EquipOut05 = this.EquipOut04.getChild("EquipOut05");
        this.EquipLIn05 = this.EquipLIn04.getChild("EquipLIn05");
        this.EquipLIn06b = this.EquipLIn06a.getChild("EquipLIn06b");
        this.EquipRIn05 = this.EquipRIn04.getChild("EquipRIn05");
        this.EquipRIn06b = this.EquipRIn06a.getChild("EquipRIn06b");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowNeck = this.GlowBodyMain.getChild("GlowNeck");
        this.GlowHead = this.GlowNeck.getChild("GlowHead");
        this.loadFaceParts(this.GlowHead);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 104)
                        .addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition equipBase = bodyMain.addOrReplaceChild("EquipBase",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition equip00 = equipBase.addOrReplaceChild("Equip00",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-11.5F, -1.0F, -1.5F, 12.0F, 3.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 3.0F, 3.0F, 0.0F, 1.5707963267948966F, 0.0F));

        PartDefinition equipOut01_1 = equip00.addOrReplaceChild("EquipOut01_1",
                CubeListBuilder.create().texOffs(30, 0)
                        .addBox(0.0F, 0.0F, -0.5F, 12.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(-11.2F, -1.0F, 0.2F, -0.2617993877991494F, 1.48352986419518F,
                        0.0F));

        PartDefinition equipOut02_1 = equipOut01_1.addOrReplaceChild("EquipOut02_1",
                CubeListBuilder.create().mirror().texOffs(33, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 9.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(12.0F, 0.0F, -0.5F, 0.0F, -0.5235987755982988F, 0.0F));

        PartDefinition equipOut03_1 = equipOut02_1.addOrReplaceChild("EquipOut03_1",
                CubeListBuilder.create().texOffs(36, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, 0.0F, -0.6981317007977318F, 0.0F));

        PartDefinition equipOut04_1 = equipOut03_1.addOrReplaceChild("EquipOut04_1",
                CubeListBuilder.create().mirror().texOffs(36, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, -0.6981317007977318F, 0.0F));

        equipOut04_1.addOrReplaceChild("EquipOut05_1",
                CubeListBuilder.create().texOffs(0, 28)
                        .addBox(0.0F, 0.0F, -1.0F, 1.0F, 6.0F, 2.0F),
                PartPose.offsetAndRotation(3.5F, 2.5F, 0.5F, 0.0F, 0.0F, 0.3490658503988659F));

        PartDefinition equipC01a = equip00.addOrReplaceChild("EquipC01a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F),
                PartPose.offset(-13.0F, 0.5F, 0.0F));

        PartDefinition equipC01b = equipC01a.addOrReplaceChild("EquipC01b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, -9.0F, -4.5F, 4.0F, 13.0F, 9.0F),
                PartPose.offsetAndRotation(-5.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.08726646259971647F));

        PartDefinition equipC01c = equipC01b.addOrReplaceChild("EquipC01c",
                CubeListBuilder.create().texOffs(30, 9)
                        .addBox(-1.5F, -5.0F, -1.5F, 3.0F, 5.0F, 3.0F),
                PartPose.offset(2.0F, -8.0F, -2.2F));

        equipC01c.addOrReplaceChild("EquipC01d",
                CubeListBuilder.create().texOffs(14, 22)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F),
                PartPose.offset(0.0F, -14.9F, 0.0F));

        PartDefinition equipC01e = equipC01b.addOrReplaceChild("EquipC01e",
                CubeListBuilder.create().texOffs(30, 9)
                        .addBox(-1.5F, -5.0F, -1.5F, 3.0F, 5.0F, 3.0F),
                PartPose.offset(2.0F, -8.0F, 2.2F));

        equipC01e.addOrReplaceChild("EquipC01f",
                CubeListBuilder.create().texOffs(14, 22)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F),
                PartPose.offset(0.0F, -14.9F, 0.0F));

        PartDefinition equipOut01 = equip00.addOrReplaceChild("EquipOut01",
                CubeListBuilder.create().texOffs(30, 0)
                        .addBox(0.0F, 0.0F, -0.5F, 12.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(-11.2F, -1.0F, -0.2F, 0.2617993877991494F,
                        -1.48352986419518F, 0.0F));

        PartDefinition equipOut02 = equipOut01.addOrReplaceChild("EquipOut02",
                CubeListBuilder.create().mirror().texOffs(33, 0)
                        .addBox(0.0F, 0.0F, -1.0F, 9.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(12.0F, 0.0F, 0.5F, 0.0F, 0.5235987755982988F, 0.0F));

        PartDefinition equipOut03 = equipOut02.addOrReplaceChild("EquipOut03",
                CubeListBuilder.create().texOffs(36, 0)
                        .addBox(0.0F, 0.0F, -1.0F, 6.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, 0.0F, 0.6981317007977318F, 0.0F));

        PartDefinition equipOut04 = equipOut03.addOrReplaceChild("EquipOut04",
                CubeListBuilder.create().mirror().texOffs(36, 0)
                        .addBox(0.0F, 0.0F, -1.0F, 6.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 0.6981317007977318F, 0.0F));

        equipOut04.addOrReplaceChild("EquipOut05",
                CubeListBuilder.create().texOffs(0, 28)
                        .addBox(0.0F, 0.0F, -1.0F, 1.0F, 6.0F, 2.0F),
                PartPose.offsetAndRotation(3.5F, 2.5F, -0.5F, 0.0F, 0.0F, 0.3490658503988659F));

        PartDefinition equipLIn01 = equip00.addOrReplaceChild("EquipLIn01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 7.0F, 2.0F, 1.0F),
                PartPose.offsetAndRotation(-2.0F, -1.0F, 1.0F, 0.08726646259971647F,
                        -1.2217304763960306F, 0.0F));

        PartDefinition equipLIn02 = equipLIn01.addOrReplaceChild("EquipLIn02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, -1.0F, 8.0F, 2.0F, 1.0F),
                PartPose.offsetAndRotation(7.0F, 0.0F, 1.0F, 0.0F, 1.1344640137963142F, 0.0F));

        equipLIn02.addOrReplaceChild("EquipLIn09",
                CubeListBuilder.create().texOffs(6, 22)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F),
                PartPose.offset(2.9F, -3.2F, -0.5F));

        equipLIn02.addOrReplaceChild("EquipLIn07",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 1.0F, 3.0F),
                PartPose.offsetAndRotation(8.5F, -0.7F, -0.5F, 0.0F, 0.5235987755982988F, 0.0F));

        equipLIn02.addOrReplaceChild("EquipLIn08",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F),
                PartPose.offset(5.2F, -1.9F, -1.3F));

        PartDefinition equipLIn03 = equipLIn02.addOrReplaceChild("EquipLIn03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, -1.0F, 4.0F, 2.0F, 1.0F),
                PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, 0.8726646259971648F, 0.0F));

        PartDefinition equipLIn04 = equipLIn03.addOrReplaceChild("EquipLIn04",
                CubeListBuilder.create().texOffs(0, 22)
                        .addBox(0.0F, 0.0F, 0.0F, 2.0F, 5.0F, 1.0F),
                PartPose.offsetAndRotation(1.5F, 1.9F, -1.3F, 0.0F, 0.2617993877991494F, 0.0F));

        equipLIn04.addOrReplaceChild("EquipLIn05",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.0F, 0.0F, 0.0F, 7.0F, 3.0F, 1.0F),
                PartPose.offsetAndRotation(0.5F, 4.7F, 0.4F, 0.0F, 0.2617993877991494F,
                        0.08726646259971647F));

        PartDefinition equipLIn06a = equipLIn03.addOrReplaceChild("EquipLIn06a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(4.3F, -0.5F, -1.5F, 0.0F, 0.6981317007977318F, 0.0F));

        equipLIn06a.addOrReplaceChild("EquipLIn06b",
                CubeListBuilder.create().texOffs(6, 22)
                        .addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F),
                PartPose.offset(-0.3F, 0.0F, 0.0F));

        PartDefinition equipRIn01 = equip00.addOrReplaceChild("EquipRIn01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, -1.0F, 7.0F, 2.0F, 1.0F),
                PartPose.offsetAndRotation(-2.0F, -1.0F, -1.0F, -0.08726646259971647F,
                        1.2217304763960306F, 0.0F));

        PartDefinition equipRIn02 = equipRIn01.addOrReplaceChild("EquipRIn02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 8.0F, 2.0F, 1.0F),
                PartPose.offsetAndRotation(7.0F, 0.0F, -1.0F, 0.0F, -1.1344640137963142F, 0.0F));

        equipRIn02.addOrReplaceChild("EquipRIn09",
                CubeListBuilder.create().texOffs(6, 22)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F),
                PartPose.offset(2.9F, -3.2F, 0.5F));

        PartDefinition equipRIn03 = equipRIn02.addOrReplaceChild("EquipRIn03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 1.0F),
                PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, -0.8726646259971648F, 0.0F));

        PartDefinition equipRIn04 = equipRIn03.addOrReplaceChild("EquipRIn04",
                CubeListBuilder.create().texOffs(0, 22)
                        .addBox(0.0F, 0.0F, -1.0F, 2.0F, 5.0F, 1.0F),
                PartPose.offsetAndRotation(1.5F, 1.9F, 1.3F, 0.0F, -0.2617993877991494F, 0.0F));

        equipRIn04.addOrReplaceChild("EquipRIn05",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.0F, 0.0F, -1.0F, 7.0F, 3.0F, 1.0F),
                PartPose.offsetAndRotation(0.5F, 4.7F, -0.4F, 0.0F, -0.2617993877991494F,
                        0.08726646259971647F));

        PartDefinition equipRIn06a = equipRIn03.addOrReplaceChild("EquipRIn06a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(4.3F, -0.5F, 1.5F, 0.0F, -0.6981317007977318F, 0.0F));

        equipRIn06a.addOrReplaceChild("EquipRIn06b",
                CubeListBuilder.create().texOffs(6, 22)
                        .addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F),
                PartPose.offset(-0.3F, 0.0F, 0.0F));

        equipRIn02.addOrReplaceChild("EquipRIn08",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F),
                PartPose.offset(5.2F, -1.9F, 1.3F));

        equipRIn02.addOrReplaceChild("EquipRIn07",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 1.0F, 3.0F),
                PartPose.offsetAndRotation(8.5F, -0.7F, 0.5F, 0.0F, -0.5235987755982988F, 0.0F));

        PartDefinition equipCannonBase = equipBase.addOrReplaceChild("EquipCannonBase",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 5.0F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition equipC01a_1 = equipCannonBase.addOrReplaceChild("EquipC01a_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F),
                PartPose.offset(20.0F, 5.0F, 0.0F));

        PartDefinition equipC01b_1 = equipC01a_1.addOrReplaceChild("EquipC01b_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, -9.0F, -4.5F, 4.0F, 13.0F, 9.0F),
                PartPose.offsetAndRotation(1.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.08726646259971647F));

        PartDefinition equipC01c_1 = equipC01b_1.addOrReplaceChild("EquipC01c_1",
                CubeListBuilder.create().texOffs(30, 9)
                        .addBox(-1.5F, -5.0F, -1.5F, 3.0F, 5.0F, 3.0F),
                PartPose.offset(2.0F, -8.0F, -2.2F));

        equipC01c_1.addOrReplaceChild("EquipC01d_1",
                CubeListBuilder.create().texOffs(14, 22)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F),
                PartPose.offset(0.0F, -14.9F, 0.0F));

        PartDefinition equipC01e_1 = equipC01b_1.addOrReplaceChild("EquipC01e_1",
                CubeListBuilder.create().texOffs(30, 9)
                        .addBox(-1.5F, -5.0F, -1.5F, 3.0F, 5.0F, 3.0F),
                PartPose.offset(2.0F, -8.0F, 2.2F));

        equipC01e_1.addOrReplaceChild("EquipC01f_1",
                CubeListBuilder.create().texOffs(14, 22)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F),
                PartPose.offset(0.0F, -14.9F, 0.0F));

        PartDefinition equipC01a_2 = equipCannonBase.addOrReplaceChild("EquipC01a_2",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F),
                PartPose.offset(-20.0F, 5.0F, 0.0F));

        PartDefinition equipC01b_2 = equipC01a_2.addOrReplaceChild("EquipC01b_2",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-4.0F, -9.0F, -4.5F, 4.0F, 13.0F, 9.0F),
                PartPose.offsetAndRotation(-1.9F, 0.0F, 0.0F, 0.0F, 0.0F, -0.08726646259971647F));

        PartDefinition equipC01e_2 = equipC01b_2.addOrReplaceChild("EquipC01e_2",
                CubeListBuilder.create().texOffs(30, 9)
                        .addBox(-1.5F, -5.0F, -1.5F, 3.0F, 5.0F, 3.0F),
                PartPose.offset(-2.0F, -8.0F, 2.2F));

        equipC01e_2.addOrReplaceChild("EquipC01f_2",
                CubeListBuilder.create().texOffs(14, 22)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F),
                PartPose.offset(0.0F, -14.9F, 0.0F));

        PartDefinition equipC01c_2 = equipC01b_2.addOrReplaceChild("EquipC01c_2",
                CubeListBuilder.create().texOffs(30, 9)
                        .addBox(-1.5F, -5.0F, -1.5F, 3.0F, 5.0F, 3.0F),
                PartPose.offset(-2.0F, -8.0F, -2.2F));

        equipC01c_2.addOrReplaceChild("EquipC01d_2",
                CubeListBuilder.create().texOffs(14, 22)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F),
                PartPose.offset(0.0F, -14.9F, 0.0F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().mirror().texOffs(24, 84)
                        .addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, 0.20943951023931953F, 0.0F,
                        0.2617993877991494F));

        PartDefinition armRight02 = armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().mirror().texOffs(24, 63)
                        .addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
                PartPose.offset(-3.0F, 11.0F, 2.5F));

        PartDefinition armRight02a = armRight02.addOrReplaceChild("ArmRight02a",
                CubeListBuilder.create().mirror().texOffs(104, 32)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 6.0F),
                PartPose.offset(2.5F, 5.5F, -2.4F));

        armRight02a.addOrReplaceChild("ArmRight02b",
                CubeListBuilder.create().texOffs(0, 64)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 3.0F, 1.0F),
                PartPose.offset(-4.0F, 1.0F, 0.0F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(98, 22)
                        .addBox(-3.5F, -2.0F, -4.9F, 7.0F, 2.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offset(0.0F, -1.0F, -0.7F));

        PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(46, 104)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F),
                PartPose.offset(0.0F, -14.8F, -3.0F));

        hairMain.addOrReplaceChild("Hair01",
                CubeListBuilder.create().texOffs(51, 41)
                        .addBox(-8.0F, 0.0F, -8.0F, 16.0F, 7.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 7.0F, 10.9F, 0.13962634015954636F, 0.0F, 0.0F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(50, 77)
                        .addBox(-8.0F, -8.0F, -7.4F, 16.0F, 16.0F, 8.0F),
                PartPose.offset(0.0F, -7.5F, 0.1F));

        hair.addOrReplaceChild("HairU01",
                CubeListBuilder.create().texOffs(52, 56)
                        .addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F),
                PartPose.offset(0.0F, -6.0F, -7.0F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(106, 31)
                        .addBox(0.0F, -6.0F, -10.5F, 0.0F, 11.0F, 11.0F),
                PartPose.offsetAndRotation(-0.5F, -7.0F, -6.0F, 0.20943951023931953F,
                        0.6981317007977318F, 0.0F));

        PartDefinition hat01 = head.addOrReplaceChild("Hat01",
                CubeListBuilder.create().texOffs(22, 17)
                        .addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 8.0F),
                PartPose.offsetAndRotation(-2.6F, -15.4F, 3.2F, -0.17453292519943295F, 0.0F,
                        -0.08726646259971647F));

        PartDefinition hat02 = hat01.addOrReplaceChild("Hat02",
                CubeListBuilder.create().texOffs(47, 10)
                        .addBox(-4.5F, 0.0F, -4.5F, 9.0F, 3.0F, 9.0F),
                PartPose.offset(0.0F, -3.0F, 0.0F));

        hat02.addOrReplaceChild("Hat03",
                CubeListBuilder.create().texOffs(42, 7)
                        .addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(-4.6F, 1.6F, 2.0F, 0.2617993877991494F, 0.13962634015954636F,
                        0.5235987755982988F));

        PartDefinition equipBag00 = bodyMain.addOrReplaceChild("EquipBag00",
                CubeListBuilder.create().texOffs(32, 27)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 14.0F, 1.0F),
                PartPose.offsetAndRotation(-6.9F, -10.9F, -0.7F, -0.17453292519943295F,
                        1.7453292519943295F, 0.08726646259971647F));

        PartDefinition equipBag01 = equipBag00.addOrReplaceChild("EquipBag01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, 0.0F, -1.5F, 8.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(-2.5F, 13.5F, 0.5F, 0.0F, 0.0F, 0.08726646259971647F));

        equipBag01.addOrReplaceChild("EquipBag03",
                CubeListBuilder.create().texOffs(6, 22)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F),
                PartPose.offset(3.0F, -2.9F, 0.0F));

        equipBag01.addOrReplaceChild("EquipBag02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F),
                PartPose.offset(5.0F, -1.9F, -0.5F));

        bodyMain.addOrReplaceChild("BoobL",
                CubeListBuilder.create().mirror().texOffs(0, 35)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 6.0F, 6.0F),
                PartPose.offsetAndRotation(3.5F, -8.7F, -3.8F, -0.8726646259971648F,
                        -0.05235987755982988F, 0.08726646259971647F));

        bodyMain.addOrReplaceChild("BoobR",
                CubeListBuilder.create().texOffs(0, 35)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 6.0F, 6.0F),
                PartPose.offsetAndRotation(-3.5F, -8.7F, -3.8F, -0.8726646259971648F,
                        0.05235987755982988F, -0.08726646259971647F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(0, 47)
                        .addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));

        PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().mirror().texOffs(0, 84)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.296705972839036F, 0.0F,
                        -0.08726646259971647F));

        PartDefinition legRight02 = legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().mirror().texOffs(0, 63)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                PartPose.offset(-3.0F, 14.0F, -3.0F));

        PartDefinition shoeR01 = legRight02.addOrReplaceChild("ShoeR01",
                CubeListBuilder.create().mirror().texOffs(19, 63)
                        .addBox(-4.0F, 0.0F, 0.0F, 4.0F, 3.0F, 1.0F),
                PartPose.offsetAndRotation(2.0F, 12.5F, 3.6F, -0.6981317007977318F,
                        0.13962634015954636F, 0.6981317007977318F));

        shoeR01.addOrReplaceChild("ShoeR02",
                CubeListBuilder.create().mirror().texOffs(24, 80)
                        .addBox(-10.0F, -3.0F, 0.0F, 10.0F, 3.0F, 1.0F),
                PartPose.offsetAndRotation(-4.0F, 3.0F, 0.1F, 0.0F, 0.0F, 0.6981317007977318F));

        PartDefinition shoeL03_1 = legRight01.addOrReplaceChild("ShoeL03_1",
                CubeListBuilder.create().texOffs(20, 33)
                        .addBox(0.0F, 0.0F, -2.2F, 1.0F, 3.0F, 5.0F),
                PartPose.offset(-3.9F, 9.5F, 0.0F));

        shoeL03_1.addOrReplaceChild("ShoeL04_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 3.0F),
                PartPose.offset(0.0F, 3.0F, -0.7F));

        PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().texOffs(0, 84)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.15707963267948966F, 0.0F,
                        0.08726646259971647F));

        PartDefinition legLeft02 = legLeft01.addOrReplaceChild("LegLeft02",
                CubeListBuilder.create().texOffs(0, 63)
                        .addBox(-6.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                PartPose.offset(3.0F, 14.0F, -3.0F));

        PartDefinition shoeL01 = legLeft02.addOrReplaceChild("ShoeL01",
                CubeListBuilder.create().texOffs(19, 63)
                        .addBox(0.0F, 0.0F, 0.0F, 4.0F, 3.0F, 1.0F),
                PartPose.offsetAndRotation(-2.0F, 12.5F, 3.6F, -0.6981317007977318F,
                        -0.13962634015954636F, -0.6981317007977318F));

        shoeL01.addOrReplaceChild("ShoeL02",
                CubeListBuilder.create().texOffs(24, 80)
                        .addBox(0.0F, -3.0F, 0.0F, 10.0F, 3.0F, 1.0F),
                PartPose.offsetAndRotation(4.0F, 3.0F, 0.1F, 0.0F, 0.0F, -0.6981317007977318F));

        PartDefinition shoeL03 = legLeft01.addOrReplaceChild("ShoeL03",
                CubeListBuilder.create().texOffs(20, 33)
                        .addBox(0.0F, 0.0F, -2.2F, 1.0F, 3.0F, 5.0F),
                PartPose.offset(2.9F, 9.5F, 0.0F));

        shoeL03.addOrReplaceChild("ShoeL04",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 3.0F),
                PartPose.offset(0.0F, 3.0F, -0.7F));

        PartDefinition skirt01 = butt.addOrReplaceChild("Skirt01",
                CubeListBuilder.create().texOffs(74, 0)
                        .addBox(-8.5F, 0.0F, -6.2F, 17.0F, 7.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 3.1F, 0.0F, -0.17453292519943295F, 0.0F, 0.0F));

        skirt01.addOrReplaceChild("Belt01",
                CubeListBuilder.create().texOffs(56, 0)
                        .addBox(-5.5F, 0.0F, 0.0F, 11.0F, 7.0F, 1.0F),
                PartPose.offsetAndRotation(-2.6F, 0.9F, -1.0F, -1.1344640137963142F,
                        1.5707963267948966F, 0.0F));

        bodyMain.addOrReplaceChild("Cloth01",
                CubeListBuilder.create().texOffs(0, 48)
                        .addBox(-1.5F, 0.0F, -0.5F, 3.0F, 6.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, -10.5F, -3.5F, -0.6981317007977318F, 0.0F, 0.0F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().texOffs(24, 84)
                        .addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.0F, 0.0F, -0.2617993877991494F));

        PartDefinition armLeft02 = armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().texOffs(24, 63)
                        .addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
                PartPose.offset(3.0F, 11.0F, 2.5F));

        PartDefinition armLeft02a = armLeft02.addOrReplaceChild("ArmLeft02a",
                CubeListBuilder.create().texOffs(104, 32)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 6.0F),
                PartPose.offset(-2.5F, 5.5F, -2.4F));

        armLeft02a.addOrReplaceChild("ArmLeft02b",
                CubeListBuilder.create().texOffs(0, 64)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 3.0F, 1.0F),
                PartPose.offset(4.0F, 1.0F, 0.0F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -15.0F, 0.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -10.3F, 0.5F));

        PartDefinition glowHead = glowNeck.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -1.0F, -0.7F));
        addDefaultFaceParts(glowHead);

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                          float headPitch) {
        IShipEmotion ent = (IShipEmotion) entity;
        // set scale per scaleLevel
        switch (ent.getScaleLevel()) {
            case 3:
                this.scale = 1.72F;
                this.offsetY = -0.58F;
                break;
            case 2:
                this.scale = 1.29F;
                this.offsetY = -0.27F;
                break;
            case 1:
                this.scale = 0.86F;
                this.offsetY = 0.35F;
                break;
            default:
                this.scale = 0.43F;
                this.offsetY = 2F;
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

        boolean flag = !EmotionHelper.checkModelState(0, state); // cannon
        this.EquipBase.visible = !flag;

        flag = !EmotionHelper.checkModelState(1, state); // bag
        this.EquipBag00.visible = !flag;

        flag = !EmotionHelper.checkModelState(2, state); // hat
        this.Hat01.visible = !flag;

        flag = !EmotionHelper.checkModelState(3, state); // shoes
        this.ShoeL01.visible = !flag;
        this.ShoeR01.visible = !flag;
        this.ShoeL03.visible = !flag;
        this.ShoeL03_1.visible = !flag;
    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowBodyMain.xRot = this.BodyMain.xRot;
        this.GlowBodyMain.yRot = this.BodyMain.yRot;
        this.GlowBodyMain.zRot = this.BodyMain.zRot;
        this.GlowHead.xRot = this.Head.xRot;
        this.GlowHead.yRot = this.Head.yRot;
        this.GlowHead.zRot = this.Head.zRot;
        this.EquipCannonBase.yRot = this.Head.yRot;
        this.EquipC01b_1.xRot = this.Head.xRot;
        this.EquipC01b_2.xRot = this.Head.xRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        // [PORT] 1.10.2 -> 1.20.1: preserve legacy dead-pose grounding offset.
        this.offsetY += 0.5F + 0.2F * ent.getScaleLevel();

        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += 0.5F + 0.2F * ent.getScaleLevel();
        this.setFaceHungry(ent);

        // 胸部
        this.BoobL.xRot = -0.8F;
        this.BoobR.xRot = -0.8F;
        // Body
        this.Head.xRot = 0.5F;
        this.Head.yRot = 0F;
        this.Head.zRot = 0F;
        this.Ahoke.yRot = 0.45F;
        this.BodyMain.xRot = 0.31F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        this.Butt.xRot = -0.85F;
        this.Skirt01.xRot = -0.33F;
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
        this.LegLeft01.xRot = -0.66F;
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = -0.14F;
        this.LegLeft02.xRot = 1.2217F;
        this.LegLeft02.yRot = 1.2217F;
        this.LegLeft02.zRot = -1.0472F;
        // this.LegLeft02.offsetX = 0F;
        // this.LegLeft02.offsetY = -0.06F;
        // this.LegLeft02.offsetZ = 0F;
        this.LegRight01.xRot = -0.66F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = 0.14F;
        this.LegRight02.xRot = 1.2217F;
        this.LegRight02.yRot = -1.2217F;
        this.LegRight02.zRot = 1.0472F;
        // this.LegRight02.offsetX = 0F;
        // this.LegRight02.offsetY = -0.06F;
        // this.LegRight02.offsetZ = 0F;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float angleX = Mth.cos(f2 * 0.08F + f * 0.25F);
        float angleX1 = Mth.cos(f2 * 0.1F + 0.3F + f * 0.5F);
        float angleX2 = Mth.cos(f2 * 0.1F + 0.6F + f * 0.5F);
        float angleAdd1 = Mth.cos(f * 0.7F) * f1;
        float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
        float addk1;
        float addk2;
        float headX = 0F;
        float headZ = 0F;
        float t2 = ent.getTickExisted() & 511;
        boolean spcStand = false;

        // 水上漂浮
        if (ent.getShipDepth(0) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        // leg move
        addk1 = angleAdd1 * 0.3F - 0.28F; // LegLeft01
        addk2 = angleAdd2 * 0.3F - 0.21F; // LegRight01

        // head
        this.Head.xRot = f4 * 0.014F;
        this.Head.yRot = f3 * 0.01F;
        this.Ahoke.yRot = angleX * 0.15F + 0.65F;
        // boob
        this.BoobL.xRot = angleX * 0.06F - 0.8F;
        this.BoobR.xRot = angleX * 0.06F - 0.8F;
        // body
        this.BodyMain.xRot = -0.1047F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        this.Butt.xRot = 0.35F;
        this.Skirt01.xRot = -0.17F;
        // cloth
        this.Hat03.xRot = angleX * 0.05F + 0.26F;
        this.Cloth01.xRot = 0F;
        // arm
        this.ArmLeft01.xRot = angleAdd2 * 0.25F + 0.3F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = angleX * 0.03F - 0.25F;
        this.ArmLeft02.xRot = 0F;
        this.ArmLeft02.zRot = 0F;
        // this.ArmLeft02.offsetX = 0F;
        // this.ArmLeft02.offsetZ = 0F;
        this.ArmRight01.xRot = angleAdd1 * 0.25F - 0.087F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = -angleX * 0.03F + 0.25F;
        this.ArmRight02.xRot = 0F;
        this.ArmRight02.zRot = 0F;
        // this.ArmRight02.offsetX = 0F;
        // this.ArmRight02.offsetZ = 0F;
        // leg
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.0873F;
        this.LegLeft02.xRot = 0F;
        this.LegLeft02.yRot = 0F;
        this.LegLeft02.zRot = 0F;
        // this.LegLeft02.offsetX = 0F;
        // this.LegLeft02.offsetY = 0F;
        // this.LegLeft02.offsetZ = 0F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.0873F;
        this.LegRight02.xRot = 0F;
        this.LegRight02.yRot = 0F;
        this.LegRight02.zRot = 0F;
        // this.LegRight02.offsetX = 0F;
        // this.LegRight02.offsetY = 0F;
        // this.LegRight02.offsetZ = 0F;
        // equip
        this.EquipCannonBase.yRot = this.Head.yRot * 0.35F;
        this.EquipC01b.xRot = this.Head.yRot;
        this.EquipC01b_1.xRot = this.Head.xRot + 1.2F;
        this.EquipC01b_2.xRot = this.Head.xRot + 1.2F;
        this.EquipC01c_1.zRot = -this.Head.yRot * 0.5F;
        this.EquipC01e_1.zRot = -this.Head.yRot * 0.5F;
        this.EquipC01c_2.zRot = -this.Head.yRot * 0.5F;
        this.EquipC01e_2.zRot = -this.Head.yRot * 0.5F;

        // special stand pos
        if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
            spcStand = true;

            this.Head.yRot *= 0.25F;
            this.ArmLeft01.xRot = -0.3490658503988659F;
            this.ArmLeft01.yRot = 0.0F;
            this.ArmLeft01.zRot = 0.4553564018453205F;
            this.ArmLeft02.xRot = 0.0F;
            this.ArmLeft02.yRot = 0.0F;
            this.ArmLeft02.zRot = 1.0471975511965976F;
            this.ArmRight01.xRot = -0.5462880558742251F;
            this.ArmRight01.yRot = -0.2617993877991494F;
            this.ArmRight01.zRot = -0.13962634015954636F;
            this.ArmRight02.xRot = -2.530727415391778F;
            this.ArmRight02.zRot = 0.0F;
            // this.ArmRight02.offsetZ = -0.32F;

            if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED) {
                this.setFace(8);
            }
        }

        if (ent.getIsSprinting() || f1 > 0.9F) {
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                // arm
                this.ArmLeft01.xRot = -0.35F;
                this.ArmLeft01.yRot = -1.7F - angleAdd2 * 0.5F;
                this.ArmLeft01.zRot = 0F;
                this.ArmLeft02.xRot = -2.4F;
                this.ArmLeft02.yRot = 0F;
                this.ArmLeft02.zRot = 0F;
                // this.ArmLeft02.offsetX = 0F;
                // this.ArmLeft02.offsetY = 0F;
                // this.ArmLeft02.offsetZ = -0.315F;
                this.ArmRight01.xRot = -0.35F;
                this.ArmRight01.yRot = 1.7F + angleAdd1 * 0.5F;
                this.ArmRight01.zRot = 0F;
                this.ArmRight02.xRot = -2.4F;
                this.ArmRight02.zRot = 0F;
                this.ArmRight02.zRot = 0F;
                // this.ArmRight02.offsetX = 0F;
                // this.ArmRight02.offsetY = 0F;
                // this.ArmRight02.offsetZ = -0.315F;
            }
        }

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        if (ent.getIsSneaking()) {
            // 潛行, 蹲下動作

            // body
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.03F + this.scale * 0.06F;
            this.Head.xRot -= 1.0472F;
            this.BodyMain.xRot = 1.0472F;
            this.Butt.xRot = -0.4F;
            // skirt
            this.Skirt01.xRot = -0.24F;
            // arm
            this.ArmLeft01.xRot = -0.6F;
            this.ArmLeft01.yRot = 0F;
            this.ArmLeft01.zRot = 0.2618F;
            this.ArmLeft02.xRot = 0F;
            this.ArmLeft02.yRot = 0F;
            this.ArmLeft02.zRot = 0F;
            // this.ArmLeft02.offsetX = 0F;
            // this.ArmLeft02.offsetY = 0F;
            // this.ArmLeft02.offsetZ = 0F;
            this.ArmRight01.xRot = -0.6F;
            this.ArmRight01.yRot = 0F;
            this.ArmRight01.zRot = -0.2618F;
            this.ArmRight02.xRot = 0F;
            this.ArmRight02.zRot = 0F;
            this.ArmRight02.zRot = 0F;
            // this.ArmRight02.offsetX = 0F;
            // this.ArmRight02.offsetY = 0F;
            // this.ArmRight02.offsetZ = 0F;
            // leg
            addk1 -= 0.4F;
            addk2 -= 0.4F;
        } // end if sneaking

        // 坐下動作
        if (ent.getIsSitting() || ent.getIsRiding()) {
            // if caressing
            if (ent.getStateEmotion(ID.S.Emotion3) == ID.Emotion3.CARESS) {
                // body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.34F;
                this.Head.xRot -= 0.91F;
                this.BodyMain.xRot = 0.7F;
                this.BodyMain.yRot = 0F;
                this.BodyMain.zRot = 0F;
                // skirt
                this.Skirt01.xRot = -0.24F;
                // arm
                this.ArmLeft01.xRot = -0.45F;
                this.ArmLeft01.yRot = 0.0F;
                this.ArmLeft01.zRot = 0.21F;
                this.ArmRight01.xRot = -0.45F;
                this.ArmRight01.yRot = 0.0F;
                this.ArmRight01.zRot = -0.21F;
                // leg
                addk1 = -1.59F;
                addk2 = -1.59F;
                this.LegLeft01.yRot = 0.0F;
                this.LegLeft01.zRot = 0.09F;
                this.LegLeft02.xRot = 2.1F;
                this.LegLeft02.yRot = 0.0F;
                this.LegLeft02.zRot = 0.0F;
                // this.LegLeft02.offsetZ = 0.37F;
                this.LegRight01.yRot = 0.0F;
                this.LegRight01.zRot = -0.09F;
                this.LegRight02.xRot = 2.1F;
                this.LegRight02.yRot = 0F;
                this.LegRight02.zRot = 0F;
                // this.LegRight02.offsetZ = 0.37F;
            } else {
                if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                    this.setFlush(true);
                    // body
                    // [PORT] Restored from 1.10.2 GlStateManager.translate
                    this.offsetY += 0.58F;
                    this.Head.xRot = 0.55F;
                    this.Head.yRot = -0.2F;
                    this.BodyMain.xRot = -0.7F;
                    this.BodyMain.yRot = -0.2618F;
                    this.BodyMain.zRot = -0.5236F;
                    this.Butt.xRot = -0.2618F;
                    this.Cloth01.xRot = 0.3F;
                    // skirt
                    this.Skirt01.xRot = -0.2443F;
                    // arm
                    this.ArmLeft01.xRot = -0.2618F;
                    this.ArmLeft01.yRot = 0.7F;
                    this.ArmLeft01.zRot = -0.5236F;
                    this.ArmLeft02.xRot = -2.1F;
                    this.ArmLeft02.yRot = 0F;
                    this.ArmLeft02.zRot = 0F;
                    // this.ArmLeft02.offsetZ = -0.31F;
                    this.ArmRight01.xRot = 0.7F;
                    this.ArmRight01.yRot = 0F;
                    this.ArmRight01.zRot = 0.5236F;
                    this.ArmRight02.xRot = -1.45F;
                    this.ArmRight02.yRot = 0F;
                    this.ArmRight02.zRot = 0F;
                    // leg
                    addk1 = -0.79F;
                    addk2 = -0.7F;
                    this.LegLeft01.yRot = 0F;
                    this.LegLeft01.zRot = -0.14F;
                    this.LegLeft02.xRot = 1.4F;
                    this.LegRight01.yRot = -0.4363F;
                    this.LegRight01.zRot = 0F;
                    this.LegRight02.xRot = 0.7F;
                } else {

                    // Body
                    // [PORT] Restored from 1.10.2 GlStateManager.translate
                    this.offsetY += 0.35F;
                    this.Head.xRot -= 0.1F;
                    this.BodyMain.xRot = 0F;
                    this.Butt.xRot = -0.2F;
                    // this.Butt.offsetY = 0F;
                    // skirt
                    this.Skirt01.xRot = -0.15F;
                    // arm
                    if (!spcStand) {
                        this.ArmLeft01.xRot = -0.4F;
                        this.ArmLeft01.zRot = 0.2618F;
                        this.ArmRight01.xRot = -0.4F;
                        this.ArmRight01.zRot = -0.2618F;
                    }
                    // leg
                    addk1 = -0.65F;
                    addk2 = -0.65F;
                    this.LegLeft01.yRot = 0.1F;
                    this.LegLeft01.zRot = 0F;
                    // this.LegLeft02.offsetZ = 0.375F;
                    this.LegLeft02.xRot = 2.45F;
                    this.LegLeft02.zRot = 0.0175F;
                    this.LegRight01.yRot = -0.1F;
                    this.LegRight01.zRot = 0F;
                    // this.LegRight02.offsetZ = 0.375F;
                    this.LegRight02.xRot = 2.45F;
                    this.LegRight02.zRot = -0.0175F;
                }
            }
        } // end if sitting

        // 攻擊動作: 設為30~50會有揮刀動作, 設為100則沒有揮刀動作
        if (ent.getAttackTick() > 30) {
            // arm
            this.ArmLeft01.xRot = -1.5F + this.Head.xRot * 0.75F;
            this.ArmLeft01.yRot = 0.17F;
            this.ArmLeft01.zRot = 0.1F;
            this.ArmLeft02.xRot = 0F;
            this.ArmLeft02.zRot = 0F;
            // this.ArmLeft02.offsetX = 0F;
            // this.ArmLeft02.offsetZ = 0F;
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

        // leg motion
        this.LegLeft01.xRot = addk1;
        this.LegRight01.xRot = addk2;
    }
}
