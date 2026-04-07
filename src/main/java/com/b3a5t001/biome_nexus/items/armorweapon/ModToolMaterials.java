package com.b3a5t001.biome_nexus.items.armorweapon;

import com.b3a5t001.biome_nexus.items.ModItems;
import com.b3a5t001.biome_nexus.util.ModTags;
import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {
    COPPER(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL, 191, 5.0F,
            1.5F, 17, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    STEEL(ModTags.Blocks.INCORRECT_FOR_STEEL_TOOL, 1645, 9.0f,
            3.0f, 16, () -> Ingredient.ofItems(ModItems.STEEL_INGOT)),
    AURORITE(ModTags.Blocks.INCORRECT_FOR_AURORITE_TOOL, 264, 6.0f,
            2.0f, 24, () -> Ingredient.ofItems(ModItems.AURORITE_ALLOY));


    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(final TagKey<Block> inverseTag, final int itemDurability, final float miningSpeed,
            final float attackDamage, final int enchantability, final Supplier<Ingredient> repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}