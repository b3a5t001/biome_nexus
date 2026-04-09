package com.b3a5t001.biome_nexus.world;

import com.b3a5t001.biome_nexus.BiomeNexus;
import com.b3a5t001.biome_nexus.blocks.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> TIN_ORE_KEY = registryKey("tin_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PLAINS_TIN_ORE_KEY = registryKey("plains_tin_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CAVE_COBALT_ORE_KEY = registryKey("cave_cobalt_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COBALT_ORE_KEY = registryKey("cobalt_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LIMESTONE_KEY = registryKey("limestone");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ICE_ROCK_KEY = registryKey("ice_rock");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SCULK_SLATE_KEY = registryKey("sculk_slate");
    public static final RegistryKey<ConfiguredFeature<?, ?>> JADE_ORE_KEY = registryKey("jade_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUSH_JADE_ORE_KEY = registryKey("cave_jade_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> ICE_ROCK_PILE_KEY = registryKey("ice_rock_pile");

    public static final RegistryKey<ConfiguredFeature<?, ?>> AURORITE_GEODE_KEY = registryKey("aurorite_geode");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> tinOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.TIN_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_TIN_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> cobaltOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.COBALT_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_COBALT_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> jadeOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.JADE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_JADE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> limestone =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.LIMESTONE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.LIMESTONE.getDefaultState()));
        List<OreFeatureConfig.Target> sculkSlate =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.SCULK_SLATE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.SCULK_SLATE.getDefaultState()));
        List<OreFeatureConfig.Target> iceRock =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.ICE_ROCK.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.ICE_ROCK.getDefaultState()));

        register(context, TIN_ORE_KEY, Feature.ORE, new OreFeatureConfig(tinOres, 8));
        register(context, PLAINS_TIN_ORE_KEY, Feature.ORE, new OreFeatureConfig(tinOres, 20));
        register(context, CAVE_COBALT_ORE_KEY, Feature.ORE, new OreFeatureConfig(cobaltOres, 6));
        register(context, COBALT_ORE_KEY, Feature.ORE, new OreFeatureConfig(cobaltOres, 8,1.0f));
        register(context, LIMESTONE_KEY, Feature.ORE, new OreFeatureConfig(limestone, 64));
        register(context, JADE_ORE_KEY, Feature.ORE, new OreFeatureConfig(jadeOres, 10,0.2f));
        register(context, LUSH_JADE_ORE_KEY, Feature.ORE, new OreFeatureConfig(jadeOres, 12));
        register(context, SCULK_SLATE_KEY, Feature.ORE, new OreFeatureConfig(sculkSlate, 64));
        register(context, ICE_ROCK_KEY, Feature.ORE, new OreFeatureConfig(iceRock, 64));


        register(context, ICE_ROCK_PILE_KEY, Feature.FOREST_ROCK,
                new SingleStateFeatureConfig(ModBlocks.ICE_ROCK.getDefaultState()));


        register(context, AURORITE_GEODE_KEY, Feature.GEODE, new GeodeFeatureConfig(
                        new GeodeLayerConfig(BlockStateProvider.of(Blocks.AIR),
                                BlockStateProvider.of(ModBlocks.AURORITE_CRYSTAL_BLOCK), BlockStateProvider.of(ModBlocks.BUDDING_AURORITE),
                                BlockStateProvider.of(ModBlocks.ICE_ROCK), BlockStateProvider.of(ModBlocks.LIMESTONE),
                                List.of(
                                        ModBlocks.SMALL_AURORITE_BUD.getDefaultState(), ModBlocks.MEDIUM_AURORITE_BUD.getDefaultState(),
                                        ModBlocks.LARGE_AURORITE_BUD.getDefaultState(), ModBlocks.AURORITE_CLUSTER.getDefaultState()),
                                BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerThicknessConfig(1.7, 2.2, 3.2, 4.2),
                        new GeodeCrackConfig(0.95, 2.0, 2),
                        0.35, 0.083, true,
                        UniformIntProvider.create(4, 6), UniformIntProvider.create(3, 4), UniformIntProvider.create(1, 2),
                        -16, 16, 0.05, 1));

    }
    public static RegistryKey<ConfiguredFeature<?,?>> registryKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(BiomeNexus.MOD_ID, name));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?,?>> key, F feature, FC config){
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
