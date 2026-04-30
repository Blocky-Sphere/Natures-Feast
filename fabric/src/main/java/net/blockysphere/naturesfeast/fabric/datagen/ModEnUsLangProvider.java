package net.blockysphere.naturesfeast.fabric.datagen;

import net.blockysphere.naturesfeast.block.ModBlocks;
import net.blockysphere.naturesfeast.effect.ModEffects;
import net.blockysphere.naturesfeast.item.ModItems;
import net.blockysphere.naturesfeast.util.ModVillagers;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModEnUsLangProvider extends FabricLanguageProvider {
    public ModEnUsLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }
    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {

        // Items & Ingredients
        translationBuilder.add(ModItems.BLACK_PEPPER.get(), "Black Pepper");
        translationBuilder.add(ModItems.DRIED_BLACK_PEPPER.get(), "Dried Black Pepper");
        translationBuilder.add(ModItems.BLACK_PEPPER_POWDER.get(), "Black Pepper Powder");
        translationBuilder.add(ModItems.CHILI_PEPPER.get(), "Chili Pepper");
        translationBuilder.add(ModItems.CHILI_PEPPER_SEEDS.get(), "Chili Pepper Seeds");
        translationBuilder.add(ModItems.GARLIC.get(), "Garlic");
        translationBuilder.add(ModItems.LEMON.get(), "Lemon");
        translationBuilder.add(ModItems.CAJUN_POWDER.get(), "Cajun Powder");

        // Meat
        translationBuilder.add(ModItems.ALLIGATOR_LEG.get(), "Alligator Leg");
        translationBuilder.add(ModItems.ALLIGATOR_TAIL.get(), "Alligator Tail");
        translationBuilder.add(ModItems.BEAR_MEAT.get(), "Bear Meat");
        translationBuilder.add(ModItems.COOKED_BEAR_MEAT.get(), "Cooked Bear Meat");
        translationBuilder.add(ModItems.SNAIL.get(), "Snail");
        translationBuilder.add(ModItems.SNAKE.get(), "Snake");
        translationBuilder.add(ModItems.COOKED_SNAKE.get(), "Cooked Snake");
        translationBuilder.add(ModItems.HORSE_MEAT.get(), "Horse Meat");
        translationBuilder.add(ModItems.COOKED_HORSE_MEAT.get(), "Cooked Horse Meat");

        // Foods
        translationBuilder.add(ModBlocks.ROAST_BEAR_STEAK_PLACED.get(), "Roast Bear Steak");
        translationBuilder.add(ModBlocks.ESCARGOTS_SNAILS_PLACED.get(), "Escargots Snails");
        translationBuilder.add(ModItems.ALLIGATOR_SAUCE_PIQUANTE.get(), "Alligator Sauce Piquante");
        translationBuilder.add(ModItems.VENISON_STEW.get(), "Venison Stew");
        translationBuilder.add(ModBlocks.DUCK_SALAD_PLACED.get(), "Duck Salad");
        translationBuilder.add(ModBlocks.MARINATED_DUCK_BREAST_PLACED.get(), "Marinated Duck Breast");
        translationBuilder.add(ModBlocks.GLOWING_PASTA_PLACED.get(), "Glowing Pasta");
        translationBuilder.add(ModBlocks.CAJUN_FRIED_ALLIGATOR_PLACED.get(), "Cajun Fried Alligator");
        translationBuilder.add(ModBlocks.HORSE_FILLET_PLACED.get(), "Horse Fillet");
        translationBuilder.add(ModItems.SPICY_FRIED_SNAKE.get(), "Spicy Fried Snake");
        translationBuilder.add(ModItems.DUCK_CASSOULET.get(), "Duck Cassoulet");
        translationBuilder.add(ModBlocks.WHOLE_BAKED_SEA_BASS_PLACED.get(), "Whole Baked Sea Bass");
        translationBuilder.add(ModItems.LEMONADE.get(), "Lemonade");

        // Blocks
        translationBuilder.add(ModBlocks.WILD_CHILI_PEPPERS.get(), "Wild Chili Peppers");
        translationBuilder.add(ModBlocks.WILD_GARLICS.get(), "Wild Garlics");
        translationBuilder.add(ModBlocks.BIRD_CAGE.get(), "Bird Cage");
        translationBuilder.add(ModBlocks.NATURES_FEAST_BANNER.get(), "Completionist Banner: §2Nature's Feast");

        // Others
        translationBuilder.add("itemgroup.natures_feast_group", "[Let's Do] Nature's Feast");
        translationBuilder.add("tooltip.naturesfeast.placeables", "Can be Placed");
        translationBuilder.add("tooltip.naturesfeast.empty", " ");
        translationBuilder.add("tooltip.naturesfeast.bird_cage.captured", "Contains: %s");

        // Entities
        translationBuilder.add("entity.minecraft.villager.naturesfeast.hunter", "Hunter");
        translationBuilder.add("entity.minecraft.villager.hunter", "Hunter");

        // Effects
        translationBuilder.add(ModEffects.SPICY.get(), "Spicy");
    }
}