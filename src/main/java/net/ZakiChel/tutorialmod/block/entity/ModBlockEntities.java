package net.ZakiChel.tutorialmod.block.entity;

import net.ZakiChel.tutorialmod.TutorialMod;
import net.ZakiChel.tutorialmod.block.ModBlocks;
import net.ZakiChel.tutorialmod.block.entity.custom.BowlNBonkerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

    public class ModBlockEntities {
        public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
                DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, TutorialMod.MOD_ID);
        public static final RegistryObject<BlockEntityType<BowlNBonkerBlockEntity>> BOWL_N_BONKER_BLOCK_ENTITY =
        BLOCK_ENTITIES.register("bowl_n_bonker_block_entity", () ->
                BlockEntityType.Builder.of(BowlNBonkerBlockEntity::new, ModBlocks.BOWL_N_BONKER.get()).build(null));


        public static void register(IEventBus eventBus) {
            BLOCK_ENTITIES.register(eventBus);
        }
    }

