package net.blockysphere.naturesfeast.block.custom;

import net.blockysphere.naturesfeast.effect.ModEffects;
import net.blockysphere.naturesfeast.item.ModFoodComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
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

public class CajunFriedAlligatorBlock extends HorizontalDirectionalBlock {
    public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 3);
    private static final int MAX_BITES = 3;
    protected static final VoxelShape SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 3.0, 12.0);
    public CajunFriedAlligatorBlock(BlockBehaviour.Properties properties) {
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
        int foodPerBite = ModFoodComponents.ROAST_BEAR_STEAK.getNutrition() / (MAX_BITES + 1);
        float saturationPerBite = ModFoodComponents.ROAST_BEAR_STEAK.getSaturationModifier();
        if (level.isClientSide) {
            if (player.canEat(false)) {
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.PASS;
        }
        if (player.canEat(false)) {
            player.getFoodData().eat(foodPerBite, saturationPerBite);
            level.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 1.0F, 1.0F);
            MobEffectInstance current = player.getEffect(ModEffects.SPICY.get());
            int newAmplifier = (current == null) ? 0 : current.getAmplifier() + 1;
            newAmplifier = Math.min(newAmplifier, 4);
            player.addEffect(new MobEffectInstance(ModEffects.SPICY.get(), 400, newAmplifier, false, true, true));
            int bites = state.getValue(BITES);
            if (bites >= MAX_BITES) {
                level.removeBlock(pos, false);
            } else {
                level.setBlock(pos, state.setValue(BITES, bites + 1), 3);
            }
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }
}