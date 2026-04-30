package net.blockysphere.naturesfeast.fabric.datagen;

import net.blockysphere.naturesfeast.item.ModItems;
import net.blockysphere.naturesfeast.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookup) {
        getOrCreateTagBuilder(ModTags.Items.IS_SPICY)
                .add(ModItems.BLACK_PEPPER.get())
                .add(ModItems.DRIED_BLACK_PEPPER.get())
                .add(ModItems.BLACK_PEPPER_POWDER.get())
                .add(ModItems.CAJUN_POWDER.get())
                .add(ModItems.CHILI_PEPPER.get())
                .add(ModItems.GARLIC.get());
    }
}