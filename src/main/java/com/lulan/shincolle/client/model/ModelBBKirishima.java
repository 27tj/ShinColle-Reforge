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

public class ModelBBKirishima extends ShipModelBaseAdv<Entity> {

        public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
                        new ResourceLocation(Reference.MOD_ID, "bb_kirishima"), "main");

        private final ModelPart BodyMain;
        private final ModelPart Neck;
        private final ModelPart Butt;
        private final ModelPart ArmLeft01;
        private final ModelPart BoobR;
        private final ModelPart BoobL;
        private final ModelPart ArmRight01;
        private final ModelPart Cloth03a1;
        private final ModelPart Cloth03a2;
        private final ModelPart EquipBase;
        private final ModelPart Head;
        private final ModelPart Hair;
        private final ModelPart HairMain;
        private final ModelPart EquipHeadBase;
        private final ModelPart EquipGlass01;
        private final ModelPart HairU01;
        private final ModelPart Ahoke;
        private final ModelPart Hair01;
        private final ModelPart EquipHead01;
        private final ModelPart EquipHead00;
        private final ModelPart EquipHead01_1;
        private final ModelPart EquipHead02;
        private final ModelPart EquipHead03;
        private final ModelPart EquipHead02_1;
        private final ModelPart EquipHead03_1;
        private final ModelPart EquipGlass02a;
        private final ModelPart EquipGlass02b;
        private final ModelPart LegLeft01;
        private final ModelPart Skirt01;
        private final ModelPart LegRight01;
        private final ModelPart SkirtB01;
        private final ModelPart Cloth02a1;
        private final ModelPart Cloth02b1;
        private final ModelPart LegLeft02;
        private final ModelPart Skirt02;
        private final ModelPart LegRight02;
        private final ModelPart Cloth01a;
        private final ModelPart Cloth02c1;
        private final ModelPart Cloth02c1_1;
        private final ModelPart Cloth01b;
        private final ModelPart Cloth01c;
        private final ModelPart Cloth01b2;
        private final ModelPart Cloth01c2;
        private final ModelPart Cloth02c2;
        private final ModelPart Cloth02c3;
        private final ModelPart Cloth02c4;
        private final ModelPart Cloth02c2_1;
        private final ModelPart Cloth02c3_1;
        private final ModelPart Cloth02c4_1;
        private final ModelPart Cloth02a2;
        private final ModelPart Cloth02a3;
        private final ModelPart Cloth02b2;
        private final ModelPart Cloth02b3;
        private final ModelPart ArmLeft02;
        private final ModelPart ClothA01;
        private final ModelPart ClothA02;
        private final ModelPart ClothA03;
        private final ModelPart ClothA04;
        private final ModelPart ClothA05;
        private final ModelPart Cloth03b;
        private final ModelPart ClothB01;
        private final ModelPart Cloth03b_1;
        private final ModelPart ArmRight02;
        private final ModelPart ClothA01_1;
        private final ModelPart ClothA02a;
        private final ModelPart ClothA03a;
        private final ModelPart ClothA04a;
        private final ModelPart ClothA05a;
        private final ModelPart EquipD01a;
        private final ModelPart EquipD02a;
        private final ModelPart EquipD02b;
        private final ModelPart EquipD01b;
        private final ModelPart EquipD02c;
        private final ModelPart EquipD02d;
        private final ModelPart EquipD03a1;
        private final ModelPart EquipD03b1;
        private final ModelPart EquipD03c1;
        private final ModelPart EquipD03d1;
        private final ModelPart EquipD01aa;
        private final ModelPart EquipD01ba;
        private final ModelPart EquipD01bb;
        private final ModelPart EquipD03a2;
        private final ModelPart EquipD03aa;
        private final ModelPart EquipD03ab;
        private final ModelPart EquipD03a3;
        private final ModelPart EquipD03a4;
        private final ModelPart EquipB05;
        private final ModelPart EquipCL1Base01L2;
        private final ModelPart EquipCL1Base02;
        private final ModelPart EquipCL1a1;
        private final ModelPart EquipCL1a1_1;
        private final ModelPart EquipCL1Base01a;
        private final ModelPart EquipCL1a2;
        private final ModelPart EquipCL1a2_1;
        private final ModelPart EquipD03a2_1;
        private final ModelPart EquipD03aa_1;
        private final ModelPart EquipD03ab_1;
        private final ModelPart EquipD03a3_1;
        private final ModelPart EquipD03a4_1;
        private final ModelPart EquipB05_1;
        private final ModelPart EquipCL1Base01R2;
        private final ModelPart EquipCL1Base02_1;
        private final ModelPart EquipCL1a1_2;
        private final ModelPart EquipCL1a1_3;
        private final ModelPart EquipCL1Base01a_1;
        private final ModelPart EquipCL1a2_2;
        private final ModelPart EquipCL1a2_3;
        private final ModelPart EquipD03c1a;
        private final ModelPart EquipD03c1b;
        private final ModelPart EquipD03c2;
        private final ModelPart EquipD03c2a;
        private final ModelPart EquipD03c3;
        private final ModelPart EquipD03c3a;
        private final ModelPart EquipB05_2;
        private final ModelPart EquipCL1Base01L1;
        private final ModelPart EquipCL1Base02_2;
        private final ModelPart EquipCL1a1_4;
        private final ModelPart EquipCL1a1_5;
        private final ModelPart EquipCL1Base01a_2;
        private final ModelPart EquipCL1Base01b;
        private final ModelPart EquipCL1a2_4;
        private final ModelPart EquipCL1a2_5;
        private final ModelPart EquipD03c1a_1;
        private final ModelPart EquipD03c1b_1;
        private final ModelPart EquipD03c2_1;
        private final ModelPart EquipD03c2a_1;
        private final ModelPart EquipD03c3_1;
        private final ModelPart EquipD03c3a_1;
        private final ModelPart EquipB05_3;
        private final ModelPart EquipCL1Base01R1;
        private final ModelPart EquipCL1Base02_3;
        private final ModelPart EquipCL1a1_6;
        private final ModelPart EquipCL1a1_7;
        private final ModelPart EquipCL1Base01a_3;
        private final ModelPart EquipCL1Base01b_1;
        private final ModelPart EquipCL1a2_6;
        private final ModelPart EquipCL1a2_7;
        private final ModelPart GlowBodyMain;
        private final ModelPart GlowHead;
        private final ModelPart GlowNeck;

        public ModelBBKirishima(ModelPart root) {
                super();
                this.BodyMain = root.getChild("BodyMain");
                this.BoobR = this.BodyMain.getChild("BoobR");
                this.Cloth03a1 = this.BodyMain.getChild("Cloth03a1");
                this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
                this.EquipBase = this.BodyMain.getChild("EquipBase");
                this.Cloth03a2 = this.BodyMain.getChild("Cloth03a2");
                this.Neck = this.BodyMain.getChild("Neck");
                this.Butt = this.BodyMain.getChild("Butt");
                this.BoobL = this.BodyMain.getChild("BoobL");
                this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
                this.ClothB01 = this.BoobR.getChild("ClothB01");
                this.Cloth03b = this.BoobR.getChild("Cloth03b");
                this.ClothA01_1 = this.ArmRight01.getChild("ClothA01_1");
                this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
                this.EquipD01a = this.EquipBase.getChild("EquipD01a");
                this.Head = this.Neck.getChild("Head");
                this.Cloth02b1 = this.Butt.getChild("Cloth02b1");
                this.SkirtB01 = this.Butt.getChild("SkirtB01");
                this.LegLeft01 = this.Butt.getChild("LegLeft01");
                this.LegRight01 = this.Butt.getChild("LegRight01");
                this.Cloth02a1 = this.Butt.getChild("Cloth02a1");
                this.Skirt01 = this.Butt.getChild("Skirt01");
                this.Cloth03b_1 = this.BoobL.getChild("Cloth03b_1");
                this.ClothA01 = this.ArmLeft01.getChild("ClothA01");
                this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
                this.ClothA02a = this.ArmRight02.getChild("ClothA02a");
                this.EquipD01b = this.EquipD01a.getChild("EquipD01b");
                this.EquipD03a1 = this.EquipD01a.getChild("EquipD03a1");
                this.EquipD03c1 = this.EquipD01a.getChild("EquipD03c1");
                this.EquipD02c = this.EquipD01a.getChild("EquipD02c");
                this.EquipD02a = this.EquipD01a.getChild("EquipD02a");
                this.EquipD03d1 = this.EquipD01a.getChild("EquipD03d1");
                this.EquipD02b = this.EquipD01a.getChild("EquipD02b");
                this.EquipD01aa = this.EquipD01a.getChild("EquipD01aa");
                this.EquipD03b1 = this.EquipD01a.getChild("EquipD03b1");
                this.EquipD02d = this.EquipD01a.getChild("EquipD02d");
                this.EquipHeadBase = this.Head.getChild("EquipHeadBase");
                this.EquipGlass01 = this.Head.getChild("EquipGlass01");
                this.HairMain = this.Head.getChild("HairMain");
                this.Hair = this.Head.getChild("Hair");
                this.Cloth02b2 = this.Cloth02b1.getChild("Cloth02b2");
                this.Cloth02c1 = this.SkirtB01.getChild("Cloth02c1");
                this.Cloth02c1_1 = this.SkirtB01.getChild("Cloth02c1_1");
                this.Cloth01a = this.SkirtB01.getChild("Cloth01a");
                this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
                this.LegRight02 = this.LegRight01.getChild("LegRight02");
                this.Cloth02a2 = this.Cloth02a1.getChild("Cloth02a2");
                this.Skirt02 = this.Skirt01.getChild("Skirt02");
                this.ClothA02 = this.ArmLeft02.getChild("ClothA02");
                this.ClothA03a = this.ClothA02a.getChild("ClothA03a");
                this.EquipD01ba = this.EquipD01b.getChild("EquipD01ba");
                this.EquipD01bb = this.EquipD01b.getChild("EquipD01bb");
                this.EquipD03ab = this.EquipD03a1.getChild("EquipD03ab");
                this.EquipD03aa = this.EquipD03a1.getChild("EquipD03aa");
                this.EquipD03a2 = this.EquipD03a1.getChild("EquipD03a2");
                this.EquipD03c1b = this.EquipD03c1.getChild("EquipD03c1b");
                this.EquipD03c2 = this.EquipD03c1.getChild("EquipD03c2");
                this.EquipD03c1a = this.EquipD03c1.getChild("EquipD03c1a");
                this.EquipD03c1a_1 = this.EquipD03d1.getChild("EquipD03c1a_1");
                this.EquipD03c1b_1 = this.EquipD03d1.getChild("EquipD03c1b_1");
                this.EquipD03c2_1 = this.EquipD03d1.getChild("EquipD03c2_1");
                this.EquipD03aa_1 = this.EquipD03b1.getChild("EquipD03aa_1");
                this.EquipD03a2_1 = this.EquipD03b1.getChild("EquipD03a2_1");
                this.EquipD03ab_1 = this.EquipD03b1.getChild("EquipD03ab_1");
                this.EquipHead00 = this.EquipHeadBase.getChild("EquipHead00");
                this.EquipHead01 = this.EquipHeadBase.getChild("EquipHead01");
                this.EquipHead01_1 = this.EquipHeadBase.getChild("EquipHead01_1");
                this.EquipGlass02a = this.EquipGlass01.getChild("EquipGlass02a");
                this.EquipGlass02b = this.EquipGlass01.getChild("EquipGlass02b");
                this.Hair01 = this.HairMain.getChild("Hair01");
                this.HairU01 = this.Hair.getChild("HairU01");
                this.Ahoke = this.Hair.getChild("Ahoke");
                this.Cloth02b3 = this.Cloth02b2.getChild("Cloth02b3");
                this.Cloth02c2 = this.Cloth02c1.getChild("Cloth02c2");
                this.Cloth02c2_1 = this.Cloth02c1_1.getChild("Cloth02c2_1");
                this.Cloth01b = this.Cloth01a.getChild("Cloth01b");
                this.Cloth01b2 = this.Cloth01a.getChild("Cloth01b2");
                this.Cloth01c = this.Cloth01a.getChild("Cloth01c");
                this.Cloth01c2 = this.Cloth01a.getChild("Cloth01c2");
                this.Cloth02a3 = this.Cloth02a2.getChild("Cloth02a3");
                this.ClothA03 = this.ClothA02.getChild("ClothA03");
                this.ClothA04a = this.ClothA03a.getChild("ClothA04a");
                this.EquipD03a3 = this.EquipD03a2.getChild("EquipD03a3");
                this.EquipD03c3 = this.EquipD03c2.getChild("EquipD03c3");
                this.EquipD03c2a = this.EquipD03c2.getChild("EquipD03c2a");
                this.EquipD03c2a_1 = this.EquipD03c2_1.getChild("EquipD03c2a_1");
                this.EquipD03c3_1 = this.EquipD03c2_1.getChild("EquipD03c3_1");
                this.EquipD03a3_1 = this.EquipD03a2_1.getChild("EquipD03a3_1");
                this.EquipHead02 = this.EquipHead01.getChild("EquipHead02");
                this.EquipHead02_1 = this.EquipHead01_1.getChild("EquipHead02_1");
                this.Cloth02c3 = this.Cloth02c2.getChild("Cloth02c3");
                this.Cloth02c3_1 = this.Cloth02c2_1.getChild("Cloth02c3_1");
                this.ClothA04 = this.ClothA03.getChild("ClothA04");
                this.ClothA05a = this.ClothA04a.getChild("ClothA05a");
                this.EquipD03a4 = this.EquipD03a3.getChild("EquipD03a4");
                this.EquipB05_2 = this.EquipD03c3.getChild("EquipB05_2");
                this.EquipD03c3a = this.EquipD03c3.getChild("EquipD03c3a");
                this.EquipD03c3a_1 = this.EquipD03c3_1.getChild("EquipD03c3a_1");
                this.EquipB05_3 = this.EquipD03c3_1.getChild("EquipB05_3");
                this.EquipD03a4_1 = this.EquipD03a3_1.getChild("EquipD03a4_1");
                this.EquipHead03 = this.EquipHead02.getChild("EquipHead03");
                this.EquipHead03_1 = this.EquipHead02_1.getChild("EquipHead03_1");
                this.Cloth02c4 = this.Cloth02c3.getChild("Cloth02c4");
                this.Cloth02c4_1 = this.Cloth02c3_1.getChild("Cloth02c4_1");
                this.ClothA05 = this.ClothA04.getChild("ClothA05");
                this.EquipB05 = this.EquipD03a4.getChild("EquipB05");
                this.EquipCL1Base01L1 = this.EquipB05_2.getChild("EquipCL1Base01L1");
                this.EquipCL1Base01R1 = this.EquipB05_3.getChild("EquipCL1Base01R1");
                this.EquipB05_1 = this.EquipD03a4_1.getChild("EquipB05_1");
                this.EquipCL1Base01L2 = this.EquipB05.getChild("EquipCL1Base01L2");
                this.EquipCL1Base01b = this.EquipCL1Base01L1.getChild("EquipCL1Base01b");
                this.EquipCL1a1_4 = this.EquipCL1Base01L1.getChild("EquipCL1a1_4");
                this.EquipCL1a1_5 = this.EquipCL1Base01L1.getChild("EquipCL1a1_5");
                this.EquipCL1Base02_2 = this.EquipCL1Base01L1.getChild("EquipCL1Base02_2");
                this.EquipCL1Base01a_2 = this.EquipCL1Base01L1.getChild("EquipCL1Base01a_2");
                this.EquipCL1Base01a_3 = this.EquipCL1Base01R1.getChild("EquipCL1Base01a_3");
                this.EquipCL1a1_7 = this.EquipCL1Base01R1.getChild("EquipCL1a1_7");
                this.EquipCL1Base02_3 = this.EquipCL1Base01R1.getChild("EquipCL1Base02_3");
                this.EquipCL1Base01b_1 = this.EquipCL1Base01R1.getChild("EquipCL1Base01b_1");
                this.EquipCL1a1_6 = this.EquipCL1Base01R1.getChild("EquipCL1a1_6");
                this.EquipCL1Base01R2 = this.EquipB05_1.getChild("EquipCL1Base01R2");
                this.EquipCL1a1_1 = this.EquipCL1Base01L2.getChild("EquipCL1a1_1");
                this.EquipCL1Base02 = this.EquipCL1Base01L2.getChild("EquipCL1Base02");
                this.EquipCL1a1 = this.EquipCL1Base01L2.getChild("EquipCL1a1");
                this.EquipCL1Base01a = this.EquipCL1Base01L2.getChild("EquipCL1Base01a");
                this.EquipCL1a2_4 = this.EquipCL1a1_4.getChild("EquipCL1a2_4");
                this.EquipCL1a2_5 = this.EquipCL1a1_5.getChild("EquipCL1a2_5");
                this.EquipCL1a2_7 = this.EquipCL1a1_7.getChild("EquipCL1a2_7");
                this.EquipCL1a2_6 = this.EquipCL1a1_6.getChild("EquipCL1a2_6");
                this.EquipCL1Base02_1 = this.EquipCL1Base01R2.getChild("EquipCL1Base02_1");
                this.EquipCL1a1_3 = this.EquipCL1Base01R2.getChild("EquipCL1a1_3");
                this.EquipCL1Base01a_1 = this.EquipCL1Base01R2.getChild("EquipCL1Base01a_1");
                this.EquipCL1a1_2 = this.EquipCL1Base01R2.getChild("EquipCL1a1_2");
                this.EquipCL1a2_1 = this.EquipCL1a1_1.getChild("EquipCL1a2_1");
                this.EquipCL1a2 = this.EquipCL1a1.getChild("EquipCL1a2");
                this.EquipCL1a2_3 = this.EquipCL1a1_3.getChild("EquipCL1a2_3");
                this.EquipCL1a2_2 = this.EquipCL1a1_2.getChild("EquipCL1a2_2");

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

                PartDefinition boobR = bodyMain.addOrReplaceChild("BoobR",
                                CubeListBuilder.create().texOffs(0, 39)
                                                .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 4.0F),
                                PartPose.offsetAndRotation(-3.5F, -8.2F, -3.8F, -0.8726646259971648F,
                                                -0.08726646259971647F, -0.06981317007977318F));

                boobR.addOrReplaceChild("ClothB01",
                                CubeListBuilder.create().texOffs(25, 37)
                                                .addBox(-4.5F, 0.0F, 0.0F, 9.0F, 7.0F, 0.0F),
                                PartPose.offsetAndRotation(2.9F, 4.6F, 1.6F, 0.9599310885968813F,
                                                -0.006806784082777885F, 0.09477137838329208F));

                boobR.addOrReplaceChild("Cloth03b",
                                CubeListBuilder.create().mirror().texOffs(161, 80)
                                                .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 5.0F, 5.0F),
                                PartPose.offsetAndRotation(-0.6F, -0.8F, -0.1F, 0.0F, 0.0F, 0.08726646259971647F));

                bodyMain.addOrReplaceChild("Cloth03a1",
                                CubeListBuilder.create().texOffs(159, 55)
                                                .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 18.0F, 7.0F),
                                PartPose.offset(4.1F, -11.1F, -4.1F));

                PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                                CubeListBuilder.create().texOffs(24, 71)
                                                .addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                                PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, -0.08726646259971647F, 0.0F,
                                                0.3141592653589793F));

                armRight01.addOrReplaceChild("ClothA01_1",
                                CubeListBuilder.create().texOffs(128, 109)
                                                .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F),
                                PartPose.offset(-0.5F, 5.1F, 0.0F));

                PartDefinition armRight02 = armRight01.addOrReplaceChild("ArmRight02",
                                CubeListBuilder.create().texOffs(24, 54)
                                                .addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
                                PartPose.offset(-3.0F, 11.0F, 2.5F));

                PartDefinition clothA02a = armRight02.addOrReplaceChild("ClothA02a",
                                CubeListBuilder.create().texOffs(128, 49)
                                                .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F),
                                PartPose.offsetAndRotation(2.5F, -0.1F, -2.5F, 0.0F, 0.012808717561550659F, 0.0F));

                PartDefinition clothA03a = clothA02a.addOrReplaceChild("ClothA03a",
                                CubeListBuilder.create().texOffs(128, 65)
                                                .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 9.0F, 6.0F),
                                PartPose.offset(-0.1F, 1.9F, -2.2F));

                PartDefinition clothA04a = clothA03a.addOrReplaceChild("ClothA04a",
                                CubeListBuilder.create().texOffs(128, 81)
                                                .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 6.0F),
                                PartPose.offset(0.0F, 0.9F, 0.8F));

                clothA04a.addOrReplaceChild("ClothA05a",
                                CubeListBuilder.create().texOffs(128, 96)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 6.0F),
                                PartPose.offset(0.0F, 1.9F, 0.8F));

                PartDefinition equipBase = bodyMain.addOrReplaceChild("EquipBase",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                                PartPose.offset(0.0F, 7.5F, 5.5F));

                PartDefinition equipD01a = equipBase.addOrReplaceChild("EquipD01a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.0F, 0.0F, 0.0F, 8.0F, 10.0F, 6.0F),
                                PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, 0.06981317007977318F, 0.0F, 0.0F));

                PartDefinition equipD01b = equipD01a.addOrReplaceChild("EquipD01b",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.0F, 0.0F, 0.0F, 8.0F, 9.0F, 6.0F),
                                PartPose.offset(0.0F, 0.4F, 5.9F));

                equipD01b.addOrReplaceChild("EquipD01ba",
                                CubeListBuilder.create().texOffs(22, 22)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 1.0F),
                                PartPose.offset(0.0F, 1.0F, 6.0F));

                equipD01b.addOrReplaceChild("EquipD01bb",
                                CubeListBuilder.create().texOffs(22, 22)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 1.0F),
                                PartPose.offset(0.0F, 4.9F, 6.0F));

                PartDefinition equipD03a1 = equipD01a.addOrReplaceChild("EquipD03a1",
                                CubeListBuilder.create().texOffs(107, 13)
                                                .addBox(0.5F, -1.0F, -2.5F, 6.0F, 2.0F, 9.0F),
                                PartPose.offsetAndRotation(5.0F, 5.8F, 3.5F, 0.0F, 0.0F, 0.5235987755982988F));

                equipD03a1.addOrReplaceChild("EquipD03ab",
                                CubeListBuilder.create().texOffs(100, 30)
                                                .addBox(0.0F, 0.0F, 0.0F, 9.0F, 3.0F, 1.0F),
                                PartPose.offset(-0.5F, -1.5F, 6.4F));

                equipD03a1.addOrReplaceChild("EquipD03aa",
                                CubeListBuilder.create().texOffs(100, 30)
                                                .addBox(0.0F, 0.0F, 0.0F, 9.0F, 3.0F, 1.0F),
                                PartPose.offset(-0.5F, -1.5F, -3.4F));

                PartDefinition equipD03a2 = equipD03a1.addOrReplaceChild("EquipD03a2",
                                CubeListBuilder.create().texOffs(107, 13)
                                                .addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F),
                                PartPose.offset(6.4F, -1.0F, -2.5F));

                PartDefinition equipD03a3 = equipD03a2.addOrReplaceChild("EquipD03a3",
                                CubeListBuilder.create().texOffs(107, 13)
                                                .addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F),
                                PartPose.offset(5.9F, 0.0F, 0.0F));

                PartDefinition equipD03a4 = equipD03a3.addOrReplaceChild("EquipD03a4",
                                CubeListBuilder.create().texOffs(107, 13)
                                                .addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F),
                                PartPose.offset(5.9F, 0.0F, 0.0F));

                PartDefinition equipB05 = equipD03a4.addOrReplaceChild("EquipB05",
                                CubeListBuilder.create().texOffs(100, 30)
                                                .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F),
                                PartPose.offset(1.5F, -0.4F, 4.5F));

                PartDefinition equipCL1Base01L2 = equipB05.addOrReplaceChild("EquipCL1Base01L2",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, -4.0F, -1.5F, 9.0F, 4.0F, 8.0F),
                                PartPose.offset(0.2F, 0.1F, 0.0F));

                PartDefinition equipCL1a1_1 = equipCL1Base01L2.addOrReplaceChild("EquipCL1a1_1",
                                CubeListBuilder.create().texOffs(19, 29)
                                                .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                                PartPose.offsetAndRotation(-2.0F, -2.3F, -2.5F, -0.16982053621904827F, 0.0F, 0.0F));

                equipCL1a1_1.addOrReplaceChild("EquipCL1a2_1",
                                CubeListBuilder.create().texOffs(151, 67)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));

                equipCL1Base01L2.addOrReplaceChild("EquipCL1Base02",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 4.0F),
                                PartPose.offsetAndRotation(0.0F, 0.3F, -2.8F, 0.17453292519943295F, 0.0F, 0.0F));

                PartDefinition equipCL1a1 = equipCL1Base01L2.addOrReplaceChild("EquipCL1a1",
                                CubeListBuilder.create().texOffs(19, 29)
                                                .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                                PartPose.offsetAndRotation(2.0F, -2.3F, -2.5F, -0.18203784098300857F, 0.0F, 0.0F));

                equipCL1a1.addOrReplaceChild("EquipCL1a2",
                                CubeListBuilder.create().texOffs(151, 67)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));

                equipCL1Base01L2.addOrReplaceChild("EquipCL1Base01a",
                                CubeListBuilder.create().texOffs(0, 9)
                                                .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 2.0F, 1.0F),
                                PartPose.offsetAndRotation(0.0F, -5.4F, -1.0F, -0.08726646259971647F, 0.0F, 0.0F));

                PartDefinition equipD03c1 = equipD01a.addOrReplaceChild("EquipD03c1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, -1.5F, 0.0F, 8.0F, 1.0F, 3.0F),
                                PartPose.offsetAndRotation(5.0F, 5.5F, 4.0F, 0.0F, 0.0F, -0.3490658503988659F));

                equipD03c1.addOrReplaceChild("EquipD03c1b",
                                CubeListBuilder.create().texOffs(100, 30)
                                                .addBox(-0.5F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F),
                                PartPose.offset(7.2F, -1.0F, 1.5F));

                PartDefinition equipD03c2 = equipD03c1.addOrReplaceChild("EquipD03c2",
                                CubeListBuilder.create().texOffs(100, 30)
                                                .addBox(0.0F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F),
                                PartPose.offsetAndRotation(8.0F, -0.2F, 1.5F, 0.0F, 0.0F, -0.2617993877991494F));

                PartDefinition equipD03c3 = equipD03c2.addOrReplaceChild("EquipD03c3",
                                CubeListBuilder.create().texOffs(100, 30)
                                                .addBox(0.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F),
                                PartPose.offsetAndRotation(7.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6108652381980153F));

                PartDefinition equipB05_2 = equipD03c3.addOrReplaceChild("EquipB05_2",
                                CubeListBuilder.create().texOffs(100, 30)
                                                .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F),
                                PartPose.offset(6.3F, -2.0F, 0.0F));

                PartDefinition equipCL1Base01L1 = equipB05_2.addOrReplaceChild("EquipCL1Base01L1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, -4.0F, -1.5F, 9.0F, 4.0F, 8.0F),
                                PartPose.offset(0.2F, 0.1F, 0.0F));

                equipCL1Base01L1.addOrReplaceChild("EquipCL1Base01b",
                                CubeListBuilder.create().texOffs(109, 24)
                                                .addBox(-5.5F, 0.0F, 0.0F, 11.0F, 2.0F, 2.0F),
                                PartPose.offset(0.0F, -5.6F, 2.0F));

                PartDefinition equipCL1a1_4 = equipCL1Base01L1.addOrReplaceChild("EquipCL1a1_4",
                                CubeListBuilder.create().texOffs(19, 29)
                                                .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                                PartPose.offsetAndRotation(2.0F, -2.3F, -2.5F, -0.18203784098300857F, 0.0F, 0.0F));

                equipCL1a1_4.addOrReplaceChild("EquipCL1a2_4",
                                CubeListBuilder.create().texOffs(151, 67)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));

                PartDefinition equipCL1a1_5 = equipCL1Base01L1.addOrReplaceChild("EquipCL1a1_5",
                                CubeListBuilder.create().texOffs(19, 29)
                                                .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                                PartPose.offsetAndRotation(-2.0F, -2.3F, -2.5F, -0.16982053621904827F, 0.0F, 0.0F));

                equipCL1a1_5.addOrReplaceChild("EquipCL1a2_5",
                                CubeListBuilder.create().texOffs(151, 67)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));

                equipCL1Base01L1.addOrReplaceChild("EquipCL1Base02_2",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 4.0F),
                                PartPose.offsetAndRotation(0.0F, 0.3F, -2.8F, 0.17453292519943295F, 0.0F, 0.0F));

                equipCL1Base01L1.addOrReplaceChild("EquipCL1Base01a_2",
                                CubeListBuilder.create().texOffs(0, 9)
                                                .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 2.0F, 1.0F),
                                PartPose.offsetAndRotation(0.0F, -5.4F, -1.0F, -0.08726646259971647F, 0.0F, 0.0F));

                equipD03c3.addOrReplaceChild("EquipD03c3a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 8.0F, 3.0F, 9.0F),
                                PartPose.offset(2.3F, -1.4F, -4.5F));

                equipD03c2.addOrReplaceChild("EquipD03c2a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, -1.5F, -4.5F, 8.0F, 3.0F, 9.0F),
                                PartPose.offset(1.5F, 0.1F, 0.0F));

                equipD03c1.addOrReplaceChild("EquipD03c1a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 3.0F),
                                PartPose.offset(0.0F, 0.2F, 0.0F));

                equipD01a.addOrReplaceChild("EquipD02c",
                                CubeListBuilder.create().mirror().texOffs(0, 0)
                                                .addBox(-3.5F, 0.0F, 0.0F, 6.0F, 12.0F, 4.0F),
                                PartPose.offset(3.3F, 5.0F, 5.9F));

                equipD01a.addOrReplaceChild("EquipD02a",
                                CubeListBuilder.create().mirror().texOffs(0, 0)
                                                .addBox(-3.5F, 0.0F, -0.6F, 7.0F, 14.0F, 5.0F),
                                PartPose.offset(3.4F, 5.0F, 1.7F));

                PartDefinition equipD03d1 = equipD01a.addOrReplaceChild("EquipD03d1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, -1.5F, 0.0F, 8.0F, 1.0F, 3.0F),
                                PartPose.offsetAndRotation(-5.0F, 5.5F, 7.0F, 0.0F, 3.141592653589793F,
                                                0.3490658503988659F));

                equipD03d1.addOrReplaceChild("EquipD03c1a_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 3.0F),
                                PartPose.offset(0.0F, 0.2F, 0.0F));

                equipD03d1.addOrReplaceChild("EquipD03c1b_1",
                                CubeListBuilder.create().texOffs(100, 30)
                                                .addBox(-0.5F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F),
                                PartPose.offset(7.2F, -1.0F, 1.5F));

                PartDefinition equipD03c2_1 = equipD03d1.addOrReplaceChild("EquipD03c2_1",
                                CubeListBuilder.create().texOffs(100, 30)
                                                .addBox(0.0F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F),
                                PartPose.offsetAndRotation(8.0F, -0.2F, 1.5F, 0.0F, 0.0F, -0.2617993877991494F));

                equipD03c2_1.addOrReplaceChild("EquipD03c2a_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, -1.5F, -4.5F, 8.0F, 3.0F, 9.0F),
                                PartPose.offset(1.5F, 0.1F, 0.0F));

                PartDefinition equipD03c3_1 = equipD03c2_1.addOrReplaceChild("EquipD03c3_1",
                                CubeListBuilder.create().texOffs(100, 30)
                                                .addBox(0.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F),
                                PartPose.offsetAndRotation(7.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6108652381980153F));

                equipD03c3_1.addOrReplaceChild("EquipD03c3a_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 8.0F, 3.0F, 9.0F),
                                PartPose.offset(2.3F, -1.4F, -4.5F));

                PartDefinition equipB05_3 = equipD03c3_1.addOrReplaceChild("EquipB05_3",
                                CubeListBuilder.create().texOffs(100, 30)
                                                .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F),
                                PartPose.offsetAndRotation(6.3F, -2.0F, 0.0F, 0.0F, 3.141592653589793F, 0.0F));

                PartDefinition equipCL1Base01R1 = equipB05_3.addOrReplaceChild("EquipCL1Base01R1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, -4.0F, -1.5F, 9.0F, 4.0F, 8.0F),
                                PartPose.offset(0.2F, 0.1F, 0.0F));

                equipCL1Base01R1.addOrReplaceChild("EquipCL1Base01a_3",
                                CubeListBuilder.create().texOffs(0, 9)
                                                .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 2.0F, 1.0F),
                                PartPose.offsetAndRotation(0.0F, -5.4F, -1.0F, -0.08726646259971647F, 0.0F, 0.0F));

                PartDefinition equipCL1a1_7 = equipCL1Base01R1.addOrReplaceChild("EquipCL1a1_7",
                                CubeListBuilder.create().texOffs(19, 29)
                                                .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                                PartPose.offsetAndRotation(-2.0F, -2.3F, -2.5F, -0.16982053621904827F, 0.0F, 0.0F));

                equipCL1a1_7.addOrReplaceChild("EquipCL1a2_7",
                                CubeListBuilder.create().texOffs(151, 67)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));

                equipCL1Base01R1.addOrReplaceChild("EquipCL1Base02_3",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 4.0F),
                                PartPose.offsetAndRotation(0.0F, 0.3F, -2.8F, 0.17453292519943295F, 0.0F, 0.0F));

                equipCL1Base01R1.addOrReplaceChild("EquipCL1Base01b_1",
                                CubeListBuilder.create().texOffs(109, 24)
                                                .addBox(-5.5F, 0.0F, 0.0F, 11.0F, 2.0F, 2.0F),
                                PartPose.offset(0.0F, -5.6F, 2.0F));

                PartDefinition equipCL1a1_6 = equipCL1Base01R1.addOrReplaceChild("EquipCL1a1_6",
                                CubeListBuilder.create().texOffs(19, 29)
                                                .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                                PartPose.offsetAndRotation(2.0F, -2.3F, -2.5F, -0.18203784098300857F, 0.0F, 0.0F));

                equipCL1a1_6.addOrReplaceChild("EquipCL1a2_6",
                                CubeListBuilder.create().texOffs(151, 67)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));

                equipD01a.addOrReplaceChild("EquipD02b",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-3.5F, 0.0F, -0.6F, 7.0F, 14.0F, 5.0F),
                                PartPose.offset(-3.4F, 5.0F, 1.7F));

                equipD01a.addOrReplaceChild("EquipD01aa",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 6.0F),
                                PartPose.offsetAndRotation(0.0F, 9.5F, -4.0F, 0.22689280275926282F, 0.0F, 0.0F));

                PartDefinition equipD03b1 = equipD01a.addOrReplaceChild("EquipD03b1",
                                CubeListBuilder.create().texOffs(107, 13)
                                                .addBox(0.5F, -1.0F, -2.5F, 6.0F, 2.0F, 9.0F),
                                PartPose.offsetAndRotation(-5.0F, 5.8F, 7.5F, 0.0F, 3.141592653589793F,
                                                -0.5235987755982988F));

                equipD03b1.addOrReplaceChild("EquipD03aa_1",
                                CubeListBuilder.create().texOffs(100, 30)
                                                .addBox(0.0F, 0.0F, 0.0F, 9.0F, 3.0F, 1.0F),
                                PartPose.offset(-0.5F, -1.5F, -3.4F));

                PartDefinition equipD03a2_1 = equipD03b1.addOrReplaceChild("EquipD03a2_1",
                                CubeListBuilder.create().texOffs(107, 13)
                                                .addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F),
                                PartPose.offset(6.4F, -1.0F, -2.5F));

                PartDefinition equipD03a3_1 = equipD03a2_1.addOrReplaceChild("EquipD03a3_1",
                                CubeListBuilder.create().texOffs(107, 13)
                                                .addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F),
                                PartPose.offset(5.9F, 0.0F, 0.0F));

                PartDefinition equipD03a4_1 = equipD03a3_1.addOrReplaceChild("EquipD03a4_1",
                                CubeListBuilder.create().texOffs(107, 13)
                                                .addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F),
                                PartPose.offset(5.9F, 0.0F, 0.0F));

                PartDefinition equipB05_1 = equipD03a4_1.addOrReplaceChild("EquipB05_1",
                                CubeListBuilder.create().texOffs(100, 30)
                                                .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F),
                                PartPose.offsetAndRotation(1.5F, -0.4F, 4.5F, 0.0F, 3.141592653589793F, 0.0F));

                PartDefinition equipCL1Base01R2 = equipB05_1.addOrReplaceChild("EquipCL1Base01R2",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, -4.0F, -1.5F, 9.0F, 4.0F, 8.0F),
                                PartPose.offset(0.2F, 0.1F, 0.0F));

                equipCL1Base01R2.addOrReplaceChild("EquipCL1Base02_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 4.0F),
                                PartPose.offsetAndRotation(0.0F, 0.3F, -2.8F, 0.17453292519943295F, 0.0F, 0.0F));

                PartDefinition equipCL1a1_3 = equipCL1Base01R2.addOrReplaceChild("EquipCL1a1_3",
                                CubeListBuilder.create().texOffs(19, 29)
                                                .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                                PartPose.offsetAndRotation(-2.0F, -2.3F, -2.5F, -0.16982053621904827F, 0.0F, 0.0F));

                equipCL1a1_3.addOrReplaceChild("EquipCL1a2_3",
                                CubeListBuilder.create().texOffs(151, 67)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));

                equipCL1Base01R2.addOrReplaceChild("EquipCL1Base01a_1",
                                CubeListBuilder.create().texOffs(0, 9)
                                                .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 2.0F, 1.0F),
                                PartPose.offsetAndRotation(0.0F, -5.4F, -1.0F, -0.08726646259971647F, 0.0F, 0.0F));

                PartDefinition equipCL1a1_2 = equipCL1Base01R2.addOrReplaceChild("EquipCL1a1_2",
                                CubeListBuilder.create().texOffs(19, 29)
                                                .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                                PartPose.offsetAndRotation(2.0F, -2.3F, -2.5F, -0.18203784098300857F, 0.0F, 0.0F));

                equipCL1a1_2.addOrReplaceChild("EquipCL1a2_2",
                                CubeListBuilder.create().texOffs(151, 67)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));

                equipD03b1.addOrReplaceChild("EquipD03ab_1",
                                CubeListBuilder.create().texOffs(100, 30)
                                                .addBox(0.0F, 0.0F, 0.0F, 9.0F, 3.0F, 1.0F),
                                PartPose.offset(-0.5F, -1.5F, 6.4F));

                equipD01a.addOrReplaceChild("EquipD02d",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 6.0F, 12.0F, 4.0F),
                                PartPose.offset(-5.9F, 5.0F, 5.9F));

                bodyMain.addOrReplaceChild("Cloth03a2",
                                CubeListBuilder.create().mirror().texOffs(159, 55)
                                                .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 18.0F, 7.0F),
                                PartPose.offset(-4.1F, -11.1F, -4.1F));

                PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                                CubeListBuilder.create().texOffs(24, 63)
                                                .addBox(-2.5F, -3.0F, -2.9F, 5.0F, 3.0F, 5.0F),
                                PartPose.offsetAndRotation(0.0F, -9.6F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));

                PartDefinition head = neck.addOrReplaceChild("Head",
                                CubeListBuilder.create().texOffs(44, 101)
                                                .addBox(-7.0F, -14.5F, -6.4F, 14.0F, 14.0F, 13.0F),
                                PartPose.offset(0.0F, -1.0F, -0.7F));

                PartDefinition equipHeadBase = head.addOrReplaceChild("EquipHeadBase",
                                CubeListBuilder.create().texOffs(40, 23)
                                                .addBox(-8.0F, 0.0F, 7.0F, 16.0F, 2.0F, 8.0F),
                                PartPose.offset(0.0F, -11.8F, -7.6F));

                equipHeadBase.addOrReplaceChild("EquipHead00",
                                CubeListBuilder.create().texOffs(44, 16)
                                                .addBox(-8.5F, 0.0F, 0.0F, 17.0F, 5.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, -4.1F, 5.0F, 0.10471975511965977F, 0.0F, 0.0F));

                PartDefinition equipHead01 = equipHeadBase.addOrReplaceChild("EquipHead01",
                                CubeListBuilder.create().texOffs(43, 105)
                                                .addBox(0.0F, -0.7F, -0.3F, 2.0F, 3.0F, 3.0F),
                                PartPose.offset(6.7F, 0.2F, 5.7F));

                PartDefinition equipHead02 = equipHead01.addOrReplaceChild("EquipHead02",
                                CubeListBuilder.create().texOffs(45, 106)
                                                .addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
                                PartPose.offset(2.4F, 0.8F, 1.2F));

                equipHead02.addOrReplaceChild("EquipHead03",
                                CubeListBuilder.create().texOffs(33, 105)
                                                .addBox(0.0F, 0.0F, 0.0F, 5.0F, 3.0F, 0.0F),
                                PartPose.offset(0.2F, -1.5F, 0.0F));

                PartDefinition equipHead01_1 = equipHeadBase.addOrReplaceChild("EquipHead01_1",
                                CubeListBuilder.create().texOffs(43, 105)
                                                .addBox(-2.0F, -0.7F, -0.3F, 2.0F, 3.0F, 3.0F),
                                PartPose.offset(-6.7F, 0.2F, 5.7F));

                PartDefinition equipHead02_1 = equipHead01_1.addOrReplaceChild("EquipHead02_1",
                                CubeListBuilder.create().texOffs(43, 107)
                                                .addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F),
                                PartPose.offset(-2.4F, 0.8F, 1.2F));

                equipHead02_1.addOrReplaceChild("EquipHead03_1",
                                CubeListBuilder.create().texOffs(33, 105)
                                                .addBox(-5.0F, 0.0F, 0.0F, 5.0F, 3.0F, 0.0F),
                                PartPose.offset(-0.2F, -1.5F, 0.0F));

                PartDefinition equipGlass01 = head.addOrReplaceChild("EquipGlass01",
                                CubeListBuilder.create().texOffs(90, 0)
                                                .addBox(-8.0F, 0.0F, 0.0F, 16.0F, 5.0F, 0.0F),
                                PartPose.offset(0.0F, -8.1F, -8.4F));

                equipGlass01.addOrReplaceChild("EquipGlass02a",
                                CubeListBuilder.create().texOffs(90, 5)
                                                .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F),
                                PartPose.offset(7.8F, 2.1F, -0.2F));

                equipGlass01.addOrReplaceChild("EquipGlass02b",
                                CubeListBuilder.create().texOffs(90, 5)
                                                .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F),
                                PartPose.offset(-7.8F, 2.1F, -0.2F));

                PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                                CubeListBuilder.create().texOffs(46, 104)
                                                .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F),
                                PartPose.offset(0.0F, -14.8F, -3.0F));

                hairMain.addOrReplaceChild("Hair01",
                                CubeListBuilder.create().texOffs(50, 39)
                                                .addBox(-8.0F, 0.0F, 0.0F, 16.0F, 8.0F, 9.0F),
                                PartPose.offsetAndRotation(0.0F, 7.7F, 1.2F, 0.10471975511965977F, 0.0F, 0.0F));

                PartDefinition hair = head.addOrReplaceChild("Hair",
                                CubeListBuilder.create().texOffs(50, 77)
                                                .addBox(-8.0F, -8.0F, -7.4F, 16.0F, 16.0F, 8.0F),
                                PartPose.offset(0.0F, -7.5F, 0.1F));

                hair.addOrReplaceChild("HairU01",
                                CubeListBuilder.create().texOffs(52, 56)
                                                .addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F),
                                PartPose.offset(0.0F, -6.0F, -7.0F));

                hair.addOrReplaceChild("Ahoke",
                                CubeListBuilder.create().texOffs(118, 42)
                                                .addBox(-1.5F, 0.0F, 0.0F, 5.0F, 7.0F, 0.0F),
                                PartPose.offsetAndRotation(-0.3F, -5.1F, -7.5F, -0.13962634015954636F,
                                                -0.17453292519943295F, 0.08726646259971647F));

                PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                                CubeListBuilder.create().texOffs(0, 88)
                                                .addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F),
                                PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));

                PartDefinition cloth02b1 = butt.addOrReplaceChild("Cloth02b1",
                                CubeListBuilder.create().texOffs(59, 0)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F),
                                PartPose.offsetAndRotation(-4.0F, 2.3F, -6.8F, -0.4363323129985824F, 0.0F,
                                                0.06981317007977318F));

                PartDefinition cloth02b2 = cloth02b1.addOrReplaceChild("Cloth02b2",
                                CubeListBuilder.create().texOffs(59, 0)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 4.9F, 0.0F, 0.17453292519943295F, 0.0F,
                                                -0.05235987755982988F));

                cloth02b2.addOrReplaceChild("Cloth02b3",
                                CubeListBuilder.create().texOffs(59, 0)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, 0.0F, 0.0F, -0.05235987755982988F));

                PartDefinition skirtB01 = butt.addOrReplaceChild("SkirtB01",
                                CubeListBuilder.create().texOffs(128, 36)
                                                .addBox(-8.0F, 0.0F, -4.5F, 16.0F, 2.0F, 9.0F),
                                PartPose.offsetAndRotation(0.0F, 0.5F, -1.9F, 0.08726646259971647F, 0.0F, 0.0F));

                PartDefinition cloth02c1 = skirtB01.addOrReplaceChild("Cloth02c1",
                                CubeListBuilder.create().texOffs(58, 7)
                                                .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 0.0F),
                                PartPose.offsetAndRotation(2.6F, 1.9F, 4.4F, 0.6283185307179586F, 0.0F,
                                                -0.08726646259971647F));

                PartDefinition cloth02c2 = cloth02c1.addOrReplaceChild("Cloth02c2",
                                CubeListBuilder.create().texOffs(58, 7)
                                                .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7853981633974483F, 0.0F, 0.0F));

                PartDefinition cloth02c3 = cloth02c2.addOrReplaceChild("Cloth02c3",
                                CubeListBuilder.create().texOffs(58, 7)
                                                .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 6.9F, 0.0F, -0.13962634015954636F, 0.0F,
                                                0.03490658503988659F));

                cloth02c3.addOrReplaceChild("Cloth02c4",
                                CubeListBuilder.create().texOffs(58, 7)
                                                .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 0.0F),
                                PartPose.offset(0.0F, 7.9F, 0.0F));

                PartDefinition cloth02c1_1 = skirtB01.addOrReplaceChild("Cloth02c1_1",
                                CubeListBuilder.create().texOffs(58, 7)
                                                .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 0.0F),
                                PartPose.offsetAndRotation(-2.6F, 1.9F, 4.4F, 0.6283185307179586F, 0.0F,
                                                0.08726646259971647F));

                PartDefinition cloth02c2_1 = cloth02c1_1.addOrReplaceChild("Cloth02c2_1",
                                CubeListBuilder.create().texOffs(58, 7)
                                                .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7853981633974483F, 0.0F, 0.0F));

                PartDefinition cloth02c3_1 = cloth02c2_1.addOrReplaceChild("Cloth02c3_1",
                                CubeListBuilder.create().texOffs(58, 7)
                                                .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 6.9F, 0.0F, -0.13962634015954636F, 0.0F,
                                                -0.03490658503988659F));

                cloth02c3_1.addOrReplaceChild("Cloth02c4_1",
                                CubeListBuilder.create().texOffs(58, 7)
                                                .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 0.0F),
                                PartPose.offset(0.0F, 7.9F, 0.0F));

                PartDefinition cloth01a = skirtB01.addOrReplaceChild("Cloth01a",
                                CubeListBuilder.create().texOffs(81, 0)
                                                .addBox(-1.0F, -2.5F, -1.0F, 2.0F, 3.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 2.3F, -5.0F, -0.2617993877991494F, 0.0F, 0.0F));

                cloth01a.addOrReplaceChild("Cloth01b",
                                CubeListBuilder.create().texOffs(65, 0)
                                                .addBox(-6.0F, -3.0F, -1.0F, 6.0F, 3.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 0.5F, 0.3F, 0.08726646259971647F,
                                                -0.17453292519943295F, -0.3490658503988659F));

                cloth01a.addOrReplaceChild("Cloth01b2",
                                CubeListBuilder.create().texOffs(65, 0)
                                                .addBox(0.0F, -3.0F, -1.0F, 6.0F, 3.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 0.5F, 0.3F, 0.08726646259971647F, 0.17453292519943295F,
                                                0.3490658503988659F));

                cloth01a.addOrReplaceChild("Cloth01c",
                                CubeListBuilder.create().texOffs(73, 5)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F),
                                PartPose.offsetAndRotation(-2.0F, -0.4F, -0.7F, -0.2617993877991494F,
                                                0.13962634015954636F, 0.17453292519943295F));

                cloth01a.addOrReplaceChild("Cloth01c2",
                                CubeListBuilder.create().mirror().texOffs(73, 5)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F),
                                PartPose.offsetAndRotation(2.0F, -0.4F, -0.7F, -0.2617993877991494F,
                                                -0.13962634015954636F, -0.17453292519943295F));

                PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                                CubeListBuilder.create().texOffs(0, 68)
                                                .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                                PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.296705972839036F, 0.0F,
                                                0.08726646259971647F));

                legLeft01.addOrReplaceChild("LegLeft02",
                                CubeListBuilder.create().texOffs(0, 47)
                                                .addBox(-6.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                                PartPose.offset(3.0F, 14.0F, -3.0F));

                PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                                CubeListBuilder.create().mirror().texOffs(0, 68)
                                                .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                                PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.19198621771937624F, 0.0F,
                                                -0.08726646259971647F));

                legRight01.addOrReplaceChild("LegRight02",
                                CubeListBuilder.create().mirror().texOffs(0, 47)
                                                .addBox(0.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                                PartPose.offset(-3.0F, 14.0F, -3.0F));

                PartDefinition cloth02a1 = butt.addOrReplaceChild("Cloth02a1",
                                CubeListBuilder.create().texOffs(59, 0)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F),
                                PartPose.offsetAndRotation(4.0F, 2.3F, -6.8F, -0.4363323129985824F, 0.0F,
                                                -0.06981317007977318F));

                PartDefinition cloth02a2 = cloth02a1.addOrReplaceChild("Cloth02a2",
                                CubeListBuilder.create().texOffs(59, 0)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 4.9F, 0.0F, 0.24434609527920614F, 0.0F,
                                                0.05235987755982988F));

                cloth02a2.addOrReplaceChild("Cloth02a3",
                                CubeListBuilder.create().texOffs(59, 0)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, 0.0F, 0.0F, 0.05235987755982988F));

                PartDefinition skirt01 = butt.addOrReplaceChild("Skirt01",
                                CubeListBuilder.create().texOffs(128, 0)
                                                .addBox(-8.5F, 0.0F, -8.5F, 17.0F, 5.0F, 11.0F),
                                PartPose.offsetAndRotation(0.0F, 3.5F, 1.5F, -0.08726646259971647F, 0.0F, 0.0F));

                skirt01.addOrReplaceChild("Skirt02",
                                CubeListBuilder.create().texOffs(128, 17)
                                                .addBox(-9.5F, 0.0F, -6.5F, 19.0F, 5.0F, 13.0F),
                                PartPose.offsetAndRotation(0.0F, 3.5F, -2.7F, -0.08726646259971647F, 0.0F, 0.0F));

                PartDefinition boobL = bodyMain.addOrReplaceChild("BoobL",
                                CubeListBuilder.create().texOffs(25, 44)
                                                .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 4.0F),
                                PartPose.offsetAndRotation(3.5F, -8.2F, -3.7F, -0.8726646259971648F,
                                                0.08726646259971647F, 0.06981317007977318F));

                boobL.addOrReplaceChild("Cloth03b_1",
                                CubeListBuilder.create().texOffs(161, 80)
                                                .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 5.0F, 5.0F),
                                PartPose.offsetAndRotation(0.6F, -0.8F, -0.1F, 0.0F, 0.0F, -0.08726646259971647F));

                PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                                CubeListBuilder.create().texOffs(24, 71)
                                                .addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                                PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.27314402793711257F, 0.0F,
                                                -0.3141592653589793F));

                armLeft01.addOrReplaceChild("ClothA01",
                                CubeListBuilder.create().texOffs(128, 109)
                                                .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F),
                                PartPose.offset(0.5F, 5.1F, 0.0F));

                PartDefinition armLeft02 = armLeft01.addOrReplaceChild("ArmLeft02",
                                CubeListBuilder.create().texOffs(24, 54)
                                                .addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
                                PartPose.offset(3.0F, 11.0F, 2.5F));

                PartDefinition clothA02 = armLeft02.addOrReplaceChild("ClothA02",
                                CubeListBuilder.create().texOffs(128, 49)
                                                .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F),
                                PartPose.offset(-2.5F, -0.1F, -2.5F));

                PartDefinition clothA03 = clothA02.addOrReplaceChild("ClothA03",
                                CubeListBuilder.create().texOffs(128, 65)
                                                .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 9.0F, 6.0F),
                                PartPose.offset(0.1F, 1.9F, -2.2F));

                PartDefinition clothA04 = clothA03.addOrReplaceChild("ClothA04",
                                CubeListBuilder.create().texOffs(128, 81)
                                                .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 6.0F),
                                PartPose.offset(0.0F, 0.9F, 0.8F));

                clothA04.addOrReplaceChild("ClothA05",
                                CubeListBuilder.create().texOffs(128, 96)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 6.0F),
                                PartPose.offset(0.0F, 1.9F, 0.8F));

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

                return LayerDefinition.create(meshdefinition, 256, 128);
        }

        @Override
        public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                        float headPitch) {
                IShipEmotion ent = (IShipEmotion) entity;
                // set scale per scaleLevel
                switch (ent.getScaleLevel()) {
                        case 3:
                                this.scale = 1.8F;
                                this.offsetY = -0.69F;
                                break;
                        case 2:
                                this.scale = 1.35F;
                                this.offsetY = -0.41F;
                                break;
                        case 1:
                                this.scale = 0.9F;
                                this.offsetY = 0.14F;
                                break;
                        default:
                                this.scale = 0.45F;
                                this.offsetY = 1.79F;
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
                poseStack.translate(0F, offsetY, 0F);
                this.BodyMain.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
                this.GlowBodyMain.render(poseStack, buffer, 0xF000F0, packedOverlay, red, green, blue, alpha);
                poseStack.popPose();
        }

        @Override
        public void showEquip(IShipEmotion ent) {

                int state = ent.getStateEmotion(ID.S.State);

                boolean flag = !EmotionHelper.checkModelState(0, state); // cannon
                this.EquipBase.visible = !flag;

                flag = !EmotionHelper.checkModelState(1, state); // head equip
                this.EquipHeadBase.visible = !flag;

                flag = !EmotionHelper.checkModelState(2, state); // glasses
                this.EquipGlass01.visible = !flag;
        }

        @Override
        public void syncRotationGlowPart() {
                this.GlowBodyMain.xRot = this.BodyMain.xRot;
                this.GlowBodyMain.yRot = this.BodyMain.yRot;
                this.GlowBodyMain.zRot = this.BodyMain.zRot;
                this.GlowHead.xRot = this.Head.xRot;
                this.GlowHead.yRot = this.Head.yRot;
                this.GlowHead.zRot = this.Head.zRot;
                this.EquipCL1a1.xRot = this.Head.xRot;
                this.EquipCL1a1_1.xRot = this.Head.xRot;
                this.EquipCL1a1_2.xRot = this.Head.xRot;
                this.EquipCL1a1_3.xRot = this.Head.xRot;
                this.EquipCL1a1_4.xRot = this.Head.xRot;
                this.EquipCL1a1_5.xRot = this.Head.xRot;
                this.EquipCL1a1_6.xRot = this.Head.xRot;
                this.EquipCL1a1_7.xRot = this.Head.xRot;
                this.EquipD03c2_1.zRot = this.EquipD03c2.zRot;
                this.EquipD03c3_1.zRot = this.EquipD03c3.zRot;
                this.EquipCL1Base01L1.yRot = this.Head.yRot;
                this.EquipCL1Base01L2.yRot = this.Head.yRot;
                this.EquipCL1Base01R1.yRot = this.Head.yRot;
                this.EquipCL1Base01R2.yRot = this.Head.yRot;
        }

        @Override
        public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

                // Scale-dependent dead pose variations (currently defaults for all scales)
                switch (ent.getScaleLevel()) {
                        case 3:
                                break;
                        case 2:
                                break;
                        case 1:
                                break;
                        default:
                                break;
                }

                this.setFaceHungry(ent);

                // body
                this.Head.xRot = 0F;
                this.Head.yRot = 0F;
                this.Head.zRot = 0F;
                this.BodyMain.xRot = 1.4F;
                this.Butt.xRot = 0.21F;
                // this.Butt.offsetY = 0F;
                // this.Butt.offsetZ = 0F;
                // boob
                this.BoobL.xRot = -0.8F;
                this.BoobR.xRot = -0.8F;
                this.ClothB01.xRot = 0.96F;
                // cloth
                this.Skirt01.xRot = -0.087F;
                this.Skirt02.xRot = -0.087F;
                // this.Skirt01.offsetY = 0F;
                // this.Skirt01.offsetZ = 0F;
                this.SkirtB01.xRot = 0.087F;
                this.ClothA03.yRot = 0F;
                this.ClothA03a.yRot = 0F;
                this.Cloth02a1.xRot = -0.5585F;
                this.Cloth02b1.xRot = -0.5585F;
                this.Cloth02c1.xRot = 0.6283F;
                this.Cloth02c1_1.xRot = 0.6283F;
                this.Cloth02c2.xRot = -0.7854F;
                this.Cloth02c2_1.xRot = -0.7854F;
                this.Cloth02c3.xRot = -0.1396F;
                this.Cloth02c3_1.xRot = -0.1396F;
                this.Cloth02c4.xRot = 0F;
                this.Cloth02c4_1.xRot = 0F;
                this.Cloth02a2.xRot = 0.1745F;
                this.Cloth02b2.xRot = 0.1745F;
                this.Cloth02a3.xRot = 0F;
                this.Cloth02b3.xRot = 0F;
                // this.ClothA03.offsetY = 0F;
                // this.ClothA04.offsetY = 0F;
                // this.ClothA05.offsetY = 0F;
                // this.ClothA03.offsetZ = 0F;
                // this.ClothA04.offsetZ = 0F;
                // this.ClothA05.offsetZ = 0F;
                // this.ClothA03a.offsetY = 0F;
                // this.ClothA04a.offsetY = 0F;
                // this.ClothA05a.offsetY = 0F;
                // this.ClothA03a.offsetZ = 0F;
                // this.ClothA04a.offsetZ = 0F;
                // this.ClothA05a.offsetZ = 0F;
                // hair
                this.Ahoke.zRot = 0.087F;
                // arm
                this.ArmLeft01.xRot = -2.8F;
                this.ArmLeft01.yRot = 0.1F;
                this.ArmLeft01.zRot = 0.84F;
                this.ArmLeft02.xRot = 0F;
                this.ArmLeft02.zRot = 1.0F;
                // this.ArmLeft02.offsetX = 0F;
                // this.ArmLeft02.offsetZ = 0F;
                this.ArmRight01.xRot = 0F;
                this.ArmRight01.yRot = 0F;
                this.ArmRight01.zRot = 0.2F;
                this.ArmRight02.xRot = 0F;
                this.ArmRight02.zRot = 0F;
                // this.ArmRight02.offsetX = 0F;
                // this.ArmRight02.offsetZ = 0F;
                // leg
                this.LegLeft01.xRot = -0.12F;
                this.LegLeft01.yRot = 0F;
                this.LegLeft01.zRot = -0.05F;
                // this.LegLeft01.offsetY = 0F;
                // this.LegLeft01.offsetZ = 0F;
                this.LegLeft02.xRot = 0F;
                this.LegLeft02.yRot = 0F;
                this.LegLeft02.zRot = 0F;
                // this.LegLeft02.offsetX = 0F;
                // this.LegLeft02.offsetY = 0F;
                // this.LegLeft02.offsetZ = 0F;
                this.LegRight01.xRot = -0.12F;
                this.LegRight01.yRot = 0F;
                this.LegRight01.zRot = 0.26F;
                // this.LegRight01.offsetY = 0F;
                // this.LegRight01.offsetZ = 0F;
                this.LegRight02.xRot = 0F;
                this.LegRight02.yRot = 0F;
                this.LegRight02.zRot = -0.4F;
                // this.LegRight02.offsetX = 0F;
                // this.LegRight02.offsetY = 0F;
                // this.LegRight02.offsetZ = 0F;
                // equip
                this.EquipBase.visible = false;
        }

        @Override
        public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

                float angleX = Mth.cos(f2 * 0.08F + f * 0.25F);
                float angleX1 = Mth.cos(f2 * 0.1F + 0.35F + f * 0.5F);
                float angleX2 = Mth.cos(f2 * 0.1F + 0.70F + f * 0.5F);
                float angleX3 = Mth.cos(f2 * 0.1F + 1.05F + f * 0.5F);
                float angleX4 = Mth.cos(f2 * 0.1F + 1.40F + f * 0.5F);
                float angleAdd1 = Mth.cos(f * 0.7F) * f1;
                float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
                float addk1 = 0;
                float addk2 = 0;
                float t2 = ent.getTickExisted() & 511;
                boolean spcStand = ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED;

                // 水上漂浮
                if (ent.getShipDepth(0) > 0D) {
                }

                // leg move
                addk1 = angleAdd1 * 0.3F - 0.28F; // LegLeft01
                addk2 = angleAdd2 * 0.3F - 0.21F; // LegRight01

                // head
                this.Head.xRot = f4 * 0.014F;
                this.Head.yRot = f3 * 0.01F;
                this.Ahoke.zRot = angleX * 0.08F + 0.05F;
                // boob
                this.BoobL.xRot = angleX * 0.06F - 0.8F;
                this.BoobR.xRot = angleX * 0.06F - 0.8F;
                this.ClothB01.xRot = 0.96F - angleX * 0.08F;
                // this.EquipGlass01.offsetZ = 0.06F;
                // body
                this.BodyMain.xRot = -0.1047F;
                this.BodyMain.yRot = 0F;
                this.BodyMain.zRot = 0F;
                this.Butt.xRot = 0.35F;
                // this.Butt.offsetY = 0F;
                // this.Butt.offsetZ = 0F;
                this.Skirt01.xRot = -0.087F;
                this.Skirt02.xRot = -0.087F;
                // this.Skirt01.offsetY = 0F;
                // this.Skirt01.offsetZ = 0F;
                // cloth
                this.ClothA03.yRot = 0F;
                this.ClothA03a.yRot = 0F;
                this.SkirtB01.xRot = 0.087F;
                this.Cloth02a1.xRot = -0.5585F;
                this.Cloth02b1.xRot = -0.5585F;
                this.Cloth02c1.xRot = 0.6283F;
                this.Cloth02c1_1.xRot = 0.6283F;
                this.Cloth02c2.xRot = -0.7854F;
                this.Cloth02c2_1.xRot = -0.7854F;
                this.Cloth02c3.xRot = -0.1396F + angleX1 * 0.06F;
                this.Cloth02c3_1.xRot = -0.1396F + angleX1 * 0.06F;
                this.Cloth02c4.xRot = -angleX2 * 0.06F;
                this.Cloth02c4_1.xRot = -angleX2 * 0.06F;
                this.Cloth02a2.xRot = 0.12F + angleX1 * 0.06F;
                this.Cloth02b2.xRot = 0.12F + angleX1 * 0.06F;
                this.Cloth02a3.xRot = -angleX2 * 0.06F;
                this.Cloth02b3.xRot = -angleX2 * 0.06F;
                // this.ClothA03.offsetX = 0F;
                // this.ClothA03.offsetY = 0F;
                // this.ClothA03.offsetZ = 0F;
                // this.ClothA04.offsetY = 0F;
                // this.ClothA04.offsetZ = 0F;
                // this.ClothA05.offsetY = 0F;
                // this.ClothA05.offsetZ = 0F;
                // this.ClothA03a.offsetX = 0F;
                // this.ClothA03a.offsetY = 0F;
                // this.ClothA03a.offsetZ = 0F;
                // this.ClothA04a.offsetY = 0F;
                // this.ClothA04a.offsetZ = 0F;
                // this.ClothA05a.offsetY = 0F;
                // this.ClothA05a.offsetZ = 0F;
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
                // this.LegLeft01.offsetY = 0F;
                // this.LegLeft01.offsetZ = 0F;
                this.LegLeft02.xRot = 0F;
                this.LegLeft02.yRot = 0F;
                this.LegLeft02.zRot = 0F;
                // this.LegLeft02.offsetX = 0F;
                // this.LegLeft02.offsetY = 0F;
                // this.LegLeft02.offsetZ = 0F;
                this.LegRight01.yRot = 0F;
                this.LegRight01.zRot = -0.0873F;
                // this.LegRight01.offsetY = 0F;
                // this.LegRight01.offsetZ = 0F;
                this.LegRight02.xRot = 0F;
                this.LegRight02.yRot = 0F;
                this.LegRight02.zRot = 0F;
                // this.LegRight02.offsetX = 0F;
                // this.LegRight02.offsetY = 0F;
                // this.LegRight02.offsetZ = 0F;
                // equip
                this.EquipCL1a1.xRot = this.Head.xRot * 0.8F - 0.21F;
                this.EquipCL1a1_1.xRot = this.Head.xRot * 0.7F - 0.23F;
                this.EquipCL1a1_2.xRot = this.Head.xRot * 0.85F - 0.20F;
                this.EquipCL1a1_3.xRot = this.Head.xRot * 0.75F - 0.25F;
                this.EquipCL1a1_4.xRot = this.Head.xRot * 0.8F - 0.20F;
                this.EquipCL1a1_5.xRot = this.Head.xRot * 0.85F - 0.19F;
                this.EquipCL1a1_6.xRot = this.Head.xRot * 0.75F - 0.21F;
                this.EquipCL1a1_7.xRot = this.Head.xRot * 0.88F - 0.19F;
                this.EquipD03c1.zRot = -0.35F + this.Head.xRot * 0.5F;
                this.EquipD03c2.zRot = -0.26F + this.Head.xRot * 0.5F;
                this.EquipD03c3.zRot = 0.61F - this.Head.xRot * 1F;
                this.EquipD03d1.zRot = -this.EquipD03c1.zRot;
                this.EquipD03c2_1.zRot = this.EquipD03c2.zRot;
                this.EquipD03c3_1.zRot = this.EquipD03c3.zRot;
                this.EquipD03a1.zRot = 0.52F + this.Head.xRot * 0.5F;
                this.EquipD03b1.zRot = -this.EquipD03a1.zRot;
                this.EquipCL1Base01L1.yRot = this.Head.yRot * 0.75F;
                this.EquipCL1Base01L2.yRot = this.Head.yRot * 0.75F;
                this.EquipCL1Base01R1.yRot = this.Head.yRot * 0.75F;
                this.EquipCL1Base01R2.yRot = this.Head.yRot * 0.75F;

                // run
                if (ent.getIsSprinting() || f1 > 0.9F) {
                        // no pose
                }

                // head tilt angle
                this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

                // sneak
                if (ent.getIsSneaking()) {
                        spcStand = false;

                        switch (ent.getScaleLevel()) {
                                case 3:
                                        break;
                                case 2:
                                        break;
                                case 1:
                                        break;
                                default:
                                        break;
                        }

                        // Body
                        this.Head.xRot -= 0.6283F;
                        this.BodyMain.xRot = 0.8727F;
                        this.Skirt01.xRot = -0.34F;
                        // this.Skirt01.offsetY = -0.2F;
                        // this.Skirt01.offsetZ = 0.03F;
                        this.Skirt02.xRot = -0.27F;
                        this.Cloth02a1.xRot = -1.23F;
                        this.Cloth02b1.xRot = -1.23F;
                        this.Cloth02c2.xRot -= 0.35F;
                        this.Cloth02c2_1.xRot -= 0.35F;
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
                } // end if sneaking

                // sit
                if (ent.getIsSitting() || ent.getIsRiding()) {
                        spcStand = false;

                        if (ent.getTickExisted() % 512 > 256) {
                                switch (ent.getScaleLevel()) {
                                        case 3:
                                                break;
                                        case 2:
                                                break;
                                        case 1:
                                                break;
                                        default:
                                                break;
                                }

                                this.setFaceScorn(ent);

                                // Body
                                this.Head.xRot += 0.1F;
                                this.BodyMain.xRot = -0.1F;
                                this.Butt.xRot = -0.4F;
                                // this.Butt.offsetZ = 0.19F;
                                this.Skirt01.xRot = -0.35F;
                                this.Skirt02.xRot = -0.19F;
                                this.Cloth02a1.xRot = 0.2F;
                                this.Cloth02b1.xRot = 0.2F;
                                this.Cloth02c1.xRot = 1.5F;
                                this.Cloth02c2.xRot = 0.35F;
                                this.Cloth02c3.xRot = 0.05F;
                                this.Cloth02c4.xRot = 0.0F;
                                this.Cloth02c1_1.xRot = 1.5F;
                                this.Cloth02c2_1.xRot = 0.35F;
                                this.Cloth02c3_1.xRot = 0.05F;
                                this.Cloth02c4_1.xRot = 0.0F;
                                this.ClothA03.yRot = 0.2F;
                                this.ClothA03a.yRot = -0.2F;
                                // arm
                                this.ArmLeft01.xRot = -1.18F;
                                this.ArmLeft01.yRot = 0.27F;
                                this.ArmLeft01.zRot = -0.1F;
                                this.ArmLeft02.zRot = 0.92F;
                                this.ArmRight01.xRot = -1.18F;
                                this.ArmRight01.yRot = -0.27F;
                                this.ArmRight01.zRot = 0.1F;
                                this.ArmRight02.zRot = -1.32F;
                                // leg
                                addk1 = -2.57F;
                                addk2 = -2.57F;
                                // this.LegLeft01.offsetY = 0.25F;
                                // this.LegLeft01.offsetZ = -0.2F;
                                this.LegLeft01.yRot = 0.11F;
                                this.LegLeft01.zRot = -0.12F;
                                this.LegLeft02.xRot = 2.75F;
                                this.LegLeft02.zRot = 0.02F;
                                // this.LegLeft02.offsetZ = 0.37F;
                                // this.LegRight01.offsetY = 0.25F;
                                // this.LegRight01.offsetZ = -0.2F;
                                this.LegRight01.yRot = -0.11F;
                                this.LegRight01.zRot = 0.12F;
                                this.LegRight02.xRot = 2.75F;
                                this.LegRight02.zRot = -0.02F;
                                // this.LegRight02.offsetZ = 0.37F;
                        } else {
                                switch (ent.getScaleLevel()) {
                                        case 3:
                                                break;
                                        case 2:
                                                break;
                                        case 1:
                                                break;
                                        default:
                                                break;
                                }

                                // Body
                                this.Head.xRot += 0.14F;
                                this.BodyMain.xRot = -0.4363F;
                                // cloth
                                this.Skirt01.xRot = -0.35F;
                                this.Skirt02.xRot = -0.19F;
                                this.SkirtB01.xRot = -0.12F;
                                this.Cloth02a2.xRot += 0.32F;
                                this.Cloth02a3.xRot += 0.4F;
                                this.Cloth02b2.xRot += 0.32F;
                                this.Cloth02b3.xRot += 0.4F;
                                this.Cloth02c1.xRot += 0.45F;
                                this.Cloth02c2.xRot += 0.1F;
                                this.Cloth02c1_1.xRot += 0.45F;
                                this.Cloth02c2_1.xRot += 0.1F;
                                this.ClothA03.yRot = 1.49F;
                                this.ClothA03a.yRot = -1.33F;
                                // arm
                                this.ArmLeft01.xRot = -0.3142F;
                                this.ArmLeft01.zRot = 0.3490F;
                                this.ArmLeft02.zRot = 1.15F;
                                this.ArmRight01.xRot = -0.4363F;
                                this.ArmRight01.zRot = -0.2793F;
                                this.ArmRight02.zRot = -1.4F;
                                // leg
                                addk1 = -1.3090F;
                                addk2 = -1.7F;
                                this.LegLeft01.yRot = 0.3142F;
                                this.LegLeft02.xRot = 1.0472F;
                                this.LegRight01.yRot = -0.35F;
                                this.LegRight01.zRot = -0.2618F;
                                this.LegRight02.xRot = 0.9F;
                        }
                } // end if sitting

                // attack
                if (ent.getAttackTick() > 20) {
                        // Body
                        this.Head.yRot *= 0.25F;
                        this.BodyMain.xRot = -0.17F;
                        // arm
                        this.ArmLeft01.xRot = -0.35F;
                        this.ArmLeft01.yRot = 0.0F;
                        this.ArmLeft01.zRot = 0.2F;
                        this.ArmLeft02.xRot = 0.0F;
                        this.ArmLeft02.yRot = 0.0F;
                        this.ArmLeft02.zRot = 1.3F;
                        this.ArmRight01.xRot = -0.5462880558742251F;
                        this.ArmRight01.yRot = -0.2617993877991494F;
                        this.ArmRight01.zRot = -0.13962634015954636F;
                        this.ArmRight02.xRot = -2.4F;
                        this.ArmRight02.zRot = 0.0F;
                        // this.ArmRight02.offsetZ = -0.32F;
                        this.ClothA03.yRot = 1.49F;
                        // leg
                        addk1 += 0.14F;
                        addk2 += 0.07F;
                        this.LegLeft01.yRot = 0F;
                        this.LegLeft01.zRot = -0.1F;
                        this.LegRight01.yRot = 0F;
                        this.LegRight01.zRot = 0.1F;
                }

                // special stand pose
                if (spcStand) {
                        // Body
                        this.Head.yRot *= 0.25F;
                        this.BodyMain.xRot = -0.17F;
                        // arm
                        this.ArmLeft01.xRot = -0.35F;
                        this.ArmLeft01.yRot = 0.0F;
                        this.ArmLeft01.zRot = 0.2F;
                        this.ArmLeft02.xRot = 0.0F;
                        this.ArmLeft02.yRot = 0.0F;
                        this.ArmLeft02.zRot = 1.3F;
                        this.ArmRight01.xRot = -0.5462880558742251F;
                        this.ArmRight01.yRot = -0.2617993877991494F;
                        this.ArmRight01.zRot = -0.13962634015954636F;
                        this.ArmRight02.xRot = -2.4F;
                        this.ArmRight02.zRot = 0.0F;
                        // this.ArmRight02.offsetZ = -0.32F;
                        this.ClothA03.yRot = 1.49F;
                        // leg
                        addk1 += 0.14F;
                        addk2 += 0.07F;
                        this.LegLeft01.yRot = 0F;
                        this.LegLeft01.zRot = -0.1F;
                        this.LegRight01.yRot = 0F;
                        this.LegRight01.zRot = 0.1F;

                        if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED) {
                                this.setFace(2);
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
                }

                // sleeves
                float HandL = this.BodyMain.xRot + this.ArmLeft01.xRot + this.ArmLeft02.xRot;
                float HandR = this.BodyMain.xRot + this.ArmRight01.xRot + this.ArmRight02.xRot;
                float HandLc = Mth.cos(HandL);
                float HandLs = Mth.sin(HandL);
                float HandRc = Mth.cos(HandR);
                float HandRs = Mth.sin(HandR);
                // this.ClothA03.offsetY = HandLc * 0.1F;
                // this.ClothA04.offsetY = HandLc * 0.2F;
                // this.ClothA05.offsetY = HandLc * 0.25F;
                // this.ClothA03.offsetZ = HandLs * -0.32F;
                // this.ClothA04.offsetZ = HandLs * -0.32F;
                // this.ClothA05.offsetZ = HandLs * -0.32F;
                // this.ClothA03a.offsetY = HandRc * 0.1F;
                // this.ClothA04a.offsetY = HandRc * 0.2F;
                // this.ClothA05a.offsetY = HandRc * 0.25F;
                // this.ClothA03a.offsetZ = HandRs * -0.32F;
                // this.ClothA04a.offsetZ = HandRs * -0.32F;
                // this.ClothA05a.offsetZ = HandRs * -0.32F;

                // leg motion
                this.LegLeft01.xRot = addk1;
                this.LegRight01.xRot = addk2;
        }
}
