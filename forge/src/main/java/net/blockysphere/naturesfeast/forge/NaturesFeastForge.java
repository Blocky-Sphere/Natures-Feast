package net.blockysphere.naturesfeast.forge;

import dev.architectury.platform.forge.EventBuses;
import net.blockysphere.naturesfeast.forge.client.NaturesFeastForgeClient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.blockysphere.naturesfeast.NaturesFeast;

@Mod(NaturesFeast.MOD_ID)
public final class NaturesFeastForge {
    public NaturesFeastForge(FMLJavaModLoadingContext context) {

        IEventBus modEventBus = context.getModEventBus();

        EventBuses.registerModEventBus(NaturesFeast.MOD_ID, modEventBus);

        modEventBus.addListener(NaturesFeastForgeClient::onInitializeClient);

        NaturesFeast.init();
    }
}