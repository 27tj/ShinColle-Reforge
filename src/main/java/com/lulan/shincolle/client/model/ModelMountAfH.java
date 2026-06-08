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
 * ModelMountAfH - PinkaLulan 2015/5/19
 * Ported from Tabula 4.1.1 to 1.20.1 ModelPart system.
 */
public class ModelMountAfH extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "mount_afh"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Jaw;
    private final ModelPart EquipCannon01;
    private final ModelPart EquipCannon02;
    private final ModelPart EquipCannon01_1;
    private final ModelPart EquipCannon02_1;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowJaw;

    public ModelMountAfH(ModelPart root) {
        super();
        this.BodyMain = root.getChild("BodyMain");
        ModelPart neck = this.BodyMain.getChild("Neck");
        this.Jaw = neck.getChild("Jaw");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        ModelPart glowNeck = this.GlowBodyMain.getChild("GlowNeck");
        this.GlowJaw = glowNeck.getChild("GlowJaw");
        ModelPart glowEquipL01 = this.GlowBodyMain.getChild("GlowEquipBaseL").getChild("GlowEquipL01");
        ModelPart equipCannonPlate = glowEquipL01.getChild("EquipCannonPlate");
        this.EquipCannon01 = equipCannonPlate.getChild("EquipCannon01");
        this.EquipCannon02 = equipCannonPlate.getChild("EquipCannon02");
        ModelPart glowEquipR01 = this.GlowBodyMain.getChild("GlowEquipBaseR").getChild("GlowEquipR01");
        ModelPart equipCannonPlate1 = glowEquipR01.getChild("EquipCannonPlate_1");
        this.EquipCannon01_1 = equipCannonPlate1.getChild("EquipCannon01_1");
        this.EquipCannon02_1 = equipCannonPlate1.getChild("EquipCannon02_1");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        // ===== Main body tree =====
        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-9.0F, -7.0F, 10.0F, 18, 12, 9),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("ChestCannon01a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 5, 5, 17),
                PartPose.offsetAndRotation(3.3F, 6.0F, -2.0F, 0.0873F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("ChestCannon02a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 5, 5, 17),
                PartPose.offsetAndRotation(-2.5F, 6.0F, -2.0F, 0.0873F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("ChestCannon03a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 5, 5, 17),
                PartPose.offsetAndRotation(-8.3F, 6.0F, -2.0F, 0.0873F, 0.0F, 0.0F));

        // EquipBaseL
        PartDefinition equipBaseL = bodyMain.addOrReplaceChild("EquipBaseL",
                CubeListBuilder.create().texOffs(0, 10)
                        .addBox(-6.0F, 0.0F, -10.0F, 11, 6, 21),
                PartPose.offsetAndRotation(14.5F, 2.0F, 5.0F, 0.0F, -0.0873F, 0.0F));

        PartDefinition equipL01 = equipBaseL.addOrReplaceChild("EquipL01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-6.0F, 0.0F, -7.0F, 10, 9, 20),
                PartPose.offsetAndRotation(0.0F, -8.0F, 1.0F, -0.1396F, 0.0F, 0.0F));

        equipL01.addOrReplaceChild("EquipL02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-6.5F, 0.0F, -9.0F, 11, 4, 23),
                PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0524F, 0.0F, 0.0F));

        // EquipBaseR
        PartDefinition equipBaseR = bodyMain.addOrReplaceChild("EquipBaseR",
                CubeListBuilder.create().texOffs(0, 10)
                        .addBox(-6.0F, 0.0F, -10.0F, 11, 6, 21),
                PartPose.offsetAndRotation(-13.5F, 2.0F, 5.0F, 0.0F, 0.0873F, 0.0F));

        PartDefinition equipR01 = equipBaseR.addOrReplaceChild("EquipR01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-5.0F, 0.0F, -7.0F, 10, 9, 20),
                PartPose.offsetAndRotation(0.0F, -8.0F, 1.0F, -0.1396F, 0.0F, 0.0F));

        equipR01.addOrReplaceChild("EquipR02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-5.5F, 0.0F, -9.0F, 11, 4, 23),
                PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0524F, 0.0F, 0.0F));

        // Neck
        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(70, 58)
                        .addBox(-7.5F, -15.0F, -3.0F, 15, 15, 14),
                PartPose.offsetAndRotation(-29.0F, 5.0F, 6.0F, 0.0F, 0.2618F, 0.0F));

        neck.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(0, 94)
                        .addBox(-9.5F, -7.0F, -22.0F, 19, 10, 24),
                PartPose.offsetAndRotation(0.0F, -15.0F, 7.0F, -0.2094F, 0.0F, 0.0F));

        neck.addOrReplaceChild("Jaw",
                CubeListBuilder.create().mirror().texOffs(0, 68)
                        .addBox(-9.5F, 0.0F, -15.0F, 19, 7, 19),
                PartPose.offsetAndRotation(0.0F, -3.0F, 0.5F, 0.5463F, 0.0F, 0.0F));

        PartDefinition cannonBase = neck.addOrReplaceChild("CannonBase",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-4.0F, -14.0F, 0.0F, 10, 14, 4),
                PartPose.offsetAndRotation(-1.0F, -16.0F, 7.0F, -0.5236F, 0.0F, 0.0F));

        cannonBase.addOrReplaceChild("Cannon01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, -10.0F, 3, 3, 10),
                PartPose.offset(2.0F, -9.0F, 0.0F));

        cannonBase.addOrReplaceChild("Cannon02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, -10.0F, 3, 3, 10),
                PartPose.offset(-3.0F, -9.0F, 0.0F));

        cannonBase.addOrReplaceChild("Cannon03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, -9.0F, 2, 2, 9),
                PartPose.offset(-3.5F, -11.3F, 0.0F));

        cannonBase.addOrReplaceChild("Cannon04",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, -13.0F, 4, 4, 13),
                PartPose.offsetAndRotation(1.0F, -13.5F, 0.0F, 0.0F, 0.0F, 0.7854F));

        cannonBase.addOrReplaceChild("Cannon05",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, -10.0F, 2, 2, 10),
                PartPose.offsetAndRotation(0.0F, -14.6F, 0.5F, -0.0524F, 0.0F, 0.0F));

        neck.addOrReplaceChild("HeadBack01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 8, 8, 11),
                PartPose.offsetAndRotation(-4.0F, -18.0F, 8.0F, -0.1396F, 0.0F, 0.0F));

        neck.addOrReplaceChild("HeadBack03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 8, 18, 8),
                PartPose.offsetAndRotation(-4.0F, -16.1F, 14.5F, 0.0911F, 0.0F, 0.0F));

        neck.addOrReplaceChild("NeckBack",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 5, 5, 5),
                PartPose.offset(-2.0F, -6.0F, 11.0F));

        // ===== Glow tree =====
        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(-29.0F, 5.0F, 6.0F, 0.0F, 0.2618F, 0.0F));

        // NeckFront (glow geometry in Neck)
        glowNeck.addOrReplaceChild("NeckFront",
                CubeListBuilder.create().texOffs(0, 52)
                        .addBox(-6.5F, 0.0F, 0.0F, 13, 14, 2),
                PartPose.offset(0.0F, -14.0F, -5.0F));

        // GlowHead
        PartDefinition glowHead = glowNeck.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, -15.0F, 7.0F, -0.2094F, 0.0F, 0.0F));

        glowHead.addOrReplaceChild("HeadTooth",
                CubeListBuilder.create().texOffs(62, 98)
                        .addBox(-9.0F, 0.0F, -6.5F, 18, 4, 15),
                PartPose.offsetAndRotation(0.0F, 2.0F, -15.0F, 0.0524F, 0.0F, 0.0F));

        glowHead.addOrReplaceChild("HeadTooth2",
                CubeListBuilder.create().texOffs(65, 99).mirror()
                        .addBox(-8.0F, 0.0F, -14.0F, 16, 3, 14),
                PartPose.offsetAndRotation(0.0F, 3.6F, -6.5F, 0.1745F, 0.0F, 0.0F));

        // GlowJaw
        PartDefinition glowJaw = glowNeck.addOrReplaceChild("GlowJaw",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -3.0F, 0.5F));

        glowJaw.addOrReplaceChild("JawTooth",
                CubeListBuilder.create().texOffs(63, 99)
                        .addBox(-9.0F, 0.0F, -14.0F, 18, 3, 14),
                PartPose.offsetAndRotation(0.0F, -1.6F, -0.3F, -0.0873F, -0.0223F, 0.0F));

        glowJaw.addOrReplaceChild("JawTooth2",
                CubeListBuilder.create().texOffs(66, 100).mirror()
                        .addBox(-8.0F, 0.0F, -13.0F, 16, 3, 13),
                PartPose.offsetAndRotation(0.0F, -2.6F, 0.0F, -0.1396F, 0.0F, 0.0F));

        // GlowCannonBase -> GlowCannon04 -> Cannon06
        PartDefinition glowCannonBase = glowNeck.addOrReplaceChild("GlowCannonBase",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(-1.0F, -16.0F, 7.0F, -0.5236F, 0.0F, 0.0F));

        PartDefinition glowCannon04 = glowCannonBase.addOrReplaceChild("GlowCannon04",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(1.0F, -13.5F, 0.0F, 0.0F, 0.0F, 0.7854F));

        glowCannon04.addOrReplaceChild("Cannon06",
                CubeListBuilder.create().texOffs(74, 0)
                        .addBox(0.0F, 0.0F, -15.0F, 2, 2, 15),
                PartPose.offset(1.0F, 1.0F, -13.0F));

        // GlowEquipBaseL -> GlowEquipL01 -> EquipCannonPlate -> EquipCannon01/02
        PartDefinition glowEquipBaseL = glowBodyMain.addOrReplaceChild("GlowEquipBaseL",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(14.5F, 2.0F, 5.0F, 0.0F, -0.0873F, 0.0F));

        PartDefinition glowEquipL01 = glowEquipBaseL.addOrReplaceChild("GlowEquipL01",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, -8.0F, 1.0F, -0.1396F, 0.0F, 0.0F));

        glowEquipL01.addOrReplaceChild("GlowEquipL02",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0524F, 0.0F, 0.0F));

        PartDefinition equipCannonPlate = glowEquipL01.addOrReplaceChild("EquipCannonPlate",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 4, 6, 1),
                PartPose.offset(-2.0F, 2.0F, -8.0F));

        equipCannonPlate.addOrReplaceChild("EquipCannon01",
                CubeListBuilder.create().texOffs(73, 0)
                        .addBox(0.0F, 0.0F, -7.0F, 1, 1, 7),
                PartPose.offsetAndRotation(1.5F, 1.0F, 0.5F, -0.3187F, -0.0873F, 0.0F));

        equipCannonPlate.addOrReplaceChild("EquipCannon02",
                CubeListBuilder.create().texOffs(73, 0)
                        .addBox(0.0F, 0.0F, -7.0F, 1, 1, 7),
                PartPose.offsetAndRotation(1.5F, 4.0F, 0.5F, 0.0F, -0.0873F, 0.0F));

        // GlowEquipBaseR -> GlowEquipR01 -> EquipCannonPlate_1 -> EquipCannon01_1/02_1
        PartDefinition glowEquipBaseR = glowBodyMain.addOrReplaceChild("GlowEquipBaseR",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(-13.5F, 2.0F, 5.0F, 0.0F, 0.0873F, 0.0F));

        PartDefinition glowEquipR01 = glowEquipBaseR.addOrReplaceChild("GlowEquipR01",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, -8.0F, 1.0F, -0.1396F, 0.0F, 0.0F));

        PartDefinition equipCannonPlate1 = glowEquipR01.addOrReplaceChild("EquipCannonPlate_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 4, 6, 1),
                PartPose.offset(-2.0F, 2.0F, -8.0F));

        equipCannonPlate1.addOrReplaceChild("EquipCannon01_1",
                CubeListBuilder.create().texOffs(73, 0)
                        .addBox(0.0F, 0.0F, -7.0F, 1, 1, 7),
                PartPose.offsetAndRotation(1.5F, 1.0F, 0.5F, -0.1820F, 0.1367F, 0.0F));

        equipCannonPlate1.addOrReplaceChild("EquipCannon02_1",
                CubeListBuilder.create().texOffs(73, 0)
                        .addBox(0.0F, 0.0F, -7.0F, 1, 1, 7),
                PartPose.offsetAndRotation(1.5F, 4.0F, 0.5F, 0.1820F, 0.0911F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
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

        // Jaw animation
        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += angleX * 0.025F + 0.025F;
        this.Jaw.xRot = angleX * 0.1F + 0.4F;

        // Cannon oscillation
        this.EquipCannon01.xRot = angleX * 0.08F - 0.32F;
        this.EquipCannon02.xRot = -angleX * 0.14F;
        this.EquipCannon01_1.xRot = -angleX * 0.12F - 0.18F;
        this.EquipCannon02_1.xRot = angleX * 0.08F + 0.18F;

        // Sync glow jaw
        this.GlowJaw.xRot = this.Jaw.xRot;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
                               float red, float green, float blue, float alpha) {
        poseStack.pushPose();
        poseStack.scale(0.7F, 0.7F, 0.7F);
        poseStack.translate(0F, 1.10F, -0.47F);

        this.BodyMain.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.GlowBodyMain.render(poseStack, buffer, 0xF000F0, packedOverlay, red, green, blue, alpha);

        poseStack.popPose();
    }

    // No face system
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
        this.GlowJaw.xRot = this.Jaw.xRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
    }
}
