package com.b3a5t001.biome_nexus.player.magic;

import com.b3a5t001.biome_nexus.player.magic.spells.FireboltSpell;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class SpellRegistry {
    public static final String FIREBOLT = "firebolt";

    private static final Map<String, Spell> SPELLS = new LinkedHashMap<>();

    public static final Spell FIREBOLT_SPELL = register(new FireboltSpell());

    public static Spell get(String id){
        return SPELLS.get(id);
    }

    public static Collection<Spell> all(){
        return Collections.unmodifiableCollection(SPELLS.values());
    }

    public static void init() {
    }

    public static Spell register(Spell spell){
        if (SPELLS.containsKey(spell.getId())) {
            throw new IllegalArgumentException("Duplicate spell id: " + spell.getId());
        }

        SPELLS.put(spell.getId(), spell);
        return spell;
    }
}
