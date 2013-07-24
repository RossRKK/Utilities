package com.github.rossrkk.utilities;

import com.github.rossrkk.utilities.item.Items;
import com.github.rossrkk.utilities.lib.Reference;
import com.github.rossrkk.utilities.util.ConfigLoader;
import com.github.rossrkk.utilities.util.CraftingManager;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class Utilities {


    @PreInit
    public void ModsToLoad(FMLPreInitializationEvent event) {
    	
    	ConfigLoader.init(event.getSuggestedConfigurationFile());
    	
        Items.init();
    }

    @Init
    public void load(FMLInitializationEvent event) {
    	CraftingManager.init();
    }

    @PostInit
    public void modsLoaded(FMLPostInitializationEvent event) {
    }
}