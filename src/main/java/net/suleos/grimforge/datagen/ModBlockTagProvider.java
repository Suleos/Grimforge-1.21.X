package net.suleos.grimforge.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.suleos.grimforge.block.ModBlocks;
import net.suleos.grimforge.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        //STONE BLOCKS
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.GRIMSTONE)
                .add(ModBlocks.NOCTILITH)
                .add(ModBlocks.DRIFTSTONE)
                .add(ModBlocks.GRIMSTONE_REVENITE_ORE)
                .add(ModBlocks.GRIMSTONE_NETHERITE_ORE)
                .add(ModBlocks.GRIMSTONE_DIAMOND_ORE)
                .add(ModBlocks.GRIMSTONE_GOLD_ORE)
                .add(ModBlocks.GRIMSTONE_ATERON_ORE)
                .add(ModBlocks.REVENITE_BLOCK)
                .add(ModBlocks.COBBLED_GRIMSTONE)
                .add(ModBlocks.GRIMSTONE_BRICKS)
                .add(ModBlocks.GRIMSTONE_BRICK_STAIRS)
                .add(ModBlocks.GRIMSTONE_BRICK_SLAB)
                .add(ModBlocks.GRIMSTONE_BRICK_WALL)
                .add(ModBlocks.ATERON_BLOCK)
                .add(ModBlocks.GRIM_SANGUOR)
                .add(ModBlocks.GRIM_MOURNIUM);


        //WALLS
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.GRIMSTONE_BRICK_WALL);


        //BLOCKS REQUIRING DIAMOND TOOLS
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.GRIMSTONE_REVENITE_ORE)
                .add(ModBlocks.GRIMSTONE_NETHERITE_ORE);

        //BLOCKS REQUIRING IRON TOOLS
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GRIMSTONE_DIAMOND_ORE)
                .add(ModBlocks.GRIMSTONE_GOLD_ORE)
                .add(ModBlocks.GRIMSTONE_ATERON_ORE)
                .add(ModBlocks.ATERON_BLOCK);

        //DEFINES THAT REVENITE = DIAMOND
        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_REVENITE_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.REVENITE_BLOCK);

        //LOGS
        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ModBlocks.MOURNING_OAK_LOG)
                .add(ModBlocks.MOURNING_OAK_WOOD);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MOURNING_OAK_LOG)
                .add(ModBlocks.MOURNING_OAK_WOOD);
    }
}
