package com.b3a5t001.biome_nexus.player.magic;

import net.minecraft.server.network.ServerPlayerEntity;

public interface Spell {
    String getId();

    String getName();

    int getManaCost();

    boolean cast(ServerPlayerEntity player);
}


