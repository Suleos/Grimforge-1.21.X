package net.suleos.grimforge.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent GLOOM_BERRIES = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.3f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 600, 0), 1.0f)
            .build();

}
