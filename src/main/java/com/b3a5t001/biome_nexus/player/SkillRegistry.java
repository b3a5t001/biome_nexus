package com.b3a5t001.biome_nexus.player;

import com.b3a5t001.biome_nexus.player.skills.MiningSkill;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SkillRegistry {
    private static Map<SkillType, Supplier<Skill>> SKILLS = new HashMap<>();

    public static void register(){
        SKILLS.put(SkillType.MINING, MiningSkill::new);
    }
    public static Map<SkillType, Supplier<Skill>> getSkills(){
        return SKILLS;
    }
}
