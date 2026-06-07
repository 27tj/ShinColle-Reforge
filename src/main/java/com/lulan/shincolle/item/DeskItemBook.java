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
 * Desk Item Book - opens the Admiral Desk book GUI (guiType 2).
 */
public class DeskItemBook extends BasicItem {

    public DeskItemBook() {
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
                    return new ContainerDesk(containerId, playerInv, 2, null);
                }
            }, buf -> {
                buf.writeInt(2); // guiType 2 = book item
                buf.writeBlockPos(BlockPos.ZERO); // no tile entity
            });
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
