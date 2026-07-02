package com.b3a5t001.biome_nexus.network;

import com.b3a5t001.biome_nexus.BiomeNexus;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record CastSpellPayload(String spellId) implements CustomPayload {
    public static final Id<CastSpellPayload> ID =
            new Id<>(Identifier.of(BiomeNexus.MOD_ID, "cast_spell"));

    public static final PacketCodec<RegistryByteBuf, CastSpellPayload> CODEC =
            PacketCodec.tuple(
                    PacketCodecs.STRING,
                    CastSpellPayload::spellId,
                    CastSpellPayload::new
            );

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
