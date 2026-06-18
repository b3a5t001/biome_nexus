package com.b3a5t001.biome_nexus.player;

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
    private void checkLevelUp(){
        int requiredPoints = playerLevel * 10;
        if(playerPoints >= requiredPoints){
            playerPoints -= requiredPoints;
            playerLevel++;
        }
    }
}
