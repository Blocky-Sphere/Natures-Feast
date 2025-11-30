package net.blockysphere.naturesfeast;

import net.blockysphere.naturesfeast.block.ModBlocks;
import net.blockysphere.naturesfeast.item.ModItemGroups;
import net.blockysphere.naturesfeast.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NaturesFeast implements ModInitializer {
    public static final String MOD_ID = "naturesfeast";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModItemGroups.registerItemGroups();
    }
}