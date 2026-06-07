package com.lulan.shincolle.tileentity;

import com.lulan.shincolle.client.gui.inventory.ContainerDesk;
import com.lulan.shincolle.init.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Block entity for the Admiral's Desk block.
 * Stores GUI state for multi-tab desk interface.
 * No tick logic needed - this is a static configuration tile.
 * <p>
 * Slot layout (4 slots): book, radar item, etc.
 * <p>
 * GUI tabs: Main (0), Radar (1), Book (2), Fleet (3), Target (4)
 */
public class TileEntityDesk extends BasicTileInventory implements MenuProvider {

    public static final int SLOT_COUNT = 4;

    /**
     * Current GUI function/tab mode
     */
    private int guiFunc = 0;
    /**
     * Radar zoom level
     */
    private int radarZoomLv = 0;
    /**
     * Book chapter selection
     */
    private int bookChap = 0;
    /**
     * Book page selection
     */
    private int bookPage = 0;

    public TileEntityDesk(BlockPos pos, BlockState state) {
        this(ModBlockEntities.DESK.get(), pos, state);
    }

    public TileEntityDesk(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state, SLOT_COUNT);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.shincolle.desk");
    }

    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInv, Player player) {
        return new ContainerDesk(containerId, playerInv, 0, this);
    }

    // ==================== GUI State ====================

    public int getGuiFunc() {
        return guiFunc;
    }

    public void setGuiFunc(int func) {
        this.guiFunc = func;
        setChanged();
    }

    public int getRadarZoomLv() {
        return radarZoomLv;
    }

    public void setRadarZoomLv(int level) {
        this.radarZoomLv = level;
        setChanged();
    }

    public int getBookChap() {
        return bookChap;
    }

    public void setBookChap(int chap) {
        this.bookChap = chap;
        setChanged();
    }

    public int getBookPage() {
        return bookPage;
    }

    public void setBookPage(int page) {
        this.bookPage = page;
        setChanged();
    }

    // ==================== NBT ====================

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("GuiFunc", guiFunc);
        tag.putInt("RadarZoom", radarZoomLv);
        tag.putInt("BookChap", bookChap);
        tag.putInt("BookPage", bookPage);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        guiFunc = tag.getInt("GuiFunc");
        radarZoomLv = tag.getInt("RadarZoom");
        bookChap = tag.getInt("BookChap");
        bookPage = tag.getInt("BookPage");
    }
}
