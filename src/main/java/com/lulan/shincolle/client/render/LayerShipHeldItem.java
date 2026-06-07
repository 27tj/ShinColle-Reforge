package com.lulan.shincolle.client.render;

import com.lulan.shincolle.client.model.ShipModelBaseAdv;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.handler.ConfigHandler;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * Render layer that displays held items in ship entity hands.
 * Ported from 1.10.2 LayerShipHeldItem to 1.20.1 RenderLayer system.
 * <p>
 * Uses ShipModelBaseAdv arm chain transforms (getArmForSide) to position
 * the held item correctly relative to the model's arm parts.
 */
@OnlyIn(Dist.CLIENT)
public class LayerShipHeldItem<T extends BasicEntityShip> extends RenderLayer<T, EntityModel<T>> {

    public LayerShipHeldItem(RenderLayerParent<T, EntityModel<T>> renderer) {
        super(renderer);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight,
                       T entity, float limbSwing, float limbSwingAmount, float partialTick,
                       float ageInTicks, float netHeadYaw, float headPitch) {
        // Check AI option
        if (!entity.canShowHeldItem())
            return;

        ItemStack mainHand = entity.getMainHandItem();
        ItemStack offHand = entity.getOffhandItem();

        if (!mainHand.isEmpty()) {
            renderHeldItem(poseStack, buffer, packedLight, entity, mainHand,
                    ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, HumanoidArm.RIGHT);
        }

        if (!offHand.isEmpty()) {
            renderHeldItem(poseStack, buffer, packedLight, entity, offHand,
                    ItemDisplayContext.THIRD_PERSON_LEFT_HAND, HumanoidArm.LEFT);
        }
    }

    private void renderHeldItem(PoseStack poseStack, MultiBufferSource buffer, int packedLight,
                                T entity, ItemStack stack, ItemDisplayContext displayContext,
                                HumanoidArm arm) {
        poseStack.pushPose();

        if (entity.isCrouching()) {
            poseStack.translate(0.0F, 0.2F, 0.0F);
        }

        // Only render for ShipModelBaseAdv models
        EntityModel<T> model = this.getParentModel();
        if (model instanceof ShipModelBaseAdv<?> advModel) {
            boolean isBlock = stack.getItem() instanceof BlockItem;
            ModelPart[] hand = advModel.getArmForSide(arm);
            float[] offset = advModel.getHeldItemOffset(entity, arm, isBlock ? 1 : 0);
            float[] rotate = advModel.getHeldItemRotate(entity, arm, isBlock ? 1 : 0);
            float modelScale = advModel.getScale();

            if (hand != null) {
                boolean leftHand = arm == HumanoidArm.LEFT;

                // Apply configurable offset
                poseStack.translate(
                        (offset[0] + (float) ConfigHandler.scaleHeldItem[1]) * (leftHand ? -1F : 1F),
                        offset[1] + (float) ConfigHandler.scaleHeldItem[2],
                        offset[2] + (float) ConfigHandler.scaleHeldItem[3]);

                // Apply arm chain transforms (body -> shoulder -> arm -> hand)
                // Equivalent to ModelRenderer.postRender() in 1.10.2
                for (ModelPart part : hand) {
                    part.translateAndRotate(poseStack);
                }

                poseStack.scale(modelScale, modelScale, modelScale);
                poseStack.mulPose(Axis.XP.rotationDegrees(-90F + rotate[0]));
                poseStack.mulPose(Axis.YP.rotationDegrees(180F + rotate[1]));
                poseStack.mulPose(Axis.ZP.rotationDegrees(rotate[2]));
                poseStack.translate((leftHand ? -1 : 1) / 16F, 0.125F, -0.625F);

                float scale = (float) ConfigHandler.scaleHeldItem[0];

                // Different scaling for different item types (matches original isFull3D
                // behavior)
                if (stack.getItem() instanceof SwordItem || stack.getItem() instanceof DiggerItem) {
                    // Weapon/tool: thinner on X axis
                    poseStack.scale(scale * 0.5F, scale, scale);
                } else if (isBlock) {
                    // Block item: slightly smaller
                    poseStack.scale(scale * 0.75F, scale * 0.75F, scale * 0.75F);
                } else {
                    // Other items: full scale
                    poseStack.scale(scale, scale, scale);
                }

                Minecraft.getInstance().getItemRenderer().renderStatic(
                        entity, stack, displayContext, leftHand,
                        poseStack, buffer, entity.level(), packedLight,
                        OverlayTexture.NO_OVERLAY, entity.getId());
            }
        }

        poseStack.popPose();
    }
}
