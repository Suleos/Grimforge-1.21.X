package net.suleos.grimforge.statuseffect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.suleos.grimforge.Grimforge;

public class ModStatusEffects {

    public static final StatusEffect CHAINED = new ChainedStatusEffect();

    public static void registerStatusEffects() {
        Registry.register(Registries.STATUS_EFFECT, Identifier.of(Grimforge.MOD_ID, "chained"), CHAINED);
    }
}
