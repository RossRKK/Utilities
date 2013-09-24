package com.github.rossrkk.utilities.gui;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.github.rossrkk.utilities.item.Items;

public class SlotDiamondPick extends Slot {

	public SlotDiamondPick(IInventory inventory, int index, int x,int y) {
		super(inventory, index, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
        return stack.itemID == Item.pickaxeDiamond.itemID || stack.itemID == Items.turidiumPick.itemID;
    }
}
