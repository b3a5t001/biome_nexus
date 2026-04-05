package com.b3a5t001.biome_nexus.datagen.helpers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.block.Block;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public final class ModBlockstateModelHelper {
    private ModBlockstateModelHelper() {
    }

    public interface ModelRef {
        Identifier itemModelId();
    }

    public record ChainModelRef(Identifier modelId, Identifier itemModelId) implements ModelRef {
    }

    public record BarsModelRef(
            Identifier postEndsModelId,
            Identifier postModelId,
            Identifier capModelId,
            Identifier capAltModelId,
            Identifier sideModelId,
            Identifier sideAltModelId,
            Identifier itemModelId
    ) implements ModelRef {
    }

    public record LanternModelRef(
            Identifier lanternModelId,
            Identifier hangingLanternModelId,
            Identifier itemModelId
    ) implements ModelRef {
    }

    public static final class Registrar {
        private final DataWriter writer;
        private final DataOutput.PathResolver blockstates;
        private final DataOutput.PathResolver modelsBlock;
        private final DataOutput.PathResolver modelsItem;
        private final List<CompletableFuture<?>> futures = new ArrayList<>();

        public Registrar(DataWriter writer,
                         DataOutput.PathResolver blockstates,
                         DataOutput.PathResolver modelsBlock,
                         DataOutput.PathResolver modelsItem) {
            this.writer = writer;
            this.blockstates = blockstates;
            this.modelsBlock = modelsBlock;
            this.modelsItem = modelsItem;
        }

        public void writeBlockstate(Identifier id, JsonObject json) {
            Path path = blockstates.resolveJson(id);
            futures.add(DataProvider.writeToPath(writer, json, path));
        }

        public void writeBlockModel(Identifier id, JsonObject json) {
            Path path = modelsBlock.resolveJson(id);
            futures.add(DataProvider.writeToPath(writer, json, path));
        }

        public void writeItemModel(Identifier id, JsonObject json) {
            Path path = modelsItem.resolveJson(id);
            futures.add(DataProvider.writeToPath(writer, json, path));
        }

        public CompletableFuture<?> done() {
            return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        }
    }

    public static ChainModelRef registerChain(Registrar registrar, Block block) {
        Identifier blockId = Registries.BLOCK.getId(block);
        Identifier blockModelId = Identifier.of(blockId.getNamespace(), "block/" + blockId.getPath());
        Identifier itemModelId = Identifier.of(blockId.getNamespace(), "item/" + blockId.getPath());
        Identifier blockTextureId = Identifier.of(blockId.getNamespace(), "block/" + blockId.getPath());
        Identifier itemTextureId = Identifier.of(blockId.getNamespace(), "item/" + blockId.getPath());

        registrar.writeBlockstate(blockId, chainBlockstate(blockModelId));
        registrar.writeBlockModel(blockId, chainBlockModel(blockTextureId));
        registrar.writeItemModel(blockId, itemModel(itemTextureId));

        return new ChainModelRef(blockModelId, itemModelId);
    }

    public static void registerChain(Registrar registrar, Block parent, Block child) {
        registerParentChild(registrar, registerChain(registrar, parent), child);
    }

    public static BarsModelRef registerBars(Registrar registrar, Block block) {
        Identifier blockId = Registries.BLOCK.getId(block);
        Identifier itemModelId = Identifier.of(blockId.getNamespace(), "item/" + blockId.getPath());
        Identifier blockTextureId = Identifier.of(blockId.getNamespace(), "block/" + blockId.getPath());

        Identifier postEndsModelId = Identifier.of(blockId.getNamespace(), "block/" + blockId.getPath() + "_post_ends");
        Identifier postModelId = Identifier.of(blockId.getNamespace(), "block/" + blockId.getPath() + "_post");
        Identifier capModelId = Identifier.of(blockId.getNamespace(), "block/" + blockId.getPath() + "_cap");
        Identifier capAltModelId = Identifier.of(blockId.getNamespace(), "block/" + blockId.getPath() + "_cap_alt");
        Identifier sideModelId = Identifier.of(blockId.getNamespace(), "block/" + blockId.getPath() + "_side");
        Identifier sideAltModelId = Identifier.of(blockId.getNamespace(), "block/" + blockId.getPath() + "_side_alt");

        registrar.writeBlockstate(blockId, barsBlockstate(
                postEndsModelId,
                postModelId,
                capModelId,
                capAltModelId,
                sideModelId,
                sideAltModelId
        ));
        registrar.writeBlockModel(withPathSuffix(blockId, "_post"), barsPostModel(blockTextureId));
        registrar.writeBlockModel(withPathSuffix(blockId, "_post_ends"), barsPostEndsModel(blockTextureId));
        registrar.writeBlockModel(withPathSuffix(blockId, "_cap"), barsCapModel(blockTextureId));
        registrar.writeBlockModel(withPathSuffix(blockId, "_cap_alt"), barsCapAltModel(blockTextureId));
        registrar.writeBlockModel(withPathSuffix(blockId, "_side"), barsSideModel(blockTextureId));
        registrar.writeBlockModel(withPathSuffix(blockId, "_side_alt"), barsSideAltModel(blockTextureId));

        Identifier itemTextureId = Identifier.of(blockId.getNamespace(), "block/" + blockId.getPath());
        registrar.writeItemModel(blockId, itemModel(itemTextureId));

        return new BarsModelRef(
                postEndsModelId,
                postModelId,
                capModelId,
                capAltModelId,
                sideModelId,
                sideAltModelId,
                itemModelId
        );
    }

    public static void registerBars(Registrar registrar, Block parent, Block child) {
        registerParentChild(registrar, registerBars(registrar, parent), child);
    }

    public static LanternModelRef registerLantern(Registrar registrar, Block block) {
        Identifier blockId = Registries.BLOCK.getId(block);
        Identifier itemModelId = Identifier.of(blockId.getNamespace(), "item/" + blockId.getPath());
        Identifier blockTextureId = Identifier.of(blockId.getNamespace(), "block/" + blockId.getPath());
        Identifier itemTextureId = Identifier.of(blockId.getNamespace(), "item/" + blockId.getPath());

        Identifier lanternModelId = Identifier.of(blockId.getNamespace(), "block/" + blockId.getPath());
        Identifier hangingLanternModelId = Identifier.of(blockId.getNamespace(), "block/" + blockId.getPath() + "_hanging");

        registrar.writeBlockstate(blockId, lanternBlockstate(lanternModelId, hangingLanternModelId));
        registrar.writeBlockModel(blockId, lanternBlockModel(blockTextureId));
        registrar.writeBlockModel(withPathSuffix(blockId, "_hanging"), lanternHangingBlockModel(blockTextureId));
        registrar.writeItemModel(blockId, itemModel(itemTextureId));

        return new LanternModelRef(lanternModelId, hangingLanternModelId, itemModelId);
    }

    public static void registerLantern(Registrar registrar, Block parent, Block child) {
        registerParentChild(registrar, registerLantern(registrar, parent), child);
    }

    public static void registerParentChild(Registrar registrar, ModelRef parentRef, Block child) {
        Identifier childId = Registries.BLOCK.getId(child);

        if (parentRef instanceof ChainModelRef chain) {
            registrar.writeBlockstate(childId, chainBlockstate(chain.modelId()));
        } else if (parentRef instanceof BarsModelRef bars) {
            registrar.writeBlockstate(childId, barsBlockstate(
                    bars.postEndsModelId(),
                    bars.postModelId(),
                    bars.capModelId(),
                    bars.capAltModelId(),
                    bars.sideModelId(),
                    bars.sideAltModelId()
            ));
        } else if (parentRef instanceof LanternModelRef lantern) {
            registrar.writeBlockstate(childId, lanternBlockstate(
                    lantern.lanternModelId(),
                    lantern.hangingLanternModelId()
            ));
        } else {
            throw new IllegalArgumentException("Unsupported model reference: " + parentRef.getClass().getName());
        }

        registrar.writeItemModel(childId, itemParentModel(parentRef.itemModelId()));
    }

    private static Identifier withPathSuffix(Identifier id, String suffix) {
        return Identifier.of(id.getNamespace(), id.getPath() + suffix);
    }

    private static JsonObject chainBlockstate(Identifier modelId) {
        String json = """
                {
                  "variants": {
                    "axis=x": { "model": "%s", "x": 90, "y": 90 },
                    "axis=y": { "model": "%s" },
                    "axis=z": { "model": "%s", "x": 90 }
                  }
                }
                """.formatted(modelId, modelId, modelId);
        return JsonParser.parseString(json).getAsJsonObject();
    }

    private static JsonObject barsBlockstate(
            Identifier postEndsModelId,
            Identifier postModelId,
            Identifier capModelId,
            Identifier capAltModelId,
            Identifier sideModelId,
            Identifier sideAltModelId
    ) {
        String json = """
                {
                  "multipart": [
                    { "apply": { "model": "%s" } },
                    {
                      "apply": { "model": "%s" },
                      "when": { "east": "false", "north": "false", "south": "false", "west": "false" }
                    },
                    {
                      "apply": { "model": "%s" },
                      "when": { "east": "false", "north": "true", "south": "false", "west": "false" }
                    },
                    {
                      "apply": { "model": "%s", "y": 90 },
                      "when": { "east": "true", "north": "false", "south": "false", "west": "false" }
                    },
                    {
                      "apply": { "model": "%s" },
                      "when": { "east": "false", "north": "false", "south": "true", "west": "false" }
                    },
                    {
                      "apply": { "model": "%s", "y": 90 },
                      "when": { "east": "false", "north": "false", "south": "false", "west": "true" }
                    },
                    {
                      "apply": { "model": "%s" },
                      "when": { "north": "true" }
                    },
                    {
                      "apply": { "model": "%s", "y": 90 },
                      "when": { "east": "true" }
                    },
                    {
                      "apply": { "model": "%s" },
                      "when": { "south": "true" }
                    },
                    {
                      "apply": { "model": "%s", "y": 90 },
                      "when": { "west": "true" }
                    }
                  ]
                }
                """.formatted(
                postEndsModelId,
                postModelId,
                capModelId,
                capModelId,
                capAltModelId,
                capAltModelId,
                sideModelId,
                sideModelId,
                sideAltModelId,
                sideAltModelId
        );
        return JsonParser.parseString(json).getAsJsonObject();
    }

    private static JsonObject chainBlockModel(Identifier textureId) {
        String json = """
                {
                  "parent": "minecraft:block/block",
                  "textures": {
                    "particle": "%s",
                    "all": "%s"
                  },
                  "elements": [
                    {
                      "from": [ 6.5, 0, 8 ],
                      "to": [ 9.5, 16, 8 ],
                      "rotation": { "origin": [ 8, 8, 8 ], "axis": "y", "angle": 45 },
                      "shade": false,
                      "faces": {
                        "north": { "uv": [ 3, 0, 0, 16 ], "texture": "#all" },
                        "south": { "uv": [ 0, 0, 3, 16 ], "texture": "#all" }
                      }
                    },
                    {
                      "from": [ 8, 0, 6.5 ],
                      "to": [ 8, 16, 9.5 ],
                      "rotation": { "origin": [ 8, 8, 8 ], "axis": "y", "angle": 45 },
                      "shade": false,
                      "faces": {
                        "west": { "uv": [ 6, 0, 3, 16 ], "texture": "#all" },
                        "east": { "uv": [ 3, 0, 6, 16 ], "texture": "#all" }
                      }
                    }
                  ]
                }
                """.formatted(textureId, textureId);
        return JsonParser.parseString(json).getAsJsonObject();
    }

    private static JsonObject barsPostModel(Identifier textureId) {
        String json = """
                {
                  "ambientocclusion": false,
                  "textures": {
                    "particle": "%s",
                    "bars": "%s"
                  },
                  "elements": [
                    { "from": [ 8, 0, 7 ], "to": [ 8, 16, 9 ],
                      "faces": {
                        "west": { "uv": [ 7, 0, 9, 16 ], "texture": "#bars" },
                        "east": { "uv": [ 9, 0, 7, 16 ], "texture": "#bars" }
                      }
                    },
                    { "from": [ 7, 0, 8 ], "to": [ 9, 16, 8 ],
                      "faces": {
                        "north": { "uv": [ 7, 0, 9, 16 ], "texture": "#bars" },
                        "south": { "uv": [ 9, 0, 7, 16 ], "texture": "#bars" }
                      }
                    }
                  ]
                }
                """.formatted(textureId, textureId);
        return JsonParser.parseString(json).getAsJsonObject();
    }

    private static JsonObject barsPostEndsModel(Identifier textureId) {
        String json = """
                {
                  "ambientocclusion": false,
                  "textures": {
                    "particle": "%s",
                    "edge": "%s"
                  },
                  "elements": [
                    { "from": [ 7, 0.001, 7 ], "to": [ 9, 0.001, 9 ],
                      "faces": {
                        "down": { "uv": [ 7, 7, 9, 9 ], "texture": "#edge" },
                        "up": { "uv": [ 7, 7, 9, 9 ], "texture": "#edge" }
                      }
                    },
                    { "from": [ 7, 15.999, 7 ], "to": [ 9, 15.999, 9 ],
                      "faces": {
                        "down": { "uv": [ 7, 7, 9, 9 ], "texture": "#edge" },
                        "up": { "uv": [ 7, 7, 9, 9 ], "texture": "#edge" }
                      }
                    }
                  ]
                }
                """.formatted(textureId, textureId);
        return JsonParser.parseString(json).getAsJsonObject();
    }

    private static JsonObject barsCapModel(Identifier textureId) {
        String json = """
                {
                  "ambientocclusion": false,
                  "textures": {
                    "particle": "%s",
                    "bars": "%s",
                    "edge": "%s"
                  },
                  "elements": [
                    { "from": [ 8, 0, 8 ], "to": [ 8, 16, 9 ],
                      "faces": {
                        "west": { "uv": [ 8, 0, 7, 16 ], "texture": "#bars" },
                        "east": { "uv": [ 7, 0, 8, 16 ], "texture": "#bars" }
                      }
                    },
                    { "from": [ 7, 0, 9 ], "to": [ 9, 16, 9 ],
                      "faces": {
                        "north": { "uv": [ 9, 0, 7, 16 ], "texture": "#bars" },
                        "south": { "uv": [ 7, 0, 9, 16 ], "texture": "#bars" }
                      }
                    }
                  ]
                }
                """.formatted(textureId, textureId, textureId);
        return JsonParser.parseString(json).getAsJsonObject();
    }

    private static JsonObject barsCapAltModel(Identifier textureId) {
        String json = """
                {
                  "ambientocclusion": false,
                  "textures": {
                    "particle": "%s",
                    "bars": "%s",
                    "edge": "%s"
                  },
                  "elements": [
                    { "from": [ 8, 0, 7 ], "to": [ 8, 16, 8 ],
                      "faces": {
                        "west": { "uv": [ 8, 0, 9, 16 ], "texture": "#bars" },
                        "east": { "uv": [ 9, 0, 8, 16 ], "texture": "#bars" }
                      }
                    },
                    { "from": [ 7, 0, 7 ], "to": [ 9, 16, 7 ],
                      "faces": {
                        "north": { "uv": [ 7, 0, 9, 16 ], "texture": "#bars" },
                        "south": { "uv": [ 9, 0, 7, 16 ], "texture": "#bars" }
                      }
                    }
                  ]
                }
                """.formatted(textureId, textureId, textureId);
        return JsonParser.parseString(json).getAsJsonObject();
    }

    private static JsonObject barsSideModel(Identifier textureId) {
        String json = """
                {
                  "ambientocclusion": false,
                  "textures": {
                    "particle": "%s",
                    "bars": "%s",
                    "edge": "%s"
                  },
                  "elements": [
                    { "from": [ 8, 0, 0 ], "to": [ 8, 16, 8 ],
                      "faces": {
                        "west": { "uv": [ 16, 0, 8, 16 ], "texture": "#bars" },
                        "east": { "uv": [ 8, 0, 16, 16 ], "texture": "#bars" }
                      }
                    },
                    { "from": [ 7, 0, 0 ], "to": [ 9, 16, 7 ],
                      "faces": {
                        "north": { "uv": [ 7, 0, 9, 16 ], "texture": "#edge", "cullface": "north" }
                      }
                    },
                    { "from": [ 7, 0.001, 0 ], "to": [ 9, 0.001, 7 ],
                      "faces": {
                        "down": { "uv": [ 9, 0, 7, 7 ], "texture": "#edge" },
                        "up": { "uv": [ 7, 0, 9, 7 ], "texture": "#edge" }
                      }
                    },
                    { "from": [ 7, 15.999, 0 ], "to": [ 9, 15.999, 7 ],
                      "faces": {
                        "down": { "uv": [ 9, 0, 7, 7 ], "texture": "#edge" },
                        "up": { "uv": [ 7, 0, 9, 7 ], "texture": "#edge" }
                      }
                    }
                  ]
                }
                """.formatted(textureId, textureId, textureId);
        return JsonParser.parseString(json).getAsJsonObject();
    }

    private static JsonObject barsSideAltModel(Identifier textureId) {
        String json = """
                {
                  "ambientocclusion": false,
                  "textures": {
                    "particle": "%s",
                    "bars": "%s",
                    "edge": "%s"
                  },
                  "elements": [
                    { "from": [ 8, 0, 8 ], "to": [ 8, 16, 16 ],
                      "faces": {
                        "west": { "uv": [ 8, 0, 0, 16 ], "texture": "#bars" },
                        "east": { "uv": [ 0, 0, 8, 16 ], "texture": "#bars" }
                      }
                    },
                    { "from": [ 7, 0, 9 ], "to": [ 9, 16, 16 ],
                      "faces": {
                        "south": { "uv": [ 7, 0, 9, 16 ], "texture": "#edge", "cullface": "south" },
                        "down": { "uv": [ 9, 9, 7, 16 ], "texture": "#edge" },
                        "up": { "uv": [ 7, 9, 9, 16 ], "texture": "#edge" }
                      }
                    },
                    { "from": [ 7, 0.001, 9 ], "to": [ 9, 0.001, 16 ],
                      "faces": {
                        "down": { "uv": [ 9, 9, 7, 16 ], "texture": "#edge" },
                        "up": { "uv": [ 7, 9, 9, 16 ], "texture": "#edge" }
                      }
                    },
                    { "from": [ 7, 15.999, 9 ], "to": [ 9, 15.999, 16 ],
                      "faces": {
                        "down": { "uv": [ 9, 9, 7, 16 ], "texture": "#edge" },
                        "up": { "uv": [ 7, 9, 9, 16 ], "texture": "#edge" }
                      }
                    }
                  ]
                }
                """.formatted(textureId, textureId, textureId);
        return JsonParser.parseString(json).getAsJsonObject();
    }

    private static JsonObject lanternBlockstate(Identifier lanternModelId, Identifier hangingLanternModelId) {
        String json = """
                {
                  "variants": {
                    "hanging=false": { "model": "%s" },
                    "hanging=true": { "model": "%s" }
                  }
                }
                """.formatted(lanternModelId, hangingLanternModelId);
        return JsonParser.parseString(json).getAsJsonObject();
    }

    private static JsonObject lanternBlockModel(Identifier textureId) {
        String json = """
                {
                  "parent": "minecraft:block/template_lantern",
                  "textures": {
                    "lantern": "%s"
                  }
                }
                """.formatted(textureId);
        return JsonParser.parseString(json).getAsJsonObject();
    }

    private static JsonObject lanternHangingBlockModel(Identifier textureId) {
        String json = """
                {
                  "parent": "minecraft:block/template_hanging_lantern",
                  "textures": {
                    "lantern": "%s"
                  }
                }
                """.formatted(textureId);
        return JsonParser.parseString(json).getAsJsonObject();
    }

    private static JsonObject itemModel(Identifier textureId) {
        String json = """
                {
                  "parent": "minecraft:item/generated",
                  "textures": {
                    "layer0": "%s"
                  }
                }
                """.formatted(textureId);
        return JsonParser.parseString(json).getAsJsonObject();
    }

    private static JsonObject itemParentModel(Identifier parentModelId) {
        String json = """
                {
                  "parent": "%s"
                }
                """.formatted(parentModelId);
        return JsonParser.parseString(json).getAsJsonObject();
    }
}
