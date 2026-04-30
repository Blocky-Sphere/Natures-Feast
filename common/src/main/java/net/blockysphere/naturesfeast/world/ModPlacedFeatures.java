package net.blockysphere.naturesfeast.world;

import net.blockysphere.naturesfeast.NaturesFeast;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> WILD_CHILI_PEPPERS_PLACED_KEY = registerKey("wild_chili_peppers_placed");
    public static final ResourceKey<PlacedFeature> WILD_GARLICS_PLACED_KEY = registerKey("wild_garlics_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, WILD_CHILI_PEPPERS_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.WILD_CHILI_PEPPERS_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(18),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                )
        );
        register(context, WILD_GARLICS_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.WILD_GARLICS_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(24),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                )
        );
    }
    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(NaturesFeast.MOD_ID, name));
    }
    private static void register(BootstapContext<PlacedFeature> context,
                                 ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}