package com.b3a5t001.biome_nexus.world.worldgen;

import com.b3a5t001.biome_nexus.util.ModTags;
import com.b3a5t001.biome_nexus.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModMiscPlacement {
    public static void placeMisc(){
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.Biomes.IS_FROZEN), GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.ICE_ROCK_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.Biomes.IS_COLD), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.AURORITE_GEODE_PLACED_KEY);
    }
}
