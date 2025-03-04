package net.suleos.grimforge.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.suleos.grimforge.Grimforge;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_REVENITE_TOOL = createTag("needs_revenite_tool");
        public static final TagKey<Block> INCORRECT_FOR_REVENITE_TOOL = createTag("incorrect_for_revenite_tool");


        public static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Grimforge.MOD_ID, name));
        }

    public static class Items {

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Grimforge.MOD_ID, name));
        }
    }


    }
}
