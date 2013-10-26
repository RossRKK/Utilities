package com.github.rossrkk.utilities.tileentities;

import net.minecraft.tileentity.TileEntity;

import com.github.rossrkk.utilities.power.IPower;

public class TECreativeGenerator extends TileEntity implements IPower {

	@Override
	public void updateEntity() {
		transfer(xCoord - 1, yCoord, zCoord);
		transfer(xCoord + 1, yCoord, zCoord);
		transfer(xCoord, yCoord - 1, zCoord);
		transfer(xCoord, yCoord + 1, zCoord);
		transfer(xCoord, yCoord, zCoord - 1);
		transfer(xCoord, yCoord, zCoord + 1);
	}

	public void transfer(int x, int y, int z) {
		if (worldObj.getBlockTileEntity(x, y, z) instanceof IPower && !((IPower)worldObj.getBlockTileEntity(x, y, z)).isGenerator()) {
			((IPower)worldObj.getBlockTileEntity(x, y, z)).incrementPower(1);
		}
	}

	@Override
	public int getPower() {
		return 0;
	}

	@Override
	public int incrementPower(int count) {
		return 0;
	}

	@Override
	public boolean isGenerator() {
		return true;
	}

}
