package com.lulan.shincolle.network;

import java.util.function.Supplier;

import com.lulan.shincolle.utility.ParticleHelper;

import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkEvent;

/**
 * Server-to-Client particle spawn packet.
 *
 * Triggers client-side particle effects for ShinColle entities.
 * Different type values correspond to different particle effects
 * (attacks, skill effects, emotional indicators, etc.).
 *
 * Particle types (from 1.10.2):
 * 0: Attack hit effect
 * 1: Cannon fire effect
 * 2: Aircraft launch
 * 3: Skill activation
 * 4+: Various other effects
 */
public class S2CSpawnParticlePacket {

    private final byte type;
    private final int entityId;
    private final byte[] payload;

    /**
     * Construct a new particle spawn packet.
     *
     * @param type     the particle effect type
     * @param entityId the source entity ID
     * @param payload  additional particle parameters (position offsets, colors,
     *                 etc.)
     */
    public S2CSpawnParticlePacket(byte type, int entityId, byte[] payload) {
        this.type = type;
        this.entityId = entityId;
        this.payload = payload != null ? payload : new byte[0];
    }

    /**
     * Decoder constructor - reads from network buffer.
     */
    public S2CSpawnParticlePacket(FriendlyByteBuf buf) {
        this.type = buf.readByte();
        this.entityId = buf.readInt();
        int len = buf.readVarInt();
        this.payload = buf.readByteArray(len);
    }

    /**
     * Encode this packet into a network buffer.
     */
    public void encode(FriendlyByteBuf buf) {
        buf.writeByte(type);
        buf.writeInt(entityId);
        buf.writeVarInt(payload.length);
        buf.writeByteArray(payload);
    }

    /**
     * Handle the packet on the client main thread.
     * Dispatches to ParticleHelper to spawn attack/effect particles.
     */
    public void handle(Supplier<NetworkEvent.Context> ctxSupplier) {
        NetworkEvent.Context ctx = ctxSupplier.get();
        ctx.enqueueWork(() -> {
            // [PORT] 1.10.2 -> 1.20.1: hard-guard client-only particle handling by
            // reception side.
            if (ctx.getDirection().getReceptionSide().isClient()) {
                handleClient();
            }
        });
        ctx.setPacketHandled(true);
    }

    @OnlyIn(Dist.CLIENT)
    private void handleClient() {
        net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
        if (mc.level == null)
            return;

        double x, y, z, lookX = 0, lookY = 1, lookZ = 0;

        // Special handling for emotion particles (type 36)
        if (type == 36) {
            Entity entity = mc.level.getEntity(entityId);
            if (entity == null)
                return;
            // Decode height and emotion type from 4-byte payload
            if (payload.length >= 4) {
                int heightEncoded = ((payload[0] & 0xFF) << 8) | (payload[1] & 0xFF);
                float h = heightEncoded / 100.0F;
                int emotionType = payload[3] & 0xFF;
                ParticleHelper.spawnEmotionParticle(entity, emotionType);
            }
            return;
        }

        if (payload.length >= 48) {
            // Full payload: 6 doubles (position + look direction)
            FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.wrappedBuffer(payload));
            try {
                x = buf.readDouble();
                y = buf.readDouble();
                z = buf.readDouble();
                lookX = buf.readDouble();
                lookY = buf.readDouble();
                lookZ = buf.readDouble();
            } finally {
                buf.release();
            }
        } else if (payload.length >= 24) {
            // Partial payload: 3 doubles (position only)
            FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.wrappedBuffer(payload));
            try {
                x = buf.readDouble();
                y = buf.readDouble();
                z = buf.readDouble();
            } finally {
                buf.release();
            }
        } else {
            // No position payload: derive from entity
            Entity entity = mc.level.getEntity(entityId);
            if (entity == null)
                return;
            x = entity.getX();
            y = entity.getY() + entity.getBbHeight() * 0.5;
            z = entity.getZ();
        }

        ParticleHelper.spawnAttackParticleAt(mc.level, x, y, z, lookX, lookY, lookZ, type);
    }

    // ========== Getters ==========

    public byte getType() {
        return type;
    }

    public int getEntityId() {
        return entityId;
    }

    public byte[] getPayload() {
        return payload;
    }
}
