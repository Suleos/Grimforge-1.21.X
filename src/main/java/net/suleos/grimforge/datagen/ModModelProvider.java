package net.suleos.grimforge.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.util.Identifier;
import net.suleos.grimforge.Grimforge;
import net.suleos.grimforge.block.ModBlocks;
import net.suleos.grimforge.block.custom.GloomBerryBushBlock;
import net.suleos.grimforge.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //BLOCKS
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRIMSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NOCTILITH);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DRIFTSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REVENITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRIMSTONE_REVENITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_GRIMSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRIMSTONE_NETHERITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRIMSTONE_DIAMOND_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRIMSTONE_GOLD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRIMSTONE_ATERON_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ATERON_BLOCK);

        //GRASS
        blockStateModelGenerator.registerSingleton(ModBlocks.GRIM_SANGUOR,
                TexturedModel.CUBE_BOTTOM_TOP);
        blockStateModelGenerator.registerSingleton(ModBlocks.GRIM_MOURNIUM,
                TexturedModel.CUBE_BOTTOM_TOP);

        //LOGS
        blockStateModelGenerator.registerSingleton(ModBlocks.MOURNING_OAK_LOG,
                TexturedModel.CUBE_BOTTOM_TOP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOURNING_OAK_WOOD);

        //SHRUBS
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.GLOOM_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.GLOOM_SHORT_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.GLOOM_BERRY_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED,
                GloomBerryBushBlock.AGE,0,1,2,3);

        //TALL FLOWERS
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.TRISTESSA, BlockStateModelGenerator.TintType.NOT_TINTED);



        //CARPETS OR MOSS
        blockStateModelGenerator.registerWoolAndCarpet(ModBlocks.GLOOM_MOSS_BLOCK, ModBlocks.GLOOM_MOSS);


        //GRIMSTONE BRICKS GROUP
        BlockStateModelGenerator.BlockTexturePool grimstoneBrickPool =  blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GRIMSTONE_BRICKS);
        grimstoneBrickPool.stairs(ModBlocks.GRIMSTONE_BRICK_STAIRS);
        grimstoneBrickPool.slab(ModBlocks.GRIMSTONE_BRICK_SLAB);
        grimstoneBrickPool.wall(ModBlocks.GRIMSTONE_BRICK_WALL);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //ITEM MODELS
        itemModelGenerator.register(ModItems.REVENITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.REVENITE_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.REVENITE_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SINTERED_REVENITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_NETHERITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.ATERON, Models.GENERATED);

        //TOOL MODELS
        itemModelGenerator.register(ModItems.REVENITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REVENITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REVENITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REVENITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REVENITE_HOE, Models.HANDHELD);

        //SHRUBS AND BUSHES
        itemModelGenerator.register(ModBlocks.GLOOM_BUSH.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.GLOOM_SHORT_GRASS.asItem(), Models.GENERATED);

    }
}
