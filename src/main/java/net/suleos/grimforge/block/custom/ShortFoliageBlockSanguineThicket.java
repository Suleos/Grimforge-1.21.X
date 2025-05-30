package net.suleos.grimforge.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.suleos.grimforge.block.ModBlocks;

public class ShortFoliageBlockSanguineThicket extends PlantBlock {
    public ShortFoliageBlockSanguineThicket(Settings settings) {
        super(settings);
    }
    @Override
    public boolean canPlaceAt(BlockState state, net.minecraft.world.WorldView world, net.minecraft.util.math.BlockPos pos) {
        BlockState blockBelow = world.getBlockState(pos.down());
        return blockBelow.isOf(ModBlocks.GRIM_SANGUOR);
    }

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return null;
    }
}
