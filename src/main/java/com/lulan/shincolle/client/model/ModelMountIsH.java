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

public class ModelMountIsH extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "mount_ish"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Neck;
    private final ModelPart Cannon01a;
    private final ModelPart Cannon01b;
    private final ModelPart Body01;
    private final ModelPart Body04;
    private final ModelPart Body05;
    private final ModelPart LegFL01;
    private final ModelPart LegFR01;
    private final ModelPart Head;
    private final ModelPart Jaw;
    private final ModelPart NeckFront;
    private final ModelPart HeadTooth;
    private final ModelPart HeadCannon;
    private final ModelPart TopCannonBase;
    private final ModelPart TopCannon01a;
    private final ModelPart TopCannon01b;
    private final ModelPart TopCannonBase02;
    private final ModelPart TopCannon02a;
    private final ModelPart TopCannon03a;
    private final ModelPart TopCannon04a;
    private final ModelPart TopCannon02b;
    private final ModelPart TopCannon03b;
    private final ModelPart TopCannon04b;
    private final ModelPart JawTooth;
    private final ModelPart Tongue01;
    private final ModelPart Tongue02;
    private final ModelPart Tongue03;
    private final ModelPart Cannon02a;
    private final ModelPart Cannon03a;
    private final ModelPart Cannon02b;
    private final ModelPart Cannon03b;
    private final ModelPart Body02;
    private final ModelPart Body03;
    private final ModelPart LegBR01;
    private final ModelPart LegBL01;
    private final ModelPart LegBR02;
    private final ModelPart LegBR03;
    private final ModelPart LegFR02;
    private final ModelPart LegFR03;
    private final ModelPart LegFL02;
    private final ModelPart LegFL03;
    private final ModelPart LegBL02;
    private final ModelPart LegBL03;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowNeck;
    private final ModelPart GlowHead;
    private final ModelPart GlowJaw;
    private final ModelPart GlowTopCannonBase;

    public ModelMountIsH(ModelPart root) {
        super();
        this.BodyMain = root.getChild("BodyMain");
        this.Body04 = this.BodyMain.getChild("Body04");
        this.Body01 = this.BodyMain.getChild("Body01");
        this.LegFL01 = this.BodyMain.getChild("LegFL01");
        this.LegFR01 = this.BodyMain.getChild("LegFR01");
        this.Body05 = this.BodyMain.getChild("Body05");
        this.Neck = this.BodyMain.getChild("Neck");
        this.Body02 = this.Body01.getChild("Body02");
        this.LegFL02 = this.LegFL01.getChild("LegFL02");
        this.LegBL02 = this.LegFR01.getChild("LegBL02");
        this.LegBR01 = this.Body05.getChild("LegBR01");
        this.LegBL01 = this.Body05.getChild("LegBL01");
        this.Jaw = this.Neck.getChild("Jaw");
        this.Head = this.Neck.getChild("Head");
        this.Body03 = this.Body02.getChild("Body03");
        this.LegFL03 = this.LegFL02.getChild("LegFL03");
        this.LegBL03 = this.LegBL02.getChild("LegBL03");
        this.LegBR02 = this.LegBR01.getChild("LegBR02");
        this.LegFR02 = this.LegBL01.getChild("LegFR02");
        this.TopCannonBase = this.Head.getChild("TopCannonBase");
        this.LegBR03 = this.LegBR02.getChild("LegBR03");
        this.LegFR03 = this.LegFR02.getChild("LegFR03");
        this.TopCannonBase02 = this.TopCannonBase.getChild("TopCannonBase02");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowNeck = this.GlowBodyMain.getChild("GlowNeck");
        this.GlowHead = this.GlowNeck.getChild("GlowHead");
        this.GlowJaw = this.GlowNeck.getChild("GlowJaw");
        this.GlowTopCannonBase = this.GlowHead.getChild("GlowTopCannonBase");

        // Glow children: cannons on body
        this.Cannon01a = this.GlowBodyMain.getChild("Cannon01a");
        this.Cannon02a = this.Cannon01a.getChild("Cannon02a");
        this.Cannon03a = this.Cannon02a.getChild("Cannon03a");
        this.Cannon01b = this.GlowBodyMain.getChild("Cannon01b");
        this.Cannon02b = this.Cannon01b.getChild("Cannon02b");
        this.Cannon03b = this.Cannon02b.getChild("Cannon03b");

        // Glow children: neck/head parts
        this.NeckFront = this.GlowNeck.getChild("NeckFront");
        this.HeadTooth = this.GlowHead.getChild("HeadTooth");
        this.HeadCannon = this.GlowHead.getChild("HeadCannon");

        // Glow children: top cannon tree
        this.TopCannon01a = this.GlowTopCannonBase.getChild("TopCannon01a");
        this.TopCannon02a = this.TopCannon01a.getChild("TopCannon02a");
        this.TopCannon03a = this.TopCannon01a.getChild("TopCannon03a");
        this.TopCannon04a = this.TopCannon03a.getChild("TopCannon04a");
        this.TopCannon01b = this.GlowTopCannonBase.getChild("TopCannon01b");
        this.TopCannon02b = this.TopCannon01b.getChild("TopCannon02b");
        this.TopCannon03b = this.TopCannon01b.getChild("TopCannon03b");
        this.TopCannon04b = this.TopCannon03b.getChild("TopCannon04b");

        // Glow children: jaw parts
        this.JawTooth = this.GlowJaw.getChild("JawTooth");
        this.Tongue01 = this.GlowJaw.getChild("Tongue01");
        this.Tongue02 = this.Tongue01.getChild("Tongue02");
        this.Tongue03 = this.Tongue02.getChild("Tongue03");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offset(0.0F, -8.0F, 5.0F));

        bodyMain.addOrReplaceChild("Body04",
                CubeListBuilder.create().texOffs(7, 0)
                        .addBox(-7.5F, -6.0F, 0.0F, 15.0F, 15.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 3.0F, -3.0F, -0.3490658503988659F, 0.0F, 0.0F));

        PartDefinition body01 = bodyMain.addOrReplaceChild("Body01",
                CubeListBuilder.create().texOffs(12, 0)
                        .addBox(-8.5F, -12.0F, -6.0F, 17.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, -1.0F, -0.5F, -0.17453292519943295F, 0.0F, 0.0F));

        PartDefinition body02 = body01.addOrReplaceChild("Body02",
                CubeListBuilder.create().texOffs(6, 3)
                        .addBox(-8.0F, -12.0F, -6.0F, 16.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 2.0F, 7.0F, -0.2617993877991494F, 0.0F, 0.0F));

        body02.addOrReplaceChild("Body03",
                CubeListBuilder.create().texOffs(18, 0)
                        .addBox(-7.5F, -12.0F, -6.0F, 15.0F, 12.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 0.5F, 10.0F, 0.3490658503988659F, 0.0F, 0.0F));

        PartDefinition legFL01 = bodyMain.addOrReplaceChild("LegFL01",
                CubeListBuilder.create().texOffs(34, 7)
                        .addBox(0.0F, -4.5F, -9.0F, 3.0F, 9.0F, 12.0F),
                PartPose.offsetAndRotation(9.0F, 13.0F, -19.0F, 0.8726646259971648F,
                        -0.13962634015954636F, 0.05235987755982988F));

        PartDefinition legFL02 = legFL01.addOrReplaceChild("LegFL02",
                CubeListBuilder.create().texOffs(3, 5)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(1.6F, -2.0F, -8.5F, -0.2617993877991494F, 0.0F, 0.0F));

        legFL02.addOrReplaceChild("LegFL03",
                CubeListBuilder.create().texOffs(9, 0)
                        .addBox(-0.5F, -6.0F, 0.0F, 1.0F, 11.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 10.2F, 1.0F, -1.0471975511965976F, 0.0F, 0.0F));

        PartDefinition legFR01 = bodyMain.addOrReplaceChild("LegFR01",
                CubeListBuilder.create().mirror().texOffs(0, 11)
                        .addBox(-3.0F, -4.5F, -9.0F, 3.0F, 9.0F, 12.0F),
                PartPose.offsetAndRotation(-9.0F, 13.0F, -19.0F, 0.8726646259971648F,
                        0.13962634015954636F, -0.05235987755982988F));

        PartDefinition legBL02 = legFR01.addOrReplaceChild("LegBL02",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(-1.6F, -2.0F, -8.5F, -0.2617993877991494F, 0.0F, 0.0F));

        legBL02.addOrReplaceChild("LegBL03",
                CubeListBuilder.create().mirror().texOffs(8, 0)
                        .addBox(-0.5F, -6.0F, 0.0F, 1.0F, 11.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 10.2F, 1.0F, -1.0471975511965976F, 0.0F, 0.0F));

        PartDefinition body05 = bodyMain.addOrReplaceChild("Body05",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-6.5F, -6.0F, 0.0F, 13.0F, 12.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 9.4F, 4.5F, 0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition legBR01 = body05.addOrReplaceChild("LegBR01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, -4.5F, -9.0F, 3.0F, 9.0F, 12.0F),
                PartPose.offsetAndRotation(-6.0F, 4.0F, 5.0F, 1.0471975511965976F, 3.001966313430247F,
                        -0.05235987755982988F));

        PartDefinition legBR02 = legBR01.addOrReplaceChild("LegBR02",
                CubeListBuilder.create().texOffs(0, 17)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(1.6F, -2.0F, -8.5F, -0.2617993877991494F, 0.0F, 0.0F));

        legBR02.addOrReplaceChild("LegBR03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-0.5F, -6.0F, 0.0F, 1.0F, 11.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 10.2F, 1.0F, -1.0471975511965976F, 0.0F, 0.0F));

        PartDefinition legBL01 = body05.addOrReplaceChild("LegBL01",
                CubeListBuilder.create().mirror().texOffs(5, 0)
                        .addBox(-3.0F, -4.5F, -9.0F, 3.0F, 9.0F, 12.0F),
                PartPose.offsetAndRotation(6.0F, 4.0F, 5.0F, 1.0471975511965976F, -3.001966313430247F,
                        0.05235987755982988F));

        PartDefinition legFR02 = legBL01.addOrReplaceChild("LegFR02",
                CubeListBuilder.create().mirror().texOffs(0, 0)
                        .addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F),
                PartPose.offsetAndRotation(-1.6F, -2.0F, -8.5F, -0.2617993877991494F, 0.0F, 0.0F));

        legFR02.addOrReplaceChild("LegFR03",
                CubeListBuilder.create().mirror().texOffs(19, 0)
                        .addBox(-0.5F, -6.0F, 0.0F, 1.0F, 11.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 10.2F, 1.0F, -1.0471975511965976F, 0.0F, 0.0F));

        PartDefinition neck = bodyMain.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-7.5F, -7.5F, -14.0F, 15.0F, 15.0F, 14.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.18203784098300857F, 0.0F, 0.0F));

        neck.addOrReplaceChild("Jaw",
                CubeListBuilder.create().texOffs(7, 0)
                        .addBox(-9.5F, 0.0F, -15.0F, 19.0F, 7.0F, 19.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, -11.0F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(0, 3)
                        .addBox(-9.5F, -7.0F, -22.0F, 19.0F, 10.0F, 24.0F),
                PartPose.offsetAndRotation(0.0F, -9.0F, -4.0F, -0.20943951023931953F, 0.0F, 0.0F));

        PartDefinition topCannonBase = head.addOrReplaceChild("TopCannonBase",
                CubeListBuilder.create().texOffs(3, 0)
                        .addBox(-7.5F, -8.0F, -8.0F, 15.0F, 8.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, -6.0F, -5.0F, -0.08726646259971647F, 0.0F, 0.0F));

        topCannonBase.addOrReplaceChild("TopCannonBase02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-5.0F, -6.0F, 0.0F, 10.0F, 6.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, -0.5F, -0.7F, -0.08726646259971647F, 0.0F, 0.0F));

        // ---- Glow tree (rendered with full bright 0xF000F0 light) ----
        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -8.0F, 5.0F));

        // Cannon01a -> Cannon02a -> Cannon03a (children of GlowBodyMain)
        PartDefinition cannon01a = glowBodyMain.addOrReplaceChild("Cannon01a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, -2.5F, -2.5F, 7.0F, 5.0F, 5.0F),
                PartPose.offset(7.0F, 2.0F, -10.0F));

        PartDefinition cannon02a = cannon01a.addOrReplaceChild("Cannon02a",
                CubeListBuilder.create().texOffs(65, 0)
                        .addBox(0.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F),
                PartPose.offsetAndRotation(3.0F, -0.5F, 2.0F, 0.20943951023931953F,
                        -0.17453292519943295F, 0.0F));

        cannon02a.addOrReplaceChild("Cannon03a",
                CubeListBuilder.create().texOffs(98, 0)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F),
                PartPose.offsetAndRotation(4.0F, 0.0F, -7.0F, -1.7453292519943295F, 0.0F, 0.0F));

        // Cannon01b -> Cannon02b -> Cannon03b (children of GlowBodyMain)
        PartDefinition cannon01b = glowBodyMain.addOrReplaceChild("Cannon01b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-7.0F, -2.5F, -2.5F, 7.0F, 5.0F, 5.0F),
                PartPose.offset(-7.0F, 2.0F, -10.0F));

        PartDefinition cannon02b = cannon01b.addOrReplaceChild("Cannon02b",
                CubeListBuilder.create().mirror().texOffs(65, 0)
                        .addBox(-8.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F),
                PartPose.offsetAndRotation(-3.0F, -0.5F, 2.0F, 0.20943951023931953F,
                        0.17453292519943295F, 0.0F));

        cannon02b.addOrReplaceChild("Cannon03b",
                CubeListBuilder.create().texOffs(98, 0)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F),
                PartPose.offsetAndRotation(-4.0F, 0.0F, -7.0F, -1.7453292519943295F, 0.0F, 0.0F));

        PartDefinition glowNeck = glowBodyMain.addOrReplaceChild("GlowNeck",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.18203784098300857F, 0.0F, 0.0F));

        // NeckFront (child of GlowNeck)
        glowNeck.addOrReplaceChild("NeckFront",
                CubeListBuilder.create().texOffs(46, 39)
                        .addBox(-6.5F, 0.0F, 0.0F, 13.0F, 14.0F, 2.0F),
                PartPose.offset(0.0F, -8.5F, -16.0F));

        PartDefinition glowHead = glowNeck.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, -9.0F, -4.0F, -0.20943951023931953F, 0.0F, 0.0F));

        // HeadTooth (child of GlowHead)
        glowHead.addOrReplaceChild("HeadTooth",
                CubeListBuilder.create().texOffs(62, 45)
                        .addBox(-9.0F, 0.0F, -6.5F, 18.0F, 4.0F, 15.0F),
                PartPose.offsetAndRotation(0.0F, 2.5F, -15.0F, 0.05235987755982988F, 0.0F, 0.0F));

        // HeadCannon (child of GlowHead)
        glowHead.addOrReplaceChild("HeadCannon",
                CubeListBuilder.create().texOffs(107, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 16.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, -2.9F, -21.0F, -1.6580627893946132F, 0.0F, 0.0F));

        PartDefinition glowTopCannonBase = glowHead.addOrReplaceChild("GlowTopCannonBase",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, -6.0F, -5.0F, -0.08726646259971647F, 0.0F, 0.0F));

        // TopCannon01a -> TopCannon02a, TopCannon03a -> TopCannon04a
        PartDefinition topCannon01a = glowTopCannonBase.addOrReplaceChild("TopCannon01a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, -1.5F, -6.0F, 3.0F, 4.0F, 6.0F),
                PartPose.offsetAndRotation(3.2F, -4.0F, -6.7F, -0.3490658503988659F, 0.0F, 0.0F));

        topCannon01a.addOrReplaceChild("TopCannon02a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 3.0F, 7.0F),
                PartPose.offset(0.0F, 0.8F, -7.0F));

        PartDefinition topCannon03a = topCannon01a.addOrReplaceChild("TopCannon03a",
                CubeListBuilder.create().texOffs(120, 0)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 18.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -5.9F, -1.5707963267948966F, 0.0F, 0.0F));

        topCannon03a.addOrReplaceChild("TopCannon04a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F),
                PartPose.offset(0.0F, 4.0F, 0.0F));

        // TopCannon01b -> TopCannon02b, TopCannon03b -> TopCannon04b
        PartDefinition topCannon01b = glowTopCannonBase.addOrReplaceChild("TopCannon01b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, -1.5F, -6.0F, 3.0F, 4.0F, 6.0F),
                PartPose.offsetAndRotation(-3.2F, -4.0F, -6.7F, -0.3490658503988659F, 0.0F, 0.0F));

        topCannon01b.addOrReplaceChild("TopCannon02b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-0.5F, 0.0F, 0.0F, 1.0F, 3.0F, 7.0F),
                PartPose.offset(0.0F, 0.8F, -7.0F));

        PartDefinition topCannon03b = topCannon01b.addOrReplaceChild("TopCannon03b",
                CubeListBuilder.create().texOffs(120, 0)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 18.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -5.9F, -1.5707963267948966F, 0.0F, 0.0F));

        topCannon03b.addOrReplaceChild("TopCannon04b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F),
                PartPose.offset(0.0F, 4.0F, 0.0F));

        PartDefinition glowJaw = glowNeck.addOrReplaceChild("GlowJaw",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 4.0F, -11.0F, 0.2617993877991494F, 0.0F, 0.0F));

        // JawTooth (child of GlowJaw)
        glowJaw.addOrReplaceChild("JawTooth",
                CubeListBuilder.create().texOffs(63, 46)
                        .addBox(-9.0F, 0.0F, -14.0F, 18.0F, 3.0F, 14.0F),
                PartPose.offsetAndRotation(0.0F, -1.7F, -0.3F, -0.08726646259971647F,
                        -0.02234021442552742F, 0.0F));

        // Tongue01 -> Tongue02 -> Tongue03 (children of GlowJaw)
        PartDefinition tongue01 = glowJaw.addOrReplaceChild("Tongue01",
                CubeListBuilder.create().mirror().texOffs(0, 50)
                        .addBox(-7.0F, 0.0F, -10.0F, 14.0F, 4.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.3839724354387525F, 0.3490658503988659F,
                        -0.05235987755982988F));

        PartDefinition tongue02 = tongue01.addOrReplaceChild("Tongue02",
                CubeListBuilder.create().texOffs(8, 52)
                        .addBox(-6.0F, -0.7F, -7.0F, 12.0F, 3.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 1.0F, -10.0F, 0.5235987755982988F, 0.0F, 0.0F));

        tongue02.addOrReplaceChild("Tongue03",
                CubeListBuilder.create().texOffs(0, 51)
                        .addBox(-5.0F, -0.3F, -6.0F, 10.0F, 2.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, -0.2F, -6.7F, 0.6981317007977318F, 0.0F, 0.0F));

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
        this.GlowJaw.xRot = this.Jaw.xRot;
        this.GlowTopCannonBase.yRot = this.TopCannonBase.yRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
    }
}
