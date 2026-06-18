package com.b3a5t001.biome_nexus.network;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record LevelSyncPayload(int level) implements CustomPayload {
    public static final Id<LevelSyncPayload> ID =
            new Id<>(Identifier.of("biome_nexus", "level_sync"));

    public static final PacketCodec<RegistryByteBuf, LevelSyncPayload> CODEC =
            PacketCodec.tuple(
                    PacketCodecs.INTEGER,
                    LevelSyncPayload::level,
                    LevelSyncPayload::new
            );

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
