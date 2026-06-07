package com.lulan.shincolle.capability;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Handles Forge Capability lifecycle events for ShinColle.
 * <p>
 * Registered on MinecraftForge.EVENT_BUS:
 * - AttachCapabilitiesEvent: attaches CapaTeitoku to players
 * - PlayerEvent.Clone: copies capability data on respawn / dimension change
 * <p>
 * Registered on MOD event bus (via ShinColle.java addListener):
 * - RegisterCapabilitiesEvent: registers CapaTeitoku capability
 */
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CapabilityHandler {

    private static final ResourceLocation TEITOKU_CAP_ID = new ResourceLocation(Reference.MOD_ID, "teitoku");

    /**
     * Attach CapaTeitoku capability to all player entities.
     */
    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            event.addCapability(TEITOKU_CAP_ID, new CapaTeitokuProvider());
        }
    }

    /**
     * Copy capability data when player respawns (death) or returns from End.
     * This ensures persistent data survives death and dimension transitions.
     */
    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        // wasDeath: true = respawn after death, false = return from End
        // In both cases, copy all data to the new player entity
        event.getOriginal().reviveCaps(); // required to access old caps
        event.getOriginal().getCapability(CapaTeitokuProvider.CAPABILITY).ifPresent(oldCap -> event.getEntity().getCapability(CapaTeitokuProvider.CAPABILITY).ifPresent(newCap -> newCap.copyFrom(oldCap)));
        event.getOriginal().invalidateCaps();
    }

    /**
     * Register capability class. Called from MOD event bus.
     */
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(CapaTeitoku.class);
    }
}
