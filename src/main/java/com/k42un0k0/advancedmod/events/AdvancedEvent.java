package com.k42un0k0.advancedmod.events;

import com.k42un0k0.advancedmod.AdvancedMod;
import com.k42un0k0.advancedmod.effect.AdvancedAttributes;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AdvancedEvent {
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        AdvancedMod.LOGGER.info("HELLO from server starting");
    }

    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
        // register a new block here
        AdvancedMod.LOGGER.info("HELLO from Register Block");
    }

    @SubscribeEvent
    public static void registerAttr(EntityAttributeModificationEvent event) {
        event.add(EntityType.PLAYER, AdvancedAttributes.MY_ATTR.get(), 0f);
    }
}