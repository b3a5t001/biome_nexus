package com.b3a5t001.biome_nexus.player;

import net.minecraft.server.world.ServerWorld;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerDataManager {
    private static final Map<ServerWorld, WorldPlayerData> WORLD = new HashMap<>();

    public static PlayerData getPlayerData(ServerWorld world, UUID uuid) {
        WorldPlayerData worldData = WORLD.computeIfAbsent(world, w ->
                new WorldPlayerData());
        return worldData.getPlayerData(uuid);
    }
}
