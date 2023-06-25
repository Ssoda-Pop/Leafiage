package com.SodaPOP.leafiage.block;

import com.SodaPOP.leafiage.Leafiage;
import com.SodaPOP.leafiage.block.custom.MortarBlock;
import com.SodaPOP.leafiage.item.LeafItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class LeafBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Leafiage.MODID);
    public static final RegistryObject<Block> MORTAR = BLOCKS.register("mortar",
            () -> new MortarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(4f).destroyTime(4).sound(SoundType.WOOD).noOcclusion()));








    private static<T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static<T extends Block> Void registerBlockItem(String name, RegistryObject<T> block,CreativeModeTab tab){
        LeafItems.ITEMS.register(name,() -> new BlockItem(block.get(),
                new Item.Properties()));
        return null;
    }
    private static<T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static<T extends Block> Void registerBlockItem(String name, RegistryObject<T> block){
        LeafItems.ITEMS.register(name,() -> new BlockItem(block.get(),
                new Item.Properties()));
        return null;
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }



}