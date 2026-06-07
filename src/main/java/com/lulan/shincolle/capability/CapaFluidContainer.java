package com.lulan.shincolle.capability;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;

import javax.annotation.Nonnull;

/**
 * Fluid capability for itemstack containers.
 * <p>
 * Provides fill/drain operations with NBT-backed fluid storage.
 * Capacity is initialized lazily to handle item creation ordering.
 */
public class CapaFluidContainer implements IFluidHandlerItem {

    public static final String FLUID_NBT_KEY = "Fluid";

    protected ItemStack stack;
    protected int capacity;
    protected boolean needInit = true;

    public CapaFluidContainer(ItemStack stack) {
        this.stack = stack;
        this.capacity = 1000; // default 1000 mb
    }

    public CapaFluidContainer(ItemStack stack, int capacity) {
        this.stack = stack;
        this.capacity = capacity;
        this.needInit = false;
    }

    /**
     * Initialize capacity from item properties if needed
     */
    protected void initCapacity() {
        if (this.needInit && !this.stack.isEmpty()) {
            // Capacity can be set by subclasses or via constructor
            this.needInit = false;
        }
    }

    @Nonnull
    @Override
    public ItemStack getContainer() {
        return stack;
    }

    @Nonnull
    public FluidStack getFluid() {
        CompoundTag tag = stack.getTag();

        if (tag == null || !tag.contains(FLUID_NBT_KEY)) {
            return FluidStack.EMPTY;
        }

        return FluidStack.loadFluidStackFromNBT(tag.getCompound(FLUID_NBT_KEY));
    }

    protected void setFluid(FluidStack fluid) {
        if (!stack.hasTag()) {
            stack.setTag(new CompoundTag());
        }

        CompoundTag fluidTag = new CompoundTag();
        fluid.writeToNBT(fluidTag);
        assert stack.getTag() != null;
        stack.getTag().put(FLUID_NBT_KEY, fluidTag);
    }

    // IFluidHandler implementation

    @Override
    public int getTanks() {
        return 1;
    }

    @Nonnull
    @Override
    public FluidStack getFluidInTank(int tank) {
        return getFluid();
    }

    @Override
    public int getTankCapacity(int tank) {
        initCapacity();
        return capacity;
    }

    @Override
    public boolean isFluidValid(int tank, @Nonnull FluidStack stack) {
        return canFillFluidType(stack);
    }

    @Override
    public int fill(FluidStack resource, FluidAction action) {
        initCapacity();

        if (stack.getCount() != 1 || resource.isEmpty() || !canFillFluidType(resource)) {
            return 0;
        }

        FluidStack contained = getFluid();

        if (contained.isEmpty()) {
            int fillAmount = Math.min(capacity, resource.getAmount());

            if (action.execute()) {
                FluidStack filled = resource.copy();
                filled.setAmount(fillAmount);
                setFluid(filled);
            }

            return fillAmount;
        } else {
            if (contained.isFluidEqual(resource)) {
                int fillAmount = Math.min(capacity - contained.getAmount(), resource.getAmount());

                if (action.execute() && fillAmount > 0) {
                    contained.grow(fillAmount);
                    setFluid(contained);
                }

                return fillAmount;
            }

            return 0;
        }
    }

    @Nonnull
    @Override
    public FluidStack drain(FluidStack resource, FluidAction action) {
        initCapacity();

        if (stack.getCount() != 1 || resource.isEmpty() || !resource.isFluidEqual(getFluid())) {
            return FluidStack.EMPTY;
        }

        return drain(resource.getAmount(), action);
    }

    @Nonnull
    @Override
    public FluidStack drain(int maxDrain, FluidAction action) {
        initCapacity();

        if (stack.getCount() != 1 || maxDrain <= 0) {
            return FluidStack.EMPTY;
        }

        FluidStack contained = getFluid();

        if (contained.isEmpty() || !canDrainFluidType(contained)) {
            return FluidStack.EMPTY;
        }

        final int drainAmount = Math.min(contained.getAmount(), maxDrain);
        FluidStack drained = contained.copy();
        drained.setAmount(drainAmount);

        if (action.execute()) {
            contained.shrink(drainAmount);

            if (contained.isEmpty()) {
                setContainerToEmpty();
            } else {
                setFluid(contained);
            }
        }

        return drained;
    }

    public boolean canFillFluidType(FluidStack fluid) {
        return true;
    }

    public boolean canDrainFluidType(FluidStack fluid) {
        return true;
    }

    protected void setContainerToEmpty() {
        if (stack.hasTag()) {
            assert stack.getTag() != null;
            stack.getTag().remove(FLUID_NBT_KEY);
        }
    }
}
