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

public class ModelLargeShipyard extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "large_shipyard"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Body01;
    private final ModelPart Body02;
    private final ModelPart Body03;
    private final ModelPart Body04;
    private final ModelPart Body05;
    private final ModelPart Body06;
    private final ModelPart Body07;
    private final ModelPart Body08;
    private final ModelPart Base00;
    private final ModelPart Base01;
    private final ModelPart Base02;
    private final ModelPart Base03;
    private final ModelPart Base04;
    private final ModelPart Base05;
    private final ModelPart Base06;
    private final ModelPart Base07;
    private final ModelPart Base08;
    private final ModelPart Pillar01a;
    private final ModelPart Pillar01b;
    private final ModelPart Pillar02a;
    private final ModelPart Pillar02b;
    private final ModelPart Pillar03a;
    private final ModelPart Pillar03b;
    private final ModelPart Pillar01a_1;
    private final ModelPart Pillar01b_1;

    public ModelLargeShipyard(ModelPart root) {
        super();
        this.BodyMain = root.getChild("BodyMain");
        this.Base00 = this.BodyMain.getChild("Base00");
        this.Body06 = this.BodyMain.getChild("Body06");
        this.Body07 = this.BodyMain.getChild("Body07");
        this.Base06 = this.BodyMain.getChild("Base06");
        this.Body03 = this.BodyMain.getChild("Body03");
        this.Body08 = this.BodyMain.getChild("Body08");
        this.Body02 = this.BodyMain.getChild("Body02");
        this.Base02 = this.BodyMain.getChild("Base02");
        this.Base01 = this.BodyMain.getChild("Base01");
        this.Base05 = this.BodyMain.getChild("Base05");
        this.Body05 = this.BodyMain.getChild("Body05");
        this.Base03 = this.BodyMain.getChild("Base03");
        this.Base04 = this.BodyMain.getChild("Base04");
        this.Body04 = this.BodyMain.getChild("Body04");
        this.Body01 = this.BodyMain.getChild("Body01");
        this.Base07 = this.BodyMain.getChild("Base07");
        this.Base08 = this.BodyMain.getChild("Base08");
        this.Pillar01a_1 = this.Body07.getChild("Pillar01a_1");
        this.Pillar02a = this.Body03.getChild("Pillar02a");
        this.Pillar03a = this.Body05.getChild("Pillar03a");
        this.Pillar01a = this.Body01.getChild("Pillar01a");
        this.Pillar01b_1 = this.Pillar01a_1.getChild("Pillar01b_1");
        this.Pillar02b = this.Pillar02a.getChild("Pillar02b");
        this.Pillar03b = this.Pillar03a.getChild("Pillar03b");
        this.Pillar01b = this.Pillar01a.getChild("Pillar01b");

    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offset(0.0F, 18.0F, 0.0F));

        bodyMain.addOrReplaceChild("Base00",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-24.0F, 0.0F, -24.0F, 16.0F, 6.0F, 16.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("Body06",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 20.0F, 6.0F, 10.0F),
                PartPose.offset(-10.0F, -6.0F, -23.0F));

        PartDefinition body07 = bodyMain.addOrReplaceChild("Body07",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 12.0F, 7.0F, 14.0F),
                PartPose.offset(10.0F, -7.0F, -20.0F));

        PartDefinition pillar01a_1 = body07.addOrReplaceChild("Pillar01a_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-4.0F, -10.0F, -4.0F, 9.0F, 10.0F, 9.0F),
                PartPose.offsetAndRotation(5.0F, 2.0F, 6.0F, -0.17453292519943295F, 0.0F,
                        -0.17453292519943295F));

        pillar01a_1.addOrReplaceChild("Pillar01b_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, -8.0F, -3.0F, 6.0F, 8.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, -9.0F, 0.5F, -0.17453292519943295F, 0.0F,
                        -0.17453292519943295F));

        bodyMain.addOrReplaceChild("Base06",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 7.0F, 16.0F),
                PartPose.offset(-24.0F, -1.0F, 8.0F));

        PartDefinition body03 = bodyMain.addOrReplaceChild("Body03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 15.0F, 7.0F, 13.0F),
                PartPose.offset(-20.6F, -7.0F, 8.0F));

        PartDefinition pillar02a = body03.addOrReplaceChild("Pillar02a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-5.5F, -10.0F, -4.5F, 11.0F, 10.0F, 9.0F),
                PartPose.offsetAndRotation(8.0F, 2.0F, 6.0F, 0.17453292519943295F, 0.0F,
                        0.17453292519943295F));

        pillar02a.addOrReplaceChild("Pillar02b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-5.5F, -6.0F, -4.0F, 8.0F, 8.0F, 7.0F),
                PartPose.offsetAndRotation(2.0F, -10.6F, 0.5F, 0.17453292519943295F, 0.0F,
                        0.17453292519943295F));

        bodyMain.addOrReplaceChild("Body08",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 8.0F, 5.0F, 18.0F),
                PartPose.offset(15.0F, -5.0F, -10.0F));

        bodyMain.addOrReplaceChild("Body02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, -3.4F, 0.0F, 18.0F, 5.0F, 11.0F),
                PartPose.offset(-7.0F, -1.5F, 11.0F));

        bodyMain.addOrReplaceChild("Base02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 7.0F, 16.0F),
                PartPose.offset(8.0F, -1.0F, -24.0F));

        bodyMain.addOrReplaceChild("Base01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 8.0F, 16.0F),
                PartPose.offset(-8.0F, -2.0F, -24.0F));

        bodyMain.addOrReplaceChild("Base05",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 8.0F, 16.0F),
                PartPose.offset(-8.0F, -2.0F, 8.0F));

        PartDefinition body05 = bodyMain.addOrReplaceChild("Body05",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 12.0F, 5.0F, 15.0F),
                PartPose.offset(-20.0F, -5.0F, -22.0F));

        PartDefinition pillar03a = body05.addOrReplaceChild("Pillar03a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-4.5F, -8.0F, -5.0F, 9.0F, 9.0F, 10.0F),
                PartPose.offsetAndRotation(6.0F, 1.0F, 7.0F, -0.17453292519943295F, 0.0F,
                        0.17453292519943295F));

        pillar03a.addOrReplaceChild("Pillar03b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, -6.0F, -3.0F, 6.0F, 8.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, -8.5F, 0.0F, -0.17453292519943295F, 0.0F,
                        0.17453292519943295F));

        bodyMain.addOrReplaceChild("Base03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 6.0F, 16.0F),
                PartPose.offset(8.0F, 0.0F, -8.0F));

        bodyMain.addOrReplaceChild("Base04",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 9.0F, 16.0F),
                PartPose.offset(8.0F, -3.0F, 8.0F));

        bodyMain.addOrReplaceChild("Body04",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 12.0F, 4.0F, 20.0F),
                PartPose.offset(-22.0F, -4.0F, -10.0F));

        PartDefinition body01 = bodyMain.addOrReplaceChild("Body01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 14.0F, 6.0F, 14.0F),
                PartPose.offset(7.0F, -6.0F, 6.0F));

        PartDefinition pillar01a = body01.addOrReplaceChild("Pillar01a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F),
                PartPose.offsetAndRotation(7.0F, 2.0F, 7.0F, 0.17453292519943295F, 0.0F,
                        -0.17453292519943295F));

        pillar01a.addOrReplaceChild("Pillar01b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, -13.3F, -3.0F, 7.0F, 8.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.17453292519943295F, 0.0F,
                        -0.17453292519943295F));

        bodyMain.addOrReplaceChild("Base07",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 8.0F, 16.0F),
                PartPose.offset(-24.0F, -2.0F, -8.0F));

        bodyMain.addOrReplaceChild("Base08",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 16.0F, 5.0F, 16.0F),
                PartPose.offset(-8.0F, 1.0F, -8.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
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
        this.BodyMain.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
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
