package net.blockysphere.naturesfeast.item;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.blockysphere.naturesfeast.NaturesFeast;
import net.blockysphere.naturesfeast.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class ModItemGroups {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(NaturesFeast.MOD_ID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<CreativeModeTab> NATURES_FEAST_TAB = TABS.register(
            "natures_feast_group",
            () -> CreativeTabRegistry.create(
                    Component.translatable("itemgroup.natures_feast_group"),
                    () -> new ItemStack(ModItems.ROAST_BEAR_STEAK.get())
            )
    );

    public static void registerItemGroups() {
        TABS.register();
        NaturesFeast.LOGGER.info("Registering Mod ItemGroups for " + NaturesFeast.MOD_ID);
        addItem(ModItems.CHILI_PEPPER_SEEDS);
        addItem(ModItems.CHILI_PEPPER);
        addItem(ModItems.GARLIC);
        addItem(ModItems.LEMON);
        addItem(ModItems.BLACK_PEPPER);
        addItem(ModBlocks.WILD_CHILI_PEPPERS);
        addItem(ModBlocks.WILD_GARLICS);
        addItem(ModItems.ALLIGATOR_LEG);
        addItem(ModItems.ALLIGATOR_TAIL);
        addItem(ModItems.SNAIL);
        addItem(ModItems.BEAR_MEAT);
        addItem(ModItems.COOKED_BEAR_MEAT);
        addItem(ModItems.HORSE_MEAT);
        addItem(ModItems.COOKED_HORSE_MEAT);
        addItem(ModItems.SNAKE);
        addItem(ModItems.COOKED_SNAKE);
        addItem(ModItems.DRIED_BLACK_PEPPER);
        addItem(ModItems.BLACK_PEPPER_POWDER);
        addItem(ModItems.CAJUN_POWDER);
        addItem(ModItems.ALLIGATOR_SAUCE_PIQUANTE);
        addItem(ModItems.DUCK_CASSOULET);
        addItem(ModItems.VENISON_STEW);
        addItem(ModItems.CAJUN_FRIED_ALLIGATOR);
        addItem(ModItems.ROAST_BEAR_STEAK);
        addItem(ModItems.SPICY_FRIED_SNAKE);
        addItem(ModItems.WHOLE_BAKED_SEA_BASS);
        addItem(ModItems.DUCK_SALAD);
        addItem(ModItems.MARINATED_DUCK_BREAST);
        addItem(ModItems.ESCARGOTS_SNAILS);
        addItem(ModItems.HORSE_FILLET);
        addItem(ModItems.GLOWING_PASTA);
        addItem(ModItems.LEMONADE);
        addItem(ModItems.BIRD_CAGE);
        addItem(ModItems.NATURES_FEAST_BANNER_ITEM);
    }
    private static void addItem(RegistrySupplier<?> entry) {
        CreativeTabRegistry.appendStack(NATURES_FEAST_TAB, () -> {
            Object obj = entry.get();
            if (obj instanceof Item item) return new ItemStack(item);
            if (obj instanceof Block block) return new ItemStack(block);
            return ItemStack.EMPTY;
        });
    }
}