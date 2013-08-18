package com.github.rossrkk.utilities.gui;

import com.github.rossrkk.utilities.tileentities.TEBlockPlacer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerPlacer extends Container {
	
	public TEBlockPlacer machine;

	public ContainerPlacer(InventoryPlayer invPlayer, TEBlockPlacer machine) {
		System.out.println("ContainerPlacer created");
		this.machine = machine;
		
		for (int x = 0; x < 9; x++) {
			addSlotToContainer(new Slot(invPlayer, x, 8 + 18 * x, 130));
		}
		
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 8 + 18 * x, 72 + y * 18));
			}
		}
		
		addSlotToContainer(new Slot(machine, 0, 26, 17));
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return machine.isUseableByPlayer(entityplayer);
	}

}
