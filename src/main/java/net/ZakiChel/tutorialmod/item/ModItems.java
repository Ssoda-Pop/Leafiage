package net.ZakiChel.tutorialmod.item;


import net.ZakiChel.tutorialmod.TutorialMod;
import net.ZakiChel.tutorialmod.item.custom.*;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).food(new FoodProperties.Builder().nutrition(4).saturationMod(0.2f).build())));
    public static final RegistryObject<Item> SMART_BLOW_TORCH = ITEMS.register("smart_blow_torch",
            () -> new SmartBlowTorchItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).durability(128)));
    public static final RegistryObject<Item> COORDINATES_TELLER = ITEMS.register("smart_coords_teller",
            () -> new SmartCoordinatesTellerItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> DASH = ITEMS.register("dash",
            () -> new dashItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> WIND_BLOW = ITEMS.register("wind_blow",
            () -> new windBlow(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> HASSAIKAI = ITEMS.register("hassaikai",
            () -> new Hassaikai(Tiers.NETHERITE, 7, -3.4f, new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> MURAKUMOGIRI = ITEMS.register("murakumogiri",
            () -> new Hassaikai(Tiers.NETHERITE, 7, -3.4f, new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> MORTAR = ITEMS.register("mortar",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
