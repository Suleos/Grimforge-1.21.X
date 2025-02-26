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
                        entries.add(ModItems.REVENITE_INGOT);
                        entries.add(ModItems.REVENITE_FRAGMENT);
                        entries.add(ModItems.SCALDING_REVENITE_FRAGMENT);
                        entries.add(ModBlocks.GRIMSTONE_REVENITE_ORE);
                        entries.add(ModBlocks.GRIMSTONE);
                        entries.add(ModBlocks.REVENITE_BLOCK);
                    }).build());


    public static void registerItemGroups() {
        Grimforge.LOGGER.info("Registering Item Groups for " + Grimforge.MOD_ID);
    }
}
