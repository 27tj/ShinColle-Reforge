package com.lulan.shincolle.init;

import com.lulan.shincolle.crafting.RecipeEnchantShell;
import com.lulan.shincolle.reference.Reference;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Registration class for custom recipe serializers.
 */
public class ModRecipes {

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister
            .create(ForgeRegistries.RECIPE_SERIALIZERS, Reference.MOD_ID);

    public static final RegistryObject<RecipeSerializer<RecipeEnchantShell>> ENCHANT_SHELL = RECIPE_SERIALIZERS
            .register("enchant_shell", RecipeEnchantShell.Serializer::new);
}
