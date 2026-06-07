package com.lulan.shincolle.block;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.capability.CapaTeitokuProvider;
import com.lulan.shincolle.init.ModBlockEntities;
import com.lulan.shincolle.tileentity.TileEntityCrane;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;

public class BlockCrane extends BasicBlockContainer {

    public BlockCrane() {
        super(Properties.of().mapColor(MapColor.METAL).strength(3.0F));
    }

    @SuppressWarnings("deprecation")
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player,
                                 InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof TileEntityCrane tile) {
                // sync owner UID on interaction
                syncOwnerUID(player, tile);
                NetworkHooks.openScreen(serverPlayer, tile, pos);
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer,
                            ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);
        if (!level.isClientSide() && placer instanceof Player player) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof TileEntityCrane tile) {
                syncOwnerUID(player, tile);
            }
        }
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player,
                                       boolean willHarvest, FluidState fluid) {
        // allow OP or creative players
        if (player.hasPermissions(2) || player.getAbilities().instabuild) {
            return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
        }

        // check tile owner
        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof TileEntityCrane tile && tile.getPlayerUID() > 0) {
            int playerUID = player.getCapability(CapaTeitokuProvider.CAPABILITY)
                    .map(CapaTeitoku::getPlayerUID).orElse(-1);
            if (playerUID != tile.getPlayerUID()) {
                return false; // not owner, prevent destruction
            }
        }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    private void syncOwnerUID(Player player, TileEntityCrane tile) {
        if (tile.getPlayerUID() <= 0) {
            player.getCapability(CapaTeitokuProvider.CAPABILITY).ifPresent(capa -> {
                int uid = capa.getPlayerUID();
                if (uid > 0) {
                    tile.setPlayerUID(uid);
                }
            });
        }
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TileEntityCrane(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state,
                                                                  BlockEntityType<T> type) {
        return level.isClientSide ? null
                : createTickerHelper(type, ModBlockEntities.CRANE.get(), TileEntityCrane::serverTick);
    }
}
