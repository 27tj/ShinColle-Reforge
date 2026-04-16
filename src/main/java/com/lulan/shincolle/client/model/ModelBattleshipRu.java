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

public class ModelBattleshipRu extends ShipModelBaseAdv<Entity> {

        public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
                        new ResourceLocation(Reference.MOD_ID, "bb_ru"), "main");

        private final ModelPart BodyMain;
        private final ModelPart Neck;
        private final ModelPart BoobR;
        private final ModelPart BoobL;
        private final ModelPart Butt;
        private final ModelPart ArmRight01;
        private final ModelPart ArmLeft01;
        private final ModelPart EquipBase;
        private final ModelPart Head;
        private final ModelPart Hair;
        private final ModelPart HairMain;
        private final ModelPart Ahoke;
        private final ModelPart HairL01;
        private final ModelPart HairR01;
        private final ModelPart HairL02;
        private final ModelPart HairR02;
        private final ModelPart Hair01;
        private final ModelPart Hair02;
        private final ModelPart LegLeft01;
        private final ModelPart LegRight01;
        private final ModelPart LegLeft02;
        private final ModelPart Shoe01;
        private final ModelPart LegRight02;
        private final ModelPart Shoe02;
        private final ModelPart ArmRight02;
        private final ModelPart EquipRBase;
        private final ModelPart EquipR01;
        private final ModelPart EquipRC01a;
        private final ModelPart EquipRC02a;
        private final ModelPart EquipRC03a;
        private final ModelPart EquipRC04a;
        private final ModelPart EquipR02a;
        private final ModelPart EquipR03a;
        private final ModelPart EquipR04a;
        private final ModelPart EquipR05a;
        private final ModelPart EquipR06a;
        private final ModelPart EquipR07;
        private final ModelPart EquipR02b;
        private final ModelPart EquipR03b;
        private final ModelPart EquipR04b;
        private final ModelPart EquipR05b;
        private final ModelPart EquipR06b;
        private final ModelPart EquipR08;
        private final ModelPart EquipR09;
        private final ModelPart EquipR10;
        private final ModelPart EquipRC01b;
        private final ModelPart EquipRC01c;
        private final ModelPart EquipRC02b;
        private final ModelPart EquipRC03b;
        private final ModelPart EquipRC03c;
        private final ModelPart ArmLeft02;
        private final ModelPart EquipLBase;
        private final ModelPart EquipL01;
        private final ModelPart EquipLC01a;
        private final ModelPart EquipLC02a;
        private final ModelPart EquipLC03a;
        private final ModelPart EquipLC04a;
        private final ModelPart EquipL02a;
        private final ModelPart EquipL03a;
        private final ModelPart EquipL04a;
        private final ModelPart EquipL05a;
        private final ModelPart EquipL06a;
        private final ModelPart EquipL07;
        private final ModelPart EquipL02b;
        private final ModelPart EquipL03b;
        private final ModelPart EquipL04b;
        private final ModelPart EquipL05b;
        private final ModelPart EquipL06b;
        private final ModelPart EquipL08;
        private final ModelPart EquipL09;
        private final ModelPart EquipL10;
        private final ModelPart EquipLC01b;
        private final ModelPart EquipLC01c;
        private final ModelPart EquipLC02b;
        private final ModelPart EquipLC03b;
        private final ModelPart EquipLC03c;
        private final ModelPart Equip01a;
        private final ModelPart Equip01b;
        private final ModelPart Equip02;
        private final ModelPart Equip03a;
        private final ModelPart EquipCB01;
        private final ModelPart Equip03b;
        private final ModelPart EquipCB03;
        private final ModelPart EquipCB02a;
        private final ModelPart EquipCB02b;
        private final ModelPart EquipCB04a;
        private final ModelPart EquipCB04b;
        private final ModelPart GloveR;
        private final ModelPart GloveL;
        private final ModelPart GlowBodyMain;
        private final ModelPart GlowNeck;
        private final ModelPart GlowHead;
        private final ModelPart Skirt01;

        public ModelBattleshipRu(ModelPart root) {
                super();
                this.scale = 0.44F;
                this.offsetY = 1.9F;
                this.BodyMain = root.getChild("BodyMain");
                this.Neck = this.BodyMain.getChild("Neck");
                this.BoobL = this.BodyMain.getChild("BoobL");
                this.EquipBase = this.BodyMain.getChild("EquipBase");
                this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
                this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
                this.Butt = this.BodyMain.getChild("Butt");
                this.BoobR = this.BodyMain.getChild("BoobR");
                this.Head = this.Neck.getChild("Head");
                this.Equip02 = this.EquipBase.getChild("Equip02");
                this.Equip01b = this.EquipBase.getChild("Equip01b");
                this.Equip01a = this.EquipBase.getChild("Equip01a");
                this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
                this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
                this.LegRight01 = this.Butt.getChild("LegRight01");
                this.Skirt01 = this.Butt.getChild("Skirt01");
                this.LegLeft01 = this.Butt.getChild("LegLeft01");
                this.HairMain = this.Head.getChild("HairMain");
                this.Hair = this.Head.getChild("Hair");
                this.Equip03b = this.Equip02.getChild("Equip03b");
                this.EquipCB03 = this.Equip02.getChild("EquipCB03");
                this.EquipCB01 = this.Equip02.getChild("EquipCB01");
                this.Equip03a = this.Equip02.getChild("Equip03a");
                this.EquipRBase = this.ArmRight02.getChild("EquipRBase");
                this.GloveR = this.ArmRight02.getChild("GloveR");
                this.EquipLBase = this.ArmLeft02.getChild("EquipLBase");
                this.GloveL = this.ArmLeft02.getChild("GloveL");
                this.LegRight02 = this.LegRight01.getChild("LegRight02");
                this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
                this.Hair01 = this.HairMain.getChild("Hair01");
                this.Ahoke = this.Hair.getChild("Ahoke");
                this.HairL01 = this.Hair.getChild("HairL01");
                this.HairR01 = this.Hair.getChild("HairR01");
                this.EquipCB04b = this.EquipCB03.getChild("EquipCB04b");
                this.EquipCB04a = this.EquipCB03.getChild("EquipCB04a");
                this.EquipCB02a = this.EquipCB01.getChild("EquipCB02a");
                this.EquipCB02b = this.EquipCB01.getChild("EquipCB02b");
                this.EquipRC02a = this.EquipRBase.getChild("EquipRC02a");
                this.EquipR04a = this.EquipRBase.getChild("EquipR04a");
                this.EquipR03a = this.EquipRBase.getChild("EquipR03a");
                this.EquipR02a = this.EquipRBase.getChild("EquipR02a");
                this.EquipR06a = this.EquipRBase.getChild("EquipR06a");
                this.EquipR04b = this.EquipRBase.getChild("EquipR04b");
                this.EquipR02b = this.EquipRBase.getChild("EquipR02b");
                this.EquipR01 = this.EquipRBase.getChild("EquipR01");
                this.EquipR09 = this.EquipRBase.getChild("EquipR09");
                this.EquipR05a = this.EquipRBase.getChild("EquipR05a");
                this.EquipRC01a = this.EquipRBase.getChild("EquipRC01a");
                this.EquipR05b = this.EquipRBase.getChild("EquipR05b");
                this.EquipRC03a = this.EquipRBase.getChild("EquipRC03a");
                this.EquipR06b = this.EquipRBase.getChild("EquipR06b");
                this.EquipR10 = this.EquipRBase.getChild("EquipR10");
                this.EquipR08 = this.EquipRBase.getChild("EquipR08");
                this.EquipR07 = this.EquipRBase.getChild("EquipR07");
                this.EquipR03b = this.EquipRBase.getChild("EquipR03b");
                this.EquipRC04a = this.EquipRBase.getChild("EquipRC04a");
                this.EquipL04a = this.EquipLBase.getChild("EquipL04a");
                this.EquipLC01a = this.EquipLBase.getChild("EquipLC01a");
                this.EquipL06b = this.EquipLBase.getChild("EquipL06b");
                this.EquipLC02a = this.EquipLBase.getChild("EquipLC02a");
                this.EquipL08 = this.EquipLBase.getChild("EquipL08");
                this.EquipL04b = this.EquipLBase.getChild("EquipL04b");
                this.EquipL05b = this.EquipLBase.getChild("EquipL05b");
                this.EquipLC03a = this.EquipLBase.getChild("EquipLC03a");
                this.EquipL06a = this.EquipLBase.getChild("EquipL06a");
                this.EquipL10 = this.EquipLBase.getChild("EquipL10");
                this.EquipL02a = this.EquipLBase.getChild("EquipL02a");
                this.EquipL07 = this.EquipLBase.getChild("EquipL07");
                this.EquipL09 = this.EquipLBase.getChild("EquipL09");
                this.EquipL01 = this.EquipLBase.getChild("EquipL01");
                this.EquipLC04a = this.EquipLBase.getChild("EquipLC04a");
                this.EquipL05a = this.EquipLBase.getChild("EquipL05a");
                this.EquipL03a = this.EquipLBase.getChild("EquipL03a");
                this.EquipL02b = this.EquipLBase.getChild("EquipL02b");
                this.EquipL03b = this.EquipLBase.getChild("EquipL03b");
                this.Shoe02 = this.LegRight02.getChild("Shoe02");
                this.Shoe01 = this.LegLeft02.getChild("Shoe01");
                this.Hair02 = this.Hair01.getChild("Hair02");
                this.HairL02 = this.HairL01.getChild("HairL02");
                this.HairR02 = this.HairR01.getChild("HairR02");
                this.EquipRC02b = this.EquipRC02a.getChild("EquipRC02b");
                this.EquipRC01b = this.EquipRC01a.getChild("EquipRC01b");
                this.EquipRC01c = this.EquipRC01a.getChild("EquipRC01c");
                this.EquipRC03b = this.EquipRC03a.getChild("EquipRC03b");
                this.EquipRC03c = this.EquipRC03a.getChild("EquipRC03c");
                this.EquipLC01b = this.EquipLC01a.getChild("EquipLC01b");
                this.EquipLC01c = this.EquipLC01a.getChild("EquipLC01c");
                this.EquipLC02b = this.EquipLC02a.getChild("EquipLC02b");
                this.EquipLC03b = this.EquipLC03a.getChild("EquipLC03b");
                this.EquipLC03c = this.EquipLC03a.getChild("EquipLC03c");

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

                PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                                CubeListBuilder.create().texOffs(54, 121)
                                                .addBox(-2.5F, -2.0F, -3.6F, 5.0F, 2.0F, 5.0F),
                                PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));

                PartDefinition head = neck.addOrReplaceChild("Head",
                                CubeListBuilder.create().texOffs(44, 101)
                                                .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                                PartPose.offset(0.0F, -1.0F, -0.7F));

                PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                                CubeListBuilder.create().texOffs(46, 104)
                                                .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F),
                                PartPose.offset(0.0F, -14.8F, -3.0F));

                PartDefinition hair01 = hairMain.addOrReplaceChild("Hair01",
                                CubeListBuilder.create().texOffs(50, 54)
                                                .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 14.0F, 9.0F),
                                PartPose.offsetAndRotation(0.0F, 9.0F, 1.0F, 0.13962634015954636F, 0.0F, 0.0F));

                hair01.addOrReplaceChild("Hair02",
                                CubeListBuilder.create().texOffs(0, 63)
                                                .addBox(-7.0F, 0.0F, -5.0F, 14.0F, 12.0F, 7.0F),
                                PartPose.offsetAndRotation(0.0F, 12.5F, 6.5F, -0.12217304763960307F, 0.0F, 0.0F));

                PartDefinition hair = head.addOrReplaceChild("Hair",
                                CubeListBuilder.create().texOffs(50, 77)
                                                .addBox(-8.0F, -8.0F, -7.4F, 16.0F, 15.0F, 8.0F),
                                PartPose.offset(0.0F, -7.5F, 0.1F));

                hair.addOrReplaceChild("Ahoke",
                                CubeListBuilder.create().texOffs(114, 45)
                                                .addBox(-1.5F, 0.0F, 0.0F, 5.0F, 7.0F, 0.0F),
                                PartPose.offsetAndRotation(0.7F, -6.0F, -7.5F, -0.08726646259971647F, 0.0F,
                                                0.136659280431156F));

                PartDefinition hairL01 = hair.addOrReplaceChild("HairL01",
                                CubeListBuilder.create().texOffs(88, 100)
                                                .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 3.0F),
                                PartPose.offsetAndRotation(6.8F, 6.5F, -6.3F, -0.08726646259971647F, -0.07F,
                                                0.05235987755982988F));

                hairL01.addOrReplaceChild("HairL02",
                                CubeListBuilder.create().texOffs(88, 100)
                                                .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 3.0F),
                                PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.12217304763960307F, 0.0F,
                                                -0.08726646259971647F));

                PartDefinition hairR01 = hair.addOrReplaceChild("HairR01",
                                CubeListBuilder.create().mirror().texOffs(88, 101)
                                                .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 3.0F),
                                PartPose.offsetAndRotation(-6.8F, 6.5F, -6.3F, -0.08726646259971647F, 0.07F,
                                                -0.05235987755982988F));

                hairR01.addOrReplaceChild("HairR02",
                                CubeListBuilder.create().mirror().texOffs(88, 100)
                                                .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 3.0F),
                                PartPose.offsetAndRotation(0.2F, 10.0F, 0.0F, 0.08726646259971647F, 0.0F,
                                                0.08726646259971647F));

                bodyMain.addOrReplaceChild("BoobL",
                                CubeListBuilder.create().mirror().texOffs(33, 101)
                                                .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 4.0F),
                                PartPose.offsetAndRotation(3.2F, -9.0F, -3.4F, -0.6981317007977318F,
                                                0.08726646259971647F, 0.08726646259971647F));

                PartDefinition equipBase = bodyMain.addOrReplaceChild("EquipBase",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                                PartPose.offset(0.0F, -9.0F, 1.0F));

                PartDefinition equip02 = equipBase.addOrReplaceChild("Equip02",
                                CubeListBuilder.create().texOffs(4, 4)
                                                .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 5.0F),
                                PartPose.offset(0.0F, -7.0F, 3.0F));

                equip02.addOrReplaceChild("Equip03b",
                                CubeListBuilder.create().texOffs(66, 0)
                                                .addBox(-10.0F, 0.0F, 0.0F, 10.0F, 5.0F, 7.0F),
                                PartPose.offsetAndRotation(-10.0F, -2.0F, 0.5F, -0.4363323129985824F,
                                                0.2617993877991494F, -0.7853981633974483F));

                PartDefinition equipCB03 = equip02.addOrReplaceChild("EquipCB03",
                                CubeListBuilder.create().mirror().texOffs(66, 0)
                                                .addBox(-10.0F, 0.0F, 0.0F, 10.0F, 5.0F, 7.0F),
                                PartPose.offsetAndRotation(-10.0F, -4.0F, 1.0F, -0.3490658503988659F,
                                                0.3490658503988659F, -0.4363323129985824F));

                equipCB03.addOrReplaceChild("EquipCB04b",
                                CubeListBuilder.create().texOffs(11, 8)
                                                .addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F),
                                PartPose.offsetAndRotation(-3.0F, 1.0F, 5.0F, 0.6108652381980153F, 0.0F, 0.0F));

                equipCB03.addOrReplaceChild("EquipCB04a",
                                CubeListBuilder.create().texOffs(9, 4)
                                                .addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F),
                                PartPose.offsetAndRotation(-6.0F, 1.0F, 5.0F, 0.7853981633974483F, 0.0F, 0.0F));

                PartDefinition equipCB01 = equip02.addOrReplaceChild("EquipCB01",
                                CubeListBuilder.create().texOffs(66, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 10.0F, 5.0F, 7.0F),
                                PartPose.offsetAndRotation(10.0F, -4.0F, 1.0F, -0.3490658503988659F,
                                                -0.3490658503988659F, 0.4363323129985824F));

                equipCB01.addOrReplaceChild("EquipCB02a",
                                CubeListBuilder.create().mirror().texOffs(13, 8)
                                                .addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F),
                                PartPose.offsetAndRotation(3.0F, 1.0F, 5.0F, 0.5235987755982988F, 0.0F, 0.0F));

                equipCB01.addOrReplaceChild("EquipCB02b",
                                CubeListBuilder.create().texOffs(13, 8)
                                                .addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F),
                                PartPose.offsetAndRotation(6.0F, 1.0F, 5.0F, 0.8726646259971648F, 0.0F, 0.0F));

                equip02.addOrReplaceChild("Equip03a",
                                CubeListBuilder.create().texOffs(66, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 10.0F, 5.0F, 7.0F),
                                PartPose.offsetAndRotation(10.0F, -2.0F, 0.5F, -0.4363323129985824F,
                                                -0.2617993877991494F, 0.7853981633974483F));

                equipBase.addOrReplaceChild("Equip01b",
                                CubeListBuilder.create().mirror().texOffs(66, 0)
                                                .addBox(-10.0F, 0.0F, 0.0F, 10.0F, 5.0F, 7.0F),
                                PartPose.offsetAndRotation(-6.0F, -3.0F, -5.5F, 0.0F, 0.17453292519943295F,
                                                0.3490658503988659F));

                equipBase.addOrReplaceChild("Equip01a",
                                CubeListBuilder.create().texOffs(66, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 10.0F, 5.0F, 7.0F),
                                PartPose.offsetAndRotation(6.0F, -3.0F, -5.5F, 0.0F, -0.17453292519943295F,
                                                -0.3490658503988659F));

                PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                                CubeListBuilder.create().mirror().texOffs(24, 84)
                                                .addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                                PartPose.offsetAndRotation(-7.8F, -9.0F, -0.7F, 0.0F, 0.4363323129985824F,
                                                0.3490658503988659F));

                PartDefinition armRight02 = armRight01.addOrReplaceChild("ArmRight02",
                                CubeListBuilder.create().mirror().texOffs(24, 84)
                                                .addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
                                PartPose.offset(-3.0F, 11.0F, 2.5F));

                PartDefinition equipRBase = armRight02.addOrReplaceChild("EquipRBase",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                                PartPose.offset(2.0F, 12.0F, -3.0F));

                PartDefinition equipRC02a = equipRBase.addOrReplaceChild("EquipRC02a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.0F, 0.0F, 0.0F, 8.0F, 11.0F, 9.0F),
                                PartPose.offset(0.0F, 1.5F, 0.0F));

                equipRC02a.addOrReplaceChild("EquipRC02b",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 10.0F, 4.0F, 0.03490658503988659F, 0.0F, 0.0F));

                equipRBase.addOrReplaceChild("EquipR04a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 1.0F, 14.0F, 16.0F),
                                PartPose.offsetAndRotation(-7.5F, 1.0F, 1.2F, 0.08726646259971647F, 0.0F, 0.0F));

                equipRBase.addOrReplaceChild("EquipR03a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 1.0F, 17.0F, 9.0F),
                                PartPose.offsetAndRotation(-7.0F, -2.4F, -3.0F, -0.22689280275926282F,
                                                -0.13962634015954636F, 0.0F));

                equipRBase.addOrReplaceChild("EquipR02a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 21.0F, 11.0F),
                                PartPose.offsetAndRotation(-5.0F, -4.0F, -9.0F, -0.5235987755982988F,
                                                -0.17453292519943295F, 0.0F));

                equipRBase.addOrReplaceChild("EquipR06a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 1.0F, 14.0F, 8.0F),
                                PartPose.offsetAndRotation(-9.6F, -3.3F, 24.2F, 0.3490658503988659F,
                                                0.6981317007977318F, 0.2617993877991494F));

                equipRBase.addOrReplaceChild("EquipR04b",
                                CubeListBuilder.create().mirror().texOffs(0, 0)
                                                .addBox(-1.0F, 0.0F, 0.0F, 1.0F, 14.0F, 16.0F),
                                PartPose.offsetAndRotation(7.5F, 1.0F, 1.2F, 0.08726646259971647F, 0.0F, 0.0F));

                equipRBase.addOrReplaceChild("EquipR02b",
                                CubeListBuilder.create().mirror().texOffs(0, 0)
                                                .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 21.0F, 11.0F),
                                PartPose.offsetAndRotation(5.0F, -4.0F, -9.0F, -0.5235987755982988F,
                                                0.17453292519943295F, 0.0F));

                equipRBase.addOrReplaceChild("EquipR01",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.0F, 0.0F, 0.0F, 8.0F, 5.0F, 1.0F),
                                PartPose.offsetAndRotation(1.0F, -2.0F, 0.0F, 0.0F, -1.5707963267948966F, 0.0F));

                equipRBase.addOrReplaceChild("EquipR09",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 12.0F, 8.0F),
                                PartPose.offsetAndRotation(0.0F, -0.2F, 20.6F, 0.3141592653589793F, 0.0F, 0.0F));

                equipRBase.addOrReplaceChild("EquipR05a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 1.0F, 14.0F, 12.0F),
                                PartPose.offsetAndRotation(-6.5F, 0.0F, 13.0F, 0.2617993877991494F,
                                                -0.2617993877991494F, 0.0F));

                PartDefinition equipRC01a = equipRBase.addOrReplaceChild("EquipRC01a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, 0.0F, 0.0F, 9.0F, 12.0F, 7.0F),
                                PartPose.offsetAndRotation(0.0F, 2.0F, -6.0F, 0.13962634015954636F, 0.0F, 0.0F));

                equipRC01a.addOrReplaceChild("EquipRC01b",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F),
                                PartPose.offsetAndRotation(-1.8F, 11.0F, 2.0F, -0.05235987755982988F, 0.0F, 0.0F));

                equipRC01a.addOrReplaceChild("EquipRC01c",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F),
                                PartPose.offsetAndRotation(1.8F, 11.0F, 2.0F, 0.03490658503988659F, 0.0F, 0.0F));

                equipRBase.addOrReplaceChild("EquipR05b",
                                CubeListBuilder.create().mirror().texOffs(0, 0)
                                                .addBox(-1.0F, 0.0F, 0.0F, 1.0F, 14.0F, 12.0F),
                                PartPose.offsetAndRotation(6.5F, 0.0F, 13.0F, 0.2617993877991494F, 0.2617993877991494F,
                                                0.0F));

                PartDefinition equipRC03a = equipRBase.addOrReplaceChild("EquipRC03a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, 0.0F, 0.0F, 9.0F, 11.0F, 7.0F),
                                PartPose.offsetAndRotation(0.0F, 1.0F, 9.0F, -0.17453292519943295F, 0.0F, 0.0F));

                equipRC03a.addOrReplaceChild("EquipRC03b",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F),
                                PartPose.offsetAndRotation(-1.8F, 10.0F, 3.5F, 0.10471975511965977F, 0.0F, 0.0F));

                equipRC03a.addOrReplaceChild("EquipRC03c",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F),
                                PartPose.offsetAndRotation(1.8F, 10.0F, 3.5F, 0.13962634015954636F, 0.0F, 0.0F));

                equipRBase.addOrReplaceChild("EquipR06b",
                                CubeListBuilder.create().mirror().texOffs(0, 0)
                                                .addBox(-1.0F, 0.0F, 0.0F, 1.0F, 14.0F, 8.0F),
                                PartPose.offsetAndRotation(9.6F, -3.3F, 24.2F, 0.3490658503988659F,
                                                -0.6981317007977318F, -0.2617993877991494F));

                equipRBase.addOrReplaceChild("EquipR10",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.0F, 0.0F, 0.0F, 4.0F, 8.0F, 8.0F),
                                PartPose.offsetAndRotation(-6.7F, 1.0F, 14.0F, 0.17453292519943295F,
                                                -0.17453292519943295F, 0.0F));

                equipRBase.addOrReplaceChild("EquipR08",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, 0.0F, 0.0F, 9.0F, 13.0F, 8.0F),
                                PartPose.offsetAndRotation(0.0F, -1.0F, -10.0F, -0.13962634015954636F, 0.0F, 0.0F));

                equipRBase.addOrReplaceChild("EquipR07",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-5.0F, 0.0F, 0.0F, 10.0F, 13.0F, 13.0F),
                                PartPose.offsetAndRotation(0.0F, -4.0F, 29.0F, -0.08726646259971647F, 0.0F, 0.0F));

                equipRBase.addOrReplaceChild("EquipR03b",
                                CubeListBuilder.create().mirror().texOffs(46, 0)
                                                .addBox(-1.0F, 0.0F, 0.0F, 1.0F, 17.0F, 9.0F),
                                PartPose.offsetAndRotation(7.0F, -2.4F, -3.0F, -0.22689280275926282F,
                                                0.13962634015954636F, 0.0F));

                equipRBase.addOrReplaceChild("EquipRC04a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-5.0F, 0.0F, 0.0F, 10.0F, 13.0F, 11.0F),
                                PartPose.offsetAndRotation(0.0F, 2.0F, 12.5F, 0.13962634015954636F, 0.0F, 0.0F));

                armRight02.addOrReplaceChild("GloveR",
                                CubeListBuilder.create().texOffs(2, 34)
                                                .addBox(2.5F, 5.5F, -2.5F, 6.0F, 7.0F, 6.0F),
                                PartPose.offset(-3.0F, 0.0F, -3.0F));

                PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                                CubeListBuilder.create().texOffs(24, 84)
                                                .addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                                PartPose.offsetAndRotation(7.8F, -9.0F, -0.7F, 0.22759093446006054F,
                                                -0.4363323129985824F, -0.3490658503988659F));

                PartDefinition armLeft02 = armLeft01.addOrReplaceChild("ArmLeft02",
                                CubeListBuilder.create().texOffs(24, 84)
                                                .addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
                                PartPose.offset(3.0F, 11.0F, 2.5F));

                PartDefinition equipLBase = armLeft02.addOrReplaceChild("EquipLBase",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                                PartPose.offset(-3.0F, 12.0F, -3.0F));

                equipLBase.addOrReplaceChild("EquipL04a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 1.0F, 14.0F, 16.0F),
                                PartPose.offsetAndRotation(-7.5F, 1.0F, 1.2F, 0.08726646259971647F, 0.0F, 0.0F));

                PartDefinition equipLC01a = equipLBase.addOrReplaceChild("EquipLC01a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, 0.0F, 0.0F, 9.0F, 12.0F, 7.0F),
                                PartPose.offsetAndRotation(0.0F, 2.0F, -6.0F, 0.13962634015954636F, 0.0F, 0.0F));

                equipLC01a.addOrReplaceChild("EquipLC01b",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F),
                                PartPose.offsetAndRotation(-1.8F, 11.0F, 2.0F, -0.05235987755982988F, 0.0F, 0.0F));

                equipLC01a.addOrReplaceChild("EquipLC01c",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F),
                                PartPose.offsetAndRotation(1.8F, 11.0F, 2.0F, 0.03490658503988659F, 0.0F, 0.0F));

                equipLBase.addOrReplaceChild("EquipL06b",
                                CubeListBuilder.create().mirror().texOffs(0, 0)
                                                .addBox(-1.0F, 0.0F, 0.0F, 1.0F, 14.0F, 8.0F),
                                PartPose.offsetAndRotation(9.6F, -3.3F, 24.2F, 0.3490658503988659F,
                                                -0.6981317007977318F, -0.2617993877991494F));

                PartDefinition equipLC02a = equipLBase.addOrReplaceChild("EquipLC02a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.0F, 0.0F, 0.0F, 8.0F, 11.0F, 9.0F),
                                PartPose.offset(0.0F, 1.5F, 0.0F));

                equipLC02a.addOrReplaceChild("EquipLC02b",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F),
                                PartPose.offsetAndRotation(0.0F, 10.0F, 4.0F, 0.03490658503988659F, 0.0F, 0.0F));

                equipLBase.addOrReplaceChild("EquipL08",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, 0.0F, 0.0F, 9.0F, 13.0F, 8.0F),
                                PartPose.offsetAndRotation(0.0F, -1.0F, -10.0F, -0.13962634015954636F, 0.0F, 0.0F));

                equipLBase.addOrReplaceChild("EquipL04b",
                                CubeListBuilder.create().mirror().texOffs(0, 0)
                                                .addBox(-1.0F, 0.0F, 0.0F, 1.0F, 14.0F, 16.0F),
                                PartPose.offsetAndRotation(7.5F, 1.0F, 1.2F, 0.08726646259971647F, 0.0F, 0.0F));

                equipLBase.addOrReplaceChild("EquipL05b",
                                CubeListBuilder.create().mirror().texOffs(0, 0)
                                                .addBox(-1.0F, 0.0F, 0.0F, 1.0F, 14.0F, 12.0F),
                                PartPose.offsetAndRotation(6.5F, 0.0F, 13.0F, 0.2617993877991494F, 0.2617993877991494F,
                                                0.0F));

                PartDefinition equipLC03a = equipLBase.addOrReplaceChild("EquipLC03a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.5F, 0.0F, 0.0F, 9.0F, 11.0F, 7.0F),
                                PartPose.offsetAndRotation(0.0F, 1.0F, 9.0F, -0.17453292519943295F, 0.0F, 0.0F));

                equipLC03a.addOrReplaceChild("EquipLC03b",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F),
                                PartPose.offsetAndRotation(-1.8F, 10.0F, 3.5F, 0.10471975511965977F, 0.0F, 0.0F));

                equipLC03a.addOrReplaceChild("EquipLC03c",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F),
                                PartPose.offsetAndRotation(1.8F, 10.0F, 3.5F, 0.13962634015954636F, 0.0F, 0.0F));

                equipLBase.addOrReplaceChild("EquipL06a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 1.0F, 14.0F, 8.0F),
                                PartPose.offsetAndRotation(-9.6F, -3.3F, 24.2F, 0.3490658503988659F,
                                                0.6981317007977318F, 0.2617993877991494F));

                equipLBase.addOrReplaceChild("EquipL10",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 4.0F, 8.0F, 8.0F),
                                PartPose.offsetAndRotation(6.7F, 1.0F, 14.0F, 0.17453292519943295F,
                                                0.17453292519943295F, 0.0F));

                equipLBase.addOrReplaceChild("EquipL02a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 21.0F, 11.0F),
                                PartPose.offsetAndRotation(-5.0F, -4.0F, -9.0F, -0.5235987755982988F,
                                                -0.17453292519943295F, 0.0F));

                equipLBase.addOrReplaceChild("EquipL07",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-5.0F, 0.0F, 0.0F, 10.0F, 13.0F, 13.0F),
                                PartPose.offsetAndRotation(0.0F, -4.0F, 29.0F, -0.08726646259971647F, 0.0F, 0.0F));

                equipLBase.addOrReplaceChild("EquipL09",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 12.0F, 8.0F),
                                PartPose.offsetAndRotation(0.0F, -0.2F, 20.6F, 0.3141592653589793F, 0.0F, 0.0F));

                equipLBase.addOrReplaceChild("EquipL01",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.0F, 0.0F, 0.0F, 8.0F, 5.0F, 1.0F),
                                PartPose.offsetAndRotation(1.0F, -2.0F, 0.0F, 0.0F, -1.5707963267948966F, 0.0F));

                equipLBase.addOrReplaceChild("EquipLC04a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-5.0F, 0.0F, 0.0F, 10.0F, 13.0F, 11.0F),
                                PartPose.offsetAndRotation(0.0F, 2.0F, 12.5F, 0.13962634015954636F, 0.0F, 0.0F));

                equipLBase.addOrReplaceChild("EquipL05a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 1.0F, 14.0F, 12.0F),
                                PartPose.offsetAndRotation(-6.5F, 0.0F, 13.0F, 0.2617993877991494F,
                                                -0.2617993877991494F, 0.0F));

                equipLBase.addOrReplaceChild("EquipL03a",
                                CubeListBuilder.create().texOffs(46, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 1.0F, 17.0F, 9.0F),
                                PartPose.offsetAndRotation(-7.0F, -2.4F, -3.0F, -0.22689280275926282F,
                                                -0.13962634015954636F, 0.0F));

                equipLBase.addOrReplaceChild("EquipL02b",
                                CubeListBuilder.create().mirror().texOffs(0, 0)
                                                .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 21.0F, 11.0F),
                                PartPose.offsetAndRotation(5.0F, -4.0F, -9.0F, -0.5235987755982988F,
                                                0.17453292519943295F, 0.0F));

                equipLBase.addOrReplaceChild("EquipL03b",
                                CubeListBuilder.create().mirror().texOffs(0, 0)
                                                .addBox(-1.0F, 0.0F, 0.0F, 1.0F, 17.0F, 9.0F),
                                PartPose.offsetAndRotation(7.0F, -2.4F, -3.0F, -0.22689280275926282F,
                                                0.13962634015954636F, 0.0F));

                armLeft02.addOrReplaceChild("GloveL",
                                CubeListBuilder.create().texOffs(2, 34)
                                                .addBox(-2.5F, 5.5F, -2.5F, 6.0F, 7.0F, 6.0F),
                                PartPose.offset(-3.0F, 0.0F, -3.0F));

                PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                                CubeListBuilder.create().texOffs(0, 47)
                                                .addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F),
                                PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));

                PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                                CubeListBuilder.create().mirror().texOffs(0, 84)
                                                .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                                PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.13962634015954636F, 0.0F,
                                                -0.08726646259971647F));

                PartDefinition legRight02 = legRight01.addOrReplaceChild("LegRight02",
                                CubeListBuilder.create().mirror().texOffs(0, 84)
                                                .addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 6.0F),
                                PartPose.offset(-3.0F, 14.0F, -3.0F));

                legRight02.addOrReplaceChild("Shoe02",
                                CubeListBuilder.create().texOffs(0, 33)
                                                .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 6.0F, 7.0F),
                                PartPose.offset(3.0F, 9.0F, 3.0F));

                butt.addOrReplaceChild("Skirt01",
                                CubeListBuilder.create().texOffs(46, 41)
                                                .addBox(-8.5F, 0.0F, -6.0F, 17.0F, 4.0F, 9.0F),
                                PartPose.offsetAndRotation(0.0F, 2.9F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));

                PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                                CubeListBuilder.create().texOffs(0, 84)
                                                .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                                PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.2792526803190927F, 0.0F,
                                                0.08726646259971647F));

                PartDefinition legLeft02 = legLeft01.addOrReplaceChild("LegLeft02",
                                CubeListBuilder.create().texOffs(0, 84)
                                                .addBox(-6.0F, 0.0F, 0.0F, 6.0F, 10.0F, 6.0F),
                                PartPose.offset(3.0F, 14.0F, -3.0F));

                legLeft02.addOrReplaceChild("Shoe01",
                                CubeListBuilder.create().texOffs(0, 33)
                                                .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 6.0F, 7.0F),
                                PartPose.offset(-3.0F, 9.0F, 3.0F));

                bodyMain.addOrReplaceChild("BoobR",
                                CubeListBuilder.create().texOffs(33, 101)
                                                .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 4.0F),
                                PartPose.offsetAndRotation(-3.2F, -9.0F, -3.4F, -0.6981317007977318F,
                                                -0.08726646259971647F, -0.08726646259971647F));

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
                this.EquipLBase.visible = !flag;
                this.EquipRBase.visible = !flag;

                flag = !EmotionHelper.checkModelState(1, state);
                this.EquipBase.visible = !flag;

                flag = !EmotionHelper.checkModelState(2, state);
                this.GloveL.visible = !flag;
                this.GloveR.visible = !flag;
        }

        @Override
        public void syncRotationGlowPart() {
                this.GlowBodyMain.xRot = this.BodyMain.xRot;
                this.GlowBodyMain.yRot = this.BodyMain.yRot;
                this.GlowBodyMain.zRot = this.BodyMain.zRot;
                this.GlowHead.xRot = this.Head.xRot;
                this.GlowHead.yRot = this.Head.yRot;
                this.GlowHead.zRot = this.Head.zRot;
                this.EquipCB02a.xRot = this.Head.xRot;
                this.EquipCB02b.xRot = this.Head.xRot;
                this.EquipCB04a.xRot = this.Head.xRot;
                this.EquipCB04b.xRot = this.Head.xRot;
                this.EquipLC01b.xRot = this.Head.xRot;
                this.EquipLC01c.xRot = this.Head.xRot;
                this.EquipLC02b.xRot = this.Head.xRot;
                this.EquipLC03b.xRot = this.Head.xRot;
                this.EquipLC03c.xRot = this.Head.xRot;
                this.EquipRC01b.xRot = this.Head.xRot;
                this.EquipRC01c.xRot = this.Head.xRot;
                this.EquipRC02b.xRot = this.Head.xRot;
                this.EquipRC03b.xRot = this.Head.xRot;
                this.EquipRC03c.xRot = this.Head.xRot;
        }

        @Override
        public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.66F;
                this.setFaceHungry(ent);

                // body
                this.Head.xRot = 0F;
                this.Head.yRot = 0F;
                this.Head.zRot = 0F;
                this.BodyMain.xRot = 1.4F;
                this.Butt.xRot = 0.21F;
                // arm
                this.ArmLeft01.xRot = -2.9F;
                this.ArmLeft01.yRot = 0F;
                this.ArmLeft01.zRot = 1.2F;
                this.ArmLeft02.xRot = 0F;
                this.ArmLeft02.zRot = 0.6F;
                // this.ArmLeft02.offsetX = 0F;
                // this.ArmLeft02.offsetZ = 0F;
                this.ArmRight01.xRot = -2.9F;
                this.ArmRight01.yRot = 0F;
                this.ArmRight01.zRot = -1.2F;
                this.ArmRight02.xRot = 0F;
                this.ArmRight02.zRot = -0.6F;
                // this.ArmRight02.offsetX = 0F;
                // this.ArmRight02.offsetZ = 0F;
                // leg
                this.LegLeft01.xRot = -0.05F;
                this.LegLeft01.yRot = 0F;
                this.LegLeft01.zRot = -0.4F;
                this.LegLeft02.xRot = 0F;
                this.LegLeft02.yRot = 0F;
                this.LegLeft02.zRot = 0.8F;
                // this.LegLeft02.offsetX = 0F;
                // this.LegLeft02.offsetY = 0F;
                // this.LegLeft02.offsetZ = 0F;
                this.LegRight01.xRot = -0.05F;
                this.LegRight01.yRot = 0F;
                this.LegRight01.zRot = 0.4F;
                this.LegRight02.xRot = 0F;
                this.LegRight02.yRot = 0F;
                this.LegRight02.zRot = -0.8F;
                // this.LegRight02.offsetX = 0F;
                // this.LegRight02.offsetY = 0F;
                // this.LegRight02.offsetZ = 0F;
                // equip
                this.EquipLBase.xRot = 0.3F;
                this.EquipLBase.yRot = 1.8F;
                this.EquipLBase.zRot = 0F;
                this.EquipRBase.xRot = 0.3F;
                this.EquipRBase.yRot = -1.8F;
                this.EquipRBase.zRot = 0F;
        }

        @Override
        public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

                float angleX = Mth.cos(f2 * 0.08F + f * 0.25F);
                float angleX1 = Mth.cos(f2 * 0.1F + 0.3F + f * 0.5F);
                float angleAdd1 = Mth.cos(f * 0.7F) * f1;
                float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
                float addk1 = 0;
                float addk2 = 0;
                float headX = 0F;
                float headZ = 0F;
                float t2 = ent.getTickExisted() & 511;
                boolean spStand = false;
                boolean showWeapon = EmotionHelper.checkModelState(0, ent.getStateEmotion(ID.S.State));

                // 水上漂浮
                if (ent.getShipDepth(0) > 0D) {
                        this.offsetY += angleX * 0.05F + 0.025F;
                }

                // leg move
                addk1 = angleAdd1 * 0.5F - 0.28F; // LegLeft01
                addk2 = angleAdd2 * 0.5F - 0.21F; // LegRight01

                // head
                this.Head.xRot = f4 * 0.01745F;
                this.Head.yRot = f3 * 0.01F;
                // boob
                this.BoobL.xRot = angleX * 0.06F - 0.67F;
                this.BoobR.xRot = angleX * 0.06F - 0.67F;
                // body
                this.Ahoke.zRot = angleX * 0.03F + 0.3F;
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += -0.12F;
                this.BodyMain.xRot = -0.1047F;
                this.BodyMain.yRot = 0F;
                this.BodyMain.zRot = 0F;
                this.Butt.xRot = 0.35F;
                // hair
                this.Hair01.xRot = angleX * 0.03F + 0.14F + headX;
                this.Hair01.zRot = 0F;
                this.Hair02.xRot = -angleX1 * 0.04F - 0.12F + headX;
                this.Hair02.zRot = 0F;
                // arm
                if (showWeapon) {
                        this.ArmLeft01.zRot = angleX * 0.03F - 0.3F;
                        this.ArmRight01.zRot = -angleX * 0.03F + 0.3F;
                } else {
                        this.ArmLeft01.zRot = angleX * 0.03F - 0.15F;
                        this.ArmRight01.zRot = -angleX * 0.03F + 0.15F;
                }
                this.ArmLeft01.xRot = angleAdd2 * 0.4F + 0.1F;
                this.ArmLeft01.yRot = 0F;
                this.ArmLeft02.xRot = 0F;
                this.ArmLeft02.zRot = 0F;
                // this.ArmLeft02.offsetX = 0F;
                // this.ArmLeft02.offsetZ = 0F;
                this.ArmRight01.xRot = angleAdd1 * 0.4F;
                this.ArmRight01.yRot = 0F;
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
                this.EquipLBase.xRot = 0F;
                this.EquipLBase.yRot = 0F;
                this.EquipLBase.zRot = 0F;
                this.EquipRBase.xRot = 0F;
                this.EquipRBase.yRot = 0F;
                this.EquipRBase.zRot = 0F;
                this.EquipCB02a.xRot = this.Head.xRot * 0.9F + 0.8F;
                this.EquipCB02b.xRot = this.Head.xRot * 0.8F + 0.9F;
                this.EquipCB04a.xRot = this.Head.xRot * 1.1F + 0.7F;
                this.EquipCB04b.xRot = this.Head.xRot * 0.9F + 0.8F;
                this.EquipLC01b.xRot = this.Head.xRot * 0.9F - 0.05F;
                this.EquipLC01c.xRot = this.Head.xRot * 0.8F - 0.08F;
                this.EquipLC02b.xRot = this.Head.xRot * 1.1F + 0.1F;
                this.EquipLC03b.xRot = this.Head.xRot * 0.9F + 0.05F;
                this.EquipLC03c.xRot = this.Head.xRot * 0.8F + 0.08F;
                this.EquipRC01b.xRot = this.Head.xRot * 0.9F - 0.05F;
                this.EquipRC01c.xRot = this.Head.xRot * 0.8F - 0.08F;
                this.EquipRC02b.xRot = this.Head.xRot * 1.1F + 0.1F;
                this.EquipRC03b.xRot = this.Head.xRot * 0.9F + 0.05F;
                this.EquipRC03c.xRot = this.Head.xRot * 0.8F + 0.08F;

                // special stand pos
                if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED &&
                                showWeapon && t2 > 400) {
                        spStand = true;

                        setFace(1);
                        // body
                        // [PORT] Restored from 1.10.2 GlStateManager.translate
                        this.offsetY += 0.12F;
                        this.BodyMain.xRot = 1.0471975511965976F;
                        this.BodyMain.yRot = 0.0F;
                        this.BodyMain.zRot = 0.0F;
                        this.Head.xRot -= 0.18203784098300857F;
                        // arm
                        this.ArmLeft01.xRot = -1.0471975511965976F;
                        this.ArmLeft01.yRot = 0.0F;
                        this.ArmLeft01.zRot = -0.3490658503988659F;
                        this.ArmRight01.xRot = -1.0471975511965976F;
                        this.ArmRight01.yRot = 0.0F;
                        this.ArmRight01.zRot = 0.3490658503988659F;
                        // leg
                        addk1 = -1.3962634015954636F;
                        addk2 = -1.3962634015954636F;
                        this.LegLeft01.yRot = 0.0F;
                        this.LegLeft01.zRot = 0.08726646259971647F;
                        this.LegRight01.yRot = 0.0F;
                        this.LegRight01.zRot = -0.08726646259971647F;
                }

                if (ent.getIsSprinting() || f1 > 0.9F) {
                        if (spStand)

                                // body
                                // [PORT] Restored from 1.10.2 GlStateManager.translate
                                this.offsetY += -0.12F;
                                this.BodyMain.xRot = -0.1F;
                        this.BodyMain.yRot = 0F;
                        this.BodyMain.zRot = 0F;
                        // arm
                        if (showWeapon) {
                                this.ArmLeft01.xRot = angleAdd2 * 0.05F + 0.5F;
                                this.ArmRight01.xRot = angleAdd1 * 0.05F + 0.5F;
                        } else {
                                this.ArmLeft01.xRot = angleAdd2 * 0.9F + 0.5F;
                                this.ArmRight01.xRot = angleAdd1 * 0.9F + 0.5F;
                        }
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
                        addk1 = angleAdd1 * 0.7F - 0.28F;
                        addk2 = angleAdd2 * 0.7F - 0.21F;
                        this.LegLeft01.yRot = 0F;
                        this.LegLeft01.zRot = 0.0873F;
                        this.LegRight01.yRot = 0F;
                        this.LegRight01.zRot = -0.0873F;
                        // equip
                        this.EquipLBase.xRot = 0.5F;
                        this.EquipLBase.yRot = 0F;
                        this.EquipLBase.zRot = 0F;
                        this.EquipRBase.xRot = 0.5F;
                        this.EquipRBase.yRot = 0F;
                        this.EquipRBase.zRot = 0F;
                }

                // head tilt angle
                this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

                if (ent.getIsSneaking()) {
                        if (spStand)

                                // Body
                                // [PORT] Restored from 1.10.2 GlStateManager.translate
                                this.offsetY += -0.12F;
                                this.Head.xRot -= 0.6283F;
                        this.BodyMain.xRot = 0.8727F;
                        // arm
                        if (showWeapon) {
                                this.ArmLeft01.xRot = angleAdd2 * 0.05F + 0.5F;
                                this.ArmLeft01.zRot = -0.25F;
                                this.ArmLeft02.xRot = -1F;
                                this.ArmRight01.xRot = angleAdd1 * 0.05F + 0.5F;
                                this.ArmRight01.zRot = 0.25F;
                                this.ArmRight02.xRot = -1F;
                        } else {
                                this.ArmLeft01.xRot = -0.35F;
                                this.ArmLeft01.zRot = 0.2618F;
                                this.ArmLeft02.xRot = 0F;
                                this.ArmRight01.xRot = -0.35F;
                                this.ArmRight01.zRot = -0.2618F;
                                this.ArmRight02.xRot = 0F;
                        }
                        this.ArmLeft01.yRot = 0F;
                        this.ArmLeft02.zRot = 0F;
                        // this.ArmLeft02.offsetX = 0F;
                        // this.ArmLeft02.offsetZ = 0F;
                        this.ArmRight01.yRot = 0F;
                        this.ArmRight02.zRot = 0F;
                        // this.ArmRight02.offsetX = 0F;
                        // this.ArmRight02.offsetZ = 0F;
                        // leg
                        addk1 -= 1.1F;
                        addk2 -= 1.1F;
                        // hair
                        this.Hair01.xRot += 0.37F;
                        this.Hair02.xRot += 0.23F;
                } // end if sneaking

                // 坐下動作
                if (ent.getIsSitting() || ent.getIsRiding()) {
                        if (spStand)

                                // [PORT] Restored from 1.10.2 GlStateManager.translate
                                this.offsetY += -0.12F;
                                if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                                        // body
                                        // [PORT] Restored from 1.10.2 GlStateManager.translate
                                        this.offsetY += 0.25F;
                                        this.BodyMain.xRot = -0.10471975511965977F;
                                        this.BodyMain.yRot = -0.3490658503988659F;
                                        this.BodyMain.zRot = 0.0F;
                                        this.Head.yRot -= 0.5235987755982988F;
                                        // arm
                                        this.ArmLeft01.xRot = 0.8726646259971648F;
                                        this.ArmLeft01.yRot = 0.0F;
                                        this.ArmLeft01.zRot = -0.3490658503988659F;
                                        this.ArmLeft02.xRot = -0.7853981633974483F;
                                        this.ArmLeft02.yRot = 0.0F;
                                        this.ArmLeft02.zRot = 0.0F;
                                        this.ArmRight01.xRot = -0.4363323129985824F;
                                        this.ArmRight01.yRot = 0.0F;
                                        this.ArmRight01.zRot = 0.3490658503988659F;
                                        this.ArmRight02.xRot = -0.8726646259971648F;
                                        this.ArmRight02.yRot = 0.0F;
                                        this.ArmRight02.zRot = 0.0F;
                                        // leg
                                        addk1 = -1.48352986419518F;
                                        addk2 = -0.4363323129985824F;
                                        this.LegLeft01.yRot = 0.0F;
                                        this.LegLeft01.zRot = 0.08726646259971647F;
                                        this.LegLeft02.xRot = 1.3962634015954636F;
                                        this.LegLeft02.yRot = 0.0F;
                                        this.LegLeft02.zRot = 0.0F;
                                        this.LegRight01.yRot = 0.0F;
                                        this.LegRight01.zRot = -0.08726646259971647F;
                                        this.LegRight02.xRot = 1.48352986419518F;
                                        this.LegRight02.yRot = 0.0F;
                                        this.LegRight02.zRot = 0.0F;
                                } else if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED &&
                                                showWeapon) {
                                        // body
                                        // [PORT] Restored from 1.10.2 GlStateManager.translate
                                        this.offsetY += 0.52F;
                                        this.BodyMain.xRot = 0.7853981633974483F;
                                        this.Butt.xRot = 0.2617993877991494F;
                                        this.Head.xRot = 0.5235987755982988F;
                                        // hair
                                        this.Hair01.xRot = -0.3490658503988659F;
                                        this.Hair02.xRot = -0.12217304763960307F;
                                        // arm
                                        this.ArmLeft01.xRot = 2.6179938779914944F;
                                        this.ArmLeft01.yRot = 0.0F;
                                        this.ArmLeft01.zRot = 0.0F;
                                        this.ArmRight01.xRot = 2.6179938779914944F;
                                        this.ArmRight01.yRot = 0.0F;
                                        this.ArmRight01.zRot = 0.0F;
                                        // leg
                                        addk1 = 0.2617993877991494F;
                                        addk2 = 0.2617993877991494F;
                                        this.LegLeft01.yRot = 0.0F;
                                        this.LegLeft01.zRot = 0.08726646259971647F;
                                        this.LegLeft02.xRot = 0.2617993877991494F;
                                        this.LegLeft02.yRot = 0.0F;
                                        this.LegLeft02.zRot = 0.0F;
                                        this.LegRight01.yRot = 0.0F;
                                        this.LegRight01.zRot = -0.08726646259971647F;
                                        this.LegRight02.xRot = 0.2617993877991494F;
                                        this.LegRight02.yRot = 0.0F;
                                        this.LegRight02.zRot = 0.0F;
                                        // equip
                                        this.EquipLBase.xRot = 1.2217304763960306F;
                                        this.EquipLBase.yRot = 0.0F;
                                        this.EquipLBase.zRot = 0.0F;
                                        this.EquipRBase.xRot = 1.2217304763960306F;
                                        this.EquipRBase.yRot = 0.0F;
                                        this.EquipRBase.zRot = 0.0F;
                                } else if (!this.EquipLBase.visible) {
                                        // body
                                        // [PORT] Restored from 1.10.2 GlStateManager.translate
                                        this.offsetY += 0.2F;
                                        this.BodyMain.xRot = 0.18203784098300857F;
                                        this.Butt.xRot = 0.2617993877991494F;
                                        this.Head.xRot -= 0.20943951023931953F;
                                        // arm
                                        this.ArmLeft01.xRot = 0.13962634015954636F;
                                        this.ArmLeft01.yRot = 0.0F;
                                        this.ArmLeft01.zRot = -0.3490658503988659F;
                                        this.ArmRight01.xRot = -1.1838568316277536F;
                                        this.ArmRight01.yRot = 0.8F;
                                        this.ArmRight01.zRot = 0.0F;
                                        this.ArmRight02.xRot = -1.3089969389957472F;
                                        this.ArmRight02.yRot = 0.0F;
                                        this.ArmRight02.zRot = 0.0F;
                                        // leg
                                        addk1 = -1.61F;
                                        addk2 = -1.57F;
                                        this.LegLeft01.yRot = 0.0F;
                                        this.LegLeft01.zRot = 0.08726646259971647F;
                                        this.LegLeft02.xRot = 1.5F;
                                        this.LegLeft02.yRot = 0.0F;
                                        this.LegLeft02.zRot = 0.0F;
                                        this.LegRight01.yRot = 0.0F;
                                        this.LegRight01.zRot = -0.08726646259971647F;
                                        this.LegRight02.xRot = 0.6F;
                                        this.LegRight02.yRot = 0.0F;
                                        this.LegRight02.zRot = 0.0F;
                                        // equip
                                        this.EquipLBase.xRot = 0.0F;
                                        this.EquipLBase.yRot = -1.5707963267948966F;
                                        this.EquipLBase.zRot = 0.3141592653589793F;
                                        this.EquipRBase.xRot = 0.7285004297824331F;
                                        this.EquipRBase.yRot = 0.0F;
                                        this.EquipRBase.zRot = 0.0F;
                                } else {
                                        this.EquipLBase.visible = false;
                                        this.EquipRBase.visible = false;
                                        // body
                                        this.BodyMain.xRot = 0.27314402793711257F;
                                        this.Butt.xRot = 0.2617993877991494F;
                                        this.Head.xRot -= 0.41887902047863906F;
                                        // arm
                                        this.ArmLeft01.xRot = 0.091106186954104F;
                                        this.ArmLeft01.yRot = 0.0F;
                                        this.ArmLeft01.zRot = -0.6373942428283291F;
                                        this.ArmLeft02.xRot = 0.0F;
                                        this.ArmLeft02.yRot = 0.0F;
                                        this.ArmLeft02.zRot = 1.3658946726107624F;
                                        this.ArmRight01.xRot = -0.85F;
                                        this.ArmRight01.yRot = 0.0F;
                                        this.ArmRight01.zRot = 0.0F;
                                        this.ArmRight02.xRot = 0.0F;
                                        this.ArmRight02.yRot = 0.0F;
                                        this.ArmRight02.zRot = -0.5009094953223726F;
                                        // leg
                                        addk1 = -1.2747884856566583F;
                                        addk2 = -2.1399481958702475F;
                                        this.LegLeft01.yRot = 0.0F;
                                        this.LegLeft01.zRot = 0.08726646259971647F;
                                        this.LegLeft02.xRot = 2.321986036853256F;
                                        this.LegLeft02.yRot = 0.0F;
                                        this.LegLeft02.zRot = 0.0F;
                                        // this.LegLeft02.offsetZ = 0.375F;
                                        this.LegRight01.yRot = 0.0F;
                                        this.LegRight01.zRot = -0.08726646259971647F;
                                        this.LegRight02.xRot = 1.5707963267948966F;
                                        this.LegRight02.yRot = 0.0F;
                                        this.LegRight02.zRot = 0.0F;
                                }
                } // end if sitting

                // 攻擊動作: 設為30~50會有揮刀動作, 設為100則沒有揮刀動作
                if (ent.getAttackTick() > 0) {
                        if (spStand)

                                // body
                                this.BodyMain.xRot = -0.1047F;
                        this.BodyMain.yRot = 0F;
                        this.BodyMain.zRot = 0F;
                        this.Butt.xRot = 0.35F;
                        // arm
                        if (showWeapon) {
                                this.ArmLeft02.xRot = -0.8726646259971648F;
                                this.ArmRight02.xRot = -0.8726646259971648F;
                        } else {
                                this.ArmLeft02.xRot = 0F;
                                this.ArmRight02.xRot = 0F;
                        }
                        this.ArmLeft01.xRot = -0.5235987755982988F;
                        this.ArmLeft01.yRot = -0.5235987755982988F;
                        this.ArmLeft01.zRot = -0.2617993877991494F;
                        this.ArmLeft02.yRot = 0.0F;
                        this.ArmLeft02.zRot = 0.0F;
                        this.ArmRight01.xRot = -0.5235987755982988F;
                        this.ArmRight01.yRot = 0.5235987755982988F;
                        this.ArmRight01.zRot = 0.2617993877991494F;
                        this.ArmRight02.yRot = 0.0F;
                        this.ArmRight02.zRot = 0.0F;
                        // leg move
                        addk1 = angleAdd1 * 0.5F - 0.28F;
                        addk2 = angleAdd2 * 0.5F - 0.21F;
                        // equip
                        this.EquipLBase.xRot = 0.0F;
                        this.EquipLBase.yRot = -0.2617993877991494F;
                        this.EquipLBase.zRot = 0.3490658503988659F;
                        this.EquipRBase.xRot = 0.0F;
                        this.EquipRBase.yRot = 0.2617993877991494F;
                        this.EquipRBase.zRot = -0.3490658503988659F;
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

                // 頭毛左右彎曲調整
                headX = this.Head.xRot * -0.5F;
                this.Hair01.xRot += headX;
                this.Hair02.xRot += headX;
                this.HairL01.xRot = angleX * 0.02F + headX - 0.09F;
                this.HairL02.xRot = -angleX1 * 0.04F + headX + 0.12F;
                this.HairR01.xRot = angleX * 0.02F + headX - 0.09F;
                this.HairR02.xRot = -angleX1 * 0.04F + headX + 0.12F;
                headZ = this.Head.zRot * -0.5F;
                this.Hair01.zRot = headZ;
                this.Hair02.zRot = headZ;
                this.HairL01.zRot = headZ + 0.05F;
                this.HairL02.zRot = headZ - 0.09F;
                this.HairR01.zRot = headZ - 0.05F;
                this.HairR02.zRot = headZ + 0.09F;

                // leg motion
                this.LegLeft01.xRot = addk1;
                this.LegRight01.xRot = addk2;
        }
}
