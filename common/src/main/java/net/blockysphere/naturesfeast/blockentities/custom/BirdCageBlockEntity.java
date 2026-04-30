package net.blockysphere.naturesfeast.blockentities.custom;

import net.blockysphere.naturesfeast.blockentities.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.UUID;

public class BirdCageBlockEntity extends BlockEntity {
    private UUID capturedEntityId;

    public BirdCageBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BIRD_CAGE.get(), pos, state);
        this.capturedEntityId = null;
    }

    public void setCapturedEntityId(UUID id) {
        this.capturedEntityId = id;
        this.setChanged();
    }

    public UUID getCapturedEntityId() {
        return this.capturedEntityId;
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        if (nbt.hasUUID("CapturedEntityId")) {
            this.capturedEntityId = nbt.getUUID("CapturedEntityId");
        }
    }
    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        if (this.capturedEntityId != null) {
            nbt.putUUID("CapturedEntityId", this.capturedEntityId);
        }
    }
}