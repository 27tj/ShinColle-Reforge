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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import java.util.NoSuchElementException;

public class ModelMountCaWD extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "mount_cawd"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Neck;
    private final ModelPart WingL01a;
    private final ModelPart WingR01a;
    private final ModelPart Seat01;
    private final ModelPart Back01;
    private final ModelPart Back02;
    private final ModelPart WingL03;
    private final ModelPart WingR03;
    private final ModelPart WingL04;
    private final ModelPart WingR04;
    private final ModelPart Back03;
    private final ModelPart Back04;
    private final ModelPart WingL02;
    private final ModelPart WingR02;
    private final ModelPart CannonL01;
    private final ModelPart CannonR01;
    private final ModelPart Tube01a;
    private final ModelPart Tube02a;
    private final ModelPart CannonM01;
    private final ModelPart Head01;
    private final ModelPart Jaw01;
    private final ModelPart Head02;
    private final ModelPart HeadTooth01;
    private final ModelPart HeadTooth02;
    private final ModelPart Jaw02;
    private final ModelPart JawTooth01;
    private final ModelPart JawTooth02;
    private final ModelPart WingL01b;
    private final ModelPart WingL01c;
    private final ModelPart WingL01Fire;
    private final ModelPart WingR01b;
    private final ModelPart WingR01c;
    private final ModelPart WingR01Fire;
    private final ModelPart Seat02;
    private final ModelPart Seat03;
    private final ModelPart CannonL02;
    private final ModelPart CannonR02;
    private final ModelPart Tube01b;
    private final ModelPart Tube02b;
    private final ModelPart CannonM02;
    private final ModelPart CannonM04;
    private final ModelPart CannonM03;
    private final ModelPart CannonM05;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowBodyMain2;
    private final ModelPart GlowNeck;
    private final ModelPart GlowJaw01;
    private final ModelPart GlowHead01;
    private final ModelPart GlowWingL01a;
    private final ModelPart GlowWingL01a2;
    private final ModelPart GlowWingL01b;
    private final ModelPart GlowWingR01a;
    private final ModelPart GlowWingR01a2;
    private final ModelPart GlowWingR01b;
    private final ModelPart GlowCannonL01;
    private final ModelPart GlowCannonR01;
    private final ModelPart GlowCannonM01;
    private final ModelPart GlowCannonM02;
    private final ModelPart GlowCannonM04;

    public ModelMountCaWD(ModelPart root) {
        super();
        this.BodyMain = root.getChild("BodyMain");
        this.Neck = this.BodyMain.getChild("Neck");
        this.Tube01a = this.BodyMain.getChild("Tube01a");
        this.Seat01 = this.BodyMain.getChild("Seat01");
        this.WingR01a = this.BodyMain.getChild("WingR01a");
        this.Back01 = this.BodyMain.getChild("Back01");
        this.Back03 = this.BodyMain.getChild("Back03");
        this.CannonM01 = this.BodyMain.getChild("CannonM01");
        this.CannonR01 = this.BodyMain.getChild("CannonR01");
        this.WingL01a = this.BodyMain.getChild("WingL01a");
        this.Back02 = this.BodyMain.getChild("Back02");
        this.Back04 = this.BodyMain.getChild("Back04");
        this.CannonL01 = this.BodyMain.getChild("CannonL01");
        this.Tube02a = this.BodyMain.getChild("Tube02a");
        this.Head01 = this.Neck.getChild("Head01");
        this.Jaw01 = this.Neck.getChild("Jaw01");
        this.Tube01b = this.Tube01a.getChild("Tube01b");
        this.Seat03 = this.Seat01.getChild("Seat03");
        this.Seat02 = this.Seat01.getChild("Seat02");
        this.CannonM02 = this.CannonM01.getChild("CannonM02");
        this.CannonM04 = this.CannonM01.getChild("CannonM04");
        this.Tube02b = this.Tube02a.getChild("Tube02b");
        this.Head02 = this.Head01.getChild("Head02");
        this.Jaw02 = this.Jaw01.getChild("Jaw02");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowBodyMain2 = root.getChild("GlowBodyMain2");
        this.GlowNeck = this.GlowBodyMain.getChild("GlowNeck");
        this.GlowWingL01a = this.GlowBodyMain.getChild("GlowWingL01a");
        this.GlowWingR01a = this.GlowBodyMain.getChild("GlowWingR01a");
        this.GlowCannonL01 = this.GlowBodyMain.getChild("GlowCannonL01");
        this.GlowCannonR01 = this.GlowBodyMain.getChild("GlowCannonR01");
        this.GlowCannonM01 = this.GlowBodyMain.getChild("GlowCannonM01");
        this.GlowWingL01a2 = this.GlowBodyMain2.getChild("GlowWingL01a2");
        this.GlowWingR01a2 = this.GlowBodyMain2.getChild("GlowWingR01a2");

        // [PORT] 1.10.2 -> 1.20.1: missing migrated wing subparts should degrade
        // gracefully instead of crashing model construction.
        this.WingL01b = getChildOrFallback(this.GlowWingL01a2, "WingL01b");
        this.WingL01c = getChildOrFallback(this.WingL01b, "WingL01c");

        this.GlowJaw01 = this.GlowNeck.getChild("GlowJaw01");
        this.GlowHead01 = this.GlowNeck.getChild("GlowHead01");
        this.GlowWingL01b = this.GlowWingL01a.getChild("GlowWingL01b");
        this.GlowWingR01b = this.GlowWingR01a.getChild("GlowWingR01b");
        this.GlowCannonM02 = this.GlowCannonM01.getChild("GlowCannonM02");
        this.GlowCannonM04 = this.GlowCannonM01.getChild("GlowCannonM04");

        this.JawTooth01 = this.GlowJaw01.getChild("JawTooth01");
        this.JawTooth02 = this.JawTooth01.getChild("JawTooth02");
        this.HeadTooth01 = this.GlowHead01.getChild("HeadTooth01");
        this.HeadTooth02 = this.HeadTooth01.getChild("HeadTooth02");
        this.WingL01Fire = this.GlowWingL01b.getChild("WingL01Fire");
        this.WingR01Fire = this.GlowWingR01b.getChild("WingR01Fire");
        this.CannonL02 = this.GlowCannonL01.getChild("CannonL02");
        this.CannonR02 = this.GlowCannonR01.getChild("CannonR02");
        this.CannonM03 = this.GlowCannonM02.getChild("CannonM03");
        this.CannonM05 = this.GlowCannonM04.getChild("CannonM05");
        this.WingR01b = getChildOrFallback(this.GlowWingR01a2, "WingR01b");
        this.WingR01c = getChildOrFallback(this.WingR01b, "WingR01c");
        this.WingL02 = this.GlowBodyMain2.getChild("WingL02");
        this.WingR02 = this.GlowBodyMain2.getChild("WingR02");
        this.WingL03 = this.GlowBodyMain2.getChild("WingL03");
        this.WingR03 = this.GlowBodyMain2.getChild("WingR03");
        this.WingL04 = this.GlowBodyMain2.getChild("WingL04");
        this.WingR04 = this.GlowBodyMain2.getChild("WingR04");
    }

    private static ModelPart getChildOrFallback(ModelPart parent, String childName) {
        try {
            return parent.getChild(childName);
        } catch (NoSuchElementException ignored) {
            return parent;
        }
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-6.5F, 0.0F, 0.0F, 13.0F, 12.0F, 8.0F),
                PartPose.offset(0.0F, 0.0F, 8.0F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(54, 0)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 12.0F, 5.0F),
                PartPose.offset(0.0F, 0.0F, -5.0F));

        PartDefinition head01 = neck.addOrReplaceChild("Head01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-7.0F, -6.0F, -15.0F, 14.0F, 6.0F, 13.0F),
                PartPose.offset(0.0F, 5.8F, 5.0F));

        head01.addOrReplaceChild("Head02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-5.0F, 0.0F, -5.0F, 10.0F, 6.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, -5.9F, -15.0F, 0.0F, 0.7853981633974483F, 0.0F));

        PartDefinition jaw01 = neck.addOrReplaceChild("Jaw01",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-7.0F, 0.0F, -15.0F, 14.0F, 6.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, 7.0F, 6.0F, 0.3141592653589793F, 0.0F, 0.0F));

        jaw01.addOrReplaceChild("Jaw02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-5.0F, 0.0F, -5.0F, 10.0F, 6.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, -0.1F, -15.0F, 0.0F, 0.7853981633974483F, 0.0F));

        PartDefinition tube01a = bodyMain.addOrReplaceChild("Tube01a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, -7.0F, 0.0F, 1.0F, 7.0F, 1.0F),
                PartPose.offsetAndRotation(4.0F, 1.0F, 9.0F, -0.7853981633974483F, 0.8726646259971648F,
                        0.2617993877991494F));

        tube01a.addOrReplaceChild("Tube01b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, -7.0F, -1.0F, 1.0F, 7.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, 1.0F, 1.3962634015954636F, 0.0F, 0.0F));

        PartDefinition seat01 = bodyMain.addOrReplaceChild("Seat01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, -10.5F, 0.3F, -0.10471975511965977F, 0.0F, 0.0F));

        seat01.addOrReplaceChild("Seat03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.0F, 0.0F, -9.0F, 2.0F, 10.0F, 9.0F),
                PartPose.offsetAndRotation(-6.2F, 1.0F, 0.5F, 0.10471975511965977F,
                        0.10471975511965977F, -0.10471975511965977F));

        seat01.addOrReplaceChild("Seat02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, -9.0F, 2.0F, 10.0F, 9.0F),
                PartPose.offsetAndRotation(6.2F, 1.0F, 0.5F, 0.10471975511965977F,
                        -0.10471975511965977F, 0.10471975511965977F));

        bodyMain.addOrReplaceChild("WingR01a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-7.0F, 0.0F, 0.0F, 7.0F, 2.0F, 2.0F),
                PartPose.offsetAndRotation(-6.0F, 13.5F, -4.0F, 0.0F, 0.3490658503988659F,
                        -0.5235987755982988F));

        bodyMain.addOrReplaceChild("Back01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 9.0F, 5.0F),
                PartPose.offset(0.0F, -9.0F, 1.0F));

        bodyMain.addOrReplaceChild("Back03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-9.0F, 0.0F, 0.0F, 18.0F, 14.0F, 7.0F),
                PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition cannonM01 = bodyMain.addOrReplaceChild("CannonM01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, -3.0F, -4.0F, 6.0F, 3.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, -8.5F, 7.0F, -0.8726646259971648F, 0.0F, 0.0F));

        cannonM01.addOrReplaceChild("CannonM02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 2.0F),
                PartPose.offset(1.3F, -1.7F, -3.5F));

        cannonM01.addOrReplaceChild("CannonM04",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 2.0F),
                PartPose.offset(-1.3F, -1.7F, -3.5F));

        bodyMain.addOrReplaceChild("CannonR01",
                CubeListBuilder.create().texOffs(9, 0)
                        .addBox(-3.5F, -5.0F, -8.0F, 7.0F, 5.0F, 8.0F),
                PartPose.offsetAndRotation(-8.0F, -6.0F, 9.0F, -0.5235987755982988F,
                        0.5235987755982988F, 0.0F));

        PartDefinition wingL01a = bodyMain.addOrReplaceChild("WingL01a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 7.0F, 2.0F, 2.0F),
                PartPose.offsetAndRotation(6.0F, 13.5F, -4.0F, 0.0F, -0.3490658503988659F,
                        0.5235987755982988F));

        PartDefinition wingL01b = wingL01a.addOrReplaceChild("WingL01b",
                CubeListBuilder.create().texOffs(25, 39)
                        .addBox(0.0F, 0.0F, 0.0F, 3.0F, 5.0F, 8.0F),
                PartPose.offsetAndRotation(6.5F, -1.5F, -4.0F, -0.08726646259971647F,
                        -0.08726646259971647F, 0.0F));

        wingL01b.addOrReplaceChild("WingL01c",
                CubeListBuilder.create().texOffs(0, 53)
                        .addBox(-3.0F, 0.0F, -6.0F, 3.0F, 5.0F, 6.0F),
                PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, 0.5235987755982988F, 0.0F));

        bodyMain.addOrReplaceChild("Back02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-5.0F, 0.0F, 0.0F, 10.0F, 14.0F, 4.0F),
                PartPose.offset(0.0F, -7.0F, 6.0F));

        bodyMain.addOrReplaceChild("Back04",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-8.0F, 0.0F, 0.0F, 16.0F, 2.0F, 3.0F),
                PartPose.offset(0.0F, 7.0F, 6.0F));

        bodyMain.addOrReplaceChild("CannonL01",
                CubeListBuilder.create().texOffs(9, 0)
                        .addBox(-3.5F, -5.0F, -8.0F, 7.0F, 5.0F, 8.0F),
                PartPose.offsetAndRotation(8.0F, -6.0F, 9.0F, -0.5235987755982988F,
                        -0.5235987755982988F, 0.0F));

        PartDefinition tube02a = bodyMain.addOrReplaceChild("Tube02a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -7.0F, -1.0F, 1.0F, 7.0F, 1.0F),
                PartPose.offsetAndRotation(-5.0F, 2.0F, 9.0F, -0.7853981633974483F,
                        -0.13962634015954636F, -0.2617993877991494F));

        tube02a.addOrReplaceChild("Tube02b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -7.0F, -1.0F, 1.0F, 7.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 1.3962634015954636F, 0.0F, 0.0F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 8.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, -5.0F));

        PartDefinition glowJaw01 = glowNeck.addOrReplaceChild("GlowJaw01",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 7.0F, 6.0F, 0.3141592653589793F, 0.0F, 0.0F));

        PartDefinition jawTooth01 = glowJaw01.addOrReplaceChild("JawTooth01",
                CubeListBuilder.create().texOffs(78, 48)
                        .addBox(-6.5F, 0.0F, -14.0F, 13.0F, 4.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -0.8F, -0.8F, -0.13962634015954636F, 0.0F, 0.0F));

        jawTooth01.addOrReplaceChild("JawTooth02",
                CubeListBuilder.create().texOffs(54, 46)
                        .addBox(-4.5F, 0.0F, -4.5F, 9.0F, 4.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -13.9F, -0.07504915783575616F,
                        0.7853981633974483F, -0.05235987755982988F));

        PartDefinition glowHead01 = glowNeck.addOrReplaceChild("GlowHead01",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 5.8F, 5.0F));

        PartDefinition headTooth01 = glowHead01.addOrReplaceChild("HeadTooth01",
                CubeListBuilder.create().texOffs(78, 48)
                        .addBox(-6.5F, 0.0F, -6.5F, 13.0F, 4.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 1.9F, -7.5F, -0.13962634015954636F, 0.0F,
                        3.141592653589793F));

        headTooth01.addOrReplaceChild("HeadTooth02",
                CubeListBuilder.create().texOffs(54, 46)
                        .addBox(-4.5F, 0.0F, -4.5F, 9.0F, 4.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -6.4F, -0.07504915783575616F,
                        0.7853981633974483F, -0.05235987755982988F));

        PartDefinition glowWingL01a = glowBodyMain.addOrReplaceChild("GlowWingL01a",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(6.0F, 13.5F, -4.0F, 0.0F, -0.3490658503988659F,
                        0.5235987755982988F));

        PartDefinition glowWingL01b = glowWingL01a.addOrReplaceChild("GlowWingL01b",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(6.5F, -1.5F, -4.0F, -0.08726646259971647F,
                        -0.08726646259971647F, 0.0F));

        glowWingL01b.addOrReplaceChild("WingL01Fire",
                CubeListBuilder.create().texOffs(116, 48)
                        .addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 4.0F),
                PartPose.offset(1.5F, 2.5F, 8.1F));

        PartDefinition glowWingR01a = glowBodyMain.addOrReplaceChild("GlowWingR01a",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(-6.0F, 13.5F, -4.0F, 0.0F, 0.3490658503988659F,
                        -0.5235987755982988F));

        PartDefinition glowWingR01b = glowWingR01a.addOrReplaceChild("GlowWingR01b",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(-6.5F, -1.5F, -4.0F, -0.08726646259971647F,
                        0.08726646259971647F, 0.0F));

        glowWingR01b.addOrReplaceChild("WingR01Fire",
                CubeListBuilder.create().texOffs(116, 48)
                        .addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 4.0F),
                PartPose.offset(-1.5F, 2.5F, 8.1F));

        PartDefinition glowCannonL01 = glowBodyMain.addOrReplaceChild("GlowCannonL01",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(8.0F, -6.0F, 9.0F, -0.5235987755982988F,
                        -0.5235987755982988F, 0.0F));

        glowCannonL01.addOrReplaceChild("CannonL02",
                CubeListBuilder.create().texOffs(0, 9)
                        .addBox(-1.0F, -1.0F, -12.0F, 2.0F, 2.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -3.2F, -7.5F, -0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition glowCannonR01 = glowBodyMain.addOrReplaceChild("GlowCannonR01",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(-8.0F, -6.0F, 9.0F, -0.5235987755982988F,
                        0.5235987755982988F, 0.0F));

        glowCannonR01.addOrReplaceChild("CannonR02",
                CubeListBuilder.create().texOffs(0, 9)
                        .addBox(-1.0F, -1.0F, -12.0F, 2.0F, 2.0F, 12.0F),
                PartPose.offset(0.0F, -3.2F, -7.5F));

        PartDefinition glowCannonM01 = glowBodyMain.addOrReplaceChild("GlowCannonM01",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, -8.5F, 7.0F, -0.8726646259971648F, 0.0F, 0.0F));

        PartDefinition glowCannonM02 = glowCannonM01.addOrReplaceChild("GlowCannonM02",
                CubeListBuilder.create(),
                PartPose.offset(1.3F, -1.7F, -3.5F));

        glowCannonM02.addOrReplaceChild("CannonM03",
                CubeListBuilder.create().texOffs(28, 15)
                        .addBox(0.0F, 0.0F, -6.0F, 1.0F, 1.0F, 6.0F),
                PartPose.offset(-0.5F, -0.7F, -2.0F));

        PartDefinition glowCannonM04 = glowCannonM01.addOrReplaceChild("GlowCannonM04",
                CubeListBuilder.create(),
                PartPose.offset(-1.3F, -1.7F, -3.5F));

        glowCannonM04.addOrReplaceChild("CannonM05",
                CubeListBuilder.create().texOffs(28, 15)
                        .addBox(0.0F, 0.0F, -6.0F, 1.0F, 1.0F, 6.0F),
                PartPose.offset(-0.5F, -0.7F, -2.0F));

        PartDefinition glowBodyMain2 = partdefinition.addOrReplaceChild("GlowBodyMain2",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 8.0F));

        glowBodyMain2.addOrReplaceChild("WingL02",
                CubeListBuilder.create().texOffs(0, 35)
                        .addBox(0.0F, -3.0F, -14.0F, 4.0F, 6.0F, 17.0F),
                PartPose.offsetAndRotation(6.0F, -5.0F, 6.0F, 0.0F, -0.17453292519943295F, 0.0F));

        glowBodyMain2.addOrReplaceChild("WingR02",
                CubeListBuilder.create().mirror().texOffs(0, 35)
                        .addBox(-4.0F, -3.0F, -14.0F, 4.0F, 6.0F, 17.0F),
                PartPose.offsetAndRotation(-6.0F, -5.0F, 6.0F, 0.0F, 0.17453292519943295F, 0.0F));

        glowBodyMain2.addOrReplaceChild("WingL03",
                CubeListBuilder.create().texOffs(30, 40)
                        .addBox(0.0F, 0.0F, -20.0F, 2.0F, 4.0F, 20.0F),
                PartPose.offsetAndRotation(7.5F, -0.5F, 11.0F, 0.20943951023931953F,
                        -0.2617993877991494F, 0.0F));

        glowBodyMain2.addOrReplaceChild("WingR03",
                CubeListBuilder.create().mirror().texOffs(30, 40)
                        .addBox(-2.0F, 0.0F, -20.0F, 2.0F, 4.0F, 20.0F),
                PartPose.offsetAndRotation(-7.5F, -0.5F, 11.0F, 0.20943951023931953F,
                        0.2617993877991494F, 0.0F));

        glowBodyMain2.addOrReplaceChild("WingL04",
                CubeListBuilder.create().texOffs(0, 47)
                        .addBox(0.0F, 0.0F, -10.0F, 2.0F, 5.0F, 12.0F),
                PartPose.offsetAndRotation(8.0F, 6.0F, 9.0F, 0.20943951023931953F,
                        -0.3490658503988659F, 0.17453292519943295F));

        glowBodyMain2.addOrReplaceChild("WingR04",
                CubeListBuilder.create().mirror().texOffs(0, 47)
                        .addBox(-2.0F, 0.0F, -10.0F, 2.0F, 5.0F, 12.0F),
                PartPose.offsetAndRotation(-8.0F, 6.0F, 9.0F, 0.20943951023931953F,
                        0.3490658503988659F, -0.17453292519943295F));

        PartDefinition glowWingL01a2 = glowBodyMain2.addOrReplaceChild("GlowWingL01a2",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(6.0F, 13.5F, -4.0F, 0.0F, -0.3490658503988659F,
                        0.5235987755982988F));

        PartDefinition wingL01b2 = glowWingL01a2.addOrReplaceChild("WingL01b",
                CubeListBuilder.create().texOffs(25, 39)
                        .addBox(0.0F, 0.0F, 0.0F, 3.0F, 5.0F, 8.0F),
                PartPose.offsetAndRotation(6.5F, -1.5F, -4.0F, -0.08726646259971647F,
                        -0.08726646259971647F, 0.0F));

        wingL01b2.addOrReplaceChild("WingL01c",
                CubeListBuilder.create().texOffs(0, 53)
                        .addBox(-3.0F, 0.0F, -6.0F, 3.0F, 5.0F, 6.0F),
                PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, 0.5235987755982988F, 0.0F));

        PartDefinition glowWingR01a2 = glowBodyMain2.addOrReplaceChild("GlowWingR01a2",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(-6.0F, 13.5F, -4.0F, 0.0F, 0.3490658503988659F,
                        -0.5235987755982988F));

        PartDefinition wingR01b = glowWingR01a2.addOrReplaceChild("WingR01b",
                CubeListBuilder.create().mirror().texOffs(25, 39)
                        .addBox(-3.0F, 0.0F, 0.0F, 3.0F, 5.0F, 8.0F),
                PartPose.offsetAndRotation(-6.5F, -1.5F, -4.0F, -0.08726646259971647F,
                        0.08726646259971647F, 0.0F));

        wingR01b.addOrReplaceChild("WingR01c",
                CubeListBuilder.create().mirror().texOffs(0, 53)
                        .addBox(0.0F, 0.0F, -6.0F, 3.0F, 5.0F, 6.0F),
                PartPose.offsetAndRotation(-3.0F, 0.0F, 0.0F, 0.0F, -0.5235987755982988F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
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
        poseStack.translate(offsetX, offsetY, offsetZ);
        this.BodyMain.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.GlowBodyMain.render(poseStack, buffer, 0xF000F0, packedOverlay, red, green, blue, alpha);
        this.GlowBodyMain2.render(poseStack, buffer, 0xF000F0, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();
    }

    @Override
    public void showEquip(IShipEmotion ent) {
    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowJaw01.xRot = this.Jaw01.xRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        float angleX = Mth.cos(f2 * 0.08F);

        // water floating
        if (ent.getShipDepth(0) > 0D) {
            this.offsetY += angleX * 0.025F + 0.025F;
        }

        // jaw
        // [PORT] Restored from 1.10.2 GlStateManager.translate
        this.offsetY += angleX * 0.025F + 0.025F;
        this.Jaw01.xRot = angleX * 0.025F + 0.32F;
        // cannon
        this.CannonL02.xRot = angleX * 0.05F - 0.3F;
        this.CannonR02.xRot = -angleX * 0.05F;
        this.CannonM03.xRot = -angleX * 0.05F;
        this.CannonM05.xRot = angleX * 0.05F;

        // seat2 - rider animation
        if (ent.getStateEmotion(ID.S.Emotion) > 0) {
            this.Jaw01.xRot = 0.7F;
        }

        // show thruster fire when moving
        if (f1 > 0.2F) {
            this.WingL01Fire.visible = true;
            this.WingR01Fire.visible = true;
        } else {
            this.WingL01Fire.visible = false;
            this.WingR01Fire.visible = false;
        }
    }
}
