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

public class ModelDestroyerHime extends ShipModelBaseAdv<Entity> {

        public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
                        new ResourceLocation(Reference.MOD_ID, "dd_hime"), "main");

        private final ModelPart BodyMain;
        private final ModelPart Neck;
        private final ModelPart Butt;
        private final ModelPart ArmRight01;
        private final ModelPart ArmLeft01;
        private final ModelPart Cloth01;
        private final ModelPart Head;
        private final ModelPart Hair;
        private final ModelPart HairMain;
        private final ModelPart Hair02;
        private final ModelPart Hat01;
        private final ModelPart HairU01;
        private final ModelPart Ahoke;
        private final ModelPart HairL01;
        private final ModelPart HairR01;
        private final ModelPart Hair01;
        private final ModelPart Hair03;
        private final ModelPart Hair04;
        private final ModelPart Hair05;
        private final ModelPart Hair06;
        private final ModelPart Hat02a;
        private final ModelPart Hat03;
        private final ModelPart Hat04a;
        private final ModelPart Hat05a;
        private final ModelPart Hat06a;
        private final ModelPart Hat06b;
        private final ModelPart Hat02b;
        private final ModelPart Hat04b;
        private final ModelPart Hat04c;
        private final ModelPart Hat05b;
        private final ModelPart LegLeft01;
        private final ModelPart LegRight01;
        private final ModelPart EquipLegL;
        private final ModelPart EquipLegR;
        private final ModelPart EquipBaseL;
        private final ModelPart EquipBaseR;
        private final ModelPart BeltBase;
        private final ModelPart LegLeft02;
        private final ModelPart LegRight02;
        private final ModelPart EquipLHead;
        private final ModelPart EquipLJaw;
        private final ModelPart EquipLB;
        private final ModelPart EquipLT01;
        private final ModelPart EquipLTU;
        private final ModelPart EquipHeadC01;
        private final ModelPart EquipHeadC02;
        private final ModelPart EquipLTD;
        private final ModelPart EquipLT02a;
        private final ModelPart EquipLT02b;
        private final ModelPart EquipLT02c;
        private final ModelPart EquipLT02d;
        private final ModelPart EquipRHead;
        private final ModelPart EquipLJaw_1;
        private final ModelPart EquipLB_1;
        private final ModelPart EquipLT01_1;
        private final ModelPart EquipLTU_1;
        private final ModelPart EquipHeadC01_1;
        private final ModelPart EquipHeadC02_1;
        private final ModelPart EquipLTD_1;
        private final ModelPart EquipLT02a_1;
        private final ModelPart EquipLT02b_1;
        private final ModelPart EquipLT02c_1;
        private final ModelPart EquipLT02d_1;
        private final ModelPart Belt01;
        private final ModelPart Belt02;
        private final ModelPart Belt03;
        private final ModelPart Belt04;
        private final ModelPart Belt05;
        private final ModelPart Belt06;
        private final ModelPart Belt07;
        private final ModelPart ArmRight02;
        private final ModelPart ArmRight02a;
        private final ModelPart ArmLeft02;
        private final ModelPart ArmLeft02a;
        private final ModelPart Cannon01;
        private final ModelPart Cannon02;
        private final ModelPart Cannon03;
        private final ModelPart Cannon04;
        private final ModelPart Cannon05;
        private final ModelPart Cloth02;
        private final ModelPart Skirt01;
        private final ModelPart GlowBodyMain;
        private final ModelPart GlowNeck;
        private final ModelPart GlowHead;

        public ModelDestroyerHime(ModelPart root) {
                super();
                this.scale = 0.38F;
                this.offsetY = 2.47F;
                this.BodyMain = root.getChild("BodyMain");
                this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
                this.Butt = this.BodyMain.getChild("Butt");
                this.Cloth01 = this.BodyMain.getChild("Cloth01");
                this.Neck = this.BodyMain.getChild("Neck");
                this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
                this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
                this.EquipLegL = this.Butt.getChild("EquipLegL");
                this.Skirt01 = this.Butt.getChild("Skirt01");
                this.EquipLegR = this.Butt.getChild("EquipLegR");
                this.BeltBase = this.Butt.getChild("BeltBase");
                this.LegLeft01 = this.Butt.getChild("LegLeft01");
                this.LegRight01 = this.Butt.getChild("LegRight01");
                this.EquipBaseL = this.Butt.getChild("EquipBaseL");
                this.EquipBaseR = this.Butt.getChild("EquipBaseR");
                this.Cloth02 = this.Cloth01.getChild("Cloth02");
                this.Head = this.Neck.getChild("Head");
                this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
                this.ArmRight02a = this.ArmRight02.getChild("ArmRight02a");
                this.Belt05 = this.BeltBase.getChild("Belt05");
                this.Belt01 = this.BeltBase.getChild("Belt01");
                this.Belt02 = this.BeltBase.getChild("Belt02");
                this.Belt06 = this.BeltBase.getChild("Belt06");
                this.Belt03 = this.BeltBase.getChild("Belt03");
                this.Belt07 = this.BeltBase.getChild("Belt07");
                this.Belt04 = this.BeltBase.getChild("Belt04");
                this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
                this.LegRight02 = this.LegRight01.getChild("LegRight02");
                this.EquipLHead = this.EquipBaseL.getChild("EquipLHead");
                this.EquipLT01 = this.EquipBaseL.getChild("EquipLT01");
                this.EquipLJaw = this.EquipBaseL.getChild("EquipLJaw");
                this.EquipLB = this.EquipBaseL.getChild("EquipLB");
                this.EquipRHead = this.EquipBaseR.getChild("EquipRHead");
                this.EquipLT01_1 = this.EquipBaseR.getChild("EquipLT01_1");
                this.EquipLJaw_1 = this.EquipBaseR.getChild("EquipLJaw_1");
                this.EquipLB_1 = this.EquipBaseR.getChild("EquipLB_1");
                this.Hair = this.Head.getChild("Hair");
                this.Hair02 = this.Head.getChild("Hair02");
                this.HairMain = this.Head.getChild("HairMain");
                this.Hat01 = this.Head.getChild("Hat01");
                this.ArmLeft02a = this.ArmLeft02.getChild("ArmLeft02a");
                this.Cannon01 = this.ArmLeft02.getChild("Cannon01");
                this.EquipLTU = this.EquipLHead.getChild("EquipLTU");
                this.EquipHeadC01 = this.EquipLHead.getChild("EquipHeadC01");
                this.EquipLT02b = this.EquipLT01.getChild("EquipLT02b");
                this.EquipLT02d = this.EquipLT01.getChild("EquipLT02d");
                this.EquipLT02c = this.EquipLT01.getChild("EquipLT02c");
                this.EquipLT02a = this.EquipLT01.getChild("EquipLT02a");
                this.EquipLTD = this.EquipLJaw.getChild("EquipLTD");
                this.EquipLTU_1 = this.EquipRHead.getChild("EquipLTU_1");
                this.EquipHeadC01_1 = this.EquipRHead.getChild("EquipHeadC01_1");
                this.EquipLT02a_1 = this.EquipLT01_1.getChild("EquipLT02a_1");
                this.EquipLT02b_1 = this.EquipLT01_1.getChild("EquipLT02b_1");
                this.EquipLT02d_1 = this.EquipLT01_1.getChild("EquipLT02d_1");
                this.EquipLT02c_1 = this.EquipLT01_1.getChild("EquipLT02c_1");
                this.EquipLTD_1 = this.EquipLJaw_1.getChild("EquipLTD_1");
                this.HairR01 = this.Hair.getChild("HairR01");
                this.HairL01 = this.Hair.getChild("HairL01");
                this.Ahoke = this.Hair.getChild("Ahoke");
                this.HairU01 = this.Hair.getChild("HairU01");
                this.Hair03 = this.Hair02.getChild("Hair03");
                this.Hair01 = this.HairMain.getChild("Hair01");
                this.Hat04a = this.Hat01.getChild("Hat04a");
                this.Hat05a = this.Hat01.getChild("Hat05a");
                this.Hat03 = this.Hat01.getChild("Hat03");
                this.Hat02b = this.Hat01.getChild("Hat02b");
                this.Hat06b = this.Hat01.getChild("Hat06b");
                this.Hat02a = this.Hat01.getChild("Hat02a");
                this.Hat06a = this.Hat01.getChild("Hat06a");
                this.Cannon03 = this.Cannon01.getChild("Cannon03");
                this.Cannon04 = this.Cannon01.getChild("Cannon04");
                this.Cannon02 = this.Cannon01.getChild("Cannon02");
                this.Cannon05 = this.Cannon01.getChild("Cannon05");
                this.EquipHeadC02 = this.EquipHeadC01.getChild("EquipHeadC02");
                this.EquipHeadC02_1 = this.EquipHeadC01_1.getChild("EquipHeadC02_1");
                this.Hair04 = this.Hair03.getChild("Hair04");
                this.Hat04b = this.Hat04a.getChild("Hat04b");
                this.Hat05b = this.Hat05a.getChild("Hat05b");
                this.Hair05 = this.Hair04.getChild("Hair05");
                this.Hat04c = this.Hat04b.getChild("Hat04c");
                this.Hair06 = this.Hair05.getChild("Hair06");

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

                PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                                CubeListBuilder.create().mirror().texOffs(24, 86)
                                                .addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                                PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, 0.2617993877991494F, 0.0F,
                                                0.7853981633974483F));

                PartDefinition armRight02 = armRight01.addOrReplaceChild("ArmRight02",
                                CubeListBuilder.create().mirror().texOffs(24, 69)
                                                .addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
                                PartPose.offset(-3.0F, 11.0F, 2.5F));

                armRight02.addOrReplaceChild("ArmRight02a",
                                CubeListBuilder.create().mirror().texOffs(0, 0)
                                                .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F),
                                PartPose.offsetAndRotation(2.5F, 6.5F, -2.4F, 0.05235987755982988F, 0.0F, 0.0F));

                PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                                CubeListBuilder.create().texOffs(0, 47)
                                                .addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F),
                                PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));

                butt.addOrReplaceChild("EquipLegL",
                                CubeListBuilder.create().texOffs(19, 3)
                                                .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 9.0F, 7.0F),
                                PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.2792526803190927F, 0.0F,
                                                0.08726646259971647F));

                butt.addOrReplaceChild("Skirt01",
                                CubeListBuilder.create().texOffs(74, 10)
                                                .addBox(-8.5F, 0.0F, -6.0F, 17.0F, 7.0F, 10.0F),
                                PartPose.offsetAndRotation(0.0F, 2.5F, -0.5F, -0.20943951023931953F, 0.0F, 0.0F));

                butt.addOrReplaceChild("EquipLegR",
                                CubeListBuilder.create().texOffs(9, 0)
                                                .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 9.0F, 7.0F),
                                PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.20943951023931953F, 0.0F,
                                                -0.08726646259971647F));

                PartDefinition beltBase = butt.addOrReplaceChild("BeltBase",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.08726646259971647F, 0.0F, 0.0F));

                beltBase.addOrReplaceChild("Belt05",
                                CubeListBuilder.create().texOffs(0, 2)
                                                .addBox(0.0F, 0.0F, -1.0F, 9.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(0.0F, -1.0F, 4.0F, 0.0F, 0.10471975511965977F, 0.0F));

                beltBase.addOrReplaceChild("Belt01",
                                CubeListBuilder.create().texOffs(0, 8)
                                                .addBox(-9.0F, 0.0F, 0.0F, 9.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(0.0F, -1.0F, -8.0F, 0.0F, 0.10471975511965977F, 0.0F));

                beltBase.addOrReplaceChild("Belt02",
                                CubeListBuilder.create().texOffs(0, 13)
                                                .addBox(0.0F, 0.0F, 0.0F, 9.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(0.0F, -1.0F, -8.0F, 0.0F, -0.10471975511965977F, 0.0F));

                beltBase.addOrReplaceChild("Belt06",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-9.0F, 0.0F, -1.0F, 9.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(0.0F, -1.0F, 4.0F, 0.0F, -0.10471975511965977F, 0.0F));

                beltBase.addOrReplaceChild("Belt03",
                                CubeListBuilder.create().texOffs(0, 11)
                                                .addBox(0.0F, 0.0F, 0.0F, 9.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(-8.9F, -1.0F, 2.8F, 0.0F, 1.5707963267948966F, 0.0F));

                beltBase.addOrReplaceChild("Belt07",
                                CubeListBuilder.create().texOffs(0, 34)
                                                .addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 4.0F),
                                PartPose.offsetAndRotation(8.8F, -2.1F, -4.0F, -0.5235987755982988F, 0.0F, 0.0F));

                beltBase.addOrReplaceChild("Belt04",
                                CubeListBuilder.create().texOffs(0, 6)
                                                .addBox(-9.0F, 0.0F, 0.0F, 9.0F, 4.0F, 1.0F),
                                PartPose.offsetAndRotation(8.9F, -1.0F, 2.8F, 0.0F, -1.5707963267948966F, 0.0F));

                PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                                CubeListBuilder.create().texOffs(0, 84)
                                                .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                                PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.2792526803190927F, 0.0F,
                                                0.08726646259971647F));

                legLeft01.addOrReplaceChild("LegLeft02",
                                CubeListBuilder.create().texOffs(0, 63)
                                                .addBox(-6.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                                PartPose.offset(3.0F, 14.0F, -3.0F));

                PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                                CubeListBuilder.create().mirror().texOffs(0, 84)
                                                .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                                PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.20943951023931953F, 0.0F,
                                                -0.08726646259971647F));

                legRight01.addOrReplaceChild("LegRight02",
                                CubeListBuilder.create().mirror().texOffs(0, 63)
                                                .addBox(0.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                                PartPose.offset(-3.0F, 14.0F, -3.0F));

                PartDefinition equipBaseL = butt.addOrReplaceChild("EquipBaseL",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, -3.0F, -3.0F, 16.0F, 6.0F, 6.0F),
                                PartPose.offsetAndRotation(7.0F, 10.0F, -3.0F, 0.05235987755982988F,
                                                -0.13962634015954636F, 0.13962634015954636F));

                PartDefinition equipLHead = equipBaseL.addOrReplaceChild("EquipLHead",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-5.5F, -6.0F, -10.0F, 11.0F, 6.0F, 14.0F),
                                PartPose.offsetAndRotation(9.0F, -2.0F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));

                equipLHead.addOrReplaceChild("EquipLTU",
                                CubeListBuilder.create().texOffs(47, 29)
                                                .addBox(-4.5F, 0.0F, -9.0F, 9.0F, 4.0F, 9.0F),
                                PartPose.offsetAndRotation(0.0F, -1.1F, -0.7F, 0.08726646259971647F, 0.0F, 0.0F));

                PartDefinition equipHeadC01 = equipLHead.addOrReplaceChild("EquipHeadC01",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 3.0F, 9.0F),
                                PartPose.offsetAndRotation(0.0F, -8.7F, -7.0F, -0.17453292519943295F, 0.0F, 0.0F));

                equipHeadC01.addOrReplaceChild("EquipHeadC02",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-0.5F, -0.6F, -7.0F, 1.0F, 1.0F, 7.0F),
                                PartPose.offset(0.0F, 1.5F, 0.5F));

                PartDefinition equipLT01 = equipBaseL.addOrReplaceChild("EquipLT01",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, -5.0F, -6.0F, 4.0F, 11.0F, 10.0F),
                                PartPose.offsetAndRotation(15.0F, 0.0F, 0.0F, 0.0F, -0.13962634015954636F, 0.0F));

                equipLT01.addOrReplaceChild("EquipLT02b",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F),
                                PartPose.offset(2.0F, -0.3F, -5.8F));

                equipLT01.addOrReplaceChild("EquipLT02d",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F),
                                PartPose.offset(2.0F, 4.3F, -5.8F));

                equipLT01.addOrReplaceChild("EquipLT02c",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F),
                                PartPose.offset(2.0F, 2.0F, -5.8F));

                equipLT01.addOrReplaceChild("EquipLT02a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F),
                                PartPose.offset(2.0F, -2.6F, -5.8F));

                PartDefinition equipLJaw = equipBaseL.addOrReplaceChild("EquipLJaw",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.0F, 4.0F, -9.0F, 8.0F, 4.0F, 9.0F),
                                PartPose.offsetAndRotation(9.0F, 0.0F, -1.2F, 0.17453292519943295F, 0.0F, 0.0F));

                equipLJaw.addOrReplaceChild("EquipLTD",
                                CubeListBuilder.create().mirror().texOffs(47, 29)
                                                .addBox(-4.5F, 0.0F, -9.0F, 9.0F, 4.0F, 9.0F),
                                PartPose.offsetAndRotation(0.0F, 5.0F, 0.2F, 0.08726646259971647F, 0.0F,
                                                3.141592653589793F));

                equipBaseL.addOrReplaceChild("EquipLB",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-5.0F, 0.0F, 0.0F, 10.0F, 10.0F, 8.0F),
                                PartPose.offsetAndRotation(9.0F, -3.5F, -5.0F, 0.08726646259971647F, 0.0F, 0.0F));

                PartDefinition equipBaseR = butt.addOrReplaceChild("EquipBaseR",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-16.0F, -3.0F, -3.0F, 16.0F, 6.0F, 6.0F),
                                PartPose.offsetAndRotation(-7.0F, 10.0F, -3.0F, 0.05235987755982988F,
                                                0.13962634015954636F, -0.13962634015954636F));

                PartDefinition equipRHead = equipBaseR.addOrReplaceChild("EquipRHead",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-5.5F, -6.0F, -10.0F, 11.0F, 6.0F, 14.0F),
                                PartPose.offsetAndRotation(-9.0F, -2.0F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));

                equipRHead.addOrReplaceChild("EquipLTU_1",
                                CubeListBuilder.create().texOffs(47, 29)
                                                .addBox(-4.5F, 0.0F, -9.0F, 9.0F, 4.0F, 9.0F),
                                PartPose.offsetAndRotation(0.0F, -1.1F, -0.7F, 0.08726646259971647F, 0.0F, 0.0F));

                PartDefinition equipHeadC01_1 = equipRHead.addOrReplaceChild("EquipHeadC01_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 3.0F, 9.0F),
                                PartPose.offsetAndRotation(0.0F, -8.7F, -7.0F, -0.17453292519943295F, 0.0F, 0.0F));

                equipHeadC01_1.addOrReplaceChild("EquipHeadC02_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-0.5F, -0.6F, -7.0F, 1.0F, 1.0F, 7.0F),
                                PartPose.offset(0.0F, 1.5F, 0.5F));

                PartDefinition equipLT01_1 = equipBaseR.addOrReplaceChild("EquipLT01_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.0F, -5.0F, -6.0F, 4.0F, 11.0F, 10.0F),
                                PartPose.offsetAndRotation(-15.0F, 0.0F, 0.0F, 0.0F, 0.13962634015954636F, 0.0F));

                equipLT01_1.addOrReplaceChild("EquipLT02a_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F),
                                PartPose.offset(-2.0F, -2.6F, -5.8F));

                equipLT01_1.addOrReplaceChild("EquipLT02b_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F),
                                PartPose.offset(-2.0F, -0.3F, -5.8F));

                equipLT01_1.addOrReplaceChild("EquipLT02d_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F),
                                PartPose.offset(-2.0F, 4.3F, -5.8F));

                equipLT01_1.addOrReplaceChild("EquipLT02c_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F),
                                PartPose.offset(-2.0F, 2.0F, -5.8F));

                PartDefinition equipLJaw_1 = equipBaseR.addOrReplaceChild("EquipLJaw_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-4.0F, 4.0F, -9.0F, 8.0F, 4.0F, 9.0F),
                                PartPose.offsetAndRotation(-9.0F, 0.0F, -1.2F, 0.17453292519943295F, 0.0F, 0.0F));

                equipLJaw_1.addOrReplaceChild("EquipLTD_1",
                                CubeListBuilder.create().texOffs(47, 29)
                                                .addBox(-4.5F, 0.0F, -9.0F, 9.0F, 4.0F, 9.0F),
                                PartPose.offsetAndRotation(0.0F, 5.0F, 0.2F, 0.08726646259971647F, 0.0F,
                                                3.141592653589793F));

                equipBaseR.addOrReplaceChild("EquipLB_1",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-5.0F, 0.0F, 0.0F, 10.0F, 10.0F, 8.0F),
                                PartPose.offsetAndRotation(-9.0F, -3.5F, -5.0F, 0.08726646259971647F, 0.0F, 0.0F));

                PartDefinition cloth01 = bodyMain.addOrReplaceChild("Cloth01",
                                CubeListBuilder.create().texOffs(84, 27)
                                                .addBox(-7.0F, 0.0F, -4.4F, 14.0F, 7.0F, 8.0F),
                                PartPose.offsetAndRotation(0.0F, -11.3F, 0.0F, -0.08726646259971647F, 0.0F, 0.0F));

                cloth01.addOrReplaceChild("Cloth02",
                                CubeListBuilder.create().texOffs(38, 47)
                                                .addBox(-4.0F, 0.0F, 0.0F, 8.0F, 8.0F, 0.0F),
                                PartPose.offsetAndRotation(0.0F, 5.4F, -4.3F, 0.05235987755982988F, 0.0F, 0.0F));

                PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-3.5F, -2.0F, -4.9F, 7.0F, 2.0F, 8.0F),
                                PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));

                PartDefinition head = neck.addOrReplaceChild("Head",
                                CubeListBuilder.create().texOffs(44, 101)
                                                .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                                PartPose.offset(0.0F, -1.0F, -0.7F));

                PartDefinition hair = head.addOrReplaceChild("Hair",
                                CubeListBuilder.create().texOffs(50, 77)
                                                .addBox(-8.0F, -8.0F, -7.4F, 16.0F, 16.0F, 8.0F),
                                PartPose.offset(0.0F, -7.5F, 0.1F));

                hair.addOrReplaceChild("HairR01",
                                CubeListBuilder.create().mirror().texOffs(90, 101)
                                                .addBox(-0.5F, 0.0F, -1.5F, 1.0F, 7.0F, 3.0F),
                                PartPose.offsetAndRotation(-7.8F, 6.5F, -4.4F, -0.08726646259971647F,
                                                -0.08726646259971647F, -0.08726646259971647F));

                hair.addOrReplaceChild("HairL01",
                                CubeListBuilder.create().texOffs(90, 101)
                                                .addBox(-0.5F, 0.0F, -1.5F, 1.0F, 7.0F, 3.0F),
                                PartPose.offsetAndRotation(7.8F, 7.0F, -4.4F, -0.13962634015954636F,
                                                0.08726646259971647F, 0.08726646259971647F));

                hair.addOrReplaceChild("Ahoke",
                                CubeListBuilder.create().texOffs(106, 31)
                                                .addBox(0.0F, -6.0F, -10.5F, 0.0F, 11.0F, 11.0F),
                                PartPose.offsetAndRotation(-0.5F, -7.0F, -6.0F, 0.20943951023931953F,
                                                0.6981317007977318F, 0.0F));

                hair.addOrReplaceChild("HairU01",
                                CubeListBuilder.create().texOffs(52, 56)
                                                .addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F),
                                PartPose.offset(0.0F, -6.0F, -7.0F));

                PartDefinition hair02 = head.addOrReplaceChild("Hair02",
                                CubeListBuilder.create().texOffs(9, 6)
                                                .addBox(0.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F),
                                PartPose.offsetAndRotation(6.5F, -10.0F, 3.5F, 0.0F, -0.08726646259971647F, 0.0F));

                PartDefinition hair03 = hair02.addOrReplaceChild("Hair03",
                                CubeListBuilder.create().texOffs(40, 99)
                                                .addBox(0.0F, -3.0F, -2.0F, 4.0F, 11.0F, 4.0F),
                                PartPose.offsetAndRotation(1.7F, 0.0F, 0.0F, -0.08726646259971647F, 0.0F,
                                                -0.08726646259971647F));

                PartDefinition hair04 = hair03.addOrReplaceChild("Hair04",
                                CubeListBuilder.create().texOffs(40, 99)
                                                .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F),
                                PartPose.offsetAndRotation(2.0F, 6.5F, 0.0F, 0.2617993877991494F, 0.0F,
                                                -0.22759093446006054F));

                PartDefinition hair05 = hair04.addOrReplaceChild("Hair05",
                                CubeListBuilder.create().texOffs(40, 99)
                                                .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F),
                                PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.5235987755982988F, 0.0F,
                                                0.3490658503988659F));

                hair05.addOrReplaceChild("Hair06",
                                CubeListBuilder.create().texOffs(40, 99)
                                                .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F),
                                PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, -0.2617993877991494F, 0.0F,
                                                0.5235987755982988F));

                PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                                CubeListBuilder.create().texOffs(46, 104)
                                                .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F),
                                PartPose.offset(0.0F, -14.8F, -3.0F));

                hairMain.addOrReplaceChild("Hair01",
                                CubeListBuilder.create().texOffs(54, 44)
                                                .addBox(-7.5F, 0.0F, -7.0F, 15.0F, 5.0F, 7.0F),
                                PartPose.offsetAndRotation(0.0F, 9.9F, 10.0F, 0.15707963267948966F, 0.0F, 0.0F));

                PartDefinition hat01 = head.addOrReplaceChild("Hat01",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-6.0F, -6.0F, -6.0F, 12.0F, 6.0F, 12.0F),
                                PartPose.offsetAndRotation(0.0F, -11.0F, 1.0F, -0.4363323129985824F, 0.0F, 0.0F));

                PartDefinition hat04a = hat01.addOrReplaceChild("Hat04a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F),
                                PartPose.offsetAndRotation(0.0F, -7.4F, -5.5F, 0.2617993877991494F, 0.2617993877991494F,
                                                -0.17453292519943295F));

                PartDefinition hat04b = hat04a.addOrReplaceChild("Hat04b",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-2.5F, -5.0F, -2.5F, 5.0F, 5.0F, 5.0F),
                                PartPose.offsetAndRotation(0.0F, -6.8F, -0.4F, -0.5235987755982988F, 0.0F, 0.0F));

                hat04b.addOrReplaceChild("Hat04c",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F),
                                PartPose.offsetAndRotation(0.0F, -3.9F, 0.0F, -0.6108652381980153F, 0.0F, 0.0F));

                PartDefinition hat05a = hat01.addOrReplaceChild("Hat05a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F),
                                PartPose.offsetAndRotation(2.0F, -10.0F, 6.0F, -0.08726646259971647F,
                                                0.5235987755982988F, 0.17453292519943295F));

                hat05a.addOrReplaceChild("Hat05b",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-1.5F, -4.0F, -1.5F, 3.0F, 4.0F, 3.0F),
                                PartPose.offsetAndRotation(0.0F, -4.1F, 0.3F, 0.6108652381980153F, 0.0F, 0.0F));

                hat01.addOrReplaceChild("Hat03",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-8.5F, -6.0F, 0.0F, 17.0F, 7.0F, 9.0F),
                                PartPose.offsetAndRotation(0.0F, -5.4F, 0.0F, -0.27314402793711257F, 0.0F, 0.0F));

                hat01.addOrReplaceChild("Hat02b",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(0.0F, -6.0F, -7.0F, 10.0F, 7.0F, 13.0F),
                                PartPose.offsetAndRotation(-0.7F, -5.0F, -2.9F, 0.17453292519943295F,
                                                -0.05235987755982988F, 0.05235987755982988F));

                hat01.addOrReplaceChild("Hat06b",
                                CubeListBuilder.create().texOffs(44, 61)
                                                .addBox(0.0F, 0.0F, -2.0F, 0.0F, 12.0F, 4.0F),
                                PartPose.offsetAndRotation(8.5F, -6.4F, 2.5F, 1.0471975511965976F, 0.08726646259971647F,
                                                -0.4363323129985824F));

                hat01.addOrReplaceChild("Hat02a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-10.0F, -6.0F, -7.0F, 10.0F, 7.0F, 13.0F),
                                PartPose.offsetAndRotation(0.7F, -5.0F, -3.0F, 0.17453292519943295F,
                                                0.05235987755982988F, -0.05235987755982988F));

                hat01.addOrReplaceChild("Hat06a",
                                CubeListBuilder.create().mirror().texOffs(44, 61)
                                                .addBox(0.0F, 0.0F, -2.0F, 0.0F, 12.0F, 4.0F),
                                PartPose.offsetAndRotation(8.5F, -6.0F, 2.0F, 0.6981317007977318F, 0.2617993877991494F,
                                                -0.6981317007977318F));

                PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                                CubeListBuilder.create().texOffs(24, 86)
                                                .addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                                PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.2617993877991494F, 0.0F,
                                                -0.7853981633974483F));

                PartDefinition armLeft02 = armLeft01.addOrReplaceChild("ArmLeft02",
                                CubeListBuilder.create().texOffs(24, 69)
                                                .addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
                                PartPose.offset(3.0F, 11.0F, 2.5F));

                armLeft02.addOrReplaceChild("ArmLeft02a",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F),
                                PartPose.offsetAndRotation(-2.5F, 6.5F, -2.4F, 0.05235987755982988F, 0.0F, 0.0F));

                PartDefinition cannon01 = armLeft02.addOrReplaceChild("Cannon01",
                                CubeListBuilder.create().texOffs(22, 21)
                                                .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F),
                                PartPose.offset(-2.5F, 3.0F, -2.5F));

                cannon01.addOrReplaceChild("Cannon03",
                                CubeListBuilder.create().texOffs(0, 21)
                                                .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 9.0F, 4.0F),
                                PartPose.offsetAndRotation(0.0F, 2.3F, 0.0F, 0.05235987755982988F, 0.0F, 0.0F));

                cannon01.addOrReplaceChild("Cannon04",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F),
                                PartPose.offset(-1.0F, 10.0F, 0.0F));

                cannon01.addOrReplaceChild("Cannon02",
                                CubeListBuilder.create().texOffs(52, 0)
                                                .addBox(-4.0F, 0.0F, -6.0F, 8.0F, 13.0F, 6.0F),
                                PartPose.offsetAndRotation(0.0F, -1.0F, 2.0F, -0.08726646259971647F, 0.0F, 0.0F));

                cannon01.addOrReplaceChild("Cannon05",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F),
                                PartPose.offset(1.0F, 10.0F, 0.0F));

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

                boolean flag = !EmotionHelper.checkModelState(0, state); // cannon
                this.EquipBaseL.visible = !flag;
                this.EquipBaseR.visible = !flag;

                flag = !EmotionHelper.checkModelState(1, state); // hat
                this.Hat01.visible = !flag;

                flag = !EmotionHelper.checkModelState(2, state); // weapon
                this.Cannon01.visible = !flag;

                flag = !EmotionHelper.checkModelState(3, state); // belt
                this.BeltBase.visible = !flag;

                flag = !EmotionHelper.checkModelState(4, state); // leg
                this.LegLeft01.visible = !flag;
                this.LegRight01.visible = !flag;

                flag = !EmotionHelper.checkModelState(5, state); // wristband
                this.ArmLeft02a.visible = !flag;
                this.ArmRight02a.visible = !flag;
        }

        @Override
        public void syncRotationGlowPart() {
                this.GlowBodyMain.xRot = this.BodyMain.xRot;
                this.GlowBodyMain.yRot = this.BodyMain.yRot;
                this.GlowBodyMain.zRot = this.BodyMain.zRot;
                this.GlowHead.xRot = this.Head.xRot;
                this.GlowHead.yRot = this.Head.yRot;
                this.GlowHead.zRot = this.Head.zRot;
                this.EquipLegL.xRot = this.LegLeft01.xRot;
                this.EquipLegL.yRot = this.LegLeft01.yRot;
                this.EquipLegL.zRot = this.LegLeft01.zRot;
                this.EquipLegR.xRot = this.LegRight01.xRot;
                this.EquipLegR.yRot = this.LegRight01.yRot;
                this.EquipLegR.zRot = this.LegRight01.zRot;
                this.EquipHeadC02.xRot = this.Head.xRot;
                this.EquipHeadC02_1.xRot = this.Head.xRot;
                this.EquipLT01.xRot = this.Head.xRot;
                this.EquipLT01_1.xRot = this.Head.xRot;
        }

        @Override
        public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.59F;
                this.setFaceHungry(ent);

                // body
                this.Head.xRot = 0F;
                this.Head.yRot = 0F;
                this.Head.zRot = 0F;
                this.Ahoke.yRot = 0.7F;
                this.BodyMain.xRot = 1.45F;
                this.Butt.xRot = 0.21F;
                // this.Butt.offsetY = 0F;
                this.BeltBase.xRot = 0.09F;
                this.Skirt01.xRot = -0.21F;
                // this.Skirt01.offsetY = 0F;
                // hair
                // hair
                this.Hair03.xRot = 0F;
                this.Hair04.xRot = 0F;
                this.Hair05.xRot = 0F;
                this.Hair06.xRot = 0F;
                this.Hair03.zRot = 0.1F;
                this.Hair04.zRot = 0.2F;
                this.Hair05.zRot = 0.3F;
                this.Hair06.zRot = 0.4F;
                // arm
                this.ArmLeft01.xRot = -2.8F;
                this.ArmLeft01.yRot = 0F;
                this.ArmLeft01.zRot = 0.7F;
                this.ArmLeft02.xRot = 0F;
                this.ArmLeft02.yRot = 0F;
                this.ArmLeft02.zRot = 1F;
                // this.ArmLeft02.offsetX = 0F;
                // this.ArmLeft02.offsetZ = 0F;
                this.ArmRight01.xRot = -2.8F;
                this.ArmRight01.yRot = 0F;
                this.ArmRight01.zRot = -0.7F;
                this.ArmRight02.xRot = 0F;
                this.ArmRight02.yRot = 0F;
                this.ArmRight02.zRot = -1.0F;
                // this.ArmRight02.offsetX = 0F;
                // this.ArmRight02.offsetZ = 0F;
                // leg
                this.LegLeft01.xRot = 0.1F;
                this.LegLeft01.yRot = 3.1415F;
                this.LegLeft01.zRot = -0.1F;
                // this.LegLeft01.offsetY = 0F;
                this.LegLeft02.xRot = 0F;
                this.LegLeft02.yRot = 0F;
                this.LegLeft02.zRot = 0F;
                // this.LegLeft02.offsetX = 0F;
                // this.LegLeft02.offsetY = 0F;
                // this.LegLeft02.offsetZ = 0F;
                this.LegRight01.xRot = 0.1F;
                this.LegRight01.yRot = 3.1415F;
                this.LegRight01.zRot = 0.1F;
                // this.LegRight01.offsetY = 0F;
                this.LegRight02.xRot = 0F;
                this.LegRight02.yRot = 0F;
                this.LegRight02.zRot = 0F;
                // this.LegRight02.offsetX = 0F;
                // this.LegRight02.offsetY = 0F;
                // this.LegRight02.offsetZ = 0F;
                // equip
                // this.EquipBaseL.offsetY = 0F;
                // this.EquipBaseR.offsetY = 0F;
        }

        @Override
        public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

                float angleX = Mth.cos(f2 * 0.08F + f * 0.25F);
                float angleX1 = Mth.cos(f2 * 0.08F + 0.3F + f * 0.5F);
                float angleX2 = Mth.cos(f2 * 0.08F + 0.6F + f * 0.5F);
                float angleX3 = Mth.cos(f2 * 0.08F + 0.9F + f * 0.5F);
                float angleAdd1 = Mth.cos(f * 0.7F) * f1;
                float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
                float addk1;
                float addk2;
                float headX = 0F;
                float headZ;
                float t2 = ent.getTickExisted() & 511;
                int state = ent.getStateEmotion(ID.S.State);
                boolean showCannon = EmotionHelper.checkModelState(0, state);
                boolean showLeg = EmotionHelper.checkModelState(4, state);

                // 水上漂浮
                if (!ent.getIsSitting() && !showLeg) {
                        this.offsetY += angleX * 0.015F + 0.025F;
                } else if (ent.getShipDepth(0) > 0D) {
                        this.offsetY += angleX * 0.05F + 0.025F;
                }

                // leg move
                addk1 = angleAdd1 * 0.5F - 0.28F; // LegLeft01
                addk2 = angleAdd2 * 0.5F - 0.21F; // LegRight01

                // head
                this.Head.xRot = f4 * 0.01745F;
                this.Head.yRot = f3 * 0.01F;
                // body
                this.Ahoke.yRot = angleX * 0.05F + 0.7F;
                this.BodyMain.xRot = -0.1047F;
                this.BodyMain.yRot = 0F;
                this.BodyMain.zRot = 0F;
                this.Butt.xRot = 0.35F;
                this.BeltBase.xRot = 0.09F;
                this.Skirt01.xRot = -0.21F;
                // this.Skirt01.offsetY = 0F;
                // hat
                this.Hat06a.xRot = -angleX * 0.1F + 0.7F;
                this.Hat06b.xRot = -angleX3 * 0.1F + 1.04F;
                // hair
                this.Hair03.xRot = angleX * 0.05F - 0.09F + headX;
                this.Hair03.zRot = -0.09F;
                this.Hair04.xRot = -angleX1 * 0.06F + 0.26F + headX;
                this.Hair04.zRot = -0.22F;
                this.Hair05.xRot = -angleX2 * 0.07F + 0.52F + headX;
                this.Hair05.zRot = 0.35F;
                this.Hair06.xRot = -angleX3 * 0.12F - 0.15F + headX;
                this.Hair06.zRot = 0.52F;
                // arm
                // equip on
                if (showCannon) {
                        this.ArmLeft01.zRot = -0.78F;
                        this.ArmRight01.zRot = 0.78F;
                }
                // equip off
                else {
                        this.ArmLeft01.zRot = angleX * 0.03F - 0.3F;
                        this.ArmRight01.zRot = -angleX * 0.03F + 0.3F;
                }
                this.ArmLeft01.xRot = angleAdd2 * 0.4F + 0.26F;
                this.ArmLeft01.yRot = 0F;
                this.ArmLeft02.xRot = 0F;
                this.ArmLeft02.zRot = 0F;
                // this.ArmLeft02.offsetX = 0F;
                // this.ArmLeft02.offsetZ = 0F;
                this.ArmRight01.xRot = angleAdd1 * 0.4F + 0.26F;
                this.ArmRight01.yRot = 0F;
                this.ArmRight02.xRot = 0F;
                this.ArmRight02.zRot = 0F;
                // this.ArmRight02.offsetX = 0F;
                // this.ArmRight02.offsetZ = 0F;
                // leg
                this.LegLeft01.yRot = 0F;
                this.LegLeft01.zRot = 0.0873F;
                // this.LegLeft01.offsetY = 0F;
                this.LegLeft02.xRot = 0F;
                this.LegLeft02.yRot = 0F;
                this.LegLeft02.zRot = 0F;
                // this.LegLeft02.offsetX = 0F;
                // this.LegLeft02.offsetZ = 0F;
                this.LegRight01.yRot = 0F;
                this.LegRight01.zRot = -0.0873F;
                // this.LegRight01.offsetY = 0F;
                this.LegRight02.xRot = 0F;
                this.LegRight02.yRot = 0F;
                this.LegRight02.zRot = 0F;
                // this.LegRight02.offsetX = 0F;
                // this.LegRight02.offsetZ = 0F;
                // equip
                this.EquipBaseL.xRot = 0.05F;
                this.EquipBaseR.xRot = 0.05F;
                // this.EquipBaseL.offsetY = 0F;
                // this.EquipBaseR.offsetY = 0F;
                this.EquipHeadC02.xRot = this.Head.xRot * 0.5F - 0.04F;
                this.EquipHeadC02_1.xRot = this.Head.xRot * 0.5F - 0.12F;
                this.EquipLT01.xRot = this.Head.xRot * 0.8F - 0.2F;
                this.EquipLT01_1.xRot = this.Head.xRot * 0.8F - 0.2F;
                this.EquipLJaw.xRot = angleX * 0.15F + 0.15F;
                this.EquipLJaw_1.xRot = angleX3 * 0.15F + 0.15F;

                // //special stand pos
                // if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
                // {
                // spStand = true;
                // }

                if (ent.getIsSprinting() || f1 > 0.9F) {
                        // if (spStand)

                        // body
                        this.Head.xRot -= 0.5F;
                        this.BodyMain.xRot = 0.5F;
                        // arm
                        this.ArmLeft01.xRot = angleAdd2 * 0.1F + 0.55F;
                        this.ArmLeft01.yRot = 0F;
                        this.ArmLeft01.zRot = -0.5F;
                        this.ArmRight01.xRot = angleAdd1 * 0.1F + 0.55F;
                        this.ArmRight01.yRot = 0F;
                        this.ArmRight01.zRot = 0.5F;
                        // hair
                        this.Hair05.xRot -= 0.2F;
                        // leg
                        addk1 = angleAdd1 * 0.8F - 0.75F;
                        addk2 = angleAdd2 * 0.8F - 0.75F;
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
                        // this.LegRight02.offsetZ = 0F;

                        // equip on
                        if (!showLeg) {
                                addk1 = angleAdd1 * 0.05F;
                                addk2 = angleAdd2 * 0.05F;
                        }
                }

                // head tilt angle
                this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

                if (ent.getIsSneaking()) {

                        // Body
                        // [PORT] Restored from 1.10.2 GlStateManager.translate
                        this.offsetY += 0.07F;
                        this.Head.xRot -= 0.6283F;
                        this.BodyMain.xRot = 0.8727F;
                        // arm
                        this.ArmLeft01.xRot = -0.35F;
                        this.ArmLeft01.yRot = 0F;
                        this.ArmLeft01.zRot = 0.2618F;
                        this.ArmLeft02.xRot = 0F;
                        this.ArmLeft02.zRot = 0F;
                        // this.ArmLeft02.offsetX = 0F;
                        // this.ArmLeft02.offsetZ = 0F;
                        this.ArmRight01.xRot = -0.35F;
                        this.ArmRight01.yRot = 0F;
                        this.ArmRight01.zRot = -0.2618F;
                        this.ArmRight02.xRot = 0F;
                        this.ArmRight02.zRot = 0F;
                        // this.ArmRight02.offsetX = 0F;
                        // this.ArmRight02.offsetZ = 0F;
                        // leg
                        addk1 -= 1F;
                        addk2 -= 1F;
                        // hair
                        this.Hair03.xRot -= 0.6F;
                        this.Hair04.xRot -= 0.6F;
                        this.Hair05.xRot -= 0.6F;
                        this.Hair06.xRot -= 0.6F;
                } // end if sneaking

                // 坐下動作
                if (ent.getIsSitting() || ent.getIsRiding()) {
                        if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                                if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED) {

                                        // [PORT] Restored from 1.10.2 GlStateManager.translate
                                        this.offsetY += 0.46F;
                                        this.setFaceDamaged(ent);

                                        // body
                                        this.Head.xRot = 0.4F;
                                        this.BeltBase.xRot = -0.9F;
                                        this.Skirt01.xRot = -0.14F;
                                        // this.Skirt01.offsetY = -0.12F;
                                        // arm
                                        this.ArmLeft01.xRot = 0.4F;
                                        this.ArmLeft01.yRot = -2.96705972839036F;
                                        this.ArmLeft01.zRot = -2.62F;
                                        this.ArmLeft02.xRot = 0.0F;
                                        this.ArmLeft02.yRot = 0.0F;
                                        this.ArmLeft02.zRot = 1F;
                                        // this.ArmLeft02.offsetX = 0F;
                                        // this.ArmLeft02.offsetZ = 0F;
                                        this.ArmRight01.xRot = 0.5235987755982988F;
                                        this.ArmRight01.yRot = 2.96705972839036F;
                                        this.ArmRight01.zRot = 2.62F;
                                        this.ArmRight02.xRot = 0.0F;
                                        this.ArmRight02.yRot = 0.0F;
                                        this.ArmRight02.zRot = -1F;
                                        // this.ArmRight02.offsetX = 0F;
                                        // this.ArmRight02.offsetZ = 0F;
                                        // leg
                                        addk1 = -2.41309222380736F;
                                        addk2 = -2.2689280275926285F;
                                        this.LegLeft01.yRot = 0.0F;
                                        this.LegLeft01.zRot = -0.27314402793711257F;
                                        this.LegLeft02.xRot = 1.4570008595648662F;
                                        this.LegLeft02.yRot = 0.0F;
                                        this.LegLeft02.zRot = 0.0F;
                                        this.LegRight01.yRot = 0.0F;
                                        this.LegRight01.zRot = 0.22759093446006054F;
                                        this.LegRight02.xRot = 1.0471975511965976F;
                                        this.LegRight02.yRot = 0.0F;
                                        this.LegRight02.zRot = 0.0F;
                                        // equip
                                        this.EquipBaseL.xRot = -0.6F;
                                        this.EquipBaseR.xRot = -0.6F;
                                        // this.EquipBaseL.offsetY = -0.62F;
                                        // this.EquipBaseR.offsetY = -0.62F;
                                } else {
                                        // body
                                        // [PORT] Restored from 1.10.2 GlStateManager.translate
                                        this.offsetY += 0.43F;
                                        this.Head.xRot -= 0.7F;
                                        this.BodyMain.xRot = 0.35F;
                                        this.BeltBase.xRot = -0.5F;
                                        this.Skirt01.xRot = -0.14F;
                                        // this.Skirt01.offsetY = -0.12F;
                                        // arm
                                        this.ArmLeft01.xRot = -0.5235987755982988F;
                                        this.ArmLeft01.yRot = 0.0F;
                                        this.ArmLeft01.zRot = 0.3490658503988659F;
                                        this.ArmLeft02.xRot = 0F;
                                        this.ArmLeft02.zRot = 0F;
                                        // this.ArmLeft02.offsetX = 0F;
                                        // this.ArmLeft02.offsetZ = 0F;
                                        this.ArmRight01.xRot = -0.5235987755982988F;
                                        this.ArmRight01.yRot = 0.0F;
                                        this.ArmRight01.zRot = -0.3490658503988659F;
                                        this.ArmRight02.xRot = 0F;
                                        this.ArmRight02.zRot = 0F;
                                        // this.ArmRight02.offsetX = 0F;
                                        // this.ArmRight02.offsetZ = 0F;
                                        // leg
                                        addk1 = -1.4486232791552935F;
                                        addk2 = -1.4486232791552935F;
                                        this.LegLeft01.yRot = -0.5235987755982988F;
                                        this.LegLeft01.zRot = -1.3962634015954636F;
                                        this.LegLeft02.xRot = 2.1816615649929116F;
                                        this.LegLeft02.yRot = 0.0F;
                                        this.LegLeft02.zRot = 0.0F;
                                        // this.LegLeft02.offsetX = 0F;
                                        // this.LegLeft02.offsetZ = 0.37F;
                                        this.LegRight01.yRot = 0.5235987755982988F;
                                        this.LegRight01.zRot = 1.3962634015954636F;
                                        this.LegRight02.xRot = 2.1816615649929116F;
                                        this.LegRight02.yRot = 0.0F;
                                        this.LegRight02.zRot = 0.0F;
                                        // this.LegRight02.offsetX = 0F;
                                        // this.LegRight02.offsetZ = 0.37F;
                                        // equip
                                        this.EquipBaseL.xRot = -0.9F;
                                        this.EquipBaseR.xRot = -0.9F;
                                        // this.EquipBaseL.offsetY = -0.4F;
                                        // this.EquipBaseR.offsetY = -0.4F;
                                        // hair
                                        this.Hair03.xRot -= 0.1F;
                                        this.Hair04.xRot -= 0.3F;
                                        this.Hair05.xRot -= 0.5F;
                                        this.Hair06.xRot -= 0.6F;
                                }
                        } else {
                                // no equip
                                if (this.EquipBaseL.visible) {
                                        // body
                                        this.Head.xRot -= 0.7F;
                                        this.BodyMain.xRot = 0.5236F;
                                        this.BeltBase.xRot = -0.9F;
                                        this.Skirt01.xRot = -0.14F;
                                        // this.Skirt01.offsetY = -0.12F;
                                        // arm
                                        this.ArmLeft01.xRot = -0.5236F;
                                        this.ArmLeft01.yRot = 0F;
                                        this.ArmLeft01.zRot = 0.3146F;
                                        this.ArmLeft02.xRot = 0F;
                                        this.ArmLeft02.zRot = 0F;
                                        // this.ArmLeft02.offsetX = 0F;
                                        // this.ArmLeft02.offsetZ = 0F;
                                        this.ArmRight01.xRot = -0.5236F;
                                        this.ArmRight01.yRot = 0F;
                                        this.ArmRight01.zRot = -0.3146F;
                                        this.ArmRight02.xRot = 0F;
                                        this.ArmRight02.zRot = 0F;
                                        // this.ArmRight02.offsetX = 0F;
                                        // this.ArmRight02.offsetZ = 0F;
                                        // leg
                                        addk1 = -2.2689F;
                                        addk2 = -2.2689F;
                                        this.LegLeft01.yRot = -0.3491F;
                                        this.LegLeft01.zRot = 0.0873F;
                                        this.LegLeft02.xRot = 0F;
                                        this.LegLeft02.yRot = 0F;
                                        this.LegLeft02.zRot = 0F;
                                        // this.LegLeft02.offsetX = 0F;
                                        // this.LegLeft02.offsetZ = 0F;
                                        this.LegRight01.yRot = 0.3491F;
                                        this.LegRight01.zRot = -0.0873F;
                                        this.LegRight02.xRot = 0F;
                                        this.LegRight02.yRot = 0F;
                                        this.LegRight02.zRot = 0F;
                                        // this.LegRight02.offsetX = 0F;
                                        // this.LegRight02.offsetZ = 0F;
                                        // hair
                                } else {
                                        // body
                                        this.Head.xRot -= 0.7F;
                                        this.BodyMain.xRot = 0.5236F;
                                        // arm
                                        this.ArmLeft01.xRot = -0.5236F;
                                        this.ArmLeft01.yRot = 0F;
                                        this.ArmLeft01.zRot = 0.3146F;
                                        this.ArmLeft02.xRot = 0F;
                                        this.ArmLeft02.zRot = 0F;
                                        // this.ArmLeft02.offsetX = 0F;
                                        // this.ArmLeft02.offsetZ = 0F;
                                        this.ArmRight01.xRot = -0.5236F;
                                        this.ArmRight01.yRot = 0F;
                                        this.ArmRight01.zRot = -0.3146F;
                                        this.ArmRight02.xRot = 0F;
                                        this.ArmRight02.zRot = 0F;
                                        // this.ArmRight02.offsetX = 0F;
                                        // this.ArmRight02.offsetZ = 0F;
                                        // leg
                                        addk1 = -2.23F;
                                        addk2 = -2.23F;
                                        this.LegLeft01.yRot = -0.3491F;
                                        this.LegLeft01.zRot = 0.0873F;
                                        this.LegLeft02.xRot = 0F;
                                        this.LegLeft02.yRot = 0F;
                                        this.LegLeft02.zRot = 0F;
                                        // this.LegLeft02.offsetX = 0F;
                                        // this.LegLeft02.offsetZ = 0F;
                                        this.LegRight01.yRot = 0.3491F;
                                        this.LegRight01.zRot = -0.0873F;
                                        this.LegRight02.xRot = 0F;
                                        this.LegRight02.yRot = 0F;
                                        this.LegRight02.zRot = 0F;
                                        // this.LegRight02.offsetX = 0F;
                                        // this.LegRight02.offsetZ = 0F;
                                        // equip
                                        this.EquipBaseL.xRot = -1.34F;
                                        this.EquipBaseR.xRot = -1.34F;
                                        // hair
                                }
                            this.Hair03.xRot -= 0.1F;
                            this.Hair04.xRot -= 0.3F;
                            this.Hair05.xRot -= 0.5F;
                            this.Hair06.xRot -= 0.6F;
                        }
                } // end if sitting

                // 攻擊動作: 設為30~50會有揮刀動作, 設為100則沒有揮刀動作
                if (ent.getAttackTick() > 0) {
                        // arm
                        this.ArmLeft01.xRot = -1.4F + this.Head.xRot * 0.75F;
                        this.ArmLeft01.yRot = 0.17F;
                        this.ArmLeft01.zRot = 0.26F;
                        this.ArmLeft02.xRot = 0F;
                        this.ArmLeft02.zRot = 0F;
                        // this.ArmLeft02.offsetX = 0F;
                        // this.ArmLeft02.offsetZ = 0F;
                        this.ArmRight01.xRot = -1.22F + this.Head.xRot * 0.75F;
                        this.ArmRight01.yRot = 0F;
                        this.ArmRight01.zRot = -0.52F;
                        this.ArmRight02.xRot = 0F;
                        this.ArmRight02.zRot = -0.78F;
                        // this.ArmRight02.offsetX = 0F;
                        // this.ArmRight02.offsetZ = 0F;
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
                this.Hair03.xRot += headX;
                this.Hair04.xRot += headX;
                this.Hair05.xRot += headX;
                this.Hair06.xRot += headX;
                this.HairL01.xRot = angleX * 0.02F + headX + 0.14F;
                this.HairR01.xRot = angleX * 0.02F + headX - 0.09F;
                headZ = this.Head.zRot * -0.5F;
                this.Hair03.zRot = headZ;
                this.Hair04.zRot = headZ;
                this.Hair05.zRot = headZ;
                this.Hair06.zRot = headZ;
                this.HairL01.zRot = headZ - 0.09F;
                this.HairR01.zRot = headZ - 0.09F;

                // leg motion
                this.LegLeft01.xRot = addk1;
                this.LegRight01.xRot = addk2;
        }
}
