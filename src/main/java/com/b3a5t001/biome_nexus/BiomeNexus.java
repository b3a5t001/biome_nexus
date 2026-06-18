package com.b3a5t001.biome_nexus;

import com.b3a5t001.biome_nexus.blocks.BlockEventHandler;
import com.b3a5t001.biome_nexus.blocks.ModBlocks;
import com.b3a5t001.biome_nexus.entities.ModEntityEvents;
import com.b3a5t001.biome_nexus.blocks.entity.ModBlockEntities;
import com.b3a5t001.biome_nexus.items.ModItemGroup;
import com.b3a5t001.biome_nexus.items.ModItems;
import com.b3a5t001.biome_nexus.server.PlayerJoinHandler;
import com.b3a5t001.biome_nexus.sound.ModSoundEvents;
import com.b3a5t001.biome_nexus.world.worldgen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BiomeNexus implements ModInitializer {
	public static final String MOD_ID = "biome_nexus";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.init();
		ModBlocks.init();
		ModBlockEntities.init();
		ModItemGroup.init();
		BlockEventHandler.init();
		ModSoundEvents.init();
		ModEntityEvents.init();
		ModWorldGeneration.init();
		PlayerJoinHandler.register();
		LOGGER.info("Initialised Biome Nexus");
	}
}
