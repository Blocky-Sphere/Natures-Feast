package net.blockysphere.naturesfeast.item.custom;

import net.blockysphere.naturesfeast.effect.ModEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AlligatorSaucePiquanteItem extends Item {
    private static final int BASE_DURATION_TICKS = 600;
    public AlligatorSaucePiquanteItem(Properties properties) {
        super(properties);
    }
    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity user) {
        ItemStack result = super.finishUsingItem(stack, level, user);
        if (!level.isClientSide && user instanceof Player player) {
            applySpicyEffect(player);
        }
        return result;
    }
    private void applySpicyEffect(Player player) {
        MobEffectInstance current = player.getEffect(ModEffects.SPICY.get());
        int newAmplifier = (current == null) ? 1 : current.getAmplifier() + 2;
        newAmplifier = Math.min(newAmplifier, 4);
        player.addEffect(new MobEffectInstance(ModEffects.SPICY.get(), BASE_DURATION_TICKS, newAmplifier,
                false, true, true));
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag context) {
        Component effectName = Component.translatable(ModEffects.SPICY.get().getDescriptionId());
        String line = effectName.getString() + " II (00:30)";
        tooltip.add(Component.literal(line).withStyle(ChatFormatting.RED));
        super.appendHoverText(stack, level, tooltip, context);
    }
}