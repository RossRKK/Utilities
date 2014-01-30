package com.github.rossrkk.utilities.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.github.rossrkk.utilities.Utilities;
import com.github.rossrkk.utilities.lib.Strings;
import com.github.rossrkk.utilities.tileentities.TESolar;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSolar extends BlockContainer{

	public BlockSolar(int id, Material material) {
		super(id, material);
		setCreativeTab(Utilities.utilTab);
		setHardness(4.0F);
		setUnlocalizedName(Strings.SOLAR_NAME);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3F, 1.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TESolar();
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public Icon bottom;

	@SideOnly(Side.CLIENT)
	public Icon top;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(Strings.TEXTURE_LOCATION + ":" + Strings.SOLAR_NAME+ "Side");
		top = register.registerIcon(Strings.TEXTURE_LOCATION + ":" + Strings.SOLAR_NAME+ "Top");
		bottom = register.registerIcon(Strings.TEXTURE_LOCATION + ":" + Strings.SOLAR_NAME+ "Bottom");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		switch (side) {
		case 0: return bottom;
		case 1: return top;
		default:return blockIcon;
		}
	}

}
