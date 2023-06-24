package com.SodaPOP.leafiage.item;

import com.SodaPOP.leafiage.block.LeafBlocks;
import net.minecraft.client.gui.ComponentPath;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.SodaPOP.leafiage.Leafiage.MODID;

public class LeafTabs {

    public static final DeferredRegister<CreativeModeTab> LEAF_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final RegistryObject<CreativeModeTab> LEAFIAGE = LEAF_TABS.register("leafiage",
            ()-> CreativeModeTab.builder(CreativeModeTab.Row.TOP,0).title(Component.literal("Leafiage"))
                    .icon(()-> new ItemStack(LeafItems.COFFEE_BEANS.get())).displayItems((t,item)->{
                        item.accept(LeafItems.COFFEE_BEANS.get());
                        item.accept(LeafItems.COFFEE_POWDER.get());
                        item.accept((LeafItems.MORTAR.get()));
                    }).build());

    public static void register(IEventBus eventBus) {
    LEAF_TABS.register(eventBus);
    }
}

