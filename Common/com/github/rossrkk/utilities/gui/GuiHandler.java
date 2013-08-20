package com.github.rossrkk.utilities.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.github.rossrkk.utilities.Utilities;
import com.github.rossrkk.utilities.tileentities.TEBlockPlacer;

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
			TileEntity te = world.getBlockTileEntity(x, y, z);
			if (te != null && te instanceof TEBlockPlacer) {
				return new ContainerPlacer(player.inventory, (TEBlockPlacer)te);
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
			TileEntity te = world.getBlockTileEntity(x, y, z);
			if (te != null && te instanceof TEBlockPlacer) {
				return new GuiPlacer(player.inventory, (TEBlockPlacer)te);
			}
		
			break;
	}


	return null;
	}

}
