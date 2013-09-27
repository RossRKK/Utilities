package com.github.rossrkk.utilities.gui;

import org.lwjgl.opengl.GL11;

import com.github.rossrkk.utilities.tileentities.TEGenerator;
import com.github.rossrkk.utilities.tileentities.TEMiner;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiCoalGen extends GuiContainer {

	public GuiCoalGen(InventoryPlayer invPlayer, TEGenerator machine) {
		super(new ContainerGenerator(invPlayer, machine));
		
		xSize = 176;
		ySize = 154;
	}

	public static final ResourceLocation texture = new ResourceLocation("utilities", "textures/gui/coalgen.png");

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		Minecraft.getMinecraft().func_110434_K().func_110577_a(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
