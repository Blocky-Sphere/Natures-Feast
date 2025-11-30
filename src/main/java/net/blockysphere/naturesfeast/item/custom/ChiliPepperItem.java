package net.blockysphere.naturesfeast.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ChiliPepperItem extends Item {
    public ChiliPepperItem(Settings settings) {super(settings);}
    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {ItemStack remainder = super.finishUsing(stack, world, user);
        if (!world.isClient && user instanceof PlayerEntity player) {player.setOnFireFor(2);}
        return remainder;
    };
}
