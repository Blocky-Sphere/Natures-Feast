package net.blockysphere.naturesfeast.fabric.datagen;

import net.blockysphere.naturesfeast.block.ModBlocks;
import net.blockysphere.naturesfeast.effect.ModEffects;
import net.blockysphere.naturesfeast.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModZhCnLangProvider extends FabricLanguageProvider {
    public ModZhCnLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "zh_cn");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {

        // Items & Ingredients
        translationBuilder.add(ModItems.BLACK_PEPPER.get(), "黑胡椒");
        translationBuilder.add(ModItems.DRIED_BLACK_PEPPER.get(), "风干黑胡椒");
        translationBuilder.add(ModItems.BLACK_PEPPER_POWDER.get(), "黑胡椒粉");
        translationBuilder.add(ModItems.CHILI_PEPPER.get(), "辣椒");
        translationBuilder.add(ModItems.CHILI_PEPPER_SEEDS.get(), "辣椒种子");
        translationBuilder.add(ModItems.GARLIC.get(), "大蒜");
        translationBuilder.add(ModItems.LEMON.get(), "柠檬");
        translationBuilder.add(ModItems.CAJUN_POWDER.get(), "肯瓊粉");

        // Meat
        translationBuilder.add(ModItems.ALLIGATOR_LEG.get(), "鳄鱼腿");
        translationBuilder.add(ModItems.ALLIGATOR_TAIL.get(), "鳄鱼尾巴");
        translationBuilder.add(ModItems.BEAR_MEAT.get(), "熊肉");
        translationBuilder.add(ModItems.COOKED_BEAR_MEAT.get(), "熟熊肉");
        translationBuilder.add(ModItems.SNAIL.get(), "蜗牛");
        translationBuilder.add(ModItems.SNAKE.get(), "蛇");
        translationBuilder.add(ModItems.COOKED_SNAKE.get(), "烤蛇肉");
        translationBuilder.add(ModItems.HORSE_MEAT.get(), "马肉");
        translationBuilder.add(ModItems.COOKED_HORSE_MEAT.get(), "熟马肉");

        // Foods
        translationBuilder.add(ModBlocks.ROAST_BEAR_STEAK_PLACED.get(), "烤熊排");
        translationBuilder.add(ModBlocks.ESCARGOTS_SNAILS_PLACED.get(), "法式焗蜗牛");
        translationBuilder.add(ModItems.ALLIGATOR_SAUCE_PIQUANTE.get(), "香辣鳄鱼酱");
        translationBuilder.add(ModItems.VENISON_STEW.get(), "炖鹿肉");
        translationBuilder.add(ModBlocks.DUCK_SALAD_PLACED.get(), "鸭肉沙拉");
        translationBuilder.add(ModBlocks.MARINATED_DUCK_BREAST_PLACED.get(), "五香腌鸭胸肉");
        translationBuilder.add(ModBlocks.GLOWING_PASTA_PLACED.get(), "发光意面");
        translationBuilder.add(ModBlocks.CAJUN_FRIED_ALLIGATOR_PLACED.get(), "肯瓊炸鳄鱼");
        translationBuilder.add(ModBlocks.HORSE_FILLET_PLACED.get(), "意式马里脊");
        translationBuilder.add(ModItems.SPICY_FRIED_SNAKE.get(), "辣味炸蛇肉");
        translationBuilder.add(ModItems.DUCK_CASSOULET.get(), "法式白豆炖鸭肉");
        translationBuilder.add(ModBlocks.WHOLE_BAKED_SEA_BASS_PLACED.get(), "整只烤鲈鱼");
        translationBuilder.add(ModItems.LEMONADE.get(), "柠檬水");

        // Blocks
        translationBuilder.add(ModBlocks.WILD_CHILI_PEPPERS.get(), "野生辣椒");
        translationBuilder.add(ModBlocks.WILD_GARLICS.get(), "野生大蒜");
        translationBuilder.add(ModBlocks.BIRD_CAGE.get(), "鸟笼");
        translationBuilder.add(ModBlocks.NATURES_FEAST_BANNER.get(), "全物品收集者旗帜: §2自然盛宴");

        // Others
        translationBuilder.add("itemgroup.natures_feast_group", "[Let's Do]自然盛宴");
        translationBuilder.add("tooltip.naturesfeast.placeables","可放置地上");
        translationBuilder.add("tooltip.naturesfeast.empty"," ");
        translationBuilder.add("tooltip.naturesfeast.bird_cage.captured","装着: %s");

        // Entities
        translationBuilder.add("entity.minecraft.villager.naturesfeast.hunter", "猎人");
        translationBuilder.add("entity.minecraft.villager.hunter", "猎人");

        // Effects
        translationBuilder.add(ModEffects.SPICY.get(), "爆辣");
    }
}
