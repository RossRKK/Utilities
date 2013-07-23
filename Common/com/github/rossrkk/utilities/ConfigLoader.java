package com.github.rossrkk.utilities;

import java.io.File;

import com.github.rossrkk.utilities.lib.IDs;
import com.github.rossrkk.utilities.lib.Strings;

import net.minecraftforge.common.Configuration;

public class ConfigLoader {
	public static void init(File file) {
		Configuration config = new Configuration(file);
		config.load();
		
		IDs.cobbleHolderID = config.getItem(Strings.COBBLE_HOLDER_KEY, IDs.COBBLE_HOLDER_DEFAULT_ID).getInt() - 256;
		
		IDs.omniToolDiamondID = config.getItem(Strings.OMNI_TOOL_DIAMOND_KEY, IDs.OMNI_TOOL_DIAMOND_DEFAULT_ID).getInt() - 256;		IDs.omniToolDiamondID = config.getItem(Strings.OMNI_TOOL_DIAMOND_KEY, IDs.OMNI_TOOL_DIAMOND_DEFAULT_ID).getInt() - 256;
		IDs.omniToolGoldID = config.getItem(Strings.OMNI_TOOL_GOLD_KEY, IDs.OMNI_TOOL_GOLD_DEFAULT_ID).getInt() - 256;
		IDs.omniToolIronID = config.getItem(Strings.OMNI_TOOL_IRON_KEY, IDs.OMNI_TOOL_IRON_DEFAULT_ID).getInt() - 256;
		IDs.omniToolStoneID = config.getItem(Strings.OMNI_TOOL_STONE_KEY, IDs.OMNI_TOOL_STONE_DEFAULT_ID).getInt() - 256;
		IDs.omniToolWoodID = config.getItem(Strings.OMNI_TOOL_WOOD_KEY, IDs.OMNI_TOOL_WOOD_DEFAULT_ID).getInt() - 256;
		
		config.save();
	}
}
