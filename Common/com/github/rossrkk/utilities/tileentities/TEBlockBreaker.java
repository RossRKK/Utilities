package com.github.rossrkk.utilities.tileentities;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.IPlantable;

public class TEBlockBreaker extends TileEntity implements IInventory{
	
	public static int side;
	public static ItemStack inventory;
	
	@Override
	public void updateEntity() {
		onInventoryChanged();
		if (!worldObj.isRemote && worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)) {
			side = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
			switch (side) {
			case 0: breakBlock(xCoord, yCoord - 1, zCoord);
			break;
			case 1: breakBlock(xCoord, yCoord + 1, zCoord);
			break;
			case 2: breakBlock(xCoord, yCoord, zCoord - 1);
			break;
			case 3: breakBlock(xCoord, yCoord, zCoord + 1);
			break;
			case 4: breakBlock(xCoord - 1, yCoord, zCoord);
			break;
			case 5: breakBlock(xCoord + 1, yCoord, zCoord);
			break;
			}
		}
	}
	
	public void breakBlock(int x, int y, int z) {
		int id = worldObj.getBlockId(x, y, z);
		int metadata = worldObj.getBlockMetadata(x, y, z);
		ItemStack stack = new ItemStack(worldObj.getBlockId(x, y, z), 1, metadata);
		if (isItemValidForSlot(0, stack)) {
			setInventorySlotContents(0, stack);
			worldObj.destroyBlock(x, y, z, false);
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
		
			NBTTagCompound item = (NBTTagCompound)items.tagAt(0);
			int slot = item.getByte("Slot");
			
			setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
		
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
		return "blockBreaker";
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
		return true;
	}
}
