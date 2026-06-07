package com.lulan.shincolle.client.render.block;

import com.lulan.shincolle.client.model.ModelBlockDesk;
import com.lulan.shincolle.client.model.ModelSmallShipyard;
import com.lulan.shincolle.init.ModBlocks;
import com.lulan.shincolle.reference.Reference;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ShipBlockItemRenderer extends BlockEntityWithoutLevelRenderer {

    private static final ResourceLocation TEX_DESK = new ResourceLocation(
            Reference.MOD_ID, "textures/blocks/blockdesk.png");
    private static final ResourceLocation TEX_SHIPYARD_OFF = new ResourceLocation(
            Reference.MOD_ID, "textures/blocks/blocksmallshipyardoff.png");
    private static ShipBlockItemRenderer instance;
    private ModelBlockDesk modelDesk;
    private ModelSmallShipyard modelShipyard;
    private boolean initialized = false;

    public ShipBlockItemRenderer() {
        super(null, null);
    }

    public static ShipBlockItemRenderer getInstance() {
        if (instance == null) {
            instance = new ShipBlockItemRenderer();
        }
        return instance;
    }

    private void ensureInitialized() {
        if (!initialized) {
            EntityModelSet modelSet = Minecraft.getInstance().getEntityModels();
            this.modelDesk = new ModelBlockDesk(modelSet.bakeLayer(ModelBlockDesk.LAYER_LOCATION));
            this.modelShipyard = new ModelSmallShipyard(modelSet.bakeLayer(ModelSmallShipyard.LAYER_LOCATION));
            this.initialized = true;
        }
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack,
                             MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        ensureInitialized();

        if (!(stack.getItem() instanceof BlockItem blockItem))
            return;

        Block block = blockItem.getBlock();

        if (block == ModBlocks.DESK.get()) {
            renderModel(poseStack, bufferSource, packedLight, packedOverlay, modelDesk, TEX_DESK);
        } else if (block == ModBlocks.SMALL_SHIPYARD.get()) {
            renderModel(poseStack, bufferSource, packedLight, packedOverlay, modelShipyard, TEX_SHIPYARD_OFF);
        }
    }

    private void renderModel(PoseStack poseStack, MultiBufferSource bufferSource,
                             int packedLight, int packedOverlay,
                             net.minecraft.client.model.Model model, ResourceLocation texture) {
        poseStack.pushPose();
        poseStack.translate(0.5F, 1.5F, 0.5F);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180F));

        VertexConsumer consumer = bufferSource.getBuffer(RenderType.entitySolid(texture));
        model.renderToBuffer(poseStack, consumer, packedLight, packedOverlay, 1F, 1F, 1F, 1F);

        poseStack.popPose();
    }
}
