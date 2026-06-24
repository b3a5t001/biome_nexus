package com.b3a5t001.biome_nexus.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.Identifier;

public class ManaHud {

    private static final int MANA_ICON_SPACING = 8;

    public static void render(DrawContext context, RenderTickCounter ticks) {

        int icons = 10;

        int startX = context.getScaledWindowWidth() / 2 + 91
                - icons * MANA_ICON_SPACING;

        int y = context.getScaledWindowHeight() - 49;

        for (int index = 0; index < icons; index++) {

            context.drawTexture(
                    Identifier.of(
                            "biome_nexus",
                            "textures/gui/sprites/hud/mana_full.png"
                    ),
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

}