package com.b3a5t001.biome_nexus.blocks.entity;

import com.b3a5t001.biome_nexus.BiomeNexus;
import com.b3a5t001.biome_nexus.blocks.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<FertilizedBlockEntity> FERTILIZED_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE,
                    Identifier.of(BiomeNexus.MOD_ID, "fertilized_block"),
                    BlockEntityType.Builder.create(
                            FertilizedBlockEntity::new,
                            ModBlocks.FERTILIZED_FARMLAND,
                            ModBlocks.FERTILIZED_GRASS_BLOCK,
                            ModBlocks.FERTILIZED_DIRT,
                            ModBlocks.FERTILIZED_COARSE_DIRT,
                            ModBlocks.FERTILIZED_PODZOL,
                            ModBlocks.FERTILIZED_MYCELIUM,
                            ModBlocks.FERTILIZED_ROOTED_DIRT,
                            ModBlocks.FERTILIZED_MUD,
                            ModBlocks.FERTILIZED_CLAY,
                            ModBlocks.FERTILIZED_SAND,
                            ModBlocks.FERTILIZED_RED_SAND,
                            ModBlocks.FERTILIZED_SOUL_SAND
                    ).build(null));

    public static void init() {
        // Trigger static init
    }
}
