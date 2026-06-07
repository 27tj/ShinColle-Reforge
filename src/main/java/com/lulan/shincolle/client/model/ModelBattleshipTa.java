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

public class ModelBattleshipTa extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "bb_ta"), "main");

    private final ModelPart BodyMain;
    private final ModelPart NeckCloth;
    private final ModelPart BoobR;
    private final ModelPart BoobL;
    private final ModelPart ArmLeft01;
    private final ModelPart ArmRight01;
    private final ModelPart Butt;
    private final ModelPart EquipLeft;
    private final ModelPart EquipRight;
    private final ModelPart Cloak01;
    private final ModelPart Head;
    private final ModelPart NeckTie;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart Ahoke;
    private final ModelPart HairL01;
    private final ModelPart HairR01;
    private final ModelPart HairL02;
    private final ModelPart HairR02;
    private final ModelPart HairMidL01;
    private final ModelPart HairMidL02;
    private final ModelPart ArmLeft02;
    private final ModelPart ArmRight02;
    private final ModelPart LegRight;
    private final ModelPart LegLeft;
    private final ModelPart ShoesR;
    private final ModelPart ShoesL;
    private final ModelPart Cloak02;
    private final ModelPart Cloak03;
    private final ModelPart Cloak04;
    private final ModelPart Cloak05;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowNeckCloth;
    private final ModelPart GlowHead;

    public ModelBattleshipTa(ModelPart root) {
        super();
        this.scale = 0.46F;
        this.offsetY = 1.78F;
        this.BodyMain = root.getChild("BodyMain");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.EquipLeft = this.BodyMain.getChild("EquipLeft");
        this.BoobR = this.BodyMain.getChild("BoobR");
        this.Butt = this.BodyMain.getChild("Butt");
        this.NeckCloth = this.BodyMain.getChild("NeckCloth");
        this.Cloak01 = this.BodyMain.getChild("Cloak01");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.BoobL = this.BodyMain.getChild("BoobL");
        this.EquipRight = this.BodyMain.getChild("EquipRight");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.LegRight = this.Butt.getChild("LegRight");
        this.LegLeft = this.Butt.getChild("LegLeft");
        this.Head = this.NeckCloth.getChild("Head");
        this.NeckTie = this.NeckCloth.getChild("NeckTie");
        this.Cloak02 = this.Cloak01.getChild("Cloak02");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.ShoesR = this.LegRight.getChild("ShoesR");
        this.ShoesL = this.LegLeft.getChild("ShoesL");
        this.HairMain = this.Head.getChild("HairMain");
        this.Hair = this.Head.getChild("Hair");
        this.Cloak03 = this.Cloak02.getChild("Cloak03");
        this.HairMidL01 = this.HairMain.getChild("HairMidL01");
        this.HairL01 = this.Hair.getChild("HairL01");
        this.HairR01 = this.Hair.getChild("HairR01");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.Cloak04 = this.Cloak03.getChild("Cloak04");
        this.HairMidL02 = this.HairMidL01.getChild("HairMidL02");
        this.HairL02 = this.HairL01.getChild("HairL02");
        this.HairR02 = this.HairR01.getChild("HairR02");
        this.Cloak05 = this.Cloak04.getChild("Cloak05");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowNeckCloth = this.GlowBodyMain.getChild("GlowNeckCloth");
        this.GlowHead = this.GlowNeckCloth.getChild("GlowHead");
        this.loadFaceParts(this.GlowHead);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 104)
                        .addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F),
                PartPose.offset(0.0F, -12.0F, 0.0F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().texOffs(24, 56)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F),
                PartPose.offsetAndRotation(-7.0F, -10.5F, 0.0F, 0.0F, 0.0F, 0.15707963267948966F));

        armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().texOffs(0, 56)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 13.0F, 5.0F),
                PartPose.offset(0.0F, 9.0F, 0.0F));

        bodyMain.addOrReplaceChild("EquipLeft",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 14.0F, 6.0F, 10.0F),
                PartPose.offsetAndRotation(9.0F, -13.0F, -6.0F, 0.0F, -0.13962634015954636F,
                        0.2617993877991494F));

        bodyMain.addOrReplaceChild("BoobR",
                CubeListBuilder.create().texOffs(0, 74)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 4.0F),
                PartPose.offsetAndRotation(-3.8F, -9.0F, -3.5F, -0.7853981633974483F,
                        -0.17453292519943295F, -0.08726646259971647F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(0, 19)
                        .addBox(-8.0F, 4.0F, -5.5F, 16.0F, 8.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition legRight = butt.addOrReplaceChild("LegRight",
                CubeListBuilder.create().texOffs(0, 91)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F),
                PartPose.offsetAndRotation(-4.5F, 9.5F, -3.0F, -0.2617993877991494F, 0.0F,
                        -0.05235987755982988F));

        legRight.addOrReplaceChild("ShoesR",
                CubeListBuilder.create().texOffs(22, 71)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 19.0F, 7.0F),
                PartPose.offset(0.0F, 7.0F, -0.2F));

        PartDefinition legLeft = butt.addOrReplaceChild("LegLeft",
                CubeListBuilder.create().mirror().texOffs(0, 91)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F),
                PartPose.offsetAndRotation(4.5F, 9.5F, -3.0F, -0.2617993877991494F, 0.0F,
                        0.05235987755982988F));

        legLeft.addOrReplaceChild("ShoesL",
                CubeListBuilder.create().mirror().texOffs(22, 71)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 19.0F, 7.0F),
                PartPose.offset(0.0F, 7.0F, -0.2F));

        PartDefinition neckCloth = bodyMain.addOrReplaceChild("NeckCloth",
                CubeListBuilder.create().texOffs(46, 14)
                        .addBox(-7.5F, -1.5F, -4.5F, 15.0F, 12.0F, 8.0F),
                PartPose.offset(0.0F, -10.0F, 0.0F));

        PartDefinition head = neckCloth.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offset(0.0F, -1.5F, 0.0F));

        PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(48, 56)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 9.0F, 10.0F),
                PartPose.offset(0.0F, -15.0F, -3.0F));

        PartDefinition hairMidL01 = hairMain.addOrReplaceChild("HairMidL01",
                CubeListBuilder.create().texOffs(48, 34)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 13.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 9.0F, 1.5F, 0.2617993877991494F, 0.0F, 0.0F));

        hairMidL01.addOrReplaceChild("HairMidL02",
                CubeListBuilder.create().texOffs(0, 34)
                        .addBox(-7.0F, 0.0F, 0.0F, 14.0F, 14.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 9.0F, 1.8F, -0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(50, 75)
                        .addBox(-8.0F, -8.0F, -7.2F, 16.0F, 17.0F, 8.0F),
                PartPose.offset(0.0F, -7.5F, 0.0F));

        PartDefinition hairL01 = hair.addOrReplaceChild("HairL01",
                CubeListBuilder.create().texOffs(88, 100)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 3.0F),
                PartPose.offsetAndRotation(6.5F, 0.0F, -6.0F, -0.17453292519943295F,
                        -0.17453292519943295F, -0.05235987755982988F));

        hairL01.addOrReplaceChild("HairL02",
                CubeListBuilder.create().texOffs(89, 103)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.2617993877991494F, 0.0F,
                        0.05235987755982988F));

        PartDefinition hairR01 = hair.addOrReplaceChild("HairR01",
                CubeListBuilder.create().texOffs(88, 100)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 3.0F),
                PartPose.offsetAndRotation(-6.5F, 0.0F, -6.0F, -0.13962634015954636F,
                        0.17453292519943295F, 0.08726646259971647F));

        hairR01.addOrReplaceChild("HairR02",
                CubeListBuilder.create().texOffs(89, 103)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 2.0F),
                PartPose.offsetAndRotation(0.2F, 7.0F, 0.5F, 0.17453292519943295F, 0.0F,
                        -0.05235987755982988F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(37, 101)
                        .addBox(-4.5F, 0.0F, 0.0F, 10.0F, 10.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, -7.3F, -7.5F, -0.136659280431156F,
                        -0.22759093446006054F, 0.0F));

        neckCloth.addOrReplaceChild("NeckTie",
                CubeListBuilder.create().texOffs(24, 97)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 7.0F, 0.0F),
                PartPose.offsetAndRotation(0.5F, 1.3F, -5.2F, -0.7F, 0.13962634015954636F,
                        0.13962634015954636F));

        PartDefinition cloak01 = bodyMain.addOrReplaceChild("Cloak01",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-11.5F, 0.0F, 0.0F, 23.0F, 5.0F, 10.0F),
                PartPose.offset(0.0F, -10.0F, -4.4F));

        PartDefinition cloak02 = cloak01.addOrReplaceChild("Cloak02",
                CubeListBuilder.create().texOffs(128, 15)
                        .addBox(-12.0F, 0.0F, 0.0F, 24.0F, 6.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 5.0F, 0.3F, 0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition cloak03 = cloak02.addOrReplaceChild("Cloak03",
                CubeListBuilder.create().texOffs(128, 31)
                        .addBox(-12.5F, 0.0F, 0.0F, 25.0F, 7.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 5.0F, 0.3F, 0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition cloak04 = cloak03.addOrReplaceChild("Cloak04",
                CubeListBuilder.create().texOffs(128, 48)
                        .addBox(-13.5F, 0.0F, 0.0F, 27.0F, 8.0F, 11.0F),
                PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.08726646259971647F, 0.0F, 0.0F));

        cloak04.addOrReplaceChild("Cloak05",
                CubeListBuilder.create().texOffs(128, 67)
                        .addBox(-14.5F, 0.0F, 0.0F, 29.0F, 9.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().mirror().texOffs(24, 56)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F),
                PartPose.offsetAndRotation(7.0F, -10.5F, 0.0F, 0.0F, 0.0F, -0.15707963267948966F));

        armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().texOffs(0, 56)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 13.0F, 5.0F),
                PartPose.offset(0.0F, 9.0F, 0.0F));

        bodyMain.addOrReplaceChild("BoobL",
                CubeListBuilder.create().mirror().texOffs(0, 74)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 4.0F),
                PartPose.offsetAndRotation(3.8F, -9.0F, -3.5F, -0.7853981633974483F,
                        0.17453292519943295F, 0.08726646259971647F));

        bodyMain.addOrReplaceChild("EquipRight",
                CubeListBuilder.create().texOffs(38, 0)
                        .addBox(-12.0F, 0.0F, 0.0F, 12.0F, 3.0F, 3.0F),
                PartPose.offsetAndRotation(-9.0F, -12.0F, -2.0F, 0.0F, 0.13962634015954636F,
                        -0.17453292519943295F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -12.0F, 0.0F));

        PartDefinition glowNeckCloth = glowBodyMain.addOrReplaceChild("GlowNeckCloth",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -10.0F, 0.0F));

        PartDefinition glowHead = glowNeckCloth.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -1.5F, 0.0F));
        addDefaultFaceParts(glowHead);

        return LayerDefinition.create(meshdefinition, 256, 128);
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

        boolean flag = !EmotionHelper.checkModelState(1, state);
        this.Cloak01.visible = !flag;

        flag = !EmotionHelper.checkModelState(2, state);
        this.EquipLeft.visible = !flag;
        this.EquipRight.visible = !flag;
    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowBodyMain.xRot = this.BodyMain.xRot;
        this.GlowBodyMain.yRot = this.BodyMain.yRot;
        this.GlowBodyMain.zRot = this.BodyMain.zRot;
        this.GlowNeckCloth.xRot = this.NeckCloth.xRot;
        this.GlowNeckCloth.yRot = this.NeckCloth.yRot;
        this.GlowNeckCloth.zRot = this.NeckCloth.zRot;
        this.GlowHead.xRot = this.Head.xRot;
        this.GlowHead.yRot = this.Head.yRot;
        this.GlowHead.zRot = this.Head.zRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += 0.62F;
        this.setFaceHungry(ent);

        // 頭部
        this.Head.xRot = 0F;
        this.Head.yRot = 0F;
        // 胸部
        this.BoobL.xRot = -0.7854F;
        this.BoobR.xRot = -0.7854F;
        this.NeckTie.xRot = -0.7F;
        // Body
        this.Ahoke.zRot = -0.06F;
        // arm
        this.ArmLeft01.yRot = 0F;
        // cloak
        this.EquipLeft.xRot = 0F;
        this.EquipRight.xRot = 0F;
        // hair
        this.Head.xRot = 0.2F;
        this.HairMidL01.xRot = 0.05F;
        this.HairMidL02.xRot = -0.3F;
        // Body
        this.BodyMain.xRot = 1.4F;
        // arm
        this.ArmLeft01.xRot = -2.8F;
        this.ArmLeft01.zRot = 0.8727F;
        this.ArmRight01.xRot = -2.8F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = -0.35F;
        // leg
        this.LegLeft.xRot = -0.087F;
        this.LegRight.xRot = -0.087F;
        this.LegLeft.zRot = -0.2618F;
        this.LegRight.zRot = 0.4F;
        // cloak
        this.Cloak01.xRot = 0F;
        this.Cloak02.xRot = 0F;
        this.Cloak03.xRot = 0F;
        this.Cloak04.xRot = 0F;
        this.Cloak05.xRot = 0F;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float angleX = Mth.cos(f2 * 0.08F);
        float angleX1 = Mth.cos(f2 * 0.08F + 0.3F + f * 0.5F);
        float angleRun = Mth.cos(f * 0.7F) * f1 * 0.6F;
        float angleRun2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.6F;
        float addk1;
        float addk2;

        // 水上漂浮
        if (ent.getShipDepth(0) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        // leg move parm
        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += angleX * 0.05F + 0.025F;
        addk1 = angleRun - 0.35F;
        addk2 = angleRun2 - 0.087F;

        // 移動頭部使其看人
        this.Head.xRot = f4 * 0.014F; // 上下角度
        this.Head.yRot = f3 * 0.01F; // 左右角度

        // 正常站立動作
        // 胸部
        this.BoobL.xRot = -angleX * 0.06F - 0.7854F;
        this.BoobR.xRot = -angleX * 0.06F - 0.7854F;
        this.NeckTie.xRot = -angleX * 0.1F - 0.7F;
        // hair
        this.HairMidL01.xRot = angleX * 0.06F + 0.2618F;
        this.HairMidL02.xRot = -angleX1 * 0.08F - 0.087F;
        this.HairL01.xRot = angleX * 0.06F - 0.13F;
        this.HairL02.xRot = -angleX1 * 0.08F + 0.21F;
        this.HairR01.xRot = angleX * 0.06F - 0.13F;
        this.HairR02.xRot = -angleX1 * 0.08F + 0.21F;
        this.HairMidL01.zRot = 0F;
        this.HairMidL02.zRot = 0F;
        this.HairL01.zRot = -0.05F;
        this.HairL02.zRot = 0.05F;
        this.HairR01.zRot = 0.087F;
        this.HairR02.zRot = -0.05F;
        // Body
        this.Ahoke.zRot = angleX * 0.1F - 0.06F;
        this.BodyMain.xRot = 0F;
        // arm
        this.ArmLeft01.xRot = 0.35F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = 0.2618F;
        this.ArmRight01.xRot = 0.35F;
        this.ArmRight01.zRot = -0.2618F;
        // leg
        this.LegLeft.zRot = 0.14F;
        this.LegRight.zRot = -0.14F;
        // cloak
        this.EquipLeft.xRot = 0F;
        this.EquipRight.xRot = 0F;
        this.Cloak01.xRot = 0F;
        this.Cloak02.xRot = angleX * 0.05F + 0.15F;
        this.Cloak03.xRot = angleX * 0.05F + 0.18F;
        this.Cloak04.xRot = angleX * 0.05F + 0.15F;
        this.Cloak05.xRot = 0.2F;

        // 奔跑動作
        if (ent.getIsSprinting() || f1 > 0.9F) {
            // leg move parm
            addk2 -= 0.35F;
            // hair
            this.HairMidL01.xRot += angleRun * 0.1F + 0.2F;
            this.HairMidL02.xRot += angleRun2 * 0.1F + 0.2F;
            // Body
            this.BodyMain.xRot = 0.087F;
            this.BodyMain.yRot = 0F;
            // arm
            this.ArmLeft01.xRot = angleRun2;
            this.ArmLeft01.zRot = -0.1745F;
            this.ArmRight01.xRot = angleRun;
            this.ArmRight01.zRot = 0.1745F;
            // leg
            this.LegLeft.zRot = 0.05F;
            this.LegRight.zRot = -0.05F;
            // cloak
            this.Cloak02.xRot = angleRun * 0.05F + 0.3F;
            this.Cloak03.xRot = angleRun * 0.05F + 0.3F;
            this.Cloak04.xRot = angleRun * 0.05F + 0.35F;
            this.Cloak05.xRot = angleRun * 0.05F + 0.4F;
        }

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        if (ent.getIsSneaking()) { // 潛行, 蹲下動作
            // leg move parm
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.05F;
            addk1 -= 0.52F;
            addk2 -= 1F;
            // Body
            this.BodyMain.xRot = 0.7F;
            // arm
            this.ArmLeft01.xRot = -0.35F;
            this.ArmLeft01.zRot = 0.26F;
            this.ArmRight01.xRot = -0.35F;
            this.ArmRight01.zRot = -0.26F;
            // cloak
            this.Cloak02.xRot = angleX * 0.05F + 0.15F;
            this.Cloak03.xRot = angleX * 0.05F + 0.15F;
            this.Cloak04.xRot = angleX * 0.05F + 0.2F;
            this.Cloak05.xRot = angleX * 0.05F + 0.2F;
        } // end if sneaking

        if (ent.getIsSitting() || ent.getIsRiding()) { // 騎乘動作
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                // leg move parm
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.65F;
                addk1 = -0.087F;
                addk2 = 0.174F;
                // hair
                this.Head.xRot -= 1.4F;
                this.Head.yRot *= 0.5F;
                // Body
                this.BodyMain.xRot = 1.4F;
                // arm
                this.ArmLeft01.xRot = -2.8F;
                this.ArmLeft01.zRot = -0.8727F;
                this.ArmRight01.xRot = -2.6F;
                this.ArmRight01.zRot = 0.35F;
                // leg
                this.LegLeft.zRot = 0.2618F;
                this.LegRight.zRot = -0.2618F;
                // cloak
                this.Cloak01.xRot = 0F;
                this.Cloak02.xRot = angleX * 0.01F + 0.15F;
                this.Cloak03.xRot = angleX * 0.01F + 0.18F;
                this.Cloak04.xRot = 0F;
                this.Cloak05.xRot = 0F;
            } else {
                // leg move parm
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.51F;
                addk1 = -1.0472F;
                addk2 = -1.3F;
                // hair
                this.Head.xRot += 0.35F;
                this.HairMidL01.xRot += 0.2F;
                this.HairMidL02.xRot += 0.2F;
                // Body
                this.BodyMain.xRot = -0.7F;
                // arm
                this.ArmLeft01.xRot = 1.0472F;
                this.ArmLeft01.zRot = -0.2618F;
                this.ArmRight01.xRot = 1.0472F;
                this.ArmRight01.zRot = 0.2618F;
                // leg
                this.LegLeft.zRot = 0.6F;
                this.LegRight.zRot = -0.6F;
                // cloak
                this.EquipLeft.xRot = 0.7F;
                this.EquipRight.xRot = 0.7F;
                this.Cloak01.xRot = 0.7F;
                this.Cloak02.xRot = angleX * 0.03F + 0.15F;
                this.Cloak03.xRot = angleX * 0.03F + 0.15F;
                this.Cloak04.xRot = angleX * 0.03F + 0.5F;
                this.Cloak05.xRot = angleX * 0.03F + 0.2F;
            }
        } // end if sitting

        // 攻擊動作
        if (ent.getAttackTick() > 0) {
            // arm
            this.ArmLeft01.xRot = -1.3F;
            this.ArmLeft01.yRot = -0.7F;
            this.ArmLeft01.zRot = 0F;
            this.ArmRight01.xRot = 0.17F;
            this.ArmRight01.zRot = 0.17F;
            this.EquipLeft.xRot = 0.2618F;
        }

        // swing arm
        float f6 = ent.getSwingTime(f2 - (int) f2);
        if (f6 != 0F) {
            float f7 = Mth.sin(f6 * f6 * (float) Math.PI);
            float f8 = Mth.sin(Mth.sqrt(f6) * (float) Math.PI);
            this.ArmRight01.xRot = 0.35F;
            this.ArmRight01.yRot = 0F;
            this.ArmRight01.zRot = -0.26F;
            this.ArmRight01.xRot += -f8 * 120.0F * ((float) Math.PI / 180F);
            this.ArmRight01.yRot += -f7 * 20.0F * ((float) Math.PI / 180F) + 0.5F;
            this.ArmRight01.zRot += -f8 * 20.0F * ((float) Math.PI / 180F);
        }

        // 鬢毛調整
        float headX = this.Head.xRot * -0.5F;
        float headZ = this.Head.zRot * -0.5F;
        this.HairMidL01.xRot += headX;
        this.HairMidL01.zRot += headZ;
        this.HairMidL02.xRot += headX * 0.5F;
        this.HairMidL02.zRot += headZ * 0.5F;
        this.HairL01.zRot += headZ;
        this.HairL02.zRot += headZ;
        this.HairR01.zRot += headZ;
        this.HairR02.zRot += headZ;
        this.HairL01.xRot += headX;
        this.HairL02.xRot += headX;
        this.HairR01.xRot += headX;
        this.HairR02.xRot += headX;

        // leg motion
        this.LegLeft.xRot = addk1;
        this.LegRight.xRot = addk2;
    }
}
