package com.github.rossrkk.utilities.tileentities;

import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TEBlockBreaker extends TileEntity{
	
	public static int side;
	
	@Override
	public void updateEntity() {
		if (!worldObj.isRemote && worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)) {
			side = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
			switch (side) {
			case 0: worldObj.destroyBlock(xCoord, yCoord - 1, zCoord, true);
			break;
			case 1: worldObj.destroyBlock(xCoord, yCoord + 1, zCoord, true);
			break;
			case 2: worldObj.destroyBlock(xCoord, yCoord, zCoord - 1, true);
			break;
			case 3: worldObj.destroyBlock(xCoord, yCoord, zCoord + 1, true);
			break;
			case 4: worldObj.destroyBlock(xCoord - 1, yCoord, zCoord, true);
			break;
			case 5: worldObj.destroyBlock(xCoord + 1, yCoord, zCoord, true);
			break;
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		
		compound.setShort("side", (short)side);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		
		side = compound.getShort("side");
	}
}
