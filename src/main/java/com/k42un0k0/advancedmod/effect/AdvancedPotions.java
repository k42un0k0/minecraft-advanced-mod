package com.k42un0k0.advancedmod.effect;

import com.k42un0k0.advancedmod.AdvancedMod;
import com.k42un0k0.advancedmod.effect.custom.FastEffect;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AdvancedPotions {

    public static DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES,
            AdvancedMod.MOD_ID);
    public static final RegistryObject<Potion> FAST = POTIONS.register("fast",
            () -> (new Potion(new EffectInstance(AdvancedEffects.FAST.get(),3600))));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
