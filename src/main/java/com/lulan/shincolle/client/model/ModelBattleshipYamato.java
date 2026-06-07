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

public class ModelBattleshipYamato extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "bb_yamato"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Neck;
    private final ModelPart BoobR;
    private final ModelPart BoobL;
    private final ModelPart Butt;
    private final ModelPart ArmLeft01;
    private final ModelPart ArmRight01;
    private final ModelPart Cloth01;
    private final ModelPart EquipBaseBelt;
    private final ModelPart Head;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart EquipHeadBase;
    private final ModelPart Ahoke;
    private final ModelPart HairL01;
    private final ModelPart HairR01;
    private final ModelPart HairU01;
    private final ModelPart HairL02;
    private final ModelPart HairL03;
    private final ModelPart HairR02;
    private final ModelPart HairR03;
    private final ModelPart HairBase;
    private final ModelPart Hair00;
    private final ModelPart Hair01;
    private final ModelPart Hair02;
    private final ModelPart Hair03;
    private final ModelPart Hair04;
    private final ModelPart HeadEquip01a;
    private final ModelPart HeadEquip02a;
    private final ModelPart HeadEquip01b;
    private final ModelPart HeadEquip01c;
    private final ModelPart HeadEquip01d;
    private final ModelPart HeadEquip01b2;
    private final ModelPart HeadEquip02b;
    private final ModelPart HeadEquip02c;
    private final ModelPart HeadEquip02d;
    private final ModelPart HeadEquip02b2;
    private final ModelPart LegRight01;
    private final ModelPart LegLeft01;
    private final ModelPart Skirt01;
    private final ModelPart AnchorL;
    private final ModelPart AnchorR;
    private final ModelPart LegRight02;
    private final ModelPart EquipLegR01;
    private final ModelPart ShoesR01;
    private final ModelPart EquipLegR02a;
    private final ModelPart EquipLegR02b;
    private final ModelPart EquipLegR02c;
    private final ModelPart LegLeft02;
    private final ModelPart EquipLegL01;
    private final ModelPart ShoesL01;
    private final ModelPart EquipLegL02a;
    private final ModelPart EquipLegL02b;
    private final ModelPart EquipLegL02c;
    private final ModelPart Skirt02;
    private final ModelPart ArmLeft01a;
    private final ModelPart ArmLeft02;
    private final ModelPart ArmRight02;
    private final ModelPart EquipU01;
    private final ModelPart EquipU01a;
    private final ModelPart EquipU01b;
    private final ModelPart EquipU02;
    private final ModelPart EquipU03a;
    private final ModelPart EquipU04a;
    private final ModelPart EquipU05a;
    private final ModelPart EquipU06;
    private final ModelPart EquipU09a;
    private final ModelPart EquipU09b;
    private final ModelPart EquipU09c;
    private final ModelPart EquipU03b;
    private final ModelPart EquipU03c;
    private final ModelPart EquipU03d;
    private final ModelPart EquipU04b;
    private final ModelPart EquipU04c;
    private final ModelPart EquipU04d;
    private final ModelPart EquipU05b;
    private final ModelPart EquipU05c;
    private final ModelPart EquipU05d;
    private final ModelPart EquipU07;
    private final ModelPart EquipU08;
    private final ModelPart Cloth02a;
    private final ModelPart Cloth02b;
    private final ModelPart EquipRotateBase;
    private final ModelPart EquipBaseBelt2;
    private final ModelPart EquipBaseM01a;
    private final ModelPart EquipBaseM01b;
    private final ModelPart EquipL01;
    private final ModelPart EquipR01;
    private final ModelPart EquipBaseM02;
    private final ModelPart EquipL02;
    private final ModelPart EquipL03;
    private final ModelPart EquipL04;
    private final ModelPart EquipLCBase01;
    private final ModelPart EquipL05;
    private final ModelPart EquipLC2Base01;
    private final ModelPart EquipLC3Base01;
    private final ModelPart EquipLC2Base02;
    private final ModelPart EquipLC201a;
    private final ModelPart EquipLC202a;
    private final ModelPart EquipLC203a;
    private final ModelPart EquipLC2Radar01;
    private final ModelPart EquipLC2Radar02;
    private final ModelPart EquipLC201b;
    private final ModelPart EquipLC202b;
    private final ModelPart EquipLC203b;
    private final ModelPart EquipLC3Base02;
    private final ModelPart EquipLC301a;
    private final ModelPart EquipLC302a;
    private final ModelPart EquipLC303a;
    private final ModelPart EquipLC3Radar01;
    private final ModelPart EquipLC3Radar02;
    private final ModelPart EquipLC301b;
    private final ModelPart EquipLC302b;
    private final ModelPart EquipLC303b;
    private final ModelPart EquipLCBase02;
    private final ModelPart EquipLC01a;
    private final ModelPart EquipLC02a;
    private final ModelPart EquipLC03a;
    private final ModelPart EquipLCRadar01;
    private final ModelPart EquipLCRadar02;
    private final ModelPart EquipLC01b;
    private final ModelPart EquipLC02b;
    private final ModelPart EquipLC03b;
    private final ModelPart EquipR02;
    private final ModelPart EquipMCBase01a;
    private final ModelPart EquipMCBase01b;
    private final ModelPart EquipR03;
    private final ModelPart EquipRCBase01;
    private final ModelPart EquipR04;
    private final ModelPart EquipRCBase02;
    private final ModelPart EquipRC01a;
    private final ModelPart EquipRC02a;
    private final ModelPart EquipRC03a;
    private final ModelPart EquipRCRadar01;
    private final ModelPart EquipRCRadar02;
    private final ModelPart EquipRC01b;
    private final ModelPart EquipRC02b;
    private final ModelPart EquipRC03b;
    private final ModelPart EquipR05;
    private final ModelPart EquipRC2Base01;
    private final ModelPart EquipRC3Base01;
    private final ModelPart EquipRC2Base02;
    private final ModelPart EquipRC201a;
    private final ModelPart EquipRC202a;
    private final ModelPart EquipRC203a;
    private final ModelPart EquipRC2Radar01;
    private final ModelPart EquipRC2Radar02;
    private final ModelPart EquipRC201b;
    private final ModelPart EquipRC202b;
    private final ModelPart EquipRC203b;
    private final ModelPart EquipRC3Base02;
    private final ModelPart EquipRC301a;
    private final ModelPart EquipRC302a;
    private final ModelPart EquipRC303a;
    private final ModelPart EquipRC3Radar01;
    private final ModelPart EquipRC3Radar02;
    private final ModelPart EquipRC301b;
    private final ModelPart EquipRC302b;
    private final ModelPart EquipRC303b;
    private final ModelPart EquipLCBase01_1;
    private final ModelPart EquipLCBase02_1;
    private final ModelPart EquipLC01a_1;
    private final ModelPart EquipLC02a_1;
    private final ModelPart EquipLC03a_1;
    private final ModelPart EquipMCRadar01;
    private final ModelPart EquipMCRadar02;
    private final ModelPart EquipLC01b_1;
    private final ModelPart EquipLC02b_1;
    private final ModelPart EquipLC03b_1;
    private final ModelPart EquipBaseM03;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowNeck;
    private final ModelPart GlowHead;

    public ModelBattleshipYamato(ModelPart root) {
        super();
        this.BodyMain = root.getChild("BodyMain");
        this.BoobL = this.BodyMain.getChild("BoobL");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.BoobR = this.BodyMain.getChild("BoobR");
        this.Cloth01 = this.BodyMain.getChild("Cloth01");
        this.EquipBaseBelt = this.BodyMain.getChild("EquipBaseBelt");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.Neck = this.BodyMain.getChild("Neck");
        this.Butt = this.BodyMain.getChild("Butt");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.ArmLeft01a = this.ArmLeft01.getChild("ArmLeft01a");
        this.Cloth02a = this.Cloth01.getChild("Cloth02a");
        this.EquipRotateBase = this.EquipBaseBelt.getChild("EquipRotateBase");
        this.EquipBaseBelt2 = this.EquipBaseBelt.getChild("EquipBaseBelt2");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.Head = this.Neck.getChild("Head");
        this.LegLeft01 = this.Butt.getChild("LegLeft01");
        this.Skirt01 = this.Butt.getChild("Skirt01");
        this.LegRight01 = this.Butt.getChild("LegRight01");
        this.AnchorL = this.Butt.getChild("AnchorL");
        this.AnchorR = this.Butt.getChild("AnchorR");
        this.Cloth02b = this.Cloth02a.getChild("Cloth02b");
        this.EquipBaseM01a = this.EquipRotateBase.getChild("EquipBaseM01a");
        this.EquipBaseM01b = this.EquipRotateBase.getChild("EquipBaseM01b");
        this.EquipU01 = this.ArmRight02.getChild("EquipU01");
        this.EquipHeadBase = this.Head.getChild("EquipHeadBase");
        this.Hair = this.Head.getChild("Hair");
        this.HairMain = this.Head.getChild("HairMain");
        this.EquipLegL01 = this.LegLeft01.getChild("EquipLegL01");
        this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
        this.Skirt02 = this.Skirt01.getChild("Skirt02");
        this.EquipLegR01 = this.LegRight01.getChild("EquipLegR01");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.EquipR01 = this.EquipBaseM01b.getChild("EquipR01");
        this.EquipL01 = this.EquipBaseM01b.getChild("EquipL01");
        this.EquipBaseM02 = this.EquipBaseM01b.getChild("EquipBaseM02");
        this.EquipU01a = this.EquipU01.getChild("EquipU01a");
        this.EquipU02 = this.EquipU01.getChild("EquipU02");
        this.EquipU01b = this.EquipU01.getChild("EquipU01b");
        this.HeadEquip02a = this.EquipHeadBase.getChild("HeadEquip02a");
        this.HeadEquip01a = this.EquipHeadBase.getChild("HeadEquip01a");
        this.HairR01 = this.Hair.getChild("HairR01");
        this.HairU01 = this.Hair.getChild("HairU01");
        this.HairL01 = this.Hair.getChild("HairL01");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.HairBase = this.HairMain.getChild("HairBase");
        this.EquipLegL02c = this.EquipLegL01.getChild("EquipLegL02c");
        this.EquipLegL02a = this.EquipLegL01.getChild("EquipLegL02a");
        this.EquipLegL02b = this.EquipLegL01.getChild("EquipLegL02b");
        this.ShoesL01 = this.LegLeft02.getChild("ShoesL01");
        this.EquipLegR02a = this.EquipLegR01.getChild("EquipLegR02a");
        this.EquipLegR02c = this.EquipLegR01.getChild("EquipLegR02c");
        this.EquipLegR02b = this.EquipLegR01.getChild("EquipLegR02b");
        this.ShoesR01 = this.LegRight02.getChild("ShoesR01");
        this.EquipMCBase01b = this.EquipR01.getChild("EquipMCBase01b");
        this.EquipR02 = this.EquipR01.getChild("EquipR02");
        this.EquipMCBase01a = this.EquipR01.getChild("EquipMCBase01a");
        this.EquipL02 = this.EquipL01.getChild("EquipL02");
        this.EquipBaseM03 = this.EquipBaseM02.getChild("EquipBaseM03");
        this.EquipU09a = this.EquipU02.getChild("EquipU09a");
        this.EquipU06 = this.EquipU02.getChild("EquipU06");
        this.EquipU09b = this.EquipU02.getChild("EquipU09b");
        this.EquipU04a = this.EquipU02.getChild("EquipU04a");
        this.EquipU03a = this.EquipU02.getChild("EquipU03a");
        this.EquipU05a = this.EquipU02.getChild("EquipU05a");
        this.EquipU09c = this.EquipU02.getChild("EquipU09c");
        this.HeadEquip02d = this.HeadEquip02a.getChild("HeadEquip02d");
        this.HeadEquip02b = this.HeadEquip02a.getChild("HeadEquip02b");
        this.HeadEquip02c = this.HeadEquip02a.getChild("HeadEquip02c");
        this.HeadEquip01d = this.HeadEquip01a.getChild("HeadEquip01d");
        this.HeadEquip01c = this.HeadEquip01a.getChild("HeadEquip01c");
        this.HeadEquip01b = this.HeadEquip01a.getChild("HeadEquip01b");
        this.HairR02 = this.HairR01.getChild("HairR02");
        this.HairL02 = this.HairL01.getChild("HairL02");
        this.Hair00 = this.HairBase.getChild("Hair00");
        this.EquipR03 = this.EquipR02.getChild("EquipR03");
        this.EquipLCBase01_1 = this.EquipMCBase01a.getChild("EquipLCBase01_1");
        this.EquipL03 = this.EquipL02.getChild("EquipL03");
        this.EquipU07 = this.EquipU06.getChild("EquipU07");
        this.EquipU04b = this.EquipU04a.getChild("EquipU04b");
        this.EquipU03b = this.EquipU03a.getChild("EquipU03b");
        this.EquipU05b = this.EquipU05a.getChild("EquipU05b");
        this.HeadEquip02b2 = this.HeadEquip02b.getChild("HeadEquip02b2");
        this.HeadEquip01b2 = this.HeadEquip01b.getChild("HeadEquip01b2");
        this.HairR03 = this.HairR02.getChild("HairR03");
        this.HairL03 = this.HairL02.getChild("HairL03");
        this.Hair01 = this.Hair00.getChild("Hair01");
        this.EquipRCBase01 = this.EquipR03.getChild("EquipRCBase01");
        this.EquipR04 = this.EquipR03.getChild("EquipR04");
        this.EquipLCBase02_1 = this.EquipLCBase01_1.getChild("EquipLCBase02_1");
        this.EquipLCBase01 = this.EquipL03.getChild("EquipLCBase01");
        this.EquipL04 = this.EquipL03.getChild("EquipL04");
        this.EquipU08 = this.EquipU07.getChild("EquipU08");
        this.EquipU04c = this.EquipU04b.getChild("EquipU04c");
        this.EquipU03c = this.EquipU03b.getChild("EquipU03c");
        this.EquipU05c = this.EquipU05b.getChild("EquipU05c");
        this.Hair02 = this.Hair01.getChild("Hair02");
        this.EquipRCBase02 = this.EquipRCBase01.getChild("EquipRCBase02");
        this.EquipRC3Base01 = this.EquipR04.getChild("EquipRC3Base01");
        this.EquipRC2Base01 = this.EquipR04.getChild("EquipRC2Base01");
        this.EquipR05 = this.EquipR04.getChild("EquipR05");
        this.EquipMCRadar02 = this.EquipLCBase02_1.getChild("EquipMCRadar02");
        this.EquipLC02a_1 = this.EquipLCBase02_1.getChild("EquipLC02a_1");
        this.EquipLC01a_1 = this.EquipLCBase02_1.getChild("EquipLC01a_1");
        this.EquipLC03a_1 = this.EquipLCBase02_1.getChild("EquipLC03a_1");
        this.EquipMCRadar01 = this.EquipLCBase02_1.getChild("EquipMCRadar01");
        this.EquipLCBase02 = this.EquipLCBase01.getChild("EquipLCBase02");
        this.EquipLC2Base01 = this.EquipL04.getChild("EquipLC2Base01");
        this.EquipLC3Base01 = this.EquipL04.getChild("EquipLC3Base01");
        this.EquipL05 = this.EquipL04.getChild("EquipL05");
        this.EquipU04d = this.EquipU04c.getChild("EquipU04d");
        this.EquipU03d = this.EquipU03c.getChild("EquipU03d");
        this.EquipU05d = this.EquipU05c.getChild("EquipU05d");
        this.Hair03 = this.Hair02.getChild("Hair03");
        this.EquipRCRadar02 = this.EquipRCBase02.getChild("EquipRCRadar02");
        this.EquipRCRadar01 = this.EquipRCBase02.getChild("EquipRCRadar01");
        this.EquipRC02a = this.EquipRCBase02.getChild("EquipRC02a");
        this.EquipRC03a = this.EquipRCBase02.getChild("EquipRC03a");
        this.EquipRC01a = this.EquipRCBase02.getChild("EquipRC01a");
        this.EquipRC3Base02 = this.EquipRC3Base01.getChild("EquipRC3Base02");
        this.EquipRC2Base02 = this.EquipRC2Base01.getChild("EquipRC2Base02");
        this.EquipLC02b_1 = this.EquipLC02a_1.getChild("EquipLC02b_1");
        this.EquipLC01b_1 = this.EquipLC01a_1.getChild("EquipLC01b_1");
        this.EquipLC03b_1 = this.EquipLC03a_1.getChild("EquipLC03b_1");
        this.EquipLC02a = this.EquipLCBase02.getChild("EquipLC02a");
        this.EquipLCRadar02 = this.EquipLCBase02.getChild("EquipLCRadar02");
        this.EquipLCRadar01 = this.EquipLCBase02.getChild("EquipLCRadar01");
        this.EquipLC03a = this.EquipLCBase02.getChild("EquipLC03a");
        this.EquipLC01a = this.EquipLCBase02.getChild("EquipLC01a");
        this.EquipLC2Base02 = this.EquipLC2Base01.getChild("EquipLC2Base02");
        this.EquipLC3Base02 = this.EquipLC3Base01.getChild("EquipLC3Base02");
        this.Hair04 = this.Hair03.getChild("Hair04");
        this.EquipRC02b = this.EquipRC02a.getChild("EquipRC02b");
        this.EquipRC03b = this.EquipRC03a.getChild("EquipRC03b");
        this.EquipRC01b = this.EquipRC01a.getChild("EquipRC01b");
        this.EquipRC302a = this.EquipRC3Base02.getChild("EquipRC302a");
        this.EquipRC3Radar02 = this.EquipRC3Base02.getChild("EquipRC3Radar02");
        this.EquipRC303a = this.EquipRC3Base02.getChild("EquipRC303a");
        this.EquipRC3Radar01 = this.EquipRC3Base02.getChild("EquipRC3Radar01");
        this.EquipRC301a = this.EquipRC3Base02.getChild("EquipRC301a");
        this.EquipRC2Radar02 = this.EquipRC2Base02.getChild("EquipRC2Radar02");
        this.EquipRC2Radar01 = this.EquipRC2Base02.getChild("EquipRC2Radar01");
        this.EquipRC203a = this.EquipRC2Base02.getChild("EquipRC203a");
        this.EquipRC202a = this.EquipRC2Base02.getChild("EquipRC202a");
        this.EquipRC201a = this.EquipRC2Base02.getChild("EquipRC201a");
        this.EquipLC02b = this.EquipLC02a.getChild("EquipLC02b");
        this.EquipLC03b = this.EquipLC03a.getChild("EquipLC03b");
        this.EquipLC01b = this.EquipLC01a.getChild("EquipLC01b");
        this.EquipLC203a = this.EquipLC2Base02.getChild("EquipLC203a");
        this.EquipLC2Radar02 = this.EquipLC2Base02.getChild("EquipLC2Radar02");
        this.EquipLC2Radar01 = this.EquipLC2Base02.getChild("EquipLC2Radar01");
        this.EquipLC201a = this.EquipLC2Base02.getChild("EquipLC201a");
        this.EquipLC202a = this.EquipLC2Base02.getChild("EquipLC202a");
        this.EquipLC3Radar02 = this.EquipLC3Base02.getChild("EquipLC3Radar02");
        this.EquipLC3Radar01 = this.EquipLC3Base02.getChild("EquipLC3Radar01");
        this.EquipLC303a = this.EquipLC3Base02.getChild("EquipLC303a");
        this.EquipLC302a = this.EquipLC3Base02.getChild("EquipLC302a");
        this.EquipLC301a = this.EquipLC3Base02.getChild("EquipLC301a");
        this.EquipRC302b = this.EquipRC302a.getChild("EquipRC302b");
        this.EquipRC303b = this.EquipRC303a.getChild("EquipRC303b");
        this.EquipRC301b = this.EquipRC301a.getChild("EquipRC301b");
        this.EquipRC203b = this.EquipRC203a.getChild("EquipRC203b");
        this.EquipRC202b = this.EquipRC202a.getChild("EquipRC202b");
        this.EquipRC201b = this.EquipRC201a.getChild("EquipRC201b");
        this.EquipLC203b = this.EquipLC203a.getChild("EquipLC203b");
        this.EquipLC201b = this.EquipLC201a.getChild("EquipLC201b");
        this.EquipLC202b = this.EquipLC202a.getChild("EquipLC202b");
        this.EquipLC303b = this.EquipLC303a.getChild("EquipLC303b");
        this.EquipLC302b = this.EquipLC302a.getChild("EquipLC302b");
        this.EquipLC301b = this.EquipLC301a.getChild("EquipLC301b");

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

        bodyMain.addOrReplaceChild("BoobL",
                CubeListBuilder.create().mirror().texOffs(33, 101)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(3.7F, -8.5F, -3.5F, -0.6981317007977318F,
                        0.13962634015954636F, 0.08726646259971647F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().mirror().texOffs(0, 29)
                        .addBox(-2.0F, -1.0F, -2.5F, 5.0F, 14.0F, 5.0F),
                PartPose.offsetAndRotation(7.8F, -9.7F, -0.7F, 0.20943951023931953F, 0.0F,
                        -0.2617993877991494F));

        armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().mirror().texOffs(20, 29)
                        .addBox(-5.0F, 0.0F, -5.0F, 5.0F, 14.0F, 5.0F),
                PartPose.offset(3.0F, 13.0F, 2.5F));

        armLeft01.addOrReplaceChild("ArmLeft01a",
                CubeListBuilder.create().mirror().texOffs(25, 69)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 6.0F),
                PartPose.offset(0.5F, 5.5F, 0.0F));

        bodyMain.addOrReplaceChild("BoobR",
                CubeListBuilder.create().texOffs(33, 101)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(-3.7F, -8.5F, -3.5F, -0.6981317007977318F,
                        -0.13962634015954636F, -0.08726646259971647F));

        PartDefinition cloth01 = bodyMain.addOrReplaceChild("Cloth01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-6.0F, 0.0F, -4.0F, 12.0F, 4.0F, 8.0F),
                PartPose.offset(0.0F, -11.3F, -0.3F));

        PartDefinition cloth02a = cloth01.addOrReplaceChild("Cloth02a",
                CubeListBuilder.create().texOffs(21, 62)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 3.2F, -4.0F, -0.6981317007977318F, 0.0F, 0.0F));

        cloth02a.addOrReplaceChild("Cloth02b",
                CubeListBuilder.create().texOffs(24, 66)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 3.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.9424777960769379F, 0.0F, 0.0F));

        PartDefinition equipBaseBelt = bodyMain.addOrReplaceChild("EquipBaseBelt",
                CubeListBuilder.create().texOffs(66, 0)
                        .addBox(-8.0F, 0.7F, -2.0F, 16.0F, 4.0F, 14.0F),
                PartPose.offsetAndRotation(0.0F, 2.0F, -2.5F, 0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition equipRotateBase = equipBaseBelt.addOrReplaceChild("EquipRotateBase",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offset(0.0F, 0.0F, 10.0F));

        equipRotateBase.addOrReplaceChild("EquipBaseM01a",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(2.5F, 0.0F, -1.0F, 5.0F, 4.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.8726646259971648F, 0.0F, 0.0F));

        PartDefinition equipBaseM01b = equipRotateBase.addOrReplaceChild("EquipBaseM01b",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-7.5F, 0.0F, -1.0F, 5.0F, 4.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.8726646259971648F, 0.0F, 0.0F));

        PartDefinition equipR01 = equipBaseM01b.addOrReplaceChild("EquipR01",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-16.0F, 0.0F, 0.0F, 16.0F, 8.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 5.5F, 3.0F, -0.8726646259971648F, 0.0F, 0.0F));

        equipR01.addOrReplaceChild("EquipMCBase01b",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-4.0F, 0.0F, 0.0F, 4.0F, 10.0F, 5.0F),
                PartPose.offsetAndRotation(-8.0F, 8.0F, 0.0F, 1.0471975511965976F, 0.0F, 0.0F));

        PartDefinition equipR02 = equipR01.addOrReplaceChild("EquipR02",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-13.0F, 0.0F, 0.0F, 13.0F, 10.0F, 5.0F),
                PartPose.offsetAndRotation(-13.5F, -0.5F, 0.6F, 0.0F, -0.5235987755982988F, 0.0F));

        PartDefinition equipR03 = equipR02.addOrReplaceChild("EquipR03",
                CubeListBuilder.create().texOffs(128, 29)
                        .addBox(-6.0F, 0.0F, -14.0F, 6.0F, 22.0F, 17.0F),
                PartPose.offsetAndRotation(-10.5F, -2.5F, -1.0F, 0.0F, 0.6981317007977318F, 0.0F));

        PartDefinition equipRCBase01 = equipR03.addOrReplaceChild("EquipRCBase01",
                CubeListBuilder.create().texOffs(196, 16)
                        .addBox(-8.5F, -5.0F, -7.0F, 16.0F, 9.0F, 14.0F),
                PartPose.offset(-3.0F, 3.0F, -5.5F));

        PartDefinition equipRCBase02 = equipRCBase01.addOrReplaceChild("EquipRCBase02",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-8.5F, -8.0F, -7.0F, 17.0F, 8.0F, 21.0F),
                PartPose.offsetAndRotation(-0.5F, -4.5F, -2.0F, -0.05235987755982988F, 0.0F, 0.0F));

        equipRCBase02.addOrReplaceChild("EquipRCRadar02",
                CubeListBuilder.create().mirror().texOffs(58, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 6.0F),
                PartPose.offset(-13.3F, -7.0F, 5.0F));

        equipRCBase02.addOrReplaceChild("EquipRCRadar01",
                CubeListBuilder.create().texOffs(58, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 6.0F),
                PartPose.offset(8.3F, -7.0F, 5.0F));

        PartDefinition equipRC02a = equipRCBase02.addOrReplaceChild("EquipRC02a",
                CubeListBuilder.create().texOffs(128, 118)
                        .addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, -4.5F, -6.0F, -0.08726646259971647F, 0.0F, 0.0F));

        equipRC02a.addOrReplaceChild("EquipRC02b",
                CubeListBuilder.create().texOffs(204, 39)
                        .addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F),
                PartPose.offset(0.0F, 0.0F, -5.0F));

        PartDefinition equipRC03a = equipRCBase02.addOrReplaceChild("EquipRC03a",
                CubeListBuilder.create().texOffs(128, 118)
                        .addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 6.0F),
                PartPose.offsetAndRotation(5.0F, -4.5F, -6.0F, -0.3490658503988659F, 0.0F, 0.0F));

        equipRC03a.addOrReplaceChild("EquipRC03b",
                CubeListBuilder.create().texOffs(204, 39)
                        .addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F),
                PartPose.offset(0.0F, 0.0F, -5.0F));

        PartDefinition equipRC01a = equipRCBase02.addOrReplaceChild("EquipRC01a",
                CubeListBuilder.create().texOffs(128, 118)
                        .addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 6.0F),
                PartPose.offsetAndRotation(-5.0F, -4.5F, -6.0F, -0.17453292519943295F, 0.0F, 0.0F));

        equipRC01a.addOrReplaceChild("EquipRC01b",
                CubeListBuilder.create().texOffs(204, 39)
                        .addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F),
                PartPose.offset(0.0F, 0.0F, -5.0F));

        PartDefinition equipR04 = equipR03.addOrReplaceChild("EquipR04",
                CubeListBuilder.create().texOffs(128, 70)
                        .addBox(-6.0F, 0.0F, -13.0F, 6.0F, 11.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, 11.0F, -12.7F, 0.0F, -0.20943951023931953F, 0.0F));

        PartDefinition equipRC3Base01 = equipR04.addOrReplaceChild("EquipRC3Base01",
                CubeListBuilder.create().texOffs(211, 23)
                        .addBox(-4.0F, 0.0F, 0.0F, 8.0F, 2.0F, 7.0F),
                PartPose.offsetAndRotation(-7.0F, 5.0F, -12.0F, 0.0F, 0.0F, -1.5707963267948966F));

        PartDefinition equipRC3Base02 = equipRC3Base01.addOrReplaceChild("EquipRC3Base02",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-4.5F, -5.0F, -5.5F, 9.0F, 5.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 0.5F, 4.0F, -0.05235987755982988F,
                        -0.18203784098300857F, 0.0F));

        PartDefinition equipRC302a = equipRC3Base02.addOrReplaceChild("EquipRC302a",
                CubeListBuilder.create().texOffs(128, 122)
                        .addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, -3.0F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));

        equipRC302a.addOrReplaceChild("EquipRC302b",
                CubeListBuilder.create().texOffs(163, 30)
                        .addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F),
                PartPose.offset(0.0F, 0.0F, -2.0F));

        equipRC3Base02.addOrReplaceChild("EquipRC3Radar02",
                CubeListBuilder.create().mirror().texOffs(128, 38)
                        .addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 4.0F),
                PartPose.offset(-6.4F, -4.0F, -1.0F));

        PartDefinition equipRC303a = equipRC3Base02.addOrReplaceChild("EquipRC303a",
                CubeListBuilder.create().texOffs(128, 122)
                        .addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F),
                PartPose.offsetAndRotation(2.6F, -3.0F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));

        equipRC303a.addOrReplaceChild("EquipRC303b",
                CubeListBuilder.create().texOffs(163, 30)
                        .addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F),
                PartPose.offset(0.0F, 0.0F, -2.0F));

        equipRC3Base02.addOrReplaceChild("EquipRC3Radar01",
                CubeListBuilder.create().texOffs(128, 38)
                        .addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 4.0F),
                PartPose.offset(4.4F, -4.0F, -1.0F));

        PartDefinition equipRC301a = equipRC3Base02.addOrReplaceChild("EquipRC301a",
                CubeListBuilder.create().texOffs(128, 122)
                        .addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F),
                PartPose.offsetAndRotation(-2.6F, -3.0F, -6.0F, -0.17453292519943295F, 0.0F, 0.0F));

        equipRC301a.addOrReplaceChild("EquipRC301b",
                CubeListBuilder.create().texOffs(163, 30)
                        .addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F),
                PartPose.offset(0.0F, 0.0F, -2.0F));

        PartDefinition equipRC2Base01 = equipR04.addOrReplaceChild("EquipRC2Base01",
                CubeListBuilder.create().texOffs(211, 23)
                        .addBox(-4.0F, 0.0F, 0.0F, 8.0F, 6.0F, 7.0F),
                PartPose.offset(-2.5F, -4.0F, -10.5F));

        PartDefinition equipRC2Base02 = equipRC2Base01.addOrReplaceChild("EquipRC2Base02",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-4.5F, -5.0F, -5.5F, 9.0F, 5.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 0.5F, 4.0F, -0.05235987755982988F, 0.0F, 0.0F));

        equipRC2Base02.addOrReplaceChild("EquipRC2Radar02",
                CubeListBuilder.create().mirror().texOffs(128, 38)
                        .addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 4.0F),
                PartPose.offset(-6.4F, -4.0F, -1.0F));

        equipRC2Base02.addOrReplaceChild("EquipRC2Radar01",
                CubeListBuilder.create().texOffs(128, 38)
                        .addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 4.0F),
                PartPose.offset(4.4F, -4.0F, -1.0F));

        PartDefinition equipRC203a = equipRC2Base02.addOrReplaceChild("EquipRC203a",
                CubeListBuilder.create().texOffs(128, 122)
                        .addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F),
                PartPose.offsetAndRotation(2.6F, -3.0F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));

        equipRC203a.addOrReplaceChild("EquipRC203b",
                CubeListBuilder.create().texOffs(163, 30)
                        .addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F),
                PartPose.offset(0.0F, 0.0F, -2.0F));

        PartDefinition equipRC202a = equipRC2Base02.addOrReplaceChild("EquipRC202a",
                CubeListBuilder.create().texOffs(128, 122)
                        .addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, -3.0F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));

        equipRC202a.addOrReplaceChild("EquipRC202b",
                CubeListBuilder.create().texOffs(163, 30)
                        .addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F),
                PartPose.offset(0.0F, 0.0F, -2.0F));

        PartDefinition equipRC201a = equipRC2Base02.addOrReplaceChild("EquipRC201a",
                CubeListBuilder.create().texOffs(128, 122)
                        .addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F),
                PartPose.offsetAndRotation(-2.6F, -3.0F, -6.0F, -0.17453292519943295F, 0.0F, 0.0F));

        equipRC201a.addOrReplaceChild("EquipRC201b",
                CubeListBuilder.create().texOffs(163, 30)
                        .addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F),
                PartPose.offset(0.0F, 0.0F, -2.0F));

        equipR04.addOrReplaceChild("EquipR05",
                CubeListBuilder.create().texOffs(174, 36)
                        .addBox(0.0F, 0.0F, -10.0F, 5.0F, 13.0F, 10.0F),
                PartPose.offsetAndRotation(-6.0F, -2.5F, -13.0F, 0.0F, -0.7853981633974483F, 0.0F));

        PartDefinition equipMCBase01a = equipR01.addOrReplaceChild("EquipMCBase01a",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 4.0F, 10.0F, 5.0F),
                PartPose.offsetAndRotation(8.0F, 8.0F, 0.0F, 1.0471975511965976F, 0.0F, 0.0F));

        PartDefinition equipLCBase01_1 = equipMCBase01a.addOrReplaceChild("EquipLCBase01_1",
                CubeListBuilder.create().texOffs(196, 16)
                        .addBox(-8.0F, -5.0F, -7.0F, 16.0F, 8.0F, 14.0F),
                PartPose.offsetAndRotation(-8.0F, 7.0F, 3.0F, -2.5953045977155678F, 0.0F, 0.0F));

        PartDefinition equipLCBase02_1 = equipLCBase01_1.addOrReplaceChild("EquipLCBase02_1",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-8.5F, -8.0F, -10.0F, 17.0F, 8.0F, 21.0F),
                PartPose.offsetAndRotation(0.5F, -4.5F, 0.0F, -0.05235987755982988F, 3.141592653589793F,
                        0.0F));

        equipLCBase02_1.addOrReplaceChild("EquipMCRadar02",
                CubeListBuilder.create().mirror().texOffs(58, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 6.0F),
                PartPose.offset(-13.3F, -7.0F, 2.0F));

        PartDefinition equipLC02a_1 = equipLCBase02_1.addOrReplaceChild("EquipLC02a_1",
                CubeListBuilder.create().texOffs(128, 118)
                        .addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, -4.5F, -9.0F, -0.2617993877991494F, 0.0F, 0.0F));

        equipLC02a_1.addOrReplaceChild("EquipLC02b_1",
                CubeListBuilder.create().texOffs(204, 39)
                        .addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F),
                PartPose.offset(0.0F, 0.0F, -5.0F));

        PartDefinition equipLC01a_1 = equipLCBase02_1.addOrReplaceChild("EquipLC01a_1",
                CubeListBuilder.create().texOffs(128, 118)
                        .addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 6.0F),
                PartPose.offsetAndRotation(-5.0F, -4.5F, -9.0F, -0.17453292519943295F, 0.0F, 0.0F));

        equipLC01a_1.addOrReplaceChild("EquipLC01b_1",
                CubeListBuilder.create().texOffs(204, 39)
                        .addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F),
                PartPose.offset(0.0F, 0.0F, -5.0F));

        PartDefinition equipLC03a_1 = equipLCBase02_1.addOrReplaceChild("EquipLC03a_1",
                CubeListBuilder.create().texOffs(128, 118)
                        .addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 6.0F),
                PartPose.offsetAndRotation(5.0F, -4.5F, -9.0F, -0.13962634015954636F, 0.0F, 0.0F));

        equipLC03a_1.addOrReplaceChild("EquipLC03b_1",
                CubeListBuilder.create().texOffs(204, 39)
                        .addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F),
                PartPose.offset(0.0F, 0.0F, -5.0F));

        equipLCBase02_1.addOrReplaceChild("EquipMCRadar01",
                CubeListBuilder.create().texOffs(58, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 6.0F),
                PartPose.offset(8.3F, -7.0F, 2.0F));

        PartDefinition equipL01 = equipBaseM01b.addOrReplaceChild("EquipL01",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 8.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 5.5F, 3.0F, -0.8726646259971648F, 0.0F, 0.0F));

        PartDefinition equipL02 = equipL01.addOrReplaceChild("EquipL02",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 13.0F, 10.0F, 5.0F),
                PartPose.offsetAndRotation(13.5F, -0.5F, 0.6F, 0.0F, 0.5235987755982988F, 0.0F));

        PartDefinition equipL03 = equipL02.addOrReplaceChild("EquipL03",
                CubeListBuilder.create().texOffs(128, 29)
                        .addBox(0.0F, 0.0F, -14.0F, 6.0F, 22.0F, 17.0F),
                PartPose.offsetAndRotation(10.5F, -2.5F, -1.0F, 0.0F, -0.6981317007977318F, 0.0F));

        PartDefinition equipLCBase01 = equipL03.addOrReplaceChild("EquipLCBase01",
                CubeListBuilder.create().texOffs(196, 16)
                        .addBox(-7.5F, -5.0F, -7.0F, 16.0F, 9.0F, 14.0F),
                PartPose.offset(3.0F, 3.0F, -5.5F));

        PartDefinition equipLCBase02 = equipLCBase01.addOrReplaceChild("EquipLCBase02",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-8.5F, -8.0F, -7.0F, 17.0F, 8.0F, 21.0F),
                PartPose.offsetAndRotation(0.5F, -4.5F, -2.0F, -0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition equipLC02a = equipLCBase02.addOrReplaceChild("EquipLC02a",
                CubeListBuilder.create().texOffs(128, 118)
                        .addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, -4.5F, -6.0F, -0.2617993877991494F, 0.0F, 0.0F));

        equipLC02a.addOrReplaceChild("EquipLC02b",
                CubeListBuilder.create().texOffs(204, 39)
                        .addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F),
                PartPose.offset(0.0F, 0.0F, -5.0F));

        equipLCBase02.addOrReplaceChild("EquipLCRadar02",
                CubeListBuilder.create().mirror().texOffs(58, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 6.0F),
                PartPose.offset(-13.3F, -7.0F, 5.0F));

        equipLCBase02.addOrReplaceChild("EquipLCRadar01",
                CubeListBuilder.create().texOffs(58, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 6.0F),
                PartPose.offset(8.3F, -7.0F, 5.0F));

        PartDefinition equipLC03a = equipLCBase02.addOrReplaceChild("EquipLC03a",
                CubeListBuilder.create().texOffs(128, 118)
                        .addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 6.0F),
                PartPose.offsetAndRotation(5.0F, -4.5F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));

        equipLC03a.addOrReplaceChild("EquipLC03b",
                CubeListBuilder.create().texOffs(204, 39)
                        .addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F),
                PartPose.offset(0.0F, 0.0F, -5.0F));

        PartDefinition equipLC01a = equipLCBase02.addOrReplaceChild("EquipLC01a",
                CubeListBuilder.create().texOffs(128, 118)
                        .addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 6.0F),
                PartPose.offsetAndRotation(-5.0F, -4.5F, -6.0F, -0.17453292519943295F, 0.0F, 0.0F));

        equipLC01a.addOrReplaceChild("EquipLC01b",
                CubeListBuilder.create().texOffs(204, 39)
                        .addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F),
                PartPose.offset(0.0F, 0.0F, -5.0F));

        PartDefinition equipL04 = equipL03.addOrReplaceChild("EquipL04",
                CubeListBuilder.create().texOffs(128, 70)
                        .addBox(0.0F, 0.0F, -13.0F, 6.0F, 11.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, 11.0F, -12.7F, 0.0F, 0.20943951023931953F, 0.0F));

        PartDefinition equipLC2Base01 = equipL04.addOrReplaceChild("EquipLC2Base01",
                CubeListBuilder.create().texOffs(211, 23)
                        .addBox(-4.0F, 0.0F, 0.0F, 8.0F, 6.0F, 7.0F),
                PartPose.offset(2.5F, -4.0F, -10.5F));

        PartDefinition equipLC2Base02 = equipLC2Base01.addOrReplaceChild("EquipLC2Base02",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-4.5F, -5.0F, -5.5F, 9.0F, 5.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 0.5F, 4.0F, -0.05235987755982988F,
                        -0.27314402793711257F, 0.0F));

        PartDefinition equipLC203a = equipLC2Base02.addOrReplaceChild("EquipLC203a",
                CubeListBuilder.create().texOffs(128, 122)
                        .addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F),
                PartPose.offsetAndRotation(2.6F, -3.0F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));

        equipLC203a.addOrReplaceChild("EquipLC203b",
                CubeListBuilder.create().texOffs(163, 30)
                        .addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F),
                PartPose.offset(0.0F, 0.0F, -2.0F));

        equipLC2Base02.addOrReplaceChild("EquipLC2Radar02",
                CubeListBuilder.create().mirror().texOffs(128, 38)
                        .addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 4.0F),
                PartPose.offset(-6.4F, -4.0F, -1.0F));

        equipLC2Base02.addOrReplaceChild("EquipLC2Radar01",
                CubeListBuilder.create().texOffs(128, 38)
                        .addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 4.0F),
                PartPose.offset(4.4F, -4.0F, -1.0F));

        PartDefinition equipLC201a = equipLC2Base02.addOrReplaceChild("EquipLC201a",
                CubeListBuilder.create().texOffs(128, 122)
                        .addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F),
                PartPose.offsetAndRotation(-2.6F, -3.0F, -6.0F, -0.17453292519943295F, 0.0F, 0.0F));

        equipLC201a.addOrReplaceChild("EquipLC201b",
                CubeListBuilder.create().texOffs(163, 30)
                        .addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F),
                PartPose.offset(0.0F, 0.0F, -2.0F));

        PartDefinition equipLC202a = equipLC2Base02.addOrReplaceChild("EquipLC202a",
                CubeListBuilder.create().texOffs(128, 122)
                        .addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, -3.0F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));

        equipLC202a.addOrReplaceChild("EquipLC202b",
                CubeListBuilder.create().texOffs(163, 30)
                        .addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F),
                PartPose.offset(0.0F, 0.0F, -2.0F));

        PartDefinition equipLC3Base01 = equipL04.addOrReplaceChild("EquipLC3Base01",
                CubeListBuilder.create().texOffs(211, 23)
                        .addBox(-4.0F, 0.0F, 0.0F, 8.0F, 2.0F, 7.0F),
                PartPose.offsetAndRotation(7.0F, 5.0F, -12.0F, 0.0F, 0.0F, 1.5707963267948966F));

        PartDefinition equipLC3Base02 = equipLC3Base01.addOrReplaceChild("EquipLC3Base02",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-4.5F, -5.0F, -5.5F, 9.0F, 5.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 0.5F, 4.0F, 0.05235987755982988F, 0.136659280431156F,
                        0.0F));

        equipLC3Base02.addOrReplaceChild("EquipLC3Radar02",
                CubeListBuilder.create().mirror().texOffs(128, 38)
                        .addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 4.0F),
                PartPose.offset(-6.4F, -4.0F, -1.0F));

        equipLC3Base02.addOrReplaceChild("EquipLC3Radar01",
                CubeListBuilder.create().texOffs(128, 38)
                        .addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 4.0F),
                PartPose.offset(4.4F, -4.0F, -1.0F));

        PartDefinition equipLC303a = equipLC3Base02.addOrReplaceChild("EquipLC303a",
                CubeListBuilder.create().texOffs(128, 122)
                        .addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F),
                PartPose.offsetAndRotation(2.6F, -3.0F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));

        equipLC303a.addOrReplaceChild("EquipLC303b",
                CubeListBuilder.create().texOffs(163, 30)
                        .addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F),
                PartPose.offset(0.0F, 0.0F, -2.0F));

        PartDefinition equipLC302a = equipLC3Base02.addOrReplaceChild("EquipLC302a",
                CubeListBuilder.create().texOffs(128, 122)
                        .addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, -3.0F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));

        equipLC302a.addOrReplaceChild("EquipLC302b",
                CubeListBuilder.create().texOffs(163, 30)
                        .addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F),
                PartPose.offset(0.0F, 0.0F, -2.0F));

        PartDefinition equipLC301a = equipLC3Base02.addOrReplaceChild("EquipLC301a",
                CubeListBuilder.create().texOffs(128, 122)
                        .addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F),
                PartPose.offsetAndRotation(-2.6F, -3.0F, -6.0F, -0.17453292519943295F, 0.0F, 0.0F));

        equipLC301a.addOrReplaceChild("EquipLC301b",
                CubeListBuilder.create().texOffs(163, 30)
                        .addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F),
                PartPose.offset(0.0F, 0.0F, -2.0F));

        equipL04.addOrReplaceChild("EquipL05",
                CubeListBuilder.create().texOffs(174, 36)
                        .addBox(-5.0F, 0.0F, -10.0F, 5.0F, 13.0F, 10.0F),
                PartPose.offsetAndRotation(6.0F, -2.5F, -13.0F, 0.0F, 0.7853981633974483F, 0.0F));

        PartDefinition equipBaseM02 = equipBaseM01b.addOrReplaceChild("EquipBaseM02",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-9.0F, 0.0F, 0.0F, 18.0F, 10.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, -1.3F, 7.7F, -0.5918411493512771F, 0.0F, 0.0F));

        equipBaseM02.addOrReplaceChild("EquipBaseM03",
                CubeListBuilder.create().texOffs(128, 95)
                        .addBox(-3.5F, -15.0F, 0.0F, 7.0F, 15.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 6.0F, -2.5F, -0.6981317007977318F, 0.0F, 0.0F));

        equipBaseBelt.addOrReplaceChild("EquipBaseBelt2",
                CubeListBuilder.create().texOffs(210, 0)
                        .addBox(-7.0F, 0.0F, -4.0F, 14.0F, 6.0F, 8.0F),
                PartPose.offset(0.0F, -8.7F, 2.5F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().texOffs(0, 29)
                        .addBox(-3.0F, -1.0F, -2.5F, 5.0F, 14.0F, 5.0F),
                PartPose.offsetAndRotation(-7.8F, -9.7F, -0.7F, 0.2617993877991494F, 0.0F,
                        0.20943951023931953F));

        PartDefinition armRight02 = armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().texOffs(20, 29)
                        .addBox(0.0F, 0.0F, -5.0F, 5.0F, 14.0F, 5.0F),
                PartPose.offsetAndRotation(-3.0F, 13.0F, 2.5F, -1.48352986419518F, 0.0F, 0.0F));

        PartDefinition equipU01 = armRight02.addOrReplaceChild("EquipU01",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, -4.0F, 0.0F, 1.0F, 7.0F, 1.0F),
                PartPose.offsetAndRotation(1.5F, 13.0F, -5.0F, -1.7453F, 2.4086F, -1.9199F));

        equipU01.addOrReplaceChild("EquipU01a",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F),
                PartPose.offset(0.0F, -12.0F, 0.0F));

        PartDefinition equipU02 = equipU01.addOrReplaceChild("EquipU02",
                CubeListBuilder.create().texOffs(222, 32)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F),
                PartPose.offset(0.5F, -15.0F, 0.5F));

        equipU02.addOrReplaceChild("EquipU09a",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 10.0F, 1.0F, 1.0F),
                PartPose.offsetAndRotation(-5.0F, -23.0F, 6.0F, -0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition equipU06 = equipU02.addOrReplaceChild("EquipU06",
                CubeListBuilder.create().texOffs(166, 60)
                        .addBox(-8.0F, 0.0F, -8.0F, 16.0F, 1.0F, 16.0F),
                PartPose.offsetAndRotation(0.0F, -31.1F, 5.5F, -0.13788101090755206F,
                        0.7853981633974483F, -0.09599310885968812F));

        PartDefinition equipU07 = equipU06.addOrReplaceChild("EquipU07",
                CubeListBuilder.create().texOffs(214, 66)
                        .addBox(0.0F, -1.0F, 0.0F, 9.0F, 1.0F, 9.0F),
                PartPose.offset(-4.5F, 0.0F, -4.5F));

        equipU07.addOrReplaceChild("EquipU08",
                CubeListBuilder.create().texOffs(214, 61)
                        .addBox(0.0F, -2.0F, 0.0F, 4.0F, 1.0F, 4.0F),
                PartPose.offset(2.5F, 0.0F, 2.5F));

        equipU02.addOrReplaceChild("EquipU09b",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-0.4F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F),
                PartPose.offsetAndRotation(0.0F, -24.0F, -3.0F, 0.0F, 0.5061454830783556F,
                        0.2617993877991494F));

        PartDefinition equipU04a = equipU02.addOrReplaceChild("EquipU04a",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-0.5F, -8.0F, -0.5F, 1.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(0.2F, 0.1F, 0.3F, -0.2617993877991494F, 0.0F,
                        0.20943951023931953F));

        PartDefinition equipU04b = equipU04a.addOrReplaceChild("EquipU04b",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F),
                PartPose.offset(-0.5F, -16.0F, -0.5F));

        PartDefinition equipU04c = equipU04b.addOrReplaceChild("EquipU04c",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F),
                PartPose.offset(0.0F, -8.0F, 0.0F));

        equipU04c.addOrReplaceChild("EquipU04d",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F),
                PartPose.offset(0.0F, -8.0F, 0.0F));

        PartDefinition equipU03a = equipU02.addOrReplaceChild("EquipU03a",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-0.5F, -8.0F, -0.5F, 1.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 0.1F, -0.3F, 0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition equipU03b = equipU03a.addOrReplaceChild("EquipU03b",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F),
                PartPose.offset(-0.5F, -16.0F, -0.5F));

        PartDefinition equipU03c = equipU03b.addOrReplaceChild("EquipU03c",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F),
                PartPose.offset(0.0F, -8.0F, 0.0F));

        equipU03c.addOrReplaceChild("EquipU03d",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F),
                PartPose.offset(0.0F, -8.0F, 0.0F));

        PartDefinition equipU05a = equipU02.addOrReplaceChild("EquipU05a",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-0.5F, -8.0F, -0.5F, 1.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(-0.2F, 0.1F, 0.3F, -0.2617993877991494F, 0.0F,
                        -0.20943951023931953F));

        PartDefinition equipU05b = equipU05a.addOrReplaceChild("EquipU05b",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F),
                PartPose.offset(-0.5F, -16.0F, -0.5F));

        PartDefinition equipU05c = equipU05b.addOrReplaceChild("EquipU05c",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F),
                PartPose.offset(0.0F, -8.0F, 0.0F));

        equipU05c.addOrReplaceChild("EquipU05d",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F),
                PartPose.offset(0.0F, -8.0F, 0.0F));

        equipU02.addOrReplaceChild("EquipU09c",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-0.6F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F),
                PartPose.offsetAndRotation(0.0F, -24.0F, -3.0F, 0.0F, -0.5061454830783556F,
                        -0.2617993877991494F));

        equipU01.addOrReplaceChild("EquipU01b",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F),
                PartPose.offset(0.0F, 3.0F, 0.0F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(0, 16)
                        .addBox(-4.5F, -2.0F, -5.0F, 9.0F, 3.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, -10.7F, -0.2F, 0.20943951023931953F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition equipHeadBase = head.addOrReplaceChild("EquipHeadBase",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-8.0F, 0.0F, 0.0F, 16.0F, 4.0F, 9.0F),
                PartPose.offset(0.0F, -9.5F, 0.0F));

        PartDefinition headEquip02a = equipHeadBase.addOrReplaceChild("HeadEquip02a",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-2.0F, 0.0F, -2.0F, 2.0F, 3.0F, 4.0F),
                PartPose.offset(-8.0F, 0.2F, 5.0F));

        headEquip02a.addOrReplaceChild("HeadEquip02d",
                CubeListBuilder.create().texOffs(91, 64)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 2.0F),
                PartPose.offset(-3.5F, 0.2F, -1.0F));

        PartDefinition headEquip02b = headEquip02a.addOrReplaceChild("HeadEquip02b",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-4.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F),
                PartPose.offset(-2.0F, 1.5F, 0.5F));

        headEquip02b.addOrReplaceChild("HeadEquip02b2",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-1.5F, -1.5F, 0.0F, 3.0F, 2.0F, 3.0F),
                PartPose.offset(-4.0F, 0.0F, -2.0F));

        headEquip02a.addOrReplaceChild("HeadEquip02c",
                CubeListBuilder.create().mirror().texOffs(43, 82)
                        .addBox(0.0F, 0.0F, 0.0F, 7.0F, 4.0F, 0.0F),
                PartPose.offset(-7.0F, -3.5F, 0.5F));

        PartDefinition headEquip01a = equipHeadBase.addOrReplaceChild("HeadEquip01a",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(0.0F, 0.0F, -2.0F, 2.0F, 3.0F, 4.0F),
                PartPose.offset(8.0F, 0.2F, 5.0F));

        headEquip01a.addOrReplaceChild("HeadEquip01d",
                CubeListBuilder.create().texOffs(91, 64)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 2.0F),
                PartPose.offset(3.5F, 0.2F, -1.0F));

        headEquip01a.addOrReplaceChild("HeadEquip01c",
                CubeListBuilder.create().texOffs(43, 82)
                        .addBox(0.0F, 0.0F, 0.0F, 7.0F, 4.0F, 0.0F),
                PartPose.offset(0.0F, -3.5F, 0.5F));

        PartDefinition headEquip01b = headEquip01a.addOrReplaceChild("HeadEquip01b",
                CubeListBuilder.create().mirror().texOffs(128, 0)
                        .addBox(0.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F),
                PartPose.offset(2.0F, 1.5F, 0.5F));

        headEquip01b.addOrReplaceChild("HeadEquip01b2",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-1.5F, -1.5F, 0.0F, 3.0F, 2.0F, 3.0F),
                PartPose.offset(4.0F, 0.0F, -2.0F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(50, 81)
                        .addBox(-8.0F, -8.0F, -7.4F, 16.0F, 12.0F, 8.0F),
                PartPose.offset(0.0F, -7.2F, 0.0F));

        PartDefinition hairR01 = hair.addOrReplaceChild("HairR01",
                CubeListBuilder.create().mirror().texOffs(40, 89)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 3.0F),
                PartPose.offsetAndRotation(-7.0F, 1.0F, -3.0F, -0.40142572795869574F,
                        0.17453292519943295F, -0.08726646259971647F));

        PartDefinition hairR02 = hairR01.addOrReplaceChild("HairR02",
                CubeListBuilder.create().mirror().texOffs(86, 101)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 2.0F),
                PartPose.offsetAndRotation(0.2F, 8.0F, 0.3F, 0.296705972839036F, 0.0F,
                        0.3141592653589793F));

        hairR02.addOrReplaceChild("HairR03",
                CubeListBuilder.create().mirror().texOffs(86, 101)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 2.0F),
                PartPose.offsetAndRotation(0.1F, 9.0F, 0.1F, 0.13962634015954636F, 0.0F,
                        -0.22689280275926282F));

        hair.addOrReplaceChild("HairU01",
                CubeListBuilder.create().texOffs(56, 23)
                        .addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F),
                PartPose.offset(0.0F, -8.8F, -5.7F));

        PartDefinition hairL01 = hair.addOrReplaceChild("HairL01",
                CubeListBuilder.create().texOffs(40, 89)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 3.0F),
                PartPose.offsetAndRotation(7.0F, 1.0F, -3.0F, -0.3665191429188092F,
                        -0.17453292519943295F, 0.08726646259971647F));

        PartDefinition hairL02 = hairL01.addOrReplaceChild("HairL02",
                CubeListBuilder.create().texOffs(86, 101)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 2.0F),
                PartPose.offsetAndRotation(-0.2F, 8.0F, 0.3F, 0.22689280275926282F, 0.0F,
                        -0.3141592653589793F));

        hairL02.addOrReplaceChild("HairL03",
                CubeListBuilder.create().texOffs(86, 101)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 2.0F),
                PartPose.offsetAndRotation(-0.1F, 9.0F, 0.1F, 0.17453292519943295F, 0.0F,
                        0.22689280275926282F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(104, 29)
                        .addBox(0.0F, -4.0F, -11.5F, 0.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -9.0F, -5.5F, 0.17453292519943295F,
                        0.6981317007977318F, 0.0F));

        PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(159, 107)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F),
                PartPose.offset(0.0F, -14.8F, -3.0F));

        PartDefinition hairBase = hairMain.addOrReplaceChild("HairBase",
                CubeListBuilder.create().texOffs(102, 35)
                        .addBox(-5.0F, 0.0F, -0.7F, 10.0F, 3.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, -0.5F, 5.5F, 0.8726646259971648F, 0.0F, 0.0F));

        PartDefinition hair00 = hairBase.addOrReplaceChild("Hair00",
                CubeListBuilder.create().texOffs(170, 81)
                        .addBox(-3.5F, 0.0F, -4.0F, 7.0F, 7.0F, 6.0F),
                PartPose.offset(0.0F, 0.2F, 2.5F));

        PartDefinition hair01 = hair00.addOrReplaceChild("Hair01",
                CubeListBuilder.create().texOffs(166, 78)
                        .addBox(-4.0F, -1.0F, -0.2F, 8.0F, 20.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 0.7F, 1.3F, -0.7285004297824331F, 0.0F,
                        -0.36425021489121656F));

        PartDefinition hair02 = hair01.addOrReplaceChild("Hair02",
                CubeListBuilder.create().mirror().texOffs(169, 80)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 18.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 16.5F, 5.0F, -0.3490658503988659F, 0.0F,
                        -0.27314402793711257F));

        PartDefinition hair03 = hair02.addOrReplaceChild("Hair03",
                CubeListBuilder.create().texOffs(170, 81)
                        .addBox(-3.5F, 0.0F, -4.0F, 7.0F, 16.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 15.0F, 1.0F, 0.2617993877991494F, 0.0F,
                        0.36425021489121656F));

        hair03.addOrReplaceChild("Hair04",
                CubeListBuilder.create().texOffs(209, 108)
                        .addBox(-3.0F, 0.0F, -3.2F, 6.0F, 15.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 13.0F, 0.0F, -0.3490658503988659F, 0.0F,
                        0.27314402793711257F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(52, 65)
                        .addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3141592653589793F, 0.0F, 0.0F));

        PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().mirror().texOffs(0, 63)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.2792526803190927F, 0.0F,
                        0.13962634015954636F));

        PartDefinition equipLegL01 = legLeft01.addOrReplaceChild("EquipLegL01",
                CubeListBuilder.create().mirror().texOffs(154, 12)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 2.0F, 7.0F),
                PartPose.offset(0.0F, 9.0F, 0.0F));

        equipLegL01.addOrReplaceChild("EquipLegL02c",
                CubeListBuilder.create().texOffs(0, 84)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F),
                PartPose.offsetAndRotation(3.2F, -0.7F, -2.5F, 0.0F, 0.0F, -0.05235987755982988F));

        equipLegL01.addOrReplaceChild("EquipLegL02a",
                CubeListBuilder.create().texOffs(0, 84)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F),
                PartPose.offsetAndRotation(3.4F, -0.9F, -0.9F, 0.0F, 0.0F, -0.05235987755982988F));

        equipLegL01.addOrReplaceChild("EquipLegL02b",
                CubeListBuilder.create().texOffs(0, 84)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F),
                PartPose.offsetAndRotation(3.2F, -0.7F, 0.7F, 0.0F, 0.0F, -0.05235987755982988F));

        PartDefinition legLeft02 = legLeft01.addOrReplaceChild("LegLeft02",
                CubeListBuilder.create().mirror().texOffs(0, 83)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                PartPose.offset(0.0F, 14.0F, -3.0F));

        legLeft02.addOrReplaceChild("ShoesL01",
                CubeListBuilder.create().mirror().texOffs(18, 80)
                        .addBox(-3.5F, 0.0F, -0.5F, 7.0F, 2.0F, 7.0F),
                PartPose.offset(0.0F, 7.0F, 0.0F));

        PartDefinition skirt01 = butt.addOrReplaceChild("Skirt01",
                CubeListBuilder.create().texOffs(0, 48)
                        .addBox(-8.5F, 0.0F, -6.0F, 17.0F, 4.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 2.3F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));

        skirt01.addOrReplaceChild("Skirt02",
                CubeListBuilder.create().texOffs(42, 51)
                        .addBox(-9.0F, 0.0F, -6.0F, 18.0F, 4.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 2.9F, -0.4F, -0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().texOffs(226, 83)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.13962634015954636F, 0.0F,
                        -0.13962634015954636F));

        PartDefinition equipLegR01 = legRight01.addOrReplaceChild("EquipLegR01",
                CubeListBuilder.create().texOffs(133, 8)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 2.0F, 7.0F),
                PartPose.offset(0.0F, 9.0F, 0.0F));

        equipLegR01.addOrReplaceChild("EquipLegR02a",
                CubeListBuilder.create().texOffs(0, 84)
                        .addBox(-1.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F),
                PartPose.offsetAndRotation(-3.2F, -0.7F, -2.5F, 0.0F, 0.0F, 0.05235987755982988F));

        equipLegR01.addOrReplaceChild("EquipLegR02c",
                CubeListBuilder.create().texOffs(0, 84)
                        .addBox(-1.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F),
                PartPose.offsetAndRotation(-3.2F, -0.7F, 0.7F, 0.0F, 0.0F, 0.05235987755982988F));

        equipLegR01.addOrReplaceChild("EquipLegR02b",
                CubeListBuilder.create().texOffs(0, 84)
                        .addBox(-1.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F),
                PartPose.offsetAndRotation(-3.4F, -0.8F, -0.9F, 0.0F, 0.0F, 0.05235987755982988F));

        PartDefinition legRight02 = legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().texOffs(201, 83)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                PartPose.offset(0.0F, 14.0F, -3.0F));

        legRight02.addOrReplaceChild("ShoesR01",
                CubeListBuilder.create().texOffs(18, 80)
                        .addBox(-3.5F, 0.0F, -0.5F, 7.0F, 2.0F, 7.0F),
                PartPose.offset(0.0F, 7.0F, 0.0F));

        butt.addOrReplaceChild("AnchorL",
                CubeListBuilder.create().mirror().texOffs(24, 90)
                        .addBox(0.0F, 0.0F, -3.0F, 1.0F, 7.0F, 6.0F),
                PartPose.offsetAndRotation(7.7F, 2.0F, -2.0F, 0.0F, 0.0F, -0.3490658503988659F));

        butt.addOrReplaceChild("AnchorR",
                CubeListBuilder.create().texOffs(24, 90)
                        .addBox(-1.0F, 0.0F, -3.0F, 1.0F, 7.0F, 6.0F),
                PartPose.offsetAndRotation(-7.7F, 2.0F, -2.0F, 0.0F, 0.0F, 0.3490658503988659F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -15.0F, 0.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -10.7F, -0.2F));

        PartDefinition glowHead = glowNeck.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -1.0F, 0.0F));
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
                this.scale = 2F;
                this.offsetY = -0.73F;
                break;
            case 2:
                this.scale = 1.5F;
                this.offsetY = -0.48F;
                break;
            case 1:
                this.scale = 1F;
                this.offsetY = 0.02F;
                break;
            default:
                this.scale = 0.5F;
                this.offsetY = 1.53F;
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

        boolean flag = !EmotionHelper.checkModelState(0, state);
        this.EquipBaseBelt.visible = !flag;

        flag = !EmotionHelper.checkModelState(1, state);
        this.EquipHeadBase.visible = !flag;

        flag = !EmotionHelper.checkModelState(2, state);
        this.EquipU01.visible = !flag;

        flag = !EmotionHelper.checkModelState(3, state);
        this.EquipLegR01.visible = !flag;
        this.EquipLegL01.visible = !flag;
    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowBodyMain.xRot = this.BodyMain.xRot;
        this.GlowBodyMain.yRot = this.BodyMain.yRot;
        this.GlowBodyMain.zRot = this.BodyMain.zRot;
        this.GlowNeck.xRot = this.Neck.xRot;
        this.GlowNeck.yRot = this.Neck.yRot;
        this.GlowNeck.zRot = this.Neck.zRot;
        this.GlowHead.xRot = this.Head.xRot;
        this.GlowHead.yRot = this.Head.yRot;
        this.GlowHead.zRot = this.Head.zRot;
        this.EquipLC01a.xRot = this.Head.xRot;
        this.EquipLC02a.xRot = this.Head.xRot;
        this.EquipLC03a.xRot = this.Head.xRot;
        this.EquipLC201a.xRot = this.Head.xRot;
        this.EquipLC202a.xRot = this.Head.xRot;
        this.EquipLC203a.xRot = this.Head.xRot;
        this.EquipRC01a.xRot = this.Head.xRot;
        this.EquipRC02a.xRot = this.Head.xRot;
        this.EquipRC03a.xRot = this.Head.xRot;
        this.EquipRC201a.xRot = this.Head.xRot;
        this.EquipRC202a.xRot = this.Head.xRot;
        this.EquipRC203a.xRot = this.Head.xRot;
        this.EquipLCBase02.yRot = this.Head.yRot;
        this.EquipLC2Base02.yRot = this.Head.yRot;
        this.EquipRCBase02.yRot = this.Head.yRot;
        this.EquipRC2Base02.yRot = this.Head.yRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        this.offsetY += 0.58F + 0.22F * ent.getScaleLevel();
        this.setFaceHungry(ent);

        // 頭部
        this.Head.xRot = -0.2618F;
        this.Head.yRot = 0F;
        this.Head.zRot = 0F;
        // 胸部
        this.BoobL.xRot = -1.0F;
        this.BoobR.xRot = -1.0F;
        this.Cloth02a.xRot = -1.0F;
        // Body
        this.Ahoke.yRot = -1.0F;
        this.BodyMain.xRot = 1.2217F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 1.2217F;
        this.Butt.xRot = -0.05F;
        // hair
        this.Hair01.xRot = -0.72F;
        this.Hair01.zRot = -0.36F;
        this.Hair02.xRot = -0.35F;
        this.Hair02.zRot = -0.15F;
        this.Hair03.xRot = 0.26F;
        this.Hair03.zRot = 0.36F;
        this.Hair04.xRot = -0.35F;
        this.Hair04.zRot = 0.1F;
        this.HairL01.zRot = 0.0873F;
        this.HairL02.zRot = -0.3142F;
        this.HairL03.zRot = 0.18F;
        this.HairR01.zRot = -0.0873F;
        this.HairR02.zRot = -1.2217F;
        this.HairR03.zRot = -0.15F;
        this.HairL01.xRot = -0.28F;
        this.HairL02.xRot = 0.15F;
        this.HairL03.xRot = 0.05F;
        this.HairR01.xRot = -0.35F;
        this.HairR02.xRot = 0.18F;
        this.HairR03.xRot = 0.02F;
        // arm
        this.ArmLeft01.xRot = -0.35F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = -3F;
        this.ArmLeft02.xRot = 0F;
        this.ArmRight01.xRot = -0.35F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = -0.35F;
        this.ArmRight02.xRot = 0F;
        this.ArmRight02.zRot = -0.8727F;
        // leg
        this.LegLeft01.xRot = -0.14F;
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.09F;
        this.LegLeft02.xRot = 0F;
        this.LegLeft02.zRot = 0F;
        // this.LegLeft02.offsetZ = 0F;
        this.LegRight01.xRot = -1.2217F;
        this.LegRight01.yRot = -0.5236F;
        this.LegRight01.zRot = 0F;
        this.LegRight02.xRot = 1.0472F;
        this.LegRight02.zRot = 0F;
        // this.LegRight02.offsetZ = 0F;
        this.AnchorL.xRot = -0.2F;
        this.AnchorR.xRot = -0.2F;
        this.AnchorR.zRot = 0.35F;
        // equip
        this.EquipU01.visible = false;
        this.EquipBaseBelt.visible = false;
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
        boolean showCannon = EmotionHelper.checkModelState(0, ent.getStateEmotion(ID.S.State));
        boolean showUmbrella = EmotionHelper.checkModelState(2, ent.getStateEmotion(ID.S.State));

        // 水上漂浮
        if (ent.getShipDepth(0) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        // leg move
        addk1 = angleAdd1 * 0.5F - 0.2793F; // LegLeft01
        addk2 = angleAdd2 * 0.5F - 0.1396F; // LegRight01

        // 移動頭部使其看人
        this.Head.xRot = f4 * 0.014F - 0.1047F; // 上下角度
        this.Head.yRot = f3 * 0.01F; // 左右角度

        // 正常站立動作
        // 胸部
        this.BoobL.xRot = angleX * 0.06F - 0.75F;
        this.BoobR.xRot = angleX * 0.06F - 0.75F;
        this.Cloth02a.xRot = angleX * 0.06F - 0.7F;
        // Body
        this.Ahoke.yRot = angleX * 0.25F + 0.45F;
        this.BodyMain.xRot = -0.1047F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        this.Butt.xRot = 0.3142F;
        // hair
        this.Hair01.xRot = angleX * 0.03F - 0.7F;
        this.Hair01.zRot = 0F;
        this.Hair02.xRot = -angleX1 * 0.04F - 0.11F;
        this.Hair02.zRot = 0F;
        this.Hair03.xRot = -angleX2 * 0.07F - 0.05F;
        this.Hair03.zRot = 0F;
        this.Hair04.xRot = -angleX3 * 0.10F - 0.02F;
        this.Hair04.zRot = 0F;
        this.HairL01.zRot = 0.0873F;
        this.HairL02.zRot = -0.3142F;
        this.HairL03.zRot = 0.18F;
        this.HairR01.zRot = -0.0873F;
        this.HairR02.zRot = 0.25F;
        this.HairR03.zRot = -0.15F;
        this.HairL01.xRot = -0.28F;
        this.HairL02.xRot = 0.15F;
        this.HairL03.xRot = 0.05F;
        this.HairR01.xRot = -0.35F;
        this.HairR02.xRot = 0.18F;
        this.HairR03.xRot = 0.02F;
        // arm
        this.ArmLeft01.xRot = angleAdd2 * 0.25F + 0.18F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = angleX * 0.03F - 0.26F;
        this.ArmLeft02.xRot = 0F;
        // equipU
        this.EquipU01.yRot = 2.4F;

        if (showUmbrella) {
            this.ArmRight01.xRot = -f1 * 0.4F + 0.1745F;
            this.ArmRight01.yRot = 0F;
            this.ArmRight01.zRot = 0.1571F;
            this.ArmRight02.xRot = -1.4835F;

        } else {
            this.ArmRight01.xRot = angleAdd1 * 0.25F + 0.18F;
            this.ArmRight01.yRot = 0F;
            this.ArmRight01.zRot = -angleX * 0.03F + 0.26F;
            this.ArmRight02.xRot = 0F;
        }
        this.ArmRight02.zRot = 0F;

        // leg
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.1396F;
        this.LegLeft02.xRot = 0F;
        this.LegLeft02.zRot = 0F;
        // this.LegLeft02.offsetZ = 0F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.1396F;
        this.LegRight02.xRot = 0F;
        this.LegRight02.zRot = 0F;
        // this.LegRight02.offsetZ = 0F;
        this.AnchorL.xRot = f1 * 0.5F - 0.2F;
        this.AnchorR.xRot = f1 * 0.5F - 0.2F;
        this.AnchorR.zRot = 0.35F;
        // cannon
        if (showCannon) {
            this.EquipRotateBase.xRot = 0F;
            this.EquipLCBase02_1.yRot = 3.1415F;

            if (this.Head.xRot <= 0F) {
                this.EquipLC01a.xRot = this.Head.xRot * 0.7F;
                this.EquipLC02a.xRot = this.Head.xRot;
                this.EquipLC03a.xRot = this.Head.xRot * 0.8F;
                this.EquipLC201a.xRot = this.Head.xRot * 1.2F;
                this.EquipLC202a.xRot = this.Head.xRot;
                this.EquipLC203a.xRot = this.Head.xRot * 0.9F;

                this.EquipRC01a.xRot = this.Head.xRot * 0.9F;
                this.EquipRC02a.xRot = this.Head.xRot;
                this.EquipRC03a.xRot = this.Head.xRot * 0.75F;
                this.EquipRC201a.xRot = this.Head.xRot * 0.85F;
                this.EquipRC202a.xRot = this.Head.xRot * 1.1F;
                this.EquipRC203a.xRot = this.Head.xRot;
            }

            this.EquipLCBase02.yRot = this.Head.yRot * 1.3F;
            this.EquipLC2Base02.yRot = this.Head.yRot * 1.45F;
            this.EquipLC3Base02.yRot = -this.Head.xRot;

            this.EquipRCBase02.yRot = this.Head.yRot * 1.3F;
            this.EquipRC2Base02.yRot = this.Head.yRot * 1.45F;
            this.EquipRC3Base02.yRot = this.Head.xRot;

            // hair in equip mode
            this.Hair01.xRot = -0.7F;
            this.Hair01.zRot = -0.35F;
            this.Hair02.xRot = -0.35F;
            this.Hair02.zRot = -0.3142F;
            this.Hair03.xRot = 0.2618F;
            this.Hair03.zRot = 0.4363F;
            this.Hair04.xRot = -0.3491F;
            this.Hair04.zRot = 0.2618F;
        }

        if (ent.getIsSprinting() || f1 > 0.1F) { // 奔跑動作
            // hair
            this.Hair01.xRot += f1 * 0.25F;
            // arm
            this.ArmLeft01.zRot += f1 * -0.25F;
        }

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        if (ent.getIsSneaking()) { // 潛行, 蹲下動作
            // Body
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.07F;
            this.Head.xRot -= 1.0472F;
            this.BodyMain.xRot = 1.0472F;
            this.Butt.xRot = -0.8378F;
            // arm
            this.ArmLeft01.xRot = -0.7F;
            this.ArmLeft01.zRot = 0.2618F;
            if (showUmbrella) {
                this.ArmRight01.xRot -= 1.0472F;
            } else {
                this.ArmRight01.xRot = -0.7F;
                this.ArmRight01.yRot = 0F;
                this.ArmRight01.zRot = -0.2618F;
                this.ArmRight02.xRot = 0F;
            }
            // hair
            this.Hair01.xRot = -1.2109F;
            this.Hair01.zRot = -0.4363F;
            this.Hair02.xRot = -0.5236F;
            this.Hair02.zRot = -0.3491F;
            this.Hair03.xRot = 0F;
            this.Hair03.zRot = 0.4363F;
            this.Hair04.xRot = -0.3491F;
            this.Hair04.zRot = 0.2618F;
            // cannon
            if (showCannon) {
                this.EquipRotateBase.xRot -= 1.0472F;
            }
        } // end if sneaking

        if (ent.getIsSitting() || ent.getIsRiding()) {
            // 騎乘動作
            if (showCannon) {
                // Body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.4F;
                this.Head.xRot -= 0.2F;
                this.BodyMain.xRot = -0.1396F;
                this.Butt.xRot = 0.1396F;
                // arm
                this.ArmLeft01.xRot = -0.2094F;
                this.ArmLeft01.zRot = 0.2618F;
                if (showUmbrella) {
                    this.ArmRight01.xRot = 0.1745F;
                    this.ArmRight01.yRot = 0F;
                    this.ArmRight01.zRot = 0.1571F;
                    this.ArmRight02.xRot = -1.4835F;
                } else {
                    this.ArmRight01.xRot = -0.2094F;
                    this.ArmRight01.yRot = 0F;
                    this.ArmRight01.zRot = -0.2618F;
                    this.ArmRight02.xRot = 0F;
                }
                // leg
                addk1 = -1.0472F;
                addk2 = -1.0472F;
                this.LegLeft01.yRot = 0.0524F;
                this.LegLeft01.zRot = 0F;
                // this.LegLeft02.offsetZ = 0.38F;
                this.LegLeft02.xRot = 2.5831F;
                this.LegLeft02.zRot = 0.0175F;
                this.LegRight01.yRot = -0.0524F;
                this.LegRight01.zRot = 0F;
                // this.LegRight02.offsetZ = 0.38F;
                this.LegRight02.xRot = 2.5831F;
                this.LegRight02.zRot = -0.0175F;
                this.EquipLCBase02_1.yRot = 0F;
            } else if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                // Body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.5F;
                this.Head.xRot -= 0.21F;
                this.Head.yRot -= 0.4363F;
                this.BodyMain.xRot = 0.2618F;
                this.BodyMain.yRot = 0.35F;
                this.BodyMain.zRot = 0.4363F;
                // hair
                this.Hair01.xRot = -0.95F;
                this.Hair01.zRot = -0.2618F;
                this.Hair02.xRot = -0.3491F;
                this.Hair02.zRot = -0.3491F;
                this.Hair03.xRot = -0.3491F;
                this.Hair03.zRot = -0.3491F;
                this.Hair04.xRot = -0.4363F;
                this.Hair04.zRot = -0.4363F;
                // arm
                this.ArmLeft01.xRot = -0.35F;
                this.ArmLeft01.yRot = -0.5236F;
                this.ArmLeft01.zRot = -0.2618F;
                this.ArmLeft02.xRot = -0.5236F;
                if (showUmbrella) {
                    this.ArmRight01.xRot = 0F;
                    this.ArmRight01.yRot = 0F;
                    this.ArmRight01.zRot = -0.0524F;
                    this.ArmRight02.xRot = -1.0472F;
                } else {
                    this.ArmRight01.xRot = 0.0873F;
                    this.ArmRight01.yRot = 0F;
                    this.ArmRight01.zRot = 0.0873F;
                    this.ArmRight02.xRot = -0.5236F;
                }
                // leg
                addk1 = -0.0873F;
                addk2 = -0.4363F;
                this.LegLeft01.yRot = 0F;
                this.LegLeft01.zRot = 1.0472F;
                this.LegLeft02.xRot = 0.4363F;
                this.LegRight01.yRot = 0F;
                this.LegRight01.zRot = 0.9250F;
                this.LegRight02.xRot = 0.5236F;
                // equipU
                this.EquipU01.yRot = 2.15F;
                this.EquipU01.zRot = -1.85F;
                this.AnchorR.zRot = 0.7F;
            } else {
                // Body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.54F;
                this.Head.xRot += 0.1047F;
                this.BodyMain.xRot = -0.1396F;
                this.Butt.xRot = 0.1396F;
                // hair
                this.Hair01.xRot = -0.6108F;
                this.Hair01.zRot = -0.2618F;
                this.Hair02.xRot = -0.4363F;
                this.Hair02.zRot = 0.4363F;
                this.Hair03.xRot = -0.3491F;
                this.Hair03.zRot = 0.4363F;
                this.Hair04.xRot = -0.5236F;
                this.Hair04.zRot = 0.5236F;
                // arm
                this.ArmLeft01.xRot = -0.2094F;
                this.ArmLeft01.zRot = 0.2618F;
                if (showUmbrella) {
                    this.ArmRight01.xRot = 0.1745F;
                    this.ArmRight01.yRot = 0F;
                    this.ArmRight01.zRot = 0.1571F;
                    this.ArmRight02.xRot = -1.4835F;
                } else {
                    this.ArmRight01.xRot = -0.2094F;
                    this.ArmRight01.yRot = 0F;
                    this.ArmRight01.zRot = -0.2618F;
                    this.ArmRight02.xRot = 0F;
                }
                // leg
                addk1 = -1.4835F;
                addk2 = -1.4835F;
                this.LegLeft01.yRot = 0.0524F;
                this.LegLeft01.zRot = -1.4835F;
                // this.LegLeft02.offsetZ = 0.38F;
                this.LegLeft02.xRot = 2.1F;
                this.LegLeft02.zRot = 0.0175F;
                this.LegRight01.yRot = -0.0524F;
                this.LegRight01.zRot = 1.4835F;
                // this.LegRight02.offsetZ = 0.38F;
                this.LegRight02.xRot = 1.9199F;
                this.LegRight02.zRot = -0.0175F;
            }
        } // end if sitting

        // 攻擊動作
        if (ent.getAttackTick() > 0) {
            this.ArmLeft01.xRot = -1.5708F;
            this.ArmLeft01.yRot = -0.2F + this.Head.yRot;
            this.ArmLeft01.zRot = 0F;
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

        // 鬢毛調整
        float headZ = this.Head.zRot * -0.5F;
        float headX = this.Head.xRot * -0.5F - 0.05F;
        this.Hair01.xRot += headX;
        this.Hair02.xRot += headX * 0.5F;
        this.Hair03.xRot += headX * 0.2F;
        this.Hair04.xRot += headX * 0.2F;
        this.Hair01.zRot += angleAdd1 * 0.04F + headZ;
        this.Hair02.zRot += angleAdd2 * 0.06F + headZ * 0.8F;
        this.Hair03.zRot += angleAdd2 * 0.08F + headZ * 0.4F;
        this.Hair04.zRot += angleAdd2 * 0.10F + headZ * 0.4F;
        this.HairL01.zRot += headZ;
        this.HairL02.zRot += headZ * 0.8F;
        this.HairL03.zRot += headZ * 0.4F;
        this.HairR01.zRot += headZ;
        this.HairR02.zRot += headZ * 0.8F;
        this.HairR03.zRot += headZ * 0.4F;
        this.HairL01.xRot += angleX * 0.04F + headX;
        this.HairL02.xRot += angleX1 * 0.05F + headX * 0.8F;
        this.HairL03.xRot += angleX2 * 0.07F + headX * 0.4F;
        this.HairR01.xRot += angleX * 0.04F + headX;
        this.HairR02.xRot += angleX1 * 0.05F + headX * 0.8F;
        this.HairR03.xRot += angleX2 * 0.07F + headX * 0.4F;

        // leg motion
        this.LegLeft01.xRot = addk1;
        this.LegRight01.xRot = addk2;
    }
}
