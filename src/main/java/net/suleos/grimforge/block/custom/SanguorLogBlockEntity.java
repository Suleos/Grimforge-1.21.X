package net.suleos.grimforge.block.custom;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.suleos.grimforge.block.entity.ModBlockEntities;
import net.suleos.grimforge.sound.ModSounds;

public class SanguorLogBlockEntity extends BlockEntity {

    private int ticks = 0; // Counter for ticks

    public SanguorLogBlockEntity(BlockPos pos, net.minecraft.block.BlockState state) {
        super(ModBlockEntities.SANGUOR_LOG_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, net.minecraft.block.BlockState state, SanguorLogBlockEntity blockEntity) {
        if (!world.isClient) {
            blockEntity.ticks++;

            if (blockEntity.ticks >= 200) { // Play sound every 200 ticks (10 seconds)
                world.playSound(
                        null, // No player
                        pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, // Center of the block
                        ModSounds.HEART_PULSE, // Your custom sound
                        SoundCategory.BLOCKS, // Sound category
                        1.0F, // Volume
                        1.0F  // Pitch
                );
                blockEntity.ticks = 0; // Reset tick counter
            }
        }
    }
}