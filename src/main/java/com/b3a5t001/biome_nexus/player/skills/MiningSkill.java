package com.b3a5t001.biome_nexus.player.skills;

import com.b3a5t001.biome_nexus.player.SkillType;
import com.b3a5t001.biome_nexus.player.Skill;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;

public class MiningSkill extends Skill {
    public MiningSkill() {
        super(SkillType.MINING);
    }

    @Override
    public void onBlockMined(BlockState state){
        if (state.isIn(BlockTags.COAL_ORES)){
            System.out.println("+25xp");
            addExperience(25);
        }
    }

    @Override
    protected int getExperienceRequired() {
        return level * 100;
    }

    @Override
    protected void onLevelUp() {
        System.out.println("Mining leveled up to " + level);
    }

}
