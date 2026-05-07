package net.blockysphere.naturesfeast.forge.client;

import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.blockysphere.naturesfeast.block.ModBlocks;
import net.blockysphere.naturesfeast.blockentities.ModBlockEntities;
import net.blockysphere.naturesfeast.renderer.NaturesFeastBannerRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class NaturesFeastForgeClient {
    public static void onInitializeClient(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
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
        });
    }
}
