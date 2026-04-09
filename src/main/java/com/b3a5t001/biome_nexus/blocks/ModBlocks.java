package com.b3a5t001.biome_nexus.blocks;

import com.b3a5t001.biome_nexus.BiomeNexus;
import com.b3a5t001.biome_nexus.blocks.custom.BuddingAuroriteBlock;
import com.b3a5t001.biome_nexus.blocks.custom.OxidizableBarsBlock;
import com.b3a5t001.biome_nexus.blocks.custom.OxidizableChainBlock;
import com.b3a5t001.biome_nexus.blocks.custom.OxidizableLanternBlock;
import com.b3a5t001.biome_nexus.blocks.fertilized.FertilizedBaseBlock;
import com.b3a5t001.biome_nexus.blocks.fertilized.FertilizedFarmBlock;
import com.b3a5t001.biome_nexus.blocks.fertilized.FertilizedFallingBlock;
import com.b3a5t001.biome_nexus.blocks.fertilized.FertilizedSoulSandBlock;
import com.b3a5t001.biome_nexus.blocks.fertilized.FertilizedSpreadableBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block SULFUR_BLOCK = registerBlock("sulfur_block",
            new Block(AbstractBlock.Settings.create().requiresTool().mapColor(MapColor.PALE_YELLOW)
                    .sounds(BlockSoundGroup.NETHER_BRICKS).strength(1.5f, 4.0f)),true);
    public static final Block SULFUR_ORE = registerBlock("sulfur_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3,7),AbstractBlock.Settings.create().requiresTool().mapColor(MapColor.DARK_CRIMSON)
                    .sounds(BlockSoundGroup.NETHER_GOLD_ORE).strength(2f, 4.0f)),true);

    // Fertilized soil variants (no direct item)
    public static final Block FERTILIZED_FARMLAND = registerBlock("fertilized_farmland",
            new FertilizedFarmBlock(Blocks.FARMLAND, AbstractBlock.Settings.copy(Blocks.FARMLAND)), false);
    public static final Block FERTILIZED_GRASS_BLOCK = registerBlock("fertilized_grass_block",
            new FertilizedSpreadableBlock(Blocks.GRASS_BLOCK, AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK)), false);
    public static final Block FERTILIZED_DIRT = registerBlock("fertilized_dirt",
            new FertilizedBaseBlock(Blocks.DIRT, AbstractBlock.Settings.copy(Blocks.DIRT)), false);
    public static final Block FERTILIZED_COARSE_DIRT = registerBlock("fertilized_coarse_dirt",
            new FertilizedBaseBlock(Blocks.COARSE_DIRT, AbstractBlock.Settings.copy(Blocks.COARSE_DIRT)), false);
    public static final Block FERTILIZED_PODZOL = registerBlock("fertilized_podzol",
            new FertilizedSpreadableBlock(Blocks.PODZOL, AbstractBlock.Settings.copy(Blocks.PODZOL)), false);
    public static final Block FERTILIZED_MYCELIUM = registerBlock("fertilized_mycelium",
            new FertilizedSpreadableBlock(Blocks.MYCELIUM, AbstractBlock.Settings.copy(Blocks.MYCELIUM)), false);
    public static final Block FERTILIZED_ROOTED_DIRT = registerBlock("fertilized_rooted_dirt",
            new FertilizedBaseBlock(Blocks.ROOTED_DIRT, AbstractBlock.Settings.copy(Blocks.ROOTED_DIRT)), false);
    public static final Block FERTILIZED_MUD = registerBlock("fertilized_mud",
            new FertilizedBaseBlock(Blocks.MUD, AbstractBlock.Settings.copy(Blocks.MUD)), false);
    public static final Block FERTILIZED_CLAY = registerBlock("fertilized_clay",
            new FertilizedBaseBlock(Blocks.CLAY, AbstractBlock.Settings.copy(Blocks.CLAY)), false);
    public static final Block FERTILIZED_SAND = registerBlock("fertilized_sand",
            new FertilizedFallingBlock(Blocks.SAND, AbstractBlock.Settings.copy(Blocks.SAND)), false);
    public static final Block FERTILIZED_RED_SAND = registerBlock("fertilized_red_sand",
            new FertilizedFallingBlock(Blocks.RED_SAND, AbstractBlock.Settings.copy(Blocks.RED_SAND)), false);
    public static final Block FERTILIZED_SOUL_SAND = registerBlock("fertilized_soul_sand",
            new FertilizedSoulSandBlock(Blocks.SOUL_SAND, AbstractBlock.Settings.copy(Blocks.SOUL_SAND)), false);

    public static final Block SULFUR_TORCH = registerBlock("sulfur_torch",
            new TorchBlock(ParticleTypes.SMALL_FLAME, AbstractBlock.Settings.copy(Blocks.TORCH)),false);
    public static final Block SULFUR_WALL_TORCH = registerBlock("sulfur_wall_torch",
            new WallTorchBlock(ParticleTypes.SMALL_FLAME, AbstractBlock.Settings.copy(Blocks.WALL_TORCH)
                    .dropsLike(ModBlocks.SULFUR_TORCH)),false);
    public static final Block COPPER_TORCH = registerBlock("copper_torch",
            new TorchBlock(ParticleTypes.SMALL_FLAME, AbstractBlock.Settings.copy(Blocks.TORCH)),false);
    public static final Block COPPER_WALL_TORCH = registerBlock("copper_wall_torch",
            new WallTorchBlock(ParticleTypes.SMALL_FLAME, AbstractBlock.Settings.copy(Blocks.WALL_TORCH)
                    .dropsLike(ModBlocks.COPPER_TORCH)),false);
    public static final Block TIN_TORCH = registerBlock("tin_torch",
            new TorchBlock(ParticleTypes.SOUL_FIRE_FLAME, AbstractBlock.Settings.copy(Blocks.TORCH)),false);
    public static final Block TIN_WALL_TORCH = registerBlock("tin_wall_torch",
            new WallTorchBlock(ParticleTypes.SOUL_FIRE_FLAME, AbstractBlock.Settings.copy(Blocks.WALL_TORCH)
                    .dropsLike(ModBlocks.TIN_TORCH)),false);

    public static final Block GOLD_LANTERN = registerBlock("gold_lantern",
            new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)),true);
    public static final Block GOLD_CHAIN = registerBlock("gold_chain",
            new ChainBlock(AbstractBlock.Settings.copy(Blocks.CHAIN)),true);
    public static final Block GOLD_BARS = registerBlock("gold_bars",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.IRON_BARS)),true);

    public static final Block COPPER_CHAIN = registerBlock("copper_chain",
            new OxidizableChainBlock(Oxidizable.OxidationLevel.UNAFFECTED,AbstractBlock.Settings.copy(Blocks.CHAIN).ticksRandomly()),true);
    public static final Block WAXED_COPPER_CHAIN = registerBlock("waxed_copper_chain",
            new ChainBlock(AbstractBlock.Settings.copy(Blocks.CHAIN)),true);
    public static final Block EXPOSED_COPPER_CHAIN = registerBlock("exposed_copper_chain",
            new OxidizableChainBlock(Oxidizable.OxidationLevel.EXPOSED,AbstractBlock.Settings.copy(Blocks.CHAIN).ticksRandomly()),true);
    public static final Block WAXED_EXPOSED_COPPER_CHAIN = registerBlock("waxed_exposed_copper_chain",
            new ChainBlock(AbstractBlock.Settings.copy(Blocks.CHAIN)),true);
    public static final Block WEATHERED_COPPER_CHAIN = registerBlock("weathered_copper_chain",
            new OxidizableChainBlock(Oxidizable.OxidationLevel.WEATHERED,AbstractBlock.Settings.copy(Blocks.CHAIN).ticksRandomly()),true);
    public static final Block WAXED_WEATHERED_COPPER_CHAIN = registerBlock("waxed_weathered_copper_chain",
            new ChainBlock(AbstractBlock.Settings.copy(Blocks.CHAIN)),true);
    public static final Block OXIDIZED_COPPER_CHAIN = registerBlock("oxidized_copper_chain",
            new OxidizableChainBlock(Oxidizable.OxidationLevel.OXIDIZED,AbstractBlock.Settings.copy(Blocks.CHAIN).ticksRandomly()),true);
    public static final Block WAXED_OXIDIZED_COPPER_CHAIN = registerBlock("waxed_oxidized_copper_chain",
            new ChainBlock(AbstractBlock.Settings.copy(Blocks.CHAIN)),true);

    public static final Block COPPER_LANTERN = registerBlock("copper_lantern",
            new OxidizableLanternBlock(Oxidizable.OxidationLevel.UNAFFECTED,AbstractBlock.Settings.copy(Blocks.LANTERN).ticksRandomly()),true);
    public static final Block WAXED_COPPER_LANTERN = registerBlock("waxed_copper_lantern",
            new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)),true);
    public static final Block EXPOSED_COPPER_LANTERN = registerBlock("exposed_copper_lantern",
            new OxidizableLanternBlock(Oxidizable.OxidationLevel.EXPOSED,AbstractBlock.Settings.copy(Blocks.LANTERN).ticksRandomly()),true);
    public static final Block WAXED_EXPOSED_COPPER_LANTERN = registerBlock("waxed_exposed_copper_lantern",
            new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)),true);
    public static final Block WEATHERED_COPPER_LANTERN = registerBlock("weathered_copper_lantern",
            new OxidizableLanternBlock(Oxidizable.OxidationLevel.WEATHERED,AbstractBlock.Settings.copy(Blocks.LANTERN).ticksRandomly()),true);
    public static final Block WAXED_WEATHERED_COPPER_LANTERN = registerBlock("waxed_weathered_copper_lantern",
            new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)),true);
    public static final Block OXIDIZED_COPPER_LANTERN = registerBlock("oxidized_copper_lantern",
            new OxidizableLanternBlock(Oxidizable.OxidationLevel.OXIDIZED,AbstractBlock.Settings.copy(Blocks.LANTERN).ticksRandomly()),true);
    public static final Block WAXED_OXIDIZED_COPPER_LANTERN = registerBlock("waxed_oxidized_copper_lantern",
            new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)),true);

    public static final Block COPPER_BARS = registerBlock("copper_bars",
            new OxidizableBarsBlock(Oxidizable.OxidationLevel.UNAFFECTED,AbstractBlock.Settings.copy(Blocks.IRON_BARS).ticksRandomly()),true);
    public static final Block WAXED_COPPER_BARS = registerBlock("waxed_copper_bars",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.IRON_BARS)),true);
    public static final Block EXPOSED_COPPER_BARS = registerBlock("exposed_copper_bars",
            new OxidizableBarsBlock(Oxidizable.OxidationLevel.EXPOSED,AbstractBlock.Settings.copy(Blocks.IRON_BARS).ticksRandomly()),true);
    public static final Block WAXED_EXPOSED_COPPER_BARS = registerBlock("waxed_exposed_copper_bars",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.IRON_BARS)),true);
    public static final Block WEATHERED_COPPER_BARS = registerBlock("weathered_copper_bars",
            new OxidizableBarsBlock(Oxidizable.OxidationLevel.WEATHERED,AbstractBlock.Settings.copy(Blocks.IRON_BARS).ticksRandomly()),true);
    public static final Block WAXED_WEATHERED_COPPER_BARS = registerBlock("waxed_weathered_copper_bars",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.IRON_BARS)),true);
    public static final Block OXIDIZED_COPPER_BARS = registerBlock("oxidized_copper_bars",
            new OxidizableBarsBlock(Oxidizable.OxidationLevel.OXIDIZED,AbstractBlock.Settings.copy(Blocks.IRON_BARS).ticksRandomly()),true);
    public static final Block WAXED_OXIDIZED_COPPER_BARS = registerBlock("waxed_oxidized_copper_bars",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.IRON_BARS)),true);
    
    public static final Block ICE_ROCK = registerBlock("ice_rock",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.CALCITE).requiresTool()),true);
    public static final Block ICE_ROCK_SLAB = registerBlock("ice_rock_slab",
            new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.CALCITE).requiresTool()),true);
    public static final Block ICE_ROCK_STAIRS = registerBlock("ice_rock_stairs",
            new StairsBlock(ModBlocks.ICE_ROCK.getDefaultState(),AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.CALCITE).requiresTool()),true);
    public static final Block ICE_ROCK_WALL = registerBlock("ice_rock_wall",
            new WallBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.CALCITE).requiresTool()),true);
    public static final Block POLISHED_ICE_ROCK = registerBlock("polished_ice_rock",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.CALCITE).requiresTool()),true);
    public static final Block POLISHED_ICE_ROCK_SLAB = registerBlock("polished_ice_rock_slab",
            new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.CALCITE).requiresTool()),true);
    public static final Block POLISHED_ICE_ROCK_STAIRS = registerBlock("polished_ice_rock_stairs",
            new StairsBlock(ModBlocks.POLISHED_ICE_ROCK.getDefaultState(),AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.CALCITE).requiresTool()),true);
    public static final Block POLISHED_ICE_ROCK_WALL = registerBlock("polished_ice_rock_wall",
            new WallBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.CALCITE).requiresTool()),true);
    public static final Block ICE_ROCK_BRICKS = registerBlock("ice_rock_bricks",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.CALCITE).requiresTool()),true);
    public static final Block ICE_ROCK_BRICK_SLAB = registerBlock("ice_rock_brick_slab",
            new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.CALCITE).requiresTool()),true);
    public static final Block ICE_ROCK_BRICK_STAIRS = registerBlock("ice_rock_brick_stairs",
            new StairsBlock(ModBlocks.ICE_ROCK_BRICKS.getDefaultState(),AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.CALCITE).requiresTool()),true);
    public static final Block ICE_ROCK_BRICK_WALL = registerBlock("ice_rock_brick_wall",
            new WallBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.CALCITE).requiresTool()),true);
    
    public static final Block LIMESTONE = registerBlock("limestone",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.BASALT).requiresTool()),true);
    public static final Block LIMESTONE_SLAB = registerBlock("limestone_slab",
            new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.BASALT).requiresTool()),true);
    public static final Block LIMESTONE_STAIRS = registerBlock("limestone_stairs",
            new StairsBlock(ModBlocks.LIMESTONE.getDefaultState(),AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.BASALT).requiresTool()),true);
    public static final Block LIMESTONE_WALL = registerBlock("limestone_wall",
            new WallBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.BASALT).requiresTool()),true);
    public static final Block POLISHED_LIMESTONE = registerBlock("polished_limestone",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.BASALT).requiresTool()),true);
    public static final Block POLISHED_LIMESTONE_SLAB = registerBlock("polished_limestone_slab",
            new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.BASALT).requiresTool()),true);
    public static final Block POLISHED_LIMESTONE_STAIRS = registerBlock("polished_limestone_stairs",
            new StairsBlock(ModBlocks.POLISHED_LIMESTONE.getDefaultState(),AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.BASALT).requiresTool()),true);
    public static final Block POLISHED_LIMESTONE_WALL = registerBlock("polished_limestone_wall",
            new WallBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.BASALT).requiresTool()),true);
    public static final Block LIMESTONE_BRICKS = registerBlock("limestone_bricks",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.BASALT).requiresTool()),true);
    public static final Block LIMESTONE_BRICK_SLAB = registerBlock("limestone_brick_slab",
            new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.BASALT).requiresTool()),true);
    public static final Block LIMESTONE_BRICK_STAIRS = registerBlock("limestone_brick_stairs",
            new StairsBlock(ModBlocks.LIMESTONE_BRICKS.getDefaultState(),AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.BASALT).requiresTool()),true);
    public static final Block LIMESTONE_BRICK_WALL = registerBlock("limestone_brick_wall",
            new WallBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(1.0f, 3.0f)
                    .sounds(BlockSoundGroup.BASALT).requiresTool()),true);

    public static final Block JADE_BRICKS = registerBlock("jade_bricks",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.EMERALD_GREEN).strength(2.0f, 6.0f)
                    .sounds(BlockSoundGroup.DEEPSLATE_TILES).requiresTool()),true);
    public static final Block JADE_BRICK_SLAB = registerBlock("jade_brick_slab",
            new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.EMERALD_GREEN).strength(2.0f, 6.0f)
                    .sounds(BlockSoundGroup.DEEPSLATE_TILES).requiresTool()),true);
    public static final Block JADE_BRICK_STAIRS = registerBlock("jade_brick_stairs",
            new StairsBlock(ModBlocks.JADE_BRICKS.getDefaultState(),AbstractBlock.Settings.create().mapColor(MapColor.EMERALD_GREEN).strength(2.0f, 6.0f)
                    .sounds(BlockSoundGroup.DEEPSLATE_TILES).requiresTool()),true);
    public static final Block JADE_BRICK_WALL = registerBlock("jade_brick_wall",
            new WallBlock(AbstractBlock.Settings.create().mapColor(MapColor.EMERALD_GREEN).strength(2.0f, 6.0f)
                    .sounds(BlockSoundGroup.DEEPSLATE_TILES).requiresTool()),true);
    public static final Block JADE_ORE = registerBlock("jade_ore",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.EMERALD_GREEN).strength(2.0f, 5.5f)
                    .sounds(BlockSoundGroup.STONE).requiresTool()),true);
    public static final Block DEEPSLATE_JADE_ORE = registerBlock("deepslate_jade_ore",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.EMERALD_GREEN).strength(2.5f, 6.0f)
                    .sounds(BlockSoundGroup.DEEPSLATE_TILES).requiresTool()),true);
    public static final Block JADE_BLOCK = registerBlock("jade_block",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.EMERALD_GREEN).strength(2.0f, 5.0f)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool()),true);

    public static final Block SCULK_SLATE = registerBlock("sculk_slate",
            new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.DEEPSLATE_GRAY).strength(2.0f, 6.0f)
                    .sounds(BlockSoundGroup.DEEPSLATE).requiresTool()),true);
    public static final Block SCULK_SLATE_BRICKS = registerBlock("sculk_slate_bricks",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.DEEPSLATE_GRAY).strength(2.0f, 6.0f)
                    .sounds(BlockSoundGroup.DEEPSLATE).requiresTool()),true);
    public static final Block SCULK_SLATE_BRICK_SLAB = registerBlock("sculk_slate_brick_slab",
            new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.DEEPSLATE_GRAY).strength(2.0f, 6.0f)
                    .sounds(BlockSoundGroup.DEEPSLATE).requiresTool()),true);
    public static final Block SCULK_SLATE_BRICK_STAIRS = registerBlock("sculk_slate_brick_stairs",
            new StairsBlock(ModBlocks.SCULK_SLATE_BRICKS.getDefaultState(),AbstractBlock.Settings.create().mapColor(MapColor.EMERALD_GREEN).strength(2.0f, 6.0f)
                    .sounds(BlockSoundGroup.DEEPSLATE).requiresTool()),true);
    public static final Block SCULK_SLATE_BRICK_WALL = registerBlock("sculk_slate_brick_wall",
            new WallBlock(AbstractBlock.Settings.create().mapColor(MapColor.DEEPSLATE_GRAY).strength(2.0f, 6.0f)
                    .sounds(BlockSoundGroup.DEEPSLATE).requiresTool()),true);

    public static final Block TIN_ORE = registerBlock("tin_ore",
             new Block(AbstractBlock.Settings.copy(Blocks.IRON_ORE)),true);
    public static final Block DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
             new Block(AbstractBlock.Settings.copy(ModBlocks.TIN_ORE).sounds(BlockSoundGroup.DEEPSLATE).mapColor(MapColor.DEEPSLATE_GRAY)),true);
    public static final Block RAW_TIN_BLOCK = registerBlock("raw_tin_block",
             new Block(AbstractBlock.Settings.copy(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.LIGHT_GRAY)),true);
    public static final Block TIN_BLOCK = registerBlock("tin_block",
             new Block(AbstractBlock.Settings.copy(Blocks.COPPER_BLOCK).mapColor(MapColor.LIGHT_GRAY)),true);
    public static final Block CUT_TIN = registerBlock("cut_tin",
             new Block(AbstractBlock.Settings.copy(Blocks.CUT_COPPER).mapColor(MapColor.LIGHT_GRAY)),true);
    public static final Block CUT_TIN_SLAB = registerBlock("cut_tin_slab",
             new SlabBlock(AbstractBlock.Settings.copy(Blocks.CUT_COPPER).mapColor(MapColor.LIGHT_GRAY)),true);
    public static final Block CUT_TIN_STAIRS = registerBlock("cut_tin_stairs",
             new StairsBlock(ModBlocks.CUT_TIN.getDefaultState(),AbstractBlock.Settings.copy(Blocks.CUT_COPPER).mapColor(MapColor.LIGHT_GRAY)),true);
    public static final Block CHISELED_TIN = registerBlock("chiseled_tin",
             new Block(AbstractBlock.Settings.copy(Blocks.CHISELED_COPPER).mapColor(MapColor.LIGHT_GRAY)),true);
    public static final Block TIN_GRATE = registerBlock("tin_grate",
             new Block(AbstractBlock.Settings.copy(Blocks.COPPER_GRATE).mapColor(MapColor.LIGHT_GRAY)),true);
    public static final Block TIN_BARS = registerBlock("tin_bars",
             new PaneBlock(AbstractBlock.Settings.copy(Blocks.IRON_BARS).mapColor(MapColor.LIGHT_GRAY)),true);
    public static final Block TIN_CHAIN = registerBlock("tin_chain",
             new ChainBlock(AbstractBlock.Settings.copy(Blocks.CHAIN).mapColor(MapColor.LIGHT_GRAY)),true);
    public static final Block TIN_LANTERN = registerBlock("tin_lantern",
             new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN).mapColor(MapColor.LIGHT_GRAY)),true);
    public static final Block TIN_DOOR = registerBlock("tin_door",
             new DoorBlock(BlockSetType.COPPER,AbstractBlock.Settings.copy(Blocks.IRON_BARS).mapColor(MapColor.LIGHT_GRAY)),true);
    public static final Block TIN_TRAPDOOR = registerBlock("tin_trapdoor",
             new TrapdoorBlock(BlockSetType.COPPER,AbstractBlock.Settings.copy(Blocks.IRON_BARS).mapColor(MapColor.LIGHT_GRAY)),true);

    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK).mapColor(MapColor.GRAY)),true);
    public static final Block STEEL_BARS = registerBlock("steel_bars",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.IRON_BARS).mapColor(MapColor.GRAY)),true);
    public static final Block STEEL_CHAIN = registerBlock("steel_chain",
            new ChainBlock(AbstractBlock.Settings.copy(Blocks.CHAIN).mapColor(MapColor.GRAY)),true);
    public static final Block STEEL_LANTERN = registerBlock("steel_lantern",
            new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN).mapColor(MapColor.GRAY)),true);

    public static final Block AURORITE_BLOCK = registerBlock("aurorite_block",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).mapColor(MapColor.PINK)),true);
    public static final Block AURORITE_CRYSTAL_BLOCK = registerBlock("aurorite_crystal_block",
            new AmethystBlock(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK).mapColor(MapColor.PINK)),true);
    public static final Block BUDDING_AURORITE = registerBlock("budding_aurorite",
            new BuddingAuroriteBlock(AbstractBlock.Settings.copy(Blocks.BUDDING_AMETHYST).mapColor(MapColor.PINK)),true);
    public static final Block AURORITE_CLUSTER = registerBlock("aurorite_cluster",
            new AmethystClusterBlock(7.0f,3.0f,
                    AbstractBlock.Settings.copy(Blocks.AMETHYST_CLUSTER).mapColor(MapColor.PINK)),true);
    public static final Block LARGE_AURORITE_BUD = registerBlock("large_aurorite_bud",
            new AmethystClusterBlock(5.0f,3.0f,
                    AbstractBlock.Settings.copy(Blocks.LARGE_AMETHYST_BUD).mapColor(MapColor.PINK)),true);
    public static final Block MEDIUM_AURORITE_BUD = registerBlock("medium_aurorite_bud",
            new AmethystClusterBlock(4.0f,3.0f,
                    AbstractBlock.Settings.copy(Blocks.MEDIUM_AMETHYST_BUD).mapColor(MapColor.PINK)),true);
    public static final Block SMALL_AURORITE_BUD = registerBlock("small_aurorite_bud",
            new AmethystClusterBlock(3.0f,4.0f,
                    AbstractBlock.Settings.copy(Blocks.SMALL_AMETHYST_BUD).mapColor(MapColor.PINK)),true);

    public static final Block BRONZE_BLOCK = registerBlock("bronze_block",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).mapColor(MapColor.DIRT_BROWN)),true);
    public static final Block BRONZE_BARS = registerBlock("bronze_bars",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.IRON_BARS).mapColor(MapColor.DIRT_BROWN)),true);
    public static final Block BRONZE_CHAIN = registerBlock("bronze_chain",
            new ChainBlock(AbstractBlock.Settings.copy(Blocks.CHAIN).mapColor(MapColor.DIRT_BROWN)),true);
    public static final Block BRONZE_LANTERN = registerBlock("bronze_lantern",
            new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN).mapColor(MapColor.DIRT_BROWN)),true);

    public static final Block COBALT_ORE = registerBlock("cobalt_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_ORE)),true);
    public static final Block DEEPSLATE_COBALT_ORE = registerBlock("deepslate_cobalt_ore",
            new Block(AbstractBlock.Settings.copy(ModBlocks.COBALT_ORE).sounds(BlockSoundGroup.DEEPSLATE).mapColor(MapColor.DEEPSLATE_GRAY)),true);
    public static final Block RAW_COBALT_BLOCK = registerBlock("raw_cobalt_block",
            new Block(AbstractBlock.Settings.copy(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.BLUE)),true);
    public static final Block COBALT_BLOCK = registerBlock("cobalt_block",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).mapColor(MapColor.BLUE)),true);
    public static final Block COBALT_BARS = registerBlock("cobalt_bars",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.IRON_BARS).mapColor(MapColor.BLUE)),true);
    public static final Block COBALT_CHAIN = registerBlock("cobalt_chain",
            new ChainBlock(AbstractBlock.Settings.copy(Blocks.CHAIN).mapColor(MapColor.BLUE)),true);
    public static final Block COBALT_LANTERN = registerBlock("cobalt_lantern",
            new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN).mapColor(MapColor.BLUE)),true);

    public static final Block CRIMSONITE_ORE = registerBlock("crimsonite_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.END_STONE).strength(30.0F, 1000.0f)),true);
    public static final Block RAW_CRIMSONITE_BLOCK = registerBlock("raw_crimsonite_block",
            new Block(AbstractBlock.Settings.copy(Blocks.RAW_COPPER_BLOCK).mapColor(MapColor.RED).strength(30.0F, 1000.0f)),true);
    public static final Block CRIMSONITE_BLOCK = registerBlock("crimsonite_block",
            new Block(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK).mapColor(MapColor.RED).strength(30.0F)),true);



    static {
        OxidizableChainBlock.registerOxidationPair(COPPER_CHAIN, EXPOSED_COPPER_CHAIN);
        OxidizableChainBlock.registerOxidationPair(EXPOSED_COPPER_CHAIN, WEATHERED_COPPER_CHAIN);
        OxidizableChainBlock.registerOxidationPair(WEATHERED_COPPER_CHAIN, OXIDIZED_COPPER_CHAIN);
    }
    static {
        OxidizableLanternBlock.registerOxidationPair(COPPER_LANTERN, EXPOSED_COPPER_LANTERN);
        OxidizableLanternBlock.registerOxidationPair(EXPOSED_COPPER_LANTERN, WEATHERED_COPPER_LANTERN);
        OxidizableLanternBlock.registerOxidationPair(WEATHERED_COPPER_LANTERN, OXIDIZED_COPPER_LANTERN);
    }
    static {
        OxidizableBarsBlock.registerOxidationPair(COPPER_BARS, EXPOSED_COPPER_BARS);
        OxidizableBarsBlock.registerOxidationPair(EXPOSED_COPPER_BARS, WEATHERED_COPPER_BARS);
        OxidizableBarsBlock.registerOxidationPair(WEATHERED_COPPER_BARS, OXIDIZED_COPPER_BARS);
    }

    private static Block registerBlock(String name, Block block, boolean hasItem){
        Block registeredBlock = Registry.register(Registries.BLOCK, Identifier.of(BiomeNexus.MOD_ID, name), block);
        if (hasItem){
            registerBlockItem(name, block);
        }return registeredBlock;
    }
    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(BiomeNexus.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    public static void init(){}
}
