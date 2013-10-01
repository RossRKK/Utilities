package com.github.rossrkk.utilities.tileentities;

import java.util.ArrayList;
import java.util.InputMismatchException;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.github.rossrkk.utilities.item.Items;
import com.github.rossrkk.utilities.power.IPower;

public class TEMiner extends TileEntity implements IInventory, IPower {

	ItemStack[] inventory = new ItemStack[10];

	int power;
	public int maxPower = 1024;
	int tickCount = 0;

	int heightDug = -1;

	@Override
	public void updateEntity() {
		if (tickCount == 16) {
			
			tickCount = 0;
			// reset the dig height if the dig height is bellow the world
			if (heightDug + yCoord == 0) {
					heightDug = -1;
			}
			// if there is more than 16 power units run
			if (power >= 16 && inventory[0] != null) {
				if (inventory[0].itemID == Items.turidiumPick.itemID || inventory[0].itemID == Item.pickaxeDiamond.itemID) {
					breakBlock(0, 0);
				}
			}
			//digDown
			heightDug --;
		}
		tickCount ++;
	}

	public void dropItem(ItemStack stack) {
		float spawnX = xCoord + worldObj.rand.nextFloat();
		float spawnY = yCoord + worldObj.rand.nextFloat();
		float spawnZ = zCoord + worldObj.rand.nextFloat();

		EntityItem droppedItem = new EntityItem(worldObj, spawnX, spawnY,
				spawnZ, stack);

		float mult = 0.05F;

		droppedItem.motionX = (-0.5F + worldObj.rand.nextFloat()) * mult;
		droppedItem.motionY = (4 + worldObj.rand.nextFloat()) * mult;
		droppedItem.motionZ = (-0.5F + worldObj.rand.nextFloat()) * mult;

		worldObj.spawnEntityInWorld(droppedItem);
	}

	public void breakBlock(int xDifference, int zDifference) {
		// if the block isn't bedrock
		if (worldObj.getBlockId(xCoord + xDifference, yCoord + heightDug, zCoord + zDifference) != Block.bedrock.blockID) {
			if (worldObj.getBlockId(xCoord + xDifference, yCoord + heightDug,
					zCoord + zDifference) != 0) {
				// get the dropped block
				ArrayList<ItemStack> dropped = Block.blocksList[worldObj.getBlockId(xCoord + xDifference, yCoord + heightDug,
								zCoord + zDifference)].getBlockDropped(worldObj, xCoord + xDifference, yCoord + heightDug, zCoord + zDifference, worldObj.getBlockMetadata(xCoord + xDifference, yCoord + heightDug, zCoord + zDifference), 0);
				ItemStack[] droppedAr = dropped.toArray(new ItemStack[9]);

				if (worldObj.destroyBlock(xCoord + xDifference, yCoord + heightDug, zCoord + zDifference, false)) {
					for (int i = 0; i < dropped.size(); i++) {
						for (int j = 1; j < inventory.length; j++) {
							if (inventory[j] != null) {
								if (inventory[j].itemID == droppedAr[i].itemID) {
									if (inventory[j].stackSize + droppedAr[i].stackSize <= droppedAr[i].getMaxStackSize()) {
										droppedAr[i].stackSize += inventory[j].stackSize;
										setInventorySlotContents(j,
												droppedAr[i]);
										break;
									} else {
										droppedAr[i].stackSize = droppedAr[i].getMaxStackSize();
										setInventorySlotContents(j, droppedAr[i]);
										break;
									}
								}
							} else {
								setInventorySlotContents(j,
										droppedAr[i]);
								break;
							}
							onInventoryChanged();
						}
					}

					// damage the pickaxe
					inventory[0].setItemDamage(inventory[0]
							.getItemDamage() + 1);
				}
			}
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
super.readFromNBT(compound);
		
		NBTTagList items = compound.getTagList("Items");
		
		for (int i = 0; i < items.tagCount(); i++) {
			NBTTagCompound item = (NBTTagCompound)items.tagAt(i);
			int slot = item.getByte("Slot");
			
			if (slot >= 0 && slot < getSizeInventory()) {
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
			}
		}

		power = compound.getInteger("power");
		heightDug = compound.getInteger("heightDug");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		
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
		return entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5,
				zCoord + 0.5) <= 64;
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
			return itemstack.itemID == Item.pickaxeDiamond.itemID || itemstack.itemID == Items.turidiumPick.itemID;
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
