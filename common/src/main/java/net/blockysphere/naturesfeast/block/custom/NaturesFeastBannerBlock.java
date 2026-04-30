package net.blockysphere.naturesfeast.block.custom;

import net.blockysphere.naturesfeast.blockentities.ModBlockEntities;
import net.blockysphere.naturesfeast.blockentities.custom.NaturesFeastBannerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class NaturesFeastBannerBlock extends BannerBlock {
    public NaturesFeastBannerBlock(Properties properties) {
        super(DyeColor.WHITE, properties);
    }
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new NaturesFeastBannerBlockEntity(pos, state);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.COMPLETIONIST_BANNER.get(), NaturesFeastBannerBlockEntity::tick);
    }
}