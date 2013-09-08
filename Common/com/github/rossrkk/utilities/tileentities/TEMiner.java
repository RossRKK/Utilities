package com.github.rossrkk.utilities.tileentities;

import com.github.rossrkk.utilities.power.Power;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TEMiner extends TileEntity implements IInventory, Power {
	
	ItemStack[] inventory = new ItemStack[11];
	
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
				((Power)worldObj.getBlockTileEntity(x, y, z)).incrementPower(1);
			}
		}
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int incrementPower(int count) {
		return 0;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isGenerator() {
		// TODO Auto-generated method stub
		return true;
	}

}
