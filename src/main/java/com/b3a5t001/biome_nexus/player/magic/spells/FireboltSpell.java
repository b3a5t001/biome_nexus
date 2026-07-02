package com.b3a5t001.biome_nexus.player.magic.spells;

import com.b3a5t001.biome_nexus.player.events.FireboltProjectile;
import com.b3a5t001.biome_nexus.player.magic.AbstractSpell;
import com.b3a5t001.biome_nexus.player.magic.SpellRegistry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public class FireboltSpell extends AbstractSpell {
    private static final double SPEED = 1.5D;
    private static final double SPAWN_DISTANCE = 1.0D;
    private static final int EXPLOSION_POWER = 0;

    public FireboltSpell() {
        super(SpellRegistry.FIREBOLT, "Firebolt", 5);
    }

    @Override
    public boolean cast(ServerPlayerEntity player) {
        ServerWorld world = player.getServerWorld();
        Vec3d direction = player.getRotationVec(1.0F).normalize();
        Vec3d velocity = direction.multiply(SPEED);
        Vec3d spawnPos = player.getEyePos().add(direction.multiply(SPAWN_DISTANCE));

        FireboltProjectile projectile = new FireboltProjectile(world, player, velocity, EXPLOSION_POWER);
        projectile.setPosition(spawnPos.x, spawnPos.y - 0.1D, spawnPos.z);
        projectile.setVelocity(velocity);

        return world.spawnEntity(projectile);
    }
}
