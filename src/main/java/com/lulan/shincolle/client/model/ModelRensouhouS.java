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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

/**
 * ModelRensouhouS - PinkaLulan 2015/3/30
 * Ported from Tabula 4.1.1 to 1.20.1 ModelPart system.
 */
public class ModelRensouhouS extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "rensouhou_s"), "main");

    private final ModelPart BodyMain;
    private final ModelPart TailJaw1;
    private final ModelPart HeadCannon1;
    private final ModelPart HeadCannon2;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowTailJaw1;

    public ModelRensouhouS(ModelPart root) {
        super();
        this.scale = 0.4F;
        this.offsetY = 0.75F;
        this.BodyMain = root.getChild("BodyMain");
        ModelPart headBase = this.BodyMain.getChild("HeadBase");
        this.TailJaw1 = headBase.getChild("TailJaw1");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        ModelPart glowHeadBase = this.GlowBodyMain.getChild("GlowHeadBase");
        this.GlowTailJaw1 = glowHeadBase.getChild("GlowTailJaw1");
        ModelPart glowHead = glowHeadBase.getChild("GlowHead");
        ModelPart glowTailHead2 = glowHead.getChild("GlowTailHead2");
        this.HeadCannon1 = glowTailHead2.getChild("HeadCannon1");
        this.HeadCannon2 = glowTailHead2.getChild("HeadCannon2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        // BodyMain (empty scaffold)
        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        // HeadBase (child of BodyMain)
        PartDefinition headBase = bodyMain.addOrReplaceChild("HeadBase",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-6.0F, -8.0F, 2.0F, 12, 15, 8),
                PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, -0.1396F, -3.1416F, 0.0F));

        // TailJaw1 (child of HeadBase)
        PartDefinition tailJaw1 = headBase.addOrReplaceChild("TailJaw1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-6.5F, 0.0F, 0.0F, 13, 5, 16),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, -0.3142F, 0.0F, 0.0F));

        // Tube01 (child of TailJaw1)
        tailJaw1.addOrReplaceChild("Tube01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-0.5F, 0.0F, 0.0F, 1, 1, 10),
                PartPose.offsetAndRotation(-4.5F, 3.0F, 13.0F, -0.1745F, -0.0524F, 0.0F));

        // Tube02 (child of TailJaw1)
        tailJaw1.addOrReplaceChild("Tube02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-0.5F, 0.0F, 0.0F, 1, 1, 10),
                PartPose.offsetAndRotation(4.5F, 3.0F, 13.0F, -0.1745F, 0.0524F, 0.0F));

        // Tube03 (child of TailJaw1)
        tailJaw1.addOrReplaceChild("Tube03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 11, 1, 1),
                PartPose.offset(-5.5F, 4.6F, 22.0F));

        // Head (child of HeadBase)
        PartDefinition head = headBase.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-7.0F, -0.2F, -3.6F, 14, 8, 10),
                PartPose.offsetAndRotation(0.0F, -8.5F, 4.0F, 0.1745F, 0.0F, 0.0F));

        // TailHead2 (child of Head)
        head.addOrReplaceChild("TailHead2",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-7.0F, 0.0F, 0.0F, 14, 8, 13),
                PartPose.offset(0.0F, -1.0F, 6.5F));

        // TailHeadCL1 (child of HeadBase)
        headBase.addOrReplaceChild("TailHeadCL1",
                CubeListBuilder.create().texOffs(36, 25)
                        .addBox(0.0F, -3.0F, -3.0F, 3, 6, 6),
                PartPose.offsetAndRotation(5.5F, 0.0F, 9.0F, 0.7854F, 0.1396F, 0.0F));

        // TailHeadCR1 (child of HeadBase, mirrored)
        headBase.addOrReplaceChild("TailHeadCR1",
                CubeListBuilder.create().texOffs(36, 25).mirror()
                        .addBox(-3.0F, -3.0F, -3.0F, 3, 6, 6),
                PartPose.offsetAndRotation(-5.5F, 0.0F, 9.0F, 0.7854F, -0.1396F, 0.0F));

        // ===== Glow tree =====
        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition glowHeadBase = glowBodyMain.addOrReplaceChild("GlowHeadBase",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, -0.1396F, -3.1416F, 0.0F));

        PartDefinition glowHead = glowHeadBase.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, -8.5F, 4.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition glowTailHead2 = glowHead.addOrReplaceChild("GlowTailHead2",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -1.0F, 6.5F));

        PartDefinition glowTailJaw1 = glowHeadBase.addOrReplaceChild("GlowTailJaw1",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, -0.3142F, 0.0F, 0.0F));

        // Tooth01 (child of GlowHead - glow only)
        glowHead.addOrReplaceChild("Tooth01",
                CubeListBuilder.create().texOffs(0, 25)
                        .addBox(-6.0F, 0.0F, 0.0F, 12, 5, 12),
                PartPose.offsetAndRotation(0.0F, 4.5F, 4.5F, -0.1745F, 0.0F, 0.0F));

        // Tooth02 (child of GlowTailJaw1 - glow only)
        glowTailJaw1.addOrReplaceChild("Tooth02",
                CubeListBuilder.create().texOffs(2, 42)
                        .addBox(-5.5F, 0.0F, 0.0F, 11, 5, 11),
                PartPose.offsetAndRotation(0.0F, -3.0F, 4.0F, 0.1745F, 0.0F, 0.0F));

        // HeadCannon1 (child of GlowTailHead2 - glow only)
        glowTailHead2.addOrReplaceChild("HeadCannon1",
                CubeListBuilder.create().texOffs(26, 6)
                        .addBox(-2.0F, -2.0F, 0.0F, 4, 4, 15),
                PartPose.offsetAndRotation(3.2F, 3.5F, 12.0F, 0.0873F, 0.0873F, 0.0176F));

        // HeadCannon2 (child of GlowTailHead2 - glow only)
        glowTailHead2.addOrReplaceChild("HeadCannon2",
                CubeListBuilder.create().texOffs(26, 6)
                        .addBox(-2.0F, -2.0F, 0.0F, 4, 4, 15),
                PartPose.offsetAndRotation(-3.2F, 3.5F, 12.0F, 0.0873F, -0.0873F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
        IShipEmotion ent = (IShipEmotion) entity;

        float angleX = Mth.cos(ageInTicks * 0.1F);

        // Jaw animation
        this.TailJaw1.xRot = angleX * 0.05F - 0.3142F;

        // Cannon oscillation
        this.HeadCannon1.xRot = angleX * 0.1F + 0.15F;
        this.HeadCannon2.xRot = -angleX * 0.1F + 0.15F;

        // Attack - wider jaw
        if (ent.getAttackTick() > 0) {
            this.TailJaw1.xRot = angleX * 0.3F - 0.8F;
        }

        // Sync glow jaw rotation
        this.GlowTailJaw1.xRot = this.TailJaw1.xRot;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
                               float red, float green, float blue, float alpha) {
        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);
        poseStack.translate(offsetX, offsetY, offsetZ);

        // Main body
        this.BodyMain.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);

        // Glow parts (full brightness)
        this.GlowBodyMain.render(poseStack, buffer, 0xF000F0, packedOverlay, red, green, blue, alpha);

        poseStack.popPose();
    }

    // No face system - override all as no-ops
    @Override
    public void setFace(int emo) {
    }

    @Override
    public void setMouth(int emo) {
    }

    @Override
    public void setFlush(boolean show) {
    }

    @Override
    public void setFaceNormal(IShipEmotion ent) {
    }

    @Override
    public void setFaceBlink0(IShipEmotion ent) {
    }

    @Override
    public void setFaceBlink1(IShipEmotion ent) {
    }

    @Override
    public void setFaceCry(IShipEmotion ent) {
    }

    @Override
    public void setFaceAttack(IShipEmotion ent) {
    }

    @Override
    public void setFaceDamaged(IShipEmotion ent) {
    }

    @Override
    public void setFaceScorn(IShipEmotion ent) {
    }

    @Override
    public void setFaceHungry(IShipEmotion ent) {
    }

    @Override
    public void setFaceAngry(IShipEmotion ent) {
    }

    @Override
    public void setFaceBored(IShipEmotion ent) {
    }

    @Override
    public void setFaceShy(IShipEmotion ent) {
    }

    @Override
    public void setFaceHappy(IShipEmotion ent) {
    }

    @Override
    public void showEquip(IShipEmotion ent) {
    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowTailJaw1.xRot = this.TailJaw1.xRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
    }
}
