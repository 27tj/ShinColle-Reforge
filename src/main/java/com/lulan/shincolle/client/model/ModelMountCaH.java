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

public class ModelMountCaH extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "mount_cah"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Neck;
    private final ModelPart Seat01;
    private final ModelPart Back01;
    private final ModelPart Back02;
    private final ModelPart Back03;
    private final ModelPart Back04;
    private final ModelPart WingL02;
    private final ModelPart WingR02;
    private final ModelPart CannonL01;
    private final ModelPart CannonR01;
    private final ModelPart Tube01a;
    private final ModelPart Tube02a;
    private final ModelPart Cannon01a;
    private final ModelPart Cannon01a_1;
    private final ModelPart Cannon01a_2;
    private final ModelPart Cannon01a_3;
    private final ModelPart Cannon01a_4;
    private final ModelPart Cannon01a_5;
    private final ModelPart Cannon01a_6;
    private final ModelPart Cannon01a_7;
    private final ModelPart Tube01a_1;
    private final ModelPart Tube01a_2;
    private final ModelPart Head01;
    private final ModelPart Jaw01;
    private final ModelPart Head02;
    private final ModelPart HeadTooth01;
    private final ModelPart HeadTooth02;
    private final ModelPart Jaw02;
    private final ModelPart JawTooth01;
    private final ModelPart JawTooth02;
    private final ModelPart CannonL02;
    private final ModelPart CannonR02;
    private final ModelPart Tube01b;
    private final ModelPart Tube02b;
    private final ModelPart Cannon01b;
    private final ModelPart Cannon01c;
    private final ModelPart Cannon01b_1;
    private final ModelPart Cannon01c_1;
    private final ModelPart Cannon01b_2;
    private final ModelPart Cannon01c_2;
    private final ModelPart Cannon01b_3;
    private final ModelPart Cannon01c_3;
    private final ModelPart Cannon01b_4;
    private final ModelPart Cannon01c_4;
    private final ModelPart Cannon01b_5;
    private final ModelPart Cannon01c_5;
    private final ModelPart Cannon01b_6;
    private final ModelPart Cannon01c_6;
    private final ModelPart Cannon01b_7;
    private final ModelPart Cannon01c_7;
    private final ModelPart Tube01b_1;
    private final ModelPart Tube01b_2;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowBodyMain2;
    private final ModelPart GlowNeck;
    private final ModelPart GlowJaw01;
    private final ModelPart GlowHead01;
    private final ModelPart GlowCannonL01;
    private final ModelPart GlowCannonR01;

    public ModelMountCaH(ModelPart root) {
        super();
        this.BodyMain = root.getChild("BodyMain");
        this.Back02 = this.BodyMain.getChild("Back02");
        this.Cannon01a_7 = this.BodyMain.getChild("Cannon01a_7");
        this.Seat01 = this.BodyMain.getChild("Seat01");
        this.Cannon01a = this.BodyMain.getChild("Cannon01a");
        this.Tube02a = this.BodyMain.getChild("Tube02a");
        this.Cannon01a_6 = this.BodyMain.getChild("Cannon01a_6");
        this.CannonR01 = this.BodyMain.getChild("CannonR01");
        this.Cannon01a_1 = this.BodyMain.getChild("Cannon01a_1");
        this.Cannon01a_5 = this.BodyMain.getChild("Cannon01a_5");
        this.CannonL01 = this.BodyMain.getChild("CannonL01");
        this.Cannon01a_4 = this.BodyMain.getChild("Cannon01a_4");
        this.Tube01a_1 = this.BodyMain.getChild("Tube01a_1");
        this.Neck = this.BodyMain.getChild("Neck");
        this.Cannon01a_3 = this.BodyMain.getChild("Cannon01a_3");
        this.Back01 = this.BodyMain.getChild("Back01");
        this.Back04 = this.BodyMain.getChild("Back04");
        this.Cannon01a_2 = this.BodyMain.getChild("Cannon01a_2");
        this.Tube01a_2 = this.BodyMain.getChild("Tube01a_2");
        this.Back03 = this.BodyMain.getChild("Back03");
        this.Tube01a = this.BodyMain.getChild("Tube01a");
        this.Cannon01b_7 = this.Cannon01a_7.getChild("Cannon01b_7");
        this.Cannon01b = this.Cannon01a.getChild("Cannon01b");
        this.Tube02b = this.Tube02a.getChild("Tube02b");
        this.Cannon01b_6 = this.Cannon01a_6.getChild("Cannon01b_6");
        this.Cannon01b_1 = this.Cannon01a_1.getChild("Cannon01b_1");
        this.Cannon01b_5 = this.Cannon01a_5.getChild("Cannon01b_5");
        this.Cannon01b_4 = this.Cannon01a_4.getChild("Cannon01b_4");
        this.Tube01b_1 = this.Tube01a_1.getChild("Tube01b_1");
        this.Head01 = this.Neck.getChild("Head01");
        this.Jaw01 = this.Neck.getChild("Jaw01");
        this.Cannon01b_3 = this.Cannon01a_3.getChild("Cannon01b_3");
        this.Cannon01b_2 = this.Cannon01a_2.getChild("Cannon01b_2");
        this.Tube01b_2 = this.Tube01a_2.getChild("Tube01b_2");
        this.Tube01b = this.Tube01a.getChild("Tube01b");
        this.Cannon01c_7 = this.Cannon01b_7.getChild("Cannon01c_7");
        this.Cannon01c = this.Cannon01b.getChild("Cannon01c");
        this.Cannon01c_6 = this.Cannon01b_6.getChild("Cannon01c_6");
        this.Cannon01c_1 = this.Cannon01b_1.getChild("Cannon01c_1");
        this.Cannon01c_5 = this.Cannon01b_5.getChild("Cannon01c_5");
        this.Cannon01c_4 = this.Cannon01b_4.getChild("Cannon01c_4");
        this.Head02 = this.Head01.getChild("Head02");
        this.Jaw02 = this.Jaw01.getChild("Jaw02");
        this.Cannon01c_3 = this.Cannon01b_3.getChild("Cannon01c_3");
        this.Cannon01c_2 = this.Cannon01b_2.getChild("Cannon01c_2");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowBodyMain2 = root.getChild("GlowBodyMain2");
        this.GlowNeck = this.GlowBodyMain.getChild("GlowNeck");
        this.GlowCannonL01 = this.GlowBodyMain.getChild("GlowCannonL01");
        this.GlowCannonR01 = this.GlowBodyMain.getChild("GlowCannonR01");
        this.GlowJaw01 = this.GlowNeck.getChild("GlowJaw01");
        this.GlowHead01 = this.GlowNeck.getChild("GlowHead01");

        this.JawTooth01 = this.GlowJaw01.getChild("JawTooth01");
        this.JawTooth02 = this.JawTooth01.getChild("JawTooth02");
        this.HeadTooth01 = this.GlowHead01.getChild("HeadTooth01");
        this.HeadTooth02 = this.HeadTooth01.getChild("HeadTooth02");
        this.CannonL02 = this.GlowCannonL01.getChild("CannonL02");
        this.CannonR02 = this.GlowCannonR01.getChild("CannonR02");
        this.WingL02 = this.GlowBodyMain2.getChild("WingL02");
        this.WingR02 = this.GlowBodyMain2.getChild("WingR02");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-6.5F, 0.0F, 0.0F, 13.0F, 12.0F, 8.0F),
                PartPose.offset(0.0F, 0.0F, 8.0F));

        bodyMain.addOrReplaceChild("Back02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-5.0F, 0.0F, 0.0F, 10.0F, 14.0F, 4.0F),
                PartPose.offset(0.0F, -7.0F, 6.0F));

        PartDefinition cannon01a_7 = bodyMain.addOrReplaceChild("Cannon01a_7",
                CubeListBuilder.create().texOffs(20, 8)
                        .addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F),
                PartPose.offsetAndRotation(-12.5F, 7.5F, 5.0F, -0.17453292519943295F,
                        0.5235987755982988F, 0.0F));

        PartDefinition cannon01b_7 = cannon01a_7.addOrReplaceChild("Cannon01b_7",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F),
                PartPose.offset(0.0F, 0.0F, -1.8F));

        cannon01b_7.addOrReplaceChild("Cannon01c_7",
                CubeListBuilder.create().texOffs(16, 12)
                        .addBox(-0.5F, -0.5F, -7.0F, 1.0F, 1.0F, 7.0F),
                PartPose.offset(0.0F, 0.0F, -4.0F));

        bodyMain.addOrReplaceChild("Seat01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, -10.5F, 0.3F, -0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition cannon01a = bodyMain.addOrReplaceChild("Cannon01a",
                CubeListBuilder.create().texOffs(19, 0)
                        .addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F),
                PartPose.offsetAndRotation(8.0F, 12.0F, 4.0F, 0.20943951023931953F,
                        -0.2617993877991494F, 0.0F));

        PartDefinition cannon01b = cannon01a.addOrReplaceChild("Cannon01b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F),
                PartPose.offset(0.0F, 0.0F, -1.8F));

        cannon01b.addOrReplaceChild("Cannon01c",
                CubeListBuilder.create().texOffs(4, 8)
                        .addBox(-0.5F, -0.5F, -7.0F, 1.0F, 1.0F, 7.0F),
                PartPose.offset(0.0F, 0.0F, -4.0F));

        PartDefinition tube02a = bodyMain.addOrReplaceChild("Tube02a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -7.0F, -1.0F, 1.0F, 7.0F, 1.0F),
                PartPose.offsetAndRotation(-3.0F, 2.0F, 9.0F, -0.7853981633974483F,
                        -0.13962634015954636F, -0.2617993877991494F));

        tube02a.addOrReplaceChild("Tube02b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -7.0F, -1.0F, 1.0F, 7.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 1.3962634015954636F, 0.0F, 0.0F));

        PartDefinition cannon01a_6 = bodyMain.addOrReplaceChild("Cannon01a_6",
                CubeListBuilder.create().texOffs(20, 8)
                        .addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F),
                PartPose.offsetAndRotation(-9.0F, 8.0F, 4.0F, -0.13962634015954636F,
                        0.2617993877991494F, 0.0F));

        PartDefinition cannon01b_6 = cannon01a_6.addOrReplaceChild("Cannon01b_6",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F),
                PartPose.offset(0.0F, 0.0F, -1.8F));

        cannon01b_6.addOrReplaceChild("Cannon01c_6",
                CubeListBuilder.create().texOffs(28, 12)
                        .addBox(-0.5F, -0.5F, -7.0F, 1.0F, 1.0F, 7.0F),
                PartPose.offset(0.0F, 0.0F, -4.0F));

        bodyMain.addOrReplaceChild("CannonR01",
                CubeListBuilder.create().texOffs(9, 0)
                        .addBox(-3.5F, -5.0F, -8.0F, 7.0F, 5.0F, 8.0F),
                PartPose.offsetAndRotation(-4.0F, -6.0F, 9.0F, -0.6981317007977318F,
                        0.10471975511965977F, 0.0F));

        PartDefinition cannon01a_1 = bodyMain.addOrReplaceChild("Cannon01a_1",
                CubeListBuilder.create().texOffs(20, 8)
                        .addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F),
                PartPose.offsetAndRotation(12.0F, 11.0F, 5.0F, 0.13962634015954636F,
                        -0.41887902047863906F, 0.0F));

        PartDefinition cannon01b_1 = cannon01a_1.addOrReplaceChild("Cannon01b_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F),
                PartPose.offset(0.0F, 0.0F, -1.8F));

        cannon01b_1.addOrReplaceChild("Cannon01c_1",
                CubeListBuilder.create().texOffs(20, 12)
                        .addBox(-0.5F, -0.5F, -7.0F, 1.0F, 1.0F, 7.0F),
                PartPose.offset(0.0F, 0.0F, -4.0F));

        PartDefinition cannon01a_5 = bodyMain.addOrReplaceChild("Cannon01a_5",
                CubeListBuilder.create().texOffs(20, 8)
                        .addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F),
                PartPose.offsetAndRotation(-12.0F, 11.0F, 5.0F, 0.20943951023931953F,
                        0.3141592653589793F, 0.0F));

        PartDefinition cannon01b_5 = cannon01a_5.addOrReplaceChild("Cannon01b_5",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F),
                PartPose.offset(0.0F, 0.0F, -1.8F));

        cannon01b_5.addOrReplaceChild("Cannon01c_5",
                CubeListBuilder.create().texOffs(12, 12)
                        .addBox(-0.5F, -0.5F, -7.0F, 1.0F, 1.0F, 7.0F),
                PartPose.offset(0.0F, 0.0F, -4.0F));

        bodyMain.addOrReplaceChild("CannonL01",
                CubeListBuilder.create().texOffs(9, 0)
                        .addBox(-3.5F, -5.0F, -8.0F, 7.0F, 5.0F, 8.0F),
                PartPose.offsetAndRotation(4.0F, -6.0F, 9.0F, -0.6981317007977318F,
                        -0.10471975511965977F, 0.0F));

        PartDefinition cannon01a_4 = bodyMain.addOrReplaceChild("Cannon01a_4",
                CubeListBuilder.create().texOffs(20, 8)
                        .addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F),
                PartPose.offsetAndRotation(-8.0F, 12.0F, 4.0F, 0.20943951023931953F,
                        0.20943951023931953F, 0.0F));

        PartDefinition cannon01b_4 = cannon01a_4.addOrReplaceChild("Cannon01b_4",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F),
                PartPose.offset(0.0F, 0.0F, -1.8F));

        cannon01b_4.addOrReplaceChild("Cannon01c_4",
                CubeListBuilder.create().texOffs(32, 12)
                        .addBox(-0.5F, -0.5F, -7.0F, 1.0F, 1.0F, 7.0F),
                PartPose.offset(0.0F, 0.0F, -4.0F));

        PartDefinition tube01a_1 = bodyMain.addOrReplaceChild("Tube01a_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, -7.0F, 0.0F, 1.0F, 7.0F, 1.0F),
                PartPose.offsetAndRotation(11.0F, 8.0F, 7.0F, -0.6981317007977318F, 0.0F,
                        -0.3490658503988659F));

        tube01a_1.addOrReplaceChild("Tube01b_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, -7.0F, -1.0F, 1.0F, 7.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, 1.0F, 1.3962634015954636F, 0.0F, 0.0F));

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

        PartDefinition cannon01a_3 = bodyMain.addOrReplaceChild("Cannon01a_3",
                CubeListBuilder.create().texOffs(20, 8)
                        .addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F),
                PartPose.offsetAndRotation(12.5F, 7.5F, 5.0F, -0.05235987755982988F,
                        -0.5235987755982988F, 0.0F));

        PartDefinition cannon01b_3 = cannon01a_3.addOrReplaceChild("Cannon01b_3",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F),
                PartPose.offset(0.0F, 0.0F, -1.8F));

        cannon01b_3.addOrReplaceChild("Cannon01c_3",
                CubeListBuilder.create().texOffs(24, 12)
                        .addBox(-0.5F, -0.5F, -7.0F, 1.0F, 1.0F, 7.0F),
                PartPose.offset(0.0F, 0.0F, -4.0F));

        bodyMain.addOrReplaceChild("Back01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-6.0F, 0.0F, 0.0F, 12.0F, 9.0F, 5.0F),
                PartPose.offset(0.0F, -9.0F, 1.0F));

        bodyMain.addOrReplaceChild("Back04",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-8.0F, 0.0F, 0.0F, 16.0F, 2.0F, 3.0F),
                PartPose.offset(0.0F, 7.0F, 6.0F));

        PartDefinition cannon01a_2 = bodyMain.addOrReplaceChild("Cannon01a_2",
                CubeListBuilder.create().texOffs(20, 8)
                        .addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F),
                PartPose.offsetAndRotation(9.0F, 8.0F, 4.0F, -0.13962634015954636F,
                        -0.3141592653589793F, 0.0F));

        PartDefinition cannon01b_2 = cannon01a_2.addOrReplaceChild("Cannon01b_2",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F),
                PartPose.offset(0.0F, 0.0F, -1.8F));

        cannon01b_2.addOrReplaceChild("Cannon01c_2",
                CubeListBuilder.create().texOffs(8, 12)
                        .addBox(-0.5F, -0.5F, -7.0F, 1.0F, 1.0F, 7.0F),
                PartPose.offset(0.0F, 0.0F, -4.0F));

        PartDefinition tube01a_2 = bodyMain.addOrReplaceChild("Tube01a_2",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, -7.0F, 0.0F, 1.0F, 7.0F, 1.0F),
                PartPose.offsetAndRotation(-12.0F, 8.0F, 6.7F, -0.6981317007977318F, 0.0F,
                        0.3490658503988659F));

        tube01a_2.addOrReplaceChild("Tube01b_2",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, -7.0F, -1.0F, 1.0F, 7.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, 1.0F, 1.3962634015954636F, 0.0F, 0.0F));

        bodyMain.addOrReplaceChild("Back03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-9.0F, 0.0F, 0.0F, 18.0F, 14.0F, 7.0F),
                PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition tube01a = bodyMain.addOrReplaceChild("Tube01a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, -7.0F, 0.0F, 1.0F, 7.0F, 1.0F),
                PartPose.offsetAndRotation(2.0F, 1.0F, 9.0F, -0.7853981633974483F, 0.8726646259971648F,
                        0.2617993877991494F));

        tube01a.addOrReplaceChild("Tube01b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, -7.0F, -1.0F, 1.0F, 7.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, -7.0F, 1.0F, 1.3962634015954636F, 0.0F, 0.0F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 8.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, -5.0F));

        PartDefinition glowJaw01 = glowNeck.addOrReplaceChild("GlowJaw01",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 7.0F, 6.0F));

        PartDefinition jawTooth01 = glowJaw01.addOrReplaceChild("JawTooth01",
                CubeListBuilder.create().texOffs(24, 24)
                        .addBox(-6.5F, 0.0F, -14.0F, 13.0F, 4.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -0.8F, -0.8F, -0.13962634015954636F, 0.0F, 0.0F));

        jawTooth01.addOrReplaceChild("JawTooth02",
                CubeListBuilder.create().texOffs(0, 23)
                        .addBox(-4.5F, 0.0F, -4.5F, 9.0F, 4.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -13.9F, -0.07504915783575616F,
                        0.7853981633974483F, -0.05235987755982988F));

        PartDefinition glowHead01 = glowNeck.addOrReplaceChild("GlowHead01",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 5.8F, 5.0F));

        PartDefinition headTooth01 = glowHead01.addOrReplaceChild("HeadTooth01",
                CubeListBuilder.create().texOffs(24, 24)
                        .addBox(-6.5F, 0.0F, -6.5F, 13.0F, 4.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 1.9F, -7.5F, -0.13962634015954636F, 0.0F,
                        3.141592653589793F));

        headTooth01.addOrReplaceChild("HeadTooth02",
                CubeListBuilder.create().texOffs(0, 23)
                        .addBox(-4.5F, 0.0F, -4.5F, 9.0F, 4.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -6.4F, -0.07504915783575616F,
                        0.7853981633974483F, -0.05235987755982988F));

        PartDefinition glowCannonL01 = glowBodyMain.addOrReplaceChild("GlowCannonL01",
                CubeListBuilder.create(),
                PartPose.offset(4.0F, -6.0F, 9.0F));

        glowCannonL01.addOrReplaceChild("CannonL02",
                CubeListBuilder.create().texOffs(0, 9)
                        .addBox(-1.0F, -1.0F, -12.0F, 2.0F, 2.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -3.2F, -7.5F, -0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition glowCannonR01 = glowBodyMain.addOrReplaceChild("GlowCannonR01",
                CubeListBuilder.create(),
                PartPose.offset(-4.0F, -6.0F, 9.0F));

        glowCannonR01.addOrReplaceChild("CannonR02",
                CubeListBuilder.create().texOffs(0, 9)
                        .addBox(-1.0F, -1.0F, -12.0F, 2.0F, 2.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -3.2F, -7.5F, -0.13962634015954636F, 0.0F, 0.0F));

        PartDefinition glowBodyMain2 = partdefinition.addOrReplaceChild("GlowBodyMain2",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 8.0F));

        glowBodyMain2.addOrReplaceChild("WingL02",
                CubeListBuilder.create().texOffs(0, 41)
                        .addBox(0.0F, -3.0F, -14.0F, 4.0F, 6.0F, 17.0F),
                PartPose.offsetAndRotation(6.0F, -2.0F, 6.0F, 0.0F, -0.10471975511965977F, 0.0F));

        glowBodyMain2.addOrReplaceChild("WingR02",
                CubeListBuilder.create().texOffs(0, 41).mirror()
                        .addBox(-4.0F, -3.0F, -14.0F, 4.0F, 6.0F, 17.0F),
                PartPose.offsetAndRotation(-6.0F, -2.0F, 6.0F, 0.0F, 0.10471975511965977F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                          float headPitch) {
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
    }
}
