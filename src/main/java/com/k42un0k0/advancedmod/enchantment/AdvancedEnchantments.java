package com.k42un0k0.advancedmod.enchantment;

import com.k42un0k0.advancedmod.AdvancedMod;
import com.k42un0k0.advancedmod.enchantment.custom.SaitamaEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AdvancedEnchantments {
    public static DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS,
            AdvancedMod.MOD_ID);
    public static final RegistryObject<Enchantment> SAITAMA = ENCHANTMENTS.register("saitama",
            () -> new SaitamaEnchantment(Enchantment.Rarity.RARE,
            EquipmentSlotType.MAINHAND));

    public static void register(IEventBus eventBus){
        ENCHANTMENTS.register(eventBus);
    }
}
