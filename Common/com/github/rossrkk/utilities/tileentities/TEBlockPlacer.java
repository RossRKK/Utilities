package com.github.rossrkk.utilities.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.IPlantable;
import net.minecraft.item.ItemBlock;

public class TEBlockPlacer extends TileEntity implements IInventory {
	public static int side;
	public ItemStack inventory;

	@Override
	public void updateEntity() {
		try {
			if (inventory.stackSize <= 0) {
				inventory = null;
			}
			if (!worldObj.isRemote && worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord) && inventory.stackSize >= 1) {
				side = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
				int blockId;
				if (!(inventory.getItem() instanceof IPlantable)) {
					ItemBlock item = (ItemBlock)inventory.getItem();
					blockId = item.getBlockID();
				} else {
					blockId = ((IPlantable)inventory.getItem()).getPlantID(worldObj, xCoord, yCoord, zCoord);
				}
				choosePlace(side, blockId);
			}
		} catch (Exception e) {
			
		}
	}
	
public void choosePlace(int side, int blockId) {
	// this switch statment decides which direction to place the
			// block based on side
			switch (side) {
			case 0:
				placeBlock(xCoord, yCoord - 1, zCoord, blockId);
				break;
				
			case 1:
				placeBlock(xCoord, yCoord + 1, zCoord, blockId);
				break;

			case 2:
				placeBlock(xCoord, yCoord, zCoord - 1, blockId);
				break;

			case 3:
				placeBlock(xCoord, yCoord, zCoord + 1, blockId);
				break;

			case 4:
				placeBlock(xCoord - 1, yCoord, zCoord, blockId);
				break;

			case 5:
				placeBlock(xCoord + 1, yCoord, zCoord, blockId);
				break;
			}
}

	public void placeBlock(int x, int y, int z, int blockId) {
	if (worldObj.isAirBlock(x, y, z)) {
			worldObj.setBlock(x, y, z, blockId, inventory.getItemDamage(), 2);
			inventory.stackSize --;
			onInventoryChanged();
	}
}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		
		NBTTagList items = new NBTTagList();
			
			ItemStack stack = getStackInSlot(0);
			
			if (stack != null) {
				NBTTagCompound item = new NBTTagCompound();
				stack.writeToNBT(item);
				items.appendTag(item);
			}
		
		compound.setTag("Items", items);
		
		compound.setShort("side", (short) side);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		
		NBTTagList items = compound.getTagList("Items");
		if ((NBTTagCompound)items.tagAt(0) != null) {
			NBTTagCompound item = (NBTTagCompound)items.tagAt(0);
			int slot = item.getByte("Slot");
			
			setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
		}
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
	public ItemStack decrStackSize(int i, int count) {
		ItemStack itemstack = getStackInSlot(i);
		
		if (itemstack != null) {
			if (itemstack.stackSize <= count) {
				setInventorySlotContents(i, null);
			}else{
				itemstack = itemstack.splitStack(count);
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
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}
		
		onInventoryChanged();
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
		return (itemstack.getItem() instanceof IPlantable || itemstack.getItem() instanceof ItemBlock);
	}
}
