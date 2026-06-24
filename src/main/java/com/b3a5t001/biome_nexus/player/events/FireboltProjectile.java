package com.b3a5t001.biome_nexus.player.events;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FireboltProjectile extends FireballEntity {
    private static final float DAMAGE = 3.0f;
    private static final float FIRE_SECONDS = 5.0f;
    public FireboltProjectile(World world, LivingEntity owner, Vec3d velocity, int explosionPower) {
        super(world, owner, velocity, explosionPower);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
    }
}
