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

public class ModelHeavyCruiserRi extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "ca_ri"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Butt;
    private final ModelPart ArmLeft;
    private final ModelPart ArmRight;
    private final ModelPart Neck;
    private final ModelPart EquipBase;
    private final ModelPart LegRight;
    private final ModelPart LegLeft;
    private final ModelPart BoobR;
    private final ModelPart BoobL;
    private final ModelPart EquipLeftBase;
    private final ModelPart EquipLeftTube1;
    private final ModelPart EquipLeftBase2;
    private final ModelPart EquipLeftBase3;
    private final ModelPart EquipLeftBase4;
    private final ModelPart EquipLeftTube2;
    private final ModelPart EquipLeftTube3;
    private final ModelPart EquipLeftTooth;
    private final ModelPart EquipRightBase;
    private final ModelPart EquipRightTube1;
    private final ModelPart EquipRightBase1;
    private final ModelPart EquipRightBase2;
    private final ModelPart EquipRightBase3;
    private final ModelPart EquipRightBase4;
    private final ModelPart EquipRightTube2;
    private final ModelPart EquipRightTube3;
    private final ModelPart EquipRightTooth1;
    private final ModelPart EquipRightTooth2;
    private final ModelPart Head;
    private final ModelPart Cloak;
    private final ModelPart Hair;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowNeck;
    private final ModelPart GlowHead;
    private final ModelPart GlowArmLeft;
    private final ModelPart GlowEquipLeftBase;
    private final ModelPart GlowEquipLeftBase3;
    private final ModelPart GlowArmRight;
    private final ModelPart GlowEquipRightBase;
    private final ModelPart GlowEquipRightBase2;
    private final ModelPart GlowEquipRightBase3;
    private final ModelPart ShoesRight;
    private final ModelPart ShoesLeft;
    private final ModelPart HeadTail0;
    private final ModelPart HeadTail1;
    private final ModelPart HeadTail2;

    public ModelHeavyCruiserRi(ModelPart root) {
        super();
        this.scale = 0.41F;
        this.offsetY = 2.15F;
        this.BodyMain = root.getChild("BodyMain");
        this.BoobL = this.BodyMain.getChild("BoobL");
        this.ArmRight = this.BodyMain.getChild("ArmRight");
        this.Neck = this.BodyMain.getChild("Neck");
        this.Butt = this.BodyMain.getChild("Butt");
        this.EquipBase = this.BodyMain.getChild("EquipBase");
        this.BoobR = this.BodyMain.getChild("BoobR");
        this.ArmLeft = this.BodyMain.getChild("ArmLeft");
        this.EquipRightBase = this.ArmRight.getChild("EquipRightBase");
        this.Head = this.Neck.getChild("Head");
        this.Cloak = this.Neck.getChild("Cloak");
        this.LegRight = this.Butt.getChild("LegRight");
        this.LegLeft = this.Butt.getChild("LegLeft");
        this.EquipLeftBase = this.ArmLeft.getChild("EquipLeftBase");
        this.EquipRightBase1 = this.EquipRightBase.getChild("EquipRightBase1");
        this.EquipRightBase4 = this.EquipRightBase.getChild("EquipRightBase4");
        this.EquipRightBase3 = this.EquipRightBase.getChild("EquipRightBase3");
        this.EquipRightBase2 = this.EquipRightBase.getChild("EquipRightBase2");
        this.EquipRightTube1 = this.EquipRightBase.getChild("EquipRightTube1");
        this.Hair = this.Head.getChild("Hair");
        this.HeadTail0 = this.Head.getChild("HeadTail0");
        this.ShoesRight = this.LegRight.getChild("ShoesRight");
        this.ShoesLeft = this.LegLeft.getChild("ShoesLeft");
        this.EquipLeftBase2 = this.EquipLeftBase.getChild("EquipLeftBase2");
        this.EquipLeftBase4 = this.EquipLeftBase.getChild("EquipLeftBase4");
        this.EquipLeftBase3 = this.EquipLeftBase.getChild("EquipLeftBase3");
        this.EquipLeftTube1 = this.EquipLeftBase.getChild("EquipLeftTube1");
        this.EquipRightTube2 = this.EquipRightTube1.getChild("EquipRightTube2");
        this.HeadTail1 = this.HeadTail0.getChild("HeadTail1");
        this.EquipLeftTube2 = this.EquipLeftTube1.getChild("EquipLeftTube2");
        this.EquipRightTube3 = this.EquipRightTube2.getChild("EquipRightTube3");
        this.HeadTail2 = this.HeadTail1.getChild("HeadTail2");
        this.EquipLeftTube3 = this.EquipLeftTube2.getChild("EquipLeftTube3");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowNeck = this.GlowBodyMain.getChild("GlowNeck");
        this.GlowArmLeft = this.GlowBodyMain.getChild("GlowArmLeft");
        this.GlowArmRight = this.GlowBodyMain.getChild("GlowArmRight");
        this.GlowHead = this.GlowNeck.getChild("GlowHead");
        this.GlowEquipLeftBase = this.GlowArmLeft.getChild("GlowEquipLeftBase");
        this.GlowEquipRightBase = this.GlowArmRight.getChild("GlowEquipRightBase");
        this.GlowEquipLeftBase3 = this.GlowEquipLeftBase.getChild("GlowEquipLeftBase3");
        this.GlowEquipRightBase2 = this.GlowEquipRightBase.getChild("GlowEquipRightBase2");
        this.GlowEquipRightBase3 = this.GlowEquipRightBase.getChild("GlowEquipRightBase3");
        this.EquipLeftTooth = this.GlowEquipLeftBase3.getChild("EquipLeftTooth");
        this.EquipRightTooth1 = this.GlowEquipRightBase2.getChild("EquipRightTooth1");
        this.EquipRightTooth2 = this.GlowEquipRightBase3.getChild("EquipRightTooth2");
        this.loadFaceParts(this.GlowHead);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-6.5F, -10.0F, -4.0F, 13.0F, 16.0F, 8.0F),
                PartPose.offset(0.0F, -14.0F, 0.0F));

        bodyMain.addOrReplaceChild("BoobL",
                CubeListBuilder.create().mirror().texOffs(1, 26)
                        .addBox(-3.5F, 0.0F, -1.0F, 7.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(3.3F, -8.5F, -2.5F, -0.7853981633974483F, 0.087F, 0.087F));

        PartDefinition armRight = bodyMain.addOrReplaceChild("ArmRight",
                CubeListBuilder.create().texOffs(0, 53)
                        .addBox(-5.0F, 0.0F, -2.5F, 5.0F, 25.0F, 5.0F),
                PartPose.offsetAndRotation(-6.0F, -9.5F, 0.0F, 0.2F, 0.0F, 0.2617993877991494F));

        PartDefinition equipRightBase = armRight.addOrReplaceChild("EquipRightBase",
                CubeListBuilder.create().texOffs(78, 6)
                        .addBox(-7.5F, 0.0F, -4.5F, 13.0F, 14.0F, 9.0F),
                PartPose.offsetAndRotation(-6.0F, 16.0F, 0.0F, 0.0F, 0.0F, -0.08726646259971647F));

        equipRightBase.addOrReplaceChild("EquipRightBase1",
                CubeListBuilder.create().texOffs(85, 4)
                        .addBox(0.0F, -20.0F, 0.0F, 4.0F, 21.0F, 11.0F),
                PartPose.offsetAndRotation(-5.0F, 0.0F, -5.5F, 0.0F, 0.0F, -0.08726646259971647F));

        equipRightBase.addOrReplaceChild("EquipRightBase4",
                CubeListBuilder.create().texOffs(81, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 4.0F, 25.0F, 15.0F),
                PartPose.offsetAndRotation(-5.0F, 0.0F, -7.5F, 0.0F, 0.0F, -0.08726646259971647F));

        equipRightBase.addOrReplaceChild("EquipRightBase3",
                CubeListBuilder.create().texOffs(90, 8)
                        .addBox(0.0F, 0.0F, -3.5F, 3.0F, 8.0F, 7.0F),
                PartPose.offsetAndRotation(1.0F, 14.0F, 0.0F, 0.0F, 0.0F, -0.2617993877991494F));

        equipRightBase.addOrReplaceChild("EquipRightBase2",
                CubeListBuilder.create().texOffs(85, 5)
                        .addBox(-5.0F, 0.0F, -5.0F, 5.0F, 10.0F, 10.0F),
                PartPose.offsetAndRotation(-4.2F, 13.0F, 0.0F, 0.0F, 0.0F, 0.08726646259971647F));

        PartDefinition equipRightTube1 = equipRightBase.addOrReplaceChild("EquipRightTube1",
                CubeListBuilder.create().texOffs(82, 56)
                        .addBox(-1.5F, -16.0F, -1.5F, 3.0F, 16.0F, 3.0F),
                PartPose.offsetAndRotation(1.0F, 8.0F, 3.0F, -1.0471975511965976F, 0.0F, 0.0F));

        PartDefinition equipRightTube2 = equipRightTube1.addOrReplaceChild("EquipRightTube2",
                CubeListBuilder.create().texOffs(82, 56)
                        .addBox(-1.5F, -13.0F, -1.5F, 3.0F, 14.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, 0.7853981633974483F,
                        -0.17453292519943295F, 0.0F));

        equipRightTube2.addOrReplaceChild("EquipRightTube3",
                CubeListBuilder.create().texOffs(82, 56)
                        .addBox(-3.5F, -23.5F, -1.4F, 3.0F, 25.0F, 3.0F),
                PartPose.offsetAndRotation(2.0F, -12.0F, 0.0F, 1.3962634015954636F,
                        -0.3490658503988659F, 0.0F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(78, 5)
                        .addBox(-5.5F, 0.0F, -5.6F, 11.0F, 3.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, -13.0F, 1.0F, 0.1F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(43, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offset(0.0F, 0.5F, 0.0F));

        head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(34, 68)
                        .addBox(-8.0F, -8.0F, -7.2F, 16.0F, 16.0F, 16.0F),
                PartPose.offset(0.0F, -7.0F, 0.0F));

        PartDefinition headTail0 = head.addOrReplaceChild("HeadTail0",
                CubeListBuilder.create().texOffs(20, 54)
                        .addBox(-4.5F, 0.0F, -3.0F, 9.0F, 14.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, -15.0F, 8.0F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition headTail1 = headTail0.addOrReplaceChild("HeadTail1",
                CubeListBuilder.create().texOffs(24, 54)
                        .addBox(-3.5F, 0.0F, -3.0F, 7.0F, 16.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.09F, 0.0F, 0.0F));

        headTail1.addOrReplaceChild("HeadTail2",
                CubeListBuilder.create().texOffs(21, 55)
                        .addBox(-4.0F, 0.0F, -2.5F, 8.0F, 18.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 14.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

        neck.addOrReplaceChild("Cloak",
                CubeListBuilder.create().texOffs(0, 112)
                        .addBox(-8.0F, 0.0F, 0.0F, 16.0F, 16.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 1.0F, 4.0F, 1.3089969389957472F, 0.0F, 0.0F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(0, 36)
                        .addBox(-8.0F, 0.0F, -4.1F, 16.0F, 8.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition legRight = butt.addOrReplaceChild("LegRight",
                CubeListBuilder.create().texOffs(1, 85)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 17.0F, 6.0F),
                PartPose.offsetAndRotation(-4.7F, 7.5F, -1.0F, -0.2F, 0.0F, -0.087F));

        legRight.addOrReplaceChild("ShoesRight",
                CubeListBuilder.create().texOffs(52, 52)
                        .addBox(-3.5F, 17.0F, -3.5F, 7.0F, 9.0F, 7.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition legLeft = butt.addOrReplaceChild("LegLeft",
                CubeListBuilder.create().texOffs(1, 85)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 17.0F, 6.0F),
                PartPose.offsetAndRotation(4.7F, 7.5F, -1.0F, -0.087F, 0.0F, 0.087F));

        legLeft.addOrReplaceChild("ShoesLeft",
                CubeListBuilder.create().mirror().texOffs(52, 52)
                        .addBox(-3.5F, 17.0F, -3.5F, 7.0F, 9.0F, 7.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("EquipBase",
                CubeListBuilder.create().texOffs(82, 12)
                        .addBox(-5.0F, 0.0F, 0.0F, 10.0F, 7.0F, 4.0F),
                PartPose.offset(0.0F, -11.0F, 4.0F));

        bodyMain.addOrReplaceChild("BoobR",
                CubeListBuilder.create().texOffs(1, 26)
                        .addBox(-3.5F, 0.0F, -1.0F, 7.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(-3.3F, -8.5F, -2.5F, -0.7853981633974483F, -0.087F,
                        -0.087F));

        PartDefinition armLeft = bodyMain.addOrReplaceChild("ArmLeft",
                CubeListBuilder.create().mirror().texOffs(0, 53)
                        .addBox(0.0F, 0.0F, -2.5F, 5.0F, 25.0F, 5.0F),
                PartPose.offsetAndRotation(6.0F, -9.5F, 0.0F, -0.087F, 0.0F, -0.2617993877991494F));

        PartDefinition equipLeftBase = armLeft.addOrReplaceChild("EquipLeftBase",
                CubeListBuilder.create().texOffs(76, 1)
                        .addBox(-6.0F, 0.0F, -7.0F, 10.0F, 14.0F, 14.0F),
                PartPose.offsetAndRotation(7.0F, 16.0F, 0.0F, 0.0F, 0.0F, 0.08726646259971647F));

        equipLeftBase.addOrReplaceChild("EquipLeftBase2",
                CubeListBuilder.create().texOffs(82, 5)
                        .addBox(-3.0F, -7.0F, -5.0F, 8.0F, 7.0F, 10.0F),
                PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.025481807079117208F));

        equipLeftBase.addOrReplaceChild("EquipLeftBase4",
                CubeListBuilder.create().texOffs(83, 9)
                        .addBox(-6.5F, 0.0F, 0.0F, 11.0F, 16.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 6.5F, 2.5F, 0.08726646259971647F, 0.0F, 0.0F));

        equipLeftBase.addOrReplaceChild("EquipLeftBase3",
                CubeListBuilder.create().texOffs(77, 5)
                        .addBox(-7.5F, 5.0F, -10.0F, 13.0F, 19.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition equipLeftTube1 = equipLeftBase.addOrReplaceChild("EquipLeftTube1",
                CubeListBuilder.create().texOffs(82, 56)
                        .addBox(-1.5F, -16.0F, -1.5F, 3.0F, 16.0F, 3.0F),
                PartPose.offsetAndRotation(-2.0F, 8.0F, 3.0F, -0.6981317007977318F, 0.5235987755982988F,
                        0.0F));

        PartDefinition equipLeftTube2 = equipLeftTube1.addOrReplaceChild("EquipLeftTube2",
                CubeListBuilder.create().texOffs(82, 56)
                        .addBox(-1.5F, -12.0F, -1.5F, 3.0F, 12.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, 0.8726646259971648F, 0.0F, 0.0F));

        equipLeftTube2.addOrReplaceChild("EquipLeftTube3",
                CubeListBuilder.create().texOffs(82, 56)
                        .addBox(-1.5F, -20.0F, -1.5F, 3.0F, 20.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.4486232791552935F, 0.7853981633974483F,
                        0.2617993877991494F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -14.0F, 0.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -13.0F, 1.0F));

        PartDefinition glowHead = glowNeck.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.5F, 0.0F));
        addDefaultFaceParts(glowHead);

        PartDefinition glowArmLeft = glowBodyMain.addOrReplaceChild("GlowArmLeft",
                CubeListBuilder.create(),
                PartPose.offset(7.0F, -10.0F, 0.0F));

        PartDefinition glowEquipLeftBase = glowArmLeft.addOrReplaceChild("GlowEquipLeftBase",
                CubeListBuilder.create(),
                PartPose.offset(7.0F, 16.0F, 0.0F));

        PartDefinition glowEquipLeftBase3 = glowEquipLeftBase.addOrReplaceChild("GlowEquipLeftBase3",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        glowEquipLeftBase3.addOrReplaceChild("EquipLeftTooth",
                CubeListBuilder.create().texOffs(44, 0)
                        .addBox(-5.5F, 0.0F, 0.0F, 9.0F, 7.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 14.0F, -1.2F, 0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition glowArmRight = glowBodyMain.addOrReplaceChild("GlowArmRight",
                CubeListBuilder.create(),
                PartPose.offset(-7.0F, -10.0F, 0.0F));

        PartDefinition glowEquipRightBase = glowArmRight.addOrReplaceChild("GlowEquipRightBase",
                CubeListBuilder.create(),
                PartPose.offset(-6.0F, 16.0F, 0.0F));

        PartDefinition glowEquipRightBase2 = glowEquipRightBase.addOrReplaceChild("GlowEquipRightBase2",
                CubeListBuilder.create(),
                PartPose.offset(-4.2F, 13.0F, 0.0F));

        glowEquipRightBase2.addOrReplaceChild("EquipRightTooth1",
                CubeListBuilder.create().texOffs(44, 13)
                        .addBox(0.0F, 0.0F, -4.0F, 2.0F, 5.0F, 8.0F),
                PartPose.offset(0.0F, 4.0F, 0.0F));

        PartDefinition glowEquipRightBase3 = glowEquipRightBase.addOrReplaceChild("GlowEquipRightBase3",
                CubeListBuilder.create(),
                PartPose.offset(1.0F, 14.0F, 0.0F));

        glowEquipRightBase3.addOrReplaceChild("EquipRightTooth2",
                CubeListBuilder.create().texOffs(59, 24)
                        .addBox(0.0F, 0.0F, -2.5F, 2.0F, 5.0F, 5.0F),
                PartPose.offset(-1.6F, 2.3F, 0.0F));

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
        boolean fc1 = EmotionHelper.checkModelState(0, state); // left cannon
        boolean fc2 = EmotionHelper.checkModelState(1, state); // right cannon

        if (fc1) {
            this.EquipBase.visible = true;
            this.EquipLeftBase.visible = true;
            this.GlowEquipLeftBase.visible = true;
        }

        if (fc2) {
            this.EquipBase.visible = true;
            this.EquipRightBase.visible = true;
            this.GlowEquipRightBase.visible = true;
        }

        if (!fc1 && !fc2) {
            this.EquipBase.visible = false;
            this.EquipLeftBase.visible = false;
            this.EquipRightBase.visible = false;
            this.GlowEquipLeftBase.visible = false;
            this.GlowEquipRightBase.visible = false;
        }

        boolean flag = !EmotionHelper.checkModelState(2, state); // cloak
        this.Cloak.visible = !flag;

        flag = !EmotionHelper.checkModelState(3, state); // hair
        this.HeadTail0.visible = !flag;
    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowArmLeft.xRot = this.ArmLeft.xRot;
        this.GlowArmLeft.yRot = this.ArmLeft.yRot;
        this.GlowArmLeft.zRot = this.ArmLeft.zRot;
        this.GlowArmRight.xRot = this.ArmRight.xRot;
        this.GlowArmRight.yRot = this.ArmRight.yRot;
        this.GlowArmRight.zRot = this.ArmRight.zRot;
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

        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += 0.46F;
        this.setFaceHungry(ent);

        // 移動頭部 使其看人, 不看人時持續擺動頭部
        this.Head.xRot = 0.2F;
        this.Head.yRot = 0F;
        this.Head.zRot = 0F;
        // 正常站立動作
        this.Cloak.xRot = -0.2F;
        this.BoobL.xRot = -0.73F;
        this.BoobR.xRot = -0.73F;
        // body
        this.BodyMain.xRot = 0.3F;
        // hair
        this.HeadTail0.xRot = -0.05F;
        this.HeadTail1.xRot = -0.05F;
        // arm
        this.ArmLeft.xRot = -0.6F;
        this.ArmRight.xRot = -0.6F;
        this.ArmLeft.zRot = 0.5F;
        this.ArmRight.zRot = -0.5F;
        // leg
        this.LegLeft.xRot = -2F;
        this.LegLeft.yRot = 0.15F;
        this.LegLeft.zRot = 1.2F;
        this.LegRight.xRot = -2F;
        this.LegRight.yRot = -0.15F;
        this.LegRight.zRot = -1.2F;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float angleZ = Mth.cos(f2 * 0.08F);
        float addk1;
        float addk2;

        // 水上漂浮
        if (ent.getShipDepth(0) > 0D) {
            // [PORT] 1.10.2 -> 1.20.1: restore legacy water bobbing translation.
            this.offsetY += angleZ * 0.05F + 0.025F;
        }

        // leg move parm
        addk1 = Mth.cos(f * 0.6662F) * 1.4F * f1 - 0.087F;
        addk2 = Mth.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1 - 0.2F;

        // 移動頭部 使其看人, 不看人時持續擺動頭部
        this.Head.yRot = f3 * 0.01F; // 左右角度
        this.Head.xRot = f4 * 0.008F; // 上下角度

        // 正常站立動作
        this.Cloak.xRot = angleZ * 0.2F + 1F;
        this.BoobL.xRot = -angleZ * 0.06F - 0.73F;
        this.BoobR.xRot = -angleZ * 0.06F - 0.73F;
        // body
        this.BodyMain.xRot = -0.15F;
        // arm
        this.ArmLeft.zRot = angleZ * -0.06F - 0.25F;
        this.ArmLeft.xRot = 0.2F;
        this.ArmRight.xRot = 0.2F;
        this.ArmRight.yRot = 0F;
        this.ArmRight.zRot = angleZ * 0.06F + 0.25F;
        // leg
        this.LegLeft.zRot = 0.087F;
        this.LegRight.zRot = -0.087F;
        this.LegLeft.yRot = 0F;
        this.LegRight.yRot = 0F;
        // hair
        this.HeadTail0.xRot = angleZ * 0.05F + 0.26F;
        this.HeadTail1.xRot = angleZ * 0.1F + 0.09F;

        if (ent.getIsSprinting() || f1 > 0.9F) { // 奔跑動作
            this.ArmLeft.xRot = 1F;
            this.ArmRight.xRot = 1F;
            this.BodyMain.xRot = 0.5F;
            this.HeadTail0.xRot = angleZ * 0.05F + 0.8F;
            addk1 -= 0.4F;
            addk2 -= 0.4F;
        }

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        if (ent.getIsSneaking()) {
            // 潛行動作
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.05F;
            this.ArmLeft.xRot = 0.7F;
            this.ArmRight.xRot = 0.7F;
            this.BodyMain.xRot = 0.5F;
            addk1 -= 0.6F;
            addk2 -= 0.6F;
        }

        if (ent.getIsSitting() || ent.getIsRiding()) { // 騎乘動作
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.44F;
                this.ArmLeft.xRot = 0.6F;
                this.ArmRight.xRot = 0.6F;
                this.ArmLeft.zRot = -0.6F;
                this.ArmRight.zRot = 0.6F;
                this.BodyMain.xRot = -0.6F;
                this.Head.xRot -= 0.2F;
                addk1 = -1.58F;
                addk2 = -1.58F;
                this.LegLeft.zRot = 1.2F;
                this.LegRight.zRot = -1.2F;
                this.LegLeft.yRot = -0.75F;
                this.LegRight.yRot = 0.75F;
                this.HeadTail0.xRot += 0.7F;
            } else {
                this.ArmLeft.xRot = -0.6F;
                this.ArmLeft.zRot = 0.3F;
                this.ArmRight.xRot = -0.6F;
                this.ArmRight.zRot = -0.3F;
                this.BodyMain.xRot = 0.3F;
                this.Head.xRot -= 0.35F;
                addk1 = -2F;
                addk2 = -2F;
                this.LegLeft.yRot = 0.15F;
                this.LegRight.yRot = -0.15F;
                this.LegLeft.zRot = 1.2F;
                this.LegRight.zRot = -1.2F;
            }
        }

        // leg motion
        this.LegLeft.xRot = addk1;
        this.LegRight.xRot = addk2;

        // 攻擊時順便將左手指向對方
        if (ent.getAttackTick() > 15) {
            this.ArmLeft.xRot = f4 / 57.29578F - 1.5F;
            this.ArmRight.zRot = 0.7F;
            this.ArmRight.xRot = 0.4F;
        }

        // swing arm
        float f6 = ent.getSwingTime(f2 - (int) f2);
        if (f6 != 0F) {
            float f7 = Mth.sin(f6 * f6 * (float) Math.PI);
            float f8 = Mth.sin(Mth.sqrt(f6) * (float) Math.PI);
            this.ArmRight.xRot = -0.5F;
            this.ArmRight.yRot = 0F;
            this.ArmRight.zRot = 0.2F;
            this.ArmRight.xRot += -f8 * 80.0F * ((float) Math.PI / 180F);
            this.ArmRight.yRot += -f7 * 20.0F * ((float) Math.PI / 180F) + 0.2F;
            this.ArmRight.zRot += -f8 * 20.0F * ((float) Math.PI / 180F);
        }
    }
}
