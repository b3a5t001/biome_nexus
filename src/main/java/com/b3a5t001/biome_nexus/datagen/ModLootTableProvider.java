package com.b3a5t001.biome_nexus.datagen;

import com.b3a5t001.biome_nexus.blocks.ModBlocks;
import com.b3a5t001.biome_nexus.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SULFUR_BLOCK);
        addDrop(ModBlocks.SULFUR_ORE,oreDrops(ModBlocks.SULFUR_ORE, ModItems.SULFUR_DUST));
        addDrop(ModBlocks.SULFUR_TORCH, drops(ModItems.SULFUR_TORCH));
        addDrop(ModBlocks.SULFUR_WALL_TORCH, drops(ModItems.SULFUR_TORCH));
        addDrop(ModBlocks.GOLD_LANTERN);
        addDrop(ModBlocks.GOLD_CHAIN);
        addDrop(ModBlocks.GOLD_BARS);
        addDrop(ModBlocks.COPPER_TORCH, drops(ModItems.COPPER_TORCH));
        addDrop(ModBlocks.COPPER_WALL_TORCH, drops(ModItems.COPPER_TORCH));
        addDrop(ModBlocks.COPPER_LANTERN);
        addDrop(ModBlocks.WAXED_COPPER_LANTERN);
        addDrop(ModBlocks.EXPOSED_COPPER_LANTERN);
        addDrop(ModBlocks.WAXED_EXPOSED_COPPER_LANTERN);
        addDrop(ModBlocks.WEATHERED_COPPER_LANTERN);
        addDrop(ModBlocks.WAXED_WEATHERED_COPPER_LANTERN);
        addDrop(ModBlocks.OXIDISED_COPPER_LANTERN);
        addDrop(ModBlocks.WAXED_OXIDISED_COPPER_LANTERN);
        addDrop(ModBlocks.COPPER_CHAIN);
        addDrop(ModBlocks.WAXED_COPPER_CHAIN);
        addDrop(ModBlocks.EXPOSED_COPPER_CHAIN);
        addDrop(ModBlocks.WAXED_EXPOSED_COPPER_CHAIN);
        addDrop(ModBlocks.WEATHERED_COPPER_CHAIN);
        addDrop(ModBlocks.WAXED_WEATHERED_COPPER_CHAIN);
        addDrop(ModBlocks.OXIDISED_COPPER_CHAIN);
        addDrop(ModBlocks.WAXED_OXIDISED_COPPER_CHAIN);
        addDrop(ModBlocks.COPPER_BARS);
        addDrop(ModBlocks.WAXED_COPPER_BARS);
        addDrop(ModBlocks.EXPOSED_COPPER_BARS);
        addDrop(ModBlocks.WAXED_EXPOSED_COPPER_BARS);
        addDrop(ModBlocks.WEATHERED_COPPER_BARS);
        addDrop(ModBlocks.WAXED_WEATHERED_COPPER_BARS);
        addDrop(ModBlocks.OXIDISED_COPPER_BARS);
        addDrop(ModBlocks.WAXED_OXIDISED_COPPER_BARS);
        addDrop(ModBlocks.ICE_ROCK);
        addDrop(ModBlocks.ICE_ROCK_SLAB, slabDrops(ModBlocks.ICE_ROCK_SLAB));
        addDrop(ModBlocks.ICE_ROCK_STAIRS);
        addDrop(ModBlocks.ICE_ROCK_WALL);
        addDrop(ModBlocks.ICE_ROCK_BRICK_WALL);
        addDrop(ModBlocks.ICE_ROCK_BRICK_SLAB,slabDrops(ModBlocks.ICE_ROCK_BRICK_SLAB));
        addDrop(ModBlocks.ICE_ROCK_BRICK_STAIRS);
        addDrop(ModBlocks.ICE_ROCK_BRICKS);
        addDrop(ModBlocks.POLISHED_ICE_ROCK);
        addDrop(ModBlocks.POLISHED_ICE_ROCK_SLAB,slabDrops(ModBlocks.POLISHED_ICE_ROCK_SLAB));
        addDrop(ModBlocks.POLISHED_ICE_ROCK_STAIRS);
        addDrop(ModBlocks.POLISHED_ICE_ROCK_WALL);
    }
}
