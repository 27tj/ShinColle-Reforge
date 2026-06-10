package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.entity.destroyer.EntityDestroyerAkatsuki;
import com.lulan.shincolle.entity.destroyer.EntityDestroyerInazuma;
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

public class ModelDestroyerIkazuchi extends ShipModelBaseAdv<Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "destroyer_ikazuchi"), "main");

    private final ModelPart BodyMain;
    private final ModelPart Butt;
    private final ModelPart Head;
    private final ModelPart ArmLeft01;
    private final ModelPart ArmRight01;
    private final ModelPart Cloth01;
    private final ModelPart EquipBase;
    private final ModelPart LegRight01;
    private final ModelPart LegLeft01;
    private final ModelPart Skirt01;
    private final ModelPart LegRight02;
    private final ModelPart LegRight03;
    private final ModelPart LegLeft02;
    private final ModelPart LegLeft03;
    private final ModelPart Skirt02;
    private final ModelPart Hair;
    private final ModelPart HairMain;
    private final ModelPart Ahoke;
    private final ModelPart HairU01;
    private final ModelPart HairL01;
    private final ModelPart HairR01;
    private final ModelPart HairL02;
    private final ModelPart HairR02;
    private final ModelPart Hair01;
    private final ModelPart ArmLeft02;
    private final ModelPart ArmLeft03;
    private final ModelPart ArmRight02;
    private final ModelPart ArmRight03;
    private final ModelPart EquipHead01;
    private final ModelPart EquipHead02;
    private final ModelPart EquipHead03;
    private final ModelPart EquipHead04;
    private final ModelPart EquipHead05;
    private final ModelPart Cloth02;
    private final ModelPart EquipMain01;
    private final ModelPart EquipC01;
    private final ModelPart EquipMain02;
    private final ModelPart EquipMain03;
    private final ModelPart EquipMain04;
    private final ModelPart EquipTL02;
    private final ModelPart EquipTL02_1;
    private final ModelPart EquipTL02a;
    private final ModelPart EquipTL02b;
    private final ModelPart EquipTL02c;
    private final ModelPart EquipTL03;
    private final ModelPart EquipTL02d;
    private final ModelPart EquipTL02e;
    private final ModelPart EquipTL02f;
    private final ModelPart EquipTL02a_1;
    private final ModelPart EquipTL02b_1;
    private final ModelPart EquipTL02c_1;
    private final ModelPart EquipTL03_1;
    private final ModelPart EquipTL02d_1;
    private final ModelPart EquipTL02e_1;
    private final ModelPart EquipTL02f_1;
    private final ModelPart EquipC02;
    private final ModelPart EquipC03;
    private final ModelPart EquipC04a;
    private final ModelPart EquipC05a;
    private final ModelPart EquipC04b;
    private final ModelPart EquipC05b;
    private final ModelPart GlowBodyMain;
    private final ModelPart GlowHead;

    public ModelDestroyerIkazuchi(ModelPart root) {
        super();
        this.BodyMain = root.getChild("BodyMain");
        this.ArmRight01 = this.BodyMain.getChild("ArmRight01");
        this.EquipBase = this.BodyMain.getChild("EquipBase");
        this.Cloth01 = this.BodyMain.getChild("Cloth01");
        this.ArmLeft01 = this.BodyMain.getChild("ArmLeft01");
        this.Butt = this.BodyMain.getChild("Butt");
        this.Head = this.BodyMain.getChild("Head");
        this.ArmRight02 = this.ArmRight01.getChild("ArmRight02");
        this.EquipC01 = this.EquipBase.getChild("EquipC01");
        this.EquipMain01 = this.EquipBase.getChild("EquipMain01");
        this.Cloth02 = this.Cloth01.getChild("Cloth02");
        this.ArmLeft02 = this.ArmLeft01.getChild("ArmLeft02");
        this.LegRight01 = this.Butt.getChild("LegRight01");
        this.Skirt01 = this.Butt.getChild("Skirt01");
        this.LegLeft01 = this.Butt.getChild("LegLeft01");
        this.Hair = this.Head.getChild("Hair");
        this.HairMain = this.Head.getChild("HairMain");
        this.ArmRight03 = this.ArmRight02.getChild("ArmRight03");
        this.EquipC02 = this.EquipC01.getChild("EquipC02");
        this.EquipTL02_1 = this.EquipMain01.getChild("EquipTL02_1");
        this.EquipMain02 = this.EquipMain01.getChild("EquipMain02");
        this.EquipMain03 = this.EquipMain01.getChild("EquipMain03");
        this.EquipMain04 = this.EquipMain01.getChild("EquipMain04");
        this.EquipTL02 = this.EquipMain01.getChild("EquipTL02");
        this.ArmLeft03 = this.ArmLeft02.getChild("ArmLeft03");
        this.LegRight02 = this.LegRight01.getChild("LegRight02");
        this.Skirt02 = this.Skirt01.getChild("Skirt02");
        this.LegLeft02 = this.LegLeft01.getChild("LegLeft02");
        this.HairU01 = this.Hair.getChild("HairU01");
        this.HairL01 = this.Hair.getChild("HairL01");
        this.Ahoke = this.Hair.getChild("Ahoke");
        this.HairR01 = this.Hair.getChild("HairR01");
        this.Hair01 = this.HairMain.getChild("Hair01");
        this.EquipHead01 = this.ArmRight03.getChild("EquipHead01");
        this.EquipC05a = this.EquipC02.getChild("EquipC05a");
        this.EquipC04a = this.EquipC02.getChild("EquipC04a");
        this.EquipC03 = this.EquipC02.getChild("EquipC03");
        this.EquipTL02c_1 = this.EquipTL02_1.getChild("EquipTL02c_1");
        this.EquipTL02a_1 = this.EquipTL02_1.getChild("EquipTL02a_1");
        this.EquipTL02d_1 = this.EquipTL02_1.getChild("EquipTL02d_1");
        this.EquipTL02b_1 = this.EquipTL02_1.getChild("EquipTL02b_1");
        this.EquipTL02f_1 = this.EquipTL02_1.getChild("EquipTL02f_1");
        this.EquipTL03_1 = this.EquipTL02_1.getChild("EquipTL03_1");
        this.EquipTL02e_1 = this.EquipTL02_1.getChild("EquipTL02e_1");
        this.EquipTL02c = this.EquipTL02.getChild("EquipTL02c");
        this.EquipTL02b = this.EquipTL02.getChild("EquipTL02b");
        this.EquipTL03 = this.EquipTL02.getChild("EquipTL03");
        this.EquipTL02e = this.EquipTL02.getChild("EquipTL02e");
        this.EquipTL02f = this.EquipTL02.getChild("EquipTL02f");
        this.EquipTL02d = this.EquipTL02.getChild("EquipTL02d");
        this.EquipTL02a = this.EquipTL02.getChild("EquipTL02a");
        this.LegRight03 = this.LegRight02.getChild("LegRight03");
        this.LegLeft03 = this.LegLeft02.getChild("LegLeft03");
        this.HairL02 = this.HairL01.getChild("HairL02");
        this.HairR02 = this.HairR01.getChild("HairR02");
        this.EquipHead02 = this.EquipHead01.getChild("EquipHead02");
        this.EquipC05b = this.EquipC05a.getChild("EquipC05b");
        this.EquipC04b = this.EquipC04a.getChild("EquipC04b");
        this.EquipHead05 = this.EquipHead02.getChild("EquipHead05");
        this.EquipHead03 = this.EquipHead02.getChild("EquipHead03");
        this.EquipHead04 = this.EquipHead02.getChild("EquipHead04");

        this.GlowBodyMain = root.getChild("GlowBodyMain");
        this.GlowHead = this.GlowBodyMain.getChild("GlowHead");
        this.loadFaceParts(this.GlowHead);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bodyMain = partdefinition.addOrReplaceChild("BodyMain",
                CubeListBuilder.create().texOffs(0, 105)
                        .addBox(-6.5F, -11.0F, -4.0F, 13.0F, 14.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition armRight01 = bodyMain.addOrReplaceChild("ArmRight01",
                CubeListBuilder.create().texOffs(0, 88)
                        .addBox(-3.5F, -1.0F, -3.0F, 6.0F, 11.0F, 6.0F),
                PartPose.offsetAndRotation(-7.3F, -9.4F, -0.7F, -0.06981317007977318F, 0.0F,
                        0.3490658503988659F));

        PartDefinition armRight02 = armRight01.addOrReplaceChild("ArmRight02",
                CubeListBuilder.create().texOffs(24, 88)
                        .addBox(0.0F, 0.0F, -6.0F, 6.0F, 8.0F, 6.0F),
                PartPose.offset(-3.5F, 10.0F, 3.0F));

        PartDefinition armRight03 = armRight02.addOrReplaceChild("ArmRight03",
                CubeListBuilder.create().texOffs(36, 102)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F),
                PartPose.offset(3.0F, 6.0F, -3.0F));

        PartDefinition equipHead01 = armRight03.addOrReplaceChild("EquipHead01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, -12.0F, 2.0F, 3.0F, 18.0F),
                PartPose.offsetAndRotation(-0.5F, 3.0F, 0.0F, 0.3142F, 0.0F, 0.0F));

        PartDefinition equipHead02 = equipHead01.addOrReplaceChild("EquipHead02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.5F, -7.0F, 0.0F, 3.0F, 14.0F, 3.0F),
                PartPose.offset(1.0F, 1.5F, -15.0F));

        equipHead02.addOrReplaceChild("EquipHead05",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -5.0F, 0.0F, 2.0F, 10.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, -2.0F));

        equipHead02.addOrReplaceChild("EquipHead03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 4.8F, 2.5F, -0.2617993877991494F, 0.0F, 0.0F));

        equipHead02.addOrReplaceChild("EquipHead04",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, -4.8F, 2.5F, 0.2617993877991494F, 0.0F, 0.0F));

        PartDefinition equipBase = bodyMain.addOrReplaceChild("EquipBase",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition equipC01 = equipBase.addOrReplaceChild("EquipC01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F),
                PartPose.offset(-7.0F, -11.0F, 9.0F));

        PartDefinition equipC02 = equipC01.addOrReplaceChild("EquipC02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.5F, -3.0F, -3.5F, 7.0F, 3.0F, 7.0F),
                PartPose.offsetAndRotation(-2.0F, 0.5F, 0.0F, -0.17453292519943295F,
                        0.6283185307179586F, 0.0F));

        PartDefinition equipC05a = equipC02.addOrReplaceChild("EquipC05a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 6.0F),
                PartPose.offset(1.5F, -3.0F, 0.0F));

        equipC05a.addOrReplaceChild("EquipC05b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-0.5F, -0.5F, -10.0F, 1.0F, 1.0F, 10.0F),
                PartPose.offset(0.0F, 0.0F, -6.0F));

        PartDefinition equipC04a = equipC02.addOrReplaceChild("EquipC04a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 6.0F),
                PartPose.offset(-1.5F, -3.0F, 0.0F));

        equipC04a.addOrReplaceChild("EquipC04b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-0.5F, -0.5F, -10.0F, 1.0F, 1.0F, 10.0F),
                PartPose.offset(0.0F, 0.0F, -6.0F));

        equipC02.addOrReplaceChild("EquipC03",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 2.0F, 5.0F),
                PartPose.offset(0.0F, -5.0F, -2.0F));

        PartDefinition equipMain01 = equipBase.addOrReplaceChild("EquipMain01",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-5.5F, -1.0F, 0.0F, 11.0F, 9.0F, 12.0F),
                PartPose.offset(0.0F, -4.0F, 5.0F));

        PartDefinition equipTL02_1 = equipMain01.addOrReplaceChild("EquipTL02_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, -4.0F, -9.0F, 3.0F, 8.0F, 12.0F),
                PartPose.offsetAndRotation(-5.5F, 6.0F, 4.5F, 0.13962634015954636F,
                        0.06981317007977318F, 0.0F));

        equipTL02_1.addOrReplaceChild("EquipTL02c_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 10.0F),
                PartPose.offset(-1.3F, 2.3F, -18.8F));

        equipTL02_1.addOrReplaceChild("EquipTL02a_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F),
                PartPose.offset(-1.3F, 0.0F, -19.8F));

        equipTL02_1.addOrReplaceChild("EquipTL02d_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F),
                PartPose.offset(-1.3F, -2.3F, 3.0F));

        equipTL02_1.addOrReplaceChild("EquipTL02b_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 10.0F),
                PartPose.offset(-1.3F, -2.3F, -18.8F));

        equipTL02_1.addOrReplaceChild("EquipTL02f_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F),
                PartPose.offset(-1.3F, 2.3F, 3.0F));

        equipTL02_1.addOrReplaceChild("EquipTL03_1",
                CubeListBuilder.create().texOffs(36, 45)
                        .addBox(-1.0F, 0.0F, -8.0F, 1.0F, 24.0F, 7.0F),
                PartPose.offsetAndRotation(-3.0F, -12.0F, 3.0F, 0.0F, 0.3490658503988659F,
                        0.08726646259971647F));

        equipTL02_1.addOrReplaceChild("EquipTL02e_1",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F),
                PartPose.offset(-1.3F, 0.0F, 2.5F));

        equipMain01.addOrReplaceChild("EquipMain02",
                CubeListBuilder.create().texOffs(46, 9)
                        .addBox(-4.5F, 0.0F, 0.0F, 9.0F, 7.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 7.7F, 0.6F, 0.6283185307179586F, 0.0F, 0.0F));

        equipMain01.addOrReplaceChild("EquipMain03",
                CubeListBuilder.create().texOffs(59, 15)
                        .addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 9.5F, 9.0F, 0.5009094953223726F, 0.0F, 0.0F));

        equipMain01.addOrReplaceChild("EquipMain04",
                CubeListBuilder.create().texOffs(0, 26)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 16.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, -16.5F, 9.0F, -0.08726646259971647F, 0.0F, 0.0F));

        PartDefinition equipTL02 = equipMain01.addOrReplaceChild("EquipTL02",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(0.0F, -4.0F, -9.0F, 3.0F, 8.0F, 12.0F),
                PartPose.offsetAndRotation(5.5F, 6.0F, 4.5F, 0.13962634015954636F,
                        -0.06981317007977318F, 0.0F));

        equipTL02.addOrReplaceChild("EquipTL02c",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 10.0F),
                PartPose.offset(1.3F, 2.3F, -18.8F));

        equipTL02.addOrReplaceChild("EquipTL02b",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 10.0F),
                PartPose.offset(1.3F, -2.3F, -18.8F));

        equipTL02.addOrReplaceChild("EquipTL03",
                CubeListBuilder.create().texOffs(36, 45)
                        .addBox(0.0F, 0.0F, -8.0F, 1.0F, 24.0F, 7.0F),
                PartPose.offsetAndRotation(3.0F, -12.0F, 3.0F, 0.0F, -0.3490658503988659F,
                        -0.08726646259971647F));

        equipTL02.addOrReplaceChild("EquipTL02e",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F),
                PartPose.offset(1.3F, 0.0F, 2.5F));

        equipTL02.addOrReplaceChild("EquipTL02f",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F),
                PartPose.offset(1.3F, 2.3F, 3.0F));

        equipTL02.addOrReplaceChild("EquipTL02d",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F),
                PartPose.offset(1.3F, -2.3F, 3.0F));

        equipTL02.addOrReplaceChild("EquipTL02a",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F),
                PartPose.offset(1.3F, 0.0F, -19.8F));

        PartDefinition cloth01 = bodyMain.addOrReplaceChild("Cloth01",
                CubeListBuilder.create().texOffs(84, 31)
                        .addBox(-7.0F, 0.0F, -4.4F, 14.0F, 7.0F, 8.0F),
                PartPose.offset(0.0F, -11.6F, 0.0F));

        cloth01.addOrReplaceChild("Cloth02",
                CubeListBuilder.create().texOffs(22, 48)
                        .addBox(-3.0F, 0.0F, 0.0F, 6.0F, 10.0F, 0.0F),
                PartPose.offset(0.0F, 4.8F, -4.3F));

        PartDefinition armLeft01 = bodyMain.addOrReplaceChild("ArmLeft01",
                CubeListBuilder.create().mirror().texOffs(0, 88)
                        .addBox(-2.5F, -1.0F, -3.0F, 6.0F, 11.0F, 6.0F),
                PartPose.offsetAndRotation(7.3F, -9.4F, -0.7F, 0.20943951023931953F, 0.0F,
                        -0.3490658503988659F));

        PartDefinition armLeft02 = armLeft01.addOrReplaceChild("ArmLeft02",
                CubeListBuilder.create().mirror().texOffs(24, 88)
                        .addBox(-6.0F, 0.0F, -6.0F, 6.0F, 8.0F, 6.0F),
                PartPose.offset(3.5F, 10.0F, 3.0F));

        armLeft02.addOrReplaceChild("ArmLeft03",
                CubeListBuilder.create().mirror().texOffs(36, 102)
                        .addBox(-2.5F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F),
                PartPose.offset(-3.0F, 6.0F, -3.0F));

        PartDefinition butt = bodyMain.addOrReplaceChild("Butt",
                CubeListBuilder.create().texOffs(54, 66)
                        .addBox(-7.0F, 0.0F, 0.0F, 14.0F, 7.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 3.0F, -4.0F, 0.20943951023931953F, 0.0F, 0.0F));

        PartDefinition legRight01 = butt.addOrReplaceChild("LegRight01",
                CubeListBuilder.create().texOffs(0, 59)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F),
                PartPose.offsetAndRotation(-4.4F, 5.5F, 3.2F, -0.03490658503988659F, 0.0F,
                        -0.10471975511965977F));

        PartDefinition legRight02 = legRight01.addOrReplaceChild("LegRight02",
                CubeListBuilder.create().texOffs(0, 72)
                        .addBox(-6.0F, 0.0F, 0.0F, 6.0F, 10.0F, 6.0F),
                PartPose.offset(3.0F, 12.0F, -3.0F));

        legRight02.addOrReplaceChild("LegRight03",
                CubeListBuilder.create().mirror().texOffs(30, 76)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 5.0F, 7.0F),
                PartPose.offset(-3.0F, 8.0F, 2.9F));

        PartDefinition skirt01 = butt.addOrReplaceChild("Skirt01",
                CubeListBuilder.create().texOffs(80, 16)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 6.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 1.7F, -0.4F, -0.05235987755982988F, 0.0F, 0.0F));

        skirt01.addOrReplaceChild("Skirt02",
                CubeListBuilder.create().texOffs(76, 0)
                        .addBox(-8.0F, 0.0F, 0.0F, 16.0F, 6.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 3.5F, -0.4F, -0.05235987755982988F, 0.0F, 0.0F));

        PartDefinition legLeft01 = butt.addOrReplaceChild("LegLeft01",
                CubeListBuilder.create().mirror().texOffs(0, 59)
                        .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F),
                PartPose.offsetAndRotation(4.4F, 5.5F, 3.2F, -0.13962634015954636F, 0.0F,
                        0.10471975511965977F));

        PartDefinition legLeft02 = legLeft01.addOrReplaceChild("LegLeft02",
                CubeListBuilder.create().mirror().texOffs(0, 72)
                        .addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 6.0F),
                PartPose.offset(-3.0F, 12.0F, -3.0F));

        legLeft02.addOrReplaceChild("LegLeft03",
                CubeListBuilder.create().texOffs(30, 76)
                        .addBox(-3.5F, 0.0F, -3.5F, 7.0F, 5.0F, 7.0F),
                PartPose.offset(3.0F, 8.0F, 2.9F));

        PartDefinition head = bodyMain.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(44, 101)
                        .addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F),
                PartPose.offsetAndRotation(0.0F, -11.8F, -1.0F, 0.10471975511965977F, 0.0F, 0.0F));

        PartDefinition hair = head.addOrReplaceChild("Hair",
                CubeListBuilder.create().texOffs(50, 81)
                        .addBox(-8.0F, -8.0F, -7.4F, 16.0F, 12.0F, 8.0F),
                PartPose.offset(0.0F, -7.5F, 0.3F));

        hair.addOrReplaceChild("HairU01",
                CubeListBuilder.create().texOffs(52, 45)
                        .addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F),
                PartPose.offset(0.0F, -6.0F, -7.0F));

        PartDefinition hairL01 = hair.addOrReplaceChild("HairL01",
                CubeListBuilder.create().texOffs(88, 101)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 9.0F, 4.0F),
                PartPose.offsetAndRotation(7.0F, -1.0F, -4.7F, 0.5759586531581287F, 0.2617993877991494F,
                        -0.2617993877991494F));

        hairL01.addOrReplaceChild("HairL02",
                CubeListBuilder.create().texOffs(88, 103)
                        .addBox(-1.0F, 0.0F, 0.0F, 1.0F, 7.0F, 4.0F),
                PartPose.offsetAndRotation(1.0F, 9.0F, 0.0F, 0.0F, 0.0F, 1.0471975511965976F));

        hair.addOrReplaceChild("Ahoke",
                CubeListBuilder.create().texOffs(0, 37)
                        .addBox(0.0F, -11.0F, -7.0F, 0.0F, 11.0F, 11.0F),
                PartPose.offsetAndRotation(-1.0F, -6.0F, -6.0F, 1.0471975511965976F,
                        1.0471975511965976F, 0.0F));

        PartDefinition hairR01 = hair.addOrReplaceChild("HairR01",
                CubeListBuilder.create().texOffs(88, 101)
                        .addBox(-1.0F, 0.0F, 0.0F, 1.0F, 9.0F, 4.0F),
                PartPose.offsetAndRotation(-7.0F, -1.0F, -4.7F, 0.5759586531581287F,
                        -0.2617993877991494F, 0.2617993877991494F));

        hairR01.addOrReplaceChild("HairR02",
                CubeListBuilder.create().texOffs(88, 103)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 7.0F, 4.0F),
                PartPose.offsetAndRotation(-1.0F, 9.0F, 0.0F, 0.0F, 0.0F, -1.0471975511965976F));

        PartDefinition hairMain = head.addOrReplaceChild("HairMain",
                CubeListBuilder.create().texOffs(46, 104)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F),
                PartPose.offset(0.0F, -14.8F, -3.0F));

        hairMain.addOrReplaceChild("Hair01",
                CubeListBuilder.create().texOffs(36, 26)
                        .addBox(-7.5F, 0.0F, 0.0F, 15.0F, 10.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 6.8F, 1.1F, 0.20943951023931953F, 0.0F, 0.0F));

        PartDefinition glowBodyMain = partdefinition.addOrReplaceChild("GlowBodyMain",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -9.0F, 0.0F));

        PartDefinition glowHead = glowBodyMain.addOrReplaceChild("GlowHead",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, -11.8F, -1.0F));
        addDefaultFaceParts(glowHead);

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
        IShipEmotion ent = (IShipEmotion) entity;
        // set scale per scaleLevel
        switch (ent.getScaleLevel()) {
            case 3:
                this.scale = 1.6F;
                this.offsetY = -0.53F;
                break;
            case 2:
                this.scale = 1.2F;
                this.offsetY = -0.23F;
                break;
            case 1:
                this.scale = 0.8F;
                this.offsetY = 0.41F;
                break;
            default:
                this.scale = 0.4F;
                this.offsetY = 2.28F;
                break;
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

        int state = ent.getStateEmotion(ID.S.State);

        boolean flag = !EmotionHelper.checkModelState(0, state); // cannon
        this.EquipBase.visible = !flag;

        flag = !EmotionHelper.checkModelState(1, state); // anchor
        this.EquipHead01.visible = !flag;
    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowBodyMain.xRot = this.BodyMain.xRot;
        this.GlowBodyMain.yRot = this.BodyMain.yRot;
        this.GlowBodyMain.zRot = this.BodyMain.zRot;
        this.GlowHead.xRot = this.Head.xRot;
        this.GlowHead.yRot = this.Head.yRot;
        this.GlowHead.zRot = this.Head.zRot;
        this.EquipC05a.xRot = this.EquipC04a.xRot;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        // [PORT] 1.10.2 -> 1.20.1: preserve legacy dead-pose grounding offset.
        this.offsetY += 0.51F + 0.24F * ent.getScaleLevel();

        this.setFaceHungry(ent);

        // body
        this.Head.xRot = 0F;
        this.Head.yRot = 0F;
        this.Head.zRot = 0F;
        this.Ahoke.yRot = 0.5236F;
        this.BodyMain.xRot = 1.55F;
        this.Butt.xRot = 0.21F;
        // this.Butt.offsetY = 0F;
        this.Skirt01.xRot = -0.052F;
        // this.Skirt01.offsetY = 0F;
        this.Skirt02.xRot = -0.052F;
        // this.Skirt02.offsetY = 0F;
        // arm
        this.ArmLeft01.xRot = -3F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = 0.3F;
        this.ArmRight01.xRot = -3F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = -0.3F;
        this.ArmLeft02.xRot = 0F;
        this.ArmLeft02.zRot = 0F;
        // this.ArmLeft02.offsetX = 0F;
        this.ArmRight02.xRot = 0F;
        this.ArmRight02.zRot = 0F;
        // this.ArmRight02.offsetX = 0F;
        // leg
        this.LegLeft01.xRot = -0.2618F;
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.03F;
        this.LegRight01.xRot = -0.2618F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.03F;
        this.LegLeft02.xRot = 0F;
        this.LegLeft02.yRot = 0F;
        this.LegLeft02.zRot = 0F;
        // this.LegLeft02.offsetX = 0F;
        // this.LegLeft02.offsetY = 0F;
        // this.LegLeft02.offsetZ = 0F;
        this.LegRight02.xRot = 0F;
        this.LegRight02.yRot = 0F;
        this.LegRight02.zRot = 0F;
        // this.LegRight02.offsetX = 0F;
        // this.LegRight02.offsetY = 0F;
        // this.LegRight02.offsetZ = 0F;
        // equip
        this.EquipHead01.yRot = -1.4F;
        this.EquipHead01.zRot = 1.4F;
        this.EquipC02.yRot = 0.6F;
        this.EquipC04a.xRot = 0F;
        this.EquipC05a.xRot = -0.2F;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {

        float angleX = Mth.cos(f2 * 0.08F + f * 0.25F);
        float angleAdd1 = Mth.cos(f * 0.7F) * f1;
        float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
        float addk1;
        float addk2;

        // 水上漂浮
        if (ent.getShipDepth(0) > 0D || ent.getShipDepth(1) > 0D) {
            this.offsetY += angleX * 0.05F + 0.025F;
        }

        // leg move
        addk1 = angleAdd1 * 0.5F - 0.14F; // LegLeft01
        addk2 = angleAdd2 * 0.5F - 0.03F; // LegRight01

        // head
        this.Head.xRot = f4 * 0.014F + 0.1047F;
        this.Head.yRot = f3 * 0.01F;
        // body
        this.Ahoke.yRot = angleX * 0.2F + 0.5F;
        this.BodyMain.xRot = -0.1047F;
        this.BodyMain.yRot = 0F;
        this.BodyMain.zRot = 0F;
        this.Butt.xRot = 0.21F;
        // this.Butt.offsetY = 0F;
        this.Skirt01.xRot = -0.052F;
        // this.Skirt01.offsetY = 0F;
        this.Skirt02.xRot = -0.052F;
        // this.Skirt02.offsetY = 0F;
        // arm
        this.ArmLeft01.xRot = angleAdd2 * 0.25F + 0.21F;
        this.ArmLeft01.yRot = 0F;
        this.ArmLeft01.zRot = angleX * 0.03F - 0.35F;
        this.ArmLeft02.xRot = 0F;
        this.ArmLeft02.zRot = 0F;
        // this.ArmLeft02.offsetX = 0F;
        this.ArmRight01.xRot = angleAdd1 * 0.25F - 0.07F;
        this.ArmRight01.yRot = 0F;
        this.ArmRight01.zRot = -angleX * 0.03F + 0.35F;
        this.ArmRight02.xRot = 0F;
        this.ArmRight02.zRot = 0F;
        // this.ArmRight02.offsetX = 0F;
        // leg
        this.LegLeft01.yRot = 0F;
        this.LegLeft01.zRot = 0.1047F;
        this.LegLeft02.xRot = 0F;
        this.LegLeft02.yRot = 0F;
        this.LegLeft02.zRot = 0F;
        // this.LegLeft02.offsetX = 0F;
        // this.LegLeft02.offsetY = 0F;
        // this.LegLeft02.offsetZ = 0F;
        this.LegRight01.yRot = 0F;
        this.LegRight01.zRot = -0.1047F;
        this.LegRight02.xRot = 0F;
        this.LegRight02.yRot = 0F;
        this.LegRight02.zRot = 0F;
        // this.LegRight02.offsetX = 0F;
        // this.LegRight02.offsetY = 0F;
        // this.LegRight02.offsetZ = 0F;
        // equip
        this.EquipHead01.yRot = 0F;
        this.EquipHead01.zRot = 0F;
        this.EquipC02.yRot = 0.5F + this.Head.yRot * 0.5F;
        this.EquipC04a.xRot = -0.2F + this.Head.xRot;
        if (this.EquipC04a.xRot > 0F)
            this.EquipC04a.xRot = 0F;
        this.EquipC05a.xRot = this.EquipC04a.xRot;

        if (!EmotionHelper.checkModelState(0, ent.getStateEmotion(ID.S.State))) {
            this.ArmLeft01.zRot += 0.1F;
            this.ArmRight01.zRot -= 0.1F;
        }

        if (ent.getIsSprinting() || f1 > 0.9F) { // 奔跑動作
            setFace(3);
            // body
            this.Head.xRot -= 0.25F;
            this.BodyMain.xRot = 0.1F;
            this.Skirt01.xRot = -0.1F;
            this.Skirt02.xRot = -0.1885F;
            // arm
            this.ArmLeft01.xRot += 0.1F;
            this.ArmLeft01.zRot -= 0.3F;
            this.ArmRight01.xRot = -2.2F + angleAdd1 * 0.2F;
            this.ArmRight01.zRot = -0.4712F;
            // leg
            addk1 -= 0.2F;
            addk2 -= 0.2F;
            // equip
            this.EquipHead01.yRot = -0.3142F;
        }

        // head tilt angle
        this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);

        if (ent.getIsSneaking()) { // 潛行, 蹲下動作
            // Body
            // [PORT] Restored from 1.10.2 GlStateManager.translate
            this.offsetY += 0.05F;
            this.Head.xRot -= 1.0472F;
            this.BodyMain.xRot = 1.0472F;
            this.Butt.xRot = -0.4F;
            // this.Butt.offsetY = -0.19F;
            this.Skirt01.xRot = -0.12F;
            this.Skirt02.xRot = -0.4F;
            // this.Skirt02.offsetY = -0.1F;
            // arm
            this.ArmLeft01.xRot = -0.6F;
            this.ArmLeft01.zRot = 0.2618F;
            this.ArmRight01.xRot = -0.6F;
            this.ArmRight01.zRot = -0.2618F;
            // leg
            addk1 -= 0.55F;
            addk2 -= 0.55F;
        } // end if sneaking

        if (ent.getIsSitting() || ent.getIsRiding()) {
            // 騎乘動作
            net.minecraft.world.entity.Entity mount = ((net.minecraft.world.entity.Entity) ent)
                    .getVehicle();

            if (mount instanceof EntityDestroyerInazuma ||
                    mount instanceof EntityDestroyerAkatsuki) {
                if (((IShipEmotion) (mount)).getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                    // Body
                    this.BodyMain.xRot = -0.1F;
                    this.Butt.xRot = -0.2F;
                    // this.Butt.offsetY = -0.1F;
                    this.Skirt01.xRot = -0.07F;
                    // this.Skirt01.offsetY = -0.05F;
                    this.Skirt02.xRot = -0.16F;
                    // this.Skirt02.offsetY = -0.08F;
                    // arm
                    this.ArmLeft01.xRot = -0.5F;
                    this.ArmLeft01.yRot = -0.2F;
                    this.ArmLeft01.zRot = 0F;
                    this.ArmLeft02.xRot = -1.45F;
                    this.ArmRight01.xRot = -0.5F;
                    this.ArmRight01.yRot = 0.2F;
                    this.ArmRight01.zRot = 0F;
                    this.ArmRight02.xRot = -1.45F;
                    // leg
                    addk1 = -0.65F;
                    addk2 = -0.65F;
                    this.LegLeft01.yRot = 0.0F;
                    this.LegLeft01.zRot = -0.25F;
                    // this.LegLeft02.offsetZ = 0.0F;
                    this.LegLeft02.xRot = 0.8F;
                    this.LegLeft02.zRot = 0.0175F;
                    this.LegRight01.yRot = -0.0F;
                    this.LegRight01.zRot = 0.25F;
                    // this.LegRight02.offsetZ = 0.0F;
                    this.LegRight02.xRot = 0.8F;
                    this.LegRight02.zRot = -0.0175F;
                    // equip
                    this.EquipHead01.visible = false;
                } else {
                    // Body
                    this.Butt.xRot = -0.2F;
                    // this.Butt.offsetY = -0.1F;
                    this.Skirt01.xRot = -0.07F;
                    // this.Skirt01.offsetY = -0.1F;
                    this.Skirt02.xRot = -0.16F;
                    // this.Skirt02.offsetY = -0.15F;
                    // arm
                    this.ArmLeft01.xRot = -0.3F;
                    this.ArmLeft01.yRot = -0.2F;
                    this.ArmLeft01.zRot = 0F;
                    this.ArmLeft02.xRot = -1.2F;
                    this.ArmRight01.xRot = -1.8F;
                    this.ArmRight01.yRot = 0.2F;
                    this.ArmRight01.zRot = 0F;
                    // leg
                    addk1 = -0.95F;
                    addk2 = -0.95F;
                    this.LegLeft01.yRot = -0.5F;
                    this.LegLeft01.zRot = -0.1F;
                    // this.LegLeft02.offsetZ = 0.0F;
                    this.LegLeft02.xRot = 0.8F;
                    this.LegLeft02.zRot = 0.0175F;
                    this.LegRight01.yRot = 0.5F;
                    this.LegRight01.zRot = 0.1F;
                    // this.LegRight02.offsetZ = 0.0F;
                    this.LegRight02.xRot = 0.8F;
                    this.LegRight02.zRot = -0.0175F;
                }
            } else if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                // head
                // [PORT] Restored from 1.10.2 GlStateManager.translate
                this.offsetY += 0.375F;
                this.Head.xRot -= 0.1F;
                // body
                this.BodyMain.xRot = -0.25F;
                this.Butt.xRot = -0.2F;
                // this.Butt.offsetY = -0.1F;
                this.Skirt01.xRot = -0.07F;
                // this.Skirt01.offsetY = -0.1F;
                this.Skirt02.xRot = -0.16F;
                // this.Skirt02.offsetY = -0.15F;
                // arm
                this.ArmLeft01.xRot = 2.5F;
                this.ArmLeft01.zRot = 0.1F;
                this.ArmLeft02.zRot = 1F;
                this.ArmRight01.xRot = 2.5F;
                this.ArmRight01.zRot = -0.1F;
                this.ArmRight02.zRot = -1F;
                // leg
                addk1 = -0.9F;
                addk2 = -0.9F;
                this.LegLeft01.zRot = -0.14F;
                this.LegLeft02.xRot = 1.2217F;
                this.LegLeft02.yRot = 1.2217F;
                this.LegLeft02.zRot = -1.0472F;
                // this.LegLeft02.offsetX = 0.32F;
                // this.LegLeft02.offsetY = 0.05F;
                // this.LegLeft02.offsetZ = 0.35F;
                this.LegRight01.zRot = 0.14F;
                this.LegRight02.xRot = 1.2217F;
                this.LegRight02.yRot = -1.2217F;
                this.LegRight02.zRot = 1.0472F;
                // this.LegRight02.offsetX = -0.32F;
                // this.LegRight02.offsetY = 0.05F;
                // this.LegRight02.offsetZ = 0.35F;
                // equip
                this.EquipHead01.visible = false;

                // arm special
                float parTick = f2 - (int) f2 + (ent.getTickExisted() % 256);

                if (parTick < 30F) {
                    float az = Mth.sin(parTick * 0.033F * 1.5708F) * 1.8F;
                    float az1 = az * 1.6F;

                    setFace(3);
                    // arm
                    this.ArmLeft01.zRot = 0.1F + az;
                    this.ArmLeft02.zRot = 1F - az1;
                    if (this.ArmLeft02.zRot < 0F)
                        this.ArmLeft02.zRot = 0F;
                    this.ArmRight01.zRot = -0.1F - az;
                    this.ArmRight02.zRot = -1F + az1;
                    if (this.ArmRight02.zRot > 0F)
                        this.ArmRight02.zRot = 0F;
                } else if (parTick < 45F) {
                    setFace(3);
                    // arm
                    this.ArmLeft01.zRot = 1.9F;
                    this.ArmLeft02.zRot = 0F;
                    this.ArmRight01.zRot = -1.9F;
                    this.ArmRight02.zRot = 0F;
                } else if (parTick < 53F) {
                    float az = Mth.cos((parTick - 45F) * 0.125F * 1.5708F);
                    float az1 = az * 1.8F;

                    // arm
                    this.ArmLeft01.zRot = 0.1F + az1;
                    this.ArmLeft02.zRot = 1F - az;
                    this.ArmRight01.zRot = -0.1F - az1;
                    this.ArmRight02.zRot = -1F + az;
                }
            } else {
                // head
                this.Head.xRot -= 0.1F;
                // body
                this.BodyMain.xRot = -0.25F;
                this.Butt.xRot = -0.2F;
                // this.Butt.offsetY = -0.1F;
                this.Skirt01.xRot = -0.07F;
                // this.Skirt01.offsetY = -0.1F;
                this.Skirt02.xRot = -0.16F;
                // this.Skirt02.offsetY = -0.15F;
                // arm
                this.ArmLeft01.xRot = 0.3F;
                this.ArmLeft01.zRot = -0.2618F;
                this.ArmRight01.xRot = 0.3F;
                this.ArmRight01.zRot = 0.2618F;
                // leg
                addk1 = -0.9F;
                addk2 = -0.9F;
                this.LegLeft01.zRot = -0.14F;
                this.LegLeft02.xRot = 1.2217F;
                this.LegLeft02.yRot = 1.2217F;
                this.LegLeft02.zRot = -1.0472F;
                // this.LegLeft02.offsetX = 0.32F;
                // this.LegLeft02.offsetY = 0.05F;
                // this.LegLeft02.offsetZ = 0.35F;
                this.LegRight01.zRot = 0.14F;
                this.LegRight02.xRot = 1.2217F;
                this.LegRight02.yRot = -1.2217F;
                this.LegRight02.zRot = 1.0472F;
                // this.LegRight02.offsetX = -0.32F;
                // this.LegRight02.offsetY = 0.05F;
                // this.LegRight02.offsetZ = 0.35F;
                // equip
                this.EquipHead01.zRot = 1.2F;
            }
        } // end if sitting

        // 攻擊動作
        if (ent.getAttackTick() > 20 && !ent.getIsRiding()) {
            setFace(3);
            // body
            this.Head.xRot -= 0.1F;
            // equip
            this.EquipHead01.yRot = -0.3142F;

            if (ent.getTickExisted() % 128 < 64) {
                // arm
                this.ArmLeft01.xRot = 0.2356F;
                this.ArmLeft01.zRot = -0.7854F;
                this.ArmLeft02.zRot = 1.5708F;
                // this.ArmLeft02.offsetX = -0.15F;
                this.ArmRight01.xRot = -1.6F + angleAdd1 * 0.2F;
                this.ArmRight01.zRot = -0.4F;
            } else {
                // arm
                this.ArmLeft01.xRot = 0.2356F;
                this.ArmLeft01.zRot = -0.7854F;
                this.ArmLeft02.zRot = 1.5708F;
                // this.ArmLeft02.offsetX = -0.15F;
                this.ArmRight01.xRot = 0.2356F;
                this.ArmRight01.zRot = 0.7854F;
                this.ArmRight02.zRot = -1.5708F;
                // this.ArmRight02.offsetX = 0.15F;
                // equip
                this.EquipHead01.visible = false;
            }
        }

        // swing arm
        float f6 = ent.getSwingTime(f2 - (int) f2);
        if (f6 != 0F) {
            float f7 = Mth.sin(f6 * f6 * (float) Math.PI);
            float f8 = Mth.sin(Mth.sqrt(f6) * (float) Math.PI);
            this.ArmRight01.xRot += -f8 * 80.0F * ((float) Math.PI / 180F);
            this.ArmRight01.yRot += -f7 * 20.0F * ((float) Math.PI / 180F) + 0.2F;
            this.ArmRight01.zRot += -f8 * 20.0F * ((float) Math.PI / 180F);
        }

        // leg motion
        this.LegLeft01.xRot = addk1;
        this.LegRight01.xRot = addk2;
    }
}
