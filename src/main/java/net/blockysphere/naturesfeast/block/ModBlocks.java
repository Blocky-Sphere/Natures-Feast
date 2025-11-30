package net.blockysphere.naturesfeast.block;

import net.blockysphere.naturesfeast.NaturesFeast;
import net.blockysphere.naturesfeast.block.custom.ChiliPepperCropBlock;
import net.blockysphere.naturesfeast.block.custom.GarlicCropBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block GARLIC_CROP = Registry.register(Registries.BLOCK, new Identifier(NaturesFeast.MOD_ID, "garlic_crop"),
            new GarlicCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    public static final Block CHILI_PEPPER_CROP = Registry.register(Registries.BLOCK, new Identifier(NaturesFeast.MOD_ID, "chili_pepper_crop"),
            new ChiliPepperCropBlock(FabricBlockSettings.copyOf(Blocks.CARROTS)));
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(NaturesFeast.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(NaturesFeast.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        NaturesFeast.LOGGER.info("Registering ModBlocks for" + NaturesFeast.MOD_ID);
    }
}
