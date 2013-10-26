package com.github.rossrkk.utilities.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

import com.github.rossrkk.utilities.Utilities;
import com.github.rossrkk.utilities.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOreTuridium extends Block{

	public BlockOreTuridium(int ID, Material material) {
		super(ID, material);
		setUnlocalizedName(Strings.BLOCK_ORE_TURIDIUM_NAME);
		setHardness(4F);
		setCreativeTab(Utilities.utilTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(Strings.TEXTURE_LOCATION + ":" + Strings.BLOCK_ORE_TURIDIUM_NAME);
	}
}
