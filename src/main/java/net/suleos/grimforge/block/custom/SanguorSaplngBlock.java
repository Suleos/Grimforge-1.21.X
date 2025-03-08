package net.suleos.grimforge.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SaplingGenerator;
import net.suleos.grimforge.block.ModBlocks;

public class SanguorSaplngBlock extends SaplingBlock {
    public SanguorSaplngBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Override
    public boolean canPlaceAt(BlockState state, net.minecraft.world.WorldView world, net.minecraft.util.math.BlockPos pos) {
        BlockState blockBelow = world.getBlockState(pos.down());
        return blockBelow.isOf(ModBlocks.GRIM_SANGUOR);
    }
}
