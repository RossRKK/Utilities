package com.github.rossrkk.utilities.tileentities;

import com.github.rossrkk.utilities.lib.IDs;
import com.github.rossrkk.utilities.power.Power;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public class TECable extends TileEntity implements Power {
	
	public int power;
	public int maxPower = 32;

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
		if (worldObj.getBlockTileEntity(x, y, z) instanceof Power && !((Power)worldObj.getBlockTileEntity(x, y, z)).isGenerator() && power >= 16) {
			power = power + ((Power)worldObj.getBlockTileEntity(x, y, z)).incrementPower(16) - 16;
		}
	}
	
	@Override
	public int getPower() {
		return power;
	}

	@Override
	public int incrementPower(int count) {
		int totalPower = count + power;
		if (totalPower > maxPower) {
			power = maxPower;
			return totalPower - maxPower;
		} else {
			power = totalPower;
			return 0;
		}
	}

	@Override
	public boolean isGenerator() {
		return false;
	}

}
