package com.github.rossrkk.utilities.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.github.rossrkk.utilities.power.IPower;

public class TEBattery extends TileEntity implements IPower {

	public final int maxPower = 100000;
	public int power = 0;
	
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
		if (worldObj.getBlockTileEntity(x, y, z) instanceof IPower && !((IPower)worldObj.getBlockTileEntity(x, y, z)).isGenerator() && power >= 16) {
			((IPower)worldObj.getBlockTileEntity(x, y, z)).incrementPower(16);
			power -= 16;
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		power = compound.getInteger("power");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
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
