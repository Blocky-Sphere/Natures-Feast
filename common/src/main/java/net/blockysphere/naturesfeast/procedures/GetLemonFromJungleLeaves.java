package net.blockysphere.naturesfeast.procedures;

import dev.architectury.event.EventResult;
import net.blockysphere.naturesfeast.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class GetLemonFromJungleLeaves {
    public static EventResult getLemonFromJungleLeaves(Player player, InteractionHand hand, BlockPos pos, Direction direction) {
        Level level = player.level();
        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
            BlockState state = level.getBlockState(pos);
            if (state.is(Blocks.JUNGLE_LEAVES)) {
                ItemStack heldStack = player.getItemInHand(hand);
                if (heldStack.is(Items.SHEARS)) {
                    Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(),
                            new ItemStack(ModItems.LEMON.get(), 2 + level.random.nextInt(2)));
                    heldStack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));
                    level.playSound(null, pos, SoundEvents.MOOSHROOM_SHEAR,
                            SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
                    return EventResult.interruptTrue();
                }
            }
        }
        return EventResult.pass();
    }
}