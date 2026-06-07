package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.entity.IShipFloating;
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

public class ModelSubmRo500 extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "ss_ro500"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Neck;
    private final ModelPart ArmLeft01;
    private final ModelPart ArmRight01;
    private final ModelPart Butt;
    private final ModelPart Cloth01;
    private final ModelPart EquipBase1;
    private final ModelPart EquipBase2;
    private final ModelPart Head;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart FlowerBase;
    private final ModelPart Ahoke;
    private final ModelPart HairL01;
    private final ModelPart HairR01;
    private final ModelPart HairL02;
    private final ModelPart HairR02;
    private final ModelPart Hair01;
    private final ModelPart Flower1;
    private final ModelPart Flower2;
    private final ModelPart Flower3;
    private final ModelPart Flower4;
    private final ModelPart ArmLeft02;
    private final ModelPart ArmRight02;
    private final ModelPart LegRight01;
    private final ModelPart LegLeft01;
    private final ModelPart LegRight02;
    private final ModelPart LegLeft02;
    private final ModelPart Equip101;
    private final ModelPart Equip102;
    private final ModelPart Equip103;
    private final ModelPart Equip104;
    private final ModelPart Equip201;
    private final ModelPart Equip202;
    private final ModelPart Equip203;
    private final ModelPart Equip204;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowNeck;
    private final ModelPart GlowHead;

    public ModelSubmRo500(ModelPart root) {
        super();
        this.BodyMain = root.getChild("BodyMain");
        this.EquipBase1 = this.BodyMain.getChild("EquipBase1");
        this.Butt = this.BodyMain.getChild("Butt");
        this.EquipBase2 = this.BodyMain.getChild("EquipBase2");
        this.Neck = this.BodyMain.getChild("Neck");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.Cloth01 = this.BodyMain.getChild("Cloth01");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.Equip101 = this.EquipBase1.getChild("Equip101");
        this.LegLeft01 = this.Butt.getChild("LegLeft01");
        this.LegRight01 = this.Butt.getChild("LegRight01");
        this.Equip204 = this.EquipBase2.getChild("Equip204");
        this.Equip203 = this.EquipBase2.getChild("Equip203");
        this.Equip202 = this.EquipBase2.getChild("Equip202");
        this.Equip201 = this.EquipBase2.getChild("Equip201");
        this.Head = this.Neck.getChild("Head");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.Equip103 = this.Equip101.getChild("Equip103");
        this.Equip104 = this.Equip101.getChild("Equip104");
        this.Equip102 = this.Equip101.getChild("Equip102");
        this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.Hair = this.Head.getChild("Hair");
        this.HairMain = this.Head.getChild("HairMain");
        this.HairR01 = this.Hair.getChild("HairR01");
        this.HairL01 = this.Hair.getChild("HairL01");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.Hair01 = this.HairMain.getChild("Hair01");
        this.HairR02 = this.HairR01.getChild("HairR02");
        this.HairL02 = this.HairL01.getChild("HairL02");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowNeck = this.GlowBodyMain.getChild("GlowNeck");
        this.GlowHead = this.GlowNeck.getChild("GlowHead");
        this.FlowerBase = this.GlowHead.getChild("FlowerBase");
        this.Flower1 = this.FlowerBase.getChild("Flower1");
        this.Flower2 = this.FlowerBase.getChild("Flower2");
        this.Flower3 = this.FlowerBase.getChild("Flower3");
        this.Flower4 = this.FlowerBase.getChild("Flower4");
        this.loadFaceParts(this.GlowHead);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 104)
                        .addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, -13.5F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition equipBase1 = bodyMain.addOrReplaceChild("EquipBase1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offset(0.0F, 7.0F, 18.0F));

        PartDefinition equip101 = equipBase1.addOrReplaceChild("Equip101",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-15.0F, -2.5F, -2.5F, 36.0F, 5.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, -6.0F, -9.5F, 0.5235987755982988F,
                        0.05235987755982988F, 0.13962634015954636F));

        equip101.addOrReplaceChild("Equip103",
                CubeListBuilder.create().texOffs(24, 73)
                        .addBox(0.0F, -1.0F, -3.0F, 7.0F, 2.0F, 6.0F),
                PartPose.offsetAndRotation(-22.0F, 0.0F, 0.0F, 0.7853981633974483F, 0.0F, 0.0F));

        equip101.addOrReplaceChild("Equip104",
                CubeListBuilder.create().texOffs(54, 10)
                        .addBox(0.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F),
                PartPose.offset(21.0F, 0.0F, 0.0F));

        equip101.addOrReplaceChild("Equip102",
                CubeListBuilder.create().texOffs(28, 73)
                        .addBox(0.0F, -3.0F, -1.0F, 7.0F, 6.0F, 2.0F),
                PartPose.offsetAndRotation(-22.0F, 0.0F, 0.0F, 0.7853981633974483F, 0.0F, 0.0F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(82, 18)
                        .addBox(-7.5F, 4.8F, -5.6F, 15.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().texOffs(0, 85)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 13.0F, 6.0F),
                PartPose.offsetAndRotation(4.2F, 11.0F, -2.2F, -0.12217304763960307F, 0.0F,
                        -0.03490658503988659F));

        legLeft01.addOrReplaceChild("LegLeft02",
                CubeListBuilder.create().mirror().texOffs(0, 65)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offset(0.0F, 13.0F, -3.0F));

        PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().texOffs(0, 85)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 13.0F, 6.0F),
                PartPose.offsetAndRotation(-4.2F, 11.0F, -2.2F, -0.12217304763960307F, 0.0F,
                        0.03490658503988659F));

        legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().texOffs(0, 65)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offset(0.0F, 13.0F, -3.0F));

        PartDefinition equipBase2 = bodyMain.addOrReplaceChild("EquipBase2",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 8.0F, -2.0F, 0.3141592653589793F, 0.0F, 0.0F));

        equipBase2.addOrReplaceChild("Equip204",
                CubeListBuilder.create().texOffs(0, 10)
                        .addBox(0.0F, 0.0F, 0.0F, 24.0F, 6.0F, 6.0F),
                PartPose.offset(-9.0F, 0.0F, -14.0F));

        equipBase2.addOrReplaceChild("Equip203",
                CubeListBuilder.create().texOffs(46, 10)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 24.0F),
                PartPose.offsetAndRotation(9.0F, 6.0F, 16.0F, -3.141592653589793F, 0.0F, 0.0F));

        equipBase2.addOrReplaceChild("Equip202",
                CubeListBuilder.create().mirror().texOffs(0, 10)
                        .addBox(0.0F, 0.0F, 0.0F, 24.0F, 6.0F, 6.0F),
                PartPose.offset(-15.0F, 0.0F, 10.0F));

        equipBase2.addOrReplaceChild("Equip201",
                CubeListBuilder.create().texOffs(46, 10)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 24.0F),
                PartPose.offset(-15.0F, 0.0F, -14.0F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(0, 22)
                        .addBox(-3.0F, -2.0F, -3.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offset(0.0F, -1.5F, 0.0F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(50, 75)
                        .addBox(-8.0F, -8.0F, -6.8F, 16.0F, 17.0F, 8.0F),
                PartPose.offset(0.0F, -7.5F, -0.5F));

        PartDefinition hairR01 = hair.addOrReplaceChild("HairR01",
                CubeListBuilder.create().texOffs(88, 100)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 3.0F),
                PartPose.offsetAndRotation(-6.5F, 0.0F, -4.0F, -0.17453292519943295F,
                        0.17453292519943295F, 0.13962634015954636F));

        hairR01.addOrReplaceChild("HairR02",
                CubeListBuilder.create().mirror().texOffs(88, 100)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 3.0F),
                PartPose.offsetAndRotation(0.2F, 6.0F, 0.0F, -0.17453292519943295F, 0.0F,
                        -0.05235987755982988F));

        PartDefinition hairL01 = hair.addOrReplaceChild("HairL01",
                CubeListBuilder.create().mirror().texOffs(88, 100)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 3.0F),
                PartPose.offsetAndRotation(6.5F, 0.0F, -4.0F, -0.17453292519943295F,
                        -0.17453292519943295F, -0.13962634015954636F));

        hairL01.addOrReplaceChild("HairL02",
                CubeListBuilder.create().texOffs(88, 100)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, -0.17453292519943295F, 0.0F,
                        0.08726646259971647F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(104, 29)
                        .addBox(0.0F, -5.0F, -12.0F, 0.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -8.5F, -5.0F, 0.0F, 0.5235987755982988F, 0.0F));

        PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(48, 47)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 9.0F, 10.0F),
                PartPose.offset(0.0F, -15.0F, -3.0F));

        hairMain.addOrReplaceChild("Hair01",
                CubeListBuilder.create().texOffs(49, 47)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 18.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 9.0F, 1.1F, 0.3490658503988659F, 0.0F, 0.0F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().texOffs(24, 81)
                        .addBox(-4.5F, -0.5F, -2.5F, 5.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(-6.0F, -9.0F, -0.5F, 0.15707963267948966F, 0.0F,
                        0.3839724354387525F));

        armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().texOffs(24, 86)
                        .addBox(-2.5F, 0.0F, -5.0F, 5.0F, 11.0F, 5.0F),
                PartPose.offset(-2.0F, 10.5F, 2.5F));

        bodyMain.addOrReplaceChild("Cloth01",
                CubeListBuilder.create().texOffs(84, 0)
                        .addBox(-7.0F, 0.0F, -4.5F, 14.0F, 10.0F, 8.0F),
                PartPose.offset(0.0F, -11.3F, 0.0F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().mirror().texOffs(24, 81)
                        .addBox(-0.5F, -0.5F, -2.5F, 5.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(6.0F, -9.0F, -0.5F, 0.15707963267948966F, 0.0F,
                        -0.3839724354387525F));

        armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().mirror().texOffs(24, 56)
                        .addBox(-2.5F, 0.0F, -5.0F, 5.0F, 11.0F, 5.0F),
                PartPose.offset(2.0F, 10.5F, 2.5F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -13.5F, 0.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -10.5F, 0.0F));

        PartDefinition glowHead = glowNeck.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -1.5F, 0.0F));
        addDefaultFaceParts(glowHead);

        PartDefinition flowerBase = glowHead.addOrReplaceChild("FlowerBase",
                CubeListBuilder.create().texOffs(0, 7)
                        .addBox(0.0F, 0.0F, -1.5F, 0.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(8.8F, -12.0F, -4.0F, -0.6981317007977318F,
                        0.08726646259971647F, -0.08726646259971647F));

        flowerBase.addOrReplaceChild("Flower1",
                CubeListBuilder.create().texOffs(0, 7)
                        .addBox(0.0F, 0.0F, -1.5F, 0.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.3089969389957472F,
                        -0.08726646259971647F, 0.0F));

        flowerBase.addOrReplaceChild("Flower2",
                CubeListBuilder.create().texOffs(0, 7)
                        .addBox(0.0F, 0.0F, -1.5F, 0.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.530727415391778F, 0.0F,
                        -0.08726646259971647F));

        flowerBase.addOrReplaceChild("Flower3",
                CubeListBuilder.create().texOffs(0, 7)
                        .addBox(0.0F, 0.0F, -1.5F, 0.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.6179938779914944F, 0.0F,
                        -0.08726646259971647F));

        flowerBase.addOrReplaceChild("Flower4",
                CubeListBuilder.create().texOffs(0, 7)
                        .addBox(0.0F, 0.0F, -1.5F, 0.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.2217304763960306F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                          float headPitch) {
        IShipEmotion ent = (IShipEmotion) entity;
        // set scale per scaleLevel
        switch (ent.getScaleLevel()) {
            case 3:
                this.scale = 1.44F;
                this.offsetY = -0.45F;
                break;
            case 2:
                this.scale = 1.08F;
                this.offsetY = -0.06F;
                break;
            case 1:
                this.scale = 0.72F;
                this.offsetY = 0.66F;
                break;
            default:
                this.scale = 0.36F;
                this.offsetY = 2.86F;
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
        // [PORT] 1.10.2 -> 1.20.1: preserve legacy slight Y compression to match
        // grounding.
        poseStack.scale(scale, scale * 0.95F, scale);
        poseStack.translate(offsetX, offsetY, offsetZ);
        this.BodyMain.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.GlowBodyMain.render(poseStack, buffer, 0xF000F0, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();
    }

    @Override
    public void showEquip(IShipEmotion ent) {

        int state = ent.getStateEmotion(ID.S.State);

        boolean flag = !EmotionHelper.checkModelState(0, state); // equip1
        this.EquipBase1.visible = !flag;

        flag = !EmotionHelper.checkModelState(1, state); // equip2
        this.EquipBase2.visible = !flag;

        flag = !EmotionHelper.checkModelState(2, state); // flower
        if (this.FlowerBase != null)
            this.FlowerBase.visible = !flag;
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

        this.offsetY += 0.55F + 0.29F * ent.getScaleLevel();
        this.setFaceHungry(ent);

        // 頭部
        this.Head.xRot = -0.35F;
        this.Head.yRot = 0F;
        // body
        this.Ahoke.yRot = 0.5236F;
        this.BodyMain.xRot = -1.6F;
        // hair
        this.Hair01.xRot = 0.3F;
        // arm
        this.ArmLeft01.xRot = 3.1F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = 0.7F;
        this.ArmRight01.xRot = 3.1F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = -0.7F;
        this.ArmLeft02.xRot = 0F;
        this.ArmRight02.xRot = 0F;
        // leg
        this.LegLeft01.xRot = -0.2F;
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = -0.1F;
        this.LegRight01.xRot = -0.2F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = 0.1F;
        this.LegLeft02.xRot = 0F;
        this.LegRight02.xRot = 0F;
        // equip
        // this.EquipBase1.offsetZ = 0F;
        // this.EquipBase2.offsetY = 0F;
        this.EquipBase2.xRot = 0.3142F;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float angleX = Mth.cos(f2 * 0.08F);
        float angleX2 = Mth.cos(f2 * 0.25F);
        float angleAdd1 = Mth.cos(f * 0.7F) * f1;
        float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
        float addk1;
        float addk2;

        // 水上漂浮
        if (ent.getShipDepth(0) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        // leg move parm
        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += angleX * 0.05F + 0.025F;
        addk1 = angleAdd1 - 0.122F;
        addk2 = angleAdd2 - 0.122F;

        // 移動頭部使其看人
        this.Head.xRot = f4 * 0.014F;
        this.Head.yRot = f3 * 0.01F;

        // 正常站立動作
        // body
        this.Ahoke.yRot = angleX * 0.25F + 0.5236F;
        this.BodyMain.xRot = -0.1F;
        // hair
        this.Hair01.xRot = angleX * 0.06F + 0.3F;
        this.Hair01.zRot = 0F;
        this.HairL01.xRot = -0.17F;
        this.HairL02.xRot = 0.17F;
        this.HairR01.xRot = -0.17F;
        this.HairR02.xRot = 0.17F;
        this.HairL01.zRot = -0.14F;
        this.HairL02.zRot = 0.08F;
        this.HairR01.zRot = 0.14F;
        this.HairR02.zRot = -0.05F;
        // arm
        boolean flag = !EmotionHelper.checkModelState(1, ent.getStateEmotion(ID.S.State));
        this.ArmLeft01.xRot = 0.157F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = -0.384F;
        if (flag)
            this.ArmLeft01.zRot += -angleX * 0.06F;
        this.ArmRight01.xRot = 0.157F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = 0.384F;
        if (flag)
            this.ArmRight01.zRot += angleX * 0.06F;
        this.ArmLeft02.xRot = 0F;
        this.ArmRight02.xRot = 0F;
        // leg
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = -0.035F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = 0.035F;
        this.LegLeft02.xRot = 0F;
        this.LegRight02.xRot = 0F;
        // equip
        // this.EquipBase1.offsetZ = 0F;
        // this.EquipBase2.offsetY = 0F;
        this.EquipBase2.xRot = 0.3142F;

        if (ent.getIsSprinting() || f1 > 0.9F) { // 奔跑動作
            setFace(3);
            // Body
            this.BodyMain.xRot = 0.1745F;
            this.Head.xRot -= 0.35F;
            // leg move parm
            addk1 -= 0.25F;
            addk2 -= 0.25F;

            // change run type base on tickExisted
            if (ent.getTickExisted() % 256 > 128) { // run type 1
                // arm
                this.ArmLeft01.xRot = 2.6F;
                this.ArmLeft01.zRot = 0.7F;
                this.ArmRight01.xRot = 2.6F;
                this.ArmRight01.zRot = -0.7F;
            } else {
                // arm
                this.ArmRight01.xRot = -2.8F;
                this.ArmRight01.zRot = -0.7F;
            }
        }

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        if (ent.getIsSneaking()) { // 潛行, 蹲下動作
            // body
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.1F;
            this.Head.xRot -= 0.8727F;
            this.BodyMain.xRot = 1.0472F;
            // hair
            this.Hair01.xRot += 0.2236F;
            // leg
            addk1 -= 1.2F;
            addk2 -= 1.2F;
        } // end if sneaking

        if (ent.getIsSitting() || ent.getIsRiding()) { // 騎乘動作
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                ((IShipFloating) ent).getShipDepth();
                // body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY -= 0.21F;
                this.Head.xRot += 0.35F;
                this.BodyMain.xRot = -0.7F;
                // arm
                this.ArmLeft01.xRot = 0.5236F;
                this.ArmLeft01.zRot = -0.5236F;
                this.ArmLeft02.xRot = -1.0472F;
                this.ArmRight01.xRot = 0.7F;
                this.ArmRight01.zRot = 0.5236F;
                this.ArmRight02.xRot = -1.0472F;
                // leg
                addk1 = -1.9F;
                addk2 = -1.9F;
                this.LegLeft02.xRot = angleX2 * 0.4F + 0.8F;
                this.LegRight02.xRot = -angleX2 * 0.4F + 0.8F;
                // equip
                // this.EquipBase1.offsetZ = -0.9F;
                this.EquipBase2.visible = true;
                this.EquipBase2.xRot = 0.7F;
            } else {
                ((IShipFloating) ent).getShipDepth();
                // body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY -= 0.22F;
                this.Head.xRot += 0.2F;
                this.BodyMain.xRot = -0.7F;
                // arm
                this.ArmLeft01.xRot = 0.95F;
                this.ArmLeft01.zRot = -0.3146F;
                this.ArmRight01.xRot = 0.95F;
                this.ArmRight01.zRot = 0.3146F;
                // leg
                addk1 = -1.1F;
                addk2 = -1.1F;
                this.LegLeft01.yRot = -0.3491F;
                this.LegRight01.yRot = 0.3491F;
                // equip
                // this.EquipBase1.offsetZ = -0.15F;
                // this.EquipBase2.offsetY = -0.15F;
            }
        } // end if sitting

        // 攻擊動作
        if (ent.getAttackTick() > 41) {
            setFace(3);
            // swing arm
            float ft = (50 - ent.getAttackTick()) + (f2 - (int) f2);
            ft *= 0.125F;
            float fa = Mth.sin(ft * ft * (float) Math.PI);
            float fb = Mth.sin(Mth.sqrt(ft) * (float) Math.PI);
            this.ArmLeft01.xRot += -fb * 180.0F * ((float) Math.PI / 180F) + 0.1F;
            this.ArmLeft01.yRot += fa * 20.0F * ((float) Math.PI / 180F) - 0.6F;
            this.ArmLeft01.zRot += fb * 20.0F * ((float) Math.PI / 180F);
            this.ArmRight01.xRot += -fb * 180.0F * ((float) Math.PI / 180F) + 0.1F;
            this.ArmRight01.yRot += -fa * 20.0F * ((float) Math.PI / 180F) + 0.6F;
            this.ArmRight01.zRot += -fb * 20.0F * ((float) Math.PI / 180F);
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
