package com.b3a5t001.biome_nexus.player;

import net.minecraft.nbt.NbtCompound;

public class PlayerData {
    private int playerLevel = 1;
    private int playerPoints = 0;

    public int getPlayerLevel(){
        return this.playerLevel;
    }
    public int getPlayerPoints(){
        return this.playerPoints;
    }
    public void addPlayerPoints(int points){
        playerPoints ++;
        checkLevelUp();
    }
    public void setPlayerLevel(int level){
        this.playerLevel = level;
    }
    public void setPlayerPoints(int points){
        this.playerPoints = points;
    }
    private void checkLevelUp(){
        int requiredPoints = playerLevel * 10;
        if(playerPoints >= requiredPoints){
            playerPoints -= requiredPoints;
            playerLevel++;
        }
    }
    public NbtCompound writeNbt() {
        NbtCompound nbt = new NbtCompound();

        nbt.putInt("playerLevel", playerLevel);
        nbt.putInt("playerPoints", playerPoints);

        return nbt;
    }
    public static PlayerData fromNbt(NbtCompound nbt) {
        PlayerData data = new PlayerData();

        data.playerLevel = nbt.getInt("playerLevel");
        data.playerPoints = nbt.getInt("playerPoints");

        return data;
    }

}
