package net.blockysphere.naturesfeast.item.custom;

import net.blockysphere.naturesfeast.block.ModBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EscargotsSnailsItem extends BlockItem {
    private static final ResourceLocation SHELL_ID = new ResourceLocation("naturalist", "snail_shell");
    public EscargotsSnailsItem(Properties properties) {
        super(ModBlocks.ESCARGOTS_SNAILS_PLACED.get(), properties);
    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity user) {
        ItemStack result = super.finishUsingItem(stack, level, user);
        if (user instanceof Player player && !level.isClientSide) {
            var shellItem = BuiltInRegistries.ITEM.get(SHELL_ID);
            if (shellItem != Items.AIR) {
                ItemStack shells = new ItemStack(shellItem, 2);
                if (!player.getInventory().add(shells)) {
                    player.drop(shells, false);
                }
            }
        }
        return result;
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