package net.ZakiChel.tutorialmod.entity.custom;

import net.ZakiChel.tutorialmod.TutorialMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, TutorialMod.MOD_ID);
    public static final RegistryObject<EntityType<flameboy>> FLAMEBOY = ENTITY_TYPES.register("flameboy",
            () -> EntityType.Builder.of(flameboy::new, MobCategory.MONSTER)
                    .build(new ResourceLocation(TutorialMod.MOD_ID,"flameboy").toString()));

    public static void register (IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
