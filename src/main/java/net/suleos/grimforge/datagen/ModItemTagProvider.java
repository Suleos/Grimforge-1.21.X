package net.suleos.grimforge.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.suleos.grimforge.block.ModBlocks;
import net.suleos.grimforge.item.ModItems;
import net.suleos.grimforge.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    public void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.REVENITE_SWORD);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.REVENITE_PICKAXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.REVENITE_SHOVEL);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.REVENITE_AXE);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.REVENITE_HOE);

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.MOURNING_OAK_LOG.asItem())
                .add(ModBlocks.MOURNING_OAK_WOOD.asItem())
                .add(ModBlocks.STRIPPED_MOURNING_OAK_LOG.asItem())
                .add(ModBlocks.STRIPPED_MOURNING_OAK_WOOD.asItem())
                .add(ModBlocks.SANGUOR_LOG.asItem())
                .add(ModBlocks.SANGUOR_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.SANGUOR_PLANKS.asItem())
                .add(ModBlocks.MOURNING_OAK_PLANKS.asItem());

    }
}
