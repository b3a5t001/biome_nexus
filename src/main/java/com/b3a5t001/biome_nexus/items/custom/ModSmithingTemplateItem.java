package com.b3a5t001.biome_nexus.items.custom;

import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class ModSmithingTemplateItem extends SmithingTemplateItem {
    public ModSmithingTemplateItem(Text appliesToText, Text ingredientsText, Text titleText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures, FeatureFlag... requiredFeatures) {
        super(appliesToText, ingredientsText, titleText, baseSlotDescriptionText, additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures, requiredFeatures);
    }
    private static final Formatting TITLE_FORMATTING = Formatting.GRAY;
    private static final Formatting DESCRIPTION_FORMATTING = Formatting.BLUE;

    private static final Text CRIMSONITE_UPGRADE_APPLIES_TO_TEXT =
            Text.translatable("item.biome_nexus.crimsonite_upgrade.applies_to")
                    .formatted(DESCRIPTION_FORMATTING);
    private static final Text CRIMSONITE_UPGRADE_INGREDIENTS_TEXT =
            Text.translatable("item.biome_nexus.crimsonite_upgrade.ingredients")
                    .formatted(DESCRIPTION_FORMATTING);
    private static final Text CRIMSONITE_UPGRADE_TEXT =
            Text.translatable("upgrade.biome_nexus.crimsonite_upgrade")
                    .formatted(TITLE_FORMATTING);
    private static final Text CRIMSONITE_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT =
            Text.translatable("smithing_template.crimsonite_upgrade.base_slot_description");
    private static final Text CRIMSONITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT =
            Text.translatable("smithing_template.crimsonite_upgrade.additions_slot_description");

    private static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE = Identifier.ofVanilla("item/empty_armor_slot_helmet");
    private static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = Identifier.ofVanilla("item/empty_armor_slot_chestplate");
    private static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = Identifier.ofVanilla("item/empty_armor_slot_leggings");
    private static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = Identifier.ofVanilla("item/empty_armor_slot_boots");
    private static final Identifier EMPTY_SLOT_HOE_TEXTURE = Identifier.ofVanilla("item/empty_slot_hoe");
    private static final Identifier EMPTY_SLOT_AXE_TEXTURE = Identifier.ofVanilla("item/empty_slot_axe");
    private static final Identifier EMPTY_SLOT_SWORD_TEXTURE = Identifier.ofVanilla("item/empty_slot_sword");
    private static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE = Identifier.ofVanilla("item/empty_slot_shovel");
    private static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE = Identifier.ofVanilla("item/empty_slot_pickaxe");
    private static final Identifier EMPTY_SLOT_INGOT_TEXTURE = Identifier.ofVanilla("item/empty_slot_ingot");


    private static List<Identifier> getCrimsoniteUpgradeEmptyBaseSlotTextures() {
        return List.of(
                EMPTY_ARMOR_SLOT_HELMET_TEXTURE,
                EMPTY_SLOT_SWORD_TEXTURE,
                EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
                EMPTY_SLOT_PICKAXE_TEXTURE,
                EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE,
                EMPTY_SLOT_AXE_TEXTURE,
                EMPTY_ARMOR_SLOT_BOOTS_TEXTURE,
                EMPTY_SLOT_HOE_TEXTURE,
                EMPTY_SLOT_SHOVEL_TEXTURE
        );
    }
    private static List<Identifier> getCrimsoniteUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_INGOT_TEXTURE);
    }

    public static SmithingTemplateItem createCrimsoniteUpgrade() {
        return new SmithingTemplateItem(
                CRIMSONITE_UPGRADE_APPLIES_TO_TEXT,
                CRIMSONITE_UPGRADE_INGREDIENTS_TEXT,
                CRIMSONITE_UPGRADE_TEXT,
                CRIMSONITE_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT,
                CRIMSONITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT,
                getCrimsoniteUpgradeEmptyBaseSlotTextures(),
                getCrimsoniteUpgradeEmptyAdditionsSlotTextures()
        );
    }
}
