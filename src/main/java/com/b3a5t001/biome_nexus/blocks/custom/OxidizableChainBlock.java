package com.b3a5t001.biome_nexus.blocks.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChainBlock;
import net.minecraft.block.Oxidizable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Optional;

public class OxidizableChainBlock extends ChainBlock implements Oxidizable {
    private static final Map<Block, Block> OXIDATION_LEVEL_INCREASES = new IdentityHashMap<>();
    private final Oxidizable.OxidationLevel oxidationLevel;

    public OxidizableChainBlock(Oxidizable.OxidationLevel oxidationLevel, Settings settings) {
        super(settings);
        this.oxidationLevel = oxidationLevel;
    }

    public static void registerOxidationPair(Block from, Block to) {
        OXIDATION_LEVEL_INCREASES.put(from, to);
    }

    @Override
    public Oxidizable.OxidationLevel getDegradationLevel() {
        return this.oxidationLevel;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.tickDegradation(state, world, pos, random);
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return OXIDATION_LEVEL_INCREASES.containsKey(state.getBlock());
    }

    @Override
    public Optional<BlockState> getDegradationResult(BlockState state) {
        Block next = OXIDATION_LEVEL_INCREASES.get(state.getBlock());
        if (next == null) {
            return Optional.empty();
        }
        return Optional.of(next.getStateWithProperties(state));
    }
}
