package com.codenamerevy.flesh2leather.config;

import com.codenamerevy.flesh2leather.util.Ref;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import static net.minecraftforge.fml.loading.LogMarkers.CORE;
import static net.minecraftforge.fml.loading.LogMarkers.FORGEMOD;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final Builder COMMON_BUILDER = new Builder();

    public static final CategoryGeneral GENERAL = new CategoryGeneral();

    public static final class CategoryGeneral
    {
        public static ForgeConfigSpec.BooleanValue furnaceRecipe;
        public static ForgeConfigSpec.BooleanValue smokerRecipe;
        public static ForgeConfigSpec.BooleanValue easyMode;
        public static ForgeConfigSpec.BooleanValue hardMode;
        public static ForgeConfigSpec.BooleanValue babyMode;
        public static ForgeConfigSpec.BooleanValue EZMode;
        public static ForgeConfigSpec.BooleanValue simpleRecipe;

        private CategoryGeneral()
        {
            COMMON_BUILDER.comment("GENERAL SETTINGS").push("GENERAL");

            COMMON_BUILDER.comment("Furnace Recipe");
            furnaceRecipe = COMMON_BUILDER
                    .comment("Enable Furnace recipe. This OR Smoker recipe is required.")
                    .translation("f2l.config.furnace")
                    .define("furnaceRecipe", false);

            COMMON_BUILDER.comment("Smoker Recipe");
            smokerRecipe = COMMON_BUILDER
                    .comment("Enable Smoker recipe. This OR Furnace recipe is required.")
                    .translation("f2l.config.smoker")
                    .define("smokerRecipe", true);

            COMMON_BUILDER.comment("Simple Recipe");
            simpleRecipe = COMMON_BUILDER
                    .comment("Enable Simple recipe (5 rotten flesh in X = 1 Combined Flesh)")
                    .translation("f2l.config.simple")
                    .define("simpleRecipe", false);

            COMMON_BUILDER.comment("Easy Mode");
            easyMode = COMMON_BUILDER
                    .comment("Enable easier recipe")
                    .translation("f2l.config.easy")
                    .define("easyMode", false);

            COMMON_BUILDER.comment("Hard Mode");
            hardMode = COMMON_BUILDER
                    .comment("Enable harder (normal) recipe")
                    .translation("f2l.config.hard")
                    .define("hardMode", true);

            COMMON_BUILDER.comment("Baby Mode");
            babyMode = COMMON_BUILDER
                    .comment("Enable direct Flesh to Combined Flesh (Smoker OR Furnace enabled is required)")
                    .translation("f2l.config.crybaby")
                    .define("babyMode", false);

            COMMON_BUILDER.comment("EZ Mode");
            EZMode = COMMON_BUILDER
                    .comment("Enable super easy mode. 1 Rotten Flesh = 1 Leather. (Seriously? Do you hate a challenge that much???)")
                    .translation("f2l.config.ihatedifficulty")
                    .define("EZMode", false);

            COMMON_BUILDER.pop();
        }
    }

    public static final ForgeConfigSpec COMMON_CONFIG = COMMON_BUILDER.build();

    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {
        Ref.LOGGER.debug(FORGEMOD, "Loaded {} config file {}", Ref.MODID, configEvent.getConfig().getFileName());
    }

    @SubscribeEvent
    public static void onFileChange(final ModConfig.Reloading configEvent) {
        Ref.LOGGER.fatal(CORE, "{} config just got changed on the file system!", Ref.MODID);
    }
}