package com.b3a5t001.biome_nexus.datagen;

import com.b3a5t001.biome_nexus.blocks.ModBlocks;
import com.b3a5t001.biome_nexus.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.client.input.Input;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

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

            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.SULFUR_TORCH)
                .input('#', Items.COAL)
                .input('X', ModItems.SULFUR_DUST)
                .input('S', Items.STICK)
                .pattern(" # ")
                .pattern(" X ")
                .pattern(" S ")
                .criterion(hasItem(ModItems.SULFUR_DUST), conditionsFromItem(ModItems.SULFUR_DUST))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.COPPER_TORCH)
                .input('#', Items.COAL)
                .input('X', ModItems.COPPER_NUGGET)
                .input('S', Items.STICK)
                .pattern(" # ")
                .pattern(" X ")
                .pattern(" S ")
                .criterion(hasItem(ModItems.SULFUR_DUST), conditionsFromItem(ModItems.SULFUR_DUST))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.GOLD_LANTERN)
                .input('S', ModItems.SULFUR_TORCH)
                .input('X', Items.GOLD_NUGGET)
                .pattern("XXX")
                .pattern("XSX")
                .pattern("XXX")
                .criterion(hasItem(ModItems.SULFUR_TORCH), conditionsFromItem(ModItems.SULFUR_TORCH))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.COPPER_LANTERN)
                .input('S', ModItems.COPPER_TORCH)
                .input('X', ModItems.COPPER_NUGGET)
                .pattern("XXX")
                .pattern("XSX")
                .pattern("XXX")
                .criterion(hasItem(ModItems.COPPER_TORCH), conditionsFromItem(ModItems.COPPER_TORCH))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.GOLD_CHAIN)
                .input('S', Items.GOLD_INGOT)
                .input('G', Items.GOLD_NUGGET)
                .pattern(" G ")
                .pattern(" S ")
                .pattern(" G ")
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.COPPER_CHAIN)
                .input('S', Items.COPPER_INGOT)
                .input('G', ModItems.COPPER_NUGGET)
                .pattern(" G ")
                .pattern(" S ")
                .pattern(" G ")
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);

        offerStainedGlassPaneRecipe(exporter, ModBlocks.GOLD_BARS, Items.GOLD_INGOT);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.COPPER_BARS, Items.COPPER_INGOT);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_SWORD)
                .input('S', Items.STICK)
                .input('C', Items.COPPER_INGOT)
                .pattern(" C ")
                .pattern(" C ")
                .pattern(" S ")
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_AXE)
                .input('S', Items.STICK)
                .input('C', Items.COPPER_INGOT)
                .pattern(" CC")
                .pattern(" SC")
                .pattern(" S ")
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE)
                .input('S', Items.STICK)
                .input('C', Items.COPPER_INGOT)
                .pattern("CCC")
                .pattern(" S ")
                .pattern(" S ")
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL)
                .input('S', Items.STICK)
                .input('C', Items.COPPER_INGOT)
                .pattern(" C ")
                .pattern(" S ")
                .pattern(" S ")
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_HOE)
                .input('S', Items.STICK)
                .input('C', Items.COPPER_INGOT)
                .pattern(" CC")
                .pattern(" S ")
                .pattern(" S ")
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_HELMET)
                .input('C', Items.COPPER_INGOT)
                .pattern("CCC")
                .pattern("C C")
                .pattern("   ")
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_CHESTPLATE)
                .input('C', Items.COPPER_INGOT)
                .pattern("C C")
                .pattern("CCC")
                .pattern("CCC")
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_LEGGINGS)
                .input('C', Items.COPPER_INGOT)
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C")
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_BOOTS)
                .input('C', Items.COPPER_INGOT)
                .pattern("C C")
                .pattern("C C")
                .pattern("   ")
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);

        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,ModBlocks.ICE_ROCK, Items.BLUE_ICE);
        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,ModBlocks.POLISHED_ICE_ROCK, ModBlocks.ICE_ROCK);
        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,ModBlocks.ICE_ROCK_BRICKS, ModBlocks.POLISHED_ICE_ROCK);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_SLAB, ModBlocks.ICE_ROCK);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_ROCK_SLAB, ModBlocks.POLISHED_ICE_ROCK);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_BRICK_SLAB, ModBlocks.ICE_ROCK_BRICKS);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_WALL, ModBlocks.ICE_ROCK);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_ROCK_WALL, ModBlocks.POLISHED_ICE_ROCK);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_BRICK_WALL, ModBlocks.ICE_ROCK_BRICKS);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_STAIRS, 4)
                .input('I', ModBlocks.ICE_ROCK.asItem())
                .pattern("I  ")
                .pattern("II ")
                .pattern("III")
                .criterion(hasItem(ModBlocks.ICE_ROCK), conditionsFromItem(ModBlocks.ICE_ROCK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_ROCK_STAIRS, 4)
                .input('I', ModBlocks.POLISHED_ICE_ROCK.asItem())
                .pattern("I  ")
                .pattern("II ")
                .pattern("III")
                .criterion(hasItem(ModBlocks.POLISHED_ICE_ROCK), conditionsFromItem(ModBlocks.POLISHED_ICE_ROCK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ROCK_BRICK_STAIRS, 4)
                .input('I', ModBlocks.ICE_ROCK_BRICKS.asItem())
                .pattern("I  ")
                .pattern("II ")
                .pattern("III")
                .criterion(hasItem(ModBlocks.ICE_ROCK_BRICKS), conditionsFromItem(ModBlocks.ICE_ROCK_BRICKS))
                .offerTo(exporter);

        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_BRICKS, ModItems.JADE_BRICK);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_BRICK_SLAB, ModBlocks.JADE_BRICKS);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_BRICK_WALL, ModBlocks.JADE_BRICKS);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_BRICK_STAIRS, 4)
                .input('I', ModBlocks.JADE_BRICKS.asItem())
                .pattern("I  ")
                .pattern("II ")
                .pattern("III")
                .criterion(hasItem(ModBlocks.JADE_BRICKS), conditionsFromItem(ModBlocks.JADE_BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_SLATE, 3)
                .input('S', Items.SCULK)
                .input('D', Items.DEEPSLATE)
                .pattern("DS ")
                .pattern("SD ")
                .pattern("   ")
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .offerTo(exporter);
        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_SLATE_BRICKS, ModBlocks.SCULK_SLATE);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_SLATE_BRICK_SLAB, ModBlocks.SCULK_SLATE_BRICKS);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_SLATE_BRICK_WALL, ModBlocks.SCULK_SLATE_BRICKS);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_SLATE_BRICK_STAIRS, 4)
                .input('I', ModBlocks.SCULK_SLATE_BRICKS.asItem())
                .pattern("I  ")
                .pattern("II ")
                .pattern("III")
                .criterion(hasItem(ModBlocks.SCULK_SLATE_BRICKS), conditionsFromItem(ModBlocks.SCULK_SLATE_BRICKS))
                .offerTo(exporter);

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
}
