package com.b3a5t001.biome_nexus.items.trims;

import com.b3a5t001.biome_nexus.BiomeNexus;
import com.b3a5t001.biome_nexus.items.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class ModTrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial> SULFUR = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(BiomeNexus.MOD_ID, "sulfur"));
    public static final RegistryKey<ArmorTrimMaterial> ICE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(BiomeNexus.MOD_ID, "ice"));
    public static final RegistryKey<ArmorTrimMaterial> SCULK = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(BiomeNexus.MOD_ID, "sculk"));
    public static final RegistryKey<ArmorTrimMaterial> JADE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(BiomeNexus.MOD_ID, "jade"));

    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable) {
        register(registerable, SULFUR, Registries.ITEM.getEntry(ModItems.SULFUR_DUST), Style.EMPTY.withColor(0xFFFACD), 0.6f);
        register(registerable, ICE, Registries.ITEM.getEntry(Items.BLUE_ICE), Style.EMPTY.withColor(0x74ABFE), 0.8f);
        register(registerable, SCULK, Registries.ITEM.getEntry(Items.ECHO_SHARD), Style.EMPTY.withColor(0x034150), 0.9f);
        register(registerable, JADE, Registries.ITEM.getEntry(ModItems.JADE_BRICK), Style.EMPTY.withColor(0x1FAE69), 0.7f);
    }

    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> armorTrimKey,
                                 RegistryEntry<Item> item, Style style, float itemModelIndex) {
        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(armorTrimKey.getValue().getPath(), item, itemModelIndex, Map.of(),
                Text.translatable(Util.createTranslationKey("trim_material", armorTrimKey.getValue())).setStyle(style));

        registerable.register(armorTrimKey, trimMaterial);

    }
}
