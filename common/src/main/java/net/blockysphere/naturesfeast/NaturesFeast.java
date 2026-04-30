package net.blockysphere.naturesfeast;

import dev.architectury.event.events.common.InteractionEvent;
import net.blockysphere.naturesfeast.block.ModBlocks;
import net.blockysphere.naturesfeast.blockentities.ModBlockEntities;
import net.blockysphere.naturesfeast.effect.ModEffects;
import net.blockysphere.naturesfeast.item.ModItemGroups;
import net.blockysphere.naturesfeast.item.ModItems;
import net.blockysphere.naturesfeast.procedures.GetLemonFromJungleLeaves;
import net.blockysphere.naturesfeast.util.ModCustomTrades;
import net.blockysphere.naturesfeast.util.ModLootTableModifiers;
import net.blockysphere.naturesfeast.util.ModVillagers;
import net.blockysphere.naturesfeast.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class NaturesFeast {
    public static final String MOD_ID = "naturesfeast";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        ModVillagers.registerVillagers();
        ModBlockEntities.registerBlockEntities();
        ModEffects.register();
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        ModItemGroups.registerItemGroups();
        ModWorldGeneration.generateModWorldGen();
        ModCustomTrades.registerCustomTrades();
        ModLootTableModifiers.modifyLootTables();
        InteractionEvent.RIGHT_CLICK_BLOCK.register(GetLemonFromJungleLeaves::getLemonFromJungleLeaves);

    }
}
