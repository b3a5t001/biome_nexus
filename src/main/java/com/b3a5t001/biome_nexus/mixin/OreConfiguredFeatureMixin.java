package com.b3a5t001.biome_nexus.mixin;

import com.b3a5t001.biome_nexus.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(net.minecraft.world.gen.feature.OreConfiguredFeatures.class)
public class OreConfiguredFeatureMixin {
    @ModifyArg(method = "bootstrap",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/structure/rule/TagMatchRuleTest;<init>(Lnet/minecraft/registry/tag/TagKey;)V"
            )
    )
    private static TagKey<Block> replaceNetherRuleTest(TagKey<Block> original){
        if (original == BlockTags.BASE_STONE_NETHER){
            return ModTags.Blocks.NETHER_ORE_REPLACEABLES;
        }
        return original;
    }
}
