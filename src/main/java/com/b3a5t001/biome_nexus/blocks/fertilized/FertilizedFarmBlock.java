package com.b3a5t001.biome_nexus.blocks.fertilized;

import com.b3a5t001.biome_nexus.blocks.entity.FertilizedBlockEntity;
import com.b3a5t001.biome_nexus.blocks.entity.ModBlockEntities;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FertilizedFarmBlock extends FarmlandBlock implements BlockEntityProvider, FertilizedBlockAccess {
    private final Block baseBlock;
    protected static final IntProperty FERT_STAGE = FertilizedBlockUtil.FERT_STAGE;

    public FertilizedFarmBlock(Block baseBlock, Settings settings) {
        super(settings.ticksRandomly());
        this.baseBlock = baseBlock;
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(MOISTURE, 0)
                .with(FERT_STAGE, 1));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FERT_STAGE);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextFloat() < 0.15f + state.get(FERT_STAGE) * 0.05f) {
            double x = pos.getX() + 0.5 + (random.nextDouble() - 0.5);
            double y = pos.getY() + 1.0;
            double z = pos.getZ() + 0.5 + (random.nextDouble() - 0.5);
            world.addParticle(net.minecraft.particle.ParticleTypes.HAPPY_VILLAGER, x, y, z, 0, 0.05, 0);
        }
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new FertilizedBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        if (world.isClient) return null;
        return type == ModBlockEntities.FERTILIZED_BLOCK_ENTITY ? (w, p, s, be) -> FertilizedBlockEntity.tick((ServerWorld) w, p, s, (FertilizedBlockEntity) be) : null;
    }

    @Override
    public Block getBaseBlock() {
        return baseBlock;
    }

    @Override
    public MapCodec<FarmlandBlock> getCodec() {
        @SuppressWarnings("unchecked")
        MapCodec<FarmlandBlock> codec = (MapCodec<FarmlandBlock>)(MapCodec<?>) CODEC;
        return codec;
    }
}
