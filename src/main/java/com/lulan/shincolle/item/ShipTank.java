package com.lulan.shincolle.item;

import com.lulan.shincolle.capability.CapaFluidContainer;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Ship Tank - fluid/resource tank for ship entities.
 * Original meta types with capacities:
 * 0 = 32000 mB
 * 1 = 128000 mB
 * 2 = 512000 mB
 * 3 = 2048000 mB
 */
public class ShipTank extends BasicItem {

    private final int type;
    private final int capacity;

    public ShipTank() {
        this(0);
    }

    public ShipTank(int type) {
        super(new Properties().stacksTo(1));
        this.type = type;
        switch (type) {
            case 0:
                this.capacity = 32000;
                break;
            case 1:
                this.capacity = 128000;
                break;
            case 2:
                this.capacity = 512000;
                break;
            case 3:
                this.capacity = 2048000;
                break;
            default:
                this.capacity = 32000;
                break;
        }
    }

    public int getType() {
        return this.type;
    }

    public int getTankCapacity() {
        return this.capacity;
    }

    /**
     * Attach fluid capability to this item, enabling it to store fluids.
     */
    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new ShipTankFluidProvider(stack, this.capacity);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("gui.shincolle.shiptank").withStyle(ChatFormatting.GRAY));

        // Show fluid contents and capacity
        String name = "";
        int amount = 0;

        var fluidOpt = FluidUtil.getFluidContained(stack);
        if (fluidOpt.isPresent()) {
            FluidStack fs = fluidOpt.get();
            name = fs.getDisplayName().getString();
            amount = fs.getAmount();
        }

        tooltip.add(Component.literal(ChatFormatting.AQUA + name + ChatFormatting.WHITE +
                " " + amount + " / " + capacity + " mB"));
    }

    /**
     * Capability provider that wraps CapaFluidContainer for fluid handling.
     */
    private static class ShipTankFluidProvider implements ICapabilityProvider {

        private final CapaFluidContainer fluidHandler;
        private final net.minecraftforge.common.util.LazyOptional<net.minecraftforge.fluids.capability.IFluidHandlerItem> holder;

        public ShipTankFluidProvider(ItemStack stack, int capacity) {
            this.fluidHandler = new CapaFluidContainer(stack, capacity);
            this.holder = net.minecraftforge.common.util.LazyOptional.of(() -> fluidHandler);
        }

        @Override
        public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(
                net.minecraftforge.common.capabilities.Capability<T> cap,
                @Nullable net.minecraft.core.Direction side) {
            if (cap == net.minecraftforge.common.capabilities.ForgeCapabilities.FLUID_HANDLER_ITEM) {
                return holder.cast();
            }
            return net.minecraftforge.common.util.LazyOptional.empty();
        }
    }
}
