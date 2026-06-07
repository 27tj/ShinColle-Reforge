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

public class ModelHeavyCruiserNe extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "ca_ne"), "main");

    private final ModelPart BodyMain;
    private final ModelPart ArmLeft01;
    private final ModelPart ArmRight01;
    private final ModelPart LegLeft01;
    private final ModelPart LegRight01;
    private final ModelPart Neck;
    private final ModelPart Head;
    private final ModelPart Cloth01;
    private final ModelPart TailBase;
    private final ModelPart ArmLeft02;
    private final ModelPart ArmRight02;
    private final ModelPart LegLeft02;
    private final ModelPart LegRight02;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart Ear01;
    private final ModelPart Ear02;
    private final ModelPart Ahoke;
    private final ModelPart Hair01;
    private final ModelPart Hair02;
    private final ModelPart Hair03;
    private final ModelPart TailL01;
    private final ModelPart TailR01;
    private final ModelPart TailL02;
    private final ModelPart TailL03;
    private final ModelPart TailL04;
    private final ModelPart TailL05;
    private final ModelPart TailL06;
    private final ModelPart TailLHead01;
    private final ModelPart TailLHead02;
    private final ModelPart TailLC01;
    private final ModelPart TailLC02;
    private final ModelPart TailLC03;
    private final ModelPart TailR02;
    private final ModelPart TailR03;
    private final ModelPart TailR04;
    private final ModelPart TailR05;
    private final ModelPart TailR06;
    private final ModelPart TailRHead01;
    private final ModelPart TailRHead02;
    private final ModelPart TailRC01;
    private final ModelPart TailRC02;
    private final ModelPart TailRC03;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowHead;

    public ModelHeavyCruiserNe(ModelPart root) {
        super();
        this.scale = 0.4F;
        this.offsetY = 2.63F;
        this.BodyMain = root.getChild("BodyMain");
        this.LegLeft01 = this.BodyMain.getChild("LegLeft01");
        this.Neck = this.BodyMain.getChild("Neck");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.TailBase = this.BodyMain.getChild("TailBase");
        this.LegRight01 = this.BodyMain.getChild("LegRight01");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.Head = this.BodyMain.getChild("Head");
        this.Cloth01 = this.BodyMain.getChild("Cloth01");
        this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.TailL01 = this.TailBase.getChild("TailL01");
        this.TailR01 = this.TailBase.getChild("TailR01");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.Hair = this.Head.getChild("Hair");
        this.Ear02 = this.Head.getChild("Ear02");
        this.Ear01 = this.Head.getChild("Ear01");
        this.HairMain = this.Head.getChild("HairMain");
        this.TailL02 = this.TailL01.getChild("TailL02");
        this.TailR02 = this.TailR01.getChild("TailR02");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.Hair02 = this.HairMain.getChild("Hair02");
        this.Hair01 = this.HairMain.getChild("Hair01");
        this.TailL03 = this.TailL02.getChild("TailL03");
        this.TailR03 = this.TailR02.getChild("TailR03");
        this.Hair03 = this.Hair02.getChild("Hair03");
        this.TailL04 = this.TailL03.getChild("TailL04");
        this.TailR04 = this.TailR03.getChild("TailR04");
        this.TailL05 = this.TailL04.getChild("TailL05");
        this.TailR05 = this.TailR04.getChild("TailR05");
        this.TailL06 = this.TailL05.getChild("TailL06");
        this.TailR06 = this.TailR05.getChild("TailR06");
        this.TailLHead01 = this.TailL06.getChild("TailLHead01");
        this.TailLHead02 = this.TailL06.getChild("TailLHead02");
        this.TailRHead01 = this.TailR06.getChild("TailRHead01");
        this.TailRHead02 = this.TailR06.getChild("TailRHead02");
        this.TailLC01 = this.TailLHead01.getChild("TailLC01");
        this.TailLC02 = this.TailLHead01.getChild("TailLC02");
        this.TailLC03 = this.TailLHead01.getChild("TailLC03");
        this.TailRC02 = this.TailRHead01.getChild("TailRC02");
        this.TailRC01 = this.TailRHead01.getChild("TailRC01");
        this.TailRC03 = this.TailRHead01.getChild("TailRC03");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowHead = this.GlowBodyMain.getChild("GlowHead");
        this.loadFaceParts(this.GlowHead);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 93)
                        .addBox(-5.5F, -4.5F, -12.0F, 11.0F, 10.0F, 24.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition legLeft01 = bodyMain.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().texOffs(48, 92)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F),
                PartPose.offsetAndRotation(4.0F, 3.0F, 8.3F, 0.13962634015954636F, 0.0F,
                        0.17453292519943295F));

        legLeft01.addOrReplaceChild("LegLeft02",
                CubeListBuilder.create().texOffs(48, 105)
                        .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 7.0F, 5.0F),
                PartPose.offset(0.0F, 8.0F, -2.5F));

        bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(0, 78)
                        .addBox(-5.0F, -2.0F, -4.5F, 10.0F, 5.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, -4.0F, -9.4F, 0.41887902047863906F, 0.0F, 0.0F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().texOffs(0, 92)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F),
                PartPose.offsetAndRotation(4.0F, 3.0F, -6.0F, -0.13962634015954636F, 0.0F,
                        0.20943951023931953F));

        armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().texOffs(0, 105)
                        .addBox(-5.0F, 0.0F, -5.0F, 5.0F, 7.0F, 5.0F),
                PartPose.offset(2.5F, 8.0F, 2.5F));

        PartDefinition tailBase = bodyMain.addOrReplaceChild("TailBase",
                CubeListBuilder.create().texOffs(98, 0)
                        .addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, -0.5F, 9.0F, 0.7853981633974483F, 0.0F, 0.0F));

        PartDefinition tailL01 = tailBase.addOrReplaceChild("TailL01",
                CubeListBuilder.create().texOffs(98, 0)
                        .addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 7.0F),
                PartPose.offsetAndRotation(1.5F, 0.0F, 6.0F, 0.2617993877991494F, 0.41887902047863906F,
                        0.0F));

        PartDefinition tailL02 = tailL01.addOrReplaceChild("TailL02",
                CubeListBuilder.create().texOffs(95, 3)
                        .addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.2617993877991494F, 0.3141592653589793F,
                        0.0F));

        PartDefinition tailL03 = tailL02.addOrReplaceChild("TailL03",
                CubeListBuilder.create().texOffs(95, 1)
                        .addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.2617993877991494F, 0.24434609527920614F,
                        0.0F));

        PartDefinition tailL04 = tailL03.addOrReplaceChild("TailL04",
                CubeListBuilder.create().texOffs(97, 3)
                        .addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.2617993877991494F, 0.20943951023931953F,
                        0.0F));

        PartDefinition tailL05 = tailL04.addOrReplaceChild("TailL05",
                CubeListBuilder.create().texOffs(95, 2)
                        .addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.2617993877991494F, 0.13962634015954636F,
                        0.0F));

        PartDefinition tailL06 = tailL05.addOrReplaceChild("TailL06",
                CubeListBuilder.create().texOffs(89, 0)
                        .addBox(-4.5F, -3.5F, 0.0F, 9.0F, 7.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.2617993877991494F, 0.06981317007977318F,
                        0.0F));

        PartDefinition tailLHead01 = tailL06.addOrReplaceChild("TailLHead01",
                CubeListBuilder.create().texOffs(76, 18)
                        .addBox(-5.5F, -2.0F, 0.0F, 11.0F, 6.0F, 15.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -2.5F, -0.12217304763960307F, 0.0F, 0.0F));

        tailLHead01.addOrReplaceChild("TailLC01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F),
                PartPose.offsetAndRotation(0.0F, 2.2F, 13.5F, -0.18203784098300857F, 0.0F, 0.0F));

        tailLHead01.addOrReplaceChild("TailLC02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F),
                PartPose.offsetAndRotation(-3.0F, 2.0F, 13.5F, -0.091106186954104F,
                        -0.08726646259971647F, 0.0F));

        tailLHead01.addOrReplaceChild("TailLC03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F),
                PartPose.offsetAndRotation(3.0F, 2.0F, 13.5F, -0.136659280431156F, 0.08726646259971647F,
                        0.0F));

        tailL06.addOrReplaceChild("TailLHead02",
                CubeListBuilder.create().texOffs(22, 27)
                        .addBox(-5.0F, -4.0F, 0.0F, 10.0F, 3.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 1.5F, 0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition tailR01 = tailBase.addOrReplaceChild("TailR01",
                CubeListBuilder.create().mirror().texOffs(101, 0)
                        .addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 7.0F),
                PartPose.offsetAndRotation(-1.5F, 0.0F, 6.0F, 0.2617993877991494F,
                        -0.06981317007977318F, 0.0F));

        PartDefinition tailR02 = tailR01.addOrReplaceChild("TailR02",
                CubeListBuilder.create().mirror().texOffs(102, 3)
                        .addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition tailR03 = tailR02.addOrReplaceChild("TailR03",
                CubeListBuilder.create().mirror().texOffs(97, 2)
                        .addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.3141592653589793F, 0.06981317007977318F,
                        0.0F));

        PartDefinition tailR04 = tailR03.addOrReplaceChild("TailR04",
                CubeListBuilder.create().mirror().texOffs(100, 2)
                        .addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.41887902047863906F, 0.13962634015954636F,
                        0.0F));

        PartDefinition tailR05 = tailR04.addOrReplaceChild("TailR05",
                CubeListBuilder.create().mirror().texOffs(97, 0)
                        .addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.5235987755982988F, 0.13962634015954636F,
                        0.0F));

        PartDefinition tailR06 = tailR05.addOrReplaceChild("TailR06",
                CubeListBuilder.create().mirror().texOffs(89, 1)
                        .addBox(-4.5F, -3.5F, 0.0F, 9.0F, 7.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.2617993877991494F, 0.13962634015954636F,
                        0.0F));

        PartDefinition tailRHead01 = tailR06.addOrReplaceChild("TailRHead01",
                CubeListBuilder.create().mirror().texOffs(76, 18)
                        .addBox(-5.5F, -2.0F, 0.0F, 11.0F, 6.0F, 15.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -2.5F, -0.12217304763960307F, 0.0F, 0.0F));

        tailRHead01.addOrReplaceChild("TailRC02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F),
                PartPose.offsetAndRotation(-3.0F, 2.0F, 13.5F, -0.091106186954104F,
                        -0.08726646259971647F, 0.0F));

        tailRHead01.addOrReplaceChild("TailRC01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F),
                PartPose.offsetAndRotation(0.0F, 2.2F, 13.5F, -0.18203784098300857F, 0.0F, 0.0F));

        tailRHead01.addOrReplaceChild("TailRC03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F),
                PartPose.offsetAndRotation(3.0F, 2.0F, 13.5F, -0.136659280431156F, 0.08726646259971647F,
                        0.0F));

        tailR06.addOrReplaceChild("TailRHead02",
                CubeListBuilder.create().mirror().texOffs(22, 27)
                        .addBox(-5.0F, -4.0F, 0.0F, 10.0F, 3.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 1.5F, 0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition legRight01 = bodyMain.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().mirror().texOffs(48, 92)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F),
                PartPose.offsetAndRotation(-4.0F, 3.0F, 8.3F, -0.13962634015954636F, 0.0F,
                        -0.17453292519943295F));

        legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().mirror().texOffs(48, 105)
                        .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 7.0F, 5.0F),
                PartPose.offset(0.0F, 8.0F, -2.5F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().mirror().texOffs(0, 92)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F),
                PartPose.offsetAndRotation(-4.0F, 3.0F, -6.0F, 0.13962634015954636F, 0.0F,
                        -0.20943951023931953F));

        armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().mirror().texOffs(0, 105)
                        .addBox(0.0F, 0.0F, -5.0F, 5.0F, 7.0F, 5.0F),
                PartPose.offset(-2.5F, 8.0F, 2.5F));

        PartDefinition head = bodyMain.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 65)
                        .addBox(-7.0F, -11.0F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offset(0.0F, -6.0F, -13.0F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(50, 40)
                        .addBox(-8.0F, -8.0F, -7.2F, 16.0F, 17.0F, 8.0F),
                PartPose.offset(0.0F, -4.0F, 0.0F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(104, 29)
                        .addBox(0.0F, -4.0F, -11.5F, 0.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -8.5F, -5.0F, 0.0F, 0.5235987755982988F, 0.0F));

        head.addOrReplaceChild("Ear02",
                CubeListBuilder.create().mirror().texOffs(0, 26)
                        .addBox(-2.0F, 0.0F, -7.0F, 4.0F, 7.0F, 7.0F),
                PartPose.offsetAndRotation(-4.2F, -11.0F, 6.8F, -0.8378F, 0.1222F, -0.1745F));

        head.addOrReplaceChild("Ear01",
                CubeListBuilder.create().texOffs(0, 26)
                        .addBox(-2.0F, 0.0F, -7.0F, 4.0F, 7.0F, 7.0F),
                PartPose.offsetAndRotation(4.2F, -11.0F, 6.8F, -0.8378F, -0.1222F, 0.1745F));

        PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(0, 56)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 12.0F, 10.0F),
                PartPose.offset(0.0F, -11.5F, -3.0F));

        PartDefinition hair02 = hairMain.addOrReplaceChild("Hair02",
                CubeListBuilder.create().texOffs(78, 92)
                        .addBox(-2.0F, 0.0F, -3.5F, 3.0F, 10.0F, 7.0F),
                PartPose.offsetAndRotation(-6.3F, 4.7F, 2.0F, 0.20943951023931953F, 0.0F,
                        0.17453292519943295F));

        hair02.addOrReplaceChild("Hair03",
                CubeListBuilder.create().texOffs(80, 109)
                        .addBox(-2.0F, 0.0F, -3.0F, 3.0F, 12.0F, 6.0F),
                PartPose.offsetAndRotation(0.2F, 7.5F, -0.3F, -0.2617993877991494F, 0.0F,
                        -0.2617993877991494F));

        hairMain.addOrReplaceChild("Hair01",
                CubeListBuilder.create().texOffs(0, 40)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 7.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 9.0F, 1.6F, 0.3490658503988659F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("Cloth01",
                CubeListBuilder.create().texOffs(42, 39)
                        .addBox(-4.0F, 0.0F, 0.0F, 8.0F, 9.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, -1.0F, -13.0F, -0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition glowHead = glowBodyMain.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -6.0F, -13.0F));
        addDefaultFaceParts(glowHead);

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
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

    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowBodyMain.xRot = this.BodyMain.xRot;
        this.GlowBodyMain.yRot = this.BodyMain.yRot;
        this.GlowBodyMain.zRot = this.BodyMain.zRot;
        this.GlowHead.xRot = this.Head.xRot;
        this.GlowHead.yRot = this.Head.yRot;
        this.GlowHead.zRot = this.Head.zRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += 0.2F;
        this.setFaceHungry(ent);

        // 頭部
        this.Head.xRot = 0.7853F;
        this.Head.yRot = 0F;
        // Body
        this.Ahoke.yRot = 0.45F;
        this.BodyMain.xRot = 0F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = -1.4835F;
        // this.Head.offsetY = 0F;
        // this.GlowHead.offsetY = 0F;
        // hair
        this.Hair02.xRot = 0.21F;
        this.Hair02.zRot = 0F;
        this.Hair03.xRot = -0.2618F;
        this.Hair03.zRot = 0F;
        // arm
        this.ArmLeft01.xRot = 0.1745F;
        this.ArmLeft01.zRot = 0.4537F;
        // this.ArmLeft01.offsetZ = 0F;
        this.ArmLeft02.zRot = 0F;
        this.ArmRight01.xRot = -0.1745F;
        this.ArmRight01.zRot = -0.05F;
        // this.ArmRight01.offsetZ = 0F;
        this.ArmRight02.zRot = 0F;
        // leg
        this.LegLeft01.xRot = -0.1745F;
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.4537F;
        this.LegLeft02.xRot = 0F;
        this.LegLeft02.zRot = 0F;
        this.LegRight01.xRot = 0.1745F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.05F;
        this.LegRight02.xRot = 0F;
        this.LegRight02.zRot = 0F;
        // tail
        this.TailBase.xRot = 0.8F;
        this.TailL01.xRot = 0.2618F;
        this.TailL01.yRot = -0.2F;
        this.TailL01.zRot = this.TailL01.yRot * 0.25F;
        this.TailL02.xRot = 0.2618F;
        this.TailL02.yRot = -0.3F;
        this.TailL02.zRot = this.TailL02.yRot * 0.25F;
        this.TailL03.xRot = 0.2618F;
        this.TailL03.yRot = -0.2F;
        this.TailL03.zRot = this.TailL03.yRot * 0.25F;
        this.TailL04.xRot = 0.35F;
        this.TailL04.yRot = 0.2F;
        this.TailL04.zRot = this.TailL04.yRot * 0.25F;
        this.TailL05.xRot = 0.4F;
        this.TailL05.yRot = 0.2F;
        this.TailL05.zRot = this.TailL05.yRot * 0.25F;
        this.TailL06.xRot = 0.45F;
        this.TailL06.yRot = 0.1F;
        this.TailL06.zRot = this.TailL06.yRot * 0.25F;
        this.TailR01.xRot = 0.6F;
        this.TailR01.yRot = 0.2617F;
        this.TailR01.zRot = this.TailR01.yRot * 0.25F;
        this.TailR02.xRot = 0.6F;
        this.TailR02.yRot = -0.2F;
        this.TailR02.zRot = this.TailR02.yRot * 0.25F;
        this.TailR03.xRot = 0.5F;
        this.TailR03.yRot = -0.1F;
        this.TailR03.zRot = this.TailR03.yRot * 0.25F;
        this.TailR04.xRot = 0.3F;
        this.TailR04.yRot = -0.1F;
        this.TailR04.zRot = this.TailR04.yRot * 0.25F;
        this.TailR05.xRot = 0.1F;
        this.TailR05.yRot = 0.1F;
        this.TailR05.zRot = this.TailR05.yRot * 0.25F;
        this.TailR06.xRot = -0.1F;
        this.TailR06.yRot = 0.1F;
        this.TailR06.zRot = this.TailR06.yRot * 0.25F;
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

        // 水上漂浮
        if (ent.getShipDepth(0) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        // leg move
        addk1 = angleAdd1 * 0.5F - 0.14F; // LegLeft01
        addk2 = angleAdd2 * 0.5F + 0.14F; // LegRight01
        this.ArmRight01.xRot = addk1;
        this.ArmLeft01.xRot = addk2;

        // head
        this.Head.xRot = f4 * 0.014F; // 上下角度
        this.Head.yRot = f3 * 0.01F; // 左右角度 角度轉成rad 即除以57.29578
        // body
        this.Ahoke.yRot = angleX * 0.25F + 0.45F;
        this.BodyMain.xRot = 0F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        // this.Head.offsetY = 0F;
        // this.GlowHead.offsetY = 0F;
        // hair
        this.Hair02.xRot = angleX1 * 0.04F + 0.21F;
        this.Hair02.zRot = 0F;
        this.Hair03.xRot = angleX2 * 0.07F - 0.2618F;
        this.Hair03.zRot = 0F;
        // arm
        this.ArmLeft01.zRot = 0.21F;
        // this.ArmLeft01.offsetZ = 0F;
        this.ArmLeft02.zRot = 0F;
        this.ArmRight01.zRot = -0.21F;
        // this.ArmRight01.offsetZ = 0F;
        this.ArmRight02.zRot = 0F;
        // leg
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.1745F;
        this.LegLeft02.xRot = 0F;
        this.LegLeft02.zRot = 0F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.1745F;
        this.LegRight02.xRot = 0F;
        this.LegRight02.zRot = 0F;
        // tail
        this.TailBase.xRot = 0.8F;
        this.TailL01.xRot = 0.2618F;
        this.TailL01.yRot = Mth.cos(-f2 * 0.1F + 0.7F) * 0.2F + 0.5F;
        this.TailL01.zRot = this.TailL01.yRot * 0.25F;
        this.TailL02.xRot = 0.2618F;
        this.TailL02.yRot = Mth.cos(-f2 * 0.1F + 1.4F) * 0.25F;
        this.TailL02.zRot = this.TailL02.yRot * 0.25F;
        this.TailL03.xRot = 0.2618F;
        this.TailL03.yRot = Mth.cos(-f2 * 0.1F + 2.1F) * 0.3F;
        this.TailL03.zRot = this.TailL03.yRot * 0.25F;
        this.TailL04.xRot = 0.35F;
        this.TailL04.yRot = Mth.cos(-f2 * 0.1F + 2.8F) * 0.35F;
        this.TailL04.zRot = this.TailL04.yRot * 0.25F;
        this.TailL05.xRot = 0.4F;
        this.TailL05.yRot = Mth.cos(-f2 * 0.1F + 3.5F) * 0.4F;
        this.TailL05.zRot = this.TailL05.yRot * 0.25F;
        this.TailL06.xRot = 0.45F;
        this.TailL06.yRot = Mth.cos(-f2 * 0.1F + 4.2F) * 0.35F;
        this.TailL06.zRot = this.TailL06.yRot * 0.25F;
        this.TailR01.xRot = 0.2618F;
        this.TailR01.yRot = Mth.cos(-f2 * 0.1F + 0.7F) * 0.2F - 0.5F;
        this.TailR01.zRot = this.TailR01.yRot * 0.25F;
        this.TailR02.xRot = 0.2618F;
        this.TailR02.yRot = Mth.cos(-f2 * 0.1F + 1.4F) * 0.25F;
        this.TailR02.zRot = this.TailR02.yRot * 0.25F;
        this.TailR03.xRot = 0.2618F;
        this.TailR03.yRot = Mth.cos(-f2 * 0.1F + 2.1F) * 0.3F;
        this.TailR03.zRot = this.TailR03.yRot * 0.25F;
        this.TailR04.xRot = 0.35F;
        this.TailR04.yRot = Mth.cos(-f2 * 0.1F + 2.8F) * 0.35F;
        this.TailR04.zRot = this.TailR04.yRot * 0.25F;
        this.TailR05.xRot = 0.4F;
        this.TailR05.yRot = Mth.cos(-f2 * 0.1F + 3.5F) * 0.4F;
        this.TailR05.zRot = this.TailR05.yRot * 0.25F;
        this.TailR06.xRot = 0.45F;
        this.TailR06.yRot = Mth.cos(-f2 * 0.1F + 4.2F) * 0.45F;
        this.TailR06.zRot = this.TailR06.yRot * 0.25F;

        // ear
        float modf2 = f2 % 128F;
        if (modf2 < 6F) {
            // total 10 ticks, loop twice in 20 ticks
            if (modf2 >= 3F)
                modf2 -= 3F;
            float anglef2 = Mth.sin(modf2 * 1.0472F) * 0.25F;
            this.Ear01.zRot = anglef2 + 0.1745F;
            this.Ear02.zRot = -anglef2 - 0.1745F;
        } else {
            this.Ear01.zRot = 0.1745F;
            this.Ear02.zRot = -0.1745F;
        }

        if (ent.getIsSprinting() || f1 > 0.8F) { // 奔跑動作
            // leg
            addk1 *= 2F;
            addk2 *= 2F;
            this.ArmRight01.xRot = addk1;
            this.ArmLeft01.xRot = addk2;
        }

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        ent.getIsSneaking(); // 潛行, 蹲下動作
        // head
        // this.Head.offsetY = 0.2F;
        // this.GlowHead.offsetY = 0.2F;
        // end if sneaking

        if (ent.getIsSitting() || ent.getIsRiding()) {
            // 騎乘動作
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                // head
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.22F;
                this.Head.xRot = 1.5359F;
                // this.Head.offsetY = 0.25F;
                this.GlowHead.xRot = 1.5359F;
                // this.GlowHead.offsetY = 0.25F;
                // arm
                addk1 = 1.5359F;
                addk2 = 1.5359F;
                this.ArmLeft01.xRot = -1.5359F;
                this.ArmLeft01.zRot = 0F;
                // this.ArmLeft01.offsetZ = -0.18F;
                this.ArmRight01.xRot = -1.5359F;
                this.ArmRight01.zRot = 0F;
                // this.ArmRight01.offsetZ = -0.18F;
                // tail
                this.TailBase.xRot = 0.0873F;
                this.TailL01.xRot = 0.02618F;
                this.TailL01.yRot *= 0.5F;
                this.TailL02.xRot = -0.02618F;
                this.TailL02.yRot *= 0.5F;
                this.TailL03.xRot = -0.02618F;
                this.TailL03.yRot *= 0.5F;
                this.TailL04.xRot = -0.035F;
                this.TailL04.yRot *= 0.5F;
                this.TailL05.xRot = -0.04F;
                this.TailL05.yRot *= 0.5F;
                this.TailL06.xRot = -0.045F;
                this.TailL06.yRot *= 0.5F;
                this.TailR01.xRot = -0.02618F;
                this.TailR01.yRot *= 0.5F;
                this.TailR02.xRot = -0.02618F;
                this.TailR02.yRot *= 0.5F;
                this.TailR03.xRot = -0.02618F;
                this.TailR03.yRot *= 0.5F;
                this.TailR04.xRot = -0.035F;
                this.TailR04.yRot *= 0.5F;
                this.TailR05.xRot = -0.04F;
                this.TailR05.yRot *= 0.5F;
                this.TailR06.xRot = -0.045F;
                this.TailR06.yRot *= 0.5F;
            } else {
                // head
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.22F;
                this.Head.xRot -= 0.5F;
                this.GlowHead.xRot -= 0.5F;
                // this.Head.offsetY = 0.25F;
                // this.GlowHead.offsetY = 0.25F;
                // arm
                addk1 = 1.5359F;
                addk2 = 1.5359F;
                this.ArmLeft01.xRot = -1.5359F;
                this.ArmLeft01.zRot = 0F;
                // this.ArmLeft01.offsetZ = -0.18F;
                this.ArmLeft02.zRot = 1.1868F;
                this.ArmRight01.xRot = -1.5359F;
                this.ArmRight01.zRot = 0F;
                // this.ArmRight01.offsetZ = -0.18F;
                this.ArmRight02.zRot = -1.1868F;
            }
        } // end if sitting

        // 攻擊動作
        if (ent.getAttackTick() > 20) {
            // tail
            this.TailL01.xRot = 0.2618F;
            this.TailL01.yRot = 0.2618F;
            this.TailL01.zRot = 0F;
            this.TailL02.xRot = 0.35F;
            this.TailL02.yRot = 0.1748F;
            this.TailL02.zRot = 0F;
            this.TailL03.xRot = 0.4363F;
            this.TailL03.yRot = 0.14F;
            this.TailL03.zRot = 0F;
            this.TailL04.xRot = 0.5236F;
            this.TailL04.yRot = 0.14F;
            this.TailL04.zRot = 0F;
            this.TailL05.xRot = 0.6109F;
            this.TailL05.yRot = 0.1745F;
            this.TailL05.zRot = 0F;
            this.TailL06.xRot = 0.35F;
            this.TailL06.yRot = 0F;
            this.TailL06.zRot = 0F;
            this.TailR01.xRot = 0.2618F;
            this.TailR01.yRot = -0.2618F;
            this.TailR01.zRot = 0F;
            this.TailR02.xRot = 0.35F;
            this.TailR02.yRot = -0.1748F;
            this.TailR02.zRot = 0F;
            this.TailR03.xRot = 0.35F;
            this.TailR03.yRot = -0.14F;
            this.TailR03.zRot = 0F;
            this.TailR04.xRot = 0.4363F;
            this.TailR04.yRot = -0.14F;
            this.TailR04.zRot = 0F;
            this.TailR05.xRot = 0.4363F;
            this.TailR05.yRot = -0.14F;
            this.TailR05.zRot = 0F;
            this.TailR06.xRot = 0.35F;
            this.TailR06.yRot = 0F;
            this.TailR06.zRot = 0F;
        }

        // swing arm
        float f6 = ent.getSwingTime(f2 - (int) f2);
        if (f6 != 0F) {
            float f7 = Mth.sin(f6 * f6 * (float) Math.PI);
            float f8 = Mth.sin(Mth.sqrt(f6) * (float) Math.PI);
            this.ArmRight01.xRot = -0.6F - f8 * 80.0F * ((float) Math.PI / 180F);
            this.ArmRight01.yRot = 0F - f7 * 20.0F * ((float) Math.PI / 180F) + 0.2F;
            this.ArmRight01.zRot = 0.2F - -f8 * 20.0F * ((float) Math.PI / 180F);
        }

        // 鬢毛調整
        float headZ = this.Head.zRot * -0.5F;
        float headX = this.Head.xRot * -0.5F - 0.05F;
        this.Hair02.xRot += headX * 0.5F;
        this.Hair03.xRot += headX * 0.2F;
        this.Hair02.zRot += headZ * 0.8F;
        this.Hair03.zRot += headZ * 0.4F;

        // leg motion
        this.LegLeft01.xRot = addk1;
        this.LegRight01.xRot = addk2;
    }
}
