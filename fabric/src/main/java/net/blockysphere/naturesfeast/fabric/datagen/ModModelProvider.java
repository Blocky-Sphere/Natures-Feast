package net.blockysphere.naturesfeast.fabric.datagen;

import net.blockysphere.naturesfeast.NaturesFeast;
import net.blockysphere.naturesfeast.block.ModBlocks;
import net.blockysphere.naturesfeast.block.custom.*;
import net.blockysphere.naturesfeast.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.*;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generator) {
        generator.createCropBlock(ModBlocks.GARLIC_CROP.get(), GarlicCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        generator.createCropBlock(ModBlocks.CHILI_PEPPER_CROP.get(), ChiliPepperCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        generator.createCrossBlock(ModBlocks.WILD_GARLICS.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createCrossBlock(ModBlocks.WILD_CHILI_PEPPERS.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(ModBlocks.BIRD_CAGE.get(), new ResourceLocation(NaturesFeast.MOD_ID, "block/bird_cage")));

        // Placed Foods
        registerPlacedFood(generator, ModBlocks.ROAST_BEAR_STEAK_PLACED.get(), RoastBearSteakBlock.BITES, "roast_bear_steak");
        registerPlacedFood(generator, ModBlocks.ESCARGOTS_SNAILS_PLACED.get(), EscargotsSnailsBlock.BITES, "escargots_snails");
        registerPlacedFood(generator, ModBlocks.CAJUN_FRIED_ALLIGATOR_PLACED.get(), CajunFriedAlligatorBlock.BITES, "cajun_fried_alligator");
        registerPlacedFood(generator, ModBlocks.WHOLE_BAKED_SEA_BASS_PLACED.get(), WholeBakedSeaBassBlock.BITES, "whole_baked_sea_bass");
        registerPlacedFood(generator, ModBlocks.HORSE_FILLET_PLACED.get(), HorseFilletBlock.BITES, "horse_fillet");
        registerPlacedFood(generator, ModBlocks.GLOWING_PASTA_PLACED.get(), GlowingPastaBlock.BITES, "glowing_pasta");
        registerPlacedFood(generator, ModBlocks.DUCK_SALAD_PLACED.get(), DuckSaladBlock.BITES, "duck_salad");
        registerPlacedFood(generator, ModBlocks.MARINATED_DUCK_BREAST_PLACED.get(), MarinatedDuckBreastBlock.BITES, "marinated_duck_breast");
    }

    @Override
    public void generateItemModels(ItemModelGenerators generator) {
        generator.generateFlatItem(ModItems.BLACK_PEPPER.get(), ModelTemplates.FLAT_ITEM);
        //generator.generateFlatItem(ModItems.GARLIC.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.CHILI_PEPPER.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.BLACK_PEPPER_POWDER.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.DRIED_BLACK_PEPPER.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.ALLIGATOR_LEG.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.ALLIGATOR_TAIL.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.BEAR_MEAT.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.ROAST_BEAR_STEAK.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.CAJUN_POWDER.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.SNAIL.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.SNAKE.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.COOKED_SNAKE.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.ESCARGOTS_SNAILS.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.COOKED_BEAR_MEAT.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.ALLIGATOR_SAUCE_PIQUANTE.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.CAJUN_FRIED_ALLIGATOR.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.NATURES_FEAST_BANNER_ITEM.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.HORSE_MEAT.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.COOKED_HORSE_MEAT.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.HORSE_FILLET.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.LEMON.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.LEMONADE.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.WHOLE_BAKED_SEA_BASS.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.SPICY_FRIED_SNAKE.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.VENISON_STEW.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.GLOWING_PASTA.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.DUCK_CASSOULET.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.DUCK_SALAD.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.MARINATED_DUCK_BREAST.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModBlocks.WILD_CHILI_PEPPERS.get().asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModBlocks.WILD_GARLICS.get().asItem(), ModelTemplates.FLAT_ITEM);
    }

    private void registerPlacedFood(BlockModelGenerators generator, Block block, IntegerProperty bitesProperty, String baseModelName) {
        PropertyDispatch dispatch = PropertyDispatch.properties(bitesProperty, HorizontalDirectionalBlock.FACING)
                .generate((bites, facing) -> {
                    VariantProperties.Rotation rotation = switch (facing) {
                        case SOUTH -> VariantProperties.Rotation.R180;
                        case EAST  -> VariantProperties.Rotation.R90;
                        case WEST  -> VariantProperties.Rotation.R270;
                        default    -> VariantProperties.Rotation.R0;
                    };

                    return Variant.variant()
                            .with(VariantProperties.MODEL, new ResourceLocation(NaturesFeast.MOD_ID, "block/" + baseModelName + "_placed" + bites))
                            .with(VariantProperties.Y_ROT, rotation);
                });
        generator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
    }

}