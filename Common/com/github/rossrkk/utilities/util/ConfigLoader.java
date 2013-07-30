package com.github.rossrkk.utilities.util;

import java.io.File;

import com.github.rossrkk.utilities.lib.IDs;
import com.github.rossrkk.utilities.lib.Strings;

import net.minecraftforge.common.Configuration;

public class ConfigLoader {
	public static void init(File file) {
		Configuration config = new Configuration(file);
		config.load();
		
		IDs.blockOreTuridiumID = config.getBlock(Strings.BLOCK_ORE_TERIDIUM_KEY, IDs.BLOCK_ORE_TURIDIUM_DEFAULT_ID).getInt() - 256;
		IDs.blockBreakerID = config.getBlock(Strings.BLOCK_BREAKER_KEY, IDs.BLOCK_BREAKER_DEFAULT_ID).getInt() - 256;
		IDs.blockBreakerID = config.getBlock(Strings.BLOCK_PLACER_KEY, IDs.BLOCK_PLACER_DEFAULT_ID).getInt() - 256;
		
		IDs.cobbleHolderID = config.getItem(Strings.COBBLE_HOLDER_KEY, IDs.COBBLE_HOLDER_DEFAULT_ID).getInt() - 256;
		
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
