package com.github.rossrkk.utilities.tileentities;

import com.github.rossrkk.utilities.power.IPower;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TEElectricFurnace extends TileEntity implements ISidedInventory, IPower {

	//1 is output and 0 is input
	public ItemStack[] inventory = new ItemStack[2];
	public int power = 0;
	public final int maxPower = 1024;
	public int cookTime = 0;
	
	@Override
	public void updateEntity() {
		System.out.println(xCoord + " " + yCoord + " " + zCoord + ":" + power);
		ItemStack result = FurnaceRecipes.smelting().getSmeltingResult(inventory[0]);
		
		if (power > 16 && result != null) {
			cookTime ++;
		}
		
		if (cookTime > 256) {
			decrStackSize(0, 1);
			if (getStackInSlot(1) == null) {
				setInventorySlotContents(1, result);
				onInventoryChanged();
				power -= 16;
			} else if (getStackInSlot(1).itemID == result.itemID && getStackInSlot(1).stackSize < result.getMaxStackSize()) {
				getStackInSlot(1).stackSize ++;
				onInventoryChanged();
				power -= 16;
			}
			cookTime = 0;
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		power = compound.getInteger("power");
		cookTime = compound.getInteger("cookTime");
		
		NBTTagList items = compound.getTagList("Items");
		
		for (int i = 0; i < items.tagCount(); i++) {
			NBTTagCompound item = (NBTTagCompound)items.tagAt(i);
			int slot = item.getByte("Slot");
			
			if (slot >= 0 && slot < getSizeInventory()) {
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);		
		compound.setInteger("power", power);
		compound.setInteger("cookTime", cookTime);
		
		NBTTagList items = new NBTTagList();
		
		for (int i = 0; i < getSizeInventory(); i++) {		
			ItemStack stack = getStackInSlot(i);
			
			if (stack != null) {
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Slot", (byte)i);
				stack.writeToNBT(item);
				items.appendTag(item);
			}
		}
		
		compound.setTag("Items", items);
	}

	
	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	@Override
	public void openChest() {		
	}

	@Override
	public void closeChest() {		
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		switch(var1) {
			case 0:return new int[]{1};
			case 1:return new int[]{1};
			case 2:return new int[]{0};
			case 3:return new int[]{0};
			case 4:return new int[]{0};
			case 5:return new int[]{0};
			default: return null;
		}
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return true;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return i == 1;
	}

	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	//1 is output and 0 is input
	@Override
	public ItemStack getStackInSlot(int i) {
		return inventory[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		ItemStack itemstack = inventory[i];

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
		return inventory[i];
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		inventory[i] = itemstack;
	}

	@Override
	public String getInvName() {
		return "electricFurnace";
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
