package com.b3a5t001.biome_nexus.player;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.PersistentState;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerSkillState extends PersistentState {
    private final Map<UUID, PlayerData> players = new HashMap<>();
    private final Map<UUID, PlayerSkills> runtimeSkills = new HashMap<>();

    public PlayerData getPlayerData(UUID uuid) {
        return players.computeIfAbsent(uuid, id ->
                new PlayerData());
    }

    public static final Type<PlayerSkillState> TYPE = new Type<>(
            PlayerSkillState::new,
            PlayerSkillState::fromNbt,
            null
    );
    private static PlayerSkillState fromNbt(
            NbtCompound nbt,
            RegistryWrapper.WrapperLookup registryLookup
    ) {

        PlayerSkillState state = new PlayerSkillState();

        NbtCompound playersNbt = nbt.getCompound("players");

        for (String key : playersNbt.getKeys()) {

            UUID uuid = UUID.fromString(key);
            PlayerData data = PlayerData.fromNbt(playersNbt.getCompound(key));

            state.players.put(uuid, data);
        }

        return state;
    }
    public PlayerSkills getRuntimeSkill(UUID uuid, ServerPlayerEntity player) {
        return runtimeSkills.computeIfAbsent(uuid, id -> {
            PlayerData data = players.get(uuid);
            return new PlayerSkills(data, this, player);
        });
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

    public void rebuildRuntime(ServerPlayerEntity player) {
        runtimeSkills.clear();

        for (var entry : players.entrySet()) {
            UUID uuid = entry.getKey();
            PlayerData data = entry.getValue();

            runtimeSkills.put(uuid, new PlayerSkills(data, this, player));
        }
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {

        NbtCompound playersNbt = new NbtCompound();

        for (var entry : players.entrySet()) {

            playersNbt.put(
                    entry.getKey().toString(),
                    entry.getValue().writeNbt()
            );
        }

        nbt.put("players", playersNbt);
        return nbt;
    }
}
