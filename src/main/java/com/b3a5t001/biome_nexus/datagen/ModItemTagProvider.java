package com.b3a5t001.biome_nexus.datagen;

import com.b3a5t001.biome_nexus.blocks.ModBlocks;
import com.b3a5t001.biome_nexus.items.ModItems;
import com.b3a5t001.biome_nexus.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider{
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.SULFUR_DUST)
                .add(ModItems.JADE_BRICK)
                .add(ModItems.TIN_INGOT)
                .add(ModItems.STEEL_INGOT)
                .add(ModItems.CRIMSONITE_INGOT)
                .add(ModItems.COBALT_INGOT)
                .add(ModItems.BRONZE_INGOT)
                .add(ModItems.AURORITE_ALLOY)
                .add(Items.ECHO_SHARD)
                .add(Items.BLUE_ICE);

        getOrCreateTagBuilder(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.GRACE_SMITHING_TEMPLATE)
                .add(ModItems.VINE_SMITHING_TEMPLATE)
                .add(ModItems.GEM_SMITHING_TEMPLATE);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.COPPER_SWORD)
                .add(ModItems.CRIMSONITE_SWORD)
                .add(ModItems.STEEL_SWORD)
                .add(ModItems.COBALT_SWORD)
                .add(ModItems.BRONZE_SWORD)
                .add(ModItems.AURORITE_SWORD);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.COPPER_AXE)
                .add(ModItems.CRIMSONITE_AXE)
                .add(ModItems.STEEL_AXE)
                .add(ModItems.COBALT_AXE)
                .add(ModItems.BRONZE_AXE)
                .add(ModItems.AURORITE_AXE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.COPPER_PICKAXE)
                .add(ModItems.CRIMSONITE_PICKAXE)
                .add(ModItems.STEEL_PICKAXE)
                .add(ModItems.COBALT_PICKAXE)
                .add(ModItems.BRONZE_PICKAXE)
                .add(ModItems.AURORITE_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.COPPER_SHOVEL)
                .add(ModItems.CRIMSONITE_SHOVEL)
                .add(ModItems.STEEL_SHOVEL)
                .add(ModItems.COBALT_SHOVEL)
                .add(ModItems.BRONZE_SHOVEL)
                .add(ModItems.AURORITE_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.COPPER_HOE)
                .add(ModItems.CRIMSONITE_HOE)
                .add(ModItems.STEEL_HOE)
                .add(ModItems.COBALT_HOE)
                .add(ModItems.BRONZE_HOE)
                .add(ModItems.AURORITE_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.COPPER_HELMET)
                .add(ModItems.COPPER_CHESTPLATE)
                .add(ModItems.COPPER_LEGGINGS)
                .add(ModItems.COPPER_BOOTS)
                .add(ModItems.CRIMSONITE_HELMET)
                .add(ModItems.CRIMSONITE_CHESTPLATE)
                .add(ModItems.CRIMSONITE_LEGGINGS)
                .add(ModItems.CRIMSONITE_BOOTS)
                .add(ModItems.STEEL_HELMET)
                .add(ModItems.STEEL_CHESTPLATE)
                .add(ModItems.STEEL_LEGGINGS)
                .add(ModItems.STEEL_BOOTS)
                .add(ModItems.COBALT_HELMET)
                .add(ModItems.COBALT_CHESTPLATE)
                .add(ModItems.COBALT_LEGGINGS)
                .add(ModItems.COBALT_BOOTS)
                .add(ModItems.BRONZE_HELMET)
                .add(ModItems.BRONZE_CHESTPLATE)
                .add(ModItems.BRONZE_LEGGINGS)
                .add(ModItems.BRONZE_BOOTS)
                .add(ModItems.AURORITE_HELMET)
                .add(ModItems.AURORITE_CHESTPLATE)
                .add(ModItems.AURORITE_LEGGINGS)
                .add(ModItems.AURORITE_BOOTS);

        getOrCreateTagBuilder(ModTags.Items.STONE_VARIANTS)
                .add(Items.STONE)
                .add(Items.GRANITE)
                .add(Items.DIORITE)
                .add(Items.ANDESITE)
                .add(Items.CALCITE)
                .add(Items.DRIPSTONE_BLOCK)
                .add(Items.TUFF)
                .add(Items.BLACKSTONE)
                .add(Items.BASALT)
                .add(Items.DEEPSLATE)
                .add(ModBlocks.LIMESTONE.asItem());

        getOrCreateTagBuilder(ModTags.Items.CRYSTALS)
                .add(Items.AMETHYST_SHARD)
                .add(ModItems.JADE_CRYSTAL)
                .add(ModItems.AURORITE_CRYSTAL);

        getOrCreateTagBuilder(ModTags.Items.EXPLOSIVE_POWDERS)
                .add(Items.GUNPOWDER)
                .add(ModItems.SULFUR_DUST);


    }
}
