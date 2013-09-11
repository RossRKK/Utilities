package com.github.rossrkk.utilities.tileentities;

import com.github.rossrkk.utilities.power.Power;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TEMiner extends TileEntity implements IInventory, Power {
	
	ItemStack[] inventory = new ItemStack[10];
	
	int power;
	int maxPower = 1024;
	
	int tickCount = 0;
	
	@Override
	public void updateEntity() {
		tickCount++;
		if (power >= 16 && tickCount == 10) {
			tickCount = 0;
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		for (int i = 0; i < inventory.length; i++) {
			inventory[i].readFromNBT(compound);
		}
		
		compound.getInteger("power");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		for (int i = 0; i < inventory.length; i++) {
			inventory[i].writeToNBT(compound);
		}
		
		compound.setInteger("power", power);
	}

	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return inventory[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		ItemStack itemstack = getStackInSlot(i);
		
		if (itemstack != null) {
			if (itemstack.stackSize <= j) {
				setInventorySlotContents(i, null);
			}else{
				itemstack = itemstack.splitStack(j);
				onInventoryChanged();
			}
		}

		return itemstack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return inventory[i];
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		inventory[i] = itemstack;
	}

	@Override
	public String getInvName() {
		return "Miner";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64;
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		if (i == 0) {
			return itemstack.itemID == Item.pickaxeDiamond.itemID;
		} else if (i == 1) {
			return true;
		}
		return true;
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
