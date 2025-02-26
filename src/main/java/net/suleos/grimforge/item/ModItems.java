package net.suleos.grimforge.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.suleos.grimforge.Grimforge;

public class ModItems {
    public static final Item REVENITE_INGOT = registerItem("revenite_ingot", new Item(new Item.Settings()));
    public static final Item REVENITE_FRAGMENT = registerItem("revenite_fragment", new Item(new Item.Settings()));
    public static final Item SCALDING_REVENITE_FRAGMENT = registerItem("scalding_revenite_fragment", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Grimforge.MOD_ID, name), item);
    }

    public static void registerModItems() {
       Grimforge.LOGGER.info("Registering Mod Items for " + Grimforge.MOD_ID);


    }
}
