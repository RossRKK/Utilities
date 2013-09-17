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
	public int maxPower = 1024;
	
	int heightDug = -1;
	
	@Override
	public void updateEntity() {
		try {
			
			//reset the dig height if the dig height is bellow the world
			if (heightDug + yCoord < 1) {
				heightDug = -1;
			}
			
			//if there is more than 16 power units run
			if (power >= 16 && inventory[0] != null) {
				if (inventory[0].itemID == Item.pickaxeDiamond.itemID) {
					//if the block isn't bedrock
					if (Block.blocksList[worldObj.getBlockId(xCoord, yCoord + heightDug, zCoord)].blockID != Block.bedrock.blockID) {
						
						//get the dropped block
						ArrayList<ItemStack> dropped = Block.blocksList[worldObj.getBlockId(xCoord, yCoord + heightDug, zCoord)].getBlockDropped(worldObj, xCoord, yCoord + heightDug, zCoord, worldObj.getBlockMetadata(xCoord, yCoord + heightDug, zCoord), 1);
						ItemStack[] droppedAr = dropped.toArray(new ItemStack[9]);
						
						//if the block is successfully destroyed
						if (worldObj.destroyBlock(xCoord, yCoord + heightDug, zCoord, false)) {
							for (int i = 0; i < dropped.size(); i++) {
								//if the item is valid for the slot
								if (isItemValidForSlot(i + 1, droppedAr[i])) {
									//manual valid item check
									if (getStackInSlot(i + 1).itemID == droppedAr[i].itemID) {
										//if else to switch between the item adding system
										if (getStackInSlot(i + 1).stackSize + droppedAr[i].stackSize >= droppedAr[i].getMaxStackSize() || getStackInSlot(i + 1) == null) {
											droppedAr[i].stackSize = droppedAr[i].stackSize + getStackInSlot(i + 1).stackSize;
											setInventorySlotContents(i + 1, droppedAr[i]);
											
											//decrease the power level
											power -= 16;
										} else {
											droppedAr[i].stackSize = droppedAr[i].getMaxStackSize();
											setInventorySlotContents(i + 1, droppedAr[i]);
											
											//decrease the power level
											power -= 16;
										}
									}
								}
							}
							//dig down
							heightDug --;
							//damage the pickaxe
							inventory[0].setItemDamage(inventory[0].getItemDamage() + 1);
						}
					}
				}
			}
		} catch (NullPointerException e) {
			
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
