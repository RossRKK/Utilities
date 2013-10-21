package com.github.rossrkk.utilities.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

import com.github.rossrkk.utilities.tileentities.TEBlockPlacer;
import com.github.rossrkk.utilities.tileentities.TEMiner;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerMiner extends Container {
		
		public TEMiner machine;
		
		public int numRows = 1;

		public ContainerMiner(InventoryPlayer invPlayer, TEMiner machine) {
			this.machine = machine;
			
			for (int x = 0; x < 9; x++) {
				addSlotToContainer(new Slot(invPlayer, x, 8 + 18 * x, 130));
			}
			
			for (int y = 0; y < 3; y++) {
				for (int x = 0; x < 9; x++) {
					addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 8 + 18 * x, 72 + y * 18));
				}
			}
			
			addSlotToContainer(new SlotDiamondPick(machine, 0, 12, 10));
			//addSlotToContainer(new Slot(machine, 1, 12, 41));
			
			int index = 1;
			for (int y = 0; y < 3; y++) {
				for (int x = 0; x < 3; x++) {
					addSlotToContainer(new Slot(machine, index, x * 21 + 79, 6 + y * 20));
					index++;
				}
			}
		}

		@Override
		public boolean canInteractWith(EntityPlayer entityplayer) {
			return machine.isUseableByPlayer(entityplayer);
		}

		@Override
		public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
			ItemStack itemstack = null;
	        Slot slot = (Slot)this.inventorySlots.get(par2);

	        if (slot != null && slot.getHasStack())
	        {
	            ItemStack itemstack1 = slot.getStack();
	            itemstack = itemstack1.copy();

	            if (par2 < this.numRows * 9)
	            {
	                if (!this.mergeItemStack(itemstack1, this.numRows * 9, this.inventorySlots.size(), true))
	                {
	                    return null;
	                }
	            }
	            else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 9, false))
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
		public void addCraftingToCrafters(ICrafting player) {
			super.addCraftingToCrafters(player);

			player.sendProgressBarUpdate(this, 0, machine.power);
		}

		@Override
		@SideOnly(Side.CLIENT)
		public void updateProgressBar(int id, int data) {
			switch (id) {
			case 0: machine.power = data;
			break;
			}
		}
}