package net.blockysphere.naturesfeast.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.registry.Registries;

public class EscargotsSnailsItem extends Item {
    private static final Identifier SHELL_ID = new Identifier("naturalist", "snail_shell");
    public EscargotsSnailsItem(Settings settings) {
        super(settings);
    }
    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack result = super.finishUsing(stack, world, user);
        if (user instanceof PlayerEntity player && !world.isClient) {
            var shellItem = Registries.ITEM.get(SHELL_ID);
            if (shellItem != null && shellItem != net.minecraft.item.Items.AIR) {
                ItemStack shells = new ItemStack(shellItem, 2);
                if (!player.getInventory().insertStack(shells)) {
                    player.dropItem(shells, false);
                }
            }
        }
        return result;
    }
}