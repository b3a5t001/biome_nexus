package com.b3a5t001.biome_nexus.blocks.entity;

import com.b3a5t001.biome_nexus.blocks.fertilized.FertilizedBlockAccess;
import com.b3a5t001.biome_nexus.blocks.fertilized.FertilizedBlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class FertilizedBlockEntity extends BlockEntity {
    private long stageExpiresAt = 0L;
    private Identifier baseBlockId;

    public FertilizedBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FERTILIZED_BLOCK_ENTITY, pos, state);
        this.baseBlockId = getBaseIdFromState(state);
    }

    public static void tick(ServerWorld world, BlockPos pos, BlockState state, FertilizedBlockEntity be) {
        if (be.stageExpiresAt == 0L) {
            be.resetTimer(world.getTime());
        }

        // If the block below is gone (fell, trampled, etc.), this block entity will be removed naturally.
        if (!state.contains(FertilizedBlockUtil.FERT_STAGE)) {
            world.removeBlockEntity(pos);
            return;
        }

        if (world.getTime() < be.stageExpiresAt) return;

        int stage = state.get(FertilizedBlockUtil.FERT_STAGE);
        if (stage > 1) {
            be.stageExpiresAt = world.getTime() + FertilizedBlockUtil.getDecayTicks();
            world.setBlockState(pos, state.with(FertilizedBlockUtil.FERT_STAGE, stage - 1), Block.NOTIFY_ALL);
        } else {
            Block base = be.resolveBaseBlock();
            BlockState baseState = FertilizedBlockUtil.copyCommonProperties(state, base.getDefaultState());
            world.setBlockState(pos, baseState, Block.NOTIFY_ALL);
            world.removeBlockEntity(pos);
        }
    }

    public void resetTimer(long currentTime) {
        this.stageExpiresAt = currentTime + FertilizedBlockUtil.getDecayTicks();
        markDirty();
    }

    private Identifier getBaseIdFromState(BlockState state) {
        Block block = state.getBlock();
        if (block instanceof FertilizedBlockAccess access) {
            return Registries.BLOCK.getId(access.getBaseBlock());
        }
        return Registries.BLOCK.getId(block);
    }

    private Block resolveBaseBlock() {
        if (baseBlockId != null) {
            return Registries.BLOCK.getOrEmpty(baseBlockId).orElse(getCachedState().getBlock());
        }
        return getCachedState().getBlock();
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup lookup) {
        super.writeNbt(nbt, lookup);
        nbt.putLong("StageExpiresAt", stageExpiresAt);
        if (baseBlockId != null) {
            nbt.putString("BaseBlock", baseBlockId.toString());
        }
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup lookup) {
        super.readNbt(nbt, lookup);
        stageExpiresAt = nbt.getLong("StageExpiresAt");
        if (nbt.contains("BaseBlock")) {
            baseBlockId = Identifier.of(nbt.getString("BaseBlock"));
        }
    }
}
