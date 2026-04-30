package net.blockysphere.naturesfeast.effect.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

import java.util.UUID;

public class SpicyEffect extends MobEffect {
    private static final UUID ATTACK_DAMAGE_UUID = UUID.fromString("648D7064-6A60-4F59-8ABE-C2C23A6DD7A9");
    public SpicyEffect(MobEffectCategory category, int color) {
        super(category, color);
    }
    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        double strengthBonus = 1.0 + 1.5 * amplifier;
        AttributeInstance attackAttribute = entity.getAttribute(Attributes.ATTACK_DAMAGE);
        if (attackAttribute != null) {
            attackAttribute.removeModifier(ATTACK_DAMAGE_UUID);
            attackAttribute.addTransientModifier(
                    new AttributeModifier(
                            ATTACK_DAMAGE_UUID,
                            "naturesfeast.spicy_strength",
                            strengthBonus,
                            AttributeModifier.Operation.ADDITION
                    )
            );
        }
        float threshold = Math.max(2.0f, 11.0f - (amplifier + 1));
        if (entity.getHealth() > threshold) {
            float fullDamage = 1.0f * amplifier + 1.0f;
            float damageToApply;

            if (entity.getHealth() - fullDamage >= threshold) {
                damageToApply = fullDamage;
            } else {
                damageToApply = entity.getHealth() - threshold;
                damageToApply = Math.max(0.5f, damageToApply);
            }
            entity.hurt(entity.damageSources().inFire(), damageToApply);
        }
    }
    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        int interval = 25 >> amplifier;
        return interval <= 0 || duration % interval == 0;
    }
    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributes, int amplifier) {
        AttributeInstance attackAttribute = entity.getAttribute(Attributes.ATTACK_DAMAGE);
        if (attackAttribute != null) {
            attackAttribute.removeModifier(ATTACK_DAMAGE_UUID);
        }
        super.removeAttributeModifiers(entity, attributes, amplifier);
    }
}