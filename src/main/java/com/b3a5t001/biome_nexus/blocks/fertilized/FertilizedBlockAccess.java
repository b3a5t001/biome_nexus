package com.b3a5t001.biome_nexus.blocks.fertilized;

import net.minecraft.block.Block;

/**
 * Exposes the original base block for fertilized variants so block entities and mixins
 * can revert or drop the right block.
 */
public interface FertilizedBlockAccess {
    Block getBaseBlock();
}
