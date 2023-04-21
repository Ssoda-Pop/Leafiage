package net.ZakiChel.tutorialmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.ZakiChel.tutorialmod.TutorialMod;
import net.ZakiChel.tutorialmod.entity.custom.flameboy;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FlameBoyRenderer extends GeoEntityRenderer<flameboy> {

    public FlameBoyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FlameBoyModel());
        this.shadowRadius =0.3f;
    }
    @Override
    public ResourceLocation getTextureLocation(flameboy instance) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/flameboy.png");
    }

    @Override
    public RenderType getRenderType(flameboy animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
