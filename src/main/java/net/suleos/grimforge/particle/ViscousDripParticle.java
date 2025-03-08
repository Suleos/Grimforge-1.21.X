package net.suleos.grimforge.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class ViscousDripParticle extends SpriteBillboardParticle {

    public ViscousDripParticle(ClientWorld clientWorld, double x, double y, double z,
                               SpriteProvider spriteProvider, double velocityX, double velocityY, double velocityZ) {
        super(clientWorld, x, y, z, velocityX, velocityY, velocityZ);

        this.setSprite(spriteProvider); // Use a sprite for this particle (static texture)

        // Particle lifetime (randomize slightly)
        this.maxAge = 40 + random.nextInt(20);

        // Configure scale, velocity, and gravity
        this.scale = 0.3F + this.random.nextFloat() * 0.1F; // Slightly variable size
        this.gravityStrength = 0.2F; // Simulate falling faster due to "blood density"
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;

        // Start fully opaque, fade over lifetime
        this.alpha = 1.0F;
    }

    @Override
    public void tick() {
        super.tick();

        // Fade out particle as it nears the end of its lifespan
        if (this.age > this.maxAge - 10) {
            this.alpha -= 0.1F;
        }

        // Mark as dead when invisible
        if (this.alpha <= 0.0F) {
            this.markDead();
        }
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT; // For blending translucent particles
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType parameters, ClientWorld world,
                                       double x, double y, double z,
                                       double velocityX, double velocityY, double velocityZ) {
            return new ViscousDripParticle(world, x, y, z, this.spriteProvider, velocityX, velocityY, velocityZ);
        }
    }
}