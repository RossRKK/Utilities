package com.github.rossrkk.utilities;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

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
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class Utilities {

	public static CreativeTabs utilTab;

    @PreInit
    public void ModsToLoad(FMLPreInitializationEvent event) {
    	
    	ConfigLoader.init(event.getSuggestedConfigurationFile());
    	
    	//Thanks SciGuy1121http://www.youtube.com/watch?v=8C_ptdFOIiE
    	utilTab = new CreativeTabs("util_utilities"){
    		public ItemStack getIconItemStack(){ return new ItemStack(Items.cobbleHolder); }
    	};
    	
    	
        Items.init();
    }

    @Init
    public void load(FMLInitializationEvent event) {
    	CraftingManager.init();
    	languageRegisters();
    }

    @PostInit
    public void modsLoaded(FMLPostInitializationEvent event) {
    }
    
    public static void languageRegisters() {
        LanguageRegistry.addName(Items.cobbleHolder, "Cobble Holder");

        // Omnitools
        LanguageRegistry.addName(Items.omnitoolDiamond, "Diamond Omni Tool");
        LanguageRegistry.addName(Items.omnitoolGold, "Gold Omni Tool");
        LanguageRegistry.addName(Items.omnitoolIron, "Iron Omni Tool");
        LanguageRegistry.addName(Items.omnitoolStone, "Stone Omni Tool");
        LanguageRegistry.addName(Items.omnitoolWood, "Wooden Omni Tool");
        
        
        LanguageRegistry.instance().addStringLocalization("itemGroup.util_utilities", "Utilities");
    }
}