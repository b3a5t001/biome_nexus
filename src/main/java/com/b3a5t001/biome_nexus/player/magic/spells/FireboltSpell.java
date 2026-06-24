package com.b3a5t001.biome_nexus.player.magic.spells;

import com.b3a5t001.biome_nexus.player.magic.Spell;
import com.b3a5t001.biome_nexus.player.magic.SpellRegistry;
import net.minecraft.server.network.ServerPlayerEntity;

public class FireboltSpell implements Spell {
    @Override
    public String getId() {
        return SpellRegistry.FIREBOLT;
    }

    @Override
    public String getName() {
        return "Firebolt";
    }

    @Override
    public int getManaCost() {
        return 0;
    }

    @Override
    public boolean cast(ServerPlayerEntity player) {
        return false;
    }
}
