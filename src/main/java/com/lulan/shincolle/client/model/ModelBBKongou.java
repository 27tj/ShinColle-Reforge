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

public class ModelBBKongou extends ShipModelBaseAdv<Entity> {

        public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
                        new ResourceLocation(Reference.MOD_ID, "bb_kongou"), "main");

        private final ModelPart BodyMain;
        private final ModelPart Neck;
        private final ModelPart Butt;
        private final ModelPart Ahoke00;
        private final ModelPart ArmLeft01;
        private final ModelPart BoobR;
        private final ModelPart BoobL;
        private final ModelPart ArmRight01;
        private final ModelPart EquipBase;
        private final ModelPart Cloth03a1;
        private final ModelPart Cloth03a2;
        private final ModelPart Head;
        private final ModelPart Hair;
        private final ModelPart HairMain;
        private final ModelPart Ahoke01;
        private final ModelPart EquipHeadBase;
        private final ModelPart HairU01;
        private final ModelPart HairR01;
        private final ModelPart HairL01;
        private final ModelPart HairCBase;
        private final ModelPart HairCBaseB;
        private final ModelPart HairS01;
        private final ModelPart HairS02;
        private final ModelPart HairR02;
        private final ModelPart HairL02;
        private final ModelPart HairC01;
        private final ModelPart HairC02;
        private final ModelPart HairC03;
        private final ModelPart HairC04;
        private final ModelPart HairC05;
        private final ModelPart HairC01b;
        private final ModelPart HairC02b;
        private final ModelPart HairC03b;
        private final ModelPart HairC04b;
        private final ModelPart HairC05b;
        private final ModelPart Hair01;
        private final ModelPart Hair02;
        private final ModelPart Ahoke02;
        private final ModelPart Ahoke03;
        private final ModelPart Ahoke04;
        private final ModelPart EquipHead01;
        private final ModelPart EquipHead01a;
        private final ModelPart EquipHead02;
        private final ModelPart EquipHead03;
        private final ModelPart EquipHead02a;
        private final ModelPart EquipHead03a;
        private final ModelPart LegLeft01;
        private final ModelPart Skirt01;
        private final ModelPart LegRight01;
        private final ModelPart SkirtB01;
        private final ModelPart LegLeft02;
        private final ModelPart Skirt02;
        private final ModelPart LegRight02;
        private final ModelPart Cloth01a;
        private final ModelPart Cloth02a1;
        private final ModelPart Cloth02b1;
        private final ModelPart Cloth02c1;
        private final ModelPart Cloth02c1_1;
        private final ModelPart Cloth01b;
        private final ModelPart Cloth01c;
        private final ModelPart Cloth01b2;
        private final ModelPart Cloth01c2;
        private final ModelPart Cloth02a2;
        private final ModelPart Cloth02a3;
        private final ModelPart Cloth02b2;
        private final ModelPart Cloth02b3;
        private final ModelPart Cloth02c2;
        private final ModelPart Cloth02c3;
        private final ModelPart Cloth02c4;
        private final ModelPart Cloth02c2_1;
        private final ModelPart Cloth02c3_1;
        private final ModelPart Cloth02c4_1;
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
        private final ModelPart EquipB01;
        private final ModelPart EquipB00a;
        private final ModelPart EquipB00a_1;
        private final ModelPart EquipB02;
        private final ModelPart EquipB01a;
        private final ModelPart EquipB01b00;
        private final ModelPart EquipB04;
        private final ModelPart EquipB04_1;
        private final ModelPart EquipB03;
        private final ModelPart EquipB02a;
        private final ModelPart EquipB01c;
        private final ModelPart EquipB01b01a;
        private final ModelPart EquipB01b01b;
        private final ModelPart EquipB01b01c;
        private final ModelPart EquipB01b02;
        private final ModelPart EquipB01b03;
        private final ModelPart EquipB01b04;
        private final ModelPart EquipB01b05;
        private final ModelPart EquipB01b06;
        private final ModelPart EquipB05;
        private final ModelPart EquipB06a;
        private final ModelPart EquipB06b;
        private final ModelPart EquipB06c;
        private final ModelPart EquipB06d;
        private final ModelPart EquipB06e;
        private final ModelPart EquipB06f;
        private final ModelPart EquipCL1Base01;
        private final ModelPart EquipCL1Base02;
        private final ModelPart EquipCL1a1;
        private final ModelPart EquipCL1a1_1;
        private final ModelPart EquipCL1a2;
        private final ModelPart EquipCL1a2_1;
        private final ModelPart EquipB05_1;
        private final ModelPart EquipB07a1;
        private final ModelPart EquipB07b1;
        private final ModelPart EquipB07c1;
        private final ModelPart EquipB07d1;
        private final ModelPart EquipCL1Base01_1;
        private final ModelPart EquipCL1Base02_1;
        private final ModelPart EquipCL1a1_2;
        private final ModelPart EquipCL1a1_3;
        private final ModelPart EquipCL1a2_2;
        private final ModelPart EquipCL1a2_3;
        private final ModelPart EquipB07a2;
        private final ModelPart EquipB07b2;
        private final ModelPart EquipB07c2;
        private final ModelPart EquipB07d2;
        private final ModelPart EquipB07d3;
        private final ModelPart EquipB05_2;
        private final ModelPart EquipB06a_1;
        private final ModelPart EquipB06b_1;
        private final ModelPart EquipB06c_1;
        private final ModelPart EquipB06d_1;
        private final ModelPart EquipB06e_1;
        private final ModelPart EquipB06f_1;
        private final ModelPart EquipCL1Base01_2;
        private final ModelPart EquipCL1Base02_2;
        private final ModelPart EquipCL1a1_4;
        private final ModelPart EquipCL1a1_5;
        private final ModelPart EquipCL1a2_4;
        private final ModelPart EquipCL1a2_5;
        private final ModelPart EquipB05_3;
        private final ModelPart EquipB07a1_1;
        private final ModelPart EquipB07b1_1;
        private final ModelPart EquipB07c1_1;
        private final ModelPart EquipB07d1_1;
        private final ModelPart EquipCL1Base01_3;
        private final ModelPart EquipCL1Base02_3;
        private final ModelPart EquipCL1a1_6;
        private final ModelPart EquipCL1a1_7;
        private final ModelPart EquipCL1a2_6;
        private final ModelPart EquipCL1a2_7;
        private final ModelPart EquipB07a2_1;
        private final ModelPart EquipB07b2_1;
        private final ModelPart EquipB07c2_1;
        private final ModelPart EquipB07d2_1;
        private final ModelPart EquipB07d3_1;
        private final ModelPart EquipB00b;
        private final ModelPart EquipB00c;
        private final ModelPart EquipB00d;
        private final ModelPart EquipB00b_1;
        private final ModelPart EquipB00c_1;
        private final ModelPart EquipB00d_1;
        private final ModelPart GlowBodyMain;
        private final ModelPart GlowHead;
        private final ModelPart GlowNeck;

        public ModelBBKongou(ModelPart root) {
                super();
                this.BodyMain = root.getChild("BodyMain");
                this.BoobL = this.BodyMain.getChild("BoobL");
                this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
                this.Cloth03a1 = this.BodyMain.getChild("Cloth03a1");
                this.EquipBase = this.BodyMain.getChild("EquipBase");
                this.Cloth03a2 = this.BodyMain.getChild("Cloth03a2");
                this.BoobR = this.BodyMain.getChild("BoobR");
                this.Butt = this.BodyMain.getChild("Butt");
                this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
                this.Neck = this.BodyMain.getChild("Neck");
                this.Cloth03b_1 = this.BoobL.getChild("Cloth03b_1");
                this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
                this.ClothA01_1 = this.ArmRight01.getChild("ClothA01_1");
                this.EquipB01 = this.EquipBase.getChild("EquipB01");
                this.EquipB00a = this.EquipBase.getChild("EquipB00a");
                this.EquipB00a_1 = this.EquipBase.getChild("EquipB00a_1");
                this.ClothB01 = this.BoobR.getChild("ClothB01");
                this.Cloth03b = this.BoobR.getChild("Cloth03b");
                this.LegRight01 = this.Butt.getChild("LegRight01");
                this.LegLeft01 = this.Butt.getChild("LegLeft01");
                this.SkirtB01 = this.Butt.getChild("SkirtB01");
                this.Skirt01 = this.Butt.getChild("Skirt01");
                this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
                this.ClothA01 = this.ArmLeft01.getChild("ClothA01");
                this.Head = this.Neck.getChild("Head");
                this.ClothA02a = this.ArmRight02.getChild("ClothA02a");
                this.EquipB01b00 = this.EquipB01.getChild("EquipB01b00");
                this.EquipB01a = this.EquipB01.getChild("EquipB01a");
                this.EquipB02 = this.EquipB01.getChild("EquipB02");
                this.EquipB04_1 = this.EquipB01.getChild("EquipB04_1");
                this.EquipB04 = this.EquipB01.getChild("EquipB04");
                this.EquipB00b = this.EquipB00a.getChild("EquipB00b");
                this.EquipB00b_1 = this.EquipB00a_1.getChild("EquipB00b_1");
                this.LegRight02 = this.LegRight01.getChild("LegRight02");
                this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
                this.Cloth02b1 = this.SkirtB01.getChild("Cloth02b1");
                this.Cloth01a = this.SkirtB01.getChild("Cloth01a");
                this.Cloth02a1 = this.SkirtB01.getChild("Cloth02a1");
                this.Cloth02c1 = this.SkirtB01.getChild("Cloth02c1");
                this.Cloth02c1_1 = this.SkirtB01.getChild("Cloth02c1_1");
                this.Skirt02 = this.Skirt01.getChild("Skirt02");
                this.ClothA02 = this.ArmLeft02.getChild("ClothA02");
                this.Hair = this.Head.getChild("Hair");
                this.EquipHeadBase = this.Head.getChild("EquipHeadBase");
                this.HairMain = this.Head.getChild("HairMain");
                this.Ahoke00 = this.Head.getChild("Ahoke00");
                this.Ahoke01 = this.Head.getChild("Ahoke01");
                this.ClothA03a = this.ClothA02a.getChild("ClothA03a");
                this.EquipB01b01b = this.EquipB01b00.getChild("EquipB01b01b");
                this.EquipB01b02 = this.EquipB01b00.getChild("EquipB01b02");
                this.EquipB01b01a = this.EquipB01b00.getChild("EquipB01b01a");
                this.EquipB01b05 = this.EquipB01b00.getChild("EquipB01b05");
                this.EquipB01b06 = this.EquipB01b00.getChild("EquipB01b06");
                this.EquipB01b04 = this.EquipB01b00.getChild("EquipB01b04");
                this.EquipB01b01c = this.EquipB01b00.getChild("EquipB01b01c");
                this.EquipB01b03 = this.EquipB01b00.getChild("EquipB01b03");
                this.EquipB01c = this.EquipB01a.getChild("EquipB01c");
                this.EquipB02a = this.EquipB02.getChild("EquipB02a");
                this.EquipB03 = this.EquipB02.getChild("EquipB03");
                this.EquipB06b_1 = this.EquipB04_1.getChild("EquipB06b_1");
                this.EquipB05_2 = this.EquipB04_1.getChild("EquipB05_2");
                this.EquipB06e_1 = this.EquipB04_1.getChild("EquipB06e_1");
                this.EquipB06d_1 = this.EquipB04_1.getChild("EquipB06d_1");
                this.EquipB06a_1 = this.EquipB04_1.getChild("EquipB06a_1");
                this.EquipB06f_1 = this.EquipB04_1.getChild("EquipB06f_1");
                this.EquipB06c_1 = this.EquipB04_1.getChild("EquipB06c_1");
                this.EquipB05 = this.EquipB04.getChild("EquipB05");
                this.EquipB06e = this.EquipB04.getChild("EquipB06e");
                this.EquipB06d = this.EquipB04.getChild("EquipB06d");
                this.EquipB06a = this.EquipB04.getChild("EquipB06a");
                this.EquipB06b = this.EquipB04.getChild("EquipB06b");
                this.EquipB06c = this.EquipB04.getChild("EquipB06c");
                this.EquipB06f = this.EquipB04.getChild("EquipB06f");
                this.EquipB00c = this.EquipB00b.getChild("EquipB00c");
                this.EquipB00c_1 = this.EquipB00b_1.getChild("EquipB00c_1");
                this.Cloth02b2 = this.Cloth02b1.getChild("Cloth02b2");
                this.Cloth01c2 = this.Cloth01a.getChild("Cloth01c2");
                this.Cloth01b2 = this.Cloth01a.getChild("Cloth01b2");
                this.Cloth01c = this.Cloth01a.getChild("Cloth01c");
                this.Cloth01b = this.Cloth01a.getChild("Cloth01b");
                this.Cloth02a2 = this.Cloth02a1.getChild("Cloth02a2");
                this.Cloth02c2 = this.Cloth02c1.getChild("Cloth02c2");
                this.Cloth02c2_1 = this.Cloth02c1_1.getChild("Cloth02c2_1");
                this.ClothA03 = this.ClothA02.getChild("ClothA03");
                this.HairU01 = this.Hair.getChild("HairU01");
                this.HairS01 = this.Hair.getChild("HairS01");
                this.HairCBase = this.Hair.getChild("HairCBase");
                this.HairL01 = this.Hair.getChild("HairL01");
                this.HairR01 = this.Hair.getChild("HairR01");
                this.HairCBaseB = this.Hair.getChild("HairCBaseB");
                this.HairS02 = this.Hair.getChild("HairS02");
                this.EquipHead01a = this.EquipHeadBase.getChild("EquipHead01a");
                this.EquipHead01 = this.EquipHeadBase.getChild("EquipHead01");
                this.Hair01 = this.HairMain.getChild("Hair01");
                this.Ahoke02 = this.Ahoke01.getChild("Ahoke02");
                this.ClothA04a = this.ClothA03a.getChild("ClothA04a");
                this.EquipCL1Base01_2 = this.EquipB05_2.getChild("EquipCL1Base01_2");
                this.EquipB05_3 = this.EquipB06d_1.getChild("EquipB05_3");
                this.EquipB07a1_1 = this.EquipB06d_1.getChild("EquipB07a1_1");
                this.EquipB07d1_1 = this.EquipB06d_1.getChild("EquipB07d1_1");
                this.EquipB07c1_1 = this.EquipB06d_1.getChild("EquipB07c1_1");
                this.EquipB07b1_1 = this.EquipB06d_1.getChild("EquipB07b1_1");
                this.EquipCL1Base01 = this.EquipB05.getChild("EquipCL1Base01");
                this.EquipB05_1 = this.EquipB06d.getChild("EquipB05_1");
                this.EquipB07c1 = this.EquipB06d.getChild("EquipB07c1");
                this.EquipB07d1 = this.EquipB06d.getChild("EquipB07d1");
                this.EquipB07b1 = this.EquipB06d.getChild("EquipB07b1");
                this.EquipB07a1 = this.EquipB06d.getChild("EquipB07a1");
                this.EquipB00d = this.EquipB00c.getChild("EquipB00d");
                this.EquipB00d_1 = this.EquipB00c_1.getChild("EquipB00d_1");
                this.Cloth02b3 = this.Cloth02b2.getChild("Cloth02b3");
                this.Cloth02a3 = this.Cloth02a2.getChild("Cloth02a3");
                this.Cloth02c3 = this.Cloth02c2.getChild("Cloth02c3");
                this.Cloth02c3_1 = this.Cloth02c2_1.getChild("Cloth02c3_1");
                this.ClothA04 = this.ClothA03.getChild("ClothA04");
                this.HairC01 = this.HairCBase.getChild("HairC01");
                this.HairL02 = this.HairL01.getChild("HairL02");
                this.HairR02 = this.HairR01.getChild("HairR02");
                this.HairC01b = this.HairCBaseB.getChild("HairC01b");
                this.EquipHead03a = this.EquipHead01a.getChild("EquipHead03a");
                this.EquipHead02a = this.EquipHead01a.getChild("EquipHead02a");
                this.EquipHead03 = this.EquipHead01.getChild("EquipHead03");
                this.EquipHead02 = this.EquipHead01.getChild("EquipHead02");
                this.Hair02 = this.Hair01.getChild("Hair02");
                this.Ahoke03 = this.Ahoke02.getChild("Ahoke03");
                this.ClothA05a = this.ClothA04a.getChild("ClothA05a");
                this.EquipCL1a1_4 = this.EquipCL1Base01_2.getChild("EquipCL1a1_4");
                this.EquipCL1Base02_2 = this.EquipCL1Base01_2.getChild("EquipCL1Base02_2");
                this.EquipCL1a1_5 = this.EquipCL1Base01_2.getChild("EquipCL1a1_5");
                this.EquipCL1Base01_3 = this.EquipB05_3.getChild("EquipCL1Base01_3");
                this.EquipB07a2_1 = this.EquipB07a1_1.getChild("EquipB07a2_1");
                this.EquipB07d3_1 = this.EquipB07d1_1.getChild("EquipB07d3_1");
                this.EquipB07d2_1 = this.EquipB07d1_1.getChild("EquipB07d2_1");
                this.EquipB07c2_1 = this.EquipB07c1_1.getChild("EquipB07c2_1");
                this.EquipB07b2_1 = this.EquipB07b1_1.getChild("EquipB07b2_1");
                this.EquipCL1Base02 = this.EquipCL1Base01.getChild("EquipCL1Base02");
                this.EquipCL1a1_1 = this.EquipCL1Base01.getChild("EquipCL1a1_1");
                this.EquipCL1a1 = this.EquipCL1Base01.getChild("EquipCL1a1");
                this.EquipCL1Base01_1 = this.EquipB05_1.getChild("EquipCL1Base01_1");
                this.EquipB07c2 = this.EquipB07c1.getChild("EquipB07c2");
                this.EquipB07d3 = this.EquipB07d1.getChild("EquipB07d3");
                this.EquipB07d2 = this.EquipB07d1.getChild("EquipB07d2");
                this.EquipB07b2 = this.EquipB07b1.getChild("EquipB07b2");
                this.EquipB07a2 = this.EquipB07a1.getChild("EquipB07a2");
                this.Cloth02c4 = this.Cloth02c3.getChild("Cloth02c4");
                this.Cloth02c4_1 = this.Cloth02c3_1.getChild("Cloth02c4_1");
                this.ClothA05 = this.ClothA04.getChild("ClothA05");
                this.HairC02 = this.HairC01.getChild("HairC02");
                this.HairC02b = this.HairC01b.getChild("HairC02b");
                this.Ahoke04 = this.Ahoke03.getChild("Ahoke04");
                this.EquipCL1a2_4 = this.EquipCL1a1_4.getChild("EquipCL1a2_4");
                this.EquipCL1a2_5 = this.EquipCL1a1_5.getChild("EquipCL1a2_5");
                this.EquipCL1Base02_3 = this.EquipCL1Base01_3.getChild("EquipCL1Base02_3");
                this.EquipCL1a1_7 = this.EquipCL1Base01_3.getChild("EquipCL1a1_7");
                this.EquipCL1a1_6 = this.EquipCL1Base01_3.getChild("EquipCL1a1_6");
                this.EquipCL1a2_1 = this.EquipCL1a1_1.getChild("EquipCL1a2_1");
                this.EquipCL1a2 = this.EquipCL1a1.getChild("EquipCL1a2");
                this.EquipCL1a1_2 = this.EquipCL1Base01_1.getChild("EquipCL1a1_2");
                this.EquipCL1Base02_1 = this.EquipCL1Base01_1.getChild("EquipCL1Base02_1");
                this.EquipCL1a1_3 = this.EquipCL1Base01_1.getChild("EquipCL1a1_3");
                this.HairC03 = this.HairC02.getChild("HairC03");
                this.HairC03b = this.HairC02b.getChild("HairC03b");
                this.EquipCL1a2_7 = this.EquipCL1a1_7.getChild("EquipCL1a2_7");
                this.EquipCL1a2_6 = this.EquipCL1a1_6.getChild("EquipCL1a2_6");
                this.EquipCL1a2_2 = this.EquipCL1a1_2.getChild("EquipCL1a2_2");
                this.EquipCL1a2_3 = this.EquipCL1a1_3.getChild("EquipCL1a2_3");
                this.HairC04 = this.HairC03.getChild("HairC04");
                this.HairC04b = this.HairC03b.getChild("HairC04b");
                this.HairC05 = this.HairC04.getChild("HairC05");
                this.HairC05b = this.HairC04b.getChild("HairC05b");

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

                PartDefinition boobL = bodyMain.addOrReplaceChild("BoobL",
                                CubeListBuilder.create().texOffs(25, 44)
                                                .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 4.0F),
                                PartPose.offsetAndRotation(3.5F, -8.2F, -3.7F, -0.8726646259971648F,
                                                0.08726646259971647F, 0.06981317007977318F));

                boobL.addOrReplaceChild("Cloth03b_1",
                                CubeListBuilder.create().texOffs(161, 80)
                                                .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 5.0F, 5.0F),
                                PartPose.offsetAndRotation(0.6F, -0.8F, -0.1F, 0.0F, 0.0F, -0.08726646259971647F));

                PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                                CubeListBuilder.create().texOffs(24, 71)
                                                .addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                                PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, -0.08726646259971647F, 0.0F,
                                                0.3141592653589793F));

                PartDefinition armRight02 = armRight01.addOrReplaceChild("ArmRight02",
                                CubeListBuilder.create().texOffs(24, 54)
                                                .addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
                                PartPose.offset(-3.0F, 11.0F, 2.5F));

                PartDefinition clothA02a = armRight02.addOrReplaceChild("ClothA02a",
                                CubeListBuilder.create().texOffs(128, 49)
                                                .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F),
                                PartPose.offset(2.5F, -0.1F, -2.5F));

                PartDefinition clothA03a = clothA02a.addOrReplaceChild("ClothA03a",
                                CubeListBuilder.create().texOffs(128, 65)
                                                .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 9.0F, 6.0F),
                                PartPose.offset(-0.1F, -0.1F, -2.2F));

                PartDefinition clothA04a = clothA03a.addOrReplaceChild("ClothA04a",
                                CubeListBuilder.create().texOffs(128, 81)
                                                .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 6.0F),
                                PartPose.offset(0.0F, 0.9F, 0.8F));

                clothA04a.addOrReplaceChild("ClothA05a",
                                CubeListBuilder.create().texOffs(128, 96)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 6.0F),
                                PartPose.offset(0.0F, 1.9F, 0.8F));

                armRight01.addOrReplaceChild("ClothA01_1",
                                CubeListBuilder.create().texOffs(128, 109)
                                                .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F),
                                PartPose.offset(-0.5F, 5.1F, 0.0F));

                bodyMain.addOrReplaceChild("Cloth03a1",
                                CubeListBuilder.create().texOffs(159, 55)
                                                .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 18.0F, 7.0F),
                                PartPose.offset(4.1F, -11.1F, -4.1F));

                PartDefinition equipBase = bodyMain.addOrReplaceChild("EquipBase",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                                PartPose.offset(0.0F, 6.5F, 9.0F));

                PartDefinition equipB01 = equipBase.addOrReplaceChild("EquipB01",
                                CubeListBuilder.create().texOffs(185, 0)
                                                .addBox(-5.5F, 0.0F, 0.0F, 11.0F, 10.0F, 9.0F),
                                PartPose.offset(0.0F, -2.0F, 0.0F));

                PartDefinition equipB01b00 = equipB01.addOrReplaceChild("EquipB01b00",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                                PartPose.offset(0.0F, 0.1F, 9.8F));

                equipB01b00.addOrReplaceChild("EquipB01b01b",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F),
                                PartPose.offsetAndRotation(1.0F, -7.9F, 0.0F, -0.08726646259971647F, 0.0F,
                                                -0.12217304763960307F));

                equipB01b00.addOrReplaceChild("EquipB01b02",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 1.0F, 4.0F),
                                PartPose.offset(0.0F, -8.7F, 0.6F));

                equipB01b00.addOrReplaceChild("EquipB01b01a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F),
                                PartPose.offsetAndRotation(0.0F, -7.9F, 1.2F, 0.12217304763960307F, 0.0F, 0.0F));

                equipB01b00.addOrReplaceChild("EquipB01b05",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-0.6F, 0.0F, -0.5F, 1.0F, 18.0F, 1.0F),
                                PartPose.offset(0.0F, -33.4F, 0.3F));

                equipB01b00.addOrReplaceChild("EquipB01b06",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-5.5F, 0.0F, 0.0F, 11.0F, 1.0F, 1.0F),
                                PartPose.offset(0.0F, -29.0F, -0.1F));

                equipB01b00.addOrReplaceChild("EquipB01b04",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 1.0F, 3.0F),
                                PartPose.offset(0.0F, -15.5F, 0.5F));

                equipB01b00.addOrReplaceChild("EquipB01b01c",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F),
                                PartPose.offsetAndRotation(-1.0F, -7.9F, 0.0F, -0.08726646259971647F, 0.0F,
                                                0.12217304763960307F));

                equipB01b00.addOrReplaceChild("EquipB01b03",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F),
                                PartPose.offset(0.0F, -14.5F, 0.5F));

                PartDefinition equipB01a = equipB01.addOrReplaceChild("EquipB01a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F),
                                PartPose.offset(0.0F, -3.9F, 4.8F));

                equipB01a.addOrReplaceChild("EquipB01c",
                                CubeListBuilder.create().texOffs(0, 20)
                                                .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F),
                                PartPose.offset(0.0F, -4.9F, 0.5F));

                PartDefinition equipB02 = equipB01.addOrReplaceChild("EquipB02",
                                CubeListBuilder.create().mirror().texOffs(226, 0)
                                                .addBox(-4.5F, 0.0F, 0.0F, 9.0F, 8.0F, 5.0F),
                                PartPose.offset(0.0F, 0.0F, 8.9F));

                equipB02.addOrReplaceChild("EquipB02a",
                                CubeListBuilder.create().texOffs(0, 30)
                                                .addBox(-2.0F, 0.0F, -1.0F, 4.0F, 5.0F, 4.0F),
                                PartPose.offset(0.0F, -4.9F, 4.6F));

                equipB02.addOrReplaceChild("EquipB03",
                                CubeListBuilder.create().mirror().texOffs(185, 20)
                                                .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 4.0F, 6.0F),
                                PartPose.offset(0.0F, 0.0F, 4.9F));

                PartDefinition equipB04_1 = equipB01.addOrReplaceChild("EquipB04_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-5.0F, 0.0F, 0.0F, 5.0F, 4.0F, 12.0F),
                                PartPose.offset(-5.0F, -2.0F, -0.5F));

                equipB04_1.addOrReplaceChild("EquipB06b_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-3.0F, 0.0F, 0.0F, 3.0F, 6.0F, 11.0F),
                                PartPose.offset(-11.4F, 4.0F, 0.5F));

                PartDefinition equipB05_2 = equipB04_1.addOrReplaceChild("EquipB05_2",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, 0.0F, -4.5F, 9.0F, 8.0F, 9.0F),
                                PartPose.offset(-9.4F, -3.8F, 6.0F));

                PartDefinition equipCL1Base01_2 = equipB05_2.addOrReplaceChild("EquipCL1Base01_2",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, -4.0F, -1.5F, 9.0F, 4.0F, 8.0F),
                                PartPose.offsetAndRotation(0.0F, 0.1F, 0.0F, 0.0F, 1.5707963267948966F, 0.0F));

                PartDefinition equipCL1a1_4 = equipCL1Base01_2.addOrReplaceChild("EquipCL1a1_4",
                                CubeListBuilder.create().texOffs(19, 29)
                                                .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                                PartPose.offsetAndRotation(2.0F, -2.3F, -2.5F, -0.20943951023931953F, 0.0F, 0.0F));

                equipCL1a1_4.addOrReplaceChild("EquipCL1a2_4",
                                CubeListBuilder.create().texOffs(151, 67)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));

                equipCL1Base01_2.addOrReplaceChild("EquipCL1Base02_2",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 4.0F),
                                PartPose.offsetAndRotation(0.0F, 0.3F, -2.8F, 0.17453292519943295F, 0.0F, 0.0F));

                PartDefinition equipCL1a1_5 = equipCL1Base01_2.addOrReplaceChild("EquipCL1a1_5",
                                CubeListBuilder.create().texOffs(19, 29)
                                                .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                                PartPose.offsetAndRotation(-2.0F, -2.3F, -2.5F, -0.20943951023931953F, 0.0F, 0.0F));

                equipCL1a1_5.addOrReplaceChild("EquipCL1a2_5",
                                CubeListBuilder.create().texOffs(151, 67)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));

                equipB04_1.addOrReplaceChild("EquipB06e_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 11.0F),
                                PartPose.offset(-25.1F, 4.0F, 0.5F));

                PartDefinition equipB06d_1 = equipB04_1.addOrReplaceChild("EquipB06d_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.0F, 0.0F, 0.0F, 4.0F, 9.0F, 11.0F),
                                PartPose.offset(-17.2F, 4.0F, 0.5F));

                PartDefinition equipB05_3 = equipB06d_1.addOrReplaceChild("EquipB05_3",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, 0.0F, -4.5F, 9.0F, 2.0F, 9.0F),
                                PartPose.offset(-4.8F, -1.9F, 5.0F));

                PartDefinition equipCL1Base01_3 = equipB05_3.addOrReplaceChild("EquipCL1Base01_3",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, -4.0F, -1.5F, 9.0F, 4.0F, 8.0F),
                                PartPose.offset(0.0F, 0.1F, 0.0F));

                equipCL1Base01_3.addOrReplaceChild("EquipCL1Base02_3",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 4.0F),
                                PartPose.offsetAndRotation(0.0F, 0.3F, -2.8F, 0.17453292519943295F, 0.0F, 0.0F));

                PartDefinition equipCL1a1_7 = equipCL1Base01_3.addOrReplaceChild("EquipCL1a1_7",
                                CubeListBuilder.create().texOffs(19, 29)
                                                .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                                PartPose.offsetAndRotation(-2.0F, -2.3F, -2.5F, -0.20943951023931953F, 0.0F, 0.0F));

                equipCL1a1_7.addOrReplaceChild("EquipCL1a2_7",
                                CubeListBuilder.create().texOffs(151, 67)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));

                PartDefinition equipCL1a1_6 = equipCL1Base01_3.addOrReplaceChild("EquipCL1a1_6",
                                CubeListBuilder.create().texOffs(19, 29)
                                                .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                                PartPose.offsetAndRotation(2.0F, -2.3F, -2.5F, -0.20943951023931953F, 0.0F, 0.0F));

                equipCL1a1_6.addOrReplaceChild("EquipCL1a2_6",
                                CubeListBuilder.create().texOffs(151, 67)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));

                PartDefinition equipB07a1_1 = equipB06d_1.addOrReplaceChild("EquipB07a1_1",
                                CubeListBuilder.create().mirror().texOffs(153, 49)
                                                .addBox(-12.0F, -2.0F, -0.5F, 12.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(1.2F, 8.7F, 12.0F, -0.20943951023931953F,
                                                0.08726646259971647F, -0.12217304763960307F));

                equipB07a1_1.addOrReplaceChild("EquipB07a2_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-5.0F, -2.0F, -1.0F, 5.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(-12.0F, 0.0F, 0.5F, 0.0F, -1.0733774899765127F, 0.0F));

                PartDefinition equipB07d1_1 = equipB06d_1.addOrReplaceChild("EquipB07d1_1",
                                CubeListBuilder.create().mirror().texOffs(153, 49)
                                                .addBox(-12.0F, -2.0F, -0.5F, 12.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(1.0F, -1.6F, 12.4F, 0.0F, 0.08726646259971647F, 0.0F));

                equipB07d1_1.addOrReplaceChild("EquipB07d3_1",
                                CubeListBuilder.create().texOffs(51, 0)
                                                .addBox(-2.0F, -7.0F, -0.5F, 2.0F, 7.0F, 1.0F),
                                PartPose.offsetAndRotation(0.0F, -1.7F, 0.0F, 0.0F, 0.0F, 0.08726646259971647F));

                equipB07d1_1.addOrReplaceChild("EquipB07d2_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-6.0F, -2.0F, -1.0F, 6.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(-12.0F, 0.0F, 0.5F, 0.0F, -1.0471975511965976F, 0.0F));

                PartDefinition equipB07c1_1 = equipB06d_1.addOrReplaceChild("EquipB07c1_1",
                                CubeListBuilder.create().mirror().texOffs(153, 49)
                                                .addBox(-12.0F, -2.0F, -0.5F, 12.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(1.0F, 2.4F, 12.4F, 0.0F, 0.08726646259971647F, 0.0F));

                equipB07c1_1.addOrReplaceChild("EquipB07c2_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-7.0F, -2.0F, -1.0F, 7.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(-12.0F, 0.0F, 0.5F, 0.0F, -1.0471975511965976F, 0.0F));

                PartDefinition equipB07b1_1 = equipB06d_1.addOrReplaceChild("EquipB07b1_1",
                                CubeListBuilder.create().mirror().texOffs(153, 49)
                                                .addBox(-12.0F, -2.0F, -0.5F, 12.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(1.0F, 5.6F, 12.4F, 0.0F, 0.08726646259971647F,
                                                -0.05235987755982988F));

                equipB07b1_1.addOrReplaceChild("EquipB07b2_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-6.0F, -2.0F, -1.0F, 6.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(-12.0F, 0.0F, 0.5F, 0.0F, -1.0471975511965976F, 0.0F));

                equipB04_1.addOrReplaceChild("EquipB06a_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-9.0F, 0.0F, 0.0F, 9.0F, 4.0F, 11.0F),
                                PartPose.offset(-2.5F, 3.9F, 0.5F));

                equipB04_1.addOrReplaceChild("EquipB06f_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 2.0F, 8.0F, 11.0F),
                                PartPose.offset(-27.0F, 4.0F, 0.5F));

                equipB04_1.addOrReplaceChild("EquipB06c_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-3.0F, 0.0F, 0.0F, 3.0F, 8.0F, 11.0F),
                                PartPose.offset(-14.3F, 4.0F, 0.5F));

                PartDefinition equipB04 = equipB01.addOrReplaceChild("EquipB04",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 12.0F),
                                PartPose.offset(5.0F, -2.0F, -0.5F));

                PartDefinition equipB05 = equipB04.addOrReplaceChild("EquipB05",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, 0.0F, -4.5F, 9.0F, 8.0F, 9.0F),
                                PartPose.offset(9.4F, -3.8F, 6.0F));

                PartDefinition equipCL1Base01 = equipB05.addOrReplaceChild("EquipCL1Base01",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, -4.0F, -1.5F, 9.0F, 4.0F, 8.0F),
                                PartPose.offsetAndRotation(0.0F, 0.1F, 0.0F, 0.0F, -1.5707963267948966F, 0.0F));

                equipCL1Base01.addOrReplaceChild("EquipCL1Base02",
                                CubeListBuilder.create().mirror().texOffs(0, 0)
                                                .addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 4.0F),
                                PartPose.offsetAndRotation(0.0F, 0.3F, -2.8F, 0.17453292519943295F, 0.0F, 0.0F));

                PartDefinition equipCL1a1_1 = equipCL1Base01.addOrReplaceChild("EquipCL1a1_1",
                                CubeListBuilder.create().texOffs(19, 29)
                                                .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                                PartPose.offsetAndRotation(-2.0F, -2.3F, -2.5F, -0.20943951023931953F, 0.0F, 0.0F));

                equipCL1a1_1.addOrReplaceChild("EquipCL1a2_1",
                                CubeListBuilder.create().texOffs(151, 67)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));

                PartDefinition equipCL1a1 = equipCL1Base01.addOrReplaceChild("EquipCL1a1",
                                CubeListBuilder.create().texOffs(19, 29)
                                                .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                                PartPose.offsetAndRotation(2.0F, -2.3F, -2.5F, -0.20943951023931953F, 0.0F, 0.0F));

                equipCL1a1.addOrReplaceChild("EquipCL1a2",
                                CubeListBuilder.create().texOffs(151, 67)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));

                equipB04.addOrReplaceChild("EquipB06e",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 11.0F),
                                PartPose.offset(21.1F, 4.0F, 0.5F));

                PartDefinition equipB06d = equipB04.addOrReplaceChild("EquipB06d",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 11.0F),
                                PartPose.offset(17.2F, 4.0F, 0.5F));

                PartDefinition equipB05_1 = equipB06d.addOrReplaceChild("EquipB05_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, 0.0F, -4.5F, 9.0F, 2.0F, 9.0F),
                                PartPose.offset(4.8F, -1.9F, 5.0F));

                PartDefinition equipCL1Base01_1 = equipB05_1.addOrReplaceChild("EquipCL1Base01_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, -4.0F, -1.5F, 9.0F, 4.0F, 8.0F),
                                PartPose.offset(0.0F, 0.1F, 0.0F));

                PartDefinition equipCL1a1_2 = equipCL1Base01_1.addOrReplaceChild("EquipCL1a1_2",
                                CubeListBuilder.create().texOffs(19, 29)
                                                .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                                PartPose.offsetAndRotation(2.0F, -2.3F, -2.5F, -0.20943951023931953F, 0.0F, 0.0F));

                equipCL1a1_2.addOrReplaceChild("EquipCL1a2_2",
                                CubeListBuilder.create().texOffs(151, 67)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));

                equipCL1Base01_1.addOrReplaceChild("EquipCL1Base02_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 4.0F),
                                PartPose.offsetAndRotation(0.0F, 0.3F, -2.8F, 0.17453292519943295F, 0.0F, 0.0F));

                PartDefinition equipCL1a1_3 = equipCL1Base01_1.addOrReplaceChild("EquipCL1a1_3",
                                CubeListBuilder.create().texOffs(19, 29)
                                                .addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F),
                                PartPose.offsetAndRotation(-2.0F, -2.3F, -2.5F, -0.16984426090695579F, 0.0F, 0.0F));

                equipCL1a1_3.addOrReplaceChild("EquipCL1a2_3",
                                CubeListBuilder.create().texOffs(151, 67)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));

                PartDefinition equipB07c1 = equipB06d.addOrReplaceChild("EquipB07c1",
                                CubeListBuilder.create().texOffs(153, 49)
                                                .addBox(0.0F, -2.0F, -0.5F, 12.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(-1.0F, 2.4F, 12.4F, 0.0F, -0.08726646259971647F, 0.0F));

                equipB07c1.addOrReplaceChild("EquipB07c2",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, -2.0F, -1.0F, 7.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(12.0F, 0.0F, 0.5F, 0.0F, 1.0471975511965976F, 0.0F));

                PartDefinition equipB07d1 = equipB06d.addOrReplaceChild("EquipB07d1",
                                CubeListBuilder.create().texOffs(153, 49)
                                                .addBox(0.0F, -2.0F, -0.5F, 12.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(-1.0F, -1.6F, 12.4F, 0.0F, -0.08726646259971647F, 0.0F));

                equipB07d1.addOrReplaceChild("EquipB07d3",
                                CubeListBuilder.create().texOffs(51, 0)
                                                .addBox(0.0F, -7.0F, -0.5F, 2.0F, 7.0F, 1.0F),
                                PartPose.offsetAndRotation(0.0F, -1.7F, 0.0F, 0.0F, 0.0F, -0.08726646259971647F));

                equipB07d1.addOrReplaceChild("EquipB07d2",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, -2.0F, -1.0F, 6.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(12.0F, 0.0F, 0.5F, 0.0F, 1.0471975511965976F, 0.0F));

                PartDefinition equipB07b1 = equipB06d.addOrReplaceChild("EquipB07b1",
                                CubeListBuilder.create().texOffs(153, 49)
                                                .addBox(0.0F, -2.0F, -0.5F, 12.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(-1.0F, 5.6F, 12.4F, 0.0F, -0.08726646259971647F,
                                                0.05235987755982988F));

                equipB07b1.addOrReplaceChild("EquipB07b2",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, -2.0F, -1.0F, 6.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(12.0F, 0.0F, 0.5F, 0.0F, 1.0471975511965976F, 0.0F));

                PartDefinition equipB07a1 = equipB06d.addOrReplaceChild("EquipB07a1",
                                CubeListBuilder.create().texOffs(153, 49)
                                                .addBox(0.0F, -2.0F, -0.5F, 12.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(-1.2F, 8.7F, 12.0F, -0.20943951023931953F,
                                                -0.08726646259971647F, 0.12217304763960307F));

                equipB07a1.addOrReplaceChild("EquipB07a2",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, -2.0F, -1.0F, 5.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(12.0F, 0.0F, 0.5F, 0.0F, 1.0733774899765127F, 0.0F));

                equipB04.addOrReplaceChild("EquipB06a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 9.0F, 4.0F, 11.0F),
                                PartPose.offset(2.5F, 3.9F, 0.5F));

                equipB04.addOrReplaceChild("EquipB06b",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 3.0F, 6.0F, 11.0F),
                                PartPose.offset(11.4F, 4.0F, 0.5F));

                equipB04.addOrReplaceChild("EquipB06c",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 3.0F, 8.0F, 11.0F),
                                PartPose.offset(14.3F, 4.0F, 0.5F));

                equipB04.addOrReplaceChild("EquipB06f",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 2.0F, 8.0F, 11.0F),
                                PartPose.offset(25.0F, 4.0F, 0.5F));

                PartDefinition equipB00a = equipBase.addOrReplaceChild("EquipB00a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 6.0F, 4.0F, 2.0F),
                                PartPose.offsetAndRotation(2.2F, -5.5F, -1.0F, 0.0F, 0.2617993877991494F, 0.0F));

                PartDefinition equipB00b = equipB00a.addOrReplaceChild("EquipB00b",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, -2.0F, 8.0F, 4.0F, 2.0F),
                                PartPose.offsetAndRotation(6.0F, -0.1F, 2.0F, 0.0F, 1.3089969389957472F, 0.0F));

                PartDefinition equipB00c = equipB00b.addOrReplaceChild("EquipB00c",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F),
                                PartPose.offsetAndRotation(5.7F, 2.0F, -0.3F, 0.0F, 0.0F, 0.6108652381980153F));

                equipB00c.addOrReplaceChild("EquipB00d",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F),
                                PartPose.offset(0.0F, 0.0F, 1.1F));

                PartDefinition equipB00a_1 = equipBase.addOrReplaceChild("EquipB00a_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-6.0F, 0.0F, 0.0F, 6.0F, 4.0F, 2.0F),
                                PartPose.offsetAndRotation(-2.2F, -5.5F, -1.0F, 0.0F, -0.2617993877991494F, 0.0F));

                PartDefinition equipB00b_1 = equipB00a_1.addOrReplaceChild("EquipB00b_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-8.0F, 0.0F, -2.0F, 8.0F, 4.0F, 2.0F),
                                PartPose.offsetAndRotation(-6.0F, -0.1F, 2.0F, 0.0F, -1.3089969389957472F, 0.0F));

                PartDefinition equipB00c_1 = equipB00b_1.addOrReplaceChild("EquipB00c_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F),
                                PartPose.offsetAndRotation(-5.7F, 2.0F, -0.3F, 0.0F, 0.0F, -0.6108652381980153F));

                equipB00c_1.addOrReplaceChild("EquipB00d_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F),
                                PartPose.offset(0.0F, 0.0F, 1.1F));

                bodyMain.addOrReplaceChild("Cloth03a2",
                                CubeListBuilder.create().mirror().texOffs(159, 55)
                                                .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 18.0F, 7.0F),
                                PartPose.offset(-4.1F, -11.1F, -4.1F));

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

                PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                                CubeListBuilder.create().texOffs(0, 88)
                                                .addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F),
                                PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));

                PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                                CubeListBuilder.create().mirror().texOffs(0, 68)
                                                .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                                PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.19198621771937624F, 0.0F,
                                                -0.08726646259971647F));

                legRight01.addOrReplaceChild("LegRight02",
                                CubeListBuilder.create().mirror().texOffs(0, 47)
                                                .addBox(0.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                                PartPose.offset(-3.0F, 14.0F, -3.0F));

                PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                                CubeListBuilder.create().texOffs(0, 68)
                                                .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                                PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.296705972839036F, 0.0F,
                                                0.08726646259971647F));

                legLeft01.addOrReplaceChild("LegLeft02",
                                CubeListBuilder.create().texOffs(0, 47)
                                                .addBox(-6.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                                PartPose.offset(3.0F, 14.0F, -3.0F));

                PartDefinition skirtB01 = butt.addOrReplaceChild("SkirtB01",
                                CubeListBuilder.create().texOffs(128, 36)
                                                .addBox(-8.0F, 0.0F, -4.5F, 16.0F, 2.0F, 9.0F),
                                PartPose.offsetAndRotation(0.0F, 0.5F, -1.9F, 0.08726646259971647F, 0.0F, 0.0F));

                PartDefinition cloth02b1 = skirtB01.addOrReplaceChild("Cloth02b1",
                                CubeListBuilder.create().texOffs(59, 0)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F),
                                PartPose.offsetAndRotation(-4.0F, 1.8F, -4.9F, -0.5585053606381855F, 0.0F,
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

                PartDefinition cloth01a = skirtB01.addOrReplaceChild("Cloth01a",
                                CubeListBuilder.create().texOffs(81, 0)
                                                .addBox(-1.0F, -2.5F, -1.0F, 2.0F, 3.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 2.3F, -5.0F, -0.2617993877991494F, 0.0F, 0.0F));

                cloth01a.addOrReplaceChild("Cloth01c2",
                                CubeListBuilder.create().mirror().texOffs(73, 5)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F),
                                PartPose.offsetAndRotation(2.0F, -0.4F, -0.7F, -0.2617993877991494F,
                                                -0.13962634015954636F, -0.17453292519943295F));

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

                cloth01a.addOrReplaceChild("Cloth01b",
                                CubeListBuilder.create().texOffs(65, 0)
                                                .addBox(-6.0F, -3.0F, -1.0F, 6.0F, 3.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 0.5F, 0.3F, 0.08726646259971647F,
                                                -0.17453292519943295F, -0.3490658503988659F));

                PartDefinition cloth02a1 = skirtB01.addOrReplaceChild("Cloth02a1",
                                CubeListBuilder.create().texOffs(59, 0)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F),
                                PartPose.offsetAndRotation(4.0F, 1.8F, -4.9F, -0.5585053606381855F, 0.0F,
                                                -0.06981317007977318F));

                PartDefinition cloth02a2 = cloth02a1.addOrReplaceChild("Cloth02a2",
                                CubeListBuilder.create().texOffs(59, 0)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 4.9F, 0.0F, 0.17453292519943295F, 0.0F,
                                                0.05235987755982988F));

                cloth02a2.addOrReplaceChild("Cloth02a3",
                                CubeListBuilder.create().texOffs(59, 0)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, 0.0F, 0.0F, 0.05235987755982988F));

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

                PartDefinition skirt01 = butt.addOrReplaceChild("Skirt01",
                                CubeListBuilder.create().texOffs(128, 0)
                                                .addBox(-8.5F, 0.0F, -8.5F, 17.0F, 5.0F, 11.0F),
                                PartPose.offsetAndRotation(0.0F, 3.5F, 1.5F, -0.08726646259971647F, 0.0F, 0.0F));

                skirt01.addOrReplaceChild("Skirt02",
                                CubeListBuilder.create().texOffs(128, 17)
                                                .addBox(-9.5F, 0.0F, -6.5F, 19.0F, 5.0F, 13.0F),
                                PartPose.offsetAndRotation(0.0F, 3.5F, -2.7F, -0.08726646259971647F, 0.0F, 0.0F));

                PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                                CubeListBuilder.create().texOffs(24, 71)
                                                .addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                                PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.17453292519943295F, 0.0F,
                                                -0.3141592653589793F));

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
                                PartPose.offset(0.1F, -0.1F, -2.2F));

                PartDefinition clothA04 = clothA03.addOrReplaceChild("ClothA04",
                                CubeListBuilder.create().texOffs(128, 81)
                                                .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 6.0F),
                                PartPose.offset(0.0F, 0.9F, 0.8F));

                clothA04.addOrReplaceChild("ClothA05",
                                CubeListBuilder.create().texOffs(128, 96)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 6.0F),
                                PartPose.offset(0.0F, 1.9F, 0.8F));

                armLeft01.addOrReplaceChild("ClothA01",
                                CubeListBuilder.create().texOffs(128, 109)
                                                .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F),
                                PartPose.offset(0.5F, 5.1F, 0.0F));

                PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                                CubeListBuilder.create().texOffs(24, 63)
                                                .addBox(-2.5F, -3.0F, -2.9F, 5.0F, 3.0F, 5.0F),
                                PartPose.offsetAndRotation(0.0F, -9.6F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));

                PartDefinition head = neck.addOrReplaceChild("Head",
                                CubeListBuilder.create().texOffs(44, 101)
                                                .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                                PartPose.offset(0.0F, -1.0F, -0.7F));

                PartDefinition hair = head.addOrReplaceChild("Hair",
                                CubeListBuilder.create().texOffs(50, 77)
                                                .addBox(-8.0F, -8.0F, -7.4F, 16.0F, 16.0F, 8.0F),
                                PartPose.offset(0.0F, -7.5F, 0.1F));

                hair.addOrReplaceChild("HairU01",
                                CubeListBuilder.create().texOffs(52, 56)
                                                .addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F),
                                PartPose.offset(0.0F, -6.0F, -7.0F));

                hair.addOrReplaceChild("HairS01",
                                CubeListBuilder.create().texOffs(110, 22)
                                                .addBox(-1.5F, -3.0F, -3.0F, 3.0F, 6.0F, 6.0F),
                                PartPose.offsetAndRotation(-8.8F, 3.1F, 3.3F, 0.0F, 0.05235987755982988F, 0.0F));

                PartDefinition hairCBase = hair.addOrReplaceChild("HairCBase",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                                PartPose.offsetAndRotation(6.0F, 1.0F, -1.6F, 0.0F, 0.0F, -0.3141592653589793F));

                PartDefinition hairC01 = hairCBase.addOrReplaceChild("HairC01",
                                CubeListBuilder.create().texOffs(40, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, -6.0F, -7.0F, 1.3962634015954636F,
                                                -0.13962634015954636F, 0.0F));

                PartDefinition hairC02 = hairC01.addOrReplaceChild("HairC02",
                                CubeListBuilder.create().texOffs(40, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 2.0F, 10.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.3439035240356336F, 0.0F, 0.0F));

                PartDefinition hairC03 = hairC02.addOrReplaceChild("HairC03",
                                CubeListBuilder.create().texOffs(40, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 2.0F, 7.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.5009094953223726F, 0.0F,
                                                -0.8726646259971648F));

                PartDefinition hairC04 = hairC03.addOrReplaceChild("HairC04",
                                CubeListBuilder.create().texOffs(40, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 2.0F, 11.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 1.0471975511965976F, 0.0F, 0.0F));

                hairC04.addOrReplaceChild("HairC05",
                                CubeListBuilder.create().texOffs(40, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 11.0F, 0.0F, 1.7453292519943295F, 0.0F, 0.0F));

                PartDefinition hairL01 = hair.addOrReplaceChild("HairL01",
                                CubeListBuilder.create().texOffs(90, 103)
                                                .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 3.0F),
                                PartPose.offsetAndRotation(6.5F, 1.5F, -4.5F, -0.19198621771937624F,
                                                -0.17453292519943295F, -0.08726646259971647F));

                hairL01.addOrReplaceChild("HairL02",
                                CubeListBuilder.create().texOffs(90, 103)
                                                .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 3.0F),
                                PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.17453292519943295F, 0.0F,
                                                0.08726646259971647F));

                PartDefinition hairR01 = hair.addOrReplaceChild("HairR01",
                                CubeListBuilder.create().mirror().texOffs(90, 103)
                                                .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 3.0F),
                                PartPose.offsetAndRotation(-6.5F, 1.5F, -4.5F, -0.19198621771937624F,
                                                0.17453292519943295F, 0.08726646259971647F));

                hairR01.addOrReplaceChild("HairR02",
                                CubeListBuilder.create().mirror().texOffs(90, 103)
                                                .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 3.0F),
                                PartPose.offsetAndRotation(0.2F, 8.0F, 0.0F, 0.17453292519943295F, 0.0F,
                                                -0.05235987755982988F));

                PartDefinition hairCBaseB = hair.addOrReplaceChild("HairCBaseB",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                                PartPose.offsetAndRotation(-6.0F, 1.0F, -1.6F, 0.0F, 0.0F, 0.3141592653589793F));

                PartDefinition hairC01b = hairCBaseB.addOrReplaceChild("HairC01b",
                                CubeListBuilder.create().texOffs(40, 0)
                                                .addBox(-2.0F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, -6.0F, -7.0F, 1.3962634015954636F,
                                                0.13962634015954636F, 0.0F));

                PartDefinition hairC02b = hairC01b.addOrReplaceChild("HairC02b",
                                CubeListBuilder.create().texOffs(40, 0)
                                                .addBox(-2.0F, 0.0F, 0.0F, 2.0F, 10.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.3439035240356336F, 0.0F, 0.0F));

                PartDefinition hairC03b = hairC02b.addOrReplaceChild("HairC03b",
                                CubeListBuilder.create().texOffs(40, 0)
                                                .addBox(-2.0F, 0.0F, 0.0F, 2.0F, 7.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.5009094953223726F, 0.0F,
                                                0.8726646259971648F));

                PartDefinition hairC04b = hairC03b.addOrReplaceChild("HairC04b",
                                CubeListBuilder.create().texOffs(40, 0)
                                                .addBox(-2.0F, 0.0F, 0.0F, 2.0F, 11.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 1.0471975511965976F, 0.0F, 0.0F));

                hairC04b.addOrReplaceChild("HairC05b",
                                CubeListBuilder.create().texOffs(40, 0)
                                                .addBox(-2.0F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 11.0F, 0.0F, 1.7453292519943295F, 0.0F, 0.0F));

                hair.addOrReplaceChild("HairS02",
                                CubeListBuilder.create().texOffs(110, 22)
                                                .addBox(-1.5F, -3.0F, -3.0F, 3.0F, 6.0F, 6.0F),
                                PartPose.offsetAndRotation(8.8F, 3.1F, 3.3F, 0.0F, -0.05235987755982988F, 0.0F));

                PartDefinition equipHeadBase = head.addOrReplaceChild("EquipHeadBase",
                                CubeListBuilder.create().texOffs(33, 16)
                                                .addBox(-8.0F, 0.0F, 0.0F, 16.0F, 2.0F, 15.0F),
                                PartPose.offset(0.0F, -11.8F, -7.6F));

                PartDefinition equipHead01a = equipHeadBase.addOrReplaceChild("EquipHead01a",
                                CubeListBuilder.create().texOffs(36, 108)
                                                .addBox(-8.0F, 0.0F, 0.0F, 8.0F, 1.0F, 2.0F),
                                PartPose.offsetAndRotation(-7.5F, 0.2F, 7.0F, 0.0F, 0.0F, 0.08726646259971647F));

                equipHead01a.addOrReplaceChild("EquipHead03a",
                                CubeListBuilder.create().texOffs(40, 105)
                                                .addBox(-7.0F, 0.0F, 0.0F, 7.0F, 2.0F, 1.0F),
                                PartPose.offset(0.2F, 0.9F, 0.5F));

                equipHead01a.addOrReplaceChild("EquipHead02a",
                                CubeListBuilder.create().texOffs(44, 82)
                                                .addBox(-7.0F, 0.0F, 1.0F, 7.0F, 2.0F, 0.0F),
                                PartPose.offset(-0.4F, -1.9F, 0.0F));

                PartDefinition equipHead01 = equipHeadBase.addOrReplaceChild("EquipHead01",
                                CubeListBuilder.create().texOffs(36, 108)
                                                .addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 2.0F),
                                PartPose.offsetAndRotation(7.5F, 0.2F, 7.0F, 0.0F, 0.0F, -0.08726646259971647F));

                equipHead01.addOrReplaceChild("EquipHead03",
                                CubeListBuilder.create().texOffs(40, 105)
                                                .addBox(0.0F, 0.0F, 0.0F, 7.0F, 2.0F, 1.0F),
                                PartPose.offset(0.2F, 0.9F, 0.5F));

                equipHead01.addOrReplaceChild("EquipHead02",
                                CubeListBuilder.create().texOffs(44, 82)
                                                .addBox(0.0F, 0.0F, 1.0F, 7.0F, 2.0F, 0.0F),
                                PartPose.offset(0.4F, -1.9F, 0.0F));

                PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                                CubeListBuilder.create().texOffs(46, 104)
                                                .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F),
                                PartPose.offset(0.0F, -14.8F, -3.0F));

                PartDefinition hair01 = hairMain.addOrReplaceChild("Hair01",
                                CubeListBuilder.create().texOffs(80, 0)
                                                .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 13.0F, 9.0F),
                                PartPose.offsetAndRotation(0.0F, 9.0F, 1.0F, 0.2617993877991494F, 0.0F, 0.0F));

                hair01.addOrReplaceChild("Hair02",
                                CubeListBuilder.create().texOffs(52, 35)
                                                .addBox(-8.0F, 0.0F, -5.0F, 16.0F, 13.0F, 8.0F),
                                PartPose.offsetAndRotation(0.0F, 10.5F, 5.7F, -0.17453292519943295F, 0.0F, 0.0F));

                head.addOrReplaceChild("Ahoke00",
                                CubeListBuilder.create().texOffs(100, 28)
                                                .addBox(0.0F, -9.0F, 0.0F, 0.0F, 12.0F, 12.0F),
                                PartPose.offsetAndRotation(-0.6F, -13.0F, -4.0F, 0.6632F, 0.5236F, 0.0F));

                PartDefinition ahoke01 = head.addOrReplaceChild("Ahoke01",
                                CubeListBuilder.create().texOffs(44, 0)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, -15.0F, -5.0F, 2.705260340591211F,
                                                -2.8797932657906435F, 0.0F));

                PartDefinition ahoke02 = ahoke01.addOrReplaceChild("Ahoke02",
                                CubeListBuilder.create().texOffs(44, 0)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 7.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 1.2217304763960306F, 0.0F, 0.0F));

                PartDefinition ahoke03 = ahoke02.addOrReplaceChild("Ahoke03",
                                CubeListBuilder.create().texOffs(44, 0)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 1.48352986419518F, 0.0F, 0.0F));

                ahoke03.addOrReplaceChild("Ahoke04",
                                CubeListBuilder.create().texOffs(44, 0)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 4.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.9599310885968813F, 0.0F, 0.0F));

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

                flag = !EmotionHelper.checkModelState(1, state); // head equip
                this.EquipHeadBase.visible = !flag;

                flag = !EmotionHelper.checkModelState(2, state); // hair
                this.HairS01.visible = !flag;
                this.HairS02.visible = !flag;
                this.HairCBase.visible = !flag;
                this.HairCBaseB.visible = !flag;

                flag = EmotionHelper.checkModelState(3, state); // ahoke
                this.Ahoke00.visible = flag; // Ahoke00 visible when state ON (original: isHidden = !flag)
                this.Ahoke01.visible = !flag;
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
                this.EquipCL1Base01.yRot = this.Head.yRot;
                this.EquipCL1Base01_1.yRot = this.Head.yRot;
                this.EquipCL1Base01_2.yRot = this.Head.yRot;
                this.EquipCL1Base01_3.yRot = this.Head.yRot;
        }

        @Override
        public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

                switch (ent.getScaleLevel()) {
                        case 3:
                                // [PORT] 1.10.2 -> 1.20.1: preserve legacy dead-pose grounding offset.
                                this.offsetY += 1.42F;
                                break;
                        case 2:
                                this.offsetY += 1.29F;
                                break;
                        case 1:
                                this.offsetY += 1.05F;
                                break;
                        default:
                                this.offsetY += 0.7F;
                                break;
                }

                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 1.05F;
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
                this.Ahoke00.xRot = 0.6632F;
                this.Ahoke00.yRot = 0.523F;
                this.Ahoke00.zRot = 0F;
                this.Ahoke01.xRot = 2.7F;
                this.Ahoke02.xRot = 1.22F;
                this.Ahoke03.xRot = 1.48F;
                this.Ahoke04.xRot = 0.96F;
                this.Hair01.xRot = 0.1F;
                this.Hair01.yRot = 0F;
                this.Hair01.zRot = 0F;
                this.Hair02.xRot = -0.3F;
                this.Hair02.yRot = 0F;
                this.Hair02.zRot = 0F;
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
                float addk1;
                float addk2;
                float headX = 0F;
                float headZ;
                float addHL1 = 0F;
                float addHR1 = 0F;
                float addHL2 = 0F;
                float addHR2 = 0F;
                float t2 = ent.getTickExisted() & 511;
                boolean spcStand = ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED;

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
                this.Ahoke00.xRot = angleX2 * 0.05F + 0.66F;
                this.Ahoke00.yRot = -angleX * 0.15F + 0.53F;
                this.Ahoke01.xRot = -angleX1 * 0.09F + 2.7F;
                this.Ahoke02.xRot = angleX2 * 0.15F + 1.22F;
                this.Ahoke03.xRot = -angleX3 * 0.10F + 1.48F;
                this.Ahoke04.xRot = -angleX4 * 0.10F + 0.96F;
                // boob
                this.BoobL.xRot = angleX * 0.06F - 0.8F;
                this.BoobR.xRot = angleX * 0.06F - 0.8F;
                this.ClothB01.xRot = 0.96F - angleX * 0.08F;
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
                // hair
                this.Hair01.xRot = angleX * 0.03F + 0.26F + headX;
                this.Hair01.zRot = 0F;
                this.Hair02.xRot = -angleX1 * 0.04F - 0.17F + headX;
                this.Hair02.zRot = 0F;
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
                this.EquipCL1Base01.yRot = this.Head.yRot * 0.5F - 0.9F;
                this.EquipCL1Base01_1.yRot = this.Head.yRot * 0.75F;
                this.EquipCL1Base01_2.yRot = this.Head.yRot * 0.5F + 0.9F;
                this.EquipCL1Base01_3.yRot = this.Head.yRot * 0.75F;

                // run
                if (ent.getIsSprinting() || f1 > 0.9F) {
                        spcStand = false;

                        if (ent.getTickExisted() % 256 > 128) {
                                this.setFace(3);
                                this.setMouth(5);
                        }
                        // body
                        this.BodyMain.xRot = 0.2F;
                        this.Skirt01.xRot = -0.4F;
                        this.Skirt02.xRot = -0.1F;
                        this.SkirtB01.xRot = -0.13F;
                        this.Cloth02c1.xRot = 1.17F;
                        this.Cloth02c1_1.xRot = 1.17F;
                        this.Cloth02c2.xRot = -0.63F;
                        this.Cloth02c2_1.xRot = -0.63F;
                        this.Hair01.xRot += 0.2F;
                        this.Hair02.xRot += 0.2F;
                        // arm
                        this.ArmLeft01.xRot = angleAdd2 * 1.2F + 0.5F;
                        this.ArmRight01.xRot = angleAdd1 * 1.2F + 0.5F;
                        this.ArmLeft01.yRot = 0F;
                        this.ArmLeft02.xRot = -1F;
                        this.ArmLeft02.zRot = 0F;
                        // this.ArmLeft02.offsetX = 0F;
                        // this.ArmLeft02.offsetZ = 0F;
                        this.ArmRight01.yRot = 0F;
                        this.ArmRight02.xRot = -1F;
                        this.ArmRight02.zRot = 0F;
                        // this.ArmRight02.offsetX = 0F;
                        // this.ArmRight02.offsetZ = 0F;
                        // leg
                        addk1 = angleAdd1 * 0.7F - 0.48F;
                        addk2 = angleAdd2 * 0.7F - 0.41F;
                        this.LegLeft01.yRot = 0F;
                        this.LegLeft01.zRot = 0.0873F;
                        this.LegRight01.yRot = 0F;
                        this.LegRight01.zRot = -0.0873F;
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
                        // [PORT] Restored from 1.10.2 GlStateManager.translate
                        this.offsetY += 0.2F;
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
                        // hair
                        this.Hair01.xRot = this.Hair01.xRot * 0.5F + 0.4F;
                        this.Hair02.xRot = this.Hair02.xRot * 0.75F + 0.25F;
                } // end if sneaking

                // sit
                if (ent.getIsSitting() || ent.getIsRiding()) {
                        spcStand = false;

                        if (ent.getTickExisted() % 512 > 256) {
                                if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
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

                                        // 頭部
                                        // [PORT] Restored from 1.10.2 GlStateManager.translate
                                        this.offsetY += 1F;
                                        this.Head.xRot = -0.35F;
                                        this.Head.yRot = 0F;
                                        // body
                                        this.BodyMain.xRot = -1.6F;
                                        // arm
                                        this.ArmLeft01.xRot = 3.0F;
                                        this.ArmLeft01.yRot = 0F;
                                        this.ArmLeft01.zRot = 0.7F;
                                        this.ArmRight01.xRot = 3.0F;
                                        this.ArmRight01.yRot = 0F;
                                        this.ArmRight01.zRot = -0.7F;
                                        this.ArmLeft02.xRot = 0F;
                                        this.ArmRight02.xRot = 0F;
                                        // leg
                                        this.LegLeft01.xRot = -0.2F;
                                        this.LegLeft01.yRot = 0F;
                                        this.LegLeft01.zRot = -0.1F;
                                        this.LegLeft02.xRot = 0F;
                                        this.LegRight01.xRot = -0.2F;
                                        this.LegRight01.yRot = 0F;
                                        this.LegRight01.zRot = 0.1F;
                                        this.LegRight02.xRot = 0F;
                                        // equip
                                        this.EquipBase.visible = false;
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

                                        // [PORT] Restored from 1.10.2 GlStateManager.translate
                                        this.offsetY += 0.82F;
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
                                        // hair
                                        this.Hair01.xRot = 0.21F + headX;
                                        this.Hair02.xRot = -0.28F + headX;
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
                                }
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
                                // [PORT] Restored from 1.10.2 GlStateManager.translate
                                this.offsetY += 0.46F;
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
                                // hair
                                this.Hair01.xRot += 0.12F;
                                this.Hair02.xRot += 0.15F;
                        }
                } // end if sitting

                // attack
                if (ent.getAttackTick() > 20) {
                        spcStand = false;

                        this.setFace(3);
                        this.setMouth(5);

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
                        addk1 += 0.14F;
                        addk2 += 0.07F;
                        this.LegLeft01.yRot = 0F;
                        this.LegLeft01.zRot = -0.17F;
                        this.LegRight01.yRot = 0F;
                        this.LegRight01.zRot = 0.17F;
                }

                // special stand pose
                if (spcStand) {
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
                        addk1 += 0.14F;
                        addk2 += 0.07F;
                        this.LegLeft01.yRot = 0F;
                        this.LegLeft01.zRot = -0.17F;
                        this.LegRight01.yRot = 0F;
                        this.LegRight01.zRot = 0.17F;

                        if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED) {
                                this.setFace(3);
                                this.setMouth(5);
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

                // 移動頭髮避免穿過身體
                headX = this.Head.xRot * -0.5F;
                this.HairL01.xRot = angleX * 0.02F + headX - 0.19F + addHL1;
                this.HairL02.xRot = -angleX1 * 0.04F + headX + 0.17F + addHL2;
                this.HairR01.xRot = angleX * 0.02F + headX - 0.19F + addHR1;
                this.HairR02.xRot = -angleX1 * 0.04F + headX + 0.17F + addHR2;
                headZ = this.Head.zRot * -0.5F;
                this.Hair01.zRot = headZ;
                this.Hair02.zRot = headZ;
                this.HairL01.zRot = headZ - 0.087F;
                this.HairL02.zRot = headZ + 0.087F;
                this.HairR01.zRot = headZ + 0.087F;
                this.HairR02.zRot = headZ - 0.052F;

                // leg motion
                this.LegLeft01.xRot = addk1;
                this.LegRight01.xRot = addk2;
        }
}
