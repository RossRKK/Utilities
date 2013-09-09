package com.github.rossrkk.utilities.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.github.rossrkk.utilities.Utilities;
import com.github.rossrkk.utilities.lib.Strings;
import com.github.rossrkk.utilities.tileentities.TECreativeGenerator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCreativeGenerator extends BlockContainer {

	protected BlockCreativeGenerator(int id, Material material) {
		super(id, material);
		setUnlocalizedName(Strings.CREATIVE_GENERATOR_NAME);
		setCreativeTab(Utilities.utilTab);
		setBlockUnbreakable();
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TECreativeGenerator();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(Strings.TEXTURE_LOCATION + ":" + Strings.CREATIVE_GENERATOR_NAME);
	}
}
