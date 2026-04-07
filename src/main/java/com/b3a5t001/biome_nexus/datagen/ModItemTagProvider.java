package com.b3a5t001.biome_nexus.datagen;

import com.b3a5t001.biome_nexus.items.ModItems;
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
                .add(Items.ECHO_SHARD)
                .add(Items.BLUE_ICE);

        getOrCreateTagBuilder(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.GRACE_SMITHING_TEMPLATE);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.COPPER_SWORD)
                .add(ModItems.STEEL_SWORD);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.COPPER_AXE)
                .add(ModItems.STEEL_AXE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.COPPER_PICKAXE)
                .add(ModItems.STEEL_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.COPPER_SHOVEL)
                .add(ModItems.STEEL_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.COPPER_HOE)
                .add(ModItems.STEEL_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.COPPER_HELMET)
                .add(ModItems.COPPER_CHESTPLATE)
                .add(ModItems.COPPER_LEGGINGS)
                .add(ModItems.COPPER_BOOTS)
                .add(ModItems.STEEL_HELMET)
                .add(ModItems.STEEL_CHESTPLATE)
                .add(ModItems.STEEL_LEGGINGS)
                .add(ModItems.STEEL_BOOTS);

    }
}
