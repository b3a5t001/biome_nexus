package com.b3a5t001.biome_nexus.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.Identifier;

public class ManaHud {

    private static final int MANA_ICON_SPACING = 8;
    private static final int MANA_PER_ICON = 2;

    public static void render(DrawContext context, RenderTickCounter ticks) {
        MinecraftClient client = MinecraftClient.getInstance();

        if (shouldHideMana(client)) {
            return;
        }

        int maxMana = ClientPlayerData.getMaxMana();
        int mana = ClientPlayerData.getMana();
        int icons = Math.max(1, (int) Math.ceil(maxMana / (double) MANA_PER_ICON));

        int startX = context.getScaledWindowWidth() / 2 + 91
                - icons * MANA_ICON_SPACING;

        int y = context.getScaledWindowHeight() - 49;

        for (int index = 0; index < icons; index++) {
            int iconMana = Math.clamp(mana - index * MANA_PER_ICON, 0, MANA_PER_ICON);

            context.drawTexture(
                    getManaTexture(iconMana),
                    startX + index * MANA_ICON_SPACING,
                    y,
                    0,
                    0,
                    9,
                    9,
                    9,
                    9
            );
        }
    }
    private static Identifier getManaTexture(int iconMana) {
        if (iconMana >= MANA_PER_ICON) {
            return Identifier.of("biome_nexus", "textures/gui/sprites/hud/mana_full.png");
        }

        if (iconMana == 1) {
            return Identifier.of("biome_nexus", "textures/gui/sprites/hud/mana_half.png");
        }

        return Identifier.of("biome_nexus", "textures/gui/sprites/hud/mana_empty.png");
    }

    private static boolean shouldHideMana(MinecraftClient client) {
        return client.player == null
                || client.player.isCreative()
                || client.player.isSpectator()
                || client.player.isSubmergedInWater()
                || client.player.isRiding();
    }

}
