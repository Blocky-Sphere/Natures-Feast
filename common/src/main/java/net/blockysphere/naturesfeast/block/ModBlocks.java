package net.blockysphere.naturesfeast.block;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.blockysphere.naturesfeast.NaturesFeast;
import net.blockysphere.naturesfeast.block.custom.*;
import net.blockysphere.naturesfeast.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class ModBlocks {
    public static final Registrar<Block> BLOCKS =
            RegistrarManager.get(NaturesFeast.MOD_ID).get(Registries.BLOCK);

    public static final RegistrySupplier<Block> GARLIC_CROP = registerBlockWithoutItem("garlic_crop",
            () -> new GarlicCropBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS)));

    public static final RegistrySupplier<Block> CHILI_PEPPER_CROP = registerBlockWithoutItem("chili_pepper_crop",
            () -> new ChiliPepperCropBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS)));

    public static final RegistrySupplier<Block> PIPER_NIGRUM = registerBlockWithoutItem("piper_nigrum",
            () -> new PiperNigrumBlock(BlockBehaviour.Properties.copy(Blocks.VINE)));

    public static final RegistrySupplier<Block> ROAST_BEAR_STEAK_PLACED = registerBlockWithoutItem("roast_bear_steak_placed",
            () -> new RoastBearSteakBlock(foodBlockProps(MapColor.COLOR_BROWN)));

    public static final RegistrySupplier<Block> ESCARGOTS_SNAILS_PLACED = registerBlockWithoutItem("escargots_snails_placed",
            () -> new EscargotsSnailsBlock(foodBlockProps(MapColor.COLOR_GRAY)));

    public static final RegistrySupplier<Block> CAJUN_FRIED_ALLIGATOR_PLACED = registerBlockWithoutItem("cajun_fried_alligator_placed",
            () -> new CajunFriedAlligatorBlock(foodBlockProps(MapColor.COLOR_ORANGE)));

    public static final RegistrySupplier<Block> BIRD_CAGE = registerBlock("bird_cage_block",
            () -> new BirdCageBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN)
                    .strength(0.85f, 3.0f).sound(SoundType.NETHERITE_BLOCK).pushReaction(PushReaction.DESTROY)));

    public static final RegistrySupplier<Block> NATURES_FEAST_BANNER = registerBlockWithoutItem("natures_feast_banner",
            () -> new NaturesFeastBannerBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD).noCollission().noOcclusion()));

    public static final RegistrySupplier<Block> NATURES_FEAST_WALL_BANNER = registerBlockWithoutItem("natures_feast_wall_banner",
            () -> new NaturesFeastWallBannerBlock(BlockBehaviour.Properties.copy(NATURES_FEAST_BANNER.get())));

    public static final RegistrySupplier<Block> WHOLE_BAKED_SEA_BASS_PLACED = registerBlockWithoutItem("whole_baked_sea_bass_placed",
            () -> new WholeBakedSeaBassBlock(BlockBehaviour.Properties.copy(ROAST_BEAR_STEAK_PLACED.get())));

    public static final RegistrySupplier<Block> HORSE_FILLET_PLACED = registerBlockWithoutItem("horse_fillet_placed",
            () -> new HorseFilletBlock(BlockBehaviour.Properties.copy(ESCARGOTS_SNAILS_PLACED.get())));

    public static final RegistrySupplier<Block> GLOWING_PASTA_PLACED = registerBlockWithoutItem("glowing_pasta_placed",
            () -> new GlowingPastaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN)
                    .strength(0.5f).sound(SoundType.WOOL).lightLevel(state -> 5).noOcclusion()));

    public static final RegistrySupplier<Block> DUCK_SALAD_PLACED = registerBlockWithoutItem("duck_salad_placed",
            () -> new DuckSaladBlock(foodBlockProps(MapColor.COLOR_LIGHT_GREEN)));

    public static final RegistrySupplier<Block> MARINATED_DUCK_BREAST_PLACED = registerBlockWithoutItem("marinated_duck_breast_placed",
            () -> new MarinatedDuckBreastBlock(foodBlockProps(MapColor.TERRACOTTA_WHITE)));

    public static final RegistrySupplier<Block> WILD_CHILI_PEPPERS = registerBlock("wild_chili_peppers",
            () -> new WildCropBlock(BlockBehaviour.Properties.copy(Blocks.POPPY)));

    public static final RegistrySupplier<Block> WILD_GARLICS = registerBlock("wild_garlics",
            () -> new WildCropBlock(BlockBehaviour.Properties.copy(Blocks.POPPY)));

    // Helper Methods
    private static BlockBehaviour.Properties foodBlockProps(MapColor color) {
        return BlockBehaviour.Properties.of().mapColor(color).strength(0.5f).sound(SoundType.WOOL).noOcclusion();
    }
    private static <T extends Block> RegistrySupplier<T> registerBlock(String name, Supplier<T> block) {
        RegistrySupplier<T> toReturn = BLOCKS.register(new ResourceLocation(NaturesFeast.MOD_ID, name), block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistrySupplier<T> block) {
        ModItems.ITEMS.register(new ResourceLocation(NaturesFeast.MOD_ID, name),
                () -> new BlockItem(block.get(), new Item.Properties()));
    }
    private static <T extends Block> RegistrySupplier<T> registerBlockWithoutItem(String name, Supplier<T> block) {
        return BLOCKS.register(new ResourceLocation(NaturesFeast.MOD_ID, name), block);
    }
    public static void registerModBlocks() {
        NaturesFeast.LOGGER.info("Registering ModBlocks for " + NaturesFeast.MOD_ID);
    }
}
