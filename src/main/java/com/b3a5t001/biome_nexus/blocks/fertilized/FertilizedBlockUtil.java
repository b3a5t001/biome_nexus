package com.b3a5t001.biome_nexus.blocks.fertilized;

import com.b3a5t001.biome_nexus.blocks.entity.FertilizedBlockEntity;
import net.minecraft.block.BambooBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CactusBlock;
import net.minecraft.block.ChorusFlowerBlock;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.FungusBlock;
import net.minecraft.block.MushroomBlock;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Property;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

/**
 * Shared helpers for fertilized block variants.
 */
public final class FertilizedBlockUtil {
    public static final IntProperty FERT_STAGE = IntProperty.of("fert_stage", 1, 5);
    private static final int TICKS_PER_STAGE = 12000; // 10 in-game minutes
    private static final ThreadLocal<Boolean> BOOSTING = ThreadLocal.withInitial(() -> false);

    private FertilizedBlockUtil() {}

    public static int getDecayTicks() {
        return TICKS_PER_STAGE;
    }

    public static void refreshTimer(World world, BlockPos pos) {
        if (world.isClient) return;
        var be = world.getBlockEntity(pos);
        if (be instanceof FertilizedBlockEntity fertilized) {
            fertilized.resetTimer(world.getTime());
        }
    }

    /**
     * Apply an extra growth attempt to the given plant position when fertilized soil is beneath.
     * This is invoked from plant random ticks (via mixin) and from fertilized block random ticks
     * as a fallback.
     */
    public static void tryBoostGrowth(World world, BlockPos plantPos, int stage, Random random) {
        if (world.isClient) return;
        BlockState plant = world.getBlockState(plantPos);
        if (!isEligiblePlant(plant.getBlock())) return;
        if (BOOSTING.get()) return;
        if (!roll(stage, random)) return;

        BOOSTING.set(true);
        try {
            plant.randomTick((ServerWorld) world, plantPos, random);
        } finally {
            BOOSTING.set(false);
        }
    }

    public static boolean isEligiblePlant(Block block) {
        if (block instanceof MushroomBlock || block instanceof FungusBlock) return false;
        return block instanceof Fertilizable ||
                block instanceof SaplingBlock ||
                block instanceof CactusBlock ||
                block instanceof SugarCaneBlock ||
                block instanceof BambooBlock ||
                block instanceof NetherWartBlock ||
                block instanceof ChorusFlowerBlock;
    }

    public static boolean roll(int stage, Random random) {
        float chance = switch (stage) {
            case 1 -> 0.35f;
            case 2 -> 0.55f;
            case 3 -> 0.70f;
            case 4 -> 0.85f;
            default -> 0.95f;
        };
        return random.nextFloat() <= chance;
    }

    /**
     * Copy shared properties between states (e.g., moisture on farmland) when swapping
     * between fertilized and base variants.
     */
    public static BlockState copyCommonProperties(BlockState from, BlockState to) {
        for (Property<?> property : from.getProperties()) {
            if (to.contains(property)) {
                to = copyProperty(from, to, property);
            }
        }
        return to;
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> BlockState copyProperty(BlockState from, BlockState to, Property<T> property) {
        return to.with(property, from.get(property));
    }
}
