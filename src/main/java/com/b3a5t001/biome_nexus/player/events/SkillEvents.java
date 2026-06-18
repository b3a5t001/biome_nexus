package com.b3a5t001.biome_nexus.player.events;

import com.b3a5t001.biome_nexus.player.PlayerSkills;
import com.b3a5t001.biome_nexus.player.SkillType;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SkillEvents {
    private static final Map<World, Map<UUID, PlayerSkills>> PLAYER_SKILLS = new HashMap<>();

    public static void register() {

        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {

            Map<UUID, PlayerSkills> worldSkills = PLAYER_SKILLS.computeIfAbsent(
                    world,
                    key -> new HashMap<>()
            );

            PlayerSkills skills = worldSkills.computeIfAbsent(
                    player.getUuid(),
                    uuid -> new PlayerSkills()
            );

            skills.getSkill(SkillType.MINING).onBlockMined(state);
        });
    }
}
