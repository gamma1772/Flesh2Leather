package com.codenamerevy.flesh2leather;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod("flesh2leather")
public class Flesh2Leather
{
    private static final String MODID = "flesh2leather";

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    private static final RegistryObject<Item> COMBINED_FLESH = ITEMS.register("combined_flesh", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    public Flesh2Leather()
    {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ITEMS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
