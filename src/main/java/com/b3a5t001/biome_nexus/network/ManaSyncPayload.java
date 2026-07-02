package com.b3a5t001.biome_nexus.network;

import com.b3a5t001.biome_nexus.BiomeNexus;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record ManaSyncPayload(int mana, int maxMana) implements CustomPayload {
    public static final Id<ManaSyncPayload> ID =
            new Id<>(Identifier.of(BiomeNexus.MOD_ID, "mana_sync"));

    public static final PacketCodec<RegistryByteBuf, ManaSyncPayload> CODEC =
            PacketCodec.tuple(
                    PacketCodecs.INTEGER,
                    ManaSyncPayload::mana,
                    PacketCodecs.INTEGER,
                    ManaSyncPayload::maxMana,
                    ManaSyncPayload::new
            );

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
