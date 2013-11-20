package com.github.rossrkk.utilities.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.github.rossrkk.utilities.Utilities;
import com.github.rossrkk.utilities.lib.Strings;
import com.github.rossrkk.utilities.tileentities.TESolar;

public class BlockSolar extends BlockContainer{

	protected BlockSolar(int id, Material material) {
		super(id, material);
		setCreativeTab(Utilities.utilTab);
		setHardness(4.0F);
		setUnlocalizedName(Strings.SOLAR_NAME);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TESolar();
	}

}
