package com.lulan.shincolle.utility;

import net.minecraft.core.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.IItemHandler;

/**
 * helper for capability
 */
public class CapaHelper {

    /**
     * get item handler
     * side: -1:check all side, 0~5:DUNSWE
     */
    public static IItemHandler getCapaInventory(ICapabilityProvider host, int side) {
        return getCapaHandler(host, ForgeCapabilities.ITEM_HANDLER, side);
    }

    /**
     * check item handler
     * side: -1:check all side, 0~5:DUNSWE
     */
    public static boolean hasCapaInventory(ICapabilityProvider host, int side) {
        return getCapaHandler(host, ForgeCapabilities.ITEM_HANDLER, side) != null;
    }

    /**
     * get fluid handler
     * side: -1:check all side, 0~5:DUNSWE
     */
    public static IFluidHandler getCapaFluid(ICapabilityProvider host, int side) {
        return getCapaHandler(host, ForgeCapabilities.FLUID_HANDLER, side);
    }

    /**
     * check fluid handler
     * side: -1:check all side, 0~5:DUNSWE
     */
    public static boolean hasCapaFluid(ICapabilityProvider host, int side) {
        return getCapaHandler(host, ForgeCapabilities.FLUID_HANDLER, side) != null;
    }

    /**
     * get capability handler
     * side: -1:check all side, 0~5:DUNSWE
     */
    @SuppressWarnings("unchecked")
    public static <T> T getCapaHandler(ICapabilityProvider host, Capability<T> capa, int side) {
        if (host != null) {
            // check all sides
            if (side < 0) {
                for (Direction dir : Direction.values()) {
                    LazyOptional<T> opt = host.getCapability(capa, dir);
                    if (opt.isPresent()) {
                        return opt.orElse(null);
                    }
                }
            }
            // check specific side
            else if (side < 6) {
                Direction dir = Direction.from3DDataValue(side);
                LazyOptional<T> opt = host.getCapability(capa, dir);
                return opt.orElse(null);
            }
        }

        return null;
    }

}
