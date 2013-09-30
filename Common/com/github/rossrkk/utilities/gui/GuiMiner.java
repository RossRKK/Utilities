package com.github.rossrkk.utilities.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.github.rossrkk.utilities.tileentities.TEBlockPlacer;
import com.github.rossrkk.utilities.tileentities.TEMiner;


public class GuiMiner extends GuiContainer {
	
	TEMiner machine;
	
	public GuiMiner(InventoryPlayer invPlayer, TEMiner machine) {
		super(new ContainerMiner(invPlayer, machine));
		
		xSize = 176;
		ySize = 154;
		
		this.machine = machine;
	}
	
	public static final ResourceLocation texture = new ResourceLocation("utilities", "textures/gui/miner.png");

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		float filled = machine.getPower() / machine.maxPower;
		int barHeight = machine.getPower()/16;
		if (barHeight > 0) {
			int srcX = xSize;
			int srcY = 32 - barHeight;
			
			drawTexturedModalRect(guiLeft + 15, guiTop + 31 + 32 - barHeight, srcX, srcY, 10, barHeight);
		}
	}
}
