package com.b3a5t001.biome_nexus.sound;

import com.b3a5t001.biome_nexus.BiomeNexus;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {
    public static final SoundEvent TEARS = registerSound("tears");
    public static final RegistryKey<JukeboxSong> TEARS_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(BiomeNexus.MOD_ID, "tears"));
    public static final SoundEvent LAVA_CHICKEN = registerSound("lava_chicken");
    public static final RegistryKey<JukeboxSong> LAVA_CHICKEN_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(BiomeNexus.MOD_ID, "lava_chicken"));

    private static SoundEvent registerSound(String name){
        Identifier id =  Identifier.of(BiomeNexus.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static void init(){}
}
