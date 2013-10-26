package com.github.rossrkk.utilities.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

import com.github.rossrkk.utilities.Utilities;
import com.github.rossrkk.utilities.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFullStoneSlab extends Block {

	public BlockFullStoneSlab(int id, Material material) {
		super(id, material);
		setUnlocalizedName(Strings.FULL_STONE_SLAB_NAME);
		setHardness(4F);
		setCreativeTab(Utilities.utilTab);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(Strings.TEXTURE_LOCATION + ":" + Strings.FULL_STONE_SLAB_NAME);
	}
}
