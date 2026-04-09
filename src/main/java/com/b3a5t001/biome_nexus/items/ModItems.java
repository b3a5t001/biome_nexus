package com.b3a5t001.biome_nexus.items;

import com.b3a5t001.biome_nexus.BiomeNexus;
import com.b3a5t001.biome_nexus.blocks.ModBlocks;
import com.b3a5t001.biome_nexus.items.armorweapon.ModArmorMaterials;
import com.b3a5t001.biome_nexus.items.armorweapon.ModToolMaterials;
import com.b3a5t001.biome_nexus.items.custom.ModSmithingTemplateItem;
import com.b3a5t001.biome_nexus.items.custom.SulfurDustItem;
import com.b3a5t001.biome_nexus.sound.ModSoundEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class ModItems {
    public static final Item SULFUR_DUST = registerItem("sulfur_dust",
            new SulfurDustItem(new Item.Settings()));
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

    public static final Item AURORITE_CRYSTAL = registerItem("aurorite_crystal",
            new Item(new Item.Settings()));
    public static final Item AURORITE_ALLOY = registerItem("aurorite_alloy",
            new Item(new Item.Settings()));

    public static final Item AURORITE_SWORD = registerItem("aurorite_sword",
            new SwordItem(ModToolMaterials.AURORITE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.AURORITE, 3, -2.4f))));
    public static final Item AURORITE_PICKAXE = registerItem("aurorite_pickaxe",
            new PickaxeItem(ModToolMaterials.AURORITE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.AURORITE, 1, -2.8f))));
    public static final Item AURORITE_AXE = registerItem("aurorite_axe",
            new AxeItem(ModToolMaterials.AURORITE, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.AURORITE, 3, -3.2f))));
    public static final Item AURORITE_SHOVEL = registerItem("aurorite_shovel",
            new ShovelItem(ModToolMaterials.AURORITE, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.AURORITE, 1.5f, -3.0f))));
    public static final Item AURORITE_HOE = registerItem("aurorite_hoe",
            new HoeItem(ModToolMaterials.AURORITE, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.AURORITE, 0, -3f))));

    public static final Item AURORITE_HELMET = registerItem("aurorite_helmet",
            new ArmorItem(ModArmorMaterials.AURORITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(16))));
    public static final Item AURORITE_CHESTPLATE = registerItem("aurorite_chestplate",
            new ArmorItem(ModArmorMaterials.AURORITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(16))));
    public static final Item AURORITE_LEGGINGS = registerItem("aurorite_leggings",
            new ArmorItem(ModArmorMaterials.AURORITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(16))));
    public static final Item AURORITE_BOOTS = registerItem("aurorite_boots",
            new ArmorItem(ModArmorMaterials.AURORITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                        .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(16))));

    public static final Item BRONZE_INGOT = registerItem("bronze_ingot",
            new Item(new Item.Settings()));
    public static final Item BRONZE_NUGGET = registerItem("bronze_nugget",
            new Item(new Item.Settings()));

    public static final Item BRONZE_SWORD = registerItem("bronze_sword",
            new SwordItem(ModToolMaterials.BRONZE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.BRONZE, 3, -2.4f))));
    public static final Item BRONZE_PICKAXE = registerItem("bronze_pickaxe",
            new PickaxeItem(ModToolMaterials.BRONZE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.BRONZE, 1, -2.8f))));
    public static final Item BRONZE_AXE = registerItem("bronze_axe",
            new AxeItem(ModToolMaterials.BRONZE, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.BRONZE, 3, -3.2f))));
    public static final Item BRONZE_SHOVEL = registerItem("bronze_shovel",
            new ShovelItem(ModToolMaterials.BRONZE, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.BRONZE, 1.5f, -3.0f))));
    public static final Item BRONZE_HOE = registerItem("bronze_hoe",
            new HoeItem(ModToolMaterials.BRONZE, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.BRONZE, 0, -3f))));

    public static final Item BRONZE_HELMET = registerItem("bronze_helmet",
            new ArmorItem(ModArmorMaterials.BRONZE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(19))));
    public static final Item BRONZE_CHESTPLATE = registerItem("bronze_chestplate",
            new ArmorItem(ModArmorMaterials.BRONZE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(19))));
    public static final Item BRONZE_LEGGINGS = registerItem("bronze_leggings",
            new ArmorItem(ModArmorMaterials.BRONZE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(19))));
    public static final Item BRONZE_BOOTS = registerItem("bronze_boots",
            new ArmorItem(ModArmorMaterials.BRONZE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(19))));

    public static final Item RAW_COBALT = registerItem("raw_cobalt",
            new Item(new Item.Settings()));
    public static final Item COBALT_INGOT = registerItem("cobalt_ingot",
            new Item(new Item.Settings()));
    public static final Item COBALT_NUGGET = registerItem("cobalt_nugget",
            new Item(new Item.Settings()));

    public static final Item COBALT_SWORD = registerItem("cobalt_sword",
            new SwordItem(ModToolMaterials.COBALT, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.COBALT, 3, -2.4f))));
    public static final Item COBALT_PICKAXE = registerItem("cobalt_pickaxe",
            new PickaxeItem(ModToolMaterials.COBALT, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.COBALT, 1, -2.8f))));
    public static final Item COBALT_AXE = registerItem("cobalt_axe",
            new AxeItem(ModToolMaterials.COBALT, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.COBALT, 3, -3.2f))));
    public static final Item COBALT_SHOVEL = registerItem("cobalt_shovel",
            new ShovelItem(ModToolMaterials.COBALT, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.COBALT, 1.5f, -3.0f))));
    public static final Item COBALT_HOE = registerItem("cobalt_hoe",
            new HoeItem(ModToolMaterials.COBALT, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.COBALT, 0, -3f))));

    public static final Item COBALT_HELMET = registerItem("cobalt_helmet",
            new ArmorItem(ModArmorMaterials.COBALT_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(33))));
    public static final Item COBALT_CHESTPLATE = registerItem("cobalt_chestplate",
            new ArmorItem(ModArmorMaterials.COBALT_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(33))));
    public static final Item COBALT_LEGGINGS = registerItem("cobalt_leggings",
            new ArmorItem(ModArmorMaterials.COBALT_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(33))));
    public static final Item COBALT_BOOTS = registerItem("cobalt_boots",
            new ArmorItem(ModArmorMaterials.COBALT_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(33))));

    public static final Item RAW_CRIMSONITE = registerItem("raw_crimsonite",
            new Item(new Item.Settings()));
    public static final Item CRIMSONITE_BILLET = registerItem("crimsonite_billet",
            new Item(new Item.Settings()));
    public static final Item CRIMSONITE_INGOT = registerItem("crimsonite_ingot",
            new Item(new Item.Settings()));

    public static final Item CRIMSONITE_SWORD = registerItem("crimsonite_sword",
            new SwordItem(ModToolMaterials.CRIMSONITE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.CRIMSONITE, 3, -2.4f))));
    public static final Item CRIMSONITE_PICKAXE = registerItem("crimsonite_pickaxe",
            new PickaxeItem(ModToolMaterials.CRIMSONITE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.CRIMSONITE, 1, -2.8f))));
    public static final Item CRIMSONITE_AXE = registerItem("crimsonite_axe",
            new AxeItem(ModToolMaterials.CRIMSONITE, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.CRIMSONITE, 3, -3.2f))));
    public static final Item CRIMSONITE_SHOVEL = registerItem("crimsonite_shovel",
            new ShovelItem(ModToolMaterials.CRIMSONITE, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.CRIMSONITE, 1.5f, -3.0f))));
    public static final Item CRIMSONITE_HOE = registerItem("crimsonite_hoe",
            new HoeItem(ModToolMaterials.CRIMSONITE, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.CRIMSONITE, 0, -3f))));

    public static final Item CRIMSONITE_HELMET = registerItem("crimsonite_helmet",
            new ArmorItem(ModArmorMaterials.CRIMSONITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(37))));
    public static final Item CRIMSONITE_CHESTPLATE = registerItem("crimsonite_chestplate",
            new ArmorItem(ModArmorMaterials.CRIMSONITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37))));
    public static final Item CRIMSONITE_LEGGINGS = registerItem("crimsonite_leggings",
            new ArmorItem(ModArmorMaterials.CRIMSONITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37))));
    public static final Item CRIMSONITE_BOOTS = registerItem("crimsonite_boots",
            new ArmorItem(ModArmorMaterials.CRIMSONITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37))));

    public static final Item CRIMSONITE_UPGRADE_SMITHING_TEMPLATE = registerItem("crimsonite_upgrade_smithing_template",
            ModSmithingTemplateItem.createCrimsoniteUpgrade());
    public static final Item GRACE_SMITHING_TEMPLATE = registerItem("grace_armor_trim_smithing_template",
            SmithingTemplateItem.of(Identifier.of(BiomeNexus.MOD_ID, "grace"), FeatureFlags.VANILLA));
    public static final Item VINE_SMITHING_TEMPLATE = registerItem("vine_armor_trim_smithing_template",
            SmithingTemplateItem.of(Identifier.of(BiomeNexus.MOD_ID, "vine"), FeatureFlags.VANILLA));
    public static final Item GEM_SMITHING_TEMPLATE = registerItem("gem_armor_trim_smithing_template",
            SmithingTemplateItem.of(Identifier.of(BiomeNexus.MOD_ID, "gem"), FeatureFlags.VANILLA));

    public static final Item TEARS_MUSIC_DISC = registerItem("music_disc_tears",
            new Item(new Item.Settings().jukeboxPlayable(ModSoundEvents.TEARS_KEY).maxCount(1)));
    public static final Item LAVA_CHICKEN_MUSIC_DISC = registerItem("music_disc_lava_chicken",
            new Item(new Item.Settings().jukeboxPlayable(ModSoundEvents.LAVA_CHICKEN_KEY).maxCount(1)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(BiomeNexus.MOD_ID, name), item);
    }

    public static void init(){}
}
