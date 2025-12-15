package net.blockysphere.naturesfeast.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.VineBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class PiperNigrumBlock extends VineBlock {
    public PiperNigrumBlock(Settings settings) {
        super(settings);
    }
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(3) == 0) {super.randomTick(state, world, pos, random);}
    }
}
