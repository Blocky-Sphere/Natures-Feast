package net.blockysphere.naturesfeast.item;

import net.blockysphere.naturesfeast.NaturesFeast;
import net.blockysphere.naturesfeast.block.ModBlocks;
import net.blockysphere.naturesfeast.item.custom.ChiliPepperItem;
import net.blockysphere.naturesfeast.item.custom.EscargotsSnailsItem;
import net.blockysphere.naturesfeast.item.custom.RoastBearSteakItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item GARLIC = registerItem("garlic", new AliasedBlockItem(ModBlocks.GARLIC_CROP, new FabricItemSettings().food(ModFoodComponents.GARLIC)));
    public static final Item CHILI_PEPPER_SEEDS = registerItem("chili_pepper_seeds", new AliasedBlockItem(ModBlocks.CHILI_PEPPER_CROP, new FabricItemSettings()));
    public static final Item BLACK_PEPPER = registerItem("black_pepper", new Item(new FabricItemSettings()));
    public static final Item DRIED_BLACK_PEPPER = registerItem("dried_black_pepper", new Item(new FabricItemSettings()));
    public static final Item BLACK_PEPPER_POWDER = registerItem("black_pepper_powder", new Item(new FabricItemSettings()));
    public static final Item CAJUN_POWDER = registerItem("cajun_powder", new Item(new FabricItemSettings()));
    public static final Item ALLIGATOR_LEG = registerItem("alligator_leg", new Item(new FabricItemSettings().food(ModFoodComponents.ALLIGATOR_LEG)));
    public static final Item ALLIGATOR_TAIL = registerItem("alligator_tail", new Item(new FabricItemSettings().food(ModFoodComponents.ALLIGATOR_TAIL)));
    public static final Item BEAR_MEAT = registerItem("bear_meat", new Item(new FabricItemSettings().food(ModFoodComponents.BEAR_MEAT)));
    public static final Item COOKED_BEAR_MEAT = registerItem("cooked_bear_meat", new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_BEAR_MEAT)));
    public static final Item ROAST_BEAR_STEAK = registerItem("roast_bear_steak", new RoastBearSteakItem(new FabricItemSettings().food(ModFoodComponents.ROAST_BEAR_STEAK)));
    public static final Item ESCARGOTS_SNAILS = registerItem("escargots_snails", new EscargotsSnailsItem(new Item.Settings().food(ModFoodComponents.ESCARGOTS_SNAILS)));
    public static final Item CHILI_PEPPER = registerItem("chili_pepper", new ChiliPepperItem(new Item.Settings().food(ModFoodComponents.CHILI_PEPPER)));
    public static final Item SNAIL = registerItem("snail", new Item(new FabricItemSettings()));
    public static final Item BEAR_CLAW = registerItem("bear_claw", new Item(new FabricItemSettings()));
    public static final Item CAJUN_SWAMP_CHICKEN = registerItem("cajun_swamp_chicken", new Item(new FabricItemSettings().food(ModFoodComponents.CAJUN_SWAMP_CHICKEN)));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(NaturesFeast.MOD_ID, name), item);
    }
    public static void registerModItems() {
        NaturesFeast.LOGGER.info("Registering Mod Items for " + NaturesFeast.MOD_ID);
    }
}
