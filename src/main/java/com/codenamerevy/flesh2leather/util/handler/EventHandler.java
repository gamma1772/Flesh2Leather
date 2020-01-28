package com.codenamerevy.flesh2leather.util.handler;

import com.codenamerevy.flesh2leather.content.items.ItemConditions;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventHandler
{
    @SubscribeEvent
    public static void registerRecipeSerializers(RegistryEvent<IRecipeSerializer<?>> event)
    {
        CraftingHelper.register(ItemConditions.Serializer.INSTANCE);
    }
}
