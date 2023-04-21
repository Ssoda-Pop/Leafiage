package net.ZakiChel.tutorialmod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;


public class ModTiers {
    public static final ForgeTier ONEPIECE = new ForgeTier(4,2031,9.0f,4.0f,15,
            BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.NETHERITE_INGOT));
}
