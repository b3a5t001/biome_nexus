package com.b3a5t001.biome_nexus.client;

import com.b3a5t001.biome_nexus.player.magic.Spell;
import net.minecraft.item.ItemStack;

public record SpellBookEntry(Spell spell, ItemStack icon) {
    public String id() {
        return spell.getId();
    }

    public String name() {
        return spell.getName();
    }

    public int manaCost() {
        return spell.getManaCost();
    }
}
