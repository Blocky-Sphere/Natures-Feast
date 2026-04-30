package net.blockysphere.naturesfeast.fabric.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.blockysphere.naturesfeast.NaturesFeast;
import net.blockysphere.naturesfeast.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BIRD_CAGE.get())
                .pattern("I")
                .pattern("G")
                .pattern("P")
                .define('I', Items.IRON_INGOT)
                .define('G', Items.GLASS)
                .define('P', ItemTags.PLANKS)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHILI_PEPPER_SEEDS.get(), 3)
                .requires(ModItems.CHILI_PEPPER.get())
                .unlockedBy(getHasName(ModItems.CHILI_PEPPER.get()), has(ModItems.CHILI_PEPPER.get()))
                .save(exporter);
        registerCookingRecipes(exporter, "bear_meat", ModItems.BEAR_MEAT.get(), ModItems.COOKED_BEAR_MEAT.get());
        registerCookingRecipes(exporter, "snake", ModItems.SNAKE.get(), ModItems.COOKED_SNAKE.get());
        registerCookingRecipes(exporter, "horse_meat", ModItems.HORSE_MEAT.get(), ModItems.COOKED_HORSE_MEAT.get());

        customCustomRecipe(exporter, "farm_and_charm:drying", "dried_black_pepper", json -> {
            json.add("ingredient", createItemIngredient("naturesfeast:black_pepper"));
            json.addProperty("recipe_type", "MEAT");
            json.add("result", createResult("naturesfeast:dried_black_pepper", 1));
        });
        customCustomRecipe(exporter, "farm_and_charm:mixing", "cajun_powder", json -> {
            JsonArray ingredients = new JsonArray();
            ingredients.add(createTagIngredient("farm_and_charm:onion"));
            ingredients.add(createItemIngredient("naturesfeast:black_pepper_powder"));
            ingredients.add(createItemIngredient("naturesfeast:chili_pepper"));
            ingredients.add(createItemIngredient("naturesfeast:garlic"));
            json.add("ingredients", ingredients);
            json.add("result", createResult("naturesfeast:cajun_powder", 4));
        });
    }

    // Helper Methods
    private void registerCookingRecipes(Consumer<FinishedRecipe> exporter, String name, net.minecraft.world.level.ItemLike input, net.minecraft.world.level.ItemLike output) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.FOOD, output, 0.35f, 200)
                .unlockedBy(getHasName(input), has(input)).save(exporter, new ResourceLocation(NaturesFeast.MOD_ID, name + "_smelting"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), RecipeCategory.FOOD, output, 0.35f, 100)
                .unlockedBy(getHasName(input), has(input)).save(exporter, new ResourceLocation(NaturesFeast.MOD_ID, name + "_smoking"));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), RecipeCategory.FOOD, output, 0.35f, 600)
                .unlockedBy(getHasName(input), has(input)).save(exporter, new ResourceLocation(NaturesFeast.MOD_ID, name + "_campfire"));
    }
    private void customCustomRecipe(Consumer<FinishedRecipe> exporter, String type, String name, Consumer<JsonObject> jsonConfig) {
        exporter.accept(new FinishedRecipe() {
            @Override
            public void serializeRecipeData(JsonObject json) {
                json.addProperty("type", type);
                jsonConfig.accept(json);
            }

            @Override
            public ResourceLocation getId() {
                return new ResourceLocation(NaturesFeast.MOD_ID, name);
            }

            @Override
            public RecipeSerializer<?> getType() {
                return RecipeSerializer.SHAPELESS_RECIPE;
            }

            @Override
            public JsonObject serializeAdvancement() { return null; }

            @Override
            public ResourceLocation getAdvancementId() { return null; }
        });
    }

    private JsonObject createItemIngredient(String itemRes) {
        JsonObject obj = new JsonObject();
        obj.addProperty("item", itemRes);
        return obj;
    }
    private JsonObject createTagIngredient(String tagRes) {
        JsonObject obj = new JsonObject();
        obj.addProperty("tag", tagRes);
        return obj;
    }
    private JsonObject createResult(String itemRes, int count) {
        JsonObject obj = new JsonObject();
        obj.addProperty("item", itemRes);
        obj.addProperty("count", count);
        return obj;
    }
}