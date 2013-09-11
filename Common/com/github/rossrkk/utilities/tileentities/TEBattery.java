package com.github.rossrkk.utilities.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.github.rossrkk.utilities.power.Power;

public class TEBattery extends TileEntity implements Power {

	public int maxPower = 1024;
	public int power;
	
	@Override
	public void updateEntity() {
		if (worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 1) {
			transfer(xCoord - 1, yCoord, zCoord);
			transfer(xCoord + 1, yCoord, zCoord);
			transfer(xCoord, yCoord - 1, zCoord);
			transfer(xCoord, yCoord + 1, zCoord);
			transfer(xCoord, yCoord, zCoord - 1);
			transfer(xCoord, yCoord, zCoord + 1);
		}
	}
	
	public void transfer(int x, int y, int z) {
		if (worldObj.getBlockTileEntity(x, y, z) instanceof Power && !((Power)worldObj.getBlockTileEntity(x, y, z)).isGenerator() && power >= 16) {
			((Power)worldObj.getBlockTileEntity(x, y, z)).incrementPower(16);
			power -= 16;
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		power = compound.getInteger("power");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		compound.setInteger("power", power);
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
		return worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 1;
	}

}