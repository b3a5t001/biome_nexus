package com.b3a5t001.biome_nexus.player;

import com.b3a5t001.biome_nexus.network.LevelSyncPayload;
import com.b3a5t001.biome_nexus.network.SkillLevelUpPayload;
import com.b3a5t001.biome_nexus.player.skills.MiningSkill;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.HashMap;
import java.util.Map;

public class PlayerSkills {

    private final Map<SkillType, Skill> skills = new HashMap<>();
    private final PlayerSkillState playerSkillState;
    private final ServerPlayerEntity player;
    private final PlayerData data;

    public PlayerSkills(PlayerData data, PlayerSkillState playerSkillState, ServerPlayerEntity player) {
        this.playerSkillState = playerSkillState;
        this.player = player;
        this.data = data;
        SkillData miningData = data.getSkillData("mining");
        skills.put(SkillType.MINING, new MiningSkill(miningData, this));
    }
    public void skillLevelUp(SkillType type, int level){
        data.addPlayerPoints(1);
        ServerPlayNetworking.send(player,
                new SkillLevelUpPayload(type, level));

        ServerPlayNetworking.send(player,
                new LevelSyncPayload(data.getPlayerLevel()));
        
        if (data.getPlayerLevel() > 1) {
            player.getServer().getPlayerManager().broadcast(
                    Text.literal(
                            player.getName().getString() +
                                    " has leveled up to Level " +
                                    data.getPlayerLevel()
                    ),
                    false
            );
        }
    }

    public Skill getSkill(SkillType type) {
        return skills.get(type);
    }

    public void markDirty() {
        playerSkillState.markDirty();
    }
}
