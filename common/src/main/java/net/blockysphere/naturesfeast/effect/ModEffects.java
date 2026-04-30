package net.blockysphere.naturesfeast.effect;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.blockysphere.naturesfeast.NaturesFeast;
import net.blockysphere.naturesfeast.effect.custom.SpicyEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(NaturesFeast.MOD_ID, Registries.MOB_EFFECT);
    public static final RegistrySupplier<MobEffect> SPICY = EFFECTS.register("spicy",
            () -> new SpicyEffect(MobEffectCategory.HARMFUL, 0xF74600));

    public static void register() {
        EFFECTS.register();
        NaturesFeast.LOGGER.info("Registering ModEffects for " + NaturesFeast.MOD_ID);
    }
}
