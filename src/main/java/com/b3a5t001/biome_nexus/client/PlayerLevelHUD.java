package com.b3a5t001.biome_nexus.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;

public class PlayerLevelHUD {
    public static void render(DrawContext dc, RenderTickCounter ticks) {
        MinecraftClient mc = MinecraftClient.getInstance();
        dc.drawText(
                mc.textRenderer,
                "Player Level : " + ClientPlayerData.getPlayerLevel(),
                10,
                10,
                0xffffff,
                true
        );
    }
}
