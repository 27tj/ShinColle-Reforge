package com.lulan.shincolle.client.render.block;

import com.lulan.shincolle.block.BasicBlockFacingContainer;
import com.lulan.shincolle.block.BlockSmallShipyard;
import com.lulan.shincolle.client.model.ModelSmallShipyard;
import com.lulan.shincolle.reference.Reference;
import com.lulan.shincolle.tileentity.TileEntitySmallShipyard;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderSmallShipyard implements BlockEntityRenderer<TileEntitySmallShipyard> {

    private static final ResourceLocation TEXTURE_ON = new ResourceLocation(
            Reference.MOD_ID, "textures/blocks/blocksmallshipyardon.png");
    private static final ResourceLocation TEXTURE_OFF = new ResourceLocation(
            Reference.MOD_ID, "textures/blocks/blocksmallshipyardoff.png");

    private final ModelSmallShipyard model;

    public RenderSmallShipyard(BlockEntityRendererProvider.Context context) {
        ModelPart root = context.bakeLayer(ModelSmallShipyard.LAYER_LOCATION);
        this.model = new ModelSmallShipyard(root);
    }

    private static float getFacingAngle(BlockState state) {
        if (!state.hasProperty(BasicBlockFacingContainer.FACING))
            return 0F;
        Direction facing = state.getValue(BasicBlockFacingContainer.FACING);
        return switch (facing) {
            case EAST -> 90F;
            case SOUTH -> 180F;
            case WEST -> -90F;
            default -> 0F; // NORTH
        };
    }

    @Override
    public void render(TileEntitySmallShipyard tile, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        BlockState state = tile.getBlockState();

        // Determine texture based on active state
        boolean active = state.hasProperty(BlockSmallShipyard.ACTIVE) && state.getValue(BlockSmallShipyard.ACTIVE);
        ResourceLocation texture = active ? TEXTURE_ON : TEXTURE_OFF;

        // Determine facing angle
        float angle = getFacingAngle(state);

        poseStack.pushPose();
        poseStack.translate(0.5F, 1.5F, 0.5F);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180F));
        poseStack.mulPose(Axis.YP.rotationDegrees(angle));

        VertexConsumer consumer = bufferSource.getBuffer(RenderType.entitySolid(texture));
        model.renderToBuffer(poseStack, consumer, packedLight, packedOverlay, 1F, 1F, 1F, 1F);

        poseStack.popPose();
    }
}
