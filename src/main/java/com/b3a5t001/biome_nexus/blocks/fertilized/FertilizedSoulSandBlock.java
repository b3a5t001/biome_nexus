package com.b3a5t001.biome_nexus.blocks.fertilized;

import com.b3a5t001.biome_nexus.blocks.entity.FertilizedBlockEntity;
import com.b3a5t001.biome_nexus.blocks.entity.ModBlockEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoulSandBlock;
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

public class FertilizedSoulSandBlock extends SoulSandBlock implements BlockEntityProvider, FertilizedBlockAccess {
    private final Block baseBlock;
    protected static final IntProperty FERT_STAGE = FertilizedBlockUtil.FERT_STAGE;

    public FertilizedSoulSandBlock(Block baseBlock, Settings settings) {
        super(settings.ticksRandomly());
        this.baseBlock = baseBlock;
        this.setDefaultState(this.stateManager.getDefaultState().with(FERT_STAGE, 1));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
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
}
