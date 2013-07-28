package com.github.rossrkk.utilities.item;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.EnumHelper;

import com.github.rossrkk.utilities.Utilities;
import com.github.rossrkk.utilities.lib.IDs;
import com.github.rossrkk.utilities.lib.Reference;
import com.github.rossrkk.utilities.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {
	// create item instances
	
		//turidium tools
		public static Item turidiumPick;
		public static Item turidiumSword;
		public static Item turidiumShovel;
		public static Item turidiumAxe;
		public static Item turidiumHoe;
	
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
		public static Item omnitoolTuridium;
	    
	    public static void init() {
	    	EnumToolMaterial turidium = EnumHelper.addToolMaterial("TURIDIUM", 2, 900, 9.0F, 3.5F, 12);
	    	// Initialise all the items
	    	
	    	enderPouch = new ItemEnderPouch(IDs.enderPouchID);
	    	
	    	ingotTuridium = new ItemIngotTuridium(IDs.ingotTuridiumID);
	    	
	        cobbleHolder = new ItemCobbleHolder(IDs.cobbleHolderID);
	        
	        // Omnitools
	        omnitoolDiamond = new ItemOmniTool(IDs.omniToolDiamondID,
	                EnumToolMaterial.EMERALD).setUnlocalizedName(Strings.OMNI_TOOL_DIAMOND_NAME).func_111206_d(Strings.OMNI_TOOL_GOLD_NAME);
	        omnitoolGold = new ItemOmniTool(IDs.omniToolGoldID,
	                EnumToolMaterial.GOLD).setUnlocalizedName(Strings.OMNI_TOOL_GOLD_NAME).func_111206_d(Strings.OMNI_TOOL_GOLD_NAME);
	        omnitoolIron = new ItemOmniTool(IDs.omniToolIronID,
	                EnumToolMaterial.IRON).setUnlocalizedName(Strings.OMNI_TOOL_IRON_NAME).func_111206_d(Strings.OMNI_TOOL_GOLD_NAME);
	        omnitoolStone = new ItemOmniTool(IDs.omniToolStoneID,
	                EnumToolMaterial.STONE).setUnlocalizedName(Strings.OMNI_TOOL_STONE_NAME).func_111206_d(Strings.OMNI_TOOL_GOLD_NAME);
	        omnitoolWood = new ItemOmniTool(IDs.omniToolWoodID,
	                EnumToolMaterial.WOOD).setUnlocalizedName(Strings.OMNI_TOOL_WOOD_NAME).func_111206_d(Strings.OMNI_TOOL_GOLD_NAME);
	        omnitoolTuridium = new ItemOmniTool(IDs.omniToolTuridiumID,
	                turidium).setUnlocalizedName(Strings.OMNI_TOOL_TURIDIUM_NAME);
	        
	        
	        
	        //turidium tools
	        turidiumPick = new ItemPickaxe(IDs.turidiumPickID, turidium).setCreativeTab(Utilities.utilTab).setUnlocalizedName(Strings.TURIDIUM_PICK_NAME).func_111206_d(Strings.TURIDIUM_PICK_NAME);
	        turidiumSword = new ItemSword(IDs.turidiumSwordID, turidium).setCreativeTab(Utilities.utilTab).setUnlocalizedName(Strings.TURIDIUM_SWORD_NAME).func_111206_d(Strings.TURIDIUM_SWORD_NAME);
	        turidiumShovel = new ItemSpade(IDs.turidiumShovelID, turidium).setCreativeTab(Utilities.utilTab).setUnlocalizedName(Strings.TURIDIUM_SHOVEL_NAME).func_111206_d(Strings.TURIDIUM_SHOVEL_NAME);
	        turidiumAxe = new ItemAxe(IDs.turidiumAxeID, turidium).setCreativeTab(Utilities.utilTab).setUnlocalizedName(Strings.TURIDIUM_AXE_NAME).func_111206_d(Strings.TURIDIUM_AXE_NAME);
	        turidiumHoe = new ItemHoe(IDs.turidiumHoeID, turidium).setCreativeTab(Utilities.utilTab).setUnlocalizedName(Strings.TURIDIUM_HOE_NAME).func_111206_d(Strings.TURIDIUM_HOE_NAME);
	        
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
	        GameRegistry.registerItem(omnitoolTuridium, Strings.OMNI_TOOL_TURIDIUM_NAME,
	                Reference.MOD_ID);
	    }
	    
	    public static void languageRegisters() {

	        LanguageRegistry.addName(cobbleHolder, "Cobble Holder");
	        
	        LanguageRegistry.addName(ingotTuridium, "Turidium Ingot");
	        
	        LanguageRegistry.addName(enderPouch, "Ender Pouch");
	    	
	        // Omnitools
	        LanguageRegistry.addName(omnitoolDiamond, "Diamond Omni Tool");
	        LanguageRegistry.addName(omnitoolGold, "Gold Omni Tool");
	        LanguageRegistry.addName(omnitoolIron, "Iron Omni Tool");
	        LanguageRegistry.addName(omnitoolStone, "Stone Omni Tool");
	        LanguageRegistry.addName(omnitoolWood, "Wooden Omni Tool");
	        LanguageRegistry.addName(omnitoolTuridium, "Turidium Omni Tool");
	        
	        //Turidium tools
	        LanguageRegistry.addName(turidiumPick, "Turidium Pickaxe");
	        LanguageRegistry.addName(turidiumSword, "Turidium Sword");
	        LanguageRegistry.addName(turidiumAxe, "Turidium Axe");
	        LanguageRegistry.addName(turidiumShovel, "Turidium Shovel");
	        LanguageRegistry.addName(turidiumHoe, "Turidium Hoe");

	    }
}
