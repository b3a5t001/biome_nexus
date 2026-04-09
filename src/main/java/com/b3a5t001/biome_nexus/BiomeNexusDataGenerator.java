package com.b3a5t001.biome_nexus;

import com.b3a5t001.biome_nexus.datagen.*;
import com.b3a5t001.biome_nexus.items.trims.ModTrimMaterials;
import com.b3a5t001.biome_nexus.items.trims.ModTrimPatterns;
import com.b3a5t001.biome_nexus.world.ModConfiguredFeatures;
import com.b3a5t001.biome_nexus.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class BiomeNexusDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		generator.createPack().addProvider(ModModelProvider::new);
		generator.createPack().addProvider(ModChainBarsModelProvider::new);
		generator.createPack().addProvider(ModBlockTagProvider::new);
		generator.createPack().addProvider(ModItemTagProvider::new);
		generator.createPack().addProvider(ModLootTableProvider::new);
		generator.createPack().addProvider(ModRecipeProvider::new);
		generator.createPack().addProvider(ModRegistryDataProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.TRIM_MATERIAL, ModTrimMaterials::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.TRIM_PATTERN, ModTrimPatterns::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}
}
