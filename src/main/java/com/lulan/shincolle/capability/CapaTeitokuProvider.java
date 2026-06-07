package com.lulan.shincolle.capability;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Capability provider for CapaTeitoku (player-attached capability).
 * <p>
 * Provides access to the player's ShinColle data (team lists, ring state, etc.)
 * via the Forge Capability system with LazyOptional.
 */
public class CapaTeitokuProvider implements ICapabilitySerializable<CompoundTag> {

    public static final Capability<CapaTeitoku> CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {
    });

    private final CapaTeitoku instance = new CapaTeitoku();
    private final LazyOptional<CapaTeitoku> optional = LazyOptional.of(() -> instance);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CAPABILITY) {
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        return instance.serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        instance.deserializeNBT(nbt);
    }

    public void invalidate() {
        optional.invalidate();
    }
}
