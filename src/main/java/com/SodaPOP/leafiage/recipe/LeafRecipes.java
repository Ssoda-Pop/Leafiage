package com.SodaPOP.leafiage.recipe;

import com.SodaPOP.leafiage.Leafiage;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LeafRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Leafiage.MODID);
    public static final RegistryObject<RecipeSerializer<MortarRecipe>> MORTAR_RECIPE_SERIALIZER = SERIALIZERS.register("mashing",
        ()-> MortarRecipe.Serializer.INSTANCE);


    public static void register(IEventBus eventBus){
        SERIALIZERS.register(eventBus);
    }
}
