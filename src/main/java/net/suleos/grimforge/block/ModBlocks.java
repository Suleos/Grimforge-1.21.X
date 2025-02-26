package net.suleos.grimforge.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.suleos.grimforge.Grimforge;

public class ModBlocks {
    public static final Block GRIMSTONE = registerBlock("grimstone",
            new Block(AbstractBlock.Settings.create()
                    .strength(3.0f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block GRIMSTONE_REVENITE_ORE = registerBlock("grimstone_revenite_ore",
            new Block(AbstractBlock.Settings.create()
                    .strength(3.0f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block REVENITE_BLOCK = registerBlock("revenite_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(3.0f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHERITE)));




    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
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
