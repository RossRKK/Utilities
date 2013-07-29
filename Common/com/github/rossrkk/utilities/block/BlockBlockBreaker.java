package com.github.rossrkk.utilities.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.github.rossrkk.utilities.Utilities;
import com.github.rossrkk.utilities.lib.Strings;
import com.github.rossrkk.utilities.tileentities.TEBlockBreaker;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBlockBreaker extends BlockContainer{
	public static TileEntity tileEnt;

	protected BlockBlockBreaker(int id, Material material) {
		super(id, material);
		setHardness(3.0F);
		setUnlocalizedName(Strings.BLOCK_BREAKER_NAME);
		setCreativeTab(Utilities.utilTab);
	}
	
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float par6, float par7, float par8, int par9) {
		world.setBlockMetadataWithNotify(x, y, z, side, 0);
		return side;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		tileEnt = new TEBlockBreaker();
		return tileEnt;
	}
	
	@SideOnly(Side.CLIENT)
	private Icon destroyIcon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(Strings.TEXTURE_LOCATION + ":" + Strings.BLOCK_BREAKER_NAME);
		destroyIcon = register.registerIcon(Strings.TEXTURE_LOCATION + ":" + Strings.BLOCK_BREAKER_NAME + "Destroy");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		if (meta == side) {
			return destroyIcon;
		} else {
			return blockIcon;
		}
	}
}
