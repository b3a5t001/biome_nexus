package com.b3a5t001.biome_nexus.entities;

import com.b3a5t001.biome_nexus.items.ModItems;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;

public class ModEntityEvents {
    public static void init(){
        ServerLivingEntityEvents.AFTER_DEATH.register((entity, damageSource) -> {
            // If a ghast dies from a fireball whose owner is a player, drop the Tears music disc.
            if (!(entity instanceof GhastEntity)) {
                return;
            }

            Entity source = damageSource.getSource();
            if (!(source instanceof FireballEntity fireball)) {
                return;
            }

            Entity owner = fireball.getOwner();
            if (!(owner instanceof PlayerEntity)) {
                return;
            }

            // Drop exactly one disc on the server side.
            entity.dropItem(ModItems.TEARS_MUSIC_DISC);

        });

        ServerLivingEntityEvents.AFTER_DEATH.register((entity, damageSource) -> {
            // If a baby zombie dies while riding a chicken (chicken jockey), drop the Lava Chicken music disc.
            if (!(entity instanceof ZombieEntity zombie)) {
                return;
            }

            if (!zombie.isBaby()) {
                return;
            }

            Entity vehicle = zombie.getVehicle();
            if (!(vehicle instanceof ChickenEntity)) {
                return;
            }

            entity.dropItem(ModItems.LAVA_CHICKEN_MUSIC_DISC);
        });
    }

}
