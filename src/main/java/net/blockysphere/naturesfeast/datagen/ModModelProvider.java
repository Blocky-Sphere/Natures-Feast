package net.blockysphere.naturesfeast.datagen;

import net.blockysphere.naturesfeast.NaturesFeast;
import net.blockysphere.naturesfeast.block.ModBlocks;
import net.blockysphere.naturesfeast.block.custom.ChiliPepperCropBlock;
import net.blockysphere.naturesfeast.block.custom.EscargotsSnailsBlock;
import net.blockysphere.naturesfeast.block.custom.GarlicCropBlock;
import net.blockysphere.naturesfeast.item.ModItems;
import net.blockysphere.naturesfeast.block.custom.RoastBearSteakBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {

        generator.registerCrop(ModBlocks.GARLIC_CROP, GarlicCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        generator.registerTintableCrossBlockStateWithStages(ModBlocks.CHILI_PEPPER_CROP,
                BlockStateModelGenerator.TintType.NOT_TINTED, ChiliPepperCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        generator.registerSimpleState(ModBlocks.BIRD_CAGE);

        // Roast Bear Meat
        var roastBearVariantMap = BlockStateVariantMap.create(RoastBearSteakBlock.BITES, HorizontalFacingBlock.FACING)
                .register((bites, facing) -> {
                    int yRot = switch (facing) {
                        case NORTH -> 0;
                        case SOUTH -> 180;
                        case EAST  -> 90;
                        case WEST  -> 270;
                        default    -> 0;
                    };
                    VariantSettings.Rotation rot = switch (yRot) {
                        case 0   -> VariantSettings.Rotation.R0;
                        case 90  -> VariantSettings.Rotation.R90;
                        case 180 -> VariantSettings.Rotation.R180;
                        case 270 -> VariantSettings.Rotation.R270;
                        default  -> VariantSettings.Rotation.R0;
                    };
                    String roastBearModelName = "block/roast_bear_steak_placed" + bites;
                    Identifier modelId = Identifier.of(NaturesFeast.MOD_ID, roastBearModelName);
                    return BlockStateVariant.create()
                            .put(VariantSettings.MODEL, modelId)
                            .put(VariantSettings.Y, rot);
                });
        generator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(ModBlocks.ROAST_BEAR_STEAK_PLACED)
                        .coordinate(roastBearVariantMap)
        );

        // Escargots Snails
        var escargotsSnailsVariantMap = BlockStateVariantMap.create(EscargotsSnailsBlock.BITES, HorizontalFacingBlock.FACING)
                .register((bites, facing) -> {
                    int yRot = switch (facing) {
                        case NORTH -> 0;
                        case SOUTH -> 180;
                        case EAST  -> 90;
                        case WEST  -> 270;
                        default    -> 0;
                    };
                    VariantSettings.Rotation rot = switch (yRot) {
                        case 0   -> VariantSettings.Rotation.R0;
                        case 90  -> VariantSettings.Rotation.R90;
                        case 180 -> VariantSettings.Rotation.R180;
                        case 270 -> VariantSettings.Rotation.R270;
                        default  -> VariantSettings.Rotation.R0;
                    };
                    String escargotsSnailsModelName = "block/escargots_snails_placed" + bites;
                    Identifier modelId = Identifier.of(NaturesFeast.MOD_ID, escargotsSnailsModelName);
                    return BlockStateVariant.create()
                            .put(VariantSettings.MODEL, modelId)
                            .put(VariantSettings.Y, rot);
                });
        generator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(ModBlocks.ESCARGOTS_SNAILS_PLACED)
                        .coordinate(escargotsSnailsVariantMap)
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        generator.register(ModItems.BLACK_PEPPER, Models.GENERATED);
        generator.register(ModItems.CHILI_PEPPER, Models.GENERATED);
        generator.register(ModItems.BLACK_PEPPER_POWDER, Models.GENERATED);
        generator.register(ModItems.DRIED_BLACK_PEPPER, Models.GENERATED);
        generator.register(ModItems.ALLIGATOR_LEG, Models.GENERATED);
        generator.register(ModItems.ALLIGATOR_TAIL, Models.GENERATED);
        generator.register(ModItems.BEAR_MEAT, Models.GENERATED);
        generator.register(ModItems.ROAST_BEAR_STEAK, Models.GENERATED);
        generator.register(ModItems.CAJUN_POWDER, Models.GENERATED);
        generator.register(ModItems.SNAIL, Models.GENERATED);
        generator.register(ModItems.ESCARGOTS_SNAILS, Models.GENERATED);
        generator.register(ModItems.COOKED_BEAR_MEAT, Models.GENERATED);
        generator.register(ModItems.BEAR_CLAW, Models.GENERATED);
        generator.register(ModItems.CAJUN_SWAMP_CHICKEN, Models.GENERATED);
    }
}