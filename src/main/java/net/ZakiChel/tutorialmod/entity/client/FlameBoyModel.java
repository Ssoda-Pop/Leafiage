package net.ZakiChel.tutorialmod.entity.client;

import net.ZakiChel.tutorialmod.TutorialMod;
import net.ZakiChel.tutorialmod.entity.custom.flameboy;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FlameBoyModel extends AnimatedGeoModel<flameboy> {
    @Override
    public ResourceLocation getModelLocation(flameboy object) {
        return new ResourceLocation(TutorialMod.MOD_ID, "geo/flameboy.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(flameboy object) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/flameboy.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(flameboy animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "anims/flameboy.animation.json");
    }
}
