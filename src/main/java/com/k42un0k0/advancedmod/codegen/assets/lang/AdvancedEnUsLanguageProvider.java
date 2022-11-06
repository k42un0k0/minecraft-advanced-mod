package com.k42un0k0.advancedmod.codegen.assets.lang;

import com.k42un0k0.advancedmod.effect.AdvancedEffects;
import com.k42un0k0.advancedmod.item.AdvancedItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class AdvancedEnUsLanguageProvider extends LanguageProvider {
    public AdvancedEnUsLanguageProvider(DataGenerator gen, String modid) {
        super(gen, modid, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(AdvancedEffects.FAST.get(),"Fast up");
        add(AdvancedItems.GLOVE.get(),"Saitama Glove");
        add("item.minecraft.potion.effect.fast","Potion of Fast");
    }
}
