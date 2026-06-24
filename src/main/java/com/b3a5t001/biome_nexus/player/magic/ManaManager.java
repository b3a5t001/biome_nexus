package com.b3a5t001.biome_nexus.player.magic;

public class ManaManager {
    private int manaCount;
    private int maxMana;

    private int regenerationDelay;
    private int regenerationTimer;

    public ManaManager() {
        this(20, 100);
    }

    public ManaManager(int maxMana, int regenerationDelay) {
        this.maxMana = maxMana;
        this.manaCount = maxMana;
        this.regenerationDelay = regenerationDelay;
    }

    public int getManaCount() {
        return manaCount;
    }

    public void setManaCount(int manaCount) {
        this.manaCount = Math.min(manaCount, maxMana);
    }

    public boolean consumeMana(int amount) {
        if (manaCount >= amount) {
            manaCount -= amount;
            return true;
        }

        return false;
    }

    public void tickRegeneration() {
        if (manaCount >= maxMana) {
            return;
        }

        regenerationTimer++;

        if (regenerationTimer >= regenerationDelay) {
            manaCount++;
            regenerationTimer = 0;
        }
    }
}