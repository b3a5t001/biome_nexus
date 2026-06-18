package com.b3a5t001.biome_nexus.player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WorldPlayerData {
    private final Map<UUID, PlayerData> players = new HashMap<>();

    public PlayerData getPlayerData(UUID uuid) {
        return players.computeIfAbsent(uuid, id ->
                new PlayerData());
    }
}
