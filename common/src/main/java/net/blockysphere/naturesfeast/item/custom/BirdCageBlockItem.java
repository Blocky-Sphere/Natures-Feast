package net.blockysphere.naturesfeast.item.custom;

import net.blockysphere.naturesfeast.block.ModBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class BirdCageBlockItem extends BlockItem {
    private static final String CAPTURED_ENTITY_KEY = "CapturedEntity";

    public BirdCageBlockItem(Properties properties) {
        super(ModBlocks.BIRD_CAGE.get(), properties);
    }
    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player user, LivingEntity entity, InteractionHand hand) {
        Level world = user.level();
        if (world.isClientSide) return InteractionResult.PASS;
        if (isFilled(stack)) return InteractionResult.PASS;
        String entityId = BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString();
        if (!isBirdToCapture(entityId)) {
            return InteractionResult.PASS;
        }
        CompoundTag entityNbt = new CompoundTag();
        entity.saveWithoutId(entityNbt);
        entityNbt.putString("id", entityId);
        entityNbt.putBoolean("NoAI", true);
        ItemStack filledCage = createFilledCage(entityNbt);
        giveReplacementItem(user, hand, stack, filledCage);
        entity.discard();
        user.playSound(SoundEvents.BOTTLE_FILL_DRAGONBREATH, 1.0F, 1.0F);
        return InteractionResult.SUCCESS;
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        ItemStack stack = user.getItemInHand(hand);

        if (!isFilled(stack) || !user.isShiftKeyDown()) {
            return super.use(world, user, hand);
        }
        if (world.isClientSide) {
            return InteractionResultHolder.success(stack);
        }
        CompoundTag entityNbt = stack.getOrCreateTag().getCompound(CAPTURED_ENTITY_KEY).copy();
        entityNbt.remove("NoAI");

        Optional<Entity> optionalEntity = EntityType.create(entityNbt, world);
        optionalEntity.ifPresent(entity -> {
            Vec3 spawnPos = user.getEyePosition().add(user.getLookAngle().scale(1.5));
            entity.moveTo(spawnPos.x, spawnPos.y, spawnPos.z, user.getYRot(), 0.0F);
            world.addFreshEntity(entity);
        });

        user.playSound(SoundEvents.PARROT_AMBIENT, 1.0F, 1.2F);
        ItemStack emptyCage = new ItemStack(this);
        giveReplacementItem(user, hand, stack, emptyCage);

        return InteractionResultHolder.consume(user.getItemInHand(hand));
    }
    private boolean isFilled(ItemStack stack) {
        return stack.hasTag() && stack.getOrCreateTag().contains(CAPTURED_ENTITY_KEY);
    }
    private ItemStack createFilledCage(CompoundTag capturedNbt) {
        ItemStack cage = new ItemStack(this);
        cage.getOrCreateTag().put(CAPTURED_ENTITY_KEY, capturedNbt);
        return cage;
    }
    private void giveReplacementItem(Player user, InteractionHand hand, ItemStack currentStack, ItemStack replacement) {
        if (currentStack.getCount() == 1) {
            user.setItemInHand(hand, replacement);
        } else {
            currentStack.shrink(1);
            if (!user.getInventory().add(replacement)) {
                user.drop(replacement, false);
            }
        }
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
        if (isFilled(stack)) {
            CompoundTag capturedNbt = stack.getOrCreateTag().getCompound(CAPTURED_ENTITY_KEY);
            if (capturedNbt.contains("id", Tag.TAG_STRING)) {
                String entityId = capturedNbt.getString("id");
                Optional<EntityType<?>> type = EntityType.byString(entityId);

                type.ifPresentOrElse(
                        t -> tooltip.add(Component.translatable("tooltip.naturesfeast.bird_cage.captured",
                                        t.getDescription().copy().withStyle(ChatFormatting.AQUA, ChatFormatting.ITALIC))
                                .withStyle(ChatFormatting.GRAY)),
                        () -> tooltip.add(Component.literal("Captured: " + entityId).withStyle(ChatFormatting.GRAY))
                );
            }
        }
        super.appendHoverText(stack, world, tooltip, context);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return this.isFilled(stack);
    }

    private static final Set<String> BIRDS_TO_CAPTURE = Set.of(
            "minecraft:parrot", "naturalist:bluejay", "naturalist:canary",
            "naturalist:sparrow", "naturalist:finch", "naturalist:robin", "naturalist:cardinal"
    );
    private boolean isBirdToCapture(String entityId) {
        return BIRDS_TO_CAPTURE.contains(entityId);
    }
}