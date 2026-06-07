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

public class ModelMountSuH extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "mount_suh"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Neck;
    private final ModelPart Head01;
    private final ModelPart Jaw;
    private final ModelPart NeckFront;
    private final ModelPart Body01;
    private final ModelPart Head02;
    private final ModelPart Head03;
    private final ModelPart Head04;
    private final ModelPart Head05;
    private final ModelPart Head06;
    private final ModelPart Head07a;
    private final ModelPart HeadTooth;
    private final ModelPart Eye01a;
    private final ModelPart Eye01b;
    private final ModelPart Eye02a;
    private final ModelPart Eye02b;
    private final ModelPart Eye03a;
    private final ModelPart Eye03b;
    private final ModelPart JawTooth;
    private final ModelPart Jaw02;
    private final ModelPart Body02;
    private final ModelPart Body01a;
    private final ModelPart Body02a;
    private final ModelPart Body02b;
    private final ModelPart Body03;
    private final ModelPart Body03a;
    private final ModelPart Body03b;
    private final ModelPart Body04;
    private final ModelPart Body04a;
    private final ModelPart Body04b;
    private final ModelPart Bridge02;
    private final ModelPart Bridge01;
    private final ModelPart Head07b;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowNeck;
    private final ModelPart GlowJaw;
    private final ModelPart GlowHead01;

    public ModelMountSuH(ModelPart root) {
        super();
        this.BodyMain = root.getChild("BodyMain");
        this.Neck = this.BodyMain.getChild("Neck");
        this.Head04 = this.Neck.getChild("Head04");
        this.Head06 = this.Neck.getChild("Head06");
        this.Head02 = this.Neck.getChild("Head02");
        this.Head07a = this.Neck.getChild("Head07a");
        this.Head03 = this.Neck.getChild("Head03");
        this.Head05 = this.Neck.getChild("Head05");
        this.Jaw = this.Neck.getChild("Jaw");
        this.Body01 = this.Neck.getChild("Body01");
        this.Head01 = this.Neck.getChild("Head01");
        this.Head07b = this.Head07a.getChild("Head07b");
        this.Bridge01 = this.Head03.getChild("Bridge01");
        this.Jaw02 = this.Jaw.getChild("Jaw02");
        this.Body01a = this.Body01.getChild("Body01a");
        this.Body02 = this.Body01.getChild("Body02");
        this.Bridge02 = this.Body01a.getChild("Bridge02");
        this.Body03 = this.Body02.getChild("Body03");
        this.Body02b = this.Body02.getChild("Body02b");
        this.Body02a = this.Body02.getChild("Body02a");
        this.Body03b = this.Body03.getChild("Body03b");
        this.Body03a = this.Body03.getChild("Body03a");
        this.Body04 = this.Body03.getChild("Body04");
        this.Body04a = this.Body04.getChild("Body04a");
        this.Body04b = this.Body04.getChild("Body04b");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowNeck = this.GlowBodyMain.getChild("GlowNeck");
        this.GlowJaw = this.GlowNeck.getChild("GlowJaw");
        this.GlowHead01 = this.GlowNeck.getChild("GlowHead01");
        this.JawTooth = this.GlowJaw.getChild("JawTooth");
        this.NeckFront = this.GlowNeck.getChild("NeckFront");
        this.HeadTooth = this.GlowHead01.getChild("HeadTooth");
        this.Eye01a = this.GlowHead01.getChild("Eye01a");
        this.Eye01b = this.GlowHead01.getChild("Eye01b");
        this.Eye02a = this.GlowHead01.getChild("Eye02a");
        this.Eye02b = this.GlowHead01.getChild("Eye02b");
        this.Eye03a = this.GlowHead01.getChild("Eye03a");
        this.Eye03b = this.GlowHead01.getChild("Eye03b");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offset(0.0F, 10.0F, 8.0F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-7.0F, -7.5F, -14.0F, 14.0F, 15.0F, 14.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        neck.addOrReplaceChild("Head04",
                CubeListBuilder.create().texOffs(0, 3)
                        .addBox(-9.5F, 0.0F, 0.0F, 19.0F, 8.0F, 12.0F),
                PartPose.offset(0.0F, -23.9F, -29.9F));

        neck.addOrReplaceChild("Head06",
                CubeListBuilder.create().texOffs(0, 3)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 6.0F, 11.0F),
                PartPose.offset(0.0F, -12.1F, -40.8F));

        neck.addOrReplaceChild("Head02",
                CubeListBuilder.create().texOffs(0, 3)
                        .addBox(-9.5F, 0.0F, 0.0F, 19.0F, 10.0F, 12.0F),
                PartPose.offset(0.0F, -16.0F, -29.9F));

        PartDefinition head07a = neck.addOrReplaceChild("Head07a",
                CubeListBuilder.create().texOffs(0, 4)
                        .addBox(-6.0F, 0.0F, -6.0F, 12.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -23.8F, -41.7F, 0.0F, 0.7853981633974483F, 0.0F));

        head07a.addOrReplaceChild("Head07b",
                CubeListBuilder.create().texOffs(0, 4)
                        .addBox(-5.0F, 0.0F, -5.0F, 10.0F, 12.0F, 10.0F),
                PartPose.offset(-0.7F, 5.5F, 0.7F));

        PartDefinition head03 = neck.addOrReplaceChild("Head03",
                CubeListBuilder.create().texOffs(0, 3)
                        .addBox(-9.5F, 0.0F, 0.0F, 19.0F, 8.0F, 12.0F),
                PartPose.offset(0.0F, -23.9F, -18.0F));

        head03.addOrReplaceChild("Bridge01",
                CubeListBuilder.create().texOffs(0, 44)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 12.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.1F, 0.0F, 1.5707963267948966F, 0.0F, 0.0F));

        neck.addOrReplaceChild("Head05",
                CubeListBuilder.create().texOffs(0, 3)
                        .addBox(-8.5F, 0.0F, 0.0F, 17.0F, 12.0F, 12.0F),
                PartPose.offset(0.0F, -24.0F, -41.8F));

        PartDefinition jaw = neck.addOrReplaceChild("Jaw",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-7.5F, 0.0F, -16.0F, 15.0F, 7.0F, 16.0F),
                PartPose.offsetAndRotation(0.0F, 2.0F, -11.6F, 0.2617993877991494F, 0.0F, 0.0F));

        jaw.addOrReplaceChild("Jaw02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-5.5F, 0.0F, -5.5F, 11.0F, 5.0F, 11.0F),
                PartPose.offsetAndRotation(0.0F, 0.8F, -14.8F, -0.33161255787892263F,
                        0.7853981633974483F, -0.2408554367752175F));

        PartDefinition body01 = neck.addOrReplaceChild("Body01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-8.5F, -12.0F, 0.0F, 17.0F, 12.0F, 12.0F),
                PartPose.offset(0.0F, -3.0F, -8.3F));

        PartDefinition body01a = body01.addOrReplaceChild("Body01a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-7.0F, 0.0F, 0.0F, 14.0F, 9.0F, 11.0F),
                PartPose.offset(0.0F, -20.7F, 0.0F));

        body01a.addOrReplaceChild("Bridge02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 10.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 0.1F, 0.0F, 1.5707963267948966F, 0.0F, 0.0F));

        PartDefinition body02 = body01.addOrReplaceChild("Body02",
                CubeListBuilder.create().texOffs(0, 3)
                        .addBox(-7.0F, -15.0F, 0.0F, 14.0F, 15.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 5.0F, 6.0F, -0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition body03 = body02.addOrReplaceChild("Body03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-8.0F, -10.0F, 0.0F, 16.0F, 10.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -3.0F, 8.0F, -0.17453292519943295F, 0.0F, 0.0F));

        body03.addOrReplaceChild("Body03b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-5.5F, 0.0F, 0.0F, 11.0F, 10.0F, 12.0F),
                PartPose.offset(0.0F, -19.9F, -2.0F));

        body03.addOrReplaceChild("Body03a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-6.0F, -6.0F, 0.0F, 12.0F, 6.0F, 11.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, 4.5F, 0.4363323129985824F, 0.0F, 0.0F));

        PartDefinition body04 = body03.addOrReplaceChild("Body04",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-4.5F, -8.0F, 0.0F, 9.0F, 8.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, -1.0F, 11.0F, 0.4363323129985824F, 0.0F, 0.0F));

        body04.addOrReplaceChild("Body04a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.5F, -6.0F, 0.0F, 5.0F, 6.0F, 5.0F),
                PartPose.offset(0.0F, -1.0F, 9.5F));

        body04.addOrReplaceChild("Body04b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.5F, 0.0F, 0.0F, 7.0F, 9.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -15.6F, 6.0F, -0.4363323129985824F, 0.0F, 0.0F));

        body02.addOrReplaceChild("Body02b",
                CubeListBuilder.create().texOffs(0, 3)
                        .addBox(-4.5F, 0.0F, 0.0F, 9.0F, 7.0F, 12.0F),
                PartPose.offset(0.0F, -21.8F, -2.0F));

        body02.addOrReplaceChild("Body02a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-6.5F, 0.0F, 0.0F, 13.0F, 7.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -2.1F, 0.0F, 0.2617993877991494F, 0.0F, 0.0F));

        neck.addOrReplaceChild("Head01",
                CubeListBuilder.create().texOffs(0, 3)
                        .addBox(-9.5F, -7.0F, -11.0F, 19.0F, 10.0F, 12.0F),
                PartPose.offset(0.0F, -9.0F, -7.0F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 10.0F, 8.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition glowJaw = glowNeck.addOrReplaceChild("GlowJaw",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 2.0F, -11.6F));

        PartDefinition glowHead01 = glowNeck.addOrReplaceChild("GlowHead01",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -9.0F, -7.0F));

        glowJaw.addOrReplaceChild("JawTooth",
                CubeListBuilder.create().texOffs(57, 46).mirror(true)
                        .addBox(-6.5F, 0.0F, -14.0F, 13.0F, 3.0F, 14.0F),
                PartPose.offsetAndRotation(0.0F, -1.7F, -2.0F, -0.08726646259971647F,
                        -0.02234021442552742F, 0.0F));

        glowNeck.addOrReplaceChild("NeckFront",
                CubeListBuilder.create().texOffs(30, 48)
                        .addBox(-5.5F, 0.0F, 0.0F, 11.0F, 14.0F, 2.0F),
                PartPose.offset(0.0F, -8.5F, -15.0F));

        glowHead01.addOrReplaceChild("HeadTooth",
                CubeListBuilder.create().texOffs(56, 45)
                        .addBox(-6.5F, 0.0F, -6.5F, 13.0F, 4.0F, 15.0F),
                PartPose.offsetAndRotation(0.0F, 2.5F, -15.0F, 0.05235987755982988F, 0.0F, 0.0F));

        glowHead01.addOrReplaceChild("Eye01a",
                CubeListBuilder.create().texOffs(77, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 8.0F, 8.0F),
                PartPose.offset(9.6F, -9.0F, -15.0F));

        glowHead01.addOrReplaceChild("Eye01b",
                CubeListBuilder.create().texOffs(77, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 8.0F, 8.0F),
                PartPose.offset(-9.6F, -9.0F, -15.0F));

        glowHead01.addOrReplaceChild("Eye02a",
                CubeListBuilder.create().texOffs(77, 8)
                        .addBox(0.0F, 0.0F, 0.1F, 0.0F, 8.0F, 8.0F),
                PartPose.offset(9.6F, -9.0F, -15.0F));

        glowHead01.addOrReplaceChild("Eye02b",
                CubeListBuilder.create().texOffs(77, 8)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 8.0F, 8.0F),
                PartPose.offset(-9.6F, -9.0F, -15.0F));

        glowHead01.addOrReplaceChild("Eye03a",
                CubeListBuilder.create().texOffs(77, 16)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 8.0F, 8.0F),
                PartPose.offset(9.6F, -9.0F, -15.0F));

        glowHead01.addOrReplaceChild("Eye03b",
                CubeListBuilder.create().texOffs(77, 16)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 8.0F, 8.0F),
                PartPose.offset(-9.6F, -9.0F, -15.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                          float headPitch) {
        IShipEmotion ent = (IShipEmotion) entity;
        float angleX = Mth.cos(ageInTicks * 0.08F);

        this.offsetY = 0F;
        if (ent.getShipDepth(0) > 0D) {
            // [PORT] 1.10.2 -> 1.20.1: restore mount water bobbing translation.
            // [RENDER?] Visual check required: water bobbing amplitude should match 1.10.2
            // mount behavior.
            // [REPRO?] Unverified visually: compare idle-on-water Y oscillation in client
            // runtime.
            this.offsetY += angleX * 0.025F + 0.025F;
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

    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowJaw.xRot = this.Jaw.xRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

    }
}
