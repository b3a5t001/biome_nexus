package com.b3a5t001.biome_nexus.datagen;

import com.b3a5t001.biome_nexus.BiomeNexus;
import com.b3a5t001.biome_nexus.blocks.ModBlocks;
import com.b3a5t001.biome_nexus.items.ModItems;
import com.b3a5t001.biome_nexus.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SULFUR_DUST
                ,RecipeCategory.BUILDING_BLOCKS, ModBlocks.SULFUR_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.COPPER_NUGGET
                ,RecipeCategory.MISC, Items.COPPER_INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.JADE_CRYSTAL
                ,RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.AURORITE_ALLOY
                ,RecipeCategory.BUILDING_BLOCKS, ModBlocks.AURORITE_BLOCK);
        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AURORITE_CRYSTAL_BLOCK, ModItems.AURORITE_CRYSTAL);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_TIN
                ,RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_TIN_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.TIN_INGOT
                ,RecipeCategory.BUILDING_BLOCKS, ModBlocks.TIN_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TIN_INGOT)
                .input('N', ModItems.TIN_NUGGET)
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .criterion(hasItem(ModItems.TIN_NUGGET), conditionsFromItem(ModItems.TIN_NUGGET))
                .offerTo(exporter, Identifier.of(BiomeNexus.MOD_ID, "tin_ingot_from_nuggets"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TIN_NUGGET, 9)
                .input(ModItems.TIN_INGOT)
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(exporter, Identifier.of(BiomeNexus.MOD_ID, "tin_nuggets_from_ingot"));
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.STEEL_INGOT
                ,RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STEEL_INGOT)
                .input('N', ModItems.STEEL_NUGGET)
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .criterion(hasItem(ModItems.STEEL_NUGGET), conditionsFromItem(ModItems.STEEL_NUGGET))
                .offerTo(exporter, Identifier.of(BiomeNexus.MOD_ID, "steel_ingot_from_nuggets"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STEEL_NUGGET, 9)
                .input(ModItems.STEEL_INGOT)
                .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
                .offerTo(exporter, Identifier.of(BiomeNexus.MOD_ID, "steel_nuggets_from_ingot"));

        offerSmithingTrimRecipe(exporter, ModItems.GRACE_SMITHING_TEMPLATE, Identifier.of(BiomeNexus.MOD_ID, "grace"));
        offerSmithingDuplicateRecipe(exporter, ModItems.GRACE_SMITHING_TEMPLATE, Blocks.COBBLESTONE);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STEEL_INGOT)
                .input(Items.IRON_INGOT,4)
                .input(Ingredient.fromTag(ItemTags.COALS),4)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, Identifier.of(BiomeNexus.MOD_ID, "steel_ingot_from_iron_and_coal"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModItems.AURORITE_ALLOY, 3)
                .input('S', ModTags.Items.STONE_VARIANTS)
                .input('A', ModItems.AURORITE_CRYSTAL)
                .pattern("AS ")
                .pattern("SA ")
                .pattern("   ")
                .criterion(hasItem(ModItems.AURORITE_CRYSTAL), conditionsFromItem(ModItems.AURORITE_CRYSTAL))
                .offerTo(exporter, Identifier.of(BiomeNexus.MOD_ID, "aurorite_alloy_from_raw"));

        offerTorchRecipe(exporter, ModBlocks.SULFUR_TORCH, ModItems.SULFUR_DUST);
        offerLanternRecipe(exporter, ModBlocks.GOLD_LANTERN, ModItems.SULFUR_TORCH, Items.GOLD_NUGGET);
        offerChainRecipe(exporter, ModBlocks.GOLD_CHAIN, Items.GOLD_INGOT, Items.GOLD_NUGGET);
        offerBarsRecipe(exporter, ModBlocks.GOLD_BARS, Items.GOLD_INGOT);
        offerTorchRecipe(exporter, ModBlocks.COPPER_TORCH, ModItems.COPPER_NUGGET);
        offerLanternRecipe(exporter, ModBlocks.COPPER_LANTERN, ModItems.COPPER_TORCH, ModItems.COPPER_NUGGET);
        offerChainRecipe(exporter, ModBlocks.COPPER_CHAIN, Items.COPPER_INGOT, ModItems.COPPER_NUGGET);
        offerBarsRecipe(exporter, ModBlocks.COPPER_BARS, Items.COPPER_INGOT);
        offerTorchRecipe(exporter, ModBlocks.TIN_TORCH, ModItems.TIN_NUGGET);
        offerLanternRecipe(exporter, ModBlocks.TIN_LANTERN, ModItems.TIN_TORCH, ModItems.TIN_NUGGET);
        offerChainRecipe(exporter, ModBlocks.TIN_CHAINS, ModItems.TIN_INGOT, ModItems.TIN_NUGGET);
        offerBarsRecipe(exporter, ModBlocks.TIN_BARS, ModItems.TIN_INGOT);
        offerLanternRecipe(exporter, ModBlocks.STEEL_LANTERN, Items.TORCH, ModItems.STEEL_NUGGET);
        offerChainRecipe(exporter, ModBlocks.STEEL_CHAINS, ModItems.STEEL_INGOT, ModItems.STEEL_NUGGET);
        offerBarsRecipe(exporter, ModBlocks.STEEL_BARS, ModItems.STEEL_INGOT);

        offerSwordRecipe(exporter, ModItems.COPPER_SWORD, Items.COPPER_INGOT);
        offerShovelRecipe(exporter, ModItems.COPPER_SHOVEL, Items.COPPER_INGOT);
        offerPickaxeRecipe(exporter, ModItems.COPPER_PICKAXE, Items.COPPER_INGOT);
        offerAxeRecipe(exporter, ModItems.COPPER_AXE, Items.COPPER_INGOT);
        offerHoeRecipe(exporter, ModItems.COPPER_HOE, Items.COPPER_INGOT);
        offerHelmetRecipe(exporter, ModItems.COPPER_HELMET, Items.COPPER_INGOT);
        offerChestplateRecipe(exporter, ModItems.COPPER_CHESTPLATE, Items.COPPER_INGOT);
        offerLeggingsRecipe(exporter, ModItems.COPPER_LEGGINGS, Items.COPPER_INGOT);
        offerBootsRecipe(exporter, ModItems.COPPER_BOOTS, Items.COPPER_INGOT);
        offerSwordRecipe(exporter, ModItems.STEEL_SWORD, ModItems.STEEL_INGOT);
        offerShovelRecipe(exporter, ModItems.STEEL_SHOVEL, ModItems.STEEL_INGOT);
        offerPickaxeRecipe(exporter, ModItems.STEEL_PICKAXE, ModItems.STEEL_INGOT);
        offerAxeRecipe(exporter, ModItems.STEEL_AXE, ModItems.STEEL_INGOT);
        offerHoeRecipe(exporter, ModItems.STEEL_HOE, ModItems.STEEL_INGOT);
        offerHelmetRecipe(exporter, ModItems.STEEL_HELMET, ModItems.STEEL_INGOT);
        offerChestplateRecipe(exporter, ModItems.STEEL_CHESTPLATE, ModItems.STEEL_INGOT);
        offerLeggingsRecipe(exporter, ModItems.STEEL_LEGGINGS, ModItems.STEEL_INGOT);
        offerBootsRecipe(exporter, ModItems.STEEL_BOOTS, ModItems.STEEL_INGOT);
        offerSwordRecipe(exporter, ModItems.AURORITE_SWORD, ModItems.AURORITE_ALLOY);
        offerShovelRecipe(exporter, ModItems.AURORITE_SHOVEL, ModItems.AURORITE_ALLOY);
        offerPickaxeRecipe(exporter, ModItems.AURORITE_PICKAXE, ModItems.AURORITE_ALLOY);
        offerAxeRecipe(exporter, ModItems.AURORITE_AXE, ModItems.AURORITE_ALLOY);
        offerHoeRecipe(exporter, ModItems.AURORITE_HOE, ModItems.AURORITE_ALLOY);
        offerHelmetRecipe(exporter, ModItems.AURORITE_HELMET, ModItems.AURORITE_ALLOY);
        offerChestplateRecipe(exporter, ModItems.AURORITE_CHESTPLATE, ModItems.AURORITE_ALLOY);
        offerLeggingsRecipe(exporter, ModItems.AURORITE_LEGGINGS, ModItems.AURORITE_ALLOY);
        offerBootsRecipe(exporter, ModItems.AURORITE_BOOTS, ModItems.AURORITE_ALLOY);

        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,ModBlocks.ICE_ROCK, Items.BLUE_ICE);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,ModBlocks.POLISHED_ICE_ROCK, ModBlocks.ICE_ROCK);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,ModBlocks.ICE_ROCK_BRICKS, ModBlocks.POLISHED_ICE_ROCK);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_SLAB, ModBlocks.ICE_ROCK);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_ROCK_SLAB, ModBlocks.POLISHED_ICE_ROCK);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_BRICK_SLAB, ModBlocks.ICE_ROCK_BRICKS);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_WALL, ModBlocks.ICE_ROCK);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_ROCK_WALL, ModBlocks.POLISHED_ICE_ROCK);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_BRICK_WALL, ModBlocks.ICE_ROCK_BRICKS);
        offerStairsRecipe(exporter, ModBlocks.ICE_ROCK_STAIRS, ModBlocks.ICE_ROCK);
        offerStairsRecipe(exporter, ModBlocks.POLISHED_ICE_ROCK_STAIRS, ModBlocks.POLISHED_ICE_ROCK);
        offerStairsRecipe(exporter, ModBlocks.ICE_ROCK_BRICK_STAIRS, ModBlocks.ICE_ROCK_BRICKS);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE, 2)
                .input('Q', Items.QUARTZ)
                .input('D', Items.DEEPSLATE)
                .pattern("DQ ")
                .pattern("QD ")
                .pattern("   ")
                .criterion(hasItem(Items.DEEPSLATE), conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,ModBlocks.POLISHED_LIMESTONE, ModBlocks.LIMESTONE);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,ModBlocks.LIMESTONE_BRICKS, ModBlocks.POLISHED_LIMESTONE);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_SLAB, ModBlocks.LIMESTONE);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE_SLAB, ModBlocks.POLISHED_LIMESTONE);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_BRICK_SLAB, ModBlocks.LIMESTONE_BRICKS);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_WALL, ModBlocks.LIMESTONE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE_WALL, ModBlocks.POLISHED_LIMESTONE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_BRICK_WALL, ModBlocks.LIMESTONE_BRICKS);
        offerStairsRecipe(exporter, ModBlocks.LIMESTONE_STAIRS, ModBlocks.LIMESTONE);
        offerStairsRecipe(exporter, ModBlocks.POLISHED_LIMESTONE_STAIRS, ModBlocks.POLISHED_LIMESTONE);
        offerStairsRecipe(exporter, ModBlocks.LIMESTONE_BRICK_STAIRS, ModBlocks.LIMESTONE_BRICKS);

        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_BRICKS, ModItems.JADE_BRICK);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_BRICK_SLAB, ModBlocks.JADE_BRICKS);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_BRICK_WALL, ModBlocks.JADE_BRICKS);
        offerStairsRecipe(exporter, ModBlocks.JADE_BRICK_STAIRS, ModBlocks.JADE_BRICKS);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_SLATE, 3)
                .input('S', Items.SCULK)
                .input('D', Items.DEEPSLATE)
                .pattern("DS ")
                .pattern("SD ")
                .pattern("   ")
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .offerTo(exporter);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_SLATE_BRICKS, ModBlocks.SCULK_SLATE);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_SLATE_BRICK_SLAB, ModBlocks.SCULK_SLATE_BRICKS);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_SLATE_BRICK_WALL, ModBlocks.SCULK_SLATE_BRICKS);
        offerStairsRecipe(exporter, ModBlocks.SCULK_SLATE_BRICK_STAIRS, ModBlocks.SCULK_SLATE_BRICKS);

        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TIN, ModBlocks.TIN_BLOCK);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TIN_SLAB, ModBlocks.CUT_TIN);
        offerStairsRecipe(exporter, ModBlocks.CUT_TIN_STAIRS, ModBlocks.CUT_TIN);
        offerGrateRecipe(exporter, ModBlocks.TIN_GRATE, ModBlocks.TIN_BLOCK);
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS ,ModBlocks.CHISELED_TIN, ModBlocks.CUT_TIN_SLAB);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TIN_DOOR, 3)
                .input('T', ModItems.TIN_INGOT)
                .pattern("TT ")
                .pattern("TT ")
                .pattern("TT ")
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TIN_TRAPDOOR, 2)
                .input('T', ModItems.TIN_INGOT)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(exporter);

        offerSmelting(exporter, List.of(ModBlocks.SULFUR_ORE), RecipeCategory.MISC,
                ModItems.SULFUR_DUST, 0.7f, 200, "sulfur_ore");
        offerBlasting(exporter, List.of(ModBlocks.SULFUR_ORE), RecipeCategory.MISC,
                ModItems.SULFUR_DUST, 0.7f, 100, "sulfur_ore");
        offerSmelting(exporter, List.of(ModBlocks.JADE_ORE,ModBlocks.DEEPSLATE_JADE_ORE,ModItems.JADE_CRYSTAL),
                RecipeCategory.MISC, ModItems.JADE_BRICK, 0.5f, 200, "jade_ore");
        offerBlasting(exporter, List.of(ModBlocks.JADE_ORE,ModBlocks.DEEPSLATE_JADE_ORE,ModItems.JADE_CRYSTAL),
                RecipeCategory.MISC, ModItems.JADE_BRICK, 0.5f, 100, "jade_ore");
        offerSmelting(exporter, List.of(ModBlocks.TIN_ORE,ModBlocks.DEEPSLATE_TIN_ORE,ModItems.RAW_TIN),
                RecipeCategory.MISC, ModItems.TIN_INGOT, 0.6f, 200, "tin_ore");
        offerBlasting(exporter, List.of(ModBlocks.TIN_ORE,ModBlocks.DEEPSLATE_TIN_ORE,ModItems.RAW_TIN),
                RecipeCategory.MISC, ModItems.TIN_INGOT, 0.6f, 100, "tin_ore");

        offerSmelting(exporter, List.of(ModItems.COPPER_BOOTS,ModItems.COPPER_AXE,ModItems.COPPER_CHESTPLATE,
                        ModItems.COPPER_HELMET,ModItems.COPPER_LEGGINGS, ModItems.COPPER_HOE,ModItems.COPPER_PICKAXE,
                        ModItems.COPPER_SHOVEL, ModItems.COPPER_SWORD), RecipeCategory.MISC,
                ModItems.COPPER_NUGGET, 0.1f, 200, "copper_nugget");
        offerBlasting(exporter, List.of(ModItems.COPPER_BOOTS,ModItems.COPPER_AXE,ModItems.COPPER_CHESTPLATE,
                        ModItems.COPPER_HELMET,ModItems.COPPER_LEGGINGS, ModItems.COPPER_HOE,ModItems.COPPER_PICKAXE,
                        ModItems.COPPER_SHOVEL, ModItems.COPPER_SWORD), RecipeCategory.MISC,
                ModItems.COPPER_NUGGET, 0.1f, 100, "copper_nugget");
        offerSmelting(exporter, List.of(ModItems.STEEL_BOOTS,ModItems.STEEL_AXE,ModItems.STEEL_CHESTPLATE,
                        ModItems.STEEL_HELMET,ModItems.STEEL_LEGGINGS, ModItems.STEEL_HOE,ModItems.STEEL_PICKAXE,
                        ModItems.STEEL_SHOVEL, ModItems.STEEL_SWORD), RecipeCategory.MISC,
                ModItems.STEEL_NUGGET, 0.4f, 200, "steel_nugget");
        offerBlasting(exporter, List.of(ModItems.STEEL_BOOTS,ModItems.STEEL_AXE,ModItems.STEEL_CHESTPLATE,
                        ModItems.STEEL_HELMET,ModItems.STEEL_LEGGINGS, ModItems.STEEL_HOE,ModItems.STEEL_PICKAXE,
                        ModItems.STEEL_SHOVEL, ModItems.STEEL_SWORD), RecipeCategory.MISC,
                ModItems.STEEL_NUGGET, 0.4f, 100, "steel_nugget");
        offerSmelting(exporter, List.of(ModItems.AURORITE_BOOTS,ModItems.AURORITE_AXE,ModItems.AURORITE_CHESTPLATE,
                        ModItems.AURORITE_HELMET,ModItems.AURORITE_LEGGINGS, ModItems.AURORITE_HOE,ModItems.AURORITE_PICKAXE,
                        ModItems.AURORITE_SHOVEL, ModItems.AURORITE_SWORD), RecipeCategory.MISC,
                ModItems.AURORITE_CRYSTAL, 0.2f, 200, "aurorite_crystal");
        offerBlasting(exporter, List.of(ModItems.AURORITE_BOOTS,ModItems.AURORITE_AXE,ModItems.AURORITE_CHESTPLATE,
                        ModItems.AURORITE_HELMET,ModItems.AURORITE_LEGGINGS, ModItems.AURORITE_HOE,ModItems.AURORITE_PICKAXE,
                        ModItems.AURORITE_SHOVEL, ModItems.AURORITE_SWORD), RecipeCategory.MISC,
                ModItems.AURORITE_CRYSTAL, 0.2f, 100, "aurorite_crystal");

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_SLAB, ModBlocks.ICE_ROCK,2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_STAIRS, ModBlocks.ICE_ROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_WALL, ModBlocks.ICE_ROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_ROCK, ModBlocks.ICE_ROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_ROCK_SLAB, ModBlocks.ICE_ROCK,2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_ROCK_STAIRS, ModBlocks.ICE_ROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_ROCK_WALL, ModBlocks.ICE_ROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_BRICKS, ModBlocks.ICE_ROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_BRICK_SLAB, ModBlocks.ICE_ROCK,2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_BRICK_STAIRS, ModBlocks.ICE_ROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_BRICK_WALL, ModBlocks.ICE_ROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_ROCK_SLAB, ModBlocks.POLISHED_ICE_ROCK,2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_ROCK_STAIRS, ModBlocks.POLISHED_ICE_ROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_ROCK_WALL, ModBlocks.POLISHED_ICE_ROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_BRICKS, ModBlocks.POLISHED_ICE_ROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_BRICK_SLAB, ModBlocks.POLISHED_ICE_ROCK,2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_BRICK_STAIRS, ModBlocks.POLISHED_ICE_ROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_BRICK_WALL, ModBlocks.POLISHED_ICE_ROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_BRICK_SLAB, ModBlocks.ICE_ROCK_BRICKS,2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_BRICK_STAIRS, ModBlocks.ICE_ROCK_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_BRICK_WALL, ModBlocks.ICE_ROCK_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_SLAB, ModBlocks.LIMESTONE,2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_STAIRS, ModBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_WALL, ModBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE, ModBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE_SLAB, ModBlocks.LIMESTONE,2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE_STAIRS, ModBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE_WALL, ModBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_BRICKS, ModBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_BRICK_SLAB, ModBlocks.LIMESTONE,2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_BRICK_STAIRS, ModBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_BRICK_WALL, ModBlocks.LIMESTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE_SLAB, ModBlocks.POLISHED_LIMESTONE,2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE_STAIRS, ModBlocks.POLISHED_LIMESTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE_WALL, ModBlocks.POLISHED_LIMESTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_BRICKS, ModBlocks.POLISHED_LIMESTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_BRICK_SLAB, ModBlocks.POLISHED_LIMESTONE,2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_BRICK_STAIRS, ModBlocks.POLISHED_LIMESTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_BRICK_WALL, ModBlocks.POLISHED_LIMESTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_BRICK_SLAB, ModBlocks.LIMESTONE_BRICKS,2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_BRICK_STAIRS, ModBlocks.LIMESTONE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_BRICK_WALL, ModBlocks.LIMESTONE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_BRICK_SLAB, ModBlocks.JADE_BRICKS,2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_BRICK_STAIRS, ModBlocks.JADE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_BRICK_WALL, ModBlocks.JADE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_SLATE_BRICKS, ModBlocks.SCULK_SLATE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_SLATE_BRICK_SLAB, ModBlocks.SCULK_SLATE,2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_SLATE_BRICK_STAIRS, ModBlocks.SCULK_SLATE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_SLATE_BRICK_WALL, ModBlocks.SCULK_SLATE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_SLATE_BRICK_SLAB, ModBlocks.SCULK_SLATE_BRICKS,2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_SLATE_BRICK_STAIRS, ModBlocks.SCULK_SLATE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_SLATE_BRICK_WALL, ModBlocks.SCULK_SLATE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TIN, ModBlocks.TIN_BLOCK, 4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TIN_SLAB, ModBlocks.TIN_BLOCK, 8);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TIN_STAIRS, ModBlocks.TIN_BLOCK, 4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_TIN, ModBlocks.TIN_BLOCK, 4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TIN_GRATE, ModBlocks.TIN_BLOCK, 4);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TIN_SLAB, ModBlocks.CUT_TIN, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TIN_STAIRS, ModBlocks.CUT_TIN);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_TIN, ModBlocks.CUT_TIN);
    }

    public static void offerStairsRecipe(RecipeExporter exporter, Block ouput, Block input){
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ouput, 4)
                .input('I', input.asItem())
                .pattern("I  ")
                .pattern("II ")
                .pattern("III")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerTorchRecipe(RecipeExporter exporter, Block ouput, Item input){
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ouput, 4)
                .input('C', ItemTags.COALS)
                .input('I', input.asItem())
                .input('S', Items.STICK)
                .pattern(" C ")
                .pattern(" I ")
                .pattern(" S ")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerLanternRecipe(RecipeExporter exporter, Block ouput, Item torch, Item nugget){
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ouput, 1)
                .input('T', torch)
                .input('N', nugget)
                .pattern("NNN")
                .pattern("NTN")
                .pattern("NNN")
                .criterion(hasItem(torch), conditionsFromItem(torch))
                .offerTo(exporter);
    }
    public static void offerChainRecipe(RecipeExporter exporter, Block ouput, Item ingot, Item nugget){
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ouput, 1)
                .input('I', ingot)
                .input('N', nugget)
                .pattern(" N ")
                .pattern(" I ")
                .pattern(" N ")
                .criterion(hasItem(ingot), conditionsFromItem(ingot))
                .offerTo(exporter);
    }
    public static void offerBarsRecipe(RecipeExporter exporter, Block ouput, Item ingot){
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ouput, 16)
                .input('I', ingot)
                .pattern("   ")
                .pattern("III")
                .pattern("III")
                .criterion(hasItem(ingot), conditionsFromItem(ingot))
                .offerTo(exporter);
    }
    public static void offerSwordRecipe(RecipeExporter exporter, Item ouput, Item input){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ouput)
                .input('I', input.asItem())
                .input('S', Items.STICK)
                .pattern(" I ")
                .pattern(" I ")
                .pattern(" S ")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerShovelRecipe(RecipeExporter exporter, Item ouput, Item input){
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ouput)
                .input('I', input.asItem())
                .input('S', Items.STICK)
                .pattern(" I ")
                .pattern(" S ")
                .pattern(" S ")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerPickaxeRecipe(RecipeExporter exporter, Item ouput, Item input){
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ouput)
                .input('I', input.asItem())
                .input('S', Items.STICK)
                .pattern("III")
                .pattern(" S ")
                .pattern(" S ")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerAxeRecipe(RecipeExporter exporter, Item ouput, Item input){
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ouput)
                .input('I', input.asItem())
                .input('S', Items.STICK)
                .pattern("II ")
                .pattern("IS ")
                .pattern(" S ")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerHoeRecipe(RecipeExporter exporter, Item ouput, Item input){
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ouput)
                .input('I', input.asItem())
                .input('S', Items.STICK)
                .pattern("II ")
                .pattern(" S ")
                .pattern(" S ")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerHelmetRecipe(RecipeExporter exporter, Item ouput, Item input){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ouput)
                .input('I', input.asItem())
                .pattern("III")
                .pattern("I I")
                .pattern("   ")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerChestplateRecipe(RecipeExporter exporter, Item ouput, Item input){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ouput)
                .input('I', input.asItem())
                .pattern("I I")
                .pattern("III")
                .pattern("III")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerLeggingsRecipe(RecipeExporter exporter, Item ouput, Item input){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ouput)
                .input('I', input.asItem())
                .pattern("III")
                .pattern("I I")
                .pattern("I I")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerBootsRecipe(RecipeExporter exporter, Item ouput, Item input){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ouput)
                .input('I', input.asItem())
                .pattern("I I")
                .pattern("I I")
                .pattern("   ")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerSmithingDuplicateRecipe(RecipeExporter exporter, Item toDuplicate, Block material){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, toDuplicate, 2)
                .input('D', Items.DIAMOND)
                .input('B', material)
                .input('T', toDuplicate)
                .pattern("DTD")
                .pattern("DBD")
                .pattern("DDD")
                .criterion(hasItem(toDuplicate), conditionsFromItem(toDuplicate))
                .offerTo(exporter);
    }
}
