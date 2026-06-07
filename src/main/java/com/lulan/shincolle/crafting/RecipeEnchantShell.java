package com.lulan.shincolle.crafting;

import com.google.gson.JsonObject;
import com.lulan.shincolle.init.ModItems;
import com.lulan.shincolle.init.ModRecipes;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Objects;

/**
 * Custom crafting recipe: Enchant Shell
 * <p>
 * Pattern (3x3):
 * P P P
 * P A P
 * P P P
 * <p>
 * Where A = equip_ammo (center), P = identical potion items (all 8 surrounding
 * slots).
 * <p>
 * The potion effect is applied/stacked onto the ammo item's NBT:
 * - Same potion ID and amplifier as existing: duration += 20 ticks, chance +=
 * 10% (cap 100%)
 * - Different potion or amplifier: reset to duration=100, chance=20%
 * <p>
 * NBT keys on the result ammo:
 * "PID" - potion effect registry ID (String)
 * "PLEVEL" - amplifier (int)
 * "PTIME" - duration in ticks (int)
 * "PCHANCE" - chance percentage (int, max 100)
 */
public class RecipeEnchantShell implements CraftingRecipe {

    private final ResourceLocation id;
    private final CraftingBookCategory category;

    public RecipeEnchantShell(ResourceLocation id, CraftingBookCategory category) {
        this.id = id;
        this.category = category;
    }

    @Override
    public boolean matches(CraftingContainer container, Level level) {
        if (container.getWidth() < 3 || container.getHeight() < 3) {
            return false;
        }

        // Center slot (1, 1) must be equip_ammo
        ItemStack center = container.getItem(container.getWidth() + 1);
        if (center.isEmpty() || center.getItem() != ModItems.EQUIP_AMMO.get()) {
            return false;
        }

        // All 8 surrounding slots must be the same potion item
        ItemStack firstPotion = ItemStack.EMPTY;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (row == 1 && col == 1) {
                    continue; // skip center
                }

                ItemStack stack = container.getItem(row * container.getWidth() + col);

                if (stack.isEmpty()) {
                    return false;
                }

                // Must be a potion item (regular potion, splash, or lingering)
                if (stack.getItem() != Items.POTION
                        && stack.getItem() != Items.SPLASH_POTION
                        && stack.getItem() != Items.LINGERING_POTION) {
                    return false;
                }

                // Must have at least one mob effect
                List<MobEffectInstance> effects = PotionUtils.getMobEffects(stack);
                if (effects.isEmpty()) {
                    return false;
                }

                if (firstPotion.isEmpty()) {
                    firstPotion = stack;
                } else {
                    // All potions must be identical (same potion type via NBT)
                    if (!ItemStack.isSameItemSameTags(firstPotion, stack)) {
                        return false;
                    }
                }
            }
        }

        return !firstPotion.isEmpty();
    }

    @Override
    public ItemStack assemble(CraftingContainer container, RegistryAccess registryAccess) {
        // Get center equip_ammo and copy it
        ItemStack center = container.getItem(container.getWidth() + 1);
        ItemStack result = center.copy();

        // Get potion effect from one of the surrounding potions
        ItemStack potionStack = ItemStack.EMPTY;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (row == 1 && col == 1)
                    continue;
                ItemStack stack = container.getItem(row * container.getWidth() + col);
                if (!stack.isEmpty()) {
                    potionStack = stack;
                    break;
                }
            }
            if (!potionStack.isEmpty())
                break;
        }

        if (potionStack.isEmpty()) {
            return ItemStack.EMPTY;
        }

        List<MobEffectInstance> effects = PotionUtils.getMobEffects(potionStack);
        if (effects.isEmpty()) {
            return ItemStack.EMPTY;
        }

        // Use the first effect from the potion
        MobEffectInstance effect = effects.get(0);
        String potionId = Objects.requireNonNull(ForgeRegistries.MOB_EFFECTS
                .getKey(effect.getEffect())).toString();
        int amplifier = effect.getAmplifier();

        // Apply/stack potion NBT onto the ammo
        CompoundTag tag = result.getOrCreateTag();

        String existingPID = tag.getString("PID");
        int existingLevel = tag.getInt("PLEVEL");

        if (existingPID.equals(potionId) && existingLevel == amplifier) {
            // Same potion and amplifier: stack duration and chance
            int existingTime = tag.getInt("PTIME");
            int existingChance = tag.getInt("PCHANCE");

            tag.putInt("PTIME", existingTime + 20);
            tag.putInt("PCHANCE", Math.min(100, existingChance + 10));
        } else {
            // Different potion or amplifier: reset
            tag.putString("PID", potionId);
            tag.putInt("PLEVEL", amplifier);
            tag.putInt("PTIME", 100);
            tag.putInt("PCHANCE", 20);
        }

        return result;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width >= 3 && height >= 3;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return new ItemStack(ModItems.EQUIP_AMMO.get());
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.ENCHANT_SHELL.get();
    }

    @Override
    public CraftingBookCategory category() {
        return this.category;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.create();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    // ========== Serializer ==========

    public static class Serializer implements RecipeSerializer<RecipeEnchantShell> {

        @Override
        public RecipeEnchantShell fromJson(ResourceLocation id, JsonObject json) {
            CraftingBookCategory category = CraftingBookCategory.CODEC.byName(
                    GsonHelper.getAsString(json, "category", null), CraftingBookCategory.MISC);
            return new RecipeEnchantShell(id, category);
        }

        @Override
        public RecipeEnchantShell fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            CraftingBookCategory category = buf.readEnum(CraftingBookCategory.class);
            return new RecipeEnchantShell(id, category);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, RecipeEnchantShell recipe) {
            buf.writeEnum(recipe.category());
        }
    }
}
