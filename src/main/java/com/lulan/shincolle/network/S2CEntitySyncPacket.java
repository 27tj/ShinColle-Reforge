package com.lulan.shincolle.network;

import com.lulan.shincolle.entity.*;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.unitclass.Attrs;
import com.lulan.shincolle.reference.unitclass.AttrsAdv;
import com.lulan.shincolle.utility.LogHelper;
import com.lulan.shincolle.utility.PacketHelper;
import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

/**
 * Server-to-Client entity synchronization packet.
 * <p>
 * Uses a type byte to multiplex 20+ sub-types for syncing various
 * entity fields (attributes, state flags, formation data, equipment, etc.).
 * <p>
 * Ported from 1.10.2 S2CEntitySync.
 */
public class S2CEntitySyncPacket {

    // ========== Packet IDs ==========

    public static final byte SyncShip_AllMisc = 0;
    public static final byte SyncShip_Emo = 1;
    public static final byte SyncShip_Flag = 2;
    public static final byte SyncShip_Minor = 3;
    public static final byte SyncShip_Riders = 4;
    public static final byte SyncShip_Scale = 5;
    public static final byte SyncShip_Formation = 6;
    public static final byte SyncShip_Buffmap = 7;
    public static final byte SyncShip_Timer = 8;
    public static final byte SyncShip_Guard = 9;
    public static final byte SyncShip_ID = 10;
    public static final byte SyncShip_UnitName = 11;
    public static final byte SyncShip_Attrs = 12;

    public static final byte SyncEntity_Emo = 50;
    public static final byte SyncEntity_PlayerUID = 51;
    public static final byte SyncEntity_PosRot = 52;
    public static final byte SyncEntity_Rot = 53;
    public static final byte SyncEntity_Motion = 54;

    public static final byte SyncProjectile = 80;

    // ========== Fields ==========

    private final byte type;
    private final int entityId;
    private final byte[] payload;

    // ========== Constructors ==========

    public S2CEntitySyncPacket(byte type, int entityId, byte[] payload) {
        this.type = type;
        this.entityId = entityId;
        this.payload = payload != null ? payload : new byte[0];
    }

    /**
     * Decoder constructor
     */
    public S2CEntitySyncPacket(FriendlyByteBuf buf) {
        this.type = buf.readByte();
        this.entityId = buf.readInt();
        int len = buf.readVarInt();
        this.payload = buf.readByteArray(len);
    }

    /**
     * Create a payload buffer, serialize data, return raw bytes.
     */
    private static byte[] toBytes(java.util.function.Consumer<FriendlyByteBuf> writer) {
        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
        try {
            writer.accept(buf);
            byte[] data = new byte[buf.readableBytes()];
            buf.readBytes(data);
            return data;
        } finally {
            buf.release();
        }
    }

    // ========== Factory Methods ==========

    /**
     * Sync all misc states: minor + emotion + flags
     */
    public static S2CEntitySyncPacket syncAllMisc(BasicEntityShip ship) {
        byte[] data = toBytes(buf -> {
            buf.writeInt(ship.getStateMinor(ID.M.ShipLevel));
            buf.writeInt(ship.getStateMinor(ID.M.Kills));
            buf.writeInt(ship.getStateMinor(ID.M.ExpCurrent));
            buf.writeInt(ship.getStateMinor(ID.M.NumAmmoLight));
            buf.writeInt(ship.getStateMinor(ID.M.NumAmmoHeavy));
            buf.writeInt(ship.getStateMinor(ID.M.NumGrudge));
            buf.writeInt(ship.getStateMinor(ID.M.NumAirLight));
            buf.writeInt(ship.getStateMinor(ID.M.NumAirHeavy));
            buf.writeInt(ship.getStateMinor(ID.M.FollowMin));
            buf.writeInt(ship.getStateMinor(ID.M.FollowMax));
            buf.writeInt(ship.getStateMinor(ID.M.FleeHP));
            buf.writeInt(ship.getStateMinor(ID.M.GuardX));
            buf.writeInt(ship.getStateMinor(ID.M.GuardY));
            buf.writeInt(ship.getStateMinor(ID.M.GuardZ));
            buf.writeInt(ship.getStateMinor(ID.M.GuardDim));
            buf.writeInt(ship.getStateMinor(ID.M.GuardID));
            buf.writeInt(ship.getStateMinor(ID.M.GuardType));
            buf.writeInt(ship.getStateMinor(ID.M.PlayerUID));
            buf.writeInt(ship.getStateMinor(ID.M.ShipUID));
            buf.writeInt(ship.getStateMinor(ID.M.PlayerEID));
            buf.writeInt(ship.getStateMinor(ID.M.FormatType));
            buf.writeInt(ship.getStateMinor(ID.M.FormatPos));
            buf.writeInt(ship.getStateMinor(ID.M.Morale));
            buf.writeInt(ship.getStateMinor(ID.M.DrumState));
            buf.writeInt(ship.getStateMinor(ID.M.LevelChunkLoader));
            buf.writeInt(ship.getStateMinor(ID.M.LevelFlare));
            buf.writeInt(ship.getStateMinor(ID.M.LevelSearchlight));
            buf.writeInt(ship.getStateMinor(ID.M.WpStay));
            buf.writeInt(ship.getStateMinor(ID.M.UseCombatRation));
            buf.writeInt(ship.getStateTimer(ID.T.CraneTime));
            buf.writeInt(ship.getStateMinor(ID.M.SensBody));
            buf.writeInt(ship.getStateMinor(ID.M.NumState));
            buf.writeInt(ship.getStateMinor(ID.M.Task));
            buf.writeInt(ship.getStateMinor(ID.M.TaskSide));
            buf.writeInt(ship.getStateEmotion(ID.S.State));
            buf.writeInt(ship.getStateEmotion(ID.S.HPState));
            buf.writeInt(ship.getStateEmotion(ID.S.Emotion));
            buf.writeInt(ship.getStateEmotion(ID.S.Emotion4));
            buf.writeInt(ship.getStateEmotion(ID.S.Phase));
            buf.writeBoolean(ship.getStateFlag(ID.F.CanFloatUp));
            buf.writeBoolean(ship.getStateFlag(ID.F.IsMarried));
            buf.writeBoolean(ship.getStateFlag(ID.F.NoFuel));
            buf.writeBoolean(ship.getStateFlag(ID.F.UseMelee));
            buf.writeBoolean(ship.getStateFlag(ID.F.UseAmmoLight));
            buf.writeBoolean(ship.getStateFlag(ID.F.UseAmmoHeavy));
            buf.writeBoolean(ship.getStateFlag(ID.F.UseAirLight));
            buf.writeBoolean(ship.getStateFlag(ID.F.UseAirHeavy));
            buf.writeBoolean(ship.getStateFlag(ID.F.UseRingEffect));
            buf.writeBoolean(ship.getStateFlag(ID.F.OnSightChase));
            buf.writeBoolean(ship.getStateFlag(ID.F.PVPFirst));
            buf.writeBoolean(ship.getStateFlag(ID.F.AntiAir));
            buf.writeBoolean(ship.getStateFlag(ID.F.AntiSS));
            buf.writeBoolean(ship.getStateFlag(ID.F.PassiveAI));
            buf.writeBoolean(ship.getStateFlag(ID.F.TimeKeeper));
            buf.writeBoolean(ship.getStateFlag(ID.F.PickItem));
            buf.writeBoolean(ship.getStateFlag(ID.F.CanPickItem));
            buf.writeBoolean(ship.getStateFlag(ID.F.ShowHeldItem));
            buf.writeBoolean(ship.getStateFlag(ID.F.AutoPump));
            buf.writeInt(ship.getTextureID());
        });
        return new S2CEntitySyncPacket(SyncShip_AllMisc, ship.getId(), data);
    }

    /**
     * Sync emotion state
     */
    public static S2CEntitySyncPacket syncEmotion(Entity entity) {
        IShipEmotion emo = (IShipEmotion) entity;
        byte[] data = toBytes(buf -> {
            buf.writeInt(emo.getStateEmotion(ID.S.State));
            buf.writeInt(emo.getStateEmotion(ID.S.HPState));
            buf.writeInt(emo.getStateEmotion(ID.S.Emotion));
            buf.writeInt(emo.getStateEmotion(ID.S.Emotion4));
            buf.writeInt(emo.getStateEmotion(ID.S.Phase));
            buf.writeBoolean(emo.getStateFlag(ID.F.NoFuel));
            buf.writeBoolean(emo.getIsSitting());
        });
        byte packetType = (entity instanceof BasicEntityShip) ? SyncShip_Emo : SyncEntity_Emo;
        return new S2CEntitySyncPacket(packetType, entity.getId(), data);
    }

    /**
     * Sync flags only
     */
    public static S2CEntitySyncPacket syncFlags(BasicEntityShip ship) {
        byte[] data = toBytes(buf -> {
            buf.writeBoolean(ship.getStateFlag(ID.F.CanFloatUp));
            buf.writeBoolean(ship.getStateFlag(ID.F.IsMarried));
            buf.writeBoolean(ship.getStateFlag(ID.F.NoFuel));
            buf.writeBoolean(ship.getStateFlag(ID.F.UseMelee));
            buf.writeBoolean(ship.getStateFlag(ID.F.UseAmmoLight));
            buf.writeBoolean(ship.getStateFlag(ID.F.UseAmmoHeavy));
            buf.writeBoolean(ship.getStateFlag(ID.F.UseAirLight));
            buf.writeBoolean(ship.getStateFlag(ID.F.UseAirHeavy));
            buf.writeBoolean(ship.getStateFlag(ID.F.UseRingEffect));
            buf.writeBoolean(ship.getStateFlag(ID.F.OnSightChase));
            buf.writeBoolean(ship.getStateFlag(ID.F.PVPFirst));
            buf.writeBoolean(ship.getStateFlag(ID.F.AntiAir));
            buf.writeBoolean(ship.getStateFlag(ID.F.AntiSS));
            buf.writeBoolean(ship.getStateFlag(ID.F.PassiveAI));
            buf.writeBoolean(ship.getStateFlag(ID.F.TimeKeeper));
            buf.writeBoolean(ship.getStateFlag(ID.F.PickItem));
            buf.writeBoolean(ship.getStateFlag(ID.F.CanPickItem));
            buf.writeBoolean(ship.getStateFlag(ID.F.ShowHeldItem));
            buf.writeBoolean(ship.getStateFlag(ID.F.AutoPump));
        });
        return new S2CEntitySyncPacket(SyncShip_Flag, ship.getId(), data);
    }

    /**
     * Sync minor states only
     */
    public static S2CEntitySyncPacket syncMinor(BasicEntityShip ship) {
        byte[] data = toBytes(buf -> {
            buf.writeInt(ship.getStateMinor(ID.M.ShipLevel));
            buf.writeInt(ship.getStateMinor(ID.M.Kills));
            buf.writeInt(ship.getStateMinor(ID.M.ExpCurrent));
            buf.writeInt(ship.getStateMinor(ID.M.NumAmmoLight));
            buf.writeInt(ship.getStateMinor(ID.M.NumAmmoHeavy));
            buf.writeInt(ship.getStateMinor(ID.M.NumGrudge));
            buf.writeInt(ship.getStateMinor(ID.M.NumAirLight));
            buf.writeInt(ship.getStateMinor(ID.M.NumAirHeavy));
            buf.writeInt(ship.getStateMinor(ID.M.FollowMin));
            buf.writeInt(ship.getStateMinor(ID.M.FollowMax));
            buf.writeInt(ship.getStateMinor(ID.M.FleeHP));
            buf.writeInt(ship.getStateMinor(ID.M.GuardX));
            buf.writeInt(ship.getStateMinor(ID.M.GuardY));
            buf.writeInt(ship.getStateMinor(ID.M.GuardZ));
            buf.writeInt(ship.getStateMinor(ID.M.GuardDim));
            buf.writeInt(ship.getStateMinor(ID.M.GuardID));
            buf.writeInt(ship.getStateMinor(ID.M.GuardType));
            buf.writeInt(ship.getStateMinor(ID.M.PlayerUID));
            buf.writeInt(ship.getStateMinor(ID.M.ShipUID));
            buf.writeInt(ship.getStateMinor(ID.M.PlayerEID));
            buf.writeInt(ship.getStateMinor(ID.M.FormatType));
            buf.writeInt(ship.getStateMinor(ID.M.FormatPos));
            buf.writeInt(ship.getStateMinor(ID.M.Morale));
            buf.writeInt(ship.getStateMinor(ID.M.DrumState));
            buf.writeInt(ship.getStateMinor(ID.M.LevelChunkLoader));
            buf.writeInt(ship.getStateMinor(ID.M.LevelFlare));
            buf.writeInt(ship.getStateMinor(ID.M.LevelSearchlight));
            buf.writeInt(ship.getStateMinor(ID.M.WpStay));
            buf.writeInt(ship.getStateMinor(ID.M.UseCombatRation));
            buf.writeInt(ship.getStateMinor(ID.M.SensBody));
        });
        return new S2CEntitySyncPacket(SyncShip_Minor, ship.getId(), data);
    }

    /**
     * Sync formation data
     */
    public static S2CEntitySyncPacket syncFormation(BasicEntityShip ship) {
        byte[] data = toBytes(buf -> {
            buf.writeInt(ship.getStateMinor(ID.M.GuardX));
            buf.writeInt(ship.getStateMinor(ID.M.GuardY));
            buf.writeInt(ship.getStateMinor(ID.M.GuardZ));
            buf.writeInt(ship.getStateMinor(ID.M.GuardDim));
            buf.writeInt(ship.getStateMinor(ID.M.GuardType));
            buf.writeInt(ship.getStateMinor(ID.M.FormatType));
            buf.writeInt(ship.getStateMinor(ID.M.FormatPos));
            float minMOV = (ship.getAttrs() instanceof AttrsAdv adv) ? adv.getMinMOV() : 0F;
            buf.writeFloat(minMOV);
        });
        return new S2CEntitySyncPacket(SyncShip_Formation, ship.getId(), data);
    }

    /**
     * Sync guard position
     */
    public static S2CEntitySyncPacket syncGuard(BasicEntityShip ship) {
        byte[] data = toBytes(buf -> {
            buf.writeInt(ship.getStateMinor(ID.M.GuardX));
            buf.writeInt(ship.getStateMinor(ID.M.GuardY));
            buf.writeInt(ship.getStateMinor(ID.M.GuardZ));
            buf.writeInt(ship.getStateMinor(ID.M.GuardDim));
            buf.writeInt(ship.getStateMinor(ID.M.GuardID));
            buf.writeInt(ship.getStateMinor(ID.M.GuardType));
        });
        return new S2CEntitySyncPacket(SyncShip_Guard, ship.getId(), data);
    }

    /**
     * Sync ID fields
     */
    public static S2CEntitySyncPacket syncID(BasicEntityShip ship) {
        byte[] data = toBytes(buf -> {
            buf.writeInt(ship.getStateMinor(ID.M.PlayerUID));
            buf.writeInt(ship.getStateMinor(ID.M.ShipUID));
            buf.writeInt(ship.getStateMinor(ID.M.PlayerEID));
        });
        return new S2CEntitySyncPacket(SyncShip_ID, ship.getId(), data);
    }

    /**
     * Sync scale level
     */
    public static S2CEntitySyncPacket syncScale(Entity entity, int scaleLevel) {
        byte[] data = toBytes(buf -> buf.writeInt(scaleLevel));
        return new S2CEntitySyncPacket(SyncShip_Scale, entity.getId(), data);
    }

    /**
     * Sync crane timer
     */
    public static S2CEntitySyncPacket syncTimer(BasicEntityShip ship) {
        byte[] data = toBytes(buf -> buf.writeInt(ship.getStateTimer(ID.T.CraneTime)));
        return new S2CEntitySyncPacket(SyncShip_Timer, ship.getId(), data);
    }

    /**
     * Sync buff map
     */
    public static S2CEntitySyncPacket syncBuffMap(BasicEntityShip ship) {
        byte[] data = toBytes(buf -> PacketHelper.writeIntMap(buf, ship.getBuffMap()));
        return new S2CEntitySyncPacket(SyncShip_Buffmap, ship.getId(), data);
    }

    /**
     * Sync unit names
     */
    public static S2CEntitySyncPacket syncUnitName(BasicEntityShip ship) {
        byte[] data = toBytes(buf -> PacketHelper.writeStringList(buf, ship.unitNames));
        return new S2CEntitySyncPacket(SyncShip_UnitName, ship.getId(), data);
    }

    /**
     * Sync ship attributes
     */
    public static S2CEntitySyncPacket syncAttrs(BasicEntityShip ship) {
        AttrsAdv attrs = (AttrsAdv) ship.getAttrs();
        byte[] data = toBytes(buf -> {
            boolean bonus = ship.getUpdateFlag(ID.FlagUpdate.AttrsBonus);
            boolean raw = ship.getUpdateFlag(ID.FlagUpdate.AttrsRaw);
            boolean equip = ship.getUpdateFlag(ID.FlagUpdate.AttrsEquip);
            boolean morale = ship.getUpdateFlag(ID.FlagUpdate.AttrsMorale);
            boolean potion = ship.getUpdateFlag(ID.FlagUpdate.AttrsPotion);
            boolean formation = ship.getUpdateFlag(ID.FlagUpdate.AttrsFormation);
            boolean buffed = ship.getUpdateFlag(ID.FlagUpdate.AttrsBuffed);

            buf.writeBoolean(bonus);
            buf.writeBoolean(raw);
            buf.writeBoolean(equip);
            buf.writeBoolean(morale);
            buf.writeBoolean(potion);
            buf.writeBoolean(formation);
            buf.writeBoolean(buffed);

            if (bonus)
                PacketHelper.writeByteArray(buf, attrs.getAttrsBonus());
            if (raw)
                PacketHelper.writeFloatArray(buf, attrs.getAttrsRaw());
            if (equip)
                PacketHelper.writeFloatArray(buf, attrs.getAttrsEquip());
            if (morale)
                PacketHelper.writeFloatArray(buf, attrs.getAttrsMorale());
            if (potion)
                PacketHelper.writeFloatArray(buf, attrs.getAttrsPotion());
            if (formation) {
                PacketHelper.writeFloatArray(buf, attrs.getAttrsFormation());
                buf.writeFloat(attrs.getMinMOV());
            }
            if (buffed) {
                PacketHelper.writeFloatArray(buf, attrs.getAttrsBuffed());
                buf.writeFloat(attrs.getMinMOV());
            }
        });

        // reset update flags after encoding
        ship.setUpdateFlag(ID.FlagUpdate.AttrsBuffed, false);
        ship.setUpdateFlag(ID.FlagUpdate.AttrsBonus, false);
        ship.setUpdateFlag(ID.FlagUpdate.AttrsEquip, false);
        ship.setUpdateFlag(ID.FlagUpdate.AttrsMorale, false);
        ship.setUpdateFlag(ID.FlagUpdate.AttrsPotion, false);
        ship.setUpdateFlag(ID.FlagUpdate.AttrsFormation, false);
        ship.setUpdateFlag(ID.FlagUpdate.AttrsRaw, false);

        return new S2CEntitySyncPacket(SyncShip_Attrs, ship.getId(), data);
    }

    /**
     * Sync rider list
     */
    public static S2CEntitySyncPacket syncRiders(Entity entity) {
        byte[] data = toBytes(buf -> {
            List<Entity> passengers = entity.getPassengers();
            buf.writeInt(passengers.size());

            for (Entity rider : passengers) {
                buf.writeInt(rider.getId());
            }

            if (entity instanceof BasicEntityMount mount && mount.getHostEntity() != null) {
                buf.writeInt(mount.getHostEntity().getId());
            } else {
                buf.writeInt(0);
            }

            if (entity.getVehicle() != null) {
                buf.writeInt(entity.getVehicle().getId());
            } else {
                buf.writeInt(0);
            }
        });
        return new S2CEntitySyncPacket(SyncShip_Riders, entity.getId(), data);
    }

    /**
     * Sync entity position and rotation
     */
    public static S2CEntitySyncPacket syncPosRot(Entity entity) {
        byte[] data = toBytes(buf -> {
            buf.writeDouble(entity.getX());
            buf.writeDouble(entity.getY());
            buf.writeDouble(entity.getZ());
            buf.writeFloat(entity.getYRot());
            buf.writeFloat(entity.getXRot());
            if (entity instanceof LivingEntity living) {
                buf.writeFloat(living.yBodyRot);
                buf.writeFloat(living.yHeadRot);
            } else {
                buf.writeFloat(0F);
                buf.writeFloat(0F);
            }
        });
        return new S2CEntitySyncPacket(SyncEntity_PosRot, entity.getId(), data);
    }

    /**
     * Sync entity rotation
     */
    public static S2CEntitySyncPacket syncRotation(Entity entity) {
        byte[] data = toBytes(buf -> {
            if (entity instanceof LivingEntity living) {
                buf.writeFloat(living.yHeadRot);
                buf.writeFloat(entity.getYRot());
                buf.writeFloat(entity.getXRot());
            } else {
                buf.writeFloat(entity.getYRot());
                buf.writeFloat(entity.getYRot());
                buf.writeFloat(entity.getXRot());
            }
        });
        return new S2CEntitySyncPacket(SyncEntity_Rot, entity.getId(), data);
    }

    /**
     * Sync entity motion
     */
    public static S2CEntitySyncPacket syncMotion(Entity entity) {
        byte[] data = toBytes(buf -> {
            buf.writeFloat((float) entity.getDeltaMovement().x);
            buf.writeFloat((float) entity.getDeltaMovement().y);
            buf.writeFloat((float) entity.getDeltaMovement().z);
        });
        return new S2CEntitySyncPacket(SyncEntity_Motion, entity.getId(), data);
    }

    /**
     * Sync projectile type
     */
    public static S2CEntitySyncPacket syncProjectile(Entity entity, int projectileType) {
        byte[] data = toBytes(buf -> buf.writeInt(projectileType));
        return new S2CEntitySyncPacket(SyncProjectile, entity.getId(), data);
    }

    /**
     * Sync player UID for an entity
     */
    public static S2CEntitySyncPacket syncPlayerUID(Entity entity, int playerUID) {
        byte[] data = toBytes(buf -> {
            buf.writeInt(entity.getId());
            buf.writeInt(-1);
            buf.writeInt(-1);
            buf.writeInt(playerUID);
        });
        return new S2CEntitySyncPacket(SyncEntity_PlayerUID, -1, data);
    }

    @OnlyIn(Dist.CLIENT)
    private static void handleSyncAllMisc(Entity entity, FriendlyByteBuf buf) {
        if (!(entity instanceof BasicEntityShip ship))
            return;

        ship.setStateMinor(ID.M.ShipLevel, buf.readInt());
        ship.setStateMinor(ID.M.Kills, buf.readInt());
        ship.setStateMinor(ID.M.ExpCurrent, buf.readInt());
        ship.setStateMinor(ID.M.NumAmmoLight, buf.readInt());
        ship.setStateMinor(ID.M.NumAmmoHeavy, buf.readInt());
        ship.setStateMinor(ID.M.NumGrudge, buf.readInt());
        ship.setStateMinor(ID.M.NumAirLight, buf.readInt());
        ship.setStateMinor(ID.M.NumAirHeavy, buf.readInt());
        ship.setStateMinor(ID.M.FollowMin, buf.readInt());
        ship.setStateMinor(ID.M.FollowMax, buf.readInt());
        ship.setStateMinor(ID.M.FleeHP, buf.readInt());
        ship.setStateMinor(ID.M.GuardX, buf.readInt());
        ship.setStateMinor(ID.M.GuardY, buf.readInt());
        ship.setStateMinor(ID.M.GuardZ, buf.readInt());
        ship.setStateMinor(ID.M.GuardDim, buf.readInt());
        ship.setStateMinor(ID.M.GuardID, buf.readInt());
        ship.setStateMinor(ID.M.GuardType, buf.readInt());
        ship.setStateMinor(ID.M.PlayerUID, buf.readInt());
        ship.setStateMinor(ID.M.ShipUID, buf.readInt());
        ship.setStateMinor(ID.M.PlayerEID, buf.readInt());
        ship.setStateMinor(ID.M.FormatType, buf.readInt());
        ship.setStateMinor(ID.M.FormatPos, buf.readInt());
        ship.setStateMinor(ID.M.Morale, buf.readInt());
        ship.setStateMinor(ID.M.DrumState, buf.readInt());
        ship.setStateMinor(ID.M.LevelChunkLoader, buf.readInt());
        ship.setStateMinor(ID.M.LevelFlare, buf.readInt());
        ship.setStateMinor(ID.M.LevelSearchlight, buf.readInt());
        ship.setStateMinor(ID.M.WpStay, buf.readInt());
        ship.setStateMinor(ID.M.UseCombatRation, buf.readInt());
        ship.setStateTimer(ID.T.CraneTime, buf.readInt());
        ship.setStateMinor(ID.M.SensBody, buf.readInt());
        ship.setStateMinor(ID.M.NumState, buf.readInt());
        ship.setStateMinor(ID.M.Task, buf.readInt());
        ship.setStateMinor(ID.M.TaskSide, buf.readInt());

        ship.setStateEmotion(ID.S.State, buf.readInt(), false);
        ship.setStateEmotion(ID.S.HPState, buf.readInt(), false);
        ship.setStateEmotion(ID.S.Emotion, buf.readInt(), false);
        ship.setStateEmotion(ID.S.Emotion4, buf.readInt(), false);
        ship.setStateEmotion(ID.S.Phase, buf.readInt(), false);

        ship.setStateFlag(ID.F.CanFloatUp, buf.readBoolean());
        ship.setStateFlag(ID.F.IsMarried, buf.readBoolean());
        ship.setStateFlag(ID.F.NoFuel, buf.readBoolean());
        ship.setStateFlag(ID.F.UseMelee, buf.readBoolean());
        ship.setStateFlag(ID.F.UseAmmoLight, buf.readBoolean());
        ship.setStateFlag(ID.F.UseAmmoHeavy, buf.readBoolean());
        ship.setStateFlag(ID.F.UseAirLight, buf.readBoolean());
        ship.setStateFlag(ID.F.UseAirHeavy, buf.readBoolean());
        ship.setStateFlag(ID.F.UseRingEffect, buf.readBoolean());
        ship.setStateFlag(ID.F.OnSightChase, buf.readBoolean());
        ship.setStateFlag(ID.F.PVPFirst, buf.readBoolean());
        ship.setStateFlag(ID.F.AntiAir, buf.readBoolean());
        ship.setStateFlag(ID.F.AntiSS, buf.readBoolean());
        ship.setStateFlag(ID.F.PassiveAI, buf.readBoolean());
        ship.setStateFlag(ID.F.TimeKeeper, buf.readBoolean());
        ship.setStateFlag(ID.F.PickItem, buf.readBoolean());
        ship.setStateFlag(ID.F.CanPickItem, buf.readBoolean());
        ship.setStateFlag(ID.F.ShowHeldItem, buf.readBoolean());
        ship.setStateFlag(ID.F.AutoPump, buf.readBoolean());
        ship.setTextureID(buf.readInt());
    }

    // ========== Handler ==========

    @OnlyIn(Dist.CLIENT)
    private static void handleSyncEmotion(Entity entity, FriendlyByteBuf buf) {
        if (!(entity instanceof IShipEmotion emo))
            return;

        emo.setStateEmotion(ID.S.State, buf.readInt(), false);
        emo.setStateEmotion(ID.S.HPState, buf.readInt(), false);
        emo.setStateEmotion(ID.S.Emotion, buf.readInt(), false);
        emo.setStateEmotion(ID.S.Emotion4, buf.readInt(), false);
        emo.setStateEmotion(ID.S.Phase, buf.readInt(), false);
        emo.setStateFlag(ID.F.NoFuel, buf.readBoolean());
        emo.setEntitySit(buf.readBoolean());
    }

    @OnlyIn(Dist.CLIENT)
    private static void handleSyncFlags(Entity entity, FriendlyByteBuf buf) {
        if (!(entity instanceof BasicEntityShip ship))
            return;

        ship.setStateFlag(ID.F.CanFloatUp, buf.readBoolean());
        ship.setStateFlag(ID.F.IsMarried, buf.readBoolean());
        ship.setStateFlag(ID.F.NoFuel, buf.readBoolean());
        ship.setStateFlag(ID.F.UseMelee, buf.readBoolean());
        ship.setStateFlag(ID.F.UseAmmoLight, buf.readBoolean());
        ship.setStateFlag(ID.F.UseAmmoHeavy, buf.readBoolean());
        ship.setStateFlag(ID.F.UseAirLight, buf.readBoolean());
        ship.setStateFlag(ID.F.UseAirHeavy, buf.readBoolean());
        ship.setStateFlag(ID.F.UseRingEffect, buf.readBoolean());
        ship.setStateFlag(ID.F.OnSightChase, buf.readBoolean());
        ship.setStateFlag(ID.F.PVPFirst, buf.readBoolean());
        ship.setStateFlag(ID.F.AntiAir, buf.readBoolean());
        ship.setStateFlag(ID.F.AntiSS, buf.readBoolean());
        ship.setStateFlag(ID.F.PassiveAI, buf.readBoolean());
        ship.setStateFlag(ID.F.TimeKeeper, buf.readBoolean());
        ship.setStateFlag(ID.F.PickItem, buf.readBoolean());
        ship.setStateFlag(ID.F.CanPickItem, buf.readBoolean());
        ship.setStateFlag(ID.F.ShowHeldItem, buf.readBoolean());
        ship.setStateFlag(ID.F.AutoPump, buf.readBoolean());
    }

    // ========== Handler Methods ==========

    @OnlyIn(Dist.CLIENT)
    private static void handleSyncMinor(Entity entity, FriendlyByteBuf buf) {
        if (!(entity instanceof BasicEntityShip ship))
            return;

        ship.setStateMinor(ID.M.ShipLevel, buf.readInt());
        ship.setStateMinor(ID.M.Kills, buf.readInt());
        ship.setStateMinor(ID.M.ExpCurrent, buf.readInt());
        ship.setStateMinor(ID.M.NumAmmoLight, buf.readInt());
        ship.setStateMinor(ID.M.NumAmmoHeavy, buf.readInt());
        ship.setStateMinor(ID.M.NumGrudge, buf.readInt());
        ship.setStateMinor(ID.M.NumAirLight, buf.readInt());
        ship.setStateMinor(ID.M.NumAirHeavy, buf.readInt());
        ship.setStateMinor(ID.M.FollowMin, buf.readInt());
        ship.setStateMinor(ID.M.FollowMax, buf.readInt());
        ship.setStateMinor(ID.M.FleeHP, buf.readInt());
        ship.setStateMinor(ID.M.GuardX, buf.readInt());
        ship.setStateMinor(ID.M.GuardY, buf.readInt());
        ship.setStateMinor(ID.M.GuardZ, buf.readInt());
        ship.setStateMinor(ID.M.GuardDim, buf.readInt());
        ship.setStateMinor(ID.M.GuardID, buf.readInt());
        ship.setStateMinor(ID.M.GuardType, buf.readInt());
        ship.setStateMinor(ID.M.PlayerUID, buf.readInt());
        ship.setStateMinor(ID.M.ShipUID, buf.readInt());
        ship.setStateMinor(ID.M.PlayerEID, buf.readInt());
        ship.setStateMinor(ID.M.FormatType, buf.readInt());
        ship.setStateMinor(ID.M.FormatPos, buf.readInt());
        ship.setStateMinor(ID.M.Morale, buf.readInt());
        ship.setStateMinor(ID.M.DrumState, buf.readInt());
        ship.setStateMinor(ID.M.LevelChunkLoader, buf.readInt());
        ship.setStateMinor(ID.M.LevelFlare, buf.readInt());
        ship.setStateMinor(ID.M.LevelSearchlight, buf.readInt());
        ship.setStateMinor(ID.M.WpStay, buf.readInt());
        ship.setStateMinor(ID.M.UseCombatRation, buf.readInt());
        ship.setStateMinor(ID.M.SensBody, buf.readInt());
    }

    @OnlyIn(Dist.CLIENT)
    private static void handleSyncFormation(Entity entity, FriendlyByteBuf buf) {
        if (!(entity instanceof BasicEntityShip ship))
            return;

        ship.setStateMinor(ID.M.GuardX, buf.readInt());
        ship.setStateMinor(ID.M.GuardY, buf.readInt());
        ship.setStateMinor(ID.M.GuardZ, buf.readInt());
        ship.setStateMinor(ID.M.GuardDim, buf.readInt());
        ship.setStateMinor(ID.M.GuardType, buf.readInt());
        ship.setStateMinor(ID.M.FormatType, buf.readInt());
        ship.setStateMinor(ID.M.FormatPos, buf.readInt());
        float minMOV = buf.readFloat();
        if (ship.getAttrs() instanceof AttrsAdv adv) {
            adv.setMinMOV(minMOV);
        }
    }

    @OnlyIn(Dist.CLIENT)
    private static void handleSyncGuard(Entity entity, FriendlyByteBuf buf) {
        if (!(entity instanceof BasicEntityShip ship))
            return;

        ship.setStateMinor(ID.M.GuardX, buf.readInt());
        ship.setStateMinor(ID.M.GuardY, buf.readInt());
        ship.setStateMinor(ID.M.GuardZ, buf.readInt());
        ship.setStateMinor(ID.M.GuardDim, buf.readInt());
        ship.setStateMinor(ID.M.GuardID, buf.readInt());
        ship.setStateMinor(ID.M.GuardType, buf.readInt());
    }

    @OnlyIn(Dist.CLIENT)
    private static void handleSyncID(Entity entity, FriendlyByteBuf buf) {
        if (!(entity instanceof BasicEntityShip ship))
            return;

        ship.setStateMinor(ID.M.PlayerUID, buf.readInt());
        ship.setStateMinor(ID.M.ShipUID, buf.readInt());
        ship.setStateMinor(ID.M.PlayerEID, buf.readInt());
    }

    @OnlyIn(Dist.CLIENT)
    private static void handleSyncScale(Entity entity, FriendlyByteBuf buf) {
        if (entity instanceof IShipEmotion emo) {
            emo.setScaleLevel(buf.readInt());
        }
    }

    @OnlyIn(Dist.CLIENT)
    private static void handleSyncTimer(Entity entity, FriendlyByteBuf buf) {
        if (!(entity instanceof BasicEntityShip ship))
            return;
        ship.setStateTimer(ID.T.CraneTime, buf.readInt());
    }

    @OnlyIn(Dist.CLIENT)
    private static void handleSyncAttrs(Entity entity, FriendlyByteBuf buf) {
        if (!(entity instanceof BasicEntityShip ship))
            return;
        if (!(ship.getAttrs() instanceof AttrsAdv attrs))
            return;

        boolean bonus = buf.readBoolean();
        boolean raw = buf.readBoolean();
        boolean equip = buf.readBoolean();
        boolean morale = buf.readBoolean();
        boolean potion = buf.readBoolean();
        boolean formation = buf.readBoolean();
        boolean buffed = buf.readBoolean();

        if (bonus) {
            byte[] bonusData = PacketHelper.readByteArray(buf);
            byte[] dst = new byte[attrs.getAttrsBonus().length];
            System.arraycopy(bonusData, 0, dst, 0, Math.min(bonusData.length, dst.length));
            attrs.setAttrsBonus(dst);
        }
        if (raw)
            attrs.setAttrsRaw(readFloatAttrArray(buf));
        if (equip)
            attrs.setAttrsEquip(readFloatAttrArray(buf));
        if (morale)
            attrs.setAttrsMorale(readFloatAttrArray(buf));
        if (potion)
            attrs.setAttrsPotion(readFloatAttrArray(buf));
        if (formation) {
            attrs.setAttrsFormation(readFloatAttrArray(buf));
            attrs.setMinMOV(buf.readFloat());
        }
        if (buffed) {
            attrs.setAttrsBuffed(readFloatAttrArray(buf));
            attrs.setMinMOV(buf.readFloat());
        }
    }

    /**
     * Read float array and ensure it's exactly AttrsLength.
     */
    private static float[] readFloatAttrArray(FriendlyByteBuf buf) {
        float[] raw = PacketHelper.readFloatArray(buf);
        if (raw.length == Attrs.AttrsLength)
            return raw;
        return Arrays.copyOf(raw, Attrs.AttrsLength);
    }

    @OnlyIn(Dist.CLIENT)
    private static void handleSyncBuffmap(Entity entity, FriendlyByteBuf buf) {
        if (!(entity instanceof BasicEntityShip ship))
            return;
        java.util.Map<Integer, Integer> map = PacketHelper.readIntMap(buf);
        ship.setBuffMap(new HashMap<>(map));
    }

    @OnlyIn(Dist.CLIENT)
    private static void handleSyncUnitName(Entity entity, FriendlyByteBuf buf) {
        if (!(entity instanceof BasicEntityShip ship))
            return;
        ship.unitNames = new ArrayList<>(PacketHelper.readStringList(buf));
    }

    @OnlyIn(Dist.CLIENT)
    private static void handleSyncRiders(Entity entity, FriendlyByteBuf buf,
                                         net.minecraft.world.level.Level level) {
        if (entity == null)
            return;

        int riderCount = buf.readInt();
        for (int i = 0; i < riderCount; i++) {
            int riderId = buf.readInt();
            Entity rider = level.getEntity(riderId);
            if (rider != null)
                rider.startRiding(entity, true);
        }

        int hostId = buf.readInt();
        if (entity instanceof BasicEntityMount mount && hostId > 0) {
            Entity host = level.getEntity(hostId);
            if (host instanceof BasicEntityShip hostShip) {
                mount.setHost(hostShip);
            }
            if (riderCount > 1) {
                mount.setStateEmotion(ID.S.Emotion, 1, false);
            }
        }

        int vehicleId = buf.readInt();
        if (vehicleId > 0) {
            Entity vehicle = level.getEntity(vehicleId);
            if (vehicle != null)
                entity.startRiding(vehicle, true);
        } else {
            entity.stopRiding();
        }
    }

    @OnlyIn(Dist.CLIENT)
    private static void handleSyncProjectile(Entity entity, FriendlyByteBuf buf) {
        if (entity instanceof IShipProjectile proj) {
            proj.setProjectileType(buf.readInt());
        }
    }

    @OnlyIn(Dist.CLIENT)
    private static void handleSyncPosRot(Entity entity, FriendlyByteBuf buf) {
        if (entity == null)
            return;

        double x = buf.readDouble();
        double y = buf.readDouble();
        double z = buf.readDouble();
        float yaw = buf.readFloat();
        float pitch = buf.readFloat();
        float bodyYaw = buf.readFloat();
        float headYaw = buf.readFloat();

        entity.setPos(x, y, z);
        entity.setYRot(yaw);
        entity.setXRot(pitch);
        if (entity instanceof LivingEntity living) {
            living.yBodyRot = bodyYaw;
            living.yHeadRot = headYaw;
        }
    }

    @OnlyIn(Dist.CLIENT)
    private static void handleSyncRot(Entity entity, FriendlyByteBuf buf) {
        if (entity == null)
            return;

        float headYaw = buf.readFloat();
        float yaw = buf.readFloat();
        float pitch = buf.readFloat();

        entity.setYRot(yaw);
        entity.setXRot(pitch);
        if (entity instanceof LivingEntity living) {
            living.yHeadRot = headYaw;
        }

        if (entity.getVehicle() instanceof BasicEntityMount mount) {
            mount.yHeadRot = headYaw;
            mount.setYRot(yaw);
            mount.setXRot(pitch);
        }

        for (Entity rider : entity.getPassengers()) {
            rider.setYRot(headYaw);
            rider.setXRot(pitch);
            if (rider instanceof LivingEntity living) {
                living.yHeadRot = headYaw;
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    private static void handleSyncMotion(Entity entity, FriendlyByteBuf buf) {
        if (entity == null)
            return;
        float mx = buf.readFloat();
        float my = buf.readFloat();
        float mz = buf.readFloat();
        entity.setDeltaMovement(mx, my, mz);
    }

    @OnlyIn(Dist.CLIENT)
    private static void handleSyncPlayerUID(FriendlyByteBuf buf,
                                            net.minecraft.world.level.Level level) {
        int id0 = buf.readInt();
        int id1 = buf.readInt();
        int id2 = buf.readInt();
        int uid = buf.readInt();

        if (id1 == -1) {
            Entity ent = level.getEntity(id0);
            if (ent instanceof IShipOwner owner) {
                owner.setPlayerUID(uid);
            }
        } else {
            // Tile entity UID sync: id0=x, id1=y, id2=z
            net.minecraft.core.BlockPos pos = new net.minecraft.core.BlockPos(id0, id1, id2);
            net.minecraft.world.level.block.entity.BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof com.lulan.shincolle.tileentity.TileEntityCrane crane) {
                crane.setPlayerUID(uid);
            } else if (be instanceof com.lulan.shincolle.tileentity.TileEntityWaypoint waypoint) {
                waypoint.setPlayerUID(uid);
            }
        }
    }

    /**
     * Encode
     */
    public void encode(FriendlyByteBuf buf) {
        buf.writeByte(type);
        buf.writeInt(entityId);
        buf.writeVarInt(payload.length);
        buf.writeByteArray(payload);
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
        if (payload.length == 0 && type != SyncEntity_PlayerUID)
            return;

        net.minecraft.world.level.Level level = Minecraft.getInstance().level;
        if (level == null)
            return;

        Entity entity = (entityId >= 0) ? level.getEntity(entityId) : null;

        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.wrappedBuffer(payload));
        try {
            switch (type) {
                case SyncShip_AllMisc:
                    handleSyncAllMisc(entity, buf);
                    break;
                case SyncShip_Emo:
                case SyncEntity_Emo:
                    handleSyncEmotion(entity, buf);
                    break;
                case SyncShip_Flag:
                    handleSyncFlags(entity, buf);
                    break;
                case SyncShip_Minor:
                    handleSyncMinor(entity, buf);
                    break;
                case SyncShip_Formation:
                    handleSyncFormation(entity, buf);
                    break;
                case SyncShip_Guard:
                    handleSyncGuard(entity, buf);
                    break;
                case SyncShip_ID:
                    handleSyncID(entity, buf);
                    break;
                case SyncShip_Scale:
                    handleSyncScale(entity, buf);
                    break;
                case SyncShip_Timer:
                    handleSyncTimer(entity, buf);
                    break;
                case SyncShip_Attrs:
                    handleSyncAttrs(entity, buf);
                    break;
                case SyncShip_Buffmap:
                    handleSyncBuffmap(entity, buf);
                    break;
                case SyncShip_UnitName:
                    handleSyncUnitName(entity, buf);
                    break;
                case SyncShip_Riders:
                    handleSyncRiders(entity, buf, level);
                    break;
                case SyncProjectile:
                    handleSyncProjectile(entity, buf);
                    break;
                case SyncEntity_PosRot:
                    handleSyncPosRot(entity, buf);
                    break;
                case SyncEntity_Rot:
                    handleSyncRot(entity, buf);
                    break;
                case SyncEntity_Motion:
                    handleSyncMotion(entity, buf);
                    break;
                case SyncEntity_PlayerUID:
                    handleSyncPlayerUID(buf, level);
                    break;
                default:
                    LogHelper.debug("S2CEntitySyncPacket: unknown type=" + type);
                    break;
            }
        } catch (Exception e) {
            LogHelper.debug("S2CEntitySyncPacket: handler error type=" + type
                    + " eid=" + entityId + " err=" + e.getMessage());
        } finally {
            buf.release();
        }
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
