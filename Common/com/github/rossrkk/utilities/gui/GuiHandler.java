package com.github.rossrkk.utilities.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.github.rossrkk.utilities.Utilities;
import com.github.rossrkk.utilities.tileentities.TEBlockBreaker;
import com.github.rossrkk.utilities.tileentities.TEBlockPlacer;
import com.github.rossrkk.utilities.tileentities.TEMiner;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {
	
	public GuiHandler() {
		NetworkRegistry.instance().registerGuiHandler(Utilities.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch (ID) {
		case 0:
			TileEntity te1 = world.getBlockTileEntity(x, y, z);
			if (te1 != null && te1 instanceof TEBlockPlacer) {
				return new ContainerPlacer(player.inventory, (TEBlockPlacer)te1);
			}
			break;
		case 1:
			TileEntity te2 = world.getBlockTileEntity(x, y, z);
			if (te2 != null && te2 instanceof TEMiner) {
				return new ContainerMiner(player.inventory, (TEMiner)te2);
			}
			break;
	}


	return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch (ID) {
		case 0:
			TileEntity te1 = world.getBlockTileEntity(x, y, z);
			if (te1 != null && te1 instanceof TEBlockPlacer) {
				return new GuiPlacer(player.inventory, (TEBlockPlacer)te1);
			}
		case 1:
			TileEntity te2 = world.getBlockTileEntity(x, y, z);
			if (te2 != null && te2 instanceof TEMiner) {
				return new GuiMiner(player.inventory, (TEMiner)te2);
			}
	}


	return null;
	}

}
