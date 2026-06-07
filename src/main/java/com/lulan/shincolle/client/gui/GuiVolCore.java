package com.lulan.shincolle.client.gui;

import com.lulan.shincolle.client.gui.inventory.ContainerVolCore;
import com.lulan.shincolle.network.C2SGUIInputPacket;
import com.lulan.shincolle.network.ModNetworking;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.tileentity.TileEntityVolCore;
import com.lulan.shincolle.utility.GuiHelper;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

/**
 * GUI screen for the volcanic core block.
 * Renders title, fuel bar, and power toggle button indicator.
 * Data is synced from server via ContainerData in ContainerVolCore.
 */
public class GuiVolCore extends AbstractContainerScreen<ContainerVolCore> {

    private static final ResourceLocation TEXTURE = new ResourceLocation("shincolle", "textures/gui/guivolcore.png");

    public GuiVolCore(ContainerVolCore menu, Inventory playerInv, Component title) {
        super(menu, playerInv, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        // Render background texture
        graphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

        // Draw power button indicator (top-left)
        int btnX = this.leftPos + 7;
        int btnY = this.topPos + 6;
        boolean active = this.menu.isBtnActive();
        boolean working = this.menu.isWorking();

        if (working) {
            // Bright green when actively working
            graphics.fill(btnX, btnY, btnX + 13, btnY + 13, 0xFF00FF00);
        } else if (active) {
            // Medium green when button is on but no fuel
            graphics.fill(btnX, btnY, btnX + 13, btnY + 13, 0xFF008800);
        } else {
            // Dim green when off
            graphics.fill(btnX, btnY, btnX + 13, btnY + 13, 0xFF005500);
        }

        // Draw fuel bar
        int barX = this.leftPos + 38;
        int barTopY = this.topPos + 28;
        int barBottomY = this.topPos + 59;
        int barWidth = 12;
        int maxBarHeight = 31;

        // Background for fuel bar (dark gray)
        graphics.fill(barX, barTopY, barX + barWidth, barBottomY, 0xFF303030);

        // Draw fuel fill (from bottom up)
        int fuelPercent = this.menu.getFuelPercent(); // 0-1000
        int fillHeight = fuelPercent * maxBarHeight / 1000;
        if (fillHeight > 0) {
            int fillColor = working ? 0xFF00CC00 : 0xFF008800;
            graphics.fill(barX, barBottomY - fillHeight, barX + barWidth, barBottomY, fillColor);
        }
    }

    @Override
    protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {
        // Draw block name centered at top
        String blockName = Component.translatable("container.shincolle.vol_core").getString();
        graphics.drawString(this.font, blockName,
                this.imageWidth / 2 - this.font.width(blockName) / 2, 6, 0x404040, false);

        // Draw fuel label near the fuel bar
        String fuelLabel = "Fuel";
        graphics.drawString(this.font, fuelLabel, 36, 62, 0x888888, false);

        // Draw power status text
        boolean active = this.menu.isBtnActive();
        boolean working = this.menu.isWorking();

        String powerStatus;
        int statusColor;
        if (working) {
            powerStatus = "Power: ON";
            statusColor = 0x00FF00;
        } else if (active) {
            powerStatus = "Power: NO FUEL";
            statusColor = 0xFFAA00;
        } else {
            powerStatus = "Power: OFF";
            statusColor = 0xAAAAAA;
        }
        graphics.drawString(this.font, powerStatus, 24, 8, statusColor, true);

        // Draw fuel percentage
        int fuelPercent = this.menu.getFuelPercent();
        String fuelStr = String.format("%.1f%%", fuelPercent / 10.0);
        graphics.drawString(this.font, fuelStr, 36, 72, 0x666666, false);

        // Player inventory label
        graphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 0x404040,
                false);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int mx = (int) mouseX - this.leftPos;
        int my = (int) mouseY - this.topPos;

        int btn = GuiHelper.getButton(6, 0, mx, my);
        if (btn >= 0) {
            TileEntityVolCore tile = this.menu.getTile();
            if (tile != null) {
                BlockPos pos = tile.getBlockPos();
                if (btn == ID.B.VolCore_Power) {
                    ModNetworking.sendToServer(new C2SGUIInputPacket(
                            C2SGUIInputPacket.TileBtn,
                            new int[]{0, pos.getX(), pos.getY(), pos.getZ(), ID.B.VolCore_Power, 0}));
                }
            }
            return true;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, partialTick);
        this.renderTooltip(graphics, mouseX, mouseY);
    }
}
