package com.lulan.shincolle.tileentity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Block entity for multiblock structure components.
 * Stores reference to the core block position.
 */
public class BasicTileMulti extends BasicTileEntity {

    protected BlockPos corePos = BlockPos.ZERO;
    protected boolean hasCorePos = false;

    public BasicTileMulti(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public BlockPos getCorePos() {
        return corePos;
    }

    public void setCorePos(BlockPos pos) {
        this.corePos = pos;
        this.hasCorePos = true;
        setChanged();
    }

    public boolean hasCorePos() {
        return hasCorePos;
    }

    public void resetCorePos() {
        this.corePos = BlockPos.ZERO;
        this.hasCorePos = false;
        setChanged();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        if (hasCorePos) {
            tag.putInt("CoreX", corePos.getX());
            tag.putInt("CoreY", corePos.getY());
            tag.putInt("CoreZ", corePos.getZ());
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains("CoreX")) {
            corePos = new BlockPos(tag.getInt("CoreX"), tag.getInt("CoreY"), tag.getInt("CoreZ"));
            hasCorePos = true;
        }
    }
}
