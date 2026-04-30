package net.blockysphere.naturesfeast.block.custom;

import net.blockysphere.naturesfeast.item.ModFoodComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EscargotsSnailsBlock extends HorizontalDirectionalBlock {
    private static final ResourceLocation SHELL_ID = new ResourceLocation("naturalist", "snail_shell");
    public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 2);
    private static final int MAX_BITES = 2;
    protected static final VoxelShape SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 6.0, 12.0);
    public EscargotsSnailsBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(BITES, 0));
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, BITES);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState()
                .setValue(FACING, ctx.getHorizontalDirection().getOpposite())
                .setValue(BITES, 0);
    }
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        int foodPerBite = ModFoodComponents.ESCARGOTS_SNAILS.getNutrition() / (MAX_BITES + 1);
        float saturationPerBite = ModFoodComponents.ESCARGOTS_SNAILS.getSaturationModifier();
        if (level.isClientSide) {
            return player.canEat(false) ? InteractionResult.SUCCESS : InteractionResult.PASS;
        }
        if (player.canEat(false)) {
            player.getFoodData().eat(foodPerBite, saturationPerBite);
            level.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 1.0F, 1.0F);
            int bites = state.getValue(BITES);
            if (bites >= MAX_BITES) {
                var shellItem = BuiltInRegistries.ITEM.get(SHELL_ID);
                if (shellItem != Items.AIR) {
                    ItemStack shells = new ItemStack(shellItem, 2);
                    if (!player.getInventory().add(shells)) {
                        player.drop(shells, false);
                    }
                }
                level.removeBlock(pos, false);
            } else {
                level.setBlock(pos, state.setValue(BITES, bites + 1), 3);
            }
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }
}
