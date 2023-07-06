package com.SodaPOP.leafiage.screen;

import com.SodaPOP.leafiage.Leafiage;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;

public class MortarScreen extends AbstractContainerScreen<MortarMenu> {
    public static final ResourceLocation TEXTURE =
            new ResourceLocation(Leafiage.MODID,"textures/gui/mortar_gui.png");
    public MortarScreen(AbstractContainerMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super((MortarMenu) pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float pPartialTicks, int MouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        graphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

    }
    @Override
    public void render(GuiGraphics pGraphics, int MouseX, int MouseY, float delta){
        renderBackground(pGraphics);
        super.render(pGraphics, MouseX,MouseY, delta);
        renderTooltip(pGraphics,MouseX, MouseY);
    }
}
