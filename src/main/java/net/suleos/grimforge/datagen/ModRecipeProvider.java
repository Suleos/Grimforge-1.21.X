package net.suleos.grimforge.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.suleos.grimforge.Grimforge;
import net.suleos.grimforge.block.ModBlocks;
import net.suleos.grimforge.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        //SMELTING/BLASTING
        List<ItemConvertible> REVENITE_SMELTABLES = List.of(ModItems.REVENITE_FRAGMENT);
        List<ItemConvertible> NETHERITE_SMELTABLES = List.of(ModItems.RAW_NETHERITE);
        List<ItemConvertible> NETHERITE_DUST = List.of(Items.NETHERITE_INGOT);
        offerBlasting(recipeExporter, REVENITE_SMELTABLES, RecipeCategory.MISC, ModItems.SINTERED_REVENITE, 2.00f,400, "revenite");

        offerSmelting(recipeExporter, NETHERITE_SMELTABLES, RecipeCategory.MISC, Items.NETHERITE_INGOT, 1.00f,200, "netherite");
        offerBlasting(recipeExporter, NETHERITE_SMELTABLES, RecipeCategory.MISC, Items.NETHERITE_INGOT, 1.00f,100, "netherite");

        offerBlasting(recipeExporter, NETHERITE_DUST, RecipeCategory.MISC, ModItems.NETHERITE_DUST, 1.00f,500, "netherite_dust");

        //REVENITE CRAFTING
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.REVENITE_INGOT, RecipeCategory.DECORATIONS, ModBlocks.REVENITE_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.REVENITE_INGOT, 1)
                .input(ModItems.SINTERED_REVENITE, 2).input(ModItems.NETHERITE_DUST, 1)
                .criterion(hasItem(ModItems.SINTERED_REVENITE), conditionsFromItem(ModItems.SINTERED_REVENITE))
                .offerTo(recipeExporter, Identifier.of(Grimforge.MOD_ID,"revenite_ingot_from_crafting"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GRIMSTONE_BRICKS, 4)
                .input(ModBlocks.COBBLED_GRIMSTONE, 4)
                .criterion(hasItem(ModBlocks.COBBLED_GRIMSTONE), conditionsFromItem(ModBlocks.COBBLED_GRIMSTONE))
                .offerTo(recipeExporter, Identifier.of(Grimforge.MOD_ID,"grimstone_bricks_from_crafting"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ATERON_BLOCK, 1)
                .input(ModItems.ATERON, 9)
                .criterion(hasItem(ModItems.ATERON), conditionsFromItem(ModItems.ATERON))
                .offerTo(recipeExporter, Identifier.of(Grimforge.MOD_ID,"ateron_from_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.GLOOM_MOSS, 3)
                .pattern("   ")
                .pattern("   ")
                .pattern(" xx")
                .input('x', ModBlocks.GLOOM_MOSS_BLOCK)
                .criterion(hasItem(ModBlocks.GLOOM_MOSS_BLOCK), conditionsFromItem(ModBlocks.GLOOM_MOSS_BLOCK))
                .offerTo(recipeExporter, Identifier.of(Grimforge.MOD_ID,"gloom_moss_from_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOURNING_OAK_WOOD, 4)
                .pattern("   ")
                .pattern(" xx")
                .pattern(" xx")
                .input('x', ModBlocks.MOURNING_OAK_LOG)
                .criterion(hasItem(ModBlocks.MOURNING_OAK_LOG), conditionsFromItem(ModBlocks.MOURNING_OAK_LOG))
                .offerTo(recipeExporter, Identifier.of(Grimforge.MOD_ID,"weeping_wood_from_crafting"));


    }
}
