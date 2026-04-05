package com.b3a5t001.biome_nexus.blocks;

import com.b3a5t001.biome_nexus.BiomeNexus;
import com.b3a5t001.biome_nexus.blocks.custom.OxidizableChainBlock;
import com.b3a5t001.biome_nexus.blocks.custom.OxidizableLanternBlock;
import com.b3a5t001.biome_nexus.blocks.custom.OxidizableBarsBlock;
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
    public static final Block OXIDISED_COPPER_CHAIN = registerBlock("oxidised_copper_chain",
            new OxidizableChainBlock(Oxidizable.OxidationLevel.OXIDIZED,AbstractBlock.Settings.copy(Blocks.CHAIN).ticksRandomly()),true);
    public static final Block WAXED_OXIDISED_COPPER_CHAIN = registerBlock("waxed_oxidised_copper_chain",
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
    public static final Block OXIDISED_COPPER_LANTERN = registerBlock("oxidised_copper_lantern",
            new OxidizableLanternBlock(Oxidizable.OxidationLevel.OXIDIZED,AbstractBlock.Settings.copy(Blocks.LANTERN).ticksRandomly()),true);
    public static final Block WAXED_OXIDISED_COPPER_LANTERN = registerBlock("waxed_oxidised_copper_lantern",
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
    public static final Block OXIDISED_COPPER_BARS = registerBlock("oxidised_copper_bars",
            new OxidizableBarsBlock(Oxidizable.OxidationLevel.OXIDIZED,AbstractBlock.Settings.copy(Blocks.IRON_BARS).ticksRandomly()),true);
    public static final Block WAXED_OXIDISED_COPPER_BARS = registerBlock("waxed_oxidised_copper_bars",
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

    static {
        OxidizableChainBlock.registerOxidationPair(COPPER_CHAIN, EXPOSED_COPPER_CHAIN);
        OxidizableChainBlock.registerOxidationPair(EXPOSED_COPPER_CHAIN, WEATHERED_COPPER_CHAIN);
        OxidizableChainBlock.registerOxidationPair(WEATHERED_COPPER_CHAIN, OXIDISED_COPPER_CHAIN);
    }
    static {
        OxidizableLanternBlock.registerOxidationPair(COPPER_LANTERN, EXPOSED_COPPER_LANTERN);
        OxidizableLanternBlock.registerOxidationPair(EXPOSED_COPPER_LANTERN, WEATHERED_COPPER_LANTERN);
        OxidizableLanternBlock.registerOxidationPair(WEATHERED_COPPER_LANTERN, OXIDISED_COPPER_LANTERN);
    }
    static {
        OxidizableBarsBlock.registerOxidationPair(COPPER_BARS, EXPOSED_COPPER_BARS);
        OxidizableBarsBlock.registerOxidationPair(EXPOSED_COPPER_BARS, WEATHERED_COPPER_BARS);
        OxidizableBarsBlock.registerOxidationPair(WEATHERED_COPPER_BARS, OXIDISED_COPPER_BARS);
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
