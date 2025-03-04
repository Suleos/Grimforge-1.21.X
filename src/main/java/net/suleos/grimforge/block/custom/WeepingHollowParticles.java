package net.suleos.grimforge.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.suleos.grimforge.block.ModBlocks;
import net.suleos.grimforge.particle.ModParticles;

public class WeepingHollowParticles extends PlantBlock {
    public WeepingHollowParticles(Settings settings) {
        super(settings);
    }
    @Override
    public boolean canPlaceAt(BlockState state, net.minecraft.world.WorldView world, net.minecraft.util.math.BlockPos pos) {
        BlockState blockBelow = world.getBlockState(pos.down());
        return blockBelow.isOf(ModBlocks.GRIM_MOURNIUM);
    }

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return null;
    }
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);

        // Check if on the client side
        if (world.isClient()) {
            double radius = 2.0; // Control the horizontal spread area (2-block radius)

            // Horizontal offsets within radius [-radius, radius]
            double offsetX = (random.nextDouble() - 0.5) * 2 * radius;
            double offsetZ = (random.nextDouble() - 0.5) * 2 * radius;

            // Vertical offset within restricted range [0.5, 2.5] blocks above the bush
            double minY = 1.0; // Minimum height
            double maxY = 3.5; // Maximum height
            double offsetY = minY + (random.nextDouble() * (maxY - minY)); // Random height in range [minY, maxY]

            // Add the particle to the world
            ((ClientWorld) world).addParticle(ModParticles.GLOOM_GLOW_PARTICLE,
                    pos.getX() + 0.5 + offsetX, // Centered horizontally on the bush, with horizontal spread
                    pos.getY() + offsetY,       // Offset vertically within restricted range
                    pos.getZ() + 0.5 + offsetZ, // Centered horizontally on the bush, with horizontal spread
                    0.0, 0.0, 0.0);             // Initial velocity (default to 0, can adjust if needed)
        }
    }
}