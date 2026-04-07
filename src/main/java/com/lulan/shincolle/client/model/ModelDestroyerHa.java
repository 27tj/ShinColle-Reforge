package com.lulan.shincolle.client.model;

import net.minecraft.world.entity.Entity;
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

public class ModelDestroyerHa extends ShipModelBaseAdv<Entity> {

        public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
                        new ResourceLocation(Reference.MOD_ID, "destroyer_ha"), "main");

        private final ModelPart Back;
        private final ModelPart NeckBack;
        private final ModelPart Body;
        private final ModelPart TailBack;
        private final ModelPart Head;
        private final ModelPart NeckBody;
        private final ModelPart HeadD01;
        private ModelPart k00;
        private final ModelPart ToothU;
        private final ModelPart HeadD02;
        private final ModelPart ToothL;
        private final ModelPart HeadD03;
        private ModelPart k01;
        private ModelPart k02;
        private ModelPart k03;
        private final ModelPart LegLeftFront;
        private final ModelPart LegRightFront;
        private final ModelPart LegLeftEnd;
        private final ModelPart LegRightEnd;
        private final ModelPart TailEnd1;
        private final ModelPart TailEnd2;
        private final ModelPart GlowBack;
        private final ModelPart GlowNeckBack;
        private final ModelPart GlowHead;

        public ModelDestroyerHa(ModelPart root) {
                super();
                this.Back = root.getChild("Back");
                this.TailBack = this.Back.getChild("TailBack");
                this.NeckBack = this.Back.getChild("NeckBack");
                this.Body = this.Back.getChild("Body");
                this.TailEnd1 = this.TailBack.getChild("TailEnd1");
                this.TailEnd2 = this.TailBack.getChild("TailEnd2");
                this.Head = this.NeckBack.getChild("Head");
                this.NeckBody = this.NeckBack.getChild("NeckBody");
                this.LegRightFront = this.Body.getChild("LegRightFront");
                this.LegLeftFront = this.Body.getChild("LegLeftFront");
                this.ToothU = this.Head.getChild("ToothU");
                this.HeadD01 = this.Head.getChild("HeadD01");
                this.LegRightEnd = this.LegRightFront.getChild("LegRightEnd");
                this.LegLeftEnd = this.LegLeftFront.getChild("LegLeftEnd");
                this.HeadD02 = this.HeadD01.getChild("HeadD02");
                this.ToothL = this.HeadD02.getChild("ToothL");
                this.HeadD03 = this.HeadD02.getChild("HeadD03");

                this.GlowBack = root.getChild("GlowBack");
                this.GlowNeckBack = this.GlowBack.getChild("GlowNeckBack");
                this.GlowHead = this.GlowNeckBack.getChild("GlowHead");
                this.loadFaceParts(this.GlowHead);
        }

        public static LayerDefinition createBodyLayer() {
                MeshDefinition meshdefinition = new MeshDefinition();
                PartDefinition partdefinition = meshdefinition.getRoot();

                PartDefinition back = partdefinition.addOrReplaceChild("Back",
                                CubeListBuilder.create().texOffs(20, 73)
                                                .addBox(-12.0F, -12.0F, -14.0F, 24.0F, 22.0F, 28.0F),
                                PartPose.offset(0.0F, -22.0F, 0.0F));

                PartDefinition tailBack = back.addOrReplaceChild("TailBack",
                                CubeListBuilder.create().texOffs(30, 79)
                                                .addBox(-10.0F, -4.0F, 0.0F, 20.0F, 17.0F, 22.0F),
                                PartPose.offsetAndRotation(0.0F, -7.0F, 9.0F, 0.08726646259971647F, 0.0F, 0.0F));

                tailBack.addOrReplaceChild("TailEnd1",
                                CubeListBuilder.create().texOffs(36, 81)
                                                .addBox(-8.0F, -3.0F, 0.0F, 16.0F, 12.0F, 20.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, 19.0F, 0.17453292519943295F, 0.0F, 0.0F));

                tailBack.addOrReplaceChild("TailEnd2",
                                CubeListBuilder.create().texOffs(42, 85)
                                                .addBox(-7.0F, -5.0F, 0.0F, 14.0F, 10.0F, 16.0F),
                                PartPose.offsetAndRotation(0.0F, 8.0F, 20.0F, -0.5235987755982988F, 0.0F, 0.0F));

                PartDefinition neckBack = back.addOrReplaceChild("NeckBack",
                                CubeListBuilder.create().texOffs(24, 79)
                                                .addBox(-13.0F, -10.0F, -20.0F, 26.0F, 26.0F, 22.0F),
                                PartPose.offsetAndRotation(0.0F, -2.5F, -11.0F, -0.0873F, 0.0F, 0.0F));

                PartDefinition head = neckBack.addOrReplaceChild("Head",
                                CubeListBuilder.create().texOffs(16, 75)
                                                .addBox(-13.5F, -14.0F, -28.0F, 27.0F, 27.0F, 26.0F),
                                PartPose.offsetAndRotation(0.0F, 3.0F, -13.0F, -0.17453292519943295F, 0.0F, 0.0F));

                head.addOrReplaceChild("ToothU",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-11.0F, 0.0F, 0.0F, 22.0F, 7.0F, 22.0F),
                                PartPose.offsetAndRotation(0.0F, 12.5F, -28.5F, 0.05235987755982988F, 0.0F, 0.0F));

                PartDefinition headD01 = head.addOrReplaceChild("HeadD01",
                                CubeListBuilder.create().texOffs(45, 94)
                                                .addBox(-12.0F, 0.0F, -3.0F, 24.0F, 16.0F, 7.0F),
                                PartPose.offsetAndRotation(0.0F, 12.0F, -3.0F, -0.13962634015954636F, 0.0F, 0.0F));

                PartDefinition headD02 = headD01.addOrReplaceChild("HeadD02",
                                CubeListBuilder.create().texOffs(27, 77)
                                                .addBox(-10.5F, 0.0F, -21.0F, 21.0F, 8.0F, 24.0F),
                                PartPose.offsetAndRotation(0.0F, 9.5F, -1.5F, 0.3490658503988659F, 0.0F, 0.0F));

                headD02.addOrReplaceChild("ToothL",
                                CubeListBuilder.create().mirror().texOffs(0, 0)
                                                .addBox(-11.0F, 0.0F, -22.0F, 22.0F, 7.0F, 22.0F),
                                PartPose.offsetAndRotation(0.0F, 1.0F, 0.5F, -3.089232776029963F, -3.141592653589793F,
                                                0.0F));

                headD02.addOrReplaceChild("HeadD03",
                                CubeListBuilder.create().texOffs(44, 83)
                                                .addBox(-5.0F, 0.0F, 0.0F, 10.0F, 10.0F, 18.0F),
                                PartPose.offsetAndRotation(0.0F, 5.0F, -28.0F, 0.3490658503988659F, 0.0F, 0.0F));

                neckBack.addOrReplaceChild("NeckBody",
                                CubeListBuilder.create().texOffs(46, 34)
                                                .addBox(-9.0F, 0.0F, -9.0F, 18.0F, 11.0F, 22.0F),
                                PartPose.offset(0.0F, 15.0F, -8.0F));

                PartDefinition body = back.addOrReplaceChild("Body",
                                CubeListBuilder.create().texOffs(44, 32)
                                                .addBox(-9.0F, 0.0F, 0.0F, 18.0F, 14.0F, 24.0F),
                                PartPose.offsetAndRotation(0.0F, 11.0F, -18.0F, 0.17453292519943295F, 0.0F, 0.0F));

                PartDefinition legRightFront = body.addOrReplaceChild("LegRightFront",
                                CubeListBuilder.create().texOffs(66, 46)
                                                .addBox(-5.0F, -4.0F, -5.0F, 10.0F, 16.0F, 10.0F),
                                PartPose.offsetAndRotation(-12.0F, 7.0F, 14.0F, -0.5235987755982988F, 0.0F, 0.0F));

                legRightFront.addOrReplaceChild("LegRightEnd",
                                CubeListBuilder.create().texOffs(70, 48)
                                                .addBox(-4.0F, -3.0F, -4.0F, 8.0F, 16.0F, 8.0F),
                                PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.6981317007977318F, 0.0F, 0.0F));

                PartDefinition legLeftFront = body.addOrReplaceChild("LegLeftFront",
                                CubeListBuilder.create().texOffs(66, 46)
                                                .addBox(-5.0F, -4.0F, -5.0F, 10.0F, 16.0F, 10.0F),
                                PartPose.offsetAndRotation(12.0F, 7.0F, 14.0F, -0.5235987755982988F, 0.0F, 0.0F));

                legLeftFront.addOrReplaceChild("LegLeftEnd",
                                CubeListBuilder.create().texOffs(70, 48)
                                                .addBox(-4.0F, -3.0F, -4.0F, 8.0F, 16.0F, 8.0F),
                                PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.6981317007977318F, 0.0F, 0.0F));

                PartDefinition glowBack = partdefinition.addOrReplaceChild("GlowBack",
                                CubeListBuilder.create(),
                                PartPose.offset(0.0F, -22.0F, 0.0F));

                PartDefinition glowNeckBack = glowBack.addOrReplaceChild("GlowNeckBack",
                                CubeListBuilder.create(),
                                PartPose.offset(0.0F, -2.5F, -11.0F));

                PartDefinition glowHead = glowNeckBack.addOrReplaceChild("GlowHead",
                                CubeListBuilder.create(),
                                PartPose.offset(0.0F, 3.0F, -13.0F));
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
                poseStack.translate(0F, offsetY, 0F);
                this.Back.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
                this.GlowBack.render(poseStack, buffer, 0xF000F0, packedOverlay, red, green, blue, alpha);
                poseStack.popPose();
        }

        @Override
        public void showEquip(IShipEmotion ent) {

                // No equipment visibility toggling needed for this model

        }

        @Override
        public void syncRotationGlowPart() {
                this.GlowBack.xRot = this.Back.xRot;
                this.GlowBack.yRot = this.Back.yRot;
                this.GlowBack.zRot = this.Back.zRot;
                this.GlowNeckBack.xRot = this.NeckBack.xRot;
                this.GlowNeckBack.yRot = this.NeckBack.yRot;
                this.GlowNeckBack.zRot = this.NeckBack.zRot;
                this.GlowHead.xRot = this.Head.xRot;
                this.GlowHead.yRot = this.Head.yRot;
                this.GlowHead.zRot = this.Head.zRot;
        }

        @Override
        public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

                // Pose animation pending - needs port from old model format

        }

        @Override
        public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

                // Pose animation pending - needs port from old model format

        }
}
