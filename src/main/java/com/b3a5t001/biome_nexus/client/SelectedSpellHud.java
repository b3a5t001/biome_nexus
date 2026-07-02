package com.b3a5t001.biome_nexus.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.Identifier;

public final class SelectedSpellHud {
    private static final Identifier SLOT_TEXTURE = Identifier.ofVanilla("hud/hotbar_selection");

    private SelectedSpellHud() {
    }

    public static void render(DrawContext context, RenderTickCounter tickCounter) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null || client.player.isSpectator()) {
            return;
        }

        SpellBookEntry selectedSpell = ClientSpellBook.getSelected();
        if (selectedSpell == null) {
            return;
        }

        int x = context.getScaledWindowWidth() / 2 + 93;
        int y = context.getScaledWindowHeight() - 23;
        context.drawGuiTexture(SLOT_TEXTURE, x, y, 24, 24);
        context.drawItemWithoutEntity(selectedSpell.icon(), x + 4, y + 4);
    }
}
