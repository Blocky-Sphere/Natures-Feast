package net.blockysphere.naturesfeast.villager;

import com.google.common.collect.ImmutableSet;
import net.blockysphere.naturesfeast.NaturesFeast;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final PointOfInterestType HUNTER_POI = registerPoi("hunter_poi", Blocks.BAMBOO_BLOCK);
    public static final VillagerProfession HUNTER = registerProfession("hunter", poiKey("hunter_poi"));
    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(NaturesFeast.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_BUTCHER));
    }
    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(NaturesFeast.MOD_ID, name), 1, 1, block);
    }
    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(NaturesFeast.MOD_ID, name));
    }
    public static void registerVillagers() {
        NaturesFeast.LOGGER.info("Registering Villagers for " + NaturesFeast.MOD_ID);
    }
}
