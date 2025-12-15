package net.blockysphere.naturesfeast.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class RoastBearSteakBlock extends HorizontalFacingBlock {
    public static final IntProperty BITES = Properties.BITES;
    private static final int MAX_BITES = 3;
    private static final VoxelShape SHAPE = Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 7.0, 13.0);
    public RoastBearSteakBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(HorizontalFacingBlock.FACING, Direction.NORTH).with(BITES, 0));
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HorizontalFacingBlock.FACING, BITES);
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return getDefaultState()
                .with(HorizontalFacingBlock.FACING, ctx.getHorizontalPlayerFacing().getOpposite())
                .with(BITES, 0);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;
        int bites = state.get(BITES);
        if (bites < MAX_BITES) {
            player.getHungerManager().add(3, 0.3f);
            world.setBlockState(pos, state.with(BITES, bites + 1));
            spawnBreakParticles(world, player, pos, state);
            world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EAT,
                    SoundCategory.PLAYERS, 0.5f, world.random.nextFloat() * 0.1f + 0.9f);
            return ActionResult.SUCCESS;
        }
        else {
            world.removeBlock(pos, false);
            spawnBreakParticles(world, player, pos, state);
            world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.BLOCKS, 1.0f, 1.0f);
            return ActionResult.SUCCESS;
        }
    }
    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (state.get(BITES) == 0) {
            super.onBreak(world, pos, state, player);
        }
        else {
            world.removeBlock(pos, false);
        }
    }
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return state.get(BITES) == 0 ? new ItemStack(this.asItem()) : ItemStack.EMPTY;
    }
}
