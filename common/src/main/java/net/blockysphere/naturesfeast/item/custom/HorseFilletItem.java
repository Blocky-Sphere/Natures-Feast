package net.blockysphere.naturesfeast.item.custom;

import net.blockysphere.naturesfeast.block.ModBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HorseFilletItem extends BlockItem {
    public HorseFilletItem(Properties properties) {
        super(ModBlocks.HORSE_FILLET_PLACED.get(), properties);
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
        tooltip.add(Component.translatable("tooltip.naturesfeast.empty"));
        tooltip.add(Component.translatable("tooltip.naturesfeast.placeables")
                .withStyle(ChatFormatting.ITALIC, ChatFormatting.GRAY));

        super.appendHoverText(stack, level, tooltip, context);
    }
}
