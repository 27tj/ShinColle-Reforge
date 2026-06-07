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

public class ModelSubmSo extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "ss_so"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Butt;
    private final ModelPart Head;
    private final ModelPart ArmLeft01;
    private final ModelPart ArmRight01;
    private final ModelPart BodyMain1;
    private final ModelPart BodyMain2;
    private final ModelPart BoobL;
    private final ModelPart BoobL2;
    private final ModelPart BoobR;
    private final ModelPart BoobR2;
    private final ModelPart Butt1;
    private final ModelPart Butt2;
    private final ModelPart LegRight01;
    private final ModelPart LegLeft01;
    private final ModelPart LegRight02;
    private final ModelPart LegLeft02;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart EquipHeadBase;
    private final ModelPart Ahoke;
    private final ModelPart HairU01;
    private final ModelPart HairL01;
    private final ModelPart HairR01;
    private final ModelPart HairL02;
    private final ModelPart HairR02;
    private final ModelPart Hair01;
    private final ModelPart Hair02;
    private final ModelPart Hair03;
    private final ModelPart EquipHead01;
    private final ModelPart EquipHead02;
    private final ModelPart EquipHead03;
    private final ModelPart EquipHead04;
    private final ModelPart EquipHead05;
    private final ModelPart EquipC01;
    private final ModelPart EquipC02;
    private final ModelPart ArmLeft02;
    private final ModelPart EquipT01a;
    private final ModelPart EquipT01b;
    private final ModelPart ArmRight02;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowHead;
    private final ModelPart GlowArmLeft01;
    private final ModelPart GlowArmLeft02;

    public ModelSubmSo(ModelPart root) {
        super();
        this.scale = 0.47F;
        this.offsetY = 1.78F;
        this.BodyMain = root.getChild("BodyMain");
        this.Butt = this.BodyMain.getChild("Butt");
        this.Head = this.BodyMain.getChild("Head");
        this.BoobL2 = this.BodyMain.getChild("BoobL2");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.BodyMain1 = this.BodyMain.getChild("BodyMain1");
        this.BoobR = this.BodyMain.getChild("BoobR");
        this.Butt1 = this.BodyMain.getChild("Butt1");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.BoobR2 = this.BodyMain.getChild("BoobR2");
        this.BodyMain2 = this.BodyMain.getChild("BodyMain2");
        this.BoobL = this.BodyMain.getChild("BoobL");
        this.Butt2 = this.BodyMain.getChild("Butt2");
        this.LegRight01 = this.Butt.getChild("LegRight01");
        this.LegLeft01 = this.Butt.getChild("LegLeft01");
        this.HairMain = this.Head.getChild("HairMain");
        this.Hair = this.Head.getChild("Hair");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
        this.Hair01 = this.HairMain.getChild("Hair01");
        this.HairL01 = this.Hair.getChild("HairL01");
        this.HairR01 = this.Hair.getChild("HairR01");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.HairU01 = this.Hair.getChild("HairU01");
        this.Hair02 = this.Hair01.getChild("Hair02");
        this.HairL02 = this.HairL01.getChild("HairL02");
        this.HairR02 = this.HairR01.getChild("HairR02");
        this.Hair03 = this.Hair02.getChild("Hair03");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowHead = this.GlowBodyMain.getChild("GlowHead");
        this.GlowArmLeft01 = this.GlowBodyMain.getChild("GlowArmLeft01");
        this.GlowArmLeft02 = this.GlowArmLeft01.getChild("GlowArmLeft02");
        this.loadFaceParts(this.GlowHead);
        this.EquipHeadBase = this.GlowHead.getChild("EquipHeadBase");
        this.EquipHead01 = this.EquipHeadBase.getChild("EquipHead01");
        this.EquipHead02 = this.EquipHeadBase.getChild("EquipHead02");
        this.EquipHead03 = this.EquipHeadBase.getChild("EquipHead03");
        this.EquipHead04 = this.EquipHeadBase.getChild("EquipHead04");
        this.EquipHead05 = this.EquipHeadBase.getChild("EquipHead05");
        this.EquipC01 = this.EquipHeadBase.getChild("EquipC01");
        this.EquipC02 = this.EquipC01.getChild("EquipC02");
        this.EquipT01a = this.GlowArmLeft02.getChild("EquipT01a");
        this.EquipT01b = this.EquipT01a.getChild("EquipT01b");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 106)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, -11.0F, -3.0F, -0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 2.5F, 2.8F, 0.20943951023931953F, 0.0F, 0.0F));

        PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().texOffs(0, 87)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F),
                PartPose.offsetAndRotation(-4.4F, 6.5F, -4.0F, -0.03490658503988659F, 0.0F,
                        -0.10471975511965977F));

        legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().texOffs(0, 87)
                        .addBox(-6.0F, 0.0F, 0.0F, 6.0F, 13.0F, 6.0F),
                PartPose.offset(3.0F, 12.0F, -3.0F));

        PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().mirror().texOffs(0, 87)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F),
                PartPose.offsetAndRotation(4.4F, 6.5F, -4.0F, -0.15707963267948966F, 0.0F,
                        0.10471975511965977F));

        legLeft01.addOrReplaceChild("LegLeft02",
                CubeListBuilder.create().mirror().texOffs(0, 87)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 13.0F, 6.0F),
                PartPose.offset(-3.0F, 12.0F, -3.0F));

        PartDefinition head = bodyMain.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, -11.8F, -0.5F, 0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(46, 104)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F),
                PartPose.offset(0.0F, -14.8F, -3.0F));

        PartDefinition hair01 = hairMain.addOrReplaceChild("Hair01",
                CubeListBuilder.create().texOffs(0, 62)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 16.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 8.0F, 1.1F, 0.20943951023931953F, 0.0F, 0.0F));

        PartDefinition hair02 = hair01.addOrReplaceChild("Hair02",
                CubeListBuilder.create().texOffs(0, 63)
                        .addBox(-8.0F, 0.0F, -5.0F, 16.0F, 16.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 13.5F, 5.5F, -0.08726646259971647F, 0.0F, 0.0F));

        hair02.addOrReplaceChild("Hair03",
                CubeListBuilder.create().texOffs(0, 40)
                        .addBox(-8.0F, 0.0F, -4.5F, 16.0F, 15.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 12.5F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(50, 81)
                        .addBox(-8.0F, -8.0F, -7.4F, 16.0F, 12.0F, 8.0F),
                PartPose.offset(0.0F, -7.5F, 0.4F));

        PartDefinition hairL01 = hair.addOrReplaceChild("HairL01",
                CubeListBuilder.create().texOffs(24, 88)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 5.0F),
                PartPose.offsetAndRotation(3.0F, 7.0F, -6.9F, -0.36425021489121656F,
                        0.9105382707654417F, -0.4553564018453205F));

        hairL01.addOrReplaceChild("HairL02",
                CubeListBuilder.create().texOffs(24, 88)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 2.5F, 2.0F, 0.17453292519943295F, -0.5235987755982988F,
                        0.17453292519943295F));

        PartDefinition hairR01 = hair.addOrReplaceChild("HairR01",
                CubeListBuilder.create().mirror().texOffs(24, 88)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(-5.5F, 8.0F, -7.0F, -0.13962634015954636F,
                        -0.4363323129985824F, -0.08726646259971647F));

        hairR01.addOrReplaceChild("HairR02",
                CubeListBuilder.create().mirror().texOffs(24, 88)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(0.3F, 10.0F, 0.0F, 0.17453292519943295F,
                        -0.08726646259971647F, 0.13962634015954636F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(39, 21)
                        .addBox(0.0F, -5.0F, -10.5F, 0.0F, 11.0F, 11.0F),
                PartPose.offsetAndRotation(-1.0F, -7.0F, -5.5F, 0.2617993877991494F,
                        0.6981317007977318F, 0.0F));

        hair.addOrReplaceChild("HairU01",
                CubeListBuilder.create().texOffs(50, 44)
                        .addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 7.0F),
                PartPose.offset(0.0F, -6.0F, -7.7F));

        bodyMain.addOrReplaceChild("BoobL2",
                CubeListBuilder.create().mirror().texOffs(65, 34)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(2.44F, -8.6F, -3.9F, -0.6981317007977318F,
                        -0.08726646259971647F, -0.06981317007977318F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().mirror().texOffs(2, 88)
                        .addBox(-2.0F, -1.0F, -2.5F, 5.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(7.8F, -9.7F, -0.7F, 0.20943951023931953F, 0.0F,
                        -0.3141592653589793F));

        armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().mirror().texOffs(2, 88)
                        .addBox(-5.0F, 0.0F, -5.0F, 5.0F, 11.0F, 5.0F),
                PartPose.offset(3.0F, 10.0F, 2.5F));

        bodyMain.addOrReplaceChild("BodyMain1",
                CubeListBuilder.create().texOffs(0, 106)
                        .addBox(-6.5F, -11.0F, -4.0F, 13.0F, 15.0F, 7.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("BoobR",
                CubeListBuilder.create().texOffs(34, 102)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(-3.2F, -8.6F, -3.9F, -0.6981317007977318F,
                        0.08726646259971647F, 0.06981317007977318F));

        bodyMain.addOrReplaceChild("Butt1",
                CubeListBuilder.create().texOffs(52, 66)
                        .addBox(-7.5F, 0.0F, -7.0F, 15.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 2.5F, 2.8F, 0.20943951023931953F, 0.0F, 0.0F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().texOffs(2, 88)
                        .addBox(-3.0F, -1.0F, -2.5F, 5.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(-7.8F, -9.7F, -0.7F, 0.0F, 0.0F, 0.20943951023931953F));

        armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().texOffs(2, 88)
                        .addBox(0.0F, 0.0F, -5.0F, 5.0F, 11.0F, 5.0F),
                PartPose.offset(-3.0F, 10.0F, 2.5F));

        bodyMain.addOrReplaceChild("BoobR2",
                CubeListBuilder.create().texOffs(106, 37)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(-2.44F, -8.6F, -3.9F, -0.6981317007977318F,
                        0.08726646259971647F, 0.06981317007977318F));

        bodyMain.addOrReplaceChild("BodyMain2",
                CubeListBuilder.create().texOffs(88, 0)
                        .addBox(-6.5F, -11.0F, -4.0F, 13.0F, 15.0F, 7.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("BoobL",
                CubeListBuilder.create().mirror().texOffs(34, 102)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(3.2F, -8.6F, -3.9F, -0.6981317007977318F,
                        -0.08726646259971647F, -0.06981317007977318F));

        bodyMain.addOrReplaceChild("Butt2",
                CubeListBuilder.create().texOffs(82, 22)
                        .addBox(-7.5F, 0.0F, -7.0F, 15.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 2.5F, 2.8F, 0.20943951023931953F, 0.0F, 0.0F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -11.0F, -3.0F));

        PartDefinition glowHead = glowBodyMain.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -11.8F, -0.5F));
        addDefaultFaceParts(glowHead);

        PartDefinition equipHeadBase = glowHead.addOrReplaceChild("EquipHeadBase",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offset(0.0F, -14.8F, 2.0F));

        equipHeadBase.addOrReplaceChild("EquipHead01",
                CubeListBuilder.create().texOffs(26, 9)
                        .addBox(0.0F, 0.0F, 0.0F, 12.0F, 7.0F, 16.0F),
                PartPose.offsetAndRotation(5.0F, -2.4F, -12.0F, 0.17453292519943295F,
                        -0.17453292519943295F, 0.13962634015954636F));

        equipHeadBase.addOrReplaceChild("EquipHead02",
                CubeListBuilder.create().mirror().texOffs(26, 9)
                        .addBox(-12.0F, 0.0F, 0.0F, 12.0F, 7.0F, 16.0F),
                PartPose.offsetAndRotation(-5.0F, -2.4F, -12.0F, 0.17453292519943295F,
                        0.17453292519943295F, -0.13962634015954636F));

        equipHeadBase.addOrReplaceChild("EquipHead03",
                CubeListBuilder.create().texOffs(35, 0)
                        .addBox(-6.5F, 0.0F, -6.5F, 13.0F, 7.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, -8.8F, -9.5F, -0.41887902047863906F,
                        2.408554367752175F, -0.28797932657906433F));

        equipHeadBase.addOrReplaceChild("EquipHead04",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 9.0F, 16.0F),
                PartPose.offsetAndRotation(0.0F, -8.5F, -4.0F, -0.5918411493512771F,
                        -0.7155849933176751F, 0.40980330836826856F));

        equipHeadBase.addOrReplaceChild("EquipHead05",
                CubeListBuilder.create().texOffs(0, 32)
                        .addBox(-5.5F, 0.0F, 0.0F, 11.0F, 4.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, -1.0F, -11.4F, 0.3141592653589793F, 0.0F, 0.0F));

        PartDefinition equipC01 = equipHeadBase.addOrReplaceChild("EquipC01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-4.5F, -8.0F, -6.5F, 9.0F, 7.0F, 11.0F),
                PartPose.offsetAndRotation(-3.0F, -2.0F, 5.0F, -0.4363323129985824F,
                        0.5235987755982988F, 0.0F));

        equipC01.addOrReplaceChild("EquipC02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, -15.0F, 2.0F, 2.0F, 15.0F),
                PartPose.offsetAndRotation(-1.0F, -6.5F, -5.0F, -0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition glowArmLeft01 = glowBodyMain.addOrReplaceChild("GlowArmLeft01",
                CubeListBuilder.create(),
                PartPose.offset(7.8F, -9.7F, -0.7F));

        PartDefinition glowArmLeft02 = glowArmLeft01.addOrReplaceChild("GlowArmLeft02",
                CubeListBuilder.create(),
                PartPose.offset(3.0F, 10.0F, 2.5F));

        PartDefinition equipT01a = glowArmLeft02.addOrReplaceChild("EquipT01a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.0F, -3.0F, -5.0F, 4.0F, 6.0F, 10.0F),
                PartPose.offsetAndRotation(-6.5F, 6.5F, -1.0F, 0.13962634015954636F, 0.0F, 0.0F));

        equipT01a.addOrReplaceChild("EquipT01b",
                CubeListBuilder.create().texOffs(0, 17)
                        .addBox(-2.5F, -3.5F, 0.0F, 5.0F, 7.0F, 8.0F),
                PartPose.offset(0.0F, 0.0F, -12.9F));

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

        boolean flag = !EmotionHelper.checkModelState(0, state);// head
        if (this.EquipHeadBase != null)
            this.EquipHeadBase.visible = !flag;

        flag = !EmotionHelper.checkModelState(1, state); // head cannon
        if (this.EquipC01 != null)
            this.EquipC01.visible = !flag;

        flag = !EmotionHelper.checkModelState(2, state); // cloth
        this.BodyMain1.visible = flag; // Outfit 1: visible when cloth state OFF (original: isHidden = !flag)
        this.Butt1.visible = flag;
        this.BoobL.visible = flag;
        this.BoobR.visible = flag;
        this.BodyMain2.visible = !flag;
        this.Butt2.visible = !flag;
        this.BoobL2.visible = !flag;
        this.BoobR2.visible = !flag;

        flag = !EmotionHelper.checkModelState(3, state); // weapon
        if (this.EquipT01a != null)
            this.EquipT01a.visible = !flag;
    }

    @Override
    public void syncRotationGlowPart() {
        this.BoobL2.xRot = this.BoobL.xRot;
        this.BoobR2.xRot = this.BoobR.xRot;
        this.Butt1.xRot = this.Butt.xRot;
        this.Butt2.xRot = this.Butt.xRot;
        this.GlowBodyMain.xRot = this.BodyMain.xRot;
        this.GlowBodyMain.yRot = this.BodyMain.yRot;
        this.GlowBodyMain.zRot = this.BodyMain.zRot;
        this.GlowHead.xRot = this.Head.xRot;
        this.GlowHead.yRot = this.Head.yRot;
        this.GlowHead.zRot = this.Head.zRot;
        this.GlowArmLeft01.xRot = this.ArmLeft01.xRot;
        this.GlowArmLeft01.yRot = this.ArmLeft01.yRot;
        this.GlowArmLeft01.zRot = this.ArmLeft01.zRot;
        this.GlowArmLeft02.xRot = this.ArmLeft02.xRot;
        this.GlowArmLeft02.yRot = this.ArmLeft02.yRot;
        this.GlowArmLeft02.zRot = this.ArmLeft02.zRot;
        if (this.EquipC01 != null)
            this.EquipC01.yRot = this.Head.yRot;
        if (this.EquipC02 != null)
            this.EquipC02.xRot = this.Head.xRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float angleX = Mth.cos(f2 * 0.08F);
        this.setFaceHungry(ent);
        // body
        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += angleX * 0.1F;
        this.Head.xRot = 0.5F;
        this.Head.yRot = 0F;
        this.BodyMain.xRot = 1.6F;
        // hair
        this.Hair01.xRot = 0.1F;
        this.Hair02.xRot = -0.5F;
        this.Hair03.xRot = -0.5F;
        // arm
        this.ArmLeft01.xRot = -1.6F;
        this.ArmLeft01.yRot = -0.15F - angleX * 0.05F;
        this.ArmRight01.xRot = -1.6F;
        this.ArmRight01.yRot = 0.15F + angleX * 0.05F;
        // leg
        this.LegLeft01.xRot = -1.6F;
        this.LegRight01.xRot = -1.6F;
        this.LegLeft01.yRot = -0.1F - angleX * 0.05F;
        this.LegRight01.yRot = 0.1F + angleX * 0.05F;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float angleX = Mth.cos(f2 * 0.08F);
        float angleX1 = Mth.cos(f2 * 0.1F + 0.3F + f * 0.5F);
        float angleX2 = Mth.cos(f2 * 0.1F + 0.6F + f * 0.5F);
        float angleX3 = Mth.cos(f2 * 0.1F + 0.9F + f * 0.5F);
        float angleAdd1 = Mth.cos(f * 0.7F) * f1 * 0.7F;
        float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.7F;
        float addk1;
        float addk2;
        float headX;
        float headZ;

        // 水上漂浮
        if (ent.getShipDepth(0) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        // head
        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += angleX * 0.05F + 0.025F;
        this.Head.xRot = f4 * 0.014F + 0.1047F;
        this.Head.yRot = f3 * 0.01F;
        this.Head.zRot = 0F;

        // boob
        this.BoobL.xRot = angleX * 0.08F - 0.76F;
        this.BoobR.xRot = angleX * 0.08F - 0.76F;
        // body
        this.Ahoke.yRot = angleX * 0.15F + 0.6F;
        this.BodyMain.xRot = -0.1047F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        this.Butt.xRot = 0.21F;
        // this.Butt.offsetZ = 0F;
        // hair
        this.Hair01.xRot = 0.209F;
        this.Hair01.zRot = 0F;
        this.Hair02.xRot = -0.087F;
        this.Hair02.zRot = 0F;
        this.Hair03.xRot = -0.139F;
        this.Hair03.zRot = 0F;
        this.HairL01.xRot = -0.3643F;
        this.HairL02.xRot = 0.1745F;
        this.HairR01.xRot = -0.1396F;
        this.HairR02.xRot = 0.1745F;
        this.HairL01.zRot = -0.4554F;
        this.HairL02.zRot = 0.1745F;
        this.HairR01.zRot = 0.06F;
        this.HairR02.zRot = -0.0596F;
        // arm
        this.ArmLeft01.xRot = 0.2094F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = -angleX * 0.05F - 0.3142F;
        this.ArmRight01.xRot = 0F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = angleX * 0.05F + 0.2094F;
        // leg
        addk1 = angleAdd1 * 0.6F - 0.157F;
        addk2 = angleAdd2 * 0.6F - 0.035F;
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.1F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.1F;
        // equip
        if (this.EquipT01a != null)
            this.EquipT01a.xRot = 0.14F;
        if (this.EquipT01a != null)
            this.EquipT01a.zRot = 0F;
        // this.EquipT01a.offsetX = 0F;
        // this.EquipT01a.offsetY = 0F;
        // this.EquipT01a.offsetZ = 0F;
        if (this.EquipC01 != null)
            this.EquipC01.yRot = this.Head.yRot + 0.5F;
        if (this.EquipC02 != null)
            this.EquipC02.xRot = this.Head.xRot;

        // sprinting
        if (ent.getIsSprinting() || f1 > 0.92F) { // 奔跑動作
            // body
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.05F;
            this.Head.xRot -= 1.1F;
            this.BodyMain.xRot = 1.2566F;
            // 胸部
            this.BoobL.xRot = angleAdd1 * 0.08F - 0.7F;
            this.BoobL.zRot = -0.07F;
            this.BoobR.xRot = angleAdd1 * 0.08F - 0.7F;
            this.BoobR.zRot = 0.07F;
            // arm
            this.ArmLeft01.xRot = -2.5133F;
            this.ArmLeft01.zRot = -0.22F;
            this.ArmRight01.xRot = -2.5133F;
            this.ArmRight01.zRot = 0.22F;
            // leg
            this.LegLeft01.zRot = 0.05F;
            this.LegRight01.zRot = -0.05F;
            // equip
            if (this.EquipT01a != null)
                this.EquipT01a.xRot = 1.2566F;
            if (this.EquipT01a != null)
                this.EquipT01a.zRot = -0.1885F;
            // this.EquipT01a.offsetX = -0.08F;
        } // end is sprinting

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        if (ent.getIsSneaking()) { // 潛行, 蹲下動作
            // Body
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.05F;
            this.Head.xRot -= 1.0472F;
            this.BodyMain.xRot = 1.0472F;
            this.Butt.xRot = -0.8378F;
            // hair
            this.Hair01.xRot -= 0.1F;
            this.Hair02.xRot -= 0.2F;
            this.Hair03.xRot -= 0.5F;
            this.HairR01.zRot -= 0.5F;
            this.HairR02.zRot -= 0.2F;
            // arm
            this.ArmLeft01.xRot = -0.7F;
            this.ArmLeft01.zRot = 0.2618F;
            this.ArmRight01.xRot = -0.7F;
            this.ArmRight01.zRot = -0.2618F;
            // leg
            addk1 -= 0.1F;
            addk2 -= 0.1F;
        } // end if sneaking

        // sitting riding
        if (ent.getIsSitting() && !ent.getIsRiding()) { // 騎乘動作
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                // 潛水深度
                // body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += angleX * 0.05F;
                this.Head.xRot *= 0.5F;
                this.Head.yRot *= 0.75F;
                this.Head.xRot += 0.5F;
                this.BodyMain.xRot = 1.6F;
                // arm
                this.ArmLeft01.xRot = -1.6F;
                this.ArmLeft01.yRot = -0.15F - angleX * 0.05F;
                this.ArmRight01.xRot = -1.6F;
                this.ArmRight01.yRot = 0.15F + angleX * 0.05F;
                // leg
                addk1 = -1.6F;
                addk2 = -1.6F;
                this.LegLeft01.yRot = -0.1F - angleX * 0.05F;
                this.LegRight01.yRot = 0.1F + angleX * 0.05F;
            } else {
                // body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.45F;
                this.Head.xRot -= 0.7F;
                this.BodyMain.xRot = 0.5236F;
                // arm
                this.ArmLeft01.xRot = -0.4F;
                this.ArmLeft01.zRot = 0.3146F;
                this.ArmRight01.xRot = -0.4F;
                this.ArmRight01.zRot = -0.3146F;
                // leg
                addk1 = -2.18F;
                addk2 = -2.18F;
                this.LegLeft01.yRot = -0.3491F;
                this.LegRight01.yRot = 0.3491F;
            }
        } // end sitting

        // attack
        if (ent.getAttackTick() > 41) {
            setFaceAttack(ent);
            // swing arm
            float ft = (50 - ent.getAttackTick()) + (f2 - (int) f2);
            ft *= 0.125F;
            float fa = Mth.cos(ft * ft * (float) Math.PI);
            float fb = Mth.cos(Mth.sqrt(ft) * (float) Math.PI);
            this.ArmLeft01.xRot += -fb * 80.0F * ((float) Math.PI / 180F) - 1.6F;
            this.ArmLeft01.yRot += fa * 20.0F * ((float) Math.PI / 180F);
            this.ArmLeft01.zRot += fb * 20.0F * ((float) Math.PI / 180F) + 0.4F;
            // equip
            // this.EquipT01a.offsetX = 0.2F;
            // this.EquipT01a.offsetY = 0.2F;
            // this.EquipT01a.offsetZ = -0.5F;
        } // end attack

        // 鬢毛調整
        headX = this.Head.xRot * -0.5F;
        headZ = this.Head.zRot * -0.5F;
        this.Hair01.xRot += angleX1 * 0.08F + headX;
        this.Hair02.xRot += -angleX2 * 0.08F + headX * 0.5F + 0.1F;
        this.Hair03.xRot += -angleX3 * 0.08F + headX * 0.5F + 0.1F;
        this.Hair01.zRot += headZ;
        this.Hair02.zRot += headZ * 0.5F;
        this.Hair03.zRot += headZ * 0.5F;
        this.HairL01.xRot += angleX * 0.04F + headX;
        this.HairL02.xRot += angleX * 0.05F + headX * 0.8F;
        this.HairR01.xRot += angleX * 0.04F + headX;
        this.HairR02.xRot += angleX * 0.05F + headX * 0.8F;
        this.HairL01.zRot += headZ;
        this.HairL02.zRot += headZ;
        this.HairR01.zRot += headZ * 2.5F;
        this.HairR02.zRot += headZ * 0.8F;

        // swing arm
        float f6 = ent.getSwingTime(f2 - (int) f2);
        if (f6 != 0F) {
            float f7 = Mth.sin(f6 * f6 * (float) Math.PI);
            float f8 = Mth.sin(Mth.sqrt(f6) * (float) Math.PI);
            this.ArmRight01.xRot += -f8 * 80.0F * ((float) Math.PI / 180F) - 0.3F;
            this.ArmRight01.yRot += -f7 * 20.0F * ((float) Math.PI / 180F) + 0.4F;
            this.ArmRight01.zRot += -f8 * 20.0F * ((float) Math.PI / 180F);
        }

        // leg motion
        this.LegLeft01.xRot = addk1;
        this.LegRight01.xRot = addk2;
    }
}
