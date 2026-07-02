package com.b3a5t001.biome_nexus.player.magic;

public abstract class AbstractSpell implements Spell {
    private final String id;
    private final String name;
    private final int manaCost;

    protected AbstractSpell(String id, String name, int manaCost) {
        this.id = id;
        this.name = name;
        this.manaCost = manaCost;
    }

    @Override
    public final String getId() {
        return id;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final int getManaCost() {
        return manaCost;
    }
}
