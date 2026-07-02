package com.b3a5t001.biome_nexus.client;

import com.b3a5t001.biome_nexus.player.magic.Spell;
import com.b3a5t001.biome_nexus.player.magic.SpellRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ClientSpellBook {
    private static final Map<String, SpellBookEntry> SPELLS = new LinkedHashMap<>();

    static {
        register(SpellRegistry.FIREBOLT, Items.FIRE_CHARGE);
    }

    private ClientSpellBook() {
    }

    public static Collection<SpellBookEntry> all() {
        return Collections.unmodifiableCollection(SPELLS.values());
    }

    public static SpellBookEntry get(String id) {
        return SPELLS.get(id);
    }

    public static SpellBookEntry getSelected() {
        return get(ClientPlayerData.getSelectedSpellId());
    }

    private static void register(String spellId, Item icon) {
        Spell spell = SpellRegistry.get(spellId);
        if (spell != null) {
            SPELLS.put(spellId, new SpellBookEntry(spell, new ItemStack(icon)));
        }
    }
}
