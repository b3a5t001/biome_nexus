package com.b3a5t001.biome_nexus.blocks;

import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;

public class BlockEventHandler {
    public static void init() {
        registerOxidationAndWax(ModBlocks.COPPER_BARS, ModBlocks.EXPOSED_COPPER_BARS, ModBlocks.WEATHERED_COPPER_BARS, ModBlocks.OXIDIZED_COPPER_BARS,
                ModBlocks.WAXED_COPPER_BARS, ModBlocks.WAXED_EXPOSED_COPPER_BARS, ModBlocks.WAXED_WEATHERED_COPPER_BARS, ModBlocks.WAXED_OXIDIZED_COPPER_BARS);

        registerOxidationAndWax(ModBlocks.COPPER_CHAIN, ModBlocks.EXPOSED_COPPER_CHAIN, ModBlocks.WEATHERED_COPPER_CHAIN, ModBlocks.OXIDIZED_COPPER_CHAIN,
                ModBlocks.WAXED_COPPER_CHAIN, ModBlocks.WAXED_EXPOSED_COPPER_CHAIN, ModBlocks.WAXED_WEATHERED_COPPER_CHAIN, ModBlocks.WAXED_OXIDIZED_COPPER_CHAIN);

        registerOxidationAndWax(ModBlocks.COPPER_LANTERN, ModBlocks.EXPOSED_COPPER_LANTERN, ModBlocks.WEATHERED_COPPER_LANTERN, ModBlocks.OXIDIZED_COPPER_LANTERN,
                ModBlocks.WAXED_COPPER_LANTERN, ModBlocks.WAXED_EXPOSED_COPPER_LANTERN, ModBlocks.WAXED_WEATHERED_COPPER_LANTERN, ModBlocks.WAXED_OXIDIZED_COPPER_LANTERN);
    }

    private static void registerOxidationAndWax(
            net.minecraft.block.Block base,
            net.minecraft.block.Block exposed,
            net.minecraft.block.Block weathered,
            net.minecraft.block.Block oxidized,
            net.minecraft.block.Block waxedBase,
            net.minecraft.block.Block waxedExposed,
            net.minecraft.block.Block waxedWeathered,
            net.minecraft.block.Block waxedOxidized
    ) {
        OxidizableBlocksRegistry.registerOxidizableBlockPair(base, exposed);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(exposed, weathered);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(weathered, oxidized);

        OxidizableBlocksRegistry.registerWaxableBlockPair(base, waxedBase);
        OxidizableBlocksRegistry.registerWaxableBlockPair(exposed, waxedExposed);
        OxidizableBlocksRegistry.registerWaxableBlockPair(weathered, waxedWeathered);
        OxidizableBlocksRegistry.registerWaxableBlockPair(oxidized, waxedOxidized);
    }
}
