package net.suleos.grimforge;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.render.RenderLayer;
import net.suleos.grimforge.block.ModBlocks;
import net.suleos.grimforge.particle.GloomGlowParticle;
import net.suleos.grimforge.particle.ModParticles;
import net.suleos.grimforge.particle.ViscousDripParticle;

public class GrimforgeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLOOM_BUSH, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLOOM_SHORT_GRASS, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLOOM_BERRY_BUSH, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRISTESSA, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRISTESSA_VINE, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VISCOUS_FERN, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MOURNING_OAK_DOOR, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MOURNING_OAK_TRAPDOOR, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VISCOUS_GRASS, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SANGUOR_SAPLING, RenderLayer.getCutout());

    ParticleFactoryRegistry.getInstance().register(ModParticles.GLOOM_GLOW_PARTICLE, GloomGlowParticle.Factory::new);
    ParticleFactoryRegistry.getInstance().register(ModParticles.VISCOUS_DRIP_PARTICLE, ViscousDripParticle.Factory::new);
    }
}

