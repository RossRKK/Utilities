package com.github.rossrkk.utilities.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
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
        // if cobble has been absorbed
        boolean cobbleAbsorbed = false;
        if (cobbleAbsorbed) {
            // loop through each stack in the inventory and chaeck if it's
            // cobble
            for (int i = 0; i < 36; i++) {
                if (player.inventory.getStackInSlot(i).itemID == 4) {
                    // add the size of the itemstack to cobbleheld
                    cobbleHeld = cobbleHeld
                            + player.inventory.getStackInSlot(i).stackSize;
                }
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
