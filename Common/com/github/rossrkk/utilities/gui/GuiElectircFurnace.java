package com.github.rossrkk.utilities.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.github.rossrkk.utilities.tileentities.TEElectricFurnace;

public class GuiElectircFurnace extends GuiContainer {

	public static final ResourceLocation texture = new ResourceLocation("utilities", "textures/gui/furnace.png");

	TEElectricFurnace machine;

	public GuiElectircFurnace(InventoryPlayer inventory, TEElectricFurnace machine) {
		super(new ContainerElectricFurnace(inventory, machine));

		this.machine = machine;

		xSize = 176;
		ySize = 166;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		int i1 = (int) (machine.cookTime / 10.7);
		drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 14, i1 + 1, 16);

		int barHeight = machine.getPower()/32;
		if (barHeight > 0) {
			int srcX = xSize;
			int srcY = 63 - barHeight;

			drawTexturedModalRect(guiLeft + 15, guiTop + 31 + 32 - barHeight, srcX, srcY, 10, barHeight);
		}
	}
}
