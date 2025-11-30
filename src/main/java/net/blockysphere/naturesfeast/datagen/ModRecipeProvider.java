package net.blockysphere.naturesfeast.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.blockysphere.naturesfeast.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    // Helper Methods
    private void offerShapelessCrossMod(Consumer<RecipeJsonProvider> exporter, String resultItemId, int count, ItemConvertible input, String recipeName) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, input, count)
                .input(input)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(new Consumer<RecipeJsonProvider>() {
                    @Override
                    public void accept(RecipeJsonProvider provider) {
                        JsonObject json = ((RecipeJsonProvider) provider).toJson();
                        JsonObject result = new JsonObject();
                        result.addProperty("item", resultItemId);
                        if (count != 1) result.addProperty("count", count);
                        json.add("result", result);
                        exporter.accept(new RecipeJsonProvider() {
                            @Override
                            public void serialize(JsonObject json) { }
                            @Override
                            public Identifier getRecipeId() {return new Identifier("naturesfeast", recipeName);}
                            @Override
                            public RecipeSerializer<?> getSerializer() {return null;}
                            @Override
                            public JsonObject toJson() {return json;}
                            @Override
                            public JsonObject toAdvancementJson() { return null; }
                            @Override
                            public Identifier getAdvancementId() { return null; }
                        });
                    }
                });
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        // Chili Pepper to Seeds
        offerShapelessRecipe(exporter, ModItems.CHILI_PEPPER_SEEDS, ModItems.CHILI_PEPPER, "misc", 3);

        // Cook Bear Meat
        offerFoodCookingRecipe(exporter, "smelting", RecipeSerializer.SMELTING, 200, ModItems.BEAR_MEAT, ModItems.COOKED_BEAR_MEAT, 0.35f);
        offerFoodCookingRecipe(exporter, "smoking", RecipeSerializer.SMOKING, 100, ModItems.BEAR_MEAT, ModItems.COOKED_BEAR_MEAT, 0.35f);
        offerFoodCookingRecipe(exporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, 600, ModItems.BEAR_MEAT, ModItems.COOKED_BEAR_MEAT, 0.35f);

        // Snail Shell From Snail
        offerShapelessCrossMod(exporter, "naturalist:snail_shell", 1, ModItems.SNAIL, "snail_shell_from_snail");

        // Roast Bear Meat Recipe
        JsonObject RoastBearRecipeJson = new JsonObject();
        RoastBearRecipeJson.addProperty("type", "farm_and_charm:roaster");
        JsonArray roast_bear_meat_ingredients = new JsonArray();
        addItem(roast_bear_meat_ingredients, "naturesfeast:bear_meat");
        addItem(roast_bear_meat_ingredients, "naturesfeast:garlic");
        addTag(roast_bear_meat_ingredients, "farm_and_charm:tomato");
        addItem(roast_bear_meat_ingredients, "naturesfeast:black_pepper_powder");
        addTag(roast_bear_meat_ingredients, "farm_and_charm:butter");
        addTag(roast_bear_meat_ingredients, "vinery:red_wine");
        RoastBearRecipeJson.add("ingredients", roast_bear_meat_ingredients);
        JsonObject container1 = new JsonObject();
        container1.addProperty("item", "minecraft:bowl");
        RoastBearRecipeJson.add("container", container1);
        JsonObject roast_bear_meat_result = new JsonObject();
        roast_bear_meat_result.addProperty("item", "naturesfeast:roast_bear_meat");
        roast_bear_meat_result.addProperty("count", 1);
        RoastBearRecipeJson.add("result", roast_bear_meat_result);
        RoastBearRecipeJson.addProperty("requiresLearning", false);
        exporter.accept(new RecipeJsonProvider() {
            @Override
            public void serialize(JsonObject json) {RoastBearRecipeJson.entrySet().forEach(entry -> json.add(entry.getKey(), entry.getValue()));}
            @Override
            public Identifier getRecipeId() {
                return new Identifier("naturesfeast", "roast_bear_meat");
            }
            @Override
            public RecipeSerializer<?> getSerializer() {
                return RecipeSerializer.SHAPELESS;
            }
            @Override
            public JsonObject toAdvancementJson() { return null; }
            @Override
            public Identifier getAdvancementId() { return null; }
        });

        //Dried Black Pepper Recipe
        JsonObject dryingRecipe = new JsonObject();
        dryingRecipe.addProperty("type", "farm_and_charm:drying");
        JsonObject ingredient = new JsonObject();
        ingredient.addProperty("item", "naturesfeast:black_pepper");
        dryingRecipe.add("ingredient", ingredient);
        dryingRecipe.addProperty("recipe_type", "MEAT");
        JsonObject drying_black_pepper_result = new JsonObject();
        drying_black_pepper_result.addProperty("item", "naturesfeast:dried_black_pepper");
        drying_black_pepper_result.addProperty("count", 1);
        dryingRecipe.add("result", drying_black_pepper_result);
        exporter.accept(new RecipeJsonProvider() {
            @Override
            public void serialize(JsonObject json) {dryingRecipe.entrySet().forEach(e -> json.add(e.getKey(), e.getValue()));}
            @Override
            public Identifier getRecipeId() {return new Identifier("naturesfeast", "dried_black_pepper");}
            @Override
            public RecipeSerializer<?> getSerializer() {return RecipeSerializer.SHAPELESS;}
            @Override
            public JsonObject toAdvancementJson() { return null; }
            @Override
            public Identifier getAdvancementId() { return null; }
        });

        // Black Pepper Powder Recipe
        JsonObject mincerRecipe = new JsonObject();
        mincerRecipe.addProperty("type", "farm_and_charm:mincer");
        JsonObject black_pepper_powder_ingredient = new JsonObject();
        black_pepper_powder_ingredient.addProperty("item", "naturesfeast:dried_black_pepper");
        mincerRecipe.add("ingredient", black_pepper_powder_ingredient);
        mincerRecipe.addProperty("recipe_type", "WOOD");
        JsonObject black_pepper_powder_result = new JsonObject();
        black_pepper_powder_result.addProperty("item", "naturesfeast:black_pepper_powder");
        black_pepper_powder_result.addProperty("count", 2);
        mincerRecipe.add("result", black_pepper_powder_result);
        exporter.accept(new RecipeJsonProvider() {
            @Override
            public void serialize(JsonObject json) {mincerRecipe.entrySet().forEach(e -> json.add(e.getKey(), e.getValue()));}
            @Override
            public Identifier getRecipeId() {return new Identifier("naturesfeast", "black_pepper_powder");}
            @Override
            public RecipeSerializer<?> getSerializer() {return RecipeSerializer.SHAPELESS;}
            @Override
            public JsonObject toAdvancementJson() { return null; }
            @Override
            public Identifier getAdvancementId() { return null; }
        });

        // Cajun Powder Recipe
        JsonObject cajunRecipe = new JsonObject();
        cajunRecipe.addProperty("type", "farm_and_charm:crafting_bowl");
        JsonArray cajun_ingredients = new JsonArray();
        addTag(cajun_ingredients, "farm_and_charm:onion");
        addItem(cajun_ingredients, "naturesfeast:black_pepper_powder");
        addItem(cajun_ingredients, "naturesfeast:chili_pepper");
        addItem(cajun_ingredients, "naturesfeast:garlic");
        cajunRecipe.add("ingredients", cajun_ingredients);
        JsonObject cajun_result = new JsonObject();
        cajun_result.addProperty("item", "naturesfeast:cajun_powder");
        cajun_result.addProperty("count", 4);
        cajunRecipe.add("result", cajun_result);
        exporter.accept(new RecipeJsonProvider() {
            @Override
            public void serialize(JsonObject json) {cajunRecipe.entrySet().forEach(entry -> json.add(entry.getKey(), entry.getValue()));}
            @Override
            public Identifier getRecipeId() {return new Identifier("naturesfeast", "cajun_powder");}
            @Override
            public RecipeSerializer<?> getSerializer() {return RecipeSerializer.SHAPELESS;}
            @Override
            public JsonObject toAdvancementJson() { return null; }
            @Override
            public Identifier getAdvancementId() { return null; }
        });

        // Escargots Snails Recipe
        JsonObject EscargotsSnailsRecipe = new JsonObject();
        EscargotsSnailsRecipe.addProperty("type", "farm_and_charm:pot_cooking");
        JsonArray escargots_snails_ingredients = new JsonArray();
        addItem(escargots_snails_ingredients, "naturesfeast:snail");
        addItem(escargots_snails_ingredients, "naturesfeast:snail");
        addTag(escargots_snails_ingredients, "farm_and_charm:butter");
        addTag(escargots_snails_ingredients, "farm_and_charm:onion");
        addItem(escargots_snails_ingredients, "naturesfeast:garlic");
        addItem(escargots_snails_ingredients, "bakery:baguette");
        EscargotsSnailsRecipe.add("ingredients", escargots_snails_ingredients);
        JsonObject container2 = new JsonObject();
        container2.addProperty("item", "minecraft:bowl");
        EscargotsSnailsRecipe.add("container", container2);
        JsonObject escargots_snails_result = new JsonObject();
        escargots_snails_result.addProperty("item", "naturesfeast:escargots_snails");
        escargots_snails_result.addProperty("count", 1);
        EscargotsSnailsRecipe.add("result", escargots_snails_result);
        EscargotsSnailsRecipe.addProperty("requiresLearning", false);
        exporter.accept(new RecipeJsonProvider() {
            @Override
            public void serialize(JsonObject json) {EscargotsSnailsRecipe.entrySet().forEach(entry -> json.add(entry.getKey(), entry.getValue()));}
            @Override
            public Identifier getRecipeId() {
                return new Identifier("naturesfeast", "escargots_snails");
            }
            @Override
            public RecipeSerializer<?> getSerializer() {
                return RecipeSerializer.SHAPELESS;
            }
            @Override
            public JsonObject toAdvancementJson() { return null; }
            @Override
            public Identifier getAdvancementId() { return null; }
        });
    }
    private static void addItem(JsonArray array, String itemId) {
        JsonObject obj = new JsonObject();
        obj.addProperty("item", itemId);
        array.add(obj);
    }
    private static void addTag(JsonArray array, String tagId) {
        JsonObject obj = new JsonObject();
        obj.addProperty("tag", tagId);
        array.add(obj);
    }
}
