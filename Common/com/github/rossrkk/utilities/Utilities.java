package com.github.rossrkk.utilities;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

import com.github.rossrkk.utilities.item.CobbleHolder;
import com.github.rossrkk.utilities.item.ItemOmniToolDiamond;
import com.github.rossrkk.utilities.item.ItemOmniToolGold;
import com.github.rossrkk.utilities.item.ItemOmniToolIron;
import com.github.rossrkk.utilities.item.ItemOmniToolStone;
import com.github.rossrkk.utilities.item.ItemOmniToolWood;
import com.github.rossrkk.utilities.lib.IDs;
import com.github.rossrkk.utilities.lib.Reference;
import com.github.rossrkk.utilities.lib.Strings;

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

    // create item instances
	
	//holders
    public static Item cobbleHolder;
    public static Item dirtHolder;

    // omni tools
    public static Item omnitoolDiamond;
    public static Item omnitoolGold;
    public static Item omnitoolIron;
    public static Item omnitoolStone;
    public static Item omnitoolWood;

    @PreInit
    public void ModsToLoad(FMLPreInitializationEvent event) {
    	
    	ConfigLoader.init(event.getSuggestedConfigurationFile());
    	
        // Initialise all the items
    	
        cobbleHolder = new CobbleHolder(IDs.cobbleHolderID);
        
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
    }

    @Init
    public void load(FMLInitializationEvent event) {
    	gameRegisters();
    	langugeRegisters();
    	
    	//Generated Chests
    	ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(cobbleHolder, 1), 1, 1, 1));
    	ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(cobbleHolder, 1), 1, 1, 1));
    	ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(cobbleHolder, 1), 1, 1, 1));


    }

    @PostInit
    public void modsLoaded(FMLPostInitializationEvent event) {
        // load EE3 Modules
    }

    // register items in game
    public static void gameRegisters() {
        GameRegistry.registerItem(cobbleHolder, Strings.COBBLE_HOLDER_NAME,
                Reference.MOD_ID);

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

        // Crafting Recipes

        // Omni tool recipes
        GameRegistry.addShapelessRecipe(new ItemStack(omnitoolDiamond, 1),
                Item.axeDiamond, Item.pickaxeDiamond, Item.hoeDiamond,
                Item.shovelDiamond, Item.swordDiamond);
        GameRegistry.addShapelessRecipe(new ItemStack(omnitoolGold, 1),
                Item.axeGold, Item.pickaxeGold, Item.hoeGold, Item.shovelGold,
                Item.swordGold);
        GameRegistry.addShapelessRecipe(new ItemStack(omnitoolIron, 1),
                Item.axeIron, Item.pickaxeIron, Item.hoeIron, Item.shovelIron,
                Item.swordIron);
        GameRegistry.addShapelessRecipe(new ItemStack(omnitoolStone, 1),
                Item.axeStone, Item.pickaxeStone, Item.hoeStone,
                Item.shovelStone, Item.swordStone);
        GameRegistry.addShapelessRecipe(new ItemStack(omnitoolWood, 1),
                Item.axeWood, Item.pickaxeWood, Item.hoeWood, Item.shovelWood,
                Item.swordWood);

        // Smelting Recipes

        // rotten flesh --> leather
        GameRegistry.addSmelting(111, new ItemStack(Item.leather, 1), 1);
    }

    public static void langugeRegisters() {
        LanguageRegistry.addName(cobbleHolder, "Cobble Holder");

        // Omnitools
        LanguageRegistry.addName(omnitoolDiamond, "Diamond Omni Tool");
        LanguageRegistry.addName(omnitoolGold, "Gold Omni Tool");
        LanguageRegistry.addName(omnitoolIron, "Iron Omni Tool");
        LanguageRegistry.addName(omnitoolStone, "Stone Omni Tool");
        LanguageRegistry.addName(omnitoolWood, "Wooden Omni Tool");
    }
}