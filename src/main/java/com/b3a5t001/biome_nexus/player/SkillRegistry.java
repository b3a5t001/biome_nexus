package com.b3a5t001.biome_nexus.player;

import com.b3a5t001.biome_nexus.player.skills.FarmingSkill;
import com.b3a5t001.biome_nexus.player.skills.MiningSkill;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class SkillRegistry {private static Map<SkillType, BiFunction<SkillData, PlayerSkills, Skill>> SKILLS = new HashMap<>();

    public static void register(){
        SKILLS.put(SkillType.MINING, MiningSkill::new);
        SKILLS.put(SkillType.FARMING, FarmingSkill::new);
    }
    public static Map<SkillType, BiFunction<SkillData, PlayerSkills, Skill>> getSkills(){
        return SKILLS;
    }
}
