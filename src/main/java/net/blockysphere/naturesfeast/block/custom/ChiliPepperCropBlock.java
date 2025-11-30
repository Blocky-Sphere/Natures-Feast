package net.blockysphere.naturesfeast.block.custom;

import net.blockysphere.naturesfeast.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ChiliPepperCropBlock extends CropBlock {
    public static final int MAX_AGE = 5;
    public static final IntProperty AGE = Properties.AGE_5;
    public ChiliPepperCropBlock(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        int age = state.get(AGE);

        if (age == getMaxAge()) {
            if (!world.isClient) {
                int count = 2 + world.random.nextInt(2);
                ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(),
                        new net.minecraft.item.ItemStack(ModItems.CHILI_PEPPER, count));
                world.setBlockState(pos, state.with(AGE, 3), Block.NOTIFY_LISTENERS);
                world.playSound(null, pos,
                        SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES,
                        SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            }
            return ActionResult.success(world.isClient);
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.CHILI_PEPPER_SEEDS;
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
