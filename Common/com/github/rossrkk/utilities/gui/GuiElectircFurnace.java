package com.github.rossrkk.utilities.gui;

import org.lwjgl.opengl.GL11;

import com.github.rossrkk.utilities.tileentities.TEElectricFurnace;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;

public class GuiElectircFurnace extends GuiContainer {

	TEElectricFurnace machine;
	
	public GuiElectircFurnace(InventoryPlayer inventory, TEElectricFurnace machine) {
		super(new ContainerElectricFurnace(inventory, machine));
		
		this.machine = machine;
		
		xSize = 175;
		ySize = 165;
	}

	public static final ResourceLocation texture = new ResourceLocation("utilities", "textures/gui/furnace.png");

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
}
