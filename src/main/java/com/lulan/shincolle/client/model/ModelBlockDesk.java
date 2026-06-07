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
import net.minecraft.world.entity.Entity;

public class ModelBlockDesk extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "block_desk"), "main");

    private final ModelPart shape1;
    private final ModelPart shape2;
    private final ModelPart shape3;
    private final ModelPart shape4;
    private final ModelPart shape6;

    public ModelBlockDesk(ModelPart root) {
        super();
        this.shape3 = root.getChild("shape3");
        this.shape6 = root.getChild("shape6");
        this.shape1 = root.getChild("shape1");
        this.shape2 = root.getChild("shape2");
        this.shape4 = root.getChild("shape4");

    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("shape3",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 15.0F, 15.0F),
                PartPose.offset(-8.0F, 9.0F, -8.0F));

        partdefinition.addOrReplaceChild("shape6",
                CubeListBuilder.create().texOffs(0, 30)
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 1.0F, 16.0F),
                PartPose.offset(-8.0F, 8.0F, -8.0F));

        partdefinition.addOrReplaceChild("shape1",
                CubeListBuilder.create().texOffs(34, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 14.0F, 6.0F, 1.0F),
                PartPose.offset(-7.0F, 9.0F, -8.0F));

        partdefinition.addOrReplaceChild("shape2",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 15.0F, 1.0F),
                PartPose.offset(-8.0F, 9.0F, 7.0F));

        partdefinition.addOrReplaceChild("shape4",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 15.0F, 15.0F),
                PartPose.offset(7.0F, 9.0F, -8.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
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
        this.shape3.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.shape6.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.shape1.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.shape2.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.shape4.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public void showEquip(IShipEmotion ent) {
    }

    @Override
    public void syncRotationGlowPart() {
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
    }
}
