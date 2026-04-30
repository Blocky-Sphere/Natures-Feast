package net.blockysphere.naturesfeast.forge;

import dev.architectury.platform.forge.EventBuses;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.blockysphere.naturesfeast.block.ModBlocks;
import net.blockysphere.naturesfeast.blockentities.ModBlockEntities;
import net.blockysphere.naturesfeast.renderer.NaturesFeastBannerRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.blockysphere.naturesfeast.NaturesFeast;

@Mod(NaturesFeast.MOD_ID)
public final class NaturesFeastForge {
    public NaturesFeastForge(FMLJavaModLoadingContext context) {

        IEventBus modEventBus = context.getModEventBus();

        EventBuses.registerModEventBus(NaturesFeast.MOD_ID, modEventBus);

        modEventBus.addListener(this::onClientSetup);

        NaturesFeast.init();
    }

    private void onClientSetup(final FMLClientSetupEvent event) {
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