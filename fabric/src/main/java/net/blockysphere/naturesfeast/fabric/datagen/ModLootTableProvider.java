package net.blockysphere.naturesfeast.fabric.datagen;

import net.blockysphere.naturesfeast.block.ModBlocks;
import net.blockysphere.naturesfeast.block.custom.*;
import net.blockysphere.naturesfeast.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.NATURES_FEAST_BANNER.get());
        dropSelf(ModBlocks.NATURES_FEAST_WALL_BANNER.get());
        dropSelf(ModBlocks.BIRD_CAGE.get());

        addPlacedFoodDrop(ModBlocks.CAJUN_FRIED_ALLIGATOR_PLACED.get(), CajunFriedAlligatorBlock.BITES, ModItems.CAJUN_FRIED_ALLIGATOR.get());
        addPlacedFoodDrop(ModBlocks.ROAST_BEAR_STEAK_PLACED.get(), RoastBearSteakBlock.BITES, ModItems.ROAST_BEAR_STEAK.get());
        addPlacedFoodDrop(ModBlocks.ESCARGOTS_SNAILS_PLACED.get(), EscargotsSnailsBlock.BITES, ModItems.ESCARGOTS_SNAILS.get());
        addPlacedFoodDrop(ModBlocks.DUCK_SALAD_PLACED.get(), DuckSaladBlock.BITES, ModItems.DUCK_SALAD.get());
        addPlacedFoodDrop(ModBlocks.MARINATED_DUCK_BREAST_PLACED.get(), MarinatedDuckBreastBlock.BITES, ModItems.MARINATED_DUCK_BREAST.get());
        addPlacedFoodDrop(ModBlocks.GLOWING_PASTA_PLACED.get(), GlowingPastaBlock.BITES, ModItems.GLOWING_PASTA.get());
        addPlacedFoodDrop(ModBlocks.WHOLE_BAKED_SEA_BASS_PLACED.get(), WholeBakedSeaBassBlock.BITES, ModItems.WHOLE_BAKED_SEA_BASS.get());
        addPlacedFoodDrop(ModBlocks.HORSE_FILLET_PLACED.get(), HorseFilletBlock.BITES, ModItems.HORSE_FILLET.get());

        // Wild Crops
        add(ModBlocks.WILD_CHILI_PEPPERS.get(),
                createSilkTouchDispatchTable(ModBlocks.WILD_CHILI_PEPPERS.get(), applyExplosionDecay(ModBlocks.WILD_CHILI_PEPPERS.get(),
                        LootItem.lootTableItem(ModItems.CHILI_PEPPER_SEEDS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 4.0f))))));

        add(ModBlocks.WILD_GARLICS.get(), block -> applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(block)).when(HAS_SILK_TOUCH))
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(ModItems.GARLIC.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f))).when(HAS_NO_SILK_TOUCH))
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(Items.ALLIUM))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f))).when(HAS_NO_SILK_TOUCH))));

        // Chili Pepper Crop
        LootItemBlockStatePropertyCondition.Builder chiliMatureCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CHILI_PEPPER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ChiliPepperCropBlock.AGE, 5));
        add(ModBlocks.CHILI_PEPPER_CROP.get(), block -> applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(ModItems.CHILI_PEPPER_SEEDS.get()))
                        .when(InvertedLootItemCondition.invert(chiliMatureCondition)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 4.0f))))
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(ModItems.CHILI_PEPPER.get()))
                        .when(chiliMatureCondition).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 3.0f))))
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(ModItems.CHILI_PEPPER_SEEDS.get()))
                        .when(chiliMatureCondition).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 4.0f))))));

        // Garlic Crop
        LootItemBlockStatePropertyCondition.Builder garlicMatureCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GARLIC_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GarlicCropBlock.AGE, 7));

        add(ModBlocks.GARLIC_CROP.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.GARLIC.get())
                                .apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))
                        )
                        .when(garlicMatureCondition)
                )
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.GARLIC.get()))
                        .when(InvertedLootItemCondition.invert(garlicMatureCondition))
                )
        );

        // Piper Nigrum Drop
        LootItemBlockStatePropertyCondition.Builder piperNigrumMatureCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.PIPER_NIGRUM.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PiperNigrumBlock.AGE, 3));
        add(ModBlocks.PIPER_NIGRUM.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.BLACK_PEPPER.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 4.0f))))
                        .when(piperNigrumMatureCondition)
                )
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.BLACK_PEPPER.get()))
                        .when(InvertedLootItemCondition.invert(piperNigrumMatureCondition))
                )
        );
    }

    private void addPlacedFoodDrop(Block foodBlock, IntegerProperty bites, Item foodItem) {
        LootItemBlockStatePropertyCondition.Builder untouched = LootItemBlockStatePropertyCondition.hasBlockStateProperties(foodBlock)
                .setProperties(StatePropertiesPredicate.Builder.properties()
                        .hasProperty(bites, 0));

        add(foodBlock, block -> applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(foodItem))
                        .when(untouched)
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                )
        ));
    }
}