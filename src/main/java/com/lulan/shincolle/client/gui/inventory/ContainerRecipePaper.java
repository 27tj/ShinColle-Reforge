package com.lulan.shincolle.client.gui.inventory;

import com.lulan.shincolle.init.ModMenuTypes;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/**
 * Container/Menu for Recipe Paper item.
 * 9 ghost crafting pattern slots + 1 result display slot + player inventory.
 * Ghost slots use custom click handling: clicking with an item sets the
 * pattern,
 * clicking with empty hand clears it.
 * The recipe pattern is stored in the Recipe Paper item's NBT.
 */
public class ContainerRecipePaper extends AbstractContainerMenu {

    public static final int CRAFTING_SLOT_COUNT = 9;
    public static final int RESULT_SLOT = 9;
    public static final int GHOST_SLOT_COUNT = 10;

    private final SimpleContainer recipeInv;
    private final int heldSlot;

    /**
     * Client-side constructor (from network)
     */
    public ContainerRecipePaper(int containerId, Inventory playerInv, FriendlyByteBuf buf) {
        this(containerId, playerInv, buf.readInt());
    }

    /**
     * Server-side constructor
     */
    public ContainerRecipePaper(int containerId, Inventory playerInv, int heldSlot) {
        super(ModMenuTypes.RECIPE_PAPER.get(), containerId);
        this.heldSlot = heldSlot;
        this.recipeInv = new SimpleContainer(GHOST_SLOT_COUNT);

        // Crafting pattern slots (0-8): 3x3 grid
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                addSlot(new SlotRecipePaper(recipeInv, row * 3 + col,
                        30 + col * 18, 17 + row * 18));
            }
        }

        // Result display slot (9)
        addSlot(new SlotRecipePaper(recipeInv, RESULT_SLOT, 124, 35));

        // Player inventory
        addPlayerInventory(playerInv, 8, 84);
    }

    protected void addPlayerInventory(Inventory inv, int x, int y) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                addSlot(new Slot(inv, 9 + row * 9 + col, x + col * 18, y + row * 18));
            }
        }
        for (int col = 0; col < 9; col++) {
            addSlot(new Slot(inv, col, x + col * 18, y + 58));
        }
    }

    /**
     * Custom click handling for ghost recipe slots.
     * Ghost slots: set pattern to a copy of the carried item, or clear if empty
     * hand.
     */
    @Override
    public void clicked(int slotId, int button, ClickType clickType, Player player) {
        if (slotId >= 0 && slotId < GHOST_SLOT_COUNT) {
            // Only allow editing crafting slots (0-8), not the result slot
            if (slotId < CRAFTING_SLOT_COUNT) {
                Slot slot = this.slots.get(slotId);
                ItemStack carried = getCarried();

                if (carried.isEmpty()) {
                    // Clear the pattern slot
                    slot.set(ItemStack.EMPTY);
                } else {
                    // Set pattern to a single copy of the carried item
                    ItemStack patternItem = carried.copy();
                    patternItem.setCount(1);
                    slot.set(patternItem);
                }
            }
            return;
        }
        super.clicked(slotId, button, clickType, player);
    }

    @Override
    public boolean stillValid(Player player) {
        // Valid as long as the player has the recipe paper in hand
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        // Ghost slots do not support shift-click transfer
        return ItemStack.EMPTY;
    }

    public SimpleContainer getRecipeInv() {
        return recipeInv;
    }

    public int getHeldSlot() {
        return heldSlot;
    }
}
