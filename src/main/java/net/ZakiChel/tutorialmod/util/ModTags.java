package net.ZakiChel.tutorialmod.util;

import net.ZakiChel.tutorialmod.TutorialMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createTag(String name){
            return BlockTags.create(new ResourceLocation(TutorialMod.MOD_ID, name));
        }
        private static TagKey<Block> createForgeTag(String name){
            return BlockTags.create(new ResourceLocation("forge", name));
    }
    }
    public static class Items {

            public static final TagKey<Item> TITANIUM_INGOT = createForgeTag("ingots/titanium");
        public static final TagKey<Item> MASHABLE = createForgeTag("mashable");

        private static TagKey<Item> createTag(String name){
            return ItemTags.create(new ResourceLocation(TutorialMod.MOD_ID, name));
    }
        private static TagKey<Item> createForgeTag(String name){
            return ItemTags.create(new ResourceLocation("forge", name));
    }

    }
}

