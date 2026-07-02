package com.b3a5t001.biome_nexus.client;

import com.b3a5t001.biome_nexus.player.magic.SpellRegistry;

public class ClientPlayerData {
    private static int playerLevel = 1;
    private static int mana = 20;
    private static int maxMana = 20;
    private static String selectedSpellId = SpellRegistry.FIREBOLT;

    public static int getPlayerLevel() {
        return playerLevel;
    }
    public static void setPlayerLevel(int level){
        playerLevel = level;
    }

    public static int getMana() {
        return mana;
    }

    public static int getMaxMana() {
        return maxMana;
    }

    public static void setMana(int mana, int maxMana) {
        ClientPlayerData.maxMana = Math.max(1, maxMana);
        ClientPlayerData.mana = Math.clamp(mana, 0, ClientPlayerData.maxMana);
    }

    public static String getSelectedSpellId() {
        return selectedSpellId;
    }

    public static void setSelectedSpellId(String selectedSpellId) {
        if (selectedSpellId != null) {
            ClientPlayerData.selectedSpellId = selectedSpellId;
        }
    }
}
