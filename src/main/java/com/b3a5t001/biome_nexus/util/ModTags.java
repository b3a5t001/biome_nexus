package com.b3a5t001.biome_nexus.util;

import com.b3a5t001.biome_nexus.BiomeNexus;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> NEEDS_COPPER_TOOL = createTag("needs_copper_tool");
        public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = createTag("incorrect_for_copper_tool");
        public static final TagKey<Block> NEEDS_STEEL_TOOL = createTag("needs_steel_tool");
        public static final TagKey<Block> INCORRECT_FOR_STEEL_TOOL = createTag("incorrect_for_steel_tool");
        public static final TagKey<Block> NEEDS_AURORITE_TOOL = createTag("needs_aurorite_tool");
        public static final TagKey<Block> INCORRECT_FOR_AURORITE_TOOL = createTag("incorrect_for_aurorite_tool");
        public static final TagKey<Block> NEEDS_BRONZE_TOOL = createTag("needs_bronze_tool");
        public static final TagKey<Block> INCORRECT_FOR_BRONZE_TOOL = createTag("incorrect_for_bronze_tool");
        public static final TagKey<Block> NEEDS_COBALT_TOOL = createTag("needs_cobalt_tool");
        public static final TagKey<Block> INCORRECT_FOR_COBALT_TOOL = createTag("incorrect_for_cobalt_tool");
        public static final TagKey<Block> NEEDS_CRIMSONITE_TOOL = createTag("needs_crimsonite_tool");
        public static final TagKey<Block> INCORRECT_FOR_CRIMSONITE_TOOL = createTag("incorrect_for_crimsonite_tool");
        public static final TagKey<Block> NETHER_ORE_REPLACEABLES = createTag("nether_ore_replaceables");

        public static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(BiomeNexus.MOD_ID, name));
        }

    }
    public static class Items{
        public static final TagKey<Item> STONE_VARIANTS = createTag("stone_variants");
        public static final TagKey<Item> CRYSTALS = createTag("crystals");
        public static final TagKey<Item> EXPLOSIVE_POWDERS = createTag("explosive_powders");

        public static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(BiomeNexus.MOD_ID, name));
        }
    }

    public static class Biomes{
        public static final TagKey<Biome> PLAINS_VARIANTS = createTag("plains_variants");
        public static final TagKey<Biome> IS_CAVE = createTag("is_cave");
        public static final TagKey<Biome> IS_FROZEN = createTag("is_frozen");
        public static final TagKey<Biome> IS_COLD = createTag("is_cold");

        public static TagKey<Biome> createTag(String name){
            return TagKey.of(RegistryKeys.BIOME, Identifier.of(BiomeNexus.MOD_ID, name));
        }
    }
}
