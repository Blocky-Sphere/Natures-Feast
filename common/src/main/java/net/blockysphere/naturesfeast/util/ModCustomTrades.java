package net.blockysphere.naturesfeast.util;

import dev.architectury.registry.level.entity.trade.TradeRegistry;
import net.blockysphere.naturesfeast.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        ModVillagers.HUNTER.listen(profession -> {
            TradeRegistry.registerVillagerTrade(profession, 1, (entity, random) ->
                    new MerchantOffer(
                            new ItemStack(ModItems.BEAR_MEAT.get(), 4),
                            new ItemStack(Items.EMERALD, 8),
                            12, 4, 0.03f));
            TradeRegistry.registerVillagerTrade(profession, 1, (entity, random) ->
                    new MerchantOffer(
                            new ItemStack(Items.EMERALD, 6),
                            new ItemStack(ModItems.BEAR_MEAT.get(), 2),
                            10, 3, 0.05f));
            TradeRegistry.registerVillagerTrade(profession, 1, (entity, random) ->
                    new MerchantOffer(
                            new ItemStack(Items.EMERALD, 5),
                            new ItemStack(ModItems.SNAIL.get(), 2),
                            10, 3, 0.04f));
            TradeRegistry.registerVillagerTrade(profession, 2, (entity, random) ->
                    new MerchantOffer(
                            new ItemStack(ModItems.SNAIL.get(), 3),
                            new ItemStack(Items.EMERALD, 10),
                            new ItemStack(ModItems.ESCARGOTS_SNAILS.get(), 1),
                            3, 8, 0.04f));
            TradeRegistry.registerVillagerTrade(profession, 2, (entity, random) ->
                    new MerchantOffer(
                            new ItemStack(ModItems.BEAR_MEAT.get(), 2),
                            new ItemStack(Items.EMERALD, 10),
                            new ItemStack(ModItems.ROAST_BEAR_STEAK.get(), 1),
                            3, 8, 0.05f));
        });
    }
}