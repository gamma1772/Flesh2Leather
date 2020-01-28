package com.codenamerevy.flesh2leather;

import com.codenamerevy.flesh2leather.config.Config;
import com.codenamerevy.flesh2leather.util.Ref;
import com.codenamerevy.flesh2leather.util.handler.EventHandler;
import com.codenamerevy.flesh2leather.util.handler.RegistryHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Ref.MODID)
public class Flesh2Leather
{
    public Flesh2Leather()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);

        MinecraftForge.EVENT_BUS.addListener(Config::onLoad);
        MinecraftForge.EVENT_BUS.addListener(Config::onFileChange);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }
    private void commonSetup(final FMLCommonSetupEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new RegistryHandler());
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }
}
