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

public class ModelCruiserTatsuta extends ShipModelBaseAdv<Entity> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(Reference.MOD_ID, "cl_tatsuta"), "main");

	private final ModelPart BodyMain;
	private final ModelPart Neck;
	private final ModelPart BoobR;
	private final ModelPart BoobL;
	private final ModelPart Butt;
	private final ModelPart ArmRight01;
	private final ModelPart ArmLeft01;
	private final ModelPart Cloth01;
	private final ModelPart Equip00;
	private final ModelPart Head;
	private final ModelPart Hair;
	private final ModelPart HairMain;
	private final ModelPart CirBase;
	private final ModelPart HairU01;
	private final ModelPart Ahoke;
	private final ModelPart Hair01;
	private final ModelPart Cir00;
	private final ModelPart Cir01;
	private final ModelPart Cir02;
	private final ModelPart Cir03;
	private final ModelPart Cir04;
	private final ModelPart LegLeft01;
	private final ModelPart Skirt01;
	private final ModelPart LegRight01;
	private final ModelPart LegLeft02;
	private final ModelPart Skirt02;
	private final ModelPart LegRight02;
	private final ModelPart ArmRight02;
	private final ModelPart ArmLeft02;
	private final ModelPart EquipSL00;
	private final ModelPart EquipSL01;
	private final ModelPart EquipSL04;
	private final ModelPart EquipSL02;
	private final ModelPart EquipSL03a;
	private final ModelPart EquipSL03b;
	private final ModelPart EquipSL03c;
	private final ModelPart EquipSL05;
	private final ModelPart Equip01a;
	private final ModelPart Equip01b;
	private final ModelPart Equip01c;
	private final ModelPart Equip02a;
	private final ModelPart Equip01d;
	private final ModelPart Equip03L;
	private final ModelPart Equip03R;
	private final ModelPart EquipCL01;
	private final ModelPart EquipCL02;
	private final ModelPart EquipCL03a;
	private final ModelPart EquipCL03b;
	private final ModelPart EquipCL03c;
	private final ModelPart EquipCR01;
	private final ModelPart EquipCR02;
	private final ModelPart EquipCR03a;
	private final ModelPart EquipCR03b;
	private final ModelPart EquipCR03c;
	private final ModelPart Equip02b;
	private final ModelPart Equip02c;
	private final ModelPart Equip02d;
	private final ModelPart GlowBodyMain;
	private final ModelPart GlowNeck;
	private final ModelPart GlowHead;
	private final ModelPart GlowBodyMain2;
	private final ModelPart GlowNeck2;
	private final ModelPart GlowHead2;
	private final ModelPart GlowEquip00;
	private final ModelPart GlowEquip01a;
	private final ModelPart GlowEquip02a;

	public ModelCruiserTatsuta(ModelPart root) {
		super();
		this.BodyMain = root.getChild("BodyMain");
		this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
		this.BoobR = this.BodyMain.getChild("BoobR");
		this.BoobL = this.BodyMain.getChild("BoobL");
		this.Neck = this.BodyMain.getChild("Neck");
		this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
		this.Equip00 = this.BodyMain.getChild("Equip00");
		this.Butt = this.BodyMain.getChild("Butt");
		this.Cloth01 = this.BodyMain.getChild("Cloth01");
		this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
		this.Head = this.Neck.getChild("Head");
		this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
		this.Equip01a = this.Equip00.getChild("Equip01a");
		this.LegRight01 = this.Butt.getChild("LegRight01");
		this.Skirt01 = this.Butt.getChild("Skirt01");
		this.LegLeft01 = this.Butt.getChild("LegLeft01");
		this.Hair = this.Head.getChild("Hair");
		this.HairMain = this.Head.getChild("HairMain");
		this.EquipSL00 = this.ArmLeft02.getChild("EquipSL00");
		this.Equip02a = this.Equip01a.getChild("Equip02a");
		this.Equip01b = this.Equip01a.getChild("Equip01b");
		this.Equip01c = this.Equip01a.getChild("Equip01c");
		this.LegRight02 = this.LegRight01.getChild("LegRight02");
		this.Skirt02 = this.Skirt01.getChild("Skirt02");
		this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
		this.Ahoke = this.Hair.getChild("Ahoke");
		this.HairU01 = this.Hair.getChild("HairU01");
		this.Hair01 = this.HairMain.getChild("Hair01");
		this.EquipSL04 = this.EquipSL00.getChild("EquipSL04");
		this.EquipSL01 = this.EquipSL00.getChild("EquipSL01");
		this.Equip01d = this.Equip01c.getChild("Equip01d");
		this.EquipSL05 = this.EquipSL04.getChild("EquipSL05");
		this.EquipSL02 = this.EquipSL01.getChild("EquipSL02");
		this.Equip03R = this.Equip01d.getChild("Equip03R");
		this.Equip03L = this.Equip01d.getChild("Equip03L");
		this.EquipSL03c = this.EquipSL02.getChild("EquipSL03c");
		this.EquipSL03a = this.EquipSL02.getChild("EquipSL03a");
		this.EquipSL03b = this.EquipSL02.getChild("EquipSL03b");
		this.EquipCR01 = this.Equip03R.getChild("EquipCR01");
		this.EquipCL01 = this.Equip03L.getChild("EquipCL01");
		this.EquipCR02 = this.EquipCR01.getChild("EquipCR02");
		this.EquipCL02 = this.EquipCL01.getChild("EquipCL02");
		this.EquipCR03c = this.EquipCR02.getChild("EquipCR03c");
		this.EquipCR03b = this.EquipCR02.getChild("EquipCR03b");
		this.EquipCR03a = this.EquipCR02.getChild("EquipCR03a");
		this.EquipCL03b = this.EquipCL02.getChild("EquipCL03b");
		this.EquipCL03a = this.EquipCL02.getChild("EquipCL03a");
		this.EquipCL03c = this.EquipCL02.getChild("EquipCL03c");

		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowBodyMain2 = root.getChild("GlowBodyMain2");
		this.GlowNeck = this.GlowBodyMain.getChild("GlowNeck");
		this.GlowEquip00 = this.GlowBodyMain.getChild("GlowEquip00");
		this.GlowNeck2 = this.GlowBodyMain2.getChild("GlowNeck2");
		this.GlowHead = this.GlowNeck.getChild("GlowHead");
		this.GlowEquip01a = this.GlowEquip00.getChild("GlowEquip01a");
		this.GlowHead2 = this.GlowNeck2.getChild("GlowHead2");
		this.GlowEquip02a = this.GlowEquip01a.getChild("GlowEquip02a");
		this.CirBase = this.GlowHead2.getChild("CirBase");
		this.Cir00 = this.CirBase.getChild("Cir00");
		this.Cir01 = this.Cir00.getChild("Cir01");
		this.Cir02 = this.Cir00.getChild("Cir02");
		this.Cir03 = this.Cir00.getChild("Cir03");
		this.Cir04 = this.Cir00.getChild("Cir04");
		this.Equip02b = this.GlowEquip02a.getChild("Equip02b");
		this.Equip02c = this.Equip02b.getChild("Equip02c");
		this.Equip02d = this.Equip02c.getChild("Equip02d");
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
				CubeListBuilder.create().mirror().texOffs(24, 84)
						.addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
				PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, -0.17453292519943295F, 0.0F, 0.2617993877991494F));

		armRight01.addOrReplaceChild("ArmRight02",
				CubeListBuilder.create().mirror().texOffs(24, 63)
						.addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
				PartPose.offset(-3.0F, 11.0F, 2.5F));

		bodyMain.addOrReplaceChild("BoobR",
				CubeListBuilder.create().texOffs(33, 101)
						.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F),
				PartPose.offsetAndRotation(-2.1F, -8.0F, -3.6F, -0.6981317007977318F, 0.10471975511965977F,
						0.13962634015954636F));

		bodyMain.addOrReplaceChild("BoobL",
				CubeListBuilder.create().mirror().texOffs(34, 101)
						.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F),
				PartPose.offsetAndRotation(2.0F, -8.0F, -3.7F, -0.6981317007977318F, -0.09250245035569946F,
						-0.13962634015954636F));

		PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
				CubeListBuilder.create().texOffs(0, 18)
						.addBox(-2.5F, -2.0F, -3.6F, 5.0F, 2.0F, 5.0F),
				PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(44, 101)
						.addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
				PartPose.offset(0.0F, -1.0F, -0.7F));

		PartDefinition hair = head.addOrReplaceChild("Hair",
				CubeListBuilder.create().texOffs(50, 77)
						.addBox(-8.0F, -8.0F, -7.4F, 16.0F, 16.0F, 8.0F),
				PartPose.offset(0.0F, -7.7F, 0.1F));

		hair.addOrReplaceChild("Ahoke",
				CubeListBuilder.create().texOffs(106, 31)
						.addBox(0.0F, -1.0F, -5.5F, 0.0F, 11.0F, 11.0F),
				PartPose.offsetAndRotation(-2.5F, -4.0F, -7.5F, 0.2617993877991494F, 1.8325957145940461F,
						0.2617993877991494F));

		hair.addOrReplaceChild("HairU01",
				CubeListBuilder.create().texOffs(52, 56)
						.addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F),
				PartPose.offset(0.0F, -6.0F, -6.9F));

		PartDefinition hairMain = head.addOrReplaceChild("HairMain",
				CubeListBuilder.create().texOffs(46, 104)
						.addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F),
				PartPose.offset(0.0F, -14.8F, -3.0F));

		hairMain.addOrReplaceChild("Hair01",
				CubeListBuilder.create().texOffs(10, 16)
						.addBox(-8.0F, 0.0F, -8.0F, 16.0F, 7.0F, 10.0F),
				PartPose.offsetAndRotation(0.0F, 9.0F, 8.2F, 0.17453292519943295F, 0.0F, 0.0F));

		PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
				CubeListBuilder.create().texOffs(24, 84)
						.addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
				PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.3141592653589793F, 0.0F, -0.5235987755982988F));

		PartDefinition armLeft02 = armLeft01.addOrReplaceChild("ArmLeft02",
				CubeListBuilder.create().texOffs(24, 63)
						.addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F),
				PartPose.offset(3.0F, 11.0F, 2.5F));

		PartDefinition equipSL00 = armLeft02.addOrReplaceChild("EquipSL00",
				CubeListBuilder.create().texOffs(106, 0)
						.addBox(-0.5F, -6.0F, -0.5F, 1.0F, 12.0F, 1.0F),
				PartPose.offsetAndRotation(-2.5F, 10.0F, -2.0F, -1.5707963267948966F, -0.08726646259971647F,
						0.5235987755982988F));

		PartDefinition equipSL04 = equipSL00.addOrReplaceChild("EquipSL04",
				CubeListBuilder.create().texOffs(106, 0)
						.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 12.0F, 1.0F),
				PartPose.offset(0.0F, -17.9F, 0.0F));

		equipSL04.addOrReplaceChild("EquipSL05",
				CubeListBuilder.create().texOffs(106, 0)
						.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 12.0F, 1.0F),
				PartPose.offset(0.0F, -11.9F, 0.0F));

		PartDefinition equipSL01 = equipSL00.addOrReplaceChild("EquipSL01",
				CubeListBuilder.create().texOffs(106, 0)
						.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 12.0F, 1.0F),
				PartPose.offset(0.0F, 5.9F, 0.0F));

		PartDefinition equipSL02 = equipSL01.addOrReplaceChild("EquipSL02",
				CubeListBuilder.create().texOffs(110, 0)
						.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 12.0F, 1.0F),
				PartPose.offset(0.0F, 11.9F, 0.0F));

		equipSL02.addOrReplaceChild("EquipSL03c",
				CubeListBuilder.create().texOffs(114, 0)
						.addBox(-0.5F, -7.0F, -2.0F, 1.0F, 8.0F, 2.0F),
				PartPose.offsetAndRotation(-0.1F, 13.9F, 3.1F, -0.03490658503988659F, 0.0F, 0.0F));

		equipSL02.addOrReplaceChild("EquipSL03a",
				CubeListBuilder.create().texOffs(120, 0)
						.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 14.0F, 3.0F),
				PartPose.offset(0.0F, 11.9F, -0.4F));

		equipSL02.addOrReplaceChild("EquipSL03b",
				CubeListBuilder.create().texOffs(102, 0)
						.addBox(-0.5F, -11.0F, -1.0F, 1.0F, 11.0F, 1.0F),
				PartPose.offsetAndRotation(-0.1F, 25.7F, 2.1F, -0.08726646259971647F, 0.0F, 0.0F));

		PartDefinition equip00 = bodyMain.addOrReplaceChild("Equip00",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 2.0F),
				PartPose.offsetAndRotation(0.0F, 4.0F, 5.0F, 0.08726646259971647F, 0.0F, 0.0F));

		PartDefinition equip01a = equip00.addOrReplaceChild("Equip01a",
				CubeListBuilder.create().texOffs(26, 0)
						.addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 5.0F),
				PartPose.offset(0.0F, -12.0F, 0.0F));

		equip01a.addOrReplaceChild("Equip02a",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.5F, 0.0F, 0.0F, 9.0F, 7.0F, 4.0F),
				PartPose.offset(0.0F, -0.4F, 10.0F));

		equip01a.addOrReplaceChild("Equip01b",
				CubeListBuilder.create().texOffs(50, 0)
						.addBox(-5.5F, 0.0F, 0.0F, 11.0F, 11.0F, 5.0F),
				PartPose.offset(0.0F, 7.0F, 0.0F));

		PartDefinition equip01c = equip01a.addOrReplaceChild("Equip01c",
				CubeListBuilder.create().texOffs(26, 0)
						.addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 5.0F),
				PartPose.offset(0.0F, 0.0F, 5.0F));

		PartDefinition equip01d = equip01c.addOrReplaceChild("Equip01d",
				CubeListBuilder.create().texOffs(50, 0)
						.addBox(-5.5F, 0.0F, 0.0F, 11.0F, 11.0F, 5.0F),
				PartPose.offset(0.0F, 7.0F, 0.0F));

		PartDefinition equip03R = equip01d.addOrReplaceChild("Equip03R",
				CubeListBuilder.create().mirror().texOffs(86, 104)
						.addBox(-4.0F, 0.0F, 0.0F, 4.0F, 8.0F, 2.0F),
				PartPose.offset(-5.0F, 1.5F, 4.5F));

		PartDefinition equipCR01 = equip03R.addOrReplaceChild("EquipCR01",
				CubeListBuilder.create().mirror().texOffs(0, 0)
						.addBox(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F),
				PartPose.offset(-3.5F, 3.5F, 2.0F));

		PartDefinition equipCR02 = equipCR01.addOrReplaceChild("EquipCR02",
				CubeListBuilder.create().mirror().texOffs(0, 2)
						.addBox(-1.0F, -3.0F, -4.0F, 1.0F, 7.0F, 9.0F),
				PartPose.offset(-1.9F, 0.0F, 0.0F));

		equipCR02.addOrReplaceChild("EquipCR03c",
				CubeListBuilder.create().texOffs(0, 27)
						.addBox(-1.0F, -7.0F, -1.0F, 2.0F, 14.0F, 2.0F),
				PartPose.offsetAndRotation(-1.9F, -0.5F, 2.7F, 0.0F, -0.3490658503988659F, 0.0F));

		equipCR02.addOrReplaceChild("EquipCR03b",
				CubeListBuilder.create().texOffs(0, 27)
						.addBox(-1.0F, -7.0F, -1.0F, 2.0F, 14.0F, 2.0F),
				PartPose.offsetAndRotation(-1.9F, -0.5F, 0.5F, 0.0F, -0.3490658503988659F, 0.0F));

		equipCR02.addOrReplaceChild("EquipCR03a",
				CubeListBuilder.create().texOffs(0, 27)
						.addBox(-1.0F, -7.0F, -1.0F, 2.0F, 14.0F, 2.0F),
				PartPose.offsetAndRotation(-1.9F, -0.5F, -1.7F, 0.0F, -0.3490658503988659F, 0.0F));

		PartDefinition equip03L = equip01d.addOrReplaceChild("Equip03L",
				CubeListBuilder.create().texOffs(86, 104)
						.addBox(0.0F, 0.0F, 0.0F, 4.0F, 8.0F, 2.0F),
				PartPose.offset(5.0F, 1.5F, 4.5F));

		PartDefinition equipCL01 = equip03L.addOrReplaceChild("EquipCL01",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(0.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F),
				PartPose.offset(3.5F, 3.5F, 2.0F));

		PartDefinition equipCL02 = equipCL01.addOrReplaceChild("EquipCL02",
				CubeListBuilder.create().texOffs(0, 2)
						.addBox(0.0F, -3.0F, -4.0F, 1.0F, 7.0F, 9.0F),
				PartPose.offset(1.9F, 0.0F, 0.0F));

		equipCL02.addOrReplaceChild("EquipCL03b",
				CubeListBuilder.create().texOffs(0, 27)
						.addBox(-1.0F, -7.0F, -1.0F, 2.0F, 14.0F, 2.0F),
				PartPose.offsetAndRotation(1.9F, -0.5F, 0.5F, 0.0F, 0.3490658503988659F, 0.0F));

		equipCL02.addOrReplaceChild("EquipCL03a",
				CubeListBuilder.create().texOffs(0, 27)
						.addBox(-1.0F, -7.0F, -1.0F, 2.0F, 14.0F, 2.0F),
				PartPose.offsetAndRotation(1.9F, -0.5F, -1.7F, 0.0F, 0.3490658503988659F, 0.0F));

		equipCL02.addOrReplaceChild("EquipCL03c",
				CubeListBuilder.create().texOffs(0, 27)
						.addBox(-1.0F, -7.0F, -1.0F, 2.0F, 14.0F, 2.0F),
				PartPose.offsetAndRotation(1.9F, -0.5F, 2.7F, 0.0F, 0.3490658503988659F, 0.0F));

		PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
				CubeListBuilder.create().texOffs(0, 47)
						.addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F),
				PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));

		PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
				CubeListBuilder.create().mirror().texOffs(0, 84)
						.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
				PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.08726646259971647F, 0.0F, -0.08726646259971647F));

		legRight01.addOrReplaceChild("LegRight02",
				CubeListBuilder.create().mirror().texOffs(0, 63)
						.addBox(0.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
				PartPose.offset(-3.0F, 14.0F, -3.0F));

		PartDefinition skirt01 = butt.addOrReplaceChild("Skirt01",
				CubeListBuilder.create().texOffs(46, 43)
						.addBox(-8.5F, 0.0F, -6.0F, 17.0F, 4.0F, 9.0F),
				PartPose.offsetAndRotation(0.0F, 2.9F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));

		skirt01.addOrReplaceChild("Skirt02",
				CubeListBuilder.create().texOffs(0, 33)
						.addBox(-9.0F, 0.0F, -6.0F, 18.0F, 4.0F, 10.0F),
				PartPose.offsetAndRotation(0.0F, 2.8F, -0.5F, -0.08726646259971647F, 0.0F, 0.0F));

		PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
				CubeListBuilder.create().texOffs(0, 84)
						.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
				PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.2792526803190927F, 0.0F, 0.08726646259971647F));

		legLeft01.addOrReplaceChild("LegLeft02",
				CubeListBuilder.create().texOffs(0, 63)
						.addBox(-6.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
				PartPose.offset(3.0F, 14.0F, -3.0F));

		bodyMain.addOrReplaceChild("Cloth01",
				CubeListBuilder.create().texOffs(112, 34)
						.addBox(-4.0F, 0.0F, 0.0F, 8.0F, 7.0F, 0.0F),
				PartPose.offsetAndRotation(0.0F, -9.6F, -3.8F, -0.5759586531581287F, 0.0F, 0.0F));

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

		PartDefinition glowEquip00 = glowBodyMain.addOrReplaceChild("GlowEquip00",
				CubeListBuilder.create(),
				PartPose.offset(0.0F, 4.0F, 5.0F));

		PartDefinition glowEquip01a = glowEquip00.addOrReplaceChild("GlowEquip01a",
				CubeListBuilder.create(),
				PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition glowEquip02a = glowEquip01a.addOrReplaceChild("GlowEquip02a",
				CubeListBuilder.create(),
				PartPose.offset(0.0F, -0.4F, 10.0F));

		PartDefinition equip02b = glowEquip02a.addOrReplaceChild("Equip02b",
				CubeListBuilder.create().texOffs(104, 24)
						.addBox(-4.0F, 0.0F, 0.0F, 8.0F, 6.0F, 4.0F),
				PartPose.offset(0.0F, 0.0F, 4.0F));

		PartDefinition equip02c = equip02b.addOrReplaceChild("Equip02c",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 1.0F),
				PartPose.offset(0.0F, 3.0F, 4.0F));

		equip02c.addOrReplaceChild("Equip02d",
				CubeListBuilder.create().texOffs(0, 49)
						.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F),
				PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition glowBodyMain2 = partdefinition.addOrReplaceChild("GlowBodyMain2",
				CubeListBuilder.create(),
				PartPose.offset(0.0F, -15.0F, 0.0F));

		PartDefinition glowNeck2 = glowBodyMain2.addOrReplaceChild("GlowNeck2",
				CubeListBuilder.create(),
				PartPose.offset(0.0F, -10.3F, 0.5F));

		PartDefinition glowHead2 = glowNeck2.addOrReplaceChild("GlowHead2",
				CubeListBuilder.create(),
				PartPose.offset(0.0F, -1.0F, -0.7F));

		PartDefinition cirBase = glowHead2.addOrReplaceChild("CirBase",
				CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, -21.0F, 4.0F, -0.2617993877991494F, 0.0F, 0.0F));

		PartDefinition cir00 = cirBase.addOrReplaceChild("Cir00",
				CubeListBuilder.create().mirror(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		cir00.addOrReplaceChild("Cir01",
				CubeListBuilder.create().texOffs(20, 12)
						.addBox(-6.0F, 0.0F, -0.5F, 12.0F, 3.0F, 1.0F),
				PartPose.offsetAndRotation(0.0F, 0.0F, -5.5F, 0.0F, 3.141592653589793F, 0.0F));

		cir00.addOrReplaceChild("Cir02",
				CubeListBuilder.create().texOffs(20, 12)
						.addBox(-6.0F, 0.0F, -0.5F, 12.0F, 3.0F, 1.0F),
				PartPose.offset(0.0F, 0.0F, 5.5F));

		cir00.addOrReplaceChild("Cir03",
				CubeListBuilder.create().texOffs(20, 12)
						.addBox(-6.0F, 0.0F, -0.5F, 12.0F, 3.0F, 1.0F),
				PartPose.offsetAndRotation(5.5F, 0.0F, 0.0F, 0.0F, 1.5707963267948966F, 0.0F));

		cir00.addOrReplaceChild("Cir04",
				CubeListBuilder.create().texOffs(20, 12)
						.addBox(-6.0F, 0.0F, -0.5F, 12.0F, 3.0F, 1.0F),
				PartPose.offsetAndRotation(-5.5F, 0.0F, 0.0F, 0.0F, -1.5707963267948966F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		IShipEmotion ent = (IShipEmotion) entity;
		// set scale per scaleLevel
		switch (ent.getScaleLevel()) {
			case 3:
				this.scale = 1.64F;
				this.offsetY = -0.58F;
				break;
			case 2:
				this.scale = 1.23F;
				this.offsetY = -0.27F;
				break;
			case 1:
				this.scale = 0.82F;
				this.offsetY = 0.35F;
				break;
			default:
				this.scale = 0.41F;
				this.offsetY = 2.17F;
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
		this.Equip00.visible = !flag;
		this.GlowEquip00.visible = !flag;

		flag = !EmotionHelper.checkModelState(1, state); // head
		if (this.CirBase != null)
			this.CirBase.visible = !flag;

		flag = !EmotionHelper.checkModelState(2, state); // weapon
		this.EquipSL00.visible = !flag;
	}

	@Override
	public void syncRotationGlowPart() {
		this.GlowBodyMain.xRot = this.BodyMain.xRot;
		this.GlowBodyMain.yRot = this.BodyMain.yRot;
		this.GlowBodyMain.zRot = this.BodyMain.zRot;
		this.GlowHead.xRot = this.Head.xRot;
		this.GlowHead.yRot = this.Head.yRot;
		this.GlowHead.zRot = this.Head.zRot;
		this.GlowBodyMain2.xRot = this.BodyMain.xRot;
		this.GlowBodyMain2.yRot = this.BodyMain.yRot;
		this.GlowBodyMain2.zRot = this.BodyMain.zRot;
		this.GlowHead2.xRot = this.Head.xRot;
		this.GlowHead2.yRot = this.Head.yRot;
		this.GlowHead2.zRot = this.Head.zRot;
	}

	@Override
	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

		this.offsetY += 0.51F + 0.26F * ent.getScaleLevel();
		this.setFaceHungry(ent);

		// body
		this.Head.xRot = 0.9599310885968813F;
		this.Head.yRot = 0.0F;
		this.Head.zRot = 0.0F;
		this.Ahoke.xRot = 0.2617993877991494F;
		this.Ahoke.yRot = 1.8325957145940461F;
		this.Ahoke.zRot = 0.2617993877991494F;
		this.BodyMain.xRot = -0.2617993877991494F;
		this.Butt.xRot = -0.2617993877991494F;
		// this.Butt.offsetY = 0F;
		this.Skirt01.xRot = -0.17453292519943295F;
		// this.Skirt01.offsetY = 0F;
		this.Skirt02.xRot = -0.20943951023931953F;
		// this.Skirt02.offsetY = 0F;
		// arm
		this.ArmLeft01.xRot = 0.4141592653589793F;
		this.ArmLeft01.yRot = 0.0F;
		this.ArmLeft01.zRot = -0.4363323129985824F;
		this.ArmLeft02.xRot = -0.10471975511965977F;
		this.ArmLeft02.yRot = 0.0F;
		this.ArmLeft02.zRot = 0.0F;
		// this.ArmLeft02.offsetX = 0F;
		// this.ArmLeft02.offsetZ = 0F;
		this.ArmRight01.xRot = 0.3617993877991494F;
		this.ArmRight01.yRot = 0.0F;
		this.ArmRight01.zRot = 0.27314402793711257F;
		this.ArmRight02.xRot = -0.27314402793711257F;
		this.ArmRight02.yRot = 0.0F;
		this.ArmRight02.zRot = 0.0F;
		// this.ArmRight02.offsetX = 0F;
		// this.ArmRight02.offsetZ = 0F;
		// equip
		this.EquipSL00.xRot = -1.68352986419518F;
		this.EquipSL00.yRot = 0F;
		this.EquipSL00.zRot = -1.1F;
		this.EquipCL02.xRot = 1.63F;
		this.EquipCR02.xRot = 1.63F;
		if (this.Cir00 != null)
			this.Cir00.yRot = 0F;
		// this.CirBase.offsetY = 0.26F;
		// leg
		this.LegLeft01.xRot = -1.7453292519943295F;
		this.LegLeft01.yRot = -0.5462880558742251F;
		this.LegLeft01.zRot = 1.48352986419518F;
		this.LegLeft02.xRot = 0.4363323129985824F;
		this.LegLeft02.yRot = 0.0F;
		this.LegLeft02.zRot = 0.0F;
		// this.LegLeft02.offsetX = 0F;
		// this.LegLeft02.offsetY = 0F;
		// this.LegLeft02.offsetZ = 0F;
		this.LegRight01.xRot = -1.5707963267948966F;
		this.LegRight01.yRot = 0.08726646259971647F;
		this.LegRight01.zRot = -0.17453292519943295F;
		this.LegRight02.xRot = 1.1344640137963142F;
		this.LegRight02.yRot = 0.0F;
		this.LegRight02.zRot = 0.0F;
		// this.LegRight02.offsetX = 0F;
		// this.LegRight02.offsetY = 0F;
		// this.LegRight02.offsetZ = 0F;
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
		boolean spcStand = false;

		// 水上漂浮
		if (ent.getShipDepth(0) > 0D) {
			this.offsetY += angleX * 0.05F + 0.025F;
		}

		// leg move
		addk1 = angleAdd1 * 0.5F - 0.28F; // LegLeft01
		addk2 = angleAdd2 * 0.5F - 0.21F; // LegRight01

		// head
		this.Head.xRot = f4 * 0.014F;
		this.Head.yRot = f3 * 0.01F;
		// boob
		this.Cloth01.xRot = angleX * 0.06F - 0.7F;
		this.BoobL.xRot = angleX * 0.06F - 0.8F;
		this.BoobR.xRot = angleX * 0.06F - 0.8F;
		// body
		this.BodyMain.xRot = -0.1047F;
		this.BodyMain.yRot = 0F;
		this.BodyMain.zRot = 0F;
		this.Butt.xRot = 0.35F;
		this.Skirt01.xRot = -0.14F;
		this.Skirt02.xRot = -0.09F;
		// this.Skirt02.offsetY = 0F;
		// arm
		this.ArmLeft01.xRot = angleAdd2 * 0.25F + 0.2F;
		this.ArmLeft01.yRot = 0F;
		this.ArmLeft01.zRot = angleX * 0.03F - 0.25F;
		this.ArmLeft02.xRot = 0F;
		this.ArmLeft02.zRot = 0F;
		// this.ArmLeft02.offsetX = 0F;
		// this.ArmLeft02.offsetZ = 0F;
		this.ArmRight01.xRot = 0F;
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
		if (this.Cir00 != null)
			this.Cir00.yRot = 0F;
		// this.CirBase.offsetY = 0F;
		this.EquipSL00.xRot = -1.1F;
		this.EquipSL00.yRot = 0.4F;
		this.EquipSL00.zRot = 0F;
		// this.EquipSL00.offsetX = 0F;
		// this.EquipSL00.offsetY = 0F;
		// this.EquipSL00.offsetZ = 0F;
		this.EquipCL02.xRot = f4 * 0.015F + 0.7F;
		this.EquipCR02.xRot = f4 * 0.015F + 0.7F;

		// special stand pos
		if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
			spcStand = true;

			if (t2 > 320) {
				setFace(8);
			} else if (t2 > 160) {
				setFace(0);
			} else {
				setFace(1);
			}

			this.Head.yRot = 0F;
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
			// equip
			this.EquipSL00.xRot = -1.17F;
			this.EquipSL00.yRot = 1.45F;
			this.EquipSL00.zRot = 0.0F;

			if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED) {
				// arm
				this.ArmLeft01.xRot = 0.6981317007977318F;
				this.ArmLeft01.yRot = -1.0471975511965976F;
				this.ArmLeft01.zRot = -2.443460952792061F;
				this.ArmLeft02.xRot = -1.3962634015954636F;
				this.ArmLeft02.yRot = 0.0F;
				this.ArmLeft02.zRot = 0.0F;
				// equip
				this.EquipSL00.xRot = -1.5707963267948966F;
				this.EquipSL00.yRot = 0.9F;
				this.EquipSL00.zRot = 0.0F;
			}
		}

		if (ent.getIsSprinting() || f1 > 0.9F) {
			// 奔跑動作
			// body
			this.Head.xRot -= 0.6F;
			this.BodyMain.xRot = 0.9F;
			this.Butt.xRot -= 0.7F;
			this.Skirt01.xRot = -0.15F;
			this.Skirt02.xRot = -0.32F;
			// arm
			this.ArmLeft01.xRot = 0.7F;
			this.ArmLeft01.yRot = -1.1F;
			this.ArmLeft01.zRot = -1F;
			this.ArmRight01.xRot = 0.7F;
			this.ArmRight01.yRot = 1.1F;
			this.ArmRight01.zRot = 1F;
			this.ArmRight02.zRot = 0F;
			// leg
			addk1 = angleAdd1 * 1F - 0.28F; // LegLeft01
			addk2 = angleAdd2 * 1F - 0.21F; // LegRight01
			// equip
			this.EquipSL00.xRot = -1.5F;
			this.EquipSL00.yRot = 0.2F;
			this.EquipSL00.zRot = 0F;
		}

		// head tilt angle
		this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

		if (ent.getIsSneaking()) {
			// 潛行, 蹲下動作
			// Body
			this.Head.xRot -= 1.0472F;
			this.BodyMain.xRot = 1.0472F;
			this.Butt.xRot = -0.4F;
			this.Skirt01.xRot = -0.12F;
			this.Skirt02.xRot = -0.16F;
			// this.Skirt02.offsetY = -0.1F;
			// arm
			if (this.EquipSL00.visible) {
				this.ArmLeft01.xRot = -0.6F;
				this.ArmLeft01.zRot = 0.2618F;
				this.ArmRight01.xRot = -0.6F;
				this.ArmRight01.zRot = -0.2618F;
			} else {
				this.ArmLeft01.xRot = angleAdd2 * 0.25F - 0.1F;
				this.ArmLeft01.yRot = -0.7F;
				this.ArmLeft01.zRot = -0.3F;
				this.ArmRight01.xRot = angleAdd1 * 0.25F - 0.1F;
				this.ArmRight01.yRot = 0.7F;
				this.ArmRight01.zRot = 0.3F;
			}
			// leg
			addk1 -= 0.4F;
			addk2 -= 0.4F;
			// equip
			if (this.Cir00 != null)
				this.Cir00.yRot = f2 * 0.025F;
		} // end if sneaking

		// 坐下動作
		if (ent.getIsSitting() || ent.getIsRiding()) {
			if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
				// body
				this.Head.xRot = 0.0F;
				this.Head.yRot += 1.2217304763960306F;
				this.Head.zRot = -0.08726646259971647F;
				this.BodyMain.xRot = -0.35F;
				this.BodyMain.yRot = -1.4486232791552935F;
				this.Butt.xRot = -0.3839724354387525F;
				this.Skirt01.xRot = -0.17453292519943295F;
				this.Skirt02.xRot = -0.2617993877991494F;
				// arm
				this.ArmLeft01.xRot = -1.22F;
				this.ArmLeft01.yRot = 0.3141592653589793F;
				this.ArmLeft01.zRot = 0.0F;
				this.ArmLeft02.xRot = 0.0F;
				this.ArmLeft02.zRot = 0.0F;
				// this.ArmLeft02.offsetX = 0F;
				// this.ArmLeft02.offsetZ = 0F;
				this.ArmRight01.xRot = -0.17453292519943295F;
				this.ArmRight01.yRot = 0.0F;
				this.ArmRight01.zRot = 0.2617993877991494F;
				this.ArmRight02.xRot = 0.0F;
				this.ArmRight02.zRot = 0.0F;
				// this.ArmRight02.offsetX = 0F;
				// this.ArmRight02.offsetZ = 0F;
				// leg
				addk1 = -1.57F;
				addk2 = -1.4F;
				this.LegLeft01.zRot = 0.08726646259971647F;
				this.LegLeft02.xRot = 0.6108652381980153F;
				this.LegLeft02.yRot = 0.0F;
				this.LegLeft02.zRot = 0.0F;
				this.LegRight01.yRot = 0.0F;
				this.LegRight01.zRot = -0.08726646259971647F;
				this.LegRight02.xRot = 1.48352986419518F;
				this.LegRight02.yRot = 0.0F;
				this.LegRight02.zRot = 0.0F;
				// equip
				if (this.Cir00 != null)
					this.Cir00.yRot = f2 * 0.025F;
				this.EquipSL00.xRot = 1.42F;
				this.EquipSL00.yRot = -0.18F;
				this.EquipSL00.zRot = 0.0F;
				// this.EquipSL00.offsetY = 0.15F;
			} else {
				// body
				this.BodyMain.xRot = -0.3F;
				this.Butt.xRot = -0.2F;
				this.Skirt01.xRot = -0.26F;
				this.Skirt02.xRot = -0.45F;
				// leg
				addk1 = -0.9F;
				addk2 = -0.9F;
				this.LegLeft01.zRot = -0.14F;
				this.LegLeft02.xRot = 1.2217F;
				this.LegLeft02.yRot = 1.2217F;
				this.LegLeft02.zRot = -1.0472F;
				// this.LegLeft02.offsetX = 0F;
				// this.LegLeft02.offsetY = -0.06F;
				// this.LegLeft02.offsetZ = 0F;
				this.LegRight01.zRot = 0.14F;
				this.LegRight02.xRot = 1.2217F;
				this.LegRight02.yRot = -1.2217F;
				this.LegRight02.zRot = 1.0472F;
				// this.LegRight02.offsetX = 0F;
				// this.LegRight02.offsetY = -0.06F;
				// this.LegRight02.offsetZ = 0F;
				// equip
				if (this.Cir00 != null)
					this.Cir00.yRot = f2 * 0.025F;
				this.EquipSL00.xRot = -1.06F;
				this.EquipSL00.yRot = 0.02F;
				this.EquipSL00.zRot = -1.29F;

				if (spcStand) {
					// arm
					this.ArmRight01.xRot += 0.3F;

					if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED) {
						// equip
						this.EquipSL00.xRot = -1.5707963267948966F;
						this.EquipSL00.yRot = 1.2F;
						this.EquipSL00.zRot = 0.0F;
					} else {
						this.EquipSL00.visible = false;
					}
				} else {
					// arm
					this.ArmLeft01.xRot += 0.1F;
					this.ArmLeft01.yRot = 0F;
					this.ArmLeft01.zRot = -0.25F;
					this.ArmRight01.xRot += 0.3F;
					this.ArmRight01.yRot = 0F;
					this.ArmRight01.zRot = 0.25F;
				}
			}
		} // end if sitting

		// 攻擊動作: 設為30~50會有揮刀動作, 設為100則沒有揮刀動作
		if (ent.getAttackTick() > 30) {
			// reset attack tick (for particle type 12)
			if (ent.getAttackTick() == 60)
				ent.setAttackTick(0);

			if (ent.getStateEmotion(ID.S.Phase) != 1) {
				// body
				this.BodyMain.xRot = 0.17453292519943295F;
				this.BodyMain.yRot = 0.0F;
				this.BodyMain.zRot = 0.0F;
				this.Butt.xRot = 0.0F;
				this.Head.xRot = -0.1F;
				this.Skirt01.xRot = -0.13962634015954636F;
				this.Skirt02.xRot = -0.08726646259971647F;
				// arm
				this.ArmLeft01.xRot = -1.6755160819145563F;
				this.ArmLeft01.yRot = 0.5235987755982988F;
				this.ArmLeft01.zRot = 0.0F;
				this.ArmLeft02.xRot = 0.0F;
				this.ArmLeft02.yRot = 0.0F;
				this.ArmLeft02.zRot = 0.0F;
				// this.ArmLeft02.offsetX = 0F;
				// this.ArmLeft02.offsetZ = 0F;
				this.ArmRight01.xRot = 0.5235987755982988F;
				this.ArmRight01.yRot = 0.0F;
				this.ArmRight01.zRot = 0.5235987755982988F;
				this.ArmRight02.xRot = 0.0F;
				this.ArmRight02.yRot = 0.0F;
				this.ArmRight02.zRot = 0.0F;
				// this.ArmRight02.offsetX = 0F;
				// this.ArmRight02.offsetZ = 0F;
				// leg
				addk1 = -0.5235987755982988F;
				addk2 = 0.2617993877991494F;
				this.LegLeft01.yRot = 0.0F;
				this.LegLeft01.zRot = 0.08726646259971647F;
				this.LegLeft02.xRot = 0.36425021489121656F;
				this.LegLeft02.yRot = 0.0F;
				this.LegLeft02.zRot = 0.0F;
				// this.LegLeft02.offsetX = 0F;
				// this.LegLeft02.offsetY = 0F;
				// this.LegLeft02.offsetZ = 0F;
				this.LegRight01.yRot = 0.0F;
				this.LegRight01.zRot = -0.08726646259971647F;
				this.LegRight02.xRot = 0F;
				this.LegRight02.yRot = 0F;
				this.LegRight02.zRot = 0F;
				// this.LegRight02.offsetX = 0F;
				// this.LegRight02.offsetY = 0F;
				// this.LegRight02.offsetZ = 0F;
				// equip
				this.EquipSL00.visible = true;
				this.EquipSL00.xRot = -0.136659280431156F;
				this.EquipSL00.yRot = 1.5707963267948966F;
				this.EquipSL00.zRot = 0.136659280431156F;
				// swing left hand
				if (ent.getAttackTick() < 51) {
					if (ent.getAttackTick() > 45) {
						int tick = 4 - (ent.getAttackTick() - 46);
						float parTick = f2 - (int) f2 + tick;
						// arm
						this.ArmLeft01.yRot = 0.52F - 0.524F * parTick;
					} else {
						// arm
						this.ArmLeft01.yRot = -2.1F;
					}
				}
			} else {
				// 奔跑動作
				// body
				this.Head.xRot -= 0.6F;
				this.BodyMain.xRot = 0.9F;
				this.Butt.xRot -= 0.7F;
				this.Skirt01.xRot = -0.15F;
				this.Skirt02.xRot = -0.32F;
				// arm
				this.ArmLeft01.xRot = 0.7F;
				this.ArmLeft01.yRot = -1.1F;
				this.ArmLeft01.zRot = -1F;
				this.ArmLeft02.xRot = 0.0F;
				this.ArmLeft02.yRot = 0.0F;
				this.ArmLeft02.zRot = 0.0F;
				// this.ArmLeft02.offsetX = 0F;
				// this.ArmLeft02.offsetZ = 0F;
				this.ArmRight01.xRot = 0.7F;
				this.ArmRight01.yRot = 1.1F;
				this.ArmRight01.zRot = 1F;
				this.ArmRight02.zRot = 0F;
				this.ArmRight02.xRot = 0.0F;
				this.ArmRight02.yRot = 0.0F;
				this.ArmRight02.zRot = 0.0F;
				// this.ArmRight02.offsetX = 0F;
				// this.ArmRight02.offsetZ = 0F;
				// leg
				addk1 = angleAdd1 * 1F - 0.28F; // LegLeft01
				addk2 = angleAdd2 * 1F - 0.21F; // LegRight01
				this.LegLeft01.yRot = 0F;
				this.LegLeft01.zRot = 0F;
				this.LegLeft02.xRot = 0F;
				this.LegLeft02.yRot = 0F;
				this.LegLeft02.zRot = 0F;
				// this.LegLeft02.offsetX = 0F;
				// this.LegLeft02.offsetY = 0F;
				// this.LegLeft02.offsetZ = 0F;
				this.LegRight01.yRot = 0F;
				this.LegRight01.zRot = 0F;
				this.LegRight02.xRot = 0F;
				this.LegRight02.yRot = 0F;
				this.LegRight02.zRot = 0F;
				// this.LegRight02.offsetX = 0F;
				// this.LegRight02.offsetY = 0F;
				// this.LegRight02.offsetZ = 0F;
				// equip
				this.EquipSL00.xRot = -1.5F;
				this.EquipSL00.yRot = 0.2F;
				this.EquipSL00.zRot = 0F;
			}

			// final attack
			if (ent.getStateEmotion(ID.S.Phase) == 2) {
				// body
				this.Head.xRot = -0.2617993877991494F;
				this.BodyMain.xRot = 0F;
				this.BodyMain.yRot = f2 * -2F;
				// arm
				this.ArmLeft01.xRot = -1.6755160819145563F;
				this.ArmLeft01.yRot = -1.3962634015954636F;
				this.ArmLeft01.zRot = 0.0F;
				this.ArmRight01.xRot = 0.17453292519943295F;
				this.ArmRight01.yRot = 0.0F;
				this.ArmRight01.zRot = 1.6755160819145563F;
				// leg
				addk1 = -0.5235987755982988F;
				addk2 = 0.13962634015954636F;
				this.LegLeft01.yRot = 0.0F;
				this.LegLeft01.zRot = 0.08726646259971647F;
				this.LegLeft02.xRot = 1.0471975511965976F;
				this.LegLeft02.yRot = 0.0F;
				this.LegLeft02.zRot = 0.0F;
				this.LegRight01.yRot = 0.0F;
				this.LegRight01.zRot = -0.08726646259971647F;
			} else if (ent.getStateEmotion(ID.S.Phase) == 3) {
				// body
				this.Head.xRot = -0.7853981633974483F;
				this.BodyMain.xRot = 1.3962634015954636F;
				this.Butt.xRot = -0.8726646259971648F;
				// arm
				this.ArmLeft01.xRot = -2.35F;
				this.ArmLeft01.yRot = 0.2617993877991494F;
				this.ArmLeft01.zRot = 0.0F;
				this.ArmRight01.xRot = 0.6981317007977318F;
				this.ArmRight01.yRot = 0.0F;
				this.ArmRight01.zRot = 0.6981317007977318F;
				// leg
				addk1 = 0.2617993877991494F;
				addk2 = -0.5235987755982988F;
				this.LegLeft01.yRot = 0.0F;
				this.LegLeft01.zRot = 0.08726646259971647F;
				this.LegLeft02.xRot = 0.2617993877991494F;
				this.LegLeft02.yRot = 0.0F;
				this.LegLeft02.zRot = 0.0F;
				this.LegRight01.yRot = 0.0F;
				this.LegRight01.zRot = -0.08726646259971647F;
				this.LegRight02.xRot = 1.3962634015954636F;
				this.LegRight02.yRot = 0.0F;
				this.LegRight02.zRot = 0.0F;
				// equip
				this.EquipSL00.xRot = 0.0F;
				this.EquipSL00.yRot = 0.0F;
				this.EquipSL00.zRot = -0.17453292519943295F;
				// this.EquipSL00.offsetX = 0.32F + (50 - ent.getAttackTick()) * 0.22F;
				// this.EquipSL00.offsetY = 2F + (50 - ent.getAttackTick()) * 5F;
				// this.EquipSL00.offsetZ = -0.08F;
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

		// leg motion
		this.LegLeft01.xRot = addk1;
		this.LegRight01.xRot = addk2;
	}
}
