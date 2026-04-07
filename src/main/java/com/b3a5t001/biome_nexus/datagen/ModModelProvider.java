package com.b3a5t001.biome_nexus.datagen;

import com.b3a5t001.biome_nexus.blocks.ModBlocks;
import com.b3a5t001.biome_nexus.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;
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
        BlockStateModelGenerator.BlockTexturePool limestonePool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LIMESTONE);
        limestonePool.slab(ModBlocks.LIMESTONE_SLAB);
        limestonePool.stairs(ModBlocks.LIMESTONE_STAIRS);
        limestonePool.wall(ModBlocks.LIMESTONE_WALL);
        BlockStateModelGenerator.BlockTexturePool polishedLimestonePool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_LIMESTONE);
        polishedLimestonePool.slab(ModBlocks.POLISHED_LIMESTONE_SLAB);
        polishedLimestonePool.stairs(ModBlocks.POLISHED_LIMESTONE_STAIRS);
        polishedLimestonePool.wall(ModBlocks.POLISHED_LIMESTONE_WALL);
        BlockStateModelGenerator.BlockTexturePool limestoneBrickPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LIMESTONE_BRICKS);
        limestoneBrickPool.slab(ModBlocks.LIMESTONE_BRICK_SLAB);
        limestoneBrickPool.stairs(ModBlocks.LIMESTONE_BRICK_STAIRS);
        limestoneBrickPool.wall(ModBlocks.LIMESTONE_BRICK_WALL);
        BlockStateModelGenerator.BlockTexturePool jadeBrickPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JADE_BRICKS);
        jadeBrickPool.slab(ModBlocks.JADE_BRICK_SLAB);
        jadeBrickPool.stairs(ModBlocks.JADE_BRICK_STAIRS);
        jadeBrickPool.wall(ModBlocks.JADE_BRICK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.JADE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.JADE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_JADE_ORE);
        BlockStateModelGenerator.BlockTexturePool sculkSlateBrickPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SCULK_SLATE_BRICKS);
        sculkSlateBrickPool.slab(ModBlocks.SCULK_SLATE_BRICK_SLAB);
        sculkSlateBrickPool.stairs(ModBlocks.SCULK_SLATE_BRICK_STAIRS);
        sculkSlateBrickPool.wall(ModBlocks.SCULK_SLATE_BRICK_WALL);
        blockStateModelGenerator.registerSingleton(ModBlocks.SCULK_SLATE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_TIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_BLOCK);
        BlockStateModelGenerator.BlockTexturePool cutTinPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CUT_TIN);
        cutTinPool.slab(ModBlocks.CUT_TIN_SLAB);
        cutTinPool.stairs(ModBlocks.CUT_TIN_STAIRS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_TIN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_GRATE);
        blockStateModelGenerator.registerDoor(ModBlocks.TIN_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.TIN_TRAPDOOR);
        blockStateModelGenerator.registerTorch(ModBlocks.TIN_TORCH, ModBlocks.TIN_WALL_TORCH);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AURORITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AURORITE_CRYSTAL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BUDDING_AURORITE);
        blockStateModelGenerator.registerAmethyst(ModBlocks.SMALL_AURORITE_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.MEDIUM_AURORITE_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.LARGE_AURORITE_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.AURORITE_CLUSTER);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SULFUR_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.JADE_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.JADE_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_TIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.AURORITE_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.AURORITE_ALLOY, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRACE_SMITHING_TEMPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.COPPER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AURORITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AURORITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AURORITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AURORITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AURORITE_HOE, Models.HANDHELD);


        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COPPER_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COPPER_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COPPER_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COPPER_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STEEL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STEEL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STEEL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STEEL_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AURORITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AURORITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AURORITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AURORITE_BOOTS));
    }
}
