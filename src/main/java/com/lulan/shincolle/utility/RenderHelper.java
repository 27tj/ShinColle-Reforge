package com.lulan.shincolle.utility;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * HUD overlay rendering utility for ShinColle.
 * Handles drawing skill icons, cooldown indicators, and other HUD elements
 * when the player is riding a ship entity (mount mode).
 * <p>
 * In 1.20.1 Forge, HUD overlays are registered via RenderGuiOverlayEvent.
 * The actual event registration will be handled in ClientSetup or a dedicated
 * event handler class.
 */
@OnlyIn(Dist.CLIENT)
public class RenderHelper {

    // GUI texture atlas for HUD elements (icons, skill indicators, etc.)
    private static final ResourceLocation HUD_ICONS = new ResourceLocation(Reference.MOD_ID,
            "textures/gui/guihud.png");
    private static final ResourceLocation SKILL_ICONS = new ResourceLocation(Reference.MOD_ID,
            "textures/gui/guihud.png");

    // Dimensions for HUD elements
    private static final int SKILL_ICON_SIZE = 18;
    private static final int BAR_WIDTH = 80;
    private static final int BAR_HEIGHT = 4;
    private static final int BAR_GAP = 2;

    // Colors (ARGB format)
    private static final int COLOR_BAR_BG = 0xFF333333;
    private static final int COLOR_HP_HIGH = 0xFF00FF00; // green: > 50%
    private static final int COLOR_HP_MED = 0xFFFFFF00; // yellow: 25%-50%
    private static final int COLOR_HP_LOW = 0xFFFF0000; // red: < 25%
    private static final int COLOR_FUEL = 0xFF3399FF; // blue
    private static final int COLOR_AMMO_TEXT = 0xFFFFFFFF; // white
    private static final int COLOR_AMMO_LOW = 0xFFFF6666; // light red
    private static final int COLOR_RETICLE = 0xCCFFFFFF; // semi-transparent white
    private static final int COLOR_COOLDOWN_OVERLAY = 0x80000000; // semi-transparent black
    private static final int COLOR_SKILL_PLACEHOLDER = 0xFF5577AA; // blue-grey placeholder

    /**
     * Draw the ship HP/fuel bar overlay on the HUD.
     *
     * @param graphics the GuiGraphics context for rendering
     * @param x        screen X position
     * @param y        screen Y position
     * @param hp       current HP value
     * @param maxHp    maximum HP value
     * @param fuel     current fuel value
     * @param maxFuel  maximum fuel value
     */
    public static void drawShipStatusBar(GuiGraphics graphics, int x, int y,
                                         float hp, float maxHp, float fuel, float maxFuel) {

        // HP bar background
        graphics.fill(x, y, x + BAR_WIDTH, y + BAR_HEIGHT, COLOR_BAR_BG);

        // HP bar foreground with color based on percentage
        float hpPct = maxHp > 0 ? Math.min(hp / maxHp, 1.0f) : 0;
        int hpColor;
        if (hpPct > 0.5f) {
            hpColor = COLOR_HP_HIGH;
        } else if (hpPct > 0.25f) {
            hpColor = COLOR_HP_MED;
        } else {
            hpColor = COLOR_HP_LOW;
        }
        int hpBarWidth = (int) (BAR_WIDTH * hpPct);
        if (hpBarWidth > 0) {
            graphics.fill(x, y, x + hpBarWidth, y + BAR_HEIGHT, hpColor);
        }

        // Fuel bar (below HP bar)
        int fuelY = y + BAR_HEIGHT + BAR_GAP;
        graphics.fill(x, fuelY, x + BAR_WIDTH, fuelY + BAR_HEIGHT, COLOR_BAR_BG);

        float fuelPct = maxFuel > 0 ? Math.min(fuel / maxFuel, 1.0f) : 0;
        int fuelBarWidth = (int) (BAR_WIDTH * fuelPct);
        if (fuelBarWidth > 0) {
            graphics.fill(x, fuelY, x + fuelBarWidth, fuelY + BAR_HEIGHT, COLOR_FUEL);
        }
    }

    /**
     * Draw the ammunition counter overlay.
     *
     * @param graphics the GuiGraphics context for rendering
     * @param x        screen X position
     * @param y        screen Y position
     * @param ammo     current ammunition count
     * @param maxAmmo  maximum ammunition count
     */
    public static void drawAmmoCounter(GuiGraphics graphics, int x, int y, int ammo, int maxAmmo) {
        Font font = Minecraft.getInstance().font;
        String ammoText = ammo + " / " + maxAmmo;

        // Use red text when ammo is low (below 20% of max)
        int textColor = (maxAmmo > 0 && ammo <= maxAmmo * 0.2f) ? COLOR_AMMO_LOW : COLOR_AMMO_TEXT;

        // Draw shadow text for readability
        graphics.drawString(font, ammoText, x + 1, y + 1, 0xFF000000, false);
        graphics.drawString(font, ammoText, x, y, textColor, false);
    }

    /**
     * Draw a targeting reticle at the center of the screen when in mount attack
     * mode. Uses simple crosshair lines drawn with fill rectangles.
     *
     * @param graphics     the GuiGraphics context for rendering
     * @param screenWidth  screen width in pixels
     * @param screenHeight screen height in pixels
     */
    public static void drawTargetReticle(GuiGraphics graphics, int screenWidth, int screenHeight) {
        int cx = screenWidth / 2;
        int cy = screenHeight / 2;

        int reticleLength = 8;
        int reticleGap = 3;
        int thickness = 1;

        // Horizontal left line
        graphics.fill(cx - reticleGap - reticleLength, cy, cx - reticleGap, cy + thickness, COLOR_RETICLE);
        // Horizontal right line
        graphics.fill(cx + reticleGap, cy, cx + reticleGap + reticleLength, cy + thickness, COLOR_RETICLE);
        // Vertical top line
        graphics.fill(cx, cy - reticleGap - reticleLength, cx + thickness, cy - reticleGap, COLOR_RETICLE);
        // Vertical bottom line
        graphics.fill(cx, cy + reticleGap, cx + thickness, cy + reticleGap + reticleLength, COLOR_RETICLE);

        // Center dot
        graphics.fill(cx, cy, cx + thickness, cy + thickness, COLOR_RETICLE);
    }

    /**
     * Draw a player skill icon at the specified screen position.
     * Used when the player is riding a ship in mount mode.
     * Renders from SKILL_ICONS texture atlas if available, otherwise
     * draws a placeholder colored square.
     *
     * @param graphics the GuiGraphics context for rendering
     * @param x        screen X position
     * @param y        screen Y position
     */
    public static void drawPlayerSkillIcon(GuiGraphics graphics, int x, int y) {
        // Draw placeholder colored square as skill icon
        // Outer border (darker)
        graphics.fill(x, y, x + SKILL_ICON_SIZE, y + SKILL_ICON_SIZE, 0xFF222222);
        // Inner fill
        graphics.fill(x + 1, y + 1, x + SKILL_ICON_SIZE - 1, y + SKILL_ICON_SIZE - 1,
                COLOR_SKILL_PLACEHOLDER);
        // Highlight edge (top and left) for slight 3D effect
        graphics.fill(x + 1, y + 1, x + SKILL_ICON_SIZE - 1, y + 2, 0xFF7799CC);
        graphics.fill(x + 1, y + 1, x + 2, y + SKILL_ICON_SIZE - 1, 0xFF7799CC);
    }

    /**
     * Draw a player skill icon with a specific skill index.
     * The skill index determines which sub-icon to draw from the atlas.
     *
     * @param graphics   the GuiGraphics context for rendering
     * @param x          screen X position
     * @param y          screen Y position
     * @param skillIndex the skill index (determines icon appearance)
     */
    public static void drawPlayerSkillIcon(GuiGraphics graphics, int x, int y, int skillIndex) {
        // Draw base icon
        drawPlayerSkillIcon(graphics, x, y);

        // Draw skill number indicator inside the icon
        Font font = Minecraft.getInstance().font;
        String label = String.valueOf(skillIndex + 1);
        int textX = x + (SKILL_ICON_SIZE - font.width(label)) / 2;
        int textY = y + (SKILL_ICON_SIZE - font.lineHeight) / 2 + 1;
        graphics.drawString(font, label, textX, textY, 0xFFFFFFFF, false);
    }

    /**
     * Draw a cooldown overlay on a skill icon.
     * Renders a semi-transparent dark rectangle that shrinks from top to bottom
     * as the cooldown progresses.
     *
     * @param graphics    the GuiGraphics context for rendering
     * @param x           screen X position
     * @param y           screen Y position
     * @param cooldownPct cooldown percentage (0.0 = ready, 1.0 = full cooldown)
     */
    public static void drawCooldownOverlay(GuiGraphics graphics, int x, int y, float cooldownPct) {
        if (cooldownPct <= 0.0f)
            return;

        cooldownPct = Math.min(cooldownPct, 1.0f);

        // Draw semi-transparent overlay from top, height proportional to cooldown
        // remaining
        int overlayHeight = (int) (SKILL_ICON_SIZE * cooldownPct);
        if (overlayHeight > 0) {
            graphics.fill(x, y, x + SKILL_ICON_SIZE, y + overlayHeight, COLOR_COOLDOWN_OVERLAY);
        }
    }
}
