package com.k42un0k0.advancedmod.effect;

import com.k42un0k0.advancedmod.AdvancedMod;
import com.k42un0k0.advancedmod.effect.custom.FastEffect;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AdvancedEffects {

    public static DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS,
            AdvancedMod.MOD_ID);
    public static final RegistryObject<Effect> FAST = EFFECTS.register("fast",
            () -> (new FastEffect(EffectType.BENEFICIAL,
                    8171462)));

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}
