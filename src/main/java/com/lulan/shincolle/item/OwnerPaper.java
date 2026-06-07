package com.lulan.shincolle.item;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.server.ServerDataManager;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

/**
 * Owner Paper - used to set ownership of ship entities.
 * Right click to sign the paper. Two players sign to allow ownership transfer.
 */
public class OwnerPaper extends BasicItem {

    public static final String SignNameA = "SignNameA";
    public static final String SignNameB = "SignNameB";
    public static final String SignIDA = "SignIDA";
    public static final String SignIDB = "SignIDB";

    public OwnerPaper() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        // server side
        if (!level.isClientSide && !player.isShiftKeyDown()) {
            CapaTeitoku capa = ServerDataManager.getTeitokuCapability(player);


            CompoundTag nbt = stack.getOrCreateTag();

            // first time use
            if (!nbt.contains(SignIDA)) {
                nbt.putString(SignNameA, player.getName().getString());
                nbt.putString(SignNameB, "");
                nbt.putInt(SignIDA, capa.getPlayerUID());
                nbt.putInt(SignIDB, -1);
                nbt.putBoolean("signPos", false);
            }
            // use > second time
            else {
                // signPos: true -> sign at A, false -> sign at B
                if (nbt.getBoolean("signPos")) {
                    nbt.putString(SignNameA, player.getName().getString());
                    nbt.putInt(SignIDA, capa.getPlayerUID());
                    nbt.putBoolean("signPos", false);
                } else {
                    nbt.putString(SignNameB, player.getName().getString());
                    nbt.putInt(SignIDB, capa.getPlayerUID());
                    nbt.putBoolean("signPos", true);
                }
            }
        }


        return InteractionResultHolder.pass(stack);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        if (stack.hasTag()) {
            CompoundTag nbt = stack.getTag();
            if (nbt != null && nbt.contains(SignIDA)) {
                tooltip.add(Component.literal(
                        ChatFormatting.RED.toString() + nbt.getInt(SignIDA) + " "
                                + ChatFormatting.AQUA + nbt.getString(SignNameA)));
                tooltip.add(Component.literal(
                        ChatFormatting.RED.toString() + nbt.getInt(SignIDB) + " "
                                + ChatFormatting.AQUA + nbt.getString(SignNameB)));
            }
        }
    }
}
