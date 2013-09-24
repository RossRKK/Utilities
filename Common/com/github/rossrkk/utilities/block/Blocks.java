package com.github.rossrkk.utilities.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

import com.github.rossrkk.utilities.lib.IDs;
import com.github.rossrkk.utilities.lib.Reference;
import com.github.rossrkk.utilities.lib.Strings;
import com.github.rossrkk.utilities.tileentities.TEBattery;
import com.github.rossrkk.utilities.tileentities.TEBlockBreaker;
import com.github.rossrkk.utilities.tileentities.TEBlockPlacer;
import com.github.rossrkk.utilities.tileentities.TECable;
import com.github.rossrkk.utilities.tileentities.TEMiner;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks {
	
	public static Block turidiumOre;
	public static Block blockBreaker;
	public static Block blockPlacer;
	public static Block fullStoneSlab;
	public static Block jumpPad;
	public static Block clearGlass;
	
	public static Block miner;
	public static Block cable;
	public static Block battery;
	public static Block creativeGenerator;
	
	public static void init() {
		//create instances of each block
		turidiumOre  = new BlockOreTuridium(IDs.blockOreTuridiumID, Material.iron);
		blockBreaker = new BlockBlockBreaker(IDs.blockBreakerID, Material.iron);
		blockPlacer = new BlockBlockPlacer(IDs.blockPlacerID, Material.iron);
		fullStoneSlab = new BlockFullStoneSlab(IDs.blockFullStoneSlabID, Material.rock);
		jumpPad = new BlockJumpPad(IDs.blockJumpPad, Material.iron);
		
		miner = new BlockMiner(IDs.blockMiner, Material.iron);
		cable = new BlockCable(IDs.cable, Material.iron);
		battery = new BlockBattery(IDs.battery, Material.iron);
		creativeGenerator = new BlockCreativeGenerator(IDs.creativeGenerator, Material.iron);
		clearGlass = new BlockClearGlass(IDs.clearGlass, Material.glass);
		
		MinecraftForge.setBlockHarvestLevel(turidiumOre, "pickaxe", 2);
		
		gameRegisters();
		languageRegisters();
	}
	
	public static void gameRegisters() {
		GameRegistry.registerBlock(turidiumOre, Strings.BLOCK_ORE_TURIDIUM_NAME + Reference.MOD_ID);
		GameRegistry.registerBlock(blockBreaker, Strings.BLOCK_BREAKER_NAME + Reference.MOD_ID);
		GameRegistry.registerBlock(blockPlacer, Strings.BLOCK_PLACER_NAME + Reference.MOD_ID);
		GameRegistry.registerBlock(fullStoneSlab, Strings.FULL_STONE_SLAB_NAME + Reference.MOD_ID);
		GameRegistry.registerBlock(jumpPad, Strings.JUMP_PAD_NAME + Reference.MOD_ID);
		GameRegistry.registerBlock(miner, Strings.MINER_NAME + Reference.MOD_ID);
		GameRegistry.registerBlock(cable, Strings.CABLE_NAME + Reference.MOD_ID);
		GameRegistry.registerBlock(battery, Strings.BATTERY_NAME + Reference.MOD_ID);
		GameRegistry.registerBlock(creativeGenerator, Strings.CREATIVE_GENERATOR_NAME + Reference.MOD_ID);
		GameRegistry.registerBlock(clearGlass, Strings.CLEAR_GLASS_NAME + Reference.MOD_ID);
		
		GameRegistry.registerTileEntity(TEBlockBreaker.class, "blockBreaker");
		GameRegistry.registerTileEntity(TEBlockPlacer.class, "blockPlacer");
		GameRegistry.registerTileEntity(TEMiner.class, "miner");
		GameRegistry.registerTileEntity(TECable.class, "cable");
		GameRegistry.registerTileEntity(TEBattery.class, "battery");
	}
	
	public static void languageRegisters() {
		LanguageRegistry.addName(turidiumOre, "Turidium Ore");
		LanguageRegistry.addName(blockBreaker, "Block Breaker");
		LanguageRegistry.addName(blockPlacer, "Block Placer");
		LanguageRegistry.addName(fullStoneSlab, "Full Stone Slab");
		
		LanguageRegistry.addName(jumpPad, "Jump Pad");
		LanguageRegistry.addName(miner, "Miner");
		LanguageRegistry.addName(cable, "Cable");
		LanguageRegistry.addName(battery, "Battery");
		LanguageRegistry.addName(creativeGenerator, "Creative Generator");
		LanguageRegistry.addName(clearGlass, "Clear Glass");
	}
}
