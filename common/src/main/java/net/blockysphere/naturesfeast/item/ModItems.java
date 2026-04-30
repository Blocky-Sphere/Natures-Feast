package net.blockysphere.naturesfeast.item;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.blockysphere.naturesfeast.NaturesFeast;
import net.blockysphere.naturesfeast.block.ModBlocks;
import net.blockysphere.naturesfeast.item.custom.*;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.StandingAndWallBlockItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(NaturesFeast.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> GARLIC = register("garlic",
            () -> new GarlicItem(new Item.Properties().food(ModFoodComponents.GARLIC)));
    public static final RegistrySupplier<Item> CHILI_PEPPER_SEEDS = register("chili_pepper_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CHILI_PEPPER_CROP.get(), new  Item.Properties()));
    public static final RegistrySupplier<Item> BLACK_PEPPER = register("black_pepper",
            () -> new BlackPepperItem(new Item.Properties()));
    public static final RegistrySupplier<Item> DRIED_BLACK_PEPPER = register("dried_black_pepper",
            () -> new Item(new Item.Properties()));
    public static final RegistrySupplier<Item> BLACK_PEPPER_POWDER = register("black_pepper_powder",
            () -> new Item(new Item.Properties()));
    public static final RegistrySupplier<Item> CAJUN_POWDER = register("cajun_powder",
            () -> new Item(new Item.Properties()));
    public static final RegistrySupplier<Item> ALLIGATOR_LEG = register("alligator_leg",
            () -> new Item(new Item.Properties().food(ModFoodComponents.ALLIGATOR_LEG)));
    public static final RegistrySupplier<Item> ALLIGATOR_TAIL = register("alligator_tail",
            () -> new Item(new Item.Properties().food(ModFoodComponents.ALLIGATOR_TAIL)));
    public static final RegistrySupplier<Item> BEAR_MEAT = register("bear_meat",
            () -> new Item(new Item.Properties().food(ModFoodComponents.BEAR_MEAT)));
    public static final RegistrySupplier<Item> COOKED_BEAR_MEAT = register("cooked_bear_meat",
            () -> new Item(new Item.Properties().food(ModFoodComponents.COOKED_BEAR_MEAT)));
    public static final RegistrySupplier<Item> ROAST_BEAR_STEAK = register("roast_bear_steak",
            () -> new RoastBearSteakItem(new Item.Properties().food(ModFoodComponents.ROAST_BEAR_STEAK)));
    public static final RegistrySupplier<Item> HORSE_MEAT = register("horse_meat",
            () -> new Item(new Item.Properties().food(ModFoodComponents.HORSE_MEAT)));
    public static final RegistrySupplier<Item> COOKED_HORSE_MEAT = register("cooked_horse_meat",
            () -> new Item(new Item.Properties().food(ModFoodComponents.COOKED_HORSE_MEAT)));
    public static final RegistrySupplier<Item> ESCARGOTS_SNAILS = register("escargots_snails",
            () -> new EscargotsSnailsItem(new Item.Properties().food(ModFoodComponents.ESCARGOTS_SNAILS)));
    public static final RegistrySupplier<Item> CHILI_PEPPER = register("chili_pepper",
            () -> new ChiliPepperItem(new Item.Properties().food(ModFoodComponents.CHILI_PEPPER)));
    public static final RegistrySupplier<Item> SNAKE = register("snake",
            () -> new Item(new Item.Properties().food(ModFoodComponents.SNAKE)));
    public static final RegistrySupplier<Item> COOKED_SNAKE = register("cooked_snake",
            () -> new Item(new Item.Properties().food(ModFoodComponents.COOKED_SNAKE)));
    public static final RegistrySupplier<Item> SNAIL = register("snail",
            () -> new Item(new Item.Properties()));
    public static final RegistrySupplier<Item> ALLIGATOR_SAUCE_PIQUANTE = register("alligator_sauce_piquante",
            () -> new AlligatorSaucePiquanteItem(new Item.Properties().food(ModFoodComponents.ALLIGATOR_SAUCE_PIQUANTE)));
    public static final RegistrySupplier<Item> CAJUN_FRIED_ALLIGATOR = register("cajun_fried_alligator",
            () -> new CajunFriedAlligatorItem(new Item.Properties().food(ModFoodComponents.CAJUN_FRIED_ALLIGATOR)));
    public static final RegistrySupplier<Item> HORSE_FILLET = register("horse_fillet",
            () -> new HorseFilletItem(new Item.Properties().food(ModFoodComponents.HORSE_FILLET)));
    public static final RegistrySupplier<Item> SPICY_FRIED_SNAKE = register("spicy_fried_snake",
            () -> new Item(new Item.Properties().food(ModFoodComponents.SPICY_FRIED_SNAKE)));
    public static final RegistrySupplier<Item> WHOLE_BAKED_SEA_BASS = register("whole_baked_sea_bass",
            () -> new WholeBakedSeaBassItem(new Item.Properties().food(ModFoodComponents.WHOLE_BAKED_SEA_BASS)));
    public static final RegistrySupplier<Item> LEMON = register("lemon",
            () -> new Item(new Item.Properties().food(ModFoodComponents.LEMON)));
    public static final RegistrySupplier<Item> LEMONADE = register("lemonade",
            () -> new LemonadeItem(new Item.Properties().food(ModFoodComponents.LEMONADE).stacksTo(16)));
    public static final RegistrySupplier<Item> VENISON_STEW = register("venison_stew",
            () -> new VenisonStewItem(new Item.Properties().food(ModFoodComponents.VENISON_STEW)));
    public static final RegistrySupplier<Item> GLOWING_PASTA = register("glowing_pasta",
            () -> new GlowingPastaItem(new Item.Properties().food(ModFoodComponents.GLOWING_PASTA)));
    public static final RegistrySupplier<Item> DUCK_CASSOULET = register("duck_cassoulet",
            () -> new Item(new Item.Properties().food(ModFoodComponents.DUCK_CASSOULET)));
    public static final RegistrySupplier<Item> DUCK_SALAD = register("duck_salad",
            () -> new DuckSaladItem(new Item.Properties().food(ModFoodComponents.DUCK_SALAD)));
    public static final RegistrySupplier<Item> MARINATED_DUCK_BREAST = register("marinated_duck_breast",
            () -> new MarinatedDuckBreastItem(new Item.Properties().food(ModFoodComponents.MARINATED_DUCK_BREAST)));
    public static final RegistrySupplier<Item> BIRD_CAGE = ITEMS.register("bird_cage",
            () -> new BirdCageBlockItem(new Item.Properties()));
    public static final RegistrySupplier<Item> NATURES_FEAST_BANNER_ITEM = register("natures_feast_banner",
            () -> new StandingAndWallBlockItem(ModBlocks.NATURES_FEAST_BANNER.get(), ModBlocks.NATURES_FEAST_WALL_BANNER.get(), new Item.Properties(), Direction.DOWN));

    // Helper Methods
    private static <T extends Item> RegistrySupplier<T> register(String name, java.util.function.Supplier<T> item) {
        return ITEMS.register(name, item);
    }
    public static void registerModItems() {
        ITEMS.register();
    }
}