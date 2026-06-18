package com.b3a5t001.biome_nexus.player.skills;

import com.b3a5t001.biome_nexus.player.SkillType;
import com.b3a5t001.biome_nexus.player.Skills;

public class MiningSkill extends Skills {
    public MiningSkill() {
        super(SkillType.MINING);
    }

    @Override
    protected int getExperienceRequired() {
        return level * 100;
    }
}
