package com.github.rossrkk.utilities.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.github.rossrkk.utilities.tileentities.TEBlockPlacer;
import com.github.rossrkk.utilities.tileentities.TEMiner;


public class GuiMiner extends GuiContainer {
	
	public int power;
	public int maxPower;
	
	public GuiMiner(InventoryPlayer invPlayer, TEMiner machine) {
		super(new ContainerMiner(invPlayer, machine));
		
		xSize = 176;
		ySize = 154;
		
		power = machine.getPower();
		maxPower = machine.maxPower;
	}
	
	public void drawPowerBar() {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		drawRect(8, 35, 8, 65, 1);
		
		if (power > maxPower / 6) {
			drawRect(0, 0, 0, 0, 0);
		}
	}
	
	public static final ResourceLocation texture = new ResourceLocation("utilities", "textures/gui/miner.png");

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		Minecraft.getMinecraft().func_110434_K().func_110577_a(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		drawPowerBar();
	}
}
