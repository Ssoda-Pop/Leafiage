package net.ZakiChel.tutorialmod.item.custom;

import net.ZakiChel.tutorialmod.TutorialMod;
import net.ZakiChel.tutorialmod.particle.ModParticles;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.phys.Vec3;

import java.util.concurrent.ThreadLocalRandom;

public class Hassaikai extends SwordItem {
    public Hassaikai(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {

        pTarget.hurtMarked = true;
        boolean chance = ThreadLocalRandom.current().nextDouble(100) < (35);
        if (chance) {
            Vec3 stun = new Vec3(0,-1,0);
            double particlespawnX = pTarget.getBlockX();
            double particlespawnY = pTarget.getBlockY();
            double particlespawnZ = pTarget.getBlockZ();

            pTarget.setDeltaMovement(stun);
            pTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 200), pAttacker);
            pAttacker.getServer().getLevel(pAttacker.getLevel().dimension()).sendParticles(ModParticles.CONQUEROR_HAKI.get(),
                    particlespawnX,particlespawnY,particlespawnZ,
                    1,0,0,0,0);
        }

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
