package com.lulan.shincolle.block;

import com.lulan.shincolle.tileentity.BasicTileMulti;
import com.lulan.shincolle.tileentity.TileMultiGrudgeHeavy;
import com.lulan.shincolle.utility.LogHelper;
import com.lulan.shincolle.utility.MulitBlockHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;

/**
 * Abstract base block for multiblock structures.
 * Hides or changes texture when structure is completed.
 */
public abstract class BasicBlockMulti extends BasicBlockContainer {

    /**
     * Multi block structure state: 0:NO multi-structure, 1:mbs INACTIVE, 2:mbs
     * ACTIVE
     */
    public static final IntegerProperty MBS = IntegerProperty.create("mbs", 0, 2);

    public BasicBlockMulti(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(MBS, 0));
    }

    /**
     * Update multi-block structure state
     */
    public static void updateBlockState(int mbState, Level level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);

        if (state.getBlock() instanceof BasicBlockMulti) {
            level.setBlock(pos, state.setValue(MBS, mbState), 2);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(MBS);
    }

    /**
     * Hide block if MBS > 0 (structure formed)
     */
    @Override
    public RenderShape getRenderShape(BlockState state) {
        if (state.getValue(MBS) > 0) {
            return RenderShape.INVISIBLE;
        }
        return RenderShape.MODEL;
    }

    /**
     * Handle fluid rendering adjacent to hidden blocks
     */
    @SuppressWarnings("deprecation")
    @Override
    public boolean skipRendering(BlockState state, BlockState adjacentState, Direction direction) {
        if (state.getValue(MBS) > 0) {
            FluidState fluid = adjacentState.getFluidState();
            if (fluid.is(Fluids.WATER) || fluid.is(Fluids.LAVA) ||
                    fluid.is(Fluids.FLOWING_WATER) || fluid.is(Fluids.FLOWING_LAVA)) {
                return false; // don't skip - block liquid
            }
        }
        return super.skipRendering(state, adjacentState, direction);
    }

    @SuppressWarnings("deprecation")
    @Override
    public float getShadeBrightness(BlockState state, BlockGetter level, BlockPos pos) {
        if (state.getValue(MBS) > 0) {
            return 1.0F; // fully transparent when hidden
        }
        return super.getShadeBrightness(state, level, pos);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getValue(MBS) > 0;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        level.setBlock(pos, state.setValue(MBS, 0), 2);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity tile = level.getBlockEntity(pos);

            // If part of a structure, reset the structure
            if (!level.isClientSide) {
                if (tile instanceof BasicTileMulti tile2 && tile2.hasCorePos()) {
                    MulitBlockHelper.resetStructure(level,
                            tile2.getCorePos().getX(),
                            tile2.getCorePos().getY(),
                            tile2.getCorePos().getZ());
                } else if (tile instanceof TileMultiGrudgeHeavy gh && gh.hasCorePos()) {
                    MulitBlockHelper.resetStructure(level,
                            gh.getCorePos().getX(),
                            gh.getCorePos().getY(),
                            gh.getCorePos().getZ());
                }
            }

            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player,
                                 InteractionHand hand, BlockHitResult hit) {
        // Client side just returns success
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        // Server side: check if structure can form or open GUI
        if (!player.isShiftKeyDown()) {
            BlockEntity te = level.getBlockEntity(pos);

            if (te instanceof TileMultiGrudgeHeavy gh) {
                // MBS already formed - open GUI at core
                if (gh.hasCorePos()) {
                    BlockEntity coreTile = level.getBlockEntity(gh.getCorePos());

                    if (coreTile instanceof TileMultiGrudgeHeavy coreGH && player instanceof ServerPlayer sp) {
                        LogHelper.debug("DEBUG : open multi block GUI");
                        NetworkHooks.openScreen(sp, coreGH, gh.getCorePos());
                        return InteractionResult.CONSUME;
                    }

                    // [PORT] 1.10.2 -> 1.20.1: stale core references can block structure
                    // reforming forever after world edits/crashes.
                    gh.resetCorePos();
                    updateBlockState(0, level, pos);
                }

                // MBS not yet formed - check if it can form
                int type = MulitBlockHelper.checkMultiBlockForm(level,
                        pos.getX(), pos.getY(), pos.getZ());

                if (type > 0) {
                    MulitBlockHelper.setupStructure(level,
                            pos.getX(), pos.getY(), pos.getZ(), type);
                    LogHelper.debug("DEBUG: check multi block form: type " + type);
                    return InteractionResult.CONSUME;
                }
            } else if (te instanceof BasicTileMulti tile) {
                // MBS already formed - open GUI at core
                if (tile.hasCorePos()) {
                    BlockEntity coreTile = level.getBlockEntity(tile.getCorePos());

                    if (coreTile instanceof TileMultiGrudgeHeavy coreGH && player instanceof ServerPlayer sp) {
                        LogHelper.debug("DEBUG : open multi block GUI");
                        NetworkHooks.openScreen(sp, coreGH, tile.getCorePos());
                        return InteractionResult.CONSUME;
                    }

                    tile.resetCorePos();
                    updateBlockState(0, level, pos);
                }
            }
        }

        return InteractionResult.PASS;
    }
}
