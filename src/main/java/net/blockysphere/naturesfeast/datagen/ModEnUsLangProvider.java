package net.blockysphere.naturesfeast.datagen;

import net.blockysphere.naturesfeast.block.ModBlocks;
import net.blockysphere.naturesfeast.item.ModItems;
import net.blockysphere.naturesfeast.villager.ModVillagers;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModEnUsLangProvider extends FabricLanguageProvider {
    public ModEnUsLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {

        // Items
        translationBuilder.add(ModItems.BLACK_PEPPER, "Black Pepper");
        translationBuilder.add(ModItems.DRIED_BLACK_PEPPER, "Dried Black Pepper");
        translationBuilder.add(ModItems.BLACK_PEPPER_POWDER, "Black Pepper Powder");
        translationBuilder.add(ModItems.CHILI_PEPPER, "Chili Pepper");
        translationBuilder.add(ModItems.CHILI_PEPPER_SEEDS, "Chili Pepper Seeds");
        translationBuilder.add(ModItems.GARLIC, "Garlic");
        translationBuilder.add(ModItems.CAJUN_POWDER, "Cajun Powder");

        translationBuilder.add(ModItems.ALLIGATOR_LEG, "Alligator Leg");
        translationBuilder.add(ModItems.ALLIGATOR_TAIL, "Alligator Tail");
        translationBuilder.add(ModItems.BEAR_MEAT, "Bear Meat");
        translationBuilder.add(ModItems.COOKED_BEAR_MEAT, "Cooked Bear Meat");
        translationBuilder.add(ModItems.BEAR_CLAW, "Bear Claw");
        translationBuilder.add(ModItems.SNAIL, "Snail");

        // Blocks
        translationBuilder.add(ModBlocks.ROAST_BEAR_STEAK_PLACED, "Roast Bear Steak");
        translationBuilder.add(ModBlocks.ESCARGOTS_SNAILS_PLACED, "Escargots Snails");
        translationBuilder.add(ModItems.CAJUN_SWAMP_CHICKEN, "Cajun Swamp Chicken");
        translationBuilder.add(ModBlocks.BIRD_CAGE, "Bird Cage");

        // Others
        translationBuilder.add("itemgroup.natures_feast_group", "[Let's Do] Natures Feast");
        translationBuilder.add("tooltip.naturesfeast.placeables.tooltip","Can be Placed");
        translationBuilder.add("tooltip.naturesfeast.empty.tooltip"," ");

        // Entities
        translationBuilder.add("entity.minecraft.villager.hunter", "Hunter");
    }
}
