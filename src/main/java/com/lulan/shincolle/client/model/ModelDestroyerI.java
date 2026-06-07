package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.Reference;
import com.lulan.shincolle.utility.EmotionHelper;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

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
 * ModelDestroyerI - PinkaLulan 2015/1/9
 * I-class destroyer pet form.
 * Ported from 1.10.2 ModelBase to 1.20.1 ModelPart system.
 * <p>
 * This model uses a custom 3-state eye system (PEyeLightL/R[0-2])
 * instead of the standard Face0-4/Mouth0-2/Flush0-1 system.
 */
public class ModelDestroyerI extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "destroyer_i"), "main");
    // Legacy 1.10.2 global Y translations (GlStateManager.translate)
    private static final float DEAD_POSE_OFFSET_Y = 0.75F;
    private static final float STANDING_OFFSET_Y = 0.42F;
    private static final float SIT_BORED_OFFSET_Y = 0.5F;
    private static final float SIT_NORMAL_OFFSET_Y = 0.68F;
    // Main model tree
    private final ModelPart PBack;
    private final ModelPart PNeck;
    private final ModelPart PHead;
    private final ModelPart PJawBottom;
    private final ModelPart PBody;
    private final ModelPart PLegLeft;
    private final ModelPart PLegLeftEnd;
    private final ModelPart PLegRight;
    private final ModelPart PLegRightEnd;
    private final ModelPart PTail;
    private final ModelPart PTailLeft;
    private final ModelPart PTailLeftEnd;
    private final ModelPart PTailRight;
    private final ModelPart PTailRightEnd;
    private final ModelPart PTailEnd;
    // Kisaragi alternate form parts (children of GlowPHead, glow rendered)
    private final ModelPart PKisaragi00;
    private final ModelPart PKisaragi01;
    private final ModelPart PKisaragi02;
    private final ModelPart PKisaragi03;
    // Glow scaffolding (empty parts mirroring PBack/PNeck/PHead hierarchy)
    private final ModelPart GlowPBack;
    private final ModelPart GlowPNeck;
    private final ModelPart GlowPHead;
    // Eye light pairs (3 emotion states, children of GlowPHead)
    private final ModelPart[] PEyeLightL = new ModelPart[3];
    private final ModelPart[] PEyeLightR = new ModelPart[3];
    // Dynamic Y offset set by animation, applied in renderToBuffer
    private float animOffsetY = 0F;

    public ModelDestroyerI(ModelPart root) {
        super();

        // Main model hierarchy: root -> PBack -> {PNeck -> PHead -> PJawBottom, PBody
        // -> {PLegLeft, PLegRight}, PTail -> ...}
        this.PBack = root.getChild("PBack");
        this.PNeck = this.PBack.getChild("PNeck");
        this.PHead = this.PNeck.getChild("PHead");
        this.PJawBottom = this.PHead.getChild("PJawBottom");
        this.PBody = this.PBack.getChild("PBody");
        this.PLegLeft = this.PBody.getChild("PLegLeft");
        this.PLegLeftEnd = this.PLegLeft.getChild("PLegLeftEnd");
        this.PLegRight = this.PBody.getChild("PLegRight");
        this.PLegRightEnd = this.PLegRight.getChild("PLegRightEnd");
        this.PTail = this.PBack.getChild("PTail");
        this.PTailLeft = this.PTail.getChild("PTailLeft");
        this.PTailLeftEnd = this.PTailLeft.getChild("PTailLeftEnd");
        this.PTailRight = this.PTail.getChild("PTailRight");
        this.PTailRightEnd = this.PTailRight.getChild("PTailRightEnd");
        this.PTailEnd = this.PTail.getChild("PTailEnd");

        // Glow scaffolding hierarchy: root -> GlowPBack -> GlowPNeck -> GlowPHead ->
        // {eyes, kisaragi}
        this.GlowPBack = root.getChild("GlowPBack");
        this.GlowPNeck = this.GlowPBack.getChild("GlowPNeck");
        this.GlowPHead = this.GlowPNeck.getChild("GlowPHead");

        // Eye lights (3 pairs)
        this.PEyeLightL[0] = this.GlowPHead.getChild("EyeLightL0");
        this.PEyeLightR[0] = this.GlowPHead.getChild("EyeLightR0");
        this.PEyeLightL[1] = this.GlowPHead.getChild("EyeLightL1");
        this.PEyeLightR[1] = this.GlowPHead.getChild("EyeLightR1");
        this.PEyeLightL[2] = this.GlowPHead.getChild("EyeLightL2");
        this.PEyeLightR[2] = this.GlowPHead.getChild("EyeLightR2");

        // Kisaragi parts
        this.PKisaragi00 = this.GlowPHead.getChild("PKisaragi00");
        this.PKisaragi01 = this.GlowPHead.getChild("PKisaragi01");
        this.PKisaragi02 = this.GlowPHead.getChild("PKisaragi02");
        this.PKisaragi03 = this.GlowPHead.getChild("PKisaragi03");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        // ==================== Main Model Tree ====================

        // PBack - root child
        // Original: setRotationPoint(-8F, -16F, 0F), rotation (0, 0, -0.31)
        // texOffs(128, 8) "Back": addBox(-12, -10, -12, 28, 20, 24)
        PartDefinition pBack = partdefinition.addOrReplaceChild("PBack",
                CubeListBuilder.create().texOffs(128, 8)
                        .addBox(-12F, -10F, -12F, 28, 20, 24),
                PartPose.offsetAndRotation(-8F, -16F, 0F, 0F, 0F, -0.31F));

        // PNeck - child of PBack
        // Original: setRotationPoint(15, 0, 0), rotation (0, 0, 0.2)
        // texOffs(128, 0) "NeckBack": addBox(-3, -11, -13, 30, 26, 26)
        // texOffs(128, 28) "NeckNeck": addBox(6, 15, -10, 21, 4, 20)
        // texOffs(0, 70) "NeckBody": addBox(-8, 7, -9, 18, 14, 18)
        PartDefinition pNeck = pBack.addOrReplaceChild("PNeck",
                CubeListBuilder.create().texOffs(128, 0)
                        .addBox(-3F, -11F, -13F, 30, 26, 26)
                        .texOffs(128, 28)
                        .addBox(6F, 15F, -10F, 21, 4, 20)
                        .texOffs(0, 70)
                        .addBox(-8F, 7F, -9F, 18, 14, 18),
                PartPose.offsetAndRotation(15F, 0F, 0F, 0F, 0F, 0.2F));

        // PHead - child of PNeck
        // Original: setRotationPoint(26, 0, 0), rotation (0, 0, 0.3)
        // texOffs(0, 0) "Head": addBox(-3, -12, -16, 32, 32, 32)
        // texOffs(96, 0) "ToothTopMid": addBox(14.5, 20, -6, 4, 6, 12)
        // texOffs(128, 54) "ToothTopRight": addBox(0, 20, -10, 18, 6, 4)
        // texOffs(128, 54) "ToothTopLeft": addBox(0, 20, 6, 18, 6, 4)
        // texOffs(0, 102) "JawTop": addBox(-3, 20, -11, 22, 2, 22)
        PartDefinition pHead = pNeck.addOrReplaceChild("PHead",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3F, -12F, -16F, 32, 32, 32)
                        .texOffs(96, 0)
                        .addBox(14.5F, 20F, -6F, 4, 6, 12)
                        .texOffs(128, 54)
                        .addBox(0F, 20F, -10F, 18, 6, 4)
                        .texOffs(128, 54)
                        .addBox(0F, 20F, 6F, 18, 6, 4)
                        .texOffs(0, 102)
                        .addBox(-3F, 20F, -11F, 22, 2, 22),
                PartPose.offsetAndRotation(26F, 0F, 0F, 0F, 0F, 0.3F));

        // PJawBottom - child of PHead
        // Original: setRotationPoint(-6, 18, 0), rotation (0, 0, -0.2)
        // texOffs(92, 64) "JawBottom": addBox(-3, 0, -10, 3, 18, 20)
        // texOffs(96, 19) "ToothBottomLeft": addBox(-1, 7.5, 6, 4, 10, 3)
        // texOffs(96, 19) "ToothBottomRight": addBox(-1, 7.5, -9, 4, 10, 3)
        // texOffs(0, 0) "ToothBottomMid": addBox(-1, 14.5, -6, 4, 3, 12)
        pHead.addOrReplaceChild("PJawBottom",
                CubeListBuilder.create().texOffs(92, 64)
                        .addBox(-3F, 0F, -10F, 3, 18, 20)
                        .texOffs(96, 19)
                        .addBox(-1F, 7.5F, 6F, 4, 10, 3)
                        .texOffs(96, 19)
                        .addBox(-1F, 7.5F, -9F, 4, 10, 3)
                        .texOffs(0, 0)
                        .addBox(-1F, 14.5F, -6F, 4, 3, 12),
                PartPose.offsetAndRotation(-6F, 18F, 0F, 0F, 0F, -0.2F));

        // PBody - child of PBack
        // Original: setRotationPoint(0, 0, 0), no rotation
        // texOffs(0, 64) "Body": addBox(-10, 10, -11, 24, 16, 22)
        PartDefinition pBody = pBack.addOrReplaceChild("PBody",
                CubeListBuilder.create().texOffs(0, 64)
                        .addBox(-10F, 10F, -11F, 24, 16, 22),
                PartPose.offset(0F, 0F, 0F));

        // PLegLeft - child of PBody
        // Original: setRotationPoint(-3, 24, 6), no rotation
        // texOffs(0, 80) "LegLeftFront": addBox(-3, -4, -1, 8, 14, 8)
        PartDefinition pLegLeft = pBody.addOrReplaceChild("PLegLeft",
                CubeListBuilder.create().texOffs(0, 80)
                        .addBox(-3F, -4F, -1F, 8, 14, 8),
                PartPose.offset(-3F, 24F, 6F));

        // PLegLeftEnd - child of PLegLeft
        // Original: setRotationPoint(1, 8, 4), no rotation
        // texOffs(0, 90) "LegLeftEnd": addBox(-12, -3, -4, 12, 6, 6)
        pLegLeft.addOrReplaceChild("PLegLeftEnd",
                CubeListBuilder.create().texOffs(0, 90)
                        .addBox(-12F, -3F, -4F, 12, 6, 6),
                PartPose.offset(1F, 8F, 4F));

        // PLegRight - child of PBody
        // Original: setRotationPoint(-3, 24, -8), no rotation
        // texOffs(0, 80) "LegRightFront": addBox(-3, -4, -5, 8, 14, 8)
        PartDefinition pLegRight = pBody.addOrReplaceChild("PLegRight",
                CubeListBuilder.create().texOffs(0, 80)
                        .addBox(-3F, -4F, -5F, 8, 14, 8),
                PartPose.offset(-3F, 24F, -8F));

        // PLegRightEnd - child of PLegRight
        // Original: setRotationPoint(1, 8, -1), no rotation
        // texOffs(0, 90) "LegRightEnd": addBox(-12, -3, -3, 12, 6, 6)
        pLegRight.addOrReplaceChild("PLegRightEnd",
                CubeListBuilder.create().texOffs(0, 90)
                        .addBox(-12F, -3F, -3F, 12, 6, 6),
                PartPose.offset(1F, 8F, -1F));

        // PTail - child of PBack
        // Original: setRotationPoint(-12, -2, 0), rotation (0, 0, 0.25)
        // texOffs(128, 16) "TailBack": addBox(-22, -6, -10, 26, 16, 20)
        // texOffs(0, 68) "TailBody": addBox(-8, 2, -8, 18, 18, 14)
        PartDefinition pTail = pBack.addOrReplaceChild("PTail",
                CubeListBuilder.create().texOffs(128, 16)
                        .addBox(-22F, -6F, -10F, 26, 16, 20)
                        .texOffs(0, 68)
                        .addBox(-8F, 2F, -8F, 18, 18, 14),
                PartPose.offsetAndRotation(-12F, -2F, 0F, 0F, 0F, 0.25F));

        // PTailLeft - child of PTail
        // Original: setRotationPoint(-12, 4, 8), rotation (0.5, 0, 0.25)
        // texOffs(128, 28) "TailLeftFront": addBox(-8, -4, 0, 12, 18, 6)
        PartDefinition pTailLeft = pTail.addOrReplaceChild("PTailLeft",
                CubeListBuilder.create().texOffs(128, 28)
                        .addBox(-8F, -4F, 0F, 12, 18, 6),
                PartPose.offsetAndRotation(-12F, 4F, 8F, 0.5F, 0F, 0.25F));

        // PTailLeftEnd - child of PTailLeft
        // Original: setRotationPoint(0, 9, 5), rotation (0, 0, -0.4)
        // texOffs(128, 36) "TailLeftEnd": addBox(-24, -4, -2, 24, 12, 4)
        pTailLeft.addOrReplaceChild("PTailLeftEnd",
                CubeListBuilder.create().texOffs(128, 36)
                        .addBox(-24F, -4F, -2F, 24, 12, 4),
                PartPose.offsetAndRotation(0F, 9F, 5F, 0F, 0F, -0.4F));

        // PTailRight - child of PTail
        // Original: setRotationPoint(-12, 4, -8), rotation (-0.5, 0, 0.25)
        // texOffs(128, 28) "TailRightFront": addBox(-8, -4, -6, 12, 18, 6)
        PartDefinition pTailRight = pTail.addOrReplaceChild("PTailRight",
                CubeListBuilder.create().texOffs(128, 28)
                        .addBox(-8F, -4F, -6F, 12, 18, 6),
                PartPose.offsetAndRotation(-12F, 4F, -8F, -0.5F, 0F, 0.25F));

        // PTailRightEnd - child of PTailRight
        // Original: setRotationPoint(0, 9, -5), rotation (0, 0, -0.4)
        // texOffs(128, 36) "TailRightEnd": addBox(-24, -4, -2, 24, 12, 4)
        pTailRight.addOrReplaceChild("PTailRightEnd",
                CubeListBuilder.create().texOffs(128, 36)
                        .addBox(-24F, -4F, -2F, 24, 12, 4),
                PartPose.offsetAndRotation(0F, 9F, -5F, 0F, 0F, -0.4F));

        // PTailEnd - child of PTail
        // Original: setRotationPoint(-22, 2, 0), rotation (0, 0, 0.3)
        // texOffs(128, 26) "TailEnd": addBox(-20, -6, -8, 24, 10, 16)
        pTail.addOrReplaceChild("PTailEnd",
                CubeListBuilder.create().texOffs(128, 26)
                        .addBox(-20F, -6F, -8F, 24, 10, 16),
                PartPose.offsetAndRotation(-22F, 2F, 0F, 0F, 0F, 0.3F));

        // ==================== Glow Model Tree ====================
        // Empty scaffolding parts mirroring PBack/PNeck/PHead transforms,
        // carrying eye lights and Kisaragi parts for glow rendering (0xF000F0)

        // GlowPBack - root child (same transform as PBack, no geometry)
        PartDefinition glowPBack = partdefinition.addOrReplaceChild("GlowPBack",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(-8F, -16F, 0F, 0F, 0F, -0.31F));

        // GlowPNeck - child of GlowPBack (same transform as PNeck, no geometry)
        PartDefinition glowPNeck = glowPBack.addOrReplaceChild("GlowPNeck",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(15F, 0F, 0F, 0F, 0F, 0.2F));

        // GlowPHead - child of GlowPNeck (same transform as PHead, no geometry)
        PartDefinition glowPHead = glowPNeck.addOrReplaceChild("GlowPHead",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(26F, 0F, 0F, 0F, 0F, 0.3F));

        // --- Eye Light pairs (3 emotion states) ---
        // Each pair has a mirrored left eye and non-mirrored right eye.
        // EyeLightL[1,2] and EyeLightR[1,2] start hidden (set in constructor via
        // setFace(0)).

        // Eye pair 0 - normal open eyes
        // Original: PEyeLightL[0] = new ModelRenderer(this, 138, 64); mirror=true;
        // addBox(-3, 0, 15.1, 24, 20, 1)
        glowPHead.addOrReplaceChild("EyeLightL0",
                CubeListBuilder.create().mirror().texOffs(138, 64)
                        .addBox(-3F, 0F, 15.1F, 24, 20, 1),
                PartPose.ZERO);
        // Original: PEyeLightR[0] = new ModelRenderer(this, 138, 64); addBox(-3, 0,
        // -16.1, 24, 20, 1)
        glowPHead.addOrReplaceChild("EyeLightR0",
                CubeListBuilder.create().texOffs(138, 64)
                        .addBox(-3F, 0F, -16.1F, 24, 20, 1),
                PartPose.ZERO);

        // Eye pair 1 - half-closed / blink
        // Original: PEyeLightL[1] = new ModelRenderer(this, 138, 85); mirror=true;
        // addBox(-3, 0, 15.1, 24, 20, 1)
        glowPHead.addOrReplaceChild("EyeLightL1",
                CubeListBuilder.create().mirror().texOffs(138, 85)
                        .addBox(-3F, 0F, 15.1F, 24, 20, 1),
                PartPose.ZERO);
        // Original: PEyeLightR[1] = new ModelRenderer(this, 138, 85); addBox(-3, 0,
        // -16.1, 24, 20, 1)
        glowPHead.addOrReplaceChild("EyeLightR1",
                CubeListBuilder.create().texOffs(138, 85)
                        .addBox(-3F, 0F, -16.1F, 24, 20, 1),
                PartPose.ZERO);

        // Eye pair 2 - narrow / distressed
        // Original: PEyeLightL[2] = new ModelRenderer(this, 138, 106); mirror=true;
        // addBox(-3, 0, 15.1, 24, 20, 1)
        glowPHead.addOrReplaceChild("EyeLightL2",
                CubeListBuilder.create().mirror().texOffs(138, 106)
                        .addBox(-3F, 0F, 15.1F, 24, 20, 1),
                PartPose.ZERO);
        // Original: PEyeLightR[2] = new ModelRenderer(this, 138, 106); addBox(-3, 0,
        // -16.1, 24, 20, 1)
        glowPHead.addOrReplaceChild("EyeLightR2",
                CubeListBuilder.create().texOffs(138, 106)
                        .addBox(-3F, 0F, -16.1F, 24, 20, 1),
                PartPose.ZERO);

        // --- Kisaragi alternate form parts (children of GlowPHead) ---

        // PKisaragi00 - base piece
        // Original: setRotationPoint(-7, -9, 14), texOffs(66, 102), addBox(0, 0, 0, 8,
        // 8, 5)
        glowPHead.addOrReplaceChild("PKisaragi00",
                CubeListBuilder.create().texOffs(66, 102)
                        .addBox(0F, 0F, 0F, 8, 8, 5),
                PartPose.offset(-7F, -9F, 14F));

        // PKisaragi01 - first fin
        // Original: setRotationPoint(-7, -9, 14), texOffs(114, 102), addBox(-2, -16, 1,
        // 8, 20, 3), rotation (0, 0, -0.524)
        glowPHead.addOrReplaceChild("PKisaragi01",
                CubeListBuilder.create().texOffs(114, 102)
                        .addBox(-2F, -16F, 1F, 8, 20, 3),
                PartPose.offsetAndRotation(-7F, -9F, 14F, 0F, 0F, -0.524F));

        // PKisaragi02 - second fin
        // Original: setRotationPoint(-7, -9, 14), texOffs(92, 102), addBox(-7, -17,
        // 0.8, 8, 18, 3), rotation (0, 0, -1.396)
        glowPHead.addOrReplaceChild("PKisaragi02",
                CubeListBuilder.create().texOffs(92, 102)
                        .addBox(-7F, -17F, 0.8F, 8, 18, 3),
                PartPose.offsetAndRotation(-7F, -9F, 14F, 0F, 0F, -1.396F));

        // PKisaragi03 - third fin
        // Original: setRotationPoint(-7, -9, 14), texOffs(92, 102), addBox(-9, -18,
        // 0.6, 8, 18, 3), rotation (0, 0, -2.094)
        glowPHead.addOrReplaceChild("PKisaragi03",
                CubeListBuilder.create().texOffs(92, 102)
                        .addBox(-9F, -18F, 0.6F, 8, 18, 3),
                PartPose.offsetAndRotation(-7F, -9F, 14F, 0F, 0F, -2.094F));

        // Original texture size: 256 x 128
        return LayerDefinition.create(meshdefinition, 256, 128);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
        IShipEmotion ent = (IShipEmotion) entity;

        // Kisaragi visibility
        this.showEquip(ent);

        // Roll emotion (uses overridden setFace/setMouth/setFlush)
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

        // Apply animation Y offset (before scale, matching original behavior)
        poseStack.translate(0F, animOffsetY, 0F);

        // Original: GlStateManager.scale(0.45F, 0.4F, 0.4F)
        poseStack.scale(0.45F, 0.4F, 0.4F);

        // Original: GlStateManager.rotate(90F, 0F, 1F, 0F) - head direction correction
        poseStack.mulPose(Axis.YP.rotationDegrees(90F));

        // Main model
        this.PBack.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);

        // Glow model (full brightness)
        this.GlowPBack.render(poseStack, buffer, 0xF000F0, packedOverlay, red, green, blue, alpha);

        poseStack.popPose();
    }

    // ==================== Emotion System Overrides ====================
    // This model uses 3 eye-light pairs instead of the standard
    // Face0-4/Mouth0-2/Flush0-1 system. Override base class methods
    // to prevent NPE from accessing null Face/Mouth/Flush fields.

    @Override
    public void setFace(int emo) {
        // Map the 10-state face system to 3 eye states:
        // base 0 -> eye 0 (normal open eyes)
        // base 1 -> eye 1 (half-closed / blink)
        // base 2-4 -> eye 2 (narrow / distressed)
        int base = emo % 5;
        int eyeIndex;
        if (base <= 0) {
            eyeIndex = 0;
        } else if (base == 1) {
            eyeIndex = 1;
        } else {
            eyeIndex = 2;
        }
        for (int i = 0; i < 3; i++) {
            this.PEyeLightL[i].visible = (i == eyeIndex);
            this.PEyeLightR[i].visible = (i == eyeIndex);
        }
    }

    @Override
    public void setMouth(int emo) {
        // No mouth parts on this creature model - no-op
    }

    @Override
    public void setFlush(boolean show) {
        // No flush parts on this creature model - no-op
    }

    // Override composite face methods that would fail on null Face/Mouth/Flush
    @Override
    public void setFaceNormal(IShipEmotion ent) {
        this.setFace(0);
    }

    @Override
    public void setFaceBlink0(IShipEmotion ent) {
        this.setFace(0);
    }

    @Override
    public void setFaceBlink1(IShipEmotion ent) {
        this.setFace(1);
    }

    @Override
    public void setFaceCry(IShipEmotion ent) {
        this.setFace(2);
    }

    @Override
    public void setFaceAttack(IShipEmotion ent) {
        this.setFace(0);
    }

    @Override
    public void setFaceDamaged(IShipEmotion ent) {
        this.setFace(2);
    }

    @Override
    public void setFaceScorn(IShipEmotion ent) {
        this.setFace(2);
    }

    @Override
    public void setFaceHungry(IShipEmotion ent) {
        this.setFace(2);
    }

    @Override
    public void setFaceAngry(IShipEmotion ent) {
        this.setFace(0);
    }

    @Override
    public void setFaceBored(IShipEmotion ent) {
        this.setFace(1);
    }

    @Override
    public void setFaceShy(IShipEmotion ent) {
        this.setFace(0);
    }

    @Override
    public void setFaceHappy(IShipEmotion ent) {
        this.setFace(0);
    }

    // ==================== Equipment / Visibility ====================

    @Override
    public void showEquip(IShipEmotion ent) {
        // Kisaragi alternate form: toggled by model state bit 0
        boolean showKisaragi = EmotionHelper.checkModelState(0, ent.getStateEmotion(ID.S.State));
        this.PKisaragi00.visible = showKisaragi;
        this.PKisaragi01.visible = showKisaragi;
        this.PKisaragi02.visible = showKisaragi;
        this.PKisaragi03.visible = showKisaragi;
    }

    // ==================== Glow Sync ====================

    @Override
    public void syncRotationGlowPart() {
        this.GlowPBack.xRot = this.PBack.xRot;
        this.GlowPBack.yRot = this.PBack.yRot;
        this.GlowPBack.zRot = this.PBack.zRot;
        this.GlowPNeck.xRot = this.PNeck.xRot;
        this.GlowPNeck.yRot = this.PNeck.yRot;
        this.GlowPNeck.zRot = this.PNeck.zRot;
        this.GlowPHead.xRot = this.PHead.xRot;
        this.GlowPHead.yRot = this.PHead.yRot;
        this.GlowPHead.zRot = this.PHead.zRot;
    }

    // ==================== Animation ====================

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        // Original: motionStopPos
        // Force distressed face for dead pose
        this.setFace(2);

        // Translate up (original: GlStateManager.translate(0F, 0.75F, 0F))
        this.animOffsetY = DEAD_POSE_OFFSET_Y;

        // Body collapsed forward
        this.PBack.xRot = 1.4835F;
        this.PBack.zRot = 0F;

        // Head drooping
        this.PNeck.yRot = 0F;
        this.PNeck.zRot = 0.2F;
        this.PHead.yRot = 0F;
        this.PHead.zRot = 0.2F;
        this.PTail.yRot = 0F;

        // Legs splayed
        this.PLegLeft.xRot = -1.0472F;
        this.PLegLeft.zRot = 0F;
        this.PLegLeftEnd.zRot = -1.4F;
        this.PLegRight.xRot = 0.087F;
        this.PLegRight.zRot = -0.7854F;
        this.PLegRightEnd.zRot = -1.4F;

        // Tail drooping
        this.PTail.zRot = 0.2F;
        this.PTailEnd.zRot = 0.3F;

        // Jaw slack
        this.PJawBottom.zRot = -0.3F;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        float angleZ = Mth.cos(f2 * 0.125F);

        // Reset dynamic offset
        this.animOffsetY = 0F;

        // Reset body
        this.PBack.xRot = 0F;

        // Reset legs
        this.PLegLeft.xRot = 0F;
        this.PLegLeft.zRot = 0F;
        this.PLegRight.xRot = 0F;
        this.PLegRight.zRot = 0F;

        // Water floating bobbing
        if (ent.getShipDepth(0) > 0D) {
            this.animOffsetY += angleZ * 0.05F + 0.025F;
        }

        // Head watching / idle head motion
        motionWatch(f3, f4, angleZ);

        if (ent.getIsSitting()) {
            motionSit(ent, angleZ);
        } else {
            // Walking / standing
            motionLeg(f, f1);
            motionTail(angleZ);

            // Reset body rotation to default standing
            this.PBack.zRot = -0.31F;

            // Standing offset (original: GlStateManager.translate(0F, 0.42F, 0F))
            this.animOffsetY += STANDING_OFFSET_Y;
        }
    }

    /**
     * Head tracking / idle head bobbing.
     * Original: motionWatch
     */
    private void motionWatch(float f3, float f4, float angleZ) {
        if (f4 != 0) {
            // Looking at target
            this.PNeck.yRot = f3 * 0.006F;
            this.PNeck.zRot = f4 * 0.006F;
            this.PHead.yRot = f3 * 0.006F;
            this.PHead.zRot = f4 * 0.006F;
            this.PTail.yRot = f3 * -0.006F; // tail swings opposite
        } else {
            // Idle gentle head bobbing
            this.PNeck.yRot = 0F;
            this.PNeck.zRot = 0.2F;
            this.PHead.yRot = 0F;
            this.PHead.zRot = angleZ * 0.15F + 0.2F;
            this.PTail.yRot = 0F;
        }
    }

    /**
     * Walking leg animation.
     * Original: motionLeg
     * Note: this model's forward direction uses Z rotation for leg swing.
     */
    private void motionLeg(float f, float f1) {
        this.PLegRight.zRot = Mth.cos(f * 0.6662F) * 1.4F * f1 - 0.6F;
        this.PLegLeft.zRot = Mth.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1 - 0.6F;
        this.PLegRightEnd.zRot = Mth.sin(f * 0.6662F) * f1 - 0.4F;
        this.PLegLeftEnd.zRot = Mth.sin(f * 0.6662F + 3.1415927F) * f1 - 0.4F;
    }

    /**
     * Tail and jaw idle animation.
     * Original: motionTail
     */
    private void motionTail(float angleZ) {
        this.PTail.zRot = angleZ * 0.2F;
        this.PTailEnd.zRot = angleZ * 0.3F;
        this.PJawBottom.zRot = angleZ * 0.2F - 0.3F;
    }

    /**
     * Sitting pose.
     * Original: motionSit
     */
    private void motionSit(IShipEmotion ent, float angleZ) {
        if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
            // Bored sitting - lying down pose
            this.animOffsetY += SIT_BORED_OFFSET_Y;
            this.PBack.zRot = 0.6F;
            this.PNeck.zRot = -0.25F;
            this.PHead.zRot = -0.3F;
            this.PLegRight.zRot = -1F;
            this.PLegLeft.zRot = -1F;
            this.PLegRightEnd.zRot = -1.1F;
            this.PLegLeftEnd.zRot = -1.1F;
            this.PTail.zRot = -0.6F;
            this.PTailEnd.zRot = -0.6F;
            this.PJawBottom.zRot = -0.7F;
        } else {
            // Normal sitting - curled up
            this.animOffsetY += SIT_NORMAL_OFFSET_Y;
            this.PBack.zRot = -0.8F;
            this.PNeck.zRot = -0.3F;
            this.PLegRight.zRot = -0.8F;
            this.PLegLeft.zRot = -0.8F;
            this.PLegRightEnd.zRot = -1.4F;
            this.PLegLeftEnd.zRot = -1.4F;
            this.PTail.zRot = 0.4F;
            this.PTailEnd.zRot = angleZ * 0.2F + 0.4F;
            this.PJawBottom.zRot = angleZ * 0.05F - 0.3F;
            this.PHead.zRot = angleZ * 0.02F + 0.4F;
        }
    }
}
