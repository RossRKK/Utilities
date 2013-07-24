package com.github.rossrkk.utilities.util;

import com.github.rossrkk.utilities.item.Items;

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

        // Smelting Recipes

        // rotten flesh --> leather
        GameRegistry.addSmelting(111, new ItemStack(Item.leather, 1), 1);
	}
}
