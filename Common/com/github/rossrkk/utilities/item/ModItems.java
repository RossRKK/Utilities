package com.github.rossrkk.utilities.item;

import com.github.rossrkk.utilities.lib.IDs;

import net.minecraft.item.Item;

public class ModItems {
    
    public static Item cobbleHolder;
    
    public static void init() {
        //Initialise all the items
        cobbleHolder = new CobbleHolder(IDs.COBBLE_HOLDER_ID);
    }
}
