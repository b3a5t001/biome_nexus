package com.b3a5t001.biome_nexus.datagen;

import com.b3a5t001.biome_nexus.blocks.ModBlocks;
import com.b3a5t001.biome_nexus.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.SULFUR_BLOCK)
                .add(ModBlocks.SULFUR_ORE)
                .add(ModBlocks.GOLD_CHAIN)
                .add(ModBlocks.GOLD_BARS)
                .add(ModBlocks.GOLD_LANTERN)
                .add(ModBlocks.COPPER_CHAIN)
                .add(ModBlocks.WAXED_COPPER_CHAIN)
                .add(ModBlocks.EXPOSED_COPPER_CHAIN)
                .add(ModBlocks.WAXED_EXPOSED_COPPER_CHAIN)
                .add(ModBlocks.WEATHERED_COPPER_CHAIN)
                .add(ModBlocks.WAXED_WEATHERED_COPPER_CHAIN)
                .add(ModBlocks.OXIDISED_COPPER_CHAIN)
                .add(ModBlocks.WAXED_OXIDISED_COPPER_CHAIN)
                .add(ModBlocks.COPPER_BARS)
                .add(ModBlocks.WAXED_COPPER_BARS)
                .add(ModBlocks.EXPOSED_COPPER_BARS)
                .add(ModBlocks.WAXED_EXPOSED_COPPER_BARS)
                .add(ModBlocks.WEATHERED_COPPER_BARS)
                .add(ModBlocks.WAXED_WEATHERED_COPPER_BARS)
                .add(ModBlocks.OXIDISED_COPPER_BARS)
                .add(ModBlocks.WAXED_OXIDISED_COPPER_BARS)
                .add(ModBlocks.COPPER_LANTERN)
                .add(ModBlocks.WAXED_COPPER_LANTERN)
                .add(ModBlocks.EXPOSED_COPPER_LANTERN)
                .add(ModBlocks.WAXED_EXPOSED_COPPER_LANTERN)
                .add(ModBlocks.WEATHERED_COPPER_LANTERN)
                .add(ModBlocks.WAXED_WEATHERED_COPPER_LANTERN)
                .add(ModBlocks.OXIDISED_COPPER_LANTERN)
                .add(ModBlocks.WAXED_OXIDISED_COPPER_LANTERN)
                .add(ModBlocks.ICE_ROCK)
                .add(ModBlocks.ICE_ROCK_SLAB)
                .add(ModBlocks.ICE_ROCK_STAIRS)
                .add(ModBlocks.ICE_ROCK_WALL)
                .add(ModBlocks.POLISHED_ICE_ROCK)
                .add(ModBlocks.POLISHED_ICE_ROCK_SLAB)
                .add(ModBlocks.POLISHED_ICE_ROCK_STAIRS)
                .add(ModBlocks.POLISHED_ICE_ROCK_WALL)
                .add(ModBlocks.ICE_ROCK_BRICKS)
                .add(ModBlocks.ICE_ROCK_BRICK_SLAB)
                .add(ModBlocks.ICE_ROCK_BRICK_STAIRS)
                .add(ModBlocks.ICE_ROCK_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SULFUR_BLOCK)
                .add(ModBlocks.SULFUR_ORE)
                .add(ModBlocks.COPPER_CHAIN)
                .add(ModBlocks.WAXED_COPPER_CHAIN)
                .add(ModBlocks.EXPOSED_COPPER_CHAIN)
                .add(ModBlocks.WAXED_EXPOSED_COPPER_CHAIN)
                .add(ModBlocks.WEATHERED_COPPER_CHAIN)
                .add(ModBlocks.WAXED_WEATHERED_COPPER_CHAIN)
                .add(ModBlocks.OXIDISED_COPPER_CHAIN)
                .add(ModBlocks.WAXED_OXIDISED_COPPER_CHAIN)
                .add(ModBlocks.COPPER_BARS)
                .add(ModBlocks.WAXED_COPPER_BARS)
                .add(ModBlocks.EXPOSED_COPPER_BARS)
                .add(ModBlocks.WAXED_EXPOSED_COPPER_BARS)
                .add(ModBlocks.WEATHERED_COPPER_BARS)
                .add(ModBlocks.WAXED_WEATHERED_COPPER_BARS)
                .add(ModBlocks.OXIDISED_COPPER_BARS)
                .add(ModBlocks.WAXED_OXIDISED_COPPER_BARS)
                .add(ModBlocks.COPPER_LANTERN)
                .add(ModBlocks.WAXED_COPPER_LANTERN)
                .add(ModBlocks.EXPOSED_COPPER_LANTERN)
                .add(ModBlocks.WAXED_EXPOSED_COPPER_LANTERN)
                .add(ModBlocks.WEATHERED_COPPER_LANTERN)
                .add(ModBlocks.WAXED_WEATHERED_COPPER_LANTERN)
                .add(ModBlocks.OXIDISED_COPPER_LANTERN)
                .add(ModBlocks.WAXED_OXIDISED_COPPER_LANTERN);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GOLD_CHAIN)
                .add(ModBlocks.GOLD_BARS)
                .add(ModBlocks.GOLD_LANTERN);
        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_COPPER_TOOL)
                .addTag(BlockTags.NEEDS_STONE_TOOL);
        getOrCreateTagBuilder(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_STONE_TOOL);
        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL);
        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.ICE_ROCK_SLAB)
                .add(ModBlocks.POLISHED_ICE_ROCK_SLAB)
                .add(ModBlocks.ICE_ROCK_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.ICE_ROCK_STAIRS)
                .add(ModBlocks.POLISHED_ICE_ROCK_STAIRS)
                .add(ModBlocks.ICE_ROCK_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.ICE_ROCK_WALL)
                .add(ModBlocks.POLISHED_ICE_ROCK_WALL)
                .add(ModBlocks.ICE_ROCK_BRICK_WALL);
    }
}
