package com.SodaPOP.leafiage;

import com.SodaPOP.leafiage.block.LeafBlocks;
import com.SodaPOP.leafiage.block.entity.LeafBlockEntities;
import com.SodaPOP.leafiage.item.LeafItems;
import com.SodaPOP.leafiage.item.LeafTabs;
import com.SodaPOP.leafiage.recipe.LeafRecipes;
import com.SodaPOP.leafiage.screen.LeafMenuTypes;
import com.SodaPOP.leafiage.screen.MortarScreen;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

@Mod(Leafiage.MODID)
public class Leafiage
{
    public static final String MODID = "leafiage";
    private static final Logger LOGGER = LogUtils.getLogger();
    public Leafiage()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        LeafBlocks.register(modEventBus);
        LeafItems.register(modEventBus);
        LeafBlockEntities.register(modEventBus);
        LeafTabs.register(modEventBus);
        LeafRecipes.register(modEventBus);
        LeafMenuTypes.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            MenuScreens.register(LeafMenuTypes.MORTAR_MENU.get(), MortarScreen::new );
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
