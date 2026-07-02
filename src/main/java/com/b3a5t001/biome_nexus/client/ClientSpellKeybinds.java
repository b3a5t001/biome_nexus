package com.b3a5t001.biome_nexus.client;

import com.b3a5t001.biome_nexus.network.CastSpellPayload;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public final class ClientSpellKeybinds {
    private static KeyBinding castSpellKey;
    private static KeyBinding spellBookKey;
    private static boolean castSpellKeyWasDown;
    private static boolean spellBookKeyWasDown;

    private ClientSpellKeybinds() {
    }

    public static void register() {
        castSpellKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.biome_nexus.cast_spell",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_C,
                "category.biome_nexus.magic"
        ));
        spellBookKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.biome_nexus.open_spell_book",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_V,
                "category.biome_nexus.magic"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            handleCastSpellKey(client);
            handleSpellBookKey(client);
        });
    }

    private static void handleCastSpellKey(MinecraftClient client) {
        boolean sentFromKeyBinding = false;

        while (castSpellKey.wasPressed()) {
            castSelectedSpell(client);
            sentFromKeyBinding = true;
        }

        boolean keyDown = isKeyDown(client, castSpellKey);
        if (keyDown && !castSpellKeyWasDown && !sentFromKeyBinding) {
            castSelectedSpell(client);
        }

        castSpellKeyWasDown = keyDown;
    }

    private static void handleSpellBookKey(MinecraftClient client) {
        boolean toggledFromKeyBinding = false;

        while (spellBookKey.wasPressed()) {
            toggleSpellBook(client);
            toggledFromKeyBinding = true;
        }

        boolean keyDown = isKeyDown(client, spellBookKey);
        if (keyDown && !spellBookKeyWasDown && !toggledFromKeyBinding) {
            toggleSpellBook(client);
        }

        spellBookKeyWasDown = keyDown;
    }

    private static boolean isKeyDown(MinecraftClient client, KeyBinding keyBinding) {
        if (client.player == null || client.world == null) {
            return false;
        }

        InputUtil.Key boundKey = KeyBindingHelper.getBoundKeyOf(keyBinding);

        if (boundKey.getCode() == InputUtil.UNKNOWN_KEY.getCode()) {
            return false;
        }

        if (boundKey.getCategory() != InputUtil.Type.KEYSYM) {
            return keyBinding.isPressed();
        }

        return InputUtil.isKeyPressed(client.getWindow().getHandle(), boundKey.getCode());
    }

    private static void castSelectedSpell(MinecraftClient client) {
        if (client.currentScreen != null || client.player == null || client.world == null) {
            return;
        }

        String selectedSpellId = ClientPlayerData.getSelectedSpellId();
        if (ClientSpellBook.get(selectedSpellId) == null) {
            return;
        }

        ClientPlayNetworking.send(new CastSpellPayload(selectedSpellId));
    }

    private static void toggleSpellBook(MinecraftClient client) {
        if (client.player == null || client.world == null) {
            return;
        }

        if (client.currentScreen instanceof SpellBookScreen) {
            client.setScreen(null);
        } else if (client.currentScreen == null) {
            client.setScreen(new SpellBookScreen());
        }
    }
}
