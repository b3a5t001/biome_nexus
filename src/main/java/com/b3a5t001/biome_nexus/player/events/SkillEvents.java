package com.b3a5t001.biome_nexus.player.events;

import com.b3a5t001.biome_nexus.player.*;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.server.world.ServerWorld;

public class SkillEvents {
    public static void register() {

        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
            if (!(world instanceof ServerWorld serverWorld)) return;

            PlayerData data = PlayerDataManager.getPlayerData(
                    serverWorld,
                    player.getUuid()
            );
            PlayerSkillState playerState = PlayerSkillState.getServerState(serverWorld);
            
            PlayerSkills skills = playerState.getRuntimeSkill(player.getUuid(), data);

            skills.getSkill(SkillType.MINING).onBlockMined(state);
        });
    }
}
