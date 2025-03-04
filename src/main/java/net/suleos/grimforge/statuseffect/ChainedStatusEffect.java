package net.suleos.grimforge.statuseffect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.LivingEntity;

public class ChainedStatusEffect extends StatusEffect {

    public ChainedStatusEffect() {
        // Changed color to Dark Red (Hex: #8B0000)
        super(StatusEffectCategory.HARMFUL, 0x8B0000);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        // Freeze the entity by setting its velocity to zero
        entity.setVelocity(0, 0, 0);
        entity.velocityModified = true;
        // Return true to indicate that the effect was applied
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // Update the effect every tick to keep the entity rooted
        return true;
    }
}
