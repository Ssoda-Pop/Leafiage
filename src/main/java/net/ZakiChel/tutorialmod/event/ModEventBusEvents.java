package net.ZakiChel.tutorialmod.event;

import net.ZakiChel.tutorialmod.TutorialMod;


import net.ZakiChel.tutorialmod.entity.custom.ModEntityTypes;
import net.ZakiChel.tutorialmod.entity.custom.flameboy;
import net.ZakiChel.tutorialmod.particle.ModParticles;
import net.ZakiChel.tutorialmod.particle.custom.ConquerorHaki;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;




@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticles.CONQUEROR_HAKI.get(),
                ConquerorHaki.Provider::new);

    }
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event){
        event.put(ModEntityTypes.FLAMEBOY.get(), flameboy.setAttributes());
    }
}
