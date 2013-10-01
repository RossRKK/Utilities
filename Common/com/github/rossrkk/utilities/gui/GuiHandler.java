package com.github.rossrkk.utilities.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.github.rossrkk.utilities.Utilities;
import com.github.rossrkk.utilities.tileentities.TEBlockPlacer;
import com.github.rossrkk.utilities.tileentities.TECoalGen;
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
		case 2:
			TileEntity te3 = world.getBlockTileEntity(x, y, z);
			if (te3 != null && te3 instanceof TECoalGen) {
				return new ContainerCoalGen(player.inventory, (TECoalGen)te3);
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
		case 2:
			TileEntity te3 = world.getBlockTileEntity(x, y, z);
			if (te3 != null && te3 instanceof TECoalGen) {
				return new GuiCoalGen(player.inventory, (TECoalGen)te3);
			}
		}

	return null;
	}

}
