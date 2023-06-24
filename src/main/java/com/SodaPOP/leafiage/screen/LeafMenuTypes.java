package com.SodaPOP.leafiage.screen;

import com.SodaPOP.leafiage.Leafiage;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LeafMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, Leafiage.MODID);
        public static final RegistryObject<MenuType<MortarMenu>> MORTAR_MENU = registerMenuType(MortarMenu::new, "mortar_menu");
        private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name){
            return MENUS.register(name,()-> IForgeMenuType.create(factory));}
    public static void register(IEventBus eventBus){
        MENUS.register(eventBus);
    }
}
