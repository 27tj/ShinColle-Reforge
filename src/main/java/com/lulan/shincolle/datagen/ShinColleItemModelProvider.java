package com.lulan.shincolle.datagen;

import com.lulan.shincolle.reference.Reference;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ShinColleItemModelProvider extends ItemModelProvider {
    public ShinColleItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Reference.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    }
}
