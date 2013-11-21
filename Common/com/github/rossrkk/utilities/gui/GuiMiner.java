package com.github.rossrkk.utilities.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.github.rossrkk.utilities.tileentities.TEMiner;


public class GuiMiner extends GuiContainer {

	public static final ResourceLocation texture = new ResourceLocation("utilities", "textures/gui/miner.png");

	TEMiner machine;

	public GuiMiner(InventoryPlayer invPlayer, TEMiner machine) {
		super(new ContainerMiner(invPlayer, machine));

		xSize = 176;
		ySize = 154;

		this.machine = machine;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		int barHeight = machine.getPower()/32;
		if (barHeight > 0) {
			int srcX = xSize;
			int srcY = 32 - barHeight;

			drawTexturedModalRect(guiLeft + 15, guiTop + 31 + 32 - barHeight, srcX, srcY, 10, barHeight);
		}
	}
}
