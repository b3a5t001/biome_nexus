package com.b3a5t001.biome_nexus.player.skills;

import com.b3a5t001.biome_nexus.player.PlayerSkills;
import com.b3a5t001.biome_nexus.player.SkillType;
import com.b3a5t001.biome_nexus.player.Skill;
import com.b3a5t001.biome_nexus.player.SkillData;
import com.b3a5t001.biome_nexus.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;

public class MiningSkill extends Skill {
    public MiningSkill(SkillData skillData, PlayerSkills playerSkills) {
        super(SkillType.MINING, skillData, playerSkills);
    }

    @Override
    public void onBlockMined(BlockState state){
        if (state.isIn(ModTags.Blocks.COMMON)){
            addExperience(5);
        }else if(state.isIn(ModTags.Blocks.UNCOMMON)){
            addExperience(10);
        }else if(state.isIn(ModTags.Blocks.RARE)){
            addExperience(25);
        }else if(state.isIn(ModTags.Blocks.EPIC)){
            addExperience(50);
        }else if(state.isIn(ModTags.Blocks.LEGENDARY)){
            addExperience(100);
        }
    }

    @Override
    protected int getExperienceRequired() {
        return level * 100;
    }

    @Override
    protected void onLevelUp() {
            }

}
