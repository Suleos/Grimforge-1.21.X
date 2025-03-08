package net.suleos.grimforge.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.suleos.grimforge.block.ModBlocks;
import net.suleos.grimforge.block.custom.GloomBerryBushBlock;
import net.suleos.grimforge.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        //BLOCKS THAT WILL DROP THEMSELVES
        addDrop(ModBlocks.REVENITE_BLOCK);
        addDrop(ModBlocks.GRIMSTONE_BRICKS);
        addDrop(ModBlocks.GRIMSTONE_BRICK_STAIRS);
        addDrop(ModBlocks.GRIMSTONE_BRICK_SLAB, slabDrops(ModBlocks.GRIMSTONE_BRICK_SLAB));
        addDrop(ModBlocks.GRIMSTONE_BRICK_WALL);
        addDrop(ModBlocks.ATERON_BLOCK);
        addDrop(ModBlocks.NOCTILITH);
        addDrop(ModBlocks.DRIFTSTONE);
        addDrop(ModBlocks.GRIM_SANGUOR);
        addDrop(ModBlocks.GRIM_MOURNIUM);
        addDrop(ModBlocks.GLOOM_BUSH);
        addDrop(ModBlocks.GLOOM_MOSS_BLOCK);
        addDrop(ModBlocks.GLOOM_MOSS);
        addDrop(ModBlocks.MOURNING_OAK_LOG);
        addDrop(ModBlocks.MOURNING_OAK_WOOD);
        addDrop(ModBlocks.STRIPPED_MOURNING_OAK_LOG);
        addDrop(ModBlocks.STRIPPED_MOURNING_OAK_WOOD);
        addDrop(ModBlocks.MOURNING_OAK_PLANKS);
        addDrop(ModBlocks.MOURNING_OAK_STAIRS);
        addDrop(ModBlocks.MOURNING_OAK_SLAB, slabDrops(ModBlocks.MOURNING_OAK_SLAB));
        addDrop(ModBlocks.MOURNING_OAK_FENCE);
        addDrop(ModBlocks.MOURNING_OAK_FENCE_GATE);
        addDrop(ModBlocks.MOURNING_OAK_BUTTON);
        addDrop(ModBlocks.MOURNING_OAK_DOOR, doorDrops(ModBlocks.MOURNING_OAK_DOOR));
        addDrop(ModBlocks.MOURNING_OAK_TRAPDOOR);
        addDrop(ModBlocks.TRISTESSA);
        addDrop(ModBlocks.TRISTESSA_VINE);
        addDrop(ModBlocks.VISCOUS_FERN);
        addDrop(ModBlocks.SANGUOR_WOOD);
        addDrop(ModBlocks.SANGUOR_LOG);

        //GRAVEL
        addDrop(ModBlocks.GRIM_GRAVEL, block -> LootTable.builder()
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) // Single roll
                        // Entry for Flint with 10% chance
                        .with(ItemEntry.builder(Items.FLINT)
                                .conditionally(RandomChanceLootCondition.builder(0.1f)))
                        // Fallback entry for dropping the block itself
                        .with(ItemEntry.builder(block))
                )
        );

        //LEAVES
        addDrop(ModBlocks.SANGUOR_LEAVES, leavesDrops(ModBlocks.SANGUOR_LEAVES, ModBlocks.SANGUOR_SAPLING, 0.0625f));

        //ORES
        addDrop(ModBlocks.GRIMSTONE_REVENITE_ORE, oreDrops(ModBlocks.GRIMSTONE_REVENITE_ORE, ModItems.REVENITE_FRAGMENT));
        addDrop(ModBlocks.GRIMSTONE_NETHERITE_ORE, oreDrops(ModBlocks.GRIMSTONE_NETHERITE_ORE, ModItems.RAW_NETHERITE));
        addDrop(ModBlocks.GRIMSTONE_DIAMOND_ORE, oreDrops(ModBlocks.GRIMSTONE_DIAMOND_ORE, Items.DIAMOND));
        addDrop(ModBlocks.GRIMSTONE_GOLD_ORE, oreDrops(ModBlocks.GRIMSTONE_GOLD_ORE, Items.RAW_GOLD));
        addDrop(ModBlocks.GRIMSTONE_ATERON_ORE, oreDrops(ModBlocks.GRIMSTONE_ATERON_ORE, ModItems.ATERON));

        //COBBLESTONES
        addDrop(ModBlocks.GRIMSTONE, drops(ModBlocks.GRIMSTONE, ModBlocks.COBBLED_GRIMSTONE));

        //BERRIES
        this.addDrop(ModBlocks.GLOOM_BERRY_BUSH,
                block -> this.applyExplosionDecay(
                        block,
                        LootTable.builder()
                                .pool(LootPool.builder()
                                                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.GLOOM_BERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(GloomBerryBushBlock.AGE, 3)))
                                                .with(ItemEntry.builder(ModItems.GLOOM_BERRIES))
                                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                                )
                                .pool(LootPool.builder()
                                                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.GLOOM_BERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(GloomBerryBushBlock.AGE, 2)))
                                                .with(ItemEntry.builder(ModItems.GLOOM_BERRIES))
                                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))));

    }


}
