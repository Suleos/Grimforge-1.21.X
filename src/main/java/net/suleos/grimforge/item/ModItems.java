package net.suleos.grimforge.item;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.suleos.grimforge.Grimforge;
import net.suleos.grimforge.block.ModBlocks;
import net.suleos.grimforge.material.ModToolMaterials;

import java.util.List;


public class ModItems {
    //Revenite
    public static final Item REVENITE_INGOT = registerItem("revenite_ingot", new Item(new Item.Settings()));
    public static final Item REVENITE_FRAGMENT = registerItem("revenite_fragment", new Item(new Item.Settings()));
    public static final Item SINTERED_REVENITE = registerItem("sintered_revenite", new Item(new Item.Settings()));

    //Netherite Addons
    public static final Item RAW_NETHERITE = registerItem("raw_netherite", new Item(new Item.Settings()));
    public static final Item NETHERITE_DUST = registerItem("netherite_dust", new Item(new Item.Settings()));

    //Revenite Tools
    public static final Item REVENITE_UPGRADE_SMITHING_TEMPLATE = registerItem("revenite_upgrade_smithing_template", new Item(new Item.Settings()));



    public static final Item REVENITE_SWORD = registerItem("revenite_sword",
            new SwordItem(ModToolMaterials.REVENITE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.REVENITE,3,-2.4f))));
    public static final Item REVENITE_PICKAXE = registerItem("revenite_pickaxe",
            new PickaxeItem(ModToolMaterials.REVENITE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.REVENITE, 1, -2.8f))));
    public static final Item REVENITE_AXE = registerItem("revenite_axe",
            new AxeItem(ModToolMaterials.REVENITE, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.REVENITE, 6, -3.2f))));
    public static final Item REVENITE_SHOVEL = registerItem("revenite_shovel",
            new ShovelItem(ModToolMaterials.REVENITE, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.REVENITE, 1.5f, -3.0f))));
    public static final Item REVENITE_HOE = registerItem("revenite_hoe",
            new HoeItem(ModToolMaterials.REVENITE, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.REVENITE, 1, -3.0f))));

    //Ateron (FUEL)
    public static final Item ATERON = registerItem("ateron", new Item(new Item.Settings()));

    //Grim Foliage
    public static final Item GLOOM_BERRIES = registerItem("gloom_berries",
            new AliasedBlockItem(ModBlocks.GLOOM_BERRY_BUSH, new Item.Settings()
                    .food(ModFoodComponents.GLOOM_BERRIES)
                    .maxCount(16)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Grimforge.MOD_ID, name), item);
    }
    private static List<Text> createUpgradeSlots(Text addText, Text removeText) {
        return List.of(addText, removeText);
    }
    private static List<Text> createUpgradeIcons(Text baseGear, Text additions) {
        return List.of(baseGear, additions);
    }
    public static void registerModItems() {
        Grimforge.LOGGER.info("Registering Mod Items for " + Grimforge.MOD_ID);
    }
}
