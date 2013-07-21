package com.github.rossrkk.utilities.item;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.github.rossrkk.utilities.lib.Strings;

public class CobbleHolder extends UtilItem {

    public CobbleHolder(int id) {
        super(id);
        maxStackSize = 1;
        this.setUnlocalizedName(Strings.COBBLE_HOLDER_NAME);
        this.setCreativeTab(CreativeTabs.tabTools);
        this.setNoRepair();
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world,
            EntityPlayer player) {

        // how much cobble has been absorbed
        int cobbleHeld = 0;
        
        //the inventory being searched
        ItemStack[] inventory = player.inventory.mainInventory;
        
        // if cobble has been absorbed
        boolean cobbleAbsorbed = false;
        
        if (!cobbleAbsorbed) {
            // loop through each stack in the inventory and check if it's
            // cobble
            for (int i = 1; i < 36; i++) {
            	try{
	                if(inventory[i].itemID == 4) {
	                    // add the size of the itemstack to cobbleheld
	                    cobbleHeld = cobbleHeld
	                            + player.inventory.getStackInSlot(i).stackSize;
	                    player.inventory.getStackInSlot(i).stackSize = 0;
	                }
            	} catch (NullPointerException e) {/*Swallowed*/}
                // clear the inventory of cobble
                player.inventory.clearInventory(4, -1);
                cobbleAbsorbed = true;
            }
        } else {

        }
        System.out.println(cobbleHeld);
        return itemStack;
    }

}
