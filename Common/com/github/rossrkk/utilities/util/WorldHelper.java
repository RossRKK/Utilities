package com.github.rossrkk.utilities.util;

import net.minecraft.world.World;

public class WorldHelper {
	public static boolean canSeeSky(World world,int x, int y, int z) {
		for (int i = y; i>= 256; i ++) {
			if(!(world.getBlockId(x, i, z) == 0)) {
				return false;
			}
		}
		return true;
	}
}
