package net.suleos.grimforge;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.FireBlock;
import net.suleos.grimforge.block.ModBlocks;
import net.suleos.grimforge.item.ModItemGroups;
import net.suleos.grimforge.item.ModItems;
import net.suleos.grimforge.particle.ModParticles;
import net.suleos.grimforge.sound.ModSounds;
import net.suleos.grimforge.statuseffect.ModStatusEffects;
import net.suleos.grimforge.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Grimforge implements ModInitializer {
	public static final String MOD_ID = "grimforge";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModStatusEffects.registerStatusEffects();
		ModSounds.registerSounds();
		ModParticles.registerParticles();
		ModWorldGeneration.generateModWorldGen();

		FuelRegistry.INSTANCE.add(ModItems.ATERON, 4800);
		FuelRegistry.INSTANCE.add(ModBlocks.ATERON_BLOCK, 19500);

		CompostingChanceRegistry.INSTANCE.add(ModItems.GLOOM_BERRIES, 0.15F);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.GLOOM_BUSH, 0.25F);

		StrippableBlockRegistry.register(ModBlocks.MOURNING_OAK_LOG, ModBlocks.STRIPPED_MOURNING_OAK_LOG);
		StrippableBlockRegistry.register(ModBlocks.MOURNING_OAK_WOOD, ModBlocks.STRIPPED_MOURNING_OAK_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MOURNING_OAK_LOG, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MOURNING_OAK_WOOD, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MOURNING_OAK_LOG, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MOURNING_OAK_WOOD, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MOURNING_OAK_PLANKS, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SANGUOR_LOG, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SANGUOR_WOOD, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SANGUOR_PLANKS, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SANGUOR_LEAVES, 30, 60);
	}
}