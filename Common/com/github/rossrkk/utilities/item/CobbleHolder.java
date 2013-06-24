package com.github.rossrkk.utilities.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.github.rossrkk.utilities.lib.Strings;


public class CobbleHolder extends Item {

    public CobbleHolder(int id) {
        super(id);
        maxStackSize = 1;
        this.setUnlocalizedName(Strings.COBBLE_HOLDER_NAME);
        this.setCreativeTab(CreativeTabs.tabTools);
        setNoRepair();
    }
    
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        
        
        int cobbleHeld = 0;
        boolean cobbleAbsorbed = false;
        if (cobbleAbsorbed) {
            for (int i = 0; i < 36; i++) {
                if (par3EntityPlayer.inventory.getStackInSlot(i).itemID == 4) {
                cobbleHeld= cobbleHeld + par3EntityPlayer.inventory.getStackInSlot(i).stackSize;
                }
            }
            par3EntityPlayer.inventory.clearInventory(4, -1);
        } else {
            
        }
        return par1ItemStack;
        
    }

}
