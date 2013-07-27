package com.github.rossrkk.utilities.util;

import java.util.List;

import com.github.rossrkk.utilities.item.Items;
import com.github.rossrkk.utilities.lib.IDs;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingManager {
	
	public static void init() {
		// Crafting Recipes

        // Omni tool recipes
        GameRegistry.addShapelessRecipe(new ItemStack(Items.omnitoolDiamond, 1),
                Item.axeDiamond, Item.pickaxeDiamond, Item.hoeDiamond,
                Item.shovelDiamond, Item.swordDiamond);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.omnitoolGold, 1),
                Item.axeGold, Item.pickaxeGold, Item.hoeGold, Item.shovelGold,
                Item.swordGold);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.omnitoolIron, 1),
                Item.axeIron, Item.pickaxeIron, Item.hoeIron, Item.shovelIron,
                Item.swordIron);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.omnitoolStone, 1),
                Item.axeStone, Item.pickaxeStone, Item.hoeStone,
                Item.shovelStone, Item.swordStone);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.omnitoolWood, 1),
                Item.axeWood, Item.pickaxeWood, Item.hoeWood, Item.shovelWood,
                Item.swordWood);
        
        //Cobble Holder Recipe
        GameRegistry.addShapedRecipe(new ItemStack(Items.cobbleHolder, 1), new Object[]{
        "SES",
        "LPL",
        "BLB", 
        'S', Item.silk, 'E', Item.emerald,'L', Item.leather, 'P', Item.enderPearl, 'B', Item.blazeRod});

        // Smelting Recipes
        
        GameRegistry.addSmelting(IDs.blockOreTuridiumID, new ItemStack(Items.ingotTuridium, 1), 1);

        // rotten flesh --> leather
        GameRegistry.addSmelting(Item.rottenFlesh.itemID, new ItemStack(Item.leather, 1), 1);
	}

}
