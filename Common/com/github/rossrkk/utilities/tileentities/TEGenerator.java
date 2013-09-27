package com.github.rossrkk.utilities.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import com.github.rossrkk.utilities.power.Power;

public class TEGenerator extends TileEntity implements Power, IInventory {

	public static ItemStack inventory;
	
	public int power;
	public int maxPower = 1024;
	
	@Override
	public int getPower() {
		return power;
	}

	@Override
	public int incrementPower(int count) {
		if (count + power <= maxPower) {
			power += count;
			return 0;
		} else {
			int temp = maxPower - (power + count);
			power = maxPower;
			return temp;
		}
	}

	@Override
	public boolean isGenerator() {
		return true;
	}

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return inventory;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		ItemStack itemstack = getStackInSlot(i);
		
		if (itemstack != null) {
			if (itemstack.stackSize <= j) {
				setInventorySlotContents(i, null);
			} else {
				itemstack = itemstack.splitStack(j);
				onInventoryChanged();
			}
		}

		return itemstack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return inventory;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		inventory = itemstack;
		onInventoryChanged();
	}

	@Override
	public String getInvName() {
		return "coalGen";
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
		return itemstack.itemID == inventory.itemID;
	}

}
