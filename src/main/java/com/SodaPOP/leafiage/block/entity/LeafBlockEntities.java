package com.SodaPOP.leafiage.block.entity;

import com.SodaPOP.leafiage.Leafiage;
import com.SodaPOP.leafiage.block.LeafBlocks;
import com.SodaPOP.leafiage.block.entity.custom.MortarBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class LeafBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Leafiage.MODID);
    public static final RegistryObject<BlockEntityType<MortarBlockEntity>> MORTAR_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("mortar_block_entity", () ->
                    BlockEntityType.Builder.of(MortarBlockEntity::new,LeafBlocks.MORTAR.get()).build(null));




    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }

}
