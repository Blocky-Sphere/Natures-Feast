package net.blockysphere.naturesfeast.fabric.client;

import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.blockysphere.naturesfeast.block.ModBlocks;
import net.blockysphere.naturesfeast.blockentities.ModBlockEntities;
import net.blockysphere.naturesfeast.renderer.NaturesFeastBannerRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;

public final class NaturesFeastFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.register(ModBlockEntities.COMPLETIONIST_BANNER.get(), NaturesFeastBannerRenderer::new);
        RenderTypeRegistry.register(RenderType.cutout(),
                ModBlocks.GARLIC_CROP.get(),
                ModBlocks.CHILI_PEPPER_CROP.get(),
                ModBlocks.PIPER_NIGRUM.get(),
                ModBlocks.BIRD_CAGE.get(),
                ModBlocks.WHOLE_BAKED_SEA_BASS_PLACED.get(),
                ModBlocks.HORSE_FILLET_PLACED.get(),
                ModBlocks.WILD_CHILI_PEPPERS.get(),
                ModBlocks.WILD_GARLICS.get()
        );
    }
}