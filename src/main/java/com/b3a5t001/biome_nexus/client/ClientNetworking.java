package com.b3a5t001.biome_nexus.client;

import com.b3a5t001.biome_nexus.network.LevelSyncPayload;
import com.b3a5t001.biome_nexus.network.ManaSyncPayload;
import com.b3a5t001.biome_nexus.network.SkillLevelUpPayload;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.Text;

public class ClientNetworking {
    public static void register(){ClientPlayNetworking.registerGlobalReceiver(
            LevelSyncPayload.ID,
            (payload, context) -> {
                context.client().execute(() -> {
                    ClientPlayerData.setPlayerLevel(payload.level());
                });
            }
    );

        ClientPlayNetworking.registerGlobalReceiver(
                ManaSyncPayload.ID,
                (payload, context) -> {
                    context.client().execute(() -> {
                        ClientPlayerData.setMana(payload.mana(), payload.maxMana());
                    });
                }
        );

        ClientPlayNetworking.registerGlobalReceiver(
                SkillLevelUpPayload.ID,
                (payload, context) -> {
                    context.client().execute(() -> {

                        MinecraftClient client = MinecraftClient.getInstance();

                        client.getToastManager().add(
                                SystemToast.create(
                                        client,
                                        SystemToast.Type.PERIODIC_NOTIFICATION,
                                        Text.literal("Skill Level Up!"),
                                        Text.literal(
                                                payload.skill().name()
                                                        + " reached level "
                                                        + payload.level()
                                        )
                                )
                        );
                    });
                }
        );
    }
}
