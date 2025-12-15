package net.blockysphere.naturesfeast.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class EscargotsSnailsBlock extends HorizontalFacingBlock {
    private static final Identifier SHELL_ID = Identifier.of("naturalist", "snail_shell");
    public static final IntProperty BITES = Properties.BITES; // 0–2 (3 states total)
    private static final int MAX_BITES = 2;
    private static final VoxelShape SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 6.0, 12.0);
    public EscargotsSnailsBlock(Settings settings) {
        super(settings);
        this.setDefaultState(
                this.getDefaultState()
                        .with(FACING, Direction.NORTH)
                        .with(BITES, 0)
        );
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, BITES);
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite())
                .with(BITES, 0);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return player.canConsume(false) ? ActionResult.SUCCESS : ActionResult.CONSUME;
        }
        int bites = state.get(BITES);
        if (bites < MAX_BITES) {
            player.getHungerManager().add(3, 0.35f);
            world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.PLAYERS, 0.5f, world.random.nextFloat() * 0.1f + 0.9f);
            world.setBlockState(pos, state.with(BITES, bites + 1));
            return ActionResult.SUCCESS;
        }
        else {
            player.getHungerManager().add(3, 0.35f);
            world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.PLAYERS, 0.8f, world.random.nextFloat() * 0.1f + 0.9f);
            var shellItem = Registries.ITEM.get(SHELL_ID);
            if (shellItem != null && shellItem != net.minecraft.item.Items.AIR) {
                ItemStack shells = new ItemStack(shellItem, 2);
                if (!player.getInventory().insertStack(shells)) {
                    player.dropItem(shells, false);
                }
            }

            world.removeBlock(pos, false);
            return ActionResult.SUCCESS;
        }
    }
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return state.get(BITES) == 0 ? new ItemStack(this.asItem()) : ItemStack.EMPTY;
    }
    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient && player.isCreative() && state.get(BITES) > 0) {
            world.removeBlock(pos, false);
        } else {
            super.onBreak(world, pos, state, player);
        }
    }
}