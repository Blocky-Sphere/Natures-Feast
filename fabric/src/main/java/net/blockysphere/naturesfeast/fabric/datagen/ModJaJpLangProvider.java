package net.blockysphere.naturesfeast.fabric.datagen;

import net.blockysphere.naturesfeast.block.ModBlocks;
import net.blockysphere.naturesfeast.effect.ModEffects;
import net.blockysphere.naturesfeast.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModJaJpLangProvider extends FabricLanguageProvider {
    public ModJaJpLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "ja_jp");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {

        // Items & Ingredients
        translationBuilder.add(ModItems.BLACK_PEPPER.get(), "黒こしょう");
        translationBuilder.add(ModItems.DRIED_BLACK_PEPPER.get(), "乾燥した黒こしょう");
        translationBuilder.add(ModItems.BLACK_PEPPER_POWDER.get(), "ブラックペッパー");
        translationBuilder.add(ModItems.CHILI_PEPPER.get(), "唐辛子");
        translationBuilder.add(ModItems.CHILI_PEPPER_SEEDS.get(), "唐辛子の種");
        translationBuilder.add(ModItems.GARLIC.get(), "ニンニク");
        translationBuilder.add(ModItems.LEMON.get(), "レモン");
        translationBuilder.add(ModItems.CAJUN_POWDER.get(), "ケイジャンスパイス");

        // Meat
        translationBuilder.add(ModItems.ALLIGATOR_LEG.get(), "アリゲーターの足");
        translationBuilder.add(ModItems.ALLIGATOR_TAIL.get(), "アリゲーターの尾");
        translationBuilder.add(ModItems.BEAR_MEAT.get(), "生の熊肉");
        translationBuilder.add(ModItems.COOKED_BEAR_MEAT.get(), "焼き熊肉");
        translationBuilder.add(ModItems.SNAIL.get(), "カタツムリ");
        translationBuilder.add(ModItems.SNAKE.get(), "生のヘビ");
        translationBuilder.add(ModItems.COOKED_SNAKE.get(), "焼きヘビ");
        translationBuilder.add(ModItems.HORSE_MEAT.get(), "馬肉");
        translationBuilder.add(ModItems.COOKED_HORSE_MEAT.get(), "焼き馬肉");

        // Foods
        translationBuilder.add(ModBlocks.ROAST_BEAR_STEAK_PLACED.get(), "熊肉のステーキ");
        translationBuilder.add(ModBlocks.ESCARGOTS_SNAILS_PLACED.get(), "エスカルゴカタツムリ");
        translationBuilder.add(ModItems.ALLIGATOR_SAUCE_PIQUANTE.get(), "アリゲーター・ソース・ピカント");
        translationBuilder.add(ModItems.VENISON_STEW.get(), "鹿肉のシチュー");
        translationBuilder.add(ModBlocks.DUCK_SALAD_PLACED.get(), "鴨肉サラダ");
        translationBuilder.add(ModBlocks.MARINATED_DUCK_BREAST_PLACED.get(), "鴨胸肉のマリネ");
        translationBuilder.add(ModBlocks.GLOWING_PASTA_PLACED.get(), "ツヤツヤのパスタ");
        translationBuilder.add(ModBlocks.CAJUN_FRIED_ALLIGATOR_PLACED.get(), "ケイジャン風アリゲーターフライ");
        translationBuilder.add(ModBlocks.HORSE_FILLET_PLACED.get(), "馬フィレ");
        translationBuilder.add(ModItems.SPICY_FRIED_SNAKE.get(), "ヘビの辛い唐揚げ");
        translationBuilder.add(ModItems.DUCK_CASSOULET.get(), "鴨のカスレ");
        translationBuilder.add(ModBlocks.WHOLE_BAKED_SEA_BASS_PLACED.get(), "丸ごと焼きバス");
        translationBuilder.add(ModItems.LEMONADE.get(), "レモネード");

        // Blocks
        translationBuilder.add(ModBlocks.WILD_CHILI_PEPPERS.get(), "野生唐辛子");
        translationBuilder.add(ModBlocks.WILD_GARLICS.get(), "野生ニンニク");
        translationBuilder.add(ModBlocks.BIRD_CAGE.get(), "鳥かご");
        translationBuilder.add(ModBlocks.NATURES_FEAST_BANNER.get(), "完璧主義者の旗: §2Nature's Feast");

        // Others
        translationBuilder.add("itemgroup.natures_feast_group", "[Let's Do] Natures Feast");
        translationBuilder.add("tooltip.naturesfeast.placeables","設置可能");
        translationBuilder.add("tooltip.naturesfeast.empty"," ");
        translationBuilder.add("tooltip.naturesfeast.bird_cage.captured","中身: %s");

        // Entities
        translationBuilder.add("entity.minecraft.villager.naturesfeast.hunter", "ハンター");
        translationBuilder.add("entity.minecraft.villager.hunter", "ハンター");

        // Effects
        translationBuilder.add(ModEffects.SPICY.get(), "激辛");
    }
}
