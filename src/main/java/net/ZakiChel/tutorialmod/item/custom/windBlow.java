package net.ZakiChel.tutorialmod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;


public class windBlow extends Item {

    public windBlow(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        if (!pLevel.isClientSide) {
            pPlayer.getCooldowns().addCooldown(this,20);
            pPlayer.hurtMarked = true;
            double Y = pPlayer.getY();
            Vec3 windBlow = new Vec3(0,Y,0).normalize().add(0,3,0);
            pPlayer.setDeltaMovement(pPlayer.getDeltaMovement().add(windBlow));


        }

        return InteractionResultHolder.success(itemstack);
    }
}