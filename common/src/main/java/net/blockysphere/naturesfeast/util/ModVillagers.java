package net.blockysphere.naturesfeast.util;

import com.google.common.collect.ImmutableSet;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.blockysphere.naturesfeast.NaturesFeast;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(NaturesFeast.MOD_ID, Registries.POINT_OF_INTEREST_TYPE);
    public static final DeferredRegister<VillagerProfession> PROFESSIONS =
            DeferredRegister.create(NaturesFeast.MOD_ID, Registries.VILLAGER_PROFESSION);
    public static final RegistrySupplier<PoiType> HUNTER_POI = POI_TYPES.register("hunter_poi",
            () -> new PoiType(ImmutableSet.copyOf(Blocks.BAMBOO_BLOCK.getStateDefinition().getPossibleStates()), 1, 1));
    public static final RegistrySupplier<VillagerProfession> HUNTER = PROFESSIONS.register("hunter",
            () -> new VillagerProfession(
                    "hunter",
                    holder -> holder.is(HUNTER_POI.getKey()),
                    holder -> holder.is(HUNTER_POI.getKey()),
                    ImmutableSet.of(),
                    ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_BUTCHER
            ));

    public static void registerVillagers() {
        NaturesFeast.LOGGER.info("Registering Villagers for " + NaturesFeast.MOD_ID);
        POI_TYPES.register();
        PROFESSIONS.register();
    }
    public static ImmutableSet<BlockState> getHunterBlockStates() {
        return ImmutableSet.copyOf(Blocks.BAMBOO_BLOCK.getStateDefinition().getPossibleStates());
    }
}