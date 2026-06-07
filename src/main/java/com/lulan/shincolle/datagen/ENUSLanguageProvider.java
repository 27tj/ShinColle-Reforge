package com.lulan.shincolle.datagen;

import com.lulan.shincolle.init.ModItems;
import com.lulan.shincolle.reference.Reference;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class ENUSLanguageProvider extends LanguageProvider {
    public ENUSLanguageProvider(PackOutput output) {
        super(output, Reference.MOD_ID, Locale.US.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(ModItems.GRUDGE, "Grudge");
        addItem(ModItems.ABYSS_METAL, "Abyss Metal");

    }
}
