package com.github.rossrkk.utilities.util;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class WorldHelper {
	public static boolean canSeeSky(World world,int x, int y, int z) {
		for (int i = y + 1; i <= 256; i ++) {
			if(!(world.isAirBlock(x, i, z) || !Block.blocksList[world.getBlockId(x, i, z)].isOpaqueCube())) {
				return false;
			}
		}
		return true;
	}
}
