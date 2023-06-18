package net.ZakiChel.tutorialmod.block;

import net.ZakiChel.tutorialmod.TutorialMod;
import net.ZakiChel.tutorialmod.block.entity.custom.BowlNBonkerBlockEntity;
import net.ZakiChel.tutorialmod.item.ModCreativeModeTab;
import net.ZakiChel.tutorialmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
            ()-> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(12f).destroyTime(9).requiresCorrectToolForDrops()));
   public static final RegistryObject<Block> TITANIUM_ORE = registerBlock("titanium_ore",
           ()-> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(12f).destroyTime(9).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BETTER_JACKO = registerBlock("better_jackolantern",
            ()-> new CarvedPumpkinBlock(BlockBehaviour.Properties.of(Material.VEGETABLE, MaterialColor.COLOR_ORANGE).strength(1.0F).sound(SoundType.WOOD).lightLevel((p_187437_) -> {
                return 15;}).noOcclusion()  ));
    public static final RegistryObject<Block> BOWL_N_BONKER = registerBlock("bowl_n_bonker",
            ()-> new BowlNBonkerBlockEntity(BlockBehaviour.Properties.of(Material.WOOD).strength(4f).destroyTime(4).sound(SoundType.WOOD).noOcclusion()));




    private static<T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block,CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static<T extends Block> Void registerBlockItem(String name, RegistryObject<T> block,CreativeModeTab tab){
        ModItems.ITEMS.register(name,() -> new BlockItem(block.get(),
                new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
            return null;
    }
    private static<T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static<T extends Block> Void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name,() -> new BlockItem(block.get(),
                new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
        return null;
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
