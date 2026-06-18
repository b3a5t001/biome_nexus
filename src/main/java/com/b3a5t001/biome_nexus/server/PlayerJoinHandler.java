package com.b3a5t001.biome_nexus.server;

import com.b3a5t001.biome_nexus.network.LevelSyncPayload;
import com.b3a5t001.biome_nexus.player.PlayerData;
import com.b3a5t001.biome_nexus.player.PlayerDataManager;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class PlayerJoinHandler {
    public static void register() {
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            PlayerData data = PlayerDataManager.getPlayerData(
                    handler.player.getServerWorld(),
                    handler.player.getUuid()
            );
            ServerPlayNetworking.send(
                    handler.player,
                    new LevelSyncPayload(data.getPlayerLevel())
            );
        });
    }
}
