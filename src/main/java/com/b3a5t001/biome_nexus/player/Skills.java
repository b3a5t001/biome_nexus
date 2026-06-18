package com.b3a5t001.biome_nexus.player;

public abstract class Skills {
    protected final SkillType type;

    protected int level= 1;
    protected int experience = 0;

    public Skills(SkillType type){
        this.type  = type;
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
        if(experience >= getExperienceRequired()){
            experience -= getExperienceRequired();
            levelUp();
        }
    }
    protected void levelUp(){
        level++;
    }
    protected abstract int getExperienceRequired();
}
