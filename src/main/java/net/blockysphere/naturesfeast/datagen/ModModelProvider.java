package net.blockysphere.naturesfeast.datagen;

import net.blockysphere.naturesfeast.block.ModBlocks;
import net.blockysphere.naturesfeast.block.custom.ChiliPepperCropBlock;
import net.blockysphere.naturesfeast.block.custom.GarlicCropBlock;
import net.blockysphere.naturesfeast.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        generator.registerCrop(ModBlocks.GARLIC_CROP, GarlicCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        generator.registerTintableCrossBlockStateWithStages(ModBlocks.CHILI_PEPPER_CROP,
                BlockStateModelGenerator.TintType.NOT_TINTED, ChiliPepperCropBlock.AGE, 0, 1, 2, 3, 4, 5);
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
        generator.register(ModItems.ROAST_BEAR_MEAT, Models.GENERATED);
        generator.register(ModItems.CAJUN_POWDER, Models.GENERATED);
        generator.register(ModItems.SNAIL, Models.GENERATED);
        generator.register(ModItems.ESCARGOTS_SNAILS, Models.GENERATED);
        generator.register(ModItems.COOKED_BEAR_MEAT, Models.GENERATED);
    }
}