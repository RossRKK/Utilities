package com.github.rossrkk.utilities.block;

import com.github.rossrkk.utilities.lib.Strings;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockClearGlass extends Block {

	public BlockClearGlass(int id, Material material) {
		super(id, material);
		setUnlocalizedName(Strings.CLEAR_GLASS_NAME);
		setHardness(4.0F);
	}
	
}
