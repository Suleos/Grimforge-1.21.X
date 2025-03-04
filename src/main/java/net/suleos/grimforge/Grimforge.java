package net.suleos.grimforge;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.suleos.grimforge.block.ModBlocks;
import net.suleos.grimforge.item.ModItemGroups;
import net.suleos.grimforge.item.ModItems;
import net.suleos.grimforge.particle.ModParticles;
import net.suleos.grimforge.sound.ModSounds;
import net.suleos.grimforge.statuseffect.ModStatusEffects;
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

		FuelRegistry.INSTANCE.add(ModItems.ATERON, 4800);
		FuelRegistry.INSTANCE.add(ModBlocks.ATERON_BLOCK, 19500);

		CompostingChanceRegistry.INSTANCE.add(ModItems.GLOOM_BERRIES, 0.15F);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.GLOOM_BUSH, 0.25F);
	}
}