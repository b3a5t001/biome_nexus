package com.b3a5t001.biome_nexus.items;

import com.b3a5t001.biome_nexus.BiomeNexus;
import com.b3a5t001.biome_nexus.blocks.ModBlocks;
import com.b3a5t001.biome_nexus.items.armorweapon.ModArmorMaterials;
import com.b3a5t001.biome_nexus.items.armorweapon.ModToolMaterials;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class ModItems {
    public static final Item SULFUR_DUST = registerItem("sulfur_dust",
            new Item(new Item.Settings()));
    public static final Item COPPER_NUGGET = registerItem("copper_nugget",
            new Item(new Item.Settings()));
    public static final Item SULFUR_TORCH = registerItem("sulfur_torch",
            new VerticallyAttachableBlockItem(ModBlocks.SULFUR_TORCH,
                    ModBlocks.SULFUR_WALL_TORCH,new Item.Settings(), Direction.DOWN));
    public static final Item COPPER_TORCH = registerItem("copper_torch",
            new VerticallyAttachableBlockItem(ModBlocks.COPPER_TORCH,
                    ModBlocks.COPPER_WALL_TORCH,new Item.Settings(), Direction.DOWN));
    public static final Item TIN_TORCH = registerItem("tin_torch",
            new VerticallyAttachableBlockItem(ModBlocks.TIN_TORCH,
                    ModBlocks.TIN_WALL_TORCH,new Item.Settings(), Direction.DOWN));

    public static final Item COPPER_SWORD = registerItem("copper_sword",
            new SwordItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.COPPER, 3, -2.4f))));
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            new PickaxeItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.COPPER, 1, -2.8f))));
    public static final Item COPPER_AXE = registerItem("copper_axe",
            new AxeItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.COPPER, 3, -3.2f))));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
            new ShovelItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.COPPER, 1.5f, -3.0f))));
    public static final Item COPPER_HOE = registerItem("copper_hoe",
            new HoeItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.COPPER, 0, -3f))));

    public static final Item COPPER_HELMET = registerItem("copper_helmet",
            new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(13))));
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate",
            new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(13))));
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings",
            new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(13))));
    public static final Item COPPER_BOOTS = registerItem("copper_boots",
            new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(13))));

    public static final Item JADE_CRYSTAL = registerItem("jade_crystal",
            new Item(new Item.Settings()));
    public static final Item JADE_BRICK = registerItem("jade_brick",
            new Item(new Item.Settings()));

    public static final Item RAW_TIN = registerItem("raw_tin",
            new Item(new Item.Settings()));
    public static final Item TIN_INGOT = registerItem("tin_ingot",
            new Item(new Item.Settings()));
    public static final Item TIN_NUGGET = registerItem("tin_nugget",
            new Item(new Item.Settings()));

    public static final Item STEEL_INGOT = registerItem("steel_ingot",
            new Item(new Item.Settings()));
    public static final Item STEEL_NUGGET = registerItem("steel_nugget",
            new Item(new Item.Settings()));

    public static final Item STEEL_SWORD = registerItem("steel_sword",
            new SwordItem(ModToolMaterials.STEEL, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STEEL, 3, -2.4f))));
    public static final Item STEEL_PICKAXE = registerItem("steel_pickaxe",
            new PickaxeItem(ModToolMaterials.STEEL, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.STEEL, 1, -2.8f))));
    public static final Item STEEL_AXE = registerItem("steel_axe",
            new AxeItem(ModToolMaterials.STEEL, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.STEEL, 3, -3.2f))));
    public static final Item STEEL_SHOVEL = registerItem("steel_shovel",
            new ShovelItem(ModToolMaterials.STEEL, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.STEEL, 1.5f, -3.0f))));
    public static final Item STEEL_HOE = registerItem("steel_hoe",
            new HoeItem(ModToolMaterials.STEEL, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.STEEL, 0, -3f))));

    public static final Item STEEL_HELMET = registerItem("steel_helmet",
            new ArmorItem(ModArmorMaterials.STEEL_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(34))));
    public static final Item STEEL_CHESTPLATE = registerItem("steel_chestplate",
            new ArmorItem(ModArmorMaterials.STEEL_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(34))));
    public static final Item STEEL_LEGGINGS = registerItem("steel_leggings",
            new ArmorItem(ModArmorMaterials.STEEL_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(34))));
    public static final Item STEEL_BOOTS = registerItem("steel_boots",
            new ArmorItem(ModArmorMaterials.STEEL_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(34))));

    public static final Item GRACE_SMITHING_TEMPLATE = registerItem("grace_armor_trim_smithing_template",
            SmithingTemplateItem.of(Identifier.of(BiomeNexus.MOD_ID, "grace"), FeatureFlags.VANILLA));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(BiomeNexus.MOD_ID, name), item);
    }

    public static void init(){}
}
