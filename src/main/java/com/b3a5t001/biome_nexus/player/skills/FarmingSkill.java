package com.b3a5t001.biome_nexus.player.skills;

import com.b3a5t001.biome_nexus.player.PlayerSkills;
import com.b3a5t001.biome_nexus.player.Skill;
import com.b3a5t001.biome_nexus.player.SkillData;
import com.b3a5t001.biome_nexus.player.SkillType;
import com.b3a5t001.biome_nexus.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

public class FarmingSkill extends Skill {
    public FarmingSkill(SkillData skillData, PlayerSkills owner) {
        super(SkillType.FARMING, skillData, owner);
    }
    @Override
    public void onBlockMined(BlockState state){
        if (state.isIn(ModTags.Blocks.CROPS)) {
            addExperience(15);
        }
    }

    @Override
    protected int getExperienceRequired() {
        return level * 50;
    }

    @Override
    protected void onLevelUp() {

    }
}
