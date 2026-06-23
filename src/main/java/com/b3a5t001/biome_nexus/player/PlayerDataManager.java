package com.b3a5t001.biome_nexus.player;

import net.minecraft.server.world.ServerWorld;

import java.util.UUID;

public class PlayerDataManager {
    public static PlayerData getPlayerData(ServerWorld world, UUID uuid) {
        PlayerSkillState state = PlayerSkillState.getServerState(world);
        return state.getPlayerData(uuid);
    }
}
