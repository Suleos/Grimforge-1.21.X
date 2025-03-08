package net.suleos.grimforge.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.suleos.grimforge.Grimforge;
import net.suleos.grimforge.block.custom.*;
import net.suleos.grimforge.world.tree.ModSaplingGenerators;

public class ModBlocks {
    //GRIMSTONE
    public static final Block GRIMSTONE = registerBlock("grimstone",
            new Block(AbstractBlock.Settings.create()
                    .strength(3.0f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block NOCTILITH = registerBlock("noctilith",
            new Block(AbstractBlock.Settings.create()
                    .strength(1.5f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.TUFF)));
    public static final Block DRIFTSTONE = registerBlock("driftstone",
            new Block(AbstractBlock.Settings.create()
                    .strength(2.0f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block GRIMSTONE_REVENITE_ORE = registerBlock("grimstone_revenite_ore",
            new Block(AbstractBlock.Settings.create()
                    .strength(3.0f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block GRIMSTONE_NETHERITE_ORE = registerBlock("grimstone_netherite_ore",
            new Block(AbstractBlock.Settings.create()
                    .strength(3.0f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block GRIMSTONE_DIAMOND_ORE = registerBlock("grimstone_diamond_ore",
            new Block(AbstractBlock.Settings.create()
                    .strength(3.0f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block GRIMSTONE_GOLD_ORE = registerBlock("grimstone_gold_ore",
            new Block(AbstractBlock.Settings.create()
                    .strength(3.0f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block GRIMSTONE_ATERON_ORE = registerBlock("grimstone_ateron_ore",
            new Block(AbstractBlock.Settings.create()
                    .strength(3.0f, 6.0f)
                    .requiresTool()
                    .luminance(state -> 10)
                    .sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block COBBLED_GRIMSTONE = registerBlock("cobbled_grimstone",
            new Block(AbstractBlock.Settings.create()
                    .strength(2.0f, 5.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block GRIM_GRAVEL = registerBlock("grim_gravel",
            new FallingBlock(AbstractBlock.Settings.copy(Blocks.GRAVEL)) {
                @Override
                protected MapCodec<? extends FallingBlock> getCodec() {
                    return null;
                }
            });
    //GRIMSTONE BRICKS GROUP
    public static final Block GRIMSTONE_BRICKS = registerBlock("grimstone_bricks",
            new Block(AbstractBlock.Settings.create()
                    .strength(2.0f, 5.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE_BRICKS)));
    public static final Block GRIMSTONE_BRICK_STAIRS = registerBlock("grimstone_brick_stairs",
            new StairsBlock(GRIMSTONE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(GRIMSTONE_BRICKS)));
    public static final Block GRIMSTONE_BRICK_SLAB = registerBlock("grimstone_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(GRIMSTONE_BRICKS)));
    public static final Block GRIMSTONE_BRICK_WALL = registerBlock("grimstone_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(GRIMSTONE_BRICKS)));


    //SANGUINE THICKET
    public static final Block GRIM_SANGUOR = registerBlock("grim_sanguor",
            new GrassBlock(AbstractBlock.Settings.create()
            .strength(0.6f, 3.0f).requiresTool().sounds(BlockSoundGroup.NYLIUM)));
    public static final Block VISCOUS_FERN = registerBlock("viscous_fern",
            new DrippingSanguineThicket(AbstractBlock.Settings.create()
                    .noCollision()
                    .breakInstantly().sounds(BlockSoundGroup.WEEPING_VINES).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block VISCOUS_GRASS = registerBlock("viscous_grass",
            new ShortFoliageBlockSanguineThicket(AbstractBlock.Settings.create()
                    .noCollision()
                    .breakInstantly().sounds(BlockSoundGroup.WEEPING_VINES).burnable().pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block SANGUOR_LOG = registerBlock("sanguor_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.WARPED_STEM).ticksRandomly()));
    public static final Block SANGUOR_WOOD = registerBlock("sanguor_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.WARPED_STEM)));
    public static final Block SANGUOR_PLANKS = registerBlock("sanguor_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)));
    public static final Block SANGUOR_STAIRS = registerBlock("sanguor_stairs",
            new StairsBlock(SANGUOR_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.WARPED_STAIRS)));
    public static final Block SANGUOR_SLAB = registerBlock("sanguor_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.WARPED_SLAB)));
    public static final Block SANGUOR_BUTTON = registerBlock("sanguor_button",
            new ButtonBlock(BlockSetType.WARPED, 30, AbstractBlock.Settings.copy(Blocks.WARPED_BUTTON)));
    public static final Block SANGUOR_FENCE = registerBlock("sanguor_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.WARPED_FENCE)));
    public static final Block SANGUOR_FENCE_GATE = registerBlock("sanguor_fence_gate",
            new FenceGateBlock(WoodType.WARPED, AbstractBlock.Settings.copy(Blocks.WARPED_FENCE_GATE)));
    public static final Block SANGUOR_LEAVES = registerBlock("sanguor_leaves",
            new ViscousDripLeafBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).sounds(BlockSoundGroup.NETHER_WART).nonOpaque()));
    public static final Block SANGUOR_SAPLING = registerBlock("sanguor_sapling",
            new SanguorSaplngBlock(ModSaplingGenerators.SANGUOR, AbstractBlock.Settings.copy(Blocks.CRIMSON_FUNGUS)));

    //WEEPING HOLLOWS
    public static final Block GRIM_MOURNIUM = registerBlock("grim_mournium",
            new GrassBlock(AbstractBlock.Settings.create()
                    .strength(0.6f, 3.0f).requiresTool().sounds(BlockSoundGroup.NYLIUM)));
    public static final Block GLOOM_BUSH = registerBlock("gloom_bush",
            new WeepingHollowParticles(AbstractBlock.Settings.create()
                    .mapColor(MapColor.LAPIS_BLUE)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XYZ)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GLOOM_SHORT_GRASS = registerBlock("gloom_short_grass",
            new ShortFoliageBlockWeepingHollow(AbstractBlock.Settings.create()
                    .mapColor(MapColor.LAPIS_BLUE)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XYZ)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GLOOM_MOSS = registerBlock("gloom_moss",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.MOSS_CARPET)));
    public static final Block GLOOM_MOSS_BLOCK = registerBlock("gloom_moss_block",
            new MossBlock(AbstractBlock.Settings.copy(Blocks.MOSS_BLOCK)));
    public static final Block GLOOM_BERRY_BUSH = registerBlockWithoutBlockItem("gloom_berry_bush",
            new GloomBerryBushBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)));
    public static final Block TRISTESSA = registerBlock("tristessa",
            new TallFoliageBlockWeepingHollow(AbstractBlock.Settings.create()
                .noCollision()
                    .luminance(state -> 9)
                .breakInstantly().sounds(BlockSoundGroup.GRASS).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block TRISTESSA_VINE = registerBlock("tristessa_vine",
            new VineBlock(AbstractBlock.Settings.copy(Blocks.VINE).luminance(state -> 9)));

    public static final Block MOURNING_OAK_LOG = registerBlock("mourning_oak_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));
    public static final Block MOURNING_OAK_WOOD = registerBlock("mourning_oak_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_MOURNING_OAK_LOG = registerBlock("stripped_mourning_oak_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_DARK_OAK_LOG)));
    public static final Block STRIPPED_MOURNING_OAK_WOOD = registerBlock("stripped_mourning_oak_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_DARK_OAK_WOOD)));

    public static final Block MOURNING_OAK_PLANKS = registerBlock("mourning_oak_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Block MOURNING_OAK_STAIRS = registerBlock("mourning_oak_stairs",
            new StairsBlock(MOURNING_OAK_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.DARK_OAK_STAIRS)));
    public static final Block MOURNING_OAK_SLAB = registerBlock("mourning_oak_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_SLAB)));

    public static final Block MOURNING_OAK_BUTTON = registerBlock("mourning_oak_button",
            new ButtonBlock(BlockSetType.DARK_OAK, 30, AbstractBlock.Settings.copy(Blocks.DARK_OAK_BUTTON)));
    public static final Block MOURNING_OAK_FENCE = registerBlock("mourning_oak_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_FENCE)));
    public static final Block MOURNING_OAK_FENCE_GATE = registerBlock("mourning_oak_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.DARK_OAK_FENCE)));

    public static final Block MOURNING_OAK_DOOR = registerBlock("mourning_oak_door",
            new DoorBlock(BlockSetType.DARK_OAK, AbstractBlock.Settings.copy(Blocks.OAK_DOOR).nonOpaque()));
    public static final Block MOURNING_OAK_TRAPDOOR = registerBlock("mourning_oak_trapdoor",
            new TrapdoorBlock(BlockSetType.DARK_OAK, AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR).nonOpaque()));



    //REVENITE
    public static final Block REVENITE_BLOCK = registerBlock("revenite_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(3.0f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHERITE)));
    //ATERON
    public static final Block ATERON_BLOCK = registerBlock("ateron_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(2.0f,5.0f)
                    .requiresTool()
                    .luminance(state -> 10)
                    .sounds(BlockSoundGroup.COPPER)));




    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Grimforge.MOD_ID, name), block);
    }
    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(Grimforge.MOD_ID, name), block);
    }



    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Grimforge.MOD_ID, name),
            new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Grimforge.LOGGER.info("Registering Mod Blocks for " + Grimforge.MOD_ID);

    }
}
