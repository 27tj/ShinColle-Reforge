package com.lulan.shincolle.client.gui;

import com.lulan.shincolle.client.gui.inventory.ContainerLargeShipyard;
import com.lulan.shincolle.network.C2SGUIInputPacket;
import com.lulan.shincolle.network.ModNetworking;
import com.lulan.shincolle.reference.Enums.EnumColors;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.tileentity.TileMultiGrudgeHeavy;
import com.lulan.shincolle.utility.GuiHelper;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

/**
 * GUI screen for the large shipyard block (Grudge Heavy multiblock).
 * Based on original GuiLargeShipyard.java.
 * <p>
 * SLOT POSITION:
 * output(168,51) fuel bar(9,83 height=63) fuel color bar(208,64)
 * ship button(157,24) equip button(177,24) inv(25,116)
 * player inv(25,141) action bar(24,199)
 */
public class GuiLargeShipyard extends AbstractContainerScreen<ContainerLargeShipyard> {

    private static final ResourceLocation TEXTURE = new ResourceLocation("shincolle",
            "textures/gui/guilargeshipyard.png");

    private final String errorMsg1;
    private final String errorMsg2;
    private float tickGUI;

    public GuiLargeShipyard(ContainerLargeShipyard menu, Inventory playerInv, Component title) {
        super(menu, playerInv, title);
        this.imageWidth = 208;
        this.imageHeight = 223;
        this.tickGUI = 0F;
        this.errorMsg1 = Component.translatable("gui.shincolle.nomaterial").getString();
        this.errorMsg2 = Component.translatable("gui.shincolle.nofuel").getString();
    }

    @Override
    protected void renderBg(GuiGraphics g, float partialTick, int mouseX, int mouseY) {
        // Background texture
        g.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

        // Fuel bar: textured vertical fill from bottom up at (9, 83)
        int fuelPercent = this.menu.getFuelPercent(); // 0-1000
        if (fuelPercent > 0) {
            int scaleBar = fuelPercent * 64 / 1000;
            g.blit(TEXTURE, this.leftPos + 9, this.topPos + 83 - scaleBar,
                    208, 64 - scaleBar, 12, scaleBar);
        }

        // Build type selection box overlay
        int buildType = this.menu.getBuildType();
        switch (buildType) {
            case 1: // SHIP
                g.blit(TEXTURE, this.leftPos + 157, this.topPos + 24, 208, 64, 18, 18);
                break;
            case 3: // SHIP_LOOP - animated
                int frame = ((int) tickGUI) % 6;
                g.blit(TEXTURE, this.leftPos + 157, this.topPos + 24,
                        208, 103 + frame * 18, 18, 18);
                break;
            case 2: // EQUIP
                g.blit(TEXTURE, this.leftPos + 177, this.topPos + 24, 208, 64, 18, 18);
                break;
            case 4: // EQUIP_LOOP - animated
                int frame2 = ((int) tickGUI) % 6;
                g.blit(TEXTURE, this.leftPos + 177, this.topPos + 24,
                        208, 103 + frame2 * 18, 18, 18);
                break;
        }

        // Material amount button overlay (48x30 box at selectMat row)
        int selectMat = this.menu.getSelectMat();
        g.blit(TEXTURE, this.leftPos + 50, this.topPos + 8 + selectMat * 19,
                0, 223, 48, 30);

        // Material selection box highlight (18x18 at selectMat row)
        g.blit(TEXTURE, this.leftPos + 27, this.topPos + 14 + selectMat * 19,
                208, 64, 18, 18);

        // Inventory mode button overlay (when mode=1/release, draw depressed state)
        int invMode = this.menu.getInvMode();
        if (invMode == 1) {
            g.blit(TEXTURE, this.leftPos + 23, this.topPos + 92, 208, 82, 25, 20);
        }
    }

    @Override
    protected void renderLabels(GuiGraphics g, int mouseX, int mouseY) {
        // Material build amounts (left column, centered at x=73)
        int[] rowY = {20, 39, 58, 77};
        for (int i = 0; i < 4; i++) {
            int buildVal = this.menu.getMatBuild(i);
            String buildStr = String.valueOf(buildVal);

            // Color: red if <100, yellow if ==1000, white otherwise
            int color;
            if (buildVal < 100)
                color = EnumColors.RED_LIGHT.getValue();
            else if (buildVal == 1000)
                color = EnumColors.YELLOW.getValue();
            else
                color = EnumColors.WHITE.getValue();

            g.drawString(this.font, buildStr,
                    73 - this.font.width(buildStr) / 2, rowY[i], color, false);
        }

        // Material stock amounts (right column, centered at x=125)
        for (int i = 0; i < 4; i++) {
            int stockVal = this.menu.getMatStock(i);
            String stockStr = String.valueOf(stockVal);
            g.drawString(this.font, stockStr,
                    125 - this.font.width(stockStr) / 2, rowY[i],
                    EnumColors.YELLOW.getValue(), false);
        }

        // Build countdown time (centered at x=176, y=77)
        int buildType = this.menu.getBuildType();
        int buildTime = this.menu.getBuildTimeSeconds();
        String time;
        if (buildTime > 0) {
            time = String.format("%d:%02d", buildTime / 60, buildTime % 60);
        } else {
            time = "0:00";
        }
        g.drawString(this.font, time,
                176 - this.font.width(time) / 2, 77,
                EnumColors.GRAY_MIDDLE.getValue(), false);

        // Error/hint messages (centered at x=105, y=99)
        if (buildType != 0) {
            // Check: if build type is set but no materials allocated or stock is
            // insufficient
            boolean noMaterials = true;
            boolean insufficientStock = false;
            for (int i = 0; i < 4; i++) {
                int buildVal = this.menu.getMatBuild(i);
                if (buildVal > 0) {
                    noMaterials = false;
                    if (buildVal > this.menu.getMatStock(i)) {
                        insufficientStock = true;
                    }
                }
            }
            int fuelPercent = this.menu.getFuelPercent();

            if (noMaterials || insufficientStock) {
                g.drawString(this.font, errorMsg1,
                        105 - this.font.width(errorMsg1) / 2, 99,
                        EnumColors.RED_LIGHT.getValue(), false);
            } else if (fuelPercent <= 0) {
                g.drawString(this.font, errorMsg2,
                        105 - this.font.width(errorMsg2) / 2, 99,
                        EnumColors.RED_LIGHT.getValue(), false);
            }
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) {
            int xClick = (int) mouseX - this.leftPos;
            int yClick = (int) mouseY - this.topPos;

            TileMultiGrudgeHeavy tile = this.menu.getTile();
            if (tile == null)
                return super.mouseClicked(mouseX, mouseY, button);

            BlockPos pos = tile.getBlockPos();
            int selectMat = this.menu.getSelectMat();

            // Page 0 buttons
            int btn = GuiHelper.getButton(ID.Gui.LARGESHIPYARD, 0, xClick, yClick);
            if (btn >= 0) {
                handleMainPageButton(btn, pos);
            }

            // Material increment/decrement page buttons (based on selectMat)
            int btn2 = GuiHelper.getButton(ID.Gui.LARGESHIPYARD, selectMat + 1, xClick, yClick);
            if (btn2 >= 0) {
                handleMaterialPageButton(btn2, pos, selectMat);
            }

            if (btn >= 0 || btn2 >= 0)
                return true;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    private void handleMainPageButton(int btn, BlockPos pos) {
        int buildType = this.menu.getBuildType();
        int invMode = this.menu.getInvMode();

        switch (btn) {
            case 0 -> {
                // Ship button: cycle NONE -> SHIP -> SHIP_LOOP -> NONE
                int newType = switch (buildType) {
                    case 0 -> 1;
                    case 1 -> 3;
                    case 3 -> 0;
                    default -> 1;
                };
                sendTileBtn(pos, ID.B.Shipyard_Type, newType);
            }
            case 1 -> {
                // Equip button: cycle NONE -> EQUIP -> EQUIP_LOOP -> NONE
                int newType = switch (buildType) {
                    case 0 -> 2;
                    case 2 -> 4;
                    case 4 -> 0;
                    default -> 2;
                };
                sendTileBtn(pos, ID.B.Shipyard_Type, newType);
            }
            case 2 -> {
                // Inventory mode toggle
                sendTileBtn(pos, ID.B.Shipyard_InvMode, invMode == 0 ? 1 : 0);
            }
            case 3, 4, 5, 6 -> {
                // Material type icon clicked -> select material
                int matIndex = btn - 3;
                sendTileBtn(pos, ID.B.Shipyard_SelectMat, matIndex);
            }
            case 7, 8, 9, 10 -> {
                // Material number text clicked -> select material
                int matIndex = btn - 7;
                sendTileBtn(pos, ID.B.Shipyard_SelectMat, matIndex);
            }
        }
    }

    private void handleMaterialPageButton(int btn, BlockPos pos, int selectMat) {
        // btn 0-7: +1000, +100, +10, +1, -1000, -100, -10, -1
        int[] deltas = {1000, 100, 10, 1, -1000, -100, -10, -1};
        if (btn >= 0 && btn < deltas.length) {
            sendTileBtn(pos, ID.B.Shipyard_INCDEC, deltas[btn]);
        }
    }

    private void sendTileBtn(BlockPos pos, int buttonId, int value) {
        ModNetworking.sendToServer(new C2SGUIInputPacket(
                C2SGUIInputPacket.TileBtn,
                new int[]{0, pos.getX(), pos.getY(), pos.getZ(), buttonId, value}));
    }

    @Override
    public void render(GuiGraphics g, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(g);
        super.render(g, mouseX, mouseY, partialTick);
        this.renderTooltip(g, mouseX, mouseY);

        // Advance tickGUI for animation
        tickGUI += 0.125F;

        // Fuel tooltip on hover (fuel bar region: 8 < x < 22, 19 < y < 84)
        int localX = mouseX - this.leftPos;
        int localY = mouseY - this.topPos;
        if (localX > 8 && localX < 22 && localY > 19 && localY < 84) {
            int fuelPct = this.menu.getFuelPercent();
            String fuelText = String.format("Fuel: %.1f%%", fuelPct / 10.0);
            g.renderTooltip(this.font, Component.literal(fuelText), mouseX, mouseY);
        }
    }
}
