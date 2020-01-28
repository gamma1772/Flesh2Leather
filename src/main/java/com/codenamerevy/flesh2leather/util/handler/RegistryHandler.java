package com.codenamerevy.flesh2leather.util.handler;

import com.codenamerevy.flesh2leather.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler
{
    @SubscribeEvent
    public static void onItemRegistry(final RegistryEvent.Register<Item> event)
    {
        ItemRegistry(event.getRegistry());
    }

    public static void ItemRegistry(IForgeRegistry<Item> registry)
    {
        registry.register(ItemInit.COMBINED_FLESH);
        registry.register(ItemInit.HARDENED_FLESH);
    }
}
