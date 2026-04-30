package net.blockysphere.naturesfeast.world.gen;

import dev.architectury.registry.level.biome.BiomeModifications;
import net.blockysphere.naturesfeast.world.ModPlacedFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

import java.util.Set;

public class ModWildCropGeneration {
    public static void generateWildCrops() {
        Set<ResourceLocation> chiliBiomes = Set.of(
                Biomes.JUNGLE.location(), Biomes.SPARSE_JUNGLE.location(), Biomes.FOREST.location(),
                Biomes.BIRCH_FOREST.location(), Biomes.OLD_GROWTH_BIRCH_FOREST.location(),
                Biomes.WOODED_BADLANDS.location(), Biomes.FLOWER_FOREST.location()
        );

        BiomeModifications.addProperties(
                context -> context.getKey().map(chiliBiomes::contains).orElse(false),
                (context, mutable) -> {
                    mutable.getGenerationProperties().addFeature(
                            GenerationStep.Decoration.VEGETAL_DECORATION,
                            ModPlacedFeatures.WILD_CHILI_PEPPERS_PLACED_KEY
                    );
                }
        );
        Set<ResourceLocation> garlicBiomes = Set.of(
                Biomes.DARK_FOREST.location(), Biomes.FLOWER_FOREST.location(), Biomes.OLD_GROWTH_BIRCH_FOREST.location()
        );
        BiomeModifications.addProperties(
                context -> context.getKey().map(garlicBiomes::contains).orElse(false),
                (context, mutable) -> {
                    mutable.getGenerationProperties().addFeature(
                            GenerationStep.Decoration.VEGETAL_DECORATION,
                            ModPlacedFeatures.WILD_GARLICS_PLACED_KEY
                    );
                }
        );
    }
}