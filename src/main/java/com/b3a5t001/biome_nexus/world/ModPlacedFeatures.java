package com.b3a5t001.biome_nexus.world;

import com.b3a5t001.biome_nexus.BiomeNexus;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> TIN_ORE_PLACED_KEY = registryKey("tin_ore_placed");
    public static final RegistryKey<PlacedFeature> PLAINS_TIN_ORE_PLACED_KEY = registryKey("plains_tin_ore_placed");
    public static final RegistryKey<PlacedFeature> CAVE_COBALT_ORE_PLACED_KEY = registryKey("cave_cobalt_ore_placed");
    public static final RegistryKey<PlacedFeature> COBALT_ORE_PLACED_KEY = registryKey("cobalt_ore_placed");
    public static final RegistryKey<PlacedFeature> LIMESTONE_PLACED_KEY = registryKey("limestone_placed");
    public static final RegistryKey<PlacedFeature> JADE_ORE_PLACED_KEY = registryKey("jade_ore_placed");
    public static final RegistryKey<PlacedFeature> LUSH_JADE_ORE_PLACED_KEY = registryKey("lush_jade_ore_placed");
    public static final RegistryKey<PlacedFeature> SCULK_SLATE_PLACED_KEY = registryKey("sculk_slate_placed");
    public static final RegistryKey<PlacedFeature> ICE_ROCK_PLACED_KEY = registryKey("ice_rock_placed");
    public static final RegistryKey<PlacedFeature> NETHER_SULFUR_ORE_PLACED_KEY = registryKey("nether_sulfur_ore_placed");
    public static final RegistryKey<PlacedFeature> END_CRIMSONTE_ORE_PLACED_KEY = registryKey("end_crimsonite_ore_placed");
    public static final RegistryKey<PlacedFeature> QUARTZ_ORE_PLACED_KEY = registryKey("quartz_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_GOLD_ORE_PLACED_KEY = registryKey("nether_gold_ore_placed");

    public static final RegistryKey<PlacedFeature> ICE_ROCK_PILE_PLACED_KEY = registryKey("ice_rock_pile_placed");
    public static final RegistryKey<PlacedFeature> AURORITE_GEODE_PLACED_KEY = registryKey("aurorite_geode_placed");

    public static void bootstrap(Registerable<PlacedFeature> context){
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, TIN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TIN_ORE_KEY),
                ModOrePlacement.modifiersWithCount(10,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-16), YOffset.fixed(64))));
        register(context, PLAINS_TIN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PLAINS_TIN_ORE_KEY),
                ModOrePlacement.modifiersWithCount(10,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-16), YOffset.fixed(64))));
        register(context, CAVE_COBALT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CAVE_COBALT_ORE_KEY),
                ModOrePlacement.modifiersWithCount(10,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(16))));
        register(context, COBALT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.COBALT_ORE_KEY),
                ModOrePlacement.modifiersWithCount(10,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(16))));
        register(context, LIMESTONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LIMESTONE_KEY),
                ModOrePlacement.modifiersWithCount(2,
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(0))));
        register(context, JADE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.JADE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(10,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(64))));
        register(context, LUSH_JADE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LUSH_JADE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(10,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(365), YOffset.fixed(0))));
        register(context, SCULK_SLATE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SCULK_SLATE_KEY),
                ModOrePlacement.modifiersWithCount(2,
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(0))));
        register(context, ICE_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_ROCK_KEY),
                ModOrePlacement.modifiersWithCount(2,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(0), YOffset.fixed(128))));
        register(context, NETHER_SULFUR_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_SULFUR_ORE_KEY),
                ModOrePlacement.modifiersWithCount(10,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(128))));
        register(context, END_CRIMSONTE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_CRIMSONITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(10,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(80))));
        register(context, QUARTZ_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.QUARTZ_ORE_KEY),
                ModOrePlacement.modifiersWithCount(16, PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));
        register(context, NETHER_GOLD_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_GOLD_ORE_KEY),
                ModOrePlacement.modifiersWithCount(10, PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));

        register(context, ICE_ROCK_PILE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_ROCK_PILE_KEY));
        register(context, AURORITE_GEODE_PLACED_KEY ,configuredFeatures.getOrThrow(ModConfiguredFeatures.AURORITE_GEODE_KEY),
                RarityFilterPlacementModifier.of(24), SquarePlacementModifier.of(),
                HeightRangePlacementModifier.uniform(YOffset.aboveBottom(6), YOffset.fixed(30)),
                BiomePlacementModifier.of()
        );
    }

    public static RegistryKey<PlacedFeature> registryKey(String name){
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(BiomeNexus.MOD_ID, name));
    }
    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> config,
                                 List<PlacementModifier> modifiers){
        context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> config,
                                                                                   PlacementModifier... modifiers){
        register(context, key, config, List.of(modifiers));
    }
}
