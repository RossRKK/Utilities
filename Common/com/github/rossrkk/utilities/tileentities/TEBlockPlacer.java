package com.github.rossrkk.utilities.tileentities;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.IPlantable;

public class TEBlockPlacer extends TileEntity implements IInventory {
	public static int side;
	public ItemStack inventory;

	@Override
	public void updateEntity() {
		try {
			if (!worldObj.isRemote
					&& worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord,
							zCoord) && inventory.stackSize > 0) {
				side = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

				// this switch statment decides which direction to place the
				// block based on side
				switch (side) {
				case 0:
					if (worldObj.isAirBlock(xCoord, yCoord - 1, zCoord)) {
						if (inventory.getItem() instanceof IPlantable) {
							IPlantable plantItem = (IPlantable) inventory
									.getItem();
							worldObj.setBlock(xCoord, yCoord - 1, zCoord,
									plantItem.getPlantID(worldObj, xCoord,
											yCoord, zCoord), plantItem.getPlantMetadata(worldObj, xCoord,
													yCoord, zCoord), 2);
						} else {
							worldObj.setBlock(xCoord, yCoord - 1, zCoord,
									inventory.itemID,
									inventory.getItemDamage(), 2);
							inventory.stackSize--;
						}
					}
					break;

				case 1:
					if (worldObj.isAirBlock(xCoord, yCoord + 1, zCoord)) {
						if (inventory.getItem() instanceof IPlantable) {
							IPlantable plantItem = (IPlantable) inventory
									.getItem();
							worldObj.setBlock(xCoord, yCoord + 1, zCoord,
									plantItem.getPlantID(worldObj, xCoord,
											yCoord, zCoord), plantItem.getPlantMetadata(worldObj, xCoord,
													yCoord, zCoord), 2);
						} else {
							worldObj.setBlock(xCoord, yCoord + 1, zCoord,
									inventory.itemID,
									inventory.getItemDamage(), 2);
							inventory.stackSize--;
						}
					}
					break;

				case 2:
					if (worldObj.isAirBlock(xCoord, yCoord, zCoord - 1)) {
						if (inventory.getItem() instanceof IPlantable) {
							IPlantable plantItem = (IPlantable) inventory
									.getItem();
							worldObj.setBlock(xCoord, yCoord, zCoord - 1,
									plantItem.getPlantID(worldObj, xCoord,
											yCoord, zCoord), plantItem.getPlantMetadata(worldObj, xCoord,
													yCoord, zCoord), 2);
						} else {
							worldObj.setBlock(xCoord, yCoord, zCoord - 1,
									inventory.itemID,
									inventory.getItemDamage(), 2);
							inventory.stackSize--;
						}
					}
					break;

				case 3:
					if (worldObj.isAirBlock(xCoord, yCoord, zCoord + 1)) {
						if (inventory.getItem() instanceof IPlantable) {
							IPlantable plantItem = (IPlantable) inventory
									.getItem();
							worldObj.setBlock(xCoord, yCoord, zCoord + 1,
									plantItem.getPlantID(worldObj, xCoord,
											yCoord, zCoord), plantItem.getPlantMetadata(worldObj, xCoord,
													yCoord, zCoord), 2);
						} else {
							worldObj.setBlock(xCoord, yCoord, zCoord + 1,
									inventory.itemID,
									inventory.getItemDamage(), 2);
							inventory.stackSize--;
						}
					}
					break;

				case 4:
					if (worldObj.isAirBlock(xCoord - 1, yCoord, zCoord)) {
						if (inventory.getItem() instanceof IPlantable) {
							IPlantable plantItem = (IPlantable) inventory
									.getItem();
							worldObj.setBlock(xCoord - 1, yCoord, zCoord,
									plantItem.getPlantID(worldObj, xCoord,
											yCoord, zCoord), plantItem.getPlantMetadata(worldObj, xCoord,
													yCoord, zCoord), 2);
						} else {
							worldObj.setBlock(xCoord - 1, yCoord, zCoord,
									inventory.itemID,
									inventory.getItemDamage(), 2);
							inventory.stackSize--;
						}
					}
					break;

				case 5:
					if (worldObj.isAirBlock(xCoord + 1, yCoord, zCoord)) {
						if (inventory.getItem() instanceof IPlantable) {
							IPlantable plantItem = (IPlantable) inventory
									.getItem();
							worldObj.setBlock(xCoord + 1, yCoord, zCoord,
									plantItem.getPlantID(worldObj, xCoord,
											yCoord, zCoord), plantItem.getPlantMetadata(worldObj, xCoord,
													yCoord, zCoord), 2);
						} else {
							worldObj.setBlock(xCoord + 1, yCoord, zCoord,
									inventory.itemID,
									inventory.getItemDamage(), 2);
							inventory.stackSize--;
						}
					}
					break;
				}
			}
		} catch (NullPointerException e) {
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		if (inventory != null) {
			inventory.writeToNBT(compound);
		}
		compound.setShort("side", (short) side);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		inventory.loadItemStackFromNBT(compound);
		side = compound.getShort("side");
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
		inventory.stackSize -= j;
		return inventory;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return inventory;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		inventory = itemstack;
	}

	@Override
	public String getInvName() {
		return "blockPlacer";
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
		if (inventory == null) {
			return true;
		} else if (inventory.itemID == itemstack.itemID) {
			return true;
		}
		return false;
	}
}
