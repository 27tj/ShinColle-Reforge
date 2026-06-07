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

/**
 * ModelDestroyerShimakaze - PinkaLulan 2015/3/27
 * Ported from Tabula 4.1.1 to 1.20.1 ModelPart system.
 */
public class ModelDestroyerShimakaze extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "destroyer_shimakaze"), "main");

    // Main body parts
    private final ModelPart BodyMain;
    private final ModelPart NeckCloth;
    private final ModelPart Head;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart Ahoke;
    private final ModelPart HairL01;
    private final ModelPart HairL02;
    private final ModelPart HairR01;
    private final ModelPart HairR02;
    private final ModelPart HairMidL01;
    private final ModelPart HairMidL02;
    private final ModelPart HairMidR01;
    private final ModelPart HairMidR02;
    private final ModelPart HairAnchor;
    private final ModelPart EarBase;
    private final ModelPart EarL01;
    private final ModelPart EarL02;
    private final ModelPart EarR01;
    private final ModelPart EarR02;
    private final ModelPart ArmLeft;
    private final ModelPart ArmRight;
    private final ModelPart Butt;
    private final ModelPart LegLeft;
    private final ModelPart LegRight;
    private final ModelPart Skirt;
    private final ModelPart ShoesL;
    private final ModelPart ShoesR;
    private final ModelPart NeckTie;
    private final ModelPart EquipBase;
    private final ModelPart EquipHead;
    private final ModelPart EquipT01;
    private final ModelPart EquipT02;
    private final ModelPart EquipT03;
    private final ModelPart EquipT04;
    private final ModelPart EquipT05;

    // Glow scaffolding
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowNeckCloth;
    private final ModelPart GlowHead;

    public ModelDestroyerShimakaze(ModelPart root) {
        super();
        this.BodyMain = root.getChild("BodyMain");
        this.NeckCloth = this.BodyMain.getChild("NeckCloth");
        this.Head = this.NeckCloth.getChild("Head");
        this.Hair = this.Head.getChild("Hair");
        this.HairMain = this.Head.getChild("HairMain");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.HairL01 = this.Hair.getChild("HairL01");
        this.HairR01 = this.Hair.getChild("HairR01");
        this.HairL02 = this.HairL01.getChild("HairL02");
        this.HairR02 = this.HairR01.getChild("HairR02");
        this.HairAnchor = this.HairL02.getChild("HairAnchor");
        this.HairMidL01 = this.HairMain.getChild("HairMidL01");
        this.HairMidR01 = this.HairMain.getChild("HairMidR01");
        this.HairMidL02 = this.HairMidL01.getChild("HairMidL02");
        this.HairMidR02 = this.HairMidR01.getChild("HairMidR02");
        this.EarBase = this.HairMain.getChild("EarBase");
        this.EarL01 = this.EarBase.getChild("EarL01");
        this.EarR01 = this.EarBase.getChild("EarR01");
        this.EarL02 = this.EarL01.getChild("EarL02");
        this.EarR02 = this.EarR01.getChild("EarR02");
        this.ArmLeft = this.BodyMain.getChild("ArmLeft");
        this.ArmRight = this.BodyMain.getChild("ArmRight");
        this.Butt = this.BodyMain.getChild("Butt");
        this.LegLeft = this.Butt.getChild("LegLeft");
        this.LegRight = this.Butt.getChild("LegRight");
        this.Skirt = this.Butt.getChild("Skirt");
        this.ShoesL = this.LegLeft.getChild("ShoesL");
        this.ShoesR = this.LegRight.getChild("ShoesR");
        this.NeckTie = this.NeckCloth.getChild("NeckTie");
        this.EquipBase = this.BodyMain.getChild("EquipBase");
        this.EquipHead = this.EquipBase.getChild("EquipHead");
        this.EquipT01 = this.EquipBase.getChild("EquipT01");
        this.EquipT02 = this.EquipBase.getChild("EquipT02");
        this.EquipT03 = this.EquipBase.getChild("EquipT03");
        this.EquipT04 = this.EquipBase.getChild("EquipT04");
        this.EquipT05 = this.EquipBase.getChild("EquipT05");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowNeckCloth = this.GlowBodyMain.getChild("GlowNeckCloth");
        this.GlowHead = this.GlowNeckCloth.getChild("GlowHead");
        this.loadFaceParts(this.GlowHead);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        // BodyMain
        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 37)
                        .addBox(-7.0F, -11.0F, -4.0F, 14, 17, 7),
                PartPose.offset(0.0F, -12.0F, 0.0F));

        // NeckCloth (child of BodyMain)
        PartDefinition neckCloth = bodyMain.addOrReplaceChild("NeckCloth",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-7.5F, -1.5F, -4.5F, 15, 12, 8),
                PartPose.offset(0.0F, -10.0F, 0.0F));

        // Head (child of NeckCloth)
        PartDefinition head = neckCloth.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(24, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14, 14, 13),
                PartPose.offset(0.0F, -1.5F, 0.0F));

        // HairMain (child of Head)
        PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(23, 61)
                        .addBox(-7.5F, 0.0F, 0.0F, 15, 9, 10),
                PartPose.offset(0.0F, -15.0F, -3.0F));

        // Hair (child of Head)
        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(24, 80)
                        .addBox(-8.0F, -7.5F, -8.0F, 16, 12, 8),
                PartPose.offset(0.0F, -7.5F, 0.0F));

        // Ahoke (child of Hair)
        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(65, 88)
                        .addBox(0.0F, 0.0F, -12.0F, 0, 13, 12),
                PartPose.offsetAndRotation(0.0F, -14.0F, -4.0F, 0.0F, 0.5236F, 0.0F));

        // HairL01 (child of Hair)
        PartDefinition hairL01 = hair.addOrReplaceChild("HairL01",
                CubeListBuilder.create().texOffs(102, 0)
                        .addBox(-1.0F, 0.0F, 0.0F, 2, 9, 4),
                PartPose.offsetAndRotation(5.5F, 0.0F, -3.0F, -0.2618F, -0.1745F, -0.2618F));

        // HairL02 (child of HairL01)
        PartDefinition hairL02 = hairL01.addOrReplaceChild("HairL02",
                CubeListBuilder.create().texOffs(103, 1)
                        .addBox(-1.0F, 0.0F, 0.0F, 2, 9, 3),
                PartPose.offsetAndRotation(-0.2F, 8.5F, 0.5F, 0.2618F, 0.0F, 0.1745F));

        // HairAnchor (child of HairL02)
        hairL02.addOrReplaceChild("HairAnchor",
                CubeListBuilder.create().texOffs(112, 7)
                        .addBox(-1.5F, 0.0F, 0.0F, 2, 5, 6),
                PartPose.offsetAndRotation(0.2F, 8.0F, -1.0F, 0.0873F, 0.0F, 0.1367F));

        // HairR01 (child of Hair)
        PartDefinition hairR01 = hair.addOrReplaceChild("HairR01",
                CubeListBuilder.create().texOffs(102, 0)
                        .addBox(-1.0F, 0.0F, 0.0F, 2, 9, 4),
                PartPose.offsetAndRotation(-5.5F, 0.0F, -3.0F, -0.2618F, 0.1745F, 0.2618F));

        // HairR02 (child of HairR01)
        hairR01.addOrReplaceChild("HairR02",
                CubeListBuilder.create().texOffs(103, 1)
                        .addBox(-1.0F, 0.0F, 0.0F, 2, 9, 3),
                PartPose.offsetAndRotation(0.2F, 8.5F, 0.5F, 0.1745F, 0.0F, -0.1745F));

        // HairMidL01 (child of HairMain)
        PartDefinition hairMidL01 = hairMain.addOrReplaceChild("HairMidL01",
                CubeListBuilder.create().texOffs(42, 40)
                        .addBox(-4.5F, 0.0F, 0.0F, 9, 13, 8),
                PartPose.offsetAndRotation(2.5F, 9.0F, 2.5F, 0.1396F, 0.0873F, -0.2618F));

        // HairMidL02 (child of HairMidL01)
        hairMidL01.addOrReplaceChild("HairMidL02",
                CubeListBuilder.create().texOffs(46, 21)
                        .addBox(-4.5F, 0.0F, 0.0F, 9, 14, 5),
                PartPose.offsetAndRotation(0.0F, 12.0F, 3.0F, 0.1396F, 0.0F, -0.1396F));

        // HairMidR01 (child of HairMain)
        PartDefinition hairMidR01 = hairMain.addOrReplaceChild("HairMidR01",
                CubeListBuilder.create().texOffs(42, 40).mirror()
                        .addBox(-4.5F, 0.0F, 0.0F, 9, 13, 8),
                PartPose.offsetAndRotation(-2.5F, 9.0F, 2.5F, 0.1396F, -0.0873F, 0.2618F));

        // HairMidR02 (child of HairMidR01)
        hairMidR01.addOrReplaceChild("HairMidR02",
                CubeListBuilder.create().texOffs(46, 21).mirror()
                        .addBox(-4.5F, 0.0F, 0.0F, 9, 14, 5),
                PartPose.offsetAndRotation(0.0F, 12.0F, 3.0F, 0.1396F, 0.0F, 0.1396F));

        // EarBase (child of HairMain)
        PartDefinition earBase = hairMain.addOrReplaceChild("EarBase",
                CubeListBuilder.create().texOffs(80, 113)
                        .addBox(0.0F, 0.0F, 0.0F, 4, 3, 4),
                PartPose.offset(-2.0F, -2.0F, 2.0F));

        // EarL01, EarL02 (child of EarBase)
        PartDefinition earL01 = earBase.addOrReplaceChild("EarL01",
                CubeListBuilder.create().texOffs(83, 113)
                        .addBox(-1.5F, -10.0F, -1.0F, 3, 10, 2),
                PartPose.offset(4.0F, 2.5F, 2.0F));
        earL01.addOrReplaceChild("EarL02",
                CubeListBuilder.create().texOffs(82, 113)
                        .addBox(-2.0F, -13.0F, -1.0F, 4, 13, 2),
                PartPose.offset(0.0F, -9.0F, 0.0F));

        // EarR01, EarR02 (child of EarBase)
        PartDefinition earR01 = earBase.addOrReplaceChild("EarR01",
                CubeListBuilder.create().texOffs(83, 113)
                        .addBox(-1.5F, -10.0F, -1.0F, 3, 10, 2),
                PartPose.offset(0.0F, 2.5F, 2.0F));
        earR01.addOrReplaceChild("EarR02",
                CubeListBuilder.create().texOffs(82, 113)
                        .addBox(-2.0F, -13.0F, -1.0F, 4, 13, 2),
                PartPose.offset(0.0F, -9.0F, 0.0F));

        // NeckTie (child of NeckCloth)
        neckCloth.addOrReplaceChild("NeckTie",
                CubeListBuilder.create().texOffs(39, 0)
                        .addBox(-3.5F, 0.0F, 0.0F, 7, 7, 0),
                PartPose.offsetAndRotation(0.0F, 2.5F, -4.7F, -0.1396F, 0.0F, 0.0F));

        // ArmLeft (child of BodyMain)
        bodyMain.addOrReplaceChild("ArmLeft",
                CubeListBuilder.create().texOffs(0, 61).mirror()
                        .addBox(-2.5F, 0.0F, -2.5F, 5, 22, 5),
                PartPose.offsetAndRotation(7.0F, -10.5F, 0.0F, 0.0F, 0.0F, -0.3491F));

        // ArmRight (child of BodyMain)
        bodyMain.addOrReplaceChild("ArmRight",
                CubeListBuilder.create().texOffs(0, 61)
                        .addBox(-2.5F, 0.0F, -2.5F, 5, 22, 5),
                PartPose.offsetAndRotation(-7.0F, -10.5F, 0.0F, 0.0F, 0.0F, 0.4363F));

        // Butt (child of BodyMain)
        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(0, 22)
                        .addBox(-8.0F, 4.0F, -5.4F, 16, 8, 7),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

        // Skirt (child of Butt)
        butt.addOrReplaceChild("Skirt",
                CubeListBuilder.create().texOffs(50, 0)
                        .addBox(-8.5F, 0.0F, -6.0F, 17, 6, 9),
                PartPose.offsetAndRotation(0.0F, 5.5F, 0.0F, -0.1745F, 0.0F, 0.0F));

        // LegLeft (child of Butt)
        PartDefinition legLeft = butt.addOrReplaceChild("LegLeft",
                CubeListBuilder.create().texOffs(0, 96).mirror()
                        .addBox(-3.0F, 0.0F, -3.0F, 6, 19, 6),
                PartPose.offsetAndRotation(4.5F, 9.5F, -3.0F, -0.2618F, 0.0F, 0.0524F));

        // ShoesL (child of LegLeft)
        legLeft.addOrReplaceChild("ShoesL",
                CubeListBuilder.create().texOffs(88, 15)
                        .addBox(-3.5F, 0.0F, -3.5F, 7, 7, 7),
                PartPose.offset(0.0F, 19.0F, -0.2F));

        // LegRight (child of Butt)
        PartDefinition legRight = butt.addOrReplaceChild("LegRight",
                CubeListBuilder.create().texOffs(0, 96)
                        .addBox(-3.0F, 0.0F, -3.0F, 6, 19, 6),
                PartPose.offsetAndRotation(-4.5F, 9.5F, -3.0F, -0.2618F, 0.0F, -0.0524F));

        // ShoesR (child of LegRight)
        legRight.addOrReplaceChild("ShoesR",
                CubeListBuilder.create().texOffs(88, 15)
                        .addBox(-3.5F, 0.0F, -3.5F, 7, 7, 7),
                PartPose.offset(0.0F, 19.0F, -0.2F));

        // EquipBase (child of BodyMain)
        PartDefinition equipBase = bodyMain.addOrReplaceChild("EquipBase",
                CubeListBuilder.create().texOffs(76, 33)
                        .addBox(-7.0F, 0.0F, -3.7F, 14, 8, 12),
                PartPose.offsetAndRotation(2.0F, -5.0F, 7.0F, 0.1396F, 0.0F, 0.5236F));

        // EquipHead (child of EquipBase)
        equipBase.addOrReplaceChild("EquipHead",
                CubeListBuilder.create().texOffs(77, 29)
                        .addBox(-9.0F, 0.0F, 0.0F, 18, 17, 7),
                PartPose.offset(0.0F, -3.0F, -0.3F));

        // EquipT01-T05 (children of EquipBase)
        equipBase.addOrReplaceChild("EquipT01",
                CubeListBuilder.create().texOffs(85, 65)
                        .addBox(0.0F, 0.0F, 0.0F, 3, 31, 3),
                PartPose.offset(5.1F, -8.0F, 1.0F));
        equipBase.addOrReplaceChild("EquipT02",
                CubeListBuilder.create().texOffs(85, 65)
                        .addBox(0.0F, 0.0F, 0.0F, 3, 31, 3),
                PartPose.offset(1.8F, -8.0F, 1.0F));
        equipBase.addOrReplaceChild("EquipT03",
                CubeListBuilder.create().texOffs(85, 65)
                        .addBox(0.0F, 0.0F, 0.0F, 3, 31, 3),
                PartPose.offset(-1.5F, -8.0F, 1.0F));
        equipBase.addOrReplaceChild("EquipT04",
                CubeListBuilder.create().texOffs(85, 65)
                        .addBox(0.0F, 0.0F, 0.0F, 3, 31, 3),
                PartPose.offset(-4.8F, -8.0F, 1.0F));
        equipBase.addOrReplaceChild("EquipT05",
                CubeListBuilder.create().texOffs(85, 65)
                        .addBox(0.0F, 0.0F, 0.0F, 3, 31, 3),
                PartPose.offset(-8.1F, -8.0F, 1.0F));

        // Glow scaffolding
        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 0.0F));
        PartDefinition glowNeckCloth = glowBodyMain.addOrReplaceChild("GlowNeckCloth",
                CubeListBuilder.create(), PartPose.offset(0.0F, -10.0F, 0.0F));
        PartDefinition glowHead = glowNeckCloth.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(), PartPose.offset(0.0F, -1.5F, 0.0F));

        // Add face parts to glow head
        addDefaultFaceParts(glowHead);

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
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

        // Set equip visibility
        this.showEquip(ent);

        // Apply flush
        this.setFlush(ent.getStateMinor(ID.M.Morale) > ID.Morale.L_Happy);

        // Roll emotion
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
        // Determine scale from entity scale level
        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);
        poseStack.translate(offsetX, offsetY, offsetZ);

        this.BodyMain.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);

        // Render glow parts with full brightness
        this.GlowBodyMain.render(poseStack, buffer, 0xF000F0, packedOverlay, red, green, blue, alpha);

        poseStack.popPose();
    }

    @Override
    public void showEquip(IShipEmotion ent) {
        int state = ent.getStateEmotion(ID.S.State);
        this.EquipBase.visible = EmotionHelper.checkModelState(1, state);
        this.HairAnchor.visible = EmotionHelper.checkModelState(2, state);

        boolean fh1 = EmotionHelper.checkModelState(3, state);
        boolean fh2 = EmotionHelper.checkModelState(4, state);
        boolean fh3 = EmotionHelper.checkModelState(5, state);
        this.EarBase.visible = (fh1 || fh2 || fh3);
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
        this.offsetY += 0.55F + 0.26F * ent.getScaleLevel();
        this.setFaceHungry(ent);

        this.EarL01.xRot = 1F;
        this.EarL01.yRot = -0.4F;
        this.EarL01.zRot = 0F;
        this.EarR01.xRot = 1F;
        this.EarR01.yRot = 1.0472F;
        this.EarR01.zRot = 0F;
        this.EarL02.xRot = -0.8F;
        this.EarL02.yRot = 0F;
        this.EarL02.zRot = 0F;
        this.EarR02.xRot = -0.2F;
        this.EarR02.yRot = -0.2F;
        this.EarR02.zRot = 0F;

        this.EquipBase.zRot = 0.52F;

        this.Head.xRot = 0F;
        this.Head.yRot = 0F;
        this.Head.zRot = 0F;
        this.Ahoke.yRot = 0.5236F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.xRot = 1.4835F;
        this.HairMidL01.xRot = -0.05F;
        this.HairMidR01.xRot = -0.05F;
        this.HairMidL02.xRot = -0.1F;
        this.HairMidR02.xRot = -0.1F;

        this.ArmLeft.xRot = -0.12F;
        this.ArmLeft.zRot = -0.2F;
        this.ArmRight.xRot = -0.12F;
        this.ArmRight.zRot = 0.2F;

        this.LegLeft.xRot = -0.2618F;
        this.LegRight.xRot = -0.2618F;
        this.LegLeft.yRot = 0F;
        this.LegRight.yRot = 0F;
        this.LegLeft.zRot = 0.03F;
        this.LegRight.zRot = -0.03F;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        float angleX = Mth.cos(f2 * 0.08F);
        float angleX1 = Mth.cos(f2 * 0.08F + 0.3F + f * 0.5F);
        float addk1;
        float addk2;

        // 水上漂浮
        if (ent.getShipDepth(0) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        // Leg default
        addk1 = Mth.cos(f * 0.7F) * f1 - 0.21F;
        addk2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 - 0.11F;

        // Head look
        this.Head.xRot = f4 * 0.014F + 0.1F;
        this.Head.yRot = f3 * 0.01F;

        // Ear state
        int state = ent.getStateEmotion(ID.S.State);
        boolean fh1 = EmotionHelper.checkModelState(3, state);
        boolean fh2 = EmotionHelper.checkModelState(4, state);
        boolean fh3 = EmotionHelper.checkModelState(5, state);

        if (fh1 && fh2 && fh3) {
            this.EarL01.xRot = angleX * 0.075F + 0.6F;
            this.EarL01.yRot = -0.5F;
            this.EarL01.zRot = 0F;
            this.EarR01.xRot = angleX * 0.075F + 1.1F;
            this.EarR01.yRot = 0.5F;
            this.EarR01.zRot = 0F;
            this.EarL02.xRot = angleX1 * 0.1F + 0.7F;
            this.EarL02.yRot = 0.1F;
            this.EarL02.zRot = 0F;
            this.EarR02.xRot = angleX1 * 0.1F + 1.0F;
            this.EarR02.yRot = -0.1F;
            this.EarR02.zRot = 0F;
        } else if (fh2 && fh3) {
            this.EarL01.xRot = angleX * 0.075F + 1.1F;
            this.EarL01.yRot = -0.5F;
            this.EarL01.zRot = 0F;
            this.EarR01.xRot = angleX * 0.075F + 1.1F;
            this.EarR01.yRot = 0.5F;
            this.EarR01.zRot = 0F;
            this.EarL02.xRot = angleX1 * 0.1F + 1.0F;
            this.EarL02.yRot = 0.1F;
            this.EarL02.zRot = 0F;
            this.EarR02.xRot = angleX1 * 0.1F + 1.0F;
            this.EarR02.yRot = -0.1F;
            this.EarR02.zRot = 0F;
        } else if (fh1 && fh3) {
            this.EarL01.xRot = angleX * 0.075F - 1.1F;
            this.EarL01.yRot = 0.5F;
            this.EarL01.zRot = 0F;
            this.EarR01.xRot = angleX1 * 0.075F - 1.1F;
            this.EarR01.yRot = -0.5F;
            this.EarR01.zRot = 0F;
            this.EarL02.xRot = angleX * 0.075F - 0.8F;
            this.EarL02.yRot = 0F;
            this.EarL02.zRot = -0.5F;
            this.EarR02.xRot = angleX1 * 0.075F - 0.8F;
            this.EarR02.yRot = 0F;
            this.EarR02.zRot = 0.5F;
        } else if (fh1 && fh2) {
            this.EarL01.xRot = angleX * 0.075F + 0.6F;
            this.EarL01.yRot = -0.5F;
            this.EarL01.zRot = 0F;
            this.EarR01.xRot = angleX * 0.075F + 0.6F;
            this.EarR01.yRot = 0.5F;
            this.EarR01.zRot = 0F;
            this.EarL02.xRot = angleX1 * 0.1F + 0.7F;
            this.EarL02.yRot = 0.1F;
            this.EarL02.zRot = 0F;
            this.EarR02.xRot = angleX1 * 0.1F + 0.7F;
            this.EarR02.yRot = -0.1F;
            this.EarR02.zRot = 0F;
        } else if (fh3) {
            this.EarL01.xRot = angleX * 0.075F + 0.3F;
            this.EarL01.yRot = -0.8F;
            this.EarL01.zRot = 0F;
            this.EarR01.xRot = angleX * 0.075F + 0.9F;
            this.EarR01.yRot = 0.6F;
            this.EarR01.zRot = 0F;
            this.EarL02.xRot = angleX1 * 0.1F + 0.6F;
            this.EarL02.yRot = 0.1F;
            this.EarL02.zRot = 0F;
            this.EarR02.xRot = angleX1 * 0.1F + 1F;
            this.EarR02.yRot = -0.1F;
            this.EarR02.zRot = 0F;
        } else if (fh2) {
            this.EarL01.xRot = angleX * 0.075F + 0.2F;
            this.EarL01.yRot = -0.4F;
            this.EarL01.zRot = 0.4F;
            this.EarR01.xRot = angleX * 0.075F + 0.2F;
            this.EarR01.yRot = 0.4F;
            this.EarR01.zRot = -0.4F;
            this.EarL02.xRot = angleX1 * 0.1F + 0.2F;
            this.EarL02.yRot = 0F;
            this.EarL02.zRot = -0.3F;
            this.EarR02.xRot = angleX1 * 0.1F + 0.2F;
            this.EarR02.yRot = 0F;
            this.EarR02.zRot = 0.3F;
        } else if (fh1) {
            this.EarL01.xRot = angleX * 0.075F - 0.1F;
            this.EarL01.yRot = 0.2F;
            this.EarL01.zRot = 0.4F;
            this.EarR01.xRot = angleX * 0.075F;
            this.EarR01.yRot = 0.2F;
            this.EarR01.zRot = -0.55F;
            this.EarL02.xRot = angleX1 * 0.1F + 0.4F;
            this.EarL02.yRot = 0F;
            this.EarL02.zRot = -0.1F;
            this.EarR02.xRot = angleX1 * 0.1F + 0.9F;
            this.EarR02.yRot = 0.5F;
            this.EarR02.zRot = 0F;
        }

        // Hair
        this.HairMidL01.xRot = angleX * 0.07F + 0.14F;
        this.HairMidL02.xRot = -angleX1 * 0.2F + 0.14F;
        this.HairMidR01.xRot = this.HairMidL01.xRot;
        this.HairMidR02.xRot = this.HairMidL02.xRot;
        this.HairMidL01.zRot = -0.2618F;
        this.HairMidL02.zRot = -0.14F;
        this.HairMidR01.zRot = 0.2618F;
        this.HairMidR02.zRot = 0.14F;
        this.HairL01.xRot = angleX * 0.06F - 0.2618F;
        this.HairL02.xRot = -angleX1 * 0.1F + 0.2618F;
        this.HairR01.xRot = angleX * 0.06F - 0.2618F;
        this.HairR02.xRot = -angleX1 * 0.1F + 0.2618F;
        this.HairL01.zRot = -0.2618F;
        this.HairL02.zRot = 0.1745F;
        this.HairR01.zRot = 0.2618F;
        this.HairR02.zRot = -0.1745F;

        // Body
        this.Ahoke.yRot = angleX * 0.25F + 0.5236F;
        this.BodyMain.xRot = -0.1F;
        this.BodyMain.yRot = 0F;

        // Arm
        this.ArmLeft.xRot = 0.15F;
        this.ArmLeft.zRot = angleX * 0.1F - 0.5236F;
        this.ArmRight.xRot = 0F;
        this.ArmRight.yRot = 0F;
        this.ArmRight.zRot = -angleX * 0.1F + 0.5236F;

        // Leg
        this.LegLeft.yRot = 0F;
        this.LegLeft.zRot = 0.05F;
        this.LegRight.yRot = 0F;
        this.LegRight.zRot = -0.05F;

        // Equip
        this.EquipBase.zRot = 0.52F;

        if (ent.getIsSprinting() || f1 > 0.6F) {
            setFace(3);
            this.Head.xRot -= 0.2618F;
            this.BodyMain.xRot = 0.2618F;
            this.HairMidL01.xRot += 0.5F;
            this.HairMidR01.xRot += 0.5F;
            this.HairMidL02.xRot += 0.5F;
            this.HairMidR02.xRot += 0.5F;
            this.ArmLeft.xRot = 0.7F;
            this.ArmLeft.zRot = -1.0472F;
            this.ArmRight.xRot = 0.7F;
            this.ArmRight.zRot = 1.0472F;
            float angleRun = Mth.cos(f * 1.5F) * f1;
            addk1 = Mth.cos(f * 2F) * f1 * 1.5F - 0.5F;
            addk2 = Mth.cos(f * 2F + 3.1415927F) * f1 * 1.5F - 0.5F;
            this.EarL01.xRot = -angleRun * 0.08F - 0.8727F;
            this.EarL01.yRot = 0.5F;
            this.EarL01.zRot = 0F;
            this.EarR01.xRot = angleRun * 0.08F - 0.8727F;
            this.EarR01.yRot = -0.5F;
            this.EarR01.zRot = 0F;
            this.EarL02.xRot = -angleRun * 0.1F - 0.5F;
            this.EarL02.yRot = 0F;
            this.EarL02.zRot = -0.5F;
            this.EarR02.xRot = angleRun * 0.1F - 0.5F;
            this.EarR02.yRot = 0F;
            this.EarR02.zRot = 0.5F;
        }

        // Head tilt
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        if (ent.getIsSneaking()) {
            this.Head.xRot -= 0.7854F;
            this.BodyMain.xRot = 0.7854F;
            this.ArmLeft.zRot = -0.5F;
            this.ArmRight.zRot = 0.5F;
            addk1 -= 0.8F;
            addk2 -= 0.8F;
        }

        if (ent.getIsSitting() || ent.getIsRiding()) {
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.575F;
                this.Head.xRot = -1.48F;
                this.Head.yRot = 0F;
                this.Head.zRot = 0F;
                this.BodyMain.xRot = 1.4835F;
                this.ArmLeft.xRot = -3.0543F;
                this.ArmLeft.zRot = -0.7F;
                this.ArmRight.xRot = -2.8F;
                this.ArmRight.zRot = 0.35F;
                addk1 = 0F;
                addk2 = -0.2618F;
                this.LegLeft.zRot = 0.1745F;
                this.LegRight.zRot = -0.35F;
            } else {
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.45F;
                this.Head.xRot -= 0.7F;
                this.BodyMain.xRot = 0.5236F;
                this.HairL01.xRot -= 0.2F;
                this.HairL02.xRot -= 0.2F;
                this.HairR01.xRot -= 0.2F;
                this.HairR02.xRot -= 0.2F;
                this.ArmLeft.xRot = -0.5236F;
                this.ArmLeft.zRot = 0.3146F;
                this.ArmRight.xRot = -0.5236F;
                this.ArmRight.zRot = -0.3146F;
                addk1 = -2.2689F;
                addk2 = -2.2689F;
                this.LegLeft.yRot = -0.3491F;
                this.LegRight.yRot = 0.3491F;
            }
        }

        if (ent.getAttackTick() > 20) {
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.14F + ent.getScaleLevel() * 0.07F;
            this.Head.xRot = -0.8727F;
            this.Head.yRot = 1.0472F;
            this.Head.zRot = -0.7F;
            this.BodyMain.xRot = 1.3F;
            this.BodyMain.yRot = -1.57F;
            this.ArmLeft.xRot = 0F;
            this.ArmLeft.zRot = -0.5F;
            this.ArmRight.xRot = 0F;
            this.ArmRight.zRot = 1.57F;
            addk1 = -1.75F;
            addk2 = -1.92F;
            this.EquipBase.zRot = 1.57F;
        }

        // Hair adjustment based on head rotation
        float headX = this.Head.xRot * -0.5F;
        float headZ = this.Head.zRot * -0.5F;
        this.HairMidL01.xRot += headX;
        this.HairMidL01.zRot += headZ;
        this.HairMidL02.xRot += headX * 0.5F;
        this.HairMidL02.zRot += headZ * 0.5F;
        this.HairMidR01.xRot += headX;
        this.HairMidR01.zRot += headZ;
        this.HairMidR02.xRot += headX * 0.5F;
        this.HairMidR02.zRot += headZ * 0.5F;
        this.HairL01.zRot += headZ;
        this.HairL02.zRot += headZ;
        this.HairR01.zRot += headZ;
        this.HairR02.zRot += headZ;
        this.HairL01.xRot += headX;
        this.HairL02.xRot += headX;
        this.HairR01.xRot += headX;
        this.HairR02.xRot += headX;

        // Leg motion
        this.LegLeft.xRot = addk1;
        this.LegRight.xRot = addk2;
    }
}
