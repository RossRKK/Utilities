package com.github.rossrkk.utilities;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import com.github.rossrkk.utilities.block.Blocks;
import com.github.rossrkk.utilities.gui.GuiHandler;
import com.github.rossrkk.utilities.item.Items;
import com.github.rossrkk.utilities.lib.Reference;
import com.github.rossrkk.utilities.util.ConfigLoader;
import com.github.rossrkk.utilities.util.CraftingManager;
import com.github.rossrkk.utilities.world.GenerationHandeler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(channels = {Reference.CHANNEL}, clientSideRequired = true, serverSideRequired = false) 
public class Utilities {
	
	@Instance(Reference.MOD_ID)
	public static Utilities instance;

	public static CreativeTabs utilTab;

    @EventHandler
    public void ModsToLoad(FMLPreInitializationEvent event) {
    	
    	ConfigLoader.init(event.getSuggestedConfigurationFile());
    	
    	//Thanks SciGuy1121 http://www.youtube.com/watch?v=8C_ptdFOIiE
    	utilTab = new CreativeTabs("util_utilities"){
    		@Override
			public ItemStack getIconItemStack(){ return new ItemStack(Items.cobbleHolder); }
    	};
    	
    	
        Items.init();
        Blocks.init();
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
    	CraftingManager.init();
    	languageRegisters();
    	
    	new GenerationHandeler();
		new GuiHandler();
    }

    @EventHandler
    public void modsLoaded(FMLPostInitializationEvent event) {
    }
    
    public static void languageRegisters() {
    	 LanguageRegistry.instance().addStringLocalization("itemGroup.util_utilities", "Utilities");
    }
}