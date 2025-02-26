package net.suleos.grimforge;

import net.fabricmc.api.ModInitializer;

import net.suleos.grimforge.block.ModBlocks;
import net.suleos.grimforge.item.ModItemGroups;
import net.suleos.grimforge.item.ModItems;
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
	}
}