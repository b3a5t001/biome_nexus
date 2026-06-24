package com.b3a5t001.biome_nexus.player;

import net.minecraft.block.BlockState;

public abstract class Skill {
    protected final SkillType type;
    protected SkillData skillData;
    protected final PlayerSkills owner;

    protected int level = 1;
    protected int experience = 0;

    public Skill(SkillType type, SkillData skillData, PlayerSkills owner) {
        this.type = type;
        this.skillData = skillData;
        this.owner = owner;
        this.level = skillData.getLevel();
        this.experience = skillData.getExperience();

    }
    public SkillType getType(){
        return type;
    }

    public int getLevel(){
        return level;
    }
    public int getExperience(){
        return  experience;
    }
    public void addExperience(int amount){
        experience += amount;
        checkLevelUp();
    }
    protected void checkLevelUp(){
        while(experience >= getExperienceRequired()){
            experience -= getExperienceRequired();
            levelUp();
        }
        skillData.setLevel(level);
        skillData.setExperience(experience);

        owner.markDirty();
    }
    protected void levelUp(){
        level++;
        owner.skillLevelUp(type, level);
        onLevelUp();
    }
    protected abstract int getExperienceRequired();
    protected abstract void onLevelUp();

    public void onBlockMined(BlockState state) {

    }
}
