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

public class ModelDestroyerRo extends ShipModelBaseAdv<Entity> {

        public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
                        new ResourceLocation(Reference.MOD_ID, "destroyer_ro"), "main");

        private final ModelPart Back;
        private final ModelPart NeckBack;
        private final ModelPart Body;
        private final ModelPart TailBack;
        private final ModelPart LegLeftFront;
        private final ModelPart LegRightFront;
        private final ModelPart BodyTurbine;
        private final ModelPart Head;
        private final ModelPart NeckBody;
        private final ModelPart HeadD03;
        private final ModelPart HeadU01;
        private final ModelPart HeadD01;
        private final ModelPart FaceL00;
        private final ModelPart FaceL01;
        private final ModelPart FaceL02;
        private final ModelPart FaceR00;
        private final ModelPart FaceR01;
        private final ModelPart FaceR02;
        private ModelPart k00;
        private final ModelPart HeadD04;
        private final ModelPart UpperTooth;
        private final ModelPart HeadU02;
        private final ModelPart LowerTooth;
        private ModelPart k01;
        private ModelPart k02;
        private ModelPart k03;
        private final ModelPart tube01;
        private final ModelPart tube02;
        private final ModelPart tube03;
        private final ModelPart TailEnd;
        private final ModelPart TailBack01;
        private final ModelPart TailBack02;
        private final ModelPart LegLeftEnd;
        private final ModelPart LegRightEnd;
        private final ModelPart GlowBack;
        private final ModelPart GlowNeckBack;
        private final ModelPart GlowHead;

        public ModelDestroyerRo(ModelPart root) {
                super();
                this.Back = root.getChild("Back");
                this.TailBack = this.Back.getChild("TailBack");
                this.LegRightFront = this.Back.getChild("LegRightFront");
                this.Body = this.Back.getChild("Body");
                this.LegLeftFront = this.Back.getChild("LegLeftFront");
                this.NeckBack = this.Back.getChild("NeckBack");
                this.BodyTurbine = this.Back.getChild("BodyTurbine");
                this.TailBack02 = this.TailBack.getChild("TailBack02");
                this.TailBack01 = this.TailBack.getChild("TailBack01");
                this.TailEnd = this.TailBack.getChild("TailEnd");
                this.LegRightEnd = this.LegRightFront.getChild("LegRightEnd");
                this.LegLeftEnd = this.LegLeftFront.getChild("LegLeftEnd");
                this.Head = this.NeckBack.getChild("Head");
                this.HeadD03 = this.NeckBack.getChild("HeadD03");
                this.NeckBody = this.NeckBack.getChild("NeckBody");
                this.HeadD04 = this.Head.getChild("HeadD04");
                this.HeadU01 = this.Head.getChild("HeadU01");
                this.HeadD01 = this.Head.getChild("HeadD01");
                this.tube01 = this.NeckBody.getChild("tube01");
                this.HeadU02 = this.HeadU01.getChild("HeadU02");
                this.UpperTooth = this.HeadU01.getChild("UpperTooth");
                this.LowerTooth = this.HeadD01.getChild("LowerTooth");
                this.tube03 = this.tube01.getChild("tube03");
                this.tube02 = this.tube01.getChild("tube02");

                this.GlowBack = root.getChild("GlowBack");
                this.GlowNeckBack = this.GlowBack.getChild("GlowNeckBack");
                this.GlowHead = this.GlowNeckBack.getChild("GlowHead");
                this.loadFaceParts(this.GlowHead);
                this.FaceL00 = this.GlowHead.getChild("FaceL00");
                this.FaceL01 = this.GlowHead.getChild("FaceL01");
                this.FaceL02 = this.GlowHead.getChild("FaceL02");
                this.FaceR00 = this.GlowHead.getChild("FaceR00");
                this.FaceR01 = this.GlowHead.getChild("FaceR01");
                this.FaceR02 = this.GlowHead.getChild("FaceR02");
        }

        public static LayerDefinition createBodyLayer() {
                MeshDefinition meshdefinition = new MeshDefinition();
                PartDefinition partdefinition = meshdefinition.getRoot();

                PartDefinition back = partdefinition.addOrReplaceChild("Back",
                                CubeListBuilder.create().texOffs(2, 32)
                                                .addBox(-12.0F, -12.0F, -14.0F, 24.0F, 22.0F, 28.0F),
                                PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, -0.2617993877991494F, 0.0F, 0.0F));

                PartDefinition tailBack = back.addOrReplaceChild("TailBack",
                                CubeListBuilder.create().texOffs(12, 38)
                                                .addBox(-10.0F, -8.0F, 0.0F, 20.0F, 14.0F, 22.0F),
                                PartPose.offsetAndRotation(0.0F, -2.0F, 11.0F, -0.08726646259971647F, 0.0F, 0.0F));

                tailBack.addOrReplaceChild("TailBack02",
                                CubeListBuilder.create().texOffs(30, 40)
                                                .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 10.0F, 20.0F),
                                PartPose.offsetAndRotation(-8.0F, 0.0F, 15.0F, -1.0471975511965976F, 0.0F,
                                                -0.40142572795869574F));

                tailBack.addOrReplaceChild("TailBack01",
                                CubeListBuilder.create().texOffs(30, 40)
                                                .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 10.0F, 20.0F),
                                PartPose.offsetAndRotation(8.0F, 0.0F, 15.0F, -1.0471975511965976F, 0.0F,
                                                0.40142572795869574F));

                tailBack.addOrReplaceChild("TailEnd",
                                CubeListBuilder.create().texOffs(14, 36)
                                                .addBox(-8.0F, -6.5F, 0.0F, 16.0F, 10.0F, 24.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, 19.0F, -0.08726646259971647F, 0.0F, 0.0F));

                PartDefinition legRightFront = back.addOrReplaceChild("LegRightFront",
                                CubeListBuilder.create().texOffs(20, 104)
                                                .addBox(-4.0F, -4.0F, -4.0F, 8.0F, 16.0F, 8.0F),
                                PartPose.offsetAndRotation(-7.8F, 12.0F, -3.0F, 0.7853981633974483F, 0.0F, 0.0F));

                legRightFront.addOrReplaceChild("LegRightEnd",
                                CubeListBuilder.create().texOffs(24, 106)
                                                .addBox(-3.0F, -3.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                                PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.5235987755982988F, 0.0F, 0.0F));

                back.addOrReplaceChild("Body",
                                CubeListBuilder.create().texOffs(4, 96)
                                                .addBox(-8.0F, 0.0F, 0.0F, 16.0F, 7.0F, 16.0F),
                                PartPose.offsetAndRotation(0.0F, 8.0F, -10.0F, 0.5235987755982988F, 0.0F, 0.0F));

                PartDefinition legLeftFront = back.addOrReplaceChild("LegLeftFront",
                                CubeListBuilder.create().texOffs(20, 104)
                                                .addBox(-4.0F, -4.0F, -4.0F, 8.0F, 16.0F, 8.0F),
                                PartPose.offsetAndRotation(7.8F, 12.0F, -3.0F, 0.7853981633974483F, 0.0F, 0.0F));

                legLeftFront.addOrReplaceChild("LegLeftEnd",
                                CubeListBuilder.create().texOffs(24, 106)
                                                .addBox(-3.0F, -3.0F, -3.0F, 6.0F, 14.0F, 6.0F),
                                PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.5235987755982988F, 0.0F, 0.0F));

                PartDefinition neckBack = back.addOrReplaceChild("NeckBack",
                                CubeListBuilder.create().texOffs(8, 40)
                                                .addBox(-13.0F, -11.0F, -20.0F, 26.0F, 26.0F, 22.0F),
                                PartPose.offsetAndRotation(0.0F, -3.0F, -12.0F, 0.08726646259971647F, 0.0F, 0.0F));

                PartDefinition head = neckBack.addOrReplaceChild("Head",
                                CubeListBuilder.create().texOffs(6, 42)
                                                .addBox(-15.0F, -12.0F, -16.0F, 30.0F, 27.0F, 18.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, -17.5F, 0.2617993877991494F, 0.0F, 0.0F));

                head.addOrReplaceChild("HeadD04",
                                CubeListBuilder.create().texOffs(2, 94)
                                                .addBox(-8.0F, 0.0F, 0.0F, 16.0F, 12.0F, 18.0F),
                                PartPose.offsetAndRotation(0.0F, 7.0F, -15.0F, -0.2617993877991494F, 0.0F, 0.0F));

                PartDefinition headU01 = head.addOrReplaceChild("HeadU01",
                                CubeListBuilder.create().texOffs(6, 40)
                                                .addBox(-14.0F, -21.0F, -9.0F, 28.0F, 16.0F, 20.0F),
                                PartPose.offsetAndRotation(0.0F, 7.0F, -19.0F, -0.08726646259971647F, 0.0F, 0.0F));

                headU01.addOrReplaceChild("HeadU02",
                                CubeListBuilder.create().texOffs(6, 40)
                                                .addBox(-14.0F, 0.0F, 0.0F, 28.0F, 15.0F, 20.0F),
                                PartPose.offsetAndRotation(0.0F, -20.0F, -23.0F, 0.08726646259971647F, 0.0F, 0.0F));

                headU01.addOrReplaceChild("UpperTooth",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-12.0F, 0.0F, 0.0F, 24.0F, 10.0F, 20.0F),
                                PartPose.offsetAndRotation(0.0F, -6.0F, -15.0F, 0.3490658503988659F, 0.0F, 0.0F));

                PartDefinition headD01 = head.addOrReplaceChild("HeadD01",
                                CubeListBuilder.create().texOffs(0, 34)
                                                .addBox(-13.0F, 1.5F, -25.0F, 26.0F, 10.0F, 28.0F),
                                PartPose.offsetAndRotation(0.0F, 1.0F, -10.3F, 0.6981317007977318F, 0.0F, 0.0F));

                headD01.addOrReplaceChild("LowerTooth",
                                CubeListBuilder.create().mirror().texOffs(0, 0)
                                                .addBox(-12.0F, 0.0F, 0.0F, 24.0F, 10.0F, 20.0F),
                                PartPose.offsetAndRotation(0.0F, 9.5F, -5.5F, -3.490658503988659F, 0.0F, 0.0F));

                neckBack.addOrReplaceChild("HeadD03",
                                CubeListBuilder.create().texOffs(2, 94)
                                                .addBox(-8.5F, 0.0F, 0.0F, 17.0F, 12.0F, 11.0F),
                                PartPose.offsetAndRotation(0.0F, 10.3F, -23.0F, -0.05235987755982988F, 0.0F, 0.0F));

                PartDefinition neckBody = neckBack.addOrReplaceChild("NeckBody",
                                CubeListBuilder.create().texOffs(0, 94)
                                                .addBox(-9.0F, 0.0F, -9.0F, 18.0F, 14.0F, 18.0F),
                                PartPose.offsetAndRotation(0.0F, 7.0F, -9.0F, 0.3490658503988659F, 0.0F, 0.0F));

                PartDefinition tube01 = neckBody.addOrReplaceChild("tube01",
                                CubeListBuilder.create().texOffs(31, 40)
                                                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 20.0F),
                                PartPose.offsetAndRotation(0.0F, 12.0F, 3.0F, -0.8726646259971648F, 0.0F, 0.0F));

                tube01.addOrReplaceChild("tube03",
                                CubeListBuilder.create().texOffs(24, 32)
                                                .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 28.0F),
                                PartPose.offsetAndRotation(-1.0F, 1.5F, 18.0F, 1.0471975511965976F,
                                                -0.13962634015954636F, 0.0F));

                tube01.addOrReplaceChild("tube02",
                                CubeListBuilder.create().texOffs(24, 32)
                                                .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 28.0F),
                                PartPose.offsetAndRotation(1.0F, 1.5F, 18.0F, 1.0471975511965976F, 0.13962634015954636F,
                                                0.0F));

                back.addOrReplaceChild("BodyTurbine",
                                CubeListBuilder.create().texOffs(86, 89)
                                                .addBox(-4.5F, 0.0F, 0.0F, 9.0F, 9.0F, 12.0F),
                                PartPose.offsetAndRotation(0.0F, 7.0F, -2.0F, -0.5235987755982988F, 0.0F, 0.0F));

                PartDefinition glowBack = partdefinition.addOrReplaceChild("GlowBack",
                                CubeListBuilder.create(),
                                PartPose.offset(0.0F, -16.0F, 0.0F));

                PartDefinition glowNeckBack = glowBack.addOrReplaceChild("GlowNeckBack",
                                CubeListBuilder.create(),
                                PartPose.offset(0.0F, -3.0F, -12.0F));

                PartDefinition glowHead = glowNeckBack.addOrReplaceChild("GlowHead",
                                CubeListBuilder.create(),
                                PartPose.offset(0.0F, 0.0F, -17.5F));
                addDefaultFaceParts(glowHead);

                // Custom dual-eye face parts for Ro-class destroyer
                glowHead.addOrReplaceChild("FaceL00",
                                CubeListBuilder.create().texOffs(98, 63)
                                                .addBox(-5.0F, 0.0F, -0.5F, 10, 8, 1),
                                PartPose.offset(-4.0F, -10.0F, -14.5F));
                glowHead.addOrReplaceChild("FaceL01",
                                CubeListBuilder.create().texOffs(98, 76)
                                                .addBox(-5.0F, 0.0F, -0.5F, 10, 8, 1),
                                PartPose.offset(-4.0F, -10.0F, -14.5F));
                glowHead.addOrReplaceChild("FaceL02",
                                CubeListBuilder.create().texOffs(98, 89)
                                                .addBox(-5.0F, 0.0F, -0.5F, 10, 8, 1),
                                PartPose.offset(-4.0F, -10.0F, -14.5F));
                glowHead.addOrReplaceChild("FaceR00",
                                CubeListBuilder.create().texOffs(98, 63)
                                                .addBox(-5.0F, 0.0F, -0.5F, 10, 8, 1),
                                PartPose.offset(4.0F, -10.0F, -14.5F));
                glowHead.addOrReplaceChild("FaceR01",
                                CubeListBuilder.create().texOffs(98, 76)
                                                .addBox(-5.0F, 0.0F, -0.5F, 10, 8, 1),
                                PartPose.offset(4.0F, -10.0F, -14.5F));
                glowHead.addOrReplaceChild("FaceR02",
                                CubeListBuilder.create().texOffs(98, 89)
                                                .addBox(-5.0F, 0.0F, -0.5F, 10, 8, 1),
                                PartPose.offset(4.0F, -10.0F, -14.5F));

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
