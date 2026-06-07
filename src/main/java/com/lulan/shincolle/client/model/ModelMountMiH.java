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

public class ModelMountMiH extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "mount_mih"), "main");

    private final ModelPart BodyMain;
    private final ModelPart UpperMain;
    private final ModelPart LowerMain;
    private final ModelPart LegArmorBase;
    private final ModelPart Back;
    private final ModelPart Head;
    private final ModelPart Back_1;
    private final ModelPart EquipHeadBack1;
    private final ModelPart EquipHeadBack1b;
    private final ModelPart EquipHead01;
    private final ModelPart EquipHead01c;
    private final ModelPart EquipHeadBack2;
    private final ModelPart EquipHead03;
    private final ModelPart EquipHeadBack3;
    private final ModelPart EquipHeadBack3b;
    private final ModelPart EquipHeadBack2b;
    private final ModelPart EquipHead03_1;
    private final ModelPart EquipHead03_2;
    private final ModelPart EquipHead03_3;
    private final ModelPart EquipHeadBack3c;
    private final ModelPart EquipHeadBack3d;
    private final ModelPart EquipHeadBack3e;
    private final ModelPart EquipHeadBack3f;
    private final ModelPart EquipHeadBack3g;
    private final ModelPart EquipHeadBack3h;
    private final ModelPart EquipHead03a;
    private final ModelPart EquipHead01_1;
    private final ModelPart EquipHead02;
    private final ModelPart EquipHead00;
    private final ModelPart EquipHead01a;
    private final ModelPart EquipHead02a;
    private final ModelPart EquipHead00a;
    private final ModelPart EquipHead03a_1;
    private final ModelPart EquipHead03a_2;
    private final ModelPart EquipHead03a_3;
    private final ModelPart EquipHead01a_1;
    private final ModelPart EquipHead01b;
    private final ModelPart EquipHead01d;
    private final ModelPart Back_2;
    private final ModelPart TopCannonBase;
    private final ModelPart TopCannonBase_1;
    private final ModelPart TongueBase1;
    private final ModelPart Head_1;
    private final ModelPart Back_3;
    private final ModelPart EquipHeadBack1_1;
    private final ModelPart EquipHeadBack1b_1;
    private final ModelPart EquipHead01_2;
    private final ModelPart EquipHead01c_1;
    private final ModelPart EquipHeadBack2_1;
    private final ModelPart EquipHead03_4;
    private final ModelPart EquipHeadBack3_1;
    private final ModelPart EquipHeadBack3b_1;
    private final ModelPart EquipHeadBack2b_1;
    private final ModelPart EquipHead03_5;
    private final ModelPart EquipHead03_6;
    private final ModelPart EquipHead03_7;
    private final ModelPart EquipHeadBack3c_1;
    private final ModelPart EquipHeadBack3d_1;
    private final ModelPart EquipHeadBack3e_1;
    private final ModelPart EquipHeadBack3f_1;
    private final ModelPart EquipHeadBack3g_1;
    private final ModelPart EquipHeadBack3h_1;
    private final ModelPart EquipHead03a_4;
    private final ModelPart EquipHead01_3;
    private final ModelPart EquipHead02_1;
    private final ModelPart EquipHead00_1;
    private final ModelPart EquipHead01a_2;
    private final ModelPart EquipHead02a_1;
    private final ModelPart EquipHead00a_1;
    private final ModelPart EquipHead03a_5;
    private final ModelPart EquipHead03a_6;
    private final ModelPart EquipHead03a_7;
    private final ModelPart EquipHead01a_3;
    private final ModelPart EquipHead01b_1;
    private final ModelPart EquipHead01d_1;
    private final ModelPart TopCannon01b;
    private final ModelPart TopCannon01b_1;
    private final ModelPart TopCannon01b_2;
    private final ModelPart TopCannonUnder;
    private final ModelPart TopCannon02b;
    private final ModelPart TopCannon03b;
    private final ModelPart TopCannon04b;
    private final ModelPart TopCannon02b_1;
    private final ModelPart TopCannon03b_1;
    private final ModelPart TopCannon04b_1;
    private final ModelPart TopCannon02b_2;
    private final ModelPart TopCannon03b_2;
    private final ModelPart TopCannon04b_2;
    private final ModelPart TopCannon01b_3;
    private final ModelPart TopCannon01b_4;
    private final ModelPart TopCannon01b_5;
    private final ModelPart TopCannonUnder_1;
    private final ModelPart TopCannon02b_3;
    private final ModelPart TopCannon03b_3;
    private final ModelPart TopCannon04b_3;
    private final ModelPart TopCannon02b_4;
    private final ModelPart TopCannon03b_4;
    private final ModelPart TopCannon04b_4;
    private final ModelPart TopCannon02b_5;
    private final ModelPart TopCannon03b_5;
    private final ModelPart TopCannon04b_5;
    private final ModelPart Tongue01;
    private final ModelPart Tongue01a;
    private final ModelPart TongueBase2;
    private final ModelPart Tongue02;
    private final ModelPart Tongue02a;
    private final ModelPart TongueBase3;
    private final ModelPart Tongue03;
    private final ModelPart Tongue03a;
    private final ModelPart LegArmorA1;
    private final ModelPart LegArmorA2;
    private final ModelPart LegArmorA3;
    private final ModelPart LegArmorA4;
    private final ModelPart LegArmorB1;
    private final ModelPart LegArmorB2;
    private final ModelPart LegArmorB3;
    private final ModelPart LegArmorB4;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowLowerMain;
    private final ModelPart GlowTopCannonBase;
    private final ModelPart GlowTopCannonBase_1;

    public ModelMountMiH(ModelPart root) {
        super();
        this.BodyMain = root.getChild("BodyMain");
        this.UpperMain = this.BodyMain.getChild("UpperMain");
        this.LowerMain = this.BodyMain.getChild("LowerMain");
        this.LegArmorBase = this.BodyMain.getChild("LegArmorBase");
        this.Back = this.UpperMain.getChild("Back");
        this.Back_2 = this.LowerMain.getChild("Back_2");
        this.TopCannonBase = this.LowerMain.getChild("TopCannonBase");
        this.TopCannonBase_1 = this.LowerMain.getChild("TopCannonBase_1");
        this.LegArmorA4 = this.LegArmorBase.getChild("LegArmorA4");
        this.LegArmorA1 = this.LegArmorBase.getChild("LegArmorA1");
        this.LegArmorA2 = this.LegArmorBase.getChild("LegArmorA2");
        this.LegArmorA3 = this.LegArmorBase.getChild("LegArmorA3");
        this.Back_1 = this.Back.getChild("Back_1");
        this.Head = this.Back.getChild("Head");
        this.Head_1 = this.Back_2.getChild("Head_1");
        this.Back_3 = this.Back_2.getChild("Back_3");
        this.TopCannonUnder = this.TopCannonBase.getChild("TopCannonUnder");
        this.TopCannonUnder_1 = this.TopCannonBase_1.getChild("TopCannonUnder_1");
        this.LegArmorB4 = this.LegArmorA4.getChild("LegArmorB4");
        this.LegArmorB1 = this.LegArmorA1.getChild("LegArmorB1");
        this.LegArmorB2 = this.LegArmorA2.getChild("LegArmorB2");
        this.LegArmorB3 = this.LegArmorA3.getChild("LegArmorB3");
        this.EquipHead01b = this.Back_1.getChild("EquipHead01b");
        this.EquipHead01d = this.Back_1.getChild("EquipHead01d");
        this.EquipHead01 = this.Head.getChild("EquipHead01");
        this.EquipHeadBack1 = this.Head.getChild("EquipHeadBack1");
        this.EquipHeadBack1b = this.Head.getChild("EquipHeadBack1b");
        this.EquipHead01c = this.Head.getChild("EquipHead01c");
        this.EquipHead01c_1 = this.Head_1.getChild("EquipHead01c_1");
        this.EquipHeadBack1_1 = this.Head_1.getChild("EquipHeadBack1_1");
        this.EquipHead01_2 = this.Head_1.getChild("EquipHead01_2");
        this.EquipHeadBack1b_1 = this.Head_1.getChild("EquipHeadBack1b_1");
        this.EquipHead01b_1 = this.Back_3.getChild("EquipHead01b_1");
        this.EquipHead01d_1 = this.Back_3.getChild("EquipHead01d_1");
        this.EquipHead01a_1 = this.EquipHead01.getChild("EquipHead01a_1");
        this.EquipHeadBack2 = this.EquipHeadBack1.getChild("EquipHeadBack2");
        this.EquipHeadBack2_1 = this.EquipHeadBack1_1.getChild("EquipHeadBack2_1");
        this.EquipHead01a_3 = this.EquipHead01_2.getChild("EquipHead01a_3");
        this.EquipHead03_1 = this.EquipHeadBack2.getChild("EquipHead03_1");
        this.EquipHeadBack3g = this.EquipHeadBack2.getChild("EquipHeadBack3g");
        this.EquipHeadBack3b = this.EquipHeadBack2.getChild("EquipHeadBack3b");
        this.EquipHead03 = this.EquipHeadBack2.getChild("EquipHead03");
        this.EquipHeadBack3h = this.EquipHeadBack2.getChild("EquipHeadBack3h");
        this.EquipHeadBack2b = this.EquipHeadBack2.getChild("EquipHeadBack2b");
        this.EquipHeadBack3 = this.EquipHeadBack2.getChild("EquipHeadBack3");
        this.EquipHeadBack3e = this.EquipHeadBack2.getChild("EquipHeadBack3e");
        this.EquipHeadBack3f = this.EquipHeadBack2.getChild("EquipHeadBack3f");
        this.EquipHead03_3 = this.EquipHeadBack2.getChild("EquipHead03_3");
        this.EquipHeadBack3c = this.EquipHeadBack2.getChild("EquipHeadBack3c");
        this.EquipHeadBack3d = this.EquipHeadBack2.getChild("EquipHeadBack3d");
        this.EquipHead03_2 = this.EquipHeadBack2.getChild("EquipHead03_2");
        this.EquipHeadBack3_1 = this.EquipHeadBack2_1.getChild("EquipHeadBack3_1");
        this.EquipHeadBack3g_1 = this.EquipHeadBack2_1.getChild("EquipHeadBack3g_1");
        this.EquipHeadBack3e_1 = this.EquipHeadBack2_1.getChild("EquipHeadBack3e_1");
        this.EquipHead03_6 = this.EquipHeadBack2_1.getChild("EquipHead03_6");
        this.EquipHead03_7 = this.EquipHeadBack2_1.getChild("EquipHead03_7");
        this.EquipHead03_5 = this.EquipHeadBack2_1.getChild("EquipHead03_5");
        this.EquipHeadBack3d_1 = this.EquipHeadBack2_1.getChild("EquipHeadBack3d_1");
        this.EquipHead03_4 = this.EquipHeadBack2_1.getChild("EquipHead03_4");
        this.EquipHeadBack2b_1 = this.EquipHeadBack2_1.getChild("EquipHeadBack2b_1");
        this.EquipHeadBack3c_1 = this.EquipHeadBack2_1.getChild("EquipHeadBack3c_1");
        this.EquipHeadBack3f_1 = this.EquipHeadBack2_1.getChild("EquipHeadBack3f_1");
        this.EquipHeadBack3h_1 = this.EquipHeadBack2_1.getChild("EquipHeadBack3h_1");
        this.EquipHeadBack3b_1 = this.EquipHeadBack2_1.getChild("EquipHeadBack3b_1");
        this.EquipHead03a_1 = this.EquipHead03_1.getChild("EquipHead03a_1");
        this.EquipHead03a = this.EquipHead03.getChild("EquipHead03a");
        this.EquipHead02 = this.EquipHeadBack3.getChild("EquipHead02");
        this.EquipHead01_1 = this.EquipHeadBack3.getChild("EquipHead01_1");
        this.EquipHead00 = this.EquipHeadBack3.getChild("EquipHead00");
        this.EquipHead03a_3 = this.EquipHead03_3.getChild("EquipHead03a_3");
        this.EquipHead03a_2 = this.EquipHead03_2.getChild("EquipHead03a_2");
        this.EquipHead02_1 = this.EquipHeadBack3_1.getChild("EquipHead02_1");
        this.EquipHead00_1 = this.EquipHeadBack3_1.getChild("EquipHead00_1");
        this.EquipHead01_3 = this.EquipHeadBack3_1.getChild("EquipHead01_3");
        this.EquipHead03a_6 = this.EquipHead03_6.getChild("EquipHead03a_6");
        this.EquipHead03a_7 = this.EquipHead03_7.getChild("EquipHead03a_7");
        this.EquipHead03a_5 = this.EquipHead03_5.getChild("EquipHead03a_5");
        this.EquipHead03a_4 = this.EquipHead03_4.getChild("EquipHead03a_4");
        this.EquipHead02a = this.EquipHead02.getChild("EquipHead02a");
        this.EquipHead01a = this.EquipHead01_1.getChild("EquipHead01a");
        this.EquipHead00a = this.EquipHead00.getChild("EquipHead00a");
        this.EquipHead02a_1 = this.EquipHead02_1.getChild("EquipHead02a_1");
        this.EquipHead00a_1 = this.EquipHead00_1.getChild("EquipHead00a_1");
        this.EquipHead01a_2 = this.EquipHead01_3.getChild("EquipHead01a_2");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowLowerMain = this.GlowBodyMain.getChild("GlowLowerMain");
        this.GlowTopCannonBase = this.GlowLowerMain.getChild("GlowTopCannonBase");
        this.GlowTopCannonBase_1 = this.GlowLowerMain.getChild("GlowTopCannonBase_1");

        // Tongue parts
        this.TongueBase1 = this.GlowLowerMain.getChild("TongueBase1");
        this.Tongue01 = this.TongueBase1.getChild("Tongue01");
        this.Tongue01a = this.TongueBase1.getChild("Tongue01a");
        this.TongueBase2 = this.TongueBase1.getChild("TongueBase2");
        this.TongueBase3 = this.TongueBase2.getChild("TongueBase3");
        this.Tongue02 = this.TongueBase2.getChild("Tongue02");
        this.Tongue02a = this.TongueBase2.getChild("Tongue02a");
        this.Tongue03 = this.TongueBase3.getChild("Tongue03");
        this.Tongue03a = this.TongueBase3.getChild("Tongue03a");

        // TopCannon parts (GlowTopCannonBase children)
        this.TopCannon01b = this.GlowTopCannonBase.getChild("TopCannon01b");
        this.TopCannon02b = this.TopCannon01b.getChild("TopCannon02b");
        this.TopCannon03b = this.TopCannon01b.getChild("TopCannon03b");
        this.TopCannon04b = this.TopCannon03b.getChild("TopCannon04b");
        this.TopCannon01b_1 = this.GlowTopCannonBase.getChild("TopCannon01b_1");
        this.TopCannon02b_1 = this.TopCannon01b_1.getChild("TopCannon02b_1");
        this.TopCannon03b_1 = this.TopCannon01b_1.getChild("TopCannon03b_1");
        this.TopCannon04b_1 = this.TopCannon03b_1.getChild("TopCannon04b_1");
        this.TopCannon01b_2 = this.GlowTopCannonBase.getChild("TopCannon01b_2");
        this.TopCannon02b_2 = this.TopCannon01b_2.getChild("TopCannon02b_2");
        this.TopCannon03b_2 = this.TopCannon01b_2.getChild("TopCannon03b_2");
        this.TopCannon04b_2 = this.TopCannon03b_2.getChild("TopCannon04b_2");

        // TopCannon parts (GlowTopCannonBase_1 children)
        this.TopCannon01b_3 = this.GlowTopCannonBase_1.getChild("TopCannon01b_3");
        this.TopCannon02b_3 = this.TopCannon01b_3.getChild("TopCannon02b_3");
        this.TopCannon03b_3 = this.TopCannon01b_3.getChild("TopCannon03b_3");
        this.TopCannon04b_3 = this.TopCannon03b_3.getChild("TopCannon04b_3");
        this.TopCannon01b_4 = this.GlowTopCannonBase_1.getChild("TopCannon01b_4");
        this.TopCannon02b_4 = this.TopCannon01b_4.getChild("TopCannon02b_4");
        this.TopCannon03b_4 = this.TopCannon01b_4.getChild("TopCannon03b_4");
        this.TopCannon04b_4 = this.TopCannon03b_4.getChild("TopCannon04b_4");
        this.TopCannon01b_5 = this.GlowTopCannonBase_1.getChild("TopCannon01b_5");
        this.TopCannon02b_5 = this.TopCannon01b_5.getChild("TopCannon02b_5");
        this.TopCannon03b_5 = this.TopCannon01b_5.getChild("TopCannon03b_5");
        this.TopCannon04b_5 = this.TopCannon03b_5.getChild("TopCannon04b_5");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));

        PartDefinition upperMain = bodyMain.addOrReplaceChild("UpperMain",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 9.5F, 14.0F, -0.4363323129985824F, 0.0F, 0.0F));

        PartDefinition back = upperMain.addOrReplaceChild("Back",
                CubeListBuilder.create().mirror().texOffs(19, 15)
                        .addBox(-10.0F, -14.0F, 9.5F, 10.0F, 6.0F, 3.0F),
                PartPose.offset(0.0F, 9.0F, -10.0F));

        PartDefinition back_1 = back.addOrReplaceChild("Back_1",
                CubeListBuilder.create().texOffs(19, 15)
                        .addBox(0.0F, -5.0F, 0.0F, 10.0F, 6.0F, 3.0F),
                PartPose.offset(0.0F, -9.0F, 9.5F));

        back_1.addOrReplaceChild("EquipHead01b",
                CubeListBuilder.create().texOffs(16, 17)
                        .addBox(-6.5F, 0.0F, 0.0F, 13.0F, 6.0F, 3.0F),
                PartPose.offsetAndRotation(13.6F, -5.0F, -3.5F, 0.0F, 0.6108652381980153F, 0.0F));

        back_1.addOrReplaceChild("EquipHead01d",
                CubeListBuilder.create().texOffs(16, 15)
                        .addBox(-6.5F, 0.0F, 0.0F, 13.0F, 6.0F, 3.0F),
                PartPose.offsetAndRotation(-13.6F, -5.0F, -3.5F, 0.0F, -0.6108652381980153F, 0.0F));

        PartDefinition head = back.addOrReplaceChild("Head",
                CubeListBuilder.create().mirror().texOffs(20, 17)
                        .addBox(-9.0F, -8.0F, -5.0F, 9.0F, 6.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, -12.0F, 14.0F, 0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition equipHead01 = head.addOrReplaceChild("EquipHead01",
                CubeListBuilder.create().texOffs(20, 16)
                        .addBox(0.0F, -8.0F, -5.0F, 9.0F, 6.0F, 3.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        equipHead01.addOrReplaceChild("EquipHead01a_1",
                CubeListBuilder.create().texOffs(17, 0)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 7.0F, 3.0F),
                PartPose.offsetAndRotation(14.0F, -8.1F, -6.1F, -0.20943951023931953F,
                        -2.530727415391778F, 0.05235987755982988F));

        PartDefinition equipHeadBack1 = head.addOrReplaceChild("EquipHeadBack1",
                CubeListBuilder.create().mirror().texOffs(13, 1)
                        .addBox(-9.0F, -9.5F, -9.2F, 9.0F, 2.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, -2.0F, -10.1F, -0.8726646259971648F, 0.0F, 0.0F));

        PartDefinition equipHeadBack2 = equipHeadBack1.addOrReplaceChild("EquipHeadBack2",
                CubeListBuilder.create().mirror().texOffs(9, 0)
                        .addBox(-10.0F, -12.0F, -11.0F, 10.0F, 2.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, 0.5F, -2.2F, 0.7853981633974483F, 0.0F, 0.0F));

        PartDefinition equipHead03_1 = equipHeadBack2.addOrReplaceChild("EquipHead03_1",
                CubeListBuilder.create().texOffs(31, 50)
                        .addBox(-6.0F, 1.0F, -4.0F, 10.0F, 11.0F, 3.0F),
                PartPose.offsetAndRotation(13.3F, -8.2F, -1.4F, -0.17453292519943295F,
                        -1.5707963267948966F, -0.17453292519943295F));

        equipHead03_1.addOrReplaceChild("EquipHead03a_1",
                CubeListBuilder.create().mirror().texOffs(28, 43)
                        .addBox(-6.0F, 0.0F, 0.0F, 10.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(-0.1F, 10.5F, -3.7F, 0.24434609527920614F, 0.0F, 0.0F));

        equipHeadBack2.addOrReplaceChild("EquipHeadBack3g",
                CubeListBuilder.create().texOffs(12, 0)
                        .addBox(-8.0F, 0.0F, 0.0F, 8.0F, 2.0F, 12.0F),
                PartPose.offsetAndRotation(-10.0F, -12.5F, -10.0F, 0.0F, 0.0F, -0.5759586531581287F));

        equipHeadBack2.addOrReplaceChild("EquipHeadBack3b",
                CubeListBuilder.create().texOffs(11, 0)
                        .addBox(0.0F, -4.0F, -5.5F, 10.0F, 2.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, -13.0F, 0.4363323129985824F, 0.0F, 0.0F));

        PartDefinition equipHead03 = equipHeadBack2.addOrReplaceChild("EquipHead03",
                CubeListBuilder.create().mirror().texOffs(0, 50)
                        .addBox(-6.0F, 1.0F, -4.0F, 12.0F, 10.0F, 3.0F),
                PartPose.offsetAndRotation(11.2F, -7.9F, -10.6F, -0.3839724354387525F,
                        -1.2217304763960306F, 0.0F));

        equipHead03.addOrReplaceChild("EquipHead03a",
                CubeListBuilder.create().texOffs(0, 43)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.1F, 10.5F, -3.7F, 0.2617993877991494F, 0.0F, 0.0F));

        equipHeadBack2.addOrReplaceChild("EquipHeadBack3h",
                CubeListBuilder.create().texOffs(15, 0)
                        .addBox(-9.0F, 0.0F, 0.0F, 9.0F, 2.0F, 8.0F),
                PartPose.offsetAndRotation(-10.0F, -12.0F, 3.5F, -1.0122909661567112F,
                        -0.24434609527920614F, -0.5235987755982988F));

        equipHeadBack2.addOrReplaceChild("EquipHeadBack2b",
                CubeListBuilder.create().texOffs(9, 0)
                        .addBox(0.0F, -12.0F, -11.0F, 10.0F, 2.0F, 13.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition equipHeadBack3 = equipHeadBack2.addOrReplaceChild("EquipHeadBack3",
                CubeListBuilder.create().mirror().texOffs(12, 0)
                        .addBox(-10.0F, -4.0F, -5.5F, 10.0F, 2.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, -13.0F, 0.4363323129985824F, 0.0F, 0.0F));

        PartDefinition equipHead02 = equipHeadBack3.addOrReplaceChild("EquipHead02",
                CubeListBuilder.create().texOffs(0, 50)
                        .addBox(-6.0F, 0.0F, -4.0F, 12.0F, 10.0F, 3.0F),
                PartPose.offsetAndRotation(8.0F, -1.0F, -2.0F, -0.8726646259971648F,
                        -0.4363323129985824F, 0.22689280275926282F));

        equipHead02.addOrReplaceChild("EquipHead02a",
                CubeListBuilder.create().texOffs(0, 43)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 9.5F, -3.6F, 0.296705972839036F, 0.0F, 0.0F));

        PartDefinition equipHead01_1 = equipHeadBack3.addOrReplaceChild("EquipHead01_1",
                CubeListBuilder.create().texOffs(0, 50)
                        .addBox(-6.0F, 0.0F, -4.0F, 12.0F, 10.0F, 3.0F),
                PartPose.offsetAndRotation(-8.0F, -1.0F, -2.0F, -0.8726646259971648F,
                        0.4363323129985824F, -0.22689280275926282F));

        equipHead01_1.addOrReplaceChild("EquipHead01a",
                CubeListBuilder.create().texOffs(0, 43)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 9.5F, -3.6F, 0.296705972839036F, 0.0F, 0.0F));

        PartDefinition equipHead00 = equipHeadBack3.addOrReplaceChild("EquipHead00",
                CubeListBuilder.create().mirror().texOffs(0, 50)
                        .addBox(-6.0F, 0.0F, -4.0F, 12.0F, 10.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, -2.0F, -4.0F, -0.8028514559173915F, 0.0F, 0.0F));

        equipHead00.addOrReplaceChild("EquipHead00a",
                CubeListBuilder.create().texOffs(0, 43)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 9.5F, -3.6F, 0.3141592653589793F, 0.0F, 0.0F));

        equipHeadBack2.addOrReplaceChild("EquipHeadBack3e",
                CubeListBuilder.create().mirror().texOffs(15, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 9.0F, 2.0F, 8.0F),
                PartPose.offsetAndRotation(10.0F, -12.0F, 3.5F, -1.0122909661567112F,
                        0.24434609527920614F, 0.5235987755982988F));

        equipHeadBack2.addOrReplaceChild("EquipHeadBack3f",
                CubeListBuilder.create().texOffs(18, 3)
                        .addBox(-3.0F, -2.0F, -4.0F, 6.0F, 2.0F, 8.0F),
                PartPose.offsetAndRotation(-11.2F, -8.0F, -12.4F, 0.3490658503988659F, 0.0F,
                        -0.5235987755982988F));

        PartDefinition equipHead03_3 = equipHeadBack2.addOrReplaceChild("EquipHead03_3",
                CubeListBuilder.create().mirror().texOffs(31, 50)
                        .addBox(-4.0F, 1.0F, -4.0F, 10.0F, 11.0F, 3.0F),
                PartPose.offsetAndRotation(-13.3F, -8.2F, -1.4F, -0.17453292519943295F,
                        1.5707963267948966F, 0.17453292519943295F));

        equipHead03_3.addOrReplaceChild("EquipHead03a_3",
                CubeListBuilder.create().texOffs(28, 43)
                        .addBox(-4.0F, 0.0F, 0.0F, 10.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.1F, 10.5F, -3.7F, 0.24434609527920614F, 0.0F, 0.0F));

        equipHeadBack2.addOrReplaceChild("EquipHeadBack3c",
                CubeListBuilder.create().mirror().texOffs(18, 0)
                        .addBox(-3.0F, -2.0F, -4.0F, 6.0F, 2.0F, 8.0F),
                PartPose.offsetAndRotation(11.2F, -8.0F, -12.4F, 0.3490658503988659F, 0.0F,
                        0.5235987755982988F));

        equipHeadBack2.addOrReplaceChild("EquipHeadBack3d",
                CubeListBuilder.create().mirror().texOffs(12, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 8.0F, 2.0F, 12.0F),
                PartPose.offsetAndRotation(10.0F, -12.5F, -10.0F, 0.0F, 0.0F, 0.5759586531581287F));

        PartDefinition equipHead03_2 = equipHeadBack2.addOrReplaceChild("EquipHead03_2",
                CubeListBuilder.create().texOffs(0, 50)
                        .addBox(-6.0F, 1.0F, -4.0F, 12.0F, 10.0F, 3.0F),
                PartPose.offsetAndRotation(-11.2F, -7.9F, -10.6F, -0.3839724354387525F,
                        1.2217304763960306F, 0.0F));

        equipHead03_2.addOrReplaceChild("EquipHead03a_2",
                CubeListBuilder.create().texOffs(0, 43)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.1F, 10.5F, -3.7F, 0.2617993877991494F, 0.0F, 0.0F));

        head.addOrReplaceChild("EquipHeadBack1b",
                CubeListBuilder.create().texOffs(13, 0)
                        .addBox(-8.0F, -9.5F, -9.4F, 9.0F, 2.0F, 10.0F),
                PartPose.offsetAndRotation(7.8F, -2.0F, -10.1F, -0.8726646259971648F, 0.0F, 0.0F));

        head.addOrReplaceChild("EquipHead01c",
                CubeListBuilder.create().mirror().texOffs(17, 0)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 7.0F, 3.0F),
                PartPose.offsetAndRotation(-14.0F, -8.1F, -6.1F, -0.20943951023931953F,
                        2.530727415391778F, 0.05235987755982988F));

        PartDefinition lowerMain = bodyMain.addOrReplaceChild("LowerMain",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 8.0F, 14.0F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition back_2 = lowerMain.addOrReplaceChild("Back_2",
                CubeListBuilder.create().mirror().texOffs(16, 15)
                        .addBox(-10.0F, -17.0F, 9.5F, 10.0F, 7.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, -11.0F, -11.0F, 0.0F, 0.0F, 3.141592653589793F));

        PartDefinition head_1 = back_2.addOrReplaceChild("Head_1",
                CubeListBuilder.create().texOffs(19, 16)
                        .addBox(-9.0F, -8.0F, -5.0F, 9.0F, 4.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, -12.0F, 14.0F, 0.08726646259971647F, 0.0F, 0.0F));

        head_1.addOrReplaceChild("EquipHead01c_1",
                CubeListBuilder.create().texOffs(17, 17)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(-11.8F, -8.1F, -8.9F, 0.20943951023931953F,
                        -0.6108652381980153F, 0.05235987755982988F));

        PartDefinition equipHeadBack1_1 = head_1.addOrReplaceChild("EquipHeadBack1_1",
                CubeListBuilder.create().mirror().texOffs(13, 3)
                        .addBox(-9.0F, -10.5F, -9.2F, 9.0F, 2.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, -2.0F, -10.1F, -0.8726646259971648F, 0.0F, 0.0F));

        PartDefinition equipHeadBack2_1 = equipHeadBack1_1.addOrReplaceChild("EquipHeadBack2_1",
                CubeListBuilder.create().mirror().texOffs(9, 0)
                        .addBox(-10.0F, -12.0F, -11.0F, 10.0F, 2.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, 0.5F, -2.2F, 0.7853981633974483F, 0.0F, 0.0F));

        PartDefinition equipHeadBack3_1 = equipHeadBack2_1.addOrReplaceChild("EquipHeadBack3_1",
                CubeListBuilder.create().mirror().texOffs(11, 0)
                        .addBox(-10.0F, -4.0F, -5.5F, 10.0F, 2.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, -13.0F, 0.4363323129985824F, 0.0F, 0.0F));

        PartDefinition equipHead02_1 = equipHeadBack3_1.addOrReplaceChild("EquipHead02_1",
                CubeListBuilder.create().texOffs(0, 50)
                        .addBox(-6.0F, 0.0F, -4.0F, 12.0F, 6.0F, 3.0F),
                PartPose.offsetAndRotation(8.0F, -1.0F, -2.0F, -0.8726646259971648F,
                        -0.4363323129985824F, 0.22689280275926282F));

        equipHead02_1.addOrReplaceChild("EquipHead02a_1",
                CubeListBuilder.create().texOffs(0, 43)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 5.5F, -3.6F, 0.296705972839036F, 0.0F, 0.0F));

        PartDefinition equipHead00_1 = equipHeadBack3_1.addOrReplaceChild("EquipHead00_1",
                CubeListBuilder.create().mirror().texOffs(0, 50)
                        .addBox(-6.0F, 0.0F, -4.0F, 12.0F, 6.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, -2.0F, -4.0F, -0.8028514559173915F, 0.0F, 0.0F));

        equipHead00_1.addOrReplaceChild("EquipHead00a_1",
                CubeListBuilder.create().texOffs(0, 43)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 5.5F, -3.6F, 0.19198621771937624F, 0.0F, 0.0F));

        PartDefinition equipHead01_3 = equipHeadBack3_1.addOrReplaceChild("EquipHead01_3",
                CubeListBuilder.create().mirror().texOffs(0, 50)
                        .addBox(-6.0F, 0.0F, -4.0F, 12.0F, 6.0F, 3.0F),
                PartPose.offsetAndRotation(-8.0F, -1.0F, -2.0F, -0.8726646259971648F,
                        0.4363323129985824F, -0.22689280275926282F));

        equipHead01_3.addOrReplaceChild("EquipHead01a_2",
                CubeListBuilder.create().texOffs(0, 43)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 5.5F, -3.6F, 0.296705972839036F, 0.0F, 0.0F));

        equipHeadBack2_1.addOrReplaceChild("EquipHeadBack3g_1",
                CubeListBuilder.create().texOffs(12, 0)
                        .addBox(-8.0F, 0.0F, 0.0F, 8.0F, 2.0F, 12.0F),
                PartPose.offsetAndRotation(-10.0F, -12.5F, -10.0F, 0.0F, 0.0F, -0.5759586531581287F));

        equipHeadBack2_1.addOrReplaceChild("EquipHeadBack3e_1",
                CubeListBuilder.create().mirror().texOffs(15, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 9.0F, 2.0F, 8.0F),
                PartPose.offsetAndRotation(10.0F, -12.0F, 3.5F, -1.0122909661567112F,
                        0.24434609527920614F, 0.5235987755982988F));

        PartDefinition equipHead03_6 = equipHeadBack2_1.addOrReplaceChild("EquipHead03_6",
                CubeListBuilder.create().texOffs(0, 50)
                        .addBox(-6.0F, 1.0F, -4.0F, 12.0F, 6.0F, 3.0F),
                PartPose.offsetAndRotation(-11.2F, -7.9F, -10.6F, -0.3839724354387525F,
                        1.2217304763960306F, 0.0F));

        equipHead03_6.addOrReplaceChild("EquipHead03a_6",
                CubeListBuilder.create().texOffs(0, 43)
                        .addBox(-6.0F, 0.0F, 0.0F, 11.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 6.2F, -3.7F, 0.20943951023931953F, 0.0F,
                        0.017453292519943295F));

        PartDefinition equipHead03_7 = equipHeadBack2_1.addOrReplaceChild("EquipHead03_7",
                CubeListBuilder.create().mirror().texOffs(31, 50)
                        .addBox(-4.0F, 1.0F, -4.0F, 10.0F, 7.0F, 3.0F),
                PartPose.offsetAndRotation(-13.3F, -8.2F, -1.4F, -0.17453292519943295F,
                        1.5707963267948966F, 0.17453292519943295F));

        equipHead03_7.addOrReplaceChild("EquipHead03a_7",
                CubeListBuilder.create().texOffs(28, 43)
                        .addBox(-4.0F, 0.0F, 0.0F, 10.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(0.1F, 6.5F, -3.7F, 0.24434609527920614F, 0.0F, 0.0F));

        PartDefinition equipHead03_5 = equipHeadBack2_1.addOrReplaceChild("EquipHead03_5",
                CubeListBuilder.create().texOffs(31, 50)
                        .addBox(-6.0F, 1.0F, -4.0F, 10.0F, 7.0F, 3.0F),
                PartPose.offsetAndRotation(13.3F, -8.2F, -1.4F, -0.17453292519943295F,
                        -1.5707963267948966F, -0.17453292519943295F));

        equipHead03_5.addOrReplaceChild("EquipHead03a_5",
                CubeListBuilder.create().mirror().texOffs(28, 43)
                        .addBox(-6.0F, 0.0F, 0.0F, 10.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(-0.1F, 6.5F, -3.7F, 0.24434609527920614F, 0.0F, 0.0F));

        equipHeadBack2_1.addOrReplaceChild("EquipHeadBack3d_1",
                CubeListBuilder.create().mirror().texOffs(12, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 8.0F, 2.0F, 12.0F),
                PartPose.offsetAndRotation(10.0F, -12.5F, -10.0F, 0.0F, 0.0F, 0.5759586531581287F));

        PartDefinition equipHead03_4 = equipHeadBack2_1.addOrReplaceChild("EquipHead03_4",
                CubeListBuilder.create().mirror().texOffs(0, 50)
                        .addBox(-6.0F, 1.0F, -4.0F, 12.0F, 6.0F, 3.0F),
                PartPose.offsetAndRotation(11.2F, -7.9F, -10.6F, -0.3839724354387525F,
                        -1.2217304763960306F, 0.0F));

        equipHead03_4.addOrReplaceChild("EquipHead03a_4",
                CubeListBuilder.create().texOffs(0, 43)
                        .addBox(-6.0F, 0.0F, 0.0F, 11.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(1.0F, 6.3F, -3.7F, 0.20943951023931953F, 0.0F,
                        -0.017453292519943295F));

        equipHeadBack2_1.addOrReplaceChild("EquipHeadBack2b_1",
                CubeListBuilder.create().texOffs(9, 0)
                        .addBox(0.0F, -12.0F, -11.0F, 10.0F, 2.0F, 13.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        equipHeadBack2_1.addOrReplaceChild("EquipHeadBack3c_1",
                CubeListBuilder.create().mirror().texOffs(18, 2)
                        .addBox(-3.0F, -2.0F, -4.0F, 6.0F, 2.0F, 8.0F),
                PartPose.offsetAndRotation(11.2F, -8.0F, -12.4F, 0.3490658503988659F, 0.0F,
                        0.5235987755982988F));

        equipHeadBack2_1.addOrReplaceChild("EquipHeadBack3f_1",
                CubeListBuilder.create().texOffs(18, 2)
                        .addBox(-3.0F, -2.0F, -4.0F, 6.0F, 2.0F, 8.0F),
                PartPose.offsetAndRotation(-11.2F, -8.0F, -12.4F, 0.3490658503988659F, 0.0F,
                        -0.5235987755982988F));

        equipHeadBack2_1.addOrReplaceChild("EquipHeadBack3h_1",
                CubeListBuilder.create().texOffs(15, 0)
                        .addBox(-9.0F, 0.0F, 0.0F, 9.0F, 2.0F, 8.0F),
                PartPose.offsetAndRotation(-10.0F, -12.0F, 3.5F, -1.0122909661567112F,
                        -0.24434609527920614F, -0.5235987755982988F));

        equipHeadBack2_1.addOrReplaceChild("EquipHeadBack3b_1",
                CubeListBuilder.create().texOffs(11, 0)
                        .addBox(0.0F, -4.0F, -5.5F, 10.0F, 2.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, -13.0F, 0.4363323129985824F, 0.0F, 0.0F));

        PartDefinition equipHead01_2 = head_1.addOrReplaceChild("EquipHead01_2",
                CubeListBuilder.create().texOffs(19, 18)
                        .addBox(0.0F, -8.0F, -5.0F, 9.0F, 4.0F, 4.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        equipHead01_2.addOrReplaceChild("EquipHead01a_3",
                CubeListBuilder.create().mirror().texOffs(17, 17)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(11.7F, -8.1F, -8.9F, 0.20943951023931953F,
                        0.6108652381980153F, -0.05235987755982988F));

        head_1.addOrReplaceChild("EquipHeadBack1b_1",
                CubeListBuilder.create().texOffs(13, 3)
                        .addBox(-8.0F, -10.5F, -9.4F, 9.0F, 2.0F, 10.0F),
                PartPose.offsetAndRotation(7.8F, -2.0F, -10.1F, -0.8726646259971648F, 0.0F, 0.0F));

        PartDefinition back_3 = back_2.addOrReplaceChild("Back_3",
                CubeListBuilder.create().texOffs(16, 15)
                        .addBox(0.0F, -5.0F, 0.0F, 10.0F, 7.0F, 4.0F),
                PartPose.offset(0.0F, -12.0F, 9.5F));

        back_3.addOrReplaceChild("EquipHead01b_1",
                CubeListBuilder.create().mirror().texOffs(16, 15)
                        .addBox(-6.5F, 0.0F, 0.0F, 13.0F, 6.0F, 3.0F),
                PartPose.offsetAndRotation(12.7F, -5.0F, -3.3F, 0.0F, 0.6108652381980153F, 0.0F));

        back_3.addOrReplaceChild("EquipHead01d_1",
                CubeListBuilder.create().texOffs(16, 15)
                        .addBox(-6.5F, 0.0F, 0.0F, 13.0F, 6.0F, 3.0F),
                PartPose.offsetAndRotation(-12.7F, -5.0F, -3.3F, 0.0F, -0.6981317007977318F, 0.0F));

        PartDefinition topCannonBase = lowerMain.addOrReplaceChild("TopCannonBase",
                CubeListBuilder.create().texOffs(32, 26)
                        .addBox(-5.0F, -6.0F, -3.0F, 10.0F, 5.0F, 6.0F),
                PartPose.offsetAndRotation(13.0F, 1.0F, -15.0F, -0.13962634015954636F,
                        -0.17453292519943295F, 0.08726646259971647F));

        topCannonBase.addOrReplaceChild("TopCannonUnder",
                CubeListBuilder.create().texOffs(44, 27)
                        .addBox(-2.0F, 0.0F, -4.0F, 4.0F, 3.0F, 5.0F),
                PartPose.offset(0.0F, -1.0F, 2.0F));

        PartDefinition topCannonBase_1 = lowerMain.addOrReplaceChild("TopCannonBase_1",
                CubeListBuilder.create().texOffs(32, 26)
                        .addBox(-5.0F, -6.0F, -3.0F, 10.0F, 5.0F, 6.0F),
                PartPose.offsetAndRotation(-13.0F, 1.0F, -15.0F, -0.13962634015954636F,
                        0.2617993877991494F, -0.08726646259971647F));

        topCannonBase_1.addOrReplaceChild("TopCannonUnder_1",
                CubeListBuilder.create().texOffs(38, 28)
                        .addBox(-2.0F, 0.0F, -4.0F, 4.0F, 3.0F, 5.0F),
                PartPose.offset(0.0F, -1.0F, 2.0F));

        PartDefinition legArmorBase = bodyMain.addOrReplaceChild("LegArmorBase",
                CubeListBuilder.create().texOffs(32, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offset(0.0F, 20.0F, 6.0F));

        PartDefinition legArmorA4 = legArmorBase.addOrReplaceChild("LegArmorA4",
                CubeListBuilder.create().texOffs(0, 4)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 8.0F, 11.0F, 1.3962634015954636F, -0.6829473363053812F,
                        -0.3141592653589793F));

        legArmorA4.addOrReplaceChild("LegArmorB4",
                CubeListBuilder.create().mirror().texOffs(21, 2)
                        .addBox(-4.5F, -4.5F, -1.0F, 9.0F, 9.0F, 2.0F),
                PartPose.offsetAndRotation(-8.0F, 3.0F, 0.0F, 0.5235987755982988F, 0.7853981633974483F,
                        -0.2792526803190927F));

        PartDefinition legArmorA1 = legArmorBase.addOrReplaceChild("LegArmorA1",
                CubeListBuilder.create().texOffs(0, 4)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 6.0F, -6.0F, -1.2217304763960306F, 0.3490658503988659F,
                        0.3141592653589793F));

        legArmorA1.addOrReplaceChild("LegArmorB1",
                CubeListBuilder.create().texOffs(21, 15)
                        .addBox(-4.5F, -4.5F, -1.0F, 9.0F, 9.0F, 2.0F),
                PartPose.offsetAndRotation(20.0F, -4.5F, 0.0F, -0.13962634015954636F,
                        0.6108652381980153F, -0.13962634015954636F));

        PartDefinition legArmorA2 = legArmorBase.addOrReplaceChild("LegArmorA2",
                CubeListBuilder.create().texOffs(0, 4)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 6.0F, -10.0F, -1.2217304763960306F, 0.0F,
                        -0.3141592653589793F));

        legArmorA2.addOrReplaceChild("LegArmorB2",
                CubeListBuilder.create().mirror().texOffs(21, 15)
                        .addBox(-4.5F, -4.5F, -1.0F, 9.0F, 9.0F, 2.0F),
                PartPose.offsetAndRotation(-18.0F, -4.5F, 0.0F, -0.13962634015954636F,
                        -0.6981317007977318F, 0.13962634015954636F));

        PartDefinition legArmorA3 = legArmorBase.addOrReplaceChild("LegArmorA3",
                CubeListBuilder.create().texOffs(0, 4)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offsetAndRotation(3.0F, 6.0F, 10.0F, -1.2217304763960306F, 0.0F,
                        0.3141592653589793F));

        legArmorA3.addOrReplaceChild("LegArmorB3",
                CubeListBuilder.create().texOffs(21, 15)
                        .addBox(-4.5F, -4.5F, -1.0F, 9.0F, 9.0F, 2.0F),
                PartPose.offsetAndRotation(12.0F, 0.0F, 0.0F, -0.05235987755982988F,
                        0.5235987755982988F, -0.2792526803190927F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));

        PartDefinition glowLowerMain = glowBodyMain.addOrReplaceChild("GlowLowerMain",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 8.0F, 14.0F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition glowTopCannonBase = glowLowerMain.addOrReplaceChild("GlowTopCannonBase",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(13.0F, 1.0F, -15.0F, -0.13962634015954636F,
                        -0.17453292519943295F, 0.08726646259971647F));

        PartDefinition glowTopCannonBase_1 = glowLowerMain.addOrReplaceChild("GlowTopCannonBase_1",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(-13.0F, 1.0F, -15.0F, -0.13962634015954636F,
                        0.2617993877991494F, -0.08726646259971647F));

        // Tongue parts (children of GlowLowerMain -> TongueBase1)
        PartDefinition tongueBase1 = glowLowerMain.addOrReplaceChild("TongueBase1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 3.5F, -17.0F, -0.6108652381980153F,
                        0.2617993877991494F, -0.05235987755982988F));

        tongueBase1.addOrReplaceChild("Tongue01",
                CubeListBuilder.create().texOffs(0, 29)
                        .addBox(0.0F, -2.0F, -10.0F, 10.0F, 4.0F, 10.0F),
                PartPose.offsetAndRotation(-0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.10471975511965977F));

        tongueBase1.addOrReplaceChild("Tongue01a",
                CubeListBuilder.create().texOffs(0, 29)
                        .addBox(-10.0F, -2.0F, -10.0F, 10.0F, 4.0F, 10.0F),
                PartPose.offsetAndRotation(0.3F, 0.0F, 0.0F, 0.0F, 0.0F, -0.10471975511965977F));

        PartDefinition tongueBase2 = tongueBase1.addOrReplaceChild("TongueBase2",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 0.5F, -9.0F, 0.6108652381980153F, 0.0F, 0.0F));

        PartDefinition tongueBase3 = tongueBase2.addOrReplaceChild("TongueBase3",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 0.2F, -6.5F, 0.6108652381980153F, 0.0F, 0.0F));

        tongueBase2.addOrReplaceChild("Tongue02a",
                CubeListBuilder.create().texOffs(0, 31)
                        .addBox(-9.0F, -2.0F, -8.0F, 9.0F, 4.0F, 8.0F),
                PartPose.offsetAndRotation(0.3F, 0.0F, 0.0F, 0.0F, 0.0F, -0.10471975511965977F));

        tongueBase2.addOrReplaceChild("Tongue02",
                CubeListBuilder.create().texOffs(4, 30)
                        .addBox(0.0F, -2.0F, -8.0F, 9.0F, 4.0F, 8.0F),
                PartPose.offsetAndRotation(-0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.10471975511965977F));

        tongueBase3.addOrReplaceChild("Tongue03",
                CubeListBuilder.create().texOffs(8, 29)
                        .addBox(0.0F, -2.0F, -8.0F, 8.0F, 3.0F, 8.0F),
                PartPose.offsetAndRotation(-0.3F, 0.2F, 0.0F, 0.0F, 0.05235987755982988F,
                        0.13962634015954636F));

        tongueBase3.addOrReplaceChild("Tongue03a",
                CubeListBuilder.create().texOffs(6, 29)
                        .addBox(-8.0F, -2.0F, -8.0F, 8.0F, 3.0F, 8.0F),
                PartPose.offsetAndRotation(0.3F, 0.0F, 0.0F, 0.0F, -0.05235987755982988F,
                        -0.13962634015954636F));

        // TopCannon parts (children of GlowTopCannonBase)
        PartDefinition topCannon01b = glowTopCannonBase.addOrReplaceChild("TopCannon01b",
                CubeListBuilder.create().texOffs(37, 30)
                        .addBox(-1.0F, -1.2F, -4.0F, 2.0F, 3.0F, 4.0F),
                PartPose.offsetAndRotation(-3.0F, -3.5F, -2.0F, -0.31869712141416456F, 0.0F, 0.0F));

        topCannon01b.addOrReplaceChild("TopCannon02b",
                CubeListBuilder.create().texOffs(42, 27)
                        .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F),
                PartPose.offset(0.0F, 0.2F, -7.0F));

        PartDefinition topCannon03b = topCannon01b.addOrReplaceChild("TopCannon03b",
                CubeListBuilder.create().texOffs(60, 52)
                        .addBox(-0.5F, 0.0F, -0.5F, 1.0F, 10.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, -0.3F, -3.9F, -1.5707963267948966F, 0.0F, 0.0F));

        topCannon03b.addOrReplaceChild("TopCannon04b",
                CubeListBuilder.create().texOffs(56, 28)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F),
                PartPose.offset(0.0F, 2.0F, 0.0F));

        PartDefinition topCannon01b_1 = glowTopCannonBase.addOrReplaceChild("TopCannon01b_1",
                CubeListBuilder.create().texOffs(46, 30)
                        .addBox(-1.0F, -1.2F, -4.0F, 2.0F, 3.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, -3.5F, -2.0F, -0.31869712141416456F, 0.0F, 0.0F));

        topCannon01b_1.addOrReplaceChild("TopCannon02b_1",
                CubeListBuilder.create().texOffs(35, 26)
                        .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F),
                PartPose.offset(0.0F, 0.2F, -7.0F));

        PartDefinition topCannon03b_1 = topCannon01b_1.addOrReplaceChild("TopCannon03b_1",
                CubeListBuilder.create().texOffs(60, 52)
                        .addBox(-0.5F, 0.0F, -0.5F, 1.0F, 10.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, -0.3F, -3.9F, -1.5707963267948966F, 0.0F, 0.0F));

        topCannon03b_1.addOrReplaceChild("TopCannon04b_1",
                CubeListBuilder.create().texOffs(47, 26)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F),
                PartPose.offset(0.0F, 2.0F, 0.0F));

        PartDefinition topCannon01b_2 = glowTopCannonBase.addOrReplaceChild("TopCannon01b_2",
                CubeListBuilder.create().texOffs(43, 26)
                        .addBox(-1.0F, -1.2F, -4.0F, 2.0F, 3.0F, 4.0F),
                PartPose.offsetAndRotation(3.0F, -3.5F, -2.0F, -0.31869712141416456F, 0.0F, 0.0F));

        topCannon01b_2.addOrReplaceChild("TopCannon02b_2",
                CubeListBuilder.create().texOffs(45, 26)
                        .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F),
                PartPose.offset(0.0F, 0.2F, -7.0F));

        PartDefinition topCannon03b_2 = topCannon01b_2.addOrReplaceChild("TopCannon03b_2",
                CubeListBuilder.create().texOffs(60, 52)
                        .addBox(-0.5F, 0.0F, -0.5F, 1.0F, 10.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, -0.3F, -3.9F, -1.5707963267948966F, 0.0F, 0.0F));

        topCannon03b_2.addOrReplaceChild("TopCannon04b_2",
                CubeListBuilder.create().texOffs(56, 26)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F),
                PartPose.offset(0.0F, 2.0F, 0.0F));

        // TopCannon parts (children of GlowTopCannonBase_1)
        PartDefinition topCannon01b_3 = glowTopCannonBase_1.addOrReplaceChild("TopCannon01b_3",
                CubeListBuilder.create().texOffs(35, 28)
                        .addBox(-1.0F, -1.2F, -4.0F, 2.0F, 3.0F, 4.0F),
                PartPose.offsetAndRotation(-3.0F, -3.5F, -2.0F, -0.31869712141416456F, 0.0F, 0.0F));

        topCannon01b_3.addOrReplaceChild("TopCannon02b_3",
                CubeListBuilder.create().texOffs(37, 27)
                        .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F),
                PartPose.offset(0.0F, 0.2F, -7.0F));

        PartDefinition topCannon03b_3 = topCannon01b_3.addOrReplaceChild("TopCannon03b_3",
                CubeListBuilder.create().texOffs(60, 52)
                        .addBox(-0.5F, 0.0F, -0.5F, 1.0F, 10.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, -0.3F, -3.9F, -1.5707963267948966F, 0.0F, 0.0F));

        topCannon03b_3.addOrReplaceChild("TopCannon04b_3",
                CubeListBuilder.create().texOffs(33, 28)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F),
                PartPose.offset(0.0F, 2.0F, 0.0F));

        PartDefinition topCannon01b_4 = glowTopCannonBase_1.addOrReplaceChild("TopCannon01b_4",
                CubeListBuilder.create().texOffs(52, 28)
                        .addBox(-1.0F, -1.2F, -4.0F, 2.0F, 3.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, -3.5F, -2.0F, -0.31869712141416456F, 0.0F, 0.0F));

        topCannon01b_4.addOrReplaceChild("TopCannon02b_4",
                CubeListBuilder.create().texOffs(37, 27)
                        .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F),
                PartPose.offset(0.0F, 0.2F, -7.0F));

        PartDefinition topCannon03b_4 = topCannon01b_4.addOrReplaceChild("TopCannon03b_4",
                CubeListBuilder.create().texOffs(60, 52)
                        .addBox(-0.5F, 0.0F, -0.5F, 1.0F, 10.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, -0.3F, -3.9F, -1.5707963267948966F, 0.0F, 0.0F));

        topCannon03b_4.addOrReplaceChild("TopCannon04b_4",
                CubeListBuilder.create().texOffs(33, 26)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F),
                PartPose.offset(0.0F, 2.0F, 0.0F));

        PartDefinition topCannon01b_5 = glowTopCannonBase_1.addOrReplaceChild("TopCannon01b_5",
                CubeListBuilder.create().texOffs(46, 27)
                        .addBox(-1.0F, -1.2F, -4.0F, 2.0F, 3.0F, 4.0F),
                PartPose.offsetAndRotation(3.0F, -3.5F, -2.0F, -0.31869712141416456F, 0.0F, 0.0F));

        topCannon01b_5.addOrReplaceChild("TopCannon02b_5",
                CubeListBuilder.create().texOffs(42, 27)
                        .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F),
                PartPose.offset(0.0F, 0.2F, -7.0F));

        PartDefinition topCannon03b_5 = topCannon01b_5.addOrReplaceChild("TopCannon03b_5",
                CubeListBuilder.create().texOffs(60, 52)
                        .addBox(-0.5F, 0.0F, -0.5F, 1.0F, 10.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, -0.3F, -3.9F, -1.5707963267948966F, 0.0F, 0.0F));

        topCannon03b_5.addOrReplaceChild("TopCannon04b_5",
                CubeListBuilder.create().texOffs(40, 27)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F),
                PartPose.offset(0.0F, 2.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                          float headPitch) {
        IShipEmotion ent = (IShipEmotion) entity;
        float angleX = Mth.cos(ageInTicks * 0.08F);

        this.offsetY = 0F;
        if (ent.getShipDepth(0) > 0D) {
            // [PORT] 1.10.2 -> 1.20.1: restore mount water bobbing translation.
            // [RENDER?] Visual check required: water bobbing amplitude should match 1.10.2
            // mount behavior.
            // [REPRO?] Unverified visually: compare idle-on-water Y oscillation in client
            // runtime.
            this.offsetY += angleX * 0.015F + 0.025F;
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
        this.GlowBodyMain.xRot = this.BodyMain.xRot;
        this.GlowTopCannonBase.yRot = this.TopCannonBase.yRot;
        this.GlowTopCannonBase_1.yRot = this.TopCannonBase_1.yRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
    }
}
