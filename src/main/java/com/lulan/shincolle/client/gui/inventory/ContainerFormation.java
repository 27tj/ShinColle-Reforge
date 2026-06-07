package com.lulan.shincolle.client.gui.inventory;

import com.lulan.shincolle.init.ModMenuTypes;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

/**
 * Container/Menu for the Formation GUI.
 * Pure data-driven GUI with no item slots.
 * Formation data is synced via custom packets.
 */
public class ContainerFormation extends AbstractContainerMenu {

    /**
     * Client-side constructor (from network)
     */
    public ContainerFormation(int containerId, Inventory playerInv, FriendlyByteBuf buf) {
        this(containerId, playerInv);
    }

    /**
     * Server-side constructor
     */
    public ContainerFormation(int containerId, Inventory playerInv) {
        super(ModMenuTypes.FORMATION.get(), containerId);
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }
}
