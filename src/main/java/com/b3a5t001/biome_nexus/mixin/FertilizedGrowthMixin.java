package com.b3a5t001.biome_nexus.mixin;

import com.b3a5t001.biome_nexus.blocks.fertilized.FertilizedBlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.block.AbstractBlock.class)
public abstract class FertilizedGrowthMixin {
    @Inject(method = "randomTick", at = @At("TAIL"))
    private void biomeNexus$applyFertilizerBoost(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        BlockState below = world.getBlockState(pos.down());
        if (!below.contains(FertilizedBlockUtil.FERT_STAGE)) return;
        int stage = below.get(FertilizedBlockUtil.FERT_STAGE);
        FertilizedBlockUtil.tryBoostGrowth(world, pos, stage, random);
    }
}
