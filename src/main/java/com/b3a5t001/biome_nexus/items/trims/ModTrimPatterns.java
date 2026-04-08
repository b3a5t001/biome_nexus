package com.b3a5t001.biome_nexus.items.trims;

import com.b3a5t001.biome_nexus.BiomeNexus;
import com.b3a5t001.biome_nexus.items.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimPattern;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModTrimPatterns {
    public static final RegistryKey<ArmorTrimPattern> GRACE = RegistryKey.of(RegistryKeys.TRIM_PATTERN,
            Identifier.of(BiomeNexus.MOD_ID, "grace"));
    public static final RegistryKey<ArmorTrimPattern> VINE = RegistryKey.of(RegistryKeys.TRIM_PATTERN,
            Identifier.of(BiomeNexus.MOD_ID, "vine"));
    public static final RegistryKey<ArmorTrimPattern> GEM = RegistryKey.of(RegistryKeys.TRIM_PATTERN,
            Identifier.of(BiomeNexus.MOD_ID, "gem"));

    public static void bootstrap(Registerable<ArmorTrimPattern> context){
        register(context, ModItems.GRACE_SMITHING_TEMPLATE, GRACE);
        register(context, ModItems.VINE_SMITHING_TEMPLATE, VINE);
        register(context, ModItems.GEM_SMITHING_TEMPLATE, GEM);
    }

    private static void register(Registerable<ArmorTrimPattern> context, Item item, RegistryKey<ArmorTrimPattern> key){
        ArmorTrimPattern trimPattern = new ArmorTrimPattern(key.getValue() , Registries.ITEM.getEntry(item),
                Text.translatable(Util.createTranslationKey("trim_pattern", key.getValue())),false);
        context.register(key, trimPattern);
    }
}
