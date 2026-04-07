package com.lulan.shincolle.handler;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.reference.Reference;
import com.lulan.shincolle.server.ServerDataManager;
import com.lulan.shincolle.utility.LogHelper;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Server-side event handler for ShinColle.
 *
 * Manages the ServerDataManager lifecycle:
 * - Initializes when overworld loads
 * - Saves and resets on server stop
 * - Ticks every server tick
 * - Updates player UIDs on login
 */
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ServerEventHandler {

    /**
     * Initialize ServerDataManager when the overworld level loads.
     */
    @SubscribeEvent
    public static void onLevelLoad(LevelEvent.Load event) {
        if (event.getLevel() instanceof ServerLevel serverLevel) {
            if (serverLevel.dimension() == Level.OVERWORLD) {
                ServerDataManager.init(serverLevel);
            }
        }
    }

    /**
     * Save and reset ServerDataManager when the server stops.
     */
    @SubscribeEvent
    public static void onServerStopping(ServerStoppingEvent event) {
        ServerDataManager.reset();
    }

    /**
     * Tick the ServerDataManager every server tick.
     */
    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            ServerDataManager.onServerTick();
        }
    }

    /**
     * Assign or update player UID on login.
     */
    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (!event.getEntity().level().isClientSide()) {
            ServerDataManager.updatePlayerID(event.getEntity());
        }
    }

    /**
     * Update player cache on respawn.
     */
    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        if (!event.getEntity().level().isClientSide()) {
            ServerDataManager.updatePlayerID(event.getEntity());
        }
    }

    /**
     * Update player cache on dimension change.
     */
    @SubscribeEvent
    public static void onPlayerChangeDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        if (!event.getEntity().level().isClientSide()) {
            ServerDataManager.updatePlayerID(event.getEntity());
        }
    }

    /**
     * Save player data on logout.
     */
    @SubscribeEvent
    public static void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
        if (!event.getEntity().level().isClientSide()) {
            CapaTeitoku capa = ServerDataManager.getTeitokuCapability(event.getEntity());
            if (capa != null && capa.getPlayerUID() > 0) {
                ServerDataManager.updatePlayerID(event.getEntity());
                LogHelper.info("player logged out: " + event.getEntity().getGameProfile().getName()
                        + " uid=" + capa.getPlayerUID());
            }
        }
    }
}
