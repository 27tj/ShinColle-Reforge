package com.lulan.shincolle.block;

import com.lulan.shincolle.entity.other.BasicEntityItem;
import com.lulan.shincolle.init.ModBlockEntities;
import com.lulan.shincolle.init.ModEntities;
import com.lulan.shincolle.tileentity.TileMultiGrudgeHeavy;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class BlockGrudgeHeavy extends BasicBlockMulti {

    public BlockGrudgeHeavy() {
        super(Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(3.0F).noOcclusion().lightLevel(s -> 15));
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        if (state.getValue(MBS) > 0) {
            return RenderShape.ENTITYBLOCK_ANIMATED;
        }
        return RenderShape.MODEL;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TileMultiGrudgeHeavy(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state,
                                                                  BlockEntityType<T> type) {
        return level.isClientSide ? null
                : createTickerHelper(type, ModBlockEntities.GRUDGE_HEAVY_MULTI.get(), TileMultiGrudgeHeavy::serverTick);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity be = level.getBlockEntity(pos);

            if (be instanceof TileMultiGrudgeHeavy tile) {
                // Combine matsBuild + matsStock into mats[4]
                int[] mats = new int[4];
                for (int i = 0; i < 4; i++) {
                    mats[i] = tile.getMatBuild(i) + tile.getMatStock(i);
                }

                // Create ItemStack with NBT containing mats + fuel
                ItemStack dropStack = new ItemStack(this);
                CompoundTag tag = dropStack.getOrCreateTag();
                tag.putIntArray("Mats", mats);
                tag.putInt("Fuel", tile.getPowerRemained());

                // [PORT] 1.10.2 -> 1.20.1: heavy grudge core drop used a custom item
                // entity to reduce accidental loss.
                if (!level.isClientSide()) {
                    BasicEntityItem dropEntity = new BasicEntityItem(
                            ModEntities.BASIC_ENTITY_ITEM.get(),
                            level,
                            pos.getX() + 0.5D,
                            pos.getY() + 0.25D,
                            pos.getZ() + 0.5D,
                            dropStack);
                    level.addFreshEntity(dropEntity);
                }

                // Drop any items in inventory slots
                ItemStackHandler inv = tile.getInventory();
                for (int i = 0; i < inv.getSlots(); i++) {
                    ItemStack stack = inv.getStackInSlot(i);
                    if (!stack.isEmpty()) {
                        Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), stack);
                    }
                }

                // Clear inventory to prevent double-drop from parent onRemove
                for (int i = 0; i < inv.getSlots(); i++) {
                    inv.setStackInSlot(i, ItemStack.EMPTY);
                }
            }
        }

        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);

        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof TileMultiGrudgeHeavy tile) {
            CompoundTag tag = stack.getTag();
            if (tag != null) {
                // Restore mats to matsStock
                if (tag.contains("Mats")) {
                    int[] mats = tag.getIntArray("Mats");
                    if (mats.length == 4) {
                        for (int i = 0; i < 4; i++) {
                            tile.setMatStock(i, mats[i]);
                        }
                    }
                }
                // Restore fuel
                if (tag.contains("Fuel")) {
                    tile.setPowerRemained(tag.getInt("Fuel"));
                }
            }
        }
    }
}
