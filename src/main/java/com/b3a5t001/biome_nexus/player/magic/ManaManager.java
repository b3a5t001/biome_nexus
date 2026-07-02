package com.b3a5t001.biome_nexus.player.magic;

import net.minecraft.nbt.NbtCompound;

public class ManaManager {
    private static final int DEFAULT_MAX_MANA = 20;
    private static final int DEFAULT_REGENERATION_DELAY = 100;

    private int manaCount;
    private int maxMana;

    private int regenerationDelay;
    private int regenerationTimer;

    public ManaManager() {
        this(DEFAULT_MAX_MANA, DEFAULT_REGENERATION_DELAY);
    }

    public ManaManager(int maxMana, int regenerationDelay) {
        this.maxMana = Math.max(1, maxMana);
        this.manaCount = this.maxMana;
        this.regenerationDelay = Math.max(1, regenerationDelay);
    }

    public int getManaCount() {
        return manaCount;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setManaCount(int manaCount) {
        this.manaCount = Math.clamp(manaCount, 0, maxMana);
    }

    public boolean consumeMana(int amount) {
        if (amount <= 0) {
            return true;
        }

        if (manaCount >= amount) {
            manaCount -= amount;
            regenerationTimer = 0;
            return true;
        }

        return false;
    }

    public void addMana(int amount) {
        if (amount <= 0) {
            return;
        }

        setManaCount(manaCount + amount);
    }

    public boolean tickRegeneration() {
        if (manaCount >= maxMana) {
            regenerationTimer = 0;
            return false;
        }

        regenerationTimer++;

        if (regenerationTimer >= regenerationDelay) {
            manaCount++;
            regenerationTimer = 0;
            return true;
        }

        return false;
    }

    public NbtCompound writeNbt() {
        NbtCompound nbt = new NbtCompound();

        nbt.putInt("manaCount", manaCount);
        nbt.putInt("maxMana", maxMana);
        nbt.putInt("regenerationDelay", regenerationDelay);
        nbt.putInt("regenerationTimer", regenerationTimer);

        return nbt;
    }

    public static ManaManager fromNbt(NbtCompound nbt) {
        int maxMana = nbt.contains("maxMana")
                ? nbt.getInt("maxMana")
                : DEFAULT_MAX_MANA;
        int regenerationDelay = nbt.contains("regenerationDelay")
                ? nbt.getInt("regenerationDelay")
                : DEFAULT_REGENERATION_DELAY;

        ManaManager manaManager = new ManaManager(maxMana, regenerationDelay);
        manaManager.setManaCount(nbt.contains("manaCount")
                ? nbt.getInt("manaCount")
                : maxMana);
        manaManager.regenerationTimer = nbt.contains("regenerationTimer")
                ? Math.max(0, nbt.getInt("regenerationTimer"))
                : 0;

        return manaManager;
    }
}
