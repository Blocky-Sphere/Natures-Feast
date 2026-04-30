package net.blockysphere.naturesfeast.fabric;

import net.blockysphere.naturesfeast.fabric.mixin.PoiTypesAccessor;
import net.blockysphere.naturesfeast.util.ModVillagers;
import net.fabricmc.api.ModInitializer;

import net.blockysphere.naturesfeast.NaturesFeast;

public final class NaturesFeastFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        NaturesFeast.init();
        var poiHolder = net.minecraft.core.registries.BuiltInRegistries.POINT_OF_INTEREST_TYPE
                .getHolderOrThrow(ModVillagers.HUNTER_POI.getKey());
        ModVillagers.getHunterBlockStates().forEach(state -> {
            PoiTypesAccessor.getTypeByState().put(state, poiHolder);
        });
    }
}
