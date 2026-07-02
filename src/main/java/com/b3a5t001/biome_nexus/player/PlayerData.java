package com.b3a5t001.biome_nexus.player;

import com.b3a5t001.biome_nexus.player.magic.ManaManager;
import net.minecraft.nbt.NbtCompound;
import java.util.HashMap;
import java.util.Map;

public class PlayerData {
    private int playerLevel = 1;
    private int playerPoints = 0;
    private final Map<String, SkillData> skillData = new HashMap<>();

    private Runnable onLevelUp;

    private ManaManager manaManager = new ManaManager();

    private int getRequiredPoints(){
        return (int)(5 * Math.pow(1.5, playerLevel - 1));
    }

    public int getPlayerLevel(){
        return this.playerLevel;
    }
    public int getPlayerPoints(){
        return this.playerPoints;
    }

    public void addPlayerPoints(int points){
        playerPoints += points;
        checkLevelUp();
    }
    public void setPlayerLevel(int level){
        this.playerLevel = level;
    }
    public void setPlayerPoints(int points){
        this.playerPoints = points;
    }
    private void checkLevelUp(){
        if(playerPoints >= getRequiredPoints()){
            playerPoints -= getRequiredPoints();
            playerLevel++;

            if(onLevelUp != null){
                onLevelUp.run();
            }
        }
    }
    public SkillData getSkillData(String skillKey) {
        return skillData.computeIfAbsent(skillKey, k -> new SkillData());
    }

    public NbtCompound writeNbt() {
        NbtCompound nbt = new NbtCompound();

        nbt.putInt("playerLevel", playerLevel);
        nbt.putInt("playerPoints", playerPoints);

        NbtCompound skillsNbt = new NbtCompound();
        for (var entry : skillData.entrySet()) {
            skillsNbt.put(entry.getKey(), entry.getValue().writeNbt());
        }
        nbt.put("skills", skillsNbt);
        nbt.put("mana", manaManager.writeNbt());

        return nbt;
    }
    public static PlayerData fromNbt(NbtCompound nbt) {
        PlayerData data = new PlayerData();

        data.playerLevel = nbt.getInt("playerLevel");
        data.playerPoints = nbt.getInt("playerPoints");

        NbtCompound skillsNbt = nbt.getCompound("skills");
        for (String key : skillsNbt.getKeys()) {
            data.skillData.put(key, SkillData.fromNbt(skillsNbt.getCompound(key)));
        }

        if (nbt.contains("mana")) {
            data.manaManager = ManaManager.fromNbt(nbt.getCompound("mana"));
        }

        return data;
    }
    public void setOnLevelUp(Runnable callBack){
        this.onLevelUp = callBack;
    }

    public ManaManager getManaManager() {
        return manaManager;
    }
}
