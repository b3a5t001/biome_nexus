package com.b3a5t001.biome_nexus.items;

import com.b3a5t001.biome_nexus.blocks.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

public class ModItemGroup {
    public static void init(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(
                entries -> {
                    entries.add(ModItems.SULFUR_DUST);
                    entries.add(ModItems.COPPER_NUGGET);
                }
        );
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(
                entries -> {
                    entries.add(ModItems.COPPER_SWORD);
                    entries.add(ModItems.COPPER_AXE);
                    entries.add(ModItems.COPPER_HELMET);
                    entries.add(ModItems.COPPER_CHESTPLATE);
                    entries.add(ModItems.COPPER_LEGGINGS);
                    entries.add(ModItems.COPPER_BOOTS);
                }
        );
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(
                entries -> {
                    entries.add(ModItems.COPPER_PICKAXE);
                    entries.add(ModItems.COPPER_AXE);
                    entries.add(ModItems.COPPER_SHOVEL);
                    entries.add(ModItems.COPPER_HOE);
                }
        );
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(
                entries -> {
                    entries.add(ModBlocks.COPPER_CHAIN);
                    entries.add(ModBlocks.EXPOSED_COPPER_CHAIN);
                    entries.add(ModBlocks.WEATHERED_COPPER_CHAIN);
                    entries.add(ModBlocks.OXIDISED_COPPER_CHAIN);
                    entries.add(ModBlocks.COPPER_BARS);
                    entries.add(ModBlocks.EXPOSED_COPPER_BARS);
                    entries.add(ModBlocks.WEATHERED_COPPER_BARS);
                    entries.add(ModBlocks.OXIDISED_COPPER_BARS);
                    entries.add(ModBlocks.WAXED_COPPER_CHAIN);
                    entries.add(ModBlocks.WAXED_EXPOSED_COPPER_CHAIN);
                    entries.add(ModBlocks.WAXED_WEATHERED_COPPER_CHAIN);
                    entries.add(ModBlocks.WAXED_OXIDISED_COPPER_CHAIN);
                    entries.add(ModBlocks.WAXED_COPPER_BARS);
                    entries.add(ModBlocks.WAXED_EXPOSED_COPPER_BARS);
                    entries.add(ModBlocks.WAXED_WEATHERED_COPPER_BARS);
                    entries.add(ModBlocks.WAXED_OXIDISED_COPPER_BARS);
                    entries.add(ModBlocks.SULFUR_BLOCK);
                    entries.add(ModBlocks.GOLD_CHAIN);
                    entries.add(ModBlocks.GOLD_BARS);
                    entries.add(ModBlocks.ICE_ROCK);
                    entries.add(ModBlocks.ICE_ROCK_SLAB);
                    entries.add(ModBlocks.ICE_ROCK_STAIRS);
                    entries.add(ModBlocks.ICE_ROCK_WALL);
                    entries.add(ModBlocks.POLISHED_ICE_ROCK);
                    entries.add(ModBlocks.POLISHED_ICE_ROCK_SLAB);
                    entries.add(ModBlocks.POLISHED_ICE_ROCK_STAIRS);
                    entries.add(ModBlocks.POLISHED_ICE_ROCK_WALL);
                    entries.add(ModBlocks.ICE_ROCK_BRICKS);
                    entries.add(ModBlocks.ICE_ROCK_BRICK_SLAB);
                    entries.add(ModBlocks.ICE_ROCK_BRICK_STAIRS);
                    entries.add(ModBlocks.ICE_ROCK_BRICK_WALL);
                }
        );
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(
                entries -> {
                    entries.add(ModBlocks.SULFUR_ORE);
                }
        );
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(
                entries -> {
                    entries.add(ModItems.COPPER_TORCH);
                    entries.add(ModBlocks.COPPER_LANTERN);
                    entries.add(ModBlocks.EXPOSED_COPPER_LANTERN);
                    entries.add(ModBlocks.WEATHERED_COPPER_LANTERN);
                    entries.add(ModBlocks.OXIDISED_COPPER_LANTERN);
                    entries.add(ModBlocks.WAXED_COPPER_LANTERN);
                    entries.add(ModBlocks.WAXED_EXPOSED_COPPER_LANTERN);
                    entries.add(ModBlocks.WAXED_WEATHERED_COPPER_LANTERN);
                    entries.add(ModBlocks.WAXED_OXIDISED_COPPER_LANTERN);
                    entries.add(ModItems.SULFUR_TORCH);
                    entries.add(ModBlocks.GOLD_LANTERN);
                }
        );
    }
}
