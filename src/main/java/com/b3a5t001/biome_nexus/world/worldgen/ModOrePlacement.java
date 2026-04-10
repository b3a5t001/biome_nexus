package com.b3a5t001.biome_nexus.world.worldgen;

import com.b3a5t001.biome_nexus.util.ModTags;
import com.b3a5t001.biome_nexus.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModOrePlacement {
    public static void placeOres(){
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.TIN_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.Biomes.PLAINS_VARIANTS), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.PLAINS_TIN_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.Biomes.IS_CAVE), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.CAVE_COBALT_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.COBALT_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.LIMESTONE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.JADE_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_JUNGLE), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.LUSH_JADE_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.SCULK_SLATE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.Biomes.IS_FROZEN), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.ICE_ROCK_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.NETHER_SULFUR_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.END_CRIMSONTE_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BASALT_DELTAS), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.QUARTZ_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BASALT_DELTAS), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.NETHER_GOLD_ORE_PLACED_KEY);
    }
}
