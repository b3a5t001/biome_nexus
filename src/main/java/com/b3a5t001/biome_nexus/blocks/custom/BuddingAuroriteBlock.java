package com.b3a5t001.biome_nexus.blocks.custom;

import com.b3a5t001.biome_nexus.blocks.ModBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

public class BuddingAuroriteBlock extends AmethystBlock {
    public static final MapCodec<BuddingAuroriteBlock> CODEC = createCodec(BuddingAuroriteBlock::new);
    public static final int GROW_CHANCE = 5;
    private static final Direction[] DIRECTIONS = Direction.values();

    @Override
    public MapCodec<BuddingAuroriteBlock> getCodec() {
        return CODEC;
    }

    public BuddingAuroriteBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
            BlockPos blockPos = pos.offset(direction);
            BlockState blockState = world.getBlockState(blockPos);
            Block block = null;
            if (canGrowIn(blockState)) {
                block = ModBlocks.SMALL_AURORITE_BUD;
            } else if (blockState.isOf(ModBlocks.SMALL_AURORITE_BUD) && blockState.get(AmethystClusterBlock.FACING) == direction) {
                block = ModBlocks.MEDIUM_AURORITE_BUD;
            } else if (blockState.isOf(ModBlocks.MEDIUM_AURORITE_BUD) && blockState.get(AmethystClusterBlock.FACING) == direction) {
                block = ModBlocks.LARGE_AURORITE_BUD;
            } else if (blockState.isOf(ModBlocks.LARGE_AURORITE_BUD) && blockState.get(AmethystClusterBlock.FACING) == direction) {
                block = ModBlocks.AURORITE_CLUSTER;
            }

            if (block != null) {
                BlockState blockState2 = block.getDefaultState()
                        .with(AmethystClusterBlock.FACING, direction)
                        .with(AmethystClusterBlock.WATERLOGGED, blockState.getFluidState().getFluid() == Fluids.WATER);
                world.setBlockState(blockPos, blockState2);
            }
        }
    }

    public static boolean canGrowIn(BlockState state) {
        return state.isAir() || state.isOf(Blocks.WATER) && state.getFluidState().getLevel() == 8;
    }
}

