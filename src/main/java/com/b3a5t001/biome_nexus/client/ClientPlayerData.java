package com.b3a5t001.biome_nexus.client;

public class ClientPlayerData {
    private static int playerLevel = 1;

    public static int getPlayerLevel() {
        return playerLevel;
    }
    public static void setPlayerLevel(int level){
        playerLevel = level;
    }
}
