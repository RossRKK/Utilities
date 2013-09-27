package com.github.rossrkk.utilities.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.github.rossrkk.utilities.block.Blocks;
import com.github.rossrkk.utilities.item.Items;
import com.github.rossrkk.utilities.lib.IDs;

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
        GameRegistry.addShapelessRecipe(new ItemStack(Items.omnitoolTuridium, 1),
                Items.turidiumAxe, Items.turidiumPick, Items.turidiumHoe, Items.turidiumShovel,
                Items.turidiumSword);
        
        //Turidium tools
        GameRegistry.addShapedRecipe(new ItemStack(Items.turidiumPick, 1), new Object[]{
            "III",
            " S ",
            " S ", 
            'S', Item.stick, 'I', Items.ingotTuridium});
        
        GameRegistry.addShapedRecipe(new ItemStack(Items.turidiumAxe, 1), new Object[]{
            " II",
            " SI",
            " S ", 
            'S', Item.stick, 'I', Items.ingotTuridium});
        
        GameRegistry.addShapedRecipe(new ItemStack(Items.turidiumAxe, 1), new Object[]{
            "II ",
            "IS ",
            " S ", 
            'S', Item.stick, 'I', Items.ingotTuridium});
        
        GameRegistry.addShapedRecipe(new ItemStack(Items.turidiumHoe, 1), new Object[]{
            "II ",
            " S ",
            " S ", 
            'S', Item.stick, 'I', Items.ingotTuridium});
        
        GameRegistry.addShapedRecipe(new ItemStack(Items.turidiumHoe, 1), new Object[]{
            " II",
            " S ",
            " S ", 
            'S', Item.stick, 'I', Items.ingotTuridium});

        GameRegistry.addShapedRecipe(new ItemStack(Items.turidiumShovel, 1), new Object[]{
            " I ",
            " S ",
            " S ", 
            'S', Item.stick, 'I', Items.ingotTuridium});
        
        GameRegistry.addShapedRecipe(new ItemStack(Items.turidiumSword, 1), new Object[]{
            " I ",
            " I ",
            " S ", 
            'S', Item.stick, 'I', Items.ingotTuridium});
        
        //Cobble Holder Recipe
        GameRegistry.addShapedRecipe(new ItemStack(Items.cobbleHolder, 1), new Object[]{
	        "SES",
	        "LPL",
	        "BLB", 
	        'S', Item.silk, 'E', Item.emerald,'L', Item.leather, 'P', Item.enderPearl, 'B', Item.blazeRod});
        
        //Ender pouch recipe
        GameRegistry.addShapedRecipe(new ItemStack(Items.enderPouch, 1), new Object[]{
            " E ",
            "LCL",
            " L ", 
            'E', Items.ingotTuridium,'L', Item.leather, 'C', Block.enderChest});
        
        //Block Placer
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.blockPlacer), new Object[]{
        	"CTC",
        	"CPC",
        	"CRC",
        'C', Block.cobblestone, 'T', Items.ingotTuridium, 'R', Item.redstone, 'P', Block.pistonBase});
        
        //Block breaker
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.blockBreaker), new Object[]{
        	"C C",
        	"CPC",
        	"CRC",
        'C', Block.cobblestone, 'T', Items.ingotTuridium, 'R', Item.redstone, 'P', Block.pistonBase});
        
        //Full stone slab
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.fullStoneSlab), new Object[]{
        	"S",
        	"S",
        'S', Block.stoneSingleSlab});
        
        //Jump pad
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.jumpPad, 6), new Object[]{
        	"CTC",
        	"CPC",
        'C', Block.cobblestone, 'T', Items.ingotTuridium, 'R', Item.redstone, 'P', Block.pistonBase});
        
        //Cable
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.cable, 6), new Object[]{
        	"SSS",
        	"RRR",
        	"SSS",
        	'S', Block.stoneSingleSlab, 'R', Item.redstone
        });
        
        //Battery
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.battery, 1), new Object[]{
        	"WCW",
        	"TRT",
        	"WWW",
        	'W', Item.ingotIron, 'T', Items.ingotTuridium, 'C', Blocks.cable, 'R', Item.redstone
        });
        
        //Miner
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.miner, 1), new Object[]{
        	"IEI",
        	"ICI",
        	"T T",
        	'I', Item.ingotIron, 'E', Item.emerald, 'C', Block.chest, 'T', Items.ingotTuridium
        });

        // Smelting Recipes
        
        GameRegistry.addSmelting(IDs.blockOreTuridiumID, new ItemStack(Items.ingotTuridium, 1), 1);

        // rotten flesh --> leather
        GameRegistry.addSmelting(Item.rottenFlesh.itemID, new ItemStack(Item.leather, 1), 1);
        
        //clear glass
        GameRegistry.addSmelting(Block.glass.blockID, new ItemStack(Blocks.clearGlass, 1), 1);
	}

}
