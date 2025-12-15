package net.blockysphere.naturesfeast.util;

import net.blockysphere.naturesfeast.item.ModItems;
import net.blockysphere.naturesfeast.villager.ModVillagers;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(ModVillagers.HUNTER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.BEAR_MEAT, 4),
                            new ItemStack(Items.EMERALD, 8),
                            12, 4, 0.03f));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 6),
                            new ItemStack(ModItems.BEAR_MEAT, 2),
                            10, 3, 0.05f));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 5),
                            new ItemStack(ModItems.SNAIL, 2),
                            10, 3, 0.04f));
                });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.HUNTER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SNAIL, 3),
                            new ItemStack(Items.EMERALD, 10),
                            new ItemStack(ModItems.ESCARGOTS_SNAILS, 1),
                            3, 8, 0.04f));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.BEAR_MEAT, 2),
                            new ItemStack(Items.EMERALD, 10),
                            new ItemStack(ModItems.ROAST_BEAR_STEAK, 1),
                            3, 8, 0.05f));
                });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.HUNTER, 4 ,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.BEAR_CLAW, 1),
                            new ItemStack(Items.EMERALD, 32),
                            4, 20, 0));
                });
    }
}
