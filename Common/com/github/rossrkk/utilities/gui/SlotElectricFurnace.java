package com.github.rossrkk.utilities.gui;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotElectricFurnace extends Slot {

	public SlotElectricFurnace(IInventory inventory, int slot, int x, int y) {
		super(inventory, slot, x, y);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return false;
	}
}
