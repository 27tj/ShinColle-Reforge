package com.lulan.shincolle.client.render.block;

import com.lulan.shincolle.block.BasicBlockMulti;
import com.lulan.shincolle.client.model.ModelLargeShipyard;
import com.lulan.shincolle.client.model.ModelVortex;
import com.lulan.shincolle.reference.Reference;
import com.lulan.shincolle.tileentity.TileMultiGrudgeHeavy;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderLargeShipyard implements BlockEntityRenderer<TileMultiGrudgeHeavy> {

    private static final ResourceLocation TEXTURE_BASE = new ResourceLocation(
            Reference.MOD_ID, "textures/blocks/blocklargeshipyard.png");
    private static final ResourceLocation VORTEX_OFF = new ResourceLocation(
            Reference.MOD_ID, "textures/blocks/modelvortex.png");
    private static final ResourceLocation VORTEX_ON = new ResourceLocation(
            Reference.MOD_ID, "textures/blocks/modelvortexon.png");

    private final ModelLargeShipyard modelBase;
    private final ModelVortex modelVortex;

    public RenderLargeShipyard(BlockEntityRendererProvider.Context context) {
        ModelPart baseRoot = context.bakeLayer(ModelLargeShipyard.LAYER_LOCATION);
        this.modelBase = new ModelLargeShipyard(baseRoot);
        ModelPart vortexRoot = context.bakeLayer(ModelVortex.LAYER_LOCATION);
        this.modelVortex = new ModelVortex(vortexRoot);
    }

    @Override
    public void render(TileMultiGrudgeHeavy tile, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        // Only render when the multiblock structure is formed (MBS > 0)
        BlockState blockState = tile.getBlockState();
        if (blockState.getValue(BasicBlockMulti.MBS) <= 0) {
            return;
        }

        Player player = Minecraft.getInstance().player;
        if (player == null)
            return;

        BlockPos pos = tile.getBlockPos();
        double distX = pos.getX() + 0.5D - player.getX();
        double distY = pos.getY() - 0.75D - player.getY();
        double distZ = pos.getZ() + 0.5D - player.getZ();
        float f1 = Mth.sqrt((float) (distX * distX + distZ * distZ));
        float pitch = (float) Math.atan2(f1, distY) + (float) (Math.PI * 0.5);
        float yaw = (float) Math.atan2(distX, distZ);

        // Vortex rotation angle
        float angle = (-player.tickCount - partialTick) % 360F;

        // Check if the multiblock structure is formed and active
        boolean active = tile.hasCorePos();

        // Speed up rotation when the structure is active (formed)
        if (active) {
            angle *= 5;
        }

        // Render base model
        poseStack.pushPose();
        poseStack.translate(0.5F, -0.2F, 0.5F);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180F));
        poseStack.scale(1F, 1.2F, 1F);

        VertexConsumer baseConsumer = bufferSource.getBuffer(RenderType.entitySolid(TEXTURE_BASE));
        modelBase.renderToBuffer(poseStack, baseConsumer, packedLight, packedOverlay, 1F, 1F, 1F, 1F);
        poseStack.popPose();

        // Render vortex
        ResourceLocation vortexTex = active ? VORTEX_ON : VORTEX_OFF;
        poseStack.pushPose();
        poseStack.translate(0.5F, 0.5F, 0.5F);
        poseStack.mulPose(Axis.YP.rotation(yaw));
        poseStack.mulPose(Axis.XP.rotation(pitch));
        poseStack.mulPose(Axis.ZP.rotationDegrees(angle));
        poseStack.scale(0.5F, 0.5F, 0.5F); // scale down vortex

        VertexConsumer vortexConsumer = bufferSource.getBuffer(RenderType.entityTranslucent(vortexTex));
        modelVortex.renderToBuffer(poseStack, vortexConsumer, packedLight, packedOverlay, 1F, 1F, 1F, 1F);
        poseStack.popPose();
    }

    @Override
    public boolean shouldRenderOffScreen(TileMultiGrudgeHeavy tile) {
        // Multiblock structure can extend beyond single block bounds
        return true;
    }
}
