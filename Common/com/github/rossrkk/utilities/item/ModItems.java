package com.github.rossrkk.utilities.item;

import com.github.rossrkk.utilities.lib.IDs;
import com.github.rossrkk.utilities.lib.Reference;
import com.github.rossrkk.utilities.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
    
    public static Item cobbleHolder;
    
    public static void init() {
        //Initialise all the items
        cobbleHolder = new CobbleHolder(IDs.COBBLE_HOLDER_ID);
        
        //Register Items
        GameRegistry.registerItem(cobbleHolder, Strings.COBBLE_HOLDER_NAME, Reference.MOD_ID);
    }
}