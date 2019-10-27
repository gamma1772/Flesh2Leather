package com.codenamerevy.flesh2leather.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.nio.file.Path;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonConfig
{
    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec COMMON_CONFIG;

    public static ForgeConfigSpec.BooleanValue enableFurnaceRecipe;
    public static ForgeConfigSpec.BooleanValue enableSmokerRecipe;
    public static ForgeConfigSpec.BooleanValue easyModeRecipes;
    public static ForgeConfigSpec.BooleanValue hardModeRecipes;

    static
    {
        init(COMMON_BUILDER);
        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();

        configData.load();

        spec.setConfig(configData);
    }

    public static void init(ForgeConfigSpec.Builder SERVER_BUILDER)
    {
        COMMON_BUILDER.comment("Furnace Recipe");
        enableFurnaceRecipe = COMMON_BUILDER
                .comment("Enable / Disable Furnace Recipe. [True / False] (DEFAULT: False)")
                .define("furnaceRecipeEnabled", false);

        COMMON_BUILDER.comment("Smoker Recipe");
        enableSmokerRecipe = COMMON_BUILDER
                .comment("Enable / Disable Smoker Recipe. [True / False] (DEFAULT: True)")
                .define("smokerRecipeEnabled", true);

        COMMON_BUILDER.comment("Easy Mode Recipes");
        easyModeRecipes = COMMON_BUILDER
                .comment("Enable / Disable Easy Mode Recipes. [True / False] (DEFAULT: False)")
                .define("easyRecipesEnabled", false);

        COMMON_BUILDER.comment("Hard Mode Recipes");
        hardModeRecipes = COMMON_BUILDER
                .comment("Enable / Disable Hard Mode Recipes [True / False] (DEFAULT: True)")
                .define("hardRecipseEnabled", true);
    }
}
