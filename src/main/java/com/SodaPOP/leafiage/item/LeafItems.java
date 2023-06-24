package com.SodaPOP.leafiage.item;

import com.SodaPOP.leafiage.Leafiage;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.Items.registerItem;

public class LeafItems {
        public static final DeferredRegister<Item> ITEMS =
                DeferredRegister.create(ForgeRegistries.ITEMS, Leafiage.MODID);
        public static final RegistryObject<Item> GENERIC = ITEMS.register("generic",
        ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COFFEE_BEANS = ITEMS.register("coffee_beans",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COFFEE_POWDER = ITEMS.register("coffee_powder",
            ()-> new Item(new Item.Properties()));




    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
    }


