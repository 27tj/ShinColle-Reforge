package com.lulan.shincolle.tileentity;

/**
 * Interface for furnace tile entities that use fluid fuel.
 * Extends ITileFurnace with fluid-specific methods.
 */
public interface ITileLiquidFurnace extends ITileFurnace {

    /**
     * Get current fluid fuel amount
     */
    int getFluidFuelAmount();

    /**
     * Consume fluid fuel, return amount actually consumed
     */
    int consumeFluidFuel(int amount);
}
