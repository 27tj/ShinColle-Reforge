package com.lulan.shincolle.item;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.capability.CapaTeitokuProvider;
import com.lulan.shincolle.network.C2SInputPacket;
import com.lulan.shincolle.network.ModNetworking;
import com.lulan.shincolle.tileentity.ITileWaypoint;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.List;

/**
 * Target Wrench - used for pairing waypoints, cranes and chests.
 * <p>
 * Sneaking + right-click on Crane, Chest (IInventory), or Waypoint
 * blocks to pair them together. Two blocks must be selected in sequence.
 */
public class TargetWrench extends BasicItem {

    public TargetWrench() {
        super(new Properties().stacksTo(1));
    }

    // ===== NBT-backed per-stack state =====

    /**
     * Get a stored tile point position from the ItemStack's NBT
     */
    public static BlockPos getTilePoint(ItemStack stack, int index) {
        CompoundTag tag = stack.getTag();
        if (tag != null && tag.contains("TilePoint" + index)) {
            return BlockPos.of(tag.getLong("TilePoint" + index));
        }
        return BlockPos.ZERO;
    }

    /**
     * Set a tile point position in the ItemStack's NBT
     */
    public static void setTilePoint(ItemStack stack, int index, BlockPos pos) {
        stack.getOrCreateTag().putLong("TilePoint" + index, pos.asLong());
    }

    /**
     * Get the current point selection index from the ItemStack's NBT
     */
    public static int getPointID(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        if (tag != null) {
            return tag.getInt("PointID");
        }
        return 0;
    }

    /**
     * Set the current point selection index in the ItemStack's NBT
     */
    public static void setPointID(ItemStack stack, int pointID) {
        stack.getOrCreateTag().putInt("PointID", pointID);
    }

    /**
     * Right-click on block: pair Crane, Chest, and Waypoint.
     * This pairing is handled on the CLIENT side, then a packet
     * is sent to the server to finalize.
     */
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        ItemStack stack = context.getItemInHand();

        if (player == null)
            return InteractionResult.PASS;

        // client side only for pairing selection
        if (level.isClientSide()) {
            if (player.isShiftKeyDown()) {
                BlockEntity tile = level.getBlockEntity(pos);

                if (tile instanceof com.lulan.shincolle.tileentity.TileEntityCrane
                        || tile instanceof net.minecraft.world.Container
                        || tile instanceof ITileWaypoint) {
                    setTilePoint(stack, getPointID(stack), pos);
                    switchPoint(stack);
                    setPair(stack, player);

                    return InteractionResult.FAIL; // return fail to prevent item swing
                } else {
                    // wrong tile entity
                    player.displayClientMessage(
                            Component.translatable("chat.shincolle.wrench.wrongtile"), false);
                    resetPos(stack);
                }
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("gui.shincolle.wrench3").withStyle(ChatFormatting.YELLOW));
    }

    private void switchPoint(ItemStack stack) {
        setPointID(stack, getPointID(stack) == 0 ? 1 : 0);
    }

    private void resetPos(ItemStack stack) {
        setTilePoint(stack, 0, BlockPos.ZERO);
        setTilePoint(stack, 1, BlockPos.ZERO);
        setPointID(stack, 0);
    }

    /**
     * Crane/Waypoint/Chest pairing logic (CLIENT SIDE ONLY).
     * Sends packet to server when both points are selected.
     */
    private boolean setPair(ItemStack stack, Player player) {
        BlockPos point0 = getTilePoint(stack, 0);
        BlockPos point1 = getTilePoint(stack, 1);

        // valid point positions (not unset)
        if (point0.equals(BlockPos.ZERO) || point1.equals(BlockPos.ZERO))
            return false;

        // get player UID
        CapaTeitoku capa = player.getCapability(CapaTeitokuProvider.CAPABILITY).orElse(null);
        int uid;

        uid = capa.getPlayerUID();
        if (uid <= 0)
            return false;

        // get tile entities
        BlockEntity[] tiles = new BlockEntity[2];
        tiles[0] = player.level().getBlockEntity(point0);
        tiles[1] = player.level().getBlockEntity(point1);

        // same point check
        if (point0.equals(point1)) {
            player.displayClientMessage(
                    Component.translatable("chat.shincolle.wrench.samepoint"), false);
            resetPos(stack);
            return false;
        }

        // chest + waypoint pairing
        if (tiles[0] instanceof net.minecraft.world.Container && !(tiles[0] instanceof ITileWaypoint)
                && tiles[1] instanceof ITileWaypoint
                || tiles[1] instanceof net.minecraft.world.Container && !(tiles[1] instanceof ITileWaypoint)
                && tiles[0] instanceof ITileWaypoint) {
            BlockPos wpPos;
            BlockPos chestPos;

            if (tiles[0] instanceof ITileWaypoint) {
                wpPos = point0;
                chestPos = point1;
            } else {
                wpPos = point1;
                chestPos = point0;
            }

            // send pairing request to server
            ModNetworking.sendToServer(new C2SInputPacket(C2SInputPacket.Request_ChestSet,
                    uid, wpPos.getX(), wpPos.getY(), wpPos.getZ(),
                    chestPos.getX(), chestPos.getY(), chestPos.getZ()));

            resetPos(stack);
            return true;
        }
        // waypoint + waypoint pairing
        else if (tiles[0] instanceof ITileWaypoint && tiles[1] instanceof ITileWaypoint) {
            int pid = getPointID(stack);
            BlockPos posF = pid == 0 ? point0 : point1;
            switchPoint(stack);
            pid = getPointID(stack);
            BlockPos posT = pid == 0 ? point0 : point1;

            // send pairing request to server
            ModNetworking.sendToServer(new C2SInputPacket(C2SInputPacket.Request_WpSet,
                    uid, posF.getX(), posF.getY(), posF.getZ(),
                    posT.getX(), posT.getY(), posT.getZ()));

            resetPos(stack);
            return true;
        } else {
            player.displayClientMessage(
                    Component.translatable("chat.shincolle.wrench.wrongtile")
                            .withStyle(ChatFormatting.YELLOW),
                    false);
            resetPos(stack);
            return false;
        }
    }
}
