package com.github.rossrkk.utilities.tileentities;

import com.github.rossrkk.utilities.lib.IDs;
import com.github.rossrkk.utilities.power.Power;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public class TECable extends TileEntity implements Power {
	
	public int power;
	public int maxPower = 6000;

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
		if (worldObj.getBlockTileEntity(x, y, z) instanceof Power) {
			if (!((Power)worldObj.getBlockTileEntity(x, y, z)).isGenerator()) {
				((Power)worldObj.getBlockTileEntity(x, y, z)).incrementPower(128);
			}
		}
	}
	
	@Override
	public int getPower() {
		return power;
	}

	@Override
	public int incrementPower(int count) {
		if (count + power < maxPower) {
			int toReturn = power + count - maxPower;
			power = maxPower;
			return toReturn;
		} else {
			power += count;
		}
		return 0;
	}

	@Override
	public boolean isGenerator() {
		return false;
	}

}
