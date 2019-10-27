package com.codenamerevy.flesh2leather.util.handler;

import com.codenamerevy.flesh2leather.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler
{
    @SubscribeEvent
    public static void onItemRegistry(final RegistryEvent.Register<Item> event)
    {
        ItemInit.ItemRegistry(event.getRegistry());
    }
}
