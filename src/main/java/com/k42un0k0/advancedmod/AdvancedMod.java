package com.k42un0k0.advancedmod;

import com.k42un0k0.advancedmod.client.renderer.SpriteLayer;
import com.k42un0k0.advancedmod.codegen.assets.AdvancedItemModelProvider;
import com.k42un0k0.advancedmod.codegen.assets.lang.AdvancedEnUsLanguageProvider;
import com.k42un0k0.advancedmod.effect.AdvancedAttributes;
import com.k42un0k0.advancedmod.effect.AdvancedEffects;
import com.k42un0k0.advancedmod.effect.AdvancedPotions;
import com.k42un0k0.advancedmod.enchantment.AdvancedEnchantments;
import com.k42un0k0.advancedmod.item.AdvancedItems;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AdvancedMod.MOD_ID)
public class AdvancedMod {
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "advancedmod";

    public AdvancedMod() {
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
        // Register ourselves for server and other game events we are interested in
        registerDeferredRegisters(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void registerDeferredRegisters(IEventBus eventBus){
        AdvancedEffects.register(eventBus);
        AdvancedPotions.register(eventBus);
        AdvancedAttributes.register(eventBus);
        AdvancedEnchantments.register(eventBus);
        AdvancedItems.register(eventBus);
    }

    // Register the setup method for modloading
    @SubscribeEvent
    public void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        AdvancedMod.LOGGER.info("HELLO FROM PREINIT");
        AdvancedMod.LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    // Register the doClientStuff method for modloading
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        AdvancedMod.LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().options);
        EntityRendererManager dispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
        PlayerRenderer defaultPlayerRenderer = new PlayerRenderer(dispatcher);
        defaultPlayerRenderer.addLayer(new SpriteLayer(defaultPlayerRenderer, Minecraft.getInstance().gameRenderer));
        dispatcher.defaultPlayerRenderer = defaultPlayerRenderer;
        dispatcher.playerRenderers.put("default", defaultPlayerRenderer);
        dispatcher.playerRenderers.put("slim", new PlayerRenderer(dispatcher, true));
    }

    // Register the enqueueIMC method for modloading
    @SubscribeEvent
    public void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> {
            AdvancedMod.LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }

    // Register the processIMC method for modloading
    @SubscribeEvent
    public void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        AdvancedMod.LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m -> m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void registerProviders(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        if (event.includeClient()) {
            gen.addProvider(new AdvancedEnUsLanguageProvider(gen, MOD_ID));
            gen.addProvider(new AdvancedItemModelProvider(gen, MOD_ID, event.getExistingFileHelper()));
        }
        if (event.includeServer()) {
//            gen.addProvider(new ExampleModFluidTagsProvider(gen, MOD_ID,
//                    event.getExistingFileHelper()));
        }
    }
}
