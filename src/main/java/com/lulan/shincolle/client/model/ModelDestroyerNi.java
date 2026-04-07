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

public class ModelDestroyerNi extends ShipModelBaseAdv<Entity> {

        public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
                        new ResourceLocation(Reference.MOD_ID, "destroyer_ni"), "main");

        private final ModelPart Back;
        private final ModelPart NeckBack;
        private final ModelPart Body;
        private final ModelPart TailBack;
        private final ModelPart Head;
        private final ModelPart NeckBody;
        private final ModelPart EquipBase;
        private final ModelPart ArmLeft;
        private final ModelPart ArmRight;
        private ModelPart k00;
        private final ModelPart ToothU;
        private ModelPart k01;
        private ModelPart k02;
        private ModelPart k03;
        private final ModelPart Equip01;
        private final ModelPart Equip02;
        private final ModelPart Equip03;
        private final ModelPart ArmLeft01;
        private final ModelPart ArmRight01;
        private final ModelPart TailEnd1;
        private final ModelPart GlowBack;
        private final ModelPart GlowNeckBack;
        private final ModelPart GlowHead;

        public ModelDestroyerNi(ModelPart root) {
                super();
                this.Back = root.getChild("Back");
                this.Body = this.Back.getChild("Body");
                this.NeckBack = this.Back.getChild("NeckBack");
                this.TailBack = this.Back.getChild("TailBack");
                this.NeckBody = this.NeckBack.getChild("NeckBody");
                this.ArmRight = this.NeckBack.getChild("ArmRight");
                this.EquipBase = this.NeckBack.getChild("EquipBase");
                this.Head = this.NeckBack.getChild("Head");
                this.ArmLeft = this.NeckBack.getChild("ArmLeft");
                this.TailEnd1 = this.TailBack.getChild("TailEnd1");
                this.ArmRight01 = this.ArmRight.getChild("ArmRight01");
                this.Equip01 = this.EquipBase.getChild("Equip01");
                this.ToothU = this.Head.getChild("ToothU");
                this.ArmLeft01 = this.ArmLeft.getChild("ArmLeft01");
                this.Equip02 = this.Equip01.getChild("Equip02");
                this.Equip03 = this.Equip02.getChild("Equip03");

                this.GlowBack = root.getChild("GlowBack");
                this.GlowNeckBack = this.GlowBack.getChild("GlowNeckBack");
                this.GlowHead = this.GlowNeckBack.getChild("GlowHead");
                this.loadFaceParts(this.GlowHead);
        }

        public static LayerDefinition createBodyLayer() {
                MeshDefinition meshdefinition = new MeshDefinition();
                PartDefinition partdefinition = meshdefinition.getRoot();

                PartDefinition back = partdefinition.addOrReplaceChild("Back",
                                CubeListBuilder.create().texOffs(14, 76)
                                                .addBox(-12.0F, -12.0F, -14.0F, 24.0F, 21.0F, 26.0F),
                                PartPose.offsetAndRotation(0.0F, -40.0F, 0.0F, 0.7853981633974483F, 0.0F, 0.0F));

                back.addOrReplaceChild("Body",
                                CubeListBuilder.create().texOffs(0, 33)
                                                .addBox(-10.0F, 0.0F, 0.0F, 20.0F, 12.0F, 24.0F),
                                PartPose.offsetAndRotation(0.0F, 11.0F, -14.0F, 0.36425021489121656F, 0.0F, 0.0F));

                PartDefinition neckBack = back.addOrReplaceChild("NeckBack",
                                CubeListBuilder.create().texOffs(10, 76)
                                                .addBox(-14.0F, -10.0F, -20.0F, 28.0F, 25.0F, 26.0F),
                                PartPose.offsetAndRotation(0.0F, -2.5F, -14.0F, 0.08726646259971647F, 0.0F, 0.0F));

                neckBack.addOrReplaceChild("NeckBody",
                                CubeListBuilder.create().texOffs(1, 36)
                                                .addBox(-11.0F, 0.0F, -9.0F, 22.0F, 10.0F, 21.0F),
                                PartPose.offsetAndRotation(0.0F, 13.0F, -4.0F, -0.31869712141416456F, 0.0F, 0.0F));

                PartDefinition armRight = neckBack.addOrReplaceChild("ArmRight",
                                CubeListBuilder.create().texOffs(0, 31)
                                                .addBox(-4.0F, 0.0F, -4.0F, 8.0F, 30.0F, 8.0F),
                                PartPose.offsetAndRotation(-13.0F, 15.0F, -9.0F, -0.5235987755982988F,
                                                0.6981317007977318F, 1.0471975511965976F));

                armRight.addOrReplaceChild("ArmRight01",
                                CubeListBuilder.create().texOffs(2, 32)
                                                .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 30.0F, 7.0F),
                                PartPose.offsetAndRotation(0.0F, 28.0F, 0.0F, 0.0F, 0.0F, -1.3962634015954636F));

                PartDefinition equipBase = neckBack.addOrReplaceChild("EquipBase",
                                CubeListBuilder.create().texOffs(11, 89)
                                                .addBox(-20.0F, 0.0F, 0.0F, 40.0F, 13.0F, 13.0F),
                                PartPose.offset(0.0F, 11.0F, -26.0F));

                PartDefinition equip01 = equipBase.addOrReplaceChild("Equip01",
                                CubeListBuilder.create().texOffs(54, 64)
                                                .addBox(0.0F, 0.0F, 0.0F, 0.0F, 24.0F, 5.0F),
                                PartPose.offsetAndRotation(18.0F, 13.0F, 9.0F, 1.0471975511965976F, 0.7853981633974483F,
                                                0.0F));

                PartDefinition equip02 = equip01.addOrReplaceChild("Equip02",
                                CubeListBuilder.create().texOffs(54, 64)
                                                .addBox(0.0F, 0.0F, 0.0F, 0.0F, 28.0F, 5.0F),
                                PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 1.3089969389957472F));

                equip02.addOrReplaceChild("Equip03",
                                CubeListBuilder.create().texOffs(54, 64)
                                                .addBox(0.0F, 0.0F, 0.0F, 0.0F, 32.0F, 5.0F),
                                PartPose.offsetAndRotation(0.0F, 28.0F, 0.0F, 0.0F, 0.0F, -1.0471975511965976F));

                PartDefinition head = neckBack.addOrReplaceChild("Head",
                                CubeListBuilder.create().texOffs(0, 70)
                                                .addBox(-16.0F, -14.0F, -28.0F, 32.0F, 22.0F, 32.0F),
                                PartPose.offsetAndRotation(0.0F, 3.0F, -19.0F, 0.08726646259971647F, 0.0F, 0.0F));

                head.addOrReplaceChild("ToothU",
                                CubeListBuilder.create().texOffs(0, 0)
                                                .addBox(-11.0F, 0.0F, 0.0F, 22.0F, 9.0F, 22.0F),
                                PartPose.offsetAndRotation(0.0F, 7.0F, -29.0F, 0.13962634015954636F, 0.0F, 0.0F));

                PartDefinition armLeft = neckBack.addOrReplaceChild("ArmLeft",
                                CubeListBuilder.create().texOffs(0, 31)
                                                .addBox(-4.0F, 0.0F, -4.0F, 8.0F, 30.0F, 8.0F),
                                PartPose.offsetAndRotation(13.0F, 15.0F, -9.0F, -0.5235987755982988F,
                                                -0.6981317007977318F, -1.0471975511965976F));

                armLeft.addOrReplaceChild("ArmLeft01",
                                CubeListBuilder.create().texOffs(2, 32)
                                                .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 30.0F, 7.0F),
                                PartPose.offsetAndRotation(0.0F, 28.0F, 0.0F, 0.0F, 0.0F, 1.3962634015954636F));

                PartDefinition tailBack = back.addOrReplaceChild("TailBack",
                                CubeListBuilder.create().texOffs(22, 80)
                                                .addBox(-10.0F, -4.0F, 0.0F, 20.0F, 17.0F, 22.0F),
                                PartPose.offsetAndRotation(0.0F, -7.0F, 9.0F, -0.17453292519943295F, 0.0F, 0.0F));

                tailBack.addOrReplaceChild("TailEnd1",
                                CubeListBuilder.create().texOffs(28, 82)
                                                .addBox(-8.0F, -3.0F, 0.0F, 16.0F, 13.0F, 20.0F),
                                PartPose.offsetAndRotation(0.0F, 0.0F, 19.0F, -0.17453292519943295F, 0.0F, 0.0F));

                PartDefinition glowBack = partdefinition.addOrReplaceChild("GlowBack",
                                CubeListBuilder.create(),
                                PartPose.offset(0.0F, -40.0F, 0.0F));

                PartDefinition glowNeckBack = glowBack.addOrReplaceChild("GlowNeckBack",
                                CubeListBuilder.create(),
                                PartPose.offset(0.0F, -2.5F, -14.0F));

                PartDefinition glowHead = glowNeckBack.addOrReplaceChild("GlowHead",
                                CubeListBuilder.create(),
                                PartPose.offset(0.0F, 3.0F, -19.0F));
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
