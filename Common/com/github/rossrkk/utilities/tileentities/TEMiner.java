package com.github.rossrkk.utilities.tileentities;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.github.rossrkk.utilities.power.Power;

public class TEMiner extends TileEntity implements IInventory, Power {
	
	ItemStack[] inventory = new ItemStack[10];
	
	int power;
	int maxPower = 1024;
	
	int heightDug = -1;
	
	@Override
	public void updateEntity() {
		if (heightDug + yCoord < 1) {
			heightDug = -1;
		}
		
		if (power >= 16 && inventory[0] != null) {
			if (inventory[0].itemID == Item.pickaxeDiamond.itemID) {
				if (Block.blocksList[worldObj.getBlockId(xCoord, yCoord + heightDug, zCoord)].blockID != Block.bedrock.blockID) {
					
					ArrayList<ItemStack> dropped = Block.blocksList[worldObj.getBlockId(xCoord, yCoord + heightDug, zCoord)].getBlockDropped(worldObj, xCoord, yCoord + heightDug, zCoord, worldObj.getBlockMetadata(xCoord, yCoord + heightDug, zCoord), 1);
					ItemStack[] droppedAr = dropped.toArray(new ItemStack[9]);
					
					if (worldObj.destroyBlock(xCoord, yCoord + heightDug, zCoord, false)) {
						for (int i = 0; i < dropped.size(); i++) {
							if (isItemValidForSlot(i + 1, droppedAr[i])) {
								setInventorySlotContents(i + 1, droppedAr[i]);
							}
						}
						heightDug --;
						inventory[0].setItemDamage(inventory[0].getItemDamage() + 1);
					}
				}
			}
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		
		for (int i = 0; i < inventory.length; i++) {
			
			NBTTagList items = compound.getTagList("Items");
			if ((NBTTagCompound)items.tagAt(i) != null) {
				NBTTagCompound item = (NBTTagCompound)items.tagAt(i);
				int slot = item.getByte("Slot");
				
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
			}
		}
		
		power = compound.getInteger("power");
		heightDug = compound.getInteger("heightDug");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		for (int i = 0; i < inventory.length; i++) {
			NBTTagList items = new NBTTagList();
				
				ItemStack stack = getStackInSlot(i);
				
				if (stack != null) {
					NBTTagCompound item = new NBTTagCompound();
					stack.writeToNBT(item);
					items.appendTag(item);
				}
			
			compound.setTag("Items", items);
		}
		
		compound.setInteger("power", power);
		compound.setInteger("heightDug", heightDug);
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
