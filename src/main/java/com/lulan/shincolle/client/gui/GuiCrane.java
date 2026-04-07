package com.lulan.shincolle.client.gui;

import com.lulan.shincolle.client.gui.inventory.ContainerCrane;
import com.lulan.shincolle.network.C2SGUIInputPacket;
import com.lulan.shincolle.network.ModNetworking;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.tileentity.TileEntityCrane;
import com.lulan.shincolle.utility.GuiHelper;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

/**
 * GUI screen for the crane block.
 * Renders mode labels, loading/unloading filter sections, ship info,
 * and toggle button states.
 * Data is synced from server via ContainerData in ContainerCrane.
 */
public class GuiCrane extends AbstractContainerScreen<ContainerCrane> {

    private static final ResourceLocation TEXTURE = new ResourceLocation("shincolle", "textures/gui/guicrane.png");

    public GuiCrane(ContainerCrane menu, Inventory playerInv, Component title) {
        super(menu, playerInv, title);
        this.imageWidth = 176;
        this.imageHeight = 204;
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        // Render background texture
        graphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

        // Draw power indicator (top-left)
        int powerX = this.leftPos + 7;
        int powerY = this.topPos + 6;
        boolean active = this.menu.isActive();
        boolean paired = this.menu.isPaired();

        if (active && paired) {
            // Bright green when active and paired
            graphics.fill(powerX, powerY, powerX + 13, powerY + 13, 0xFF00FF00);
        } else if (active) {
            // Medium green when active but not paired
            graphics.fill(powerX, powerY, powerX + 13, powerY + 13, 0xFF008800);
        } else {
            // Dim green when off
            graphics.fill(powerX, powerY, powerX + 13, powerY + 13, 0xFF005500);
        }

        // Draw loading section header bar
        int loadBarX = this.leftPos + 17;
        int loadBarY = this.topPos + 52;
        boolean enabLoad = this.menu.isEnabLoad();
        graphics.fill(loadBarX, loadBarY, loadBarX + 140, loadBarY + 1,
                enabLoad ? 0xFFAA4444 : 0xFF884444);

        // Draw unloading section header bar
        int unloadBarY = this.topPos + 83;
        boolean enabUnload = this.menu.isEnabUnload();
        graphics.fill(loadBarX, unloadBarY, loadBarX + 140, unloadBarY + 1,
                enabUnload ? 0xFF4444AA : 0xFF444488);
    }

    @Override
    protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {
        // Draw wait mode display (centered at top)
        int craneMode = this.menu.getCraneMode();
        String modeStr;
        if (craneMode >= 0 && craneMode < TileEntityCrane.MODE_NAMES.length) {
            modeStr = TileEntityCrane.MODE_NAMES[craneMode];
        } else {
            modeStr = "Unknown";
        }
        int modeLen = this.font.width(modeStr) / 2;
        graphics.drawString(this.font, modeStr, 57 - modeLen, 9, 0xFFFF00, true);

        // Draw section labels
        boolean enabLoad = this.menu.isEnabLoad();
        boolean enabUnload = this.menu.isEnabUnload();

        // Loading section label
        String loadLabel = "To Ship";
        graphics.drawString(this.font, loadLabel, 21, 54,
                enabLoad ? 0xFF5555 : 0x885555, false);

        // Unloading section label
        String unloadLabel = "To Chest";
        graphics.drawString(this.font, unloadLabel, 21, 85,
                enabUnload ? 0x5555FF : 0x404040, false);

        // Draw filter toggle labels with active/inactive colors
        boolean checkMeta = this.menu.isCheckMetadata();
        boolean checkNbt = this.menu.isCheckNbt();

        graphics.drawString(this.font, "Meta", 23, 34,
                checkMeta ? 0x00FF00 : 0x888888, true);
        graphics.drawString(this.font, "NBT", 51, 34,
                checkNbt ? 0x00FF00 : 0x888888, true);

        // Draw ship info area (right side)
        boolean active = this.menu.isActive();
        boolean paired = this.menu.isPaired();

        // Status indicator
        String statusStr;
        int statusColor;
        if (active && paired) {
            statusStr = "Active";
            statusColor = 0x00FF00;
        } else if (active) {
            statusStr = "No Chest";
            statusColor = 0xFFAA00;
        } else {
            statusStr = "Inactive";
            statusColor = 0x888888;
        }
        graphics.drawString(this.font, statusStr, 80, 24, statusColor, true);

        // Paired status
        String pairedStr = paired ? "Paired" : "Not Paired";
        graphics.drawString(this.font, pairedStr, 80, 34,
                paired ? 0x55FF55 : 0x555555, true);

        // Draw 3x3 grid labels for loading filters
        String loadFilterLabel = "Loading Filters";
        graphics.drawString(this.font, loadFilterLabel, 17, 62, 0xAA5555, true);

        // Draw 3x3 grid labels for unloading filters
        String unloadFilterLabel = "Unloading Filters";
        graphics.drawString(this.font, unloadFilterLabel, 107, 62, 0x5555AA, true);

        // Player inventory label
        graphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 0x404040,
                false);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int mx = (int) mouseX - this.leftPos;
        int my = (int) mouseY - this.topPos;

        int btn = GuiHelper.getButton(5, 0, mx, my);
        if (btn >= 0) {
            TileEntityCrane tile = this.menu.getTile();
            if (tile != null) {
                BlockPos pos = tile.getBlockPos();
                int buttonId = btn; // GuiHelper button indices map directly to ID.B.Crane_* values
                int value = 0;

                // For mode button, cycle through modes
                if (btn == ID.B.Crane_Mode) {
                    int currentMode = this.menu.getCraneMode();
                    value = (currentMode + 1) % TileEntityCrane.MODE_NAMES.length;
                }

                sendTileBtn(pos, buttonId, value);
            }
            return true;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    private void sendTileBtn(BlockPos pos, int buttonId, int value) {
        ModNetworking.sendToServer(new C2SGUIInputPacket(
                C2SGUIInputPacket.TileBtn,
                new int[] { 0, pos.getX(), pos.getY(), pos.getZ(), buttonId, value }));
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, partialTick);
        this.renderTooltip(graphics, mouseX, mouseY);
    }
}
