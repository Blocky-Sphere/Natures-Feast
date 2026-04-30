package net.blockysphere.naturesfeast.item.custom;

import net.blockysphere.naturesfeast.block.ModBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GlowingPastaItem extends BlockItem {
    public GlowingPastaItem(Item.Properties properties) {
        super(ModBlocks.GLOWING_PASTA_PLACED.get(), properties);
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
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag context) {
        Component glowingName = Component.translatable(MobEffects.GLOWING.getDescriptionId());
        tooltip.add(Component.literal(glowingName.getString() + " (01:30)")
                .withStyle(ChatFormatting.BLUE));
        Component nightVisionName = Component.translatable(MobEffects.NIGHT_VISION.getDescriptionId());
        tooltip.add(Component.literal(nightVisionName.getString() + " (01:30)")
                .withStyle(ChatFormatting.BLUE));
        tooltip.add(Component.translatable("tooltip.naturesfeast.empty"));
        tooltip.add(Component.translatable("tooltip.naturesfeast.placeables")
                .withStyle(ChatFormatting.ITALIC, ChatFormatting.GRAY));

        super.appendHoverText(stack, level, tooltip, context);
    }

}
