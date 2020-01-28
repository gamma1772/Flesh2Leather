package com.codenamerevy.flesh2leather.content.items;

import com.codenamerevy.flesh2leather.config.Config;
import com.codenamerevy.flesh2leather.util.Ref;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ItemConditions implements ICondition
{
    public static final ResourceLocation NAME = new ResourceLocation(Ref.MODID, "items");
    public static String OBJECT;

    public ItemConditions (String object)
    {
        this.OBJECT = object;
    }

    @Override
    public ResourceLocation getID()
    {
        return NAME;
    }

    @Override
    public boolean test()
    {
        if(OBJECT.equals("furnace_cfg"))    return Config.GENERAL.furnaceRecipe.get();
        if(OBJECT.equals("smoker_cfg"))     return Config.GENERAL.smokerRecipe.get();
        if(OBJECT.equals("simple_cfg"))     return Config.GENERAL.simpleRecipe.get();
        if(OBJECT.equals("easy_cfg"))       return Config.GENERAL.easyMode.get();
        if(OBJECT.equals("hard_cfg"))       return Config.GENERAL.hardMode.get();
        if(OBJECT.equals("baby_cfg"))       return Config.GENERAL.babyMode.get();
        if(OBJECT.equals("ez_cfg"))         return Config.GENERAL.EZMode.get();

        return false;
    }

    public static class Serializer implements IConditionSerializer<ItemConditions> {
        public static final ItemConditions.Serializer INSTANCE = new ItemConditions.Serializer();

        @Override
        public void write(JsonObject json, ItemConditions value) {}

        @Override
        public ItemConditions read(JsonObject json) {
            return new ItemConditions(json.get("object").getAsString());
        }

        @Override
        public ResourceLocation getID() {
            return NAME;
        }
    }
}
