package com.github.rossrkk.utilities;

import net.minecraft.item.Item;

import com.github.rossrkk.utilities.item.CobbleHolder;
import com.github.rossrkk.utilities.lib.IDs;
import com.github.rossrkk.utilities.lib.Reference;
import com.github.rossrkk.utilities.lib.Strings;
import com.github.rossrkk.utilities.recipes.CopperTransmute;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)

public class Utilities {
    
    
    //create item instances
    public static Item cobbleHolder;
    public static Item omnitool;
    
    @PreInit
    public void ModsToLoad(FMLPreInitializationEvent event) {
        //Initialise all the items
        cobbleHolder = new CobbleHolder(IDs.COBBLE_HOLDER_ID);
        omnitool = new CobbleHolder(IDs.OMNI_TOOL_ID);
    }
    
    @Init
    public void load(FMLInitializationEvent event) {

    }
    @PostInit
    public void modsLoaded(FMLPostInitializationEvent event) {
        //load EE3 Modules
        CopperTransmute.init();
    }
    
    //register items in game
    public static void gameRegisters() {
        GameRegistry.registerItem(cobbleHolder, Strings.COBBLE_HOLDER_NAME, Reference.MOD_ID);
        GameRegistry.registerItem(omnitool, Strings.OMNI_TOOL_NAME, Reference.MOD_ID);
    }
    
    public static void langugeRegisters() {
        LanguageRegistry.addName(cobbleHolder, "Cobble Holder");
        LanguageRegistry.addName(omnitool, "Omni Tool");
    }
}
