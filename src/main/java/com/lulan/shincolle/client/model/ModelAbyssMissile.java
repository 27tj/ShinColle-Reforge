package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.reference.Reference;
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

public class ModelAbyssMissile extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "abyss_missile"), "main");

    private final ModelPart Body;
    private final ModelPart Head;
    private final ModelPart Tail;
    private final ModelPart Tail1;
    private final ModelPart Tail2;

    public ModelAbyssMissile(ModelPart root) {
        super();
        this.Body = root.getChild("Body");
        this.Head = this.Body.getChild("Head");
        this.Tail = this.Body.getChild("Tail");
        this.Tail1 = this.Body.getChild("Tail1");
        this.Tail2 = this.Body.getChild("Tail2");

    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("Body",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.0F, -2.0F, -5.5F, 4.0F, 4.0F, 11.0F),
                PartPose.offset(0.0F, 14.0F, -1.5F));

        body.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 1.0F),
                PartPose.offset(-1.5F, -1.5F, -6.5F));

        body.addOrReplaceChild("Tail",
                CubeListBuilder.create().texOffs(0, 4)
                        .addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 3.0F),
                PartPose.offset(-1.0F, -1.0F, 5.5F));

        body.addOrReplaceChild("Tail1",
                CubeListBuilder.create().texOffs(0, 20)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 5.0F, 4.0F),
                PartPose.offset(-0.5F, -2.5F, 5.5F));

        body.addOrReplaceChild("Tail2",
                CubeListBuilder.create().texOffs(0, 15)
                        .addBox(0.0F, 0.0F, 0.0F, 5.0F, 1.0F, 4.0F),
                PartPose.offset(-2.5F, -0.5F, 5.5F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    private static float normalizeToRadians(float angle) {
        if (Math.abs(angle) > ((float) Math.PI * 2F)) {
            return angle * ((float) Math.PI / 180F);
        }
        return angle;
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                          float headPitch) {
        float yaw = normalizeToRadians(netHeadYaw);
        float pitch = normalizeToRadians(headPitch);
        this.Body.yRot = yaw;
        this.Body.xRot = pitch;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
                               float red, float green, float blue, float alpha) {
        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);
        poseStack.translate(offsetX, offsetY, offsetZ);
        this.Body.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();
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
