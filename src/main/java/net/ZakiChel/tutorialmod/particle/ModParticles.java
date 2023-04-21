package net.ZakiChel.tutorialmod.particle;

import net.ZakiChel.tutorialmod.TutorialMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {
    public  static  final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, TutorialMod.MOD_ID);

    public static final RegistryObject<SimpleParticleType> CONQUEROR_HAKI =
            PARTICLE_TYPES.register("conqueror_haki", ()-> new SimpleParticleType(true));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);

    }
}
