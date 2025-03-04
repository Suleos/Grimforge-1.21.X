package net.suleos.grimforge.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.suleos.grimforge.Grimforge;
import net.suleos.grimforge.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup GRIMFORGE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Grimforge.MOD_ID, "grimforge_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.REVENITE_INGOT))
                    .displayName(Text.translatable("itemgroup.grimforge.grimforge_items_group"))
                    .entries((displayContext, entries) -> {
                        //STONE
                        entries.add(ModBlocks.GRIMSTONE);
                        entries.add(ModBlocks.GRIM_SANGUOR);
                        entries.add(ModBlocks.GRIM_MOURNIUM);
                        entries.add(ModBlocks.COBBLED_GRIMSTONE);
                        entries.add(ModBlocks.NOCTILITH);
                        entries.add(ModBlocks.DRIFTSTONE);
                        entries.add(ModBlocks.GRIMSTONE_REVENITE_ORE);
                        entries.add(ModBlocks.GRIMSTONE_NETHERITE_ORE);
                        entries.add(ModBlocks.GRIMSTONE_DIAMOND_ORE);
                        entries.add(ModBlocks.GRIMSTONE_GOLD_ORE);
                        entries.add(ModBlocks.GRIMSTONE_ATERON_ORE);
                        //LOGS
                        entries.add(ModBlocks.MOURNING_OAK_LOG);
                        entries.add(ModBlocks.MOURNING_OAK_WOOD);
                        //GRIMSTONE BRICKS GROUP
                        entries.add(ModBlocks.GRIMSTONE_BRICKS);
                        entries.add(ModBlocks.GRIMSTONE_BRICK_STAIRS);
                        entries.add(ModBlocks.GRIMSTONE_BRICK_SLAB);
                        entries.add(ModBlocks.GRIMSTONE_BRICK_WALL);
                        //MISC BLOCKS
                        entries.add(ModBlocks.REVENITE_BLOCK);
                        entries.add(ModBlocks.ATERON_BLOCK);
                        //NETHERITE ADDONS
                        entries.add(ModItems.RAW_NETHERITE);
                        entries.add(ModItems.NETHERITE_DUST);
                        //ATERON
                        entries.add(ModItems.ATERON);
                        //REVENITE
                        entries.add(ModItems.REVENITE_FRAGMENT);
                        entries.add(ModItems.REVENITE_INGOT);
                        entries.add(ModItems.SINTERED_REVENITE);
                        entries.add(ModItems.REVENITE_UPGRADE_SMITHING_TEMPLATE);
                        //REVENITE TOOLS
                        entries.add(ModItems.REVENITE_SWORD);
                        entries.add(ModItems.REVENITE_PICKAXE);
                        entries.add(ModItems.REVENITE_AXE);
                        entries.add(ModItems.REVENITE_SHOVEL);
                        entries.add(ModItems.REVENITE_HOE);
                        //FOLIAGE
                        entries.add(ModBlocks.GLOOM_BUSH);
                        entries.add(ModBlocks.TRISTESSA);
                        entries.add(ModBlocks.GLOOM_SHORT_GRASS);
                        entries.add(ModBlocks.GLOOM_MOSS);
                        entries.add(ModBlocks.GLOOM_MOSS_BLOCK);
                        //CONSUMABLES
                        entries.add(ModItems.GLOOM_BERRIES);
                    }).build());


    public static void registerItemGroups() {
        Grimforge.LOGGER.info("Registering Item Groups for " + Grimforge.MOD_ID);
    }
}
