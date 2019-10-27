package com.codenamerevy.flesh2leather.init;

import com.codenamerevy.flesh2leather.items.ItemBase;
import com.codenamerevy.flesh2leather.util.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemInit
{
    public static final Item COMBINED_FLESH = new ItemBase(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("combined_flesh"));
    public static final Item HARDENED_FLESH = new ItemBase(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("hardened_flesh"));

    public static void ItemRegistry(IForgeRegistry<Item> registry)
    {
        registry.register(COMBINED_FLESH);
        registry.register(HARDENED_FLESH);
    }

    private static ResourceLocation location(String name)
    {
        return new ResourceLocation(Reference.MODID, name);
    }
}
