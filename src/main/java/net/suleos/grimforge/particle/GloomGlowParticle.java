package net.suleos.grimforge.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class GloomGlowParticle extends SpriteBillboardParticle {
    private final SpriteProvider spriteProvider;
    private final int totalFrames = 3;
    private float baseAlpha;
    private int flickerTimer;

    public GloomGlowParticle(ClientWorld clientWorld, double x, double y, double z,
                             SpriteProvider spriteProvider, double xSpeed, double ySpeed, double zSpeed) {
        super(clientWorld, x, y, z, xSpeed, ySpeed, zSpeed);

        this.spriteProvider = spriteProvider;
        this.setSpriteForAge(spriteProvider);

        this.maxAge = 400; //lifespan in ticks
        this.scale = 0.2F + this.random.nextFloat() * 0.1F; //randomized size
        this.gravityStrength = 0.003F; //will not be affected by gravity
        this.velocityMultiplier = 0.96F; //smoothing of velocity changes

        //velocity
        this.velocityX = (random.nextFloat() - 0.5f) * 0.02f;
        this.velocityY = (random.nextFloat() - 0.1f) * 0.02f;
        this.velocityZ = (random.nextFloat() - 0.5f) * 0.02f;

        //opacity properties
        this.baseAlpha = 0.8f + random.nextFloat() * 0.2f;
        this.alpha = 0.0f;
        this.flickerTimer = random.nextInt(40);



    }

    @Override
    public void tick() {
        super.tick();

        // Apply air resistance to dampen movement over time (creates smoother drifting)
        this.velocityX *= this.velocityMultiplier;
        this.velocityY *= this.velocityMultiplier;
        this.velocityZ *= this.velocityMultiplier;

        // Add random horizontal drifting
        this.velocityX += (random.nextFloat() - 0.5f) * 0.004f; // Horizontal drift
        this.velocityZ += (random.nextFloat() - 0.5f) * 0.004f; // Horizontal drift

        // Smaller vertical drifting to simulate floating up/down motion
        if (this.age % 10 == 0) { // Apply vertical drift every 10 ticks for smoother up/down motion
            this.velocityY += (random.nextFloat() - 0.5f) * 0.008f; // Up/down occasional drift
        }

        // Light upward "float" occasionally triggered
        if (random.nextFloat() < 0.02f) { // 2% chance per tick to float upward
            this.velocityY += 0.01f; // Small upward nudge
        }

        // Add occasional stronger changes to horizontal direction for more dynamic wandering
        if (this.age % 50 == 0) { // Every 50 ticks, apply larger random shift
            this.velocityX += (random.nextFloat() - 0.5f) * 0.02f; // Stronger horizontal shift
            this.velocityZ += (random.nextFloat() - 0.5f) * 0.02f; // Stronger horizontal shift
        }

        // Handle flickering (same logic as before)
        if (this.flickerTimer <= 0) {
            this.alpha = baseAlpha * (0.5F + 0.5F * (float) Math.sin(this.age / 5.0F)); // Smooth flicker
            if (this.random.nextFloat() < 0.05F) {
                this.flickerTimer = 20 + random.nextInt(60); // Wait 20-80 ticks before glowing again
            }
        } else {
            this.alpha = 0.0F; // Not glowing
            this.flickerTimer--;
        }

        // Fade the particle out as it nears the end of its lifespan
        if (this.age > this.maxAge - 50) {
            float fadeFactor = (float) (this.maxAge - this.age) / 50.0F;
            this.alpha = Math.max(0.0F, this.alpha * fadeFactor);
        }

        // Texture animation (unchanged from existing logic)
        if (!this.dead) {
            int frameCount = totalFrames;
            int frameDuration = 5;
            int cycleLength = frameCount * frameDuration;
            int currentFrame = (this.age % cycleLength) / frameDuration;
            this.setSprite(this.spriteProvider.getSprite(currentFrame, frameCount));
        }

    }


    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        @Nullable
        public Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new GloomGlowParticle(world, x, y, z, this.spriteProvider, velocityX, velocityY, velocityZ);
        }
    }
}
