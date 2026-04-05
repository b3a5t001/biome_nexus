package com.b3a5t001.biome_nexus.datagen;

import com.b3a5t001.biome_nexus.blocks.ModBlocks;
import com.b3a5t001.biome_nexus.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SULFUR_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SULFUR_ORE);
        blockStateModelGenerator.registerTorch(ModBlocks.SULFUR_TORCH, ModBlocks.SULFUR_WALL_TORCH);
        blockStateModelGenerator.registerTorch(ModBlocks.COPPER_TORCH, ModBlocks.COPPER_WALL_TORCH);
        BlockStateModelGenerator.BlockTexturePool iceRockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ICE_ROCK);
        iceRockPool.slab(ModBlocks.ICE_ROCK_SLAB);
        iceRockPool.stairs(ModBlocks.ICE_ROCK_STAIRS);
        iceRockPool.wall(ModBlocks.ICE_ROCK_WALL);
        BlockStateModelGenerator.BlockTexturePool polishedIceRockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_ICE_ROCK);
        polishedIceRockPool.slab(ModBlocks.POLISHED_ICE_ROCK_SLAB);
        polishedIceRockPool.stairs(ModBlocks.POLISHED_ICE_ROCK_STAIRS);
        polishedIceRockPool.wall(ModBlocks.POLISHED_ICE_ROCK_WALL);
        BlockStateModelGenerator.BlockTexturePool iceRockBrickPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ICE_ROCK_BRICKS);
        iceRockBrickPool.slab(ModBlocks.ICE_ROCK_BRICK_SLAB);
        iceRockBrickPool.stairs(ModBlocks.ICE_ROCK_BRICK_STAIRS);
        iceRockBrickPool.wall(ModBlocks.ICE_ROCK_BRICK_WALL);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SULFUR_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_NUGGET, Models.GENERATED);

        itemModelGenerator.register(ModItems.COPPER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COPPER_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COPPER_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COPPER_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COPPER_BOOTS));
    }
}
