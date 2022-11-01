package com.k42un0k0.advancedmod.effect;

import com.k42un0k0.advancedmod.AdvancedMod;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AdvancedAttributes {
    public static DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES,
            AdvancedMod.MOD_ID);

    public static final RegistryObject<Attribute> MY_ATTR = ATTRIBUTES.register("generic.myattr", () -> (new RangedAttribute(
            "attribute.name.generic.myattr", (double) 0.4F, 0.0D, 1024.0D)).setSyncable(true));

    public static void register(IEventBus eventBus) {
        ATTRIBUTES.register(eventBus);
    }
}
