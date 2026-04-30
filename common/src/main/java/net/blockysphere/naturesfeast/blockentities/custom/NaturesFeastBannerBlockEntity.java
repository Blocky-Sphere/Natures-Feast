package net.blockysphere.naturesfeast.blockentities.custom;

import net.blockysphere.naturesfeast.blockentities.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class NaturesFeastBannerBlockEntity extends BannerBlockEntity {
    public NaturesFeastBannerBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }
    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.COMPLETIONIST_BANNER.get();
    }
    public static void tick(Level level, BlockPos pos, BlockState state1, NaturesFeastBannerBlockEntity banner) {
        if (level.isClientSide || level.getGameTime() % 20 != 0) return;
        AABB area = new AABB(pos).inflate(8.0);
        List<Player> players = level.getEntitiesOfClass(Player.class, area, Player::isAlive);
        for (Player player : players) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 220, 1, true, false));
        }
    }
}
