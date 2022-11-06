package com.k42un0k0.advancedmod.codegen.assets;

import com.k42un0k0.advancedmod.item.AdvancedItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class AdvancedItemModelProvider extends ItemModelProvider {
    public AdvancedItemModelProvider(DataGenerator gen, String modId, ExistingFileHelper existingFileHelper) {
        super(gen, modId, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(AdvancedItems.GLOVE.get());
    }

    private void simpleItem(Item item) {
        ResourceLocation name = Objects.requireNonNull(item.getRegistryName());
        singleTexture(name.getPath(), mcLoc(folder + "/generated"), "layer0", new ResourceLocation(name.getNamespace(), folder + "/" + name.getPath()));
    }

}
