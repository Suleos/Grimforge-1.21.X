package net.suleos.grimforge.block.entity;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.suleos.grimforge.Grimforge;
import net.suleos.grimforge.block.ModBlocks;
import net.suleos.grimforge.block.custom.SanguorLogBlockEntity;

public class ModBlockEntities {

    // Declare the Block Entity Type
    public static BlockEntityType<SanguorLogBlockEntity> SANGUOR_LOG_ENTITY;

    // This method registers the custom block entity
    public static void registerBlockEntities() {
        SANGUOR_LOG_ENTITY = Registry.register(
                Registries.BLOCK_ENTITY_TYPE, // Vanilla registry for block entities
                Identifier.of(Grimforge.MOD_ID, "sanguor_log_entity"), // Your block entity ID
                BlockEntityType.Builder.create(SanguorLogBlockEntity::new, ModBlocks.SANGUOR_LOG).build(null)
        );
    }
}