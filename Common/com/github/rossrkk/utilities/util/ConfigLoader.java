package com.github.rossrkk.utilities.util;

import java.io.File;

import net.minecraftforge.common.Configuration;

import com.github.rossrkk.utilities.lib.IDs;
import com.github.rossrkk.utilities.lib.Strings;

public class ConfigLoader {
	public static void init(File file) {
		Configuration config = new Configuration(file);
		config.load();

		IDs.blockOreTuridiumID = config.getBlock(Strings.BLOCK_ORE_TERIDIUM_KEY, IDs.BLOCK_ORE_TURIDIUM_DEFAULT_ID).getInt() - 256;
		IDs.blockBreakerID = config.getBlock(Strings.BLOCK_BREAKER_KEY, IDs.BLOCK_BREAKER_DEFAULT_ID).getInt() - 256;
		IDs.blockPlacerID = config.getBlock(Strings.BLOCK_PLACER_KEY, IDs.BLOCK_PLACER_DEFAULT_ID).getInt() - 256;
		IDs.blockFullStoneSlabID = config.getBlock(Strings.FULL_STONE_SLAB_KEY, IDs.FULL_STONE_SLAB_DEFAULT_ID).getInt() - 256;
		IDs.blockJumpPad = config.getBlock(Strings.JUMP_PAD_KEY, IDs.JUMP_PAD_DEFAULT_ID).getInt() - 256;
		IDs.blockMiner = config.getBlock(Strings.MINER_KEY, IDs.MINER_DEFAULT_ID).getInt() - 256;
		IDs.cable = config.getBlock(Strings.CABLE_KEY, IDs.CABLE_DEFAULT_ID).getInt() - 256;
		IDs.battery = config.getBlock(Strings.BATTERY_NAME, IDs.BATTERY_DEFAULT_ID).getInt() - 256;
		IDs.creativeGenerator = config.getBlock(Strings.CREATIVE_GENERATOR_NAME, IDs.CREATIVE_GENERATOR_DEFAULT_ID).getInt() - 256;
		IDs.clearGlass = config.getBlock(Strings.CLEAR_GLASS_NAME, IDs.CLEAR_GLASS_DEFAULT_ID).getInt() - 256;
		IDs.coalGen = config.getBlock(Strings.COAL_GEN_NAME, IDs.COAL_GEN_DEFAULT_ID).getInt() - 256;
		IDs.elctricFurnace = config.getBlock(Strings.ELECTRIC_FURNACE_NAME, IDs.ELECTRIC_FURNACE_DEFAULT_ID).getInt() - 256;
		IDs.solar = config.getBlock(Strings.SOLAR_NAME, IDs.SOLAR_DEFAULT_ID).getInt() - 256;

		IDs.cobbleHolderID = config.getItem(Strings.COBBLE_HOLDER_KEY, IDs.COBBLE_HOLDER_DEFAULT_ID).getInt() - 256;

		IDs.ingotTuridiumID = config.getItem(Strings.INGOT_TURIDIUM_KEY, IDs.INGOT_TURIDIUM_DEFAULT_ID).getInt() - 256;

		IDs.enderPouchID = config.getItem(Strings.ENDER_POUCH_KEY, IDs.ENDER_POUCH_DEFAULT_ID).getInt() - 256;

		IDs.omniToolDiamondID = config.getItem(Strings.OMNI_TOOL_DIAMOND_KEY, IDs.OMNI_TOOL_DIAMOND_DEFAULT_ID).getInt() - 256;
		IDs.omniToolGoldID = config.getItem(Strings.OMNI_TOOL_GOLD_KEY, IDs.OMNI_TOOL_GOLD_DEFAULT_ID).getInt() - 256;
		IDs.omniToolIronID = config.getItem(Strings.OMNI_TOOL_IRON_KEY, IDs.OMNI_TOOL_IRON_DEFAULT_ID).getInt() - 256;
		IDs.omniToolStoneID = config.getItem(Strings.OMNI_TOOL_STONE_KEY, IDs.OMNI_TOOL_STONE_DEFAULT_ID).getInt() - 256;
		IDs.omniToolWoodID = config.getItem(Strings.OMNI_TOOL_WOOD_KEY, IDs.OMNI_TOOL_WOOD_DEFAULT_ID).getInt() - 256;
		IDs.omniToolTuridiumID = config.getItem(Strings.OMNI_TOOL_TURIDIUM_KEY, IDs.OMNI_TOOL_TURIDIUM_DEFAULT_ID).getInt() - 256;

		IDs.turidiumSwordID = config.getItem("turidiumSword", IDs.TURIDIUM_SWORD_DEFAULT_ID).getInt() - 256;
		IDs.turidiumPickID = config.getItem("turidiumPick", IDs.TURIDIUM_PICK_DEFAULT_ID).getInt() - 256;
		IDs.turidiumAxeID = config.getItem("turidiumAxe", IDs.TURIDIUM_AXE_DEFAULT_ID).getInt() - 256;
		IDs.turidiumShovelID = config.getItem("turidiumShovel", IDs.TURIDIUM_SHOVEL_DEFAULT_ID).getInt() - 256;
		IDs.turidiumHoeID = config.getItem("turidiumHoe", IDs.TURIDIUM_HOE_DEFAULT_ID).getInt() - 256;

		config.save();
	}
}
