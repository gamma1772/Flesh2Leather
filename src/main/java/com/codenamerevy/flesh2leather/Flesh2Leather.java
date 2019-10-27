package com.codenamerevy.flesh2leather;

import com.codenamerevy.flesh2leather.config.CommonConfig;
import com.codenamerevy.flesh2leather.util.Reference;
import com.codenamerevy.flesh2leather.util.handler.EventHandler;
import com.codenamerevy.flesh2leather.util.handler.RegistryHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(Reference.MODID)
public class Flesh2Leather
{
    public Flesh2Leather()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        MinecraftForge.EVENT_BUS.addListener(RegistryHandler::onItemRegistry);
        MinecraftForge.EVENT_BUS.addListener(EventHandler::registerRecipeSerializers);
        MinecraftForge.EVENT_BUS.register(this);

        CommonConfig.loadConfig(CommonConfig.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("f2l-common.toml"));
    }
    private void setup (final FMLCommonSetupEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new RegistryHandler());
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        Reference.LOGGER.info(Reference.MODNAME + " with ID " + Reference.MODID + " started FMLCommonSetup event.");
    }
}
