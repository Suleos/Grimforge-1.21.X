package net.suleos.grimforge.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.suleos.grimforge.block.ModBlocks;
import net.suleos.grimforge.particle.ModParticles;

public class DrippingSanguineThicket extends TallPlantBlock {
    public DrippingSanguineThicket(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState blockBelow = world.getBlockState(pos.down());
        return blockBelow.isOf(ModBlocks.GRIM_SANGUOR); // Ensures it can only be placed on GRIM_SANGUOR blocks
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);

        // Only run on the client side
        if (world.isClient()) {
            // Random chance to spawn a particle
            if (random.nextFloat() < 0.05f) {
                spawnDripParticle((ClientWorld) world, pos, random);
            }
        }
    }

    private void spawnDripParticle(ClientWorld world, BlockPos pos, Random random) {
        // Slight offsets for particle position
        double x = pos.getX() + 0.5 + (random.nextDouble() - 0.5) * 0.5; // Center horizontally with small random offset
        double y = pos.getY() + random.nextDouble() * 0.75;
        double z = pos.getZ() + 0.5 + (random.nextDouble() - 0.5) * 0.5; // Center horizontally with small random offset

        // Add the particle to the client world
        world.addParticle(ModParticles.VISCOUS_DRIP_PARTICLE, // Reference to your custom particle
                x, y, z,                            // Particle spawn position
                0.0, 0.0, 0.0);                     // Initial velocity set to 0 (static drip)
    }
}