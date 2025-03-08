package net.suleos.grimforge.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.suleos.grimforge.Grimforge;

import java.lang.reflect.Constructor;

public class ModSounds {

    // Helper method to create a SoundEvent via reflection
    private static SoundEvent createSoundEvent(Identifier id) {
        try {
            // Obtain the constructor that takes (Identifier, float, boolean)
            Constructor<SoundEvent> constructor = SoundEvent.class.getDeclaredConstructor(Identifier.class, float.class, boolean.class);
            constructor.setAccessible(true);
            // Provide default values for float and boolean (e.g. 1.0f and false)
            return constructor.newInstance(id, 1.0f, false);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create SoundEvent", e);
        }
    }

    public static final SoundEvent CHAIN_BIND = Registry.register(
            Registries.SOUND_EVENT,
            Identifier.of(Grimforge.MOD_ID, "chain_bind"),
            createSoundEvent(Identifier.of(Grimforge.MOD_ID, "chain_bind"))
    );
    public static final SoundEvent HEART_PULSE = Registry.register(
            Registries.SOUND_EVENT,
            Identifier.of(Grimforge.MOD_ID, "heart_pulse"),
            createSoundEvent(Identifier.of(Grimforge.MOD_ID, "heart_pulse"))
    );

    public static void registerSounds() {
        // Call this during mod initialization if needed
    }
}
