package com.b3a5t001.biome_nexus.player.magic;

import com.b3a5t001.biome_nexus.network.ManaSyncPayload;
import com.b3a5t001.biome_nexus.player.PlayerData;
import com.b3a5t001.biome_nexus.player.PlayerSkillState;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;

public final class SpellCaster {
    private SpellCaster() {
    }

    public static SpellCastResult cast(ServerPlayerEntity player, String spellId) {
        Spell spell = SpellRegistry.get(spellId);

        if (spell == null) {
            return SpellCastResult.UNKNOWN_SPELL;
        }

        PlayerSkillState state = PlayerSkillState.getServerState(player.getServerWorld());
        PlayerData data = state.getPlayerData(player.getUuid());
        ManaManager manaManager = data.getManaManager();
        boolean creativeCasting = player.isCreative();

        if (!creativeCasting && !manaManager.consumeMana(spell.getManaCost())) {
            syncMana(player, data);
            return SpellCastResult.NOT_ENOUGH_MANA;
        }

        if (!spell.cast(player)) {
            if (!creativeCasting) {
                manaManager.addMana(spell.getManaCost());
            }

            syncMana(player, data);
            return SpellCastResult.CAST_FAILED;
        }

        if (!creativeCasting) {
            state.markDirty();
        }

        syncMana(player, data);
        return SpellCastResult.SUCCESS;
    }

    public static void syncMana(ServerPlayerEntity player, PlayerData data) {
        ManaManager manaManager = data.getManaManager();

        ServerPlayNetworking.send(
                player,
                new ManaSyncPayload(
                        manaManager.getManaCount(),
                        manaManager.getMaxMana()
                )
        );
    }
}
