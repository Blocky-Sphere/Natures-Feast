package net.blockysphere.naturesfeast.block;

import net.blockysphere.naturesfeast.NaturesFeast;
import net.blockysphere.naturesfeast.block.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block GARLIC_CROP = registerBlock("garlic_crop", new GarlicCropBlock(FabricBlockSettings.copyOf(Blocks.CARROTS)));
    public static final Block CHILI_PEPPER_CROP = registerBlock("chili_pepper_crop", new ChiliPepperCropBlock(FabricBlockSettings.copyOf(Blocks.CARROTS)));
    public static final Block PIPER_NIGRUM = registerBlock("piper_nigrum", new PiperNigrumBlock(FabricBlockSettings.copyOf(Blocks.VINE)));
    public static final Block ROAST_BEAR_STEAK_PLACED = registerBlockWithoutItem("roast_bear_steak",
            new RoastBearSteakBlock(FabricBlockSettings.create().mapColor(MapColor.BROWN).strength(0.5f).sounds(BlockSoundGroup.WOOL).nonOpaque().luminance(0)));
    public static final Block ESCARGOTS_SNAILS_PLACED = registerBlockWithoutItem("escargots_snails",
            new EscargotsSnailsBlock(FabricBlockSettings.create().mapColor(MapColor.GRAY).strength(0.5f).sounds(BlockSoundGroup.WOOL).nonOpaque().luminance(0)));
    public static final Block BIRD_CAGE = registerBlock("bird_cage",
            new BirdCageBlock(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_BROWN).strength(2.0f, 3.0f).sounds(BlockSoundGroup.NETHERITE).pistonBehavior(PistonBehavior.DESTROY)));
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
    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(NaturesFeast.MOD_ID, name), block);
    }
}
