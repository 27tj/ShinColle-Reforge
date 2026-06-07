package com.lulan.shincolle.network;

import com.lulan.shincolle.utility.LogHelper;
import com.lulan.shincolle.utility.PacketHelper;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

/**
 * Server-to-Client reaction packet.
 * <p>
 * Sent by the server to inform the client about command reactions,
 * status updates, and server-side event results.
 * <p>
 * Ported from 1.10.2 S2CReactPackets.
 */
public class S2CReactPacket {

    // ========== Packet IDs ==========

    public static final byte CmdChOwner = 0;
    public static final byte CmdShipInfo = 1;
    public static final byte CmdShipAttr = 2;
    public static final byte CmdShipList = 3;
    public static final byte FlareEffect = 20;

    // ========== Fields ==========

    private final byte type;
    private final int[] values;

    // ========== Constructors ==========

    public S2CReactPacket(byte type, int... values) {
        this.type = type;
        this.values = values != null ? values : new int[0];
    }

    /**
     * Decoder constructor
     */
    public S2CReactPacket(FriendlyByteBuf buf) {
        this.type = buf.readByte();
        this.values = PacketHelper.readIntArray(buf);
    }

    /**
     * Create a flare effect packet
     */
    public static S2CReactPacket flareEffect(int x, int y, int z) {
        return new S2CReactPacket(FlareEffect, x, y, z);
    }

    // ========== Handler ==========

    /**
     * Create a change owner reaction packet
     */
    public static S2CReactPacket cmdChOwner(int senderEid, int ownerEid) {
        return new S2CReactPacket(CmdChOwner, senderEid, ownerEid);
    }

    /**
     * Create a ship info reaction packet
     */
    public static S2CReactPacket cmdShipInfo(int senderEid) {
        return new S2CReactPacket(CmdShipInfo, senderEid);
    }

    // ========== Handler Methods ==========

    /**
     * Create a set ship attrs reaction packet
     */
    public static S2CReactPacket cmdShipAttr(int... values) {
        return new S2CReactPacket(CmdShipAttr, values);
    }

    /**
     * Encode
     */
    public void encode(FriendlyByteBuf buf) {
        buf.writeByte(type);
        PacketHelper.writeIntArray(buf, values);
    }

    public void handle(Supplier<NetworkEvent.Context> ctxSupplier) {
        NetworkEvent.Context ctx = ctxSupplier.get();
        ctx.enqueueWork(() -> {
            // [PORT] 1.10.2 -> 1.20.1: enforce client-only execution at reception side.
            if (ctx.getDirection().getReceptionSide().isClient()) {
                handleClient();
            }
        });
        ctx.setPacketHandled(true);
    }

    @OnlyIn(Dist.CLIENT)
    private void handleClient() {
        try {
            switch (type) {
                case CmdChOwner:
                    handleCmdChOwner();
                    break;
                case CmdShipInfo:
                    handleCmdShipInfo();
                    break;
                case CmdShipAttr:
                    handleCmdShipAttr();
                    break;
                case CmdShipList:
                    handleCmdShipList();
                    break;
                case FlareEffect:
                    handleFlareEffect();
                    break;
                default:
                    LogHelper.debug("S2CReactPacket: unknown type=" + type);
                    break;
            }
        } catch (Exception e) {
            LogHelper.debug("S2CReactPacket: handler error type=" + type
                    + " err=" + e.getMessage());
        }
    }

    /**
     * Change owner command reaction.
     * values: 0:sender eid, 1:owner eid
     * Client-side: raycasts to target ship, then sends C2SInputPacket.CmdChOwner
     */
    @OnlyIn(Dist.CLIENT)
    private void handleCmdChOwner() {
        if (values.length < 2)
            return;
        net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
        if (mc.hitResult != null && mc.hitResult.getType() == net.minecraft.world.phys.HitResult.Type.ENTITY) {
            net.minecraft.world.phys.EntityHitResult ehr = (net.minecraft.world.phys.EntityHitResult) mc.hitResult;
            net.minecraft.world.entity.Entity target = ehr.getEntity();
            if (target instanceof com.lulan.shincolle.entity.BasicEntityShip) {
                ModNetworking.sendToServer(new C2SInputPacket(C2SInputPacket.CmdChOwner,
                        values[1], target.getId()));
            }
        }
    }

    // ========== Factory Methods ==========

    /**
     * Ship info command reaction.
     * values: 0:sender eid
     * Client-side: raycasts to target ship, then sends request for ship info
     */
    @OnlyIn(Dist.CLIENT)
    private void handleCmdShipInfo() {
        net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
        if (mc.hitResult != null && mc.hitResult.getType() == net.minecraft.world.phys.HitResult.Type.ENTITY) {
            net.minecraft.world.phys.EntityHitResult ehr = (net.minecraft.world.phys.EntityHitResult) mc.hitResult;
            net.minecraft.world.entity.Entity target = ehr.getEntity();
            if (target instanceof com.lulan.shincolle.entity.BasicEntityShip ship && mc.player != null) {
                mc.player.sendSystemMessage(net.minecraft.network.chat.Component.literal(
                        "[ShinColle] Ship: " + ship.getName().getString() +
                                " | Level: " + ship.getLevel() +
                                " | HP: " + String.format("%.0f/%.0f", ship.getHealth(), ship.getMaxHealth())));
            }
        }
    }

    /**
     * Set ship attrs command reaction.
     * values: 0:sender eid, 1:ship lv, 2-7:bonus values
     * Client-side: raycasts to target ship, sends C2SInputPacket.CmdShipAttr
     */
    @OnlyIn(Dist.CLIENT)
    private void handleCmdShipAttr() {
        if (values.length < 2)
            return;
        net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
        if (mc.hitResult != null && mc.hitResult.getType() == net.minecraft.world.phys.HitResult.Type.ENTITY) {
            net.minecraft.world.phys.EntityHitResult ehr = (net.minecraft.world.phys.EntityHitResult) mc.hitResult;
            net.minecraft.world.entity.Entity target = ehr.getEntity();
            if (target instanceof com.lulan.shincolle.entity.BasicEntityShip) {
                // Forward the attr values with target entity id
                int[] sendValues = new int[values.length + 1];
                sendValues[0] = target.getId();
                System.arraycopy(values, 1, sendValues, 1, values.length - 1);
                ModNetworking.sendToServer(new C2SInputPacket(C2SInputPacket.CmdShipAttr, sendValues));
            }
        }
    }

    /**
     * Ship list command reaction.
     * values: 0:total size, 1:page num, 2:list size
     * Client-side: displays paginated ship list in chat
     */
    @OnlyIn(Dist.CLIENT)
    private void handleCmdShipList() {
        if (values.length < 3)
            return;
        net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
        if (mc.player != null) {
            mc.player.sendSystemMessage(net.minecraft.network.chat.Component.literal(
                    "[ShinColle] Ship List: page " + values[1] +
                            " | total=" + values[0] + " | showing=" + values[2]));
        }
    }

    /**
     * Flare light effect.
     * values: 0:x, 1:y, 2:z
     */
    @OnlyIn(Dist.CLIENT)
    private void handleFlareEffect() {
        if (values.length < 3)
            return;
        net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
        if (mc.level == null)
            return;
        // Place a temporary light source at the flare position
        // Use vanilla light block (light_block) or just spawn flame particles as visual
        // effect
        double x = values[0] + 0.5;
        double y = values[1] + 0.5;
        double z = values[2] + 0.5;
        for (int i = 0; i < 8; i++) {
            mc.level.addParticle(net.minecraft.core.particles.ParticleTypes.FLAME,
                    x + (mc.level.random.nextDouble() - 0.5) * 2,
                    y + mc.level.random.nextDouble() * 2,
                    z + (mc.level.random.nextDouble() - 0.5) * 2,
                    0, 0.05, 0);
        }
    }

    // ========== Getters ==========

    public byte getType() {
        return type;
    }

    public int[] getValues() {
        return values;
    }
}
