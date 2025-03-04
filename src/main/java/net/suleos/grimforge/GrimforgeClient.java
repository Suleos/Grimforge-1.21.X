package net.suleos.grimforge;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.suleos.grimforge.block.ModBlocks;
import net.suleos.grimforge.particle.GloomGlowParticle;
import net.suleos.grimforge.particle.ModParticles;

public class GrimforgeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLOOM_BUSH, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLOOM_SHORT_GRASS, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLOOM_BERRY_BUSH, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRISTESSA, RenderLayer.getCutout());

    ParticleFactoryRegistry.getInstance().register(ModParticles.GLOOM_GLOW_PARTICLE, GloomGlowParticle.Factory::new);
    }
}

