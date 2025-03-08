package net.suleos.grimforge.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.suleos.grimforge.Grimforge;
import net.suleos.grimforge.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator SANGUOR = new SaplingGenerator(Grimforge.MOD_ID + ":sanguor",
            Optional.empty(), Optional.of(ModConfiguredFeatures.SANGUOR_KEY), Optional.empty());
}
