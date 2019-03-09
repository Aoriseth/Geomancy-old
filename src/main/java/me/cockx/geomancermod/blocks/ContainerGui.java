package me.cockx.geomancermod.blocks;

import me.cockx.geomancermod.GeomancerMod;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class ContainerGui extends GuiContainer {

    private static final int WIDTH = 180;
    private static final int HEIGHT = 152;
    private static final ResourceLocation background = new ResourceLocation(GeomancerMod.MODID, "textures/gui/screen.png");

    public ContainerGui(ContainerTileEntity containerTileEntity, Container inventorySlotsIn) {
        super(inventorySlotsIn);
        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float v, int i, int i1) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft,guiTop,0,0,xSize,ySize);
    }
}
