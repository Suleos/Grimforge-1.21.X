package net.suleos.grimforge.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.suleos.grimforge.Grimforge;

public class ModParticles {
    public static final SimpleParticleType GLOOM_GLOW_PARTICLE =
            registerParticle("gloom_glow_particle", FabricParticleTypes.simple());

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Grimforge.MOD_ID, name), particleType);
    }
    public static void registerParticles() {
        Grimforge.LOGGER.info("Registering particles for" + Grimforge.MOD_ID);
    }
}
