package net.blockysphere.naturesfeast.item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent GARLIC = new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).build();
    public static final FoodComponent CHILI_PEPPER = new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build();
    public static final FoodComponent ALLIGATOR_LEG = new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).meat().build();
    public static final FoodComponent ALLIGATOR_TAIL = new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).meat().build();
    public static final FoodComponent BEAR_MEAT = new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).meat().build();
    public static final FoodComponent COOKED_BEAR_MEAT = new FoodComponent.Builder().hunger(8).saturationModifier(0.8f).meat().build();
    public static final FoodComponent ROAST_BEAR_STEAK = new FoodComponent.Builder().hunger(10).saturationModifier(0.85f).alwaysEdible().build();
    public static final FoodComponent ESCARGOTS_SNAILS = new FoodComponent.Builder().hunger(8).saturationModifier(0.8f).alwaysEdible().build();
    public static final FoodComponent CAJUN_SWAMP_CHICKEN = new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).alwaysEdible().build();
}
