package net.blockysphere.naturesfeast.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodComponents {
    public static final FoodProperties GARLIC = new FoodProperties.Builder().fast().nutrition(2).saturationMod(0.1f).build();

    public static final FoodProperties CHILI_PEPPER = new FoodProperties.Builder().alwaysEat().nutrition(2).saturationMod(0.2f).build();
    public static final FoodProperties ALLIGATOR_LEG = new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).meat().build();
    public static final FoodProperties ALLIGATOR_TAIL = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).meat().build();
    public static final FoodProperties BEAR_MEAT = new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).meat().build();
    public static final FoodProperties HORSE_MEAT = new FoodProperties.Builder().nutrition(3).saturationMod(0.25f).meat().build();
    public static final FoodProperties COOKED_HORSE_MEAT = new FoodProperties.Builder().nutrition(7).saturationMod(0.8f).meat().build();
    public static final FoodProperties HORSE_FILLET = new FoodProperties.Builder().nutrition(8).saturationMod(0.85f).alwaysEat().build();
    public static final FoodProperties SNAKE = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).meat().build();
    public static final FoodProperties COOKED_SNAKE = new FoodProperties.Builder().nutrition(7).saturationMod(0.6f).meat().build();
    public static final FoodProperties COOKED_BEAR_MEAT = new FoodProperties.Builder().nutrition(8).saturationMod(0.8f).meat().build();
    public static final FoodProperties ROAST_BEAR_STEAK = new FoodProperties.Builder().nutrition(12).saturationMod(0.85f).alwaysEat().build();
    public static final FoodProperties VENISON_STEW = new FoodProperties.Builder().nutrition(10).saturationMod(0.6f).alwaysEat().build();
    public static final FoodProperties ESCARGOTS_SNAILS = new FoodProperties.Builder().nutrition(6).saturationMod(0.7f).alwaysEat().build();
    public static final FoodProperties ALLIGATOR_SAUCE_PIQUANTE = new FoodProperties.Builder().nutrition(10).saturationMod(0.9f).alwaysEat().build();
    public static final FoodProperties CAJUN_FRIED_ALLIGATOR = new FoodProperties.Builder().nutrition(8).saturationMod(0.8f).alwaysEat().build();
    public static final FoodProperties SPICY_FRIED_SNAKE = new FoodProperties.Builder().nutrition(9).saturationMod(0.75f).alwaysEat().build();
    public static final FoodProperties WHOLE_BAKED_SEA_BASS = new FoodProperties.Builder().nutrition(8).saturationMod(0.75f).alwaysEat().build();
    public static final FoodProperties DUCK_CASSOULET = new FoodProperties.Builder().nutrition(14).saturationMod(0.95f).alwaysEat().build();
    public static final FoodProperties DUCK_SALAD = new FoodProperties.Builder().nutrition(7).saturationMod(0.7f).alwaysEat().build();
    public static final FoodProperties MARINATED_DUCK_BREAST = new FoodProperties.Builder().nutrition(8).saturationMod(0.65f).alwaysEat().build();
    public static final FoodProperties GLOWING_PASTA = new FoodProperties.Builder().nutrition(7).saturationMod(0.5f).alwaysEat()
            .effect(new MobEffectInstance(MobEffects.GLOWING, 1800), 1.0f)
            .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1800), 1.0f).build();
    public static final FoodProperties LEMON = new FoodProperties.Builder().nutrition(2).saturationMod(0.1f)
            .effect(new MobEffectInstance(MobEffects.HUNGER, 100), 0.85f).build();
    public static final FoodProperties LEMONADE = new FoodProperties.Builder().nutrition(3).saturationMod(0.35f)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600), 1.0f).alwaysEat().build();

}
