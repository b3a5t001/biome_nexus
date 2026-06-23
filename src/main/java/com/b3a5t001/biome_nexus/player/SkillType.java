package com.b3a5t001.biome_nexus.player;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;

public enum SkillType {
    MINING,FARMING,MAGIC,COMBAT;
    public static final PacketCodec<RegistryByteBuf, SkillType> PACKET_CODEC =
            PacketCodec.of(
                    (type, buf) -> buf.writeInt(type.ordinal()),
                    buf -> SkillType.values()[buf.readInt()]
            );
}
