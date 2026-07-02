package com.b3a5t001.biome_nexus.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SpellBookScreen extends Screen {
    private static final Identifier BACKGROUND_TEXTURE = Identifier.ofVanilla("textures/gui/recipe_book.png");
    private static final Identifier SLOT_TEXTURE = Identifier.ofVanilla("recipe_book/slot_craftable");
    private static final int BACKGROUND_WIDTH = 147;
    private static final int BACKGROUND_HEIGHT = 166;
    private static final int SLOT_SIZE = 25;
    private static final int SLOT_START_X = 11;
    private static final int SLOT_START_Y = 31;
    private static final int SLOT_SPACING = 25;
    private static final int SLOTS_PER_ROW = 5;

    private int left;
    private int top;
    private SpellBookEntry hoveredEntry;

    public SpellBookScreen() {
        super(Text.translatable("screen.biome_nexus.spell_book"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        left = (width - BACKGROUND_WIDTH) / 2;
        top = (height - BACKGROUND_HEIGHT) / 2;
        hoveredEntry = null;

        context.drawTexture(BACKGROUND_TEXTURE, left, top, 1, 1, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        context.drawText(textRenderer, getTitle(), left + 27, top + 14, 0x404040, false);
        renderSpellSlots(context, mouseX, mouseY);

        super.render(context, mouseX, mouseY, delta);
        renderSpellTooltip(context, mouseX, mouseY);
    }

    private void renderSpellSlots(DrawContext context, int mouseX, int mouseY) {
        int index = 0;
        for (SpellBookEntry entry : ClientSpellBook.all()) {
            int slotX = left + SLOT_START_X + SLOT_SPACING * (index % SLOTS_PER_ROW);
            int slotY = top + SLOT_START_Y + SLOT_SPACING * (index / SLOTS_PER_ROW);
            boolean hovered = isPointWithinSlot(mouseX, mouseY, slotX, slotY);
            boolean selected = entry.id().equals(ClientPlayerData.getSelectedSpellId());

            context.drawGuiTexture(SLOT_TEXTURE, slotX, slotY, SLOT_SIZE, SLOT_SIZE);
            if (selected) {
                context.fill(slotX + 1, slotY + 1, slotX + SLOT_SIZE - 1, slotY + SLOT_SIZE - 1, 0x33FFFFFF);
                context.drawBorder(slotX - 1, slotY - 1, SLOT_SIZE + 2, SLOT_SIZE + 2, 0xFFFFFFFF);
            }
            if (hovered) {
                hoveredEntry = entry;
                context.fill(slotX + 1, slotY + 1, slotX + SLOT_SIZE - 1, slotY + SLOT_SIZE - 1, 0x55FFFFFF);
            }

            context.drawItemWithoutEntity(entry.icon(), slotX + 4, slotY + 4);
            index++;
        }
    }

    private void renderSpellTooltip(DrawContext context, int mouseX, int mouseY) {
        if (hoveredEntry != null) {
            context.drawTooltip(
                    textRenderer,
                    java.util.List.of(
                            Text.literal(hoveredEntry.name()),
                            Text.literal("Cost: " + hoveredEntry.manaCost() + " mana")
                    ),
                    mouseX,
                    mouseY
            );
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) {
            int index = 0;
            for (SpellBookEntry entry : ClientSpellBook.all()) {
                int slotX = left + SLOT_START_X + SLOT_SPACING * (index % SLOTS_PER_ROW);
                int slotY = top + SLOT_START_Y + SLOT_SPACING * (index / SLOTS_PER_ROW);
                if (isPointWithinSlot(mouseX, mouseY, slotX, slotY)) {
                    ClientPlayerData.setSelectedSpellId(entry.id());
                    return true;
                }
                index++;
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    @Override
    public void blur() {
    }

    private boolean isPointWithinSlot(double pointX, double pointY, int slotX, int slotY) {
        return pointX >= slotX && pointX < slotX + SLOT_SIZE && pointY >= slotY && pointY < slotY + SLOT_SIZE;
    }
}
