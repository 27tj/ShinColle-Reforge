package com.lulan.shincolle.client.gui;

import com.lulan.shincolle.client.gui.inventory.ContainerRecipePaper;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

/**
 * GUI screen for the recipe paper item.
 * Renders crafting grid labels, result display, and recipe info.
 */
public class GuiRecipePaper extends AbstractContainerScreen<ContainerRecipePaper> {

    private static final ResourceLocation TEXTURE = new ResourceLocation("shincolle",
            "textures/gui/guirecipepaper.png");

    public GuiRecipePaper(ContainerRecipePaper menu, Inventory playerInv, Component title) {
        super(menu, playerInv, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        // Render background texture
        graphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

        // Draw arrow from crafting grid to result slot
        int arrowX = this.leftPos + 90;
        int arrowY = this.topPos + 35;
        // Simple arrow indicator (horizontal line with arrowhead)
        graphics.fill(arrowX, arrowY + 3, arrowX + 25, arrowY + 5, 0xFF888888);
        // Arrowhead
        graphics.fill(arrowX + 22, arrowY + 1, arrowX + 25, arrowY + 7, 0xFF888888);
    }

    @Override
    protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {
        // Draw title centered at top
        String paperTitle = "Recipe Paper";
        graphics.drawString(this.font, paperTitle,
                this.imageWidth / 2 - this.font.width(paperTitle) / 2, 6, 0x404040, false);

        // Draw section labels
        // Crafting pattern label
        String patternLabel = "Pattern";
        graphics.drawString(this.font, patternLabel,
                39 - this.font.width(patternLabel) / 2, 60, 0x888888, false);

        // Result label
        String resultLabel = "Result";
        graphics.drawString(this.font, resultLabel,
                124 - this.font.width(resultLabel) / 2, 52, 0x888888, false);

        // Draw recipe info / helper text
        // Check if any pattern slots have items
        boolean hasPattern = false;
        for (int i = 0; i < ContainerRecipePaper.CRAFTING_SLOT_COUNT; i++) {
            ItemStack stack = this.menu.getRecipeInv().getItem(i);
            if (!stack.isEmpty()) {
                hasPattern = true;
                break;
            }
        }

        if (!hasPattern) {
            // Show instructions when empty
            String hint1 = "Click items to set pattern";
            String hint2 = "Empty hand to clear slot";
            graphics.drawString(this.font, hint1,
                    this.imageWidth / 2 - this.font.width(hint1) / 2, 68, 0x666666, false);
            graphics.drawString(this.font, hint2,
                    this.imageWidth / 2 - this.font.width(hint2) / 2, 78, 0x666666, false);
        } else {
            // Show pattern indicator
            String patternSet = "Pattern set";
            graphics.drawString(this.font, patternSet,
                    this.imageWidth / 2 - this.font.width(patternSet) / 2, 68, 0x00AA00, false);
        }

        // Player inventory label
        graphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 0x404040, false);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, partialTick);
        this.renderTooltip(graphics, mouseX, mouseY);
    }
}
