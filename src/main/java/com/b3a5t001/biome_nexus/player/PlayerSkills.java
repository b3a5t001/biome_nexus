package com.b3a5t001.biome_nexus.player;

import com.b3a5t001.biome_nexus.player.skills.MiningSkill;

import java.util.HashMap;
import java.util.Map;

public class PlayerSkills {

    private final Map<SkillType, Skill> skills = new HashMap<>();

    public PlayerSkills() {
        System.out.println("NEW PLAYER SKILLS CREATED");
        skills.put(SkillType.MINING, new MiningSkill());
    }

    public Skill getSkill(SkillType type) {
        return skills.get(type);
    }
}
