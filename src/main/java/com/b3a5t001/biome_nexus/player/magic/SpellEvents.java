package com.b3a5t001.biome_nexus.player.magic;

import com.b3a5t001.biome_nexus.network.CastSpellPayload;
import com.b3a5t001.biome_nexus.player.PlayerData;
import com.b3a5t001.biome_nexus.player.PlayerSkillState;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;

public final class SpellEvents {
    private SpellEvents() {
    }

    public static void register() {
        ServerPlayNetworking.registerGlobalReceiver(
                CastSpellPayload.ID,
                (payload, context) -> SpellCaster.cast(context.player(), payload.spellId())
        );

        ServerTickEvents.END_WORLD_TICK.register(world -> {
            PlayerSkillState state = PlayerSkillState.getServerState(world);
            boolean dirty = false;

            for (ServerPlayerEntity player : world.getPlayers()) {
                PlayerData data = state.getPlayerData(player.getUuid());

                if (data.getManaManager().tickRegeneration()) {
                    SpellCaster.syncMana(player, data);
                    dirty = true;
                }
            }

            if (dirty) {
                state.markDirty();
            }
        });
    }
}
