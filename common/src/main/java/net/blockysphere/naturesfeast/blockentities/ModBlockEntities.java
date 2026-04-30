package net.blockysphere.naturesfeast.blockentities;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.blockysphere.naturesfeast.NaturesFeast;
import net.blockysphere.naturesfeast.block.ModBlocks;
import net.blockysphere.naturesfeast.blockentities.custom.BirdCageBlockEntity;
import net.blockysphere.naturesfeast.blockentities.custom.NaturesFeastBannerBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(NaturesFeast.MOD_ID, Registries.BLOCK_ENTITY_TYPE);
    public static final RegistrySupplier<BlockEntityType<NaturesFeastBannerBlockEntity>> COMPLETIONIST_BANNER =
            BLOCK_ENTITIES.register("completionist_banner_entity", () ->
                    BlockEntityType.Builder.of(NaturesFeastBannerBlockEntity::new,
                            ModBlocks.NATURES_FEAST_BANNER.get(), ModBlocks.NATURES_FEAST_WALL_BANNER.get()).build(null));
    public static final RegistrySupplier<BlockEntityType<BirdCageBlockEntity>> BIRD_CAGE =
            BLOCK_ENTITIES.register("bird_cage_entity", () ->
                    BlockEntityType.Builder.of(BirdCageBlockEntity::new, ModBlocks.BIRD_CAGE.get()).build(null));
    public static void registerBlockEntities() {
        NaturesFeast.LOGGER.info("Registering ModBlockEntities for " + NaturesFeast.MOD_ID);
        BLOCK_ENTITIES.register();
    }
}