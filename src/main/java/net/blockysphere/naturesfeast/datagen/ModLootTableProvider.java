package net.blockysphere.naturesfeast.datagen;

import net.blockysphere.naturesfeast.block.ModBlocks;
import net.blockysphere.naturesfeast.block.custom.ChiliPepperCropBlock;
import net.blockysphere.naturesfeast.block.custom.GarlicCropBlock;
import net.blockysphere.naturesfeast.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.InvertedLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        // Chili Pepper Crop Drop
        BlockStatePropertyLootCondition.Builder ChiliMatureCondition = BlockStatePropertyLootCondition.builder(ModBlocks.CHILI_PEPPER_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(ChiliPepperCropBlock.AGE, 5));
        addDrop(ModBlocks.CHILI_PEPPER_CROP, block -> applyExplosionDecay(block, LootTable.builder()
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1)).with(ItemEntry.builder(ModItems.CHILI_PEPPER_SEEDS))
                                .conditionally(ChiliMatureCondition.invert()).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f))))
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1)).with(ItemEntry.builder(ModItems.CHILI_PEPPER))
                                .conditionally(ChiliMatureCondition).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 3.0f))))
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1)).with(ItemEntry.builder(ModItems.CHILI_PEPPER_SEEDS))
                                .conditionally(ChiliMatureCondition).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f))))));

        // Garlic Crop Drop
        BlockStatePropertyLootCondition.Builder garlic_crop_builder = BlockStatePropertyLootCondition.builder(ModBlocks.GARLIC_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(GarlicCropBlock.AGE, 7));
        addDrop(ModBlocks.GARLIC_CROP, LootTable.builder()
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.GARLIC)
                                .apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286F, 3))
                        )
                        .conditionally(garlic_crop_builder)
                )
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.GARLIC))
                        .conditionally(InvertedLootCondition.builder(garlic_crop_builder))
                )
        );
    }
}