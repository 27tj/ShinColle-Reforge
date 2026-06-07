package com.lulan.shincolle.datagen.server;

import com.lulan.shincolle.loot.AddItemModifier;
import com.lulan.shincolle.reference.Reference;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class ShinColleGlobalLootModifierProvider extends GlobalLootModifierProvider {

    public ShinColleGlobalLootModifierProvider(PackOutput output) {
        super(output, Reference.MOD_ID);
    }

    @Override
    protected void start() {
        add("add_drop", new AddItemModifier(new LootItemCondition[]{}));
    }
}
