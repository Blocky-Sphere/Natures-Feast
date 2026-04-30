package net.blockysphere.naturesfeast.block.custom;

import net.blockysphere.naturesfeast.blockentities.custom.BirdCageBlockEntity;
import net.blockysphere.naturesfeast.item.ModItems;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.UUID;

public class BirdCageBlock extends HorizontalDirectionalBlock implements EntityBlock {
    private static final VoxelShape SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 13.0, 15.0);
    public BirdCageBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BirdCageBlockEntity(pos, state);
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.setPlacedBy(level, pos, state, placer, itemStack);
        if (!level.isClientSide && itemStack.hasTag() && itemStack.getTag().contains("CapturedEntity")) {
            CompoundTag entityTag = itemStack.getTag().getCompound("CapturedEntity");
            Optional<Entity> optionalEntity = EntityType.create(entityTag, level);
            optionalEntity.ifPresent(entity -> {
                if (entity instanceof LivingEntity livingEntity) {
                    double x = pos.getX() + 0.5;
                    double y = pos.getY() + 0.125;
                    double z = pos.getZ() + 0.5;
                    entity.moveTo(x, y, z, 0.0F, 0.0F);
                    level.addFreshEntity(entity);
                    livingEntity.setDeltaMovement(0, 0, 0);
                    livingEntity.setOnGround(true);
                    livingEntity.setNoGravity(true);
                    if (entity instanceof Parrot parrot) {
                        parrot.setInSittingPose(false);
                    }
                    if (placer != null) {
                        livingEntity.lookAt(EntityAnchorArgument.Anchor.EYES, placer.getEyePosition());
                    }
                    BlockEntity be = level.getBlockEntity(pos);
                    if (be instanceof BirdCageBlockEntity cageBe) {
                        cageBe.setCapturedEntityId(entity.getUUID());
                    }
                }
            });
        }
    }
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }
        if (player.isShiftKeyDown() && player.getItemInHand(hand).isEmpty()) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof BirdCageBlockEntity cageBe && cageBe.getCapturedEntityId() != null) {
                UUID entityId = cageBe.getCapturedEntityId();
                if (level instanceof ServerLevel serverLevel) {
                    Entity entity = serverLevel.getEntity(entityId);
                    if (entity instanceof LivingEntity living) {
                        CompoundTag entityTag = new CompoundTag();
                        living.save(entityTag);
                        entityTag.putBoolean("NoAI", true);
                        ItemStack filledCage = new ItemStack(ModItems.BIRD_CAGE.get());
                        filledCage.getOrCreateTag().put("CapturedEntity", entityTag);
                        if (!player.getInventory().add(filledCage)) {
                            player.drop(filledCage, false);
                        }
                        entity.discard();
                        level.playSound(null, pos, SoundEvents.NETHERITE_BLOCK_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
                        level.removeBlock(pos, false);
                        return InteractionResult.SUCCESS;
                    }
                }
            }
        }
        return InteractionResult.PASS;
    }
    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.is(newState.getBlock())) {
            if (!level.isClientSide) {
                BlockEntity be = level.getBlockEntity(pos);
                if (be instanceof BirdCageBlockEntity cageBe && cageBe.getCapturedEntityId() != null) {
                    UUID entityId = cageBe.getCapturedEntityId();
                    if (level instanceof ServerLevel serverLevel) {
                        Entity entity = serverLevel.getEntity(entityId);
                        if (entity instanceof LivingEntity living) {
                            CompoundTag nbt = new CompoundTag();
                            living.save(nbt);
                            nbt.remove("NoAI");
                            living.load(nbt);
                            if (living instanceof Parrot parrot) {
                                parrot.setInSittingPose(false);
                            }
                        }
                    }
                }
            }
        }
        super.onRemove(state, level, pos, newState, moved);
    }
}