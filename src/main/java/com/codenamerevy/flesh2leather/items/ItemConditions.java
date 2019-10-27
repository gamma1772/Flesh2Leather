package com.codenamerevy.flesh2leather.items;

import com.codenamerevy.flesh2leather.config.CommonConfig;
import com.codenamerevy.flesh2leather.util.Reference;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ItemConditions implements ICondition
{
    public static final ResourceLocation NAME = new ResourceLocation(Reference.MODID, "items");
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
        if(OBJECT.equals("furnace_cfg"))    return CommonConfig.enableFurnaceRecipe.get();
        if(OBJECT.equals("smoker_cfg"))     return CommonConfig.enableSmokerRecipe.get();
        if(OBJECT.equals("easy_cfg"))       return CommonConfig.easyModeRecipes.get();
        if(OBJECT.equals("hard_cfg"))       return CommonConfig.hardModeRecipes.get();
        return false;
    }

    public static class Serializer implements IConditionSerializer<ItemConditions> {
        public static final ItemConditions.Serializer INSTANCE = new ItemConditions.Serializer();

        @Override
        public void write(JsonObject json, ItemConditions value) {

        }

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
