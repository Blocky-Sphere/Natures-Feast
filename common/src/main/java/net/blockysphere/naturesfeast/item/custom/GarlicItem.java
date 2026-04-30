package net.blockysphere.naturesfeast.item.custom;

import net.blockysphere.naturesfeast.block.ModBlocks;
import net.blockysphere.naturesfeast.effect.ModEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem; // 或使用 AliasedBlockItem
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GarlicItem extends BlockItem {
    private static final int BASE_DURATION_TICKS = 300;
    public GarlicItem(Properties properties) {
        super(ModBlocks.GARLIC_CROP.get(), properties);
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
        int newAmplifier = (current == null) ? 0 : current.getAmplifier() + 1;
        newAmplifier = Math.min(newAmplifier, 4);
        player.addEffect(new MobEffectInstance(ModEffects.SPICY.get(), BASE_DURATION_TICKS, newAmplifier,
                false, true, true));
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag context) {
        Component effectName = Component.translatable(ModEffects.SPICY.get().getDescriptionId());
        String line = effectName.getString() + " (00:15)";
        tooltip.add(Component.literal(line).withStyle(ChatFormatting.RED));
        super.appendHoverText(stack, level, tooltip, context);
    }
}