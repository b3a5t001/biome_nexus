package com.b3a5t001.biome_nexus.network;

import com.b3a5t001.biome_nexus.BiomeNexus;
import net.minecraft.util.Identifier;

public class ModPackets {
    public static final Identifier LEVEL_SYNC =
            Identifier.of(BiomeNexus.MOD_ID, "level_sync");
}
