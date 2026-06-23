package com.b3a5t001.biome_nexus;

import com.b3a5t001.biome_nexus.blocks.BlockEventHandler;
import com.b3a5t001.biome_nexus.blocks.ModBlocks;
import com.b3a5t001.biome_nexus.client.ClientNetworking;
import com.b3a5t001.biome_nexus.entities.ModEntityEvents;
import com.b3a5t001.biome_nexus.blocks.entity.ModBlockEntities;
import com.b3a5t001.biome_nexus.items.ModItemGroup;
import com.b3a5t001.biome_nexus.items.ModItems;
import com.b3a5t001.biome_nexus.network.LevelSyncPayload;
import com.b3a5t001.biome_nexus.network.SkillLevelUpPayload;
import com.b3a5t001.biome_nexus.player.SkillRegistry;
import com.b3a5t001.biome_nexus.player.events.SkillEvents;
import com.b3a5t001.biome_nexus.server.PlayerJoinHandler;
import com.b3a5t001.biome_nexus.sound.ModSoundEvents;
import com.b3a5t001.biome_nexus.world.worldgen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BiomeNexus implements ModInitializer {
	public static final String MOD_ID = "biome_nexus";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		PayloadTypeRegistry.playS2C().register(
				LevelSyncPayload.ID,
				LevelSyncPayload.CODEC
		);
		PayloadTypeRegistry.playS2C().register(
				SkillLevelUpPayload.ID,
				SkillLevelUpPayload.CODEC
		);
		ModItems.init();
		ModBlocks.init();
		ModBlockEntities.init();
		ModItemGroup.init();
		BlockEventHandler.init();
		ModSoundEvents.init();
		ModEntityEvents.init();
		ModWorldGeneration.init();
		PlayerJoinHandler.register();
		SkillRegistry.register();
		SkillEvents.register();
		ClientNetworking.register();
		LOGGER.info("Initialised Biome Nexus");
	}
}
