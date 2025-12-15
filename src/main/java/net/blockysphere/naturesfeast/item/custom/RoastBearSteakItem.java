package net.blockysphere.naturesfeast.item.custom;

import net.blockysphere.naturesfeast.block.ModBlocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RoastBearSteakItem extends BlockItem {
    public RoastBearSteakItem(Item.Settings settings) {
        super(ModBlocks.ROAST_BEAR_STEAK_PLACED, settings);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        if (player == null || !player.isSneaking()) {
            return ActionResult.PASS;
        }
        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.naturesfeast.empty.tooltip"));
        tooltip.add(Text.translatable("tooltip.naturesfeast.placeables.tooltip").formatted(Formatting.ITALIC, Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
