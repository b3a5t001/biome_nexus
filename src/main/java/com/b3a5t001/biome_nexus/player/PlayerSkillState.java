package com.b3a5t001.biome_nexus.player;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.PersistentState;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerSkillState extends PersistentState {
    private final Map<UUID, PlayerData> players = new HashMap<>();

    public PlayerData getPlayerData(UUID uuid) {
        return players.computeIfAbsent(uuid, id ->
                new PlayerData());
    }

    public static final Type<PlayerSkillState> TYPE = new Type<>(
            PlayerSkillState::new,
            PlayerSkillState::fromNbt,
            null
    );
    private static PlayerSkillState fromNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        return new PlayerSkillState();
    }
    public static PlayerSkillState getServerState(ServerWorld world) {
        return world.getPersistentStateManager().getOrCreate(
                TYPE,
                "player_skills"
        );
    }

    public boolean hasPlayer(UUID uuid){
        return players.containsKey(uuid);
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        NbtCompound playersNbt = new NbtCompound();
        for (UUID uuid : players.keySet()) {
            playersNbt.putBoolean(uuid.toString(), true);
        }
        nbt.put("players", playersNbt);
        return nbt;
    }
}
