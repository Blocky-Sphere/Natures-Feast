package net.blockysphere.naturesfeast.item;

import net.blockysphere.naturesfeast.NaturesFeast;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup LETS_DO_NATURES_FEAST = Registry.register(Registries.ITEM_GROUP,
            new Identifier(NaturesFeast.MOD_ID, "garlic"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.natures_feast"))
                    .icon(() -> new ItemStack(ModItems.CHILI_PEPPER)).entries((displayContext, entries) -> {

                        entries.add(ModItems.BLACK_PEPPER);
                        entries.add(ModItems.DRIED_BLACK_PEPPER);
                        entries.add(ModItems.CHILI_PEPPER_SEEDS);
                        entries.add(ModItems.CHILI_PEPPER);
                        entries.add(ModItems.GARLIC);
                        entries.add(ModItems.ALLIGATOR_LEG);
                        entries.add(ModItems.ALLIGATOR_TAIL);
                        entries.add(ModItems.SNAIL);
                        entries.add(ModItems.BEAR_MEAT);
                        entries.add(ModItems.COOKED_BEAR_MEAT);
                        entries.add(ModItems.BLACK_PEPPER_POWDER);
                        entries.add(ModItems.CAJUN_POWDER);
                        entries.add(ModItems.ESCARGOTS_SNAILS);
                        entries.add(ModItems.ROAST_BEAR_MEAT);

                    }).build());
    public static void registerItemGroups() {
        NaturesFeast.LOGGER.info("Registering Mod Item Groups for " + NaturesFeast.MOD_ID);
    }
}