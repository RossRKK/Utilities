package com.github.rossrkk.utilities.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.github.rossrkk.utilities.lib.IDs;
import com.github.rossrkk.utilities.lib.Reference;
import com.github.rossrkk.utilities.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks {
	
	public static Block turidiumOre;
	public static Block blockBreaker;
	public static Block blockPlacer;
	
	public static void init() {
		//create instances of each block
		turidiumOre  = new BlockOreTuridium(IDs.blockOreTuridiumID, Material.rock);
		blockBreaker = new BlockBlockBreaker(IDs.blockBreakerID, Material.rock);
		blockPlacer = new BlockBlockPlacer(IDs.blockPlacerID, Material.rock);
		
		gameRegisters();
		languageRegisters();
	}
	
	public static void gameRegisters() {
		GameRegistry.registerBlock(turidiumOre, Strings.BLOCK_ORE_TURIDIUM_NAME + Reference.MOD_ID);
		GameRegistry.registerBlock(blockBreaker, Strings.BLOCK_BREAKER_NAME + Reference.MOD_ID);
		GameRegistry.registerBlock(blockPlacer, Strings.BLOCK_PLACER_NAME + Reference.MOD_ID);
	}
	
	public static void languageRegisters() {
		LanguageRegistry.addName(turidiumOre, "Turidium Ore");
		LanguageRegistry.addName(blockBreaker, "Block Breaker");
		LanguageRegistry.addName(blockPlacer, "Block Placer");
	}
}
