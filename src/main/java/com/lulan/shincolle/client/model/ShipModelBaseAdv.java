package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.reference.ID;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;

import java.util.NoSuchElementException;

/**
 * Base model class for ShinColle ship entities (1.20.1 port).
 * <p>
 * Replaces the old ShipModelBaseAdv which extended ModelBase.
 * All ship models extend this class and implement their own
 * createBodyLayer() static method for part definitions.
 */
public abstract class ShipModelBaseAdv<T extends Entity> extends EntityModel<T> implements IModelEmotionAdv {

    protected float scale = 1F;
    protected float offsetX = 0F;
    protected float offsetY = 0F;
    protected float offsetZ = 0F;
    // Held item support fields
    protected ModelPart[] armMain;
    protected ModelPart[] armOff;
    protected float[] offsetItem = new float[]{0F, 0F, 0F};
    protected float[] rotateItem = new float[]{0F, 0F, 0F};
    protected float[] offsetBlock = new float[]{0F, 0F, 0F};
    protected float[] rotateBlock = new float[]{0F, 0F, 0F};
    // Face parts (for emotion system)
    protected ModelPart Face0;
    protected ModelPart Face1;
    protected ModelPart Face2;
    protected ModelPart Face3;
    protected ModelPart Face4;
    protected ModelPart Mouth0;
    protected ModelPart Mouth1;
    protected ModelPart Mouth2;
    protected ModelPart Flush0;
    protected ModelPart Flush1;
    private boolean offsetBaseInitialized = false;
    private float baseOffsetX = 0F;
    private float baseOffsetY = 0F;
    private float baseOffsetZ = 0F;

    public ShipModelBaseAdv() {
        super();
    }

    /**
     * Helper: add default face parts to a PartDefinition (the glow head).
     * Call from createBodyLayer() in subclass to add Face0-4, Mouth0-2, Flush0-1.
     */
    protected static void addDefaultFaceParts(PartDefinition glowHead) {
        glowHead.addOrReplaceChild("Face0",
                CubeListBuilder.create().texOffs(98, 63)
                        .addBox(-7.0F, 0.0F, -0.5F, 14, 12, 1),
                PartPose.offset(0.0F, -12.2F, -6.1F));
        glowHead.addOrReplaceChild("Face1",
                CubeListBuilder.create().texOffs(98, 76)
                        .addBox(-7.0F, 0.0F, -0.5F, 14, 12, 1),
                PartPose.offset(0.0F, -12.2F, -6.1F));
        glowHead.addOrReplaceChild("Face2",
                CubeListBuilder.create().texOffs(98, 89)
                        .addBox(-7.0F, 0.0F, -0.5F, 14, 12, 1),
                PartPose.offset(0.0F, -12.2F, -6.1F));
        glowHead.addOrReplaceChild("Face3",
                CubeListBuilder.create().texOffs(98, 102)
                        .addBox(-7.0F, 0.0F, -0.5F, 14, 12, 1),
                PartPose.offset(0.0F, -12.2F, -6.1F));
        glowHead.addOrReplaceChild("Face4",
                CubeListBuilder.create().texOffs(98, 115)
                        .addBox(-7.0F, 0.0F, -0.5F, 14, 12, 1),
                PartPose.offset(0.0F, -12.2F, -6.1F));
        glowHead.addOrReplaceChild("Mouth0",
                CubeListBuilder.create().texOffs(100, 53)
                        .addBox(-3.0F, 0.0F, -0.5F, 6, 4, 1),
                PartPose.offset(0.0F, -4.2F, -6.2F));
        glowHead.addOrReplaceChild("Mouth1",
                CubeListBuilder.create().texOffs(100, 58)
                        .addBox(-3.0F, 0.0F, -0.5F, 6, 4, 1),
                PartPose.offset(0.0F, -4.2F, -6.2F));
        glowHead.addOrReplaceChild("Mouth2",
                CubeListBuilder.create().texOffs(114, 53)
                        .addBox(-3.0F, 0.0F, -0.5F, 6, 4, 1),
                PartPose.offset(0.0F, -4.2F, -6.2F));
        glowHead.addOrReplaceChild("Flush0",
                CubeListBuilder.create().texOffs(114, 58)
                        .addBox(-1.0F, 0.0F, -0.5F, 2, 1, 0),
                PartPose.offset(-6F, -3.0F, -6.9F));
        glowHead.addOrReplaceChild("Flush1",
                CubeListBuilder.create().texOffs(114, 58)
                        .addBox(-1.0F, 0.0F, -0.5F, 2, 1, 0),
                PartPose.offset(6F, -3.0F, -6.9F));
    }

    private static ModelPart getOptionalChild(ModelPart parent, String childName) {
        try {
            return parent.getChild(childName);
        } catch (NoSuchElementException ignored) {
            return null;
        }
    }

    /**
     * Helper: load face parts from a ModelPart (the glow head).
     * Call from constructor after getting the glow head part.
     */
    protected void loadFaceParts(ModelPart glowHead) {
        // [PORT] 1.10.2 -> 1.20.1: some migrated models omit parts; missing face parts
        // should disable expressions instead of crashing renderer bootstrap.
        this.Face0 = getOptionalChild(glowHead, "Face0");
        this.Face1 = getOptionalChild(glowHead, "Face1");
        this.Face2 = getOptionalChild(glowHead, "Face2");
        this.Face3 = getOptionalChild(glowHead, "Face3");
        this.Face4 = getOptionalChild(glowHead, "Face4");
        this.Mouth0 = getOptionalChild(glowHead, "Mouth0");
        this.Mouth1 = getOptionalChild(glowHead, "Mouth1");
        this.Mouth2 = getOptionalChild(glowHead, "Mouth2");
        this.Flush0 = getOptionalChild(glowHead, "Flush0");
        this.Flush1 = getOptionalChild(glowHead, "Flush1");
    }

    public float getScale() {
        return this.scale;
    }

    public float getOffsetY() {
        return this.offsetY;
    }

    @Override
    public void prepareMobModel(T entity, float limbSwing, float limbSwingAmount, float partialTick) {
        super.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTick);
        captureBaseOffsetsIfNeeded();
        // [PORT] 1.10.2 -> 1.20.1: offsetY accumulates former
        // GlStateManager.translate()
        // conversions; reset each frame to avoid cross-frame drift.
        // [REPRO?] visual verification pending: check NoFuel grounding on multiple ship
        // classes.
        resetOffsetsToBase();
    }

    private void captureBaseOffsetsIfNeeded() {
        if (this.offsetBaseInitialized) {
            return;
        }

        this.baseOffsetX = this.offsetX;
        this.baseOffsetY = this.offsetY;
        this.baseOffsetZ = this.offsetZ;
        this.offsetBaseInitialized = true;
    }

    private void resetOffsetsToBase() {
        this.offsetX = this.baseOffsetX;
        this.offsetY = this.baseOffsetY;
        this.offsetZ = this.baseOffsetZ;
    }

    /**
     * Get the arm ModelPart chain from body to hand for the specified side.
     * Subclasses should set armMain/armOff in their constructors.
     */
    public ModelPart[] getArmForSide(HumanoidArm side) {
        return side == HumanoidArm.RIGHT ? this.armMain : this.armOff;
    }

    /**
     * Get the held item rendering offset for this model.
     * Override in subclasses for custom positioning.
     *
     * @param ent  the ship entity
     * @param side which arm
     * @param type 0 = item, 1 = block
     */
    public float[] getHeldItemOffset(IShipEmotion ent, HumanoidArm side, int type) {
        return type == 0 ? this.offsetItem : this.offsetBlock;
    }

    /**
     * Get the held item rendering rotation for this model.
     * Override in subclasses for custom rotation.
     *
     * @param ent  the ship entity
     * @param side which arm
     * @param type 0 = item, 1 = block
     */
    public float[] getHeldItemRotate(IShipEmotion ent, HumanoidArm side, int type) {
        return type == 0 ? this.rotateItem : this.rotateBlock;
    }

    // ========== Emotion Methods (ported from ShipModelBaseAdv) ==========

    @Override
    public void setFace(int emo) {
        if (this.Face0 != null)
            this.Face0.visible = (emo == 0 || emo == 5);
        if (this.Face1 != null)
            this.Face1.visible = (emo == 1 || emo == 6);
        if (this.Face2 != null)
            this.Face2.visible = (emo == 2 || emo == 7);
        if (this.Face3 != null)
            this.Face3.visible = (emo == 3 || emo == 8);
        if (this.Face4 != null)
            this.Face4.visible = (emo == 4 || emo == 9);

        // Reset Y rotation, then flip if emo >= 5
        if (emo >= 0 && emo <= 4) {
            if (emo == 0 && this.Face0 != null)
                this.Face0.yRot = 0F;
            if (emo == 1 && this.Face1 != null)
                this.Face1.yRot = 0F;
            if (emo == 2 && this.Face2 != null)
                this.Face2.yRot = 0F;
            if (emo == 3 && this.Face3 != null)
                this.Face3.yRot = 0F;
            if (emo == 4 && this.Face4 != null)
                this.Face4.yRot = 0F;
        } else {
            int base = emo - 5;
            if (base == 0 && this.Face0 != null)
                this.Face0.yRot = 3.14159F;
            if (base == 1 && this.Face1 != null)
                this.Face1.yRot = 3.14159F;
            if (base == 2 && this.Face2 != null)
                this.Face2.yRot = 3.14159F;
            if (base == 3 && this.Face3 != null)
                this.Face3.yRot = 3.14159F;
            if (base == 4 && this.Face4 != null)
                this.Face4.yRot = 3.14159F;
        }
    }

    @Override
    public void setMouth(int emo) {
        if (this.Mouth0 != null)
            this.Mouth0.visible = (emo == 0 || emo == 3);
        if (this.Mouth1 != null)
            this.Mouth1.visible = (emo == 1 || emo == 4);
        if (this.Mouth2 != null)
            this.Mouth2.visible = (emo == 2 || emo == 5);

        if (emo <= 2) {
            if (emo == 0 && this.Mouth0 != null)
                this.Mouth0.yRot = 0F;
            if (emo == 1 && this.Mouth1 != null)
                this.Mouth1.yRot = 0F;
            if (emo == 2 && this.Mouth2 != null)
                this.Mouth2.yRot = 0F;
        } else {
            if (emo == 3 && this.Mouth0 != null)
                this.Mouth0.yRot = 3.14159F;
            if (emo == 4 && this.Mouth1 != null)
                this.Mouth1.yRot = 3.14159F;
            if (emo == 5 && this.Mouth2 != null)
                this.Mouth2.yRot = 3.14159F;
        }
    }

    @Override
    public void setFlush(boolean show) {
        if (this.Flush0 != null)
            this.Flush0.visible = show;
        if (this.Flush1 != null)
            this.Flush1.visible = show;
    }

    @Override
    public void setFaceNormal(IShipEmotion ent) {
        this.setFace(0);
        if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED && (ent.getTickExisted() & 255) > 160) {
            this.setMouth(3);
        } else {
            this.setMouth(0);
        }
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
        int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 255;
        if (t < 128) {
            this.setFace(6);
            this.setMouth(t < 64 ? 5 : 2);
        } else {
            this.setFace(7);
            this.setMouth(2);
        }
    }

    @Override
    public void setFaceAttack(IShipEmotion ent) {
        int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 511;
        if (t < 128) {
            this.setFace(1);
            this.setMouth(t < 64 ? 0 : 2);
        } else if (t < 256) {
            this.setFace(2);
            this.setMouth(t < 180 ? 0 : 1);
        } else if (t < 384) {
            this.setFace(3);
            this.setMouth(t < 320 ? 0 : 4);
        } else {
            this.setFace(8);
            this.setMouth(t < 450 ? 0 : 1);
        }
    }

    @Override
    public void setFaceDamaged(IShipEmotion ent) {
        int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 511;
        if (t < 200) {
            this.setFace(6);
            this.setMouth(t < 60 ? 5 : 2);
        } else if (t < 400) {
            this.setFace(3);
            this.setMouth(t < 250 ? 0 : 4);
        } else {
            this.setFace(9);
            this.setMouth(t < 450 ? 0 : 1);
        }
    }

    @Override
    public void setFaceScorn(IShipEmotion ent) {
        this.setFace(2);
        this.setMouth(1);
    }

    @Override
    public void setFaceHungry(IShipEmotion ent) {
        this.setFace(4);
        this.setMouth(2);
    }

    @Override
    public void setFaceAngry(IShipEmotion ent) {
        int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 255;
        if (t < 128) {
            this.setFace(1);
            this.setMouth(t < 64 ? 0 : 1);
        } else {
            this.setFace(2);
            this.setMouth(t < 170 ? 1 : 2);
        }
    }

    @Override
    public void setFaceBored(IShipEmotion ent) {
        int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 511;
        if (t < 170) {
            this.setFace(5);
            this.setMouth(t < 80 ? 0 : 4);
        } else if (t < 340) {
            this.setFace(8);
            this.setMouth(0);
        } else {
            this.setFace(0);
            this.setMouth(0);
        }
    }

    @Override
    public void setFaceShy(IShipEmotion ent) {
        this.setFlush(true);
        int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 255;
        if (t < 140) {
            this.setFace(0);
            this.setMouth(t < 80 ? 3 : 2);
        } else {
            this.setFace(8);
            this.setMouth(0);
        }
    }

    @Override
    public void setFaceHappy(IShipEmotion ent) {
        this.setFlush(true);
        int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 255;
        if (t < 140) {
            this.setFace(3);
            this.setMouth(t < 80 ? 0 : 4);
        } else {
            this.setFace(8);
            this.setMouth(4);
        }
    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void setField(int id, float value) {
    }

    @Override
    public float getField(int id) {
        return 0;
    }

    /**
     * Override in subclasses that render misc models (e.g. block entity desk).
     */
    public boolean shouldRenderMiscModel(int miscID) {
        return false;
    }
}
