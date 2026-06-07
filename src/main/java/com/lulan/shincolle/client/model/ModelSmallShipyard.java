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

public class ModelSmallShipyard extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "small_shipyard"), "main");

    private final ModelPart shape1;
    private final ModelPart shape2;
    private final ModelPart shape3;
    private final ModelPart shape4;
    private final ModelPart shape5;
    private final ModelPart shape6;
    private final ModelPart shape7;
    private final ModelPart shape8;
    private final ModelPart shape9;
    private final ModelPart shape10;
    private final ModelPart shape11;

    public ModelSmallShipyard(ModelPart root) {
        super();
        this.shape1 = root.getChild("shape1");
        this.shape2 = root.getChild("shape2");
        this.shape3 = root.getChild("shape3");
        this.shape4 = root.getChild("shape4");
        this.shape5 = root.getChild("shape5");
        this.shape6 = root.getChild("shape6");
        this.shape7 = root.getChild("shape7");
        this.shape8 = root.getChild("shape8");
        this.shape9 = root.getChild("shape9");
        this.shape10 = root.getChild("shape10");
        this.shape11 = root.getChild("shape11");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        // Shape1: base platform 16x1x16
        partdefinition.addOrReplaceChild("shape1",
                CubeListBuilder.create().texOffs(0, 0).mirror()
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 1.0F, 16.0F),
                PartPose.offset(-8.0F, 23.0F, -8.0F));

        // Shape2: crane structure 14x3x10
        partdefinition.addOrReplaceChild("shape2",
                CubeListBuilder.create().texOffs(0, 19).mirror()
                        .addBox(0.0F, 0.0F, 0.0F, 14.0F, 3.0F, 10.0F),
                PartPose.offset(-7.0F, 20.0F, -3.0F));

        // Shape3: crane housing 6x4x6
        partdefinition.addOrReplaceChild("shape3",
                CubeListBuilder.create().texOffs(0, 0).mirror()
                        .addBox(-5.0F, 0.0F, 0.0F, 6.0F, 4.0F, 6.0F),
                PartPose.offset(-1.0F, 17.0F, -1.5F));

        // Shape4: crane pillar 4x6x4
        partdefinition.addOrReplaceChild("shape4",
                CubeListBuilder.create().texOffs(0, 0).mirror()
                        .addBox(0.0F, 0.0F, 0.0F, 4.0F, 6.0F, 4.0F),
                PartPose.offset(-5.0F, 11.0F, -1.0F));

        // Shape5: crane top 3x3x3
        partdefinition.addOrReplaceChild("shape5",
                CubeListBuilder.create().texOffs(48, 6).mirror()
                        .addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 3.0F),
                PartPose.offset(-4.5F, 8.0F, -0.5F));

        // Shape6: platform extension 10x3x6
        partdefinition.addOrReplaceChild("shape6",
                CubeListBuilder.create().texOffs(32, 20).mirror()
                        .addBox(0.0F, 0.0F, 0.0F, 10.0F, 3.0F, 6.0F),
                PartPose.offset(-3.5F, 18.0F, 0.0F));

        // Shape7: right pillar 4x3x4
        partdefinition.addOrReplaceChild("shape7",
                CubeListBuilder.create().texOffs(0, 10).mirror()
                        .addBox(0.0F, 0.0F, 0.0F, 4.0F, 3.0F, 4.0F),
                PartPose.offset(2.0F, 15.0F, 1.5F));

        // Shape8: right top 3x3x3
        partdefinition.addOrReplaceChild("shape8",
                CubeListBuilder.create().texOffs(48, 12).mirror()
                        .addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 3.0F),
                PartPose.offset(2.5F, 12.5F, 2.0F));

        // Shape9: front ledge 11x2x4
        partdefinition.addOrReplaceChild("shape9",
                CubeListBuilder.create().texOffs(0, 17).mirror()
                        .addBox(0.0F, 1.0F, 0.0F, 11.0F, 2.0F, 4.0F),
                PartPose.offset(-5.0F, 20.0F, -7.0F));

        // Shape10: front detail 4x2x4
        partdefinition.addOrReplaceChild("shape10",
                CubeListBuilder.create().texOffs(0, 10).mirror()
                        .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 2.0F, 4.0F),
                PartPose.offset(1.0F, 19.0F, -6.5F));

        // Shape11: front equipment 3x3x3
        partdefinition.addOrReplaceChild("shape11",
                CubeListBuilder.create().texOffs(48, 0).mirror()
                        .addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 3.0F),
                PartPose.offset(-0.5F, 16.01333F, -6.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
                               float red, float green, float blue, float alpha) {
        this.shape1.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.shape2.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.shape3.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.shape4.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.shape5.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.shape6.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.shape7.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.shape8.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.shape9.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.shape10.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.shape11.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
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
