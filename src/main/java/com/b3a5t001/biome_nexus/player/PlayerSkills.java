package com.b3a5t001.biome_nexus.player;

import com.b3a5t001.biome_nexus.player.skills.MiningSkill;

import java.util.HashMap;
import java.util.Map;

public class PlayerSkills {

    private final Map<SkillType, Skill> skills = new HashMap<>();
    private final PlayerSkillState playerSkillState;

    public PlayerSkills(PlayerData data, PlayerSkillState playerSkillState) {
        this.playerSkillState = playerSkillState;
        SkillData miningData = data.getSkillData("mining");
        skills.put(SkillType.MINING, new MiningSkill(miningData, this));
    }

    public Skill getSkill(SkillType type) {
        return skills.get(type);
    }

    public void markDirty() {
        playerSkillState.markDirty();
    }
}
