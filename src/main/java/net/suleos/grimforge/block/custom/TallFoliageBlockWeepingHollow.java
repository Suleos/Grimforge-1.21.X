package net.suleos.grimforge.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.TallPlantBlock;
import net.suleos.grimforge.block.ModBlocks;

public class TallFoliageBlockWeepingHollow extends TallPlantBlock {
    public TallFoliageBlockWeepingHollow(Settings settings) {
        super(settings);
    }
    @Override
    public boolean canPlaceAt(BlockState state, net.minecraft.world.WorldView world, net.minecraft.util.math.BlockPos pos) {
        BlockState blockBelow = world.getBlockState(pos.down());
        return blockBelow.isOf(ModBlocks.GRIM_MOURNIUM);
    }
}
