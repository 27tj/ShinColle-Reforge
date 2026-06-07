package com.lulan.shincolle.client.gui;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.capability.CapaTeitokuProvider;
import com.lulan.shincolle.client.gui.inventory.ContainerFormation;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.network.C2SGUIInputPacket;
import com.lulan.shincolle.network.ModNetworking;
import com.lulan.shincolle.utility.FormationHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import org.lwjgl.glfw.GLFW;

/**
 * GUI screen for the fleet formation interface.
 * Reads team/formation data from client-side CapaTeitoku capability.
 * Sends formation changes to server via C2SGUIInputPacket.
 */
public class GuiFormation extends AbstractContainerScreen<ContainerFormation> {

    private static final ResourceLocation TEXTURE = new ResourceLocation("shincolle", "textures/gui/guiformation.png");

    /**
     * Formation type names
     */
    private static final String[] FORMATION_NAMES = {
            "None", "Line Ahead", "Double Line", "Diamond", "Echelon", "Line Abreast"
    };

    /**
     * Attribute labels for formation buff display
     */
    private static final String[] ATTR_LABELS = {"ATK(L)", "ATK(H)", "DEF", "SPD", "CRI", "DODGE"};
    private static final int[] ATTR_COLORS = {0xFFFF4444, 0xFF44FF44, 0xFFFFFFFF, 0xFFFFFFFF, 0xFF44FFFF, 0xFFFFCC00};
    /**
     * Indices into FormationHelper result array for the 6 displayed attributes
     */
    private static final int[] ATTR_INDICES = {0, 1, 2, 3, 8, 9};

    /**
     * Currently selected team (0-8)
     */
    private int teamClicked = 0;
    /**
     * Currently selected ship slot (0-5)
     */
    private int listClicked = 0;
    /**
     * Last clicked ship slot index for double-click detection
     */
    private int lastSlotClicked = -1;
    /**
     * Last click timestamp (ms) for ship-slot double-click detection
     */
    private long lastSlotClickTime = 0L;
    /**
     * Team name rename input field (legacy formation GUI behavior)
     */
    private EditBox unitNameField;
    /**
     * True while editing team name
     */
    private boolean renamingTeamName = false;

    public GuiFormation(ContainerFormation menu, Inventory playerInv, Component title) {
        super(menu, playerInv, title);
        this.imageWidth = 256;
        this.imageHeight = 192;
    }

    @Override
    protected void init() {
        super.init();
        // Initialize selected team from capability
        CapaTeitoku capa = getCapaTeitoku();
        if (capa != null) {
            this.teamClicked = capa.getSelectTeam();
        }

        this.unitNameField = new EditBox(this.font, this.leftPos + 100, this.topPos + 180, 150, 12, Component.empty());
        this.unitNameField.setMaxLength(64);
        this.unitNameField.setVisible(false);
        this.unitNameField.setFocused(false);
        this.addRenderableWidget(this.unitNameField);
    }

    @Override
    public void containerTick() {
        super.containerTick();
        if (this.unitNameField != null) {
            this.unitNameField.tick();
        }
    }

    private CapaTeitoku getCapaTeitoku() {
        Player player = Minecraft.getInstance().player;
        if (player == null)
            return null;
        return player.getCapability(CapaTeitokuProvider.CAPABILITY).orElse(null);
    }

    private int getFormationID() {
        CapaTeitoku capa = getCapaTeitoku();
        if (capa == null)
            return 0;
        return capa.getFormatID(teamClicked);
    }

    private String getShipName(int team, int slot) {
        CapaTeitoku capa = getCapaTeitoku();
        if (capa == null)
            return "(Empty)";

        int shipUID = capa.getTeamMember(team, slot);
        if (shipUID <= 0)
            return "(Empty)";

        // Try to find the entity in the client world using runtime entity ID
        Player player = Minecraft.getInstance().player;
        if (player != null) {
            int entityId = capa.getTeamSID(team, slot);
            if (entityId > 0) {
                Entity entity = player.level().getEntity(entityId);
                if (entity instanceof BasicEntityShip ship) {
                    return ship.getDisplayName().getString();
                }
            }
        }

        // Entity not loaded - show persistent ship UID
        return "Ship #" + shipUID;
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        // Render background texture
        graphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

        int formatID = getFormationID();

        // Draw ship slot list background (6 ship slots on the right side)
        for (int i = 0; i < 6; i++) {
            int slotY = this.topPos + 5 + i * 27;
            int slotX = this.leftPos + 142;

            if (i == this.listClicked) {
                // Highlighted slot
                graphics.fill(slotX, slotY, slotX + 108, slotY + 25, 0x44FFFFFF);
            }
        }

        // Draw team selector buttons (at bottom, 9 team buttons)
        for (int i = 0; i < 9; i++) {
            int btnX = this.leftPos + 18 + i * 12;
            int btnY = this.topPos + 167;
            int btnColor = (i == this.teamClicked) ? 0xCCFFFF00 : 0x88888888;
            graphics.fill(btnX, btnY, btnX + 9, btnY + 11, btnColor);
        }

        // Draw formation type buttons (above team buttons, 6 formation types)
        for (int i = 0; i < 6; i++) {
            int btnX = this.leftPos + 18 + i * 18;
            int btnY = this.topPos + 149;
            int btnColor = (i == formatID) ? 0xCC00CCFF : 0x88555555;
            graphics.fill(btnX, btnY, btnX + 15, btnY + 15, btnColor);
        }

        // Draw formation position spots (in the upper left area)
        int spotAreaX = this.leftPos + 10;
        int spotAreaY = this.topPos + 10;
        CapaTeitoku capa = getCapaTeitoku();
        for (int i = 0; i < 6; i++) {
            int spotX = spotAreaX + 25 + (i % 3) * 15;
            int spotY = spotAreaY + 15 + (i / 3) * 20;

            // Check if slot has a ship
            boolean hasShip = capa != null && capa.getTeamMember(teamClicked, i) > 0;
            int spotColor;
            if (i == this.listClicked) {
                spotColor = 0xFFFFFF00; // Yellow for selected
            } else if (hasShip) {
                spotColor = 0xFF00AAFF; // Blue for occupied
            } else {
                spotColor = 0xFF555555; // Gray for empty
            }
            graphics.fill(spotX - 2, spotY - 2, spotX + 3, spotY + 3, spotColor);
        }
    }

    @Override
    protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {
        CapaTeitoku capa = getCapaTeitoku();
        int formatID = getFormationID();

        // Draw team name / unit name centered
        String unitName;
        if (capa != null) {
            unitName = "\"" + capa.getUnitName(teamClicked) + "\"";
        } else {
            unitName = "\"Team " + (teamClicked + 1) + "\"";
        }
        graphics.drawString(this.font, unitName, 100, 182, 0xFFFF00, true);

        // Draw formation type name
        String formatName = (formatID >= 0 && formatID < FORMATION_NAMES.length)
                ? FORMATION_NAMES[formatID]
                : "Unknown";
        graphics.drawString(this.font, formatName,
                80 - this.font.width(formatName) / 2, 140, 0x00CCFF, true);

        // Draw ship slot list (6 slots on the right)
        for (int i = 0; i < 6; i++) {
            int textY = 9 + i * 27;
            String slotLabel = "Slot " + (i + 1);
            int slotColor = (i == this.listClicked) ? 0xFFFFFF : 0xAAAAAA;

            // Slot number
            graphics.drawString(this.font, slotLabel, 148, textY, slotColor, true);

            // Ship name from capability data
            String shipName = getShipName(teamClicked, i);
            boolean isEmpty = shipName.equals("(Empty)");
            graphics.drawString(this.font, shipName, 148, textY + 10,
                    isEmpty ? 0x666666 : 0x55FF55, true);
        }

        // Draw formation buff header
        String fpHeader = "Formation Buffs";
        graphics.drawString(this.font, fpHeader, 10, 40, 0xCC88FF, true);

        // Draw attribute buff bars with real values from FormationHelper
        float[] buffs = FormationHelper.getFormationBuffValue(formatID, listClicked);
        int barStartY = 54;
        for (int i = 0; i < ATTR_LABELS.length; i++) {
            int barY = barStartY + i * 15;
            int labelX = 9;

            // Label
            graphics.drawString(this.font, ATTR_LABELS[i], labelX, barY, ATTR_COLORS[i], true);

            int barBgX = labelX + 40;

            // Background bar
            graphics.fill(barBgX, barY + 1, barBgX + 60, barY + 7, 0xFF333333);

            // Buff value fill (center at 30 pixels = 1.0x multiplier)
            if (buffs != null && ATTR_INDICES[i] < buffs.length) {
                float buffVal = buffs[ATTR_INDICES[i]];
                int fillWidth = (int) (buffVal * 30);
                fillWidth = Math.max(0, Math.min(fillWidth, 60));
                if (fillWidth > 0) {
                    int fillColor = buffVal >= 1.0f ? 0xFF00CC00 : 0xFFCC0000;
                    graphics.fill(barBgX, barY + 1, barBgX + fillWidth, barY + 7, fillColor);
                }

                // Show numeric value
                String valStr = String.format("%.0f%%", buffVal * 100);
                graphics.drawString(this.font, valStr, barBgX + 62, barY, 0xCCCCCC, true);
            }
        }

        // Draw team buttons labels
        for (int i = 0; i < 9; i++) {
            int btnX = 18 + i * 12;
            String teamNum = String.valueOf(i + 1);
            int numColor = (i == this.teamClicked) ? 0xFFFFFF : 0x888888;
            graphics.drawString(this.font, teamNum, btnX + 2, 169, numColor, true);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int mx = (int) mouseX - this.leftPos;
        int my = (int) mouseY - this.topPos;

        if (this.renamingTeamName && this.unitNameField != null
                && this.unitNameField.mouseClicked(mouseX, mouseY, button)) {
            return true;
        }

        // Handle ship slot clicks (right side, 6 slots)
        if (mx >= 142 && mx <= 250) {
            for (int i = 0; i < 6; i++) {
                int slotY = 5 + i * 27;
                if (my >= slotY && my <= slotY + 25) {
                    handleShipSlotClick(i);
                    return true;
                }
            }
        }

        // Handle team button clicks
        for (int i = 0; i < 9; i++) {
            int btnX = 18 + i * 12;
            int btnY = 167;
            if (mx >= btnX && mx <= btnX + 9 && my >= btnY && my <= btnY + 11) {
                if (this.renamingTeamName) {
                    return true;
                }
                this.teamClicked = i;
                this.listClicked = 0;
                Player player = Minecraft.getInstance().player;
                if (player != null) {
                    // [PORT] 1.10.2 -> 1.20.1: keep server-selected team in sync with formation GUI
                    // selection.
                    ModNetworking.sendToServer(new C2SGUIInputPacket(
                            C2SGUIInputPacket.SetSelect,
                            new int[]{player.getId(), 0, i}));
                }
                // Update local capability
                CapaTeitoku capa = getCapaTeitoku();
                if (capa != null) {
                    capa.setSelectTeam(i);
                }
                return true;
            }
        }

        // Handle rename unit name button (legacy button area)
        if (mx >= 46 && mx <= 94 && my >= 180 && my <= 192) {
            if (!this.renamingTeamName) {
                startRenameTeamName();
            } else {
                submitRenameTeamName();
            }
            return true;
        }

        // Handle formation ship order buttons (legacy UP/DOWN controls)
        if (mx >= 159 && mx <= 189 && my >= 170 && my <= 180) {
            swapSelectedShip(false);
            return true;
        }
        if (mx >= 203 && mx <= 233 && my >= 170 && my <= 180) {
            swapSelectedShip(true);
            return true;
        }

        // Handle formation type button clicks
        for (int i = 0; i < 6; i++) {
            int btnX = 18 + i * 18;
            int btnY = 149;
            if (mx >= btnX && mx <= btnX + 15 && my >= btnY && my <= btnY + 15) {
                // Send formation change to server
                Player player = Minecraft.getInstance().player;
                ModNetworking.sendToServer(new C2SGUIInputPacket(
                        C2SGUIInputPacket.SetFormation,
                        new int[]{player != null ? player.getId() : 0, teamClicked, i}));
                // Update local capability
                CapaTeitoku capa = getCapaTeitoku();
                if (capa != null) {
                    capa.setFormatID(teamClicked, i);
                }
                return true;
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (this.renamingTeamName) {
            if (keyCode == GLFW.GLFW_KEY_ENTER || keyCode == GLFW.GLFW_KEY_KP_ENTER) {
                submitRenameTeamName();
                return true;
            }
            if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
                cancelRenameTeamName();
                return true;
            }
            if (this.unitNameField != null && this.unitNameField.keyPressed(keyCode, scanCode, modifiers)) {
                return true;
            }
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean charTyped(char codePoint, int modifiers) {
        if (this.renamingTeamName && this.unitNameField != null) {
            return this.unitNameField.charTyped(codePoint, modifiers);
        }
        return super.charTyped(codePoint, modifiers);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, partialTick);
        this.renderTooltip(graphics, mouseX, mouseY);
    }

    private void handleShipSlotClick(int slot) {
        this.listClicked = slot;

        long now = System.currentTimeMillis();
        if (slot == this.lastSlotClicked && (now - this.lastSlotClickTime) <= 250L) {
            openSelectedShipGui();
        }

        this.lastSlotClicked = slot;
        this.lastSlotClickTime = now;
    }

    private void openSelectedShipGui() {
        Player player = Minecraft.getInstance().player;
        CapaTeitoku capa = getCapaTeitoku();
        if (player == null || capa == null) {
            return;
        }

        int sid = capa.getTeamSID(this.teamClicked, this.listClicked);
        if (sid <= 0) {
            return;
        }

        ModNetworking.sendToServer(new C2SGUIInputPacket(
                C2SGUIInputPacket.OpenShipGUI,
                new int[]{player.getId(), 0, sid}));
    }

    private void swapSelectedShip(boolean moveUp) {
        Player player = Minecraft.getInstance().player;
        CapaTeitoku capa = getCapaTeitoku();
        if (player == null || capa == null) {
            return;
        }

        int current = this.listClicked;
        int target = moveUp ? (current <= 0 ? 5 : current - 1) : (current >= 5 ? 0 : current + 1);

        ModNetworking.sendToServer(new C2SGUIInputPacket(
                C2SGUIInputPacket.SwapShip,
                new int[]{player.getId(), 0, current, target}));

        // Client-side optimistic swap so UI responds immediately before server sync
        // packet arrives.
        int currentMember = capa.getTeamMember(this.teamClicked, current);
        int currentSid = capa.getTeamSID(this.teamClicked, current);
        capa.setTeamMember(this.teamClicked, current, capa.getTeamMember(this.teamClicked, target));
        capa.setTeamSID(this.teamClicked, current, capa.getTeamSID(this.teamClicked, target));
        capa.setTeamMember(this.teamClicked, target, currentMember);
        capa.setTeamSID(this.teamClicked, target, currentSid);

        this.listClicked = target;
    }

    private void startRenameTeamName() {
        CapaTeitoku capa = getCapaTeitoku();
        if (this.unitNameField == null || capa == null) {
            return;
        }

        this.renamingTeamName = true;
        this.unitNameField.setVisible(true);
        this.unitNameField.setFocused(true);
        this.unitNameField.setValue(capa.getUnitName(this.teamClicked));
        this.unitNameField.setCursorPosition(this.unitNameField.getValue().length());
        this.setFocused(this.unitNameField);
    }

    private void submitRenameTeamName() {
        CapaTeitoku capa = getCapaTeitoku();
        Player player = Minecraft.getInstance().player;
        if (!this.renamingTeamName || this.unitNameField == null || capa == null || player == null) {
            cancelRenameTeamName();
            return;
        }

        String newName = this.unitNameField.getValue().trim();
        if (!newName.isEmpty()) {
            ModNetworking.sendToServer(new C2SGUIInputPacket(
                    C2SGUIInputPacket.SetUnitName,
                    new int[]{player.getId(), 0, this.teamClicked},
                    newName));
            capa.setUnitName(this.teamClicked, newName);
        }

        cancelRenameTeamName();
    }

    private void cancelRenameTeamName() {
        this.renamingTeamName = false;
        if (this.unitNameField != null) {
            this.unitNameField.setFocused(false);
            this.unitNameField.setVisible(false);
        }
        this.setFocused(null);
    }
}
