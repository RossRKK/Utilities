package com.github.rossrkk.utilities.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.github.rossrkk.utilities.tileentities.TEBlockPlacer;

public class GuiPlacer extends GuiContainer {

	public static final ResourceLocation texture = new ResourceLocation("utilities", "textures/gui/placer.png");

	public GuiPlacer(InventoryPlayer invPlayer, TEBlockPlacer machine) {
		super(new ContainerPlacer(invPlayer, machine));

		xSize = 176;
		ySize = 154;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
