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

public class ModelBattleshipHime extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "bb_hime"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Neck;
    private final ModelPart BoobR;
    private final ModelPart BoobL;
    private final ModelPart ArmLeft01;
    private final ModelPart ArmRight01;
    private final ModelPart Butt;
    private final ModelPart Cloth01;
    private final ModelPart Head;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart HeadHL;
    private final ModelPart HeadHR;
    private final ModelPart Ahoke;
    private final ModelPart HairL01;
    private final ModelPart HairR01;
    private final ModelPart HairL02;
    private final ModelPart HairL03;
    private final ModelPart HairR02;
    private final ModelPart HairR03;
    private final ModelPart Hair01;
    private final ModelPart Hair02;
    private final ModelPart Hair03;
    private final ModelPart ArmLeft02;
    private final ModelPart ArmRight02;
    private final ModelPart LegRight01;
    private final ModelPart LegLeft01;
    private final ModelPart LegRight02;
    private final ModelPart ClothR02;
    private final ModelPart ClothR03;
    private final ModelPart LegLeft02;
    private final ModelPart ClothL02;
    private final ModelPart ClothL03;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowNeck;
    private final ModelPart GlowHead;

    public ModelBattleshipHime(ModelPart root) {
        super();
        this.scale = 0.5F;
        this.offsetY = 0F;
        this.BodyMain = root.getChild("BodyMain");
        this.BoobR = this.BodyMain.getChild("BoobR");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.BoobL = this.BodyMain.getChild("BoobL");
        this.Butt = this.BodyMain.getChild("Butt");
        this.Cloth01 = this.BodyMain.getChild("Cloth01");
        this.Neck = this.BodyMain.getChild("Neck");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.LegLeft01 = this.Butt.getChild("LegLeft01");
        this.LegRight01 = this.Butt.getChild("LegRight01");
        this.Head = this.Neck.getChild("Head");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.ClothL02 = this.LegLeft01.getChild("ClothL02");
        this.ClothL03 = this.LegLeft01.getChild("ClothL03");
        this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
        this.ClothR02 = this.LegRight01.getChild("ClothR02");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.ClothR03 = this.LegRight01.getChild("ClothR03");
        this.Hair = this.Head.getChild("Hair");
        this.HeadHL = this.Head.getChild("HeadHL");
        this.HairMain = this.Head.getChild("HairMain");
        this.HeadHR = this.Head.getChild("HeadHR");
        this.HairR01 = this.Hair.getChild("HairR01");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.HairL01 = this.Hair.getChild("HairL01");
        this.Hair01 = this.HairMain.getChild("Hair01");
        this.HairR02 = this.HairR01.getChild("HairR02");
        this.HairL02 = this.HairL01.getChild("HairL02");
        this.Hair02 = this.Hair01.getChild("Hair02");
        this.HairR03 = this.HairR02.getChild("HairR03");
        this.HairL03 = this.HairL02.getChild("HairL03");
        this.Hair03 = this.Hair02.getChild("Hair03");

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
                PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.05235987755982988F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("BoobR",
                CubeListBuilder.create().texOffs(33, 101)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(-3.7F, -9.0F, -3.5F, -0.6981317007977318F, -0.13962634015954636F,
                        -0.08726646259971647F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().mirror().texOffs(15, 80)
                        .addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.0F, 0.0F, -0.20943951023931953F));

        armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().mirror().texOffs(0, 71)
                        .addBox(-5.0F, 0.0F, -5.0F, 5.0F, 13.0F, 5.0F),
                PartPose.offset(3.0F, 11.0F, 2.5F));

        bodyMain.addOrReplaceChild("BoobL",
                CubeListBuilder.create().mirror().texOffs(33, 101)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(3.7F, -9.0F, -3.5F, -0.6981317007977318F, 0.13962634015954636F,
                        0.08726646259971647F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(82, 13)
                        .addBox(-7.5F, 4.0F, -5.5F, 15.0F, 8.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().mirror().texOffs(0, 84)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(4.5F, 9.5F, -2.7F, -0.20943951023931953F, 0.0F, 0.05235987755982988F));

        legLeft01.addOrReplaceChild("ClothL02",
                CubeListBuilder.create().texOffs(10, 1)
                        .addBox(-4.4F, 0.0F, -3.7F, 8.0F, 3.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.13962634015954636F, 0.0F, 0.0F));

        legLeft01.addOrReplaceChild("ClothL03",
                CubeListBuilder.create().texOffs(8, 0)
                        .addBox(-4.5F, 0.0F, -3.8F, 9.0F, 5.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 1.5F, 0.1F, 0.08726646259971647F, 0.0F, 0.0F));

        legLeft01.addOrReplaceChild("LegLeft02",
                CubeListBuilder.create().mirror().texOffs(24, 80)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                PartPose.offset(0.0F, 14.0F, -3.0F));

        PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().texOffs(0, 84)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(-4.5F, 9.5F, -2.7F, -0.20943951023931953F, 0.0F, -0.05235987755982988F));

        legRight01.addOrReplaceChild("ClothR02",
                CubeListBuilder.create().texOffs(10, 1)
                        .addBox(-3.6F, 0.0F, -3.7F, 8.0F, 3.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.13962634015954636F, 0.0F, 0.0F));

        legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().texOffs(24, 80)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F),
                PartPose.offset(0.0F, 14.0F, -3.0F));

        legRight01.addOrReplaceChild("ClothR03",
                CubeListBuilder.create().texOffs(8, 0)
                        .addBox(-4.5F, 0.0F, -3.8F, 9.0F, 5.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 1.5F, 0.1F, 0.08726646259971647F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("Cloth01",
                CubeListBuilder.create().texOffs(84, 0)
                        .addBox(-7.0F, 0.0F, -4.5F, 14.0F, 5.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.13962634015954636F, 0.0F, 0.0F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(44, 0)
                        .addBox(-4.5F, -2.0F, -4.0F, 9.0F, 1.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, -10.0F, -0.5F, 0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offset(0.0F, -1.5F, 0.0F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(50, 75)
                        .addBox(-8.0F, -8.0F, -7.2F, 16.0F, 17.0F, 8.0F),
                PartPose.offset(0.0F, -7.5F, 0.0F));

        PartDefinition hairR01 = hair.addOrReplaceChild("HairR01",
                CubeListBuilder.create().texOffs(88, 100)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 3.0F),
                PartPose.offsetAndRotation(-6.5F, 0.0F, -5.0F, -0.13962634015954636F, 0.17453292519943295F,
                        0.13962634015954636F));

        PartDefinition hairR02 = hairR01.addOrReplaceChild("HairR02",
                CubeListBuilder.create().texOffs(88, 100)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 3.0F),
                PartPose.offsetAndRotation(0.2F, 10.0F, 0.0F, 0.08726646259971647F, 0.0F, -0.05235987755982988F));

        hairR02.addOrReplaceChild("HairR03",
                CubeListBuilder.create().texOffs(88, 100)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 13.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 11.0F, 0.0F, 0.13962634015954636F, 0.0F, -0.05235987755982988F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(108, 41)
                        .addBox(-2.0F, 0.0F, 0.0F, 10.0F, 12.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, -5.3F, -7.2F, -0.05235987755982988F, 0.0F, -0.03490658503988659F));

        PartDefinition hairL01 = hair.addOrReplaceChild("HairL01",
                CubeListBuilder.create().texOffs(88, 100)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 3.0F),
                PartPose.offsetAndRotation(6.5F, 0.0F, -5.0F, -0.13962634015954636F, -0.17453292519943295F,
                        -0.13962634015954636F));

        PartDefinition hairL02 = hairL01.addOrReplaceChild("HairL02",
                CubeListBuilder.create().texOffs(88, 100)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.05235987755982988F, 0.0F, 0.08726646259971647F));

        hairL02.addOrReplaceChild("HairL03",
                CubeListBuilder.create().texOffs(88, 100)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 13.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 11.0F, 0.0F, 0.13962634015954636F, 0.0F, 0.08726646259971647F));

        head.addOrReplaceChild("HeadHL",
                CubeListBuilder.create().mirror().texOffs(120, 29)
                        .addBox(-1.0F, -9.0F, -1.0F, 2.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(3.5F, -7.5F, -3.3F, 0.6981317007977318F, 0.0F, 0.13962634015954636F));

        PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(2, 0)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 9.0F, 10.0F),
                PartPose.offset(0.0F, -15.0F, -3.0F));

        PartDefinition hair01 = hairMain.addOrReplaceChild("Hair01",
                CubeListBuilder.create().texOffs(50, 46)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 17.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 9.0F, 1.0F, 0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition hair02 = hair01.addOrReplaceChild("Hair02",
                CubeListBuilder.create().texOffs(2, 47)
                        .addBox(-8.0F, 0.0F, -5.0F, 16.0F, 15.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 12.0F, 5.7F, -0.05235987755982988F, 0.0F, 0.0F));

        hair02.addOrReplaceChild("Hair03",
                CubeListBuilder.create().texOffs(3, 24)
                        .addBox(-8.0F, 0.0F, -5.5F, 16.0F, 13.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 12.0F, 0.2F, -0.08970992355250852F, 0.0F, 0.016231562043547264F));

        head.addOrReplaceChild("HeadHR",
                CubeListBuilder.create().texOffs(120, 29)
                        .addBox(-1.0F, -9.0F, -1.0F, 2.0F, 5.0F, 2.0F),
                PartPose.offsetAndRotation(-3.5F, -7.5F, -3.3F, 0.6981317007977318F, 0.0F, -0.13962634015954636F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().texOffs(15, 80)
                        .addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, 0.10471975511965977F, 0.0F, 0.20943951023931953F));

        armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().texOffs(0, 71)
                        .addBox(0.0F, 0.0F, -5.0F, 5.0F, 13.0F, 5.0F),
                PartPose.offset(-3.0F, 11.0F, 2.5F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -15.0F, 0.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -10.0F, -0.5F));

        PartDefinition glowHead = glowNeck.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -1.5F, 0.0F));
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

    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float addk1;
        float addk2;
        float headX;
        float headZ;
        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += 1.05F;
        this.setFaceHungry(ent);

        // 移動頭部使其看人
        this.Head.xRot = 0F; // 上下角度
        this.Head.yRot = 0F; // 左右角度 角度轉成rad 即除以57.29578
        this.Head.zRot = 0F;
        // 正常站立動作
        // 胸部
        this.BoobL.xRot = -0.7F;
        this.BoobR.xRot = -0.7F;
        // Body
        this.BodyMain.zRot = 0F;
        // hair
        this.Hair01.xRot = 0.26F;
        this.Hair02.xRot = -0.08F;
        this.Hair03.xRot = -0.14F;
        // arm
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft02.xRot = 0F;
        // this.ArmLeft02.offsetX = 0F;
        // this.ArmLeft02.offsetY = 0F;
        // this.ArmLeft02.offsetZ = 0F;
        this.ArmRight02.xRot = 0F;
        // this.ArmRight02.offsetX = 0F;
        // this.ArmRight02.offsetY = 0F;
        // this.ArmRight02.offsetZ = 0F;
        // leg
        this.LegLeft01.yRot = 0F;
        this.LegRight01.yRot = 0F;

        // Body
        this.Head.xRot += 0.14F;
        this.BodyMain.xRot = 0.4F;
        this.Butt.xRot = -0.4F;
        // this.Butt.offsetZ = 0.19F;
        this.BoobL.xRot -= 0.2F;
        this.BoobR.xRot -= 0.2F;
        // arm
        this.ArmLeft01.xRot = -1.3F;
        this.ArmLeft01.zRot = -0.1F;
        this.ArmLeft02.zRot = 1.15F;
        this.ArmRight01.xRot = -1.3F;
        this.ArmRight01.zRot = 0.1F;
        this.ArmRight02.zRot = -1.4F;
        // leg
        addk1 = -2.1232F;
        addk2 = -2.0708F;
        this.LegLeft01.zRot = -0.2F;
        this.LegLeft02.xRot = 1.34F;
        this.LegRight01.zRot = 0.2F;
        this.LegRight02.xRot = 1.13F;
        // hair
        this.Hair01.xRot -= 0.2F;
        this.Hair02.xRot -= 0.2F;
        this.Hair03.xRot -= 0.1F;

        // 移動頭髮避免穿過身體
        headZ = this.Head.zRot * -0.5F;
        this.Hair01.zRot = headZ;
        this.Hair02.zRot = headZ;
        this.HairL01.zRot = headZ - 0.0F;
        this.HairL02.zRot = headZ + 0.087F;
        this.HairR01.zRot = headZ + 0.0F;
        this.HairR02.zRot = headZ - 0.052F;

        headX = this.Head.xRot * -0.5F;
        this.HairL01.xRot = headX - 0.1F;
        this.HairL02.xRot = headX - 0.3F;
        this.HairL03.xRot = headX - 0.0F;
        this.HairR01.xRot = headX - 0.1F;
        this.HairR02.xRot = headX - 0.3F;
        this.HairR03.xRot = headX - 0.0F;

        // leg motion
        this.LegLeft01.xRot = addk1;
        this.LegRight01.xRot = addk2;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float angleX = Mth.cos(f2 * 0.08F);
        float angleX1 = Mth.cos(f2 * 0.08F + 0.3F + f * 0.5F);
        float angleX2 = Mth.cos(f2 * 0.08F + 0.6F + f * 0.5F);
        float angleAdd1 = Mth.cos(f * 0.7F) * f1 * 0.7F;
        float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.7F;
        float addk1;
        float addk2;
        float headX;
        float headZ;

        // 水上漂浮
        if (ent.getShipDepth(0) > 0D || ent.getShipDepth(1) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        // leg move parm
        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += 0.5F;
        addk1 = angleAdd1 - 0.122F;
        addk2 = angleAdd2 - 0.174F;

        // 移動頭部使其看人
        this.Head.xRot = f4 * 0.014F + 0.05F; // 上下角度
        this.Head.yRot = f3 * 0.01F;
        // 正常站立動作
        // 胸部
        this.BoobL.xRot = angleX * 0.06F - 0.7F;
        this.BoobR.xRot = angleX * 0.06F - 0.7F;
        // Body
        this.Ahoke.zRot = angleX * 0.02F - 0.02F;
        this.BodyMain.xRot = -0.1F;
        this.Butt.xRot = 0.2618F;
        // this.Butt.offsetZ = 0F;
        // hair
        this.Hair01.xRot = angleX * 0.03F + 0.15F;
        this.Hair02.xRot = -angleX1 * 0.04F - 0.05F;
        this.Hair03.xRot = -angleX2 * 0.07F - 0.08F;
        this.Hair01.zRot = 0F;
        this.Hair02.zRot = 0F;
        this.Hair03.zRot = 0F;
        this.HairL01.xRot = angleX * 0.02F - 0.14F;
        this.HairL02.xRot = -angleX1 * 0.04F + 0.08F;
        this.HairL03.xRot = -angleX2 * 0.07F + 0.1F;
        this.HairR01.xRot = angleX * 0.02F - 0.14F;
        this.HairR02.xRot = -angleX1 * 0.04F + 0.08F;
        this.HairR03.xRot = -angleX2 * 0.07F + 0.1F;
        this.HairL01.zRot = -0.14F;
        this.HairL02.zRot = 0.087F;
        this.HairL03.zRot = 0.087F;
        this.HairR01.zRot = 0.14F;
        this.HairR02.zRot = -0.06F;
        this.HairR03.zRot = -0.06F;
        // arm
        this.ArmLeft01.xRot = angleAdd2 * 0.8F;
        this.ArmLeft01.zRot = angleX * 0.08F - 0.2F;
        this.ArmLeft02.xRot = 0F;
        this.ArmLeft02.zRot = 0F;
        // this.ArmLeft02.offsetX = 0F;
        // this.ArmLeft02.offsetY = 0F;
        // this.ArmLeft02.offsetZ = 0F;
        this.ArmRight01.xRot = angleAdd1 * 0.8F + 0.1745F;
        this.ArmRight01.zRot = -angleX * 0.08F + 0.2F;
        this.ArmRight02.xRot = 0F;
        this.ArmRight02.yRot = 0F;
        this.ArmRight02.zRot = 0F;
        // this.ArmRight02.offsetX = 0F;
        // this.ArmRight02.offsetY = 0F;
        // this.ArmRight02.offsetZ = 0F;
        // leg
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.087F;
        this.LegLeft02.xRot = 0F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.087F;
        this.LegRight02.xRot = 0F;

        // 奔跑動作
        ent.getIsSprinting();
        // 沒有特殊跑步動作


        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        // 潛行, 蹲下動作
        if (ent.getIsSneaking()) {
            // Body
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.08F;
            this.Head.xRot -= 0.6283F;
            this.BodyMain.xRot = 0.8727F;
            // arm
            this.ArmLeft01.xRot = -0.35F;
            this.ArmLeft01.zRot = 0.2618F;
            this.ArmRight01.xRot = -0.35F;
            this.ArmRight01.zRot = -0.2618F;
            // leg
            addk1 -= 0.88F;
            addk2 -= 0.88F;
            // hair
            this.Hair01.xRot += 0.37F;
            this.Hair02.xRot += 0.23F;
            this.Hair03.xRot -= 0.1F;
        } // end if sneaking

        // 騎乘動作
        if (ent.getIsSitting() && !ent.getIsRiding()) {
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                // Body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.65F;
                this.Head.xRot = -1.2217F;
                this.Head.yRot = this.Head.yRot * 0.5F;
                this.BodyMain.xRot = 1.2217F;
                // arm
                this.ArmLeft01.xRot = -1.9199F;
                this.ArmLeft01.zRot = -0.1745F;
                this.ArmLeft02.xRot = -2.31F;
                // this.ArmLeft02.offsetY = 0.22F;
                // this.ArmLeft02.offsetZ = -0.21F;
                this.ArmRight01.xRot = -1.9199F;
                this.ArmRight01.zRot = 0.1745F;
                this.ArmRight02.xRot = -2.31F;
                // this.ArmRight02.offsetY = 0.22F;
                // this.ArmRight02.offsetZ = -0.21F;
                // leg
                addk1 = 0F;
                addk2 = 0F;
                this.LegLeft02.xRot = angleX * 0.4F + 1F;
                this.LegRight02.xRot = -angleX * 0.4F + 1F;
                // hair
                this.Hair01.xRot += 0.1F;
                this.Hair02.xRot += 0.05F;
                this.HairL01.xRot -= 0.3F;
                this.HairR01.xRot -= 0.3F;
                this.HairL02.xRot += 0.3F;
                this.HairR02.xRot += 0.3F;
            } else {
                // Body
                this.Head.xRot += 0.14F;
                this.BodyMain.xRot = -0.4363F;
                this.BoobL.xRot -= 0.25F;
                this.BoobR.xRot -= 0.25F;
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
                this.Hair03.xRot += 0.25F;
            }
        } // end sitting

        if (ent.getIsRiding()) {
            if (((net.minecraft.world.entity.Entity) ent).getVehicle() instanceof BasicEntityMount) {
                if (ent.getIsSitting()) {
                    if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                        // Body
                        this.Head.xRot = -1.2217F;
                        this.Head.yRot = this.Head.yRot / 2F;
                        this.BodyMain.xRot = 1.2217F;
                        // arm
                        this.ArmLeft01.xRot = -1.9199F;
                        this.ArmLeft01.zRot = -0.1745F;
                        this.ArmLeft02.xRot = -2.31F;
                        // this.ArmLeft02.offsetY = 0.22F;
                        // this.ArmLeft02.offsetZ = -0.21F;
                        this.ArmRight01.xRot = -1.9199F;
                        this.ArmRight01.zRot = 0.1745F;
                        this.ArmRight02.xRot = -2.31F;
                        // this.ArmRight02.offsetY = 0.22F;
                        // this.ArmRight02.offsetZ = -0.21F;
                        // leg
                        addk1 = 0F;
                        addk2 = 0F;
                        this.LegLeft02.xRot = angleX * 0.4F + 1F;
                        this.LegRight02.xRot = -angleX * 0.4F + 1F;
                        // hair
                        this.Hair01.xRot += 0.1F;
                        this.Hair02.xRot += 0.05F;
                        this.HairL01.xRot -= 0.3F;
                        this.HairR01.xRot -= 0.3F;
                        this.HairL02.xRot += 0.3F;
                        this.HairR02.xRot += 0.3F;
                    } else {
                        // Body
                        this.Head.xRot += 0.14F;
                        this.BodyMain.xRot = -0.4363F;
                        this.BoobL.xRot -= 0.25F;
                        this.BoobR.xRot -= 0.25F;
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
                        this.Hair03.xRot += 0.25F;
                    }
                } // end if sitting
                else {
                    // Body
                    // [PORT] Restored from 1.10.2 GlStateManager.translate
                    this.offsetY += 0.17F;
                    this.Head.xRot += 0.1745F;
                    this.BodyMain.xRot = -0.35F;
                    // arm
                    this.ArmLeft01.xRot = -0.2F;
                    this.ArmLeft01.zRot = 0.3490F;
                    this.ArmLeft02.zRot = 1.15F;
                    this.ArmRight01.xRot = -0.3F;
                    this.ArmRight01.zRot = -0.2793F;
                    this.ArmRight02.zRot = -1.4F;
                    // leg
                    addk1 = 0.1745F;
                    addk2 = -0.8727F;
                    this.LegLeft01.zRot = -0.1F;
                    this.LegRight01.zRot = 0.1F;
                    this.LegRight02.xRot = 1.0472F;
                    // hair
                    this.Hair01.xRot += 0.12F;
                    this.Hair02.xRot += 0.22F;
                    this.Hair03.xRot += 0.25F;
                }
            } // end ship mount
            else { // normal mount ex: cart
                if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                    // Body
                    this.Head.xRot = -1.2217F;
                    this.Head.yRot = this.Head.yRot / 2F;
                    this.BodyMain.xRot = 1.2217F;
                    // arm
                    this.ArmLeft01.xRot = -1.9199F;
                    this.ArmLeft01.zRot = -0.1745F;
                    this.ArmLeft02.xRot = -2.31F;
                    // this.ArmLeft02.offsetY = 0.22F;
                    // this.ArmLeft02.offsetZ = -0.21F;
                    this.ArmRight01.xRot = -1.9199F;
                    this.ArmRight01.zRot = 0.1745F;
                    this.ArmRight02.xRot = -2.31F;
                    // this.ArmRight02.offsetY = 0.22F;
                    // this.ArmRight02.offsetZ = -0.21F;
                    // leg
                    addk1 = 0F;
                    addk2 = 0F;
                    this.LegLeft02.xRot = angleX * 0.4F + 1F;
                    this.LegRight02.xRot = -angleX * 0.4F + 1F;
                    // hair
                    this.Hair01.xRot += 0.1F;
                    this.Hair02.xRot += 0.05F;
                    this.HairL01.xRot -= 0.3F;
                    this.HairR01.xRot -= 0.3F;
                    this.HairL02.xRot += 0.3F;
                    this.HairR02.xRot += 0.3F;
                } else {
                    // Body
                    this.Head.xRot += 0.14F;
                    this.BodyMain.xRot = -0.4363F;
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
                    this.Hair03.xRot += 0.25F;
                }
            }
        } // end ridding

        // 攻擊動作
        if (ent.getAttackTick() > 20) {
            // arm
            this.ArmLeft01.xRot = -1.6F;
            this.ArmLeft01.yRot = 0F;
            this.ArmLeft01.zRot = 0.21F;
            this.ArmLeft02.xRot = 0F;
            this.ArmLeft02.zRot = 0F;
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
            this.ArmRight02.xRot = 0F;
            this.ArmRight02.yRot = 0F;
            this.ArmRight02.zRot = 0F;
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
        this.HairL01.xRot += headX;
        this.HairL02.xRot += headX * 0.5F;
        this.HairL03.xRot += headX * 0.5F;
        this.HairR01.xRot += headX;
        this.HairR02.xRot += headX * 0.5F;
        this.HairR03.xRot += headX * 0.5F;
        this.HairL01.zRot += headZ;
        this.HairL02.zRot += headZ * 0.5F;
        this.HairL03.zRot += headZ * 0.5F;
        this.HairR01.zRot += headZ;
        this.HairR02.zRot += headZ * 0.5F;
        this.HairR03.zRot += headZ * 0.5F;

        // leg motion
        this.LegLeft01.xRot = addk1;
        this.LegRight01.xRot = addk2;
    }
}
