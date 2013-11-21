package com.github.rossrkk.utilities.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.github.rossrkk.utilities.tileentities.TEElectricFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerElectricFurnace extends Container {

	public TEElectricFurnace machine;

	public int numRows = 1;

	public ContainerElectricFurnace(InventoryPlayer invPlayer, TEElectricFurnace machine) {
		this.machine = machine;

		for (int x = 0; x < 9; x++) {
			addSlotToContainer(new Slot(invPlayer, x, 8 + 18 * x, 142));
		}

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18));
			}
		}

		addSlotToContainer(new SlotElectricFurnace(machine, 1, 116, 35));
		addSlotToContainer(new Slot(machine, 0, 56, 35));
	}

	@Override
	public void addCraftingToCrafters(ICrafting player) {
		super.addCraftingToCrafters(player);

		player.sendProgressBarUpdate(this, 0, machine.cookTime);
		player.sendProgressBarUpdate(this, 1, machine.power);
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return machine.isUseableByPlayer(entityplayer);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
		ItemStack itemstack = null;
		Slot slot = (Slot)inventorySlots.get(par2);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (par2 < numRows * 9)
			{
				if (!mergeItemStack(itemstack1, numRows * 9, inventorySlots.size(), true))
				{
					return null;
				}
			}
			else if (!mergeItemStack(itemstack1, 0, numRows * 9, false))
			{
				return null;
			}

			if (itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack)null);
			}
			else
			{
				slot.onSlotChanged();
			}
		}

		return itemstack;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) {
		switch (id) {
		case 0: machine.cookTime = data;
		break;
		case 1: machine.power = data;
		break;
		}
	}
}
