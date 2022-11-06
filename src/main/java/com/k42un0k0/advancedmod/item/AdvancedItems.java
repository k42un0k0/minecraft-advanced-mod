package com.k42un0k0.advancedmod.item;

import com.k42un0k0.advancedmod.AdvancedMod;
import com.k42un0k0.advancedmod.item.custom.GloveItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AdvancedItems {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            AdvancedMod.MOD_ID);
    public static final RegistryObject<Item> GLOVE = ITEMS.register("glove",
            () -> new GloveItem(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
