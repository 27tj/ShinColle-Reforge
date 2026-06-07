package com.lulan.shincolle.tileentity;

/**
 * Interface for furnace-like tile entities with power tracking.
 */
public interface ITileFurnace {

    /**
     * Power consumed in current processing cycle
     */
    int getPowerConsumed();

    void setPowerConsumed(int par1);

    /**
     * Power goal for current processing cycle
     */
    int getPowerGoal();

    void setPowerGoal(int par1);

    /**
     * Remaining fuel power
     */
    int getPowerRemained();

    void setPowerRemained(int par1);

    /**
     * Maximum fuel power capacity
     */
    int getPowerMax();

    void setPowerMax(int par1);

    /**
     * Fuel magnification from config
     */
    float getFuelMagni();
}
