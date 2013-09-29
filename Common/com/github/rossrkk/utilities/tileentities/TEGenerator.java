package com.github.rossrkk.utilities.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import com.github.rossrkk.utilities.power.Power;

public class TEGenerator extends TileEntity implements Power, IInventory {

	public static ItemStack inventory;
	
	public int power;
	public int maxPower = 1024;
	public int toTransfer = 16;
	
	public int currentBurnTime = 0;
	
	@Override
	public void updateEntity() {
		if (currentBurnTime == 0) {
			if (inventory != null && inventory.itemID == Item.coal.itemID) {
				inventory.stackSize --;
				currentBurnTime = 1600;
			}
		}
		
		if (currentBurnTime > 0) {
			power += 1;
			currentBurnTime --;
		}
		
		if (power >= 16) {
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
	
	public void transfer(int x, int y, int z) {
		if (worldObj.getBlockTileEntity(x, y, z) instanceof Power 
				&& !((Power)worldObj.getBlockTileEntity(x, y, z)).isGenerator() 
				&& power >= toTransfer) {
			power = power + ((Power)worldObj.getBlockTileEntity(x, y, z)).incrementPower(toTransfer) - toTransfer;
		}
	}
	
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
		if (inventory != null) {
			return itemstack.itemID == inventory.itemID;
		}
		return true;
	}

}
