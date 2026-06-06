package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.BasicEntityMount;
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

public class ModelCarrierHime extends ShipModelBaseAdv<Entity> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(Reference.MOD_ID, "cv_hime"), "main");

	private final ModelPart BodyMain;
	private final ModelPart Neck;
	private final ModelPart BoobR;
	private final ModelPart BoobL;
	private final ModelPart Butt;
	private final ModelPart ArmRight01;
	private final ModelPart ArmLeft01;
	private final ModelPart Cloth01;
	private final ModelPart Cloth02;
	private final ModelPart Head;
	private final ModelPart Hair;
	private final ModelPart HairMain;
	private final ModelPart Ahoke;
	private final ModelPart HairL01;
	private final ModelPart HairR01;
	private final ModelPart HairL02;
	private final ModelPart HairR02;
	private final ModelPart Hair01;
	private final ModelPart Hair04;
	private final ModelPart Hair02;
	private final ModelPart Hair03;
	private final ModelPart Hair05;
	private final ModelPart Hair06;
	private final ModelPart Hair07;
	private final ModelPart LegLeft01;
	private final ModelPart Skirt01;
	private final ModelPart LegRight01;
	private final ModelPart LegLeft02;
	private final ModelPart LegLeft01a;
	private final ModelPart LegLeft01b;
	private final ModelPart ShoesL01;
	private final ModelPart ShoesL02;
	private final ModelPart ShoesL03;
	private final ModelPart ShoesL04;
	private final ModelPart Skirt02;
	private final ModelPart LegRight01a;
	private final ModelPart LegRight01b;
	private final ModelPart LegRight02;
	private final ModelPart ShoesR01;
	private final ModelPart ShoesR02;
	private final ModelPart ShoesR03;
	private final ModelPart ShoesR04;
	private final ModelPart ArmRight01a;
	private final ModelPart ArmRight01b;
	private final ModelPart ArmRight02;
	private final ModelPart EquipSR01;
	private final ModelPart EquipSR02;
	private final ModelPart EquipSR04;
	private final ModelPart EquipSR03;
	private final ModelPart EquipSR05;
	private final ModelPart ArmLeft02;
	private final ModelPart ArmLeft01a;
	private final ModelPart ArmLeft01b;
	private final ModelPart EquipSL01;
	private final ModelPart EquipSL02;
	private final ModelPart EquipSL04;
	private final ModelPart EquipSL03;
	private final ModelPart EquipSL05;
	private final ModelPart GlowBodyMain;
	private final ModelPart GlowBodyMain2;
	private final ModelPart GlowNeck;
	private final ModelPart GlowHead;
	private final ModelPart GlowArmLeft01;
	private final ModelPart GlowArmLeft02;
	private final ModelPart GlowArmRight01;
	private final ModelPart GlowArmRight02;

	public ModelCarrierHime(ModelPart root) {
		super();
		this.scale = 0.47F;
		this.offsetY = 1.7F;
		this.BodyMain = root.getChild("BodyMain");
		this.Butt = this.BodyMain.getChild("Butt");
		this.Cloth01 = this.BodyMain.getChild("Cloth01");
		this.BoobL = this.BodyMain.getChild("BoobL");
		this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
		this.Cloth02 = this.BodyMain.getChild("Cloth02");
		this.Neck = this.BodyMain.getChild("Neck");
		this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
		this.BoobR = this.BodyMain.getChild("BoobR");
		this.LegRight01 = this.Butt.getChild("LegRight01");
		this.Skirt01 = this.Butt.getChild("Skirt01");
		this.LegLeft01 = this.Butt.getChild("LegLeft01");
		this.ArmLeft01b = this.ArmLeft01.getChild("ArmLeft01b");
		this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
		this.ArmLeft01a = this.ArmLeft01.getChild("ArmLeft01a");
		this.Head = this.Neck.getChild("Head");
		this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
		this.ArmRight01a = this.ArmRight01.getChild("ArmRight01a");
		this.ArmRight01b = this.ArmRight01.getChild("ArmRight01b");
		this.LegRight02 = this.LegRight01.getChild("LegRight02");
		this.LegRight01a = this.LegRight01.getChild("LegRight01a");
		this.LegRight01b = this.LegRight01.getChild("LegRight01b");
		this.Skirt02 = this.Skirt01.getChild("Skirt02");
		this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
		this.LegLeft01a = this.LegLeft01.getChild("LegLeft01a");
		this.LegLeft01b = this.LegLeft01.getChild("LegLeft01b");
		this.Hair = this.Head.getChild("Hair");
		this.HairMain = this.Head.getChild("HairMain");
		this.ShoesR01 = this.LegRight02.getChild("ShoesR01");
		this.ShoesL01 = this.LegLeft02.getChild("ShoesL01");
		this.Ahoke = this.Hair.getChild("Ahoke");
		this.HairR01 = this.Hair.getChild("HairR01");
		this.HairL01 = this.Hair.getChild("HairL01");
		this.Hair01 = this.HairMain.getChild("Hair01");
		this.Hair04 = this.HairMain.getChild("Hair04");
		this.ShoesR02 = this.ShoesR01.getChild("ShoesR02");
		this.ShoesL02 = this.ShoesL01.getChild("ShoesL02");
		this.HairR02 = this.HairR01.getChild("HairR02");
		this.HairL02 = this.HairL01.getChild("HairL02");
		this.Hair02 = this.Hair01.getChild("Hair02");
		this.Hair05 = this.Hair04.getChild("Hair05");
		this.ShoesR03 = this.ShoesR02.getChild("ShoesR03");
		this.ShoesL03 = this.ShoesL02.getChild("ShoesL03");
		this.Hair03 = this.Hair02.getChild("Hair03");
		this.Hair06 = this.Hair05.getChild("Hair06");
		this.ShoesR04 = this.ShoesR03.getChild("ShoesR04");
		this.ShoesL04 = this.ShoesL03.getChild("ShoesL04");
		this.Hair07 = this.Hair06.getChild("Hair07");

		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowBodyMain2 = root.getChild("GlowBodyMain2");
		this.GlowNeck = this.GlowBodyMain.getChild("GlowNeck");
		this.GlowArmLeft01 = this.GlowBodyMain2.getChild("GlowArmLeft01");
		this.GlowArmRight01 = this.GlowBodyMain2.getChild("GlowArmRight01");
		this.GlowHead = this.GlowNeck.getChild("GlowHead");
		this.GlowArmLeft02 = this.GlowArmLeft01.getChild("GlowArmLeft02");
		this.GlowArmRight02 = this.GlowArmRight01.getChild("GlowArmRight02");
		this.loadFaceParts(this.GlowHead);

		this.EquipSL01 = this.GlowArmLeft02.getChild("EquipSL01");
		this.EquipSL02 = this.EquipSL01.getChild("EquipSL02");
		this.EquipSL03 = this.EquipSL02.getChild("EquipSL03");
		this.EquipSL04 = this.EquipSL01.getChild("EquipSL04");
		this.EquipSL05 = this.EquipSL04.getChild("EquipSL05");
		this.EquipSR01 = this.GlowArmRight02.getChild("EquipSR01");
		this.EquipSR02 = this.EquipSR01.getChild("EquipSR02");
		this.EquipSR03 = this.EquipSR02.getChild("EquipSR03");
		this.EquipSR04 = this.EquipSR01.getChild("EquipSR04");
		this.EquipSR05 = this.EquipSR04.getChild("EquipSR05");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
				CubeListBuilder.create().texOffs(0, 104)
						.addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F),
				PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));

		PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
				CubeListBuilder.create().texOffs(52, 61)
						.addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F),
				PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));

		PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
				CubeListBuilder.create().mirror().texOffs(0, 83)
						.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
				PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.17453292519943295F, 0.0F, -0.10471975511965977F));

		PartDefinition legRight02 = legRight01.addOrReplaceChild("LegRight02",
				CubeListBuilder.create().mirror().texOffs(103, 0)
						.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 3.0F, 6.0F),
				PartPose.offset(0.0F, 14.0F, -3.0F));

		PartDefinition shoesR01 = legRight02.addOrReplaceChild("ShoesR01",
				CubeListBuilder.create().mirror().texOffs(100, 0)
						.addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F),
				PartPose.offsetAndRotation(0.0F, 2.0F, 3.0F, 0.13962634015954636F, 0.0F, 0.0F));

		PartDefinition shoesR02 = shoesR01.addOrReplaceChild("ShoesR02",
				CubeListBuilder.create().mirror().texOffs(90, 0)
						.addBox(-4.0F, 0.0F, -4.0F, 8.0F, 3.0F, 9.0F),
				PartPose.offsetAndRotation(0.0F, 2.5F, -0.7F, 0.20943951023931953F, 0.0F, 0.0F));

		PartDefinition shoesR03 = shoesR02.addOrReplaceChild("ShoesR03",
				CubeListBuilder.create().mirror().texOffs(100, 3)
						.addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F),
				PartPose.offsetAndRotation(0.0F, 2.4F, -0.7F, -0.13962634015954636F, 0.0F, 0.0F));

		shoesR03.addOrReplaceChild("ShoesR04",
				CubeListBuilder.create().mirror().texOffs(104, 13)
						.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F),
				PartPose.offsetAndRotation(0.0F, 2.2F, -0.3F, -0.20943951023931953F, 0.0F, 0.0F));

		legRight01.addOrReplaceChild("LegRight01a",
				CubeListBuilder.create().mirror().texOffs(95, 0)
						.addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F),
				PartPose.offsetAndRotation(0.0F, 8.6F, -0.2F, 0.20943951023931953F, 0.0F, 0.0F));

		legRight01.addOrReplaceChild("LegRight01b",
				CubeListBuilder.create().mirror().texOffs(96, 2)
						.addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F),
				PartPose.offsetAndRotation(0.0F, 11.6F, -0.1F, 0.20943951023931953F, 0.0F, 0.0F));

		PartDefinition skirt01 = butt.addOrReplaceChild("Skirt01",
				CubeListBuilder.create().texOffs(46, 34)
						.addBox(-8.5F, 0.0F, -6.0F, 17.0F, 4.0F, 9.0F),
				PartPose.offsetAndRotation(0.0F, 2.9F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));

		skirt01.addOrReplaceChild("Skirt02",
				CubeListBuilder.create().texOffs(42, 47)
						.addBox(-9.0F, 0.0F, -6.0F, 18.0F, 4.0F, 10.0F),
				PartPose.offsetAndRotation(0.0F, 2.8F, -0.5F, -0.08726646259971647F, 0.0F, 0.0F));

		PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
				CubeListBuilder.create().texOffs(0, 83)
						.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
				PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.3490658503988659F, 0.0F, 0.10471975511965977F));

		PartDefinition legLeft02 = legLeft01.addOrReplaceChild("LegLeft02",
				CubeListBuilder.create().texOffs(92, 2)
						.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 3.0F, 6.0F),
				PartPose.offset(0.0F, 14.0F, -3.0F));

		PartDefinition shoesL01 = legLeft02.addOrReplaceChild("ShoesL01",
				CubeListBuilder.create().texOffs(97, 2)
						.addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F),
				PartPose.offsetAndRotation(0.0F, 2.0F, 3.0F, 0.13962634015954636F, 0.0F, 0.0F));

		PartDefinition shoesL02 = shoesL01.addOrReplaceChild("ShoesL02",
				CubeListBuilder.create().texOffs(90, 0)
						.addBox(-4.0F, 0.0F, -4.0F, 8.0F, 3.0F, 9.0F),
				PartPose.offsetAndRotation(0.0F, 2.5F, -0.7F, 0.20943951023931953F, 0.0F, 0.0F));

		PartDefinition shoesL03 = shoesL02.addOrReplaceChild("ShoesL03",
				CubeListBuilder.create().texOffs(95, 0)
						.addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F),
				PartPose.offsetAndRotation(0.0F, 2.4F, -0.7F, -0.13962634015954636F, 0.0F, 0.0F));

		shoesL03.addOrReplaceChild("ShoesL04",
				CubeListBuilder.create().texOffs(104, 13)
						.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F),
				PartPose.offsetAndRotation(0.0F, 2.2F, -0.3F, -0.20943951023931953F, 0.0F, 0.0F));

		legLeft01.addOrReplaceChild("LegLeft01a",
				CubeListBuilder.create().texOffs(92, 2)
						.addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F),
				PartPose.offsetAndRotation(0.0F, 8.6F, -0.2F, 0.20943951023931953F, 0.0F, 0.0F));

		legLeft01.addOrReplaceChild("LegLeft01b",
				CubeListBuilder.create().texOffs(93, 3)
						.addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F),
				PartPose.offsetAndRotation(0.0F, 11.6F, -0.1F, 0.20943951023931953F, 0.0F, 0.0F));

		bodyMain.addOrReplaceChild("Cloth01",
				CubeListBuilder.create().texOffs(0, 22)
						.addBox(-7.0F, 0.0F, -4.0F, 14.0F, 5.0F, 8.0F),
				PartPose.offset(0.0F, -11.5F, -0.3F));

		bodyMain.addOrReplaceChild("BoobL",
				CubeListBuilder.create().mirror().texOffs(33, 101)
						.addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F),
				PartPose.offsetAndRotation(3.5F, -8.1F, -3.7F, -0.6981317007977318F, 0.08726646259971647F,
						0.08726646259971647F));

		PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
				CubeListBuilder.create().mirror().texOffs(4, 85)
						.addBox(-2.0F, -1.0F, -2.5F, 5.0F, 8.0F, 5.0F),
				PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.3490658503988659F, 0.0F, -0.2617993877991494F));

		armLeft01.addOrReplaceChild("ArmLeft01b",
				CubeListBuilder.create().mirror().texOffs(90, 6)
						.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 6.0F),
				PartPose.offsetAndRotation(0.5F, 9.0F, -0.1F, 0.20943951023931953F, 0.0F, 0.0F));

		armLeft01.addOrReplaceChild("ArmLeft02",
				CubeListBuilder.create().mirror().texOffs(96, 2)
						.addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
				PartPose.offset(3.0F, 12.0F, 2.5F));

		armLeft01.addOrReplaceChild("ArmLeft01a",
				CubeListBuilder.create().mirror().texOffs(90, 9)
						.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 6.0F),
				PartPose.offsetAndRotation(0.5F, 5.5F, -0.2F, 0.20943951023931953F, 0.0F, 0.0F));

		bodyMain.addOrReplaceChild("Cloth02",
				CubeListBuilder.create().texOffs(36, 93)
						.addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 0.0F),
				PartPose.offset(0.3F, -4.5F, -6.5F));

		PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
				CubeListBuilder.create().texOffs(100, 2)
						.addBox(-3.0F, -2.0F, -3.5F, 6.0F, 2.0F, 6.0F),
				PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(44, 101)
						.addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
				PartPose.offset(0.0F, -1.0F, -0.7F));

		PartDefinition hair = head.addOrReplaceChild("Hair",
				CubeListBuilder.create().texOffs(50, 77)
						.addBox(-8.0F, -8.0F, -7.2F, 16.0F, 16.0F, 8.0F),
				PartPose.offset(0.0F, -7.5F, 0.0F));

		hair.addOrReplaceChild("Ahoke",
				CubeListBuilder.create().texOffs(106, 31)
						.addBox(0.0F, -6.0F, -10.5F, 0.0F, 11.0F, 11.0F),
				PartPose.offsetAndRotation(0.0F, -7.0F, -6.0F, 0.20943951023931953F, 0.6981317007977318F, 0.0F));

		PartDefinition hairR01 = hair.addOrReplaceChild("HairR01",
				CubeListBuilder.create().mirror().texOffs(86, 101)
						.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 4.0F),
				PartPose.offsetAndRotation(-7.0F, 3.0F, -5.5F, -0.13962634015954636F, 0.17453292519943295F,
						0.08726646259971647F));

		hairR01.addOrReplaceChild("HairR02",
				CubeListBuilder.create().mirror().texOffs(86, 101)
						.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 4.0F),
				PartPose.offsetAndRotation(0.2F, 7.0F, 0.0F, 0.17453292519943295F, 0.0F, -0.05235987755982988F));

		PartDefinition hairL01 = hair.addOrReplaceChild("HairL01",
				CubeListBuilder.create().texOffs(86, 101)
						.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 4.0F),
				PartPose.offsetAndRotation(7.0F, 3.0F, -5.5F, -0.13962634015954636F, -0.17453292519943295F,
						-0.08726646259971647F));

		hairL01.addOrReplaceChild("HairL02",
				CubeListBuilder.create().texOffs(86, 101)
						.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 4.0F),
				PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.08726646259971647F));

		PartDefinition hairMain = head.addOrReplaceChild("HairMain",
				CubeListBuilder.create().texOffs(0, 57)
						.addBox(-7.5F, 0.0F, 0.0F, 15.0F, 12.0F, 10.0F),
				PartPose.offset(0.0F, -15.0F, -3.0F));

		PartDefinition hair01 = hairMain.addOrReplaceChild("Hair01",
				CubeListBuilder.create().texOffs(0, 57)
						.addBox(-7.5F, 0.0F, 0.0F, 15.0F, 17.0F, 9.0F),
				PartPose.offsetAndRotation(0.0F, 9.0F, 1.0F, 0.20943951023931953F, 0.0F, 0.0F));

		PartDefinition hair02 = hair01.addOrReplaceChild("Hair02",
				CubeListBuilder.create().texOffs(0, 58)
						.addBox(-8.0F, 0.0F, -5.0F, 16.0F, 16.0F, 8.0F),
				PartPose.offsetAndRotation(0.0F, 13.5F, 5.5F, -0.08726646259971647F, 0.0F, 0.0F));

		hair02.addOrReplaceChild("Hair03",
				CubeListBuilder.create().texOffs(0, 35)
						.addBox(-8.0F, 0.0F, -4.5F, 16.0F, 15.0F, 7.0F),
				PartPose.offsetAndRotation(0.0F, 12.5F, -0.1F, -0.13962634015954636F, 0.0F, 0.0F));

		PartDefinition hair04 = hairMain.addOrReplaceChild("Hair04",
				CubeListBuilder.create().texOffs(108, 0)
						.addBox(0.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F),
				PartPose.offsetAndRotation(6.5F, 3.5F, 6.0F, 0.0F, -0.08726646259971647F, -0.08726646259971647F));

		PartDefinition hair05 = hair04.addOrReplaceChild("Hair05",
				CubeListBuilder.create().texOffs(108, 28)
						.addBox(0.0F, -2.5F, -2.5F, 5.0F, 9.0F, 5.0F),
				PartPose.offsetAndRotation(1.5F, -1.0F, 0.0F, 0.10471975511965977F, -0.08726646259971647F,
						-0.17453292519943295F));

		PartDefinition hair06 = hair05.addOrReplaceChild("Hair06",
				CubeListBuilder.create().texOffs(109, 28)
						.addBox(-2.0F, 0.0F, -2.5F, 4.0F, 7.0F, 5.0F),
				PartPose.offsetAndRotation(2.5F, 4.0F, 0.0F, 0.20943951023931953F, 0.0F, 0.13962634015954636F));

		hair06.addOrReplaceChild("Hair07",
				CubeListBuilder.create().texOffs(110, 29)
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F),
				PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, -0.2617993877991494F, 0.0F, 0.13962634015954636F));

		PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
				CubeListBuilder.create().mirror().texOffs(0, 85)
						.addBox(-3.0F, -1.0F, -2.5F, 5.0F, 8.0F, 5.0F),
				PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, 0.0F, 0.0F, 0.2617993877991494F));

		armRight01.addOrReplaceChild("ArmRight02",
				CubeListBuilder.create().mirror().texOffs(93, 0)
						.addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
				PartPose.offset(-3.0F, 12.0F, 2.5F));

		armRight01.addOrReplaceChild("ArmRight01a",
				CubeListBuilder.create().texOffs(92, 3)
						.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 6.0F),
				PartPose.offsetAndRotation(-0.5F, 5.5F, -0.2F, 0.20943951023931953F, 0.0F, 0.0F));

		armRight01.addOrReplaceChild("ArmRight01b",
				CubeListBuilder.create().texOffs(92, 0)
						.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 6.0F),
				PartPose.offsetAndRotation(-0.5F, 9.0F, -0.1F, 0.20943951023931953F, 0.0F, 0.0F));

		bodyMain.addOrReplaceChild("BoobR",
				CubeListBuilder.create().texOffs(33, 101)
						.addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F),
				PartPose.offsetAndRotation(-3.5F, -8.1F, -3.7F, -0.6981317007977318F, -0.08726646259971647F,
						-0.08726646259971647F));

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

		PartDefinition glowBodyMain2 = partdefinition.addOrReplaceChild("GlowBodyMain2",
				CubeListBuilder.create(),
				PartPose.offset(0.0F, -15.0F, 0.0F));

		PartDefinition glowArmLeft01 = glowBodyMain2.addOrReplaceChild("GlowArmLeft01",
				CubeListBuilder.create(),
				PartPose.offset(7.8F, -9.3F, -0.7F));

		PartDefinition glowArmLeft02 = glowArmLeft01.addOrReplaceChild("GlowArmLeft02",
				CubeListBuilder.create(),
				PartPose.offset(3.0F, 12.0F, 2.5F));

		PartDefinition equipSL01 = glowArmLeft02.addOrReplaceChild("EquipSL01",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F),
				PartPose.offsetAndRotation(-3.0F, 10.5F, -6.0F, -1.5707963267948966F, 0.0F, 1.5707963267948966F));

		PartDefinition equipSL02 = equipSL01.addOrReplaceChild("EquipSL02",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F),
				PartPose.offset(0.0F, 16.0F, 0.0F));

		equipSL02.addOrReplaceChild("EquipSL03",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F),
				PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition equipSL04 = equipSL01.addOrReplaceChild("EquipSL04",
				CubeListBuilder.create().texOffs(109, 0)
						.addBox(-0.5F, -9.0F, -0.5F, 1.0F, 9.0F, 1.0F),
				PartPose.ZERO);

		equipSL04.addOrReplaceChild("EquipSL05",
				CubeListBuilder.create().texOffs(100, 0)
						.addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F),
				PartPose.offset(0.0F, -9.0F, 0.0F));

		PartDefinition glowArmRight01 = glowBodyMain2.addOrReplaceChild("GlowArmRight01",
				CubeListBuilder.create(),
				PartPose.offset(-7.8F, -9.3F, -0.7F));

		PartDefinition glowArmRight02 = glowArmRight01.addOrReplaceChild("GlowArmRight02",
				CubeListBuilder.create(),
				PartPose.offset(-3.0F, 12.0F, 2.5F));

		PartDefinition equipSR01 = glowArmRight02.addOrReplaceChild("EquipSR01",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F),
				PartPose.offsetAndRotation(3.0F, 10.5F, -6.0F, -1.5707963267948966F, 0.0F, 1.5707963267948966F));

		PartDefinition equipSR02 = equipSR01.addOrReplaceChild("EquipSR02",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F),
				PartPose.offset(0.0F, 16.0F, 0.0F));

		equipSR02.addOrReplaceChild("EquipSR03",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F),
				PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition equipSR04 = equipSR01.addOrReplaceChild("EquipSR04",
				CubeListBuilder.create().texOffs(107, 0)
						.addBox(-0.5F, -9.0F, -0.5F, 1.0F, 9.0F, 1.0F),
				PartPose.ZERO);

		equipSR04.addOrReplaceChild("EquipSR05",
				CubeListBuilder.create().texOffs(100, 0)
						.addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F),
				PartPose.offset(0.0F, -9.0F, 0.0F));

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
		boolean f1 = EmotionHelper.checkModelState(1, state);
		boolean f2 = EmotionHelper.checkModelState(2, state);

		if (f1 || f2) {
			this.GlowBodyMain2.visible = true;
			this.GlowArmLeft01.visible = !f1;
			this.GlowArmRight01.visible = !f2;
		} else {
			this.GlowBodyMain2.visible = false;
		}
	}

	@Override
	public void syncRotationGlowPart() {
		this.GlowBodyMain.xRot = this.BodyMain.xRot;
		this.GlowBodyMain.yRot = this.BodyMain.yRot;
		this.GlowBodyMain.zRot = this.BodyMain.zRot;
		this.GlowBodyMain2.xRot = this.BodyMain.xRot;
		this.GlowBodyMain2.yRot = this.BodyMain.yRot;
		this.GlowBodyMain2.zRot = this.BodyMain.zRot;
		this.GlowHead.xRot = this.Head.xRot;
		this.GlowHead.yRot = this.Head.yRot;
		this.GlowHead.zRot = this.Head.zRot;
		this.GlowArmLeft01.xRot = this.ArmLeft01.xRot;
		this.GlowArmLeft01.yRot = this.ArmLeft01.yRot;
		this.GlowArmLeft01.zRot = this.ArmLeft01.zRot;
		this.GlowArmLeft02.xRot = this.ArmLeft02.xRot;
		this.GlowArmLeft02.yRot = this.ArmLeft02.yRot;
		this.GlowArmLeft02.zRot = this.ArmLeft02.zRot;
		this.GlowArmRight01.xRot = this.ArmRight01.xRot;
		this.GlowArmRight01.yRot = this.ArmRight01.yRot;
		this.GlowArmRight01.zRot = this.ArmRight01.zRot;
		this.GlowArmRight02.xRot = this.ArmRight02.xRot;
		this.GlowArmRight02.yRot = this.ArmRight02.yRot;
		this.GlowArmRight02.zRot = this.ArmRight02.zRot;
	}

	@Override
	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

  // [PORT] Restored from 1.10.2 GlStateManager.translate
  this.offsetY += 0.49F;
		this.setFaceHungry(ent);

		// head
		this.Head.xRot = 0.65F;
		this.Head.yRot = 0F;
		this.Head.zRot = 0F;
		// 胸部
		this.BoobL.xRot = -0.75F;
		this.BoobR.xRot = -0.75F;
		// body
		this.Ahoke.yRot = 0.7F;
		this.BodyMain.xRot = -0.2F;
		this.BodyMain.yRot = 0F;
		this.BodyMain.zRot = 0F;
		this.Butt.xRot = -0.14F;
		this.Skirt01.xRot = -0.1745F;
		// this.Skirt01.offsetY = 0F;
		this.Skirt02.xRot = -0.2618F;
		// this.Skirt02.offsetY = 0F;
		// hair
		this.Hair01.xRot = -0.1F;
		this.Hair01.zRot = 0F;
		this.Hair02.xRot = -0.2F;
		this.Hair02.zRot = 0F;
		this.Hair03.xRot = -0.14F;
		this.Hair03.zRot = 0F;
		this.Hair05.xRot = -0.4F;
		this.Hair05.zRot = 0F;
		this.Hair06.xRot = 0.14F;
		this.Hair06.zRot = 0F;
		this.Hair07.xRot = -0.2F;
		this.Hair07.zRot = 0F;
		this.HairL01.xRot = -0.14F;
		this.HairL01.zRot = 0F;
		this.HairL02.xRot = 0.17F;
		this.HairL02.zRot = 0F;
		this.HairR01.xRot = -0.14F;
		this.HairR01.zRot = 0F;
		this.HairR02.xRot = 0.17F;
		this.HairR02.zRot = 0F;
		// arm
		this.ArmLeft01.xRot = 0.2F;
		this.ArmLeft01.yRot = 0F;
		this.ArmLeft01.zRot = -0.2618F;
		this.ArmLeft02.xRot = 0F;
		// this.ArmLeft02.offsetY = 0F;
		// this.ArmLeft02.offsetZ = 0F;
		this.ArmRight01.xRot = 0.2F;
		this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = 0.2618F;
		this.ArmRight02.yRot = 0F;
		this.ArmRight02.zRot = 0F;
		this.ArmRight02.xRot = 0F;
		// this.ArmRight02.offsetY = 0F;
		// this.ArmRight02.offsetZ = 0F;
		// leg
		this.LegLeft01.xRot = -0.9F;
		this.LegLeft01.zRot = -0.14F;
		this.LegLeft02.xRot = 1.2217F;
		this.LegLeft02.yRot = 1.2217F;
		this.LegLeft02.zRot = -1.0472F;
		// this.LegLeft02.offsetX = 0.22F;
		// this.LegLeft02.offsetY = -0.03F;
		// this.LegLeft02.offsetZ = 0.2F;
		this.LegRight01.xRot = -0.9F;
		this.LegRight01.zRot = 0.14F;
		this.LegRight02.xRot = 1.2217F;
		this.LegRight02.yRot = -1.2217F;
		this.LegRight02.zRot = 1.0472F;
		// this.LegRight02.offsetX = -0.22F;
		// this.LegRight02.offsetY = -0.03F;
		// this.LegRight02.offsetZ = 0.2F;
		// equip
		this.GlowBodyMain2.visible = false;
		// 鬢毛調整
		this.Hair01.zRot = 0F;
		this.Hair02.zRot = 0F;
		this.HairL01.zRot = 0.087F;
		this.HairL02.zRot = 0.087F;
		this.HairR01.zRot = 0.087F;
		this.HairR02.zRot = -0.052F;
		this.HairL01.xRot = -0.65F;
		this.HairL02.xRot = 0.17F;
		this.HairR01.xRot = -0.65F;
		this.HairR02.xRot = 0.17F;
	}

	@Override
	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

		float angleX = Mth.cos(f2 * 0.08F + f * 0.25F);
		float angleX1 = Mth.cos(f2 * 0.08F + 0.3F + f * 0.5F);
		float angleX2 = Mth.cos(f2 * 0.08F + 0.6F + f * 0.5F);
		float angleAdd1 = Mth.cos(f * 0.7F) * f1;
		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
		float addk1;
		float addk2;
		float headX;
		float headZ;

		// 水上漂浮
		if (ent.getShipDepth(0) > 0D || ent.getShipDepth(1) > 0D) {
			this.offsetY += angleX * 0.05F + 0.025F;
		}

		// leg move
  // [PORT] Restored from 1.10.2 GlStateManager.translate
  this.offsetY += angleX * 0.05F + 0.025F;
		addk1 = angleAdd1 * 0.5F - 0.35F;
		addk2 = angleAdd2 * 0.5F - 0.1745F;

		// head
		this.Head.xRot = f4 * 0.014F;
		this.Head.yRot = f3 * 0.01F;
		// 胸部
		this.BoobL.xRot = angleX * 0.06F - 0.75F;
		this.BoobR.xRot = angleX * 0.06F - 0.75F;
		// body
		this.Ahoke.yRot = angleX * 0.2F + 0.7F;
		this.BodyMain.xRot = -0.1047F;
		this.BodyMain.yRot = 0F;
		this.BodyMain.zRot = 0F;
		this.Butt.xRot = 0.35F;
		this.Skirt01.xRot = -0.14F;
		// this.Skirt01.offsetY = 0F;
		this.Skirt02.xRot = -0.087F;
		// this.Skirt02.offsetY = 0F;
		// hair
		this.Hair01.xRot = angleX * 0.03F + 0.21F;
		this.Hair01.zRot = 0F;
		this.Hair02.xRot = -angleX1 * 0.04F - 0.087F;
		this.Hair02.zRot = 0F;
		this.Hair03.xRot = -angleX2 * 0.07F - 0.14F;
		this.Hair03.zRot = 0F;
		this.Hair05.xRot = angleX * 0.06F + 0.1F;
		this.Hair05.zRot = 0F;
		this.Hair06.xRot = -angleX1 * 0.08F + 0.14F;
		this.Hair06.zRot = 0F;
		this.Hair07.xRot = -angleX2 * 0.1F - 0.2F;
		this.Hair07.zRot = 0F;
		this.HairL01.xRot = angleX * 0.04F - 0.14F;
		this.HairL01.zRot = 0F;
		this.HairL02.xRot = -angleX1 * 0.06F + 0.17F;
		this.HairL02.zRot = 0F;
		this.HairR01.xRot = angleX * 0.04F - 0.14F;
		this.HairR01.zRot = 0F;
		this.HairR02.xRot = -angleX1 * 0.06F + 0.17F;
		this.HairR02.zRot = 0F;
		// arm
		this.ArmLeft01.xRot = angleAdd2 * 0.25F + 0.35F;
		this.ArmLeft01.yRot = 0F;
		this.ArmLeft01.zRot = angleX * 0.03F - 0.26F;
		this.ArmLeft02.xRot = 0F;
		// this.ArmLeft02.offsetY = 0F;
		// this.ArmLeft02.offsetZ = 0F;
		this.ArmRight01.xRot = angleAdd1 * 0.25F;
		this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = -angleX * 0.03F + 0.26F;
		this.ArmRight02.yRot = 0F;
		this.ArmRight02.zRot = 0F;
		this.ArmRight02.xRot = 0F;
		// this.ArmRight02.offsetY = 0F;
		// this.ArmRight02.offsetZ = 0F;
		// leg
		this.LegLeft01.zRot = 0.1F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.yRot = 0F;
		this.LegLeft02.zRot = 0F;
		// this.LegLeft02.offsetX = 0F;
		// this.LegLeft02.offsetY = 0F;
		// this.LegLeft02.offsetZ = 0F;
		this.LegRight01.zRot = -0.1F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.yRot = 0F;
		this.LegRight02.zRot = 0F;
		// this.LegRight02.offsetX = 0F;
		// this.LegRight02.offsetY = 0F;
		// this.LegRight02.offsetZ = 0F;
		// equip
		if (this.EquipSL01 != null)
			this.EquipSL01.xRot = -1.57F;
		if (this.EquipSL01 != null)
			this.EquipSL01.yRot = 0F;
		if (this.EquipSL01 != null)
			this.EquipSL01.zRot = 1.57F;
		// this.EquipSL01.offsetX = 0F;
		// this.EquipSL01.offsetY = 0F;
		// this.EquipSL01.offsetZ = 0F;
		if (this.EquipSR01 != null)
			this.EquipSR01.xRot = -1.57F;
		if (this.EquipSR01 != null)
			this.EquipSR01.yRot = 0F;
		if (this.EquipSR01 != null)
			this.EquipSR01.zRot = 1.57F;
		// this.EquipSR01.offsetX = 0F;
		// this.EquipSR01.offsetY = 0F;
		// this.EquipSR01.offsetZ = 0F;

		// 奔跑動作
		if (ent.getIsSprinting() || f1 > 0.95F) {
			// body
   // [PORT] Restored from 1.10.2 GlStateManager.translate
   this.offsetY += 0.05F;
			this.Head.xRot -= 0.4F;
			this.BodyMain.xRot = 0.7F;
			this.Butt.xRot -= 0.7F;
			this.Skirt01.xRot = -0.15F;
			this.Skirt02.xRot = -0.32F;
			// hair
			this.Hair01.xRot += 0.3F;
			// arm
			this.ArmLeft01.xRot = 0.4F;
			this.ArmLeft01.yRot = -0.5F;
			this.ArmLeft01.zRot = -0.7F;
			this.ArmRight01.xRot = 0.4F;
			this.ArmRight01.yRot = 0.5F;
			this.ArmRight01.zRot = 0.7F;
		}

		// head tilt angle
		this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

		// 潛行, 蹲下動作
		if (ent.getIsSneaking()) {
			// Body
   // [PORT] Restored from 1.10.2 GlStateManager.translate
   this.offsetY += 0.05F;
			this.Head.xRot -= 1.0472F;
			this.BodyMain.xRot = 1.0472F;
			this.Butt.xRot = -0.4F;
			this.Skirt01.xRot = -0.12F;
			this.Skirt02.xRot = -0.16F;
			// this.Skirt02.offsetY = -0.1F;
			// hair
			this.Hair02.xRot -= 0.3F;
			this.Hair03.xRot -= 0.3F;
			// arm
			int state = ent.getStateEmotion(ID.S.State);
			boolean fs1 = EmotionHelper.checkModelState(1, state);
			boolean fs2 = EmotionHelper.checkModelState(2, state);

			if (fs1 || fs2) {
				this.ArmLeft01.xRot = angleAdd2 * 0.25F - 0.1F;
				this.ArmLeft01.yRot = -0.7F;
				this.ArmLeft01.zRot = -0.3F;
				this.ArmRight01.xRot = angleAdd1 * 0.25F - 0.1F;
				this.ArmRight01.yRot = 0.7F;
				this.ArmRight01.zRot = 0.3F;
			} else {
				this.ArmLeft01.xRot = -0.6F;
				this.ArmLeft01.zRot = 0.2618F;
				this.ArmRight01.xRot = -0.6F;
				this.ArmRight01.zRot = -0.2618F;
			}
			// leg
			addk1 -= 0.4F;
			addk2 -= 0.4F;
		} // end if sneaking

		// 騎乘動作
		if (((net.minecraft.world.entity.Entity) ent).getVehicle() instanceof BasicEntityMount) {
			if (ent.getIsSitting()) {
				if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
					// Body
     // [PORT] Restored from 1.10.2 GlStateManager.translate
     this.offsetY += 0.65F;
                    this.offsetZ -= 0.27F;
					this.Head.xRot = -1.2217F;
					this.Head.yRot = 0F;
					this.Head.zRot = 0F;
					this.BodyMain.xRot = 1.2217F;
					// hair
					this.Hair02.xRot += 0.2F;
					this.Hair03.xRot += 0.2F;
					this.Hair05.xRot -= 0.6F;
					this.Hair06.xRot -= 0.5F;
					// arm
					this.ArmLeft01.xRot = -2F;
					this.ArmLeft01.yRot = -0.1F;
					this.ArmLeft01.zRot = -0.1F;
					this.ArmLeft02.xRot = -2.5F;
					// this.ArmLeft02.offsetY = 0.1F;
					// this.ArmLeft02.offsetZ = -0.3F;
					this.ArmRight01.xRot = -2F;
					this.ArmRight01.yRot = 0.1F;
					this.ArmRight01.zRot = 0.1F;
					this.ArmRight02.xRot = -2.5F;
					// this.ArmRight02.offsetY = 0.1F;
					// this.ArmRight02.offsetZ = -0.3F;
					// leg
					addk1 = 0F;
					addk2 = 0F;
					this.LegLeft02.xRot = angleX * 0.4F + 0.8F;
					this.LegRight02.xRot = -angleX * 0.4F + 0.8F;
					// equip
					this.GlowBodyMain2.visible = false;
				} else {
					// head
     // [PORT] Restored from 1.10.2 GlStateManager.translate
     this.offsetY += 0.51F;
					this.Head.yRot -= 0.4F;
					this.Head.zRot += 0.2F;
					// body
					this.BodyMain.xRot = -0.25F;
					this.Butt.xRot = -0.2F;
					this.Skirt01.xRot = -0.13F;
					// this.Skirt01.offsetY = -0.05F;
					this.Skirt02.xRot = -0.13F;
					// this.Skirt02.offsetY = -0.05F;
					// arm
					this.ArmLeft01.xRot = 0.35F;
					this.ArmLeft01.zRot = -0.2618F;
					this.ArmRight01.xRot = -0.4F;
					this.ArmRight01.zRot = 0.4F;
					// leg
					addk1 = -0.9F;
					addk2 = -0.9F;
					this.LegLeft01.zRot = -0.14F;
					this.LegLeft02.xRot = 1.2217F;
					this.LegLeft02.yRot = 1.2217F;
					this.LegLeft02.zRot = -1.0472F;
					// this.LegLeft02.offsetX = 0.22F;
					// this.LegLeft02.offsetY = -0.03F;
					// this.LegLeft02.offsetZ = 0.2F;
					this.LegRight01.zRot = 0.14F;
					this.LegRight02.xRot = 1.2217F;
					this.LegRight02.yRot = -1.2217F;
					this.LegRight02.zRot = 1.0472F;
					// this.LegRight02.offsetX = -0.22F;
					// this.LegRight02.offsetY = -0.03F;
					// this.LegRight02.offsetZ = 0.2F;
					// equip
					if (this.EquipSL01 != null)
						this.EquipSL01.xRot -= 0.06F;
					if (this.EquipSL01 != null)
						this.EquipSL01.zRot -= 1.2F;
					if (this.EquipSR01 != null)
						this.EquipSR01.xRot -= 1.2F;
				}
			} else {
				// body
    // [PORT] Restored from 1.10.2 GlStateManager.translate
    this.offsetY += 0.56F;
				this.BodyMain.xRot = -0.45F;
				this.Butt.xRot = -0.2F;
				this.Skirt01.xRot = -0.13F;
				// this.Skirt01.offsetY = -0.05F;
				this.Skirt02.xRot = -0.13F;
				// this.Skirt02.offsetY = -0.05F;
				// arm
				this.ArmLeft01.xRot = 0.2F;
				this.ArmLeft01.zRot = -1.1F;
				this.ArmRight01.xRot = 0.2F;
				this.ArmRight01.zRot = 1.1F;
				// leg
				addk1 = -0.8F;
				addk2 = -1.2F;
				this.LegLeft01.zRot = -0.14F;
				this.LegLeft02.xRot = 1.2217F;
				this.LegLeft02.yRot = 1.2217F;
				this.LegLeft02.zRot = -1.0472F;
				// this.LegLeft02.offsetX = 0.22F;
				// this.LegLeft02.offsetY = -0.03F;
				// this.LegLeft02.offsetZ = 0.2F;
				this.LegRight01.zRot = 0.14F;
				this.LegRight02.xRot = 0.9F;
				// equip
				if (this.EquipSL01 != null)
					this.EquipSL01.xRot = -1.2F;
				if (this.EquipSL01 != null)
					this.EquipSL01.yRot = 0.1F;
				if (this.EquipSL01 != null)
					this.EquipSL01.zRot = 1F;
				// this.EquipSL01.offsetX = 0.24F;
				// this.EquipSL01.offsetY = -0.5F;
				// this.EquipSL01.offsetZ = 1F;
				if (this.EquipSR01 != null)
					this.EquipSR01.xRot = -1.2F;
				if (this.EquipSR01 != null)
					this.EquipSR01.yRot = -0.1F;
				if (this.EquipSR01 != null)
					this.EquipSR01.zRot = -1F;
				// this.EquipSR01.offsetX = -0.24F;
				// this.EquipSR01.offsetY = -0.5F;
				// this.EquipSR01.offsetZ = 1F;
			}
		} else if (ent.getIsSitting() || ent.getIsRiding()) {
			if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
				// Body
				this.Head.xRot = -1.2217F;
				this.Head.yRot = 0F;
				this.Head.zRot = 0F;
				this.BodyMain.xRot = 1.2217F;
				// hair
				this.Hair02.xRot += 0.2F;
				this.Hair03.xRot += 0.2F;
				this.Hair05.xRot -= 0.6F;
				this.Hair06.xRot -= 0.5F;
				// arm
				this.ArmLeft01.xRot = -2F;
				this.ArmLeft01.yRot = -0.1F;
				this.ArmLeft01.zRot = -0.1F;
				this.ArmLeft02.xRot = -2.5F;
				// this.ArmLeft02.offsetY = 0.1F;
				// this.ArmLeft02.offsetZ = -0.3F;
				this.ArmRight01.xRot = -2F;
				this.ArmRight01.yRot = 0.1F;
				this.ArmRight01.zRot = 0.1F;
				this.ArmRight02.xRot = -2.5F;
				// this.ArmRight02.offsetY = 0.1F;
				// this.ArmRight02.offsetZ = -0.3F;
				// leg
				addk1 = 0F;
				addk2 = 0F;
				this.LegLeft02.xRot = angleX * 0.4F + 0.8F;
				this.LegRight02.xRot = -angleX * 0.4F + 0.8F;
				// equip
				this.GlowBodyMain2.visible = false;
			} else {
				// head
				this.Head.yRot -= 0.4F;
				this.Head.zRot += 0.2F;
				// body
				this.BodyMain.xRot = -0.25F;
				this.Butt.xRot = -0.2F;
				this.Skirt01.xRot = -0.13F;
				// this.Skirt01.offsetY = -0.05F;
				this.Skirt02.xRot = -0.13F;
				// this.Skirt02.offsetY = -0.05F;
				// arm
				this.ArmLeft01.xRot = 0.35F;
				this.ArmLeft01.zRot = -0.2618F;
				this.ArmRight01.xRot = -0.4F;
				this.ArmRight01.zRot = 0.4F;
				// leg
				addk1 = -0.9F;
				addk2 = -0.9F;
				this.LegLeft01.zRot = -0.14F;
				this.LegLeft02.xRot = 1.2217F;
				this.LegLeft02.yRot = 1.2217F;
				this.LegLeft02.zRot = -1.0472F;
				// this.LegLeft02.offsetX = 0.22F;
				// this.LegLeft02.offsetY = -0.03F;
				// this.LegLeft02.offsetZ = 0.2F;
				this.LegRight01.zRot = 0.14F;
				this.LegRight02.xRot = 1.2217F;
				this.LegRight02.yRot = -1.2217F;
				this.LegRight02.zRot = 1.0472F;
				// this.LegRight02.offsetX = -0.22F;
				// this.LegRight02.offsetY = -0.03F;
				// this.LegRight02.offsetZ = 0.2F;
				// equip
				if (this.EquipSL01 != null)
					this.EquipSL01.xRot -= 0.06F;
				if (this.EquipSL01 != null)
					this.EquipSL01.zRot -= 1.2F;
				if (this.EquipSR01 != null)
					this.EquipSR01.xRot -= 1.2F;
			}
		}

		if (!(((net.minecraft.world.entity.Entity) ent).getVehicle() instanceof BasicEntityMount)) {
			// 攻擊動作
			int atktime = ent.getAttackTick();
			if (atktime > 41) {
				setFaceAttack(ent);
				// swing arm
				float ft = (50 - ent.getAttackTick()) + (f2 - (int) f2);
				ft *= 0.125F;
				float fa = Mth.cos(ft * ft * (float) Math.PI);
				float fb = Mth.cos(Mth.sqrt(ft) * (float) Math.PI);
				this.ArmLeft01.xRot += -fb * 120.0F * ((float) Math.PI / 180F) - 1.5F;
				this.ArmLeft01.yRot += fa * 20.0F * ((float) Math.PI / 180F);
				this.ArmLeft01.zRot += fb * 20.0F * ((float) Math.PI / 180F) + 0.26F;
			}
			if (atktime > 36 && atktime < 45) {
				setFaceAttack(ent);
				// swing arm
				float ft = (45 - ent.getAttackTick()) + (f2 - (int) f2);
				ft *= 0.125F;
				float fa = Mth.cos(ft * ft * (float) Math.PI);
				float fb = Mth.cos(Mth.sqrt(ft) * (float) Math.PI);
				this.ArmRight01.xRot += -fb * 120.0F * ((float) Math.PI / 180F) - 1.5F;
				this.ArmRight01.yRot += -fa * 20.0F * ((float) Math.PI / 180F);
				this.ArmRight01.zRot += -fb * 20.0F * ((float) Math.PI / 180F) - 0.26F;
			}

			// swing arm
			float f6 = ent.getSwingTime(f2 - (int) f2);
			if (f6 != 0F) {
				float f7 = Mth.sin(f6 * f6 * (float) Math.PI);
				float f8 = Mth.sin(Mth.sqrt(f6) * (float) Math.PI);
				this.ArmRight01.xRot += -f8 * 95.0F * ((float) Math.PI / 180F);
				this.ArmRight01.yRot += -f7 * 20.0F * ((float) Math.PI / 180F) + 0.2F;
				this.ArmRight01.zRot += -f8 * 20.0F * ((float) Math.PI / 180F);
			}
		}

		// 鬢毛調整
		headX = this.Head.xRot * -0.5F;
		headZ = this.Head.zRot * -0.5F;
		this.Hair01.xRot += headX;
		this.Hair01.zRot += headZ;
		this.Hair02.xRot += headX * 0.5F;
		this.Hair02.zRot += headZ * 0.5F;
		this.Hair03.xRot += headX * 0.5F;
		this.Hair03.zRot += headZ * 0.5F;
		this.Hair05.xRot += headX;
		this.Hair05.zRot += headZ;
		this.Hair06.xRot += headX;
		this.Hair06.zRot += headZ;
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
	}
}
