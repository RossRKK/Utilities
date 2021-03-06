package com.github.rossrkk.utilities.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.github.rossrkk.utilities.power.IPower;
import com.github.rossrkk.utilities.util.WorldHelper;

public class TESolar extends TileEntity implements IPower {

	public int maxPower = 32;
	public int power = 0;
	public int totalOut = 16;
	public int toTransfer = 16;

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
		return true;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		power = compound.getInteger("power");
	}

	public void transfer(int x, int y, int z) {
		if (worldObj.getBlockTileEntity(x, y, z) instanceof IPower
				&& !((IPower)worldObj.getBlockTileEntity(x, y, z)).isGenerator()
				&& power >= toTransfer) {
			power = power + ((IPower)worldObj.getBlockTileEntity(x, y, z)).incrementPower(toTransfer) - toTransfer;
		}
	}

	public void transferPower() {
		if (power >= toTransfer) {
			//Transfer power
			int randomSide = worldObj.rand.nextInt(6);
			switch (randomSide) {
			case 0: transfer(xCoord, yCoord, zCoord + 1);
			break;
			case 1: transfer(xCoord - 1, yCoord, zCoord);
			break;
			case 2: transfer(xCoord + 1, yCoord, zCoord);
			break;
			case 3: transfer(xCoord, yCoord - 1, zCoord);
			break;
			case 4: transfer(xCoord, yCoord + 1, zCoord);
			break;
			case 5: transfer(xCoord, yCoord, zCoord - 1);
			break;
			}
		}
	}

	@Override
	public void updateEntity() {
		if(WorldHelper.canSeeSky(worldObj, xCoord, yCoord, zCoord)) {
			power += totalOut;
		}

		transferPower();
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("power", power);
	}
}
