package com.b3a5t001.biome_nexus.network;

import com.b3a5t001.biome_nexus.BiomeNexus;
import com.b3a5t001.biome_nexus.player.SkillType;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record SkillLevelUpPayload(SkillType skill, int level) implements CustomPayload {

    public static final Id<SkillLevelUpPayload> ID =
            new Id<>(Identifier.of(BiomeNexus.MOD_ID, "skill_level_up"));

    public static final PacketCodec<RegistryByteBuf, SkillLevelUpPayload> CODEC =
            PacketCodec.tuple(
                    SkillType.PACKET_CODEC,
                    SkillLevelUpPayload::skill,
                    PacketCodecs.INTEGER,
                    SkillLevelUpPayload::level,
                    SkillLevelUpPayload::new
            );

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
