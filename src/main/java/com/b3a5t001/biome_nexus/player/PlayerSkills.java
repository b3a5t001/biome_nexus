package com.b3a5t001.biome_nexus.player;

import com.b3a5t001.biome_nexus.network.SkillLevelUpPayload;
import com.b3a5t001.biome_nexus.player.skills.MiningSkill;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.HashMap;
import java.util.Map;

public class PlayerSkills {

    private final Map<SkillType, Skill> skills = new HashMap<>();
    private final PlayerSkillState playerSkillState;
    private final ServerPlayerEntity player;

    public PlayerSkills(PlayerData data, PlayerSkillState playerSkillState, ServerPlayerEntity player) {
        this.playerSkillState = playerSkillState;
        this.player = player;
        SkillData miningData = data.getSkillData("mining");
        skills.put(SkillType.MINING, new MiningSkill(miningData, this));
    }
    public void skillLevelUp(SkillType type, int level){
        ServerPlayNetworking.send(player,
                new SkillLevelUpPayload(type, level));
    }

    public Skill getSkill(SkillType type) {
        return skills.get(type);
    }

    public void markDirty() {
        playerSkillState.markDirty();
    }
}
