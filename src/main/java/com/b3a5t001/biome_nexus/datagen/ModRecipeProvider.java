package com.b3a5t001.biome_nexus.datagen;

import com.b3a5t001.biome_nexus.blocks.ModBlocks;
import com.b3a5t001.biome_nexus.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.client.input.Input;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

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
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.COPPER_NUGGET
        ,RecipeCategory.BUILDING_BLOCKS, Items.COPPER_INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.JADE_CRYSTAL
                    ,RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_BLOCK);

        offerTorchRecipe(exporter, ModBlocks.SULFUR_TORCH, ModItems.SULFUR_DUST);
        offerLanternRecipe(exporter, ModBlocks.GOLD_LANTERN, ModItems.SULFUR_TORCH, Items.GOLD_NUGGET);
        offerChainRecipe(exporter, ModBlocks.GOLD_CHAIN, Items.GOLD_INGOT, Items.GOLD_NUGGET);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.GOLD_BARS, Items.GOLD_INGOT);
        offerTorchRecipe(exporter, ModBlocks.COPPER_TORCH, ModItems.COPPER_NUGGET);
        offerLanternRecipe(exporter, ModBlocks.COPPER_LANTERN, ModItems.COPPER_TORCH, ModItems.COPPER_NUGGET);
        offerChainRecipe(exporter, ModBlocks.COPPER_CHAIN, Items.COPPER_INGOT, ModItems.COPPER_NUGGET);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.COPPER_BARS, Items.COPPER_INGOT);

        offerSwordRecipe(exporter, ModItems.COPPER_SWORD, Items.COPPER_INGOT);
        offerShovelRecipe(exporter, ModItems.COPPER_SHOVEL, Items.COPPER_INGOT);
        offerPickaxeRecipe(exporter, ModItems.COPPER_PICKAXE, Items.COPPER_INGOT);
        offerAxeRecipe(exporter, ModItems.COPPER_AXE, Items.COPPER_INGOT);
        offerHoeRecipe(exporter, ModItems.COPPER_HOE, Items.COPPER_INGOT);
        offerHelmetRecipe(exporter, ModItems.COPPER_HELMET, Items.COPPER_INGOT);
        offerChestplateRecipe(exporter, ModItems.COPPER_CHESTPLATE, Items.COPPER_INGOT);
        offerLeggingsRecipe(exporter, ModItems.COPPER_LEGGINGS, Items.COPPER_INGOT);
        offerBootsRecipe(exporter, ModItems.COPPER_BOOTS, Items.COPPER_INGOT);

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

        offerSmelting(exporter, List.of(ModBlocks.SULFUR_ORE), RecipeCategory.MISC,
                ModItems.SULFUR_DUST, 0.7f, 200, "sulfur_ore");
        offerBlasting(exporter, List.of(ModBlocks.SULFUR_ORE), RecipeCategory.MISC,
                ModItems.SULFUR_DUST, 0.7f, 100, "sulfur_ore");
        offerSmelting(exporter, List.of(ModBlocks.JADE_ORE,ModBlocks.DEEPSLATE_JADE_ORE,ModItems.JADE_CRYSTAL),
                RecipeCategory.MISC, ModItems.JADE_BRICK, 0.5f, 200, "jade_ore");
        offerBlasting(exporter, List.of(ModBlocks.JADE_ORE,ModBlocks.DEEPSLATE_JADE_ORE,ModItems.JADE_CRYSTAL),
                RecipeCategory.MISC, ModItems.JADE_BRICK, 0.5f, 100, "jade_ore");

        offerSmelting(exporter, List.of(ModItems.COPPER_BOOTS,ModItems.COPPER_AXE,ModItems.COPPER_CHESTPLATE,
                        ModItems.COPPER_HELMET,ModItems.COPPER_LEGGINGS, ModItems.COPPER_HOE,ModItems.COPPER_PICKAXE,
                        ModItems.COPPER_SHOVEL, ModItems.COPPER_SWORD), RecipeCategory.MISC,
                ModItems.COPPER_NUGGET, 0.1f, 200, "copper_nugget");
        offerBlasting(exporter, List.of(ModItems.COPPER_BOOTS,ModItems.COPPER_AXE,ModItems.COPPER_CHESTPLATE,
                        ModItems.COPPER_HELMET,ModItems.COPPER_LEGGINGS, ModItems.COPPER_HOE,ModItems.COPPER_PICKAXE,
                        ModItems.COPPER_SHOVEL, ModItems.COPPER_SWORD), RecipeCategory.MISC,
                ModItems.COPPER_NUGGET, 0.1f, 100, "copper_nugget");

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
                .pattern("I I")
                .pattern("III")
                .pattern("III")
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
}
