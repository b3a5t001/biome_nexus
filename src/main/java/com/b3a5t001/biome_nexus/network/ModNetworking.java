package com.b3a5t001.biome_nexus.network;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public class ModNetworking implements ModInitializer {
    @Override
    public void onInitialize() {
        PayloadTypeRegistry.playS2C().register(
                LevelSyncPayload.ID,
                LevelSyncPayload.CODEC
        );

    }
}
