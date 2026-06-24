package com.b3a5t001.biome_nexus.player;

import net.minecraft.nbt.NbtCompound;

public class SkillData {
    private int level = 1;
    private int experience = 0;

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public NbtCompound writeNbt() {
        NbtCompound nbt = new NbtCompound();
        nbt.putInt("level", level);
        nbt.putInt("experience", experience);
        return nbt;
    }

    public static SkillData fromNbt(NbtCompound nbt) {
        SkillData data = new SkillData();
        data.level = nbt.getInt("level");
        data.experience = nbt.getInt("experience");
        return data;
    }
}
