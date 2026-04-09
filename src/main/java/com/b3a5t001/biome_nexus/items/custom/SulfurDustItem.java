package com.b3a5t001.biome_nexus.items.custom;

import com.b3a5t001.biome_nexus.blocks.ModBlocks;
import com.b3a5t001.biome_nexus.blocks.fertilized.FertilizedBlockUtil;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SulfurDustItem extends Item {
    public SulfurDustItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        var state = world.getBlockState(pos);

        // Nylium is explicitly excluded
        if (state.isOf(net.minecraft.block.Blocks.WARPED_NYLIUM) || state.isOf(net.minecraft.block.Blocks.CRIMSON_NYLIUM)) {
            return ActionResult.PASS;
        }

        // If already fertilized, just increment stage
        if (isFertilized(state)) {
            int stage = state.get(FertilizedBlockUtil.FERT_STAGE);
            if (stage >= 5) return ActionResult.PASS;
            BlockPos applyPos = pos;
            BlockState newState = state.with(FertilizedBlockUtil.FERT_STAGE, stage + 1);
            world.setBlockState(applyPos, newState, 3);
            FertilizedBlockUtil.refreshTimer(world, applyPos);
            playUseEffects(context);
            consume(context);
            return ActionResult.success(world.isClient);
        }

        BlockState target = mapToFertilized(state);
        if (target == null) return ActionResult.PASS;

        target = FertilizedBlockUtil.copyCommonProperties(state, target);
        world.setBlockState(pos, target, 3);
        FertilizedBlockUtil.refreshTimer(world, pos);
        playUseEffects(context);
        consume(context);
        return ActionResult.success(world.isClient);
    }

    private void consume(ItemUsageContext context) {
        if (!context.getPlayer().isCreative()) {
            context.getStack().decrement(1);
        }
    }

    private void playUseEffects(ItemUsageContext context) {
        context.getWorld().playSound(context.getPlayer(), context.getBlockPos(),
                SoundEvents.ITEM_BONE_MEAL_USE, SoundCategory.BLOCKS, 0.8f, 1.0f);
    }

    private boolean isFertilized(BlockState state) {
        return state.contains(FertilizedBlockUtil.FERT_STAGE);
    }

    private BlockState mapToFertilized(BlockState base) {
        if (base.isOf(net.minecraft.block.Blocks.FARMLAND)) return ModBlocks.FERTILIZED_FARMLAND.getDefaultState();
        if (base.isOf(net.minecraft.block.Blocks.GRASS_BLOCK)) return ModBlocks.FERTILIZED_GRASS_BLOCK.getDefaultState();
        if (base.isOf(net.minecraft.block.Blocks.DIRT)) return ModBlocks.FERTILIZED_DIRT.getDefaultState();
        if (base.isOf(net.minecraft.block.Blocks.COARSE_DIRT)) return ModBlocks.FERTILIZED_COARSE_DIRT.getDefaultState();
        if (base.isOf(net.minecraft.block.Blocks.PODZOL)) return ModBlocks.FERTILIZED_PODZOL.getDefaultState();
        if (base.isOf(net.minecraft.block.Blocks.MYCELIUM)) return ModBlocks.FERTILIZED_MYCELIUM.getDefaultState();
        if (base.isOf(net.minecraft.block.Blocks.ROOTED_DIRT)) return ModBlocks.FERTILIZED_ROOTED_DIRT.getDefaultState();
        if (base.isOf(net.minecraft.block.Blocks.MUD)) return ModBlocks.FERTILIZED_MUD.getDefaultState();
        if (base.isOf(net.minecraft.block.Blocks.SAND)) return ModBlocks.FERTILIZED_SAND.getDefaultState();
        if (base.isOf(net.minecraft.block.Blocks.RED_SAND)) return ModBlocks.FERTILIZED_RED_SAND.getDefaultState();
        if (base.isOf(net.minecraft.block.Blocks.SOUL_SAND)) return ModBlocks.FERTILIZED_SOUL_SAND.getDefaultState();
        if (base.isOf(net.minecraft.block.Blocks.CLAY)) return ModBlocks.FERTILIZED_CLAY.getDefaultState();
        return null;
    }
}
