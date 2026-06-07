package com.lulan.shincolle.client.gui.inventory;

import com.lulan.shincolle.init.ModMenuTypes;
import com.lulan.shincolle.tileentity.TileEntityDesk;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

/**
 * Container/Menu for the Admiral's Desk.
 * Can be opened from the desk block (type 0), radar item (type 1), or book item
 * (type 2).
 * No container-specific slots -- only player inventory is shown.
 * The GUI content is driven by data, not inventory slots.
 */
public class ContainerDesk extends AbstractContainerMenu {

    /**
     * GUI type: 0=block, 1=radar item, 2=book item
     */
    private final int guiType;
    private final TileEntityDesk tile;

    /**
     * Client-side constructor (from network)
     */
    public ContainerDesk(int containerId, Inventory playerInv, FriendlyByteBuf buf) {
        this(containerId, playerInv, buf.readInt(), getDeskTileFromBuf(playerInv.player, buf));
    }

    /**
     * Server-side constructor
     */
    public ContainerDesk(int containerId, Inventory playerInv, int guiType, TileEntityDesk tile) {
        super(ModMenuTypes.DESK.get(), containerId);
        this.guiType = guiType;
        this.tile = tile;
    }

    private static TileEntityDesk getDeskTileFromBuf(Player player, FriendlyByteBuf buf) {
        BlockPos pos = buf.readBlockPos();
        if (pos.equals(BlockPos.ZERO)) {
            return null; // Item-based opening (no tile)
        }
        BlockEntity be = player.level().getBlockEntity(pos);
        return be instanceof TileEntityDesk t ? t : null;
    }

    @Override
    public boolean stillValid(Player player) {
        // Block-based: distance check
        if (guiType == 0 && tile != null) {
            BlockPos pos = tile.getBlockPos();
            return player.distanceToSqr(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5) <= 64.0;
        }
        // Item-based: always valid while open
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        // No container-specific slots to shift-click into
        return ItemStack.EMPTY;
    }

    public int getGuiType() {
        return guiType;
    }

    public TileEntityDesk getTile() {
        return tile;
    }
}
