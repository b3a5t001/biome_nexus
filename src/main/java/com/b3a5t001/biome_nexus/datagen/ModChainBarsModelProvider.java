package com.b3a5t001.biome_nexus.datagen;

import com.b3a5t001.biome_nexus.blocks.ModBlocks;
import com.b3a5t001.biome_nexus.datagen.helpers.ModBlockstateModelHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;

import java.util.concurrent.CompletableFuture;

public class ModChainBarsModelProvider implements DataProvider {
    private final FabricDataOutput output;

    public ModChainBarsModelProvider(FabricDataOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        DataOutput.PathResolver blockstates = output.getResolver(DataOutput.OutputType.RESOURCE_PACK, "blockstates");
        DataOutput.PathResolver modelsBlock = output.getResolver(DataOutput.OutputType.RESOURCE_PACK, "models/block");
        DataOutput.PathResolver modelsItem = output.getResolver(DataOutput.OutputType.RESOURCE_PACK, "models/item");

        ModBlockstateModelHelper.Registrar registrar = new ModBlockstateModelHelper.Registrar(
                writer,
                blockstates,
                modelsBlock,
                modelsItem
        );

        ModBlockstateModelHelper.registerChain(registrar, ModBlocks.GOLD_CHAIN);
        ModBlockstateModelHelper.registerBars(registrar, ModBlocks.GOLD_BARS);
        ModBlockstateModelHelper.registerLantern(registrar, ModBlocks.GOLD_LANTERN);

        ModBlockstateModelHelper.registerChain(registrar, ModBlocks.COPPER_CHAIN, ModBlocks.WAXED_COPPER_CHAIN);
        ModBlockstateModelHelper.registerChain(registrar, ModBlocks.EXPOSED_COPPER_CHAIN, ModBlocks.WAXED_EXPOSED_COPPER_CHAIN);
        ModBlockstateModelHelper.registerChain(registrar, ModBlocks.WEATHERED_COPPER_CHAIN, ModBlocks.WAXED_WEATHERED_COPPER_CHAIN);
        ModBlockstateModelHelper.registerChain(registrar, ModBlocks.OXIDISED_COPPER_CHAIN, ModBlocks.WAXED_OXIDISED_COPPER_CHAIN);

        ModBlockstateModelHelper.registerBars(registrar, ModBlocks.COPPER_BARS, ModBlocks.WAXED_COPPER_BARS);
        ModBlockstateModelHelper.registerBars(registrar, ModBlocks.EXPOSED_COPPER_BARS, ModBlocks.WAXED_EXPOSED_COPPER_BARS);
        ModBlockstateModelHelper.registerBars(registrar, ModBlocks.WEATHERED_COPPER_BARS, ModBlocks.WAXED_WEATHERED_COPPER_BARS);
        ModBlockstateModelHelper.registerBars(registrar, ModBlocks.OXIDISED_COPPER_BARS, ModBlocks.WAXED_OXIDISED_COPPER_BARS);

        ModBlockstateModelHelper.registerLantern(registrar, ModBlocks.COPPER_LANTERN, ModBlocks.WAXED_COPPER_LANTERN);
        ModBlockstateModelHelper.registerLantern(registrar, ModBlocks.EXPOSED_COPPER_LANTERN, ModBlocks.WAXED_EXPOSED_COPPER_LANTERN);
        ModBlockstateModelHelper.registerLantern(registrar, ModBlocks.WEATHERED_COPPER_LANTERN, ModBlocks.WAXED_WEATHERED_COPPER_LANTERN);
        ModBlockstateModelHelper.registerLantern(registrar, ModBlocks.OXIDISED_COPPER_LANTERN, ModBlocks.WAXED_OXIDISED_COPPER_LANTERN);

        return registrar.done();
    }

    @Override
    public String getName() {
        return "Biome Nexus Chain/Bars Models";
    }
}
