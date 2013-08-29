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

public class TEBlockBreaker extends TileEntity {
	
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
		worldObj.destroyBlock(x, y, z, true);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		
		compound.setShort("side", (short) side);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		side = compound.getShort("side");
	}
}
