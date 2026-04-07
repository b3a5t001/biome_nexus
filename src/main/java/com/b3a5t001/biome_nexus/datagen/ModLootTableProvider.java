package com.b3a5t001.biome_nexus.datagen;

import com.b3a5t001.biome_nexus.blocks.ModBlocks;
import com.b3a5t001.biome_nexus.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SULFUR_BLOCK);
        addDrop(ModBlocks.SULFUR_ORE,oreDrops(ModBlocks.SULFUR_ORE, ModItems.SULFUR_DUST));
        addDrop(ModBlocks.SULFUR_TORCH, drops(ModItems.SULFUR_TORCH));
        addDrop(ModBlocks.SULFUR_WALL_TORCH, drops(ModItems.SULFUR_TORCH));
        addDrop(ModBlocks.GOLD_LANTERN);
        addDrop(ModBlocks.GOLD_CHAIN);
        addDrop(ModBlocks.GOLD_BARS);
        addDrop(ModBlocks.COPPER_TORCH, drops(ModItems.COPPER_TORCH));
        addDrop(ModBlocks.COPPER_WALL_TORCH, drops(ModItems.COPPER_TORCH));
        addDrop(ModBlocks.COPPER_LANTERN);
        addDrop(ModBlocks.WAXED_COPPER_LANTERN);
        addDrop(ModBlocks.EXPOSED_COPPER_LANTERN);
        addDrop(ModBlocks.WAXED_EXPOSED_COPPER_LANTERN);
        addDrop(ModBlocks.WEATHERED_COPPER_LANTERN);
        addDrop(ModBlocks.WAXED_WEATHERED_COPPER_LANTERN);
        addDrop(ModBlocks.OXIDISED_COPPER_LANTERN);
        addDrop(ModBlocks.WAXED_OXIDISED_COPPER_LANTERN);
        addDrop(ModBlocks.COPPER_CHAIN);
        addDrop(ModBlocks.WAXED_COPPER_CHAIN);
        addDrop(ModBlocks.EXPOSED_COPPER_CHAIN);
        addDrop(ModBlocks.WAXED_EXPOSED_COPPER_CHAIN);
        addDrop(ModBlocks.WEATHERED_COPPER_CHAIN);
        addDrop(ModBlocks.WAXED_WEATHERED_COPPER_CHAIN);
        addDrop(ModBlocks.OXIDISED_COPPER_CHAIN);
        addDrop(ModBlocks.WAXED_OXIDISED_COPPER_CHAIN);
        addDrop(ModBlocks.COPPER_BARS);
        addDrop(ModBlocks.WAXED_COPPER_BARS);
        addDrop(ModBlocks.EXPOSED_COPPER_BARS);
        addDrop(ModBlocks.WAXED_EXPOSED_COPPER_BARS);
        addDrop(ModBlocks.WEATHERED_COPPER_BARS);
        addDrop(ModBlocks.WAXED_WEATHERED_COPPER_BARS);
        addDrop(ModBlocks.OXIDISED_COPPER_BARS);
        addDrop(ModBlocks.WAXED_OXIDISED_COPPER_BARS);
        addDrop(ModBlocks.LIMESTONE);
        addDrop(ModBlocks.LIMESTONE_SLAB, slabDrops(ModBlocks.LIMESTONE_SLAB));
        addDrop(ModBlocks.LIMESTONE_STAIRS);
        addDrop(ModBlocks.LIMESTONE_WALL);
        addDrop(ModBlocks.POLISHED_LIMESTONE);
        addDrop(ModBlocks.POLISHED_LIMESTONE_SLAB,slabDrops(ModBlocks.POLISHED_LIMESTONE_SLAB));
        addDrop(ModBlocks.POLISHED_LIMESTONE_STAIRS);
        addDrop(ModBlocks.POLISHED_LIMESTONE_WALL);
        addDrop(ModBlocks.LIMESTONE_BRICKS);
        addDrop(ModBlocks.LIMESTONE_BRICK_SLAB,slabDrops(ModBlocks.LIMESTONE_BRICK_SLAB));
        addDrop(ModBlocks.LIMESTONE_BRICK_STAIRS);
        addDrop(ModBlocks.LIMESTONE_BRICK_WALL);
        addDrop(ModBlocks.ICE_ROCK);
        addDrop(ModBlocks.ICE_ROCK_SLAB, slabDrops(ModBlocks.ICE_ROCK_SLAB));
        addDrop(ModBlocks.ICE_ROCK_STAIRS);
        addDrop(ModBlocks.ICE_ROCK_WALL);
        addDrop(ModBlocks.POLISHED_ICE_ROCK);
        addDrop(ModBlocks.POLISHED_ICE_ROCK_SLAB,slabDrops(ModBlocks.POLISHED_ICE_ROCK_SLAB));
        addDrop(ModBlocks.POLISHED_ICE_ROCK_STAIRS);
        addDrop(ModBlocks.POLISHED_ICE_ROCK_WALL);
        addDrop(ModBlocks.ICE_ROCK_BRICKS);
        addDrop(ModBlocks.ICE_ROCK_BRICK_SLAB,slabDrops(ModBlocks.ICE_ROCK_BRICK_SLAB));
        addDrop(ModBlocks.ICE_ROCK_BRICK_STAIRS);
        addDrop(ModBlocks.ICE_ROCK_BRICK_WALL);
        addDrop(ModBlocks.JADE_BLOCK);
        addDrop(ModBlocks.JADE_BRICKS);
        addDrop(ModBlocks.JADE_BRICK_SLAB,slabDrops(ModBlocks.JADE_BRICK_SLAB));
        addDrop(ModBlocks.JADE_BRICK_STAIRS);
        addDrop(ModBlocks.JADE_BRICK_WALL);
        addDrop(ModBlocks.JADE_ORE,multipleOreDrops(ModBlocks.JADE_ORE, ModItems.JADE_CRYSTAL,1,3));
        addDrop(ModBlocks.DEEPSLATE_JADE_ORE,multipleOreDrops(ModBlocks.DEEPSLATE_JADE_ORE, ModItems.JADE_CRYSTAL,1,3));;
        addDrop(ModBlocks.SCULK_SLATE);
        addDrop(ModBlocks.SCULK_SLATE_BRICKS);
        addDrop(ModBlocks.SCULK_SLATE_BRICK_SLAB,slabDrops(ModBlocks.SCULK_SLATE_BRICK_SLAB));
        addDrop(ModBlocks.SCULK_SLATE_BRICK_STAIRS);
        addDrop(ModBlocks.SCULK_SLATE_BRICK_WALL);
        addDrop(ModBlocks.TIN_ORE, multipleOreDrops(ModBlocks.TIN_ORE, ModItems.RAW_TIN,2,5));
        addDrop(ModBlocks.DEEPSLATE_TIN_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_TIN_ORE, ModItems.RAW_TIN,2,5));
        addDrop(ModBlocks.RAW_TIN_BLOCK);
        addDrop(ModBlocks.TIN_BLOCK);
        addDrop(ModBlocks.CUT_TIN);
        addDrop(ModBlocks.CUT_TIN_SLAB, slabDrops(ModBlocks.CUT_TIN_SLAB));
        addDrop(ModBlocks.CUT_TIN_STAIRS);
        addDrop(ModBlocks.CHISELED_TIN);
        addDrop(ModBlocks.TIN_GRATE);
        addDrop(ModBlocks.TIN_TORCH, drops(ModItems.TIN_TORCH));
        addDrop(ModBlocks.TIN_WALL_TORCH, drops(ModItems.TIN_TORCH));
        addDrop(ModBlocks.TIN_LANTERN);
        addDrop(ModBlocks.TIN_CHAINS);
        addDrop(ModBlocks.TIN_BARS);
        addDrop(ModBlocks.TIN_DOOR, doorDrops(ModBlocks.TIN_DOOR));
        addDrop(ModBlocks.TIN_TRAPDOOR);
    }

    public LootTable.Builder multipleOreDrops(Block block, Item drop, int min, int max) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(
                block,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(drop)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))
                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
