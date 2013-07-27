package com.github.rossrkk.utilities.item;

import com.github.rossrkk.utilities.lib.IDs;
import com.github.rossrkk.utilities.lib.Reference;
import com.github.rossrkk.utilities.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class Items {
	// create item instances
	
		public static Item ingotTuridium;
		public static Item enderPouch;
	
		//holders
	    public static Item cobbleHolder;

	    // omni tools
	    public static Item omnitoolDiamond;
	    public static Item omnitoolGold;
	    public static Item omnitoolIron;
	    public static Item omnitoolStone;
	    public static Item omnitoolWood;
	    
	    public static void init() {
	    	// Initialise all the items
	    	
	    	enderPouch = new ItemEnderPouch(IDs.enderPouchID);
	    	
	    	ingotTuridium = new ItemIngotTuridium(IDs.ingotTuridiumID);
	    	
	        cobbleHolder = new ItemCobbleHolder(IDs.cobbleHolderID);
	        
	        // Omnitools
	        omnitoolDiamond = new ItemOmniToolDiamond(IDs.omniToolDiamondID,
	                EnumToolMaterial.EMERALD);
	        omnitoolGold = new ItemOmniToolGold(IDs.omniToolGoldID,
	                EnumToolMaterial.GOLD);
	        omnitoolIron = new ItemOmniToolIron(IDs.omniToolIronID,
	                EnumToolMaterial.IRON);
	        omnitoolStone = new ItemOmniToolStone(IDs.omniToolStoneID,
	                EnumToolMaterial.STONE);
	        omnitoolWood = new ItemOmniToolWood(IDs.omniToolWoodID,
	                EnumToolMaterial.WOOD);
	        
	        gameRegisters();
	        languageRegisters();
	        
	        //World generation
	        	//Generated Chests
	    	ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(cobbleHolder, 1), 1, 1, 1));
	    	//ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(cobbleHolder, 1), 1, 1, 1));
	    	ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(cobbleHolder, 1), 1, 1, 1));
	    }
	    
	    // register items in game
	    public static void gameRegisters() {
	        GameRegistry.registerItem(cobbleHolder, Strings.COBBLE_HOLDER_NAME,
	                Reference.MOD_ID);
	        
	        GameRegistry.registerItem(enderPouch, Strings.ENDER_POUCH_NAME, Reference.MOD_ID);
	        
	        GameRegistry.registerItem(ingotTuridium, Strings.INGOT_TURIDIUM_NAME, Reference.MOD_ID);

	        // Omnitools
	        GameRegistry.registerItem(omnitoolDiamond, Strings.OMNI_TOOL_DIAMOND_NAME,
	                Reference.MOD_ID);
	        GameRegistry.registerItem(omnitoolGold, Strings.OMNI_TOOL_GOLD_NAME,
	                Reference.MOD_ID);
	        GameRegistry.registerItem(omnitoolIron, Strings.OMNI_TOOL_IRON_NAME,
	                Reference.MOD_ID);
	        GameRegistry.registerItem(omnitoolStone, Strings.OMNI_TOOL_STONE_NAME,
	                Reference.MOD_ID);
	        GameRegistry.registerItem(omnitoolWood, Strings.OMNI_TOOL_WOOD_NAME,
	                Reference.MOD_ID);
	    }
	    
	    public static void languageRegisters() {

	        LanguageRegistry.addName(Items.cobbleHolder, "Cobble Holder");
	        
	        LanguageRegistry.addName(ingotTuridium, "Turidium Ingot");
	        
	        LanguageRegistry.addName(enderPouch, "Ender Pouch");
	    	
	        // Omnitools
	        LanguageRegistry.addName(Items.omnitoolDiamond, "Diamond Omni Tool");
	        LanguageRegistry.addName(Items.omnitoolGold, "Gold Omni Tool");
	        LanguageRegistry.addName(Items.omnitoolIron, "Iron Omni Tool");
	        LanguageRegistry.addName(Items.omnitoolStone, "Stone Omni Tool");
	        LanguageRegistry.addName(Items.omnitoolWood, "Wooden Omni Tool");
	    }
}
