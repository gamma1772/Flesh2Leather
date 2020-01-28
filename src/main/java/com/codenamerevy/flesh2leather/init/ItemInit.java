package com.codenamerevy.flesh2leather.init;

import com.codenamerevy.flesh2leather.content.items.ItemBase;
import com.codenamerevy.flesh2leather.util.Ref;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

public class ItemInit
{
    public static final Item COMBINED_FLESH = new ItemBase(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("combined_flesh"));
    public static final Item HARDENED_FLESH = new ItemBase(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("hardened_flesh"));

    private static ResourceLocation location(String name)
    {
        return new ResourceLocation(Ref.MODID, name);
    }
}
