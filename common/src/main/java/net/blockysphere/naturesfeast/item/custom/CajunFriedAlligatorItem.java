package net.blockysphere.naturesfeast.item.custom;

import net.blockysphere.naturesfeast.block.ModBlocks;
import net.blockysphere.naturesfeast.effect.ModEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CajunFriedAlligatorItem extends BlockItem {
    private static final int BASE_DURATION_TICKS = 400;
    public CajunFriedAlligatorItem(Properties properties) {
        super(ModBlocks.CAJUN_FRIED_ALLIGATOR_PLACED.get(), properties);
    }
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        if (player == null || !player.isShiftKeyDown()) {
            return InteractionResult.PASS;
        }
        return super.useOn(context);
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
        String line = effectName.getString() + " II (00:20)";
        tooltip.add(Component.literal(line).withStyle(ChatFormatting.RED));
        tooltip.add(Component.translatable("tooltip.naturesfeast.empty"));
        tooltip.add(Component.translatable("tooltip.naturesfeast.placeables")
                .withStyle(ChatFormatting.ITALIC, ChatFormatting.GRAY));
        super.appendHoverText(stack, level, tooltip, context);
    }
}