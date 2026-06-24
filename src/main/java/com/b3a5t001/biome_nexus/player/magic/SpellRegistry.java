package com.b3a5t001.biome_nexus.player.magic;

import com.b3a5t001.biome_nexus.player.magic.spells.FireboltSpell;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class SpellRegistry {
    public static final String FIREBOLT = "firebolt";

    private static final Map<String, Spell> SPELLS = new LinkedHashMap<>();

    static{
        register(new FireboltSpell());
    }
    public static Spell get(String id){
        return SPELLS.get(id);
    }

    public static Collection<Spell> all(){
        return SPELLS.values();
    }

    private static void register(Spell spell){
        SPELLS.put(spell.getName(), spell);
    }
}
