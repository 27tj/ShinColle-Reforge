package com.lulan.shincolle.item;

import com.lulan.shincolle.client.gui.inventory.ContainerDesk;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

/**
 * Desk Item Radar - opens the Admiral Desk radar GUI (guiType 1).
 */
public class DeskItemRadar extends BasicItem {

    public DeskItemRadar() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            NetworkHooks.openScreen(serverPlayer, new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return Component.translatable("container.shincolle.desk");
                }

                @Override
                public AbstractContainerMenu createMenu(int containerId, Inventory playerInv, Player p) {
                    return new ContainerDesk(containerId, playerInv, 1, null);
                }
            }, buf -> {
                buf.writeInt(1); // guiType 1 = radar item
                buf.writeBlockPos(BlockPos.ZERO); // no tile entity
            });
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
