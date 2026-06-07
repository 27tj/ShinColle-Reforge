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

public class ModelSubmU511 extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "ss_u511"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Neck;
    private final ModelPart ArmLeft01;
    private final ModelPart ArmRight01;
    private final ModelPart Butt;
    private final ModelPart Cloth01;
    private final ModelPart EquipBase;
    private final ModelPart Head;
    private final ModelPart Pipe;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart Hat01;
    private final ModelPart Ahoke;
    private final ModelPart HairL01;
    private final ModelPart HairR01;
    private final ModelPart HairL02;
    private final ModelPart HairR02;
    private final ModelPart Hair01;
    private final ModelPart Hat02;
    private final ModelPart Ear1;
    private final ModelPart Ear2;
    private final ModelPart ArmLeft02;
    private final ModelPart ArmLeft03;
    private final ModelPart ArmRight02;
    private final ModelPart ArmRight03;
    private final ModelPart LegRight01;
    private final ModelPart LegLeft01;
    private final ModelPart Skirt;
    private final ModelPart LegRight02;
    private final ModelPart LegLeft02;
    private final ModelPart EquipMid;
    private final ModelPart EquipL;
    private final ModelPart EquipR;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowNeck;
    private final ModelPart GlowHead;

    public ModelSubmU511(ModelPart root) {
        super();
        this.BodyMain = root.getChild("BodyMain");
        this.Cloth01 = this.BodyMain.getChild("Cloth01");
        this.Neck = this.BodyMain.getChild("Neck");
        this.Butt = this.BodyMain.getChild("Butt");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.EquipBase = this.BodyMain.getChild("EquipBase");
        this.Head = this.Neck.getChild("Head");
        this.Pipe = this.Neck.getChild("Pipe");
        this.Skirt = this.Butt.getChild("Skirt");
        this.LegRight01 = this.Butt.getChild("LegRight01");
        this.LegLeft01 = this.Butt.getChild("LegLeft01");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.EquipMid = this.EquipBase.getChild("EquipMid");
        this.Hat01 = this.Head.getChild("Hat01");
        this.Hair = this.Head.getChild("Hair");
        this.HairMain = this.Head.getChild("HairMain");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
        this.ArmRight03 = this.ArmRight02.getChild("ArmRight03");
        this.ArmLeft03 = this.ArmLeft02.getChild("ArmLeft03");
        this.EquipL = this.EquipMid.getChild("EquipL");
        this.EquipR = this.EquipMid.getChild("EquipR");
        this.Hat02 = this.Hat01.getChild("Hat02");
        this.HairL01 = this.Hair.getChild("HairL01");
        this.HairR01 = this.Hair.getChild("HairR01");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.Hair01 = this.HairMain.getChild("Hair01");
        this.Ear2 = this.Hat02.getChild("Ear2");
        this.Ear1 = this.Hat02.getChild("Ear1");
        this.HairL02 = this.HairL01.getChild("HairL02");
        this.HairR02 = this.HairR01.getChild("HairR02");

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
                        .addBox(-6.5F, -11.0F, -4.0F, 13.0F, 21.0F, 7.0F),
                PartPose.offset(0.0F, -13.0F, 0.0F));

        bodyMain.addOrReplaceChild("Cloth01",
                CubeListBuilder.create().texOffs(84, 0)
                        .addBox(-7.0F, 0.0F, -4.5F, 14.0F, 11.0F, 8.0F),
                PartPose.offset(0.0F, -11.5F, 0.0F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-4.5F, -2.0F, -6.0F, 9.0F, 4.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offset(0.0F, -1.5F, 0.0F));

        PartDefinition hat01 = head.addOrReplaceChild("Hat01",
                CubeListBuilder.create().texOffs(30, 24)
                        .addBox(-3.0F, -6.0F, 0.5F, 6.0F, 6.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, -15.0F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));

        PartDefinition hat02 = hat01.addOrReplaceChild("Hat02",
                CubeListBuilder.create().texOffs(4, 17)
                        .addBox(-8.0F, 0.0F, 0.5F, 16.0F, 1.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 0.5F, 8.4F, 0.3141592653589793F, 0.0F, 0.0F));

        hat02.addOrReplaceChild("Ear2",
                CubeListBuilder.create().texOffs(4, 18)
                        .addBox(0.0F, 0.0F, -4.0F, 0.0F, 8.0F, 5.0F),
                PartPose.offsetAndRotation(-8.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.2617993877991494F));

        hat02.addOrReplaceChild("Ear1",
                CubeListBuilder.create().mirror().texOffs(4, 18)
                        .addBox(0.0F, 0.0F, -4.0F, 0.0F, 8.0F, 5.0F),
                PartPose.offsetAndRotation(8.0F, -1.0F, 0.0F, 0.0F, 0.0F, -0.2617993877991494F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(50, 75)
                        .addBox(-8.0F, -8.0F, -6.8F, 16.0F, 17.0F, 8.0F),
                PartPose.offset(0.0F, -7.5F, -0.5F));

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

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(104, 29)
                        .addBox(0.0F, -4.0F, -11.0F, 0.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -8.0F, -5.0F, 0.0F, 0.5235987755982988F, 0.0F));

        PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(48, 47)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 9.0F, 10.0F),
                PartPose.offset(0.0F, -15.0F, -3.0F));

        hairMain.addOrReplaceChild("Hair01",
                CubeListBuilder.create().texOffs(49, 47)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 18.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 9.0F, 1.1F, 0.2617993877991494F, 0.0F, 0.0F));

        neck.addOrReplaceChild("Pipe",
                CubeListBuilder.create().texOffs(0, 17)
                        .addBox(0.0F, -26.0F, 0.0F, 1.0F, 25.0F, 1.0F),
                PartPose.offsetAndRotation(7.0F, -1.0F, -3.5F, -0.08726646259971647F, 0.0F,
                        0.08726646259971647F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(80, 19)
                        .addBox(-8.0F, 5.0F, -5.0F, 16.0F, 9.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2617993877991494F, 0.0F, 0.0F));

        butt.addOrReplaceChild("Skirt",
                CubeListBuilder.create().texOffs(80, 19)
                        .addBox(-8.0F, 0.0F, -4.5F, 16.0F, 9.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 5.0F, -2.0F, 0.3490658503988659F, -3.141592653589793F,
                        0.0F));

        PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().texOffs(0, 85)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 13.0F, 6.0F),
                PartPose.offsetAndRotation(-3.8F, 9.5F, -2.7F, -0.2618F, 0.0F, -0.03490658503988659F));

        legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().texOffs(0, 67)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offset(0.0F, 13.0F, -3.0F));

        PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().texOffs(0, 85)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 13.0F, 6.0F),
                PartPose.offsetAndRotation(3.8F, 9.5F, -2.7F, -0.2618F, 0.0F, 0.03490658503988659F));

        legLeft01.addOrReplaceChild("LegLeft02",
                CubeListBuilder.create().texOffs(0, 67)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 14.0F, 6.0F),
                PartPose.offset(0.0F, 13.0F, -3.0F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().texOffs(24, 67)
                        .addBox(-4.5F, -1.0F, -3.5F, 7.0F, 8.0F, 7.0F),
                PartPose.offsetAndRotation(-7.2F, -9.0F, -0.7F, 0.0F, 0.0F, 0.10471975511965977F));

        PartDefinition armRight02 = armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().texOffs(24, 95)
                        .addBox(-2.5F, 0.0F, -3.0F, 5.0F, 3.0F, 5.0F),
                PartPose.offset(-0.8F, 7.0F, 0.5F));

        armRight02.addOrReplaceChild("ArmRight03",
                CubeListBuilder.create().texOffs(28, 78)
                        .addBox(-2.5F, 0.0F, -4.0F, 5.0F, 11.0F, 5.0F),
                PartPose.offset(0.0F, 3.0F, 1.0F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().mirror().texOffs(24, 67)
                        .addBox(-2.5F, -1.0F, -3.5F, 7.0F, 8.0F, 7.0F),
                PartPose.offsetAndRotation(7.2F, -9.0F, -0.7F, 0.0F, 0.0F, -0.10471975511965977F));

        PartDefinition armLeft02 = armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().mirror().texOffs(24, 95)
                        .addBox(-2.5F, 0.0F, -3.0F, 5.0F, 3.0F, 5.0F),
                PartPose.offset(0.8F, 7.0F, 0.5F));

        armLeft02.addOrReplaceChild("ArmLeft03",
                CubeListBuilder.create().mirror().texOffs(28, 78)
                        .addBox(-2.5F, 0.0F, -4.0F, 5.0F, 11.0F, 5.0F),
                PartPose.offset(0.0F, 3.0F, 1.0F));

        PartDefinition equipBase = bodyMain.addOrReplaceChild("EquipBase",
                CubeListBuilder.create().texOffs(60, 0)
                        .addBox(-3.0F, 0.0F, 1.0F, 6.0F, 16.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 8.0F, 3.0F, 0.4363323129985824F, 0.0F, 0.0F));

        PartDefinition equipMid = equipBase.addOrReplaceChild("EquipMid",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-13.0F, 0.0F, 0.0F, 26.0F, 12.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, -5.0F, 2.0F, 0.13962634015954636F, 0.0F, 0.0F));

        equipMid.addOrReplaceChild("EquipL",
                CubeListBuilder.create().mirror().texOffs(0, 23)
                        .addBox(0.0F, 0.0F, -20.0F, 5.0F, 13.0F, 20.0F),
                PartPose.offsetAndRotation(11.5F, 0.0F, 4.0F, -0.3141592653589793F,
                        -0.17453292519943295F, 0.0F));

        equipMid.addOrReplaceChild("EquipR",
                CubeListBuilder.create().texOffs(0, 23)
                        .addBox(-5.0F, 0.0F, -20.0F, 5.0F, 13.0F, 20.0F),
                PartPose.offsetAndRotation(-11.5F, 0.0F, 4.0F, -0.3141592653589793F,
                        0.17453292519943295F, 0.0F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -13.0F, 0.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -10.5F, 0.0F));

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

        boolean flag = !EmotionHelper.checkModelState(0, state); // cannon
        this.EquipBase.visible = !flag;

        flag = !EmotionHelper.checkModelState(1, state); // hat
        this.Hat01.visible = !flag;

        flag = !EmotionHelper.checkModelState(2, state); // tube
        this.Pipe.visible = !flag;
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

        this.offsetY += 0.41F + 0.19F * ent.getScaleLevel();
        this.setFaceHungry(ent);

        // leg
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.035F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.035F;
        this.LegLeft01.xRot = -2.8F;
        this.LegLeft02.xRot = 1.4F;
        this.LegRight01.xRot = -2.8F;
        this.LegRight02.xRot = 1.4F;
        // equip
        this.Pipe.xRot = -0.0873F;
        // body
        this.Ahoke.yRot = 0.5236F;
        this.Head.xRot = 0.2618F;
        this.Head.yRot = 0F;
        this.BodyMain.xRot = 0.35F;
        // arm
        this.ArmLeft01.xRot = -0.7F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = -0.12F;
        this.ArmRight01.xRot = -0.96F;
        this.ArmRight01.yRot = -0.35F;
        this.ArmRight01.zRot = 0.12F;
        this.ArmRight03.zRot = -1.57F;
        // this.ArmRight03.offsetX = -0.153F;
        // this.ArmRight03.offsetY = 0.1F;
        // hair
        this.Hair01.xRot = 0.05F;
        this.Ear1.zRot = -0.2618F;
        this.Ear2.zRot = 0.2618F;
        // skirt
        this.Skirt.xRot = 2.618F;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float angleX = Mth.cos(f2 * 0.08F);
        float angleAdd1 = Mth.cos(f * 0.7F) * f1 * 0.5F;
        float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.5F;
        float addk1;
        float addk2;

        // 水上漂浮
        if (ent.getShipDepth(0) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        // leg move parm
        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += angleX * 0.05F + 0.025F;
        addk1 = angleAdd1 - 0.2118F;
        addk2 = angleAdd2 - 0.1118F;

        // 移動頭部使其看人
        this.Head.xRot = f4 * 0.014F + 0.1F;
        this.Head.yRot = f3 * 0.01F;

        // 正常站立動作
        // Body
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
        this.Ear1.zRot = angleX * 0.1F - 0.2618F;
        this.Ear2.zRot = angleX * 0.1F + 0.2618F;
        // arm
        this.ArmLeft01.xRot = angleAdd2 * 0.5F + 0.15F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = -angleX * 0.06F - 0.16F;
        this.ArmRight01.xRot = angleAdd1 * 0.5F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = angleX * 0.06F + 0.16F;
        this.ArmRight03.zRot = 0F;
        // this.ArmRight03.offsetX = 0F;
        // this.ArmRight03.offsetY = 0F;
        // leg
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.035F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.035F;
        this.LegLeft02.xRot = 0F;
        this.LegRight02.xRot = 0F;
        // equip
        this.Pipe.xRot = -0.0873F;
        // skirt
        this.Skirt.xRot = 0.35F;

        ent.getIsSprinting(); // 奔跑動作
        // 無特殊奔跑動作


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
            // equip
            this.Pipe.xRot = -0.7854F;
            // skirt
            this.Skirt.xRot = 0.8727F;
        } // end if sneaking

        if (ent.getIsSitting() || ent.getIsRiding()) { // 騎乘動作
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                // body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.41F;
                this.Head.xRot += 0.2618F;
                this.BodyMain.xRot = 0.35F;
                // hair
                this.HairL01.xRot -= 0.2F;
                this.HairR01.xRot -= 0.2F;
                this.HairL02.xRot -= 0.2F;
                this.HairR02.xRot -= 0.2F;
                // arm
                this.ArmLeft01.xRot = -angleX * 0.2F - 0.7F;
                this.ArmRight01.xRot = -0.96F;
                this.ArmRight01.yRot = -0.35F;
                this.ArmRight03.zRot = -1.57F;
                // this.ArmRight03.offsetX = -0.153F;
                // this.ArmRight03.offsetY = 0.1F;
                // hair
                this.Hair01.xRot -= 0.25F;
                // leg
                addk1 = -2.8F;
                addk2 = -2.8F;
                this.LegLeft02.xRot = 1.4F;
                this.LegRight02.xRot = 1.4F;
                // skirt
                this.Skirt.xRot = 2.618F;
            } else {
                // body
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.4F;
                this.Head.xRot -= 0.7F;
                this.BodyMain.xRot = 0.5236F;
                // hair
                this.HairL01.xRot -= 0.3F;
                this.HairR01.xRot -= 0.3F;
                this.HairL02.xRot -= 0.3F;
                this.HairR02.xRot -= 0.3F;
                // arm
                this.ArmLeft01.xRot = -0.5236F;
                this.ArmLeft01.zRot = 0.3146F;
                this.ArmRight01.xRot = -0.5236F;
                this.ArmRight01.zRot = -0.3146F;
                // leg
                addk1 = -2.2689F;
                addk2 = -2.2689F;
                this.LegLeft01.yRot = -0.3491F;
                this.LegRight01.yRot = 0.3491F;
                // equip
                this.Pipe.xRot = -0.7854F;
                // skirt
                this.Skirt.xRot = 0.8727F;
            }
        } // end if sitting

        // attack
        if (ent.getAttackTick() > 43) {
            // swing arm
            float ft = (50 - ent.getAttackTick()) + (f2 - (int) f2);
            ft *= 0.08F;
            float fa = Mth.cos(ft * ft * (float) Math.PI);
            float fb = Mth.cos(Mth.sqrt(ft) * (float) Math.PI);
            this.ArmLeft01.xRot += -fb * 80.0F * ((float) Math.PI / 180F) - 0.9F;
            this.ArmLeft01.yRot += fa * 20.0F * ((float) Math.PI / 180F) - 0.3F;
            this.ArmLeft01.zRot += fb * 10.0F * ((float) Math.PI / 180F);
        } // end attack

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

        // 鬢毛調整
        float headX = this.Head.xRot * -0.5F;
        float headZ = this.Head.zRot * -0.5F;
        this.Hair01.xRot += headX;
        this.Hair01.zRot += headZ;
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
