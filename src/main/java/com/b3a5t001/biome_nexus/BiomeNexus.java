package com.b3a5t001.biome_nexus;

import com.b3a5t001.biome_nexus.blocks.BlockEventHandler;
import com.b3a5t001.biome_nexus.blocks.ModBlocks;
import com.b3a5t001.biome_nexus.items.ModItemGroup;
import com.b3a5t001.biome_nexus.items.ModItems;
import com.b3a5t001.biome_nexus.sound.ModSoundEvents;
import net.fabricmc.api.ModInitializer;

import net.minecraft.sound.BlockSoundGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BiomeNexus implements ModInitializer {
	public static final String MOD_ID = "biome_nexus";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.init();
		ModBlocks.init();
		ModItemGroup.init();
		BlockEventHandler.init();
		ModSoundEvents.init();
		LOGGER.info("Hello Fabric world!");
	}
}