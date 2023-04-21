package net.ZakiChel.tutorialmod.item.custom;

import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;


public class dashItem extends Item {

    public dashItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        if (!pLevel.isClientSide) {
            pPlayer.getCooldowns().addCooldown(this, 30);
            pPlayer.hurtMarked = true;
            Vec3 playerLook = pPlayer.getViewVector(1);
            double Z = playerLook.z();
            double X = playerLook.x();
            double Y = playerLook.y();
            Vec3 dashVec = new Vec3(X, Y, Z).normalize().add(0,0,0);
            pPlayer.setDeltaMovement(pPlayer.getDeltaMovement().add(dashVec));
        }

        return InteractionResultHolder.success(itemstack);
    }
}