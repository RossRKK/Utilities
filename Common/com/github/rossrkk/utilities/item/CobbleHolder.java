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
    
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        
        
        int cobbleHeld = 0;
        boolean cobbleAbsorbed = false;
        if (cobbleAbsorbed) {
            for (int i = 0; i < 36; i++) {
                if (player.inventory.getStackInSlot(i).itemID == 4) {
                cobbleHeld= cobbleHeld + player.inventory.getStackInSlot(i).stackSize;
                }
            }
            player.inventory.clearInventory(4, -1);
        } else {
            
        }
        return itemStack;
        
    }

}
