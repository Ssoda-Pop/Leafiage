package net.ZakiChel.tutorialmod;

import net.ZakiChel.tutorialmod.block.ModBlocks;
import net.ZakiChel.tutorialmod.entity.client.FlameBoyRenderer;
import net.ZakiChel.tutorialmod.entity.custom.ModEntityTypes;
import net.ZakiChel.tutorialmod.item.ModItems;
import net.ZakiChel.tutorialmod.particle.ModParticles;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import javax.swing.text.html.parser.Entity;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MOD_ID)
public class TutorialMod
{
    public static final String MOD_ID = "tutorialmod";

    private static final Logger LOGGER = LogManager.getLogger();


    public TutorialMod() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModParticles.register(eventBus);
        ModEntityTypes.register(eventBus);
        GeckoLib.initialize();
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void clientSetup(final FMLCommonSetupEvent event){
        EntityRenderers.register(ModEntityTypes.FLAMEBOY.get(), FlameBoyRenderer::new);
    }
    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }


}
